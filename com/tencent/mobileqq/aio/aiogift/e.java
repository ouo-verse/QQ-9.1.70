package com.tencent.mobileqq.aio.aiogift;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.aiogift.AIOTroopGiftUIState;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mobileqq.vas.gift.ITroopGiftComponent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0013\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/aiogift/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mobileqq/aio/msg/ai;", "msgItem", "", "B", "", "refresh", "Lcom/tencent/aio/data/msglist/a;", BdhLogUtil.LogTag.Tag_Conn, "itemTroop", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "com/tencent/mobileqq/aio/aiogift/e$a", "f", "Lcom/tencent/mobileqq/aio/aiogift/e$a;", "action", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/aiogift/e$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTroopGiftEvent.TroopGiftPlayEvent) {
                AIOTroopGiftEvent.TroopGiftPlayEvent troopGiftPlayEvent = (AIOTroopGiftEvent.TroopGiftPlayEvent) i3;
                ((ITroopGiftComponent) QRoute.api(ITroopGiftComponent.class)).setPause(troopGiftPlayEvent.a());
                e.this.updateUI(new AIOTroopGiftUIState.MsgListGiftState(troopGiftPlayEvent.a()));
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

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.action = new a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(ai itemTroop) {
        BaseQQAppInterface baseQQAppInterface;
        boolean z16;
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_miniaio", false)) {
            return;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - 200;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            str = baseQQAppInterface.getCurrentAccountUin();
        }
        if (str == null) {
            return;
        }
        if ((itemTroop.getMsgRecord().msgTime > currentTimeMillis || (itemTroop.getMsgRecord().msgTime < currentTimeMillis && !itemTroop.H())) && ((ITroopGiftComponent) QRoute.api(ITroopGiftComponent.class)).needAutoShowAnim(itemTroop, str)) {
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (itemTroop.getMsgRecord().msgTime > currentTimeMillis) {
                z16 = true;
            } else {
                z16 = false;
            }
            e16.h(new AIOTroopGiftEvent.StartGiftAnimationEvent(itemTroop, false, z16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(ai msgItem) {
        TextGiftElement j26 = msgItem.j2();
        if (j26 == null) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTroopGiftEvent.StartGiftAnimationEvent(msgItem, true, false));
        HashMap hashMap = new HashMap();
        String valueOf = String.valueOf(j26.price);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(textGiftElement.price)");
        hashMap.put("gift_price", valueOf);
        hashMap.put("gift_type", msgItem.i2());
        ITroopGiftApi iTroopGiftApi = (ITroopGiftApi) QRoute.api(ITroopGiftApi.class);
        String valueOf2 = String.valueOf(j26.giftId);
        String str = j26.giftName;
        Intrinsics.checkNotNullExpressionValue(str, "textGiftElement.giftName");
        iTroopGiftApi.reportTroopBirthGift("20", valueOf2, str, "5", 102, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(boolean refresh, com.tencent.aio.data.msglist.a msgItem) {
        BaseQQAppInterface baseQQAppInterface;
        TextGiftElement j26;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ai aiVar = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        if (msgItem instanceof ai) {
            aiVar = (ai) msgItem;
        }
        if (aiVar == null || (j26 = aiVar.j2()) == null) {
            return;
        }
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        String valueOf = String.valueOf(j26.senderUin);
        String valueOf2 = String.valueOf(j26.receiverUin);
        String str = j26.senderNick;
        String str2 = j26.receiverNick;
        Intent intent = new Intent();
        NTPanelEntrance nTPanelEntrance = NTPanelEntrance.TROOP_GIFT_ITEM;
        if (Intrinsics.areEqual(currentAccountUin, valueOf2)) {
            nTPanelEntrance = NTPanelEntrance.TROOP_GIFT_ITEM_BACK;
            intent.putExtra("member_uin", valueOf);
            intent.putExtra("member_display_name", str);
        } else if (j26.sendType == 1) {
            nTPanelEntrance = NTPanelEntrance.TROOP_BIRTH_ITEM;
            intent.putExtra("member_uin", valueOf2);
            intent.putExtra("member_display_name", str2);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTroopGiftEvent.TroopSendGiftEvent(refresh, intent, nTPanelEntrance));
        HashMap hashMap = new HashMap();
        String valueOf3 = String.valueOf(j26.price);
        Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(textGiftElement.price)");
        hashMap.put("gift_price", valueOf3);
        hashMap.put("gift_type", aiVar.i2());
        ITroopGiftApi iTroopGiftApi = (ITroopGiftApi) QRoute.api(ITroopGiftApi.class);
        String valueOf4 = String.valueOf(j26.giftId);
        String str3 = j26.giftName;
        Intrinsics.checkNotNullExpressionValue(str3, "textGiftElement.giftName");
        iTroopGiftApi.reportTroopBirthGift("20", valueOf4, str3, "5", 102, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d) {
            d dVar = (d) intent;
            if (dVar.b()) {
                B(dVar.a());
                return;
            } else {
                A(dVar.a());
                return;
            }
        }
        if (intent instanceof c) {
            c cVar = (c) intent;
            C(cVar.b(), cVar.a());
        } else if (intent instanceof b) {
            ((b) intent).a().a((com.tencent.aio.api.runtime.a) getMContext());
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOTroopGiftEvent.TroopGiftPlayEvent.class)), this.action);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOTroopGiftEvent.TroopGiftPlayEvent.class)), this.action);
    }
}
