package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u000eJ\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasDataHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "queryExtensionInfo", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "uin", "", "queryDbIfNeed", "", "requestFaceId", "", "key", "from", "callback", "Lcom/tencent/mobileqq/vas/api/IVasDataHelperApi$RequestCallback;", "RequestCallback", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasDataHelperApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasDataHelperApi$RequestCallback;", "", "call", "", "callbackKey", "", "avatarId", "", "pendantId", "", "pendantDiyId", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface RequestCallback {
        void call(@NotNull String callbackKey, int avatarId, long pendantId, int pendantDiyId);
    }

    @Nullable
    NTVasSimpleInfo queryExtensionInfo(@NotNull String uin, boolean queryDbIfNeed);

    void requestFaceId(@NotNull String key, @NotNull String uin, @NotNull String from, @Nullable RequestCallback callback);
}
