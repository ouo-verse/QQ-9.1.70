package com.tencent.mobileqq.wxmini.impl.plugin;

import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH&J,\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J-\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/plugin/a;", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$b;", "", "wxaAppID", "apiName", "Lorg/json/JSONObject;", "data", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$a;", "callback", "", "e", "", "b", "a", "c", "d", "invoke", "<init>", "()V", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a implements WxaExtendApiJSBridge.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        return MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName);
    }

    private final void e(String wxaAppID, String apiName, JSONObject data, WxaExtendApiJSBridge.a callback) {
        com.tencent.mobileqq.wxmini.impl.plugin.ipc.c.f327751d.invoke(wxaAppID, apiName, data, callback);
    }

    public abstract boolean a();

    public void c(@NotNull String wxaAppID, @NotNull String apiName, @Nullable JSONObject data, @Nullable WxaExtendApiJSBridge.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, wxaAppID, apiName, data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (callback != null) {
            callback.callback(WxaExtendApiJSBridge.ErrMsg.OK, "", new JSONObject());
        }
    }

    public void d(@NotNull String wxaAppID, @NotNull String apiName, @Nullable JSONObject data, @Nullable WxaExtendApiJSBridge.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, wxaAppID, apiName, data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (callback != null) {
            callback.callback(WxaExtendApiJSBridge.ErrMsg.OK, "", new JSONObject());
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.b
    public final void invoke(@NotNull String wxaAppID, @NotNull String apiName, @Nullable JSONObject data, @Nullable WxaExtendApiJSBridge.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, wxaAppID, apiName, data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (a()) {
            d(wxaAppID, apiName, data, callback);
        } else if (b()) {
            c(wxaAppID, apiName, data, callback);
        } else {
            e(wxaAppID, apiName, data, callback);
        }
    }
}
