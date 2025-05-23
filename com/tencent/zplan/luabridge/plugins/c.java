package com.tencent.zplan.luabridge.plugins;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.zplan.c;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import nx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/c;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "download", "<init>", "()V", "d", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/c$a;", "", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "b", "", "c", "L2N_Download", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.plugins.c$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/zplan/luabridge/plugins/c$a$a", "Lnx4/a;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lnx4/a$b;", "result", "a", "", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "onDownloadProgress", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.zplan.luabridge.plugins.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static final class C10065a implements nx4.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LuaArgument f385731a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef f385732b;

            C10065a(LuaArgument luaArgument, Ref.ObjectRef objectRef) {
                this.f385731a = luaArgument;
                this.f385732b = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // nx4.a
            public void a(int statusCode, @Nullable String filePath, @Nullable a.b result) {
                ZLog.f386189b.i("DownloadPlugin", 1, "download success, url=" + ((String) this.f385732b.element));
                LuaArgument luaArgument = this.f385731a;
                luaArgument.callback(luaArgument.ok());
            }

            @Override // nx4.a
            public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
                ZLog.f386189b.m("DownloadPlugin", 1, "download failed, code:" + statusCode + ", msg:" + errorMsg);
                LuaArgument luaArgument = this.f385731a;
                luaArgument.callback(luaArgument.fail("code:" + statusCode + ", msg:" + errorMsg));
            }

            @Override // nx4.a
            public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
                ZLog.f386189b.i("DownloadPlugin", 1, "download progress, " + progress);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/luabridge/plugins/c$a$b", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.zplan.luabridge.plugins.c$a$b */
        /* loaded from: classes27.dex */
        public static final class b extends c.a {
            b() {
            }

            @Override // com.tencent.zplan.c
            @NotNull
            public String t0(@Nullable String eventName, @Nullable String params, int callbackId) {
                JSONObject jSONObject = new JSONObject(params);
                ZLog.f386189b.i("DownloadPlugin", 1, "L2N_Download:" + jSONObject);
                Intrinsics.checkNotNull(eventName);
                Intrinsics.checkNotNull(params);
                return c.INSTANCE.b(new LuaArgument(new com.tencent.zplan.luabridge.b(eventName, params, callbackId)));
            }
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v6, types: [T, java.lang.String] */
        public final String b(LuaArgument argument) {
            ?? replace$default;
            String replace$default2;
            Boolean bool;
            JSONObject jSONObject = new JSONObject(argument.getParams());
            ZLog zLog = ZLog.f386189b;
            zLog.i("DownloadPlugin", 1, "L2N_Download:" + jSONObject);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = jSONObject.optString("RemoteUrl");
            String localPath = jSONObject.optString("LocalPath");
            String optString = jSONObject.optString("Priority");
            if (!TextUtils.isEmpty((String) objectRef.element) && !TextUtils.isEmpty(localPath)) {
                String url = (String) objectRef.element;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                replace$default = StringsKt__StringsJVMKt.replace$default(url, "\\/", "/", false, 4, (Object) null);
                objectRef.element = replace$default;
                Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                replace$default2 = StringsKt__StringsJVMKt.replace$default(localPath, "\\/", "/", false, 4, (Object) null);
                Map<String, String> a16 = com.tencent.zplan.common.utils.h.f385294a.a(jSONObject.optString("Header"));
                lx4.c cVar = (lx4.c) mx4.a.f417748a.a(lx4.c.class);
                if (cVar != null) {
                    bool = Boolean.valueOf(cVar.a((String) objectRef.element, replace$default2, a16, Intrinsics.areEqual(optString, "High"), 60, new C10065a(argument, objectRef)));
                } else {
                    bool = null;
                }
                Intrinsics.checkNotNull(bool);
                if (!bool.booleanValue()) {
                    zLog.m("DownloadPlugin", 1, "start download failed");
                    String fail = argument.fail("start download failed");
                    argument.callback(fail);
                    return fail;
                }
                return "";
            }
            zLog.m("DownloadPlugin", 1, "url or localPath is empty, please check");
            String fail2 = argument.fail("url or localPath is empty, please check");
            argument.callback(fail2);
            return fail2;
        }

        public final void c() {
            zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
            if (dVar != null && dVar.a()) {
                ZLog.f386189b.k("DownloadPlugin", "register in zplan process");
            } else {
                ZPlanServiceHelper.I.p0("L2N_Download", new b());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @LuaEvent("L2N_Download")
    @Nullable
    public final String download(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        return INSTANCE.b(argument);
    }
}
