package com.tencent.mobileqq.utils;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private static LruCache<String, String> f307391a = new LruCache<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private static String f307392b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f307393c = "troop_mem_nick_update_target";

    /* renamed from: d, reason: collision with root package name */
    public static int f307394d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f307395e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f307396f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static String f307397g = "uni_seq";

    /* renamed from: h, reason: collision with root package name */
    public static String f307398h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Paint f307399i = new Paint();

    @NotNull
    public static String A(QQAppInterface qQAppInterface, String str) {
        String str2;
        PhoneContact queryPhoneContactByUin;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) != null) {
            str2 = queryPhoneContactByUin.name;
        } else {
            str2 = null;
        }
        if (friendsSimpleInfoWithUid != null) {
            return C(friendsSimpleInfoWithUid, str2);
        }
        return str;
    }

    public static String A0(QQAppInterface qQAppInterface, String str, String str2, long j3, String str3, Map<String, DiscussionMemberInfo> map) {
        if (((64 & j3) >>> 6) == 1 && (j3 & 536870912) != 536870912 && (map == null || map.size() == 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + str);
            }
            return str3;
        }
        if (s0(qQAppInterface, j3, str3)) {
            return k(qQAppInterface, str2, map);
        }
        return str3;
    }

    public static String B(QQAppInterface qQAppInterface, String str) {
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    public static boolean B0(QQAppInterface qQAppInterface, String str, DiscussionInfo discussionInfo, Map<String, DiscussionMemberInfo> map, boolean z16) {
        boolean z17;
        String str2;
        if (discussionInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + str);
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, Flag =" + discussionInfo.DiscussionFlag + " disUin=" + str);
        }
        if (!discussionInfo.hasRenamed() && ((discussionInfo.DiscussionFlag & 536870912) >>> 29) == 1 && (map == null || map.size() == 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName no need disUin=" + str);
            }
            return false;
        }
        if (t0(qQAppInterface, discussionInfo)) {
            z17 = z0(qQAppInterface, str, discussionInfo, map);
        } else {
            z17 = false;
        }
        if (!z16 && !z17 && (str2 = discussionInfo.mCompareSpell) != null && str2.length() != 0) {
            return false;
        }
        com.tencent.mobileqq.app.j.f(discussionInfo);
        discussionInfo.DiscussionFlag &= -536870913;
        return true;
    }

    private static String C(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, String str) {
        if (dVar.r() != null && dVar.r().length() > 0) {
            return dVar.r();
        }
        if (str == null || str.length() <= 0) {
            if (dVar.p() != null && dVar.p().length() > 0) {
                return dVar.p();
            }
            return dVar.x();
        }
        return str;
    }

    public static boolean C0(QQAppInterface qQAppInterface) {
        boolean z16;
        boolean z17;
        if (com.tencent.mobileqq.extendfriend.utils.a.b(qQAppInterface) == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((MayknowRecommendManager) qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).i("sp_mayknow_entry_list_add") && !StudyModeManager.t()) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean e16 = com.tencent.mobileqq.extendfriend.utils.a.e(qQAppInterface);
        if (z16 && z17 && e16) {
            return true;
        }
        return false;
    }

    private static String D(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, String str) {
        if (dVar.r() != null && dVar.r().length() > 0) {
            return dVar.r();
        }
        if (str == null || str.length() <= 0) {
            if (dVar.p() != null && dVar.p().length() > 0) {
                return dVar.p();
            }
            return "";
        }
        return str;
    }

    public static String E(QQAppInterface qQAppInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        String remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getRemarkWithUid(uidFromUin, "ContactUtils");
        String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "ContactUtils");
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ContactUtils")) {
            if (!TextUtils.isEmpty(remarkWithUid)) {
                return remarkWithUid;
            }
            if (!TextUtils.isEmpty(nickWithUid)) {
                return nickWithUid;
            }
            return str;
        }
        return str;
    }

    public static String F(AppRuntime appRuntime, String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        if (friendsSimpleInfoWithUid != null) {
            return friendsSimpleInfoWithUid.m();
        }
        return str;
    }

    public static String G(QQAppInterface qQAppInterface, String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
            return friendsSimpleInfoWithUid.p();
        }
        Card r16 = friendsManager.r(str);
        if (r16 != null && !TextUtils.isEmpty(r16.strNick)) {
            return r16.strNick;
        }
        return str;
    }

    public static String H(AppInterface appInterface, String str) {
        String str2;
        PhoneContact queryPhoneContactByUin;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        IPhoneContactService iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) != null) {
            str2 = queryPhoneContactByUin.name;
        } else {
            str2 = null;
        }
        if (friendsSimpleInfoWithUid != null) {
            if (friendsSimpleInfoWithUid.r() != null && friendsSimpleInfoWithUid.r().length() > 0) {
                return friendsSimpleInfoWithUid.r();
            }
            if (friendsSimpleInfoWithUid.p() != null && friendsSimpleInfoWithUid.p().length() > 0) {
                return friendsSimpleInfoWithUid.p();
            }
            if (str2 != null && str2.length() > 0) {
                return str2;
            }
            return friendsSimpleInfoWithUid.x();
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r10.getShowPcOnlineIconConfig() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (r10.getShowPcOnlineIconConfig() != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int I(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, QQAppInterface qQAppInterface) {
        FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        int a16 = com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z());
        if (a16 != 0 && a16 != 6) {
            com.tencent.mobileqq.friend.status.a c16 = com.tencent.mobileqq.friend.status.a.c();
            if (1 != c16.b(cVar.z(), 0)) {
                if (2 == c16.b(cVar.z(), 0)) {
                    return 1;
                }
                if (3 != c16.b(cVar.z(), 0)) {
                }
                return 0;
            }
        } else {
            if (cVar.A() != 1) {
                if (cVar.A() != 3) {
                    if (cVar.A() == 2) {
                        return 1;
                    }
                    return 3;
                }
                return 0;
            }
            return 2;
        }
    }

    public static String J(AppInterface appInterface, String str, String str2) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        String remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getRemarkWithUid(uidFromUin, "ContactUtils");
        String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "ContactUtils");
        if (!TextUtils.isEmpty(remarkWithUid)) {
            return remarkWithUid;
        }
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "ContactUtils-gary");
        if (troopMemberInfoSync != null) {
            if (!TextUtils.isEmpty(troopMemberInfoSync.troopnick)) {
                return troopMemberInfoSync.troopnick;
            }
            if (!TextUtils.isEmpty(nickWithUid)) {
                return nickWithUid;
            }
            if (str2.equals(appInterface.getCurrentAccountUin())) {
                if (!TextUtils.isEmpty(troopMemberInfoSync.friendnick)) {
                    return troopMemberInfoSync.friendnick;
                }
                return str2;
            }
            if (!TextUtils.isEmpty(troopMemberInfoSync.autoremark)) {
                return troopMemberInfoSync.autoremark;
            }
            if (!TextUtils.isEmpty(troopMemberInfoSync.friendnick)) {
                return troopMemberInfoSync.friendnick;
            }
            return str2;
        }
        ((com.tencent.mobileqq.troop.api.handler.e) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).f2(Long.parseLong(str), Long.parseLong(str2));
        return str2;
    }

    public static String K(AppInterface appInterface, String str) {
        IGProGuildInfo iGProGuildInfo;
        if (appInterface instanceof QQAppInterface) {
            iGProGuildInfo = ((IGPSService) ((QQAppInterface) appInterface).getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo != null) {
            if (iGProGuildInfo.getGuildName() == null) {
                return str;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "getGuildName, " + iGProGuildInfo.getGuildName());
            }
            return iGProGuildInfo.getGuildName();
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("ContactUtils", 1, "igProGuildInfo is null,getGuildName:null " + str, new Throwable("can't get name by guildId " + str));
        }
        return "";
    }

    public static String L(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().substring(0, 1).toUpperCase();
    }

    public static boolean M(AppRuntime appRuntime) {
        if (((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("unfrequent_contacts")) {
            return true;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            return !n0(appRuntime);
        }
        return false;
    }

    @Deprecated
    public static String N(BaseQQAppInterface baseQQAppInterface, int i3, String str, String str2) {
        if (i3 != 1) {
            if (i3 == 3000) {
                return n(baseQQAppInterface, str, str2);
            }
            if (i3 != 10014) {
                return "";
            }
            return ((IGPSService) baseQQAppInterface.getRuntimeService(IGPSService.class, "")).getGuildUserDisplayName(str, str2);
        }
        return str2;
    }

    public static String O(int i3) {
        if (i3 != 12) {
            if (i3 != 100) {
                if (i3 != 101) {
                    switch (i3) {
                        case 1:
                            return "WIFI\u7f51\u7edc";
                        case 2:
                        default:
                            return "2G\u7f51\u7edc";
                        case 3:
                            return "3G\u7f51\u7edc";
                        case 4:
                            return "4G\u7f51\u7edc";
                        case 5:
                            return HardCodeUtil.qqStr(R.string.f171811l44);
                        case 6:
                            return HardCodeUtil.qqStr(R.string.l46);
                        case 7:
                            return HardCodeUtil.qqStr(R.string.l48);
                        case 8:
                            return HardCodeUtil.qqStr(R.string.l47);
                        case 9:
                            return HardCodeUtil.qqStr(R.string.l4_);
                        case 10:
                            return "TIM\u5728\u7ebf";
                    }
                }
                return HardCodeUtil.qqStr(R.string.f171812l45);
            }
            return "iPhone\u5728\u7ebf";
        }
        return "5G\u7f51\u7edc";
    }

    public static String P(int i3) {
        if (i3 != 100) {
            if (i3 != 101) {
                switch (i3) {
                    case 1:
                        return "WiFi\u5728\u7ebf";
                    case 2:
                    default:
                        return "2G\u5728\u7ebf";
                    case 3:
                        return "3G\u5728\u7ebf";
                    case 4:
                        return "4G\u5728\u7ebf";
                    case 5:
                        return HardCodeUtil.qqStr(R.string.f171810l43);
                    case 6:
                        return HardCodeUtil.qqStr(R.string.l4d);
                    case 7:
                        return HardCodeUtil.qqStr(R.string.l49);
                    case 8:
                        return "BMW QQ\u5728\u7ebf";
                    case 9:
                        return "\u8f66\u8f7dQQ\u5728\u7ebf";
                    case 10:
                        return "TIM\u5728\u7ebf";
                    case 11:
                        return HardCodeUtil.qqStr(R.string.l4c);
                    case 12:
                        return "5G\u5728\u7ebf";
                }
            }
            return HardCodeUtil.qqStr(R.string.l4a);
        }
        return "iPhone\u5728\u7ebf";
    }

    public static String Q(AppInterface appInterface, String str, int i3) {
        if (i3 == 1) {
            return h0(appInterface, str);
        }
        if (3000 == i3) {
            return r(appInterface, str);
        }
        if (i3 == 0 || 1024 == i3) {
            return F(appInterface, str);
        }
        return str;
    }

    public static String R(QQAppInterface qQAppInterface, String str, int i3) {
        String str2;
        String str3;
        String str4;
        if (i3 == 1) {
            return h0(qQAppInterface, str);
        }
        if (3000 == i3) {
            return p(qQAppInterface, qQAppInterface.getApp(), str);
        }
        if (10014 == i3) {
            return K(qQAppInterface, str);
        }
        if (1008 != i3 && 1024 != i3) {
            if (i3 == 1006) {
                IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
                PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(str);
                if (queryContactByCodeNumber != null) {
                    return queryContactByCodeNumber.name;
                }
                String uinByPhoneNum = iPhoneContactService.getUinByPhoneNum(str);
                if (uinByPhoneNum != null) {
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uinByPhoneNum);
                    com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                    aVar.d(uidFromUin);
                    str4 = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                } else {
                    str4 = null;
                }
                if (str4 != null && !str4.equals(uinByPhoneNum)) {
                    return str4;
                }
                return str;
            }
            return F(qQAppInterface, str);
        }
        if (QidianManager.P(qQAppInterface, str)) {
            return QidianManager.v(qQAppInterface, str);
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str);
        if (publicAccountInfo != null && (str3 = publicAccountInfo.name) != null) {
            return str3;
        }
        IPublicAccountDetail findAccountDetailInfo = iPublicAccountDataManager.findAccountDetailInfo(str);
        if (findAccountDetailInfo != null && findAccountDetailInfo.getName() != null) {
            return findAccountDetailInfo.getName();
        }
        EqqDetail b16 = ((com.tencent.mobileqq.app.z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).b(str);
        if (b16 != null && (str2 = b16.name) != null) {
            return str2;
        }
        return str;
    }

    public static String S(QQAppInterface qQAppInterface, int i3, String str, String str2, boolean z16, String str3) {
        String s16;
        try {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (z16) {
                        s16 = qQAppInterface.getCurrentNickname();
                    } else {
                        if (str2 != null) {
                            try {
                                if (str2.length() != 0) {
                                    return str2;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e("ContactUtils", 1, "getNickname e =" + e);
                                return str2;
                            }
                        }
                        return s(qQAppInterface, str, "", 0, 0);
                    }
                } else {
                    s16 = n(qQAppInterface, str, str3);
                }
            } else {
                s16 = s(qQAppInterface, str3, str, 1, 0);
            }
            return s16;
        } catch (Exception e17) {
            e = e17;
            str2 = str3;
        }
    }

    public static String T(QQAppInterface qQAppInterface, SessionInfo sessionInfo, boolean z16, String str) {
        int i3;
        try {
            i3 = sessionInfo.f179555d;
        } catch (Exception unused) {
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                if (z16) {
                    return qQAppInterface.getCurrentNickname();
                }
                str = sessionInfo.f179563i;
                if (str == null || str.length() == 0) {
                    return s(qQAppInterface, sessionInfo.f179557e, "", 0, 0);
                }
                return str;
            }
            return n(qQAppInterface, sessionInfo.f179557e, str);
        }
        return s(qQAppInterface, str, sessionInfo.f179557e, 1, 0);
    }

    public static String U(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            char c16 = 0;
            char c17 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (i3 == 0) {
                    c16 = charAt;
                }
                if (i3 == 1) {
                    c17 = charAt;
                }
                if (charAt >= '\u4e00' && charAt <= '\u9fa5') {
                    return String.valueOf(charAt);
                }
            }
            if (c16 >= '!' && c16 <= '~') {
                if (c17 >= '!' && c17 <= '~') {
                    return String.valueOf(new char[]{c16, c17});
                }
                return String.valueOf(c16);
            }
            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return "";
    }

    public static String V(AppInterface appInterface, String str) {
        return ((IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(str);
    }

    public static String W(AppInterface appInterface, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null) {
            return k3.getNewTroopNameOrTroopName();
        }
        String troopNameFromSP = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopNameFromSP(appInterface.getApp(), str);
        if (!u0(troopNameFromSP)) {
            troopNameFromSP = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getNewTroopNameOrTroopName()", str, Boolean.valueOf(z16)));
        }
        return troopNameFromSP;
    }

    public static String X() {
        return f307398h;
    }

    public static String Y(QQAppInterface qQAppInterface, DiscussionMemberInfo discussionMemberInfo) {
        String str;
        String str2 = discussionMemberInfo.memberUin;
        if (!TextUtils.isEmpty(discussionMemberInfo.inteRemark)) {
            str = discussionMemberInfo.inteRemark;
        } else {
            str = discussionMemberInfo.memberName;
        }
        if (TextUtils.isEmpty(str)) {
            return G(qQAppInterface, discussionMemberInfo.memberUin);
        }
        return str;
    }

    private static String Z(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, String str) {
        if (dVar.r() != null && dVar.r().length() > 0) {
            return dVar.r();
        }
        if (str == null || str.length() <= 0) {
            if (dVar.p() != null && dVar.p().length() > 0) {
                return dVar.p();
            }
            return dVar.x();
        }
        return str;
    }

    public static String a0(Friends friends) {
        return b0(((IFriendDataTransApi) QRoute.api(IFriendDataTransApi.class)).friendsConvertToOnlineStatusInfo(friends, true));
    }

    public static String b0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        String str;
        if (cVar == null) {
            return "";
        }
        int a16 = com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z());
        if (a16 == 4 && !com.tencent.mobileqq.friend.status.b.d(cVar.z(), cVar.E(), cVar.u(), cVar.c0())) {
            str = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getStatusNamePlusNetWorkType(com.tencent.mobileqq.activity.contacts.friend.a.a(cVar.E(), cVar.z(), cVar.C()));
        } else {
            str = null;
        }
        String c06 = cVar.c0();
        if (a16 == 4 && CustomOnlineStatusManager.Utils.m(cVar.t()) && !TextUtils.isEmpty(cVar.s())) {
            c06 = cVar.s();
        }
        if (str != null && !TextUtils.isEmpty(c06)) {
            return c06 + str;
        }
        return c06;
    }

    public static void c(QQAppInterface qQAppInterface, String str, String str2) {
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addUinByPhoneNum(str, str2);
        }
    }

    public static String c0(QQAppInterface qQAppInterface, final String str, String str2, int i3, final Function1<String, Unit> function1) {
        if (i3 == 1) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(str2, str, "ContactUtils-team", new Function1() { // from class: com.tencent.mobileqq.utils.ab
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w06;
                    w06 = ac.w0(Function1.this, str, (TroopMemberNickInfo) obj);
                    return w06;
                }
            });
        } else {
            function1.invoke(n(qQAppInterface, str2, str));
        }
        return str;
    }

    public static void d() {
        f307398h = null;
    }

    public static float d0(String str) {
        if (!TextUtils.isEmpty(str)) {
            f307399i.setTextSize(36.0f);
            return f307399i.measureText(str) / 36.0f;
        }
        return 1.0f;
    }

    private static int e(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        return bArr.length;
    }

    public static String e0(QQAppInterface qQAppInterface, String str, String str2, int i3, long j3) {
        String str3;
        if (i3 == 2) {
            str3 = n(qQAppInterface, str2, str);
        } else {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, str, null, "ContactUtils-dis", j3);
            if (troopMemberInfoSync != null) {
                str3 = troopMemberInfoSync.nickInfo.getShowName();
            } else {
                str3 = "";
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        return str;
    }

    public static String f(AppInterface appInterface, String str) {
        if (str == null) {
            return null;
        }
        String property = appInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + str);
        if (TextUtils.isEmpty(property)) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
            if (friendsSimpleInfoWithUid != null) {
                property = friendsSimpleInfoWithUid.p();
            }
        }
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        return str;
    }

    public static String g(AppRuntime appRuntime, String str, boolean z16) {
        IPublicAccountDataManager iPublicAccountDataManager;
        PublicAccountInfo publicAccountInfo;
        Card r16;
        String p16;
        if (str == null || "".equals(str)) {
            return "";
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        FriendsManager friendsManager = (FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsSimpleInfoWithUid != null) {
            if (friendsSimpleInfoWithUid.B()) {
                if (friendsSimpleInfoWithUid.r() != null && !"".equals(friendsSimpleInfoWithUid.r())) {
                    p16 = friendsSimpleInfoWithUid.r();
                } else {
                    p16 = friendsSimpleInfoWithUid.p();
                }
            } else {
                p16 = friendsSimpleInfoWithUid.p();
            }
            if (v0(p16, str)) {
                return p16;
            }
        }
        String F = F(appRuntime, str);
        if (v0(F, str)) {
            return F;
        }
        if (friendsManager != null && !v0(F, str) && (r16 = friendsManager.r(str)) != null) {
            F = r16.strNick;
            if (v0(F, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getBuddyName()", str, Boolean.valueOf(z16)));
                }
                return F;
            }
        }
        if (!v0(F, str) && (iPublicAccountDataManager = (IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")) != null && (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) != null) {
            String str2 = publicAccountInfo.name;
            if (v0(str2, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getBuddyName()", str, Boolean.valueOf(z16)));
                }
                return str2;
            }
        }
        if (z16) {
            ((com.tencent.mobileqq.app.i) appRuntime.getManager(QQManagerFactory.CONTACT_FACADE)).a().d(str);
        }
        return str;
    }

    public static String g0(AppInterface appInterface, String str, boolean z16) {
        String str2;
        if (str == null || "".equals(str)) {
            return "";
        }
        String Q = Q(appInterface, str, 1);
        if (v0(Q, str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopDisplayName()", str, Boolean.valueOf(z16)));
            }
            return Q;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache != null) {
            str2 = troopInfoFromCache.getTroopDisplayName();
        } else {
            str2 = null;
        }
        if (!u0(str2)) {
            str2 = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopNameFromSP(appInterface.getApp(), str);
        }
        if (!u0(str2)) {
            if (z16) {
                ((com.tencent.mobileqq.app.i) appInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().f(str);
            }
            str2 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopDisplayName()", str, Boolean.valueOf(z16)));
        }
        return str2;
    }

    public static String h(AppRuntime appRuntime, String str, boolean z16) {
        Card card;
        String str2;
        String p16;
        if (str == null || "".equals(str)) {
            return "";
        }
        if (appRuntime == null) {
            return str;
        }
        FriendsManager friendsManager = (FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        if (friendsSimpleInfoWithUid != null && (p16 = friendsSimpleInfoWithUid.p()) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("FriendEntity getBuddyNickName()", str, Boolean.valueOf(z16)));
            }
            return p16;
        }
        if (friendsManager != null) {
            card = friendsManager.r(str);
        } else {
            card = null;
        }
        if (card != null && (str2 = card.strNick) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("FriendCard getBuddyNickName()", str, Boolean.valueOf(z16)));
            }
            return str2;
        }
        if (z16) {
            ((com.tencent.mobileqq.app.i) appRuntime.getManager(QQManagerFactory.CONTACT_FACADE)).a().d(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getBuddyNickName()", str, Boolean.valueOf(z16)));
        }
        return str;
    }

    public static String h0(AppInterface appInterface, String str) {
        TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null && k3.getTroopDisplayName() != null) {
            return k3.getTroopDisplayName();
        }
        return str;
    }

    private static String i(int i3, String str, String str2) {
        String str3 = "";
        if (i3 <= 0) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (str.length() != 0) {
            str3 = "\u3001";
        }
        sb5.append(str3);
        sb5.append(str2);
        String sb6 = sb5.toString();
        if (e(sb6) <= i3) {
            return sb6;
        }
        if (str.length() != 0) {
            str2 = "\u3001" + str2;
        }
        int e16 = i3 - e(str);
        StringBuilder sb7 = new StringBuilder();
        int i16 = 0;
        while (true) {
            if (i16 >= str2.length()) {
                break;
            }
            int codePointAt = str2.codePointAt(i16);
            int charCount = Character.charCount(codePointAt);
            i16 += charCount;
            sb7.appendCodePoint(codePointAt);
            if (e(sb7.toString()) > e16) {
                sb7.delete(sb7.length() - charCount, sb7.length());
                break;
            }
        }
        String sb8 = sb7.toString();
        if (!sb8.equals("\u3001")) {
            return str + sb8;
        }
        return str;
    }

    public static String i0(AppInterface appInterface, String str, String str2, String str3, TroopMemberInfo troopMemberInfo, boolean z16, Bundle bundle) {
        String str4;
        String str5;
        if (str != null && !"".equals(str) && str2 != null && !"".equals(str2) && str3 != null && !"".equals(str3)) {
            if (troopMemberInfo != null) {
                str4 = troopMemberInfo.nickInfo.getShowName();
            } else {
                str4 = null;
            }
            boolean v06 = v0(str4, str);
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str4));
            }
            if (v06) {
                return str4;
            }
            if (troopMemberInfo != null) {
                str5 = troopMemberInfo.troopnick;
                if (!u0(str5)) {
                    str5 = troopMemberInfo.friendnick;
                }
            } else {
                str5 = null;
            }
            if (!u0(str5)) {
                if (z16) {
                    ((com.tencent.mobileqq.app.i) appInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().g(str, str2, str3, bundle);
                }
                str5 = str;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str5));
            }
            return str5;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), bundle));
        }
        return "";
    }

    public static String j(AppInterface appInterface, String str) {
        String str2;
        long j3;
        String str3 = "";
        if (str == null || "".equals(str)) {
            return "";
        }
        if (TextUtils.equals(str, AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN)) {
            return BaseApplication.getContext().getString(R.string.ccw);
        }
        if (TextUtils.equals(str, AppConstants.MSG_BOX_YANZHI_UIN)) {
            return BaseApplication.getContext().getString(R.string.f171126cd1);
        }
        DateNickNameInfo D = ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).D(str);
        if (D != null) {
            str2 = D.nickName;
            j3 = D.lastUpdateTime;
        } else {
            str2 = null;
            j3 = 0;
        }
        if (str2 == null || Math.abs(System.currentTimeMillis() - j3) >= 86400000) {
            if (str2 != null) {
                str3 = str2;
            }
            ((com.tencent.mobileqq.app.i) appInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().e(str);
            return str3;
        }
        return str2;
    }

    @Deprecated
    public static String j0(AppInterface appInterface, String str, String str2, String str3, boolean z16, Bundle bundle) {
        String str4;
        String str5;
        if (str != null && !"".equals(str) && str2 != null && !"".equals(str2) && str3 != null && !"".equals(str3)) {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, str, null, "ContactUtils-getTroopNickName");
            if (troopMemberInfoSync != null) {
                str4 = troopMemberInfoSync.nickInfo.getShowName();
            } else {
                str4 = null;
            }
            boolean v06 = v0(str4, str);
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str4));
            }
            if (v06) {
                return str4;
            }
            if (troopMemberInfoSync != null) {
                str5 = troopMemberInfoSync.troopnick;
                if (!u0(str5)) {
                    str5 = troopMemberInfoSync.friendnick;
                }
            } else {
                str5 = null;
            }
            if (!u0(str5)) {
                if (z16) {
                    ((com.tencent.mobileqq.app.i) appInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().g(str, str2, str3, bundle);
                }
                str5 = str;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str5));
            }
            return str5;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), bundle));
        }
        return "";
    }

    private static String k(QQAppInterface qQAppInterface, String str, Map<String, DiscussionMemberInfo> map) {
        String str2 = "";
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && map != null && map.size() != 0) {
            j.c cVar = new j.c(qQAppInterface, str, qQAppInterface.getCurrentAccountUin());
            ArrayList arrayList = new ArrayList(map.values());
            while (arrayList.size() > 0) {
                DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) Collections.min(arrayList, cVar);
                arrayList.remove(discussionMemberInfo);
                str2 = i(48, str2, m(discussionMemberInfo, qQAppInterface));
                if (str2.length() >= 47) {
                    break;
                }
            }
            return str2;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactUtils", 2, " === getDiscussionCombinedName app is null or ownerUin is null or members is null or members size is 0 ====");
        }
        return "";
    }

    public static void k0(final AppInterface appInterface, final String str, final String str2, final String str3, final boolean z16, final Bundle bundle, @NonNull final com.tencent.mobileqq.troop.e eVar) {
        if (str != null && !"".equals(str) && str2 != null && !"".equals(str2) && str3 != null && !"".equals(str3)) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str2, str, false, null, "ContactUtils-nickname", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.utils.aa
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    ac.x0(str, str2, str3, z16, eVar, appInterface, bundle, troopMemberInfo);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), bundle));
        }
        eVar.a("");
    }

    public static String l(QQAppInterface qQAppInterface, String str, String str2) {
        String nickWithUid;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ContactUtils")) {
            DiscussionMemberInfo l3 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).l(str, str2);
            if (l3 != null) {
                nickWithUid = l3.inteRemark;
            } else {
                nickWithUid = "";
            }
        } else {
            nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "ContactUtils");
        }
        if (nickWithUid != null && nickWithUid.trim().length() != 0) {
            return nickWithUid;
        }
        return str2;
    }

    public static String l0(QQAppInterface qQAppInterface, String str) {
        String H = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).H(str);
        if (H == null) {
            return str;
        }
        return R(qQAppInterface, H, 1);
    }

    @Deprecated
    public static String m(DiscussionMemberInfo discussionMemberInfo, QQAppInterface qQAppInterface) {
        String str;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(discussionMemberInfo.memberUin);
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ContactUtils")) {
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(uidFromUin);
            str = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        } else {
            str = discussionMemberInfo.inteRemark;
        }
        if (TextUtils.isEmpty(str)) {
            str = discussionMemberInfo.memberName;
        }
        if (TextUtils.isEmpty(str)) {
            return discussionMemberInfo.memberUin;
        }
        return str;
    }

    public static String m0(AppRuntime appRuntime, String str) {
        IPhoneContactService iPhoneContactService = (IPhoneContactService) appRuntime.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null) {
            return "";
        }
        return iPhoneContactService.getUinByPhoneNum(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        boolean z16;
        String str3;
        DiscussionMemberInfo discussionMemberInfo;
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) baseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (str2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
                return "";
            }
            return "";
        }
        DiscussionInfo h16 = nVar.h(str);
        if (h16 != null && h16.isDiscussHrMeeting()) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2), "ContactUtils");
        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B() && !z16) {
            if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                return friendsSimpleInfoWithUid.r();
            }
            if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
                return friendsSimpleInfoWithUid.p();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
            }
            return str2;
        }
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        if (n3 != null && (discussionMemberInfo = n3.get(str2)) != null) {
            str3 = discussionMemberInfo.inteRemark;
            String str4 = discussionMemberInfo.memberName;
            if (TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(str4)) {
                    str3 = str4;
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.w("ContactUtils", 1, "getDiscussionMemberShowName, discussionShowName[" + com.tencent.mobileqq.util.aw.a(str3) + "], discussionUin[" + str + "], memberUin[" + str2 + "], bIsDiscHrMeeting[" + z16 + "]");
            }
            if (str3 == null && str3.trim().length() != 0) {
                return str3;
            }
            if (!z16) {
                return QAVHrMeeting.f();
            }
            if (friendsSimpleInfoWithUid != null) {
                return friendsSimpleInfoWithUid.p();
            }
            ((FriendListHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(str2, false);
            return str2;
        }
        str3 = null;
        if (QLog.isDevelopLevel()) {
        }
        if (str3 == null) {
        }
        if (!z16) {
        }
    }

    public static boolean n0(AppRuntime appRuntime) {
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("ContactUtils")) {
            if (dVar.n() != null && dVar.n().byteValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public static String o(Context context, DiscussionInfo discussionInfo) {
        String str;
        if (discussionInfo != null) {
            str = discussionInfo.discussionName;
        } else {
            str = "";
        }
        if (str == null || str.length() == 0) {
            return context.getResources().getString(R.string.as8);
        }
        return str;
    }

    public static boolean o0(String str) {
        if (Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static String p(QQAppInterface qQAppInterface, Context context, String str) {
        DiscussionInfo discussionInfo;
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (nVar != null) {
            discussionInfo = nVar.h(str);
        } else {
            discussionInfo = null;
        }
        return o(context, discussionInfo);
    }

    public static boolean p0(QQAppInterface qQAppInterface, String str) {
        DiscussionInfo h16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
        if (h16 != null) {
            return h16.isDiscussHrMeeting();
        }
        return false;
    }

    public static String q(QQAppInterface qQAppInterface, String str) {
        DiscussionInfo h16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
        if (h16 != null && !TextUtils.isEmpty(h16.discussionName)) {
            return h16.discussionName;
        }
        return null;
    }

    public static boolean q0(int i3) {
        if (i3 != 81 && i3 != 82 && i3 != 83 && i3 != 84 && i3 != 101 && i3 != 102 && i3 != 103 && i3 != 107 && i3 != 110 && i3 != 123 && i3 != 25 && i3 != 28 && i3 != 35 && i3 != 36 && i3 != 37 && i3 != 31 && i3 != 32 && i3 != 33 && i3 != 34 && i3 != 19) {
            return false;
        }
        return true;
    }

    public static String r(AppInterface appInterface, String str) {
        DiscussionInfo h16 = ((com.tencent.mobileqq.app.n) appInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
        if (h16 != null && !TextUtils.isEmpty(h16.discussionName)) {
            return h16.discussionName;
        }
        return str;
    }

    public static boolean r0(QQAppInterface qQAppInterface, DiscussionInfo discussionInfo) {
        String str;
        if (!t0(qQAppInterface, discussionInfo) && (str = discussionInfo.mCompareSpell) != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static String s(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        String str3 = null;
        if (i3 != 1 && i3 != 7 && i3 != 6 && i3 != 2 && i3 != 5) {
            dVar = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        } else {
            dVar = null;
        }
        switch (i3) {
            case 0:
                PhoneContact queryPhoneContactByUin = ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(str);
                if (dVar == null) {
                    str3 = g(qQAppInterface, str, true);
                    break;
                } else {
                    str3 = t(i16, str, dVar, queryPhoneContactByUin);
                    break;
                }
            case 1:
                if (i16 != 0 && i16 != 3) {
                    str3 = str;
                    break;
                } else {
                    TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, str, null, "ContactUtils-dis", 200L);
                    if (troopMemberInfoSync == null) {
                        str3 = "";
                        break;
                    } else {
                        str3 = troopMemberInfoSync.nickInfo.getShowName();
                        break;
                    }
                }
            case 2:
                str3 = n(qQAppInterface, str2, str);
                break;
            case 3:
                str3 = v(i16, str, dVar, ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(str));
                break;
            case 4:
                str3 = u(i16, str, dVar, ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(str));
                break;
            case 5:
            default:
                if (dVar != null && !TextUtils.isEmpty(dVar.p())) {
                    str3 = dVar.p();
                    break;
                }
                break;
            case 6:
                TroopInfo k3 = troopManager.k(str);
                if (k3 != null) {
                    str3 = k3.getTroopDisplayName();
                    break;
                }
                break;
            case 7:
                str3 = o(qQAppInterface.getApp(), nVar.h(str));
                break;
            case 8:
                str3 = R(qQAppInterface, str, 1008);
                break;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        return str3;
    }

    public static boolean s0(QQAppInterface qQAppInterface, long j3, String str) {
        if (f307392b == null) {
            f307392b = qQAppInterface.getApp().getString(R.string.i_u);
        }
        if ((((64 & j3) >>> 6) != 1 || ((j3 & 536870912) >>> 29) != 1) && str != null && !str.matches(f307392b) && str.length() != 0) {
            return false;
        }
        return true;
    }

    private static String t(int i3, String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, PhoneContact phoneContact) {
        String p16;
        if (i3 != 0 && i3 != 3) {
            return "";
        }
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.r())) {
                p16 = dVar.r();
            } else {
                p16 = dVar.p();
            }
            return p16;
        }
        return str;
    }

    public static boolean t0(QQAppInterface qQAppInterface, DiscussionInfo discussionInfo) {
        return s0(qQAppInterface, discussionInfo.DiscussionFlag, discussionInfo.discussionName);
    }

    private static String u(int i3, String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, PhoneContact phoneContact) {
        String p16;
        if (i3 != 0 && i3 != 3) {
            return "";
        }
        if (dVar != null && dVar.B()) {
            if (!TextUtils.isEmpty(dVar.r())) {
                p16 = dVar.r();
            } else {
                p16 = dVar.p();
            }
            return p16;
        }
        if (phoneContact != null) {
            return phoneContact.name;
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.p())) {
            return dVar.p();
        }
        return str;
    }

    private static boolean u0(String str) {
        if (str != null && !"".equals(str)) {
            return true;
        }
        return false;
    }

    private static String v(int i3, String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, PhoneContact phoneContact) {
        String p16;
        if (i3 != 0) {
            if (i3 != 3) {
                return "";
            }
            if (dVar != null && dVar.B()) {
                if (!TextUtils.isEmpty(dVar.r())) {
                    p16 = dVar.r();
                } else {
                    p16 = dVar.p();
                }
                return p16;
            }
            if (phoneContact != null) {
                return phoneContact.name;
            }
            if (dVar != null && !TextUtils.isEmpty(dVar.p())) {
                return dVar.p();
            }
            return str;
        }
        if (phoneContact != null) {
            return phoneContact.name;
        }
        return str;
    }

    public static boolean v0(String str, String str2) {
        if (u0(str) && !str.equals(str2) && str2 != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x002b. Please report as an issue. */
    public static int w(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return 1;
                }
                if (i3 != 3) {
                    if (i3 != 1008) {
                        if (i3 != 1009) {
                            if (i3 == 1020) {
                                return 1;
                            }
                            if (i3 != 1021) {
                                if (i3 != 3000) {
                                    if (i3 != 10002 && i3 != 10004 && i3 != 10019) {
                                        switch (i3) {
                                            case 1000:
                                                return 1;
                                            case 1001:
                                            case 1002:
                                            case 1003:
                                                break;
                                            case 1004:
                                                return 2;
                                            case 1005:
                                                break;
                                            case 1006:
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 1023:
                                                    case 1025:
                                                        break;
                                                    case 1024:
                                                        break;
                                                    default:
                                                        return -1;
                                                }
                                        }
                                    }
                                } else {
                                    return 7;
                                }
                            } else {
                                return 5;
                            }
                        }
                        return 4;
                    }
                    return 8;
                }
                return 3;
            }
            return 6;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit w0(Function1 function1, String str, TroopMemberNickInfo troopMemberNickInfo) {
        if (troopMemberNickInfo != null) {
            str = troopMemberNickInfo.getShowName(false, false);
        }
        return (Unit) function1.invoke(str);
    }

    public static String x(String str, float f16) {
        if (d0(str) > f16) {
            int max = Math.max(0, (int) (f16 - 3.0f));
            int i3 = max;
            while (max < str.length()) {
                if (d0(str.substring(0, max) + "\u2026") > f16) {
                    break;
                }
                i3 = max;
                max++;
            }
            return str.substring(0, i3) + "\u2026";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(String str, String str2, String str3, boolean z16, com.tencent.mobileqq.troop.e eVar, AppInterface appInterface, Bundle bundle, TroopMemberInfo troopMemberInfo) {
        String str4;
        String str5;
        if (troopMemberInfo != null) {
            str4 = troopMemberInfo.nickInfo.getShowName();
        } else {
            str4 = "";
        }
        boolean v06 = v0(str4, str);
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str4));
        }
        if (v06) {
            eVar.a(str4);
            return;
        }
        if (troopMemberInfo != null) {
            str5 = troopMemberInfo.troopnick;
            if (!u0(str5)) {
                str5 = troopMemberInfo.friendnick;
            }
        } else {
            str5 = null;
        }
        if (!u0(str5)) {
            if (z16) {
                ((com.tencent.mobileqq.app.i) appInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().g(str, str2, str3, bundle);
            }
            str5 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg("getTroopNickName()", str, str2, str3, Boolean.valueOf(z16), str5));
        }
        eVar.a(str5);
    }

    @NotNull
    public static String y(QQAppInterface qQAppInterface, String str) {
        String str2;
        PhoneContact queryPhoneContactByUin;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) != null) {
            str2 = queryPhoneContactByUin.name;
        } else {
            str2 = null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        if (friendsSimpleInfoWithUid != null) {
            return Z(friendsSimpleInfoWithUid, str2);
        }
        return str;
    }

    public static void y0(int i3) {
        String str;
        switch (i3) {
            case 1:
                str = "0X80068AA";
                break;
            case 2:
                str = "0X80068AB";
                break;
            case 3:
                str = "0X80068AC";
                break;
            case 4:
                str = "0X80068AD";
                break;
            case 5:
                str = "0X80068AE";
                break;
            case 6:
                str = "0X80068AF";
                break;
            case 7:
                str = "0X80068B0";
                break;
            case 8:
                str = "0X80068B1";
                break;
            default:
                str = null;
                break;
        }
        f307398h = str;
    }

    public static String z(QQAppInterface qQAppInterface, String str) {
        String str2;
        PhoneContact queryPhoneContactByUin;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactUtils");
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin("")) != null) {
            str2 = queryPhoneContactByUin.name;
        } else {
            str2 = null;
        }
        if (friendsSimpleInfoWithUid == null) {
            return "";
        }
        return D(friendsSimpleInfoWithUid, str2);
    }

    private static boolean z0(QQAppInterface qQAppInterface, String str, DiscussionInfo discussionInfo, Map<String, DiscussionMemberInfo> map) {
        if (discussionInfo != null && map != null && map.size() != 0) {
            discussionInfo.discussionName = k(qQAppInterface, discussionInfo.ownerUin, map);
            return true;
        }
        return false;
    }

    @Deprecated
    public static String f0(AppRuntime appRuntime, String str, String str2) {
        return str2;
    }
}
