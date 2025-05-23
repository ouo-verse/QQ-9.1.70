package o13;

import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u00022\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lo13/a;", "", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$a;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: o13.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10877a implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public C10877a(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            this.proxy.bubbleSetUp(setKey, data.optInt("itemId"), data.optBoolean("isVoice"));
            this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lo13/a$c;", "", "", "business", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "Lw33/a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: o13.a$c, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final w33.a a(long business, VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            if (business == 5) {
                return new e(proxy);
            }
            if (business == 2) {
                return new C10877a(proxy);
            }
            Long l3 = ChatBackgroundBusiness.BID;
            if (l3 != null && business == l3.longValue()) {
                return new b(proxy);
            }
            if (business == 15) {
                return new f(proxy);
            }
            if (business == 3) {
                return new g(proxy);
            }
            if ((((business > 333L ? 1 : (business == 333L ? 0 : -1)) == 0 || (business > 54L ? 1 : (business == 54L ? 0 : -1)) == 0) || (business > 57L ? 1 : (business == 57L ? 0 : -1)) == 0) || business == 327) {
                return new h(proxy);
            }
            if (business == 328) {
                return new d(proxy);
            }
            return new d(proxy);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$d;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public d(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            if (TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
                return;
            }
            this.proxy.reportSetEndSetSuccess(setKey, String.valueOf(data.optInt("itemId")));
            this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$e;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public e(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            if (data.has("themeFontId")) {
                this.proxy.themeFontSetUp(setKey, data.optInt("themeFontId"));
            } else {
                this.proxy.fontSetUp(setKey, data.optInt("itemId"), data.optInt("type"));
            }
            this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$f;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class f implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"o13/a$f$a", "Leipc/EIPCCallback$Stub;", "Leipc/EIPCResult;", "result", "", "callback", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: o13.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class BinderC10878a extends EIPCCallback.Stub {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f421737e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f421738f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f421739h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ JSONObject f421740i;

            BinderC10878a(String str, int i3, String str2, JSONObject jSONObject) {
                this.f421737e = str;
                this.f421738f = i3;
                this.f421739h = str2;
                this.f421740i = jSONObject;
            }

            @Override // eipc.EIPCCallback
            public void callback(EIPCResult result) throws RemoteException {
                String str;
                Intrinsics.checkNotNullParameter(result, "result");
                int i3 = result.data.getInt("result");
                try {
                    f.this.proxy.cardSingleStepEndReport(this.f421737e, this.f421738f, 2, i3);
                    WebViewPlugin plugin = f.this.proxy.getPlugin();
                    String str2 = this.f421739h;
                    String[] strArr = new String[1];
                    if (i3 == 0) {
                        str = "";
                    } else {
                        str = "\u83b7\u53d6\u8d44\u6599\u5361\u540d\u7247\u534f\u8bae\u63a5\u53e3\u8fd4\u56de\u5931\u8d25";
                    }
                    strArr[0] = new w33.b(i3, str).toString();
                    plugin.callJs(str2, strArr);
                } catch (Exception unused) {
                    QLog.e("BusinessStrategyFactory", 1, "cardProfileGetInfo parse error" + this.f421740i);
                }
            }
        }

        public f(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            this.proxy.cardProfileGetInfo(setKey, true, new BinderC10878a(setKey, data.optInt("itemId"), callbackId, data));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$g;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class g implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public g(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            this.proxy.themeSetUp(setKey, String.valueOf(data.optInt("itemId")), callbackId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo13/a$h;", "Lw33/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class h implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public h(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                return;
            }
            this.proxy.reportSetEndSetSuccess(setKey, String.valueOf(data.optInt("itemId")));
            VasUtil.getService().getVipDataProxy().requestAndUpdateData(currentAccountUin);
            this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lo13/a$b;", "Lw33/a;", "Lorg/json/JSONArray;", "batchSet", "", "b", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "callbackId", "a", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements w33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final VasCommonJsbProxy proxy;

        public b(VasCommonJsbProxy proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        private final void b(JSONArray batchSet) {
            int length = batchSet.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = batchSet.optJSONObject(i3);
                String uin = optJSONObject.optString("uin");
                int optInt = optJSONObject.optInt("type");
                String imageName = optJSONObject.optString("imageName");
                int optInt2 = optJSONObject.optInt("effectId");
                IGXHManager gxh = VasUtil.getService().getGxh();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                Intrinsics.checkNotNullExpressionValue(imageName, "imageName");
                gxh.setCustomChatBackground(uin, imageName, optInt2, optInt, true);
            }
        }

        @Override // w33.a
        public void a(JSONObject data, String setKey, String callbackId) {
            String shopBgPath;
            String valueOf;
            JSONArray optJSONArray;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            int optInt = data.optInt("itemId");
            if (optInt == 99 && (optJSONArray = data.optJSONArray("batchSet")) != null) {
                b(optJSONArray);
                this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
                return;
            }
            Intent intent = this.proxy.getPlugin().mRuntime.a().getIntent();
            if (optInt == 100) {
                shopBgPath = "null";
            } else {
                shopBgPath = ChatBackgroundUtil.getShopBgPath(String.valueOf(optInt));
                Intrinsics.checkNotNullExpressionValue(shopBgPath, "{\n                ChatBa\u2026toString())\n            }");
            }
            String str = shopBgPath;
            int optInt2 = data.optInt(VipFunCallConstants.KEY_FEET_TYPE);
            String name = data.optString("name");
            String optString = data.optString("friendUin");
            if (optInt == 100) {
                valueOf = "theme_1000";
            } else {
                valueOf = String.valueOf(optInt);
            }
            VasCommonJsbProxy vasCommonJsbProxy = this.proxy;
            if (optString == null || optString.length() == 0) {
                optString = null;
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            vasCommonJsbProxy.chatBackgroundSetUp(setKey, valueOf, optString, str, name, "", optInt2, intent);
            this.proxy.getPlugin().callJs(callbackId, new w33.b(0, "").toString());
            VasUtil.getService().getGxh().forceUpdateVasUserData(1);
        }
    }
}
