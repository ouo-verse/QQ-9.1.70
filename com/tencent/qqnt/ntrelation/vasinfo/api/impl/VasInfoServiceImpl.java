package com.tencent.qqnt.ntrelation.vasinfo.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J>\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016J*\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J:\u0010\u0019\u001a\u00020\t2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J0\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J*\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eH\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/impl/VasInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IVasInfoService;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "Lkx3/a;", "ntVasDetailInfo", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "ntVasSimpleInfo", "", "simpleInfo2DetailInfo", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "getVasSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "queryCallback", "changeData", "Lhx3/c;", "updateCallback", "accurateUpdateVasSimpleInfo", "changeDataList", "iQueryGeneralDataCallback", "getVasInfoWithUid", "getControlGroupVasInfoWithUid", "Lhx3/a;", "deleteCallback", "deleteVasDetailInfo", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasInfoApi;", "isNew", "Z", "()Z", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class VasInfoServiceImpl implements IVasInfoService {

    @NotNull
    public static final String TAG = "VasInfoServiceImpl";

    @NotNull
    private IQQVasInfoApi absApiImpl = new NTVasInfoApiImpl();
    private final boolean isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();

    private final IQQVasInfoApi getAbsServiceImpl() {
        IQQVasInfoApi iQQVasInfoApi;
        String str;
        IQQVasInfoApi iQQVasInfoApi2 = this.absApiImpl;
        if (iQQVasInfoApi2 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQVasInfoApi2 instanceof NTVasInfoApiImpl)) {
                return iQQVasInfoApi2;
            }
            if (!z16 && !(iQQVasInfoApi2 instanceof NTVasInfoApiImpl)) {
                return iQQVasInfoApi2;
            }
        }
        if (this.isNew) {
            iQQVasInfoApi = new NTVasInfoApiImpl();
        } else {
            iQQVasInfoApi = (IQQVasInfoApi) a.INSTANCE.a(IQQVasInfoApi.class);
        }
        this.absApiImpl = iQQVasInfoApi;
        if (iQQVasInfoApi != null) {
            str = iQQVasInfoApi.getClass().getName();
        } else {
            str = null;
        }
        QLog.d(TAG, 1, "getFriendsSimpleInfo abServiceImpl is " + str);
        return this.absApiImpl;
    }

    private final IQQVasInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTVasInfoApiImpl();
        }
        return (IQQVasInfoApi) a.INSTANCE.a(IQQVasInfoApi.class);
    }

    private final void simpleInfo2DetailInfo(kx3.a ntVasDetailInfo, NTVasSimpleInfo ntVasSimpleInfo) {
        boolean z16;
        ntVasDetailInfo.l0(ntVasSimpleInfo.qqVipInfo);
        ntVasDetailInfo.n0(ntVasSimpleInfo.superVipInfo);
        ntVasDetailInfo.f0(ntVasSimpleInfo.namePlateOfKingGameId);
        ntVasDetailInfo.g0(ntVasSimpleInfo.namePlateOfKingLoginTime);
        ntVasDetailInfo.d0(ntVasSimpleInfo.namePlateOfKingDan);
        Boolean bool = ntVasSimpleInfo.namePlateOfKingDanDisplatSwitch;
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        ntVasDetailInfo.e0(z16);
        ntVasDetailInfo.O(ntVasSimpleInfo.bigClubInfo);
        ntVasDetailInfo.Z(ntVasSimpleInfo.gameCardId);
        ntVasDetailInfo.i0(ntVasSimpleInfo.nameplateVipType);
        ntVasDetailInfo.a0(ntVasSimpleInfo.grayNameplateFlag);
        ntVasDetailInfo.m0(ntVasSimpleInfo.superQqInfo);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void accurateUpdateVasSimpleInfo(@NotNull NTVasSimpleInfo changeData, @Nullable String trace, @Nullable c<NTVasSimpleInfo> updateCallback) {
        Intrinsics.checkNotNullParameter(changeData, "changeData");
        accurateUpdateVasSimpleInfo(new ArrayList<>(Collections.singletonList(changeData)), trace, updateCallback);
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNTLogOpen()) {
            QLog.e("VasDataConvertUtil", 1, "trace " + trace + " updateVasDetailInfo " + changeData + " " + QLog.getStackTraceString(new Throwable()));
        }
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void deleteVasDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<kx3.a> deleteCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteVasDetailInfo(uid, trace, deleteCallback);
        getReverseServiceImpl().deleteVasDetailInfo(uid, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void getControlGroupVasInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getReverseServiceImpl().getVasInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void getVasInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            lx3.a.f415742a.a(uid, trace, iQueryGeneralDataCallback);
        }
        getAbsServiceImpl().getVasInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    @Nullable
    public ArrayList<NTVasSimpleInfo> getVasSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        if (uids.size() > Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        return getAbsServiceImpl().getVasSimpleInfoWithUid(uids, trace);
    }

    /* renamed from: isNew, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void getVasInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getVasInfoWithUid(uid, false, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void accurateUpdateVasSimpleInfo(@NotNull ArrayList<NTVasSimpleInfo> changeDataList, @Nullable String trace, @Nullable c<NTVasSimpleInfo> updateCallback) {
        Intrinsics.checkNotNullParameter(changeDataList, "changeDataList");
        getAbsServiceImpl().accurateUpdateVasDetailInfo(changeDataList, trace, updateCallback);
        getReverseServiceImpl().accurateUpdateVasDetailInfo(changeDataList, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    @Nullable
    public NTVasSimpleInfo getVasSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<NTVasSimpleInfo> vasSimpleInfoWithUid = getVasSimpleInfoWithUid(arrayList, trace);
        if (vasSimpleInfoWithUid == null || vasSimpleInfoWithUid.size() == 0) {
            return null;
        }
        return vasSimpleInfoWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService
    public void getVasSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<NTVasSimpleInfo> queryCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        if (isObserver) {
            lx3.a.f415742a.b(uid, trace, queryCallback);
        }
        NTVasSimpleInfo vasSimpleInfoWithUid = getVasSimpleInfoWithUid(uid, trace);
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
        if (vasSimpleInfoWithUid != null) {
            arrayList.add(vasSimpleInfoWithUid);
        }
        e<NTVasSimpleInfo> eVar = new e<>();
        eVar.e(arrayList);
        queryCallback.onQueryResult(eVar);
    }
}
