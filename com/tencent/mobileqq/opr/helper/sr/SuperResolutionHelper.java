package com.tencent.mobileqq.opr.helper.sr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.opr.QQSR;
import com.tencent.mobileqq.opr.helper.sr.model.SrStatus;
import com.tencent.mobileqq.opr.helper.sr.model.e;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskErrorCode;
import com.tencent.mobileqq.opr.model.TaskExtendResult;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.mobileqq.opr.model.TaskReportParams;
import com.tencent.mobileqq.opr.model.a;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import com.tencent.qne.util.Md5UtilKt;
import com.tencent.zplan.common.utils.FileCache;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0019BC\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b^\u0010_J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ.\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J;\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0010R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102RR\u0010?\u001a/\b\u0001\u0012\u0013\u0012\u001100\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001008\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BRR\u0010G\u001a/\b\u0001\u0012\u0013\u0012\u00110@\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001008\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0017\u0010Q\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\\\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "", "", "key", "", "keepSize", "localPath", "Lkotlin/Function0;", "Landroid/graphics/Bitmap;", "getBitmap", "Lcom/tencent/mobileqq/opr/helper/sr/model/d;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "originBitmap", "Landroid/util/Size;", "t", "", "u", "p", MimeHelper.IMAGE_SUBTYPE_BITMAP, "v", "(Ljava/lang/String;ZLjava/lang/String;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "contextRef", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "b", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "modelConfig", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "c", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "taskQueueConfig", "Lcom/tencent/qne/delegate/d;", "d", "Lcom/tencent/qne/delegate/d;", "shiply", "Lcom/tencent/qne/delegate/b;", "e", "Lcom/tencent/qne/delegate/b;", "logger", "Lcom/tencent/qne/delegate/c;", "f", "Lcom/tencent/qne/delegate/c;", "reporter", "Lcom/tencent/qne/util/d;", "g", "Lcom/tencent/qne/util/d;", "initStatus", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "status", "Lkotlin/coroutines/Continuation;", h.F, "Lkotlin/jvm/functions/Function2;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lkotlin/jvm/functions/Function2;", "setInitStatusListener", "(Lkotlin/jvm/functions/Function2;)V", "initStatusListener", "Lcom/tencent/mobileqq/opr/model/a;", "i", "Lcom/tencent/mobileqq/opr/model/a;", "modelStatus", "j", "r", "setModelStatusListener", "modelStatusListener", "Lkotlinx/coroutines/CompletableJob;", "k", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CoroutineScope;", "l", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/tencent/mobileqq/opr/QQSR;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CompletableDeferred;", "qqsrDeferred", "Lkotlinx/coroutines/Job;", DomainData.DOMAIN_NAME, "Lkotlinx/coroutines/Job;", "initJob", "Lcom/tencent/zplan/common/utils/FileCache;", "Lcom/tencent/zplan/common/utils/FileCache;", "fileCache", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/opr/model/ModelConfig;Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;Lcom/tencent/qne/delegate/d;Lcom/tencent/qne/delegate/b;Lcom/tencent/qne/delegate/c;)V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SuperResolutionHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private static String f257023q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    private static FileCache f257024r;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ModelConfig modelConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskQueueConfig taskQueueConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d shiply;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b logger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c reporter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qne.util.d initStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.qne.util.d, ? super Continuation<? super Unit>, ? extends Object> initStatusListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a modelStatus;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> modelStatusListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableJob supervisorJob;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableDeferred<QQSR> qqsrDeferred;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job initJob;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileCache fileCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper$a;", "", "", "", "keepSize", "d", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/common/utils/FileCache;", "c", "", "b", "TAG", "Ljava/lang/String;", "fileCache", "Lcom/tencent/zplan/common/utils/FileCache;", "fileCacheDir", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(String str, boolean z16) {
            String str2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = Md5UtilKt.b(str);
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            objArr[1] = str2;
            String format = String.format("qqsr_cache_%s_k%s", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }

        public final synchronized void b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getCacheDir() + "/OPR/SRCache");
            OprLogger.i("[qqsr]SuperResolutionHelper", Intrinsics.stringPlus("clearGlobalCache:", file.getAbsolutePath()));
            if (file.exists()) {
                FilesKt__UtilsKt.deleteRecursively(file);
            }
        }

        @NotNull
        public final synchronized FileCache c(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FileCache) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (SuperResolutionHelper.f257024r == null) {
                String str = context.getCacheDir() + "/OPR/SRCache";
                SuperResolutionHelper.f257023q = str;
                SuperResolutionHelper.f257024r = new FileCache(str, 500L);
            }
            FileCache fileCache = SuperResolutionHelper.f257024r;
            Intrinsics.checkNotNull(fileCache);
            return fileCache;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SuperResolutionHelper(@NotNull WeakReference<Context> contextRef, @NotNull ModelConfig modelConfig, @NotNull TaskQueueConfig taskQueueConfig, @NotNull d shiply, @NotNull b logger, @Nullable c cVar) {
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(modelConfig, "modelConfig");
        Intrinsics.checkNotNullParameter(taskQueueConfig, "taskQueueConfig");
        Intrinsics.checkNotNullParameter(shiply, "shiply");
        Intrinsics.checkNotNullParameter(logger, "logger");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contextRef, modelConfig, taskQueueConfig, shiply, logger, cVar);
            return;
        }
        this.contextRef = contextRef;
        this.modelConfig = modelConfig;
        this.taskQueueConfig = taskQueueConfig;
        this.shiply = shiply;
        this.logger = logger;
        this.reporter = cVar;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.supervisorJob = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorJob$default));
        this.qqsrDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Companion companion = INSTANCE;
        Context context = contextRef.get();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "contextRef.get()!!");
        this.fileCache = companion.c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(String str, boolean z16, String str2, Function0<Bitmap> function0, Continuation<? super com.tencent.mobileqq.opr.helper.sr.model.d> continuation) {
        SuperResolutionHelper$realSuperResolution$1 superResolutionHelper$realSuperResolution$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        final SuperResolutionHelper superResolutionHelper;
        final String str3;
        boolean z17;
        long j3;
        Function0<Bitmap> function02;
        QQSR qqsr;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof SuperResolutionHelper$realSuperResolution$1) {
            superResolutionHelper$realSuperResolution$1 = (SuperResolutionHelper$realSuperResolution$1) continuation;
            int i16 = superResolutionHelper$realSuperResolution$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                superResolutionHelper$realSuperResolution$1.label = i16 - Integer.MIN_VALUE;
                Object obj = superResolutionHelper$realSuperResolution$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = superResolutionHelper$realSuperResolution$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = superResolutionHelper$realSuperResolution$1.J$0;
                    z17 = superResolutionHelper$realSuperResolution$1.Z$0;
                    objectRef2 = (Ref.ObjectRef) superResolutionHelper$realSuperResolution$1.L$4;
                    objectRef = (Ref.ObjectRef) superResolutionHelper$realSuperResolution$1.L$3;
                    function02 = (Function0) superResolutionHelper$realSuperResolution$1.L$2;
                    String str4 = (String) superResolutionHelper$realSuperResolution$1.L$1;
                    superResolutionHelper = (SuperResolutionHelper) superResolutionHelper$realSuperResolution$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str3 = str4;
                } else {
                    ResultKt.throwOnFailure(obj);
                    boolean c16 = com.tencent.qne.util.a.c(str2);
                    OprLogger.d("[qqsr]SuperResolutionHelper", "realSuperResolution start, key:" + str + ", keepSize:" + z16 + ", localPath:" + ((Object) str2) + " exist:" + c16);
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    if (c16) {
                        objectRef2.element = str2;
                    } else {
                        ?? invoke = function0.invoke();
                        objectRef.element = invoke;
                        if (invoke == 0) {
                            return new com.tencent.mobileqq.opr.helper.sr.model.d(SrStatus.GetInputBitmapFail, null, null, 6, null);
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    u();
                    CompletableDeferred<QQSR> completableDeferred = this.qqsrDeferred;
                    superResolutionHelper$realSuperResolution$1.L$0 = this;
                    superResolutionHelper$realSuperResolution$1.L$1 = str;
                    superResolutionHelper$realSuperResolution$1.L$2 = function0;
                    superResolutionHelper$realSuperResolution$1.L$3 = objectRef;
                    superResolutionHelper$realSuperResolution$1.L$4 = objectRef2;
                    superResolutionHelper$realSuperResolution$1.Z$0 = z16;
                    superResolutionHelper$realSuperResolution$1.J$0 = currentTimeMillis;
                    superResolutionHelper$realSuperResolution$1.label = 1;
                    Object await = completableDeferred.await(superResolutionHelper$realSuperResolution$1);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    superResolutionHelper = this;
                    str3 = str;
                    z17 = z16;
                    j3 = currentTimeMillis;
                    obj = await;
                    function02 = function0;
                }
                qqsr = (QQSR) obj;
                final com.tencent.mobileqq.opr.helper.sr.model.b bVar = new com.tencent.mobileqq.opr.helper.sr.model.b(true, System.currentTimeMillis() - j3, new com.tencent.mobileqq.opr.helper.sr.model.c(superResolutionHelper.initStatus, superResolutionHelper.modelStatus));
                if (qqsr != null) {
                    OprLogger.e("[qqsr]SuperResolutionHelper", "superResolution fail, qqsr instance null");
                    return new com.tencent.mobileqq.opr.helper.sr.model.d(SrStatus.GetSrInstanceFail, null, new e(null, bVar, null, null, null, 29, null), 2, null);
                }
                superResolutionHelper$realSuperResolution$1.L$0 = superResolutionHelper;
                superResolutionHelper$realSuperResolution$1.L$1 = str3;
                superResolutionHelper$realSuperResolution$1.L$2 = function02;
                superResolutionHelper$realSuperResolution$1.L$3 = objectRef;
                superResolutionHelper$realSuperResolution$1.L$4 = objectRef2;
                superResolutionHelper$realSuperResolution$1.L$5 = qqsr;
                superResolutionHelper$realSuperResolution$1.L$6 = bVar;
                superResolutionHelper$realSuperResolution$1.Z$0 = z17;
                superResolutionHelper$realSuperResolution$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(superResolutionHelper$realSuperResolution$1);
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                final boolean z18 = z17;
                final Ref.ObjectRef objectRef3 = objectRef;
                final Function0<Bitmap> function03 = function02;
                qqsr.startSuperResolution((String) objectRef2.element, (Bitmap) objectRef.element, new Function5<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, Unit>(str3, z18, bVar, objectRef3, cancellableContinuationImpl, function03) { // from class: com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper$realSuperResolution$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.opr.helper.sr.model.d> $continuation;
                    final /* synthetic */ Function0<Bitmap> $getBitmap;
                    final /* synthetic */ com.tencent.mobileqq.opr.helper.sr.model.b $getSrInstanceStatistic;
                    final /* synthetic */ Ref.ObjectRef<Bitmap> $inputBitmapMaybe;
                    final /* synthetic */ boolean $keepSize;
                    final /* synthetic */ String $key;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(5);
                        this.$key = str3;
                        this.$keepSize = z18;
                        this.$getSrInstanceStatistic = bVar;
                        this.$inputBitmapMaybe = objectRef3;
                        this.$continuation = cancellableContinuationImpl;
                        this.$getBitmap = function03;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, SuperResolutionHelper.this, str3, Boolean.valueOf(z18), bVar, objectRef3, cancellableContinuationImpl, function03);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function5
                    public /* bridge */ /* synthetic */ Unit invoke(TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, Integer num, Integer num2) {
                        invoke(taskErrorCode, taskExtendResult, bArr, num.intValue(), num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull TaskErrorCode errorCode, @NotNull TaskExtendResult extend, @Nullable byte[] bArr, int i17, int i18) {
                        SrStatus srStatus;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, errorCode, extend, bArr, Integer.valueOf(i17), Integer.valueOf(i18));
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Intrinsics.checkNotNullParameter(extend, "extend");
                        Size size = null;
                        Bitmap a16 = errorCode == TaskErrorCode.Success ? com.tencent.mobileqq.opr.utils.a.a(bArr, i17, i18) : null;
                        if (a16 != null) {
                            SuperResolutionHelper superResolutionHelper2 = SuperResolutionHelper.this;
                            String str5 = this.$key;
                            boolean z19 = this.$keepSize;
                            final Ref.ObjectRef<Bitmap> objectRef4 = this.$inputBitmapMaybe;
                            final Function0<Bitmap> function04 = this.$getBitmap;
                            size = superResolutionHelper2.t(a16, str5, z19, new Function0<Bitmap>(objectRef4, function04) { // from class: com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper$realSuperResolution$2$1$outputSize$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Function0<Bitmap> $getBitmap;
                                final /* synthetic */ Ref.ObjectRef<Bitmap> $inputBitmapMaybe;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$inputBitmapMaybe = objectRef4;
                                    this.$getBitmap = function04;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef4, (Object) function04);
                                    }
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @Nullable
                                public final Bitmap invoke() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        return (Bitmap) iPatchRedirector2.redirect((short) 2, (Object) this);
                                    }
                                    Bitmap bitmap = this.$inputBitmapMaybe.element;
                                    return bitmap == null ? this.$getBitmap.invoke() : bitmap;
                                }
                            });
                        }
                        Size size2 = size;
                        if (a16 != null) {
                            a16.recycle();
                        }
                        String p16 = SuperResolutionHelper.this.p(this.$key, this.$keepSize);
                        if (p16 != null) {
                            srStatus = SrStatus.Success;
                        } else {
                            srStatus = SrStatus.DoSrFail;
                        }
                        TaskReportParams taskReportParams = extend.getTaskReportParams();
                        int queueWaitingTimeMs = taskReportParams == null ? 0 : taskReportParams.getQueueWaitingTimeMs();
                        TaskReportParams taskReportParams2 = extend.getTaskReportParams();
                        com.tencent.mobileqq.opr.helper.sr.model.d dVar = new com.tencent.mobileqq.opr.helper.sr.model.d(srStatus, p16, new e(Boolean.FALSE, this.$getSrInstanceStatistic, new com.tencent.mobileqq.opr.helper.sr.model.a(errorCode, queueWaitingTimeMs, taskReportParams2 != null ? taskReportParams2.getExecuteTimeMs() : 0), com.tencent.mobileqq.opr.utils.a.e(this.$inputBitmapMaybe.element), size2));
                        OprLogger.i("[qqsr]SuperResolutionHelper", Intrinsics.stringPlus("superResolution end, result:", dVar));
                        this.$continuation.resumeWith(Result.m476constructorimpl(dVar));
                    }
                });
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(superResolutionHelper$realSuperResolution$1);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        superResolutionHelper$realSuperResolution$1 = new SuperResolutionHelper$realSuperResolution$1(this, continuation);
        Object obj2 = superResolutionHelper$realSuperResolution$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = superResolutionHelper$realSuperResolution$1.label;
        if (i3 == 0) {
        }
        qqsr = (QQSR) obj2;
        final com.tencent.mobileqq.opr.helper.sr.model.b bVar2 = new com.tencent.mobileqq.opr.helper.sr.model.b(true, System.currentTimeMillis() - j3, new com.tencent.mobileqq.opr.helper.sr.model.c(superResolutionHelper.initStatus, superResolutionHelper.modelStatus));
        if (qqsr != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size t(Bitmap bitmap, String str, boolean z16, Function0<Bitmap> function0) {
        Size e16;
        boolean c16;
        String d16 = INSTANCE.d(str, z16);
        String str2 = ((Object) f257023q) + '/' + d16 + "_temp.jpg";
        if (!z16) {
            if (com.tencent.mobileqq.opr.utils.a.c(bitmap, str2, null, 2, null)) {
                this.fileCache.g(str2, d16);
            }
            return com.tencent.mobileqq.opr.utils.a.e(bitmap);
        }
        Bitmap invoke = function0.invoke();
        if (invoke == null) {
            e16 = null;
        } else {
            e16 = com.tencent.mobileqq.opr.utils.a.e(invoke);
        }
        if (e16 != null) {
            Bitmap d17 = com.tencent.mobileqq.opr.utils.a.d(bitmap, e16);
            c16 = com.tencent.mobileqq.opr.utils.a.c(d17, str2, null, 2, null);
            d17.recycle();
        } else {
            c16 = com.tencent.mobileqq.opr.utils.a.c(bitmap, str2, null, 2, null);
        }
        if (!c16 || !this.fileCache.g(str2, d16)) {
            return null;
        }
        if (e16 == null) {
            return com.tencent.mobileqq.opr.utils.a.e(bitmap);
        }
        return e16;
    }

    public final synchronized void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Job job = this.initJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.initJob = null;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SuperResolutionHelper$destroy$1(this, null), 3, null);
    }

    @Nullable
    public final String p(@NotNull String key, boolean keepSize) {
        File c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, key, Boolean.valueOf(keepSize));
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() != 0) {
            z16 = false;
        }
        if (z16 || (c16 = this.fileCache.c(INSTANCE.d(key, keepSize))) == null) {
            return null;
        }
        return c16.getAbsolutePath();
    }

    @Nullable
    public final Function2<com.tencent.qne.util.d, Continuation<? super Unit>, Object> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.initStatusListener;
    }

    @Nullable
    public final Function2<a, Continuation<? super Unit>, Object> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function2) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.modelStatusListener;
    }

    public final synchronized void u() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.initJob != null) {
            return;
        }
        Context context = this.contextRef.get();
        if (context != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SuperResolutionHelper$setup$1(context, this, null), 3, null);
            this.initJob = launch$default;
        }
    }

    @Nullable
    public final Object v(@NotNull String str, boolean z16, @Nullable final String str2, @Nullable final Bitmap bitmap, @NotNull Continuation<? super com.tencent.mobileqq.opr.helper.sr.model.d> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), str2, bitmap, continuation);
        }
        String p16 = p(str, z16);
        if (p16 != null) {
            return new com.tencent.mobileqq.opr.helper.sr.model.d(SrStatus.SuccessFromCache, p16, new e(Boxing.boxBoolean(true), null, null, null, null, 30, null));
        }
        return s(str, z16, str2, new Function0<Bitmap>(bitmap, str2) { // from class: com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper$superResolution$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap $bitmap;
            final /* synthetic */ String $localPath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$bitmap = bitmap;
                this.$localPath = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) bitmap, (Object) str2);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Bitmap invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bitmap bitmap2 = this.$bitmap;
                if (bitmap2 != null) {
                    return bitmap2;
                }
                String str3 = this.$localPath;
                if (str3 == null) {
                    return null;
                }
                return com.tencent.mobileqq.opr.utils.a.g(str3, null, 1, null);
            }
        }, continuation);
    }
}
