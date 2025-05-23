package nr3;

import com.tencent.qmethod.monitor.network.e;
import com.tencent.qmethod.monitor.report.base.db.c;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lnr3/a;", "", "e", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @Nullable
    public static c f421181c;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static String f421179a = "ReportBaseInfo";

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final UserMeta f421180b = new UserMeta(null, null, null, null, null, null, 63, null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static AtomicBoolean f421182d = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R(\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lnr3/a$a;", "", "", "c", "", "a", "TAG", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG$annotations", "()V", "AUTO_BASE_TYPE", "AUTO_SUB_TYPE", "DAU_BASE_TYPE", "DAU_SUB_TYPE", "DOWNLOAD_BASE_TYPE", "DOWNLOAD_SUB_TYPE", "FUNC_INVOKE", "ILLEGAL_API_BASE_TYPE", "ILLEGAL_API_SUB_TYPE", "NETWORK_CAPTURE_TYPE", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "dbHelper", "Lcom/tencent/qmethod/monitor/report/base/db/c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lnr3/b;", "userMeta", "Lnr3/b;", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: nr3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"nr3/a$a$a", "Lcom/tencent/qmethod/monitor/base/a;", "", "b", "", "isAgree", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: nr3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static final class C10865a implements com.tencent.qmethod.monitor.base.a {
            C10865a() {
            }

            @Override // com.tencent.qmethod.monitor.base.a
            public void a(boolean isAgree) {
                a.f421180b.b();
            }

            @Override // com.tencent.qmethod.monitor.base.a
            public void b() {
                a.f421180b.b();
            }
        }

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final String a() {
            return e.f343757e.a() + "v1/" + a.f421180b.appId + "/upload-json";
        }

        @NotNull
        public final String b() {
            return a.f421179a;
        }

        public final void c() {
            if (a.f421182d.compareAndSet(false, true)) {
                try {
                    tr3.a aVar = tr3.a.f437217d;
                    com.tencent.qmethod.monitor.a aVar2 = com.tencent.qmethod.monitor.a.f343451h;
                    aVar.e(aVar2.g().getContext());
                    a.f421180b.b();
                    a.f421181c = c.INSTANCE.a(aVar2.g().getContext());
                } catch (Exception e16) {
                    o.d(b(), "Initialization failed", e16);
                }
            } else {
                o.c(b(), "Repeat initialization");
            }
            com.tencent.qmethod.monitor.a.f343451h.o(new C10865a());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
