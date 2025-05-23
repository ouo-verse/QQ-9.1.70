package af2;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Laf2/c;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    public static final c f25997d = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"af2/c$a", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceSchemeCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements Function1<JSONObject, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25998d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f25999e;

        a(String str, int i3) {
            this.f25998d = str;
            this.f25999e = i3;
        }

        public void a(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (QLog.isColorLevel()) {
                QLog.d("ECPluginIPCHelper", 2, "ACTION_HANDLE_SCHEME: url=" + this.f25998d + ", callback data=" + data);
            }
            Bundle bundle = new Bundle();
            bundle.putString("DATA_JSON", data.toString());
            c.f25997d.callbackResult(this.f25999e, EIPCResult.createSuccessResult(bundle));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
            a(jSONObject);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"af2/c$b", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceSchemeCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements Function1<JSONObject, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f26000d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f26001e;

        b(int i3, int i16) {
            this.f26000d = i3;
            this.f26001e = i16;
        }

        public void a(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (QLog.isColorLevel()) {
                QLog.d("ECPluginIPCHelper", 2, "ACTION_HANDLE_SCHEME_TARGET: target=" + this.f26000d + ", callback data=" + data);
            }
            Bundle bundle = new Bundle();
            bundle.putString("DATA_JSON", data.toString());
            c.f25997d.callbackResult(this.f26001e, EIPCResult.createSuccessResult(bundle));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
            a(jSONObject);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"af2/c$c", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: af2.c$c, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0034c implements Function1<HashMap<String, Object>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f26002d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f26003e;

        C0034c(int i3, int i16) {
            this.f26002d = i3;
            this.f26003e = i16;
        }

        public void a(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (QLog.isColorLevel()) {
                QLog.d("ECPluginIPCHelper", 2, "ACTION_HANDLE_LOGIC: logicType=" + this.f26002d + ", callback data=" + result);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("DATA_HASH_MAP", result);
            c.f25997d.callbackResult(this.f26003e, EIPCResult.createSuccessResult(bundle));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
            a(hashMap);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"af2/c$d", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/ECQQRemoteResponse;", "successResponse", "", "a", "errorResponse", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class d implements com.tencent.mobileqq.qqecommerce.biz.sdk.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26004a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f26005b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f26006c;

        d(String str, String str2, int i3) {
            this.f26004a = str;
            this.f26005b = str2;
            this.f26006c = i3;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.a
        public void a(ECQQRemoteResponse successResponse) {
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            if (QLog.isColorLevel()) {
                QLog.d("ECPluginIPCHelper", 2, "ACTION_SEND_PACKAGE: onSuccess service=" + this.f26004a + ", method=" + this.f26005b + ", callback data=" + successResponse);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("SENDER_CALLBACK_TYPE", 1);
            bundle.putSerializable("SENDER_CALLBACK_RESULT", successResponse);
            c.f25997d.callbackResult(this.f26006c, EIPCResult.createSuccessResult(bundle));
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.a
        public void b(ECQQRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            if (QLog.isColorLevel()) {
                QLog.d("ECPluginIPCHelper", 2, "ACTION_SEND_PACKAGE: onError service=" + this.f26004a + ", method=" + this.f26005b + ", callback data=" + errorResponse);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("SENDER_CALLBACK_TYPE", 2);
            bundle.putSerializable("SENDER_CALLBACK_RESULT", errorResponse);
            c.f25997d.callbackResult(this.f26006c, EIPCResult.createSuccessResult(bundle));
        }
    }

    c() {
        super("ECPluginIPCHelper");
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, int callbackId) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d("ECPluginIPCHelper", 2, "onCall: action=" + action);
        }
        boolean z16 = params.getBoolean("CALL_BACK");
        switch (action.hashCode()) {
            case -1366525216:
                if (action.equals("ACTION_DATA_REPORT")) {
                    String action2 = params.getString("DATA_ACTION", "");
                    Serializable serializable = params.getSerializable("DATA_HASH_MAP");
                    HashMap<Object, Object> hashMap = serializable instanceof HashMap ? (HashMap) serializable : null;
                    QQECommerceSdkManager qQECommerceSdkManager = QQECommerceSdkManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(action2, "action");
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    qQECommerceSdkManager.dataReport(action2, hashMap);
                    break;
                }
                break;
            case 194788816:
                if (action.equals("ACTION_HANDLE_LOGIC")) {
                    int i3 = params.getInt("DATA_LOGIC");
                    Serializable serializable2 = params.getSerializable("DATA_HASH_MAP");
                    HashMap<String, String> hashMap2 = serializable2 instanceof HashMap ? (HashMap) serializable2 : null;
                    C0034c c0034c = z16 ? new C0034c(i3, callbackId) : null;
                    QQECommerceSdkManager qQECommerceSdkManager2 = QQECommerceSdkManager.INSTANCE;
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap<>();
                    }
                    qQECommerceSdkManager2.handleLogic(i3, hashMap2, c0034c);
                    break;
                }
                break;
            case 1014461640:
                if (action.equals("ACTION_INIT_CONFIG")) {
                    QQECommerceSdkManager.INSTANCE.iniSdkConfig();
                    break;
                }
                break;
            case 1636342269:
                if (action.equals("ACTION_HANDLE_SCHEME_TARGET")) {
                    int i16 = params.getInt("DATA_TARGET");
                    Serializable serializable3 = params.getSerializable("DATA_HASH_MAP");
                    HashMap<String, String> hashMap3 = serializable3 instanceof HashMap ? (HashMap) serializable3 : null;
                    b bVar = z16 ? new b(i16, callbackId) : null;
                    QQECommerceSdkManager qQECommerceSdkManager3 = QQECommerceSdkManager.INSTANCE;
                    if (hashMap3 == null) {
                        hashMap3 = new HashMap<>();
                    }
                    qQECommerceSdkManager3.handleScheme(i16, hashMap3, bVar);
                    break;
                }
                break;
            case 1932834131:
                if (action.equals("ACTION_HANDLE_SCHEME")) {
                    String url = params.getString("DATA_URL", "");
                    Serializable serializable4 = params.getSerializable("DATA_HASH_MAP");
                    HashMap<String, String> hashMap4 = serializable4 instanceof HashMap ? (HashMap) serializable4 : null;
                    a aVar = z16 ? new a(url, callbackId) : null;
                    if (hashMap4 != null) {
                        QQECommerceSdkManager qQECommerceSdkManager4 = QQECommerceSdkManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        qQECommerceSdkManager4.handleScheme(url, aVar, hashMap4);
                        break;
                    } else {
                        QQECommerceSdkManager qQECommerceSdkManager5 = QQECommerceSdkManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        qQECommerceSdkManager5.handleScheme(url, aVar);
                        break;
                    }
                }
                break;
            case 2075780568:
                if (action.equals("ACTION_SEND_PACKAGE")) {
                    String service = params.getString("DATA_SERVICE", "");
                    String method = params.getString("DATA_METHOD", "");
                    byte[] byteArray = params.getByteArray("DATA_BYTE_ARRAY");
                    Serializable serializable5 = params.getSerializable("DATA_HASH_MAP");
                    HashMap<Object, Object> hashMap5 = serializable5 instanceof HashMap ? (HashMap) serializable5 : null;
                    d dVar = z16 ? new d(service, method, callbackId) : null;
                    QQECommerceSdkManager qQECommerceSdkManager6 = QQECommerceSdkManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(service, "service");
                    Intrinsics.checkNotNullExpressionValue(method, "method");
                    qQECommerceSdkManager6.sendPackage(service, method, byteArray, hashMap5, dVar);
                    break;
                }
                break;
        }
        return new EIPCResult();
    }
}
