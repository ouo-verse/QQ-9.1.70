package com.tencent.mobileqq.delfriend.api.impl;

import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.delfriend.api.INTDelFriendRspDeal;
import com.tencent.mobileqq.nearby.b;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/delfriend/api/impl/NTDelFriendRspDealImpl;", "Lcom/tencent/mobileqq/delfriend/api/INTDelFriendRspDeal;", "()V", "onIceBreakingDelFrd", "", "delUin", "", "onNearByDelFriend", "onTofuDelFriend", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class NTDelFriendRspDealImpl implements INTDelFriendRspDeal {
    @Override // com.tencent.mobileqq.delfriend.api.INTDelFriendRspDeal
    public void onIceBreakingDelFrd(String delUin) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(delUin, "delUin");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Manager manager = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : peekAppRuntime.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        IceBreakingMng iceBreakingMng = manager instanceof IceBreakingMng ? (IceBreakingMng) manager : null;
        Boolean valueOf = iceBreakingMng != null ? Boolean.valueOf(iceBreakingMng.S(delUin)) : null;
        if ((iceBreakingMng != null ? iceBreakingMng.I(delUin) : true) && QLog.isColorLevel()) {
            QLog.i("NTDelFriendRspDealImpl", 2, "clearIceBreakingFlag onDelFrd uin: " + delUin + " " + valueOf);
        }
    }

    @Override // com.tencent.mobileqq.delfriend.api.INTDelFriendRspDeal
    public void onNearByDelFriend(String delUin) {
        ConcurrentHashMap<String, Integer> c16;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(delUin, "delUin");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Manager manager = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : peekAppRuntime.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        b bVar = manager instanceof b ? (b) manager : null;
        if (bVar == null || (c16 = bVar.c()) == null) {
            return;
        }
        c16.put(delUin, 1);
    }

    @Override // com.tencent.mobileqq.delfriend.api.INTDelFriendRspDeal
    public void onTofuDelFriend(String delUin) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(delUin, "delUin");
        if (QLog.isColorLevel()) {
            QLog.i("NTDelFriendRspDealImpl", 2, "onDelFriend " + delUin);
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Manager manager = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : peekAppRuntime.getManager(QQManagerFactory.BEANCURD_MANAGER);
        q qVar = manager instanceof q ? (q) manager : null;
        if (qVar != null) {
            qVar.j(delUin);
        }
    }
}
