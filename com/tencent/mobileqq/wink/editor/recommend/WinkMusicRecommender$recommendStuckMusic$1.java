package com.tencent.mobileqq.wink.editor.recommend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.recommend.WinkMusicRecommender", f = "WinkMusicRecommender.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {53, 58, 70}, m = "recommendStuckMusic", n = {"this", "onStateChanged", "onStateChanged", "coverBitmaps", "onStateChanged", "coverBitmaps", "musicInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes21.dex */
public final class WinkMusicRecommender$recommendStuckMusic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkMusicRecommender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMusicRecommender$recommendStuckMusic$1(WinkMusicRecommender winkMusicRecommender, Continuation<? super WinkMusicRecommender$recommendStuckMusic$1> continuation) {
        super(continuation);
        this.this$0 = winkMusicRecommender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
