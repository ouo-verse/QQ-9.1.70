package com.tencent.mobileqq.wink.publish;

import android.os.Bundle;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.c;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishContentText$1", f = "OneClickPublishingHelper.kt", i = {}, l = {433}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper$publishContentText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ List<String> $media;
    final /* synthetic */ int $publishSource;
    final /* synthetic */ String $textContent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickPublishingHelper$publishContentText$1(String str, List<String> list, int i3, Bundle bundle, Continuation<? super OneClickPublishingHelper$publishContentText$1> continuation) {
        super(2, continuation);
        this.$textContent = str;
        this.$media = list;
        this.$publishSource = i3;
        this.$extras = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OneClickPublishingHelper$publishContentText$1(this.$textContent, this.$media, this.$publishSource, this.$extras, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
    
        com.tencent.mobileqq.wink.publish.OneClickPublishingHelper.f325628a.F("publishContentText", r10.$publishSource, new com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode(com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode.ERROR_CODE_GEN_COVER_FAILED, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e A[Catch: Exception -> 0x000f, TryCatch #0 {Exception -> 0x000f, blocks: (B:5:0x000b, B:6:0x003b, B:8:0x0062, B:13:0x006e, B:16:0x0079, B:21:0x0083, B:24:0x009b, B:31:0x001e), top: B:2:0x0007 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkDraftGenerator.DraftData draftData;
        String a16;
        boolean z16;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z17 = true;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                WinkExportUtils.G();
                WinkDraftGenerator winkDraftGenerator = WinkDraftGenerator.f325956a;
                String str2 = this.$textContent;
                List<String> list = this.$media;
                final int i16 = this.$publishSource;
                Function1<OneClickPublishingFeedErrorCode, Unit> function1 = new Function1<OneClickPublishingFeedErrorCode, Unit>() { // from class: com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishContentText$1$draftData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(OneClickPublishingFeedErrorCode oneClickPublishingFeedErrorCode) {
                        invoke2(oneClickPublishingFeedErrorCode);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull OneClickPublishingFeedErrorCode it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        OneClickPublishingHelper.f325628a.F("publishContentText", i16, it);
                    }
                };
                OneClickPublishingHelper$publishContentText$1$draftData$2 oneClickPublishingHelper$publishContentText$1$draftData$2 = new Function1<WinkEditDataWrapper, Unit>() { // from class: com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishContentText$1$draftData$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull WinkEditDataWrapper it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkEditDataWrapper winkEditDataWrapper) {
                        invoke2(winkEditDataWrapper);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                obj = winkDraftGenerator.i(str2, list, null, function1, oneClickPublishingHelper$publishContentText$1$draftData$2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            draftData = (WinkDraftGenerator.DraftData) obj;
            com.tencent.mobileqq.wink.editor.cover.b bVar = com.tencent.mobileqq.wink.editor.cover.b.f319709a;
            WinkEditData winkEditData = draftData.getEditDataWrapper().getEditDatas().get(0);
            Intrinsics.checkNotNullExpressionValue(winkEditData, "draftData.editDataWrapper.editDatas[0]");
            a16 = bVar.a(winkEditData, c.r(draftData.getEditDataWrapper()));
        } catch (Exception e16) {
            w53.b.d("OneClickPublishingHelper", "publishContentText fail", e16);
        }
        if (a16 != null && a16.length() != 0) {
            z16 = false;
            if (z16) {
                a16 = draftData.getPublishDraft().c();
            }
            str = a16;
            if (str != null && str.length() != 0) {
                z17 = false;
            }
            OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
            int i17 = this.$publishSource;
            String missionId = draftData.getMissionId();
            WinkEditDataWrapper editDataWrapper = draftData.getEditDataWrapper();
            k93.c publishDraft = draftData.getPublishDraft();
            Intrinsics.checkNotNull(str);
            oneClickPublishingHelper.G(i17, missionId, editDataWrapper, publishDraft, str, "", this.$extras);
            return Unit.INSTANCE;
        }
        z16 = true;
        if (z16) {
        }
        str = a16;
        if (str != null) {
            z17 = false;
        }
        OneClickPublishingHelper oneClickPublishingHelper2 = OneClickPublishingHelper.f325628a;
        int i172 = this.$publishSource;
        String missionId2 = draftData.getMissionId();
        WinkEditDataWrapper editDataWrapper2 = draftData.getEditDataWrapper();
        k93.c publishDraft2 = draftData.getPublishDraft();
        Intrinsics.checkNotNull(str);
        oneClickPublishingHelper2.G(i172, missionId2, editDataWrapper2, publishDraft2, str, "", this.$extras);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OneClickPublishingHelper$publishContentText$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
