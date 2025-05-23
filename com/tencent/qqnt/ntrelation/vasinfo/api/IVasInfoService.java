package com.tencent.qqnt.ntrelation.vasinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import hx3.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J0\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&J(\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&J0\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&J,\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H&J<\u0010\u0016\u001a\u00020\u000e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H&J,\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/IVasInfoService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "getVasSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "queryCallback", "", "Lkx3/a;", "iQueryGeneralDataCallback", "getVasInfoWithUid", "getControlGroupVasInfoWithUid", "changeData", "Lhx3/c;", "updateCallback", "accurateUpdateVasSimpleInfo", "changeDataList", "Lhx3/a;", "deleteCallback", "deleteVasDetailInfo", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IVasInfoService extends QRouteApi {
    void accurateUpdateVasSimpleInfo(@NotNull NTVasSimpleInfo changeData, @Nullable String trace, @Nullable c<NTVasSimpleInfo> updateCallback);

    void accurateUpdateVasSimpleInfo(@NotNull ArrayList<NTVasSimpleInfo> changeDataList, @Nullable String trace, @Nullable c<NTVasSimpleInfo> updateCallback);

    void deleteVasDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable a<kx3.a> deleteCallback);

    void getControlGroupVasInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback);

    void getVasInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback);

    void getVasInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback);

    @Nullable
    NTVasSimpleInfo getVasSimpleInfoWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<NTVasSimpleInfo> getVasSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    void getVasSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<NTVasSimpleInfo> queryCallback);
}
