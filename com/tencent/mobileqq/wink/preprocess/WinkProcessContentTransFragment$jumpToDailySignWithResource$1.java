package com.tencent.mobileqq.wink.preprocess;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.dailysign.af;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import cooperation.peak.PeakConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$jumpToDailySignWithResource$1", f = "WinkProcessContentTransFragment.kt", i = {0}, l = {252}, m = "invokeSuspend", n = {"intent"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkProcessContentTransFragment$jumpToDailySignWithResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $mediaPaths;
    final /* synthetic */ String $textContent;
    Object L$0;
    int label;
    final /* synthetic */ WinkProcessContentTransFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkProcessContentTransFragment$jumpToDailySignWithResource$1(List<String> list, String str, WinkProcessContentTransFragment winkProcessContentTransFragment, Continuation<? super WinkProcessContentTransFragment$jumpToDailySignWithResource$1> continuation) {
        super(2, continuation);
        this.$mediaPaths = list;
        this.$textContent = str;
        this.this$0 = winkProcessContentTransFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkProcessContentTransFragment$jumpToDailySignWithResource$1(this.$mediaPaths, this.$textContent, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String tag;
        Bundle bundle;
        Bundle bundle2;
        Intent intent;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    bundle2 = (Bundle) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                af afVar = new af(this.$mediaPaths, this.$textContent, null, 4, null);
                FragmentActivity activity = this.this$0.getActivity();
                if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
                    bundle = new Bundle();
                }
                DailySignConfig dailySignConfig = new DailySignConfig(afVar);
                dailySignConfig.setFrom("QZONE");
                WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                this.L$0 = bundle;
                this.label = 1;
                obj = winkMaterialResourceLoader.h(dailySignConfig, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bundle2 = bundle;
            }
            bundle2.putSerializable(QQWinkConstants.EDITOR_TEXT_TEMPLATE_CONFIG, (DailySignConfig) obj);
            bundle2.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            bundle2.putString(WinkDTParamBuilder.APP_KEY_NAME, "00000QG6YX3X0LZH");
            com.tencent.mobileqq.wink.f.m(this.this$0.requireContext(), bundle2);
        } catch (Exception e16) {
            tag = this.this$0.getTAG();
            w53.b.d(tag, "jumpToDailySignWithResource fail", e16);
        }
        this.this$0.Ah("[processMedia] jump to dailySign");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkProcessContentTransFragment$jumpToDailySignWithResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
