package com.tencent.zplan.world.manager;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/zplan/world/manager/ZPlanWorldManager$doOnWorldThread$1"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f386259d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f386260e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f386261f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f386262h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f386263i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ IZPlanWorldListener f386264m;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$getZPlanWorld$1$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug", "com/tencent/zplan/world/manager/ZPlanWorldManager$$special$$inlined$doOnGetZPlanWorldIdle$lambda$1"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f386265d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 f386266e;

        a(long j3, ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1) {
            this.f386265d = j3;
            this.f386266e = zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, @Nullable String result) {
            ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
            ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 = this.f386266e;
            zPlanWorldManager.L(success, result, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386264m, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386261f, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386262h, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386260e, this.f386265d, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386263i);
        }
    }

    public ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1(String str, int i3, int i16, int i17, int i18, IZPlanWorldListener iZPlanWorldListener) {
        this.f386259d = str;
        this.f386260e = i3;
        this.f386261f = i16;
        this.f386262h = i17;
        this.f386263i = i18;
        this.f386264m = iZPlanWorldListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
        String str = this.f386259d;
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str);
        ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
        zPlanWorldManager2.O();
        zLog.k("ZPlanWorldManager", "doOnGetZPlanWorldIdle getZPlanWorlding: " + ZPlanWorldManager.g(zPlanWorldManager2));
        if (ZPlanWorldManager.g(zPlanWorldManager2)) {
            zPlanWorldManager2.x(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1$lambda$1

                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$getZPlanWorld$1$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug", "com/tencent/zplan/world/manager/ZPlanWorldManager$$special$$inlined$doOnGetZPlanWorldIdle$1$lambda$1"}, k = 1, mv = {1, 4, 2})
                /* loaded from: classes27.dex */
                public static final class a implements a.b {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f386267d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1$lambda$1 f386268e;

                    a(long j3, ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1$lambda$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1$lambda$1) {
                        this.f386267d = j3;
                        this.f386268e = zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1$lambda$1;
                    }

                    @Override // com.tencent.zplan.luabridge.a.b
                    public void onExecuteLua() {
                        a.b.C10064a.a(this);
                    }

                    @Override // com.tencent.zplan.luabridge.a.b
                    public void onLuaResult(boolean success, @Nullable String result) {
                        ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
                        ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 = ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this;
                        zPlanWorldManager.L(success, result, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386264m, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386261f, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386262h, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386260e, this.f386267d, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386263i);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog2 = ZLog.f386189b;
                    zLog2.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding true");
                    ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                    ZPlanWorldManager.getZPlanWorlding = true;
                    zLog2.k("ZPlanWorldManager", "getZPlanWorld scene : " + ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386260e + ", width : " + ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386261f + ", height : " + ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386262h);
                    ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1 = ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this;
                    if (!zPlanWorldManager3.I(zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386260e, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386263i, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386261f, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386262h, zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.f386264m)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("createWorld scene : ");
                        sb5.append(ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386260e);
                        sb5.append(", width : ");
                        sb5.append(ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386261f);
                        sb5.append(", ");
                        sb5.append("height: ");
                        sb5.append(ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386262h);
                        sb5.append(", thread: ");
                        sb5.append(Thread.currentThread());
                        sb5.append(", ");
                        sb5.append("threadnbame : ");
                        Thread currentThread = Thread.currentThread();
                        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                        sb5.append(currentThread.getName());
                        zLog2.k("ZPlanWorldManager", sb5.toString());
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("Width", ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386261f);
                        jSONObject.put("Height", ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1.this.f386262h);
                        jSONObject.put("DrawMode", 0);
                        zLog2.l("ZPlanWorldManager", "createWorld : ", new StackPrinter("createWorld"));
                        ZPlanLuaBridge.INSTANCE.callLua("N2L_CreateWorld", jSONObject, (a.b) new a(currentTimeMillis, this), true);
                    }
                }
            });
        } else {
            zLog.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding true");
            ZPlanWorldManager.getZPlanWorlding = true;
            zLog.k("ZPlanWorldManager", "getZPlanWorld scene : " + this.f386260e + ", width : " + this.f386261f + ", height : " + this.f386262h);
            if (!zPlanWorldManager2.I(this.f386260e, this.f386263i, this.f386261f, this.f386262h, this.f386264m)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("createWorld scene : ");
                sb5.append(this.f386260e);
                sb5.append(", width : ");
                sb5.append(this.f386261f);
                sb5.append(", ");
                sb5.append("height: ");
                sb5.append(this.f386262h);
                sb5.append(", thread: ");
                sb5.append(Thread.currentThread());
                sb5.append(", ");
                sb5.append("threadnbame : ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getName());
                zLog.k("ZPlanWorldManager", sb5.toString());
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Width", this.f386261f);
                jSONObject.put("Height", this.f386262h);
                jSONObject.put("DrawMode", 0);
                zLog.l("ZPlanWorldManager", "createWorld : ", new StackPrinter("createWorld"));
                ZPlanLuaBridge.INSTANCE.callLua("N2L_CreateWorld", jSONObject, (a.b) new a(currentTimeMillis, this), true);
            }
        }
        zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str);
    }
}
