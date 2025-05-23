package com.tencent.ad.tangram.views.feedback;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.config.data.AdConfigForFeedback;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdNavigationBarUtil;
import com.tencent.ad.tangram.util.AdStatusBarUtil;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.feedback.AdFeedbackItemView;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFeedbackDialogFragment extends ReportDialogFragment {
    private static final String HIDE_TOAST_STR = "\u611f\u8c22\u53cd\u9988\uff0c\u5c06\u51cf\u5c11\u6b64\u7c7b\u5e7f\u544a\u63a8\u8350";
    private static final String MACRO_REPORT_URL = "__ACT_TYPE__";
    private static final String TAG = "AdFeedbackDialogFragment";

    @Nullable
    private View mDialogView;
    private NoClickAccessibilityDelegate mNoClickAccessibilityDelegate;

    @Nullable
    private AdFeedbackParams mParams;

    @NonNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsDarkMode = false;
    private int mStyleId = 0;
    private final View.OnClickListener mCancelClickedListener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AdFeedbackDialogFragment.this.handleCancelClicked();
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    private final View.OnClickListener mListViewItemClickedListener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AdFeedbackDialogFragment.this.handleItemClicked(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Listener {
        void onResult(Result result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NoClickAccessibilityDelegate extends View.AccessibilityDelegate {
        private volatile boolean mReportedcAcessibility;
        private final boolean mSupportAntiSpam;
        private final WeakReference<AdFeedbackDialogFragment> mWeakFragment;

        private String getPosId() {
            AdFeedbackDialogFragment adFeedbackDialogFragment;
            WeakReference<AdFeedbackDialogFragment> weakReference = this.mWeakFragment;
            Ad ad5 = null;
            if (weakReference != null) {
                adFeedbackDialogFragment = weakReference.get();
            } else {
                adFeedbackDialogFragment = null;
            }
            if (adFeedbackDialogFragment != null && adFeedbackDialogFragment.mParams != null) {
                ad5 = adFeedbackDialogFragment.mParams.f61346ad;
            }
            if (ad5 != null) {
                return ad5.getPosId();
            }
            return "";
        }

        private static boolean isTouchExplorationEnabled(Context context) {
            if (context == null) {
                AdLog.e(AdFeedbackDialogFragment.TAG, "[isTouchExplorationEnabled] context is null");
                return true;
            }
            try {
                return ((AccessibilityManager) context.getSystemService("accessibility")).isTouchExplorationEnabled();
            } catch (Throwable th5) {
                AdLog.e(AdFeedbackDialogFragment.TAG, "[isTouchExplorationEnabled]", th5);
                return true;
            }
        }

        private void reportForAntiSpam(Context context, String str) {
            if (context == null) {
                AdLog.e(AdFeedbackDialogFragment.TAG, "[reportForAntiSpam] context is null");
                return;
            }
            gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
            gdt_analysis_eventVar.posId = getPosId();
            gdt_analysis_eventVar.api = str;
            AdAnalysisUtil.initEvent(context, gdt_analysis_event.EVENT_OPEN_SPAM_CLICK_OPEN, gdt_analysis_eventVar);
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
        }

        private void setBoundsInScreen(AccessibilityNodeInfo accessibilityNodeInfo) {
            AdFeedbackDialogFragment adFeedbackDialogFragment;
            WeakReference<AdFeedbackDialogFragment> weakReference = this.mWeakFragment;
            if (weakReference != null) {
                adFeedbackDialogFragment = weakReference.get();
            } else {
                adFeedbackDialogFragment = null;
            }
            if (adFeedbackDialogFragment != null && adFeedbackDialogFragment.mDialogView != null && accessibilityNodeInfo != null) {
                Rect rect = new Rect();
                try {
                    adFeedbackDialogFragment.mDialogView.getGlobalVisibleRect(rect);
                } catch (Throwable th5) {
                    AdLog.e(AdFeedbackDialogFragment.TAG, "[setBoundsInScreen]", th5);
                }
                int i3 = rect.top - 1;
                rect.bottom = i3;
                rect.top = i3;
                AdLog.i(AdFeedbackDialogFragment.TAG, "[setBoundsInScreen] set rect" + rect);
                accessibilityNodeInfo.setBoundsInScreen(rect);
                return;
            }
            AdLog.e(AdFeedbackDialogFragment.TAG, "[setBoundsInScreen] some params is null");
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            Context context;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AdLog.i(AdFeedbackDialogFragment.TAG, "[onInitializeAccessibilityNodeInfo], supportAntiSpam:" + this.mSupportAntiSpam);
            Context context2 = null;
            if (accessibilityNodeInfo != null && this.mSupportAntiSpam) {
                if (view != null) {
                    context = view.getContext();
                } else {
                    context = null;
                }
                if (!isTouchExplorationEnabled(context)) {
                    setBoundsInScreen(accessibilityNodeInfo);
                }
            }
            if (!this.mReportedcAcessibility) {
                this.mReportedcAcessibility = true;
                if (view != null) {
                    context2 = view.getContext();
                }
                reportForAntiSpam(context2, "onInitializeAccessibilityNodeInfo");
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            Context context;
            AdLog.i(AdFeedbackDialogFragment.TAG, "[performAccessibilityAction] action:" + i3 + ", supportAntiSpam:" + this.mSupportAntiSpam);
            if (i3 == 16) {
                AdFeedbackDialogFragment adFeedbackDialogFragment = null;
                if (view != null) {
                    context = view.getContext();
                } else {
                    context = null;
                }
                reportForAntiSpam(context, "performAccessibilityAction");
                if (this.mSupportAntiSpam) {
                    WeakReference<AdFeedbackDialogFragment> weakReference = this.mWeakFragment;
                    if (weakReference != null) {
                        adFeedbackDialogFragment = weakReference.get();
                    }
                    if (adFeedbackDialogFragment != null) {
                        adFeedbackDialogFragment.dismiss();
                        return true;
                    }
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i3, bundle);
        }

        NoClickAccessibilityDelegate(WeakReference<AdFeedbackDialogFragment> weakReference) {
            this.mWeakFragment = weakReference;
            this.mSupportAntiSpam = AdFeedbackDialogFragment.access$500();
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static class Result {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61345ad;

        @Nullable
        public AdError result = null;
        public int action = 0;
    }

    static /* synthetic */ boolean access$500() {
        return isEnableAntiSpamAction();
    }

    @NonNull
    private View createView() {
        boolean z16;
        int i3;
        float f16;
        int i16;
        int i17;
        Ad ad5;
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setBackgroundColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
        int i18 = 0;
        if (this.mStyleId == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 17;
        } else {
            i3 = 80;
        }
        relativeLayout.setGravity(i3);
        relativeLayout.setOnClickListener(this.mCancelClickedListener);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        float f17 = 15.0f;
        if (z16) {
            f16 = 15.0f;
        } else {
            f16 = 6.0f;
        }
        int dp2px = AdUIUtils.dp2px(f16, getResources());
        if (!z16) {
            f17 = 45.0f;
        }
        linearLayout.setPadding(0, dp2px, 0, AdUIUtils.dp2px(f17, getResources()));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        if (z16) {
            i16 = -2;
        } else {
            i16 = -1;
        }
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i16, -2));
        List<?> list = null;
        linearLayout.setOnClickListener(null);
        this.mDialogView = linearLayout;
        int dp2px2 = AdUIUtils.dp2px(14.0f, getResources());
        if (z16) {
            i17 = dp2px2;
        } else {
            i17 = 0;
        }
        setRoundedCornerBackground(linearLayout, dp2px2, i17, AdFeedback.getInstance().getBackgroundColor(getContext()));
        if (!z16) {
            View view = new View(getActivity());
            int dp2px3 = AdUIUtils.dp2px(10.0f, getResources());
            setRoundedCornerBackground(view, dp2px3, dp2px3, AdFeedback.getInstance().getMainDividerColor(getContext()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AdUIUtils.dp2px(40.0f, getResources()), AdUIUtils.dp2px(4.0f, getResources()));
            layoutParams.bottomMargin = AdUIUtils.dp2px(6.0f, getResources());
            view.setLayoutParams(layoutParams);
            linearLayout.addView(view);
        }
        AdFeedbackParams adFeedbackParams = this.mParams;
        if (adFeedbackParams != null) {
            ad5 = adFeedbackParams.f61346ad;
        } else {
            ad5 = null;
        }
        if (ad5 != null) {
            list = ad5.getFeedbackItems();
        }
        if (list == null) {
            return relativeLayout;
        }
        for (Object obj : list) {
            if (obj instanceof AdFeedbackItemModel) {
                AdFeedbackItemView.Params params = new AdFeedbackItemView.Params();
                params.isDarkMode = this.mIsDarkMode;
                params.styleId = this.mStyleId;
                params.listener = new WeakReference<>(this.mListViewItemClickedListener);
                params.model = (AdFeedbackItemModel) obj;
                initAntiSpamParam(params);
                if (i18 != 0) {
                    View view2 = new View(getActivity());
                    view2.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
                    Integer dividerColor = AdFeedback.getInstance().getDividerColor(getContext());
                    if (dividerColor != null) {
                        view2.setBackgroundColor(dividerColor.intValue());
                    }
                    linearLayout.addView(view2);
                }
                linearLayout.addView(new AdFeedbackItemView(getActivity(), params));
                i18++;
            }
        }
        AdFeedbackParams adFeedbackParams2 = this.mParams;
        if (adFeedbackParams2 != null && adFeedbackParams2.isValid() && this.mParams.shouldShowCancelButton) {
            linearLayout.addView(initCancelButton());
        }
        AnimationSet animationSet = new AnimationSet(true);
        if (!z16) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, AdUIUtils.dp2px(20.0f, getResources()), 0.0f);
            translateAnimation.setDuration(200L);
            animationSet.addAnimation(translateAnimation);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        linearLayout.startAnimation(animationSet);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCancelClicked() {
        Ad ad5;
        Result result = new Result();
        AdFeedbackParams adFeedbackParams = this.mParams;
        if (adFeedbackParams != null) {
            ad5 = adFeedbackParams.f61346ad;
        } else {
            ad5 = null;
        }
        result.f61345ad = ad5;
        result.result = new AdError(0);
        result.action = 0;
        onResult(this.mParams, result);
        dismiss();
    }

    private void handleHideAdClicked() {
        AdFeedbackParams adFeedbackParams = this.mParams;
        if (adFeedbackParams != null && adFeedbackParams.isValid() && this.mParams.shouldShowToast) {
            AdToast.getInstance().show(this.mParams.activity.get(), 2, HIDE_TOAST_STR, 0);
            AdLog.i(TAG, "handle hide ad");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleItemClicked(@NonNull View view) {
        AdFeedbackItemModel model;
        Ad ad5;
        if (!(view instanceof AdFeedbackItemView) || (model = ((AdFeedbackItemView) view).getModel()) == null) {
            return;
        }
        reportItemClicked(model.mReportType);
        Context context = view.getContext();
        int i3 = model.mActionType;
        AdFeedbackParams adFeedbackParams = this.mParams;
        Ad ad6 = null;
        if (adFeedbackParams != null) {
            ad5 = adFeedbackParams.f61346ad;
        } else {
            ad5 = null;
        }
        reportClickForAnalysis(context, i3, ad5);
        int i16 = model.mActionType;
        if (i16 != 3) {
            if (i16 != 6) {
                AdLog.e(TAG, "cannot handle such action" + model.mActionType);
            } else {
                handleJumpToDestUrl(model.mJumpUrl);
            }
        } else {
            handleHideAdClicked();
        }
        Result result = new Result();
        AdFeedbackParams adFeedbackParams2 = this.mParams;
        if (adFeedbackParams2 != null) {
            ad6 = adFeedbackParams2.f61346ad;
        }
        result.f61345ad = ad6;
        result.action = model.mActionType;
        result.result = new AdError(0);
        onResult(this.mParams, result);
        dismiss();
    }

    private void handleJumpToDestUrl(String str) {
        AdFeedbackParams adFeedbackParams = this.mParams;
        if (adFeedbackParams != null && adFeedbackParams.isValid()) {
            if (TextUtils.isEmpty(str)) {
                AdLog.e(TAG, "cannot handle this action because of an empty jump url");
                return;
            }
            if (this.mIsDarkMode) {
                try {
                    str = str + URLEncoder.encode("&isnm=2", "utf-8");
                } catch (Throwable unused) {
                }
            }
            AdBrowser.Params params = new AdBrowser.Params();
            params.activity = this.mParams.activity;
            params.url = str;
            AdBrowser.getInstance().showWithoutAd(params);
        }
    }

    @RequiresApi(api = 9)
    private void init(@Nullable AdFeedbackParams adFeedbackParams) {
        if (adFeedbackParams != null && adFeedbackParams.isValid()) {
            this.mParams = adFeedbackParams;
            this.mStyleId = adFeedbackParams.styleId;
            this.mIsDarkMode = adFeedbackParams.isDarkMode;
        }
    }

    private void initAntiSpamParam(AdFeedbackItemView.Params params) {
        if (!isEnableAntiSpamReport()) {
            AdLog.i(TAG, "[initAntiSpamParam] switch not open");
            return;
        }
        if (params == null) {
            AdLog.i(TAG, "[initAntiSpamParam] params is null");
            return;
        }
        AdFeedbackItemModel adFeedbackItemModel = params.model;
        if (adFeedbackItemModel != null && adFeedbackItemModel.mActionType != 3) {
            AdLog.i(TAG, "[initAntiSpamParam] not hide ad action");
            return;
        }
        if (this.mNoClickAccessibilityDelegate == null) {
            this.mNoClickAccessibilityDelegate = new NoClickAccessibilityDelegate(new WeakReference(this));
        }
        params.noClickAccessibilityDelegate = this.mNoClickAccessibilityDelegate;
    }

    @NonNull
    private TextView initCancelButton() {
        TextView textView = new TextView(getActivity());
        int dp2px = AdUIUtils.dp2px(34.0f, getResources());
        setRoundedCornerBackground(textView, dp2px, dp2px, AdFeedback.getInstance().getCancelButtonBackgroundColor(getContext()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        float f16 = 15.0f;
        layoutParams.leftMargin = AdUIUtils.dp2px(15.0f, getResources());
        layoutParams.rightMargin = AdUIUtils.dp2px(15.0f, getResources());
        layoutParams.topMargin = AdUIUtils.dp2px(10.0f, getResources());
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        int dp2px2 = AdUIUtils.dp2px(7.0f, getResources());
        textView.setPadding(0, dp2px2, 0, dp2px2);
        textView.setText("\u53d6\u6d88");
        if (this.mStyleId == 1) {
            f16 = 14.0f;
        }
        textView.setTextSize(1, f16);
        Integer cancelButtonTextColor = AdFeedback.getInstance().getCancelButtonTextColor(getContext());
        if (cancelButtonTextColor != null) {
            textView.setTextColor(cancelButtonTextColor.intValue());
        } else {
            AdLog.e(TAG, "[initCancelButton] textColor is null");
        }
        textView.setOnClickListener(this.mCancelClickedListener);
        return textView;
    }

    private void initWindowStyle(@Nullable Window window) {
        int i3;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            AdStatusBarUtil.setTransparent(window);
            AdNavigationBarUtil.setTransparent(window);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.mStyleId == 1) {
            i3 = 17;
        } else {
            i3 = 80;
        }
        attributes.gravity = i3;
        attributes.width = -1;
        attributes.height = -1;
        attributes.windowAnimations = 0;
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    @NonNull
    private static boolean isDataValid(AdFeedbackParams adFeedbackParams) {
        List<?> feedbackItems;
        if (adFeedbackParams == null || !adFeedbackParams.isValid() || (feedbackItems = adFeedbackParams.f61346ad.getFeedbackItems()) == null || feedbackItems.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean isEnableAntiSpamAction() {
        AdConfigForFeedback configForFeedback = AdConfigManager.getInstance().getConfigForFeedback();
        if (configForFeedback != null) {
            return configForFeedback.antiSpamForFeedBackAction;
        }
        return false;
    }

    private static boolean isEnableAntiSpamReport() {
        AdConfigForFeedback configForFeedback = AdConfigManager.getInstance().getConfigForFeedback();
        if (configForFeedback != null) {
            return configForFeedback.antiSpamForFeedBackReport;
        }
        return false;
    }

    private static void onResult(AdFeedbackParams adFeedbackParams, Result result) {
        Listener listener;
        if (adFeedbackParams != null && adFeedbackParams.isValid() && (listener = adFeedbackParams.listener.get()) != null) {
            listener.onResult(result);
        }
    }

    private void reportClickForAnalysis(Context context, int i3, Ad ad5) {
        if (!isEnableAntiSpamReport()) {
            AdLog.i(TAG, "[reportClickForAnalyze] switch not open");
            return;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, gdt_analysis_event.EVENT_FEEDBACK_CLICK, ad5);
        if (createEventForAd == null) {
            AdLog.e(TAG, "[reportClickForAnalyze] event is null");
        } else {
            createEventForAd.actionId = i3;
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, 103));
        }
    }

    private void reportItemClicked(int i3) {
        Ad ad5;
        String str;
        AdFeedbackParams adFeedbackParams = this.mParams;
        if (adFeedbackParams != null) {
            ad5 = adFeedbackParams.f61346ad;
        } else {
            ad5 = null;
        }
        if (ad5 != null) {
            str = ad5.getUrlForFeedBack();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String replace = str.replace(MACRO_REPORT_URL, String.valueOf(i3));
        AdHttp.Params params = new AdHttp.Params();
        params.setUrl(replace);
        params.method = "GET";
        AdHttp.sendAsync(params, null);
    }

    private static void setRoundedCornerBackground(@Nullable View view, int i3, int i16, Integer num) {
        if (view != null && num != null) {
            float f16 = i3;
            float f17 = i16;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f17, f17, f17, f17}, null, null));
            Paint paint = shapeDrawable.getPaint();
            if (paint != null) {
                paint.setColor(num.intValue());
            }
            view.setBackgroundDrawable(shapeDrawable);
            return;
        }
        AdLog.e(TAG, "[setRoundedCornerBackground] error, view or color is null");
    }

    @RequiresApi(api = 9)
    public static void start(AdFeedbackParams adFeedbackParams) {
        boolean z16;
        Activity activity;
        Ad ad5 = null;
        if (!isDataValid(adFeedbackParams) || (activity = adFeedbackParams.activity.get()) == null) {
            z16 = false;
        } else {
            AdFeedbackDialogFragment adFeedbackDialogFragment = new AdFeedbackDialogFragment();
            adFeedbackDialogFragment.init(adFeedbackParams);
            adFeedbackDialogFragment.show(activity.getFragmentManager(), (String) null);
            z16 = true;
        }
        if (!z16) {
            Result result = new Result();
            if (adFeedbackParams != null) {
                ad5 = adFeedbackParams.f61346ad;
            }
            result.f61345ad = ad5;
            result.result = new AdError(4);
            result.action = 0;
            onResult(adFeedbackParams, result);
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        AnimationSet animationSet = new AnimationSet(true);
        if (this.mStyleId == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, AdUIUtils.dp2px(20.0f, getResources()));
            translateAnimation.setDuration(200L);
            animationSet.addAnimation(translateAnimation);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AdFeedbackDialogFragment.this.mHandler.post(new Runnable() { // from class: com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AdFeedbackDialogFragment.super.dismissAllowingStateLoss();
                        } catch (Throwable th5) {
                            AdLog.e(AdFeedbackDialogFragment.TAG, "[dismiss][onAnimationEnd]", th5);
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        View view = this.mDialogView;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment, android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        ReportDialog reportDialog = new ReportDialog(getActivity());
        reportDialog.requestWindowFeature(1);
        reportDialog.setContentView(createView());
        initWindowStyle(reportDialog.getWindow());
        return reportDialog;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Throwable th5) {
            AdLog.e(TAG, "show", th5);
        }
    }
}
