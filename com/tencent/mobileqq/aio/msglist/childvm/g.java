package com.tencent.mobileqq.aio.msglist.childvm;

import android.content.Context;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001!B#\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/g;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "displayList", "", "k", "l", "clickedMsg", "j", "", "i", "msgItem", h.F, DomainData.DOMAIN_NAME, "msgItemList", "g", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "com/tencent/mobileqq/aio/msglist/childvm/g$b", "Lcom/tencent/mobileqq/aio/msglist/childvm/g$b;", "mAction", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f190496i;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/childvm/g$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                g.this.m(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f190496i = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull MsgListVMWrapper<at.b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mParentVm, (Object) mAioContext);
        } else {
            this.mAction = new b();
        }
    }

    private final void g(List<? extends AIOMsgItem> msgItemList) {
        Context context = c().c().getContext();
        if (context == null) {
            return;
        }
        am amVar = am.f194110a;
        if (!amVar.b(context, amVar.k(c()), msgItemList)) {
            return;
        }
        c().e().h(new LongShotMsgIntent.AddSelectMsgList(msgItemList));
    }

    private final void h(AIOMsgItem msgItem) {
        List<? extends AIOMsgItem> listOf;
        Context context = c().c().getContext();
        if (context == null) {
            return;
        }
        am amVar = am.f194110a;
        List<AIOMsgItem> k3 = amVar.k(c());
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msgItem);
        if (!amVar.b(context, k3, listOf)) {
            return;
        }
        c().e().h(new LongShotMsgIntent.AddSelectMsg(msgItem));
    }

    private final void i(AIOMsgItem clickedMsg) {
        List<com.tencent.aio.data.msglist.a> b16 = b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.AIOMsgItem>");
        int k3 = k(b16);
        int l3 = l(b16);
        if (k3 > l3) {
            return;
        }
        boolean z16 = false;
        if (k3 == -1) {
            if (am.f194110a.f(c()) > 0) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.yrx), 0).show();
                return;
            } else {
                h(clickedMsg);
                return;
            }
        }
        int j3 = j(b16, clickedMsg);
        if (k3 <= j3 && j3 <= l3) {
            z16 = true;
        }
        if (z16) {
            h(clickedMsg);
        } else if (j3 < k3) {
            g(b16.subList(j3, k3));
        } else if (j3 > l3) {
            g(b16.subList(l3 + 1, j3 + 1));
        }
    }

    private final int j(List<? extends AIOMsgItem> displayList, AIOMsgItem clickedMsg) {
        boolean z16;
        if (!(!displayList.isEmpty())) {
            return -1;
        }
        Iterator<? extends AIOMsgItem> it = displayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (clickedMsg.getMsgId() == it.next().getMsgId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private final int k(List<? extends AIOMsgItem> displayList) {
        if (!displayList.isEmpty()) {
            Iterator<? extends AIOMsgItem> it = displayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                if (!am.f194110a.h(c(), it.next())) {
                    i3 = i16;
                } else {
                    return i3;
                }
            }
        }
        return -1;
    }

    private final int l(List<? extends AIOMsgItem> displayList) {
        int lastIndex;
        int lastIndex2;
        List reversed;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(displayList);
        if (!displayList.isEmpty()) {
            reversed = CollectionsKt___CollectionsKt.reversed(displayList);
            Iterator it = reversed.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i16 = i3 + 1;
                if (am.f194110a.h(c(), (AIOMsgItem) it.next())) {
                    lastIndex = i3;
                    break;
                }
                i3 = i16;
            }
        }
        lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(displayList);
        return lastIndex2 - lastIndex;
    }

    private final void n(AIOMsgItem msgItem) {
        c().e().h(new LongShotMsgIntent.RemoveSelectMsg(msgItem));
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            c().e().f(this, this.mAction);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.AddClickedMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.RemoveMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.OnlyAddSingleMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.OnlyAddMsgList");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new HashSet();
    }

    public final void m(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof LongShotMsgIntent.AddClickedMsg) {
            i(((LongShotMsgIntent.AddClickedMsg) intent).a());
            return;
        }
        if (intent instanceof LongShotMsgIntent.RemoveMsg) {
            n(((LongShotMsgIntent.RemoveMsg) intent).a());
        } else if (intent instanceof LongShotMsgIntent.OnlyAddSingleMsg) {
            h(((LongShotMsgIntent.OnlyAddSingleMsg) intent).a());
        } else if (intent instanceof LongShotMsgIntent.OnlyAddMsgList) {
            g(((LongShotMsgIntent.OnlyAddMsgList) intent).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c().e().i(this, this.mAction);
        }
    }
}
