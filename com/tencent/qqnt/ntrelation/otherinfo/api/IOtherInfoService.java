package com.tencent.qqnt.ntrelation.otherinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.otherinfo.bean.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J0\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J>\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH&J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH&J0\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH&J8\u0010\u0010\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH&J,\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H&J<\u0010\u0015\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H&J<\u0010\u0017\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\fj\b\u0012\u0004\u0012\u00020\u000f`\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013H&J*\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/IOtherInfoService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uid", "trace", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "getOtherSimpleInfoWithUid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "getOtherInfoWithUid", "getControlGroupOtherInfoWithUid", "ntOtherSimpleInfo", "Lhx3/c;", "updateCallback", "accurateUpdateNTOtherSimpleInfo", "ntOtherSimpleInfoList", "accurateUpdateNTOtherDetailInfo", "Lhx3/a;", "deleteCallback", "deleteNTOtherDetailInfo", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOtherInfoService extends QRouteApi {
    void accurateUpdateNTOtherDetailInfo(@NotNull ArrayList<a> ntOtherSimpleInfoList, @Nullable String trace, @Nullable c<a> updateCallback);

    void accurateUpdateNTOtherSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.otherinfo.bean.c ntOtherSimpleInfo, @Nullable String trace, @Nullable c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> updateCallback);

    void accurateUpdateNTOtherSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> ntOtherSimpleInfoList, @Nullable String trace, @Nullable c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> updateCallback);

    void deleteNTOtherDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<a> deleteCallback);

    void getControlGroupOtherInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    void getOtherInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    void getOtherInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    void getOtherInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    @Nullable
    com.tencent.qqnt.ntrelation.otherinfo.bean.c getOtherSimpleInfoWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> getOtherSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    void getOtherSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.otherinfo.bean.c> iQueryGeneralDataCallback);
}
