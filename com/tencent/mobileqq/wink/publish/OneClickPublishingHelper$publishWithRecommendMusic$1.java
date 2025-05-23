package com.tencent.mobileqq.wink.publish;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import java.util.List;
import k93.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishWithRecommendMusic$1", f = "OneClickPublishingHelper.kt", i = {}, l = {tlv_t183.CMD_183, 410}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper$publishWithRecommendMusic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ List<String> $mediaPaths;
    final /* synthetic */ int $publishSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickPublishingHelper$publishWithRecommendMusic$1(List<String> list, int i3, Bundle bundle, String str, Continuation<? super OneClickPublishingHelper$publishWithRecommendMusic$1> continuation) {
        super(2, continuation);
        this.$mediaPaths = list;
        this.$publishSource = i3;
        this.$extras = bundle;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OneClickPublishingHelper$publishWithRecommendMusic$1(this.$mediaPaths, this.$publishSource, this.$extras, this.$content, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String str;
        List<String> listOf;
        String c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z17 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    WinkDraftGenerator.DraftData draftData = (WinkDraftGenerator.DraftData) obj;
                    c16 = draftData.getPublishDraft().c();
                    if (c16 != null || c16.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        OneClickPublishingHelper.f325628a.F("publishWithRecommendMusic", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_GEN_COVER_FAILED, null, 2, null));
                        return Unit.INSTANCE;
                    }
                    OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
                    int i16 = this.$publishSource;
                    String missionId = draftData.getMissionId();
                    WinkEditDataWrapper editDataWrapper = draftData.getEditDataWrapper();
                    c publishDraft = draftData.getPublishDraft();
                    String c17 = draftData.getPublishDraft().c();
                    Intrinsics.checkNotNullExpressionValue(c17, "draftData.publishDraft.coverPath");
                    oneClickPublishingHelper.G(i16, missionId, editDataWrapper, publishDraft, c17, this.$content, this.$extras);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            OneClickPublishingHelper oneClickPublishingHelper2 = OneClickPublishingHelper.f325628a;
            List<String> list = this.$mediaPaths;
            this.label = 1;
            obj = oneClickPublishingHelper2.x(list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List<String> list2 = (List) obj;
        List<String> list3 = list2;
        if (list3 != null && !list3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            OneClickPublishingHelper.f325628a.F("publishWithRecommendMusic", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_PROCESSED_MEDIA_PATHS_IS_NULL, null, 2, null));
            return Unit.INSTANCE;
        }
        List<LocalMediaInfo> i17 = o.f326724a.i(list2);
        if (i17.isEmpty()) {
            OneClickPublishingHelper.f325628a.F("publishWithRecommendMusic", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_PATH_TO_LOCALMEDIAINFO_FAILED, null, 2, null));
            return Unit.INSTANCE;
        }
        OneClickPublishingHelper oneClickPublishingHelper3 = OneClickPublishingHelper.f325628a;
        oneClickPublishingHelper3.w(i17);
        if (i17.size() == 1 && QAlbumUtil.getMediaType(i17.get(0).path) != 1) {
            Bundle bundle = this.$extras;
            if (bundle != null) {
                str = bundle.getString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO, str)) {
                int i18 = this.$publishSource;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(i17.get(0).path);
                oneClickPublishingHelper3.A(i18, listOf, this.$content, this.$extras);
                return Unit.INSTANCE;
            }
        }
        WinkDraftGenerator winkDraftGenerator = WinkDraftGenerator.f325956a;
        String str2 = this.$content;
        final int i19 = this.$publishSource;
        Function1<OneClickPublishingFeedErrorCode, Unit> function1 = new Function1<OneClickPublishingFeedErrorCode, Unit>() { // from class: com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishWithRecommendMusic$1$draftData$1
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
                OneClickPublishingHelper.f325628a.F("publishWithRecommendMusic", i19, it);
            }
        };
        this.label = 2;
        obj = winkDraftGenerator.j(str2, i17, function1, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        WinkDraftGenerator.DraftData draftData2 = (WinkDraftGenerator.DraftData) obj;
        c16 = draftData2.getPublishDraft().c();
        if (c16 != null) {
        }
        z17 = true;
        if (!z17) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OneClickPublishingHelper$publishWithRecommendMusic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
