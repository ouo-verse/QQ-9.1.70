package com.tencent.sqshow.zootopia.nativeui.ue;

import b94.a;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;
import uv4.am;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J@\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J,\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/aa;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Lb94/a;", "Lcom/tencent/zplan/luabridge/a;", DomainData.DOMAIN_NAME, "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "getType", "", "params", "Lcom/tencent/zplan/luabridge/a$b;", "cb", "l", "from", "Lqu4/a;", "avatarCharacter", "Lorg/json/JSONObject;", "clickedItemParam", "tag", "Lcom/tencent/zplan/zplantracing/b;", "zplanSpan", "d", "Ls94/b;", "data", "b", "Ls94/a;", "j", "Luv4/am;", "aiCameraCfg", "currentCameraCfg", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "e", "k", "Z", "mServiceConnected", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aa implements ZPlanEngineStatusUpdateListener, b94.a {

    /* renamed from: d, reason: collision with root package name */
    public static final aa f371327d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mServiceConnected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371329d;

        a(a.b bVar) {
            this.f371329d = bVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("UEAvatarOperator_", 1, "changeAvatarDress onLuaResult:{success:" + success + ", result:" + result + "}");
            a.b bVar = this.f371329d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            QLog.i("UEAvatarOperator_", 1, "changeAvatarDress onExecuteLua");
            a.b bVar = this.f371329d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371330d;

        b(a.b bVar) {
            this.f371330d = bVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("UEAvatarOperator_", 1, "changeFaceControlPoint onLuaResult:{success:" + success + ", result:" + result + "}");
            a.b bVar = this.f371330d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            QLog.i("UEAvatarOperator_", 1, "changeFaceControlPoint onExecuteLua");
            a.b bVar = this.f371330d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$c", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371331d;

        c(a.b bVar) {
            this.f371331d = bVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("UEAvatarOperator_", 1, "enterAiMakeFace onLuaResult:{success:" + success + ", result:" + result + "}");
            a.b bVar = this.f371331d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            QLog.i("UEAvatarOperator_", 1, "enterAiMakeFace onExecuteLua");
            a.b bVar = this.f371331d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$d", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371332d;

        d(a.b bVar) {
            this.f371332d = bVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("UEAvatarOperator_", 1, "resetRotation onLuaResult:{success:" + success + ", result:" + result + "}");
            a.b bVar = this.f371332d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            QLog.i("UEAvatarOperator_", 1, "resetRotation onExecuteLua");
            a.b bVar = this.f371332d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$e", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f371334e;

        e(a.b bVar, String str) {
            this.f371333d = bVar;
            this.f371334e = str;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b bVar = this.f371333d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
            QLog.i("UEAvatarOperator_", 1, "setCameraConfig onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b bVar = this.f371333d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
            QLog.i("UEAvatarOperator_", 1, "setCameraConfig params:" + this.f371334e + ", onLuaResult:{success:" + success + ", result:" + result + "}");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/aa$f", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f371335d;

        f(a.b bVar) {
            this.f371335d = bVar;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("UEAvatarOperator_", 1, "syncFaceInfo onLuaResult:{success:" + success + ", result:" + result + "}");
            a.b bVar = this.f371335d;
            if (bVar != null) {
                bVar.onLuaResult(success, result);
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            QLog.i("UEAvatarOperator_", 1, "syncFaceInfo onExecuteLua");
            a.b bVar = this.f371335d;
            if (bVar != null) {
                bVar.onExecuteLua();
            }
        }
    }

    static {
        aa aaVar = new aa();
        f371327d = aaVar;
        ZPlanServiceHelper.I.E0(aaVar);
    }

    aa() {
    }

    private final com.tencent.zplan.luabridge.a n() {
        if (t74.h.b()) {
            return ZPlanServiceHelper.I.S();
        }
        if (t74.h.e()) {
            return ZPlanLuaBridge.INSTANCE;
        }
        return null;
    }

    @Override // b94.a
    public FilamentUrlTemplate a() {
        return a.C0113a.c(this);
    }

    @Override // b94.a
    public void b(FaceInfoSyncData data, a.b cb5) {
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = data.f().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toJson().toString()");
        QLog.i("UEAvatarOperator_", 1, "syncFaceInfo paramStr:" + jSONObject);
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_SyncFaceInfo", jSONObject, new f(cb5));
        }
    }

    @Override // b94.a
    public void c(boolean z16) {
        a.C0113a.g(this, z16);
    }

    @Override // b94.a
    public void d(String from, qu4.a avatarCharacter, JSONObject clickedItemParam, String tag, a.b cb5, com.tencent.zplan.zplantracing.b zplanSpan) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        JSONObject h16 = r94.c.h(avatarCharacter);
        if (clickedItemParam != null) {
            h16.put("clicked_item_data", clickedItemParam);
        }
        if (tag != null) {
            h16.put("tag", tag);
        }
        String jSONObject = h16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "paramJson.toString()");
        QLog.i("UEAvatarOperator_", 1, "changeAvatarDress taskFrom:" + from + " , tag = " + tag);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("changeAvatarDress paramStr:");
        sb5.append(jSONObject);
        QLog.i("UEAvatarOperator_", 1, sb5.toString());
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_ChangeAvatarDress", jSONObject, new a(cb5));
        }
    }

    @Override // b94.a
    public void e(am aiCameraCfg, am currentCameraCfg, a.b cb5, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(aiCameraCfg, "aiCameraCfg");
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("CameraInfo", r94.c.u(aiCameraCfg));
        if (currentCameraCfg != null) {
            jSONObject.put("CurrentCameraInfo", r94.c.u(currentCameraCfg));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "paramsJson.toString()");
        QLog.i("UEAvatarOperator_", 1, "enterAiMakeFace params:" + jSONObject2);
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_EnterAIMakeFace", jSONObject2, new c(cb5));
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.c(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    @Override // b94.a
    public void f() {
        a.C0113a.h(this);
    }

    @Override // b94.a
    public void g(qu4.a aVar) {
        a.C0113a.e(this, aVar);
    }

    @Override // b94.a
    public AvatarEngineType getType() {
        return AvatarEngineType.UE;
    }

    @Override // b94.a
    public void h(boolean z16) {
        a.C0113a.f(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // b94.a
    public void i() {
        a.C0113a.i(this);
    }

    @Override // b94.a
    public void j(FaceControlPointData data, a.b cb5) {
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = data.c().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toJson().toString()");
        QLog.i("UEAvatarOperator_", 1, "changeFaceControlPoint paramStr:" + jSONObject);
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_ChangeFaceUIControlPoint", jSONObject, new b(cb5));
        }
    }

    @Override // b94.a
    public void l(String params, a.b cb5) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("UEAvatarOperator_", 1, "setCameraConfig params:" + params);
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_SetCamera", params, new e(cb5, params));
        }
    }

    @Override // b94.a
    public void m(qu4.a aVar, com.tencent.zplan.zplantracing.b bVar) {
        a.C0113a.k(this, aVar, bVar);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        mServiceConnected = connect;
        QLog.i("UEAvatarOperator_", 1, "serviceConnected connect:" + connect);
    }

    @Override // b94.a
    public void k(a.b cb5) {
        QLog.i("UEAvatarOperator_", 1, "resetRotation ");
        com.tencent.zplan.luabridge.a n3 = n();
        if (n3 != null) {
            n3.callLua("N2L_ResetPlayerRotation", "{}", new d(cb5));
        }
    }
}
