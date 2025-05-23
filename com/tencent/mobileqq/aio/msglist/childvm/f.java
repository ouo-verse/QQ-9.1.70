package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.qqnt.aio.nick.k;
import com.tencent.qqnt.aio.refresher.ap;
import com.tencent.qqnt.bus.event.v;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/f;", "", "", "c", "Lcom/tencent/qqnt/aio/refresher/ap;", "rsp", "d", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "refreshRsp", "b", "", "I", "getRefreshType", "()I", "refreshType", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "vmWr", "vm", "<init>", "(ILcom/tencent/mobileqq/aio/msglist/childvm/MsgItemRefreshBuisVM;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int refreshType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MsgItemRefreshBuisVM> vmWr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/f$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_AIO_BACKGROUND", "I", "TYPE_AIO_REFRESH_RESPONSE", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.childvm.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(int i3, @NotNull MsgItemRefreshBuisVM vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) vm5);
        } else {
            this.refreshType = i3;
            this.vmWr = new WeakReference<>(vm5);
        }
    }

    private final void c() {
        MsgItemRefreshBuisVM msgItemRefreshBuisVM = this.vmWr.get();
        if (msgItemRefreshBuisVM == null) {
            return;
        }
        MsgList M = msgItemRefreshBuisVM.d().m().M();
        if (M.isEmpty()) {
            QLog.i("RefreshRunnable", 1, "[refreshAIOBackground]: displayList size is 0");
        }
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem cloneNewInstance = ((AIOMsgItem) aVar).cloneNewInstance();
                String currentChatBackgroundBg = ((IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class)).getCurrentChatBackgroundBg(String.valueOf(cloneNewInstance.getMsgRecord().peerUin), cloneNewInstance.p0());
                if (currentChatBackgroundBg == null) {
                    currentChatBackgroundBg = "";
                }
                cloneNewInstance.e1(currentChatBackgroundBg);
                cloneNewInstance.Y1(com.tencent.mobileqq.aio.msg.a.a(cloneNewInstance));
                Unit unit = Unit.INSTANCE;
                M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                z16 = true;
            }
            i3 = i16;
        }
        if (z16) {
            e.a(msgItemRefreshBuisVM, M, "refresh_aio_background");
        }
    }

    private final void d(ap rsp) {
        MsgItemRefreshBuisVM msgItemRefreshBuisVM = this.vmWr.get();
        if (msgItemRefreshBuisVM == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RefreshRunnable", 2, "refreshQCircleRedDot");
        }
        MsgList M = msgItemRefreshBuisVM.d().m().M();
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if (aVar instanceof AIOMsgItem) {
                for (v vVar : rsp.a()) {
                    AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                    if (Intrinsics.areEqual(String.valueOf(aIOMsgItem.getMsgRecord().senderUin), vVar.c())) {
                        AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                        cloneNewInstance.K1(new k(vVar.d(), vVar.a(), vVar.b()));
                        Unit unit = Unit.INSTANCE;
                        M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                        z16 = true;
                    }
                }
            }
            i3 = i16;
        }
        if (z16) {
            e.a(msgItemRefreshBuisVM, M, "qcircle_red_dot");
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.refreshType == 1) {
            c();
        }
    }

    public final void b(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.f refreshRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) refreshRsp);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshRsp, "refreshRsp");
        if (refreshRsp instanceof ap) {
            d((ap) refreshRsp);
        }
    }
}
