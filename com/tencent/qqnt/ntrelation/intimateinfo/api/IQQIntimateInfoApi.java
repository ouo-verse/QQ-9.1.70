package com.tencent.qqnt.ntrelation.intimateinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J:\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH&J*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH&J \u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "getIntimateSimpleInfoWithUid", "ntIntimateSimpleInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "", "accurateUpdateIntimateInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteIntimateInfo", "Lhx3/b;", "", "iQueryGeneralDataCallback", "getBindIntimateRelationshipFriendCount", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQIntimateInfoApi extends QRouteApi {
    void accurateUpdateIntimateInfo(@NotNull ArrayList<a> ntIntimateSimpleInfo, @Nullable String trace, @Nullable c<a> iUpdateGeneralDataCallback);

    void deleteIntimateInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<a> iDeleteGeneralDataCallback);

    void getBindIntimateRelationshipFriendCount(@Nullable String trace, @NotNull b<Integer> iQueryGeneralDataCallback);

    @Nullable
    ArrayList<a> getIntimateSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);
}
