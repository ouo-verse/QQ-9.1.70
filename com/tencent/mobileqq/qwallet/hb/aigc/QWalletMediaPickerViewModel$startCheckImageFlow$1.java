package com.tencent.mobileqq.qwallet.hb.aigc;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerViewModel;
import com.tencent.mobileqq.qwallet.hb.aigc.data.OutputImageInfo;
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
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerViewModel$startCheckImageFlow$1", f = "QWalletMediaPickerViewModel.kt", i = {0, 1}, l = {61, 69}, m = "invokeSuspend", n = {"currentImg", "currentImg"}, s = {"L$0", "L$0"})
/* loaded from: classes16.dex */
public final class QWalletMediaPickerViewModel$startCheckImageFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizId;
    final /* synthetic */ String $path;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ QWalletMediaPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletMediaPickerViewModel$startCheckImageFlow$1(String str, QWalletMediaPickerViewModel qWalletMediaPickerViewModel, String str2, Continuation<? super QWalletMediaPickerViewModel$startCheckImageFlow$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = qWalletMediaPickerViewModel;
        this.$bizId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletMediaPickerViewModel$startCheckImageFlow$1(this.$path, this.this$0, this.$bizId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        OutputImageInfo outputImageInfo;
        a aVar;
        OutputImageInfo outputImageInfo2;
        a aVar2;
        OutputImageInfo outputImageInfo3;
        MutableLiveData mutableLiveData3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str = "";
        try {
            try {
                try {
                } finally {
                    this.this$0.R1();
                }
            } catch (Exception unused) {
                this.this$0.R1();
                mutableLiveData = this.this$0._processEvent;
                mutableLiveData.postValue(QWalletMediaPickerViewModel.b.c.f277210a);
                return Unit.INSTANCE;
            }
        } catch (Exception e16) {
            mutableLiveData2 = this.this$0._processEvent;
            mutableLiveData2.postValue(new QWalletMediaPickerViewModel.b.DetectFail(e16));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    outputImageInfo3 = (OutputImageInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableLiveData3 = this.this$0._processEvent;
                    mutableLiveData3.postValue(new QWalletMediaPickerViewModel.b.DetectSuccess(outputImageInfo3));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            OutputImageInfo outputImageInfo4 = (OutputImageInfo) this.L$1;
            OutputImageInfo outputImageInfo5 = (OutputImageInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
            outputImageInfo2 = outputImageInfo4;
            outputImageInfo = outputImageInfo5;
        } else {
            ResultKt.throwOnFailure(obj);
            outputImageInfo = new OutputImageInfo(null, null, 3, null);
            String b16 = c.f277218a.b(this.$path);
            if (b16 == null) {
                b16 = "";
            }
            outputImageInfo.c(b16);
            aVar = this.this$0.service;
            String localPath = outputImageInfo.getLocalPath();
            this.L$0 = outputImageInfo;
            this.L$1 = outputImageInfo;
            this.label = 1;
            obj = aVar.h(localPath, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            outputImageInfo2 = outputImageInfo;
        }
        outputImageInfo2.e((String) obj);
        aVar2 = this.this$0.service;
        String str2 = this.$bizId;
        String uploadUrl = outputImageInfo.getUploadUrl();
        if (uploadUrl != null) {
            str = uploadUrl;
        }
        this.L$0 = outputImageInfo;
        this.L$1 = null;
        this.label = 2;
        if (aVar2.g(str2, str, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        outputImageInfo3 = outputImageInfo;
        mutableLiveData3 = this.this$0._processEvent;
        mutableLiveData3.postValue(new QWalletMediaPickerViewModel.b.DetectSuccess(outputImageInfo3));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletMediaPickerViewModel$startCheckImageFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
