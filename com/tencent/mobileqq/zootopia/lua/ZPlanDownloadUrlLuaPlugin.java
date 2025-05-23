package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanDownloadUrlLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "errorCode", "", "errorMessage", "", "c", "downUrlRequest", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanDownloadUrlLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanDownloadUrlLuaPlugin> f328379e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanDownloadUrlLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanDownloadUrlLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanDownloadUrlLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanDownloadUrlLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanDownloadUrlLuaPlugin a() {
            return (ZPlanDownloadUrlLuaPlugin) ZPlanDownloadUrlLuaPlugin.f328379e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanDownloadUrlLuaPlugin$b", "Lcom/tencent/mobileqq/zootopia/ipc/e;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lnx4/a$b;", "result", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlRspInfo", "", "b", "errorCode", "errorMessage", "onDownloadFailed", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328380a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f328381b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328382c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZPlanDownloadUrlLuaPlugin f328383d;

        b(LuaArgument luaArgument, long j3, String str, ZPlanDownloadUrlLuaPlugin zPlanDownloadUrlLuaPlugin) {
            this.f328380a = luaArgument;
            this.f328381b = j3;
            this.f328382c = str;
            this.f328383d = zPlanDownloadUrlLuaPlugin;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.e
        public void a(int errorCode, String errorMessage) {
            this.f328383d.c(this.f328380a, errorCode, errorMessage);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.e
        public void b(int statusCode, String filePath, a.b result, ZPlanResDownloadUrlRsp urlRspInfo) {
            Intrinsics.checkNotNullParameter(urlRspInfo, "urlRspInfo");
            QLog.i("ZPlanDownloadUrlLuaPlugin", 1, "downUrlRequest, " + this.f328380a + " callbackSuccess, costTime= " + (System.currentTimeMillis() - this.f328381b));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("url", urlRspInfo.getFullUrl());
            if (filePath == null) {
                filePath = "";
            }
            jSONObject.put("local_path", filePath);
            jSONObject.put("asset_path", this.f328382c);
            jSONObject.put("md5", urlRspInfo.getMd5());
            this.f328380a.callback(jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.e
        public void onDownloadFailed(int errorCode, String errorMessage) {
            this.f328383d.c(this.f328380a, errorCode, errorMessage);
        }
    }

    static {
        Lazy<ZPlanDownloadUrlLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanDownloadUrlLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanDownloadUrlLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanDownloadUrlLuaPlugin invoke() {
                return new ZPlanDownloadUrlLuaPlugin();
            }
        });
        f328379e = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(LuaArgument argument, int errorCode, String errorMessage) {
        QLog.e("ZPlanDownloadUrlLuaPlugin", 1, "downUrlRequest, " + argument + " callbackFail: " + errorCode + ", " + errorMessage);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", errorCode);
        jSONObject.put("err_msg", errorMessage);
        argument.callback(jSONObject.toString());
    }

    @LuaEvent("L2N_DownURLRequest")
    public final String downUrlRequest(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanDownloadUrlLuaPlugin", 1, "downUrlRequest, " + argument + ", " + argument.getF440574c() + ", nativeUeEnv= " + com.tencent.sqshow.zootopia.utils.ab.INSTANCE.d());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String path = jSONObject.optString("Path");
        String urlFromParam = jSONObject.optString("Url");
        if (TextUtils.isEmpty(path)) {
            c(argument, -99901, "path is empty");
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ipc.n nVar = (com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class);
        Intrinsics.checkNotNullExpressionValue(path, "path");
        Intrinsics.checkNotNullExpressionValue(urlFromParam, "urlFromParam");
        nVar.downloadResByPath(new ZPlanResDownloadReq(path, urlFromParam, null, 4, null), new b(argument, currentTimeMillis, path, this));
        return "";
    }
}
