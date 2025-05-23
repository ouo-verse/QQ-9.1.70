package com.tencent.zplan.luabridge.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.plugins.DatongReportPlugin;
import com.tencent.zplan.utils.ZLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import zx4.t;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/DatongReportPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleReport", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class DatongReportPlugin extends LuaBasePlugin {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final lx4.f f385712h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static final t f385713i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f385709d = "DatongReportPlugin";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f385710e = "eventId";

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f385711f = "paramMap";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/DatongReportPlugin$a;", "", "", "TAG", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "KEY_EVENT_ID", "a", "KEY_PARAMS", "b", "Lzx4/t;", "reporter", "Lzx4/t;", "c", "()Lzx4/t;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.plugins.DatongReportPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a() {
            return DatongReportPlugin.f385710e;
        }

        @NotNull
        public final String b() {
            return DatongReportPlugin.f385711f;
        }

        @Nullable
        public final t c() {
            return DatongReportPlugin.f385713i;
        }

        @NotNull
        public final String d() {
            return DatongReportPlugin.f385709d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        mx4.a aVar = mx4.a.f417748a;
        Object a16 = aVar.a(lx4.f.class);
        Intrinsics.checkNotNull(a16);
        f385712h = (lx4.f) a16;
        f385713i = (t) aVar.a(t.class);
    }

    @LuaEvent("L2N_DatongReport")
    @Nullable
    public final String handleReport(@NotNull final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (TextUtils.isEmpty(argument.getParams())) {
            ZLog.f386189b.d(f385709d, 1, "L2N_DatongReport params empty");
            return argument.fail();
        }
        f.a.c(f385712h, new Runnable() { // from class: com.tencent.zplan.luabridge.plugins.DatongReportPlugin$handleReport$task$1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject = new JSONObject(LuaArgument.this.getParams());
                DatongReportPlugin.Companion companion = DatongReportPlugin.INSTANCE;
                String eventId = jSONObject.optString(companion.a());
                JSONObject optJSONObject = jSONObject.optJSONObject(companion.b());
                ZLog zLog = ZLog.f386189b;
                zLog.i(companion.d(), 1, "L2N_DatongReport " + eventId);
                if (!TextUtils.isEmpty(eventId) && optJSONObject != null) {
                    HashMap hashMap = new HashMap();
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        String optString = optJSONObject.optString(key);
                        if (optString != null) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            hashMap.put(key, optString);
                        }
                    }
                    t c16 = DatongReportPlugin.INSTANCE.c();
                    if (c16 != null) {
                        Intrinsics.checkNotNullExpressionValue(eventId, "eventId");
                        c16.report(eventId, hashMap);
                        return;
                    }
                    return;
                }
                zLog.d(companion.d(), 1, "L2N_DatongReport params error");
            }
        }, 0L, 2, null);
        return argument.ok();
    }
}
