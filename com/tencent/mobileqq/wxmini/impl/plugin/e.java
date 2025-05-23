package com.tencent.mobileqq.wxmini.impl.plugin;

import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/plugin/e;", "Lcom/tencent/mobileqq/wxmini/impl/plugin/a;", "", "a", "", "wxaAppID", "apiName", "Lorg/json/JSONObject;", "data", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$a;", "callback", "", "d", "<init>", "()V", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/plugin/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.impl.plugin.e$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WxaExtendApiJSBridge.a aVar, boolean z16, JSONObject jSONObject) {
        if (z16) {
            if (aVar != null) {
                aVar.callback(WxaExtendApiJSBridge.ErrMsg.OK, "", jSONObject);
            }
        } else if (aVar != null) {
            WxaExtendApiJSBridge.ErrMsg errMsg = WxaExtendApiJSBridge.ErrMsg.FAIL;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            aVar.callback(errMsg, "", jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.wxmini.impl.plugin.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wxmini.impl.plugin.a
    public void d(@NotNull String wxaAppID, @NotNull String apiName, @Nullable JSONObject data, @Nullable final WxaExtendApiJSBridge.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, wxaAppID, apiName, data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (data == null) {
            if (callback != null) {
                callback.callback(WxaExtendApiJSBridge.ErrMsg.FAIL, "", new JSONObject());
                return;
            }
            return;
        }
        ((IWeiXinMiniServiceAPI) QRoute.api(IWeiXinMiniServiceAPI.class)).openConnectAuthorize(wxaAppID, data, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.wxmini.impl.plugin.d
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                e.g(WxaExtendApiJSBridge.a.this, z16, jSONObject);
            }
        });
    }
}
