package com.tencent.mobileqq.pymk.api;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.troop.findtroop.TabRecommendPB$PersonExtraInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&J)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u001c\u001a\u00020\u000fH&J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\u000fH&J\b\u0010\u001e\u001a\u00020\u000fH&J*\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\r2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!H&J2\u0010&\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!2\b\u0010%\u001a\u0004\u0018\u00010$H&J<\u0010,\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022$\u0010+\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u000f0(H&JD\u0010,\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022$\u0010+\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u000f0(H&J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020$H&J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020$H&J\b\u00101\u001a\u00020$H&J\b\u00102\u001a\u00020\rH&J\u0010\u00104\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\rH&J\u0018\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u00108\u001a\u000207H&J\b\u00109\u001a\u00020\u000fH&\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/IQQRecommendFriendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "getLocalRecommendData", "", "dataSource", "Lcom/tencent/mobileqq/data/PYMKBizEntryInfo;", "getBizEntryInfo", "Lkotlin/Pair;", "getTotalCountAndBizToShow", "", "type", "", "needRefresh", "", "setBizEntryClose", "(ILjava/lang/Long;Z)V", "setBizEntryCartonShow", "(ILjava/lang/Long;)V", "Lcom/tencent/mobileqq/pymk/api/c;", "getMayKnowDataSet", "Lcom/tencent/mobileqq/data/QZoneInfo;", "getQZoneInfo", "Lcom/tencent/mobileqq/pymk/api/a;", "listener", "addListener", "removeListener", "fetchRecommendDataRemote", "fetchTop2RecommendDataRemoteForce", "fetchRecommendDataRemoteForceAll", "isForce", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterUins", "fetchRecommendDataRemoteWithFilter", "", "eTag", "fetchRecommendWithFilterAETag", "uins", "Lkotlin/Function2;", "", "Ltencent/im/troop/findtroop/TabRecommendPB$PersonExtraInfo;", "block", "fetchQZoneExtraInfo", "uin", "removeRecommendData", "traceId", "saveTraceId", "getTraceId", "pymkTestSwitch", "needShow", "setPymkTestSwitch", "itemSize", "setTimeStampAndResort", "Lcom/tencent/mobileqq/pymk/api/b;", "getPYMKMediaUtil", "removeAllPymkData", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQRecommendFriendApi extends QRouteApi {
    void addListener(@NotNull a listener);

    void addListener(@NotNull a listener, int dataSource);

    void fetchQZoneExtraInfo(int dataSource, @NotNull List<Long> uins, @NotNull Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> block);

    void fetchQZoneExtraInfo(@NotNull List<Long> uins, @NotNull Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> block);

    void fetchRecommendDataRemote();

    void fetchRecommendDataRemote(int dataSource);

    void fetchRecommendDataRemoteForceAll();

    void fetchRecommendDataRemoteWithFilter(boolean isForce, @NotNull ArrayList<Long> filterUins);

    void fetchRecommendWithFilterAETag(boolean isForce, @NotNull ArrayList<Long> filterUins, @Nullable String eTag);

    void fetchTop2RecommendDataRemoteForce();

    @NotNull
    List<PYMKBizEntryInfo> getBizEntryInfo(int dataSource);

    @NotNull
    List<MayKnowRecommend> getLocalRecommendData();

    @NotNull
    List<MayKnowRecommend> getLocalRecommendData(int dataSource);

    @NotNull
    c getMayKnowDataSet();

    @NotNull
    b getPYMKMediaUtil();

    @Nullable
    QZoneInfo getQZoneInfo();

    @NotNull
    Pair<Integer, List<PYMKBizEntryInfo>> getTotalCountAndBizToShow(int dataSource);

    @NotNull
    String getTraceId();

    boolean pymkTestSwitch();

    void removeAllPymkData();

    void removeListener(@NotNull a listener);

    void removeListener(@NotNull a listener, int dataSource);

    void removeRecommendData(@NotNull String uin);

    void saveTraceId(@NotNull String traceId);

    void setBizEntryCartonShow(int dataSource, @Nullable Long type);

    void setBizEntryClose(int dataSource, @Nullable Long type, boolean needRefresh);

    void setPymkTestSwitch(boolean needShow);

    void setTimeStampAndResort(int itemSize, int dataSource);
}
