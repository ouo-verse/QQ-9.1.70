package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J:\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016J*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0016J \u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/QQIntimateInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "getIntimateSimpleInfoWithUid", "ntIntimateSimpleInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "", "accurateUpdateIntimateInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteIntimateInfo", "Lhx3/b;", "", "iQueryGeneralDataCallback", "getBindIntimateRelationshipFriendCount", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQIntimateInfoApiImpl implements IQQIntimateInfoApi {
    public static final String TAG = "QQIntimateInfoApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBindIntimateRelationshipFriendCount$lambda$5(FriendsManager friendsManager, hx3.b iQueryGeneralDataCallback, String str) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        int C = friendsManager.C();
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(C));
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
        QLog.i(TAG, 1, "getBindIntimateRelationshipFriendCount " + str + " count is  " + C + " \n");
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void accurateUpdateIntimateInfo(ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfo, String trace, hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "ntIntimateSimpleInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService2;
        Iterator<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> it = ntIntimateSimpleInfo.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a info = it.next();
            Friends friend = iFriendDataService != null ? iFriendDataService.getFriend(info.n(), true) : null;
            if (friend == null) {
                friend = new Friends();
                friend.uin = info.n();
            }
            ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(info.n(), true);
            if (extensionInfo == null) {
                extensionInfo = new ExtensionInfo();
                extensionInfo.uin = info.n();
            }
            a aVar = a.f360078a;
            Intrinsics.checkNotNullExpressionValue(info, "info");
            if (aVar.b(info, extensionInfo)) {
                iFriendExtensionService.saveExtensionInfo(extensionInfo);
            }
            if (aVar.a(info, friend)) {
                iFriendDataService.saveFriend(friend);
            }
        }
        e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar = new e<>();
        eVar.e(ntIntimateSimpleInfo);
        if (iUpdateGeneralDataCallback != null) {
            iUpdateGeneralDataCallback.onUpdateResult(eVar);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void deleteIntimateInfo(String uid, String trace, hx3.a<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iDeleteGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.a(iDeleteGeneralDataCallback);
            QLog.i("LogUtil", 1, "deleteIntimateInfo " + trace + " app is null \n");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        new ArrayList();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid != null) {
            IRuntimeService runtimeService3 = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService3, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
            ((IFriendExtensionService) runtimeService3).deleteExtensionInfo(uinFromUid);
            if (iDeleteGeneralDataCallback != null) {
                iDeleteGeneralDataCallback.a(new e<>());
            }
            QLog.i(TAG, 1, "getBindIntimateRelationshipFriendCount " + trace + " deleteIntimateInfo finish \n");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void getBindIntimateRelationshipFriendCount(final String trace, final hx3.b<Integer> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getBindIntimateRelationshipFriendCount " + trace + " app is null \n");
            return;
        }
        final FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getBindIntimateRelationshipFriendCount " + trace + " fmi is null \n");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.intimateinfo.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                QQIntimateInfoApiImpl.getBindIntimateRelationshipFriendCount$lambda$5(FriendsManager.this, iQueryGeneralDataCallback, trace);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> getIntimateSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        Friends friends;
        Boolean bool;
        Boolean bool2;
        String str;
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService2;
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            String uin = iRelationNTUinAndUidApi.getUinFromUid(uid);
            ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, false);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mutualmark_unshow", false) && extensionInfo != null) {
                ((com.tencent.mobileqq.mutualmark.info.a) extensionInfo.getBusinessData(com.tencent.mobileqq.mutualmark.info.a.class, new Object[0])).b(extensionInfo);
            }
            if (iFriendDataService == null || (friends = iFriendDataService.getFriend(uin, true)) == null) {
                friends = new Friends();
            }
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(null, null, 3, null);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            aVar.B(uin);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            aVar.A(uid);
            aVar.v(extensionInfo != null ? extensionInfo.intimate_type : 0);
            aVar.u(extensionInfo != null ? extensionInfo.intimate_level : 0);
            aVar.t(extensionInfo != null ? extensionInfo.intimate_chatDays : 0);
            aVar.w(extensionInfo != null ? extensionInfo.last_intimate_chatTime : 0L);
            if (extensionInfo != null) {
                bool = Boolean.valueOf(extensionInfo.isExtinguish);
            } else {
                bool = Boolean.FALSE;
            }
            aVar.r(bool);
            if (extensionInfo != null) {
                bool2 = Boolean.valueOf(extensionInfo.isListenTogetherOpen);
            } else {
                bool2 = Boolean.FALSE;
            }
            aVar.x(bool2);
            aVar.s(friends.iconFlag);
            if (extensionInfo == null || (str = extensionInfo.mutual_marks_store_json) == null) {
                str = "";
            }
            aVar.z(str);
            arrayList.add(aVar);
        }
        return arrayList;
    }
}
