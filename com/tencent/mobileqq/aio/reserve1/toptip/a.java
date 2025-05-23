package com.tencent.mobileqq.aio.reserve1.toptip;

import at.e;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTopTipEvent;
import com.tencent.mobileqq.aio.msgbox.MsgBox;
import com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent;
import com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB;
import com.tencent.mobileqq.aio.reserve1.toptip.event.TopTipsEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/a;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent$ShowMsgBoxEvent;", "intent", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msgbox/MsgBox;", "f", "Lcom/tencent/mobileqq/aio/msgbox/MsgBox;", "msgBox", "Lcom/tencent/mvi/base/route/a;", h.F, "Lcom/tencent/mvi/base/route/a;", "mAction", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class a extends com.tencent.qqnt.aio.baseVM.a<e, TopTipViewState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgBox msgBox;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/toptip/a$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.toptip.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7351a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        C7351a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof AIOTopTipEvent.ShowCustomBar) {
                a.this.updateUI(new AIOTopTipContainerVB.ShowCustomBarState(((AIOTopTipEvent.ShowCustomBar) intent).a()));
                return;
            }
            if (intent instanceof AIOTopTipEvent.RemoveCustomBar) {
                a.this.updateUI(AIOTopTipContainerVB.RemoveCustomBarState.f193389d);
                return;
            }
            if (intent instanceof AIOTopTipEvent.SetTopPadding) {
                a.this.updateUI(new AIOTopTipContainerVB.SetTopPadding(((AIOTopTipEvent.SetTopPadding) intent).a()));
                return;
            }
            if (intent instanceof AIOTopTipEvent.SetTroopTODOBar) {
                a.this.updateUI(new AIOTopTipContainerVB.ShowTroopTODOBarState(((AIOTopTipEvent.SetTroopTODOBar) intent).a()));
                return;
            }
            if (intent instanceof AIOTopTipEvent.RemoveTroopTODOBar) {
                a.this.updateUI(new AIOTopTipContainerVB.RemoveTroopTODOBarState(((AIOTopTipEvent.RemoveTroopTODOBar) intent).a()));
                return;
            }
            if (intent instanceof TopTipsEvent.TopTipsShowEvent) {
                a.this.updateUI(new AIOTopTipContainerVB.ShowTopTipState(((TopTipsEvent.TopTipsShowEvent) intent).a()));
                return;
            }
            if (intent instanceof TopTipsEvent.TopTipsHideEvent) {
                a.this.updateUI(new AIOTopTipContainerVB.HideTopTipState(((TopTipsEvent.TopTipsHideEvent) intent).a()));
                return;
            }
            if (intent instanceof TopTipsEvent.TopTipsReplaceShowEvent) {
                TopTipsEvent.TopTipsReplaceShowEvent topTipsReplaceShowEvent = (TopTipsEvent.TopTipsReplaceShowEvent) intent;
                a.this.updateUI(new AIOTopTipContainerVB.ReplaceTopTipState(topTipsReplaceShowEvent.a(), topTipsReplaceShowEvent.b()));
            } else if (intent instanceof MsgBoxEvent.HideMsgBoxEvent) {
                a.this.updateUI(new AIOTopTipContainerVB.HideMsgBoxState());
            } else if (intent instanceof MsgBoxEvent.ShowMsgBoxEvent) {
                a.this.n((MsgBoxEvent.ShowMsgBoxEvent) intent);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new C7351a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgBoxEvent.ShowMsgBoxEvent intent) {
        if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isAioTopNotificationShow()) {
            return;
        }
        if (this.msgBox == null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            this.msgBox = new MsgBox(aVar);
        }
        RecentContactInfo a16 = intent.a();
        boolean z16 = false;
        if (a16 != null && a16.notifiedType == 2) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        MsgBox msgBox = this.msgBox;
        Intrinsics.checkNotNull(msgBox);
        if (!msgBox.v(intent.a())) {
            return;
        }
        MsgBox msgBox2 = this.msgBox;
        Intrinsics.checkNotNull(msgBox2);
        updateUI(new AIOTopTipContainerVB.ShowMsgBoxState(msgBox2.o(intent.a())));
        MsgBox msgBox3 = this.msgBox;
        Intrinsics.checkNotNull(msgBox3);
        msgBox3.g(intent.a());
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.reserve1.toptip.event.TopTipsEvent.TopTipsShowEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.toptip.event.TopTipsEvent.TopTipsHideEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.toptip.event.TopTipsEvent.TopTipsReplaceShowEvent");
        hashSet.add("com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent.ShowMsgBoxEvent");
        hashSet.add("com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent.HideMsgBoxEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTopTipEvent.ShowCustomBar");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTopTipEvent.RemoveCustomBar");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTopTipEvent.SetTroopTODOBar");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTopTipEvent.RemoveTroopTODOBar");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTopTipEvent.SetTopPadding");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull e intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.handleIntent(intent);
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        updateUI(new AIOTopTipContainerVB.HideMsgBoxState());
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        this.msgBox = null;
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.aioContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            context = null;
        }
        context.e().f(this, this.mAction);
    }
}
