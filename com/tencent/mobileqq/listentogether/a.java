package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import tencent.media_relation.media_relation$MediaRelationInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f240892a = "ListenTogetherAIOStatusHelper";

    public static void b(QQAppInterface qQAppInterface, String str, boolean z16) {
        FriendsManager friendsManager;
        Object obj;
        if (QLog.isColorLevel()) {
            QLog.i(f240892a, 2, "setIsC2CListenTogetherOpen, app = " + qQAppInterface + " frienduin:" + str + " isOpen:" + z16);
        }
        if (qQAppInterface == null || (friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)) == null) {
            return;
        }
        Friends v3 = friendsManager.v(str);
        if (v3 == null || !v3.isFriend()) {
            z16 = false;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
        aVar.q();
        aVar.x(Boolean.valueOf(z16));
        ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, f240892a, (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
        ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, str);
        if (QLog.isColorLevel()) {
            String str2 = f240892a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setIsC2CListenTogetherOpen extensionInfo saved,  new:");
            sb5.append(z16);
            sb5.append(" friend:");
            if (v3 != null) {
                obj = Boolean.valueOf(v3.isFriend());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i(str2, 2, sb5.toString());
        }
    }

    public static void c(QQAppInterface qQAppInterface, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(f240892a, 2, "setIsGroupListenTogetherOpen, app = " + qQAppInterface + " troopuin:" + str + " isOpen:" + z16);
        }
        if (!z16) {
            com.tencent.mobileqq.listentogether.nt.c.f241083a.c(str);
        }
        if (qQAppInterface != null) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateListenTogetherState(str, z16);
        }
    }

    public static boolean a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            media_relation$MediaRelationInfo media_relation_mediarelationinfo = new media_relation$MediaRelationInfo();
            try {
                media_relation_mediarelationinfo.mergeFrom(bArr);
            } catch (Exception e16) {
                e16.printStackTrace();
                media_relation_mediarelationinfo = null;
            }
            if (media_relation_mediarelationinfo != null && media_relation_mediarelationinfo.create_time.has()) {
                return ((long) media_relation_mediarelationinfo.create_time.get()) >= NetConnInfoCenter.getServerTime() - JoinTimeType.SEVEN_DAY;
            }
        }
        return false;
    }
}
