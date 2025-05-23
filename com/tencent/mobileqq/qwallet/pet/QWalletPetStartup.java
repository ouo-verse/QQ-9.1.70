package com.tencent.mobileqq.qwallet.pet;

import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$GetRsp;
import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import com.tencent.mobileqq.qwallet.pet.data.f;
import com.tencent.qphone.base.util.QLog;
import il2.a;
import il2.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\n\u0011012\u00163\u0019\u000b4\tB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b-\u0010.J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#R[\u0010,\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\b0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup;", "", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "stepResult", "", "e", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;ZLcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$d;", "callback", "f", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "a", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "getScene", "()Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "scene", "b", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$d;", "", "c", "Ljava/util/Map;", "finishTask", "Lgl2/d;", "Lgl2/d;", "preloadStrategy", "Lil2/a;", "Lil2/a;", "supportChecker", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStartCheck", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "step", "result", "g", "Lkotlin/jvm/functions/Function3;", "stepCheckerCallback", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;)V", h.F, "CheckInitFilament", "CheckModelResource", "CheckPrepareData", "EnumTask", "Scene", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPetStartup {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<EnumTask, Boolean> finishTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gl2.d preloadStrategy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final il2.a supportChecker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean hasStartCheck;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<EnumTask, Boolean, FailResultData, Unit> stepCheckerCallback;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$CheckInitFilament;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$e;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "getScene", "()Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "scene", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "Lkotlin/ParameterName;", "name", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "stepResult", "callback", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;Lkotlin/jvm/functions/Function3;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class CheckInitFilament extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Scene scene;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f278727a;

            static {
                int[] iArr = new int[Scene.values().length];
                try {
                    iArr[Scene.QWALLET_HOME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Scene.PET_HOME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f278727a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckInitFilament(@NotNull Scene scene, @NotNull Function3<? super EnumTask, ? super Boolean, ? super FailResultData, Unit> callback) {
            super(EnumTask.TASK_INIT_FILAMENT, callback);
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.scene = scene;
        }

        @Nullable
        public Object c(@NotNull Continuation<? super Unit> continuation) {
            int i3 = a.f278727a[this.scene.ordinal()];
            if (i3 == 1 || i3 == 2) {
                b.f407933a.a(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckInitFilament$check$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        QLog.i("QWallet.Pet.Startup", 1, QWalletPetStartup.CheckInitFilament.this.getCheckerStep() + MsgSummary.STR_COLON + z16);
                        QWalletPetStartup.CheckInitFilament.this.a().invoke(QWalletPetStartup.CheckInitFilament.this.getCheckerStep(), Boolean.valueOf(z16), QWalletPetStartup.FailResultData.INSTANCE.a(QWalletPetStartup.CheckInitFilament.this.getCheckerStep()));
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$CheckModelResource;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$e;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lgl2/d;", "Lgl2/d;", "getPreloadStrategy", "()Lgl2/d;", "preloadStrategy", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "Lkotlin/ParameterName;", "name", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "stepResult", "callback", "<init>", "(Lgl2/d;Lkotlin/jvm/functions/Function3;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class CheckModelResource extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final gl2.d preloadStrategy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckModelResource(@NotNull gl2.d preloadStrategy, @NotNull Function3<? super EnumTask, ? super Boolean, ? super FailResultData, Unit> callback) {
            super(EnumTask.TASK_MODEL_RESOURCE, callback);
            Intrinsics.checkNotNullParameter(preloadStrategy, "preloadStrategy");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.preloadStrategy = preloadStrategy;
        }

        @Nullable
        public Object c(@NotNull Continuation<? super Unit> continuation) {
            this.preloadStrategy.h(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckModelResource$check$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QLog.i("QWallet.Pet.Startup", 1, QWalletPetStartup.CheckModelResource.this.getCheckerStep() + ": true");
                    QWalletPetStartup.CheckModelResource.this.a().invoke(QWalletPetStartup.CheckModelResource.this.getCheckerStep(), Boolean.valueOf(z16), QWalletPetStartup.FailResultData.INSTANCE.a(QWalletPetStartup.CheckModelResource.this.getCheckerStep()));
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001Bf\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012M\u0010\u0018\u001aI\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00020\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$CheckPrepareData;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$e;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lgl2/d;", "Lgl2/d;", "e", "()Lgl2/d;", "preloadStrategy", "Lil2/a;", "d", "Lil2/a;", "()Lil2/a;", "petSupportChecker", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "Lkotlin/ParameterName;", "name", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "result", "callback", "<init>", "(Lgl2/d;Lil2/a;Lkotlin/jvm/functions/Function3;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class CheckPrepareData extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final gl2.d preloadStrategy;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final il2.a petSupportChecker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckPrepareData(@NotNull gl2.d preloadStrategy, @NotNull il2.a petSupportChecker, @NotNull Function3<? super EnumTask, ? super Boolean, ? super FailResultData, Unit> callback) {
            super(EnumTask.TASK_PREPARE_DATA, callback);
            Intrinsics.checkNotNullParameter(preloadStrategy, "preloadStrategy");
            Intrinsics.checkNotNullParameter(petSupportChecker, "petSupportChecker");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.preloadStrategy = preloadStrategy;
            this.petSupportChecker = petSupportChecker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object c(@NotNull Continuation<? super Unit> continuation) {
            QWalletPetStartup$CheckPrepareData$check$1 qWalletPetStartup$CheckPrepareData$check$1;
            Object coroutine_suspended;
            int i3;
            CheckPrepareData checkPrepareData;
            if (continuation instanceof QWalletPetStartup$CheckPrepareData$check$1) {
                qWalletPetStartup$CheckPrepareData$check$1 = (QWalletPetStartup$CheckPrepareData$check$1) continuation;
                int i16 = qWalletPetStartup$CheckPrepareData$check$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    qWalletPetStartup$CheckPrepareData$check$1.label = i16 - Integer.MIN_VALUE;
                    QWalletPetStartup$CheckPrepareData$check$1 qWalletPetStartup$CheckPrepareData$check$12 = qWalletPetStartup$CheckPrepareData$check$1;
                    Object obj = qWalletPetStartup$CheckPrepareData$check$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = qWalletPetStartup$CheckPrepareData$check$12.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            checkPrepareData = (CheckPrepareData) qWalletPetStartup$CheckPrepareData$check$12.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception e16) {
                                e = e16;
                                QLog.w("QWallet.Pet.Startup", 1, checkPrepareData.getCheckerStep() + " error " + e);
                                checkPrepareData.a().invoke(checkPrepareData.getCheckerStep(), Boxing.boxBoolean(false), FailResultData.INSTANCE.a(checkPrepareData.getCheckerStep()));
                                return Unit.INSTANCE;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        try {
                            final CountDownLatch countDownLatch = new CountDownLatch(2);
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            hl2.a aVar = hl2.a.f405243a;
                            aVar.c(new Function2<Boolean, PetGlobalConfig$GetRsp, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckPrepareData$check$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, PetGlobalConfig$GetRsp petGlobalConfig$GetRsp) {
                                    invoke(bool.booleanValue(), petGlobalConfig$GetRsp);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16, @Nullable PetGlobalConfig$GetRsp petGlobalConfig$GetRsp) {
                                    Ref.BooleanRef.this.element = f.f278777a.j(petGlobalConfig$GetRsp);
                                    countDownLatch.countDown();
                                }
                            });
                            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            aVar.d(new Function2<Integer, PetUserState$HomepageRsp, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckPrepareData$check$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, PetUserState$HomepageRsp petUserState$HomepageRsp) {
                                    invoke(num.intValue(), petUserState$HomepageRsp);
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                public final void invoke(int i17, @Nullable PetUserState$HomepageRsp petUserState$HomepageRsp) {
                                    Ref.ObjectRef<PetUserState$HomepageRsp> objectRef2 = objectRef;
                                    T t16 = petUserState$HomepageRsp;
                                    if (i17 == 200002) {
                                        t16 = new PetUserState$HomepageRsp();
                                    }
                                    objectRef2.element = t16;
                                    this.getPetSupportChecker().b(objectRef.element);
                                    countDownLatch.countDown();
                                }
                            });
                            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
                            PetUserState$HomepageRsp petUserState$HomepageRsp = (PetUserState$HomepageRsp) objectRef.element;
                            if (booleanRef.element && petUserState$HomepageRsp != null) {
                                i.e eVar = i.e.f261783e;
                                QWalletPetStartup$CheckPrepareData$check$4 qWalletPetStartup$CheckPrepareData$check$4 = new QWalletPetStartup$CheckPrepareData$check$4(this, petUserState$HomepageRsp, null);
                                qWalletPetStartup$CheckPrepareData$check$12.L$0 = this;
                                qWalletPetStartup$CheckPrepareData$check$12.label = 1;
                                if (CorountineFunKt.i(eVar, "QWallet.Pet.Startup", null, qWalletPetStartup$CheckPrepareData$check$4, qWalletPetStartup$CheckPrepareData$check$12, 4, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                a().invoke(getCheckerStep(), Boxing.boxBoolean(false), FailResultData.INSTANCE.a(getCheckerStep()));
                                QLog.i("QWallet.Pet.Startup", 1, getCheckerStep() + ": false");
                            }
                        } catch (Exception e17) {
                            e = e17;
                            checkPrepareData = this;
                            QLog.w("QWallet.Pet.Startup", 1, checkPrepareData.getCheckerStep() + " error " + e);
                            checkPrepareData.a().invoke(checkPrepareData.getCheckerStep(), Boxing.boxBoolean(false), FailResultData.INSTANCE.a(checkPrepareData.getCheckerStep()));
                            return Unit.INSTANCE;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            qWalletPetStartup$CheckPrepareData$check$1 = new QWalletPetStartup$CheckPrepareData$check$1(this, continuation);
            QWalletPetStartup$CheckPrepareData$check$1 qWalletPetStartup$CheckPrepareData$check$122 = qWalletPetStartup$CheckPrepareData$check$1;
            Object obj2 = qWalletPetStartup$CheckPrepareData$check$122.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = qWalletPetStartup$CheckPrepareData$check$122.label;
            if (i3 == 0) {
            }
            return Unit.INSTANCE;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final il2.a getPetSupportChecker() {
            return this.petSupportChecker;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final gl2.d getPreloadStrategy() {
            return this.preloadStrategy;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "", "(Ljava/lang/String;I)V", "TASK_START", "TASK_PREPARE_DATA", "TASK_SUPPORT", "TASK_INIT_FILAMENT", "TASK_MODEL_RESOURCE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum EnumTask {
        TASK_START,
        TASK_PREPARE_DATA,
        TASK_SUPPORT,
        TASK_INIT_FILAMENT,
        TASK_MODEL_RESOURCE
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$Scene;", "", "(Ljava/lang/String;I)V", "QWALLET_HOME", "PET_HOME", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum Scene {
        QWALLET_HOME,
        PET_HOME
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$a;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$e;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lil2/a;", "Lil2/a;", "getSupportChecker", "()Lil2/a;", "supportChecker", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "Lkotlin/ParameterName;", "name", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "stepResult", "callback", "<init>", "(Lil2/a;Lkotlin/jvm/functions/Function3;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends e {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final il2.a supportChecker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull il2.a supportChecker, @NotNull Function3<? super EnumTask, ? super Boolean, ? super FailResultData, Unit> callback) {
            super(EnumTask.TASK_SUPPORT, callback);
            Intrinsics.checkNotNullParameter(supportChecker, "supportChecker");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.supportChecker = supportChecker;
        }

        @Nullable
        public Object c(@NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            a.SupportResult supportResult = this.supportChecker.getSupportResult();
            if (supportResult != null && !supportResult.getIsSupport()) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = !z16;
            QLog.i("QWallet.Pet.Startup", 1, getCheckerStep() + MsgSummary.STR_COLON + z17);
            if (!z17) {
                FailResultData a16 = FailResultData.INSTANCE.a(getCheckerStep());
                if (a16 != null) {
                    a16.d(this.supportChecker.getSupportResult());
                }
                a().invoke(getCheckerStep(), Boxing.boxBoolean(false), a16);
            } else {
                a().invoke(getCheckerStep(), Boxing.boxBoolean(true), null);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "a", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "c", "()Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "failTask", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "failMsg", "Ljava/lang/Object;", "()Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "failData", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;Ljava/lang/String;Ljava/lang/Object;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class FailResultData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final EnumTask failTask;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String failMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Object failData;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c$a;", "", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "failStep", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$c$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final FailResultData a(@Nullable EnumTask failStep) {
                if (failStep == null) {
                    return null;
                }
                String string = jl2.b.f410584a.a().getString(R.string.f2182863a, Integer.valueOf(failStep.ordinal()));
                Intrinsics.checkNotNullExpressionValue(string, "QWalletPetUtils.appConte\u2026or_msg, failStep.ordinal)");
                return new FailResultData(failStep, string, null);
            }

            Companion() {
            }
        }

        public FailResultData(@NotNull EnumTask failTask, @Nullable String str, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(failTask, "failTask");
            this.failTask = failTask;
            this.failMsg = str;
            this.failData = obj;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Object getFailData() {
            return this.failData;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getFailMsg() {
            return this.failMsg;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final EnumTask getFailTask() {
            return this.failTask;
        }

        public final void d(@Nullable Object obj) {
            this.failData = obj;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FailResultData)) {
                return false;
            }
            FailResultData failResultData = (FailResultData) other;
            if (this.failTask == failResultData.failTask && Intrinsics.areEqual(this.failMsg, failResultData.failMsg) && Intrinsics.areEqual(this.failData, failResultData.failData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.failTask.hashCode() * 31;
            String str = this.failMsg;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            Object obj = this.failData;
            if (obj != null) {
                i3 = obj.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "FailResultData(failTask=" + this.failTask + ", failMsg=" + this.failMsg + ", failData=" + this.failData + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$d;", "", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "finishTask", "", "a", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "failResultData", "b", "(ZLcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface d {
        @Nullable
        Object a(@NotNull EnumTask enumTask, @NotNull Continuation<? super Unit> continuation);

        @Nullable
        Object b(boolean z16, @Nullable FailResultData failResultData, @NotNull Continuation<? super Unit> continuation);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\b\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R^\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$e;", "", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "a", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "b", "()Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;", "checkerStep", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "currentStep", "", "isSucceed", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$c;", "result", "", "Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function3;", "callback", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup$EnumTask;Lkotlin/jvm/functions/Function3;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EnumTask checkerStep;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function3<EnumTask, Boolean, FailResultData, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull EnumTask checkerStep, @NotNull Function3<? super EnumTask, ? super Boolean, ? super FailResultData, Unit> callback) {
            Intrinsics.checkNotNullParameter(checkerStep, "checkerStep");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.checkerStep = checkerStep;
            this.callback = callback;
        }

        @NotNull
        public final Function3<EnumTask, Boolean, FailResultData, Unit> a() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final EnumTask getCheckerStep() {
            return this.checkerStep;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278738a;

        static {
            int[] iArr = new int[EnumTask.values().length];
            try {
                iArr[EnumTask.TASK_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumTask.TASK_PREPARE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumTask.TASK_SUPPORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumTask.TASK_INIT_FILAMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumTask.TASK_MODEL_RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f278738a = iArr;
        }
    }

    public QWalletPetStartup(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
        this.finishTask = new LinkedHashMap();
        this.preloadStrategy = new gl2.d();
        this.supportChecker = new il2.a();
        this.hasStartCheck = new AtomicBoolean(false);
        this.stepCheckerCallback = new Function3<EnumTask, Boolean, FailResultData, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$stepCheckerCallback$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$stepCheckerCallback$1$1", f = "QWalletPetStartup.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$stepCheckerCallback$1$1, reason: invalid class name */
            /* loaded from: classes16.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ boolean $isSucceed;
                final /* synthetic */ QWalletPetStartup.FailResultData $result;
                final /* synthetic */ QWalletPetStartup.EnumTask $step;
                int label;
                final /* synthetic */ QWalletPetStartup this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(QWalletPetStartup qWalletPetStartup, QWalletPetStartup.EnumTask enumTask, boolean z16, QWalletPetStartup.FailResultData failResultData, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = qWalletPetStartup;
                    this.$step = enumTask;
                    this.$isSucceed = z16;
                    this.$result = failResultData;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$step, this.$isSucceed, this.$result, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    Object e16;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        QWalletPetStartup qWalletPetStartup = this.this$0;
                        QWalletPetStartup.EnumTask enumTask = this.$step;
                        boolean z16 = this.$isSucceed;
                        QWalletPetStartup.FailResultData failResultData = this.$result;
                        this.label = 1;
                        e16 = qWalletPetStartup.e(enumTask, z16, failResultData, this);
                        if (e16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(QWalletPetStartup.EnumTask enumTask, Boolean bool, QWalletPetStartup.FailResultData failResultData) {
                invoke(enumTask, bool.booleanValue(), failResultData);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull QWalletPetStartup.EnumTask step, boolean z16, @Nullable QWalletPetStartup.FailResultData failResultData) {
                Intrinsics.checkNotNullParameter(step, "step");
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "QWallet.Pet.Startup", null, null, null, new AnonymousClass1(QWalletPetStartup.this, step, z16, failResultData, null), 14, null);
                }
            }
        };
    }

    private final Object d(Continuation<? super Unit> continuation) {
        return CorountineFunKt.i(i.c.f261781e, "QWallet.Pet.Startup", null, new QWalletPetStartup$checkAllTaskFinish$2(this, null), continuation, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(EnumTask enumTask, boolean z16, FailResultData failResultData, Continuation<? super Unit> continuation) {
        QWalletPetStartup$nextStep$1 qWalletPetStartup$nextStep$1;
        Object coroutine_suspended;
        QWalletPetStartup qWalletPetStartup;
        int i3;
        QWalletPetStartup qWalletPetStartup2;
        CheckModelResource checkModelResource;
        EnumTask enumTask2 = enumTask;
        if (continuation instanceof QWalletPetStartup$nextStep$1) {
            qWalletPetStartup$nextStep$1 = (QWalletPetStartup$nextStep$1) continuation;
            int i16 = qWalletPetStartup$nextStep$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qWalletPetStartup$nextStep$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qWalletPetStartup$nextStep$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (qWalletPetStartup$nextStep$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (!z16) {
                            QLog.w("QWallet.Pet.Startup", 1, "startup end, fail step: " + enumTask2);
                            i.e eVar = i.e.f261783e;
                            QWalletPetStartup$nextStep$2 qWalletPetStartup$nextStep$2 = new QWalletPetStartup$nextStep$2(this, failResultData, null);
                            qWalletPetStartup$nextStep$1.label = 1;
                            if (CorountineFunKt.i(eVar, "QWallet.Pet.Startup", null, qWalletPetStartup$nextStep$2, qWalletPetStartup$nextStep$1, 4, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        this.finishTask.put(enumTask2, Boxing.boxBoolean(z16));
                        i.e eVar2 = i.e.f261783e;
                        QWalletPetStartup$nextStep$3 qWalletPetStartup$nextStep$3 = new QWalletPetStartup$nextStep$3(this, enumTask2, null);
                        qWalletPetStartup$nextStep$1.L$0 = this;
                        qWalletPetStartup$nextStep$1.L$1 = enumTask2;
                        qWalletPetStartup$nextStep$1.label = 2;
                        if (CorountineFunKt.i(eVar2, "QWallet.Pet.Startup", null, qWalletPetStartup$nextStep$3, qWalletPetStartup$nextStep$1, 4, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        qWalletPetStartup = this;
                        i3 = f.f278738a[enumTask2.ordinal()];
                        if (i3 == 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 != 5) {
                                            return Unit.INSTANCE;
                                        }
                                        qWalletPetStartup$nextStep$1.L$0 = null;
                                        qWalletPetStartup$nextStep$1.L$1 = null;
                                        qWalletPetStartup$nextStep$1.label = 8;
                                        if (qWalletPetStartup.d(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    qWalletPetStartup$nextStep$1.L$0 = null;
                                    qWalletPetStartup$nextStep$1.L$1 = null;
                                    qWalletPetStartup$nextStep$1.label = 7;
                                    if (qWalletPetStartup.d(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                CheckInitFilament checkInitFilament = new CheckInitFilament(qWalletPetStartup.scene, qWalletPetStartup.stepCheckerCallback);
                                qWalletPetStartup$nextStep$1.L$0 = qWalletPetStartup;
                                qWalletPetStartup$nextStep$1.L$1 = null;
                                qWalletPetStartup$nextStep$1.label = 5;
                                if (checkInitFilament.c(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                qWalletPetStartup2 = qWalletPetStartup;
                                checkModelResource = new CheckModelResource(qWalletPetStartup2.preloadStrategy, qWalletPetStartup2.stepCheckerCallback);
                                qWalletPetStartup$nextStep$1.L$0 = null;
                                qWalletPetStartup$nextStep$1.label = 6;
                                if (checkModelResource.c(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            a aVar = new a(qWalletPetStartup.supportChecker, qWalletPetStartup.stepCheckerCallback);
                            qWalletPetStartup$nextStep$1.L$0 = null;
                            qWalletPetStartup$nextStep$1.L$1 = null;
                            qWalletPetStartup$nextStep$1.label = 4;
                            if (aVar.c(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        CheckPrepareData checkPrepareData = new CheckPrepareData(qWalletPetStartup.preloadStrategy, qWalletPetStartup.supportChecker, qWalletPetStartup.stepCheckerCallback);
                        qWalletPetStartup$nextStep$1.L$0 = null;
                        qWalletPetStartup$nextStep$1.L$1 = null;
                        qWalletPetStartup$nextStep$1.label = 3;
                        if (checkPrepareData.c(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 2:
                        enumTask2 = (EnumTask) qWalletPetStartup$nextStep$1.L$1;
                        qWalletPetStartup = (QWalletPetStartup) qWalletPetStartup$nextStep$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i3 = f.f278738a[enumTask2.ordinal()];
                        if (i3 == 1) {
                        }
                        break;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 5:
                        qWalletPetStartup2 = (QWalletPetStartup) qWalletPetStartup$nextStep$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        checkModelResource = new CheckModelResource(qWalletPetStartup2.preloadStrategy, qWalletPetStartup2.stepCheckerCallback);
                        qWalletPetStartup$nextStep$1.L$0 = null;
                        qWalletPetStartup$nextStep$1.label = 6;
                        if (checkModelResource.c(qWalletPetStartup$nextStep$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        qWalletPetStartup$nextStep$1 = new QWalletPetStartup$nextStep$1(this, continuation);
        Object obj2 = qWalletPetStartup$nextStep$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (qWalletPetStartup$nextStep$1.label) {
        }
    }

    public final void f(@NotNull d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.hasStartCheck.compareAndSet(false, true)) {
            return;
        }
        this.callback = callback;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QWallet.Pet.Startup", null, null, null, new QWalletPetStartup$startCheck$1(this, null), 14, null);
        }
    }
}
