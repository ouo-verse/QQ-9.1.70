package com.tencent.zplan.luabridge;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/luabridge/a;", "", "", AdMetricTag.EVENT_NAME, "Lcom/tencent/zplan/luabridge/a$b;", "listener", "", "bUseLog", "", "callLua", "params", "Lorg/json/JSONObject;", "b", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10063a {
        public static /* synthetic */ void a(a aVar, String str, b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                aVar.callLua(str, bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callLua");
        }

        public static /* synthetic */ void b(a aVar, String str, String str2, b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bVar = null;
                }
                aVar.callLua(str, str2, bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callLua");
        }

        public static /* synthetic */ void c(a aVar, String str, String str2, b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bVar = null;
                }
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                aVar.callLua(str, str2, bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callLua");
        }

        public static /* synthetic */ void d(a aVar, String str, JSONObject jSONObject, b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bVar = null;
                }
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                aVar.callLua(str, jSONObject, bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callLua");
        }
    }

    void callLua(@NotNull String eventName, @Nullable b listener, boolean bUseLog);

    void callLua(@NotNull String eventName, @NotNull String params, @Nullable b listener);

    void callLua(@NotNull String eventName, @NotNull String params, @Nullable b listener, boolean bUseLog);

    void callLua(@NotNull String eventName, @NotNull JSONObject params, @Nullable b listener, boolean bUseLog);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/luabridge/a$b;", "", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface b {
        void onExecuteLua();

        void onLuaResult(boolean success, @Nullable String result);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.tencent.zplan.luabridge.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static final class C10064a {
            public static void a(@NotNull b bVar) {
            }

            public static void b(@NotNull b bVar, boolean z16, @Nullable String str) {
            }
        }
    }
}
