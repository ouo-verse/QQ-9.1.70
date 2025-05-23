package com.tencent.tavcut.core.render.builder.light;

import android.graphics.RectF;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.util.MatrixTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.light.ClipAsset;
import org.light.PhotoClip;
import org.light.TimeLine;
import org.light.TimeRange;
import org.light.VideoClip;
import org.light.lightAssetKit.components.Rect;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightEntityTransHelper;", "", "()V", "copyByteArray", "", "byteArray", "transClipSourcesToClipAssets", "", "Lorg/light/ClipAsset;", "clipSources", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "transLightTimeLineToTimeline", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "timeLines", "", "Lorg/light/TimeLine;", "([Lorg/light/TimeLine;)Ljava/util/List;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightEntityTransHelper {
    public static final LightEntityTransHelper INSTANCE = new LightEntityTransHelper();

    LightEntityTransHelper() {
    }

    private final byte[] copyByteArray(byte[] byteArray) {
        if (byteArray == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[byteArray.length];
        if (byteArray.length <= 0) {
            return bArr;
        }
        int length = byteArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = byteArray[i3];
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @NotNull
    public static final List<ClipAsset> transClipSourcesToClipAssets(@NotNull List<ClipSource> clipSources) {
        float f16;
        long j3;
        boolean z16;
        VideoClip videoClip;
        float f17;
        float f18;
        float f19;
        byte[] bArr;
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        ArrayList arrayList = new ArrayList();
        for (ClipSource clipSource : clipSources) {
            if (clipSource.getType() == ClipType.PHOTO) {
                PhotoClip photoClip = new PhotoClip();
                photoClip.photoEffectPath = clipSource.getPhotoEffectPath();
                LightEntityTransHelper lightEntityTransHelper = INSTANCE;
                ByteString byteArray = clipSource.getByteArray();
                if (byteArray != null) {
                    bArr = byteArray.toByteArray();
                } else {
                    bArr = null;
                }
                photoClip.bytes = lightEntityTransHelper.copyByteArray(bArr);
                videoClip = photoClip;
            } else {
                VideoClip videoClip2 = new VideoClip();
                Float speed = clipSource.getSpeed();
                float f26 = 1.0f;
                if (speed != null) {
                    f16 = speed.floatValue();
                } else {
                    f16 = 1.0f;
                }
                videoClip2.speed = f16;
                Float volume = clipSource.getVolume();
                if (volume != null) {
                    f26 = volume.floatValue();
                }
                videoClip2.volume = f26;
                Long startOffset = clipSource.getStartOffset();
                if (startOffset != null) {
                    j3 = startOffset.longValue();
                } else {
                    j3 = 0;
                }
                videoClip2.startOffset = j3;
                Boolean autoLoop = clipSource.getAutoLoop();
                if (autoLoop != null) {
                    z16 = autoLoop.booleanValue();
                } else {
                    z16 = false;
                }
                videoClip2.autoLoop = z16;
                videoClip = videoClip2;
            }
            Rect clipRect = clipSource.getClipRect();
            float f27 = 0.0f;
            if (clipRect != null) {
                f17 = clipRect.left;
            } else {
                f17 = 0.0f;
            }
            Rect clipRect2 = clipSource.getClipRect();
            if (clipRect2 != null) {
                f18 = clipRect2.top;
            } else {
                f18 = 0.0f;
            }
            Rect clipRect3 = clipSource.getClipRect();
            if (clipRect3 != null) {
                f19 = clipRect3.right;
            } else {
                f19 = 0.0f;
            }
            Rect clipRect4 = clipSource.getClipRect();
            if (clipRect4 != null) {
                f27 = clipRect4.bottom;
            }
            videoClip.clipRect = new RectF(f17, f18, f19, f27);
            videoClip.duration = clipSource.getDuration();
            videoClip.path = clipSource.getPath();
            videoClip.matrix = MatrixTransform.transListMatrixToMatrix(clipSource.getMatrix());
            arrayList.add(videoClip);
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<Timeline> transLightTimeLineToTimeline(@NotNull TimeLine[] timeLines) {
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        ArrayList arrayList = new ArrayList();
        for (TimeLine timeLine : timeLines) {
            Integer valueOf = Integer.valueOf(timeLine.entityID);
            String str = timeLine.type;
            TimeRange timeRange = timeLine.range;
            arrayList.add(new Timeline(valueOf, str, new TimeRange(timeRange.startTime, timeRange.duration), Long.valueOf(timeLine.time), timeLine.event));
        }
        return arrayList;
    }
}
