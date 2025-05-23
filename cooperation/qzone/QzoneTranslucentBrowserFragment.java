package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import ne0.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneTranslucentBrowserFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment implements h {
    public static final String BUNDLE_KEY_INTENT = "intent";
    public static final String CONTENT_BACKGROUND_COLOR = "CONTENT_BACKGROUND_COLOR";
    public static final String KEY_SHOW_CLOSE_BTN = "show_close_btn";
    private boolean mIsShowCloseBtn = true;

    private int dpToPx(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCloseButton(RelativeLayout relativeLayout) {
        if (relativeLayout != null && getHostActivity() != null) {
            ImageView imageView = new ImageView(getHostActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = dpToPx(50.0f);
            layoutParams.rightMargin = dpToPx(15.0f);
            layoutParams.addRule(11);
            relativeLayout.addView(imageView, layoutParams);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.gbl));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.QzoneTranslucentBrowserFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (QzoneTranslucentBrowserFragment.this.getHostActivity() != null) {
                        QzoneTranslucentBrowserFragment.this.getHostActivity().finish();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    public static QzoneTranslucentBrowserFragment newInstance(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        QzoneTranslucentBrowserFragment qzoneTranslucentBrowserFragment = new QzoneTranslucentBrowserFragment();
        qzoneTranslucentBrowserFragment.setArguments(bundle);
        return qzoneTranslucentBrowserFragment;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void activityFinish() {
        super.activityFinish();
        if (getHostActivity() != null) {
            getHostActivity().setResult(-1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new com.tencent.mobileqq.webview.swift.proxy.a(this.webViewSurface) { // from class: cooperation.qzone.QzoneTranslucentBrowserFragment.1
            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                QzoneTranslucentBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                QzoneTranslucentBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageFinished(WebView webView, String str) {
                this.webViewKernelCallBack.onPageFinished(webView, str);
                if (QzoneTranslucentBrowserFragment.this.mIsShowCloseBtn) {
                    QzoneTranslucentBrowserFragment qzoneTranslucentBrowserFragment = QzoneTranslucentBrowserFragment.this;
                    qzoneTranslucentBrowserFragment.initCloseButton(qzoneTranslucentBrowserFragment.contentView);
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return f.g(this);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
    public void onInitUIContent(Bundle bundle, t tVar) {
        if (getUIStyleHandler() != null) {
            getUIStyleHandler().f314499a0 = true;
        }
        super.onInitUIContent(bundle, tVar);
        Intent intent = this.intent;
        if (intent != null) {
            this.contentView.setBackgroundColor(intent.getIntExtra(CONTENT_BACKGROUND_COLOR, 0));
            this.mIsShowCloseBtn = this.intent.getBooleanExtra(KEY_SHOW_CLOSE_BTN, true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return f.o(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        return newInstance(intent);
    }
}
