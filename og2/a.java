package og2;

import android.content.Intent;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Log2/a;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "Lcom/tencent/mm/opensdk/modelmsg/SendAuth$Resp;", "resp", "", "a", "", "c", "d", "Landroid/content/Intent;", "intent", "b", "Log2/c;", "listener", "e", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "req", "onReq", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "onResp", "", "Ljava/lang/String;", "wxAppId", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "f", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxApi", h.F, "Log2/c;", "wxAuthListener", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IWXAPIEventHandler {

    /* renamed from: d, reason: collision with root package name */
    public static final a f422654d = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String wxAppId = "wxa97c4edf8894340d";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final IWXAPI wxApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static c wxAuthListener;

    static {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(MobileQQ.sMobileQQ, "wxa97c4edf8894340d", true);
        createWXAPI.registerApp("wxa97c4edf8894340d");
        createWXAPI.setLogImpl(C10909a.f422658a);
        Intrinsics.checkNotNullExpressionValue(createWXAPI, "createWXAPI(MobileQQ.sMo\u2026ogImpl(ECWXAuthLog)\n    }");
        wxApi = createWXAPI;
    }

    a() {
    }

    private final void a(SendAuth.Resp resp) {
        int i3 = resp.errCode;
        String str = resp.errStr;
        QLog.d("ECWXAuthComponent", 2, "handleWXAuthResp, errorCode = " + i3 + ", errorMsg = " + str);
        c cVar = wxAuthListener;
        if (cVar != null) {
            cVar.a(i3, str, resp.code);
        }
        wxAuthListener = null;
    }

    private final boolean c() {
        boolean contains$default;
        boolean contains$default2;
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String lowerCase = MODEL.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null);
        if (!contains$default) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            String lowerCase2 = MANUFACTURER.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null);
            if (!contains$default2) {
                return false;
            }
        }
        return true;
    }

    public final void b(Intent intent) {
        wxApi.handleIntent(intent, this);
    }

    public final boolean d() {
        return wxApi.isWXAppInstalled();
    }

    public final void e(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("ECWXAuthComponent", 1, "start reqWXAuthCode.");
        wxAuthListener = listener;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "qq_wx_login";
        if (c()) {
            QLog.d("ECWXAuthComponent", 1, "vivo system, use WXEntryActivityCompat.");
            SendAuth.Options options = new SendAuth.Options();
            options.callbackClassName = "com.tencent.mobileqq.wxapi.WXEntryActivityCompat";
            req.options = options;
        }
        wxApi.sendReq(req);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq req) {
        QLog.d("ECWXAuthComponent", 1, "onReq.");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp resp) {
        QLog.d("ECWXAuthComponent", 1, "onResp");
        if (resp instanceof SendAuth.Resp) {
            a((SendAuth.Resp) resp);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Log2/a$a;", "Lcom/tencent/mm/opensdk/utils/ILog;", "", "tag", "msg", "", "v", "d", "i", "w", "e", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: og2.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10909a implements ILog {

        /* renamed from: a, reason: collision with root package name */
        public static final C10909a f422658a = new C10909a();

        C10909a() {
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void d(String tag, String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            QLog.d(tag, 1, msg2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void e(String tag, String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            QLog.e(tag, 1, msg2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void i(String tag, String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            QLog.i(tag, 1, msg2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void v(String tag, String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            QLog.d(tag, 1, msg2);
        }

        @Override // com.tencent.mm.opensdk.utils.ILog
        public void w(String tag, String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            QLog.w(tag, 1, msg2);
        }
    }
}
