package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.trooptodo.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;", "", "Lkotlin/Function0;", "", "task", "c", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/trooptodo/d;", "model", "e", tl.h.F, "i", "j", "f", "g", "Lcom/tencent/mobileqq/troop/trooptodo/m$a;", "a", "Lcom/tencent/mobileqq/troop/trooptodo/m$a;", "reportData", "<init>", "()V", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopToDoReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m.a reportData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter$a;", "", "", "TYPE_FAIL", "I", "TYPE_SUCCESS", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopToDoReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.reportData = new m.a();
        }
    }

    private final void c(final Function0<Unit> task) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.trooptodo.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopToDoReporter.d(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void e(@NotNull AppInterface app, @NotNull d model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(model, "model");
        this.reportData.f301812a = m.c(app, model.c().f301780a);
        this.reportData.f301813b = model.c().f301785f;
        this.reportData.f301814c = model.c().f301786g;
        this.reportData.f301815d = model.c().f301787h;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$reportCloseTask$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoReporter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m.a aVar;
                    m.a aVar2;
                    m.a aVar3;
                    m.a aVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    aVar = TroopToDoReporter.this.reportData;
                    String valueOf = String.valueOf(aVar.f301812a);
                    aVar2 = TroopToDoReporter.this.reportData;
                    String valueOf2 = String.valueOf(aVar2.f301813b);
                    aVar3 = TroopToDoReporter.this.reportData;
                    String str = aVar3.f301814c;
                    aVar4 = TroopToDoReporter.this.reportData;
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BC78", "0X800BC78", 0, 0, valueOf, valueOf2, str, String.valueOf(aVar4.f301815d));
                }
            });
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$reportComplteTask$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoReporter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m.a aVar;
                    m.a aVar2;
                    m.a aVar3;
                    m.a aVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    aVar = TroopToDoReporter.this.reportData;
                    String valueOf = String.valueOf(aVar.f301812a);
                    aVar2 = TroopToDoReporter.this.reportData;
                    String valueOf2 = String.valueOf(aVar2.f301813b);
                    aVar3 = TroopToDoReporter.this.reportData;
                    String str = aVar3.f301814c;
                    aVar4 = TroopToDoReporter.this.reportData;
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BC77", "0X800BC77", 0, 0, valueOf, valueOf2, str, String.valueOf(aVar4.f301815d));
                }
            });
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$reportExposure$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoReporter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m.a aVar;
                    m.a aVar2;
                    m.a aVar3;
                    m.a aVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    aVar = TroopToDoReporter.this.reportData;
                    String valueOf = String.valueOf(aVar.f301812a);
                    aVar2 = TroopToDoReporter.this.reportData;
                    String valueOf2 = String.valueOf(aVar2.f301813b);
                    aVar3 = TroopToDoReporter.this.reportData;
                    String str = aVar3.f301814c;
                    aVar4 = TroopToDoReporter.this.reportData;
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BC74", "0X800BC74", 0, 0, valueOf, valueOf2, str, String.valueOf(aVar4.f301815d));
                }
            });
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$reportJump$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoReporter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m.a aVar;
                    m.a aVar2;
                    m.a aVar3;
                    m.a aVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    aVar = TroopToDoReporter.this.reportData;
                    String valueOf = String.valueOf(aVar.f301812a);
                    aVar2 = TroopToDoReporter.this.reportData;
                    String valueOf2 = String.valueOf(aVar2.f301813b);
                    aVar3 = TroopToDoReporter.this.reportData;
                    String str = aVar3.f301814c;
                    aVar4 = TroopToDoReporter.this.reportData;
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BC76", "0X800BC76", 0, 0, valueOf, valueOf2, str, String.valueOf(aVar4.f301815d));
                }
            });
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoReporter$reportLocate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoReporter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m.a aVar;
                    m.a aVar2;
                    m.a aVar3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    aVar = TroopToDoReporter.this.reportData;
                    String valueOf = String.valueOf(aVar.f301812a);
                    aVar2 = TroopToDoReporter.this.reportData;
                    String valueOf2 = String.valueOf(aVar2.f301813b);
                    aVar3 = TroopToDoReporter.this.reportData;
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BC75", "0X800BC75", 0, 0, valueOf, valueOf2, aVar3.f301814c, "1");
                }
            });
        }
    }
}
