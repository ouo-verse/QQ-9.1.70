package com.tencent.qqnt.notification.trace;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.notification.trace.ITrackerReport;
import com.tencent.qqnt.notification.trace.a;
import com.tencent.qqnt.util.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b,\u0010\u001cJ\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0007H&J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/notification/trace/INotifyTracker;", "Lcom/tencent/qqnt/notification/trace/a;", "Lcom/tencent/qqnt/notification/trace/ITrackerReport;", "Lkotlin/Function0;", "", "invoker", "v", "", "complete", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/notification/trace/a$b;", "totalConfig", "c", "Lcom/tencent/qqnt/notification/trace/a$a;", "notificationConfig", "b", "Lcom/tencent/qqnt/notification/trace/a$c;", "vibratorConfig", "a", "u", "have", "r", "(Z)V", ReportConstant.COSTREPORT_PREFIX, "t", "()V", "<set-?>", "Lcom/tencent/qqnt/notification/trace/a$b;", "o", "()Lcom/tencent/qqnt/notification/trace/a$b;", "Lcom/tencent/qqnt/notification/trace/a$a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/notification/trace/a$a;", "Lcom/tencent/qqnt/notification/trace/a$c;", "p", "()Lcom/tencent/qqnt/notification/trace/a$c;", "d", "Z", "notificationTrackerComplete", "e", "vibratorTrackerComplete", "<init>", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class INotifyTracker implements a, ITrackerReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.b totalConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.InterfaceC9664a notificationConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.c vibratorConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean notificationTrackerComplete;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean vibratorTrackerComplete;

    public INotifyTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean complete, Function0<Unit> invoker) {
        if (complete) {
            if (!b.f362976b.isDebugVersion()) {
            } else {
                throw new RuntimeException("can not track repeat Tracker !!");
            }
        } else {
            invoker.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String event) {
        report(event);
    }

    private final void v(Function0<Unit> invoker) {
        if (!u()) {
            return;
        }
        invoker.invoke();
    }

    @Override // com.tencent.qqnt.notification.trace.a
    @NotNull
    public final a a(@NotNull final a.c vibratorConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) vibratorConfig);
        }
        Intrinsics.checkNotNullParameter(vibratorConfig, "vibratorConfig");
        v(new Function0<Unit>(vibratorConfig) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$vibratorAndAudioConfig$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a.c $vibratorConfig;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$vibratorConfig = vibratorConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) INotifyTracker.this, (Object) vibratorConfig);
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
                } else {
                    INotifyTracker.this.vibratorConfig = this.$vibratorConfig;
                }
            }
        });
        return this;
    }

    @Override // com.tencent.qqnt.notification.trace.a
    @NotNull
    public final a b(@NotNull final a.InterfaceC9664a notificationConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) notificationConfig);
        }
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        v(new Function0<Unit>(notificationConfig) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$notificationConfig$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a.InterfaceC9664a $notificationConfig;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notificationConfig = notificationConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) INotifyTracker.this, (Object) notificationConfig);
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
                } else {
                    INotifyTracker.this.notificationConfig = this.$notificationConfig;
                }
            }
        });
        return this;
    }

    @Override // com.tencent.qqnt.notification.trace.a
    @NotNull
    public final a c(@NotNull final a.b totalConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) totalConfig);
        }
        Intrinsics.checkNotNullParameter(totalConfig, "totalConfig");
        v(new Function0<Unit>(totalConfig) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$totalConfig$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a.b $totalConfig;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$totalConfig = totalConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) INotifyTracker.this, (Object) totalConfig);
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
                } else {
                    INotifyTracker.this.totalConfig = this.$totalConfig;
                }
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final a.InterfaceC9664a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a.InterfaceC9664a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.notificationConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final a.b o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.totalConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final a.c p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.vibratorConfig;
    }

    public final void r(final boolean have) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, have);
        } else {
            v(new Function0<Unit>(have) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$trackUINotification$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $have;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$have = have;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, INotifyTracker.this, Boolean.valueOf(have));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    INotifyTracker iNotifyTracker = INotifyTracker.this;
                    z16 = iNotifyTracker.notificationTrackerComplete;
                    iNotifyTracker.m(z16, new Function0<Unit>(this.$have) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$trackUINotification$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ boolean $have;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$have = r6;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, INotifyTracker.this, Boolean.valueOf(r6));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            INotifyTracker.this.notificationTrackerComplete = true;
                            if (this.$have) {
                                INotifyTracker.this.q(ITrackerReport.ReportEvent.PUSH_NOTIFICATION_SHOW);
                            } else {
                                INotifyTracker.this.q(ITrackerReport.ReportEvent.PUSH_NOTIFICATION_SHOW_NO);
                            }
                        }
                    });
                    INotifyTracker.this.notificationConfig = null;
                }
            });
        }
    }

    public final void s(final boolean have) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, have);
        } else {
            v(new Function0<Unit>(have) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$trackVibratorAndAudio$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $have;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$have = have;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, INotifyTracker.this, Boolean.valueOf(have));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    INotifyTracker iNotifyTracker = INotifyTracker.this;
                    z16 = iNotifyTracker.vibratorTrackerComplete;
                    iNotifyTracker.m(z16, new Function0<Unit>(this.$have) { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$trackVibratorAndAudio$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ boolean $have;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$have = r6;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, INotifyTracker.this, Boolean.valueOf(r6));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            INotifyTracker.this.vibratorTrackerComplete = true;
                            if (this.$have) {
                                INotifyTracker.this.q(ITrackerReport.ReportEvent.PUSH_VIBRATOR_AUDIO_ACTION);
                            } else {
                                INotifyTracker.this.q(ITrackerReport.ReportEvent.PUSH_VIBRATOR_AUDIO_ACTION_NO);
                            }
                        }
                    });
                    INotifyTracker.this.vibratorConfig = null;
                }
            });
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            v(new Function0<Unit>() { // from class: com.tencent.qqnt.notification.trace.INotifyTracker$trackWithOutNotificationAndAudio$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) INotifyTracker.this);
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
                    } else {
                        INotifyTracker.this.r(true);
                        INotifyTracker.this.s(false);
                    }
                }
            });
        }
    }

    public abstract boolean u();
}
