package com.tencent.mobileqq.wink.publish;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishToQCircle$1", f = "OneClickPublishingHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper$publishToQCircle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $coverPath;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ String $methodName;
    final /* synthetic */ String $missionId;
    final /* synthetic */ boolean $needSaveNewDraft;
    final /* synthetic */ int $publishSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickPublishingHelper$publishToQCircle$1(String str, String str2, int i3, String str3, boolean z16, String str4, Bundle bundle, Continuation<? super OneClickPublishingHelper$publishToQCircle$1> continuation) {
        super(2, continuation);
        this.$missionId = str;
        this.$methodName = str2;
        this.$publishSource = i3;
        this.$coverPath = str3;
        this.$needSaveNewDraft = z16;
        this.$content = str4;
        this.$extras = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OneClickPublishingHelper$publishToQCircle$1(this.$missionId, this.$methodName, this.$publishSource, this.$coverPath, this.$needSaveNewDraft, this.$content, this.$extras, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            w53.b.f("OneClickPublishingHelper", "[publishToQCircle] missionId=" + this.$missionId);
            WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(this.$missionId);
            if (c16 == null) {
                OneClickPublishingHelper.f325628a.F(this.$methodName, this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MEDIA_MODEL_FOR_EDIT_IS_NULL, null, 2, null));
                return Unit.INSTANCE;
            }
            WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(this.$missionId);
            if (d16 == null) {
                OneClickPublishingHelper.f325628a.F(this.$methodName, this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MEDIA_MODEL_FOR_EXPORT_IS_NULL, null, 2, null));
                return Unit.INSTANCE;
            }
            ArrayList<LocalMediaInfo> originMediaInfos = c16.getOriginMediaInfos();
            if (originMediaInfos != null) {
                OneClickPublishingHelper.f325628a.I(c16, this.$publishSource, d16, this.$coverPath, originMediaInfos, this.$needSaveNewDraft, this.$missionId, this.$content, this.$extras);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OneClickPublishingHelper$publishToQCircle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
