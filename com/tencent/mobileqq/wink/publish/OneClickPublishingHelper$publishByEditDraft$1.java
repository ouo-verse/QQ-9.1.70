package com.tencent.mobileqq.wink.publish;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.c;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import e93.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.OneClickPublishingHelper$publishByEditDraft$1", f = "OneClickPublishingHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper$publishByEditDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $coverPath;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ String $missionId;
    final /* synthetic */ boolean $needSaveNewDraft;
    final /* synthetic */ int $publishSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickPublishingHelper$publishByEditDraft$1(String str, int i3, Bundle bundle, String str2, String str3, boolean z16, Continuation<? super OneClickPublishingHelper$publishByEditDraft$1> continuation) {
        super(2, continuation);
        this.$missionId = str;
        this.$publishSource = i3;
        this.$extras = bundle;
        this.$content = str2;
        this.$coverPath = str3;
        this.$needSaveNewDraft = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OneClickPublishingHelper$publishByEditDraft$1(this.$missionId, this.$publishSource, this.$extras, this.$content, this.$coverPath, this.$needSaveNewDraft, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0159  */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        LocalMediaInfo localMediaInfo;
        ?? r46;
        ?? r47;
        ?? r48;
        ?? r49;
        int collectionSizeOrDefault;
        String str;
        String str2;
        WinkEditDataWrapper winkEditDataWrapper;
        Object firstOrNull;
        ?? r26;
        Bundle bundle;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            w53.b.f("OneClickPublishingHelper", "[publishByEditDraft] missionId=" + this.$missionId);
            WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(this.$missionId);
            if (c16 == null) {
                OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MEDIA_MODEL_FOR_EDIT_IS_NULL, null, 2, null));
                return Unit.INSTANCE;
            }
            WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(this.$missionId);
            if (d16 == null) {
                OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MEDIA_MODEL_FOR_EXPORT_IS_NULL, null, 2, null));
                return Unit.INSTANCE;
            }
            Integer editMode = c16.getEditMode();
            String str3 = null;
            ArrayList<String> arrayList = null;
            boolean z16 = false;
            if (editMode != null && editMode.intValue() == 1) {
                w53.b.f("OneClickPublishingHelper", "[publishByEditDraft] \u56fe\u7247\u6a21\u5f0f\uff0c\u4f7f\u7528\u5bfc\u51fa\u7684\u5c01\u9762\u8d70publishWithRecommendMusic()\u8def\u5f84");
                LocalMediaInfo outMediaInfo = c16.getOutMediaInfo();
                if (outMediaInfo != null) {
                    arrayList = outMediaInfo.mOriginPath;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    r26 = false;
                } else {
                    r26 = true;
                }
                if (r26 != false) {
                    OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_EDIT_IMAGE_PATHS_IS_EMPTY, null, 2, null));
                    return Unit.INSTANCE;
                }
                String captureMaterialId = c16.getCaptureMaterialId();
                if (captureMaterialId == null || captureMaterialId.length() == 0) {
                    z16 = true;
                }
                if (!z16 && (bundle = this.$extras) != null) {
                    bundle.putString("captureMaterialId", c16.getCaptureMaterialId());
                }
                OneClickPublishingHelper.f325628a.E(this.$publishSource, arrayList, this.$content, this.$extras);
                return Unit.INSTANCE;
            }
            ArrayList<LocalMediaInfo> originMediaInfos = c16.getOriginMediaInfos();
            if (originMediaInfos != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) originMediaInfos);
                localMediaInfo = (LocalMediaInfo) firstOrNull;
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo == null) {
                OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_FIRST_MEDIA_IS_NULL, null, 2, null));
                return Unit.INSTANCE;
            }
            LocalMediaInfo outMediaInfo2 = d16.getOutMediaInfo();
            if (outMediaInfo2 != null) {
                str3 = outMediaInfo2.thumbnailPath;
            }
            if (str3 != null && str3.length() != 0) {
                r46 = false;
            } else {
                r46 = true;
            }
            if (r46 != false) {
                String str4 = this.$coverPath;
                if (str4 != null) {
                    if (str4.length() > 0) {
                        r49 = true;
                    } else {
                        r49 = false;
                    }
                    if (r49 == true) {
                        r47 = true;
                        if (r47 == false && new File(this.$coverPath).exists()) {
                            str3 = this.$coverPath;
                        } else {
                            com.tencent.mobileqq.wink.editor.cover.b bVar = com.tencent.mobileqq.wink.editor.cover.b.f319709a;
                            WinkEditData winkEditData = c16.getEditDatas().get(0);
                            Intrinsics.checkNotNullExpressionValue(winkEditData, "editData.editDatas[0]");
                            str3 = bVar.a(winkEditData, c.r(c16));
                            if (str3 == null && str3.length() != 0) {
                                r48 = false;
                            } else {
                                r48 = true;
                            }
                            if (r48 != false) {
                                if (i.I(localMediaInfo)) {
                                    str3 = PublishVideoUtils.getVideoCover(localMediaInfo.path);
                                } else {
                                    str3 = localMediaInfo.path;
                                }
                            }
                        }
                    }
                }
                r47 = false;
                if (r47 == false) {
                }
                com.tencent.mobileqq.wink.editor.cover.b bVar2 = com.tencent.mobileqq.wink.editor.cover.b.f319709a;
                WinkEditData winkEditData2 = c16.getEditDatas().get(0);
                Intrinsics.checkNotNullExpressionValue(winkEditData2, "editData.editDatas[0]");
                str3 = bVar2.a(winkEditData2, c.r(c16));
                if (str3 == null) {
                }
                r48 = true;
                if (r48 != false) {
                }
            }
            String str5 = str3;
            if (str5 == null || str5.length() == 0) {
                z16 = true;
            }
            if (z16) {
                OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_GEN_COVER_FAILED, null, 2, null));
                return Unit.INSTANCE;
            }
            ArrayList<LocalMediaInfo> originMediaInfos2 = c16.getOriginMediaInfos();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originMediaInfos2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = originMediaInfos2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((LocalMediaInfo) it.next()).path);
            }
            List<LocalMediaInfo> i3 = o.f326724a.i(arrayList2);
            if (i3.isEmpty()) {
                OneClickPublishingHelper.f325628a.F("publishByEditDraft", this.$publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_PATH_TO_LOCALMEDIAINFO_FAILED, null, 2, null));
                return Unit.INSTANCE;
            }
            if (this.$needSaveNewDraft) {
                String d26 = u.d2();
                Intrinsics.checkNotNullExpressionValue(d26, "formatMissionId()");
                str = str5;
                str2 = d26;
                winkEditDataWrapper = WinkEditDataWrapper.copy$default(c16, d26, null, null, null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2, 4095, null);
                com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, str2);
                com.tencent.mobileqq.wink.editor.draft.a.i(WinkEditDataWrapper.copy$default(d16, d26, null, null, null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2, 4095, null), str2);
            } else {
                str = str5;
                str2 = this.$missionId;
                winkEditDataWrapper = c16;
            }
            Integer from = c16.getFrom();
            if (from != null && from.intValue() == 7) {
                OneClickPublishingHelper.f325628a.G(this.$publishSource, str2, winkEditDataWrapper, WinkDraftGenerator.r(WinkDraftGenerator.f325956a, str2, this.$content, i3, false, false, 16, null), str, "", this.$extras);
            } else {
                OneClickPublishingHelper.f325628a.G(this.$publishSource, str2, winkEditDataWrapper, WinkDraftGenerator.r(WinkDraftGenerator.f325956a, str2, this.$content, i3, false, false, 24, null), str, this.$content, this.$extras);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OneClickPublishingHelper$publishByEditDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
