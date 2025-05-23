package com.tencent.mobileqq.qwallet.pet.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.util.r;
import com.tencent.mobileqq.webviewplugin.q;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0015H\u0014J\u0012\u0010)\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010*\u001a\u00020\tH\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/fragment/HalfWebViewFragment;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity$QQTranslucentBrowserFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "contentView", "Landroid/content/Intent;", "intent", "", "uh", "vh", "Bh", "yh", "xh", "view", "Eh", "wh", "Ah", "", "currentUrl", "", "Ch", "actionName", "Dh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/webview/swift/utils/t;", "webViewKernelCallBack", "onInitUIContent", "Landroid/content/res/Configuration;", "newConfig", "doOnConfigurationChanged", "onResume", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webviewplugin/q;", "getWebTitleBarInterface", "handleBackEvent", "v", NodeProps.ON_CLICK, "activityFinish", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "vBg", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "ivBack", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HalfWebViewFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View vBg;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView ivBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J>\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ>\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010*\u001a\u00020)8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0014\u0010-\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u001aR\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u001d\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/fragment/HalfWebViewFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "merchantLogo", "merchantTitle", "", "heightPercentage", "opacity", "Landroid/content/Intent;", "b", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "requestCode", "", "d", "Landroidx/fragment/app/Fragment;", "fragment", "c", "Landroid/os/Bundle;", "bundle", "", "a", "COLOR_BIT_MAX", "I", "", "CORNER_DEFAULT", UserInfo.SEX_FEMALE, "HEIGHT_PERCENTAGE_DEFAULT", "KEY_FRAGMENT_CLASS", "Ljava/lang/String;", "KEY_HEIGHT_PERCENTAGE", "KEY_LAUNCH_BY_INTERFACE", "KEY_MERCHANT_LOGO", "KEY_MERCHANT_TITLE", "KEY_OPACITY", "KEY_OUT_LAST_URL", "KEY_OUT_LAST_URL_TITLE", "KEY_WEB_URL", "", "MASK_WINDOW_DELAY", "J", "OPACITY_DEFAULT", "PERCENT_MAX", "TAG", "TOUCH_EXPAND_SIZE", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.fragment.HalfWebViewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent b(Activity activity, String url, String merchantLogo, String merchantTitle, int heightPercentage, int opacity) {
            Intent intent = new Intent();
            intent.putExtra("url", url);
            intent.putExtra("qwMerchantLogo", merchantLogo);
            intent.putExtra("qwMerchantTitle", merchantTitle);
            intent.putExtra("qwHeightPercentage", heightPercentage);
            intent.putExtra("qwOpacity", opacity);
            intent.putExtra("qwLaunchByInterface", true);
            intent.setClass(activity, QQTranslucentBrowserActivity.class);
            intent.putExtra("fragmentClass", HalfWebViewFragment.class);
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            return intent;
        }

        public final boolean a(@Nullable Activity activity, @Nullable Bundle bundle) {
            Intent intent;
            Bundle extras;
            if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !Intrinsics.areEqual(extras.get("fragmentClass"), HalfWebViewFragment.class)) {
                return false;
            }
            if (bundle != null) {
                bundle.remove("qwMerchantLogo");
            }
            if (bundle != null) {
                bundle.remove("qwMerchantTitle");
            }
            if (bundle != null) {
                bundle.putInt("qwOpacity", 0);
            }
            if (bundle != null) {
                bundle.remove(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN);
            }
            if (bundle != null) {
                bundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
            }
            return true;
        }

        public final void c(@NotNull Fragment fragment, @NotNull String url, @NotNull String merchantLogo, @NotNull String merchantTitle, int heightPercentage, int opacity, int requestCode) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(merchantLogo, "merchantLogo");
            Intrinsics.checkNotNullParameter(merchantTitle, "merchantTitle");
            FragmentActivity activity = fragment.getActivity();
            if (activity != null && !activity.isFinishing()) {
                fragment.startActivityForResult(b(activity, url, merchantLogo, merchantTitle, heightPercentage, opacity), requestCode);
                activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            }
        }

        public final void d(@NotNull WebViewPlugin plugin, @NotNull String url, @NotNull String merchantLogo, @NotNull String merchantTitle, int heightPercentage, int opacity, int requestCode) {
            Activity activity;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(merchantLogo, "merchantLogo");
            Intrinsics.checkNotNullParameter(merchantTitle, "merchantTitle");
            WebViewPlugin.b bVar = plugin.mRuntime;
            if (bVar != null) {
                activity = bVar.a();
            } else {
                activity = null;
            }
            if (activity != null && !activity.isFinishing()) {
                plugin.startActivityForResult(b(activity, url, merchantLogo, merchantTitle, heightPercentage, opacity), (byte) requestCode);
                activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qwallet/pet/fragment/HalfWebViewFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/b;", "", "tipsMargin", "webviewMargin", "", "Kb", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.b {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
        public void Kb(int tipsMargin, int webviewMargin) {
            super.Kb(tipsMargin, HalfWebViewFragment.this.getResources().getDimensionPixelSize(R.dimen.ciu));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/qwallet/pet/fragment/HalfWebViewFragment$c", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "onInitTitleBar", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "title", "onReceivedTitle", "onPageFinished", "", "softKeyboardResizeCompactOn", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends com.tencent.mobileqq.webview.swift.proxy.a {
        c(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitTitleBar(@Nullable Bundle extraData) {
            super.onInitTitleBar(extraData);
            HalfWebViewFragment.this.getWebTitleBarInterface().u5(false);
            ImmersiveUtils.clearCoverForStatus(HalfWebViewFragment.this.getQBaseActivity().getWindow(), true);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            HalfWebViewFragment halfWebViewFragment = HalfWebViewFragment.this;
            t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            halfWebViewFragment.onInitUIContent(extraData, webViewKernelCallBack);
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        
            if (r1.canGoBack() == true) goto L11;
         */
        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            boolean z16;
            int i3;
            super.onPageFinished(view, url);
            boolean Ch = HalfWebViewFragment.this.Ch(url);
            ImageView imageView = HalfWebViewFragment.this.ivBack;
            if (imageView != null) {
                TouchWebView touchWebView = ((WebViewFragment) HalfWebViewFragment.this).webView;
                if (touchWebView != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16 && !Ch) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                imageView.setVisibility(i3);
            }
            ImmersiveUtils.setStatusTextColorNew(false, HalfWebViewFragment.this.getQBaseActivity().getWindow(), false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
        
            if (r5.canGoBack() == true) goto L11;
         */
        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            boolean z16;
            super.onPageStarted(view, url, favicon);
            boolean areEqual = Intrinsics.areEqual(Uri.parse(url).getQueryParameter("noBack"), "1");
            ImageView imageView = HalfWebViewFragment.this.ivBack;
            if (imageView != null) {
                TouchWebView touchWebView = ((WebViewFragment) HalfWebViewFragment.this).webView;
                int i3 = 0;
                if (touchWebView != null) {
                    z16 = true;
                }
                z16 = false;
                if (!z16 || areEqual) {
                    i3 = 4;
                }
                imageView.setVisibility(i3);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedTitle(@Nullable WebView view, @Nullable String title) {
            TextView textView;
            if (!r.a(title) && (textView = HalfWebViewFragment.this.tvTitle) != null) {
                textView.setText(title);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean softKeyboardResizeCompactOn() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pet/fragment/HalfWebViewFragment$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends ViewOutlineProvider {
        d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dpToPx(12.0f));
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private final void Ah(Intent intent) {
        Object obj;
        View titleBarView = getWebTitleBarInterface().getTitleBarView();
        ViewParent parent = titleBarView.getParent();
        if (parent instanceof RelativeLayout) {
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            View inflate = View.inflate(getActivity(), R.layout.hiv, null);
            this.tvTitle = (TextView) inflate.findViewById(R.id.kbs);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.du6);
            this.ivBack = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            String stringExtra = intent.getStringExtra("qwMerchantTitle");
            View findViewById = inflate.findViewById(R.id.x5r);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.half_web_view_merchant_title)");
            ((TextView) findViewById).setText(stringExtra);
            String stringExtra2 = intent.getStringExtra("qwMerchantLogo");
            View findViewById2 = inflate.findViewById(R.id.x5q);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.half_web_view_merchant_logo)");
            ImageView imageView2 = (ImageView) findViewById2;
            imageView2.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(stringExtra2));
            xh(imageView2);
            View findViewById3 = inflate.findViewById(R.id.dum);
            ((ImageView) findViewById3).setOnClickListener(this);
            BaseAIOUtils.g(findViewById3, ViewUtils.dpToPx(20.0f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, inflate.getResources().getDimensionPixelSize(R.dimen.ciu));
            layoutParams.addRule(3, titleBarView.getId());
            RelativeLayout relativeLayout = (RelativeLayout) parent;
            relativeLayout.addView(inflate, layoutParams);
            View findViewById4 = relativeLayout.findViewById(R.id.jse);
            if (findViewById4 != null) {
                obj = findViewById4.getLayoutParams();
            } else {
                obj = null;
            }
            if (obj instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = inflate.getResources().getDimensionPixelSize(R.dimen.ciu);
            }
        }
    }

    private final void Bh(ViewGroup rootView) {
        rootView.findViewById(R.id.l2a).setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ch(String currentUrl) {
        boolean z16;
        if (currentUrl != null && currentUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return Intrinsics.areEqual(Uri.parse(currentUrl).getQueryParameter("noBack"), "1");
    }

    private final void Dh(String actionName) {
        String str;
        String str2;
        Intent intent = super.getQBaseActivity().getIntent();
        if (intent != null) {
            str = intent.getStringExtra("qwMerchantTitle");
        } else {
            str = null;
        }
        if (intent != null) {
            str2 = intent.getStringExtra("url");
        } else {
            str2 = null;
        }
        com.tencent.mobileqq.qwallet.c.f(actionName, null, null, str, str2, 6, null);
    }

    private final void Eh(View view) {
        View view2;
        ColorDrawable colorDrawable;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            Integer num = null;
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (view2 != null) {
                Drawable background = view2.getBackground();
                if (background instanceof ColorDrawable) {
                    colorDrawable = (ColorDrawable) background;
                } else {
                    colorDrawable = null;
                }
                if (colorDrawable != null) {
                    num = Integer.valueOf(colorDrawable.getColor());
                }
                QLog.i("HalfWebViewFragment", 1, "setParentViewTransparent: " + view2 + ", bgColor=" + num);
                view2.setBackgroundColor(0);
            }
        }
    }

    private final void uh(ViewGroup rootView, View contentView, Intent intent) {
        Ah(intent);
        wh(contentView, intent);
        Eh(contentView);
        vh(rootView, intent);
    }

    private final void vh(ViewGroup rootView, Intent intent) {
        Bh(rootView);
        yh(intent, rootView);
    }

    private final void wh(View contentView, Intent intent) {
        Integer num;
        int screenHeight;
        Resources resources;
        Configuration configuration;
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            int intExtra = intent.getIntExtra("qwHeightPercentage", 88);
            FragmentActivity activity = getActivity();
            if (activity != null && (resources = activity.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                num = Integer.valueOf(configuration.orientation);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 2) {
                screenHeight = ViewUtils.getScreenWidth();
            } else {
                screenHeight = ViewUtils.getScreenHeight();
            }
            layoutParams.height = (screenHeight * intExtra) / 100;
            ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            contentView.setLayoutParams(layoutParams);
        }
        QLog.i("HalfWebViewFragment", 2, "[doOnInitUIContent] lp:" + layoutParams);
    }

    private final void xh(View contentView) {
        contentView.setOutlineProvider(new d());
        contentView.setClipToOutline(true);
    }

    private final void yh(final Intent intent, final ViewGroup rootView) {
        if (intent.getBooleanExtra("qwLaunchByInterface", false)) {
            intent.putExtra("qwLaunchByInterface", false);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            }
            this.vBg = rootView;
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    HalfWebViewFragment.zh(intent, rootView);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Intent intent, ViewGroup this_apply) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setBackgroundColor(Color.argb((intent.getIntExtra("qwOpacity", 50) * 255) / 100, 0, 0, 0));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void activityFinish() {
        String str;
        super.activityFinish();
        View view = this.vBg;
        if (view != null) {
            view.setBackgroundColor(0);
        }
        if (getHostActivity() != null) {
            Intent intent = new Intent();
            CustomWebView webView = getWebView();
            String str2 = null;
            if (webView != null) {
                str = webView.getUrl();
            } else {
                str = null;
            }
            intent.putExtra("last_url", str);
            CustomWebView webView2 = getWebView();
            if (webView2 != null) {
                str2 = webView2.getTitle();
            }
            intent.putExtra("last_url_title", str2);
            getHostActivity().setResult(-1, intent);
        }
        Dh("qqwallet.halfwebview_close.click");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnConfigurationChanged(@Nullable Configuration newConfig) {
        View findViewById;
        super.doOnConfigurationChanged(newConfig);
        QBaseActivity qBaseActivity = super.getQBaseActivity();
        if (qBaseActivity != null && (findViewById = qBaseActivity.findViewById(R.id.b9v)) != null) {
            Intent intent = qBaseActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            wh(findViewById, intent);
            Eh(findViewById);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public q getWebTitleBarInterface() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new c(this.webViewSurface);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean handleBackEvent() {
        if (Ch(getUrl())) {
            return false;
        }
        return super.handleBackEvent();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.du6) {
            doOnBackEvent();
        } else if (num != null && num.intValue() == R.id.dum && (activity = getActivity()) != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.style.a6r;
            } else {
                i3 = R.style.a6q;
            }
            activity.setTheme(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
    public void onInitUIContent(@Nullable Bundle extraData, @NotNull t webViewKernelCallBack) {
        View findViewById;
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        getUIStyleHandler().f314512m.f314620c &= -5;
        QBaseActivity qBaseActivity = super.getQBaseActivity();
        if (qBaseActivity != null && (findViewById = qBaseActivity.findViewById(R.id.b9v)) != null) {
            ViewParent parent = findViewById.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            Intent intent = super.getQBaseActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "super.getQBaseActivity().intent");
            uh((ViewGroup) parent, findViewById, intent);
        }
        super.onInitUIContent(extraData, webViewKernelCallBack);
        Dh("qqwallet.halfwebview_open.show");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersiveUtils.setStatusTextColorNew(false, getQBaseActivity().getWindow(), false);
    }
}
