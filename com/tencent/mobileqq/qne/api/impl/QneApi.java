package com.tencent.mobileqq.qne.api.impl;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qne.api.IQneApi;
import com.tencent.mobileqq.qne.api.SRLevel;
import com.tencent.qne.delegate.Level;
import com.tencent.qne.delegate.e;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qne.model.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.j;
import com.tencent.rdelivery.reshub.api.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qne/api/impl/QneApi;", "Lcom/tencent/mobileqq/qne/api/IQneApi;", "", "onlyDownloadOnWifi", "Lcom/tencent/qne/delegate/d;", "createShiplyDelegate", "Lcom/tencent/qne/delegate/b;", "createLogDelegate", "Lcom/tencent/qne/delegate/c;", "createReportDelegate", "", "resourceId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "isShiplyResourceDownloaded", "Lcom/tencent/mobileqq/qne/api/SRLevel;", "level", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "createSuperResolutionHelper", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "modelConfig", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "taskQueueConfig", "Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "createOldPhotoRepairHelper", "TAG", "Ljava/lang/String;", "appId", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/rdelivery/reshub/api/s;", "params$delegate", "Lkotlin/Lazy;", "getParams", "()Lcom/tencent/rdelivery/reshub/api/s;", "params", "resHubInit$delegate", "getResHubInit", "()Z", "resHubInit", "<init>", "()V", "qne-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QneApi implements IQneApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final QneApi INSTANCE;

    @NotNull
    private static final String TAG = "QneApi";

    @NotNull
    private static final String appId = "4cd6974be1";

    @NotNull
    private static final String appKey = "0ccc46ca-154c-4c6b-8b0b-4d8537ffcbcc";

    /* renamed from: params$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy params;

    /* renamed from: resHubInit$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy resHubInit;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262060a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22324);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[SRLevel.values().length];
            try {
                iArr[SRLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SRLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SRLevel.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f262060a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qne/api/impl/QneApi$b", "Lcom/tencent/qne/delegate/b;", "Lcom/tencent/qne/delegate/Level;", "level", "", "tag", "msg", "", "throwable", "", "a", "qne-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements com.tencent.qne.delegate.b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f262061a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22325);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[Level.values().length];
                try {
                    iArr[Level.VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Level.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Level.INFO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Level.WARN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Level.ERROR.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f262061a = iArr;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qne.delegate.b
        public void a(@NotNull Level level, @NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, level, tag, msg2, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = a.f262061a[level.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            QLog.e(tag, 1, msg2, throwable);
                            return;
                        }
                        return;
                    }
                    QLog.w(tag, 1, msg2, throwable);
                    return;
                }
                QLog.i(tag, 1, msg2, throwable);
                return;
            }
            QLog.d(tag, 1, msg2, throwable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qne/api/impl/QneApi$c", "Lcom/tencent/qne/delegate/c;", "", AdMetricTag.EVENT_NAME, "params", "", "report", "qne-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements com.tencent.qne.delegate.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qne.delegate.c
        public void report(@NotNull String eventName, @NotNull String params) {
            HashMap<String, String> hashMap;
            String simpleName;
            Map<? extends String, ? extends String> mapOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eventName, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            JSONObject a16 = com.tencent.mobileqq.qne.util.c.a(params);
            if (a16 != null) {
                hashMap = com.tencent.mobileqq.qne.util.c.b(a16);
            } else {
                hashMap = null;
            }
            QneInterpreter qneInterpreter = QneInterpreter.f344344a;
            if (qneInterpreter.c() != null) {
                f c16 = qneInterpreter.c();
                Intrinsics.checkNotNull(c16);
                simpleName = Reflection.getOrCreateKotlinClass(c16.getClass()).getSimpleName();
            } else {
                simpleName = Reflection.getOrCreateKotlinClass(qneInterpreter.a().getClass()).getSimpleName();
            }
            if (hashMap != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("params_device", qneInterpreter.b()), TuplesKt.to("params_soc", String.valueOf(simpleName)));
                hashMap.putAll(mapOf);
            }
            com.tencent.mobileqq.qne.util.b.c(null, eventName, hashMap, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qne/api/impl/QneApi$d", "Lcom/tencent/qne/delegate/d;", "", "resourceId", "", "specificTaskId", "Lcom/tencent/qne/delegate/e;", "a", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qne-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.qne.delegate.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qne.delegate.a f262062a;

        d(com.tencent.qne.delegate.a aVar) {
            this.f262062a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qne.delegate.d
        @Nullable
        public Object a(@NotNull String str, @Nullable Long l3, @NotNull Continuation<? super e> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, str, l3, continuation);
            }
            return this.f262062a.a(str, l3, continuation);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new QneApi();
        lazy = LazyKt__LazyJVMKt.lazy(QneApi$params$2.INSTANCE);
        params = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QneApi$resHubInit$2.INSTANCE);
        resHubInit = lazy2;
    }

    QneApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qne.delegate.b createLogDelegate() {
        return new b();
    }

    private final com.tencent.qne.delegate.c createReportDelegate() {
        return new c();
    }

    private final com.tencent.qne.delegate.d createShiplyDelegate(boolean onlyDownloadOnWifi) {
        getResHubInit();
        return new d(new com.tencent.qne.delegate.a("4cd6974be1", "0ccc46ca-154c-4c6b-8b0b-4d8537ffcbcc", getParams(), onlyDownloadOnWifi));
    }

    private final ResHubParams getParams() {
        return (ResHubParams) params.getValue();
    }

    private final boolean getResHubInit() {
        return ((Boolean) resHubInit.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public OldPhotoRepairHelper createOldPhotoRepairHelper(@NotNull Context context, boolean onlyDownloadOnWifi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OldPhotoRepairHelper) iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(onlyDownloadOnWifi));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new OldPhotoRepairHelper(new WeakReference(context), createShiplyDelegate(onlyDownloadOnWifi), createLogDelegate(), createReportDelegate());
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public SuperResolutionHelper createSuperResolutionHelper(@NotNull SRLevel level) {
        ModelConfig modelConfig;
        ModelConfig modelConfig2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SuperResolutionHelper) iPatchRedirector.redirect((short) 3, (Object) this, (Object) level);
        }
        Intrinsics.checkNotNullParameter(level, "level");
        BaseApplication baseApplication = BaseApplication.context;
        int i3 = a.f262060a[level.ordinal()];
        if (i3 == 1) {
            modelConfig = new ModelConfig("realesrganx2", 2, 2, 256, false, false, 48, null);
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                modelConfig2 = new ModelConfig("mobile_sr", 1, 2, 256, false, false, 48, null);
                return new SuperResolutionHelper(new WeakReference(baseApplication), modelConfig2, new TaskQueueConfig(0, 0, null, 7, null), createShiplyDelegate(false), createLogDelegate(), createReportDelegate());
            }
            modelConfig = new ModelConfig("realesr_x2v3", 1, 2, 288, false, false, 48, null);
        }
        modelConfig2 = modelConfig;
        return new SuperResolutionHelper(new WeakReference(baseApplication), modelConfig2, new TaskQueueConfig(0, 0, null, 7, null), createShiplyDelegate(false), createLogDelegate(), createReportDelegate());
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    public boolean isShiplyResourceDownloaded(@Nullable String resourceId, long taskId) {
        g b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, resourceId, Long.valueOf(taskId))).booleanValue();
        }
        if (resourceId == null) {
            return false;
        }
        getResHubInit();
        r rVar = new r();
        rVar.c(INSTANCE.getParams());
        i b17 = j.a.b(com.tencent.rdelivery.reshub.core.j.L, "4cd6974be1", "0ccc46ca-154c-4c6b-8b0b-4d8537ffcbcc", null, null, null, null, rVar, 60, null);
        if (taskId > 0) {
            b16 = b17.d(resourceId, taskId, false);
        } else {
            b16 = b17.b(resourceId, false);
        }
        if (b16 != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public SuperResolutionHelper createSuperResolutionHelper(@NotNull Context context, @NotNull ModelConfig modelConfig, @NotNull TaskQueueConfig taskQueueConfig, boolean onlyDownloadOnWifi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SuperResolutionHelper) iPatchRedirector.redirect((short) 4, this, context, modelConfig, taskQueueConfig, Boolean.valueOf(onlyDownloadOnWifi));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modelConfig, "modelConfig");
        Intrinsics.checkNotNullParameter(taskQueueConfig, "taskQueueConfig");
        return new SuperResolutionHelper(new WeakReference(context), modelConfig, taskQueueConfig, createShiplyDelegate(onlyDownloadOnWifi), createLogDelegate(), createReportDelegate());
    }
}
