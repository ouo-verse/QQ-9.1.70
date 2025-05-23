package com.tencent.mobileqq.tbstool.web;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tbstool.web.jshandler.d;
import com.tencent.mobileqq.tbstool.web.jshandler.e;
import com.tencent.mobileqq.tbstool.web.jshandler.f;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016JO\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\f\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tbstool/web/a;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lorg/json/JSONObject;", "args", "", "p", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/tbstool/web/jshandler/a;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "handlerList", "<init>", "()V", "e", "a", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.tbstool.web.jshandler.a> handlerList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/tbstool/web/a$a;", "", "", "KEY_CALLBACK", "Ljava/lang/String;", "NAME_SPACE", "TAG", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tbstool.web.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        ArrayList<com.tencent.mobileqq.tbstool.web.jshandler.a> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new d(), new com.tencent.mobileqq.tbstool.web.jshandler.b(), new e(), new f(), new com.tencent.mobileqq.tbstool.web.jshandler.c());
            this.handlerList = arrayListOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String p(JSONObject args) {
        String callbackFunc = args.optString("callback", "");
        if (TextUtils.isEmpty(callbackFunc)) {
            QLog.d("TBSToolWebViewPlugin", 1, "callbackJS callbackFunc null");
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(callbackFunc, "callbackFunc");
        return callbackFunc;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DocToolsModule";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, listener, url, pkgName, method, args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        QLog.d("TBSToolWebViewPlugin", 1, "handleJsRequest, url=" + url + ", pkgName=" + pkgName + ", methodName=" + method + ", args=" + args);
        if (url == null || !TextUtils.equals("DocToolsModule", pkgName) || TextUtils.isEmpty(method)) {
            return false;
        }
        String str = args[0];
        if (str == null) {
            str = "";
        }
        JSONObject jSONObject = new JSONObject(str);
        for (com.tencent.mobileqq.tbstool.web.jshandler.a aVar : this.handlerList) {
            Intrinsics.checkNotNull(method);
            if (aVar.d(method)) {
                JSONObject c16 = aVar.c(method, jSONObject);
                if (c16 == null) {
                    return true;
                }
                String p16 = p(jSONObject);
                if (TextUtils.isEmpty(p16)) {
                    if (listener != null) {
                        listener.d(c16);
                    }
                    return true;
                }
                callJs(p16, c16.toString());
                return true;
            }
        }
        c.f291461a.b(this, method, jSONObject, listener);
        return true;
    }
}
