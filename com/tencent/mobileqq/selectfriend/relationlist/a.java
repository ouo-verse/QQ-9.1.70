package com.tencent.mobileqq.selectfriend.relationlist;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u0003H\u0002J0\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J>\u0010\u0019\u001a\u00020\u00182\u001a\u0010\u0015\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0013j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020\u000b\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/a;", "", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUsers", "", "isShowRecentChatList", "isMatchFriendUserList", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "forwardOption", "shouldShowGuild", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "b", "d", "list", "f", "", "guildId", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "recentList", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "e", "recentUser", h.F, "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "ntSimpleInfo", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "l", "Lcom/tencent/mobileqq/data/PhoneContact;", "phoneContact", "j", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "k", "sharedNode", "g", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f285557a = new a();

    a() {
    }

    private final boolean a(String guildId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        return !((IGPSService) runtimeService).isGuildMember(guildId);
    }

    @JvmStatic
    public static final List<SharedNode> b(List<RecentUser> recentUsers, boolean isShowRecentChatList, boolean isMatchFriendUserList, ForwardBaseOption forwardOption, boolean shouldShowGuild) {
        ArrayList<RecentUser> arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(recentUsers, "recentUsers");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.i("DataConvertUtil", 1, "convertRecentUserToShareNode app is null");
            return new ArrayList();
        }
        if (isShowRecentChatList) {
            List<RecentUser> f16 = f285557a.f(recentUsers, isMatchFriendUserList, forwardOption);
            arrayList = f16 == null ? new ArrayList<>() : new ArrayList<>(f16);
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            a aVar = f285557a;
            aVar.e(arrayList, qQAppInterface, forwardOption, shouldShowGuild);
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(qQAppInterface)) {
                arrayList.add(0, aVar.d());
            }
        }
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(f285557a.h((RecentUser) it.next()));
            }
            return arrayList2;
        }
        return new ArrayList();
    }

    private final RecentUser d() {
        RecentUser recentUser = new RecentUser(AppConstants.DATALINE_NEW_VERSION_UIN, 0);
        recentUser.displayName = HardCodeUtil.qqStr(R.string.f187533u9);
        return recentUser;
    }

    public final void e(ArrayList<RecentUser> recentList, QQAppInterface app, ForwardBaseOption forwardOption, boolean shouldShowGuild) {
        Set set;
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(app, "app");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator<RecentUser> it = recentList.iterator();
        while (it.hasNext()) {
            RecentUser next = it.next();
            Intrinsics.checkNotNull(next);
            if (next.lFlag == 16 || next.getType() == 10005) {
                arrayList.add(next);
            }
            if (next.getType() == 1038) {
                arrayList.add(next);
            }
            if (TextUtils.equals(next.uin, "256111111111111111") || TextUtils.equals(next.uin, "1111111111111111FFFFFFFFFFFFFFFF")) {
                arrayList.add(next);
            }
            if (TextUtils.equals(next.uin, "256111111111111112")) {
                arrayList.add(next);
            }
            if (next.getType() == 1046) {
                arrayList.add(next);
            }
            if (next.getType() == 10019) {
                arrayList.add(next);
            }
            if (TextUtils.equals(next.uin, com.tencent.mobileqq.filemanager.fileassistant.util.h.g(app))) {
                arrayList.add(next);
            }
            if (TextUtils.equals(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, next.uin) || next.getType() == 8111 || next.getType() == 8112 || next.getType() == 8113 || next.getType() == 10007 || next.getType() == 10015) {
                arrayList.add(next);
            }
            if (next.getType() == 10014) {
                if (!shouldShowGuild) {
                    arrayList.add(next);
                } else {
                    IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
                    IGPSService iGPSService = (IGPSService) runtimeService;
                    IGProChannelInfo channelInfo = iGPSService.getChannelInfo(next.uin);
                    if (TextUtils.isEmpty(next.troopUin) && channelInfo != null) {
                        QLog.w("DataConvertUtil", 1, "filterRecentList guild troopUin isEmpty");
                        next.troopUin = channelInfo.getGuildId();
                    }
                    if (iGPSService.getGuildInfo(next.troopUin) == null || channelInfo == null || channelInfo.getType() != 1) {
                        arrayList.add(next);
                    }
                }
            }
            if (next.getType() == 10027) {
                String str = next.uin;
                Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
                if (a(str)) {
                    arrayList.add(next);
                }
            }
            if (next.getType() == 1) {
                Manager manager = app.getManager(QQManagerFactory.TROOP_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
                TroopInfo k3 = ((TroopManager) manager).k(next.uin);
                if (k3 == null || !k3.hadJoinTroop()) {
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("refreshRecentList, filter troop, recentUser.troopUin =");
                        sb5.append(next.troopUin);
                        sb5.append(",recentUser.uin = ");
                        sb5.append(next.uin);
                        sb5.append(",groupStatus =");
                        sb5.append(k3 != null ? k3.groupStatus : null);
                        QLog.i("DataConvertUtil", 4, sb5.toString());
                    }
                    arrayList.add(next);
                }
            }
            if (next.getType() == 0) {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next.uin.toString());
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                hashMap.put(uid, next);
            }
            if (forwardOption != null && !forwardOption.allowRecentUser(next)) {
                arrayList.add(next);
            }
            if (!((ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class)).shouldAddToList(next, true)) {
                arrayList.add(next);
            }
        }
        if (!hashMap.isEmpty()) {
            Map<String, Boolean> isFriends = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriends("DataConvertUtil", new ArrayList<>(hashMap.keySet()));
            for (String str2 : isFriends.keySet()) {
                if (Intrinsics.areEqual(Boolean.FALSE, isFriends.get(str2)) && hashMap.get(str2) != null) {
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("refreshRecentList, filter deleted friend, uin = ");
                        Object obj = hashMap.get(str2);
                        Intrinsics.checkNotNull(obj);
                        sb6.append(((RecentUser) obj).uin);
                        QLog.i("DataConvertUtil", 4, sb6.toString());
                    }
                    arrayList.add(hashMap.get(str2));
                }
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        recentList.removeAll(set);
    }

    public final ResultRecord g(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        ResultRecord resultRecord = new ResultRecord();
        Object bizData = sharedNode.getBizData();
        if (bizData instanceof ResultRecord) {
            return (ResultRecord) bizData;
        }
        boolean z16 = false;
        if (bizData instanceof RecentUser) {
            resultRecord.uin = sharedNode.getKey();
            resultRecord.name = sharedNode.getTitle();
            RecentUser recentUser = (RecentUser) bizData;
            resultRecord.uinType = recentUser.getType();
            int type = recentUser.getType();
            resultRecord.type = type;
            resultRecord.groupUin = recentUser.troopUin;
            resultRecord.isNewTroop = type == 1 && !TroopUtils.n(resultRecord.uin);
            resultRecord.guildId = recentUser.troopUin;
            resultRecord.source = 2;
        }
        if (bizData instanceof n.b) {
            n.b bVar = (n.b) bizData;
            resultRecord.uin = bVar.f187221c;
            RecentUser recentUser2 = bVar.f187222d;
            if (recentUser2 != null) {
                resultRecord.uinType = recentUser2.getType();
                resultRecord.type = bVar.f187222d.getType();
                String str = bVar.f187222d.troopUin;
                resultRecord.groupUin = str;
                resultRecord.guildId = str;
            }
            if (resultRecord.type == 1 && !TroopUtils.n(resultRecord.uin)) {
                z16 = true;
            }
            resultRecord.isNewTroop = z16;
            resultRecord.name = bVar.f187219a;
            resultRecord.source = 2;
        }
        return resultRecord;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01e9, code lost:
    
        if (r1 != 1020) goto L110;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0064. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SharedNode h(RecentUser recentUser) {
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        int i16;
        String g16;
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String uin = recentUser.uin;
        int type = recentUser.getType();
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopManager troopManager = (TroopManager) manager;
        TroopInfo k3 = troopManager.k(uin);
        int type2 = recentUser.getType();
        boolean z16 = false;
        if (type2 != 0) {
            if (type2 == 1) {
                if (k3 != null) {
                    str4 = k3.getTroopDisplayName();
                } else {
                    str4 = recentUser.displayName;
                }
                if (str4 != null) {
                    int length = str4.length() - 1;
                    int i17 = 0;
                    boolean z17 = false;
                    while (i17 <= length) {
                        boolean z18 = Intrinsics.compare((int) str4.charAt(!z17 ? i17 : length), 32) <= 0;
                        if (z17) {
                            if (!z18) {
                                break;
                            }
                            length--;
                        } else if (z18) {
                            i17++;
                        } else {
                            z17 = true;
                        }
                    }
                    if (!Intrinsics.areEqual(str4.subSequence(i17, length + 1).toString(), "")) {
                        str = str4;
                        i16 = 4;
                    }
                }
                str = uin;
                i16 = 4;
            } else if (type2 != 1000 && type2 != 1001) {
                if (type2 == 1008) {
                    IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
                    Object findPublicAccountInfo = ((IPublicAccountDataManager) runtimeService).findPublicAccountInfo(uin);
                    Intrinsics.checkNotNull(findPublicAccountInfo, "null cannot be cast to non-null type com.tencent.mobileqq.data.PublicAccountInfo");
                    str = ((PublicAccountInfo) findPublicAccountInfo).name;
                } else if (type2 != 1046) {
                    if (type2 == 3000) {
                        Manager manager2 = peekAppRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                        Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.app.DiscussionManager");
                        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) manager2;
                        DiscussionInfo h16 = nVar.h(uin);
                        if (h16 != null && !h16.isHidden()) {
                            String str5 = TextUtils.isEmpty(h16.discussionName) ? recentUser.displayName : h16.discussionName;
                            if (TextUtils.isEmpty(str5)) {
                                str5 = HardCodeUtil.qqStr(R.string.as8);
                            }
                            str = str5;
                            str3 = String.valueOf(nVar.q(uin));
                            i3 = 101;
                            str2 = "";
                            if (k3 == null) {
                            }
                            if (k3 != null) {
                            }
                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                            String valueOf = String.valueOf(recentUser.type);
                            if (str == null) {
                            }
                            return new SharedNode(uin, valueOf, str2, r4, i3, str, z16, false, recentUser, 128, null);
                        }
                    } else if (type2 == 6002) {
                        str = recentUser.displayName;
                        i16 = 104;
                    } else if (type2 != 10002 && type2 != 10004 && type2 != 10008 && type2 != 10010) {
                        if (type2 == 10014) {
                            IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IGPSService.class, "");
                            Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IG\u2026nt.MAIN\n                )");
                            IGPSService iGPSService = (IGPSService) runtimeService2;
                            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(recentUser.troopUin);
                            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(uin);
                            if (guildInfo != null && channelInfo != null) {
                                str = guildInfo.getGuildName() + QbAddrData.DATA_SPLITER + channelInfo.getChannelName();
                            }
                            String str6 = recentUser.troopUin;
                            if (str6 == null) {
                                str6 = "";
                            }
                            str2 = str6;
                            str3 = "";
                            i3 = 1;
                            if (k3 == null) {
                                z16 = true;
                            }
                            if (k3 != null) {
                            }
                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                            String valueOf2 = String.valueOf(recentUser.type);
                            if (str == null) {
                            }
                            return new SharedNode(uin, valueOf2, str2, r4, i3, str, z16, false, recentUser, 128, null);
                        }
                        if (type2 != 10027) {
                            switch (type2) {
                                case 1003:
                                case 1004:
                                case 1005:
                                    break;
                                case 1006:
                                    String m06 = ac.m0(peekAppRuntime, uin);
                                    IRuntimeService runtimeService3 = peekAppRuntime.getRuntimeService(IPhoneContactService.class, "");
                                    Intrinsics.checkNotNullExpressionValue(runtimeService3, "app.getRuntimeService<IP\u2026nt.MAIN\n                )");
                                    PhoneContact queryContactByCodeNumber = ((IPhoneContactService) runtimeService3).queryContactByCodeNumber(uin);
                                    if (queryContactByCodeNumber == null) {
                                        if (m06 == null) {
                                            str = uin;
                                            i16 = 11;
                                            break;
                                        } else {
                                            g16 = ac.g(peekAppRuntime, m06, true);
                                        }
                                    } else {
                                        g16 = queryContactByCodeNumber.name;
                                    }
                                    str = g16;
                                    i16 = 11;
                                default:
                                    switch (type2) {
                                        case 1021:
                                            str = ac.g(peekAppRuntime, uin, true);
                                            break;
                                    }
                            }
                            if (k3 == null && k.l(peekAppRuntime, uin)) {
                                z16 = true;
                            }
                            String valueOf3 = k3 != null ? String.valueOf(k3.getMemberNumClient()) : str3;
                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                            String valueOf22 = String.valueOf(recentUser.type);
                            if (str == null) {
                                str = "";
                            }
                            return new SharedNode(uin, valueOf22, str2, valueOf3, i3, str, z16, false, recentUser, 128, null);
                        }
                        IRuntimeService runtimeService4 = peekAppRuntime.getRuntimeService(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService4, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
                        IGProGuildInfo guildInfo2 = ((IGPSService) runtimeService4).getGuildInfo(recentUser.uin);
                        str = guildInfo2 != null ? guildInfo2.getGuildName() : null;
                        i16 = 117;
                    }
                } else {
                    str = recentUser.displayName;
                    i16 = 202;
                }
                str3 = "";
                str2 = str3;
                i3 = 1;
                if (k3 == null) {
                }
                if (k3 != null) {
                }
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                String valueOf222 = String.valueOf(recentUser.type);
                if (str == null) {
                }
                return new SharedNode(uin, valueOf222, str2, valueOf3, i3, str, z16, false, recentUser, 128, null);
            }
            i3 = i16;
            str3 = "";
            str2 = str3;
            if (k3 == null) {
            }
            if (k3 != null) {
            }
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            String valueOf2222 = String.valueOf(recentUser.type);
            if (str == null) {
            }
            return new SharedNode(uin, valueOf2222, str2, valueOf3, i3, str, z16, false, recentUser, 128, null);
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.c(0);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        aVar.d(uid);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        if (type != 1000) {
            if (type == 1004) {
                if (!(peekAppRuntime instanceof QQAppInterface)) {
                    QLog.i("DataConvertUtil", 1, "getKeyFromRecentUser fail because app is not QQAppInterface");
                } else {
                    nameWithConfig = ac.n((BaseQQAppInterface) peekAppRuntime, recentUser.troopUin, uin);
                }
            }
            if (nameWithConfig != null || Intrinsics.areEqual("", nameWithConfig)) {
                nameWithConfig = ac.g(peekAppRuntime, uin, true);
            }
            str = (!TextUtils.isEmpty(nameWithConfig) || ((peekAppRuntime instanceof QQAppInterface) && Intrinsics.areEqual(nameWithConfig, com.tencent.mobileqq.filemanager.fileassistant.util.h.g((BaseQQAppInterface) peekAppRuntime)))) ? recentUser.displayName : nameWithConfig;
            str3 = "";
            str2 = str3;
            i3 = 1;
            if (k3 == null) {
            }
            if (k3 != null) {
            }
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            String valueOf22222 = String.valueOf(recentUser.type);
            if (str == null) {
            }
            return new SharedNode(uin, valueOf22222, str2, valueOf3, i3, str, z16, false, recentUser, 128, null);
        }
        String G = troopManager.G(recentUser.troopUin);
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i("DataConvertUtil", 1, "getTroopNickName fail because app is not QQAppInterface");
        } else {
            nameWithConfig = ac.j0((AppInterface) peekAppRuntime, uin, G, recentUser.troopUin, true, null);
        }
        if (nameWithConfig != null) {
        }
        nameWithConfig = ac.g(peekAppRuntime, uin, true);
        if (TextUtils.isEmpty(nameWithConfig)) {
        }
        str3 = "";
        str2 = str3;
        i3 = 1;
        if (k3 == null) {
        }
        if (k3 != null) {
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        String valueOf222222 = String.valueOf(recentUser.type);
        if (str == null) {
        }
        return new SharedNode(uin, valueOf222222, str2, valueOf3, i3, str, z16, false, recentUser, 128, null);
    }

    public final SharedNode i(com.tencent.qqnt.ntrelation.friendsinfo.bean.d ntSimpleInfo) {
        Intrinsics.checkNotNullParameter(ntSimpleInfo, "ntSimpleInfo");
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(ntSimpleInfo.getUid());
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        String x16 = ntSimpleInfo.x();
        if (nameWithConfig == null) {
            nameWithConfig = "";
        }
        return new SharedNode(x16, "0", null, "", 1, nameWithConfig, false, false, ntSimpleInfo, 132, null);
    }

    public final SharedNode j(PhoneContact phoneContact) {
        Intrinsics.checkNotNullParameter(phoneContact, "phoneContact");
        String str = phoneContact.mobileCode;
        Intrinsics.checkNotNullExpressionValue(str, "phoneContact.mobileCode");
        String str2 = phoneContact.name;
        if (str2 == null) {
            str2 = "";
        }
        return new SharedNode(str, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, null, "", 1, str2, false, false, phoneContact, 132, null);
    }

    public final SharedNode k(ResultRecord resultRecord) {
        Intrinsics.checkNotNullParameter(resultRecord, "resultRecord");
        String str = resultRecord.uin;
        Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
        String valueOf = String.valueOf(resultRecord.type);
        String str2 = resultRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "resultRecord.guildId");
        String str3 = resultRecord.name;
        Intrinsics.checkNotNullExpressionValue(str3, "resultRecord.name");
        return new SharedNode(str, valueOf, str2, "", 1, str3, false, false, resultRecord);
    }

    public final SharedNode l(RobotCoreInfo robotCoreInfo) {
        Intrinsics.checkNotNullParameter(robotCoreInfo, "robotCoreInfo");
        String valueOf = String.valueOf(robotCoreInfo.robotUin);
        String str = robotCoreInfo.name;
        if (str == null) {
            str = "";
        }
        return new SharedNode(valueOf, "0", null, "", 1, str, true, false, robotCoreInfo, 132, null);
    }

    private final List<RecentUser> f(List<RecentUser> list, boolean isMatchFriendUserList, ForwardBaseOption forwardOption) {
        List<RecentUser> forwardRecentList;
        if (isMatchFriendUserList) {
            return ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).getForwardRecentList();
        }
        return (forwardOption == null || (forwardRecentList = forwardOption.getForwardRecentList(list)) == null) ? new ArrayList() : forwardRecentList;
    }

    public static /* synthetic */ List c(List list, boolean z16, boolean z17, ForwardBaseOption forwardBaseOption, boolean z18, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z18 = false;
        }
        return b(list, z16, z17, forwardBaseOption, z18);
    }
}
