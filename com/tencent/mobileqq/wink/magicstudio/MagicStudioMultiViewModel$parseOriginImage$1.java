package com.tencent.mobileqq.wink.magicstudio;

import android.util.Size;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.InputMediaType;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$parseOriginImage$1", f = "MagicStudioMultiViewModel.kt", i = {0}, l = {206}, m = "invokeSuspend", n = {"ratio"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$parseOriginImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MagicStudioPicStyle $magicStudioStyle;
    final /* synthetic */ LocalMediaInfo $originImage;
    Object L$0;
    int label;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$parseOriginImage$1(MagicStudioPicStyle magicStudioPicStyle, MagicStudioMultiViewModel magicStudioMultiViewModel, LocalMediaInfo localMediaInfo, Continuation<? super MagicStudioMultiViewModel$parseOriginImage$1> continuation) {
        super(2, continuation);
        this.$magicStudioStyle = magicStudioPicStyle;
        this.this$0 = magicStudioMultiViewModel;
        this.$originImage = localMediaInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioMultiViewModel$parseOriginImage$1(this.$magicStudioStyle, this.this$0, this.$originImage, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
    
        if (r0.mediaHeight >= r0.mediaWidth) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
    
        r4 = "3:2";
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0119, code lost:
    
        if (r0.mediaHeight >= r0.mediaWidth) goto L54;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Size i3;
        MutableLiveData mutableLiveData;
        String outputImageAspectRatio;
        String str;
        Object th5;
        Object S1;
        String str2;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        boolean z16 = true;
        if (i16 != 0) {
            if (i16 == 1) {
                str = (String) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th6) {
                    th5 = th6;
                    w53.b.c("MagicStudioMultiViewModel", "cropFaceRegion failed: " + th5);
                    str2 = this.$originImage.path;
                    mutableLiveData2 = this.this$0._updateLoadingViewRatio;
                    mutableLiveData2.postValue(TuplesKt.to(str, str2));
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str3 = "2:3";
            boolean z17 = false;
            if (this.$magicStudioStyle.getInputMediaType() == InputMediaType.FACE_CROP) {
                String outputImageAspectRatio2 = this.$magicStudioStyle.getOutputImageAspectRatio();
                if (outputImageAspectRatio2 == null || outputImageAspectRatio2.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    outputImageAspectRatio = "2:3";
                } else {
                    outputImageAspectRatio = this.$magicStudioStyle.getOutputImageAspectRatio();
                }
                w53.b.f("MagicStudioMultiViewModel", "parseOriginImage ratio: " + this.$magicStudioStyle.getStyleId() + " " + outputImageAspectRatio);
                try {
                    MagicStudioMultiViewModel magicStudioMultiViewModel = this.this$0;
                    String str4 = this.$originImage.path;
                    Intrinsics.checkNotNullExpressionValue(str4, "originImage.path");
                    this.L$0 = outputImageAspectRatio;
                    this.label = 1;
                    S1 = magicStudioMultiViewModel.S1(str4, outputImageAspectRatio, this);
                    if (S1 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = outputImageAspectRatio;
                    obj = S1;
                } catch (Throwable th7) {
                    str = outputImageAspectRatio;
                    th5 = th7;
                    w53.b.c("MagicStudioMultiViewModel", "cropFaceRegion failed: " + th5);
                    str2 = this.$originImage.path;
                    mutableLiveData2 = this.this$0._updateLoadingViewRatio;
                    mutableLiveData2.postValue(TuplesKt.to(str, str2));
                    return Unit.INSTANCE;
                }
            } else {
                LocalMediaInfo localMediaInfo = this.$originImage;
                if ((localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0 || localMediaInfo.orientation != 0) && (i3 = com.tencent.mobileqq.wink.utils.f.i(localMediaInfo.path, true)) != null) {
                    this.$originImage.mediaWidth = i3.getWidth();
                    this.$originImage.mediaHeight = i3.getHeight();
                    this.$originImage.orientation = 0;
                }
                String outputImageAspectRatio3 = this.$magicStudioStyle.getOutputImageAspectRatio();
                if (outputImageAspectRatio3 != null && outputImageAspectRatio3.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    LocalMediaInfo localMediaInfo2 = this.$originImage;
                } else {
                    if (Intrinsics.areEqual(this.$magicStudioStyle.getOutputImageAspectRatio(), "-1")) {
                        LocalMediaInfo localMediaInfo3 = this.$originImage;
                    } else {
                        str3 = this.$magicStudioStyle.getOutputImageAspectRatio();
                    }
                    mutableLiveData = this.this$0._updateLoadingViewRatio;
                    mutableLiveData.postValue(TuplesKt.to(str3, this.$originImage.path));
                    return Unit.INSTANCE;
                }
            }
        }
        str2 = (String) obj;
        mutableLiveData2 = this.this$0._updateLoadingViewRatio;
        mutableLiveData2.postValue(TuplesKt.to(str, str2));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$parseOriginImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
