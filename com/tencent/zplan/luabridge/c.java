package com.tencent.zplan.luabridge;

import android.os.IBinder;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.zplan.b;
import com.tencent.zplan.h;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/luabridge/c;", "Lcom/tencent/zplan/luabridge/a;", "", AdMetricTag.EVENT_NAME, "params", "Lcom/tencent/zplan/luabridge/a$b;", "listener", "", "bUseLog", "", "b", "callLua", "Lorg/json/JSONObject;", "a", "Lcom/tencent/zplan/h;", "Lcom/tencent/zplan/h;", "getZPlanService", "()Lcom/tencent/zplan/h;", "zPlanService", "<init>", "(Lcom/tencent/zplan/h;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h zPlanService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/luabridge/c$b", "Lcom/tencent/zplan/b$a;", "", "onExecuteLua", "", StateEvent.ProcessResult.SUCCEED, "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b extends b.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f385708d;

        b(a.b bVar) {
            this.f385708d = bVar;
        }

        @Override // com.tencent.zplan.b
        public void onExecuteLua() {
            this.f385708d.onExecuteLua();
        }

        @Override // com.tencent.zplan.b
        public void onLuaResult(boolean succeed, @Nullable String result) {
            this.f385708d.onLuaResult(succeed, result);
        }
    }

    public c(@NotNull h zPlanService) {
        Intrinsics.checkNotNullParameter(zPlanService, "zPlanService");
        this.zPlanService = zPlanService;
    }

    private final void b(String eventName, String params, a.b listener, boolean bUseLog) {
        b bVar;
        ux4.b bVar2 = ux4.b.f440566e;
        if (bVar2.j(eventName)) {
            if (params == null) {
                params = "{}";
            }
            bVar2.a(eventName, new JSONObject(params), listener, bUseLog);
            return;
        }
        if (!a()) {
            ZLog.f386189b.f("[zplan]RemoteLuaCaller", "[realCallLua] isBinderAlive == false eventName=" + eventName + " params=" + params);
            return;
        }
        try {
            h hVar = this.zPlanService;
            if (listener != null) {
                bVar = new b(listener);
            } else {
                bVar = null;
            }
            hVar.s4(eventName, params, bVar, bUseLog);
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]RemoteLuaCaller", "[realCallLua] failed", e16);
        }
    }

    public boolean a() {
        IBinder asBinder = this.zPlanService.asBinder();
        Intrinsics.checkNotNullExpressionValue(asBinder, "zPlanService.asBinder()");
        return asBinder.isBinderAlive();
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        b(eventName, null, listener, bUseLog);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @NotNull String params, @Nullable a.b listener) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        b(eventName, params, listener, true);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @NotNull String params, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        b(eventName, params, listener, bUseLog);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @NotNull JSONObject params, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        b(eventName, params.toString(), listener, bUseLog);
    }
}
