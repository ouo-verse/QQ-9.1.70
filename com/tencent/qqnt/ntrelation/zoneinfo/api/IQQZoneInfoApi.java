package com.tencent.qqnt.ntrelation.zoneinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.zoneinfo.bean.c;
import hx3.a;
import hx3.b;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J8\u0010\u000e\u001a\u00020\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J*\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&J*\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014H&J:\u0010\u0018\u001a\u00020\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&J:\u0010\u0013\u001a\u00020\r2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0002j\b\u0012\u0004\u0012\u00020\u000b`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "getZoneSimpleInfoWithUid", "uid", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "iQueryGeneralDataCallback", "", "getZoneDetailWithUid", "uidList", "ntZoneDetailInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateZoneDetailInfo", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteZoneDetailInfo", "ntZoneSimpleInfoList", "updateZoneSimpleInfo", "ntZoneDetailInfoList", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQZoneInfoApi extends QRouteApi {
    void deleteZoneDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iDeleteGeneralDataCallback);

    void getZoneDetailWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback);

    void getZoneDetailWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback);

    @Nullable
    ArrayList<c> getZoneSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    void updateZoneDetailInfo(@NotNull com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback);

    void updateZoneDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> ntZoneDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback);

    void updateZoneSimpleInfo(@NotNull ArrayList<c> ntZoneSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback);
}
