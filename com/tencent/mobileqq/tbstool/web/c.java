package com.tencent.mobileqq.tbstool.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tbstool/web/c;", "", "Lcom/tencent/mobileqq/tbstool/web/a;", "plugin", "", "method", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "", "b", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f291461a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f291461a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(JSONObject params, JsBridgeListener jsBridgeListener, a plugin, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(plugin, "$plugin");
        if (!eIPCResult.isSuccess()) {
            return;
        }
        String string = eIPCResult.data.getString("param", "");
        String optString = params.optString("callback", "");
        if (TextUtils.isEmpty(optString)) {
            if (jsBridgeListener != null) {
                jsBridgeListener.c(string);
            }
            QLog.d("TBSWebBridge", 1, "onComplete callbackParam: " + string);
            return;
        }
        QLog.d("TBSWebBridge", 1, "callJs callbackParam: " + string);
        plugin.callJs(optString, string);
    }

    public final void b(@NotNull final a plugin, @Nullable String method, @NotNull final JSONObject params, @Nullable final JsBridgeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, plugin, method, params, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(params, "params");
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        Bundle bundle = new Bundle();
        bundle.putString("method", method);
        bundle.putString("param", params.toString());
        Unit unit = Unit.INSTANCE;
        client.callServer("TBSToolIPCModule", "forwardJSRequestToTBS", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.tbstool.web.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.c(JSONObject.this, listener, plugin, eIPCResult);
            }
        });
    }
}
