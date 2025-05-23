package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/l;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        String str;
        String p16;
        com.tencent.mobileqq.guild.webview.g gVar;
        WebViewPlugin.b bVar;
        CustomWebView webView;
        int[] intArray;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        com.tencent.mobileqq.guild.webview.g gVar2 = this.f235756e;
        if (gVar2 != null && (p16 = gVar2.p()) != null && (gVar = this.f235756e) != null && (bVar = gVar.mRuntime) != null && (webView = bVar.e()) != null) {
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
            RemoteWebViewEvent remoteWebViewEvent = RemoteWebViewEvent.ON_PAGE_FINISH;
            Bundle bundle = new Bundle();
            bundle.putInt(RequestApplyFragment.ERROR_CODE, 0);
            bundle.putString("ERROR_MESSAGE", "");
            boolean[] zArr = {webView.canScrollVertically(-1), webView.canScrollVertically(1), webView.canScrollHorizontally(-1), webView.canScrollHorizontally(1)};
            ArrayList arrayList = new ArrayList(4);
            for (int i3 = 0; i3 < 4; i3++) {
                arrayList.add(Integer.valueOf(zArr[i3] ? 1 : 0));
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            bundle.putIntArray("CAN_SCROLL_INIT_DATA", intArray);
            Unit unit = Unit.INSTANCE;
            a16.S(p16, remoteWebViewEvent, bundle);
        }
        com.tencent.mobileqq.guild.webview.g gVar3 = this.f235756e;
        if (gVar3 != null) {
            str = gVar3.p();
        } else {
            str = null;
        }
        QLog.i("Guild.jump.JS.AbsJsBridgeMethod", 1, "HideLoadingViewMethod onInvoke remoteWebPageId:" + str);
        return true;
    }
}
