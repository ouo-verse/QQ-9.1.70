package com.tencent.ams.fusion.widget.downloadcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.base.CustomImageView;
import com.tencent.ams.fusion.widget.downloadcard.DownloadHandler;
import com.tencent.ams.fusion.widget.downloadcard.DownloadWebView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadCardView extends FrameLayout implements DownloadHandler.DownloadStatusChangeListener, IDownloadCardView {
    static IPatchRedirector $redirector_ = null;
    private static final String AGREEMENT = "\u9690\u79c1\u534f\u8bae";
    public static final int COLOR_APP_NAME = -15658735;
    public static final int COLOR_APP_NAME_DARK = -855310;
    public static final int COLOR_APP_VERSION = -6710887;
    public static final int COLOR_APP_VERSION_DARK = -7697782;
    public static final int COLOR_BUTTON_BACKGROUND_DARK = -13421773;
    private static final String FEATURELIST = "\u529f\u80fd\u4ecb\u7ecd";
    private static final String IMAGE_CLOSE_BASE64 = "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";
    private static final String PERMISSION = "\u5e94\u7528\u6743\u9650";
    private static final String TAG = "DownloadCardView";
    private TextView mAgeAppropriateView;
    private TextView mAgreementView;
    private DownloadWebView mAgreementWebView;
    private CustomImageView mAppIconView;
    private TextView mAppNameView;
    private TextView mAppVersionView;
    private TextView mAuthorNameView;
    private TextView mCancelTextView;
    private DownloadCancelView mCancelView;
    private int mClickViewType;
    private float mClickX;
    private float mClickY;
    private View mCloseView;
    private TextView mDeveloperNameView;
    private DownloadButton mDownloadButton;
    private DownloadHandler mDownloadHandler;
    private DownloadInfo mDownloadInfo;
    private DownloadStatus mDownloadStatus;
    private View mFeatureListSplitView;
    private TextView mFeatureListView;
    private DownloadWebView mFeatureListWebView;
    private TextView mICPView;
    private DownloadCardListener mListener;
    private View mPermissionAndAgreementContainer;
    private TextView mPermissionView;
    private DownloadWebView mPermissionWebView;
    private int mThemeColor;
    private AnimatorSet mTipShowHideAnimator;
    private TextView mTipsView;

    public DownloadCardView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mDownloadStatus = new DownloadStatus(-1);
            initView(getContext());
        }
    }

    private void addWebViews(Context context) {
        DownloadWebView createWebView = createWebView(context);
        this.mFeatureListWebView = createWebView;
        createWebView.setListener(new DownloadWebView.DownloadWebViewListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadWebView.DownloadWebViewListener
            public void onClose() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (DownloadCardView.this.mListener != null) {
                    DownloadCardView.this.mListener.onFeatureListWebViewDismiss();
                }
            }
        });
        addView(this.mFeatureListWebView);
        DownloadWebView createWebView2 = createWebView(context);
        this.mPermissionWebView = createWebView2;
        createWebView2.setListener(new DownloadWebView.DownloadWebViewListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadWebView.DownloadWebViewListener
            public void onClose() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (DownloadCardView.this.mListener != null) {
                    DownloadCardView.this.mListener.onPermissionWebViewDismiss();
                }
            }
        });
        addView(this.mPermissionWebView);
        DownloadWebView createWebView3 = createWebView(context);
        this.mAgreementWebView = createWebView3;
        createWebView3.setListener(new DownloadWebView.DownloadWebViewListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadWebView.DownloadWebViewListener
            public void onClose() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (DownloadCardView.this.mListener != null) {
                    DownloadCardView.this.mListener.onAgreementWebViewDismiss();
                }
            }
        });
        addView(this.mAgreementWebView);
    }

    private View createCancelView(Context context) {
        DownloadCancelView downloadCancelView = new DownloadCancelView(context);
        downloadCancelView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        downloadCancelView.setLeftButtonClickListener(new View.OnClickListener(downloadCancelView) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ DownloadCancelView val$cancelView;

            {
                this.val$cancelView = downloadCancelView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this, (Object) downloadCancelView);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    this.val$cancelView.close();
                    if (DownloadCardView.this.mListener != null) {
                        DownloadCardView.this.mListener.onCancelViewCancelButtonClick();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        downloadCancelView.setRightButtonClickListener(new View.OnClickListener(downloadCancelView) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ DownloadCancelView val$cancelView;

            {
                this.val$cancelView = downloadCancelView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this, (Object) downloadCancelView);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (DownloadCardView.this.mDownloadHandler != null) {
                        DownloadCardView.this.mDownloadHandler.deleteDownload(DownloadCardView.this.mDownloadInfo);
                    }
                    this.val$cancelView.close();
                    if (DownloadCardView.this.mListener != null) {
                        DownloadCardView.this.mListener.onCancelViewConfirmButtonClick();
                    }
                    DownloadCardView.this.setCancelTextViewVisible(false, null);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mCancelView = downloadCancelView;
        downloadCancelView.hide();
        return downloadCancelView;
    }

    private View createCloseView(Context context) {
        ImageView imageView = new ImageView(context);
        int dp2px = (int) Utils.dp2px(20.0f);
        int dp2px2 = (int) Utils.dp2px(16.0f);
        int dp2px3 = (int) Utils.dp2px(13.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 5;
        layoutParams.topMargin = dp2px2;
        layoutParams.rightMargin = dp2px2;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageBitmap(Utils.bitmapFromBase64StringSafe(IMAGE_CLOSE_BASE64, dp2px3, dp2px3));
        this.mCloseView = imageView;
        return imageView;
    }

    private View createContentView(Context context) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        CustomImageView customImageView = new CustomImageView(context);
        customImageView.setRadius(Utils.dp2px(10.0f));
        customImageView.setTag(1);
        int dp2px = (int) Utils.dp2px(70.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px, dp2px);
        layoutParams.topMargin = (int) Utils.dp2px(36.0f);
        linearLayout2.addView(customImageView, layoutParams);
        this.mAppIconView = customImageView;
        TextView textView = new TextView(context);
        textView.setTextSize(0, Utils.dp2px(18.0f));
        if (ViewUtils.isDarkMode()) {
            i3 = COLOR_APP_NAME_DARK;
        } else {
            i3 = COLOR_APP_NAME;
        }
        textView.setTextColor(i3);
        textView.getPaint().setFakeBoldText(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(24.0f));
        layoutParams2.topMargin = (int) Utils.dp2px(10.0f);
        linearLayout2.addView(textView, layoutParams2);
        this.mAppNameView = textView;
        TextView textView2 = new TextView(context);
        textView2.setTextSize(0, Utils.dp2px(13.0f));
        boolean isDarkMode = ViewUtils.isDarkMode();
        int i27 = COLOR_APP_VERSION_DARK;
        if (isDarkMode) {
            i16 = -7697782;
        } else {
            i16 = -6710887;
        }
        textView2.setTextColor(i16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = (int) Utils.dp2px(4.0f);
        linearLayout2.addView(textView2, layoutParams3);
        this.mAppVersionView = textView2;
        TextView textView3 = new TextView(context);
        textView3.setTextSize(0, Utils.dp2px(13.0f));
        if (ViewUtils.isDarkMode()) {
            i17 = -7697782;
        } else {
            i17 = -6710887;
        }
        textView3.setTextColor(i17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = (int) Utils.dp2px(4.0f);
        linearLayout2.addView(textView3, layoutParams4);
        this.mAgeAppropriateView = textView3;
        TextView textView4 = new TextView(context);
        textView4.setTextSize(0, Utils.dp2px(12.0f));
        if (ViewUtils.isDarkMode()) {
            i18 = -35310;
        } else {
            i18 = -39665;
        }
        textView4.setTextColor(i18);
        textView4.setSingleLine(true);
        textView4.setVisibility(0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = (int) Utils.dp2px(8.0f);
        linearLayout2.addView(textView4, layoutParams5);
        this.mTipsView = textView4;
        DownloadButton downloadButton = new DownloadButton(context);
        downloadButton.setProgress(100.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, (int) Utils.dp2px(48.0f));
        int dp2px2 = (int) Utils.dp2px(24.0f);
        layoutParams6.leftMargin = dp2px2;
        layoutParams6.rightMargin = dp2px2;
        layoutParams6.topMargin = (int) Utils.dp2px(8.0f);
        linearLayout2.addView(downloadButton, layoutParams6);
        this.mDownloadButton = downloadButton;
        TextView textView5 = new TextView(context);
        textView5.setTextSize(0, Utils.dp2px(14.0f));
        textView5.setTextColor(COLOR_APP_VERSION);
        textView5.setSingleLine(true);
        textView5.getPaint().setFakeBoldText(true);
        textView5.setVisibility(8);
        this.mCancelTextView = textView5;
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = (int) Utils.dp2px(14.0f);
        linearLayout2.addView(textView5, layoutParams7);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(81);
        linearLayout3.setPadding(0, 0, 0, (int) Utils.dp2px(34.0f));
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -1));
        TextView textView6 = new TextView(context);
        textView6.setTextSize(0, Utils.dp2px(13.0f));
        if (ViewUtils.isDarkMode()) {
            i19 = -7697782;
        } else {
            i19 = -6710887;
        }
        textView6.setTextColor(i19);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f));
        layoutParams8.bottomMargin = (int) Utils.dp2px(2.0f);
        linearLayout3.addView(textView6, layoutParams8);
        this.mAuthorNameView = textView6;
        TextView textView7 = new TextView(context);
        textView7.setTextSize(0, Utils.dp2px(13.0f));
        if (ViewUtils.isDarkMode()) {
            i26 = -7697782;
        } else {
            i26 = -6710887;
        }
        textView7.setTextColor(i26);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f));
        layoutParams9.bottomMargin = (int) Utils.dp2px(2.0f);
        linearLayout3.addView(textView7, layoutParams9);
        this.mDeveloperNameView = textView7;
        TextView textView8 = new TextView(context);
        textView8.setTextSize(0, Utils.dp2px(13.0f));
        if (!ViewUtils.isDarkMode()) {
            i27 = -6710887;
        }
        textView8.setTextColor(i27);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f));
        layoutParams10.bottomMargin = (int) Utils.dp2px(2.0f);
        linearLayout3.addView(textView8, layoutParams10);
        this.mICPView = textView8;
        linearLayout3.addView(createPermissionAndAgreement(context), new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f)));
        return linearLayout;
    }

    private View createPermissionAndAgreement(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, (int) Utils.dp2px(20.0f)));
        this.mPermissionAndAgreementContainer = linearLayout;
        TextView textView = new TextView(context);
        textView.setText(FEATURELIST);
        textView.setTextSize(0, Utils.dp2px(13.0f));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        this.mFeatureListView = textView;
        View createSplitView = createSplitView(context);
        this.mFeatureListSplitView = createSplitView;
        linearLayout.addView(createSplitView);
        TextView textView2 = new TextView(context);
        textView2.setText(PERMISSION);
        textView2.setTextSize(0, Utils.dp2px(13.0f));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        this.mPermissionView = textView2;
        linearLayout.addView(createSplitView(context));
        TextView textView3 = new TextView(context);
        textView3.setText(AGREEMENT);
        textView3.setTextSize(0, Utils.dp2px(13.0f));
        linearLayout.addView(textView3);
        this.mAgreementView = textView3;
        return linearLayout;
    }

    private View createSplitView(Context context) {
        int i3;
        View view = new View(context);
        if (ViewUtils.isDarkMode()) {
            i3 = COLOR_APP_VERSION_DARK;
        } else {
            i3 = 570425344;
        }
        view.setBackgroundColor(i3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) Utils.dp2px(1.0f), (int) Utils.dp2px(12.0f));
        int dp2px = (int) Utils.dp2px(12.0f);
        layoutParams.leftMargin = dp2px;
        layoutParams.rightMargin = dp2px;
        layoutParams.topMargin = (int) Utils.dp2px(1.0f);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private DownloadWebView createWebView(Context context) {
        DownloadWebView downloadWebView = new DownloadWebView(context);
        downloadWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        downloadWebView.setVisibility(4);
        this.mAgreementWebView = downloadWebView;
        return downloadWebView;
    }

    private void handlerClick() {
        DownloadStatus downloadStatus;
        if (this.mDownloadInfo == null) {
            return;
        }
        int i3 = this.mClickViewType;
        if (i3 == 9) {
            this.mFeatureListWebView.setTitle(FEATURELIST);
            this.mFeatureListWebView.setVisibility(0);
            DownloadCardListener downloadCardListener = this.mListener;
            if (downloadCardListener != null) {
                downloadCardListener.onFeatureListWebViewShow();
                return;
            }
            return;
        }
        if (i3 == 5) {
            this.mPermissionWebView.setTitle(PERMISSION);
            this.mPermissionWebView.setVisibility(0);
            DownloadCardListener downloadCardListener2 = this.mListener;
            if (downloadCardListener2 != null) {
                downloadCardListener2.onPermissionWebViewShow();
                return;
            }
            return;
        }
        if (i3 == 6) {
            this.mAgreementWebView.setTitle(AGREEMENT);
            this.mAgreementWebView.setVisibility(0);
            DownloadCardListener downloadCardListener3 = this.mListener;
            if (downloadCardListener3 != null) {
                downloadCardListener3.onAgreementWebViewShow();
                return;
            }
            return;
        }
        if (i3 == 10) {
            if (this.mDownloadStatus.getStatus() == 1) {
                DownloadHandler downloadHandler = this.mDownloadHandler;
                if (downloadHandler != null) {
                    downloadHandler.pauseDownload(this.mDownloadInfo);
                }
                setCancelTextViewVisible(true, "\u53d6\u6d88\u4efb\u52a1");
                return;
            }
            if (this.mDownloadStatus.getStatus() == 2) {
                DownloadCancelView downloadCancelView = this.mCancelView;
                if (downloadCancelView != null) {
                    downloadCancelView.show();
                }
                DownloadCardListener downloadCardListener4 = this.mListener;
                if (downloadCardListener4 != null) {
                    downloadCardListener4.onCancelViewShow();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 8 && (downloadStatus = this.mDownloadStatus) != null && this.mDownloadHandler != null) {
            int status = downloadStatus.getStatus();
            if (status != 0) {
                if (status != 2) {
                    if (status != 3) {
                        if (status != 5) {
                            if (status != 6) {
                                if (status != 7) {
                                    return;
                                }
                            }
                        } else {
                            this.mDownloadHandler.openApp(this.mDownloadInfo);
                            DownloadCardListener downloadCardListener5 = this.mListener;
                            if (downloadCardListener5 != null) {
                                downloadCardListener5.onOpenAppClick();
                                return;
                            }
                            return;
                        }
                    }
                    this.mDownloadHandler.installApp(this.mDownloadInfo);
                    DownloadCardListener downloadCardListener6 = this.mListener;
                    if (downloadCardListener6 != null) {
                        downloadCardListener6.onStartInstallClick();
                        return;
                    }
                    return;
                }
                this.mDownloadHandler.resumeDownload(this.mDownloadInfo);
                DownloadCardListener downloadCardListener7 = this.mListener;
                if (downloadCardListener7 != null) {
                    downloadCardListener7.onResumeDownloadClick();
                }
                setCancelTextViewVisible(true, "\u53d6\u6d88\u4e0b\u8f7d");
                return;
            }
            this.mDownloadHandler.startDownload(this.mDownloadInfo);
            DownloadCardListener downloadCardListener8 = this.mListener;
            if (downloadCardListener8 != null) {
                downloadCardListener8.onStartDownloadClick();
            }
            setCancelTextViewVisible(true, "\u53d6\u6d88\u4e0b\u8f7d");
            setTipsToastVisibility(4);
        }
    }

    private void initView(Context context) {
        addView(createContentView(context));
        addView(createCloseView(context));
        addWebViews(context);
        addView(createCancelView(context));
        setBackgroundColor(-1);
    }

    private boolean isTouchInView(View view, float f16, float f17) {
        float xInRootView = Utils.getXInRootView(view, this);
        float yInRootView = Utils.getYInRootView(view, this);
        RectF rectF = new RectF();
        rectF.left = xInRootView;
        rectF.right = xInRootView + view.getWidth();
        rectF.top = yInRootView;
        rectF.bottom = yInRootView + view.getHeight();
        return rectF.contains((int) f16, (int) f17);
    }

    private boolean isViewVisible(View view) {
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCancelTextViewVisible(boolean z16, String str) {
        TextView textView = this.mCancelTextView;
        if (textView == null) {
            return;
        }
        if (!z16 && textView.getVisibility() == 8) {
            return;
        }
        if (z16 && this.mCancelTextView.getVisibility() == 0 && str != null && str.contentEquals(this.mCancelTextView.getText())) {
            return;
        }
        this.mCancelTextView.post(new Runnable(z16, str) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$show;
            final /* synthetic */ String val$text;

            {
                this.val$show = z16;
                this.val$text = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DownloadCardView.this, Boolean.valueOf(z16), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TextView textView2 = DownloadCardView.this.mCancelTextView;
                    if (this.val$show) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    textView2.setVisibility(i3);
                    String str2 = this.val$text;
                    if (str2 != null && !str2.contentEquals(DownloadCardView.this.mCancelTextView.getText())) {
                        DownloadCardView.this.mCancelTextView.setText(this.val$text);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private void setTipsToastVisibility(int i3) {
        TextView textView = this.mTipsView;
        if (textView != null && i3 != textView.getVisibility()) {
            this.mTipsView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipsToast(String str) {
        if (this.mTipsView != null && !TextUtils.isEmpty(str)) {
            this.mTipsView.setAlpha(0.0f);
            this.mTipsView.setText(str);
            AnimatorSet animatorSet = this.mTipShowHideAnimator;
            if (animatorSet == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTipsView, c.f123400v, 0.0f, 1.0f);
                try {
                    ofFloat.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
                } catch (Throwable unused) {
                }
                ofFloat.setDuration(160L);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mTipsView, c.f123400v, 1.0f, 0.0f);
                ofFloat2.setDuration(160L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(ofFloat2).after(ofFloat).after(3000L);
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardView.this);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                        } else {
                            DownloadCardView.this.mTipsView.setText("");
                            DownloadCardView.this.mTipsView.setVisibility(4);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                        } else {
                            DownloadCardView.this.mTipsView.setVisibility(0);
                        }
                    }
                });
                animatorSet = animatorSet2;
            } else {
                animatorSet.cancel();
            }
            this.mTipShowHideAnimator = animatorSet;
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadButtonStatus(DownloadStatus downloadStatus) {
        if (downloadStatus == null) {
            return;
        }
        this.mDownloadStatus = downloadStatus;
        if (this.mDownloadButton == null) {
            return;
        }
        String str = "\u7acb\u5373\u4e0b\u8f7d";
        if (downloadStatus.getStatus() == 0) {
            setCancelTextViewVisible(false, null);
        } else if (downloadStatus.getStatus() == 1) {
            str = Math.min(100, Math.round(downloadStatus.getProgress())) + "%";
        } else if (downloadStatus.getStatus() == 2) {
            setCancelTextViewVisible(true, "\u53d6\u6d88\u4efb\u52a1");
            str = "\u7ee7\u7eed\u4e0b\u8f7d";
        } else if (downloadStatus.getStatus() != 3 && downloadStatus.getStatus() != 6) {
            if (downloadStatus.getStatus() == 5) {
                setCancelTextViewVisible(false, null);
                str = "\u6253\u5f00\u5e94\u7528";
            } else if (downloadStatus.getStatus() == 7) {
                setCancelTextViewVisible(false, null);
            }
        } else {
            setCancelTextViewVisible(false, null);
            DownloadInfo downloadInfo = this.mDownloadInfo;
            if (downloadInfo != null && this.mDownloadHandler != null && downloadInfo.isManualInstall()) {
                this.mDownloadHandler.installApp(this.mDownloadInfo);
            }
            str = "\u7acb\u5373\u5b89\u88c5";
        }
        this.mDownloadButton.setText(str);
        this.mDownloadButton.setProgress(downloadStatus.getProgress());
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        DownloadWebView downloadWebView = this.mFeatureListWebView;
        if (downloadWebView != null) {
            downloadWebView.destroy();
        }
        DownloadWebView downloadWebView2 = this.mAgreementWebView;
        if (downloadWebView2 != null) {
            downloadWebView2.destroy();
        }
        DownloadWebView downloadWebView3 = this.mPermissionWebView;
        if (downloadWebView3 != null) {
            downloadWebView3.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 9;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        DownloadCancelView downloadCancelView = this.mCancelView;
        if (downloadCancelView != null && downloadCancelView.getVisibility() == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (isTouchInView(this.mCloseView, x16, y16)) {
                i3 = 7;
            } else {
                if (isShowingWebView()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (isTouchInView(this.mAppIconView, x16, y16)) {
                    i3 = 1;
                } else if (isTouchInView(this.mAppNameView, x16, y16)) {
                    i3 = 2;
                } else if (isTouchInView(this.mAppVersionView, x16, y16)) {
                    i3 = 3;
                } else if (isTouchInView(this.mAuthorNameView, x16, y16)) {
                    i3 = 4;
                } else if (isTouchInView(this.mPermissionAndAgreementContainer, x16, y16)) {
                    if (!isTouchInView(this.mFeatureListView, x16, y16)) {
                        if (isTouchInView(this.mPermissionView, x16, y16)) {
                            i3 = 5;
                        } else {
                            if (isTouchInView(this.mAgreementView, x16, y16)) {
                                i3 = 6;
                            }
                            i3 = 0;
                        }
                    }
                } else if (isTouchInView(this.mDownloadButton, x16, y16)) {
                    i3 = 8;
                } else if (isTouchInView(this.mCancelTextView, x16, y16)) {
                    i3 = 10;
                } else if (isTouchInView(this.mAgeAppropriateView, x16, y16)) {
                    i3 = 11;
                } else {
                    if (isTouchInView(this.mDeveloperNameView, x16, y16)) {
                        i3 = 12;
                    }
                    i3 = 0;
                }
            }
            this.mClickViewType = i3;
            this.mClickX = x16;
            this.mClickY = y16;
            return true;
        }
        if (motionEvent.getAction() == 1) {
            DownloadCardListener downloadCardListener = this.mListener;
            if (downloadCardListener != null) {
                downloadCardListener.onViewClick(this.mClickViewType, this.mClickX, this.mClickY);
                Logger.d(TAG, "onViewClick - viewType:" + this.mClickViewType + ", x:" + this.mClickX + ", y:" + this.mClickY);
            }
            handlerClick();
            this.mClickViewType = 0;
            this.mClickX = 0.0f;
            this.mClickY = 0.0f;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        DownloadHandler downloadHandler = this.mDownloadHandler;
        if (downloadHandler == null) {
            Logger.w(TAG, "startDownload failed: download handler not set");
            return;
        }
        DownloadInfo downloadInfo = this.mDownloadInfo;
        if (downloadInfo == null) {
            Logger.w(TAG, "startDownload failed: download info not set");
            return;
        }
        downloadHandler.unregisterDownloadStatusChangeListener(downloadInfo);
        DownloadCardListener downloadCardListener = this.mListener;
        if (downloadCardListener != null) {
            downloadCardListener.onViewDismiss();
        }
    }

    public boolean isShowingWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!isViewVisible(this.mFeatureListWebView) && !isViewVisible(this.mAgreementWebView) && !isViewVisible(this.mPermissionWebView)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler.DownloadStatusChangeListener
    public void onStatusChange(DownloadInfo downloadInfo, DownloadStatus downloadStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) downloadInfo, (Object) downloadStatus);
        } else {
            Utils.runOnUiThread(new Runnable(downloadStatus) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ DownloadStatus val$status;

                {
                    this.val$status = downloadStatus;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadCardView.this, (Object) downloadStatus);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DownloadCardView.this.updateDownloadButtonStatus(this.val$status);
                        if (this.val$status.getStatus() == 7) {
                            DownloadCardView.this.showTipsToast("\u4e0b\u8f7d\u5931\u8d25");
                            return;
                        } else {
                            if (this.val$status.getStatus() == 1) {
                                DownloadCardView.this.setCancelTextViewVisible(true, "\u53d6\u6d88\u4e0b\u8f7d");
                                return;
                            }
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setDownloadHandler(DownloadHandler downloadHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadHandler);
            return;
        }
        this.mDownloadHandler = downloadHandler;
        DownloadCancelView downloadCancelView = this.mCancelView;
        if (downloadCancelView != null) {
            downloadCancelView.setDownloadHandler(downloadHandler);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDownloadInfo(DownloadInfo downloadInfo) {
        boolean z16;
        DownloadWebView downloadWebView;
        DownloadWebView downloadWebView2;
        DownloadCancelView downloadCancelView;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadInfo);
            return;
        }
        if (downloadInfo == null) {
            Logger.w(TAG, "downloadInfo must be not null!");
            return;
        }
        this.mDownloadInfo = downloadInfo;
        TextView textView = this.mAppNameView;
        if (textView != null) {
            textView.setText(downloadInfo.getAppName());
        }
        TextView textView2 = this.mAppVersionView;
        if (textView2 != null) {
            textView2.setText(this.mDownloadInfo.getAppVersion());
        }
        TextView textView3 = this.mAuthorNameView;
        if (textView3 != null) {
            textView3.setText(this.mDownloadInfo.getAuthorName());
        }
        boolean z17 = true;
        if (this.mAgeAppropriateView != null) {
            if (!TextUtils.isEmpty(this.mDownloadInfo.getAgeAppropriate())) {
                this.mAgeAppropriateView.setText(this.mDownloadInfo.getAgeAppropriate());
                this.mAgeAppropriateView.setVisibility(0);
                z16 = true;
                if (this.mDeveloperNameView != null) {
                    if (!TextUtils.isEmpty(this.mDownloadInfo.getDeveloperName()) && !this.mDownloadInfo.getDeveloperName().equals(this.mDownloadInfo.getAuthorName())) {
                        this.mDeveloperNameView.setText(this.mDownloadInfo.getDeveloperName());
                        this.mDeveloperNameView.setVisibility(0);
                        if (this.mICPView != null) {
                            if (!TextUtils.isEmpty(this.mDownloadInfo.getICP())) {
                                this.mICPView.setText(this.mDownloadInfo.getICP());
                                this.mICPView.setVisibility(0);
                            } else {
                                this.mICPView.setVisibility(8);
                            }
                        }
                        if (!TextUtils.isEmpty(this.mDownloadInfo.getFeatureListUrl())) {
                            DownloadWebView downloadWebView3 = this.mFeatureListWebView;
                            if (downloadWebView3 != null) {
                                downloadWebView3.loadUrl(this.mDownloadInfo.getFeatureListUrl());
                            }
                        } else {
                            this.mFeatureListView.setVisibility(8);
                            this.mFeatureListSplitView.setVisibility(8);
                        }
                        downloadWebView = this.mPermissionWebView;
                        if (downloadWebView != null) {
                            downloadWebView.loadUrl(this.mDownloadInfo.getPermissionsUrl());
                        }
                        downloadWebView2 = this.mAgreementWebView;
                        if (downloadWebView2 != null) {
                            downloadWebView2.loadUrl(this.mDownloadInfo.getAgreementUrl());
                        }
                        downloadCancelView = this.mCancelView;
                        if (downloadCancelView != null) {
                            downloadCancelView.setDownloadInfo(downloadInfo);
                        }
                        updateDownloadButtonStatus(this.mDownloadInfo.getInitDownloadStatus());
                        layoutParams = getLayoutParams();
                        if (layoutParams != null && (i3 = layoutParams.height) != -1 && i3 != -2) {
                            if (z16) {
                                layoutParams.height = i3 + ((int) Utils.dp2px(20.0f));
                            }
                            if (z17) {
                                layoutParams.height += (int) Utils.dp2px(20.0f);
                            }
                            setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    this.mDeveloperNameView.setVisibility(8);
                }
                z17 = false;
                if (this.mICPView != null) {
                }
                if (!TextUtils.isEmpty(this.mDownloadInfo.getFeatureListUrl())) {
                }
                downloadWebView = this.mPermissionWebView;
                if (downloadWebView != null) {
                }
                downloadWebView2 = this.mAgreementWebView;
                if (downloadWebView2 != null) {
                }
                downloadCancelView = this.mCancelView;
                if (downloadCancelView != null) {
                }
                updateDownloadButtonStatus(this.mDownloadInfo.getInitDownloadStatus());
                layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    return;
                } else {
                    return;
                }
            }
            this.mAgeAppropriateView.setVisibility(8);
        }
        z16 = false;
        if (this.mDeveloperNameView != null) {
        }
        z17 = false;
        if (this.mICPView != null) {
        }
        if (!TextUtils.isEmpty(this.mDownloadInfo.getFeatureListUrl())) {
        }
        downloadWebView = this.mPermissionWebView;
        if (downloadWebView != null) {
        }
        downloadWebView2 = this.mAgreementWebView;
        if (downloadWebView2 != null) {
        }
        downloadCancelView = this.mCancelView;
        if (downloadCancelView != null) {
        }
        updateDownloadButtonStatus(this.mDownloadInfo.getInitDownloadStatus());
        layoutParams = getLayoutParams();
        if (layoutParams != null) {
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setListener(DownloadCardListener downloadCardListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadCardListener);
        } else {
            this.mListener = downloadCardListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setThemeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mThemeColor = i3;
        int buildColorWithAlphaRatio = Utils.buildColorWithAlphaRatio(0.8f, i3);
        TextView textView = this.mFeatureListView;
        if (textView != null) {
            textView.setTextColor(buildColorWithAlphaRatio);
        }
        TextView textView2 = this.mPermissionView;
        if (textView2 != null) {
            textView2.setTextColor(buildColorWithAlphaRatio);
        }
        TextView textView3 = this.mAgreementView;
        if (textView3 != null) {
            textView3.setTextColor(buildColorWithAlphaRatio);
        }
        DownloadButton downloadButton = this.mDownloadButton;
        if (downloadButton != null) {
            downloadButton.setThemeColor(i3);
        }
        DownloadCancelView downloadCancelView = this.mCancelView;
        if (downloadCancelView != null) {
            downloadCancelView.setThemeColor(i3);
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        DownloadHandler downloadHandler = this.mDownloadHandler;
        if (downloadHandler == null) {
            Logger.w(TAG, "startDownload failed: download handler not set");
            return;
        }
        DownloadInfo downloadInfo = this.mDownloadInfo;
        if (downloadInfo == null) {
            Logger.w(TAG, "startDownload failed: download info not set");
        } else {
            downloadHandler.getDownloadStatus(downloadInfo, new DownloadHandler.DownloadStatusGetter(downloadHandler, downloadInfo) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DownloadHandler val$handler;
                final /* synthetic */ DownloadInfo val$info;

                {
                    this.val$handler = downloadHandler;
                    this.val$info = downloadInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DownloadCardView.this, downloadHandler, downloadInfo);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler.DownloadStatusGetter
                public void onGetStatus(DownloadStatus downloadStatus) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) downloadStatus);
                    } else {
                        DownloadCardView.this.post(new Runnable(downloadStatus) { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardView.1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ DownloadStatus val$status;

                            {
                                this.val$status = downloadStatus;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) downloadStatus);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    DownloadCardView.this.updateDownloadButtonStatus(this.val$status);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    anonymousClass1.val$handler.registerDownloadStatusChangeListener(anonymousClass1.val$info, DownloadCardView.this);
                                    if (this.val$status.getStatus() == 0 && AnonymousClass1.this.val$info.isAutoDownload()) {
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        anonymousClass12.val$handler.startDownload(anonymousClass12.val$info);
                                    } else if (this.val$status.getStatus() == 2 && AnonymousClass1.this.val$info.isAutoDownload()) {
                                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                        anonymousClass13.val$handler.resumeDownload(anonymousClass13.val$info);
                                    } else if (this.val$status.getStatus() == 3 && AnonymousClass1.this.val$info.isManualInstall()) {
                                        AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                        anonymousClass14.val$handler.installApp(anonymousClass14.val$info);
                                    }
                                    if (DownloadCardView.this.mAppIconView != null) {
                                        if (AnonymousClass1.this.val$info.getAppIcon() != null) {
                                            DownloadCardView.this.mAppIconView.setImageBitmap(AnonymousClass1.this.val$info.getAppIcon());
                                        } else {
                                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                            anonymousClass15.val$handler.displayImage(anonymousClass15.val$info.getAppIconUrl(), DownloadCardView.this.mAppIconView);
                                        }
                                    }
                                    if (DownloadCardView.this.mDownloadHandler.getNetWorkType() != 5) {
                                        DownloadCardView.this.showTipsToast("\u5f53\u524d\u4e3a\u975eWIFI\u60c5\u51b5\u4e0b\u8f7d");
                                    }
                                    if (DownloadCardView.this.mListener != null) {
                                        DownloadCardView.this.mListener.onViewShow();
                                        return;
                                    }
                                    return;
                                }
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        });
                    }
                }
            });
        }
    }
}
