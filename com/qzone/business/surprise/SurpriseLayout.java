package com.qzone.business.surprise;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.util.ar;
import com.tencent.component.media.gif.AnimationListener;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.photogif.QzoneAnimationDrawable;
import com.tencent.luggage.wxa.eg.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SurpriseLayout extends RelativeLayout {
    private AnimationListener C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f44805d;

    /* renamed from: e, reason: collision with root package name */
    private Button f44806e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.business.surprise.a f44807f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f44808h;

    /* renamed from: i, reason: collision with root package name */
    private String f44809i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f44810m;

    /* compiled from: P */
    /* renamed from: com.qzone.business.surprise.SurpriseLayout$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ SurpriseLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f44805d.setBackgroundDrawable(this.this$0.f44808h);
            this.this$0.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.business.surprise.SurpriseLayout$6, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ SurpriseLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f44808h == null) {
                return;
            }
            int intrinsicWidth = this.this$0.f44808h.getIntrinsicWidth();
            int intrinsicHeight = this.this$0.f44808h.getIntrinsicHeight();
            int e16 = ar.e(intrinsicWidth / 2);
            int e17 = ar.e(intrinsicHeight / 2);
            ViewGroup.LayoutParams layoutParams = this.this$0.f44805d.getLayoutParams();
            layoutParams.width = e16;
            layoutParams.height = e17;
            this.this$0.f44805d.requestLayout();
            QZLog.d("SurpriseLayout", 1, "update splash view params: width:" + e16 + ",height:" + e17 + ",rawWidth:" + intrinsicWidth + ",rawHeigth:" + intrinsicHeight);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.business.surprise.SurpriseLayout$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ SurpriseLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SurpriseLayout.this.h();
            LpReportInfo_pf00064.allReport(b.C6164b.CTRL_INDEX, 3, SurpriseLayout.this.f44807f.f44814a, SurpriseLayout.this.i());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SurpriseLayout(Context context) {
        super(context);
        k(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        AnimationListener animationListener;
        Drawable drawable = this.f44808h;
        if (drawable != null) {
            if (drawable instanceof QzoneAnimationDrawable) {
                ((QzoneAnimationDrawable) drawable).setAnimationListener(null);
                ((QzoneAnimationDrawable) this.f44808h).stop();
            } else if ((drawable instanceof NewGifDrawable) && (animationListener = this.C) != null) {
                ((NewGifDrawable) drawable).removeAnimationListener(animationListener);
            }
        }
        this.f44808h = null;
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        com.qzone.business.surprise.a aVar;
        if (TextUtils.isEmpty(this.f44809i) && (aVar = this.f44807f) != null && !TextUtils.isEmpty(aVar.f44815b)) {
            int lastIndexOf = this.f44807f.f44815b.lastIndexOf("/") + 1;
            int lastIndexOf2 = this.f44807f.f44815b.lastIndexOf(".zip");
            if (lastIndexOf > 0 && lastIndexOf2 > lastIndexOf) {
                this.f44809i = this.f44807f.f44815b.substring(lastIndexOf, lastIndexOf2);
            } else if (lastIndexOf > 0) {
                this.f44809i = this.f44807f.f44815b.substring(lastIndexOf);
            }
        }
        return this.f44809i;
    }

    private void k(Context context) {
        this.f44810m = new Handler(Looper.getMainLooper());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f44805d = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(this.f44805d, layoutParams);
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SURPRISE_CLICK_WIDTH, 205);
        int config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SURPRISE_CLICK_HEIGHT, 285);
        this.f44806e = new Button(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ar.e(config), ar.e(config2));
        layoutParams2.addRule(13);
        this.f44806e.setBackgroundColor(0);
        relativeLayout.addView(this.f44806e, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        addView(relativeLayout, layoutParams3);
        this.f44805d.setClickable(false);
        this.f44806e.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.business.surprise.SurpriseLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                SurpriseLayout.this.l();
                SurpriseLayout.this.f44810m.postDelayed(new Runnable() { // from class: com.qzone.business.surprise.SurpriseLayout.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SurpriseLayout.this.h();
                    }
                }, 500L);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        setOnClickListener(new a());
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.qzone.business.surprise.a aVar = this.f44807f;
        if (aVar == null || TextUtils.isEmpty(aVar.f44816c)) {
            return;
        }
        g gVar = new g(this.f44807f.f44816c);
        QZLog.i("SurpriseLayout", 2, "onPhotoClick jumpUrl:" + this.f44807f.f44816c);
        d.b(BaseActivity.getTopActivity(), gVar);
        LpReportInfo_pf00064.allReport(b.C6164b.CTRL_INDEX, 2, this.f44807f.f44814a, i());
    }

    public void setData(com.qzone.business.surprise.a aVar) {
        this.f44807f = aVar;
    }

    public SurpriseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k(context);
    }

    public void j() {
        setVisibility(8);
    }
}
