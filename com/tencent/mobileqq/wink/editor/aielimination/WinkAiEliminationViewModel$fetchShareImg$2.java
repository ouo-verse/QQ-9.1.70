package com.tencent.mobileqq.wink.editor.aielimination;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel$fetchShareImg$2", f = "WinkAiEliminationViewModel.kt", i = {0, 0, 1}, l = {PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, m = "invokeSuspend", n = {"downloadOutPath", "sharePaths", "sharePaths"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel$fetchShareImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, String>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkAiEliminationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiEliminationViewModel$fetchShareImg$2(WinkAiEliminationViewModel winkAiEliminationViewModel, Continuation<? super WinkAiEliminationViewModel$fetchShareImg$2> continuation) {
        super(2, continuation);
        this.this$0 = winkAiEliminationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkAiEliminationViewModel$fetchShareImg$2 winkAiEliminationViewModel$fetchShareImg$2 = new WinkAiEliminationViewModel$fetchShareImg$2(this.this$0, continuation);
        winkAiEliminationViewModel$fetchShareImg$2.L$0 = obj;
        return winkAiEliminationViewModel$fetchShareImg$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        Map map;
        Map map2;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    map2 = (Map) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = (String) obj;
                    if (str != null) {
                        map2.put("SHARE_PREFIX__OUT_CHANNEL", str);
                    }
                    return map2;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) this.L$1;
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkAiEliminationViewModel$fetchShareImg$2$downloadQQPath$1(this.this$0, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkAiEliminationViewModel$fetchShareImg$2$downloadOutPath$1(this.this$0, null), 3, null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.L$0 = async$default2;
            this.L$1 = linkedHashMap;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            obj = await;
            map = linkedHashMap;
        }
        String str2 = (String) obj;
        if (str2 != null) {
            map.put("SHARE_PREFIX__QQ", str2);
        }
        this.L$0 = map;
        this.L$1 = null;
        this.label = 2;
        obj = deferred.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        map2 = map;
        str = (String) obj;
        if (str != null) {
        }
        return map2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Map<String, String>> continuation) {
        return ((WinkAiEliminationViewModel$fetchShareImg$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
