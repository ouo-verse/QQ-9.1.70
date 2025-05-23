package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusCommonApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmethodmonitor.pandoraevent.PandoraEventReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.control.MicroStep;
import com.tencent.mobileqq.startup.control.a;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tencent.util.DevelopInfoUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessTimerDelay;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/startup/control/a;", "i", tl.h.F, "g", "", "doStep", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "d", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "microStep", "", "e", "Ljava/util/List;", "timerDelayInitFunc", "<init>", "()V", "f", "a", "TimerDelayTask", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PreloadBusinessTimerDelay extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final int[] f195362h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MicroStep microStep;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Function0<com.tencent.mobileqq.startup.control.a>> timerDelayInitFunc;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessTimerDelay$TimerDelayTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/automator/Automator;", "d", "Lmqq/util/WeakReference;", "getAutomator", "()Lmqq/util/WeakReference;", "automator", "Lcom/tencent/mobileqq/startup/control/MicroStep;", "e", "getMicroStep", "microStep", "", "f", "Ljava/lang/String;", "getStepDetail", "()Ljava/lang/String;", "stepDetail", "<init>", "(Lmqq/util/WeakReference;Lmqq/util/WeakReference;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class TimerDelayTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Automator> automator;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<MicroStep> microStep;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String stepDetail;

        public TimerDelayTask(@NotNull WeakReference<Automator> automator, @NotNull WeakReference<MicroStep> microStep, @NotNull String stepDetail) {
            Intrinsics.checkNotNullParameter(automator, "automator");
            Intrinsics.checkNotNullParameter(microStep, "microStep");
            Intrinsics.checkNotNullParameter(stepDetail, "stepDetail");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, automator, microStep, stepDetail);
                return;
            }
            this.automator = automator;
            this.microStep = microStep;
            this.stepDetail = stepDetail;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            Automator automator = this.automator.get();
            if (automator != null) {
                if (!(!automator.D)) {
                    automator = null;
                }
                if (automator != null) {
                    com.tencent.mobileqq.app.automator.h.a(automator, this.stepDetail).run();
                }
            }
            MicroStep microStep = this.microStep.get();
            if (microStep != null) {
                microStep.c(com.tencent.mobileqq.startup.control.b.a(this.stepDetail));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/PreloadBusinessTimerDelay$a;", "", "", "LAST_UPDATE_TIME_PRE", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f195362h = new int[]{5, 30, 120};
        }
    }

    public PreloadBusinessTimerDelay() {
        List<Function0<com.tencent.mobileqq.startup.control.a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.microStep = new MicroStep();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Function0[]{i(), h(), g()});
        this.timerDelayInitFunc = listOf;
    }

    private final Function0<com.tencent.mobileqq.startup.control.a> g() {
        return new Function0<com.tencent.mobileqq.startup.control.a>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay2m$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                MicroStep microStep7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.startup.control.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                microStep = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c16 = microStep.d(MicroStep.BusinessTag.BasicCrash, PreloadBusinessTimerDelay$initStepDelay2m$1$result$1.INSTANCE).c(new a.c(68));
                microStep2 = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c17 = c16.c(microStep2.d(MicroStep.BusinessTag.BasicHardCoderSoUpdate, AnonymousClass1.INSTANCE));
                microStep3 = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c18 = c17.c(microStep3.d(MicroStep.BusinessTag.ZPlanConfig, AnonymousClass2.INSTANCE));
                microStep4 = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c19 = c18.c(microStep4.d(MicroStep.BusinessTag.BasicPandoraEventReport, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay2m$1.3
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            PandoraEventReportHelper.b(((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getCurrentAccountUin());
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                })).c(new a.c(52));
                microStep5 = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c26 = c19.c(microStep5.d(MicroStep.BusinessTag.ReportProcessExit, AnonymousClass4.INSTANCE));
                microStep6 = PreloadBusinessTimerDelay.this.microStep;
                com.tencent.mobileqq.startup.control.a c27 = c26.c(microStep6.d(MicroStep.BusinessTag.MiniGame, AnonymousClass5.INSTANCE));
                microStep7 = PreloadBusinessTimerDelay.this.microStep;
                return c27.c(microStep7.d(MicroStep.BusinessTag.BasicPerfMemory, AnonymousClass6.INSTANCE));
            }
        };
    }

    private final Function0<com.tencent.mobileqq.startup.control.a> h() {
        return new Function0<com.tencent.mobileqq.startup.control.a>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1$7, reason: invalid class name */
            /* loaded from: classes11.dex */
            public static final class AnonymousClass7 extends Lambda implements Function0<Unit> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ PreloadBusinessTimerDelay this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass7(PreloadBusinessTimerDelay preloadBusinessTimerDelay) {
                    super(0);
                    this.this$0 = preloadBusinessTimerDelay;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) preloadBusinessTimerDelay);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(PreloadBusinessTimerDelay this$0) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    ZhituManager.I(((Automator) this$0.mAutomator).E).F0(((Automator) this$0.mAutomator).E);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        final PreloadBusinessTimerDelay preloadBusinessTimerDelay = this.this$0;
                        ThreadManagerV2.excute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE 
                              (wrap:java.lang.Runnable:0x0013: CONSTRUCTOR (r0v1 'preloadBusinessTimerDelay' com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay):void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.i.<init>(com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay):void type: CONSTRUCTOR)
                              (128 int)
                              (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                              false
                             STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.7.invoke():void, file: classes11.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.i, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 21 more
                            */
                        /*
                            this = this;
                            com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.AnonymousClass7.$redirector_
                            if (r0 == 0) goto Lf
                            r1 = 2
                            boolean r2 = r0.hasPatch(r1)
                            if (r2 == 0) goto Lf
                            r0.redirect(r1, r4)
                            return
                        Lf:
                            com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay r0 = r4.this$0
                            com.tencent.mobileqq.app.automator.step.i r1 = new com.tencent.mobileqq.app.automator.step.i
                            r1.<init>(r0)
                            r0 = 0
                            r2 = 0
                            r3 = 128(0x80, float:1.794E-43)
                            com.tencent.mobileqq.app.ThreadManagerV2.excute(r1, r3, r0, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.AnonymousClass7.invoke2():void");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1$8, reason: invalid class name */
                /* loaded from: classes11.dex */
                public static final class AnonymousClass8 extends Lambda implements Function0<Unit> {
                    static IPatchRedirector $redirector_;
                    public static final AnonymousClass8 INSTANCE;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54074);
                        $redirector_ = redirector;
                        if (redirector != null && redirector.hasPatch((short) 3)) {
                            redirector.redirect((short) 3);
                        } else {
                            INSTANCE = new AnonymousClass8();
                        }
                    }

                    AnonymousClass8() {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void c() {
                        com.tencent.qqconnect.wtlogin.a.f344969a.a();
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ThreadManagerV2.excute(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE 
                                  (wrap:java.lang.Runnable:0x0011: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.j.<init>():void type: CONSTRUCTOR)
                                  (16 int)
                                  (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                                  false
                                 STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] (LINE:2) in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.8.invoke():void, file: classes11.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.j, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 21 more
                                */
                            /*
                                this = this;
                                com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.AnonymousClass8.$redirector_
                                if (r0 == 0) goto Lf
                                r1 = 2
                                boolean r2 = r0.hasPatch(r1)
                                if (r2 == 0) goto Lf
                                r0.redirect(r1, r4)
                                return
                            Lf:
                                com.tencent.mobileqq.app.automator.step.j r0 = new com.tencent.mobileqq.app.automator.step.j
                                r0.<init>()
                                r1 = 0
                                r2 = 0
                                r3 = 16
                                com.tencent.mobileqq.app.ThreadManagerV2.excute(r0, r3, r1, r2)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.AnonymousClass8.invoke2():void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                        MicroStep microStep7;
                        MicroStep microStep8;
                        MicroStep microStep9;
                        MicroStep microStep10;
                        MicroStep microStep11;
                        MicroStep microStep12;
                        MicroStep microStep13;
                        MicroStep microStep14;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (com.tencent.mobileqq.startup.control.a) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        a.c cVar = new a.c(30);
                        microStep = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c16 = cVar.c(microStep.d(MicroStep.BusinessTag.BasicDexMonitor, AnonymousClass1.INSTANCE));
                        microStep2 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c17 = c16.c(microStep2.d(MicroStep.BusinessTag.ZPlanConfig, AnonymousClass2.INSTANCE));
                        microStep3 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c18 = c17.c(microStep3.d(MicroStep.BusinessTag.MatchFriend, AnonymousClass3.INSTANCE));
                        microStep4 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c19 = c18.c(microStep4.d(MicroStep.BusinessTag.AdAndHealthStepReport, AnonymousClass4.INSTANCE));
                        microStep5 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c26 = c19.c(microStep5.d(MicroStep.BusinessTag.BasicPreDownload, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.5
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                IRuntimeService runtimeService = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getRuntimeService(IPreDownloadController.class);
                                Intrinsics.checkNotNullExpressionValue(runtimeService, "mAutomator.app.getRuntim\u2026ss.java\n                )");
                                ((IPreDownloadController) runtimeService).startPreDownload();
                            }
                        }));
                        microStep6 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c27 = c26.c(microStep6.d(MicroStep.BusinessTag.Relation0x5ebForColdStart, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.6
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                BusinessHandler businessHandler = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER);
                                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.colornote.data.ColorNoteHandler");
                                ((ColorNoteHandler) businessHandler).G2();
                            }
                        }));
                        microStep7 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c28 = c27.c(microStep7.d(MicroStep.BusinessTag.BasicRichText, new AnonymousClass7(PreloadBusinessTimerDelay.this)));
                        microStep8 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c29 = c28.c(microStep8.d(MicroStep.BusinessTag.ReportGuid, AnonymousClass8.INSTANCE));
                        microStep9 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c36 = c29.c(microStep9.d(MicroStep.BusinessTag.MiniDataPull, AnonymousClass9.INSTANCE));
                        microStep10 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c37 = c36.c(microStep10.d(MicroStep.BusinessTag.SubAccountSpecialCare, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay30s$1.10
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getSubAccountSpecialCareListFromService(((Automator) PreloadBusinessTimerDelay.this.mAutomator).E, true, null);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        }));
                        microStep11 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c38 = c37.c(microStep11.d(MicroStep.BusinessTag.MMKVDelayedEvents, AnonymousClass11.INSTANCE));
                        microStep12 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c39 = c38.c(microStep12.d(MicroStep.BusinessTag.PreDownloadTbs, AnonymousClass12.INSTANCE));
                        microStep13 = PreloadBusinessTimerDelay.this.microStep;
                        com.tencent.mobileqq.startup.control.a c46 = c39.c(microStep13.d(MicroStep.BusinessTag.TBSTool, AnonymousClass13.INSTANCE));
                        microStep14 = PreloadBusinessTimerDelay.this.microStep;
                        return c46.c(microStep14.d(MicroStep.BusinessTag.WxMiniApp, AnonymousClass14.INSTANCE));
                    }
                };
            }

            private final Function0<com.tencent.mobileqq.startup.control.a> i() {
                return new Function0<com.tencent.mobileqq.startup.control.a>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1$16, reason: invalid class name */
                    /* loaded from: classes11.dex */
                    public static final class AnonymousClass16 extends Lambda implements Function0<Unit> {
                        static IPatchRedirector $redirector_;
                        public static final AnonymousClass16 INSTANCE;

                        static {
                            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54087);
                            $redirector_ = redirector;
                            if (redirector != null && redirector.hasPatch((short) 3)) {
                                redirector.redirect((short) 3);
                            } else {
                                INSTANCE = new AnonymousClass16();
                            }
                        }

                        AnonymousClass16() {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void c() {
                            if (!nx.a.f421514k.get()) {
                                nx.a.a(BaseApplication.getContext());
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                ThreadManager.getSubThreadHandler().post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE 
                                      (wrap:mqq.os.MqqHandler:0x000f: INVOKE  STATIC call: com.tencent.mobileqq.app.ThreadManager.getSubThreadHandler():mqq.os.MqqHandler A[MD:():mqq.os.MqqHandler (m), WRAPPED] (LINE:2))
                                      (wrap:java.lang.Runnable:0x0015: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.k.<init>():void type: CONSTRUCTOR)
                                     VIRTUAL call: mqq.os.MqqHandler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (m)] (LINE:2) in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.16.invoke():void, file: classes11.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.k, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 21 more
                                    */
                                /*
                                    this = this;
                                    com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass16.$redirector_
                                    if (r0 == 0) goto Lf
                                    r1 = 2
                                    boolean r2 = r0.hasPatch(r1)
                                    if (r2 == 0) goto Lf
                                    r0.redirect(r1, r3)
                                    return
                                Lf:
                                    mqq.os.MqqHandler r0 = com.tencent.mobileqq.app.ThreadManager.getSubThreadHandler()
                                    com.tencent.mobileqq.app.automator.step.k r1 = new com.tencent.mobileqq.app.automator.step.k
                                    r1.<init>()
                                    r0.post(r1)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass16.invoke2():void");
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                        /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1$19, reason: invalid class name */
                        /* loaded from: classes11.dex */
                        public static final class AnonymousClass19 extends Lambda implements Function0<Unit> {
                            static IPatchRedirector $redirector_;
                            public static final AnonymousClass19 INSTANCE;

                            static {
                                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54090);
                                $redirector_ = redirector;
                                if (redirector != null && redirector.hasPatch((short) 3)) {
                                    redirector.redirect((short) 3);
                                } else {
                                    INSTANCE = new AnonymousClass19();
                                }
                            }

                            AnonymousClass19() {
                                super(0);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void c() {
                                ((ILoginApi) QRoute.api(ILoginApi.class)).reportWtUpgrade();
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                    ThreadManagerV2.excute(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE 
                                          (wrap:java.lang.Runnable:0x0011: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.l.<init>():void type: CONSTRUCTOR)
                                          (16 int)
                                          (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                                          false
                                         STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] (LINE:2) in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.19.invoke():void, file: classes11.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.l, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 21 more
                                        */
                                    /*
                                        this = this;
                                        com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass19.$redirector_
                                        if (r0 == 0) goto Lf
                                        r1 = 2
                                        boolean r2 = r0.hasPatch(r1)
                                        if (r2 == 0) goto Lf
                                        r0.redirect(r1, r4)
                                        return
                                    Lf:
                                        com.tencent.mobileqq.app.automator.step.l r0 = new com.tencent.mobileqq.app.automator.step.l
                                        r0.<init>()
                                        r1 = 0
                                        r2 = 0
                                        r3 = 16
                                        com.tencent.mobileqq.app.ThreadManagerV2.excute(r0, r3, r1, r2)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass19.invoke2():void");
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                            /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1$25, reason: invalid class name */
                            /* loaded from: classes11.dex */
                            public static final class AnonymousClass25 extends Lambda implements Function0<Unit> {
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ PreloadBusinessTimerDelay this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass25(PreloadBusinessTimerDelay preloadBusinessTimerDelay) {
                                    super(0);
                                    this.this$0 = preloadBusinessTimerDelay;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) preloadBusinessTimerDelay);
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void b(PreloadBusinessTimerDelay this$0) {
                                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                                    ((Automator) this$0.mAutomator).E.getRuntimeService(ISubAccountService.class);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                    } else {
                                        final PreloadBusinessTimerDelay preloadBusinessTimerDelay = this.this$0;
                                        ThreadManagerV2.excute(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE 
                                              (wrap:java.lang.Runnable:0x0013: CONSTRUCTOR (r0v1 'preloadBusinessTimerDelay' com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay):void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.m.<init>(com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay):void type: CONSTRUCTOR)
                                              (32 int)
                                              (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                                              false
                                             STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.25.invoke():void, file: classes11.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.m, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 21 more
                                            */
                                        /*
                                            this = this;
                                            com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass25.$redirector_
                                            if (r0 == 0) goto Lf
                                            r1 = 2
                                            boolean r2 = r0.hasPatch(r1)
                                            if (r2 == 0) goto Lf
                                            r0.redirect(r1, r4)
                                            return
                                        Lf:
                                            com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay r0 = r4.this$0
                                            com.tencent.mobileqq.app.automator.step.m r1 = new com.tencent.mobileqq.app.automator.step.m
                                            r1.<init>(r0)
                                            r0 = 0
                                            r2 = 0
                                            r3 = 32
                                            com.tencent.mobileqq.app.ThreadManagerV2.excute(r1, r3, r0, r2)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass25.invoke2():void");
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                                /* renamed from: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1$3, reason: invalid class name */
                                /* loaded from: classes11.dex */
                                public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
                                    static IPatchRedirector $redirector_;
                                    public static final AnonymousClass3 INSTANCE;

                                    static {
                                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54106);
                                        $redirector_ = redirector;
                                        if (redirector != null && redirector.hasPatch((short) 3)) {
                                            redirector.redirect((short) 3);
                                        } else {
                                            INSTANCE = new AnonymousClass3();
                                        }
                                    }

                                    AnonymousClass3() {
                                        super(0);
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                            iPatchRedirector.redirect((short) 1, (Object) this);
                                        }
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void c() {
                                        CrashReport.putUserData(BaseApplication.getContext(), "branchName", DevelopInfoUtils.getBranchName(true));
                                        String o3MMKVData = ((IDTAPI) QRoute.api(IDTAPI.class)).getO3MMKVData("O3_1bad5c33edb3fed0");
                                        if (StringUtil.isEmpty(o3MMKVData)) {
                                            o3MMKVData = "-1";
                                        }
                                        CrashReport.putUserData(BaseApplication.getContext(), "repackageInfo", o3MMKVData);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                            ThreadManagerV2.excute(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE 
                                                  (wrap:java.lang.Runnable:0x0011: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.tencent.mobileqq.app.automator.step.n.<init>():void type: CONSTRUCTOR)
                                                  (64 int)
                                                  (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                                                  false
                                                 STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] (LINE:2) in method: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.3.invoke():void, file: classes11.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.app.automator.step.n, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 21 more
                                                */
                                            /*
                                                this = this;
                                                com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass3.$redirector_
                                                if (r0 == 0) goto Lf
                                                r1 = 2
                                                boolean r2 = r0.hasPatch(r1)
                                                if (r2 == 0) goto Lf
                                                r0.redirect(r1, r4)
                                                return
                                            Lf:
                                                com.tencent.mobileqq.app.automator.step.n r0 = new com.tencent.mobileqq.app.automator.step.n
                                                r0.<init>()
                                                r1 = 0
                                                r2 = 0
                                                r3 = 64
                                                com.tencent.mobileqq.app.ThreadManagerV2.excute(r0, r3, r1, r2)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.AnonymousClass3.invoke2():void");
                                        }
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                        MicroStep microStep7;
                                        MicroStep microStep8;
                                        MicroStep microStep9;
                                        MicroStep microStep10;
                                        MicroStep microStep11;
                                        MicroStep microStep12;
                                        MicroStep microStep13;
                                        MicroStep microStep14;
                                        MicroStep microStep15;
                                        MicroStep microStep16;
                                        MicroStep microStep17;
                                        MicroStep microStep18;
                                        MicroStep microStep19;
                                        MicroStep microStep20;
                                        MicroStep microStep21;
                                        MicroStep microStep22;
                                        MicroStep microStep23;
                                        MicroStep microStep24;
                                        MicroStep microStep25;
                                        MicroStep microStep26;
                                        MicroStep microStep27;
                                        MicroStep microStep28;
                                        MicroStep microStep29;
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                            return (com.tencent.mobileqq.startup.control.a) iPatchRedirector.redirect((short) 2, (Object) this);
                                        }
                                        microStep = PreloadBusinessTimerDelay.this.microStep;
                                        MicroStep.BusinessTag businessTag = MicroStep.BusinessTag.BasicRealNameCheck;
                                        final PreloadBusinessTimerDelay preloadBusinessTimerDelay = PreloadBusinessTimerDelay.this;
                                        com.tencent.mobileqq.startup.control.a d16 = microStep.d(businessTag, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1$result$1
                                            static IPatchRedirector $redirector_;

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                BusinessHandler businessHandler = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                                                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.ConfigHandler");
                                                ((ConfigHandler) businessHandler).r3();
                                            }
                                        });
                                        microStep2 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c16 = d16.c(microStep2.d(MicroStep.BusinessTag.NoPasswordCheck, AnonymousClass1.INSTANCE));
                                        microStep3 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c17 = c16.c(microStep3.d(MicroStep.BusinessTag.GuildTabSpec, AnonymousClass2.INSTANCE));
                                        microStep4 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c18 = c17.c(microStep4.d(MicroStep.BusinessTag.BasicCrash, AnonymousClass3.INSTANCE));
                                        microStep5 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c19 = c18.c(microStep5.d(MicroStep.BusinessTag.IssueFix, AnonymousClass4.INSTANCE));
                                        microStep6 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c26 = c19.c(microStep6.d(MicroStep.BusinessTag.GuildMsgFocusReport, AnonymousClass5.INSTANCE));
                                        AppSetting.isPublicVersion();
                                        microStep7 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c27 = c26.c(microStep7.d(MicroStep.BusinessTag.ZPlanConfig, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.6
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                                                QQAppInterface qQAppInterface = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E;
                                                Intrinsics.checkNotNullExpressionValue(qQAppInterface, "mAutomator.app");
                                                iZPlanApi.prepareZPlanConfig(qQAppInterface);
                                            }
                                        }));
                                        microStep8 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c28 = c27.c(microStep8.d(MicroStep.BusinessTag.RelationGetMatchFriendEntrance, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.7
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                                    ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getMatchFriendEntrance(((Automator) PreloadBusinessTimerDelay.this.mAutomator).E);
                                                } else {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                }
                                            }
                                        }));
                                        microStep9 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c29 = c28.c(microStep9.d(MicroStep.BusinessTag.VASSelfVipData, AnonymousClass8.INSTANCE));
                                        microStep10 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c36 = c29.c(microStep10.d(MicroStep.BusinessTag.VASVipData, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.9
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                                    VasUtil.getService().getAppIconSwitchManager().checkAndSwitchIcon(((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getCurrentUin(), false);
                                                } else {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                }
                                            }
                                        }));
                                        microStep11 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c37 = c36.c(microStep11.d(MicroStep.BusinessTag.VASGetFunCallData, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.10
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                BusinessHandler businessHandler = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
                                                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vipav.VipSetFunCallHandler");
                                                ((VipSetFunCallHandler) businessHandler).P2(1, new Bundle());
                                            }
                                        }));
                                        microStep12 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c38 = c37.c(microStep12.d(MicroStep.BusinessTag.MiniMsgTab, AnonymousClass11.INSTANCE));
                                        microStep13 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c39 = c38.c(microStep13.d(MicroStep.BusinessTag.GameCenterCheck, AnonymousClass12.INSTANCE));
                                        microStep14 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c46 = c39.c(microStep14.d(MicroStep.BusinessTag.NewerGuideBanner, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.13
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                Manager manager = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
                                                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager");
                                                ((com.tencent.mobileqq.activity.recent.guidebanner.b) manager).d();
                                            }
                                        }));
                                        microStep15 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c47 = c46.c(microStep15.d(MicroStep.BusinessTag.NTTraceReport, AnonymousClass14.INSTANCE));
                                        microStep16 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c48 = c47.c(microStep16.d(MicroStep.BusinessTag.ColorNoteGetRecentSwitch, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.15
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                BusinessHandler businessHandler = ((Automator) PreloadBusinessTimerDelay.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER);
                                                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.colornote.data.ColorNoteHandler");
                                                ((ColorNoteHandler) businessHandler).H2();
                                            }
                                        }));
                                        microStep17 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c49 = c48.c(microStep17.d(MicroStep.BusinessTag.BmqqInit, AnonymousClass16.INSTANCE));
                                        microStep18 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c56 = c49.c(microStep18.d(MicroStep.BusinessTag.MsgBackupCleanRootPath, AnonymousClass17.INSTANCE));
                                        microStep19 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c57 = c56.c(microStep19.d(MicroStep.BusinessTag.MsgNotifyPushDialogTask, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.18
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                                    new MsgNotifyPushDialog.e(((Automator) PreloadBusinessTimerDelay.this.mAutomator).E).execute(new Void[0]);
                                                } else {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                }
                                            }
                                        }));
                                        microStep20 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c58 = c57.c(microStep20.d(MicroStep.BusinessTag.WtUpgradeReport, AnonymousClass19.INSTANCE));
                                        microStep21 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c59 = c58.c(microStep21.d(MicroStep.BusinessTag.NotificationConfigParser, AnonymousClass20.INSTANCE));
                                        microStep22 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c65 = c59.c(microStep22.d(MicroStep.BusinessTag.ZhuoXusConfigParser, AnonymousClass21.INSTANCE));
                                        microStep23 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c66 = c65.c(microStep23.d(MicroStep.BusinessTag.Shiply, AnonymousClass22.INSTANCE));
                                        if (!AppSetting.isPublicVersion()) {
                                            microStep29 = PreloadBusinessTimerDelay.this.microStep;
                                            c66 = c66.c(microStep29.d(MicroStep.BusinessTag.BasicMiBaoChange, AnonymousClass23.INSTANCE));
                                        }
                                        microStep24 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c67 = c66.c(microStep24.d(MicroStep.BusinessTag.QuickApp, AnonymousClass24.INSTANCE));
                                        microStep25 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c68 = c67.c(microStep25.d(MicroStep.BusinessTag.SubAccountServiceInit, new AnonymousClass25(PreloadBusinessTimerDelay.this)));
                                        microStep26 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c69 = c68.c(microStep26.d(MicroStep.BusinessTag.OnlineStatusInit, new Function0<Unit>() { // from class: com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay$initStepDelay5s$1.26
                                            static IPatchRedirector $redirector_;

                                            {
                                                super(0);
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreloadBusinessTimerDelay.this);
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
                                                IOnlineStatusCommonApi iOnlineStatusCommonApi = (IOnlineStatusCommonApi) QRoute.api(IOnlineStatusCommonApi.class);
                                                Automator automator = (Automator) PreloadBusinessTimerDelay.this.mAutomator;
                                                iOnlineStatusCommonApi.doInit(automator != null ? automator.E : null);
                                            }
                                        }));
                                        microStep27 = PreloadBusinessTimerDelay.this.microStep;
                                        com.tencent.mobileqq.startup.control.a c75 = c69.c(microStep27.d(MicroStep.BusinessTag.PublicAccountInit, AnonymousClass27.INSTANCE));
                                        microStep28 = PreloadBusinessTimerDelay.this.microStep;
                                        return c75.c(microStep28.d(MicroStep.BusinessTag.FlashTransferResumeFailedTransfer, AnonymousClass28.INSTANCE));
                                    }
                                };
                            }

                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.tencent.mobileqq.app.automator.AsyncStep
                            public int doStep() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                                }
                                int[] iArr = f195362h;
                                int length = iArr.length;
                                int i3 = 0;
                                int i16 = 0;
                                while (i3 < length) {
                                    int i17 = iArr[i3];
                                    int i18 = i16 + 1;
                                    com.tencent.mobileqq.startup.control.a invoke = this.timerDelayInitFunc.get(i16).invoke();
                                    if (invoke != null) {
                                        String f16 = invoke.f();
                                        ThreadManagerV2.executeDelay(new TimerDelayTask(new WeakReference(this.mAutomator), new WeakReference(this.microStep), f16), 16, null, true, i17 * 1000);
                                        QLog.i("AutoMonitor", 1, "PreloadBusiness, timer delay: " + i17 + ", step: " + f16);
                                    }
                                    i3++;
                                    i16 = i18;
                                }
                                return 7;
                            }
                        }
