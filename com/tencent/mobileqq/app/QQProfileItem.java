package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.b;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jf.dexlib2.analysis.RegisterType;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpdateItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ContentItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$FriendRemark;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$FriendTeamList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$GenderFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$GeneralBuffer;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$GroupName;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$NickNameFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ProfileInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ProfileListResult;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ProfileTvInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ReqBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$RspBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$UpdateProfileList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$ValueBit;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$ReqBody;

/* loaded from: classes11.dex */
public class QQProfileItem implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f194971d;

    /* renamed from: e, reason: collision with root package name */
    private ByteStringMicro f194972e;

    public QQProfileItem(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194971d = qQAppInterface;
        this.f194972e = null;
        c(qQAppInterface, "775_hot_friend_new_boat_clear_version");
        c(qQAppInterface, "top_position_and_disturb_clear_version");
        c(qQAppInterface, "check_message_preview_version_clear");
    }

    private void A(FriendsManager friendsManager, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQProfileItem", 1, "updateBlackOrBlackedFlag is error! friend uin is empty!");
            return;
        }
        if (i3 != 4090) {
            if (i3 == 4092) {
                this.f194971d.getMsgCache().f286225q.put(str, str);
                if (QLog.isColorLevel()) {
                    QLog.i("QQProfileItem", 1, "updateBlackOrBlackedFlag is execute! friend uin is " + str + " id is " + i3 + " flag is 1");
                    return;
                }
                return;
            }
            return;
        }
        this.f194971d.getMsgCache().f286223p.put(str, str);
        if (QLog.isColorLevel()) {
            QLog.i("QQProfileItem", 1, "updateBlackOrBlackedFlag is execute! friend uin is " + str + " id is " + i3 + " flag is 1");
        }
    }

    public static void B(long j3, String str, n nVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName uin = " + j3 + ",nickName = " + str);
        }
        ArrayList<DiscussionInfo> k3 = nVar.k();
        if (k3 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<DiscussionInfo> it = k3.iterator();
            while (it.hasNext()) {
                DiscussionInfo next = it.next();
                DiscussionMemberInfo l3 = nVar.l(next.uin, Long.toString(j3));
                if (l3 != null && a(str, l3.memberName)) {
                    l3.memberName = str;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName discussMem.memberName = " + l3.memberName + ",discussMem.inteRemark = " + l3.inteRemark + ",discussionUin = " + next.uin);
                    }
                    arrayList.add(l3);
                }
            }
            if (arrayList.size() > 0) {
                nVar.F(arrayList);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("count", String.valueOf(arrayList.size()));
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "updateDiscussMemberNick", true, 0L, 0L, hashMap, "", true);
            }
        }
    }

    public static void C(long j3, String str, n nVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark uin = " + j3 + ",remarkName = " + str);
        }
        ArrayList<DiscussionInfo> k3 = nVar.k();
        if (k3 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<DiscussionInfo> it = k3.iterator();
            while (it.hasNext()) {
                DiscussionInfo next = it.next();
                DiscussionMemberInfo l3 = nVar.l(next.uin, Long.toString(j3));
                if (l3 != null && b(str, l3.inteRemark)) {
                    l3.inteRemark = str;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark discussMem.memberName = " + l3.memberName + ",discussMem.inteRemark = " + l3.inteRemark + ",discussionUin = " + next.uin);
                    }
                    arrayList.add(l3);
                }
            }
            if (arrayList.size() > 0) {
                nVar.F(arrayList);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("count", String.valueOf(arrayList.size()));
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "updateDiscussMemberRemark", true, 0L, 0L, hashMap, "", true);
            }
        }
    }

    public static boolean a(String str, String str2) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel() && z16) {
            QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByName newFriendName = " + str + ",oldFriendName = " + str2 + ",result = " + z16);
        }
        return z16;
    }

    public static boolean b(String str, String str2) {
        boolean z16;
        boolean z17 = true;
        if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z17 = z16;
        }
        if (QLog.isColorLevel() && z17) {
            QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByRemark ,newRemark = " + str + ",oldRemark = " + str2 + ",result = " + z17);
        }
        return z17;
    }

    public static void c(QQAppInterface qQAppInterface, String str) {
        ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.app.QQProfileItem.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f194974e;

            {
                this.f194974e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QQAppInterface.this != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion");
                    }
                    SharedPreferences preferences = QQAppInterface.this.getPreferences();
                    if (!preferences.getBoolean(this.f194974e, false)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion clear");
                        }
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putBoolean(this.f194974e, true);
                        edit.putLong("inccheckupdatetimeStamp9", 0L);
                        edit.commit();
                    }
                }
            }
        }, 16, null, true);
    }

    public static void d(String str, byte[] bArr, int i3) {
        String str2 = new String();
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "len = " + i3);
        }
        StringBuilder sb5 = new StringBuilder("");
        int i16 = 0;
        while (i16 < i3) {
            byte b16 = bArr[i16];
            String str3 = str2 + "0123456789ABCDEF".charAt((b16 >> 4) & 15) + "" + "0123456789ABCDEF".charAt(b16 & RegisterType.DOUBLE_HI) + " ";
            i16++;
            if (i16 % 8 == 0) {
                str2 = str3 + " ";
                if (i16 % 16 == 0) {
                    if (QLog.isColorLevel()) {
                        sb5.append(str2 + "\n");
                    }
                    str2 = "";
                }
            } else {
                str2 = str3;
            }
        }
        QLog.d(str, 2, sb5.toString());
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    private void e(Oidb_0x5e0$RspBody oidb_0x5e0$RspBody) {
        boolean z16;
        FriendsManager friendsManager;
        ?? r56;
        ?? r65;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap;
        ArrayList arrayList4;
        NTVasSimpleInfo[] nTVasSimpleInfoArr;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr2;
        String str;
        boolean z17;
        FriendsManager friendsManager2;
        FriendsManager friendsManager3 = (FriendsManager) this.f194971d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        TroopManager troopManager = (TroopManager) this.f194971d.getManager(QQManagerFactory.TROOP_MANAGER);
        List<Oidb_0x5e0$ContentItem> list = oidb_0x5e0$RspBody.rpt_msg_contentItem.get();
        if (list == null) {
            return;
        }
        this.f194971d.getMsgCache().f286227r.addAndGet(list.size());
        if (oidb_0x5e0$RspBody.uint32_over_flag.has() && oidb_0x5e0$RspBody.uint32_over_flag.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + list.size() + " overFlag:" + z16;
        String str3 = ProfileContants.CMD_CHECK_UPDATE_REQ;
        QLog.i(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, str2);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr3 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d[list.size()];
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr4 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d[list.size()];
        NTVasSimpleInfo[] nTVasSimpleInfoArr2 = new NTVasSimpleInfo[list.size()];
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        for (Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem : list) {
            if (oidb_0x5e0$ContentItem.uint32_update_profile_id.has()) {
                arrayList = arrayList9;
                arrayList2 = arrayList8;
                arrayList3 = arrayList7;
                hashMap = hashMap2;
                arrayList4 = arrayList6;
                nTVasSimpleInfoArr = nTVasSimpleInfoArr2;
                dVarArr = dVarArr4;
                dVarArr2 = dVarArr3;
                str = str3;
                z17 = z16;
                friendsManager2 = friendsManager3;
                i(oidb_0x5e0$ContentItem, friendsManager3, troopManager, arrayList2, arrayList, dVarArr3, dVarArr4, nTVasSimpleInfoArr, 0, arrayList5, arrayList4, hashMap, arrayList3);
            } else {
                arrayList = arrayList9;
                arrayList2 = arrayList8;
                arrayList3 = arrayList7;
                hashMap = hashMap2;
                arrayList4 = arrayList6;
                nTVasSimpleInfoArr = nTVasSimpleInfoArr2;
                dVarArr = dVarArr4;
                dVarArr2 = dVarArr3;
                str = str3;
                z17 = z16;
                friendsManager2 = friendsManager3;
            }
            str3 = str;
            arrayList8 = arrayList2;
            arrayList9 = arrayList;
            arrayList7 = arrayList3;
            hashMap2 = hashMap;
            arrayList6 = arrayList4;
            nTVasSimpleInfoArr2 = nTVasSimpleInfoArr;
            dVarArr4 = dVarArr;
            dVarArr3 = dVarArr2;
            z16 = z17;
            friendsManager3 = friendsManager2;
        }
        ArrayList arrayList10 = arrayList7;
        HashMap hashMap3 = hashMap2;
        ArrayList arrayList11 = arrayList6;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr5 = dVarArr3;
        String str4 = str3;
        boolean z18 = z16;
        FriendsManager friendsManager4 = friendsManager3;
        f(arrayList8, arrayList9);
        if (QLog.isColorLevel()) {
            QLog.d(str4, 2, "handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=" + arrayList11.size());
        }
        if (arrayList11.size() > 0) {
            friendsManager = friendsManager4;
            friendsManager.i(arrayList11);
            r65 = 0;
            r56 = 1;
            ((FriendListHandler) this.f194971d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(95, true, new Object[]{Boolean.TRUE, arrayList11});
        } else {
            friendsManager = friendsManager4;
            r56 = 1;
            r65 = 0;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[r65] = "0x5e0 hiddenChatMap.size:";
            objArr[r56] = Integer.valueOf(hashMap3.size());
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, objArr);
        }
        if (hashMap3.size() > 0) {
            Object[] objArr2 = new Object[2];
            objArr2[r65] = "hiddenChatMap profileItem ";
            objArr2[r56] = Integer.valueOf(hashMap3.size());
            QLog.d(LogTag.TAG_HIDDEN_CHAT, (int) r56, objArr2);
            FriendsStatusUtil.b(hashMap3, this.f194971d, r65);
        }
        if (arrayList10.size() > 0) {
            ((FriendListHandler) this.f194971d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(102, r56, arrayList10);
        }
        if (z18 && this.f194971d.getMsgCache().f286227r.get() != 0) {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList12 = new ArrayList<>();
            h(friendsManager, dVarArr5, r65, arrayList12);
            int size = arrayList12.size();
            arrayList12.toArray(new com.tencent.qqnt.ntrelation.friendsinfo.bean.d[size]);
            if (QLog.isColorLevel()) {
                QLog.d(str4, 2, "CheckUpdate ValueBit update Friends count = " + ((int) r65) + " includeShield:" + size);
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(arrayList12, "QQProfileItem", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(str4, 2, "CheckUpdate ValueBit update Friends count = " + ((int) r65));
            }
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(new ArrayList<>(Arrays.asList(dVarArr5)), "QQProfileItem", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        }
        g(oidb_0x5e0$RspBody);
        if (oidb_0x5e0$RspBody.uint32_over_flag.has() && oidb_0x5e0$RspBody.uint32_over_flag.get() == r56) {
            this.f194972e = null;
            this.f194971d.getMsgCache().f286221o.clear();
            this.f194971d.getMsgCache().f286223p.clear();
            this.f194971d.getMsgCache().f286225q.clear();
            this.f194971d.getMsgCache().f286227r.set(r65);
            return;
        }
        if (oidb_0x5e0$RspBody.bytes_svrcontext.has()) {
            this.f194972e = oidb_0x5e0$RspBody.bytes_svrcontext.get();
            ((FriendListHandler) this.f194971d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCheckUpdate(r65, r56);
        }
    }

    private void f(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2) {
        try {
            n nVar = (n) this.f194971d.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            if (arrayList.size() > 0) {
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it.next();
                    B(Long.parseLong(next.x()), next.p(), nVar);
                }
            }
            if (arrayList2.size() > 0) {
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d next2 = it5.next();
                    C(Long.parseLong(next2.x()), next2.r(), nVar);
                }
            }
        } catch (NumberFormatException e16) {
            QLog.e("QQProfileItem", 1, "handleFriendNameAndRemark fail " + e16);
        }
    }

    private void g(Oidb_0x5e0$RspBody oidb_0x5e0$RspBody) {
        List<Oidb_0x5e0$ProfileListResult> list = oidb_0x5e0$RspBody.rpt_msg_ProfileListResult.get();
        if (list != null) {
            SharedPreferences.Editor edit = this.f194971d.getPreferences().edit();
            for (Oidb_0x5e0$ProfileListResult oidb_0x5e0$ProfileListResult : list) {
                if (oidb_0x5e0$ProfileListResult.uint32_result.has() && oidb_0x5e0$ProfileListResult.uint32_result.get() == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "get result =" + oidb_0x5e0$ProfileListResult.uint32_result.get());
                    }
                    if (oidb_0x5e0$ProfileListResult.uint32_update_profile_id.has() && oidb_0x5e0$ProfileListResult.uint32_new_content_timestamp.has()) {
                        int i3 = oidb_0x5e0$ProfileListResult.uint32_update_profile_id.get();
                        int i16 = oidb_0x5e0$ProfileListResult.uint32_new_content_timestamp.get();
                        edit.putLong("inccheckupdatetimeStamp" + i3, i16);
                        if (QLog.isColorLevel()) {
                            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "handleCheckUpdateRspBody profileid:" + i3 + " uint32_new_content_timestamp =" + i16);
                        }
                    }
                }
            }
            edit.commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(FriendsManager friendsManager, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr, int i3, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList) {
        int i16;
        boolean z16;
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("QQProfileItem");
        if (allFriend.size() <= 0) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f194971d.getMsgCache().f286221o;
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.f194971d.getMsgCache().f286223p;
        ConcurrentHashMap<String, String> concurrentHashMap3 = this.f194971d.getMsgCache().f286225q;
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = allFriend.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it.next();
            if (next == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "handleShieldAndBlackListFriends null == ntSimpleInfo");
                }
            } else {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(next.getUid(), next.x());
                dVar.M();
                boolean z17 = true;
                if (next.E() && !concurrentHashMap.containsKey(next.x())) {
                    dVar.r0(false);
                } else if (!next.E() && concurrentHashMap.containsKey(next.x())) {
                    dVar.r0(true);
                } else {
                    z16 = false;
                    if (com.tencent.relation.common.config.toggle.c.N.g(false)) {
                        Boolean bool = Boolean.TRUE;
                        if (bool.equals(next.z()) && !concurrentHashMap2.containsKey(next.x())) {
                            dVar.a0(Boolean.FALSE);
                        } else {
                            if (bool.equals(next.z()) && concurrentHashMap2.containsKey(next.x())) {
                                next.a0(bool);
                            }
                            if (!bool.equals(next.z()) && !concurrentHashMap3.containsKey(next.x())) {
                                dVar.a0(Boolean.FALSE);
                            } else if (Boolean.FALSE.equals(next.z()) && concurrentHashMap3.containsKey(next.x())) {
                                dVar.a0(bool);
                            }
                            if (!z17) {
                                arrayList.add(dVar);
                            }
                        }
                        z16 = true;
                        if (!bool.equals(next.z())) {
                        }
                        if (Boolean.FALSE.equals(next.z())) {
                            dVar.a0(bool);
                            if (!z17) {
                            }
                        }
                    }
                    z17 = z16;
                    if (!z17) {
                    }
                }
                z16 = true;
                if (com.tencent.relation.common.config.toggle.c.N.g(false)) {
                }
                z17 = z16;
                if (!z17) {
                }
            }
        }
        for (i16 = 0; i16 < i3; i16++) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = dVarArr[i16];
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
    }

    private void i(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager, TroopManager troopManager, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr2, NTVasSimpleInfo[] nTVasSimpleInfoArr, int i3, ArrayList<TroopInfo> arrayList3, ArrayList<SpecialCareInfo> arrayList4, Map<String, Boolean> map, ArrayList<String> arrayList5) {
        b.a aVar = new b.a(0L);
        aVar.a();
        switch (oidb_0x5e0$ContentItem.uint32_update_profile_id.get()) {
            case 1:
                n(oidb_0x5e0$ContentItem, friendsManager, arrayList, dVarArr, dVarArr2, i3);
                break;
            case 2:
                w(oidb_0x5e0$ContentItem, friendsManager);
                break;
            case 3:
                u(oidb_0x5e0$ContentItem, friendsManager, arrayList2);
                break;
            case 5:
                x(oidb_0x5e0$ContentItem, troopManager, arrayList3);
                break;
            case 6:
                m(oidb_0x5e0$ContentItem);
                break;
            case 7:
                y(oidb_0x5e0$ContentItem, nTVasSimpleInfoArr, i3);
                break;
            case 9:
                v(oidb_0x5e0$ContentItem, friendsManager, arrayList4, map, arrayList5);
                break;
            case 10:
                k(oidb_0x5e0$ContentItem, friendsManager);
                break;
            case 11:
                l(oidb_0x5e0$ContentItem, friendsManager);
                break;
            case 12:
                j(oidb_0x5e0$ContentItem, friendsManager);
                break;
            case 13:
                o(oidb_0x5e0$ContentItem, friendsManager);
                break;
            case 15:
                p(oidb_0x5e0$ContentItem, friendsManager, aVar);
                break;
            case 16:
                if (oidb_0x5e0$ContentItem.msg_intimate_info.has()) {
                    FriendIntimateRelationshipHelper.h(this.f194971d, oidb_0x5e0$ContentItem.msg_intimate_info.get());
                    break;
                }
                break;
            case 17:
                if (oidb_0x5e0$ContentItem.msg_ext_sns_frd_data.has()) {
                    ExtSnsFrdDataHandleHelper.r(this.f194971d, oidb_0x5e0$ContentItem.msg_ext_sns_frd_data.get());
                    break;
                }
                break;
            case 18:
                if (oidb_0x5e0$ContentItem.msg_mutual_mark_data.has()) {
                    MutualMarkDataS2CHandleHelper.f(this.f194971d, oidb_0x5e0$ContentItem.msg_mutual_mark_data.get());
                    break;
                }
                break;
        }
        if (!TextUtils.isEmpty(aVar.f196640a)) {
            com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) this.f194971d.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
            if (bVar != null) {
                bVar.c(aVar);
            }
            aVar.a();
        }
    }

    private void j(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager) {
        long j3;
        if (oidb_0x5e0$ContentItem.msg_general_buffer.has()) {
            Oidb_0x5e0$GeneralBuffer oidb_0x5e0$GeneralBuffer = oidb_0x5e0$ContentItem.msg_general_buffer.get();
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                j3 = oidb_0x5e0$GeneralBuffer.uint64_uin.get();
            } else {
                j3 = 0;
            }
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                ByteBuffer wrap = ByteBuffer.wrap(oidb_0x5e0$GeneralBuffer.bytes_value.get().toByteArray());
                if (wrap.remaining() >= 4) {
                    int i3 = wrap.getInt();
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                    IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
                    com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, String.valueOf(j3));
                    aVar.o(i3);
                    aVar.v0(System.currentTimeMillis());
                    iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "QQProfileItem", null);
                }
            }
        }
    }

    private void k(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager) {
        long j3;
        if (oidb_0x5e0$ContentItem.msg_general_buffer.has()) {
            Oidb_0x5e0$GeneralBuffer oidb_0x5e0$GeneralBuffer = oidb_0x5e0$ContentItem.msg_general_buffer.get();
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                j3 = oidb_0x5e0$GeneralBuffer.uint64_uin.get();
            } else {
                j3 = 0;
            }
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                ByteBuffer wrap = ByteBuffer.wrap(oidb_0x5e0$GeneralBuffer.bytes_value.get().toByteArray());
                if (wrap.remaining() >= 8) {
                    long j16 = wrap.getLong();
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                    IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
                    NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, String.valueOf(j3));
                    nTVasSimpleInfo.c();
                    nTVasSimpleInfo.pendantId = j16;
                    nTVasSimpleInfo.timestamp = System.currentTimeMillis();
                    iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
                }
            }
        }
    }

    private void l(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager) {
        long j3;
        if (oidb_0x5e0$ContentItem.msg_general_buffer.has()) {
            Oidb_0x5e0$GeneralBuffer oidb_0x5e0$GeneralBuffer = oidb_0x5e0$ContentItem.msg_general_buffer.get();
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                j3 = oidb_0x5e0$GeneralBuffer.uint64_uin.get();
            } else {
                j3 = 0;
            }
            if (oidb_0x5e0$GeneralBuffer != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
                ByteBuffer wrap = ByteBuffer.wrap(oidb_0x5e0$GeneralBuffer.bytes_value.get().toByteArray());
                if (wrap.remaining() >= 4) {
                    int i3 = wrap.getInt();
                    NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
                    nTVasSimpleInfo.c();
                    nTVasSimpleInfo.uVipFont = i3;
                    nTVasSimpleInfo.timestamp = System.currentTimeMillis();
                    ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
                }
            }
        }
    }

    private void m(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem) {
        Oidb_0x5e0$FriendTeamList oidb_0x5e0$FriendTeamList;
        if (oidb_0x5e0$ContentItem.msg_friend_teamlist.has() && (oidb_0x5e0$FriendTeamList = oidb_0x5e0$ContentItem.msg_friend_teamlist.get()) != null && oidb_0x5e0$FriendTeamList.uint32_update_flag.has() && oidb_0x5e0$FriendTeamList.uint32_update_flag.get() == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "CheckUpdate GroupList\uff1auin = ");
            }
            ((FriendListHandler) this.f194971d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
        }
    }

    private void n(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr, com.tencent.qqnt.ntrelation.friendsinfo.bean.d[] dVarArr2, int i3) {
        Oidb_0x5e0$NickNameFiled oidb_0x5e0$NickNameFiled;
        if (oidb_0x5e0$ContentItem.msg_nicknamefiled.has() && (oidb_0x5e0$NickNameFiled = oidb_0x5e0$ContentItem.msg_nicknamefiled.get()) != null && oidb_0x5e0$NickNameFiled.uint64_uin.has()) {
            long j3 = oidb_0x5e0$NickNameFiled.uint64_uin.get();
            String stringUtf8 = oidb_0x5e0$NickNameFiled.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CheckUpdate  Nick\uff1auin = ");
                sb5.append((j3 + FaceUtil.IMG_TEMP).substring(0, 4));
                sb5.append(" \u6635\u79f0 = ");
                sb5.append(com.tencent.mobileqq.util.aw.a(stringUtf8));
                QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb5.toString());
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
            dVar.M();
            dVar.k0(stringUtf8);
            dVar.g0(System.currentTimeMillis());
            dVarArr[i3] = dVar;
            dVarArr2[i3] = dVar;
            if (dVar.B()) {
                arrayList.add(dVar);
            }
        }
    }

    private void o(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager) {
        Oidb_0x5e0$GeneralBuffer oidb_0x5e0$GeneralBuffer;
        if (oidb_0x5e0$ContentItem.msg_general_buffer.has() && (oidb_0x5e0$GeneralBuffer = oidb_0x5e0$ContentItem.msg_general_buffer.get()) != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
            ByteBuffer wrap = ByteBuffer.wrap(oidb_0x5e0$GeneralBuffer.bytes_value.get().toByteArray());
            if (wrap.remaining() > 8) {
                long j3 = wrap.getInt() & 4294967295L;
                long j16 = 4294967295L & wrap.getInt();
                byte[] bArr = new byte[wrap.getShort() & 65535];
                wrap.get(bArr);
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, Long.toString(j3));
                dVar.M();
                if (dVar.t() != j16) {
                    com.tencent.mobileqq.richstatus.c.m(dVar, bArr, j16);
                    dVar.N(Boolean.valueOf(SignatureManager.m(this.f194971d, Long.toString(j3), com.tencent.mobileqq.richstatus.c.h(dVar))));
                    iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "QQProfileItem", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "insertSignMsgIfNeeded from QQProfileItem uin = " + j3 + " result = " + dVar.y());
                    }
                }
            }
        }
    }

    private void p(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager, b.a aVar) {
        if (oidb_0x5e0$ContentItem.msg_profile_info.has()) {
            Oidb_0x5e0$ProfileInfo oidb_0x5e0$ProfileInfo = oidb_0x5e0$ContentItem.msg_profile_info.get();
            long j3 = oidb_0x5e0$ProfileInfo.uint64_uin.get();
            List<Oidb_0x5e0$ProfileTvInfo> list = oidb_0x5e0$ProfileInfo.rpt_msg_profile_info.get();
            aVar.a();
            aVar.f196640a = Long.toString(j3);
            StringBuilder sb5 = new StringBuilder();
            for (Oidb_0x5e0$ProfileTvInfo oidb_0x5e0$ProfileTvInfo : list) {
                int i3 = oidb_0x5e0$ProfileTvInfo.uint32_field_id.get();
                oidb_0x5e0$ProfileTvInfo.uint32_field_type.get();
                sb5.append(",field: ");
                sb5.append(i3);
                sb5.append(", int_value: ");
                sb5.append(0L);
                if (i3 != 20015) {
                    if (i3 != 27201) {
                        if (i3 != 27218) {
                            if (i3 != 27254) {
                                if (i3 != 40530) {
                                    if (i3 != 40556) {
                                        if (i3 == 42099) {
                                            aVar.f196641b = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
                                        }
                                    } else {
                                        aVar.f196643d = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
                                    }
                                } else {
                                    t(oidb_0x5e0$ProfileTvInfo, friendsManager, j3);
                                }
                            } else {
                                r(oidb_0x5e0$ProfileTvInfo, friendsManager, j3);
                            }
                        } else {
                            q(oidb_0x5e0$ProfileTvInfo, friendsManager, j3);
                        }
                    } else {
                        s(oidb_0x5e0$ProfileTvInfo, friendsManager, j3);
                    }
                } else {
                    aVar.f196642c = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Check update for profile field uin: ");
                sb6.append((j3 + FaceUtil.IMG_TEMP).substring(0, 4));
                sb6.append((Object) sb5);
                QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb6.toString());
            }
        }
    }

    private void q(Oidb_0x5e0$ProfileTvInfo oidb_0x5e0$ProfileTvInfo, FriendsManager friendsManager, long j3) {
        long j16 = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, String.valueOf(j3));
        aVar.m();
        aVar.o0(j16);
        iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singleton(aVar)), "QQProfileItem", null);
        if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "update uin=" + j3 + " latestplNewsTs=" + j16);
        }
    }

    private void r(Oidb_0x5e0$ProfileTvInfo oidb_0x5e0$ProfileTvInfo, FriendsManager friendsManager, long j3) {
        long j16 = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isDebugVersion()) {
            QLog.d("QQProfileItem", 2, "update, Get font effect, uin= " + j3 + ", fontEffect = " + j16 + ", updateTime = " + serverTime);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.fontEffect = (int) j16;
        nTVasSimpleInfo.fontEffectLastUpdateTime = serverTime;
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
    }

    private void s(Oidb_0x5e0$ProfileTvInfo oidb_0x5e0$ProfileTvInfo, FriendsManager friendsManager, long j3) {
        long j16 = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
        nTVasSimpleInfo.c();
        long parseFontId = FontManagerConstants.parseFontId(j16);
        int parseFontType = FontManagerConstants.parseFontType(j16);
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDebugVersion()) {
            QLog.d("QQProfileItem", 2, "update, Get Font, uin=" + j3 + ", id=" + parseFontId + ", type = " + parseFontType);
        }
        nTVasSimpleInfo.uVipFont = parseFontId;
        nTVasSimpleInfo.vipFontType = parseFontType;
        nTVasSimpleInfo.timestamp = currentTimeMillis;
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
    }

    private void t(Oidb_0x5e0$ProfileTvInfo oidb_0x5e0$ProfileTvInfo, FriendsManager friendsManager, long j3) {
        long j16 = oidb_0x5e0$ProfileTvInfo.uint64_field_int_value.get();
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), String.valueOf(j3));
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.magicFont = (int) j16;
        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
        if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "update, Get magic font, uin= " + j3 + ", magicfont = " + nTVasSimpleInfo.magicFont);
        }
    }

    private void u(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList) {
        Oidb_0x5e0$FriendRemark oidb_0x5e0$FriendRemark;
        String str;
        if (oidb_0x5e0$ContentItem.msg_friendremark.has() && (oidb_0x5e0$FriendRemark = oidb_0x5e0$ContentItem.msg_friendremark.get()) != null && oidb_0x5e0$FriendRemark.uint64_uin.has()) {
            long j3 = oidb_0x5e0$FriendRemark.uint64_uin.get();
            String stringUtf8 = oidb_0x5e0$FriendRemark.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CheckUpdate Remark\uff1auin = ");
                sb5.append((j3 + FaceUtil.IMG_TEMP).substring(0, 4));
                sb5.append(" \u5907\u6ce8\u5185\u5bb9 = ");
                sb5.append(com.tencent.mobileqq.util.aw.a(stringUtf8));
                QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb5.toString());
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3));
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QQProfileItem");
            if (friendsSimpleInfoWithUid != null) {
                str = friendsSimpleInfoWithUid.r();
            } else {
                friendsSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                str = null;
            }
            if (TextUtils.isEmpty(stringUtf8)) {
                stringUtf8 = "";
            }
            if (!stringUtf8.equals(friendsSimpleInfoWithUid.r())) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, Long.toString(j3));
                dVar.M();
                dVar.m0(stringUtf8);
                dVar.g0(System.currentTimeMillis());
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, "QQProfileItem", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
            }
            if (friendsSimpleInfoWithUid.B() && b(stringUtf8, str)) {
                arrayList.add(friendsSimpleInfoWithUid);
            }
        }
    }

    private void v(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager, ArrayList<SpecialCareInfo> arrayList, Map<String, Boolean> map, ArrayList<String> arrayList2) {
        Oidb_0x5e0$GeneralBuffer oidb_0x5e0$GeneralBuffer;
        String str;
        if (oidb_0x5e0$ContentItem.msg_general_buffer.has() && (oidb_0x5e0$GeneralBuffer = oidb_0x5e0$ContentItem.msg_general_buffer.get()) != null && oidb_0x5e0$GeneralBuffer.bytes_value.has()) {
            Oidb_0x5d0$SnsUpateBuffer oidb_0x5d0$SnsUpateBuffer = new Oidb_0x5d0$SnsUpateBuffer();
            try {
                oidb_0x5d0$SnsUpateBuffer.mergeFrom(oidb_0x5e0$GeneralBuffer.bytes_value.get().toByteArray());
            } catch (Exception e16) {
                e16.printStackTrace();
                oidb_0x5d0$SnsUpateBuffer = null;
            }
            Oidb_0x5d0$SnsUpateBuffer oidb_0x5d0$SnsUpateBuffer2 = oidb_0x5d0$SnsUpateBuffer;
            if (oidb_0x5d0$SnsUpateBuffer2 != null && oidb_0x5d0$SnsUpateBuffer2.uint64_uin.has() && oidb_0x5d0$SnsUpateBuffer2.rpt_uin32_idlist.has()) {
                for (Integer num : oidb_0x5d0$SnsUpateBuffer2.rpt_uin32_idlist.get()) {
                    if (num.intValue() == 4051) {
                        String valueOf = String.valueOf(oidb_0x5d0$SnsUpateBuffer2.uint64_uin.get());
                        if (QLog.isColorLevel()) {
                            if (valueOf.length() >= 4) {
                                str = valueOf.substring(valueOf.length() - 4);
                            } else {
                                str = valueOf;
                            }
                            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "CheckUpdate ValueBit : shd: " + str);
                        }
                        this.f194971d.getMsgCache().f286221o.put(valueOf, valueOf);
                    }
                    A(friendsManager, String.valueOf(oidb_0x5d0$SnsUpateBuffer2.uint64_uin.get()), num.intValue());
                }
                return;
            }
            if (oidb_0x5d0$SnsUpateBuffer2 != null && oidb_0x5d0$SnsUpateBuffer2.uint64_uin.has() && oidb_0x5d0$SnsUpateBuffer2.rpt_msg_sns_update_item.has()) {
                z(oidb_0x5d0$SnsUpateBuffer2, friendsManager, arrayList, map, arrayList2);
            }
        }
    }

    private void w(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, FriendsManager friendsManager) {
        com.tencent.mobileqq.nearby.b bVar;
        if (oidb_0x5e0$ContentItem.msg_genderfiled.has()) {
            Oidb_0x5e0$GenderFiled oidb_0x5e0$GenderFiled = oidb_0x5e0$ContentItem.msg_genderfiled.get();
            long j3 = oidb_0x5e0$GenderFiled.uint64_uin.get();
            Card r16 = friendsManager.r(j3 + "");
            if (r16 != null) {
                int i3 = oidb_0x5e0$GenderFiled.uint32_gender.get();
                if (i3 == 1) {
                    i3 = 0;
                } else if (i3 == 2) {
                    i3 = 1;
                } else if (i3 == 0) {
                    i3 = 2;
                }
                r16.shGender = (short) i3;
                if (Utils.p(this.f194971d.getCurrentAccountUin(), String.valueOf(j3)) && (bVar = (com.tencent.mobileqq.nearby.b) this.f194971d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)) != null) {
                    bVar.d(r16.shGender);
                }
                friendsManager.p0(r16);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("CheckUpdate  sex: uin = ");
                    sb5.append((j3 + FaceUtil.IMG_TEMP).substring(0, 4));
                    sb5.append(" sex = ");
                    sb5.append(i3);
                    QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb5.toString());
                }
            }
        }
    }

    private void x(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, TroopManager troopManager, ArrayList<TroopInfo> arrayList) {
        Oidb_0x5e0$GroupName oidb_0x5e0$GroupName;
        if (oidb_0x5e0$ContentItem.msg_groupname.has() && (oidb_0x5e0$GroupName = oidb_0x5e0$ContentItem.msg_groupname.get()) != null && oidb_0x5e0$GroupName.uint64_group_uin.has()) {
            long j3 = oidb_0x5e0$GroupName.uint64_group_uin.get();
            String stringUtf8 = oidb_0x5e0$GroupName.bytes_value.get().toStringUtf8();
            TroopInfo k3 = troopManager.k(j3 + "");
            if (k3 != null) {
                k3.troopname = stringUtf8;
                arrayList.add(k3);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("CheckUpdate TroopName\uff1auin = ");
                    sb5.append((j3 + FaceUtil.IMG_TEMP).substring(0, 4));
                    sb5.append(" \u7fa4\u540d\u79f0\u5185\u5bb9 = ");
                    sb5.append(com.tencent.mobileqq.util.aw.a(stringUtf8));
                    QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb5.toString());
                }
            }
        }
    }

    private void y(Oidb_0x5e0$ContentItem oidb_0x5e0$ContentItem, NTVasSimpleInfo[] nTVasSimpleInfoArr, int i3) {
        Oidb_0x5e0$ValueBit oidb_0x5e0$ValueBit;
        int i16;
        int i17;
        if (oidb_0x5e0$ContentItem.msg_value_bit.has() && (oidb_0x5e0$ValueBit = oidb_0x5e0$ContentItem.msg_value_bit.get()) != null && oidb_0x5e0$ValueBit.uint64_uin.has()) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(oidb_0x5e0$ValueBit.uint64_uin.get()));
            IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
            NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uidFromUin, "QQProfileItem");
            if (vasSimpleInfoWithUid == null) {
                return;
            }
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(vasSimpleInfoWithUid.getUid(), vasSimpleInfoWithUid.getUin());
            nTVasSimpleInfo.c();
            int i18 = vasSimpleInfoWithUid.qqVipInfo;
            int i19 = vasSimpleInfoWithUid.superVipInfo;
            int i26 = 1;
            if (oidb_0x5e0$ValueBit.bytes_identity_flag.has() && oidb_0x5e0$ValueBit.bytes_identity_flag.get().size() >= 3) {
                byte byteAt = oidb_0x5e0$ValueBit.bytes_identity_flag.get().byteAt(0);
                byte byteAt2 = oidb_0x5e0$ValueBit.bytes_identity_flag.get().byteAt(2);
                int i27 = vasSimpleInfoWithUid.qqVipInfo;
                if ((byteAt & 252) != 0) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                int i28 = (i16 << 24) | i27;
                vasSimpleInfoWithUid.qqVipInfo = i28;
                nTVasSimpleInfo.qqVipInfo = i28;
                int i29 = vasSimpleInfoWithUid.qqVipInfo;
                if ((byteAt2 & Constants.VIRTUAL_GAMEPAD_SDK_DATA) != 0) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                int i36 = i29 | (i17 << 24);
                vasSimpleInfoWithUid.qqVipInfo = i36;
                nTVasSimpleInfo.qqVipInfo = i36;
            }
            if (oidb_0x5e0$ValueBit.bytes_ext_flag.has() && oidb_0x5e0$ValueBit.bytes_ext_flag.get().size() >= 5) {
                byte byteAt3 = oidb_0x5e0$ValueBit.bytes_ext_flag.get().byteAt(5);
                int i37 = vasSimpleInfoWithUid.superVipInfo;
                if ((byteAt3 & 32) == 0) {
                    i26 = 0;
                }
                int i38 = (i26 << 24) | i37;
                vasSimpleInfoWithUid.superVipInfo = i38;
                nTVasSimpleInfo.superVipInfo = i38;
            }
            if (vasSimpleInfoWithUid.superVipInfo != i19 || vasSimpleInfoWithUid.qqVipInfo != i18) {
                nTVasSimpleInfoArr[i3] = vasSimpleInfoWithUid;
            }
            iVasInfoService.accurateUpdateVasSimpleInfo(new ArrayList<>(Arrays.asList(nTVasSimpleInfoArr)), "QQProfileItem", (hx3.c<NTVasSimpleInfo>) null);
        }
    }

    private void z(Oidb_0x5d0$SnsUpateBuffer oidb_0x5d0$SnsUpateBuffer, FriendsManager friendsManager, ArrayList<SpecialCareInfo> arrayList, Map<String, Boolean> map, ArrayList<String> arrayList2) {
        List<Oidb_0x5d0$SnsUpdateItem> list = oidb_0x5d0$SnsUpateBuffer.rpt_msg_sns_update_item.get();
        long j3 = oidb_0x5d0$SnsUpateBuffer.uint64_uin.get();
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = null;
        com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = null;
        for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : list) {
            if (oidb_0x5d0$SnsUpdateItem != null && oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.has() && oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
                if (oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13578) {
                    FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(j3), 13578, 18);
                    if (!oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
                        updateFriendStatusItem.e(null);
                    } else {
                        updateFriendStatusItem.e(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
                    }
                    FriendsStatusUtil.h(this.f194971d, updateFriendStatusItem, null);
                } else if (oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13579) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQProfileItem", 2, "get do not disturb push");
                    }
                    FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem2 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(j3), 13579, 19);
                    updateFriendStatusItem2.f(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
                    FriendsStatusUtil.h(this.f194971d, updateFriendStatusItem2, null);
                } else {
                    if (oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13568) {
                        com.tencent.mobileqq.activity.specialcare.e.a(String.valueOf(oidb_0x5d0$SnsUpateBuffer.uint64_uin.get()), oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8(), this.f194971d);
                    }
                    if (dVar == null || cVar == null) {
                        String valueOf = String.valueOf(j3);
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QQProfileItem");
                        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(uidFromUin, "QQProfileItem");
                        if (friendsSimpleInfoWithUid == null) {
                            friendsSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                            friendsSimpleInfoWithUid.v0(uidFromUin);
                            friendsSimpleInfoWithUid.w0(valueOf);
                        }
                        if (otherSimpleInfoWithUid == null) {
                            otherSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.otherinfo.bean.c();
                            otherSimpleInfoWithUid.t(uidFromUin);
                            friendsSimpleInfoWithUid.w0(valueOf);
                        }
                        dVar = friendsSimpleInfoWithUid;
                        cVar = otherSimpleInfoWithUid;
                    }
                    int i3 = oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get();
                    String stringUtf8 = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8();
                    FriendListHandler.initSpecialCareInfo(dVar, i3, stringUtf8, cVar);
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "handleCheckUpdateRspBody uin=" + j3 + ", itemtype=" + i3 + ",itemVal=" + stringUtf8);
                    }
                    if (oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13581) {
                        String valueOf2 = String.valueOf(oidb_0x5d0$SnsUpateBuffer.uint64_uin.get());
                        boolean z16 = false;
                        if (oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
                            byte[] byteArray = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray();
                            if (byteArray.length != 0 && byteArray[0] != 0) {
                                z16 = true;
                            }
                        }
                        map.put(valueOf2, Boolean.valueOf(z16));
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (QLog.isDebugVersion()) {
            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "QQProfileItem::getCheckUpdateItemData called checkUpdateType:" + i3);
        }
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 101;
        SharedPreferences preferences = this.f194971d.getPreferences();
        long[] jArr = new long[19];
        for (int i16 = 0; i16 < 19; i16++) {
            jArr[i16] = preferences.getLong("inccheckupdatetimeStamp" + Integer.toString(i16), 0L) - 0;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(50);
            for (int i17 = 0; i17 < 19; i17++) {
                sb5.append(Long.toString(jArr[i17]));
                sb5.append(" ");
            }
            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, sb5.toString());
        }
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList2 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList2.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList2.uint32_update_profile_id.set(1);
        oidb_0x5e0$UpdateProfileList2.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList2.uint32_get_content_timestamp.set((int) jArr[1]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList3 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList3.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList3.uint32_update_profile_id.set(2);
        oidb_0x5e0$UpdateProfileList3.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList3.uint32_get_content_timestamp.set((int) jArr[2]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList4 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList4.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList4.uint32_update_profile_id.set(3);
        oidb_0x5e0$UpdateProfileList4.uint32_friendlist_type.set(0);
        oidb_0x5e0$UpdateProfileList4.uint32_get_content_timestamp.set((int) jArr[3]);
        if (!((FriendListHandler) this.f194971d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).isSyncingAllFriendsRichStatus()) {
            oidb_0x5e0$UpdateProfileList = new Oidb_0x5e0$UpdateProfileList();
            oidb_0x5e0$UpdateProfileList.uint32_need_content.set(0);
            oidb_0x5e0$UpdateProfileList.uint32_update_profile_id.set(13);
            oidb_0x5e0$UpdateProfileList.uint32_friendlist_type.set(1);
            oidb_0x5e0$UpdateProfileList.uint32_get_content_timestamp.set((int) jArr[13]);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "skip rich status check update");
            }
            oidb_0x5e0$UpdateProfileList = null;
        }
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList5 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList5.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList5.uint32_update_profile_id.set(5);
        oidb_0x5e0$UpdateProfileList5.uint32_friendlist_type.set(0);
        oidb_0x5e0$UpdateProfileList5.uint32_get_content_timestamp.set((int) jArr[5]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList6 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList6.uint32_need_content.set(1);
        oidb_0x5e0$UpdateProfileList6.uint32_update_profile_id.set(6);
        oidb_0x5e0$UpdateProfileList6.uint32_friendlist_type.set(0);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList7 = oidb_0x5e0$UpdateProfileList;
        oidb_0x5e0$UpdateProfileList6.uint32_get_content_timestamp.set((int) jArr[6]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList8 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList8.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList8.uint32_update_profile_id.set(7);
        oidb_0x5e0$UpdateProfileList8.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList8.uint32_get_content_timestamp.set((int) jArr[7]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList9 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList9.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList9.uint32_update_profile_id.set(9);
        oidb_0x5e0$UpdateProfileList9.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList9.uint32_get_content_timestamp.set((int) jArr[9]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList10 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList10.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList10.uint32_update_profile_id.set(10);
        oidb_0x5e0$UpdateProfileList10.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList10.uint32_get_content_timestamp.set((int) jArr[10]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList11 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList11.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList11.uint32_update_profile_id.set(11);
        oidb_0x5e0$UpdateProfileList11.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList11.uint32_get_content_timestamp.set((int) jArr[11]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList12 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList12.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList12.uint32_update_profile_id.set(12);
        oidb_0x5e0$UpdateProfileList12.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList12.uint32_get_content_timestamp.set((int) jArr[12]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList13 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList13.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList13.uint32_update_profile_id.set(15);
        oidb_0x5e0$UpdateProfileList13.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList13.uint32_get_content_timestamp.set((int) jArr[15]);
        if (!((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).disableCMShowRequest()) {
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_VIP_FLAG));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_VIP_LEVEL));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_FEATURE_FLAG));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_UPDATE_TS));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_SIGN_TS));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_APOLLO_AI_FLAG));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_CMSHOW_3D_FLAG));
        }
        oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_VIP_FONT_ID_TYPE));
        oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_VIP_MAGIC_FONT_FLAG));
        oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_VIP_FONT_EFFECT));
        com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) this.f194971d.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if (bVar != null && bVar.h()) {
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_CLASSIC_HEAD_ACTIVITY_STARTED));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_QQ_AVATAR_TYPE));
            oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(20015);
            if (QLog.isColorLevel()) {
                QLog.d("QQProfileItem", 2, "ClassicHeadActivity Params is add");
            }
        }
        oidb_0x5e0$UpdateProfileList13.rpt_uint32_profile_field_list.add(Integer.valueOf(ProfileContants.FIELD_PERSONALITY_LABEL_TS));
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList14 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList14.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList14.uint32_update_profile_id.set(16);
        oidb_0x5e0$UpdateProfileList14.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList14.uint32_get_content_timestamp.set((int) jArr[16]);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList15 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList15.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList15.uint32_update_profile_id.set(17);
        oidb_0x5e0$UpdateProfileList15.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList15.uint32_get_content_timestamp.set((int) jArr[17]);
        Oidb_0xd50$ReqBody oidb_0xd50$ReqBody = new Oidb_0xd50$ReqBody();
        oidb_0xd50$ReqBody.appid.set(10002L);
        oidb_0xd50$ReqBody.req_music_switch.set(1);
        oidb_0xd50$ReqBody.req_ksing_switch.set(1);
        oidb_0xd50$ReqBody.req_mutualmark_lbsshare.set(1);
        if (QLog.isDebugVersion()) {
            QLog.d("QQProfileItem", 2, "getCheckUpdateItemData: invoked. ", " req lbs share profile. ", "\u6b64\u5904\u5f88\u53ef\u80fd\u89e6\u53d1\u589e\u91cf\u8d44\u6599\u66f4\u65b0\u9650\u9891\u903b\u8f91\uff0c\u4f1a\u5bfc\u81f4\u72b6\u6001\u5237\u65b0\u4e0d\u53ca\u65f6\u3002\uff08\u6d88\u606ftab\u5916\u663e\u56fe\u6807\u672a\u5237\u65b0\u7b49\u7b49\u95ee\u9898\uff09");
        }
        oidb_0xd50$ReqBody.req_mutualmark_alienation.set(1);
        oidb_0xd50$ReqBody.req_aio_quick_app.set(1);
        oidb_0x5e0$UpdateProfileList15.msg_0xd50_req.set(oidb_0xd50$ReqBody);
        Oidb_0x5e0$UpdateProfileList oidb_0x5e0$UpdateProfileList16 = new Oidb_0x5e0$UpdateProfileList();
        oidb_0x5e0$UpdateProfileList16.uint32_need_content.set(0);
        oidb_0x5e0$UpdateProfileList16.uint32_update_profile_id.set(18);
        oidb_0x5e0$UpdateProfileList16.uint32_friendlist_type.set(1);
        oidb_0x5e0$UpdateProfileList16.uint32_get_content_timestamp.set((int) jArr[18]);
        Oidb_0xd6b$ReqBody oidb_0xd6b$ReqBody = new Oidb_0xd6b$ReqBody();
        oidb_0xd6b$ReqBody.start_time.set((int) jArr[18]);
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
            oidb_0xd6b$ReqBody.cmd_version.set("1");
        }
        oidb_0x5e0$UpdateProfileList16.msg_0xd6b_req.set(oidb_0xd6b$ReqBody);
        Oidb_0x5e0$ReqBody oidb_0x5e0$ReqBody = new Oidb_0x5e0$ReqBody();
        ByteStringMicro byteStringMicro = this.f194972e;
        if (byteStringMicro != null) {
            oidb_0x5e0$ReqBody.bytes_svrcontext.set(byteStringMicro);
        }
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList2);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList3);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList4);
        if (oidb_0x5e0$UpdateProfileList7 != null) {
            oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList7);
        }
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList5);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList6);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList8);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList9);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList10);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList11);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList12);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList13);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList14);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList15);
        oidb_0x5e0$ReqBody.rpt_msg_update_profile_list.add(oidb_0x5e0$UpdateProfileList16);
        if (i3 == 8) {
            oidb_0x5e0$ReqBody.uint32_forced_update.set(1);
        }
        reqItem.vecParam = oidb_0x5e0$ReqBody.toByteArray();
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        Oidb_0x5e0$RspBody oidb_0x5e0$RspBody;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        QLog.i(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, "QQProfileItem::handleCheckUpdateItemData called item.cResult = " + ((int) respItem.cResult));
        if (respItem.eServiceID == 101 && respItem.cResult == 2) {
            byte[] bArr = respItem.vecUpdate;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleCheckUpdateItemData pbdata.length=");
                if (bArr != null) {
                    i3 = bArr.length;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                QLog.d("QQProfileItem", 2, sb5.toString());
            }
            try {
                oidb_0x5e0$RspBody = new Oidb_0x5e0$RspBody().mergeFrom(bArr);
            } catch (Exception e16) {
                e16.printStackTrace();
                oidb_0x5e0$RspBody = null;
            }
            if (oidb_0x5e0$RspBody == null) {
                return;
            }
            e(oidb_0x5e0$RspBody);
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 13;
    }
}
