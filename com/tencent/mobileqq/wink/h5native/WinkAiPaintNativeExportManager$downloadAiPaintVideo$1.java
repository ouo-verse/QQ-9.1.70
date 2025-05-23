package com.tencent.mobileqq.wink.h5native;

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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$downloadAiPaintVideo$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$downloadAiPaintVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IQQWinkEditorResAPI.DownloadAiPaintVideoListener $listener;
    final /* synthetic */ String $savePath;
    final /* synthetic */ String $videoUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$downloadAiPaintVideo$1(String str, String str2, IQQWinkEditorResAPI.DownloadAiPaintVideoListener downloadAiPaintVideoListener, Continuation<? super WinkAiPaintNativeExportManager$downloadAiPaintVideo$1> continuation) {
        super(2, continuation);
        this.$videoUrl = str;
        this.$savePath = str2;
        this.$listener = downloadAiPaintVideoListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$downloadAiPaintVideo$1(this.$videoUrl, this.$savePath, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String replace$default;
        boolean endsWith$default;
        boolean endsWith$default2;
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
            replace$default = StringsKt__StringsJVMKt.replace$default(this.$videoUrl, "https://qqcircle_aipainting_native_export.qq.com/local_files", "", false, 4, (Object) null);
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(replace$default, "data.m", false, 2, null);
            if (endsWith$default) {
                WinkAiPaintNativeExportManager.f322863a.H(replace$default, this.$savePath, this.$listener);
            } else {
                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(replace$default, "data.mqr", false, 2, null);
                if (endsWith$default2) {
                    if (FileUtils.fileExists(replace$default)) {
                        WinkAiPaintNativeExportManager.f322863a.H(replace$default, this.$savePath, this.$listener);
                    } else {
                        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
                        this.label = 1;
                        obj = winkAiPaintNativeExportManager.Z(replace$default, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        WinkAiPaintNativeExportManager.f322863a.H((String) obj, this.$savePath, this.$listener);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$downloadAiPaintVideo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
