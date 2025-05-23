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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH&J(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J0\u0010\u0014\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/IQQOtherInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "uids", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "iQueryGeneralDataCallback", "", "getOtherInfoWithUid", "uid", "Lhx3/a;", "deleteCallback", "deleteNTOtherDetailInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "getOtherSimpleInfoWithUid", "ntOtherDetailInfoList", "Lhx3/c;", "updateCallback", "accurateUpdateNTOtherDetailInfo", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQOtherInfoApi extends QRouteApi {
    void accurateUpdateNTOtherDetailInfo(@NotNull ArrayList<a> ntOtherDetailInfoList, @Nullable String trace, @Nullable c<a> updateCallback);

    void deleteNTOtherDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<a> deleteCallback);

    void getOtherInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    @Nullable
    ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> getOtherSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);
}
