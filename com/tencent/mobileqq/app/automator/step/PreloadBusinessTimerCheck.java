package com.tencent.mobileqq.app.automator.step;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.control.MicroStep;
import com.tencent.mobileqq.startup.control.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessTimerCheck;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/startup/control/a;", "g", tl.h.F, "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "doStep", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "d", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "microStep", "", "e", "Ljava/util/List;", "timerCheckInitFunc", "<init>", "()V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PreloadBusinessTimerCheck extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final int[] f195358h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MicroStep microStep;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Function0<com.tencent.mobileqq.startup.control.a>> timerCheckInitFunc;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessTimerCheck$a;", "", "", "LAST_UPDATE_TIME_PRE", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerCheck$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f195358h = new int[]{12, 24};
        }
    }

    public PreloadBusinessTimerCheck() {
        List<Function0<com.tencent.mobileqq.startup.control.a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.microStep = new MicroStep();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Function0[]{g(), h()});
        this.timerCheckInitFunc = listOf;
    }

    private final Function0<com.tencent.mobileqq.startup.control.a> g() {
        return new Function0<com.tencent.mobileqq.startup.control.a>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerCheck$initStepEvery12H$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerCheck.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.startup.control.a invoke() {
                MicroStep microStep;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.startup.control.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                microStep = PreloadBusinessTimerCheck.this.microStep;
                return microStep.d(MicroStep.BusinessTag.GuildTabSpec, PreloadBusinessTimerCheck$initStepEvery12H$1$result$1.INSTANCE);
            }
        };
    }

    private final Function0<com.tencent.mobileqq.startup.control.a> h() {
        return new Function0<com.tencent.mobileqq.startup.control.a>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerCheck$initStepEvery24H$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerCheck.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.startup.control.a invoke() {
                MicroStep microStep;
                MicroStep microStep2;
                MicroStep microStep3;
                MicroStep microStep4;
                MicroStep microStep5;
                MicroStep microStep6;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.startup.control.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                new a.c(27);
                microStep = PreloadBusinessTimerCheck.this.microStep;
                com.tencent.mobileqq.startup.control.a d16 = microStep.d(MicroStep.BusinessTag.BasicCrash, AnonymousClass1.INSTANCE);
                microStep2 = PreloadBusinessTimerCheck.this.microStep;
                com.tencent.mobileqq.startup.control.a c16 = d16.c(microStep2.d(MicroStep.BusinessTag.BasicPerfNetflow, AnonymousClass2.INSTANCE));
                microStep3 = PreloadBusinessTimerCheck.this.microStep;
                com.tencent.mobileqq.startup.control.a c17 = c16.c(microStep3.d(MicroStep.BusinessTag.BasicMiBaoChange, AnonymousClass3.INSTANCE));
                microStep4 = PreloadBusinessTimerCheck.this.microStep;
                com.tencent.mobileqq.startup.control.a c18 = c17.c(microStep4.d(MicroStep.BusinessTag.PPCLoginAuth, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerCheck$initStepEvery24H$1.4
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerCheck.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BusinessHandler businessHandler = ((Automator) PreloadBusinessTimerCheck.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.PPC_LOGIN_AUTH);
                        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.PPCLoginAuthHandler");
                        ((PPCLoginAuthHandler) businessHandler).E2();
                    }
                }));
                microStep5 = PreloadBusinessTimerCheck.this.microStep;
                com.tencent.mobileqq.startup.control.a c19 = c18.c(microStep5.d(MicroStep.BusinessTag.GroupVideoPreload, AnonymousClass5.INSTANCE));
                microStep6 = PreloadBusinessTimerCheck.this.microStep;
                return c19.c(microStep6.d(MicroStep.BusinessTag.MiniGame, AnonymousClass6.INSTANCE));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        int[] iArr;
        int i3;
        com.tencent.mobileqq.startup.control.a e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr2 = f195358h;
        int length = iArr2.length;
        int i16 = 0;
        com.tencent.mobileqq.startup.control.a aVar = null;
        int i17 = 0;
        while (i16 < length) {
            int i18 = iArr2[i16];
            int i19 = i17 + 1;
            long j3 = ((Automator) this.mAutomator).f195307f.getLong("LAST_UPDATE_NEW_TIME_PRE_" + i18, 0L);
            long j16 = currentTimeMillis - j3;
            if (j3 == 0) {
                QLog.i("AutoMonitor", 1, "PreloadBusiness, timer check interval: " + i18 + "h, return for first launch");
                ((Automator) this.mAutomator).f195307f.edit().putLong("LAST_UPDATE_NEW_TIME_PRE_" + i18, currentTimeMillis).commit();
                iArr = iArr2;
                i3 = length;
            } else {
                iArr = iArr2;
                i3 = length;
                if (Math.abs(j16) >= i18 * 60 * 60 * 1000) {
                    QLog.i("AutoMonitor", 1, "PreloadBusiness, timer check interval: " + i18 + tl.h.F);
                    ((Automator) this.mAutomator).f195307f.edit().putLong("LAST_UPDATE_NEW_TIME_PRE_" + i18, currentTimeMillis).commit();
                    if (aVar == null) {
                        e16 = this.timerCheckInitFunc.get(i17).invoke();
                    } else {
                        com.tencent.mobileqq.startup.control.a invoke = this.timerCheckInitFunc.get(i17).invoke();
                        if (invoke != null) {
                            e16 = aVar.e(invoke);
                        }
                    }
                    aVar = e16;
                }
            }
            i16++;
            i17 = i19;
            iArr2 = iArr;
            length = i3;
        }
        com.tencent.mobileqq.startup.control.a aVar2 = aVar;
        if (aVar2 != null) {
            String f16 = aVar2.f();
            QLog.i("AutoMonitor", 1, "PreloadBusiness, timer check step: " + f16);
            com.tencent.mobileqq.app.automator.h.a((Automator) this.mAutomator, f16).run();
            return 7;
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.microStep.b();
        }
    }
}
