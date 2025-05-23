package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel", f = "WinkEditorOpeningEndingViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {620}, m = "handleTemplateJump", n = {"this", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, WadlProxyConsts.KEY_MATERIAL, "finishedCallback", "placeHolders", "isFromClipping"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$handleTemplateJump$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingViewModel$handleTemplateJump$1(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, Continuation<? super WinkEditorOpeningEndingViewModel$handleTemplateJump$1> continuation) {
        super(continuation);
        this.this$0 = winkEditorOpeningEndingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object B2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B2 = this.this$0.B2(null, null, null, false, null, this);
        return B2;
    }
}
