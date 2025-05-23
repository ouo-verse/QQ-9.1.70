package com.tencent.ecommerce.base.plugin;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J6\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J*\u0010\u0012\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/b;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "", "g", "url", "", h.F, "c", "", "target", "d", "Landroid/app/Application;", "application", "e", "f", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f100883a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/base/plugin/b$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f100884a;

        a(HashMap hashMap) {
            this.f100884a = hashMap;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            QQEcommerceSdk.INSTANCE.onEvent(new ECPluginServiceEvent(this.f100884a, data));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/base/plugin/b$b", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.plugin.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static final class C1033b implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f100885a;

        C1033b(HashMap hashMap) {
            this.f100885a = hashMap;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            QQEcommerceSdk.INSTANCE.onEvent(new ECPluginServiceEvent(this.f100885a, data));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/plugin/b$c", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "result", "", "onResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c implements IECLogicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f100886a;

        c(HashMap hashMap) {
            this.f100886a = hashMap;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(HashMap<String, Object> result) {
            QQEcommerceSdk.INSTANCE.onEvent(new ECPluginServiceEvent(this.f100886a, result));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/base/plugin/b$d", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "", "result", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class d implements IECLoadSoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100887a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f100888b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f100889c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f100890d;

        d(String str, k kVar, String str2, HashMap hashMap) {
            this.f100887a = str;
            this.f100888b = kVar;
            this.f100889c = str2;
            this.f100890d = hashMap;
        }

        @Override // com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback
        public void loadResult(int result) {
            cg0.a.b("ECPluginHandler", "[loadPtsLiteSo] operation = " + this.f100887a + " result = " + result);
            boolean z16 = result == 0;
            xg0.a.f447957b.c(result, this.f100888b);
            if (z16) {
                b.f100883a.c(this.f100889c, this.f100890d);
                return;
            }
            IECPluginServiceDelegate pluginServiceDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
            if (pluginServiceDelegate != null) {
                pluginServiceDelegate.onPtsLoadFailed();
            }
            i.f101155b.d("\u52a0\u8f7d\u5e93\u5931\u8d25", ECToastIcon.ICON_NONE, 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/base/plugin/b$e", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "", "result", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class e implements IECLoadSoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f100891a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f100892b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f100893c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f100894d;

        e(String str, k kVar, int i3, HashMap hashMap) {
            this.f100891a = str;
            this.f100892b = kVar;
            this.f100893c = i3;
            this.f100894d = hashMap;
        }

        @Override // com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback
        public void loadResult(int result) {
            cg0.a.b("ECPluginHandler", "[loadPtsLiteSo] operation = " + this.f100891a + " result = " + result);
            boolean z16 = result == 0;
            xg0.a.f447957b.c(result, this.f100892b);
            if (z16) {
                b.f100883a.d(this.f100893c, this.f100894d);
                return;
            }
            IECPluginServiceDelegate pluginServiceDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
            if (pluginServiceDelegate != null) {
                pluginServiceDelegate.onPtsLoadFailed();
            }
            i.f101155b.d("\u52a0\u8f7d\u5e93\u5931\u8d25", ECToastIcon.ICON_NONE, 1);
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String url, HashMap<String, String> params) {
        IECPluginServiceDelegate pluginServiceDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
        if (pluginServiceDelegate != null) {
            pluginServiceDelegate.onHandleScheme(url != null ? url : "", params);
        }
        HashMap hashMap = Intrinsics.areEqual(params.get("KEY_SCHEME_EXT_DATA"), String.valueOf(true)) ? new HashMap(params) : null;
        if (hashMap != null) {
            hashMap.remove("KEY_LOGIC_TYPE");
            hashMap.remove("KEY_SCHEME");
            hashMap.remove(TraeConstants.KEY_OPERATION);
            hashMap.remove("KEY_TARGET");
            hashMap.remove("KEY_CALLBACK");
            hashMap.remove("KEY_SCHEME_EXT_DATA");
        }
        ECScheme.c(url, new a(params), hashMap instanceof Map ? hashMap : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int target, HashMap<String, String> params) {
        IECPluginServiceDelegate pluginServiceDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
        if (pluginServiceDelegate != null) {
            pluginServiceDelegate.onHandleTargetScheme(target, params);
        }
        ECScheme.b(target, params, new C1033b(params));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(HashMap<String, String> params) {
        Integer intOrNull;
        xg0.a aVar = xg0.a.f447957b;
        boolean a16 = aVar.a();
        String str = params.get(TraeConstants.KEY_OPERATION);
        if (str == null) {
            return;
        }
        int hashCode = str.hashCode();
        if (hashCode == -1854658139) {
            if (str.equals("SCHEME")) {
                String str2 = params.get("KEY_SCHEME");
                if (h(str2) && !a16) {
                    k kVar = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_SO_LOAD);
                    IECPluginServiceDelegate pluginServiceDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
                    if (pluginServiceDelegate != null) {
                        pluginServiceDelegate.onHandlePtsLoad();
                    }
                    aVar.b(new d(str, kVar, str2, params));
                    return;
                }
                c(str2, params);
                return;
            }
            return;
        }
        if (hashCode != -120877942) {
            if (hashCode == 72611646 && str.equals("LOGIC")) {
                String str3 = params.get("KEY_LOGIC_TYPE");
                if (str3 != null && intOrNull != null) {
                    r5 = intOrNull.intValue();
                }
                IECPluginServiceDelegate pluginServiceDelegate2 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
                if (pluginServiceDelegate2 != null) {
                    pluginServiceDelegate2.onHandleLogic(r5, params);
                }
                ECLogicDispatcher.f100875b.a(r5, params, new c(params));
                return;
            }
            return;
        }
        if (str.equals("SCHME_BY_TARGET")) {
            String str4 = params.get("KEY_TARGET");
            r5 = str4 != null ? Integer.parseInt(str4) : 0;
            if (!a16) {
                k kVar2 = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_SO_LOAD);
                IECPluginServiceDelegate pluginServiceDelegate3 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPluginServiceDelegate();
                if (pluginServiceDelegate3 != null) {
                    pluginServiceDelegate3.onHandlePtsLoad();
                }
                aVar.b(new e(str, kVar2, r5, params));
                return;
            }
            d(r5, params);
        }
    }

    public final void e(Application application, HashMap<String, String> params) {
        if (!QQEcommerceSdk.INSTANCE.getHasInited()) {
            Log.e("ECPluginHandler", "handleNativeRequest: QQEcommerceSdk have not inited");
            return;
        }
        ECPluginApplication.Companion companion = ECPluginApplication.INSTANCE;
        if (!companion.b()) {
            companion.c(application);
        }
        cg0.a.b("ECPluginHandler", "handleNativeRequest, params=" + params);
        g(params);
    }

    public final void f(HashMap<String, String> params) {
        g(params);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(String url) {
        Integer intOrNull;
        if (url == null || url.length() == 0) {
            return true;
        }
        try {
            Uri parse = Uri.parse(url);
            if (parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("target");
                int intValue = (queryParameter == null || intOrNull == null) ? 0 : intOrNull.intValue();
                String queryParameter2 = parse.getQueryParameter("page_name");
                if (intValue == 52) {
                    if (Intrinsics.areEqual(queryParameter2, "qsearch_detail")) {
                        return false;
                    }
                }
            }
        } catch (Exception e16) {
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            cg0.a.a("ECPluginHandler", "needCheckPts", message);
        }
        return true;
    }
}
