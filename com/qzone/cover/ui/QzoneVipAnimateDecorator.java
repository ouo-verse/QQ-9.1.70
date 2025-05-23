package com.qzone.cover.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVipAnimateDecorator extends ImageView {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private String f46766d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f46767e;

    /* renamed from: f, reason: collision with root package name */
    private int f46768f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f46769h;

    /* renamed from: i, reason: collision with root package name */
    private Lifecycle f46770i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f46771m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View.OnClickListener onClickListener = QzoneVipAnimateDecorator.this.f46767e;
            if (onClickListener != null) {
                if (QzoneVipAnimateDecorator.this.f46768f != 2) {
                    if (QzoneVipAnimateDecorator.this.f46768f == 1) {
                        QzoneVipAnimateDecorator.this.d(807);
                    }
                } else {
                    QzoneVipAnimateDecorator qzoneVipAnimateDecorator = QzoneVipAnimateDecorator.this;
                    qzoneVipAnimateDecorator.g(Long.parseLong(qzoneVipAnimateDecorator.f46766d), 8);
                }
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QzoneVipAnimateDecorator(Context context) {
        super(context);
        this.f46771m = new a();
        this.C = "";
    }

    public static boolean h() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", "VipAnimateSwitch", 1) == 1;
    }

    private void l() {
        if (!h()) {
            QZLog.i("QzoneVipAnimateDecorato", 1, "playVipDecoratorAnimate switch = 0 off");
            return;
        }
        int i3 = this.f46768f;
        if (i3 == 2) {
            g(Long.parseLong(this.f46766d), 11);
        } else if (i3 == 1) {
            d(806);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 0.88f, 1.0f, 0.88f, 1.0f, 0.88f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 0.88f, 1.0f, 0.88f, 1.0f, 0.88f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setStartDelay(100L);
        animatorSet.start();
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.C) && this.f46769h != null && ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).hasDownloadComplete(this.f46769h)) {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneVipAnimateDecorato", 2, "mVipAnimationDecorator animate has start  url.equals = " + str.equals(this.C));
                return;
            }
            return;
        }
        this.C = str;
        this.f46769h = f(str);
        if (this.f46770i != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).bindLifeCycle(this.f46769h, this.f46770i);
        }
        setImageDrawable(this.f46769h);
        f6.a.c(this);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f46769h);
        l();
    }

    public void d(int i3) {
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneVipAnimateDecorato", 2, "Home Page vipDecoratorAnimateReport actype = 302 subtype = " + i3 + " reserves = 1 reserves2 =  reserves3 = 1");
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("302", i3 + "", 1, "", "1"), false, false);
    }

    public void e(Lifecycle lifecycle) {
        this.f46770i = lifecycle;
    }

    public Drawable f(String str) {
        Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, str, 24);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, ar.l() / 720.0f);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(zipAnimationDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(zipAnimationDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
        return zipAnimationDrawable;
    }

    public void g(long j3, int i3) {
        int i16 = j3 == LoginData.getInstance().getUin() ? 1 : 2;
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneVipAnimateDecorato", 2, "Home Page vipDecoratorAnimateReport actype = 308 subtype = 11 reserves = " + i3 + " reserves2 = " + i16 + " reserves3 = 1");
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("308", "11", i3, i16 + "", "1"), false, false);
    }

    public void i() {
        if (this.f46769h != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46769h);
        }
    }

    public void j() {
        if (this.f46769h != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46769h);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f46769h);
            this.f46769h = null;
        }
    }

    public void k() {
        if (this.f46769h == null || getVisibility() != 0) {
            return;
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.f46769h);
    }

    public boolean n(int i3, String str, View.OnClickListener onClickListener) {
        String str2;
        this.f46768f = i3;
        this.f46766d = str;
        this.f46767e = onClickListener;
        QzoneVipInfo vipInfo = VipComponentProxy.f50997g.getServiceInterface().getVipInfo(String.valueOf(str));
        if (vipInfo != null && !vipInfo.isQQUnionVip()) {
            int vipType = vipInfo.getVipType();
            int vipLevel = vipInfo.getVipLevel();
            if (vipType == 0) {
                if (vipLevel == 0) {
                    str2 = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/guajian/lv_kaitong.zip";
                } else if (vipLevel > 0) {
                    str2 = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/guajian/lv" + vipLevel + ".zip";
                }
                if (this.f46769h != null && ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).hasDownloadComplete(this.f46769h) && str2.equals(this.C)) {
                    return true;
                }
                setVisibility(0);
                setOnClickListener(this.f46771m);
                AccessibilityUtil.p(this, l.a(R.string.f172605sf4) + l.a(R.string.sfa) + vipLevel + l.a(R.string.sf8));
                m(str2);
                return true;
            }
        }
        return false;
    }

    public QzoneVipAnimateDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46771m = new a();
        this.C = "";
    }

    public QzoneVipAnimateDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46771m = new a();
        this.C = "";
    }
}
