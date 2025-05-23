package com.qzone.reborn.feedx.widget;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.qzone.reborn.feedx.widget.f;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f56093a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f56094b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f56095c;

    /* renamed from: d, reason: collision with root package name */
    private final c f56096d;

    /* renamed from: e, reason: collision with root package name */
    private String f56097e;

    /* renamed from: f, reason: collision with root package name */
    AnimationDrawable f56098f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f56099g;

    /* renamed from: h, reason: collision with root package name */
    public int f56100h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f56101i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f56102j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f56103k;

    /* renamed from: l, reason: collision with root package name */
    com.qzone.publish.business.publishqueue.b f56104l;

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
                bundle.putString("key_left_button_title", f.this.f56097e);
                f.this.f56096d.I(bundle);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        ViewGroup B();

        void I(Bundle bundle);

        void b0(boolean z16);

        Handler getHandler();

        Resources getResources();
    }

    public f(c cVar) {
        this.f56098f = null;
        this.f56099g = false;
        this.f56104l = new a();
        this.f56096d = cVar;
        AnimationDrawable d16 = d(cVar, R.drawable.lf5);
        this.f56098f = d16;
        d16.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        e();
    }

    private void e() {
        if (this.f56095c == null) {
            this.f56095c = this.f56096d.B();
        }
        if (this.f56093a == null) {
            ImageView imageView = (ImageView) this.f56095c.findViewById(R.id.g4s);
            this.f56093a = imageView;
            imageView.setMaxHeight((int) this.f56096d.getResources().getDimension(R.dimen.f158719n9));
            this.f56093a.setImageResource(R.drawable.nyh);
            this.f56093a.setOnClickListener(new b());
            QZoneTitleBarActivity.setLayerType(this.f56093a);
            this.f56093a.setVisibility(4);
        }
        if (this.f56094b == null) {
            TextView textView = (TextView) this.f56095c.findViewById(R.id.g4t);
            this.f56094b = textView;
            textView.setVisibility(4);
        }
    }

    private void h() {
        TextView textView = this.f56094b;
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f56094b.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            if (lc.b.d()) {
                a9.f fVar = a9.f.f25725a;
                this.f56100h = fVar.c().y();
                this.f56101i = fVar.c().A();
                this.f56102j = fVar.c().z();
            } else {
                this.f56100h = QZonePublishQueue.w().A();
                this.f56101i = QZonePublishQueue.w().F();
                this.f56102j = QZonePublishQueue.w().E();
            }
            m(this.f56100h, this.f56101i, this.f56102j);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    private void m(int i3, boolean z16, boolean z17) {
        boolean Z0 = com.qzone.adapter.feedcomponent.i.H().Z0(System.currentTimeMillis() / 1000);
        this.f56099g = Z0;
        boolean z18 = (Z0 || this.f56103k) ? false : true;
        if (!com.qzone.reborn.util.e.b("QZPublishX_QZonePublishBox_updatePublishBox", 100L)) {
            QLog.d("QZPublishX_QZonePublishBox", 1, "updatePublishBox  | size=" + i3 + " | hasRunningTask=" + z16 + " | hasOfflineWaittingTask=" + z17 + " | isGuest=" + this.f56103k + " | isShowPublishBox=" + z18);
        }
        if (i3 > 0 && z18) {
            this.f56096d.b0(true);
            this.f56095c.setVisibility(0);
            if (this.f56093a.getVisibility() != 0) {
                this.f56093a.setVisibility(0);
            }
            if (z16) {
                i();
                com.tencent.widget.d.b(this.f56094b, 9, i3, 0);
            } else if (z17) {
                j();
                com.tencent.widget.d.b(this.f56094b, 8, i3, R.drawable.gcs);
                h();
            } else {
                j();
                com.tencent.widget.d.b(this.f56094b, 8, i3, R.drawable.gcr);
                h();
            }
            if (this.f56094b.getVisibility() != 0) {
                this.f56094b.setVisibility(0);
                return;
            }
            return;
        }
        this.f56096d.b0(false);
        if (this.f56093a.getVisibility() == 0) {
            this.f56093a.setVisibility(4);
        }
        if (this.f56094b.getVisibility() == 0) {
            this.f56094b.setVisibility(4);
        }
        this.f56095c.setVisibility(8);
    }

    public void f() {
        if (lc.b.d()) {
            a9.f.f25725a.c().i(this.f56104l);
        } else {
            QZonePublishQueue.w().i(this.f56104l);
        }
        l();
    }

    public void g(boolean z16) {
        this.f56103k = z16;
        m(this.f56100h, this.f56101i, this.f56102j);
    }

    public void i() {
        if (this.f56093a == null) {
            return;
        }
        AnimationDrawable animationDrawable = this.f56098f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        this.f56093a.setImageDrawable(this.f56098f);
        AnimationDrawable animationDrawable2 = this.f56098f;
        if (animationDrawable2 != null) {
            animationDrawable2.start();
        }
    }

    public void j() {
        if (this.f56093a == null) {
            return;
        }
        AnimationDrawable animationDrawable = this.f56098f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        AnimationDrawable animationDrawable2 = this.f56098f;
        if (animationDrawable2 != null) {
            this.f56093a.setImageDrawable(animationDrawable2.getFrame(animationDrawable2.getNumberOfFrames() - 1));
        }
    }

    public void k(int i3) {
        AnimationDrawable animationDrawable = this.f56098f;
        if (animationDrawable != null) {
            animationDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        }
        this.f56093a.setColorFilter(i3);
    }

    public void n(Intent intent) {
        if (lc.b.d() || intent == null) {
            return;
        }
        try {
            this.f56100h = intent.getIntExtra("size", 0);
            this.f56101i = intent.getBooleanExtra("hasRunningTask", false);
            boolean booleanExtra = intent.getBooleanExtra("hasOfflineWaittingTask", false);
            this.f56102j = booleanExtra;
            m(this.f56100h, this.f56101i, booleanExtra);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    private AnimationDrawable d(c cVar, int i3) {
        if (cVar == null) {
            return null;
        }
        Drawable drawable = cVar.getResources().getDrawable(i3);
        if (drawable instanceof AnimationDrawable) {
            return (AnimationDrawable) drawable;
        }
        return null;
    }

    public f(c cVar, String str) {
        this(cVar);
        this.f56097e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements com.qzone.publish.business.publishqueue.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            f.this.l();
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void onQueueChanged() {
            if (f.this.f56096d == null || f.this.f56096d.getHandler() == null) {
                return;
            }
            f.this.f56096d.getHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.this.b();
                }
            });
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void H(IQueueTask iQueueTask) {
        }
    }
}
