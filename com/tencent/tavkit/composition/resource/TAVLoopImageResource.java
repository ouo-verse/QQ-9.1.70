package com.tencent.tavkit.composition.resource;

import android.util.SparseArray;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0001H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavkit/composition/resource/TAVLoopImageResource;", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "images", "", "Lcom/tencent/tavkit/ciimage/CIImage;", WidgetCacheConstellationData.INTERVAL, "Lcom/tencent/tav/coremedia/CMTime;", "duration", "(Ljava/util/List;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V", "ciImageHashMap", "Ljava/lang/ThreadLocal;", "Landroid/util/SparseArray;", "clone", "imageAtTime", "time", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "tavkit_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TAVLoopImageResource extends TAVResource {
    private final ThreadLocal<SparseArray<CIImage>> ciImageHashMap;
    private final List<CIImage> images;
    private final CMTime interval;

    /* JADX WARN: Multi-variable type inference failed */
    public TAVLoopImageResource(@NotNull List<? extends CIImage> images, @NotNull CMTime interval, @NotNull CMTime duration) {
        Intrinsics.checkParameterIsNotNull(images, "images");
        Intrinsics.checkParameterIsNotNull(interval, "interval");
        Intrinsics.checkParameterIsNotNull(duration, "duration");
        this.images = images;
        this.interval = interval;
        this.ciImageHashMap = new ThreadLocal<>();
        setDuration(duration);
        setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, duration));
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    @Nullable
    public CIImage imageAtTime(@NotNull CMTime time, @NotNull CGSize renderSize) {
        Intrinsics.checkParameterIsNotNull(time, "time");
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        if (!this.sourceTimeRange.containsTime(time) || this.images.isEmpty()) {
            return null;
        }
        ThreadLocal<SparseArray<CIImage>> threadLocal = this.ciImageHashMap;
        SparseArray<CIImage> sparseArray = threadLocal.get();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            threadLocal.set(sparseArray);
        }
        SparseArray<CIImage> sparseArray2 = sparseArray;
        int timeUs = (int) ((time.getTimeUs() / this.interval.getTimeUs()) % this.images.size());
        CIImage cIImage = sparseArray2.get(timeUs);
        if (cIImage != null) {
            cIImage.reset();
            return cIImage;
        }
        sparseArray2.put(timeUs, this.images.get(timeUs).m267clone());
        return sparseArray2.get(timeUs);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    @NotNull
    /* renamed from: clone */
    public TAVResource mo272clone() {
        List<CIImage> list = this.images;
        CMTime cMTime = this.interval;
        CMTime duration = this.duration;
        Intrinsics.checkExpressionValueIsNotNull(duration, "duration");
        return new TAVLoopImageResource(list, cMTime, duration);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TAVLoopImageResource(List list, CMTime cMTime, CMTime cMTime2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, cMTime, cMTime2);
        if ((i3 & 4) != 0) {
            cMTime2 = CMTime.fromUs(list.size() * cMTime.getTimeUs());
            Intrinsics.checkExpressionValueIsNotNull(cMTime2, "CMTime.fromUs(images.size * interval.timeUs)");
        }
    }
}
