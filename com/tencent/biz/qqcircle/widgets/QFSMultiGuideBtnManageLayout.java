package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWidget$StButton;
import feedcloud.FeedCloudWidget$StButtonGroup;
import feedcloud.FeedCloudWidget$StButtonStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StButtonGroup;
import qqcircle.QQCircleDitto$StButtonStyle;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMultiGuideBtnManageLayout extends LinearLayout {
    private FeedCloudMeta$StFeed C;
    private View D;
    private View E;
    private View F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private QQCircleDitto$StButtonGroup f93313d;

    /* renamed from: e, reason: collision with root package name */
    private List<QQCircleDitto$StButton> f93314e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudWidget$StButtonGroup f93315f;

    /* renamed from: h, reason: collision with root package name */
    private List<QFSMultiGuideBtn> f93316h;

    /* renamed from: i, reason: collision with root package name */
    private float f93317i;

    /* renamed from: m, reason: collision with root package name */
    private m f93318m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements QFSMultiGuideBtn.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.a
        public void a(QFSMultiGuideBtn qFSMultiGuideBtn) {
            QFSMultiGuideBtnManageLayout.this.p(qFSMultiGuideBtn);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.a
        public void b(QFSMultiGuideBtn qFSMultiGuideBtn) {
            QFSMultiGuideBtnManageLayout.this.o(qFSMultiGuideBtn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements QFSMultiGuideBtn.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.b
        public void a(int i3) {
            if (QFSMultiGuideBtnManageLayout.this.f93318m != null) {
                QFSMultiGuideBtnManageLayout.this.f93318m.a(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements QFSMultiGuideBtn.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.a
        public void a(QFSMultiGuideBtn qFSMultiGuideBtn) {
            QFSMultiGuideBtnManageLayout.this.p(qFSMultiGuideBtn);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.a
        public void b(QFSMultiGuideBtn qFSMultiGuideBtn) {
            QFSMultiGuideBtnManageLayout.this.o(qFSMultiGuideBtn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSMultiGuideBtn f93323d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSMultiGuideBtn f93324e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f93325f;

        d(QFSMultiGuideBtn qFSMultiGuideBtn, QFSMultiGuideBtn qFSMultiGuideBtn2, int i3) {
            this.f93323d = qFSMultiGuideBtn;
            this.f93324e = qFSMultiGuideBtn2;
            this.f93325f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f93323d != null && this.f93324e != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93323d.getLayoutParams();
                layoutParams.width = intValue;
                this.f93323d.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f93324e.getLayoutParams();
                layoutParams2.width = intValue - (intValue - this.f93325f);
                this.f93324e.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSMultiGuideBtn f93327d;

        e(QFSMultiGuideBtn qFSMultiGuideBtn) {
            this.f93327d = qFSMultiGuideBtn;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f93327d == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93327d.getLayoutParams();
            layoutParams.width += (int) floatValue;
            this.f93327d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSMultiGuideBtn f93329d;

        f(QFSMultiGuideBtn qFSMultiGuideBtn) {
            this.f93329d = qFSMultiGuideBtn;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f93329d == null) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93329d.getLayoutParams();
            layoutParams.leftMargin = intValue;
            this.f93329d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f93334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f93335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f93336f;

        i(View view, int i3, int i16) {
            this.f93334d = view;
            this.f93335e = i3;
            this.f93336f = i16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f93334d != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                QFSMultiGuideBtnManageLayout.this.setTranslationY(this.f93335e - intValue);
                this.f93334d.setTranslationY(this.f93336f - intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class k implements QFSMultiGuideBtn.b {
        k() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtn.b
        public void a(int i3) {
            QLog.d("QFSMultiGuideBtnManageLayout", 2, "[onSelect] multiBtn type =" + i3);
            if (QFSMultiGuideBtnManageLayout.this.f93318m != null) {
                QFSMultiGuideBtnManageLayout.this.f93318m.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface l {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface m {
        void a(int i3);
    }

    public QFSMultiGuideBtnManageLayout(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ l a(QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout) {
        qFSMultiGuideBtnManageLayout.getClass();
        return null;
    }

    private void l(QFSMultiGuideBtn qFSMultiGuideBtn, QFSMultiGuideBtn qFSMultiGuideBtn2) {
        int width = qFSMultiGuideBtn.getWidth();
        ValueAnimator ofInt = ValueAnimator.ofInt(width, (this.G * width) + (DisplayUtil.dip2px(getContext(), this.f93317i) * (this.G - 1)));
        ofInt.addUpdateListener(new d(qFSMultiGuideBtn, qFSMultiGuideBtn2, width));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSMultiGuideBtn2, "translationX", 0.0f, -width);
        ofFloat.addUpdateListener(new e(qFSMultiGuideBtn2));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(DisplayUtil.dip2px(getContext(), this.f93317i), 0);
        ofInt2.addUpdateListener(new f(qFSMultiGuideBtn));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new com.tencent.mobileqq.widget.g());
        animatorSet.playTogether(ofInt, ofFloat, ofInt2);
        animatorSet.addListener(new g(qFSMultiGuideBtn2));
        animatorSet.start();
    }

    private void m(int i3, QFSMultiGuideBtn qFSMultiGuideBtn) {
        if (i3 != 4 && i3 != 2) {
            if (i3 != 1 && i3 != 3) {
                if (TextUtils.isEmpty(qFSMultiGuideBtn.b())) {
                    QLog.e("QFSMultiGuideBtnManageLayout", 1, "[launcherSchema] current url not is empty.");
                    return;
                } else {
                    com.tencent.biz.qqcircle.launcher.c.g(getContext(), qFSMultiGuideBtn.b());
                    r();
                    return;
                }
            }
            qFSMultiGuideBtn.e();
            QFSMultiGuideBtn qFSMultiGuideBtn2 = new QFSMultiGuideBtn(getContext());
            Iterator<QFSMultiGuideBtn> it = this.f93316h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                QFSMultiGuideBtn next = it.next();
                if (next.c() != i3) {
                    qFSMultiGuideBtn2 = next;
                    break;
                }
            }
            l(qFSMultiGuideBtn, qFSMultiGuideBtn2);
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSMultiGuideBtnManageLayout.this.r();
                }
            }, 800L, true);
            return;
        }
        r();
    }

    private void n(int i3, QFSMultiGuideBtn qFSMultiGuideBtn, @NotNull final View view) {
        if (i3 == 4) {
            q(view);
            return;
        }
        if (i3 == 3) {
            qFSMultiGuideBtn.e();
            QFSMultiGuideBtn qFSMultiGuideBtn2 = new QFSMultiGuideBtn(getContext());
            Iterator<QFSMultiGuideBtn> it = this.f93316h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                QFSMultiGuideBtn next = it.next();
                if (next.c() != i3) {
                    qFSMultiGuideBtn2 = next;
                    break;
                }
            }
            l(qFSMultiGuideBtn, qFSMultiGuideBtn2);
            QLog.d("QFSMultiGuideBtnManageLayout", 1, "[doSelectAnimationWithOtherBanner] doOperation");
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.13
                @Override // java.lang.Runnable
                public void run() {
                    QFSMultiGuideBtnManageLayout.this.q(view);
                }
            }, 800L, true);
            return;
        }
        if (TextUtils.isEmpty(qFSMultiGuideBtn.b())) {
            QLog.e("QFSMultiGuideBtnManageLayout", 1, "[launcherSchema] current url not is empty.");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), qFSMultiGuideBtn.b());
            q(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(QFSMultiGuideBtn qFSMultiGuideBtn) {
        if (this.C != null && qFSMultiGuideBtn != null) {
            try {
                VideoReport.setElementId(qFSMultiGuideBtn, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_GUIDE_BUTTON);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qFSMultiGuideBtn.a());
                buildElementParams.put("xsj_feed_id", this.C.f398449id.get());
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                VideoReport.reportEvent("dt_imp", qFSMultiGuideBtn, buildElementParams);
                VideoReport.setElementClickPolicy(qFSMultiGuideBtn, ClickPolicy.REPORT_NONE);
                VideoReport.setElementReuseIdentifier(qFSMultiGuideBtn, this.C.f398449id.get());
            } catch (Throwable th5) {
                QLog.e("QFSMultiGuideBtnManageLayout", 1, "[dtReportBindViewData] error: ", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(QFSMultiGuideBtn qFSMultiGuideBtn) {
        if (this.C != null && qFSMultiGuideBtn != null) {
            try {
                VideoReport.setElementId(qFSMultiGuideBtn, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_GUIDE_BUTTON);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qFSMultiGuideBtn.a());
                buildElementParams.put("xsj_feed_id", this.C.f398449id.get());
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                VideoReport.reportEvent("dt_clck", qFSMultiGuideBtn, buildElementParams);
                VideoReport.setElementExposePolicy(qFSMultiGuideBtn, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementReuseIdentifier(qFSMultiGuideBtn, this.C.f398449id.get());
            } catch (Throwable th5) {
                QLog.e("QFSMultiGuideBtnManageLayout", 1, "[dtReportCustomDynamicViewClick] error: ", th5);
            }
            if (qFSMultiGuideBtn.c() == 1) {
                Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams2.put("xsj_action_type", "like");
                buildElementParams2.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                buildElementParams2.put("xsj_target_qq", this.C.poster.f398463id.get());
                VideoReport.setElementId(qFSMultiGuideBtn, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_GUIDE_BUTTON);
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_LIKE_WORK, qFSMultiGuideBtn, buildElementParams2);
                VideoReport.setElementExposePolicy(qFSMultiGuideBtn, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(qFSMultiGuideBtn, ClickPolicy.REPORT_NONE);
                VideoReport.setElementReuseIdentifier(qFSMultiGuideBtn, this.C.f398449id.get());
                return;
            }
            if (qFSMultiGuideBtn.c() == 3) {
                Map<String, Object> buildElementParams3 = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams3.put("xsj_action_type", "follow");
                buildElementParams3.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                buildElementParams3.put("xsj_target_qq", this.C.poster.f398463id.get());
                buildElementParams3.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qFSMultiGuideBtn.a());
                VideoReport.setElementId(qFSMultiGuideBtn, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_GUIDE_BUTTON);
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSMultiGuideBtn, buildElementParams3);
                VideoReport.setElementExposePolicy(qFSMultiGuideBtn, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(qFSMultiGuideBtn, ClickPolicy.REPORT_NONE);
                VideoReport.setElementReuseIdentifier(qFSMultiGuideBtn, this.C.f398449id.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(@NotNull View view) {
        int translationY = (int) getTranslationY();
        view.setTranslationY(DisplayUtil.dip2px(getContext(), 32.0f));
        int translationY2 = (int) view.getTranslationY();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, DisplayUtil.dip2px(getContext(), 32.0f));
        ofInt.setStartDelay(40L);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new i(view, translationY, translationY2));
        ofInt.addListener(new j(view));
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(250L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "translationY", 0.0f, DisplayUtil.dip2px(getContext(), 42.0f));
        ofFloat2.setStartDelay(200L);
        ofFloat2.setDuration(250L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.E, "translationY", 0.0f, DisplayUtil.dip2px(getContext(), 42.0f));
        ofFloat3.setStartDelay(200L);
        ofFloat3.setDuration(250L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(450L);
        animatorSet.playTogether(ofFloat2, ofFloat, ofFloat3);
        animatorSet.addListener(new h());
        animatorSet.start();
    }

    public void j(List<FeedCloudWidget$StButton> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            this.G = list.size();
            this.f93316h.clear();
            for (int i3 = 0; i3 < this.G; i3++) {
                FeedCloudWidget$StButton feedCloudWidget$StButton = list.get(i3);
                if (feedCloudWidget$StButton != null) {
                    QFSMultiGuideBtn qFSMultiGuideBtn = new QFSMultiGuideBtn(getContext());
                    FeedCloudWidget$StButtonStyle feedCloudWidget$StButtonStyle = feedCloudWidget$StButton.style.get();
                    qFSMultiGuideBtn.setCornerRadius(cx.a(feedCloudWidget$StButtonStyle.cornerSize.get()));
                    qFSMultiGuideBtn.setAfterSelectedBgColor(feedCloudWidget$StButtonStyle.bgColorPost.get());
                    qFSMultiGuideBtn.setAfterSelectedText(feedCloudWidget$StButtonStyle.textPost.get());
                    qFSMultiGuideBtn.setAfterSelectedTextColor(feedCloudWidget$StButtonStyle.textColorPost.get());
                    qFSMultiGuideBtn.setType(feedCloudWidget$StButton.type.get());
                    qFSMultiGuideBtn.setSchema(feedCloudWidget$StButton.jumpUrl.get());
                    qFSMultiGuideBtn.f(feedCloudWidget$StButtonStyle.textPre.get(), feedCloudWidget$StButtonStyle.textColorPre.get(), feedCloudWidget$StButtonStyle.textSize.get(), feedCloudWidget$StButtonStyle.bgColorPre.get());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                    if (i3 > 0) {
                        layoutParams.setMargins(DisplayUtil.dip2px(getContext(), this.f93317i), 0, 0, 0);
                    }
                    qFSMultiGuideBtn.setLayoutParams(layoutParams);
                    qFSMultiGuideBtn.setOnSelectedListener(new b());
                    qFSMultiGuideBtn.setDatongJsonData(feedCloudWidget$StButton.datongJsonData.get());
                    qFSMultiGuideBtn.setGuideBtnListener(new c());
                    this.f93316h.add(qFSMultiGuideBtn);
                    addView(qFSMultiGuideBtn);
                }
            }
            return;
        }
        QLog.e("QFSMultiGuideBtnManageLayout", 1, "[createFolderMultiBtn] multiBtn is empty.");
    }

    public void k(List<QQCircleDitto$StButton> list) {
        if (list != null && !list.isEmpty()) {
            removeAllViews();
            this.G = list.size();
            this.f93316h.clear();
            for (int i3 = 0; i3 < this.G; i3++) {
                QQCircleDitto$StButton qQCircleDitto$StButton = list.get(i3);
                if (qQCircleDitto$StButton != null) {
                    QFSMultiGuideBtn qFSMultiGuideBtn = new QFSMultiGuideBtn(getContext());
                    QQCircleDitto$StButtonStyle qQCircleDitto$StButtonStyle = qQCircleDitto$StButton.style.get();
                    qFSMultiGuideBtn.setCornerRadius(cx.a(qQCircleDitto$StButtonStyle.cornerSize.get()));
                    qFSMultiGuideBtn.setAfterSelectedBgColor(qQCircleDitto$StButtonStyle.bgColorPost.get());
                    qFSMultiGuideBtn.setAfterSelectedText(qQCircleDitto$StButtonStyle.textPost.get());
                    qFSMultiGuideBtn.setAfterSelectedTextColor(qQCircleDitto$StButtonStyle.textColorPost.get());
                    qFSMultiGuideBtn.setType(qQCircleDitto$StButton.type.get());
                    qFSMultiGuideBtn.setSchema(qQCircleDitto$StButton.jumpUrl.get());
                    qFSMultiGuideBtn.f(qQCircleDitto$StButtonStyle.textPre.get(), qQCircleDitto$StButtonStyle.textColorPre.get(), qQCircleDitto$StButtonStyle.textSize.get(), qQCircleDitto$StButtonStyle.bgColorPre.get());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                    if (i3 > 0) {
                        layoutParams.setMargins(DisplayUtil.dip2px(getContext(), this.f93317i), 0, 0, 0);
                    }
                    qFSMultiGuideBtn.setLayoutParams(layoutParams);
                    qFSMultiGuideBtn.setOnSelectedListener(new k());
                    qFSMultiGuideBtn.setDatongJsonData(qQCircleDitto$StButton.datongJsonData.get());
                    qFSMultiGuideBtn.setGuideBtnListener(new a());
                    this.f93316h.add(qFSMultiGuideBtn);
                    addView(qFSMultiGuideBtn);
                }
            }
            return;
        }
        QLog.e("QFSMultiGuideBtnManageLayout", 1, "[createMultiBtn] multiBtn is empty.");
    }

    public void s(int i3) {
        t(i3, null);
    }

    public void setBottomBannerViewGroup(View view) {
        this.F = view;
    }

    public void setData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QQCircleDitto$StButtonGroup qQCircleDitto$StButtonGroup, View view) {
        if (feedCloudMeta$StFeed != null && qQCircleDitto$StButtonGroup != null) {
            this.f93313d = qQCircleDitto$StButtonGroup;
            List<QQCircleDitto$StButton> list = qQCircleDitto$StButtonGroup.buttons.get();
            if (list != null && !list.isEmpty()) {
                this.f93314e = list;
                this.C = feedCloudMeta$StFeed;
                k(list);
                this.f93317i = DisplayUtil.dip2px(getContext(), this.f93313d.margin.get());
                this.D = view;
                return;
            }
            QLog.e("QFSMultiGuideBtnManageLayout", 1, "[setLayerPageData] multiBtn is empty.");
            return;
        }
        QLog.e("QFSMultiGuideBtnManageLayout", 1, "[setLayerPageData] feed or stButtonGroup is empty.");
    }

    public void setInfoViewTop(View view) {
        this.E = view;
    }

    public void setOnSelectedListener(m mVar) {
        this.f93318m = mVar;
    }

    public void t(int i3, View view) {
        QLog.d("QFSMultiGuideBtnManageLayout", 1, "[updateSelectedUI] otherBannerView = " + view + ", type =" + i3);
        for (QFSMultiGuideBtn qFSMultiGuideBtn : this.f93316h) {
            if (qFSMultiGuideBtn.c() == i3) {
                if (view == null) {
                    QLog.d("QFSMultiGuideBtnManageLayout", 1, "[updateSelectedUI] doSelectAnimation");
                    m(i3, qFSMultiGuideBtn);
                    return;
                } else {
                    QLog.d("QFSMultiGuideBtnManageLayout", 1, "[updateSelectedUI] doSelectAnimationWithOtherBanner");
                    n(i3, qFSMultiGuideBtn, view);
                    return;
                }
            }
        }
    }

    public QFSMultiGuideBtnManageLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSMultiGuideBtnManageLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93314e = new ArrayList();
        this.f93316h = new ArrayList();
        this.f93317i = 8.0f;
    }

    public void setData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudWidget$StButtonGroup feedCloudWidget$StButtonGroup, View view) {
        if (feedCloudMeta$StFeed != null && feedCloudWidget$StButtonGroup != null) {
            this.f93315f = feedCloudWidget$StButtonGroup;
            List<FeedCloudWidget$StButton> list = feedCloudWidget$StButtonGroup.buttons.get();
            if (list != null && !list.isEmpty()) {
                this.C = feedCloudMeta$StFeed;
                j(list);
                this.D = view;
                return;
            }
            QLog.e("QFSMultiGuideBtnManageLayout", 1, "[setData] multiBtn is empty.");
            return;
        }
        QLog.e("QFSMultiGuideBtnManageLayout", 1, "[setData] feed or stButtonGroup is empty.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSMultiGuideBtn f93331d;

        g(QFSMultiGuideBtn qFSMultiGuideBtn) {
            this.f93331d = qFSMultiGuideBtn;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSMultiGuideBtn qFSMultiGuideBtn = this.f93331d;
            if (qFSMultiGuideBtn != null) {
                qFSMultiGuideBtn.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class h implements Animator.AnimatorListener {
        h() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSMultiGuideBtnManageLayout", 1, "[startDismissAnimation] animatorSet onAnimationEnd");
            QFSMultiGuideBtnManageLayout.a(QFSMultiGuideBtnManageLayout.this);
            QFSMultiGuideBtnManageLayout.this.setVisibility(8);
            QFSMultiGuideBtnManageLayout.this.setAlpha(1.0f);
            if (QFSMultiGuideBtnManageLayout.this.F != null) {
                QFSMultiGuideBtnManageLayout.this.F.setVisibility(8);
            }
            if (QFSMultiGuideBtnManageLayout.this.D != null) {
                QFSMultiGuideBtnManageLayout.this.D.setTranslationY(0.0f);
            }
            if (QFSMultiGuideBtnManageLayout.this.E != null) {
                QFSMultiGuideBtnManageLayout.this.E.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f93338d;

        j(View view) {
            this.f93338d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSMultiGuideBtnManageLayout", 1, "[showOtherBannerAnimation] onAnimationEnd");
            QFSMultiGuideBtnManageLayout.a(QFSMultiGuideBtnManageLayout.this);
            QFSMultiGuideBtnManageLayout.this.setVisibility(8);
            QFSMultiGuideBtnManageLayout.this.setTranslationY(0.0f);
            View view = this.f93338d;
            if (view != null) {
                view.setTranslationY(0.0f);
                this.f93338d.setVisibility(0);
            }
            if (QFSMultiGuideBtnManageLayout.this.F != null) {
                QFSMultiGuideBtnManageLayout.this.F.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public void setAnimationEndListener(l lVar) {
    }
}
