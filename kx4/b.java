package kx4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.highway.netprobe.EchoTask;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.utils.LogUtil;
import ix4.f;
import ix4.g;
import ix4.i;
import ix4.j;
import ix4.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import lx4.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b%\u0010&J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J$\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J`\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\t\u001a\u00020\bJ4\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\"\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\"\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J.\u0010$\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b\u00a8\u0006'"}, d2 = {"Lkx4/b;", "", "Lix4/b;", "reqInfo", "Lkx4/a;", "", "Lix4/k;", "callback", "", "uin", "", "i", h.F, "j", "Llx4/e$c;", "c", "", "paramType", "Lix4/e;", "jsonParams", "reqFrom", "ueVersion", "recordScene", "appearanceKey", "Lgx4/a;", "avatarCharacter", "d", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "e", "userRecordTask", "b", "a", "status", "url", "errMsg", "bizInfo", "g", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kx4/b$b", "Llx4/e$c;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: kx4.b$b, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10689b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f413407a;

        C10689b(a aVar) {
            this.f413407a = aVar;
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer errCode, @Nullable String errMsg) {
            int i3;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createLocalRecordTask error - " + errCode + " - " + errMsg, null, 8, null);
            }
            a aVar = this.f413407a;
            if (errCode != null) {
                i3 = errCode.intValue();
            } else {
                i3 = -999;
            }
            aVar.onResultFailure(i3, errMsg);
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
            try {
                g c16 = g.c(data);
                a aVar = this.f413407a;
                k[] kVarArr = c16.f408940a;
                Intrinsics.checkNotNullExpressionValue(kVarArr, "rsp.userRecordTask");
                aVar.onResultSuccess(kVarArr);
            } catch (Exception e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("ZPlanCloudRecordService", 1, "createLocalRecordTask throw e:" + e16.getMessage(), e16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kx4/b$c", "Llx4/e$c;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f413408a;

        c(a aVar) {
            this.f413408a = aVar;
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer errCode, @Nullable String errMsg) {
            int i3;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createRecordTask error - " + errCode + " - " + errMsg, null, 8, null);
            }
            a aVar = this.f413408a;
            if (errCode != null) {
                i3 = errCode.intValue();
            } else {
                i3 = -999;
            }
            aVar.onResultFailure(i3, errMsg);
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
            try {
                j c16 = j.c(data);
                a aVar = this.f413408a;
                k[] kVarArr = c16.f408949a;
                Intrinsics.checkNotNullExpressionValue(kVarArr, "rsp.userRecordTask");
                aVar.onResultSuccess(kVarArr);
            } catch (Exception e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("ZPlanCloudRecordService", 1, "createRecordTask throw e:" + e16.getMessage(), e16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kx4/b$d", "Llx4/e$c;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f413409a;

        d(a aVar) {
            this.f413409a = aVar;
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer errCode, @Nullable String errMsg) {
            int i3;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "getUserRecordTask error - " + errCode + " - " + errMsg, null, 8, null);
            }
            a aVar = this.f413409a;
            if (errCode != null) {
                i3 = errCode.intValue();
            } else {
                i3 = -999;
            }
            aVar.onResultFailure(i3, errMsg);
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
            try {
                ix4.c c16 = ix4.c.c(data);
                if (c16.f408937a == null) {
                    c16.f408937a = new k[0];
                }
                a aVar = this.f413409a;
                k[] kVarArr = c16.f408937a;
                Intrinsics.checkNotNullExpressionValue(kVarArr, "rsp.userRecordTask");
                aVar.onResultSuccess(kVarArr);
            } catch (Exception e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("ZPlanCloudRecordService", 1, "getUserRecordTask throw e:" + e16.getMessage(), e16);
                }
            }
        }
    }

    private final e.c c(a<k[]> callback) {
        return new d(callback);
    }

    public static /* synthetic */ void f(b bVar, String str, int i3, String str2, a aVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        bVar.e(str, i3, str2, aVar);
    }

    private final void h(ix4.b reqInfo, a<k[]> callback) {
        Map emptyMap;
        lx4.e eVar = (lx4.e) mx4.a.f417748a.a(lx4.e.class);
        if (eVar == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "getUserRecordTask fail proxy is null!", null, 8, null);
            }
            callback.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "requestProxy is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(reqInfo);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.a(eVar, "trpc.metaverse.user_task.UserRecordTaskServer", "GetUserRecordTask", byteArray, emptyMap, c(callback), 0, 32, null);
    }

    private final void i(ix4.b reqInfo, a<k[]> callback, String uin) {
        String str;
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null) {
            str = aVar.getCurrentUin();
        } else {
            str = null;
        }
        if (str != null && !Intrinsics.areEqual(uin, str)) {
            j(reqInfo, callback);
        } else {
            h(reqInfo, callback);
        }
    }

    private final void j(ix4.b reqInfo, a<k[]> callback) {
        Map emptyMap;
        lx4.e eVar = (lx4.e) mx4.a.f417748a.a(lx4.e.class);
        if (eVar == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "getUserRecordTask fail proxy is null!", null, 8, null);
            }
            callback.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "requestProxy is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(reqInfo);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.b(eVar, "trpc.zplan.avatar_easter_egg.Handle", "SsoGetCloudReport", byteArray, emptyMap, c(callback), 0, 32, null);
    }

    public final void a(@NotNull k userRecordTask, @NotNull a<k[]> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(userRecordTask, "userRecordTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f fVar = new f();
        fVar.f408939a = userRecordTask;
        lx4.e eVar = (lx4.e) mx4.a.f417748a.a(lx4.e.class);
        if (eVar == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createLocalRecordTask fail proxy is null!", null, 8, null);
            }
            callback.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "requestProxy is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.a(eVar, "trpc.metaverse.user_task.UserRecordTaskServer", "LocalRecordTaskCreate", byteArray, emptyMap, new C10689b(callback), 0, 32, null);
    }

    public final void b(@NotNull k userRecordTask, @NotNull a<k[]> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(userRecordTask, "userRecordTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        i iVar = new i();
        iVar.f408948a = userRecordTask;
        lx4.e eVar = (lx4.e) mx4.a.f417748a.a(lx4.e.class);
        if (eVar == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createRecordTask fail proxy is null!", null, 8, null);
            }
            callback.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "requestProxy is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(iVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.a(eVar, "trpc.metaverse.user_task.UserRecordTaskServer", "RecordTaskCreate", byteArray, emptyMap, new c(callback), 0, 32, null);
    }

    public final void d(int paramType, @Nullable ix4.e jsonParams, int reqFrom, @NotNull String ueVersion, int recordScene, @NotNull String appearanceKey, @Nullable gx4.a avatarCharacter, @NotNull a<k[]> callback, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(ueVersion, "ueVersion");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(uin, "uin");
        ix4.b bVar = new ix4.b();
        bVar.f408927a = paramType;
        if (jsonParams != null) {
            bVar.f408928b = jsonParams;
        }
        if (avatarCharacter != null) {
            bVar.f408936j = avatarCharacter;
        }
        bVar.f408931e = reqFrom;
        bVar.f408932f = ueVersion;
        bVar.f408933g = recordScene;
        bVar.f408934h = appearanceKey;
        i(bVar, callback, uin);
    }

    public final void e(@NotNull String taskId, int reqFrom, @NotNull String uin, @NotNull a<k[]> callback) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ix4.b bVar = new ix4.b();
        bVar.f408931e = reqFrom;
        bVar.f408930d = new String[]{taskId};
        i(bVar, callback, uin);
    }

    public final void g(@NotNull String taskId, int status, @NotNull String url, @NotNull String errMsg, @NotNull String bizInfo) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(bizInfo, "bizInfo");
        ix4.h hVar = new ix4.h();
        hVar.f408941a = taskId;
        hVar.f408943c = status;
        hVar.f408942b = url;
        hVar.f408944d = errMsg;
        hVar.f408946f = bizInfo;
        lx4.e eVar = (lx4.e) mx4.a.f417748a.a(lx4.e.class);
        if (eVar == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createLocalRecordTask fail proxy is null!", null, 8, null);
                return;
            }
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(hVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.a(eVar, "trpc.metaverse.user_task.UserRecordTaskServer", "RecordTaskCallBack", byteArray, emptyMap, new e(), 0, 32, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kx4/b$e", "Llx4/e$c;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class e implements e.c {
        e() {
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer errCode, @Nullable String errMsg) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "ZPlanCloudRecordService", 1, "createLocalRecordTask error - " + errCode + " - " + errMsg, null, 8, null);
            }
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
        }
    }
}
