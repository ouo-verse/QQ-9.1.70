package com.tencent.mobileqq.zplan.smallhome;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import defpackage.UEBuglyInfoRecorder;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/i;", "", "Lcom/tencent/zplan/luabridge/a;", "a", "", "mapId", "", "nativeId", "", "b", "d", "", "enable", "f", "e", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f335703a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/i$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements a.b {
        a() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapBackToFrontEnd onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapBackToFrontEnd onLuaResult, success: " + success + ", result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/i$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapClearResource onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapClearResource onLuaResult, success: " + success + ", result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/i$c", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements a.b {
        c() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapExitFromNative onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapExitFromNative onLuaResult, success: " + success + ", result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/i$d", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements a.b {
        d() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapSwitchToFloatingWindow onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            QLog.d("ZPlanUeOperater", 1, "N2L_MapSwitchToFloatingWindow onLuaResult, success: " + success + ", result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/i$e", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements a.b {
        e() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
            QLog.d("ZPlanUeOperater", 1, "N2L_ShowUVAni onExecuteLua");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            QLog.d("ZPlanUeOperater", 1, "N2L_ShowUVAni onLuaResult, success: " + success + ", result: " + result);
        }
    }

    i() {
    }

    private final com.tencent.zplan.luabridge.a a() {
        if (t74.h.b()) {
            return ZPlanServiceHelper.I.S();
        }
        if (t74.h.e()) {
            return ZPlanLuaBridge.INSTANCE;
        }
        QLog.d("ZPlanUeOperater", 1, "getLuaCaller can only call by MAIN or ZPLAN process!");
        return null;
    }

    public final void b(int mapId, String nativeId) {
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mapId", mapId);
        jSONObject.put("nativeId", nativeId);
        com.tencent.zplan.luabridge.a a16 = a();
        if (a16 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            a16.callLua("N2L_MapBackToFrontEnd", jSONObject2, new a());
        }
    }

    public final void c() {
        com.tencent.zplan.luabridge.a a16 = a();
        if (a16 != null) {
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            a16.callLua("N2L_MapClearResource", jSONObject, new b());
        }
    }

    public final void d(int mapId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mapId", mapId);
        QLog.i("ZPlanUeOperater", 1, "N2L_MapExitFromNative BEGIN - " + jSONObject);
        com.tencent.zplan.luabridge.a a16 = a();
        if (a16 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            a16.callLua("N2L_MapExitFromNative", jSONObject2, new c());
        }
        i.Companion companion = k74.i.INSTANCE;
        ((yk3.d) companion.a(yk3.d.class)).clearInvalidModRes(mapId);
        if (t74.h.e()) {
            UEBuglyInfoRecorder.f25109a.onSmallHomeExit();
        } else {
            ((defpackage.c) companion.a(defpackage.c.class)).onSmallHomeExit();
        }
    }

    public final void e(int mapId, String nativeId) {
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mapId", mapId);
        jSONObject.put("nativeId", nativeId);
        com.tencent.zplan.luabridge.a a16 = a();
        if (a16 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            a16.callLua("N2L_MapSwitchToFloatingWindow", jSONObject2, new d());
        }
    }

    public final void f(boolean enable) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enable", enable ? 1 : 0);
        QLog.d("ZPlanUeOperater", 1, "setShowUVAni " + jSONObject);
        com.tencent.zplan.luabridge.a a16 = a();
        if (a16 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            a16.callLua("N2L_ShowUVAni", jSONObject2, new e());
        }
    }
}
