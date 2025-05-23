package com.qwallet.student;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.jsp.invoke.ChsiCertificationParams;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/qwallet/student/ChsiCertificationFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Landroid/view/View$OnClickListener;", "", "sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "chsiContentLayout", "Lcom/qwallet/student/c;", "D", "Lcom/qwallet/student/c;", "guideVC", "Lcom/qwallet/student/i;", "E", "Lcom/qwallet/student/i;", "verifyVC", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ChsiCertificationFragment extends WebViewFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View chsiContentLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private c guideVC;

    /* renamed from: E, reason: from kotlin metadata */
    private i verifyVC;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qwallet/student/ChsiCertificationFragment$a;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "params", "", "requestCode", "", "b", "Landroid/content/Intent;", "intent", "a", "", "KEY_CHSI_PARAMS", "Ljava/lang/String;", "KEY_FRAGMENT_CLASS", "KEY_WEB_URL", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.student.ChsiCertificationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull WebViewPlugin plugin, @NotNull Intent intent, int requestCode) {
            Activity activity;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(intent, "intent");
            WebViewPlugin.b bVar = plugin.mRuntime;
            Activity activity2 = null;
            if (bVar != null) {
                activity = bVar.a();
            } else {
                activity = null;
            }
            if (activity == null) {
                WebViewPlugin.b bVar2 = plugin.mRuntime;
                if (bVar2 != null) {
                    activity2 = bVar2.a();
                }
                QLog.i("ChsiCertificationFragment", 1, "activity error : activity: " + activity2 + " is null");
                return;
            }
            if (activity.isFinishing()) {
                return;
            }
            intent.setClass(activity, QQTranslucentBrowserActivity.class);
            intent.putExtra("fragmentClass", ChsiCertificationFragment.class);
            plugin.startActivityForResult(intent, (byte) requestCode);
        }

        @JvmStatic
        public final void b(@NotNull WebViewPlugin plugin, @NotNull ChsiCertificationParams params, int requestCode) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent = new Intent();
            intent.putExtra("url", params.getUrl());
            intent.putExtra("qwChsiCertificationParams", params);
            intent.putExtra("hide_more_button", true);
            Unit unit = Unit.INSTANCE;
            a(plugin, intent, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/qwallet/student/ChsiCertificationFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "onInitTitleBar", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "", "softKeyboardResizeCompactOn", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitTitleBar(@Nullable Bundle extraData) {
            super.onInitTitleBar(extraData);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            super.onInitUIContent(extraData);
            ChsiCertificationFragment.this.sh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            if (url == null) {
                return;
            }
            QLog.d("ChsiCertificationFragment", 1, "onPageFinished = " + url);
            c cVar = ChsiCertificationFragment.this.guideVC;
            c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideVC");
                cVar = null;
            }
            cVar.f();
            i iVar = ChsiCertificationFragment.this.verifyVC;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyVC");
                iVar = null;
            }
            iVar.r();
            i iVar2 = ChsiCertificationFragment.this.verifyVC;
            if (iVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyVC");
                iVar2 = null;
            }
            if (!iVar2.p(url)) {
                c cVar3 = ChsiCertificationFragment.this.guideVC;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guideVC");
                } else {
                    cVar2 = cVar3;
                }
                cVar2.e(url);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean softKeyboardResizeCompactOn() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sh() {
        View findViewById;
        getUIStyleHandler().f314512m.f314620c &= -5;
        QBaseActivity qBaseActivity = super.getQBaseActivity();
        if (qBaseActivity != null && (findViewById = qBaseActivity.findViewById(R.id.b9v)) != null) {
            ViewParent parent = findViewById.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            View view = this.chsiContentLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chsiContentLayout");
                view = null;
            }
            viewGroup.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ChsiCertificationParams chsiCertificationParams;
        super.onCreate(savedInstanceState);
        Intent intent = this.intent;
        View view = null;
        if (intent != null) {
            chsiCertificationParams = (ChsiCertificationParams) intent.getParcelableExtra("qwChsiCertificationParams");
        } else {
            chsiCertificationParams = null;
        }
        if (chsiCertificationParams == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        View inflate = View.inflate(getContext(), R.layout.hic, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026rtification_layout, null)");
        this.chsiContentLayout = inflate;
        View view2 = this.chsiContentLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chsiContentLayout");
            view2 = null;
        }
        this.guideVC = new c(this, view2, chsiCertificationParams);
        View view3 = this.chsiContentLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chsiContentLayout");
        } else {
            view = view3;
        }
        this.verifyVC = new i(this, view, chsiCertificationParams);
    }
}
