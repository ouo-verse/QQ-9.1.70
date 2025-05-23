package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopmedal.TroopMedalUpdateEvent;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtMedalData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/m;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "Z", "oldState", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class m implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean oldState;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void b(@Nullable TroopInfo troopInfo) {
        GroupExtMedalData groupExtMedalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        GroupExt groupExt = troopInfo.groupExt;
        boolean z16 = false;
        if (groupExt != null && (groupExtMedalData = groupExt.groupExtMedalData) != null && groupExtMedalData.groupNameColorChange == 1) {
            z16 = true;
        }
        this.oldState = z16;
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo troopInfo) {
        GroupExtMedalData groupExtMedalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        GroupExt groupExt = troopInfo.groupExt;
        boolean z16 = false;
        if (groupExt != null && (groupExtMedalData = groupExt.groupExtMedalData) != null && groupExtMedalData.groupNameColorChange == 1) {
            z16 = true;
        }
        if (z16 != this.oldState) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String troopUin = troopInfo.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
            simpleEventBus.dispatchEvent(new TroopMedalUpdateEvent(troopUin, troopInfo.groupExt.groupExtMedalData));
            IChatsUtil iChatsUtil = (IChatsUtil) QRoute.api(IChatsUtil.class);
            String troopUin2 = troopInfo.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin2, "troopInfo.troopUin");
            iChatsUtil.sendEventToChat(new a.x(troopUin2, com.tencent.qqnt.chats.core.adapter.itemdata.payload.j.f354601a));
        }
    }
}
