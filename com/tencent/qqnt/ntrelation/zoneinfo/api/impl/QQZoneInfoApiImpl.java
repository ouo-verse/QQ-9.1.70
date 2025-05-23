package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J8\u0010\u0014\u001a\u00020\u00062\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0015j\b\u0012\u0004\u0012\u00020\n`\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J>\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00162\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0015j\b\u0012\u0004\u0012\u00020\n`\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016J:\u0010\u001c\u001a\u00020\u00062\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0015j\b\u0012\u0004\u0012\u00020\u0002`\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016J:\u0010\u001e\u001a\u00020\u00062\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0015j\b\u0012\u0004\u0012\u00020\b`\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/QQZoneInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "ntZoneDetailInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "", "zoneDetailInfoTransferExtensionInfo", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "ntZoneSimpleInfo", "", "uin", "uid", "friend2DetailInfo", "trace", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteZoneDetailInfo", "Lhx3/b;", "iQueryGeneralDataCallback", "getZoneDetailWithUid", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uidList", "uids", "getZoneSimpleInfoWithUid", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateZoneDetailInfo", "ntZoneSimpleInfoList", "updateZoneSimpleInfo", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQZoneInfoApiImpl implements IQQZoneInfoApi {
    public static final String DELETE_ZONE_INFO_TASK_TAG = "_DELETE_ZONE_INFO_TASK_TAG";
    public static final String GET_ZONE_INFO_TASK_TAG = "_GET_ZONE_INFO_TASK_TAG";
    public static final String TAG = "QQZoneInfoApiImpl";
    public static final String UPDATE_ZONE_INFO_TASK_TAG = "_UPDATE_ZONE_INFO_TASK_TAG";

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.ntrelation.zoneinfo.bean.a friend2DetailInfo(String uin, String uid, ExtensionInfo extensionInfo) {
        String str;
        String str2;
        com.tencent.qqnt.ntrelation.zoneinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.zoneinfo.bean.a(null, null, 0, 0L, null, false, null, 127, null);
        aVar.n(uin);
        aVar.m(uid);
        aVar.r(extensionInfo != null ? extensionInfo.feedType : 0);
        aVar.q(extensionInfo != null ? extensionInfo.feedTime : 0L);
        String str3 = "";
        if (extensionInfo == null || (str = extensionInfo.feedContent) == null) {
            str = "";
        }
        aVar.k(str);
        aVar.l(extensionInfo != null ? extensionInfo.feedHasPhoto : false);
        if (extensionInfo != null && (str2 = extensionInfo.feedPhotoUrl) != null) {
            str3 = str2;
        }
        aVar.p(str3);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zoneDetailInfoTransferExtensionInfo(com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, ExtensionInfo extensionInfo) {
        if (extensionInfo != null) {
            extensionInfo.feedType = ntZoneDetailInfo.j();
        }
        if (extensionInfo != null) {
            extensionInfo.feedTime = ntZoneDetailInfo.f();
        }
        if (extensionInfo != null) {
            extensionInfo.feedContent = ntZoneDetailInfo.b();
        }
        if (extensionInfo != null) {
            extensionInfo.feedHasPhoto = ntZoneDetailInfo.c();
        }
        if (extensionInfo == null) {
            return;
        }
        extensionInfo.feedPhotoUrl = ntZoneDetailInfo.e();
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void deleteZoneDetailInfo(String uid, String trace, hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iDeleteGeneralDataCallback) {
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.a(iDeleteGeneralDataCallback);
            QLog.i("LogUtil", 1, "deleteZoneDetailInfo " + trace + " app is null \n");
            return;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid == null || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e)) == null) {
            return;
        }
        CorountineFunKt.e(f16, "QQZoneInfoApiImpl_DELETE_ZONE_INFO_TASK_TAG", null, null, null, new QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1(peekAppRuntime, uinFromUid, iDeleteGeneralDataCallback, trace, null), 14, null);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(String uid, String trace, hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getZoneDetailWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> getZoneSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> arrayList = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            String uin = iRelationNTUinAndUidApi.getUinFromUid(uid);
            ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            arrayList.add(friend2DetailInfo(uin, uid, extensionInfo));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, String trace, hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(ntZoneDetailInfo, "ntZoneDetailInfo");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneSimpleInfo(ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> ntZoneSimpleInfoList, String trace, hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(ntZoneSimpleInfoList, "ntZoneSimpleInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> ntZoneSimpleInfoList, String trace, hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(ntZoneSimpleInfoList, "ntZoneSimpleInfoList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQZoneInfoApiImpl_UPDATE_ZONE_INFO_TASK_TAG", null, null, null, new QQZoneInfoApiImpl$updateZoneDetailInfo$1(peekAppRuntime, ntZoneSimpleInfoList, this, iUpdateGeneralDataCallback, null), 14, null);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(ArrayList<String> uidList, String trace, hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getZoneDetailWithUid " + trace + " app is null \n");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ArrayList arrayList = new ArrayList();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQZoneInfoApiImpl_GET_ZONE_INFO_TASK_TAG", null, null, null, new QQZoneInfoApiImpl$getZoneDetailWithUid$1(uidList, iRelationNTUinAndUidApi, iFriendExtensionService, this, iQueryGeneralDataCallback, trace, arrayList, null), 14, null);
        }
    }

    private final void zoneDetailInfoTransferExtensionInfo(com.tencent.qqnt.ntrelation.zoneinfo.bean.c ntZoneSimpleInfo, ExtensionInfo extensionInfo) {
        if (extensionInfo != null) {
            extensionInfo.feedType = ntZoneSimpleInfo.j();
        }
        if (extensionInfo != null) {
            extensionInfo.feedTime = ntZoneSimpleInfo.f();
        }
        if (extensionInfo != null) {
            extensionInfo.feedContent = ntZoneSimpleInfo.b();
        }
        if (extensionInfo != null) {
            extensionInfo.feedHasPhoto = ntZoneSimpleInfo.c();
        }
        if (extensionInfo == null) {
            return;
        }
        extensionInfo.feedPhotoUrl = ntZoneSimpleInfo.e();
    }
}
