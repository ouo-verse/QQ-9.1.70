package com.tencent.mobileqq.qqlive.anchor.live.pkstate;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVideoAvailableEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/i;", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnUserVideoAvailableEvent;", "event", "", "t", "u", "Lhn3/b;", ReportConstant.COSTREPORT_PREFIX, "Lhn3/a;", "info", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "o", "r", "k", "i", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/component/core/event/Eventor;", "e", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lei2/a;", "crossRoomLiveService", "Lei2/a;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "pkVideoViewService", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "", "f", "J", "linkScreenAnchorUid", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "linkScreenAnchorPlay", "Lfi2/a;", "componentContext", "<init>", "(Lfi2/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends com.tencent.mobileqq.qqlive.framework.component.b implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @InjectService(key = ei2.a.class)
    private ei2.a crossRoomLiveService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long linkScreenAnchorUid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a linkScreenAnchorPlay;

    @InjectService(key = com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c.class)
    private com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkVideoViewService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkstate.i$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkstate/i$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements OnEvent<LinkScreenEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkScreenEvent event) {
            LinkScreenAnchorInfo linkScreenAnchorInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Integer num = null;
            if (event != null) {
                linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
            } else {
                linkScreenAnchorInfo = null;
            }
            AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "rev LinkScreenEvent: " + event + ", anchorInfo " + linkScreenAnchorInfo);
            if (event != null) {
                num = Integer.valueOf(event.getType());
            }
            if (num != null && num.intValue() == 1) {
                i.this.s(event);
            } else if (num != null && num.intValue() == 2) {
                i.this.r();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkstate/i$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lio3/a;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements OnEvent<LinkMuteEvent> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkMuteEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "rev LinkMuteEvent: " + event);
            a aVar = i.this.linkScreenAnchorPlay;
            if (aVar != null) {
                Intrinsics.checkNotNull(event);
                aVar.b(event);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull fi2.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentContext);
        } else {
            this.eventor = new Eventor();
        }
    }

    private final a o(LinkScreenAnchorInfo info) {
        a hVar;
        com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c cVar = null;
        if (com.tencent.now.linkscreengame.model.c.f338502a.a(info.getLiveType())) {
            com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c cVar2 = this.pkVideoViewService;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pkVideoViewService");
            } else {
                cVar = cVar2;
            }
            hVar = new com.tencent.mobileqq.qqlive.anchor.live.pkstate.c(cVar);
        } else {
            ei2.a aVar = this.crossRoomLiveService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("crossRoomLiveService");
                aVar = null;
            }
            com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c cVar3 = this.pkVideoViewService;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pkVideoViewService");
            } else {
                cVar = cVar3;
            }
            hVar = new h(aVar, cVar);
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        a aVar = this.linkScreenAnchorPlay;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(LinkScreenEvent event) {
        LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
        if (linkScreenAnchorInfo == null) {
            return;
        }
        a o16 = o(linkScreenAnchorInfo);
        this.linkScreenAnchorPlay = o16;
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "create linkScreenAnchorPlay: " + o16);
        a aVar = this.linkScreenAnchorPlay;
        if (aVar != null) {
            aVar.c(event);
        }
    }

    private final void t(OnUserVideoAvailableEvent event) {
        a aVar;
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "onUserVideoAvailable", "appId: " + event.getAppId() + "available: " + event.getAvailable() + ", userID: " + event.getUserId() + ", linkScreenAnchorUid: " + this.linkScreenAnchorUid);
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && Intrinsics.areEqual(String.valueOf(this.linkScreenAnchorUid), event.getUserId()) && (aVar = this.linkScreenAnchorPlay) != null) {
            aVar.onUserVideoAvailable(event.getUserId(), event.getAvailable());
        }
    }

    private final void u() {
        this.eventor.addOnEvent(new b()).addOnEvent(new c());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OnUserVideoAvailableEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            AegisLogger.INSTANCE.d("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "unInitComponent");
            this.eventor.removeAll();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.context = e().getContext();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if (event instanceof OnUserVideoAvailableEvent) {
            t((OnUserVideoAvailableEvent) event);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "onEnterRoom");
        u();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkPKAnchorPlayComponent", "onExitRoom");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.eventor.removeAll();
    }
}
