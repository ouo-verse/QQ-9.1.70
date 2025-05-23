package com.tencent.mobileqq.activity.about;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J.\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/about/PolarLightWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/h;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "", "style", "Lcom/tencent/mobileqq/webview/swift/u;", "supporter", "Lcom/tencent/mobileqq/webview/swift/WebViewTabBarData;", "data", "Landroid/content/Intent;", "intent", "newInstance", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLight", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class PolarLightWebViewFragment extends WebViewFragment implements com.tencent.mobileqq.webview.swift.h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private QUIPolarLightView polarLight;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/about/PolarLightWebViewFragment$a;", "Lcom/tencent/mobileqq/webview/swift/ak;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "Lcom/tencent/mobileqq/activity/about/PolarLightWebViewFragment;", "X", "Lcom/tencent/mobileqq/activity/about/PolarLightWebViewFragment;", "webViewFragment", "<init>", "(Lcom/tencent/mobileqq/activity/about/PolarLightWebViewFragment;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    private static final class a extends ak {
        static IPatchRedirector $redirector_;

        /* renamed from: X, reason: from kotlin metadata */
        @NotNull
        private final PolarLightWebViewFragment webViewFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull PolarLightWebViewFragment webViewFragment) {
            super(webViewFragment);
            Intrinsics.checkNotNullParameter(webViewFragment, "webViewFragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewFragment);
            } else {
                this.webViewFragment = webViewFragment;
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.ak, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            Drawable drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) extraData);
                return;
            }
            super.onInitUIContent(extraData);
            this.webViewFragment.getUIStyleHandler().T.setVisibility(8);
            Context context = this.webViewFragment.getContext();
            if (context != null && (drawable = context.getDrawable(R.drawable.qui_common_bg_bottom_brand_bg)) != null) {
                this.webViewFragment.contentView.setBackground(drawable);
            }
        }
    }

    public PolarLightWebViewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (t) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a(this);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    @NotNull
    public WebViewFragment newInstance(int style, @Nullable u supporter, @Nullable WebViewTabBarData data, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(style), supporter, data, intent);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        PolarLightWebViewFragment polarLightWebViewFragment = new PolarLightWebViewFragment();
        polarLightWebViewFragment.setArguments(bundle);
        return polarLightWebViewFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.View] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            viewGroup2 = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            QUIPolarLightView qUIPolarLightView = null;
            if (onCreateView instanceof ViewGroup) {
                viewGroup = (ViewGroup) onCreateView;
            } else {
                viewGroup = null;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168774gv1, viewGroup, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.biz.qui.quipolarlight.QUIPolarLightView");
            this.polarLight = (QUIPolarLightView) inflate;
            float floatExtra = getIntent().getFloatExtra("polar_light_frame", 0.0f);
            QUIPolarLightView qUIPolarLightView2 = this.polarLight;
            if (qUIPolarLightView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("polarLight");
                qUIPolarLightView2 = null;
            }
            qUIPolarLightView2.getPolarLightRender().n(floatExtra);
            QUIPolarLightView qUIPolarLightView3 = this.polarLight;
            if (qUIPolarLightView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("polarLight");
                qUIPolarLightView3 = null;
            }
            qUIPolarLightView3.getPolarLightRender().q(new a.b(0.6f, 0.5f, 0.4f, 0.3f, 0.0f));
            viewGroup2 = viewGroup;
            if (viewGroup != null) {
                QUIPolarLightView qUIPolarLightView4 = this.polarLight;
                if (qUIPolarLightView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("polarLight");
                } else {
                    qUIPolarLightView = qUIPolarLightView4;
                }
                viewGroup.addView(qUIPolarLightView, 0);
                viewGroup2 = viewGroup;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        QUIPolarLightView qUIPolarLightView = this.polarLight;
        if (qUIPolarLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("polarLight");
            qUIPolarLightView = null;
        }
        qUIPolarLightView.stopAnimation();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QUIPolarLightView qUIPolarLightView = this.polarLight;
        if (qUIPolarLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("polarLight");
            qUIPolarLightView = null;
        }
        qUIPolarLightView.m();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
            intent.putExtra("fragmentStyle", 0);
        }
    }
}
