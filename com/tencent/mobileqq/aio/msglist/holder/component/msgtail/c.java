package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msglist.holder.component.essencetail.a;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySelectMsgEvent;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySetVisibleMsgEvent;
import com.tencent.qqnt.aio.emoreply.g;
import com.tencent.qqnt.aio.essence.EssenceEvent;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.utils.j;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0011\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "E", "", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "com/tencent/mobileqq/aio/msglist/holder/component/msgtail/c$b", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/c$b;", "mAction", "", "Lkotlin/Pair;", "", "f", "Ljava/util/List;", "mMessageList", "<init>", "()V", h.F, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.c$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgtail/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        List<Pair<String, b>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(AIOEmoReplySelectMsgEvent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(AIOEmoReplySetVisibleMsgEvent.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent msgIntent) {
        z.c cVar;
        int i3;
        if (msgIntent instanceof AIOEmoReplySelectMsgEvent) {
            AIOEmoReplySelectMsgEvent aIOEmoReplySelectMsgEvent = (AIOEmoReplySelectMsgEvent) msgIntent;
            com.tencent.qqnt.aio.emoreply.h a16 = aIOEmoReplySelectMsgEvent.a();
            if (a16 != null) {
                k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.GetBottomPaddingIncrement.f188300d);
                if (k3 instanceof z.c) {
                    cVar = (z.c) k3;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    i3 = cVar.a();
                } else {
                    i3 = 0;
                }
                a16.i(i3);
            }
            updateUI(new AIOEmoReplySelectState(aIOEmoReplySelectMsgEvent.b(), aIOEmoReplySelectMsgEvent.c(), aIOEmoReplySelectMsgEvent.d(), aIOEmoReplySelectMsgEvent.a()));
            return;
        }
        if (msgIntent instanceof AIOEmoReplySetVisibleMsgEvent) {
            updateUI(new AIOEmoReplySetVisibleState(((AIOEmoReplySetVisibleMsgEvent) msgIntent).a()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean n() {
        Bundle l3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l();
        if (!l3.getBoolean("key_is_forward_aio", false) || !l3.getBoolean("key_forward_aio_show_custom_msg")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7296a) {
            a.C7296a c7296a = (a.C7296a) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new EssenceEvent.ClickEssenceTail(c7296a.c(), c7296a.b(), c7296a.a()));
            return;
        }
        if (intent instanceof g.a) {
            updateUI(new AIOEmoReplyRefreshState(((g.a) intent).a()));
            return;
        }
        if (intent instanceof d.b) {
            ((d.b) intent).b(n());
            return;
        }
        if (intent instanceof d.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.OnMsgTailChanged(((d.c) intent).a()));
            return;
        }
        if (intent instanceof d.a) {
            d.a aVar = (d.a) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(5, new AIOMsgListEvent.EmoReplyAnimationEvent(aVar.b(), aVar.a()), null, 4, null));
        } else if (intent instanceof d.C7313d) {
            d.C7313d c7313d = (d.C7313d) intent;
            ((IAIOEmoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoPanelApi.class)).openAIOEmoPanel((com.tencent.aio.api.runtime.a) getMContext(), c7313d.a(), c7313d.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar = (com.tencent.mvi.base.route.a) pair.getSecond();
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(str, aVar, d16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
