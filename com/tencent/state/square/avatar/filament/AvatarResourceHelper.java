package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.state.template.data.CommonDataKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/avatar/filament/AvatarResourceHelper;", "", "()V", "TAG", "", "loadAvatarInfo", "Lorg/json/JSONObject;", "uin", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMoodConfig", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarResourceHelper {
    public static final AvatarResourceHelper INSTANCE = new AvatarResourceHelper();
    public static final String TAG = "AvatarResourceHelper";

    AvatarResourceHelper() {
    }

    public final Object loadAvatarInfo(long j3, Continuation<? super JSONObject> continuation) {
        return SquareBase.INSTANCE.getConfig().getAvatarUtils().getAvatarInfo(j3, CommonDataKt.isMe(j3), continuation);
    }

    public final Object loadMoodConfig(final String str, Continuation<? super MoodConfig> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        final long currentTimeMillis = System.currentTimeMillis();
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        FilamentZipFileUtils.INSTANCE.downloadFile(str, new UnZipListener() { // from class: com.tencent.state.square.avatar.filament.AvatarResourceHelper$loadMoodConfig$$inlined$suspendCoroutine$lambda$1
            @Override // com.tencent.state.square.avatar.filament.UnZipListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d(AvatarResourceHelper.TAG, "onTaskFailed: " + errorMessage);
                Continuation.this.resumeWith(Result.m476constructorimpl(null));
            }

            @Override // com.tencent.state.square.avatar.filament.UnZipListener
            public void onTaskStart() {
                SquareBaseKt.getSquareLog().d(AvatarResourceHelper.TAG, "onTaskStart " + str);
            }

            @Override // com.tencent.state.square.avatar.filament.UnZipListener
            public void onTaskSuccess(JSONObject moodConfig) {
                Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
                SquareBaseKt.getSquareLog().d(AvatarResourceHelper.TAG, "onTaskSuccess cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", " + str);
                try {
                    MoodConfig.Companion companion = MoodConfig.INSTANCE;
                    String jSONObject = moodConfig.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "moodConfig.toString()");
                    Continuation.this.resumeWith(Result.m476constructorimpl(companion.fromJson(jSONObject)));
                } catch (Exception unused) {
                    SquareBaseKt.getSquareLog().d(AvatarResourceHelper.TAG, "onTaskFailed: fromJson error");
                    Continuation.this.resumeWith(Result.m476constructorimpl(null));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
