package com.tencent.state.square.avatar.filament;

import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/avatar/filament/IActionHelper;", "", "loadPlayParams", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "hostUin", "", "guestUin", "url", "", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IActionHelper {
    Object loadPlayParams(long j3, Long l3, String str, Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation);
}
