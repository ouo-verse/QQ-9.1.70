package com.tencent.mobileqq.wink.picker.core.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository", f = "WinkOnlineAssetMediaRepository.kt", i = {0}, l = {171}, m = "handleTemplateUserInfo", n = {"templateInfoMap"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkOnlineAssetMediaRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1(WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository, Continuation<? super WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1> continuation) {
        super(continuation);
        this.this$0 = winkOnlineAssetMediaRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object k3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        k3 = this.this$0.k(null, this);
        return k3;
    }
}
