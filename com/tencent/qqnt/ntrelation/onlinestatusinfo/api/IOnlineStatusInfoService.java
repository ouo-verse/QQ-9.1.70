package com.tencent.qqnt.ntrelation.onlinestatusinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import hx3.a;
import hx3.b;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J0\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J(\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\fH&J(\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\fH&J0\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\fH&J8\u0010\u0013\u001a\u00020\u000e2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\fH&J*\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H&J*\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H&J:\u0010\u001a\u001a\u00020\u000e2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H&J*\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001cH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IOnlineStatusInfoService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "getOnlineStatusSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "", "callback", "addOnlineStatusSimpleInfoCallback", "removeOnlineStatusSimpleInfoCallback", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "getOnlineStatusInfoWithUid", "getControlGroupOnlineStatusInfoWithUid", "ntOnlineStatusDetailInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateOnlineStatusDetailInfo", "ntOnlineStatusSimpleInfo", "updateOnlineStatusSimpleInfo", "ntOnlineStatusSimpleInfoList", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteOnlineStatusDetailInfo", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOnlineStatusInfoService extends QRouteApi {
    void addOnlineStatusSimpleInfoCallback(@NotNull String uid, @Nullable String trace, @NotNull b<c> callback);

    void deleteOnlineStatusDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable a<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iDeleteGeneralDataCallback);

    void getControlGroupOnlineStatusInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback);

    void getOnlineStatusInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback);

    void getOnlineStatusInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback);

    void getOnlineStatusInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback);

    @Nullable
    c getOnlineStatusSimpleInfoWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<c> getOnlineStatusSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    void getOnlineStatusSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    void removeOnlineStatusSimpleInfoCallback(@NotNull String uid, @Nullable String trace, @NotNull b<c> callback);

    void updateOnlineStatusDetailInfo(@NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback);

    void updateOnlineStatusSimpleInfo(@NotNull c ntOnlineStatusSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback);

    void updateOnlineStatusSimpleInfo(@NotNull ArrayList<c> ntOnlineStatusSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback);
}
