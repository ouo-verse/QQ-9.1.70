package com.qzone.publish.utils;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes39.dex */
public class PublishBoxForTitle {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f52116a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f52117b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f52118c;

    /* renamed from: d, reason: collision with root package name */
    private final b f52119d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationDrawable f52120e;

    /* renamed from: f, reason: collision with root package name */
    private String f52121f;

    /* renamed from: g, reason: collision with root package name */
    AnimationDrawable f52122g;

    /* renamed from: h, reason: collision with root package name */
    AnimationDrawable f52123h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f52124i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f52125j;

    /* renamed from: k, reason: collision with root package name */
    com.qzone.publish.business.publishqueue.b f52126k;

    /* renamed from: l, reason: collision with root package name */
    DownloadQueue.b f52127l;

    /* renamed from: m, reason: collision with root package name */
    public int f52128m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f52129n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f52130o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PublishBoxForTitle.this.f52119d.Ng();
            Bundle bundle = new Bundle();
            bundle.putString("key_left_button_title", PublishBoxForTitle.this.f52121f);
            PublishBoxForTitle.this.f52119d.I(bundle);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface b {
        ViewGroup B();

        void I(Bundle bundle);

        void K4();

        void Ng();

        int Sf();

        void b0(boolean z16);

        Handler getHandler();

        Resources getResources();

        boolean i0();

        boolean z();
    }

    public PublishBoxForTitle(b bVar) {
        this.f52122g = null;
        this.f52123h = null;
        this.f52124i = true;
        this.f52125j = false;
        this.f52126k = new com.qzone.publish.business.publishqueue.b() { // from class: com.qzone.publish.utils.PublishBoxForTitle.1
            @Override // com.qzone.publish.business.publishqueue.b
            public void onQueueChanged() {
                if (PublishBoxForTitle.this.f52119d == null || PublishBoxForTitle.this.f52119d.getHandler() == null) {
                    return;
                }
                PublishBoxForTitle.this.f52119d.getHandler().post(new Runnable() { // from class: com.qzone.publish.utils.PublishBoxForTitle.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PublishBoxForTitle.this.l();
                    }
                });
            }

            @Override // com.qzone.publish.business.publishqueue.b
            public void H(IQueueTask iQueueTask) {
            }
        };
        this.f52119d = bVar;
        QZonePublishQueue.w().i(this.f52126k);
        AnimationDrawable e16 = e(bVar, R.drawable.lf5);
        this.f52122g = e16;
        if (e16 != null) {
            e16.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.useDarkResource()) {
            AnimationDrawable e17 = e(bVar, R.drawable.lf6);
            this.f52123h = e17;
            if (e17 != null) {
                e17.setColorFilter(null);
            }
        } else {
            AnimationDrawable e18 = e(bVar, R.drawable.lf5);
            this.f52123h = e18;
            if (e18 != null) {
                e18.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            }
        }
        l();
    }

    private void f() {
        if (this.f52118c == null) {
            this.f52118c = this.f52119d.B();
        }
        if (this.f52116a == null) {
            ImageView imageView = (ImageView) this.f52118c.findViewById(R.id.g4s);
            this.f52116a = imageView;
            imageView.setMaxHeight((int) this.f52119d.getResources().getDimension(R.dimen.f158719n9));
            if (this.f52119d.Sf() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f52116a.getLayoutParams();
                layoutParams.width = this.f52119d.Sf();
                this.f52116a.setLayoutParams(layoutParams);
            }
            this.f52116a.setImageResource(R.drawable.nyh);
            this.f52116a.setOnClickListener(new a());
            QZoneTitleBarActivity.setLayerType(this.f52116a);
            this.f52116a.setVisibility(4);
        }
        if (this.f52117b == null) {
            TextView textView = (TextView) this.f52118c.findViewById(R.id.g4t);
            this.f52117b = textView;
            textView.setVisibility(4);
        }
    }

    private void h() {
        TextView textView = this.f52117b;
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f52117b.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f52128m = QZonePublishQueue.w().A();
        this.f52129n = QZonePublishQueue.w().F();
        boolean E = QZonePublishQueue.w().E();
        this.f52130o = E;
        m(this.f52128m, this.f52129n, E);
    }

    private void m(int i3, boolean z16, boolean z17) {
        f();
        boolean Z0 = i.H().Z0(System.currentTimeMillis() / 1000);
        this.f52125j = Z0;
        boolean z18 = !Z0 && this.f52124i;
        if (i3 > 0 && z18) {
            this.f52119d.b0(true);
            this.f52118c.setVisibility(0);
            if (this.f52116a.getVisibility() != 0) {
                this.f52116a.setVisibility(0);
                this.f52119d.K4();
            }
            if (z16) {
                j();
                com.tencent.widget.d.b(this.f52117b, 9, i3, 0);
            } else if (z17) {
                k();
                com.tencent.widget.d.b(this.f52117b, 8, i3, R.drawable.gcs);
                h();
            } else {
                k();
                com.tencent.widget.d.b(this.f52117b, 8, i3, R.drawable.gcr);
                h();
            }
            if (this.f52117b.getVisibility() != 0) {
                this.f52117b.setVisibility(0);
            }
        } else {
            this.f52119d.b0(false);
            if (this.f52116a.getVisibility() == 0) {
                this.f52116a.setVisibility(4);
            }
            if (this.f52117b.getVisibility() == 0) {
                this.f52117b.setVisibility(4);
            }
            this.f52118c.setVisibility(8);
        }
        DownloadQueue.b bVar = this.f52127l;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void i(DownloadQueue.b bVar) {
        this.f52127l = bVar;
    }

    public void j() {
        ImageView imageView;
        AnimationDrawable animationDrawable = this.f52120e;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f52120e = null;
        }
        if (!this.f52119d.z() && !this.f52119d.i0()) {
            this.f52120e = this.f52123h;
        } else {
            this.f52120e = this.f52122g;
        }
        AnimationDrawable animationDrawable2 = this.f52120e;
        if (animationDrawable2 == null || (imageView = this.f52116a) == null) {
            return;
        }
        imageView.setImageDrawable(animationDrawable2);
        this.f52120e.start();
    }

    public void k() {
        AnimationDrawable animationDrawable = this.f52120e;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f52120e = null;
        }
        if (this.f52116a == null) {
            return;
        }
        if (!this.f52119d.z() && !this.f52119d.i0()) {
            AnimationDrawable animationDrawable2 = this.f52123h;
            if (animationDrawable2 != null) {
                this.f52116a.setImageDrawable(animationDrawable2.getFrame(animationDrawable2.getNumberOfFrames() - 1));
            }
            if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.useDarkResource()) {
                return;
            }
            com.tencent.mobileqq.qzone.picload.c.a().m(this.f52116a, -1);
            return;
        }
        this.f52116a.setImageResource(R.drawable.nyh);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f52116a, -1);
    }

    public void d() {
        this.f52124i = false;
        l();
    }

    public void g() {
        this.f52124i = true;
        l();
    }

    private AnimationDrawable e(b bVar, int i3) {
        if (bVar == null) {
            return null;
        }
        Drawable drawable = bVar.getResources().getDrawable(i3);
        if (drawable instanceof AnimationDrawable) {
            return (AnimationDrawable) drawable;
        }
        return null;
    }

    public PublishBoxForTitle(b bVar, String str) {
        this(bVar);
        this.f52121f = str;
    }
}
