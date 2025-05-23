package com.tencent.mobileqq.onlinestatus.guide;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.animation.interpolator.EaseCubicInterpolator;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ai;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StatusConversationHelper extends e {

    /* renamed from: a, reason: collision with root package name */
    public c f255881a = new c();

    /* renamed from: b, reason: collision with root package name */
    public boolean f255882b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f255890d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f255891e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f255892f;

        a(int i3, TextView textView, TextView textView2) {
            this.f255890d = i3;
            this.f255891e = textView;
            this.f255892f = textView2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f16;
            float intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float f17 = this.f255890d * (intValue / 300.0f);
            if (intValue < 100.0f) {
                f16 = 0.0f;
            } else {
                f16 = (intValue - 100.0f) / 200.0f;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f255891e.getLayoutParams();
            layoutParams.setMargins((int) f17, 0, 0, 0);
            this.f255891e.setLayoutParams(layoutParams);
            this.f255892f.setAlpha(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f255894d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f255895e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f255896f;

        b(int i3, TextView textView, TextView textView2) {
            this.f255894d = i3;
            this.f255895e = textView;
            this.f255896f = textView2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f16;
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i3 = this.f255894d;
            float f17 = intValue;
            float f18 = i3 - (i3 * (f17 / 300.0f));
            if (f17 < 100.0f) {
                f16 = 1.0f;
            } else {
                f16 = (300.0f - f17) / 200.0f;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f255895e.getLayoutParams();
            layoutParams.setMargins((int) f18, 0, 0, 0);
            this.f255895e.setLayoutParams(layoutParams);
            this.f255896f.setAlpha(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(TextView textView, TextView textView2) {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            f(peekAppRuntime, textView, textView2);
        } catch (Exception e16) {
            QLog.i("StatusConversationHelper", 1, "checkAndSetGuide", e16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.guide.e
    public long b(AppRuntime appRuntime) {
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(appRuntime);
        QLog.i("StatusConversationHelper", 1, "getSelfStatus status=" + onlineStatus + ",extOnlineStatus=" + M);
        if (onlineStatus == AppRuntime.Status.online) {
            return M;
        }
        return -1L;
    }

    public void f(AppRuntime appRuntime, TextView textView, TextView textView2) {
        com.tencent.mobileqq.onlinestatus.guide.b bVar;
        StatusConversationHelper statusConversationHelper;
        String str;
        String str2;
        String str3;
        long j3;
        TextView textView3;
        TextView textView4;
        long j16;
        String str4;
        String str5;
        long j17;
        String str6;
        if (textView != null && textView2 != null) {
            ai a16 = a();
            if (a16 != null && (bVar = a16.D) != null && bVar.f255901a > 0 && !TextUtils.isEmpty(bVar.f255903c)) {
                com.tencent.mobileqq.onlinestatus.guide.b bVar2 = a16.D;
                if (bVar2.f255902b > 0) {
                    long j18 = bVar2.f255901a;
                    if (d() && !a16.D.f255905e) {
                        QLog.i("StatusConversationHelper", 1, "checkAndSetGuide not showInStudyMode guideStatusId=" + j18);
                        i(textView, textView2);
                        return;
                    }
                    if (this.f255881a.b(appRuntime, j18)) {
                        QLog.i("StatusConversationHelper", 1, "checkAndSetGuide has click guideStatusId=" + j18);
                        i(textView, textView2);
                        return;
                    }
                    if (b(appRuntime) == j18) {
                        QLog.i("StatusConversationHelper", 1, "checkAndSetGuide selfStatus == guideStatusId=" + j18);
                        this.f255881a.h(appRuntime, j18);
                        this.f255881a.f(appRuntime, j18);
                        i(textView, textView2);
                        return;
                    }
                    long c16 = c();
                    long d16 = this.f255881a.d(appRuntime, j18);
                    if (c16 >= d16) {
                        if (d16 > 0) {
                            j16 = d16;
                            if (c16 - d16 > a16.D.f255902b) {
                                statusConversationHelper = this;
                                str = ",serverTime=";
                                textView3 = textView;
                                textView4 = textView2;
                                str2 = "StatusConversationHelper";
                                str3 = ",firstShowTime=";
                                j3 = j16;
                            }
                        } else {
                            j16 = d16;
                        }
                        if (d16 > 0) {
                            str4 = ",serverTime=";
                            str5 = "StatusConversationHelper";
                            j17 = j16;
                            str6 = ",firstShowTime=";
                        } else {
                            j17 = j16;
                            str4 = ",serverTime=";
                            str5 = "StatusConversationHelper";
                            str6 = ",firstShowTime=";
                            this.f255881a.g(appRuntime, j18, c16);
                        }
                        QLog.i(str5, 1, "checkAndSetGuide show guideStatusId=" + j18 + str6 + j17 + str4 + c16 + ",duration=" + a16.D.f255902b);
                        o(textView, textView2, a16.D);
                        return;
                    }
                    statusConversationHelper = this;
                    str = ",serverTime=";
                    str2 = "StatusConversationHelper";
                    str3 = ",firstShowTime=";
                    j3 = d16;
                    textView3 = textView;
                    textView4 = textView2;
                    QLog.i(str2, 1, "checkAndSetGuide time error guideStatusId=" + j18 + str3 + j3 + str + c16 + ",duration=" + a16.D.f255902b);
                    statusConversationHelper.i(textView3, textView4);
                    return;
                }
            }
            QLog.i("StatusConversationHelper", 1, "checkAndSetGuide configBean error");
            i(textView, textView2);
            return;
        }
        QLog.i("StatusConversationHelper", 1, "checkAndSetGuide error");
        this.f255882b = false;
    }

    public void g(final TextView textView, final TextView textView2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.guide.a
            @Override // java.lang.Runnable
            public final void run() {
                StatusConversationHelper.this.j(textView, textView2);
            }
        }, 32, null, true);
    }

    public void h(TextView textView, TextView textView2) {
        long j3;
        if (this.f255882b) {
            QLog.i("StatusConversationHelper", 1, "hideConversationGuideView isNeedShow");
            return;
        }
        if (textView2.getVisibility() != 0) {
            QLog.i("StatusConversationHelper", 1, "hideConversationGuideView no visibility");
            return;
        }
        Object tag = textView2.getTag(R.id.f88254wk);
        if (tag != null && (tag instanceof Long)) {
            j3 = ((Long) tag).longValue();
        } else {
            j3 = 0;
        }
        QLog.i("StatusConversationHelper", 1, "hideConversationGuideView statusGuideId=" + j3);
        if (j3 > 0) {
            l(textView, textView2);
        } else {
            textView2.setTag(R.id.f88254wk, 0);
            textView2.setVisibility(4);
        }
    }

    public void i(final TextView textView, final TextView textView2) {
        this.f255882b = false;
        if (textView2.getVisibility() != 0) {
            QLog.i("StatusConversationHelper", 1, "hideConversationGuideViewDelay no visibility");
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.guide.StatusConversationHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        StatusConversationHelper.this.h(textView, textView2);
                    } catch (Exception e16) {
                        QLog.i("StatusConversationHelper", 1, "hideConversationGuideView", e16);
                    }
                }
            }, 5000L);
        }
    }

    public void k(AppRuntime appRuntime, TextView textView, TextView textView2) {
        long j3;
        Object tag = textView2.getTag(R.id.f88254wk);
        if (tag != null && (tag instanceof Long)) {
            j3 = ((Long) tag).longValue();
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return;
        }
        this.f255881a.f(appRuntime, j3);
        QLog.i("StatusConversationHelper", 1, "onClickConversationGuide statusGuideId=" + j3);
        this.f255882b = false;
        h(textView, textView2);
    }

    public void l(TextView textView, TextView textView2) {
        if (textView2.getVisibility() != 0) {
            QLog.i("StatusConversationHelper", 1, "runHideAnimation error tvStatusGuide is no visible");
            return;
        }
        textView2.setTag(R.id.f88254wk, 0);
        int width = textView2.getWidth();
        if (width <= 0) {
            QLog.i("StatusConversationHelper", 1, "runHideAnimation error tvStatusGuideWidth=" + width);
            return;
        }
        QLog.i("StatusConversationHelper", 1, "runHideAnimation tvStatusGuideWidth=" + width);
        int dip2px = width + ViewUtils.dip2px(6.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 300);
        ofInt.addUpdateListener(new b(dip2px, textView, textView2));
        ofInt.setInterpolator(new EaseCubicInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public void m(TextView textView, TextView textView2) {
        int width = textView2.getWidth();
        if (width <= 0) {
            QLog.i("StatusConversationHelper", 1, "runShowAnimation error tvStatusGuideWidth=" + width);
            return;
        }
        QLog.i("StatusConversationHelper", 1, "runShowAnimation tvStatusGuideWidth=" + width);
        int dip2px = width + ViewUtils.dip2px(6.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 300);
        ofInt.addUpdateListener(new a(dip2px, textView, textView2));
        ofInt.setInterpolator(new EaseCubicInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public void n(final TextView textView, final TextView textView2, com.tencent.mobileqq.onlinestatus.guide.b bVar) {
        long j3;
        if (!this.f255882b) {
            QLog.i("StatusConversationHelper", 1, "showConversationGuideView not isNeedShow");
            return;
        }
        Object tag = textView2.getTag(R.id.f88254wk);
        if (tag != null && (tag instanceof Long)) {
            j3 = ((Long) tag).longValue();
        } else {
            j3 = 0;
        }
        if (j3 > 0 && textView2.getVisibility() == 0 && j3 == bVar.f255901a) {
            QLog.i("StatusConversationHelper", 1, "showConversationGuideView has showed statusId=" + j3);
            return;
        }
        if (!TextUtils.isEmpty(bVar.f255904d)) {
            URLDrawable drawable = URLDrawable.getDrawable(bVar.f255904d, URLDrawable.URLDrawableOptions.obtain());
            int dip2px = ViewUtils.dip2px(12.0f);
            drawable.setBounds(0, 0, dip2px, dip2px);
            textView2.setCompoundDrawablePadding(ViewUtils.dip2px(2.0f));
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        textView2.setText(bVar.f255903c);
        textView2.setTag(R.id.f88254wk, Long.valueOf(bVar.f255901a));
        textView2.setVisibility(0);
        QLog.i("StatusConversationHelper", 1, "showConversationGuideView statusId=" + bVar.f255901a);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.guide.StatusConversationHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    StatusConversationHelper.this.m(textView, textView2);
                } catch (Exception e16) {
                    QLog.i("StatusConversationHelper", 1, "runShowAnimation", e16);
                }
            }
        });
    }

    public void o(final TextView textView, final TextView textView2, final com.tencent.mobileqq.onlinestatus.guide.b bVar) {
        long j3;
        this.f255882b = true;
        Object tag = textView2.getTag(R.id.f88254wk);
        if (tag != null && (tag instanceof Long)) {
            j3 = ((Long) tag).longValue();
        } else {
            j3 = 0;
        }
        if (j3 > 0 && textView2.getVisibility() == 0 && j3 == bVar.f255901a) {
            QLog.i("StatusConversationHelper", 1, "showConversationGuideViewDelayed has showed statusId=" + j3);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.guide.StatusConversationHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    StatusConversationHelper.this.n(textView, textView2, bVar);
                } catch (Exception e16) {
                    QLog.i("StatusConversationHelper", 1, "showConversationGuideView", e16);
                }
            }
        }, 5000L);
    }
}
