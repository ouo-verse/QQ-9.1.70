package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LoadingUI extends BaseGameLoadingView {
    public static final String TAG = "LoadingUI";
    private MiniAppProxy.IDrawableLoadedCallBack iconCallback;
    int iconSize;
    private boolean isForeground;
    private LinearLayout mBottonLayout;
    private LinearLayout mCenterLayout;
    private ImageView mCloseView;
    private LinearLayout mDeveloperDescLayout;
    private TextView mDeveloperDescView;
    private LinearLayout mGameCopyRightLayout;
    private TextView mGameCopyrightInfo;
    private ImageView mGameFakeFirstFrame;
    private RelativeLayout mGameFakeFirstFrameDownLoadRect;
    private TextView mGameFakeFrameGameName;
    private ProgressBar mGameFakeFrameProgres;
    private TextView mGameFakeFrameProgressText;
    private SquareImageView mGameFakeGameLogo;
    private TextView mGameInstruction;
    private TextView mGameVersionDesc;
    private TextView mJumpBtn;
    private SquareImageView mLogoView;
    private MiniAppInfo mMiniAppInfo;
    private ImageView mMoreView;
    private TextView mNameView;
    private String mProgressStr;
    private TextView mProgressTxt;
    private LinearLayout mSplashLayout;
    private boolean mSplashLoadComplete;
    private ProgressBar mSplashProgressBar;
    private TextView mSplashProgressTxt;
    private ImageView mStartView;
    private View mStatusBar;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class a implements MiniAppProxy.IDrawableLoadedCallBack {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ WeakReference a(a aVar) {
            throw null;
        }
    }

    public LoadingUI(Context context) {
        this(context, null);
    }

    private void checkShowFakeFirstFrame() {
        String fakeFristFrameUrlByAppid = getFakeFristFrameUrlByAppid(GameWnsUtils.getFakeFristFrameUrl(), this.mMiniAppInfo.appId);
        if (!TextUtils.isEmpty(fakeFristFrameUrlByAppid) || URLUtil.isValidUrl(fakeFristFrameUrlByAppid)) {
            try {
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                Drawable drawable = getContext().getResources().getDrawable(R.color.transparent);
                Drawable drawable2 = miniAppProxy.getDrawable(getContext(), fakeFristFrameUrlByAppid, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, drawable);
                if (drawable2 != null) {
                    drawable = drawable2;
                }
                this.mGameFakeFirstFrame.setImageDrawable(drawable);
                miniAppProxy.setDrawableCallback(drawable, new MiniAppProxy.IDrawableLoadedCallBack() { // from class: com.tencent.qqmini.minigame.ui.LoadingUI.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack
                    public void onLoadSuccessed(Drawable drawable3) {
                        LoadingUI.this.mGameFakeFirstFrameDownLoadRect.setVisibility(0);
                        LoadingUI.this.mBottonLayout.setVisibility(8);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private String getFakeFristFrameUrlByAppid(String str, String str2) {
        String[] split;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (split = str.split(";")) != null && split.length > 0) {
                for (String str3 : split) {
                    String[] split2 = str3.split("\\|\\|");
                    if (split2 != null && split2.length == 2 && str2.equals(split2[0])) {
                        return split2[1];
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void initUIComponents() {
        try {
            View.inflate(getContext(), R.layout.mini_sdk_game_loading_layout, this);
            this.mStatusBar = findViewById(R.id.status_bar);
            this.mGameInstruction = (TextView) findViewById(R.id.game_instruction);
            this.mGameVersionDesc = (TextView) findViewById(R.id.game_version_desc);
            this.mGameCopyrightInfo = (TextView) findViewById(R.id.game_copyright_info);
            this.mGameCopyRightLayout = (LinearLayout) findViewById(R.id.game_copyright);
            this.mJumpBtn = (TextView) findViewById(R.id.jump_btn);
            this.mMoreView = (ImageView) findViewById(R.id.btn_more_menu);
            this.mCloseView = (ImageView) findViewById(R.id.btn_close);
            this.mNameView = (TextView) findViewById(R.id.game_name);
            this.mDeveloperDescView = (TextView) findViewById(R.id.developer_desc);
            this.mDeveloperDescLayout = (LinearLayout) findViewById(R.id.developer_desc_layout);
            SquareImageView squareImageView = (SquareImageView) findViewById(R.id.logo_mask);
            this.mLogoView = squareImageView;
            squareImageView.setRoundRect(this.iconSize);
            this.mBottonLayout = (LinearLayout) findViewById(R.id.bottom_layout);
            this.mGameFakeFirstFrameDownLoadRect = (RelativeLayout) findViewById(R.id.minigame_fakecover_rect);
            this.mGameFakeFirstFrame = (ImageView) findViewById(R.id.game_fake_firstframe);
            this.mGameFakeFrameProgres = (ProgressBar) findViewById(R.id.minigame_fakecover_progressbar);
            this.mGameFakeFrameProgressText = (TextView) findViewById(R.id.minigame_fakecover_progresstext);
            this.mGameFakeFrameGameName = (TextView) findViewById(R.id.minigame_fakecover_gamename);
            SquareImageView squareImageView2 = (SquareImageView) findViewById(R.id.minigame_fakecover_gamelogo);
            this.mGameFakeGameLogo = squareImageView2;
            squareImageView2.setRoundRect(10);
            this.mProgressTxt = (TextView) findViewById(R.id.txt_download_progress);
            this.mSplashProgressTxt = (TextView) findViewById(R.id.splash_txt_download_progress);
            this.mSplashProgressBar = (ProgressBar) findViewById(R.id.splash_launch_progress);
            setImportantForAccessibility(2);
        } catch (Exception e16) {
            QMLog.e(TAG, "initUIComponents crashed.", e16);
        }
    }

    private boolean isInterLoadingMode() {
        return true;
    }

    private void onResume() {
        this.isForeground = true;
        TextView textView = this.mProgressTxt;
        if (textView == null) {
            return;
        }
        textView.setText(this.mProgressStr);
        this.mSplashProgressTxt.setText(this.mProgressStr);
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            this.mNameView.setText(miniAppInfo.name);
            this.mGameFakeFrameGameName.setText(this.mMiniAppInfo.name);
            showGameCopyRight();
            showDeveloperDesc();
            showGameVersionDesc();
            if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                Drawable drawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_default_icon);
                Context context = getContext();
                SquareImageView squareImageView = this.mLogoView;
                String str = this.mMiniAppInfo.iconUrl;
                int i3 = this.iconSize;
                miniAppProxy.loadImage(context, squareImageView, str, i3, i3, drawable, drawable);
                Context context2 = getContext();
                SquareImageView squareImageView2 = this.mGameFakeGameLogo;
                String str2 = this.mMiniAppInfo.iconUrl;
                int i16 = this.iconSize;
                miniAppProxy.loadImage(context2, squareImageView2, str2, i16, i16, drawable, drawable);
            }
            checkShowFakeFirstFrame();
        }
    }

    private void onStop() {
        this.isForeground = false;
        setVisibility(8);
    }

    private void showDeveloperDesc() {
        if (TextUtils.isEmpty(this.mMiniAppInfo.developerDesc)) {
            this.mDeveloperDescLayout.setVisibility(8);
            return;
        }
        this.mDeveloperDescLayout.setVisibility(0);
        this.mDeveloperDescView.setText("\u7531" + this.mMiniAppInfo.developerDesc + "\u63d0\u4f9b");
    }

    private void showGameCopyRight() {
        if (!TextUtils.isEmpty(this.mMiniAppInfo.gameRegistrationNumber)) {
            this.mGameCopyRightLayout.setVisibility(0);
            this.mGameCopyrightInfo.setText("\u5907\u6848\u53f7\uff1a" + this.mMiniAppInfo.gameRegistrationNumber);
            return;
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.gameCopyrightInfo)) {
            this.mGameCopyRightLayout.setVisibility(0);
            this.mGameCopyrightInfo.setText(this.mMiniAppInfo.gameCopyrightInfo);
        } else {
            this.mGameCopyRightLayout.setVisibility(8);
        }
    }

    private void showGameVersionDesc() {
        ArrayList<String> arrayList = this.mMiniAppInfo.qualifications;
        if (arrayList != null && arrayList.size() > 0) {
            this.mDeveloperDescLayout.setVisibility(8);
            this.mGameVersionDesc.setVisibility(0);
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.mMiniAppInfo.qualifications.size(); i3++) {
                if (i3 > 0 && !TextUtils.isEmpty(this.mMiniAppInfo.qualifications.get(i3 - 1))) {
                    sb5.append("\n");
                }
                if (!TextUtils.isEmpty(this.mMiniAppInfo.qualifications.get(i3))) {
                    sb5.append(this.mMiniAppInfo.qualifications.get(i3));
                }
            }
            this.mGameVersionDesc.setText(sb5.toString());
            return;
        }
        this.mGameVersionDesc.setVisibility(4);
    }

    private void showStartView() {
        this.mSplashProgressBar.setVisibility(8);
        this.mSplashProgressTxt.setVisibility(8);
        this.mStartView.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void hide() {
        onStop();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public BaseGameLoadingView initUIData(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
        return this;
    }

    public boolean isForeground() {
        return this.isForeground;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressInt(float f16) {
        ProgressBar progressBar = this.mGameFakeFrameProgres;
        if (progressBar != null) {
            progressBar.setProgress((int) (f16 * 100.0f));
        }
        TextView textView = this.mGameFakeFrameProgressText;
        if (textView != null) {
            textView.setText(((int) (f16 * 100.0f)) + "%");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressTxt(String str) {
        TextView textView = this.mProgressTxt;
        if (textView != null) {
            textView.setText(str);
        }
        this.mProgressStr = str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void show(ViewGroup viewGroup) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        viewGroup.addView(this);
        onResume();
    }

    public LoadingUI(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingUI(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.iconSize = DisplayUtil.dip2px(getContext(), 100.0f);
        this.mProgressStr = "0%";
        this.mSplashLoadComplete = false;
        this.isForeground = false;
        initUIComponents();
    }
}
