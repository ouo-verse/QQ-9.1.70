package com.tencent.mobileqq.nearbypro.api;

import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J=\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J>\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/IAvatarService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cleanup", "", "loadMotionPlayParams", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "hostUin", "", "guestUin", "url", "", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reqAvatarInfo", "Lorg/json/JSONObject;", "tinyId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMotionCover", "motionId", "", "motionAssetMD5", "coverUrl", "recordDressKey", "callback", "Lkotlin/Function0;", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IAvatarService extends QRouteApi {
    void cleanup();

    @Nullable
    Object loadMotionPlayParams(long j3, @Nullable Long l3, @NotNull String str, @NotNull Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation);

    @Nullable
    Object reqAvatarInfo(long j3, @NotNull Continuation<? super JSONObject> continuation);

    void setMotionCover(long tinyId, int motionId, @NotNull String motionAssetMD5, @NotNull String coverUrl, @NotNull String recordDressKey, @NotNull Function0<Unit> callback);
}
