package com.tencent.mobileqq.opr;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskErrorCode;
import com.tencent.mobileqq.opr.model.TaskExtendResult;
import com.tencent.mobileqq.opr.utils.SoLoader;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.qne.QneSDK;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import io.github.landerlyoung.jenny.NativeClass;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeClass
@Keep
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u00a2\u0001\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2{\u0010\u001c\u001aw\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00070\u000fj\u0002`\u001bH\u0082 J?\u0010'\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020*J\u0097\u0001\u0010,\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2{\u0010\u001c\u001aw\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00070\u000fj\u0002`\u001bR\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/opr/QQSR;", "", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "modelConfig", "", "nInit", "nativeHandle", "", "nRelease", "", "nPreloadModel", "", "localPath", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lkotlin/Function5;", "Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/mobileqq/opr/model/TaskExtendResult;", "taskExtendResult", "", "data", "", "width", "height", "Lcom/tencent/mobileqq/opr/SrCallback;", "callback", "nStartSuperResolution", "Landroid/content/Context;", "context", "Lcom/tencent/qne/delegate/d;", "shiply", "Lcom/tencent/qne/delegate/b;", "logger", "Lcom/tencent/qne/delegate/c;", "reporter", "Lcom/tencent/qne/util/d;", ColorRingJsPlugin.Method_SetUp, "(Landroid/content/Context;Lcom/tencent/mobileqq/opr/model/ModelConfig;Lcom/tencent/qne/delegate/d;Lcom/tencent/qne/delegate/b;Lcom/tencent/qne/delegate/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "Lcom/tencent/mobileqq/opr/model/a;", "preloadModel", "startSuperResolution", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/lang/Long;", "<init>", "()V", "Companion", "a", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class QQSR {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    public static final String TAG = "[opr]QQSR";

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private volatile Long nativeHandle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/opr/QQSR$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes16.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            Companion = new a(null);
        }
    }

    public QQSR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lock = new ReentrantLock();
        }
    }

    private final native long nInit(ModelConfig modelConfig);

    private final native boolean nPreloadModel(long nativeHandle);

    private final native void nRelease(long nativeHandle);

    private final native void nStartSuperResolution(long nativeHandle, String localPath, Bitmap bitmap, Function5<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, Unit> callback);

    public static /* synthetic */ Object setup$default(QQSR qqsr, Context context, ModelConfig modelConfig, d dVar, b bVar, c cVar, Continuation continuation, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            cVar = null;
        }
        return qqsr.setup(context, modelConfig, dVar, bVar, cVar, continuation);
    }

    @NotNull
    public final com.tencent.mobileqq.opr.model.a preloadModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.opr.model.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Long l3 = this.nativeHandle;
            if (l3 == null) {
                return new com.tencent.mobileqq.opr.model.a(false, 0L, 3, null);
            }
            long longValue = l3.longValue();
            long currentTimeMillis = System.currentTimeMillis();
            boolean nPreloadModel = nPreloadModel(longValue);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            OprLogger.i(TAG, "preloadModel " + nPreloadModel + ", cost:" + currentTimeMillis2 + " ms");
            return new com.tencent.mobileqq.opr.model.a(nPreloadModel, currentTimeMillis2);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Long l3 = this.nativeHandle;
            this.nativeHandle = null;
            if (l3 == null) {
                return;
            }
            long longValue = l3.longValue();
            OprLogger.i(TAG, Intrinsics.stringPlus("release nativeHandle:", Long.valueOf(longValue)));
            nRelease(longValue);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setup(@NotNull Context context, @NotNull ModelConfig modelConfig, @NotNull d dVar, @NotNull b bVar, @Nullable c cVar, @NotNull Continuation<? super com.tencent.qne.util.d> continuation) {
        QQSR$setup$1 qQSR$setup$1;
        Object coroutine_suspended;
        int i3;
        QQSR qqsr;
        ModelConfig modelConfig2;
        com.tencent.qne.util.d dVar2;
        Context context2;
        ModelConfig modelConfig3;
        com.tencent.qne.util.d dVar3;
        Context context3 = context;
        d dVar4 = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context3, modelConfig, dVar4, bVar, cVar, continuation);
        }
        if (continuation instanceof QQSR$setup$1) {
            qQSR$setup$1 = (QQSR$setup$1) continuation;
            int i16 = qQSR$setup$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQSR$setup$1.label = i16 - Integer.MIN_VALUE;
                QQSR$setup$1 qQSR$setup$12 = qQSR$setup$1;
                Object obj = qQSR$setup$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQSR$setup$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            modelConfig3 = (ModelConfig) qQSR$setup$12.L$2;
                            context2 = (Context) qQSR$setup$12.L$1;
                            qqsr = (QQSR) qQSR$setup$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            dVar3 = (com.tencent.qne.util.d) obj;
                            if (dVar3.b()) {
                                OprLogger.e(TAG, Intrinsics.stringPlus("setup fail, opr setup fail, oprStatus:", dVar3));
                                return dVar3;
                            }
                            ReentrantLock reentrantLock = qqsr.lock;
                            reentrantLock.lock();
                            try {
                                Long boxLong = Boxing.boxLong(qqsr.nInit(modelConfig3));
                                reentrantLock.unlock();
                                qqsr.nativeHandle = boxLong;
                                OprLogger.i(TAG, Intrinsics.stringPlus("setup nativeHandle:", qqsr.nativeHandle));
                                PlatformBridge.INSTANCE.init(context2);
                                return dVar3;
                            } catch (Throwable th5) {
                                reentrantLock.unlock();
                                throw th5;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d dVar5 = (d) qQSR$setup$12.L$3;
                    modelConfig2 = (ModelConfig) qQSR$setup$12.L$2;
                    Context context4 = (Context) qQSR$setup$12.L$1;
                    QQSR qqsr2 = (QQSR) qQSR$setup$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    dVar4 = dVar5;
                    context3 = context4;
                    qqsr = qqsr2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    OprLogger.INSTANCE.init$opr_debug(bVar);
                    QneSDK qneSDK = QneSDK.f344322a;
                    qQSR$setup$12.L$0 = this;
                    qQSR$setup$12.L$1 = context3;
                    qQSR$setup$12.L$2 = modelConfig;
                    qQSR$setup$12.L$3 = dVar4;
                    qQSR$setup$12.label = 1;
                    obj = qneSDK.c(context, dVar, bVar, cVar, qQSR$setup$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qqsr = this;
                    modelConfig2 = modelConfig;
                }
                dVar2 = (com.tencent.qne.util.d) obj;
                if (dVar2.b()) {
                    OprLogger.e(TAG, Intrinsics.stringPlus("setup fail, qne setup fail, qneStatus:", dVar2));
                    return dVar2;
                }
                SoLoader soLoader = new SoLoader(dVar4, context3.getFilesDir() + "/OPR/so");
                qQSR$setup$12.L$0 = qqsr;
                qQSR$setup$12.L$1 = context3;
                qQSR$setup$12.L$2 = modelConfig2;
                qQSR$setup$12.L$3 = null;
                qQSR$setup$12.label = 2;
                obj = soLoader.e(qQSR$setup$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ModelConfig modelConfig4 = modelConfig2;
                context2 = context3;
                modelConfig3 = modelConfig4;
                dVar3 = (com.tencent.qne.util.d) obj;
                if (dVar3.b()) {
                }
            }
        }
        qQSR$setup$1 = new QQSR$setup$1(this, continuation);
        QQSR$setup$1 qQSR$setup$122 = qQSR$setup$1;
        Object obj2 = qQSR$setup$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQSR$setup$122.label;
        if (i3 == 0) {
        }
        dVar2 = (com.tencent.qne.util.d) obj2;
        if (dVar2.b()) {
        }
    }

    public final void startSuperResolution(@Nullable String localPath, @Nullable Bitmap bitmap, @NotNull final Function5<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, localPath, bitmap, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Long l3 = this.nativeHandle;
            if (l3 == null) {
                return;
            }
            nStartSuperResolution(l3.longValue(), localPath, bitmap, new Function5<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, Unit>(callback) { // from class: com.tencent.mobileqq.opr.QQSR$startSuperResolution$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function5<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.opr.QQSR$startSuperResolution$1$1", f = "QQSR.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.opr.QQSR$startSuperResolution$1$1, reason: invalid class name */
                /* loaded from: classes16.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function5<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, Unit> $callback;
                    final /* synthetic */ byte[] $data;
                    final /* synthetic */ TaskErrorCode $errorCode;
                    final /* synthetic */ int $height;
                    final /* synthetic */ TaskExtendResult $taskExtendResult;
                    final /* synthetic */ int $width;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Function5<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, Unit> function5, TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, int i3, int i16, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$callback = function5;
                        this.$errorCode = taskErrorCode;
                        this.$taskExtendResult = taskExtendResult;
                        this.$data = bArr;
                        this.$width = i3;
                        this.$height = i16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, function5, taskErrorCode, taskExtendResult, bArr, Integer.valueOf(i3), Integer.valueOf(i16), continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        return new AnonymousClass1(this.$callback, this.$errorCode, this.$taskExtendResult, this.$data, this.$width, this.$height, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.$callback.invoke(this.$errorCode, this.$taskExtendResult, this.$data, Boxing.boxInt(this.$width), Boxing.boxInt(this.$height));
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(5);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function5
                public /* bridge */ /* synthetic */ Unit invoke(TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, Integer num, Integer num2) {
                    invoke(taskErrorCode, taskExtendResult, bArr, num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull TaskErrorCode errorCode, @NotNull TaskExtendResult taskExtendResult, @Nullable byte[] bArr, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, errorCode, taskExtendResult, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                    Intrinsics.checkNotNullParameter(taskExtendResult, "taskExtendResult");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this.$callback, errorCode, taskExtendResult, bArr, i3, i16, null), 3, null);
                }
            });
        } finally {
            reentrantLock.unlock();
        }
    }
}
