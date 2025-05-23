package com.tencent.mobileqq.app.friendlist;

import KQQ.ProfSmpInfoRes;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.z;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, List<String> list) {
        for (String str : list) {
            try {
                List<MessageRecord> Q = qQAppInterface.getMessageFacade().Q(str, 0);
                if (Q != null && Q.size() > 0) {
                    for (MessageRecord messageRecord : Q) {
                        int i3 = messageRecord.msgtype;
                        if (i3 == -1013 || i3 == -1019 || i3 == -1018 || i3 == -2019 || i3 == -7006) {
                            qQAppInterface.getMessageFacade().T1(str, 0, messageRecord.uniseq);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void b(QQAppInterface qQAppInterface, ProfSmpInfoRes profSmpInfoRes, Card card, String str, ArrayList<String> arrayList) {
        boolean z16;
        short s16;
        card.nFaceID = profSmpInfoRes.wFace;
        card.shGender = profSmpInfoRes.cSex;
        card.age = profSmpInfoRes.wAge;
        String str2 = profSmpInfoRes.strNick;
        if (str2 != null) {
            card.strNick = str2;
        }
        String str3 = profSmpInfoRes.sCountry;
        if (str3 != null) {
            card.strCountry = str3;
        }
        String str4 = profSmpInfoRes.sProvince;
        if (str4 != null) {
            card.strProvince = str4;
        }
        String str5 = profSmpInfoRes.sCity;
        if (str5 != null) {
            card.strCity = str5;
        }
        if (str.equals(qQAppInterface.getCurrentAccountUin()) && (s16 = profSmpInfoRes.wLevel) != 0) {
            card.iQQLevel = s16;
        }
        if (profSmpInfoRes.isShowXMan != -1 && profSmpInfoRes.dwLoginDay >= 0 && profSmpInfoRes.dwPhoneQQXManDay > 0) {
            if (str.equals(qQAppInterface.getCurrentAccountUin())) {
                card.lLoginDays = profSmpInfoRes.dwLoginDay;
                card.lQQMasterLogindays = profSmpInfoRes.dwPhoneQQXManDay;
                card.iXManScene1DelayTime = profSmpInfoRes.iXManScene1DelayTime;
                card.iXManScene2DelayTime = profSmpInfoRes.iXManScene2DelayTime;
                if (profSmpInfoRes.isShowXMan == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                card.setXManFlag(z16);
            }
            if (arrayList.size() == 1) {
                if (!str.equals(qQAppInterface.getCurrentAccountUin())) {
                    card.allowPeopleSee = profSmpInfoRes.bOpenLoginDays;
                }
                card.allowClick = profSmpInfoRes.bXManIconClick;
            }
        }
    }

    public static void c(FriendListHandler friendListHandler, ToServiceMsg toServiceMsg, ProfSmpInfoRes profSmpInfoRes, List<Object[]> list, String str) {
        if (toServiceMsg.extraData.getBoolean("reqDateNick", false)) {
            String str2 = profSmpInfoRes.sDateNick;
            if (TextUtils.isEmpty(str2)) {
                str2 = profSmpInfoRes.strNick;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            list.add(new Object[]{str, str2, Byte.valueOf(profSmpInfoRes.cSex)});
            if (QLog.isColorLevel()) {
                QLog.d(FriendListHandler.TAG, 2, "$handleFriendInfo add to nickSaveList| uin=" + str + " | datenick = " + profSmpInfoRes.sDateNick + " | nick=" + profSmpInfoRes.strNick);
            }
            friendListHandler.notifyUI(85, true, new Object[]{str, str2});
        }
    }

    public static void d(ProfSmpInfoRes profSmpInfoRes, boolean z16, boolean z17, QQAppInterface qQAppInterface, String str) {
        BusinessCardManager businessCardManager;
        if (z16 || z17) {
            qQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, profSmpInfoRes.strNick);
        }
        if (profSmpInfoRes.cBusiCardFlag == 1 && z16 && (businessCardManager = (BusinessCardManager) qQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)) != null) {
            com.tencent.mobileqq.businessCard.b.d(qQAppInterface, businessCardManager.k(), 0, true);
            businessCardManager.t(1, true);
        }
    }

    public static void e(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, ProfSmpInfoRes profSmpInfoRes) {
        if (toServiceMsg.extraData.getBoolean("reqSelfLevel", false)) {
            z.i(qQAppInterface.getApp().getApplicationContext(), qQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
            if (QLog.isColorLevel()) {
                QLog.d(FriendListHandler.TAG, 2, "$handleFriendInfo | iQQLevel = " + ((int) profSmpInfoRes.wLevel));
            }
        }
    }

    public static void f(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, ProfSmpInfoRes profSmpInfoRes) {
        if (toServiceMsg.extraData.getBoolean("reqXMan", false)) {
            Context applicationContext = qQAppInterface.getApp().getApplicationContext();
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            z.h(applicationContext, currentAccountUin, System.currentTimeMillis());
            if (toServiceMsg.extraData.getInt("getXManInfoScene", 0) == 2) {
                z.g(applicationContext, currentAccountUin, System.currentTimeMillis());
            }
            if (QLog.isColorLevel()) {
                QLog.d(FriendListHandler.TAG, 2, "$handleFriendInfo | dwLoginDay=" + profSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay=" + profSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan=" + profSmpInfoRes.isShowXMan + " | iXManScene1DelayTime=" + profSmpInfoRes.iXManScene1DelayTime + " | iXManScene2DelayTime=" + profSmpInfoRes.iXManScene2DelayTime);
            }
        }
    }

    public static boolean g(ByteBuffer byteBuffer, NTVasSimpleInfo nTVasSimpleInfo, int i3) {
        if (i3 == 27025 && byteBuffer.getShort() == 8) {
            nTVasSimpleInfo.pendantId = byteBuffer.getLong();
            nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            return true;
        }
        return false;
    }

    public static void h(QQAppInterface qQAppInterface, ByteBuffer byteBuffer, long j3, int i3) {
        int i16;
        if (i3 == 20059 && byteBuffer.getShort() == 4 && (i16 = byteBuffer.getInt()) >= 0 && String.valueOf(j3).equals(qQAppInterface.getCurrentAccountUin())) {
            ((BubbleManager) qQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).z(i16, true);
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfBubbleId(i16);
        }
    }

    public static boolean i(ByteBuffer byteBuffer, NTVasSimpleInfo nTVasSimpleInfo, int i3) {
        if (i3 == 27041 && byteBuffer.getShort() == 4) {
            int i16 = byteBuffer.getInt();
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(nTVasSimpleInfo.getUid(), nTVasSimpleInfo.getUin());
            cVar.m();
            cVar.o(i16);
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(cVar, "FriendListHandlerUtil", (hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
            return false;
        }
        return false;
    }

    public static boolean j(ByteBuffer byteBuffer, NTVasSimpleInfo nTVasSimpleInfo, int i3) {
        if (i3 == 27201 && byteBuffer.getShort() == 4) {
            long j3 = byteBuffer.getInt();
            nTVasSimpleInfo.uVipFont = FontManagerConstants.parseFontId(j3);
            nTVasSimpleInfo.vipFontType = FontManagerConstants.parseFontType(j3);
            nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            return true;
        }
        return false;
    }

    public static void k(boolean z16, QQAppInterface qQAppInterface) {
        EnterpriseQQHandler enterpriseQQHandler;
        if (z16 && (enterpriseQQHandler = (EnterpriseQQHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER)) != null) {
            enterpriseQQHandler.D2(SystemClock.uptimeMillis());
        }
    }

    public static void l(QQAppInterface qQAppInterface, List<Object[]> list) {
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        for (Object[] objArr : list) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(FriendListHandler.TAG, 2, "handleFriendInfo handle nickSaveList:" + objArr[0] + ", " + objArr[1] + ", " + objArr[2]);
                }
                friendsManager.q0((String) objArr[0], (String) objArr[1], ((Byte) objArr[2]).byteValue());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(FriendListHandler.TAG, 2, "handleFriendInfo saveDateNickByUin err" + e16, e16);
                } else {
                    QLog.i(FriendListHandler.TAG, 1, "handleFriendInfo saveDateNickByUin err" + e16);
                }
            }
        }
    }

    public static int m(VipBaseInfo vipBaseInfo, int i3, int i16) {
        Map<Integer, VipOpenInfo> map;
        VipOpenInfo vipOpenInfo;
        int i17;
        int i18;
        if (vipBaseInfo != null && (map = vipBaseInfo.mOpenInfo) != null && (vipOpenInfo = map.get(Integer.valueOf(i3))) != null && (i17 = vipOpenInfo.iVipLevel) != -1 && (i18 = vipOpenInfo.iVipType) != -1) {
            return ((((vipOpenInfo.bOpen ? 1 : 0) << 8) | (((byte) i18) & 255)) << 16) | ((short) i17);
        }
        return i16;
    }
}
