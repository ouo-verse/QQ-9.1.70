package com.tencent.tavcut.render.builder.light;

import android.graphics.RectF;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.transform.MatrixTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.ClipAsset;
import org.light.PhotoClip;
import org.light.TimeLine;
import org.light.TimeRange;
import org.light.VideoClip;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/a;", "", "", "Lcom/tencent/tavcut/model/ClipSource;", "clipSources", "Lorg/light/ClipAsset;", "a", "", "Lorg/light/TimeLine;", "timeLines", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "b", "([Lorg/light/TimeLine;)Ljava/util/List;", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f374378a = new a();

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @NotNull
    public static final List<ClipAsset> a(@NotNull List<ClipSource> clipSources) {
        float f16;
        long j3;
        VideoClip videoClip;
        float f17;
        float f18;
        float f19;
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        ArrayList arrayList = new ArrayList();
        for (ClipSource clipSource : clipSources) {
            if (clipSource.type == ClipSource.ClipType.PHOTO) {
                PhotoClip photoClip = new PhotoClip();
                photoClip.photoEffectPath = clipSource.photoEffectPath;
                videoClip = photoClip;
            } else {
                VideoClip videoClip2 = new VideoClip();
                Float f26 = clipSource.speed;
                float f27 = 1.0f;
                if (f26 != null) {
                    f16 = f26.floatValue();
                } else {
                    f16 = 1.0f;
                }
                videoClip2.speed = f16;
                Float f28 = clipSource.volume;
                if (f28 != null) {
                    f27 = f28.floatValue();
                }
                videoClip2.volume = f27;
                Long l3 = clipSource.startOffset;
                if (l3 != null) {
                    j3 = l3.longValue();
                } else {
                    j3 = 0;
                }
                videoClip2.startOffset = j3;
                videoClip = videoClip2;
            }
            Rect rect = clipSource.clipRect;
            float f29 = 0.0f;
            if (rect != null) {
                f17 = rect.left;
            } else {
                f17 = 0.0f;
            }
            if (rect != null) {
                f18 = rect.top;
            } else {
                f18 = 0.0f;
            }
            if (rect != null) {
                f19 = rect.right;
            } else {
                f19 = 0.0f;
            }
            if (rect != null) {
                f29 = rect.bottom;
            }
            videoClip.clipRect = new RectF(f17, f18, f19, f29);
            videoClip.duration = clipSource.duration;
            videoClip.path = clipSource.path;
            videoClip.matrix = MatrixTransform.transListMatrixToMatrix(clipSource.matrix);
            arrayList.add(videoClip);
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<Timeline> b(@NotNull TimeLine[] timeLines) {
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        ArrayList arrayList = new ArrayList();
        for (TimeLine timeLine : timeLines) {
            Integer valueOf = Integer.valueOf(timeLine.entityID);
            String str = timeLine.type;
            TimeRange timeRange = timeLine.range;
            arrayList.add(new Timeline(valueOf, str, new com.tencent.tavcut.composition.model.component.TimeRange(timeRange.startTime, timeRange.duration, null, 4, null), Long.valueOf(timeLine.time), timeLine.event, null, 32, null));
        }
        return arrayList;
    }
}
