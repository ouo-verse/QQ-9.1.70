package com.tencent.mobileqq.pymk.api.impl;

import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.pymk.api.a;
import com.tencent.mobileqq.pymk.api.b;
import com.tencent.mobileqq.pymk.api.c;
import com.tencent.mobileqq.pymk.qzone.PYMKMediaUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.troop.findtroop.TabRecommendPB$PersonExtraInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J(\u0010#\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!H\u0016J2\u0010&\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J<\u0010,\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022$\u0010+\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u000f0(H\u0016JD\u0010,\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022$\u0010+\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u000f0(H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020$H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020$H\u0016J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\rH\u0016J\u0018\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020\u000fH\u0016R\u0014\u0010:\u001a\u00020$8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/impl/QQRecommendFriendApiImpl;", "Lcom/tencent/mobileqq/pymk/api/IQQRecommendFriendApi;", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "getLocalRecommendData", "", "dataSource", "Lcom/tencent/mobileqq/data/PYMKBizEntryInfo;", "getBizEntryInfo", "Lkotlin/Pair;", "getTotalCountAndBizToShow", "", "type", "", "needRefresh", "", "setBizEntryClose", "(ILjava/lang/Long;Z)V", "setBizEntryCartonShow", "(ILjava/lang/Long;)V", "Lcom/tencent/mobileqq/pymk/api/c;", "getMayKnowDataSet", "Lcom/tencent/mobileqq/data/QZoneInfo;", "getQZoneInfo", "Lcom/tencent/mobileqq/pymk/api/a;", "listener", "addListener", "removeListener", "fetchRecommendDataRemote", "fetchTop2RecommendDataRemoteForce", "fetchRecommendDataRemoteForceAll", "isForce", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterUins", "fetchRecommendDataRemoteWithFilter", "", "eTag", "fetchRecommendWithFilterAETag", "uins", "Lkotlin/Function2;", "", "Ltencent/im/troop/findtroop/TabRecommendPB$PersonExtraInfo;", "block", "fetchQZoneExtraInfo", "uin", "removeRecommendData", "traceId", "saveTraceId", "getTraceId", "pymkTestSwitch", "needShow", "setPymkTestSwitch", "itemSize", "setTimeStampAndResort", "Lcom/tencent/mobileqq/pymk/api/b;", "getPYMKMediaUtil", "removeAllPymkData", "KEY_NEED_SHOW_REQ_TOAST", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQRecommendFriendApiImpl implements IQQRecommendFriendApi {
    private final String KEY_NEED_SHOW_REQ_TOAST = "qq_need_show_toast";

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void addListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MayKnowPersonRepositoryForDifSource.D(listener, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchQZoneExtraInfo(List<Long> uins, Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> block) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(block, "block");
        MayKnowPersonRepositoryForDifSource.I(1, uins, block);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchRecommendDataRemote() {
        MayKnowPersonRepositoryForDifSource.K(false, null, null, 0, 15, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchRecommendDataRemoteForceAll() {
        boolean pYMKSetting = ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getPYMKSetting();
        List<MayKnowRecommend> O = MayKnowPersonRepositoryForDifSource.O(1);
        if ((O.isEmpty() && pYMKSetting) || ((true ^ O.isEmpty()) && !pYMKSetting)) {
            MayKnowPersonRepositoryForDifSource.K(true, null, null, 1, 6, null);
        }
        MayKnowPersonRepositoryForDifSource.K(false, null, null, 4, 6, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchRecommendDataRemoteWithFilter(boolean isForce, ArrayList<Long> filterUins) {
        Intrinsics.checkNotNullParameter(filterUins, "filterUins");
        MayKnowPersonRepositoryForDifSource.K(isForce, filterUins, null, 0, 12, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchRecommendWithFilterAETag(boolean isForce, ArrayList<Long> filterUins, String eTag) {
        Intrinsics.checkNotNullParameter(filterUins, "filterUins");
        MayKnowPersonRepositoryForDifSource.K(isForce, filterUins, eTag, 0, 8, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public List<PYMKBizEntryInfo> getBizEntryInfo(int dataSource) {
        return MayKnowPersonRepositoryForDifSource.M(dataSource);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public List<MayKnowRecommend> getLocalRecommendData() {
        return MayKnowPersonRepositoryForDifSource.P(0, 1, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public b getPYMKMediaUtil() {
        return new PYMKMediaUtil();
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public QZoneInfo getQZoneInfo() {
        return MayKnowPersonRepositoryForDifSource.T().get(1);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public Pair<Integer, List<PYMKBizEntryInfo>> getTotalCountAndBizToShow(int dataSource) {
        List<PYMKBizEntryInfo> M = MayKnowPersonRepositoryForDifSource.M(dataSource);
        ArrayList arrayList = new ArrayList();
        for (PYMKBizEntryInfo pYMKBizEntryInfo : M) {
            if (pYMKBizEntryInfo.isAbleToShow()) {
                arrayList.add(pYMKBizEntryInfo);
            }
        }
        return new Pair<>(Integer.valueOf(M.size()), arrayList);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public String getTraceId() {
        return MayKnowPersonRepositoryForDifSource.X(MayKnowPersonRepositoryForDifSource.f261398a, 0, 1, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public boolean pymkTestSwitch() {
        Intrinsics.checkNotNullExpressionValue(QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations"), "fromV2(MobileQQ.getConte\u2026), QMMKVFile.FILE_COMMON)");
        return false;
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void removeAllPymkData() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime != null ? peekAppRuntime.getManager(QQManagerFactory.CTENTRY_MNG) : null;
        if (manager instanceof CTEntryMng) {
            ((CTEntryMng) manager).w().k();
        }
        MayKnowPersonRepositoryForDifSource.f261398a.n0();
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void removeListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MayKnowPersonRepositoryForDifSource.p0(listener, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void removeRecommendData(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MayKnowPersonRepositoryForDifSource.q0(uin);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void saveTraceId(String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        MayKnowPersonRepositoryForDifSource.v0(MayKnowPersonRepositoryForDifSource.f261398a, traceId, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void setPymkTestSwitch(boolean needShow) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.getConte\u2026), QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(this.KEY_NEED_SHOW_REQ_TOAST, needShow);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void setTimeStampAndResort(int itemSize, int dataSource) {
        MayKnowPersonRepositoryForDifSource.f261398a.y0(itemSize, dataSource);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void addListener(a listener, int dataSource) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MayKnowPersonRepositoryForDifSource.C(listener, dataSource);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchQZoneExtraInfo(int dataSource, List<Long> uins, Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> block) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(block, "block");
        MayKnowPersonRepositoryForDifSource.I(dataSource, uins, block);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchRecommendDataRemote(int dataSource) {
        MayKnowPersonRepositoryForDifSource.K(false, null, null, dataSource, 7, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public List<MayKnowRecommend> getLocalRecommendData(int dataSource) {
        return MayKnowPersonRepositoryForDifSource.O(dataSource);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void removeListener(a listener, int dataSource) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MayKnowPersonRepositoryForDifSource.o0(listener, dataSource);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void setBizEntryCartonShow(int dataSource, Long type) {
        if (type != null) {
            type.longValue();
            MayKnowPersonRepositoryForDifSource.w0(dataSource, type.longValue());
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void setBizEntryClose(int dataSource, Long type, boolean needRefresh) {
        if (type != null) {
            type.longValue();
            MayKnowPersonRepositoryForDifSource.x0(type.longValue(), needRefresh);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public c getMayKnowDataSet() {
        return MayKnowPersonRepositoryForDifSource.R(0, 1, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi
    public void fetchTop2RecommendDataRemoteForce() {
        MayKnowPersonRepositoryForDifSource.K(true, null, null, 4, 6, null);
    }
}
