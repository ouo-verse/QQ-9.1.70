package com.tencent.mobileqq.minigame.ui.loading;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.mini.api.ui.ICustomMiniLoadingView;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.downloadui.loading.LoadingProgressBar;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import com.tencent.xweb.FileReaderHelper;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.libpag.PAGImageView;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\u0012\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\tJ\u0006\u00100\u001a\u00020!J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0016J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0017J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\tH\u0002J\u000e\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0006J\u0010\u0010;\u001a\u00020!2\u0006\u0010.\u001a\u00020<H\u0016J\u0012\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/minigame/ui/loading/MiniGameCustomLoadingView;", "Lcom/tencent/qqmini/sdk/launcher/ui/BaseGameLoadingView;", "Lcom/tencent/mobileqq/mini/api/ui/ICustomMiniLoadingView;", "context", "Landroid/content/Context;", "loadingBgImgUrl", "", "landscapeLoadingBgImgUrl", "isVa", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V", "isLuanchVa", "loadingPagView", "Lorg/libpag/PAGImageView;", "loadingProgressBar", "Lcom/tencent/mobileqq/minigame/va/downloadui/loading/LoadingProgressBar;", "loadingTextView", "Landroid/widget/TextView;", "loadingTipsLayout", "Landroid/widget/RelativeLayout;", "mGameAppId", "mLandscapeLoadingBgImgUrl", "mLandscapeViewHeight", "", "mLandscapeViewWidth", "mLaunchFrom", "mLoadingBg", "Landroid/widget/ImageView;", "mLoadingBgImgUrl", "mMiniAppId", "mViewHeight", "mViewWidth", "hide", "", "init", "initLoadingProgress", "viewRoot", "initUIData", "p0", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "initViewSize", "loadPagAnimation", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLoadProgressChange", "progress", "showInstallTips", "onScreenLandScape", "reportShow", "requestHideFromJavaScript", "setGameAppId", "gameAppId", "setLaunchSource", "from", "setLoadingBg", MiniChatConstants.MINI_APP_LANDSCAPE, "setMiniAppId", "miniAppId", "setProgressInt", "", "setProgressTxt", FileReaderHelper.TXT_EXT, "show", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCustomLoadingView extends BaseGameLoadingView implements ICustomMiniLoadingView {
    public static final int LAUNCH_FROM_MINI_GAME = 0;
    public static final int LAUNCH_FROM_VA_INSTALL = 1;
    public static final String MMKV_KEY_VIEW_HEIGHT = "mini_game_custom_loading_view_height";
    public static final String MMKV_KEY_VIEW_LANDSCAPE_HEIGHT = "mini_game_custom_loading_land_view_height";
    public static final String MMKV_KEY_VIEW_LANDSCAPE_WIDTH = "mini_game_custom_loading_land_view_width";
    public static final String MMKV_KEY_VIEW_WIDTH = "mini_game_custom_loading_view_width";
    private static final String PAG_LOADING_URL = "https://img.gamecenter.qq.com/xgame/gm/1720684324714_6a4b87215d6d35bff5f6fa95ce0e3d01.pag";
    private static final String TAG = "MiniGameCustomLoadingView";
    private final boolean isLuanchVa;
    private PAGImageView loadingPagView;
    private LoadingProgressBar loadingProgressBar;
    private TextView loadingTextView;
    private RelativeLayout loadingTipsLayout;
    private String mGameAppId;
    private String mLandscapeLoadingBgImgUrl;
    private int mLandscapeViewHeight;
    private int mLandscapeViewWidth;
    private int mLaunchFrom;
    private ImageView mLoadingBg;
    private String mLoadingBgImgUrl;
    private String mMiniAppId;
    private int mViewHeight;
    private int mViewWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGameCustomLoadingView(Context context, String loadingBgImgUrl, String landscapeLoadingBgImgUrl, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(loadingBgImgUrl, "loadingBgImgUrl");
        Intrinsics.checkNotNullParameter(landscapeLoadingBgImgUrl, "landscapeLoadingBgImgUrl");
        this.isLuanchVa = z16;
        init(loadingBgImgUrl, landscapeLoadingBgImgUrl);
    }

    private final void init(String loadingBgImgUrl, String landscapeLoadingBgImgUrl) {
        initViewSize();
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            r1 = ((Activity) context).getRequestedOrientation() == 0;
            QLog.i(TAG, 1, "init isLandScape:" + r1);
        }
        this.mLoadingBgImgUrl = loadingBgImgUrl;
        this.mLandscapeLoadingBgImgUrl = landscapeLoadingBgImgUrl;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.djw, this);
        View findViewById = findViewById(R.id.rcs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom_loading_bg)");
        this.mLoadingBg = (ImageView) findViewById;
        setLoadingBg(r1);
        if (this.isLuanchVa) {
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            initLoadingProgress((RelativeLayout) inflate);
        }
    }

    private final void initLoadingProgress(RelativeLayout viewRoot) {
        this.loadingTipsLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (ah.f307408i * 100));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        float f16 = ah.f307408i;
        layoutParams.bottomMargin = (int) (111.0f * f16);
        layoutParams.leftMargin = (int) (f16 * 28.0f);
        layoutParams.rightMargin = (int) (f16 * 28.0f);
        viewRoot.addView(this.loadingTipsLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.loadingTextView = textView;
        textView.setTextColor(-1);
        TextView textView2 = this.loadingTextView;
        if (textView2 != null) {
            textView2.setTextSize(10.0f);
        }
        TextView textView3 = this.loadingTextView;
        if (textView3 != null) {
            textView3.setGravity(17);
        }
        TextView textView4 = this.loadingTextView;
        if (textView4 != null) {
            textView4.setText("");
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, (int) (ah.f307408i * 22));
        layoutParams2.addRule(12);
        layoutParams2.addRule(9);
        RelativeLayout relativeLayout = this.loadingTipsLayout;
        if (relativeLayout != null) {
            relativeLayout.addView(this.loadingTextView, layoutParams2);
        }
        if (MiniGameVAUtil.isPagReady()) {
            this.loadingPagView = new PAGImageView(getContext());
            float f17 = ah.f307408i;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (120 * f17), (int) (f17 * 60));
            layoutParams3.addRule(12);
            layoutParams3.addRule(9);
            layoutParams3.bottomMargin = (int) (ah.f307408i * 35);
            RelativeLayout relativeLayout2 = this.loadingTipsLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.addView(this.loadingPagView, layoutParams3);
            }
            PAGImageView pAGImageView = this.loadingPagView;
            if (pAGImageView != null) {
                pAGImageView.setLayoutParams(layoutParams3);
            }
            loadPagAnimation();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.loadingProgressBar = new LoadingProgressBar(context);
        float M = (float) ah.M();
        float f18 = ah.f307408i;
        int i3 = (int) (M - ((28.0f * f18) * 2));
        int i16 = (int) (f18 * 5);
        LoadingProgressBar loadingProgressBar = this.loadingProgressBar;
        if (loadingProgressBar != null) {
            loadingProgressBar.init(R.drawable.iqm, i3, i16);
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i3, i16);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = (int) (ah.f307408i * 26);
        RelativeLayout relativeLayout3 = this.loadingTipsLayout;
        if (relativeLayout3 != null) {
            relativeLayout3.addView(this.loadingProgressBar, layoutParams4);
        }
        LoadingProgressBar loadingProgressBar2 = this.loadingProgressBar;
        if (loadingProgressBar2 == null) {
            return;
        }
        loadingProgressBar2.setLayoutParams(layoutParams4);
    }

    private final void initViewSize() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(mqq.app.MobileQQ.\u2026QMMKVFile.FILE_MINI_GAME)");
        this.mViewWidth = fromV2.decodeInt(MMKV_KEY_VIEW_WIDTH, 0);
        this.mViewHeight = fromV2.decodeInt(MMKV_KEY_VIEW_HEIGHT, 0);
        this.mLandscapeViewWidth = fromV2.decodeInt(MMKV_KEY_VIEW_LANDSCAPE_WIDTH, 0);
        int decodeInt = fromV2.decodeInt(MMKV_KEY_VIEW_LANDSCAPE_HEIGHT, 0);
        this.mLandscapeViewHeight = decodeInt;
        QLog.i(TAG, 1, "initViewSize mViewWidth:" + this.mViewWidth + ", mViewHeight:" + this.mViewHeight + ", mLandscapeViewWidth:" + this.mLandscapeViewWidth + ", mLandscapeViewHeight:" + decodeInt);
    }

    private final void loadPagAnimation() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.loading.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCustomLoadingView.loadPagAnimation$lambda$2(MiniGameCustomLoadingView.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadPagAnimation$lambda$2(MiniGameCustomLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGImageView pAGImageView = this$0.loadingPagView;
        if (pAGImageView != null) {
            pAGImageView.setComposition(PagViewMonitor.Load(PAG_LOADING_URL));
        }
        PAGImageView pAGImageView2 = this$0.loadingPagView;
        if (pAGImageView2 != null) {
            pAGImageView2.setRepeatCount(-1);
        }
        PAGImageView pAGImageView3 = this$0.loadingPagView;
        if (pAGImageView3 != null) {
            pAGImageView3.play();
        }
    }

    private final void reportShow() {
        if (this.mLaunchFrom == 0) {
            HashMap hashMap = new HashMap();
            String str = this.mMiniAppId;
            if (str == null) {
                str = "";
            }
            hashMap.put("ext2", str);
            MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989316", "8", "", hashMap);
        }
    }

    private final void setLoadingBg(final boolean isLandscape) {
        String str;
        String str2;
        int i3;
        int i16;
        int i17;
        QLog.i(TAG, 1, "setLoadingBg isLandScape:" + isLandscape);
        ImageView imageView = null;
        if (isLandscape) {
            str = this.mLandscapeLoadingBgImgUrl;
            if (str == null) {
                str2 = "mLandscapeLoadingBgImgUrl";
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                str = null;
            }
        } else {
            str = this.mLoadingBgImgUrl;
            if (str == null) {
                str2 = "mLoadingBgImgUrl";
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                str = null;
            }
        }
        int i18 = this.mViewWidth;
        if (i18 != 0 && (i3 = this.mViewHeight) != 0 && (i16 = this.mLandscapeViewWidth) != 0 && (i17 = this.mLandscapeViewHeight) != 0) {
            if (isLandscape) {
                i18 = i16;
            }
            if (isLandscape) {
                i3 = i17;
            }
            Option obtain = Option.obtain();
            ImageView imageView2 = this.mLoadingBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingBg");
                imageView2 = null;
            }
            Option option = obtain.setTargetView(imageView2).setUrl(str).setRequestWidth(i18).setRequestHeight(i3).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        } else {
            Option obtain2 = Option.obtain();
            ImageView imageView3 = this.mLoadingBg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingBg");
                imageView3 = null;
            }
            Option option2 = obtain2.setTargetView(imageView3).setUrl(str).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader2 = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            qQPicLoader2.e(option2, null);
        }
        ImageView imageView4 = this.mLoadingBg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBg");
        } else {
            imageView = imageView4;
        }
        imageView.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.loading.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCustomLoadingView.setLoadingBg$lambda$4(MiniGameCustomLoadingView.this, isLandscape);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLoadingBg$lambda$4(MiniGameCustomLoadingView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mLoadingBg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBg");
            imageView = null;
        }
        int width = imageView.getWidth();
        ImageView imageView3 = this$0.mLoadingBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBg");
        } else {
            imageView2 = imageView3;
        }
        int height = imageView2.getHeight();
        QLog.i(TAG, 1, "setLoadingBg isLandScape:" + z16 + ", width:" + width + ", height:" + height);
        if (z16) {
            if (width == this$0.mLandscapeViewWidth && height == this$0.mLandscapeViewHeight) {
                return;
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(mqq.app.MobileQQ.\u2026QMMKVFile.FILE_MINI_GAME)");
            fromV2.encodeInt(MMKV_KEY_VIEW_LANDSCAPE_WIDTH, width);
            fromV2.encodeInt(MMKV_KEY_VIEW_LANDSCAPE_HEIGHT, height);
            this$0.mLandscapeViewWidth = width;
            this$0.mLandscapeViewHeight = height;
            return;
        }
        if (width == this$0.mViewWidth && height == this$0.mViewHeight) {
            return;
        }
        MMKVOptionEntityV2 fromV22 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV22, "fromV2(mqq.app.MobileQQ.\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV22.encodeInt(MMKV_KEY_VIEW_WIDTH, width);
        fromV22.encodeInt(MMKV_KEY_VIEW_HEIGHT, height);
        this$0.mViewWidth = width;
        this$0.mViewHeight = height;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        boolean z16 = false;
        if (newConfig != null && newConfig.orientation == 1) {
            setLoadingBg(false);
            return;
        }
        if (newConfig != null && newConfig.orientation == 2) {
            z16 = true;
        }
        if (z16) {
            setLoadingBg(true);
        }
    }

    public final void onLoadProgressChange(int progress, boolean showInstallTips) {
        String loadingViewInstallingTips;
        TextView textView;
        LoadingProgressBar loadingProgressBar = this.loadingProgressBar;
        if (loadingProgressBar != null) {
            loadingProgressBar.setProgress(progress);
        }
        TextView textView2 = this.loadingTextView;
        if (textView2 != null) {
            textView2.setVisibility(showInstallTips ? 0 : 4);
        }
        TextView textView3 = this.loadingTextView;
        if (textView3 != null && textView3.isShown()) {
            MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
            if (progress >= 99) {
                TextView textView4 = this.loadingTextView;
                if (textView4 != null) {
                    textView4.setText(miniGameVAInterceptConfig != null ? miniGameVAInterceptConfig.getLoadingViewInstalledTips() : null);
                }
            } else if (miniGameVAInterceptConfig != null && (loadingViewInstallingTips = miniGameVAInterceptConfig.getLoadingViewInstallingTips()) != null && (textView = this.loadingTextView) != null) {
                try {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(loadingViewInstallingTips, Arrays.copyOf(new Object[]{Integer.valueOf(progress)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    loadingViewInstallingTips = format;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onLoadProgressChange e:", e16);
                }
                textView.setText(loadingViewInstallingTips);
            }
        }
        PAGImageView pAGImageView = this.loadingPagView;
        if (pAGImageView == null || this.loadingTipsLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(pAGImageView);
        RelativeLayout relativeLayout = this.loadingTipsLayout;
        Intrinsics.checkNotNull(relativeLayout);
        int width = relativeLayout.getWidth();
        Intrinsics.checkNotNull(this.loadingPagView);
        pAGImageView.setTranslationX(((width - r1.getWidth()) * progress) / 100.0f);
    }

    public final void onScreenLandScape() {
        RelativeLayout relativeLayout = this.loadingTipsLayout;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.bottomMargin = (int) (ah.f307408i * 20);
            }
            relativeLayout.setLayoutParams(layoutParams2);
        }
        LoadingProgressBar loadingProgressBar = this.loadingProgressBar;
        if (loadingProgressBar != null) {
            float max = (float) Math.max(ah.Z(), ah.y());
            float f16 = ah.f307408i;
            int i3 = (int) (max - ((28.0f * f16) * 2));
            int i16 = (int) (f16 * 5);
            LoadingProgressBar loadingProgressBar2 = this.loadingProgressBar;
            if (loadingProgressBar2 != null) {
                loadingProgressBar2.init(R.drawable.iqm, i3, i16);
            }
            ViewGroup.LayoutParams layoutParams3 = loadingProgressBar.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
            if (layoutParams4 != null) {
                layoutParams4.width = i3;
            }
            LoadingProgressBar loadingProgressBar3 = this.loadingProgressBar;
            if (loadingProgressBar3 == null) {
                return;
            }
            loadingProgressBar3.setLayoutParams(layoutParams4);
        }
    }

    public final MiniGameCustomLoadingView setGameAppId(String gameAppId) {
        Intrinsics.checkNotNullParameter(gameAppId, "gameAppId");
        this.mGameAppId = gameAppId;
        return this;
    }

    public final MiniGameCustomLoadingView setLaunchSource(int from) {
        this.mLaunchFrom = from;
        return this;
    }

    public final MiniGameCustomLoadingView setMiniAppId(String miniAppId) {
        Intrinsics.checkNotNullParameter(miniAppId, "miniAppId");
        this.mMiniAppId = miniAppId;
        return this;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void show(ViewGroup viewGroup) {
        setVisibility(0);
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
        reportShow();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void hide() {
        setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.ui.ICustomMiniLoadingView
    public void requestHideFromJavaScript() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public BaseGameLoadingView initUIData(MiniAppInfo p06) {
        return this;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressInt(float progress) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressTxt(String txt) {
    }
}
