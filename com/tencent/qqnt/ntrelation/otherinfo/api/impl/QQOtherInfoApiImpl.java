package com.tencent.qqnt.ntrelation.otherinfo.api.impl;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J0\u0010\u0011\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0016J*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/QQOtherInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/otherinfo/api/IQQOtherInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "iQueryGeneralDataCallback", "", "getOtherInfoWithUid", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "getOtherSimpleInfoWithUid", "ntOtherDetailInfoList", "Lhx3/c;", "updateCallback", "accurateUpdateNTOtherDetailInfo", "uid", "Lhx3/a;", "deleteCallback", "deleteNTOtherDetailInfo", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQOtherInfoApiImpl implements IQQOtherInfoApi {
    public static final String TAG = "QQOtherInfoApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTOtherDetailInfo$lambda$1(AppRuntime app, ArrayList ntOtherDetailInfoList, hx3.c cVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "$ntOtherDetailInfoList");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        Manager manager = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        FriendsManager friendsManager = (FriendsManager) manager;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ntOtherDetailInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = (com.tencent.qqnt.ntrelation.otherinfo.bean.a) it.next();
            if (aVar != null) {
                ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(aVar.j(), true);
                String j3 = aVar.j();
                if (extensionInfo == null) {
                    extensionInfo = new ExtensionInfo();
                    extensionInfo.uin = j3;
                }
                d dVar = d.f360189a;
                if (dVar.a(aVar, extensionInfo)) {
                    arrayList.add(extensionInfo);
                }
                SpecialCareInfo O = friendsManager.O(j3);
                if (O == null) {
                    O = new SpecialCareInfo();
                    O.uin = j3;
                }
                if (dVar.b(aVar, O)) {
                    arrayList2.add(O);
                }
            }
        }
        boolean saveExtensionInfoList = arrayList.isEmpty() ^ true ? iFriendExtensionService.saveExtensionInfoList(arrayList) : false;
        if (!arrayList2.isEmpty()) {
            friendsManager.i(arrayList2);
        }
        if (cVar == null) {
            return;
        }
        if (saveExtensionInfoList) {
            responseData.d(0);
            responseData.e(ntOtherDetailInfoList);
        } else {
            responseData.d(-1);
        }
        cVar.onUpdateResult(responseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void deleteNTOtherDetailInfo$lambda$3$lambda$2(AppRuntime app, String it, hx3.a aVar, Ref.ObjectRef responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        ((IFriendExtensionService) runtimeService).deleteExtensionInfo(it);
        if (aVar != null) {
            aVar.a((com.tencent.qqnt.ntrelation.friendsinfo.bean.e) responseData.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOtherInfoWithUid$lambda$0(ArrayList uids, IRelationNTUinAndUidApi relationNTUinAndUidApi, IFriendExtensionService iFriendExtensionService, IFriendDataService iFriendDataService, String str, ArrayList result, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, hx3.b iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uids, "$uids");
        Intrinsics.checkNotNullParameter(relationNTUinAndUidApi, "$relationNTUinAndUidApi");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        Iterator it = uids.iterator();
        while (it.hasNext()) {
            String uinFromUid = relationNTUinAndUidApi.getUinFromUid((String) it.next());
            ExtensionInfo extensionInfo = iFriendExtensionService != null ? iFriendExtensionService.getExtensionInfo(uinFromUid) : null;
            Friends friend = iFriendDataService != null ? iFriendDataService.getFriend(uinFromUid, true) : null;
            if (friend == null) {
                QLog.e(TAG, 1, str + " getOtherInfoWithUid is error! friends is invalid!");
            } else {
                com.tencent.qqnt.ntrelation.otherinfo.bean.a a16 = com.tencent.relation.common.nt.help.a.INSTANCE.a(friend, extensionInfo);
                if (a16 != null) {
                    result.add(a16);
                }
            }
        }
        responseData.e(result);
        iQueryGeneralDataCallback.onQueryResult(responseData);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void accurateUpdateNTOtherDetailInfo(final ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherDetailInfoList, String trace, final hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.a> updateCallback) {
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "ntOtherDetailInfoList");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                QQOtherInfoApiImpl.accurateUpdateNTOtherDetailInfo$lambda$1(AppRuntime.this, ntOtherDetailInfoList, updateCallback, eVar);
            }
        }, 32, null, false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void deleteNTOtherDetailInfo(String uid, String trace, final hx3.a<com.tencent.qqnt.ntrelation.otherinfo.bean.a> deleteCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQOtherInfoApiImpl.deleteNTOtherDetailInfo$lambda$3$lambda$2(AppRuntime.this, uinFromUid, deleteCallback, objectRef);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void getOtherInfoWithUid(final ArrayList<String> uids, final String trace, final hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        if (peekAppRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, trace + " getOtherInfoWithUid app == null");
            }
            eVar.d(-1);
            iQueryGeneralDataCallback.onQueryResult(eVar);
            return;
        }
        final IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        final IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        final ArrayList arrayList = new ArrayList();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                QQOtherInfoApiImpl.getOtherInfoWithUid$lambda$0(uids, iRelationNTUinAndUidApi, iFriendExtensionService, iFriendDataService, trace, arrayList, eVar, iQueryGeneralDataCallback);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> getOtherSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        Boolean bool;
        Number number;
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, trace + " getOtherSimpleInfoWithUid app == null");
            }
            return null;
        }
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            String uin = iRelationNTUinAndUidApi.getUinFromUid(uid);
            Intrinsics.checkNotNull(iFriendExtensionService);
            ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
            com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(null, null, 3, null);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            cVar.t(uid);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            cVar.u(uin);
            if (extensionInfo != null) {
                bool = Boolean.valueOf(extensionInfo.isAioShortcutBarOpen);
            } else {
                bool = Boolean.TRUE;
            }
            cVar.n(bool);
            cVar.o(extensionInfo != null ? extensionInfo.colorRingId : 0L);
            cVar.r(extensionInfo != null ? extensionInfo.isSharingLocation : 0);
            if (extensionInfo != null) {
                number = Integer.valueOf(extensionInfo.friendRingId);
            } else {
                number = 0L;
            }
            cVar.p(number.longValue());
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
