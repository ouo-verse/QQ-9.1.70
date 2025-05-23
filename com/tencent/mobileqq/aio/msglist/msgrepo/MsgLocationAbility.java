package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.aio.data.AIOContact;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0010H\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/MsgLocationAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "v", "w", "u", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "intent", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByIdEvent;", "r", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateByTimeEvent;", "t", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$ListScrollStateChanged;", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/base/route/MsgIntent;", "g", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "i", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "aioMsgRepo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "focusBottomOnBackground", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgLocationAbility extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgRepo aioMsgRepo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean focusBottomOnBackground;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/MsgLocationAbility$a;", "", "", "TAG", "Ljava/lang/String;", "", "TROOP_BAR_EXTRA_COUNT", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.MsgLocationAbility$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgLocationAbility(@NotNull AIOMsgRepo aioMsgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioMsgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(aioMsgRepo, "aioMsgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aioMsgRepo, aioContext, scope);
        } else {
            this.aioMsgRepo = aioMsgRepo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MsgNavigationEvent.NavigateByIdEvent intent) {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new MsgLocationAbility$handleNavigateByIdEvent$1(intent, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(MsgNavigationEvent.NavigateBySeqEvent intent) {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new MsgLocationAbility$handleNavigateBySeqEvent$1(intent, this, null), 2, null);
    }

    private final void t(MsgNavigationEvent.NavigateByTimeEvent intent) {
        AIOContact c16 = d().g().r().c();
        Contact contact = new Contact(c16.e(), c16.j(), "");
        QLog.i("MsgLocationAbility", 1, "[handleNavigatieByTimeEvent]: contact is " + contact + ", clientSeq is " + intent.a() + ", msgTime is " + intent.b());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(new AIOMsgServiceWithContext(null).f(contact, intent.a(), intent.b()), new MsgLocationAbility$handleNavigateByTimeEvent$1(this, intent, null)), zs.b.a(Dispatchers.INSTANCE)), f());
    }

    private final void u() {
        QLog.i("MsgLocationAbility", 1, "[handleNavigationNotify]");
        this.focusBottomOnBackground = false;
    }

    private final void v() {
        boolean q16 = AIOUtil.f194084a.q(d());
        this.focusBottomOnBackground = q16;
        QLog.i("MsgLocationAbility", 1, "[handlePauseEvent]: isFocusBottom " + q16);
    }

    private final void w() {
        QLog.i("MsgLocationAbility", 1, "[handleResumeEvent]: isFocusBottom " + this.focusBottomOnBackground);
        if (this.focusBottomOnBackground) {
            e().z();
        }
        this.focusBottomOnBackground = false;
    }

    private final void x(AIOMsgListEvent.ListScrollStateChanged intent) {
        if (!this.focusBottomOnBackground) {
            return;
        }
        QLog.i("MsgLocationAbility", 1, "[handleScrollStateChange]: state is " + intent.a());
        if (intent.a() == 1 || intent.a() == 2) {
            this.focusBottomOnBackground = false;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof LifeCycleEvent.OnPause) {
            v();
            return;
        }
        if (intent instanceof LifeCycleEvent.OnResume) {
            w();
            return;
        }
        if (intent instanceof MsgNavigationEvent.NavigationNotify) {
            u();
            return;
        }
        if (intent instanceof MsgNavigationEvent.NavigateBySeqEvent) {
            s((MsgNavigationEvent.NavigateBySeqEvent) intent);
            return;
        }
        if (intent instanceof MsgNavigationEvent.NavigateByIdEvent) {
            r((MsgNavigationEvent.NavigateByIdEvent) intent);
        } else if (intent instanceof MsgNavigationEvent.NavigateByTimeEvent) {
            t((MsgNavigationEvent.NavigateByTimeEvent) intent);
        } else if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            x((AIOMsgListEvent.ListScrollStateChanged) intent);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnResume");
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnPause");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigationNotify");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateBySeqEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateByIdEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateByTimeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollStateChanged");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @NotNull
    public final AIOMsgRepo q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgRepo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioMsgRepo;
    }
}
