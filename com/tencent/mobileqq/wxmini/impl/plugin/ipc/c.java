package com.tencent.mobileqq.wxmini.impl.plugin.ipc;

import android.os.Bundle;
import com.tencent.ark.ark;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.wxmini.api.IWxMiniLibApi;
import com.tencent.mobileqq.wxmini.impl.plugin.h;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J-\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/plugin/ipc/c;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$b;", "Landroid/os/Bundle;", "params", "", "callbackId", "", "e", "", "action", "Leipc/EIPCResult;", "onCall", "wxaAppID", "apiName", "Lorg/json/JSONObject;", "data", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$a;", "callback", "invoke", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/wxaapi/WxaExtendApiJSBridge$ErrMsg;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "errCodeMap", "<init>", "()V", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends QIPCModule implements WxaExtendApiJSBridge.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f327751d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<WxaExtendApiJSBridge.ErrMsg> errCodeMap;

    static {
        ArrayList<WxaExtendApiJSBridge.ErrMsg> arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f327751d = new c();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WxaExtendApiJSBridge.ErrMsg.FAIL, WxaExtendApiJSBridge.ErrMsg.OK, WxaExtendApiJSBridge.ErrMsg.CANCEL);
        errCodeMap = arrayListOf;
    }

    c() {
        super(IWxMiniLibApi.WX_MINI_IPC_MODULE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WxaExtendApiJSBridge.a aVar, EIPCResult eIPCResult) {
        Bundle bundle;
        String str;
        String string;
        JSONObject jSONObject = null;
        if (eIPCResult != null) {
            bundle = eIPCResult.data;
        } else {
            bundle = null;
        }
        ArrayList<WxaExtendApiJSBridge.ErrMsg> arrayList = errCodeMap;
        int i3 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("code", 0);
        }
        WxaExtendApiJSBridge.ErrMsg errMsg = arrayList.get(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errCodeMap[resultData?.getInt(\"code\", 0) ?: 0]");
        WxaExtendApiJSBridge.ErrMsg errMsg2 = errMsg;
        if (bundle == null || (str = bundle.getString("msg")) == null) {
            str = "";
        }
        if (bundle != null && (string = bundle.getString(ark.ARKMETADATA_JSON)) != null) {
            jSONObject = new JSONObject(string);
        }
        if (aVar != null) {
            aVar.callback(errMsg2, str, jSONObject);
        }
    }

    private final void e(Bundle params, final int callbackId) {
        h.b().invoke(params.getString("wxaAppID", ""), params.getString("apiName", ""), new JSONObject(params.getString(ark.ARKMETADATA_JSON, "")), new WxaExtendApiJSBridge.a() { // from class: com.tencent.mobileqq.wxmini.impl.plugin.ipc.a
            @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.a
            public final void callback(WxaExtendApiJSBridge.ErrMsg errMsg, String str, JSONObject jSONObject) {
                c.f(callbackId, errMsg, str, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, WxaExtendApiJSBridge.ErrMsg errMsg, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putString(ark.ARKMETADATA_JSON, String.valueOf(jSONObject));
        bundle.putInt("code", errCodeMap.indexOf(errMsg));
        f327751d.callbackResult(i3, EIPCResult.createResult(0, bundle));
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.b
    public void invoke(@NotNull String wxaAppID, @NotNull String apiName, @Nullable JSONObject data, @Nullable final WxaExtendApiJSBridge.a callback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, wxaAppID, apiName, data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        Bundle bundle = new Bundle();
        bundle.putString("wxaAppID", wxaAppID);
        bundle.putString("apiName", apiName);
        if (data == null || (str = data.toString()) == null) {
            str = "";
        }
        bundle.putString(ark.ARKMETADATA_JSON, str);
        Unit unit = Unit.INSTANCE;
        client.callServer(IWxMiniLibApi.WX_MINI_IPC_MODULE_NAME, "wx_invoke", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.wxmini.impl.plugin.ipc.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.d(WxaExtendApiJSBridge.a.this, eIPCResult);
            }
        });
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (params == null) {
            callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
            return null;
        }
        if (Intrinsics.areEqual(action, "wx_invoke")) {
            e(params, callbackId);
        } else {
            callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
        }
        return null;
    }
}
