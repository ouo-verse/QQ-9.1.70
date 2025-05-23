package com.tencent.mobileqq.mini.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.WebViewProgressBar;
import com.tencent.qqmini.sdk.widget.WebViewProgressBarController;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMiniAppNavigationBar extends NavigationBar {
    public static final int DEFAULT_ICON_HEIGHT = 23;
    public static final int DEFAULT_ICON_WIDTH = 23;
    private static final String TAG = "GuildMiniAppNavigationBar";
    private static Long mLastClickTime = 0L;
    private ImageView mBackIcon;
    private RelativeLayout mBackIconContainer;
    private TextView mBtnJoin;
    private ImageView mBtnShare;
    protected TextView mCenterMask;
    private RelativeLayout mContainer;
    private WebViewProgressBarController mController;
    private IQQGuildRouterApi.MiniAppJoinGuildDialogCallback mJoinGuildCallback;
    private Drawable mLoadingDrawable;
    private ProgressBar mLoadingProgressBar;
    private SquareImageView mLogoIcon;
    private WebViewProgressBar mProgressBar;
    private View mStatusBarMask;
    private TextView mTitleView;

    public GuildMiniAppNavigationBar(Context context) {
        super(context);
        this.mJoinGuildCallback = getMiniAppJoinGuildDialogCallback();
    }

    private IQQGuildRouterApi.MiniAppJoinGuildDialogCallback getMiniAppJoinGuildDialogCallback() {
        return new IQQGuildRouterApi.MiniAppJoinGuildDialogCallback() { // from class: com.tencent.mobileqq.mini.ui.GuildMiniAppNavigationBar.2
            @Override // com.tencent.mobileqq.guild.api.IQQGuildRouterApi.MiniAppJoinGuildDialogCallback
            public void onGuildCardClick() {
                new CapsuleButtonClickListener(((NavigationBar) GuildMiniAppNavigationBar.this).mNavigationBarCallback.getMiniAppContext()).onCloseClick();
            }
        };
    }

    private boolean isAllowSeeInGuest() {
        long appId = getAppId();
        return appId == 1000205 || appId == 1000225;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - mLastClickTime.longValue();
        if (longValue > 0 && longValue < 800) {
            if (QLog.isColorLevel()) {
                QLog.i("isFastDoubleClick", 2, "time:" + currentTimeMillis + ", mLastClickTIme:" + mLastClickTime + ", timeDiff:" + longValue);
            }
            return true;
        }
        mLastClickTime = Long.valueOf(currentTimeMillis);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMaskIfNeeded$2(View view) {
        if (isFastDoubleClick()) {
            return;
        }
        openJoinGuildDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitView$0(View view) {
        onShareClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitView$1(View view) {
        onJoinClick();
    }

    protected void addMaskIfNeeded() {
        if (isGuest() && !isAllowSeeInGuest()) {
            this.mNavigationBarCallback.getPageRootView().addView(this.mCenterMask);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            layoutParams.addRule(3, getId());
            this.mCenterMask.setLayoutParams(layoutParams);
            this.mCenterMask.bringToFront();
            this.mCenterMask.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMiniAppNavigationBar.this.lambda$addMaskIfNeeded$2(view);
                }
            });
            this.mNavigationBarCallback.getPageRootView().invalidate();
            this.mCenterMask.setVisibility(0);
            return;
        }
        this.mCenterMask.setVisibility(8);
    }

    protected long getAppId() {
        Bundle bundle;
        EntryModel entryModel = getEntryModel();
        if (entryModel == null || (bundle = entryModel.mArguments) == null) {
            return 0L;
        }
        return bundle.getLong("extra_app_id");
    }

    protected String getChannelId() {
        Bundle bundle;
        EntryModel entryModel = getEntryModel();
        if (entryModel == null || (bundle = entryModel.mArguments) == null) {
            return null;
        }
        return bundle.getString("extra_channel_id");
    }

    protected EntryModel getEntryModel() {
        if (this.mNavigationBarCallback.getMiniAppContext().getMiniAppInfo() == null || this.mNavigationBarCallback.getMiniAppContext().getMiniAppInfo().launchParam == null) {
            return null;
        }
        return this.mNavigationBarCallback.getMiniAppContext().getMiniAppInfo().launchParam.entryModel;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void hideLoading() {
        this.mLoadingProgressBar.setVisibility(4);
    }

    protected boolean isGuest() {
        Bundle bundle;
        EntryModel entryModel = getEntryModel();
        if (entryModel == null || (bundle = entryModel.mArguments) == null) {
            return false;
        }
        return bundle.getBoolean("extra_key_is_guest");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QMLog.d(TAG, "onAttachedToWindow called for ");
        addMaskIfNeeded();
    }

    protected void onBackClick() {
        NavigationBar.a aVar;
        if (isFastDoubleClick() || (aVar = this.mNavigationBarCallback) == null) {
            return;
        }
        aVar.onClickBack(this);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    protected void onInitView() {
        LayoutInflater.from(getContext()).inflate(R.layout.dja, this);
        this.mContainer = (RelativeLayout) findViewById(R.id.rjf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.mContainer.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
        this.mContainer.setLayoutParams(layoutParams);
        this.mContainer.setClipChildren(false);
        View findViewById = findViewById(R.id.rjd);
        this.mStatusBarMask = findViewById;
        ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
        layoutParams2.height = DisplayUtil.getStatusBarHeight(getContext());
        this.mStatusBarMask.setLayoutParams(layoutParams2);
        this.mBtnShare = (ImageView) findViewById(R.id.rck);
        this.mBtnJoin = (TextView) findViewById(R.id.rch);
        this.mBackIconContainer = (RelativeLayout) findViewById(R.id.rjh);
        this.mBackIcon = (ImageView) findViewById(R.id.rjg);
        this.mTitleView = (TextView) findViewById(R.id.rje);
        this.mLoadingProgressBar = (ProgressBar) findViewById(R.id.rjc);
        this.mBackIconContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.GuildMiniAppNavigationBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuildMiniAppNavigationBar.this.onBackClick();
            }
        });
        this.mBtnShare.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMiniAppNavigationBar.this.lambda$onInitView$0(view);
            }
        });
        this.mBtnJoin.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMiniAppNavigationBar.this.lambda$onInitView$1(view);
            }
        });
        this.mProgressBar = (WebViewProgressBar) findViewById(R.id.rjb);
        this.mLoadingDrawable = getResources().getDrawable(com.tencent.qqmini.sdk.R.drawable.mini_sdk_common_loading);
        this.mLogoIcon = (SquareImageView) findViewById(R.id.rja);
        this.mTitleView.setText(this.mBarText);
        this.mTitleView.setTextColor(this.mBarTextStyle);
        this.mLoadingProgressBar.setIndeterminateDrawable(this.mLoadingDrawable);
        this.mLoadingProgressBar.setIndeterminate(true);
        this.mLoadingProgressBar.setVisibility(8);
        this.mProgressBar.setVisibility(8);
        if (this.mBarTextStyle == -1) {
            this.mBackIcon.setImageResource(com.tencent.qqmini.sdk.R.drawable.mini_sdk_nav_bar_title_back_img_white);
            this.mBtnShare.setBackgroundResource(R.drawable.ipg);
        } else {
            this.mBackIcon.setImageResource(com.tencent.qqmini.sdk.R.drawable.mini_sdk_nav_bar_title_back_img);
            this.mBtnShare.setBackgroundResource(R.drawable.ipf);
        }
        TextView textView = new TextView(getContext());
        this.mCenterMask = textView;
        textView.setContentDescription("centerMask");
        this.mCenterMask.setBackgroundColor(0);
        this.mCenterMask.setImportantForAccessibility(2);
    }

    protected void onJoinClick() {
        if (isFastDoubleClick()) {
            return;
        }
        sendJoinGuildBroadcast();
        this.mNavigationBarCallback.getMiniAppContext().getAttachActivity().finishAndRemoveTask();
    }

    protected void onShareClick() {
        if (isFastDoubleClick()) {
            return;
        }
        QMLog.i(TAG, "on share click");
        if (TextUtils.isEmpty(LoginManager.getInstance().getAccount())) {
            QMLog.e(TAG, "uin is empty, not show ShareClick. ");
            return;
        }
        GuildMiniAppShareData guildShareData = getGuildShareData(getChannelId());
        if (guildShareData == null) {
            QLog.e(TAG, 1, "share data is null");
            MiniToast.makeText(this.mNavigationBarCallback.getMiniAppContext().getAttachActivity(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        } else {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openChannelSharePanel(this.mNavigationBarCallback.getMiniAppContext().getAttachActivity(), guildShareData);
        }
    }

    public void openJoinGuildDialog() {
        GuildMiniAppShareData guildShareData = getGuildShareData(getChannelId());
        if (guildShareData != null) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openJoinGuildDialogFromMiniApp(guildShareData, this.mJoinGuildCallback);
        }
    }

    protected void sendJoinGuildBroadcast() {
        Intent intent = new Intent();
        intent.setAction("action_join_guild_from_mini_app_channel");
        intent.putExtra("extra_channel_id", getChannelId());
        this.mNavigationBarCallback.getMiniAppContext().getAttachActivity().sendBroadcast(intent);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setNavBackgroundColor(int i3) {
        this.mBackGroundColor = i3;
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i3);
        }
        return this;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setTextStyle(String str) {
        if ("black".equals(str)) {
            this.mBarTextStyle = -16777216;
        } else if ("white".equals(str)) {
            this.mBarTextStyle = -1;
        }
        this.mTitleView.setTextColor(this.mBarTextStyle);
        if (this.mBarTextStyle == -1) {
            this.mBackIcon.setImageResource(com.tencent.qqmini.sdk.R.drawable.mini_sdk_nav_bar_title_back_img_white);
            this.mBtnShare.setBackgroundResource(R.drawable.ipg);
        } else {
            this.mBackIcon.setImageResource(com.tencent.qqmini.sdk.R.drawable.mini_sdk_nav_bar_title_back_img);
            this.mBtnShare.setBackgroundResource(R.drawable.ipf);
        }
        return this;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setTitleTextFromMiniApp(String str) {
        super.setTitleTextFromMiniApp(str);
        this.mTitleView.setText(str);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public boolean shouldContentBelow(String str) {
        return true;
    }

    public void showCustomConfigShareIcon(boolean z16) {
        QMLog.d(TAG, "showCustomConfigShareIcon, isGuest = " + z16);
        if (z16) {
            this.mBtnShare.setVisibility(8);
            this.mBtnJoin.setVisibility(0);
        } else {
            this.mBtnShare.setVisibility(0);
            this.mBtnJoin.setVisibility(8);
        }
    }

    public void showCustomConfigTitleIcon(String str) {
        SquareImageView squareImageView;
        QMLog.d(TAG, "showCustomConfigTitleIcon  url = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = getContext();
        if (context == null) {
            QMLog.d(TAG, "showCustomConfigTitleIcon fail for context is null");
            return;
        }
        Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(context, str, DisplayUtil.dip2px(context, 23.0f), DisplayUtil.dip2px(context, 23.0f), context.getResources().getDrawable(com.tencent.qqmini.sdk.R.drawable.mini_sdk_default_icon));
        if (drawable != null && (squareImageView = this.mLogoIcon) != null) {
            squareImageView.setVisibility(0);
            this.mLogoIcon.setImageDrawable(drawable);
            this.mLogoIcon.setRoundRect(DisplayUtil.dip2px(context, 4.0f));
        } else {
            QMLog.e(TAG, "showLogoIcon load icon error url = " + str);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void showLoading() {
        this.mLoadingProgressBar.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    protected void updateBarStyle() {
        NavigationBarInfo navigationBarInfo = this.barInfo;
        if (navigationBarInfo != null) {
            setNavBackgroundColor(navigationBarInfo.backgoundColor);
            setTextStyle(this.barInfo.textStyle);
        }
        this.mTitleView.setText(this.mBarText);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void updateByMiniAppContext(IMiniAppContext iMiniAppContext) {
        QMLog.i(TAG, "updateByMiniAppContext");
        EntryModel entryModel = getEntryModel();
        if (entryModel != null) {
            showCustomConfigTitleIcon(entryModel.titlebarIconUrl);
            showCustomConfigShareIcon(isGuest());
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void updateProgress(byte b16) {
        WebViewProgressBar webViewProgressBar;
        WebViewProgressBar webViewProgressBar2;
        if (this.mController == null) {
            WebViewProgressBarController webViewProgressBarController = new WebViewProgressBarController();
            this.mController = webViewProgressBarController;
            WebViewProgressBar webViewProgressBar3 = this.mProgressBar;
            if (webViewProgressBar3 != null) {
                webViewProgressBar3.setController(webViewProgressBarController);
                this.mController.setProgressBar(this.mProgressBar);
            }
        }
        if (b16 == 0 && (webViewProgressBar2 = this.mProgressBar) != null) {
            webViewProgressBar2.setVisibility(0);
        }
        if (b16 == 2 && (webViewProgressBar = this.mProgressBar) != null) {
            webViewProgressBar.setVisibility(8);
        }
        this.mController.enterStatus(b16);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setNavBackgroundColor(int i3, long j3, String str) {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(relativeLayout, "backgroundColor", this.mBackGroundColor, i3);
            ofInt.setDuration(j3);
            ofInt.setEvaluator(new ArgbEvaluator());
            if (CanvasView.ACTION_LINER.equals(str)) {
                ofInt.setInterpolator(new LinearInterpolator());
            } else if ("easeIn".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
            } else if ("easeOut".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            } else if ("easeInOut".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
            }
            ofInt.start();
        }
        this.mBackGroundColor = i3;
        return this;
    }

    protected GuildMiniAppShareData getGuildShareData(String str) {
        if (str == null) {
            return null;
        }
        try {
            return (GuildMiniAppShareData) new Gson().fromJson(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getMiniAppGuildShareInfo(str), GuildMiniAppShareData.class);
        } catch (Exception e16) {
            QMLog.d(TAG, "Failed parse gson: " + e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setCapsuleVisible(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setMaskVisible(int i3) {
    }
}
