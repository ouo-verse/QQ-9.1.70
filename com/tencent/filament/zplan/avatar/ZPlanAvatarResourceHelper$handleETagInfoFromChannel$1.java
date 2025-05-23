package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import el0.ETagInfo;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {703}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ETagInfo $eTagInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1(ETagInfo eTagInfo, Continuation continuation) {
        super(2, continuation);
        this.$eTagInfo = eTagInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1(this.$eTagInfo, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009a A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x0085, B:9:0x0097, B:12:0x009a), top: B:6:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0097 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x0085, B:9:0x0097, B:12:0x009a), top: B:6:0x0085 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String n06;
        boolean startsWith$default;
        String N0;
        Deferred async$default;
        Object await;
        ConcurrentSkipListSet concurrentSkipListSet;
        ConcurrentSkipListSet concurrentSkipListSet2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    await = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$eTagInfo.getUrl().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "handleETagInfoFromChannel fail, eTagInfo.url empty.");
                    return Unit.INSTANCE;
                }
                FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                n06 = zPlanAvatarResourceHelper.n0(F);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.$eTagInfo.getUrl(), n06, false, 2, null);
                if (startsWith$default) {
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanAvatarResourceHelper$handleETagInfoFromChannel$1$unzipDirPath$fetchUnzipShaderPath$1(this, F, null), 3, null);
                    this.label = 1;
                    await = async$default.await(this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    N0 = zPlanAvatarResourceHelper.N0(this.$eTagInfo.getUrl(), F);
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
                    concurrentSkipListSet = ZPlanAvatarResourceHelper.eTagsFromChannel;
                    if (concurrentSkipListSet.contains(this.$eTagInfo.getUrl())) {
                        concurrentSkipListSet2 = ZPlanAvatarResourceHelper.eTagsFromChannel;
                        concurrentSkipListSet2.add(this.$eTagInfo.getUrl());
                        zPlanAvatarResourceHelper2.H0(this.$eTagInfo);
                        zPlanAvatarResourceHelper2.M0(this.$eTagInfo, N0);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            }
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper22 = ZPlanAvatarResourceHelper.f105660o;
            concurrentSkipListSet = ZPlanAvatarResourceHelper.eTagsFromChannel;
            if (concurrentSkipListSet.contains(this.$eTagInfo.getUrl())) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "handleETagInfoFromChannel fail.", th5);
            return Unit.INSTANCE;
        }
        N0 = (String) await;
    }
}
