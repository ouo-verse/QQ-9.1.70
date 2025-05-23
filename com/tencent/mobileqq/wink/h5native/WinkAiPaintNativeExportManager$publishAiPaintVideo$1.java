package com.tencent.mobileqq.wink.h5native;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$publishAiPaintVideo$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$publishAiPaintVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IQQWinkEditorResAPI.AiPaintResponseListener $listener;
    final /* synthetic */ PublishVideoRequest $request;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$publishAiPaintVideo$1(PublishVideoRequest publishVideoRequest, IQQWinkEditorResAPI.AiPaintResponseListener aiPaintResponseListener, Continuation<? super WinkAiPaintNativeExportManager$publishAiPaintVideo$1> continuation) {
        super(2, continuation);
        this.$request = publishVideoRequest;
        this.$listener = aiPaintResponseListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$publishAiPaintVideo$1(this.$request, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean startsWith$default;
        String videoUrl;
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
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.$request.getVideoUrl(), "https://qqcircle_aipainting_native_export.qq.com/local_files", false, 2, null);
            if (startsWith$default) {
                videoUrl = StringsKt__StringsKt.removePrefix(this.$request.getVideoUrl(), (CharSequence) "https://qqcircle_aipainting_native_export.qq.com/local_files");
            } else {
                videoUrl = this.$request.getVideoUrl();
            }
            if (FileUtils.fileExists(videoUrl)) {
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
                PublishVideoRequest publishVideoRequest = this.$request;
                this.label = 1;
                obj = winkAiPaintNativeExportManager.c0(videoUrl, publishVideoRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                w53.b.c("WinkAiPaintNativeExportManager", "file not exist: " + videoUrl);
                throw new IllegalStateException(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            }
        }
        this.$listener.onResponse(this.$request.getCallback(), new PublishVideoResponse(0, "success", (String) obj).toJsonStr());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$publishAiPaintVideo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
