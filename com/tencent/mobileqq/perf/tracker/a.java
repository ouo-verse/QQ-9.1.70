package com.tencent.mobileqq.perf.tracker;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.a.AbstractC8214a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 )*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002\u0018\u0013B\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0004H$J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0012J\b\u0010\u0019\u001a\u00020\bH\u0004R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R&\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*R \u00100\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u00020\u0006018\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u00102\u001a\u0004\b3\u00104R\u001a\u0010:\u001a\u0002068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u00109R\u001a\u0010?\u001a\u00020;8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010D\u001a\u00020@8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bA\u0010CR\u0014\u0010H\u001a\u00020E8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/a;", "Lcom/tencent/mobileqq/perf/tracker/a$a;", "T", "", "", DomainData.DOMAIN_NAME, "", "stage", "", "delay", "u", "e", "o", "", "delayTimeMs", "p", "trackerData", "d", "(Lcom/tencent/mobileqq/perf/tracker/a$a;)V", "b", "c", "l", "(Ljava/lang/String;)Lcom/tencent/mobileqq/perf/tracker/a$a;", "r", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Class;", "Ljava/lang/Class;", "trackerDataClz", "", "I", "g", "()I", "t", "(I)V", "procReportCount", "f", ReportConstant.COSTREPORT_PREFIX, "dailyReportCount", "Ljava/util/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "j", "()Ljava/util/LinkedHashMap;", "traceMap", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/LinkedList;", "trackerQueue", "", "Ljava/util/Set;", "getStageSet", "()Ljava/util/Set;", "stageSet", "Lcom/tencent/commonsdk/pool/RecyclablePool;", "Lcom/tencent/commonsdk/pool/RecyclablePool;", tl.h.F, "()Lcom/tencent/commonsdk/pool/RecyclablePool;", "sPool", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMonitorHandler", "()Landroid/os/Handler;", "monitorHandler", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "i", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "()Lcom/tencent/mobileqq/perf/tracker/callback/a;", "sceneChangedCallback", "Lcom/tencent/mobileqq/perf/config/plugin/a;", "k", "()Lcom/tencent/mobileqq/perf/config/plugin/a;", "trackerConfig", "<init>", "(Ljava/lang/Class;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class a<T extends AbstractC8214a> {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name */
    private static final int f258220k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<T> trackerDataClz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int procReportCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int dailyReportCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, T> traceMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<T> trackerQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> stageSet;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclablePool sPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler monitorHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.perf.tracker.callback.a sceneChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\f\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0005\u0010\nR\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u000f\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/a$a;", "Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;", "", "recycle", "", tl.h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "fromStage", "i", "c", "stage", "j", "b", "nextStage", "", "k", "Z", "d", "()Z", "(Z)V", "waitReport", "l", "e", "f", "isFirstTracker", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.tracker.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static abstract class AbstractC8214a extends RecyclablePool.Recyclable {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String fromStage;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String stage;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String nextStage;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean waitReport;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstTracker;

        public AbstractC8214a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.isFirstTracker = true;
            }
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.fromStage;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.nextStage;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.stage;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.waitReport;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.isFirstTracker;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.isFirstTracker = z16;
            }
        }

        public final void g(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.fromStage = str;
            }
        }

        public final void h(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.nextStage = str;
            }
        }

        public final void i(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.stage = str;
            }
        }

        public final void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.waitReport = z16;
            }
        }

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this);
                return;
            }
            super.recycle();
            this.stage = null;
            this.nextStage = null;
            this.waitReport = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/a$b;", "", "", "LOOP_INTERVAL", "J", "", "MSG_TRACE_END", "I", "MSG_TRACE_LOOP", "MSG_TRACE_START", "ONE_DAY_MILLISECONDS", "", "TAG", "Ljava/lang/String;", "TRACE_DELAY", "TRACE_END_DELAY", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.tracker.a$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/tracker/a$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<T> f258235a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<T> aVar, Looper looper) {
            super(looper);
            this.f258235a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) looper);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        removeMessages(2);
                        this.f258235a.b();
                        return;
                    }
                    return;
                }
                a<T> aVar = this.f258235a;
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.tencent.mobileqq.perf.tracker.AbsPerfTracker");
                aVar.c((AbstractC8214a) obj);
                return;
            }
            a<T> aVar2 = this.f258235a;
            Object obj2 = msg2.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of com.tencent.mobileqq.perf.tracker.AbsPerfTracker");
            aVar2.d((AbstractC8214a) obj2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/perf/tracker/a$d", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "stage", "", "delay", "", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityDestroyed", "onProcessForeground", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "onFragmentResumed", "onFragmentPaused", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<T> f258236d;

        d(a<T> aVar) {
            this.f258236d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            a<T> aVar = this.f258236d;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            aVar.u(name, false);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.f258236d.e(activity.getClass().getName());
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) fm5, (Object) f16);
                return;
            }
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            this.f258236d.e(f16.getClass().getName());
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) fm5, (Object) f16);
                return;
            }
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            a<T> aVar = this.f258236d;
            String name = f16.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "f.javaClass.name");
            aVar.u(name, false);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f258236d.o();
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceEnd(@NotNull String stage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) stage);
            } else {
                Intrinsics.checkNotNullParameter(stage, "stage");
                this.f258236d.e(stage);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, stage, Boolean.valueOf(delay));
            } else {
                Intrinsics.checkNotNullParameter(stage, "stage");
                this.f258236d.u(stage, delay);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
            f258220k = Process.myPid();
        }
    }

    public a(@NotNull Class<T> trackerDataClz) {
        Intrinsics.checkNotNullParameter(trackerDataClz, "trackerDataClz");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) trackerDataClz);
            return;
        }
        this.trackerDataClz = trackerDataClz;
        this.traceMap = new LinkedHashMap<>(4);
        this.trackerQueue = new LinkedList<>();
        this.stageSet = new HashSet(10);
        this.sPool = new RecyclablePool(trackerDataClz, 5);
        this.monitorHandler = new c(this, QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
        this.sceneChangedCallback = new d(this);
    }

    protected final void a(@NotNull T trackerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) trackerData);
            return;
        }
        Intrinsics.checkNotNullParameter(trackerData, "trackerData");
        if (this.trackerQueue.size() > 8) {
            T remove = this.trackerQueue.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "trackerQueue.removeAt(0)");
            T t16 = remove;
            if (!this.traceMap.containsValue(t16) && !t16.d()) {
                this.sPool.recycle(t16);
            }
        }
        this.trackerQueue.add(trackerData);
    }

    protected abstract void b();

    protected abstract void c(@NotNull T trackerData);

    protected abstract void d(@NotNull T trackerData);

    protected void e(@Nullable String stage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) stage);
            return;
        }
        synchronized (this.traceMap) {
            Object remove = TypeIntrinsics.asMutableMap(this.traceMap).remove(stage);
            if (remove == null) {
                return;
            }
            ((AbstractC8214a) remove).j(true);
            Unit unit = Unit.INSTANCE;
            Message obtainMessage = this.monitorHandler.obtainMessage(1);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "monitorHandler.obtainMessage(MSG_TRACE_END)");
            obtainMessage.obj = remove;
            this.monitorHandler.removeMessages(1);
            this.monitorHandler.sendMessageDelayed(obtainMessage, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.dailyReportCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.procReportCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RecyclablePool h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RecyclablePool) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.sPool;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.perf.tracker.callback.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.perf.tracker.callback.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.sceneChangedCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinkedHashMap<String, T> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LinkedHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.traceMap;
    }

    @NotNull
    protected abstract com.tencent.mobileqq.perf.config.plugin.a k();

    @NotNull
    protected final T l(@NotNull String stage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (T) iPatchRedirector.redirect((short) 17, (Object) this, (Object) stage);
        }
        Intrinsics.checkNotNullParameter(stage, "stage");
        RecyclablePool.Recyclable obtain = this.sPool.obtain(this.trackerDataClz);
        Intrinsics.checkNotNull(obtain, "null cannot be cast to non-null type T of com.tencent.mobileqq.perf.tracker.AbsPerfTracker");
        T t16 = (T) obtain;
        t16.i(stage);
        t16.f(!this.stageSet.contains(stage));
        if (t16.e()) {
            this.stageSet.add(stage);
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinkedList<T> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LinkedList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.trackerQueue;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            p(k().loopInterval);
        }
    }

    protected final void p(long delayTimeMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, delayTimeMs);
        } else if (delayTimeMs > 0) {
            this.monitorHandler.sendEmptyMessageDelayed(2, delayTimeMs);
        } else {
            this.monitorHandler.sendEmptyMessageDelayed(2, k().loopInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (Math.random() < k().eventSampleRatio && (this.dailyReportCount < k().dailyReportLimit || this.procReportCount < k().procOnceReportLimit)) {
            return true;
        }
        return false;
    }

    protected final void r(@NotNull T trackerData) {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) trackerData);
            return;
        }
        Intrinsics.checkNotNullParameter(trackerData, "trackerData");
        if (this.traceMap.size() > 0) {
            Collection<T> values = this.traceMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "traceMap.values");
            last = CollectionsKt___CollectionsKt.last(values);
            Intrinsics.checkNotNullExpressionValue(last, "traceMap.values.last()");
            AbstractC8214a abstractC8214a = (AbstractC8214a) last;
            trackerData.g(abstractC8214a.c());
            if (abstractC8214a.b() == null) {
                abstractC8214a.h(trackerData.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.dailyReportCount = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.procReportCount = i3;
        }
    }

    protected void u(@NotNull String stage, boolean delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, stage, Boolean.valueOf(delay));
            return;
        }
        Intrinsics.checkNotNullParameter(stage, "stage");
        T l3 = l(stage);
        synchronized (this.traceMap) {
            r(l3);
            this.traceMap.put(stage, l3);
            a(l3);
            Unit unit = Unit.INSTANCE;
        }
        Message obtainMessage = this.monitorHandler.obtainMessage(0);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "monitorHandler.obtainMessage(MSG_TRACE_START)");
        obtainMessage.obj = l3;
        this.monitorHandler.removeMessages(0);
        if (delay) {
            this.monitorHandler.sendMessageDelayed(obtainMessage, 1000L);
        } else {
            this.monitorHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }
}
