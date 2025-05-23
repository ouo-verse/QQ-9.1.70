package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.menu.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0016H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00180\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "", "G", "H", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Landroid/view/View;", "videoView", UserInfo.SEX_FEMALE, "D", "view", "", "isMute", "B", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "com/tencent/mobileqq/aio/msglist/holder/component/video/a$a", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/a$a;", "action", "", "Lkotlin/Pair;", "", tl.h.F, "Ljava/util/List;", "messageList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7325a action;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, C7325a>> messageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/video/a$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7325a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        C7325a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                a.this.C(i3);
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

    public a() {
        List<Pair<String, C7325a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        C7325a c7325a = new C7325a();
        this.action = c7325a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.VideoPlayEvent.class)), c7325a));
        this.messageList = listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(AIOMsgItem msgItem, View view, boolean isMute) {
        z.a aVar;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgItem.getMsgRecord()));
        List<AIOMsgItem> list = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        if (aVar != null) {
            list = aVar.a();
        }
        iRichMediaBrowserApi.enterVideoPreview(peekAppRuntime, requireContext, view, msgItem, 0L, isMute, false, null, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.VideoPlayEvent) {
            updateUI(new AIOVideoEvent$VideoPlayState(((AIOMsgListEvent.VideoPlayEvent) intent).a()));
        }
    }

    private final void D(AIOMsgItem msgItem, View videoView) {
        B(msgItem, videoView, false);
    }

    private final void F(AIOMsgItem msgItem, View videoView) {
        B(msgItem, videoView, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ba) {
            d.ba baVar = (d.ba) intent;
            D(baVar.a(), baVar.b());
        } else if (intent instanceof p.k) {
            p.k kVar = (p.k) intent;
            F(kVar.a(), kVar.b());
        } else {
            super.handleIntent(intent);
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            H();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        G();
    }
}
