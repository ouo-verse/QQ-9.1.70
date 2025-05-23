package com.qzone.reborn.feedpro.widget;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.qzone.reborn.feedpro.widget.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l implements ue.a {
    private String C;
    public int E;
    public boolean F;
    public boolean G;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f54652d;

    /* renamed from: e, reason: collision with root package name */
    private LottieAnimationView f54653e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f54654f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f54655h;

    /* renamed from: i, reason: collision with root package name */
    private int f54656i;

    /* renamed from: m, reason: collision with root package name */
    private final e f54657m;
    private boolean D = false;
    com.qzone.publish.business.publishqueue.b H = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (lc.b.d()) {
                ((vb.b) ho.i.t(vb.b.class)).k(view.getContext(), new QZAlbumxTaskDetailInitBean(LoginData.getInstance().getUinString(), null, 0));
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("key_left_button_title", l.this.C);
                l.this.f54657m.I(bundle);
            }
            fo.c.b("dt_clck", l.this.f54653e, "em_qz_outbox", new fo.b().g(ClickPolicy.REPORT_NONE));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.DEV, "doFinishAnim onAnimationCancel");
            l.this.f54653e.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.USR, "doFinishAnim onAnimationEnd");
            l.this.f54653e.removeAnimatorListener(this);
            l.this.f54653e.cancelAnimation();
            l lVar = l.this;
            lVar.w(lVar.E, lVar.F, lVar.G);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.DEV, "doFinishAnim onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.USR, "doFinishAnim onAnimationStart");
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
        ViewGroup B();

        void I(Bundle bundle);
    }

    public l(e eVar, String str, int i3) {
        this.f54656i = -1;
        this.f54657m = eVar;
        this.C = str;
        this.f54656i = i3;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void t() {
        LottieAnimationView lottieAnimationView = this.f54653e;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setFailureListener(new LottieListener() { // from class: com.qzone.reborn.feedpro.widget.j
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                l.this.q((Throwable) obj);
            }
        });
        this.f54653e.cancelAnimation();
        this.f54653e.addAnimatorListener(new c());
        this.f54653e.setAnimation("feeds/qzone_publish_upload_complete_anim.json");
        this.f54653e.setRepeatCount(0);
        this.f54653e.playAnimation();
    }

    private void p() {
        if (this.f54655h == null) {
            ViewGroup B = this.f54657m.B();
            this.f54655h = B;
            B.setLayerType(0, null);
        }
        if (this.f54653e == null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f54655h.findViewById(R.id.n9p);
            this.f54653e = lottieAnimationView;
            lottieAnimationView.setImageResource(R.drawable.qui_arrowhead_up_circle);
            com.tencent.mobileqq.qzone.picload.c.a().m(this.f54653e, this.f54656i);
            this.f54653e.setMaxHeight((int) this.f54655h.getResources().getDimension(R.dimen.f158719n9));
            this.f54653e.setOnClickListener(new b());
            o(this.f54653e, this.f54656i);
            QZoneTitleBarActivity.setLayerType(this.f54653e);
            this.f54653e.setVisibility(4);
        }
        if (this.f54654f == null) {
            TextView textView = (TextView) this.f54655h.findViewById(R.id.f162766mi4);
            this.f54654f = textView;
            textView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Throwable th5) {
        RFWLog.e("QZPublishX_QzoneProPublishBox", RFWLog.USR, "doFinishAnim onFailure :" + th5);
        this.f54653e.setFailureListener(null);
        this.f54653e.cancelAnimation();
        w(this.E, this.F, this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(LottieAnimationView lottieAnimationView, final ColorFilter colorFilter, LottieComposition lottieComposition) {
        Iterator<KeyPath> it = lottieAnimationView.resolveKeyPath(new KeyPath("**")).iterator();
        while (it.hasNext()) {
            lottieAnimationView.addValueCallback(it.next(), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.qzone.reborn.feedpro.widget.i
                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                    ColorFilter r16;
                    r16 = l.r(colorFilter, lottieFrameInfo);
                    return r16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(int i3, boolean z16, boolean z17) {
        boolean Z0 = com.qzone.adapter.feedcomponent.i.H().Z0(System.currentTimeMillis() / 1000);
        this.D = Z0;
        boolean z18 = !Z0;
        if (!com.qzone.reborn.util.e.b("QZPublishX_QzoneProPublishBox_updatePublishBox", 100L)) {
            QLog.d("QZPublishX_QzoneProPublishBox", 1, "updatePublishBox  | size=" + i3 + " | hasRunningTask=" + z16 + " | hasOfflineWaittingTask=" + z17 + " | isShowPublishBox=" + z18);
        }
        if (i3 > 0 && z18) {
            this.f54655h.setVisibility(0);
            if (this.f54653e.getVisibility() != 0) {
                this.f54653e.setVisibility(0);
            }
            if (z16) {
                z();
                com.tencent.widget.d.b(this.f54654f, 9, i3, 0);
                this.f54654f.requestLayout();
            } else if (z17) {
                A();
                com.tencent.widget.d.b(this.f54654f, 8, i3, R.drawable.gcs);
                y();
            } else {
                A();
                com.tencent.widget.d.b(this.f54654f, 8, i3, R.drawable.gcr);
                y();
            }
            if (this.f54654f.getVisibility() != 0) {
                this.f54654f.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f54653e.isAnimating() && this.f54653e.getVisibility() == 0) {
            this.f54652d = new Runnable() { // from class: com.qzone.reborn.feedpro.widget.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.t();
                }
            };
            return;
        }
        this.f54652d = null;
        if (this.f54653e.getVisibility() == 0) {
            this.f54653e.setVisibility(4);
        }
        if (this.f54654f.getVisibility() == 0) {
            this.f54654f.setVisibility(4);
        }
        this.f54655h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Throwable th5) {
        RFWLog.e("QZPublishX_QzoneProPublishBox", RFWLog.USR, "onFailure :" + th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final int i3, final boolean z16, final boolean z17) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                l.this.u(i3, z16, z17);
            }
        });
    }

    private void y() {
        TextView textView = this.f54654f;
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f54654f.setLayoutParams(layoutParams);
    }

    public void A() {
        LottieAnimationView lottieAnimationView = this.f54653e;
        if (lottieAnimationView == null) {
            return;
        }
        this.f54652d = null;
        lottieAnimationView.cancelAnimation();
        this.f54653e.setImageResource(R.drawable.qui_arrowhead_up_circle);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f54653e, this.f54656i);
    }

    public void B() {
        try {
            if (lc.b.d()) {
                a9.f fVar = a9.f.f25725a;
                this.E = fVar.c().y();
                this.F = fVar.c().A();
                boolean z16 = fVar.c().z();
                this.G = z16;
                w(this.E, this.F, z16);
            } else {
                Intent intent = new Intent();
                intent.setAction(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY_FROM_QUERY);
                BaseApplicationImpl.getApplication().sendBroadcast(intent);
            }
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    @Override // ue.a
    public void G(Intent intent) {
        if (lc.b.d() || intent == null) {
            return;
        }
        try {
            this.E = intent.getIntExtra("size", 0);
            this.F = intent.getBooleanExtra("hasRunningTask", false);
            boolean booleanExtra = intent.getBooleanExtra("hasOfflineWaittingTask", false);
            this.G = booleanExtra;
            w(this.E, this.F, booleanExtra);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    @Override // ue.a
    public void d0() {
        if (lc.b.d()) {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.USR, "callOnAttachedToWindow init publish from qzonex");
            a9.f.f25725a.c().i(this.H);
        } else {
            RFWLog.d("QZPublishX_QzoneProPublishBox", RFWLog.USR, "callOnAttachedToWindow init publish from old publish");
        }
        B();
    }

    public ViewGroup n() {
        return this.f54655h;
    }

    public void x(int i3) {
        LottieAnimationView lottieAnimationView = this.f54653e;
        if (lottieAnimationView != null) {
            lottieAnimationView.setBackgroundResource(i3);
        }
    }

    public void z() {
        LottieAnimationView lottieAnimationView = this.f54653e;
        if (lottieAnimationView == null) {
            return;
        }
        this.f54652d = null;
        lottieAnimationView.cancelAnimation();
        this.f54653e.addAnimatorListener(new d());
        this.f54653e.setFailureListener(new LottieListener() { // from class: com.qzone.reborn.feedpro.widget.h
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                l.v((Throwable) obj);
            }
        });
        this.f54653e.setAnimation("feeds/qzone_publish_upload_anim.json");
        this.f54653e.setRepeatCount(-1);
        this.f54653e.playAnimation();
    }

    private void o(final LottieAnimationView lottieAnimationView, int i3) {
        if (lottieAnimationView == null) {
            return;
        }
        final LightingColorFilter lightingColorFilter = new LightingColorFilter(0, i3);
        lottieAnimationView.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.qzone.reborn.feedpro.widget.f
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                l.s(LottieAnimationView.this, lightingColorFilter, lottieComposition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements com.qzone.publish.business.publishqueue.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            l.this.B();
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void onQueueChanged() {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.a.this.b();
                }
            });
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void H(IQueueTask iQueueTask) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            l.this.f54653e.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.f54653e.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (l.this.f54652d != null) {
                l.this.f54652d.run();
                l.this.f54652d = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ColorFilter r(ColorFilter colorFilter, LottieFrameInfo lottieFrameInfo) {
        return colorFilter;
    }
}
