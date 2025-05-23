package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$handleAigcTemplate$1", f = "WinkEditorOpeningEndingViewModel.kt", i = {0, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {357, 369, com.tencent.luggage.wxa.se.b.CTRL_INDEX, 376, LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE}, m = "invokeSuspend", n = {"totalStartTime", "totalStartTime", "startTime", "totalStartTime", "styleId", "totalStartTime", "startTime", "styleId", "totalStartTime", "startTime", "aigcImagePath", "totalStartTime", "startTime"}, s = {"J$0", "J$0", "J$1", "J$0", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$handleAigcTemplate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpeningEndingAigcData $aigcData;
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $isFromClipping;
    final /* synthetic */ MetaMaterial $material;
    final /* synthetic */ WeakReference<Activity> $weakActivity;
    long J$0;
    long J$1;
    Object L$0;
    int label;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingViewModel$handleAigcTemplate$1(MetaMaterial metaMaterial, WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, String str, OpeningEndingAigcData openingEndingAigcData, WeakReference<Activity> weakReference, boolean z16, Continuation<? super WinkEditorOpeningEndingViewModel$handleAigcTemplate$1> continuation) {
        super(2, continuation);
        this.$material = metaMaterial;
        this.this$0 = winkEditorOpeningEndingViewModel;
        this.$filePath = str;
        this.$aigcData = openingEndingAigcData;
        this.$weakActivity = weakReference;
        this.$isFromClipping = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorOpeningEndingViewModel$handleAigcTemplate$1(this.$material, this.this$0, this.$filePath, this.$aigcData, this.$weakActivity, this.$isFromClipping, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0244  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long elapsedRealtime;
        Object b16;
        long j3;
        Object b17;
        long j16;
        OpeningEndingAigcData openingEndingAigcData;
        Object i3;
        long j17;
        OpeningEndingAigcData openingEndingAigcData2;
        Object first;
        WinkAIGCService l26;
        String imageUploadUrl;
        String str;
        long j18;
        long j19;
        long elapsedRealtime2;
        Object d16;
        String str2;
        String k26;
        long j26;
        Object f16;
        String str3;
        long j27;
        final Intent d26;
        List<String> mutableListOf;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b bVar;
        WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                elapsedRealtime = SystemClock.elapsedRealtime();
                WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
                MetaMaterial metaMaterial = this.$material;
                this.J$0 = elapsedRealtime;
                this.label = 1;
                b16 = com.tencent.mobileqq.wink.edit.manager.ak.b(a16, metaMaterial, null, this, 2, null);
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) b16).booleanValue()) {
                    w53.b.c("WinkEditorOpeningEndingViewModel", "download material failed, id: " + this.$material.f30533id);
                    this.this$0.y2(true, false, "");
                    return Unit.INSTANCE;
                }
                WinkEditorResourceManager.a1().i0(this.$material);
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                String c16 = this.this$0.l2().c(this.$filePath);
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate compress costtime: " + (SystemClock.elapsedRealtime() - elapsedRealtime3));
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                OpeningEndingAigcData openingEndingAigcData3 = this.$aigcData;
                com.tencent.mobileqq.wink.utils.al alVar = com.tencent.mobileqq.wink.utils.al.f326675a;
                this.L$0 = openingEndingAigcData3;
                this.J$0 = elapsedRealtime;
                this.J$1 = elapsedRealtime4;
                this.label = 2;
                j3 = elapsedRealtime4;
                b17 = com.tencent.mobileqq.wink.utils.al.b(alVar, c16, false, this, 2, null);
                if (b17 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j16 = elapsedRealtime;
                openingEndingAigcData = openingEndingAigcData3;
                openingEndingAigcData.setImageUploadUrl((String) b17);
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate uploadImage costtime: " + (SystemClock.elapsedRealtime() - j3));
                OpeningEndingAigcData openingEndingAigcData4 = this.$aigcData;
                WinkAIGCService l27 = this.this$0.l2();
                String imageUploadUrl2 = this.$aigcData.getImageUploadUrl();
                this.L$0 = openingEndingAigcData4;
                this.J$0 = j16;
                this.label = 3;
                i3 = l27.i("opening_ending", imageUploadUrl2, this);
                if (i3 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                j17 = j16;
                openingEndingAigcData2 = openingEndingAigcData4;
                openingEndingAigcData2.setSafeId((String) i3);
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.$aigcData.getStyleMaterials());
                String z06 = com.tencent.mobileqq.wink.editor.c.z0((MetaMaterial) first);
                long elapsedRealtime5 = SystemClock.elapsedRealtime();
                l26 = this.this$0.l2();
                imageUploadUrl = this.$aigcData.getImageUploadUrl();
                this.L$0 = z06;
                this.J$0 = j17;
                this.J$1 = elapsedRealtime5;
                this.label = 4;
                if (l26.b("opening_ending", imageUploadUrl, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = z06;
                j18 = elapsedRealtime5;
                j19 = j17;
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate checkImageValid costtime: " + (SystemClock.elapsedRealtime() - j18));
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                WinkAIGCService l28 = this.this$0.l2();
                String imageUploadUrl3 = this.$aigcData.getImageUploadUrl();
                String safeId = this.$aigcData.getSafeId();
                this.L$0 = str;
                this.J$0 = j19;
                this.J$1 = elapsedRealtime2;
                this.label = 5;
                d16 = l28.d(imageUploadUrl3, str, safeId, this);
                if (d16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long j28 = j19;
                str2 = (String) d16;
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate generateImage costtime: " + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                if (str2 != null) {
                    k26 = this.this$0.k2(str2);
                    this.$aigcData.getAigcImagePathMap().put(str, k26);
                    long elapsedRealtime6 = SystemClock.elapsedRealtime();
                    WinkEditorResourceManager a17 = WinkEditorResourceManager.a1();
                    Intrinsics.checkNotNullExpressionValue(a17, "getInstance()");
                    this.L$0 = k26;
                    this.J$0 = j28;
                    this.J$1 = elapsedRealtime6;
                    this.label = 6;
                    j26 = elapsedRealtime6;
                    f16 = com.tencent.mobileqq.wink.edit.manager.ak.f(a17, str2, k26, null, this, 4, null);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str3 = k26;
                    j27 = j28;
                    if (((Boolean) f16).booleanValue()) {
                        this.this$0.y2(true, false, "");
                        return Unit.INSTANCE;
                    }
                    w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate downloadUrl costtime: " + (SystemClock.elapsedRealtime() - j26));
                    long elapsedRealtime7 = SystemClock.elapsedRealtime() - j27;
                    w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate total costtime: " + elapsedRealtime7);
                    com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.a();
                    Activity activity = this.$weakActivity.get();
                    Intrinsics.checkNotNull(activity);
                    final Activity activity2 = activity;
                    d26 = this.this$0.d2(activity2, this.$material, this.$isFromClipping, this.$aigcData, elapsedRealtime7);
                    com.tencent.mobileqq.wink.utils.o oVar = com.tencent.mobileqq.wink.utils.o.f326724a;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str3);
                    List<LocalMediaInfo> i16 = oVar.i(mutableListOf);
                    bVar = this.this$0.nextStepUIStateUpdater;
                    if (bVar != null) {
                        winkMediaPickerNextStepHelper = new WinkMediaPickerNextStepHelper(bVar);
                    } else {
                        winkMediaPickerNextStepHelper = null;
                    }
                    if (winkMediaPickerNextStepHelper != null) {
                        TabType tabType = TabType.ALL_MEDIA;
                        MediaPickerScene mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY;
                        TemplateLibraryData templateLibraryData = new TemplateLibraryData(this.$material, false, 0);
                        final WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel = this.this$0;
                        winkMediaPickerNextStepHelper.h(activity2, tabType, i16, false, mediaPickerScene, templateLibraryData, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$handleAigcTemplate$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                                invoke2(mediaPickerOutput);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull MediaPickerOutput output) {
                                Intrinsics.checkNotNullParameter(output, "output");
                                com.tencent.mobileqq.wink.picker.g.d(activity2, d26, output);
                                winkEditorOpeningEndingViewModel.y2(false, false, "");
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
                this.this$0.y2(true, false, "");
                return Unit.INSTANCE;
            case 1:
                long j29 = this.J$0;
                ResultKt.throwOnFailure(obj);
                elapsedRealtime = j29;
                b16 = obj;
                if (((Boolean) b16).booleanValue()) {
                }
                break;
            case 2:
                long j36 = this.J$1;
                j16 = this.J$0;
                openingEndingAigcData = (OpeningEndingAigcData) this.L$0;
                ResultKt.throwOnFailure(obj);
                j3 = j36;
                b17 = obj;
                openingEndingAigcData.setImageUploadUrl((String) b17);
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate uploadImage costtime: " + (SystemClock.elapsedRealtime() - j3));
                OpeningEndingAigcData openingEndingAigcData42 = this.$aigcData;
                WinkAIGCService l272 = this.this$0.l2();
                String imageUploadUrl22 = this.$aigcData.getImageUploadUrl();
                this.L$0 = openingEndingAigcData42;
                this.J$0 = j16;
                this.label = 3;
                i3 = l272.i("opening_ending", imageUploadUrl22, this);
                if (i3 != coroutine_suspended) {
                }
                break;
            case 3:
                long j37 = this.J$0;
                openingEndingAigcData2 = (OpeningEndingAigcData) this.L$0;
                ResultKt.throwOnFailure(obj);
                j17 = j37;
                i3 = obj;
                openingEndingAigcData2.setSafeId((String) i3);
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.$aigcData.getStyleMaterials());
                String z062 = com.tencent.mobileqq.wink.editor.c.z0((MetaMaterial) first);
                long elapsedRealtime52 = SystemClock.elapsedRealtime();
                l26 = this.this$0.l2();
                imageUploadUrl = this.$aigcData.getImageUploadUrl();
                this.L$0 = z062;
                this.J$0 = j17;
                this.J$1 = elapsedRealtime52;
                this.label = 4;
                if (l26.b("opening_ending", imageUploadUrl, this) != coroutine_suspended) {
                }
                break;
            case 4:
                j18 = this.J$1;
                j19 = this.J$0;
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate checkImageValid costtime: " + (SystemClock.elapsedRealtime() - j18));
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                WinkAIGCService l282 = this.this$0.l2();
                String imageUploadUrl32 = this.$aigcData.getImageUploadUrl();
                String safeId2 = this.$aigcData.getSafeId();
                this.L$0 = str;
                this.J$0 = j19;
                this.J$1 = elapsedRealtime2;
                this.label = 5;
                d16 = l282.d(imageUploadUrl32, str, safeId2, this);
                if (d16 == coroutine_suspended) {
                }
                long j282 = j19;
                str2 = (String) d16;
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate generateImage costtime: " + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                if (str2 != null) {
                }
                break;
            case 5:
                elapsedRealtime2 = this.J$1;
                j19 = this.J$0;
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                d16 = obj;
                long j2822 = j19;
                str2 = (String) d16;
                w53.b.f("WinkEditorOpeningEndingViewModel", "handleAigcTemplate generateImage costtime: " + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                if (str2 != null) {
                }
                break;
            case 6:
                long j38 = this.J$1;
                j27 = this.J$0;
                str3 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                j26 = j38;
                f16 = obj;
                if (((Boolean) f16).booleanValue()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorOpeningEndingViewModel$handleAigcTemplate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
