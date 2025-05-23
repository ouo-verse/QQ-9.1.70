package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.SmoothModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.device.LightDeviceUtils;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004J2\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u001c\u001a\u00020\u0007*\u00020\u0005J\n\u0010\u001e\u001a\u00020\u001d*\u00020\u0005J\u0016\u0010\u001f\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u001e\u0010%\u001a\u0004\u0018\u00010$2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0018\u00010!R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00102R\u0014\u00105\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "", DomainData.DOMAIN_NAME, "e", "mediaClip", "Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig$SharpenStrength;", "i", "sharpenStrengths", "t", "Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "mediaClipList", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "picDetectListener", "Lcom/tencent/mobileqq/wink/editor/dr;", "videoTavCut", "r", "d", "o", "", tl.h.F, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "l", "k", "Lkotlin/Pair;", "", "pair", "Lcom/tencent/videocut/model/SmoothModel;", "j", "Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig;", "b", "Lkotlin/Lazy;", "g", "()Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig;", "enhanceConfig", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mobileqq/wink/editor/hdr/c;", "c", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "mConcurrentLinkedQueue", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "picDetectJob", "I", "currentPhoneLevel", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkHDRPicQualityDetectUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkHDRPicQualityDetectUtils f320445a = new WinkHDRPicQualityDetectUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enhanceConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentLinkedQueue<PicDetectItem> mConcurrentLinkedQueue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job picDetectJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int currentPhoneLevel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "", "", "isBlur", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean isBlur);
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EnhanceConfig>() { // from class: com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils$enhanceConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnhanceConfig invoke() {
                return ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig();
            }
        });
        enhanceConfig = lazy;
        mConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        currentPhoneLevel = LightDeviceUtils.getPhonePerfLevel(com.tencent.mobileqq.wink.b.c());
    }

    WinkHDRPicQualityDetectUtils() {
    }

    private final boolean e(List<? extends MediaClip> mediaClips) {
        int i3;
        int i16;
        int coerceAtLeast;
        SizeF sizeF;
        SizeF sizeF2;
        if (mediaClips != null) {
            Iterator<T> it = mediaClips.iterator();
            while (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null && (sizeF2 = resourceModel.size) != null) {
                    i3 = (int) sizeF2.width;
                } else {
                    i3 = 0;
                }
                if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                    i16 = (int) sizeF.height;
                } else {
                    i16 = 0;
                }
                w53.b.a("WinkHDRPicQualityDetectUtils", "contains4KSizeMediaClip clipWidth:" + i3 + ", clipHeight:" + i16);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, i16);
                if (coerceAtLeast >= 3840) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnhanceConfig g() {
        Object value = enhanceConfig.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-enhanceConfig>(...)");
        return (EnhanceConfig) value;
    }

    private final EnhanceConfig.SharpenStrength i(MediaClip mediaClip) {
        float f16;
        float f17;
        float f18;
        RectF rectF;
        SizeF sizeF;
        SizeF sizeF2;
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            f16 = resourceModel.deblurScore;
        } else {
            f16 = 0.0f;
        }
        float f19 = 1.0f;
        if (f(mediaClip) > 0.0f) {
            f17 = 1.0f / f(mediaClip);
        } else {
            f17 = 1.0f;
        }
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null && (sizeF2 = resourceModel2.size) != null) {
            f18 = sizeF2.width;
        } else {
            f18 = 1.0f;
        }
        if (resourceModel2 != null && (sizeF = resourceModel2.size) != null) {
            f19 = sizeF.height;
        }
        if (resourceModel2 != null && (rectF = resourceModel2.picClipRect) != null) {
            f18 = Math.abs(rectF.right - rectF.left);
            f19 = Math.abs(rectF.bottom - rectF.top);
        }
        List<EnhanceConfig.SharpenStrength> g16 = g().g();
        if (g16 != null) {
            for (EnhanceConfig.SharpenStrength sharpenStrength : g16) {
                if (f16 >= sharpenStrength.getDeblurScoreStart() && f16 < sharpenStrength.getDeblurScoreEnd() && f17 >= sharpenStrength.getScaleStart() && f17 < sharpenStrength.getScaleEnd() && currentPhoneLevel >= sharpenStrength.getLowDeviceLevel() && f19 < sharpenStrength.getSizeEndHeight() && f19 >= sharpenStrength.getSizeStartHeight() && f18 < sharpenStrength.getSizeEndWidth() && f18 >= sharpenStrength.getSizeStartWidth()) {
                    return sharpenStrength;
                }
            }
        }
        return new EnhanceConfig.SharpenStrength();
    }

    private final boolean n(List<? extends MediaClip> mediaClips) {
        if (com.tencent.mobileqq.wink.editor.hdr.a.c() && !e(mediaClips)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Job launch$default;
        PicDetectItem poll = mConcurrentLinkedQueue.poll();
        if (poll != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkHDRPicQualityDetectUtils$startDetect$1(poll, null), 3, null);
            picDetectJob = launch$default;
        }
    }

    public static /* synthetic */ void s(WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils, u uVar, List list, a aVar, dr drVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            drVar = null;
        }
        winkHDRPicQualityDetectUtils.r(uVar, list, aVar, drVar);
    }

    public final void d() {
        Iterator<T> it = mConcurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((PicDetectItem) it.next()).f(true);
        }
    }

    public final float f(@NotNull MediaClip mediaClip) {
        ResourceModel resourceModel;
        RectF rectF;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        if (com.tencent.videocut.render.extension.e.o(mediaClip).width > 0.0f && com.tencent.videocut.render.extension.e.o(mediaClip).height > 0.0f && (resourceModel = mediaClip.resource) != null && (rectF = resourceModel.picClipRect) != null) {
            float abs = Math.abs(rectF.right - rectF.left);
            float abs2 = Math.abs(rectF.bottom - rectF.top);
            if (abs2 > 0.0f && abs > 0.0f) {
                return Math.min(com.tencent.videocut.render.extension.e.o(mediaClip).width / abs, com.tencent.videocut.render.extension.e.o(mediaClip).height / abs2);
            }
            return 1.0f;
        }
        return 1.0f;
    }

    public final int h() {
        return 1;
    }

    @Nullable
    public final SmoothModel j(@Nullable Pair<? extends MediaClip, Long> pair) {
        String str;
        boolean z16;
        long j3;
        if (pair == null) {
            return null;
        }
        MediaClip first = pair.getFirst();
        long longValue = pair.getSecond().longValue();
        EnhanceConfig.SharpenStrength i3 = i(first);
        SmoothModel.Builder builder = new SmoothModel.Builder();
        ResourceModel resourceModel = first.resource;
        if (resourceModel == null || (str = resourceModel.id) == null) {
            str = "";
        }
        builder.id = str;
        if (i3.getStrength() > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        builder.enableSharp = z16;
        builder.sharpenType = i3.getSharpenType();
        builder.sharpenStrength = i3.getStrength();
        builder.startOffsetUs = longValue;
        ResourceModel resourceModel2 = first.resource;
        if (resourceModel2 != null) {
            j3 = resourceModel2.scaleDuration;
        } else {
            j3 = 0;
        }
        builder.durationUs = j3;
        return builder.build();
    }

    @NotNull
    public final List<Integer> k(@Nullable List<? extends MediaClip> mediaClips) {
        ArrayList arrayList = new ArrayList();
        if (mediaClips != null) {
            int i3 = 0;
            for (Object obj : mediaClips) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (f320445a.i((MediaClip) obj).getSuperResolution() == 1) {
                    arrayList.add(Integer.valueOf(i3));
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    public final boolean l(@Nullable List<? extends MediaClip> mediaClips) {
        if (mediaClips != null) {
            Iterator<T> it = mediaClips.iterator();
            while (it.hasNext()) {
                EnhanceConfig.SharpenStrength i3 = f320445a.i((MediaClip) it.next());
                if (i3.getSuperResolution() != 0 || i3.getStrength() > 0.0f) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean m(@NotNull MediaClip mediaClip) {
        float f16;
        Float f17;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            f16 = resourceModel.deblurScore;
        } else {
            f16 = -1.0f;
        }
        float f18 = f(mediaClip);
        if (f18 > 0.0f && f16 >= g().getDeblurAverageScore()) {
            f16 = (float) (((f16 * 0.750518269317816d) - 17.7069233738405d) + ((1 / f18) * 34.6272033511921d));
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                f17 = Float.valueOf(resourceModel2.deblurScore);
            } else {
                f17 = null;
            }
            w53.b.a("WinkHDRPicQualityDetectUtils", "blur crop scale:" + f18 + ", deblurScore:" + f16 + ", originDeblurScore:" + f17 + " ,deblurAverageScore:" + g().getDeblurAverageScore() + "}");
        }
        if (f16 > 0.0f && f16 <= g().getDeblurAverageScore()) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        Job job = picDetectJob;
        if (job == null || !job.isActive()) {
            return false;
        }
        return true;
    }

    public final boolean p(@Nullable List<? extends MediaClip> mediaClips) {
        if (mediaClips != null) {
            Iterator<T> it = mediaClips.iterator();
            while (it.hasNext()) {
                if (f320445a.m((MediaClip) it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void r(@NotNull u winkExportViewModel, @Nullable List<? extends MediaClip> mediaClipList, @NotNull a picDetectListener, @Nullable dr videoTavCut) {
        Intrinsics.checkNotNullParameter(winkExportViewModel, "winkExportViewModel");
        Intrinsics.checkNotNullParameter(picDetectListener, "picDetectListener");
        if (!n(mediaClipList)) {
            w53.b.f("WinkHDRPicQualityDetectUtils", "isEnablePicQualityDetect false, exit startPicQualityDetect");
            return;
        }
        mConcurrentLinkedQueue.add(new PicDetectItem(winkExportViewModel, mediaClipList, picDetectListener, videoTavCut, false, 16, null));
        Job job = picDetectJob;
        if (job != null) {
            boolean z16 = false;
            if (job != null && job.isCompleted()) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
        }
        q();
    }

    public final void t(@Nullable List<EnhanceConfig.SharpenStrength> sharpenStrengths) {
        g().i(sharpenStrengths);
    }
}
