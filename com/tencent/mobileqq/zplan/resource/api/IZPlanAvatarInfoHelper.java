package com.tencent.mobileqq.zplan.resource.api;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zootopia.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import zb3.FriendsRespData;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\b\u0010\u0018\u001a\u00020\u0016H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/IZPlanAvatarInfoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lorg/json/JSONObject;", "fetchMyAvatarInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uin", "fetchOtherAvatarInfoWithUin", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOtherAvatarInfoCache", "", "byteValue", "getOtherAvatarInfoForLPlan", "", "friendUin", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/google/protobuf/nano/MessageNano;", "getSingleFriendZplanInfoReq", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "callback", "", "getSingleFriendZplanInfoRsp", "preloadUEAvatarSuitInfo", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAvatarInfoHelper extends QRouteApi {
    @Nullable
    Object fetchMyAvatarInfo(@NotNull Continuation<? super JSONObject> continuation);

    @Nullable
    Object fetchOtherAvatarInfoCache(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation);

    @Nullable
    Object fetchOtherAvatarInfoWithUin(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation);

    @NotNull
    JSONObject getOtherAvatarInfoForLPlan(@NotNull byte[] byteValue);

    @NotNull
    MessageNano getSingleFriendZplanInfoReq(long friendUin, @NotNull AppRuntime appRuntime);

    void getSingleFriendZplanInfoRsp(@NotNull byte[] byteValue, @NotNull d<FriendsRespData> callback);

    void preloadUEAvatarSuitInfo();
}
