package com.tencent.state.square.avatar.filament;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ=\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/avatar/filament/SquareActionHelper;", "Lcom/tencent/state/square/avatar/filament/IActionHelper;", "()V", "loadMoodConfigAndAvatarInfo", "Lkotlin/Pair;", "Lcom/tencent/state/square/avatar/filament/FilamentPlayRawData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "hostUin", "", "guestUin", "url", "", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPlayParams", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareActionHelper implements IActionHelper {
    public static final SquareActionHelper INSTANCE = new SquareActionHelper();

    SquareActionHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Object loadMoodConfigAndAvatarInfo(long j3, Long l3, String str, Continuation<? super Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> continuation) {
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = new LoadFilamentAssetsStatistics(0L, false, 0L, 0L, 15, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        BuildersKt__BuildersKt.runBlocking$default(null, new SquareActionHelper$loadMoodConfigAndAvatarInfo$2(objectRef, str, loadFilamentAssetsStatistics, objectRef2, j3, l3, objectRef3, null), 1, null);
        T t16 = objectRef.element;
        if (((MoodConfig) t16) != null) {
            if (((JSONObject) objectRef2.element) != null) {
                MoodConfig moodConfig = (MoodConfig) t16;
                Intrinsics.checkNotNull(moodConfig);
                JSONObject jSONObject = (JSONObject) objectRef2.element;
                Intrinsics.checkNotNull(jSONObject);
                return new Pair(new FilamentPlayRawData(moodConfig, jSONObject, (JSONObject) objectRef3.element), loadFilamentAssetsStatistics);
            }
            throw new Exception("loadAvatarInfo failed, uin:" + j3);
        }
        throw new Exception("loadActionInfo failed, uin:" + j3 + ", guestUin:" + l3 + ", url:" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // com.tencent.state.square.avatar.filament.IActionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadPlayParams(long j3, Long l3, String str, Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation) {
        SquareActionHelper$loadPlayParams$1 squareActionHelper$loadPlayParams$1;
        Object coroutine_suspended;
        int i3;
        Long l16;
        Object loadMoodConfigAndAvatarInfo;
        long j16;
        MoodConfig moodConfig;
        AnimType animType;
        AnimType animType2;
        SquareAvatarData.AvatarData avatarData;
        if (continuation instanceof SquareActionHelper$loadPlayParams$1) {
            squareActionHelper$loadPlayParams$1 = (SquareActionHelper$loadPlayParams$1) continuation;
            int i16 = squareActionHelper$loadPlayParams$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                squareActionHelper$loadPlayParams$1.label = i16 - Integer.MIN_VALUE;
                SquareActionHelper$loadPlayParams$1 squareActionHelper$loadPlayParams$12 = squareActionHelper$loadPlayParams$1;
                Object obj = squareActionHelper$loadPlayParams$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = squareActionHelper$loadPlayParams$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    l16 = l3;
                    squareActionHelper$loadPlayParams$12.L$0 = l16;
                    squareActionHelper$loadPlayParams$12.J$0 = j3;
                    squareActionHelper$loadPlayParams$12.label = 1;
                    loadMoodConfigAndAvatarInfo = loadMoodConfigAndAvatarInfo(j3, l3, str, squareActionHelper$loadPlayParams$12);
                    if (loadMoodConfigAndAvatarInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j16 = j3;
                } else if (i3 == 1) {
                    long j17 = squareActionHelper$loadPlayParams$12.J$0;
                    Long l17 = (Long) squareActionHelper$loadPlayParams$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    j16 = j17;
                    loadMoodConfigAndAvatarInfo = obj;
                    l16 = l17;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Pair pair = (Pair) loadMoodConfigAndAvatarInfo;
                FilamentPlayRawData filamentPlayRawData = (FilamentPlayRawData) pair.component1();
                LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) pair.component2();
                moodConfig = filamentPlayRawData.getMoodConfig();
                JSONObject hostAvatarInfo = filamentPlayRawData.getHostAvatarInfo();
                JSONObject guestAvatarInfo = filamentPlayRawData.getGuestAvatarInfo();
                EnumUserGender.Companion companion = EnumUserGender.INSTANCE;
                EnumUserGender a16 = companion.a(hostAvatarInfo.optInt("gender", 0));
                AvatarType avatarType = AvatarType.HOST;
                animType = AnimType.IDLE;
                SquareAvatarData.AvatarAnim avatarAnim = moodConfig.getAvatarAnim(a16, avatarType, animType);
                String jSONObject = hostAvatarInfo.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "hostAvatarInfo.toString()");
                SquareAvatarData.AvatarData avatarData2 = new SquareAvatarData.AvatarData(j16, a16, avatarAnim, jSONObject);
                if (moodConfig.hasGuest() || l16 == null || guestAvatarInfo == null) {
                    animType2 = animType;
                    avatarData = null;
                } else {
                    EnumUserGender a17 = companion.a(guestAvatarInfo.optInt("gender", 0));
                    long longValue = l16.longValue();
                    animType2 = animType;
                    SquareAvatarData.AvatarAnim avatarAnim2 = moodConfig.getAvatarAnim(a17, AvatarType.GUEST, animType2);
                    String jSONObject2 = guestAvatarInfo.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "guestAvatarInfo.toString()");
                    avatarData = new SquareAvatarData.AvatarData(longValue, a17, avatarAnim2, jSONObject2);
                }
                return new Triple(moodConfig, new SquareAvatarData(avatarData2, avatarData, moodConfig.getExtraActorData(animType2, a16), moodConfig.getLightInfo(), moodConfig.getCameraInfo()), loadFilamentAssetsStatistics);
            }
        }
        squareActionHelper$loadPlayParams$1 = new SquareActionHelper$loadPlayParams$1(this, continuation);
        SquareActionHelper$loadPlayParams$1 squareActionHelper$loadPlayParams$122 = squareActionHelper$loadPlayParams$1;
        Object obj2 = squareActionHelper$loadPlayParams$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = squareActionHelper$loadPlayParams$122.label;
        if (i3 != 0) {
        }
        Pair pair2 = (Pair) loadMoodConfigAndAvatarInfo;
        FilamentPlayRawData filamentPlayRawData2 = (FilamentPlayRawData) pair2.component1();
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics2 = (LoadFilamentAssetsStatistics) pair2.component2();
        moodConfig = filamentPlayRawData2.getMoodConfig();
        JSONObject hostAvatarInfo2 = filamentPlayRawData2.getHostAvatarInfo();
        JSONObject guestAvatarInfo2 = filamentPlayRawData2.getGuestAvatarInfo();
        EnumUserGender.Companion companion2 = EnumUserGender.INSTANCE;
        EnumUserGender a162 = companion2.a(hostAvatarInfo2.optInt("gender", 0));
        AvatarType avatarType2 = AvatarType.HOST;
        animType = AnimType.IDLE;
        SquareAvatarData.AvatarAnim avatarAnim3 = moodConfig.getAvatarAnim(a162, avatarType2, animType);
        String jSONObject3 = hostAvatarInfo2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "hostAvatarInfo.toString()");
        SquareAvatarData.AvatarData avatarData22 = new SquareAvatarData.AvatarData(j16, a162, avatarAnim3, jSONObject3);
        if (moodConfig.hasGuest()) {
        }
        animType2 = animType;
        avatarData = null;
        return new Triple(moodConfig, new SquareAvatarData(avatarData22, avatarData, moodConfig.getExtraActorData(animType2, a162), moodConfig.getLightInfo(), moodConfig.getCameraInfo()), loadFilamentAssetsStatistics2);
    }
}
