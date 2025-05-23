package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel", f = "WinkEditorOpeningEndingViewModel.kt", i = {0, 0, 0, 0}, l = {com.tencent.luggage.wxa.gg.b.CTRL_INDEX}, m = "fillTemplateByImage", n = {"this", "placeHolders", "normalClips", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$fillTemplateByImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingViewModel$fillTemplateByImage$1(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, Continuation<? super WinkEditorOpeningEndingViewModel$fillTemplateByImage$1> continuation) {
        super(continuation);
        this.this$0 = winkEditorOpeningEndingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h26 = this.this$0.h2(null, null, this);
        return h26;
    }
}
