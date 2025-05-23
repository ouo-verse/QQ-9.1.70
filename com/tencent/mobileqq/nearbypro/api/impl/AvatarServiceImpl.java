package com.tencent.mobileqq.nearbypro.api.impl;

import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.nearbypro.repository.service.AvatarService;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0001J=\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J?\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0096\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/AvatarServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/api/IAvatarService;", "()V", "cleanup", "", "loadMotionPlayParams", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "hostUin", "", "guestUin", "url", "", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reqAvatarInfo", "Lorg/json/JSONObject;", "tinyId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMotionCover", "motionId", "", "motionAssetMD5", "coverUrl", "recordDressKey", "callback", "Lkotlin/Function0;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class AvatarServiceImpl implements IAvatarService {
    private final /* synthetic */ AvatarService $$delegate_0 = AvatarService.INSTANCE;

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    public void cleanup() {
        this.$$delegate_0.cleanup();
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    @Nullable
    public Object loadMotionPlayParams(long j3, @Nullable Long l3, @NotNull String str, @NotNull Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation) {
        return this.$$delegate_0.loadMotionPlayParams(j3, l3, str, continuation);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    @Nullable
    public Object reqAvatarInfo(long j3, @NotNull Continuation<? super JSONObject> continuation) {
        return this.$$delegate_0.reqAvatarInfo(j3, continuation);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IAvatarService
    public void setMotionCover(long tinyId, int motionId, @NotNull String motionAssetMD5, @NotNull String coverUrl, @NotNull String recordDressKey, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(motionAssetMD5, "motionAssetMD5");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(recordDressKey, "recordDressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.setMotionCover(tinyId, motionId, motionAssetMD5, coverUrl, recordDressKey, callback);
    }
}
