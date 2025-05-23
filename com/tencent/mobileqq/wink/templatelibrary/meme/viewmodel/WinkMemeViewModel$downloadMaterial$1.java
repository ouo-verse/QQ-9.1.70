package com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.explore.WinkMediaModelGenerator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.WinkMemeViewModel$downloadMaterial$1", f = "WinkMemeViewModel.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMemeViewModel$downloadMaterial$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $height;
    final /* synthetic */ String $json;
    final /* synthetic */ String $topic;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ WinkMemeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemeViewModel$downloadMaterial$1(String str, int i3, int i16, Context context, String str2, WinkMemeViewModel winkMemeViewModel, Continuation<? super WinkMemeViewModel$downloadMaterial$1> continuation) {
        super(2, continuation);
        this.$json = str;
        this.$width = i3;
        this.$height = i16;
        this.$context = context;
        this.$topic = str2;
        this.this$0 = winkMemeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMemeViewModel$downloadMaterial$1(this.$json, this.$width, this.$height, this.$context, this.$topic, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
        MutableLiveData mutableLiveData;
        HashMap hashMap2;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkMediaModelGenerator winkMediaModelGenerator = WinkMediaModelGenerator.f322764a;
            String str2 = this.$json;
            int i16 = this.$width;
            int i17 = this.$height;
            Context context = this.$context;
            String str3 = this.$topic;
            this.label = 1;
            obj = winkMediaModelGenerator.k(str2, i16, i17, context, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        w53.b.f("WinkMemeViewModel", "downloadMaterial... isSuccess:" + booleanValue);
        if (!booleanValue) {
            hashMap2 = this.this$0.contentToJson;
            str = this.this$0.currentRequestContent;
            hashMap2.put(str, this.$json);
        } else {
            hashMap = this.this$0.contentToJson;
            hashMap.clear();
        }
        mutableLiveData = this.this$0._downloadAndSaveFinish;
        mutableLiveData.postValue(Boxing.boxBoolean(booleanValue));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMemeViewModel$downloadMaterial$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
