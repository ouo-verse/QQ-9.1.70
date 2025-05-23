package com.tencent.mobileqq.wink.picker.core.repository;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository", f = "WinkOnlineAssetMediaRepository.kt", i = {0, 0, 1, 1, 2, 2}, l = {46, 51, 55}, m = "exportLightSdkVideo", n = {"this", WadlProxyConsts.KEY_MATERIAL, WadlProxyConsts.KEY_MATERIAL, "userData", WadlProxyConsts.KEY_MATERIAL, "userData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes21.dex */
public final class WinkOnlineAssetMediaRepository$exportLightSdkVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkOnlineAssetMediaRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkOnlineAssetMediaRepository$exportLightSdkVideo$1(WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository, Continuation<? super WinkOnlineAssetMediaRepository$exportLightSdkVideo$1> continuation) {
        super(continuation);
        this.this$0 = winkOnlineAssetMediaRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
