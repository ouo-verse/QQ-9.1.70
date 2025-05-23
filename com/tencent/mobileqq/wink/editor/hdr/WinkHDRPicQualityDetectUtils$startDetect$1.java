package com.tencent.mobileqq.wink.editor.hdr;

import com.gyailib.library.GYAssessPicQualityOption;
import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.export.v;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils$startDetect$1", f = "WinkHDRPicQualityDetectUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkHDRPicQualityDetectUtils$startDetect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PicDetectItem $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkHDRPicQualityDetectUtils$startDetect$1(PicDetectItem picDetectItem, Continuation<? super WinkHDRPicQualityDetectUtils$startDetect$1> continuation) {
        super(2, continuation);
        this.$item = picDetectItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkHDRPicQualityDetectUtils$startDetect$1(this.$item, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList arrayList;
        Integer num;
        boolean z16;
        List<MediaClip> b16;
        String str;
        ResourceModel resourceModel;
        float f16;
        float f17;
        String str2;
        GYAssessPicQualityOption gyAssessPicQualityOption;
        EnhanceConfig g16;
        Float f18;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<MediaClip> b17 = this.$item.b();
            if (b17 != null) {
                arrayList = new ArrayList();
                for (Object obj2 : b17) {
                    ResourceModel resourceModel2 = ((MediaClip) obj2).resource;
                    if (resourceModel2 != null) {
                        f18 = Boxing.boxFloat(resourceModel2.deblurScore);
                    } else {
                        f18 = null;
                    }
                    if (Intrinsics.areEqual(f18, 0.0f)) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                num = Boxing.boxInt(arrayList.size());
            } else {
                num = null;
            }
            w53.b.a("WinkHDRPicQualityDetectUtils", "startPicQualityDetect needDetectClips length is :" + num);
            Map map = (Map) this.$item.getWinkExportViewModel().X1(arrayList, null).second;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && map.isEmpty()) {
                this.$item.getPicDetectListener().a(false);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (arrayList != null) {
                    int i3 = 0;
                    for (Object obj3 : arrayList) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        MediaClip mediaClip = (MediaClip) obj3;
                        v vVar = (v) map.get(Boxing.boxInt(i3));
                        if (vVar != null && (gyAssessPicQualityOption = vVar.b()) != null) {
                            Intrinsics.checkNotNullExpressionValue(gyAssessPicQualityOption, "gyAssessPicQualityOption");
                            f17 = gyAssessPicQualityOption.deblurAvgScore;
                            if (gyAssessPicQualityOption.enableDelogo == 1) {
                                g16 = WinkHDRPicQualityDetectUtils.f320445a.g();
                                f17 -= g16.getBlurBias();
                            }
                        } else {
                            f17 = -1.0f;
                        }
                        ResourceModel resourceModel3 = mediaClip.resource;
                        if (resourceModel3 != null && (str2 = resourceModel3.id) != null) {
                            linkedHashMap.put(str2, Boxing.boxFloat(f17));
                        }
                        i3 = i16;
                    }
                }
                dr videoTavCut = this.$item.getVideoTavCut();
                if (videoTavCut == null || (b16 = videoTavCut.a0()) == null) {
                    b16 = this.$item.b();
                }
                if (b16 != null) {
                    for (MediaClip mediaClip2 : b16) {
                        ResourceModel resourceModel4 = mediaClip2.resource;
                        if (resourceModel4 != null) {
                            str = resourceModel4.id;
                        } else {
                            str = null;
                        }
                        if (linkedHashMap.containsKey(str) && (resourceModel = mediaClip2.resource) != null) {
                            Float f19 = (Float) linkedHashMap.get(str);
                            if (f19 != null) {
                                f16 = f19.floatValue();
                            } else {
                                f16 = -1.0f;
                            }
                            resourceModel.deblurScore = f16;
                        }
                    }
                }
                w53.b.a("WinkHDRPicQualityDetectUtils", "startPicQualityDetect consume:" + this.$item.hashCode());
                if (!this.$item.getCanceled()) {
                    this.$item.getPicDetectListener().a(WinkHDRPicQualityDetectUtils.f320445a.p(b16));
                } else {
                    this.$item.getPicDetectListener().a(false);
                }
                WinkHDRPicQualityDetectUtils.picDetectJob = null;
                WinkHDRPicQualityDetectUtils.f320445a.q();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkHDRPicQualityDetectUtils$startDetect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
