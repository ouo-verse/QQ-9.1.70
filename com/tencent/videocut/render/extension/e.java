package com.tencent.videocut.render.extension;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.openingending.OpeningEndingAigcData;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaClipForCover;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Rect;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u001a\u0014\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a)\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\n\u0010\u0012\u001a\u00020\u0000*\u00020\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018\u001a3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001b2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\"\u0010 \u001a\u0004\u0018\u00010\u0000*\u00020\u000f2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e\u001a2\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u000f0\u001b2\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e0\u001b\u001a,\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\u00020\"2\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e0\u001b\u001a$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b\u001a$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b\u001a\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001b\u001a\u0012\u0010(\u001a\u00020\f*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001b\u001a\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u00000\u001b\u001a\u001e\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00180**\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001b\u001a\u0016\u00100\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-*\u00020\u0000\u001a\u0010\u00101\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00000\u001b\u001a\u0016\u00104\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u0000\u001aN\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u001b2\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u00020\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0004\u001a*\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b2\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010?\u001a\u00020\u0014*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001b\u001a\u0010\u0010@\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00000\u001b\"\u0015\u0010C\u001a\u00020\u0004*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bA\u0010B\"\u0015\u0010G\u001a\u00020D*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010B\"\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bK\u0010B\"\u0017\u0010N\u001a\u0004\u0018\u00010\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006O"}, d2 = {"Lcom/tencent/videocut/model/MediaClip;", "Lcom/tencent/videocut/render/extension/MediaClipUseType;", "useType", "e", "", "templateId", "d", "missionId", "b", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "aigcData", "c", "", "useOriginDuration", "needAutoLoop", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "y", "(Lcom/tencent/videocut/model/MediaClip;ZLjava/lang/Boolean;)Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "l", "mediaClip", "", "duration", UserInfo.SEX_FEMALE, "f", "", "value", "G", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/util/List;ZLjava/lang/Boolean;)Ljava/util/List;", "", "extrasMap", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "E", "originClips", "I", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "w", "", "", "g", "Lkotlin/Pair;", "Landroid/graphics/Matrix;", "Landroid/graphics/RectF;", tl.h.F, "i", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "a", "width", "height", "path", "", "byteArray", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "id", "Lcom/tencent/videocut/model/MediaClipForCover;", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", DomainData.DOMAIN_NAME, "(Lcom/tencent/videocut/model/MediaClip;)Ljava/lang/String;", "resId", "Lcom/tencent/videocut/model/SizeF;", "o", "(Lcom/tencent/videocut/model/MediaClip;)Lcom/tencent/videocut/model/SizeF;", "size", "r", "(Lcom/tencent/videocut/model/MediaClip;)Lcom/tencent/videocut/render/extension/MediaClipUseType;", "p", "j", "k", "(Lcom/tencent/videocut/model/MediaClip;)Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "openingEndingAigcData", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class e {
    public static /* synthetic */ ClipSource A(MediaClip mediaClip, boolean z16, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        return y(mediaClip, z16, bool);
    }

    public static /* synthetic */ List B(List list, boolean z16, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        return z(list, z16, bool);
    }

    @Nullable
    public static final MediaClip C(@NotNull ClipSource clipSource, @NotNull Map<String, String> extrasMap) {
        float f16;
        MediaType mediaType;
        RectF rectF;
        float f17;
        MediaType mediaType2;
        RectF rectF2;
        Intrinsics.checkNotNullParameter(clipSource, "<this>");
        Intrinsics.checkNotNullParameter(extrasMap, "extrasMap");
        long j3 = 0;
        float f18 = 1.0f;
        String str = "";
        if (!Intrinsics.areEqual(clipSource.getByteArray(), ByteString.EMPTY)) {
            String sourceId = clipSource.getSourceId();
            if (sourceId == null) {
                sourceId = "";
            }
            String path = clipSource.getPath();
            if (path != null) {
                str = path;
            }
            long duration = clipSource.getDuration();
            float duration2 = (float) clipSource.getDuration();
            Float speed = clipSource.getSpeed();
            if (speed != null) {
                f17 = speed.floatValue();
            } else {
                f17 = 1.0f;
            }
            long j16 = duration2 / f17;
            long duration3 = clipSource.getDuration();
            if (clipSource.getType() == ClipType.PHOTO) {
                mediaType2 = MediaType.IMAGE;
            } else {
                mediaType2 = MediaType.VIDEO;
            }
            MediaType mediaType3 = mediaType2;
            SizeF sizeF = new SizeF(720.0f, 1280.0f, null, 4, null);
            Float volume = clipSource.getVolume();
            if (volume != null) {
                f18 = volume.floatValue();
            }
            float f19 = f18;
            Long startOffset = clipSource.getStartOffset();
            if (startOffset != null) {
                j3 = startOffset.longValue();
            }
            long j17 = j3;
            Rect clipRect = clipSource.getClipRect();
            if (clipRect != null) {
                rectF2 = new RectF(clipRect.left, clipRect.top, clipRect.right, clipRect.bottom, null, 16, null);
            } else {
                rectF2 = null;
            }
            return new MediaClipForCover(new ResourceModel(sourceId, str, j16, 0L, duration, j17, duration3, mediaType3, sizeF, f19, extrasMap, rectF2, null, null, null, 0.0f, null, 126976, null), t.a(), null, null, null, null, null, clipSource.getByteArray(), 124, null);
        }
        String sourceId2 = clipSource.getSourceId();
        if (sourceId2 == null) {
            sourceId2 = "";
        }
        String path2 = clipSource.getPath();
        if (path2 != null) {
            str = path2;
        }
        long duration4 = clipSource.getDuration();
        float duration5 = (float) clipSource.getDuration();
        Float speed2 = clipSource.getSpeed();
        if (speed2 != null) {
            f16 = speed2.floatValue();
        } else {
            f16 = 1.0f;
        }
        long j18 = duration5 / f16;
        long duration6 = clipSource.getDuration();
        if (clipSource.getType() == ClipType.PHOTO) {
            mediaType = MediaType.IMAGE;
        } else {
            mediaType = MediaType.VIDEO;
        }
        MediaType mediaType4 = mediaType;
        SizeF sizeF2 = new SizeF(720.0f, 1280.0f, null, 4, null);
        Float volume2 = clipSource.getVolume();
        if (volume2 != null) {
            f18 = volume2.floatValue();
        }
        float f26 = f18;
        Long startOffset2 = clipSource.getStartOffset();
        if (startOffset2 != null) {
            j3 = startOffset2.longValue();
        }
        long j19 = j3;
        Rect clipRect2 = clipSource.getClipRect();
        if (clipRect2 != null) {
            rectF = new RectF(clipRect2.left, clipRect2.top, clipRect2.right, clipRect2.bottom, null, 16, null);
        } else {
            rectF = null;
        }
        return new MediaClip(new ResourceModel(sourceId2, str, j18, 0L, duration4, j19, duration6, mediaType4, sizeF2, f26, extrasMap, rectF, null, null, null, 0.0f, null, 126976, null), t.a(), null, null, null, clipSource.getMatrix(), null, 92, null);
    }

    @NotNull
    public static final List<MediaClip> D(@NotNull List<ClipSource> list, @NotNull List<? extends Map<String, String>> extrasMap) {
        int collectionSizeOrDefault;
        Object orNull;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(extrasMap, "extrasMap");
        List<ClipSource> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ClipSource clipSource = (ClipSource) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(extrasMap, i3);
            Map map = (Map) orNull;
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            MediaClip C = C(clipSource, map);
            Intrinsics.checkNotNull(C);
            arrayList.add(C);
            i3 = i16;
        }
        return arrayList;
    }

    @NotNull
    public static final List<MediaClip> E(@NotNull LAKRenderModel lAKRenderModel, @NotNull List<? extends Map<String, String>> extrasMap) {
        int collectionSizeOrDefault;
        Object orNull;
        Intrinsics.checkNotNullParameter(lAKRenderModel, "<this>");
        Intrinsics.checkNotNullParameter(extrasMap, "extrasMap");
        List<ClipSource> clipsAssets = lAKRenderModel.getClipsAssets();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(clipsAssets, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : clipsAssets) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ClipSource clipSource = (ClipSource) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(extrasMap, i3);
            Map map = (Map) orNull;
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            MediaClip C = C(clipSource, map);
            Intrinsics.checkNotNull(C);
            arrayList.add(C);
            i3 = i16;
        }
        return arrayList;
    }

    @NotNull
    public static final MediaClip F(@NotNull MediaClip mediaClip, long j3) {
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : Long.valueOf(j3), (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(j3), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final ClipSource G(@NotNull ClipSource clipSource, float f16) {
        ClipSource copy;
        Intrinsics.checkNotNullParameter(clipSource, "<this>");
        copy = clipSource.copy((r30 & 1) != 0 ? clipSource.sourceId : null, (r30 & 2) != 0 ? clipSource.path : null, (r30 & 4) != 0 ? clipSource.type : null, (r30 & 8) != 0 ? clipSource.duration : 0L, (r30 & 16) != 0 ? clipSource.speed : null, (r30 & 32) != 0 ? clipSource.volume : Float.valueOf(f16), (r30 & 64) != 0 ? clipSource.startOffset : null, (r30 & 128) != 0 ? clipSource.matrix : null, (r30 & 256) != 0 ? clipSource.photoEffectPath : null, (r30 & 512) != 0 ? clipSource.transform : null, (r30 & 1024) != 0 ? clipSource.clipRect : null, (r30 & 2048) != 0 ? clipSource.byteArray : null, (r30 & 4096) != 0 ? clipSource.autoLoop : null);
        return copy;
    }

    @NotNull
    public static final List<MediaClip> H(@NotNull List<? extends MediaClip> list, @NotNull List<? extends MediaClip> originClips) {
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        Object obj;
        SizeF sizeF;
        ResourceModel copy;
        ResourceModel resourceModel2;
        String str;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(originClips, "originClips");
        List<? extends MediaClip> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list2) {
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                Iterator<T> it = originClips.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        String str2 = mediaClip.resource.id;
                        ResourceModel resourceModel4 = ((MediaClip) next).resource;
                        if (resourceModel4 != null) {
                            str = resourceModel4.id;
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str2, str)) {
                            obj = next;
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MediaClip mediaClip2 = (MediaClip) obj;
                if (mediaClip2 == null || (resourceModel2 = mediaClip2.resource) == null || (sizeF = resourceModel2.size) == null) {
                    sizeF = mediaClip.resource.size;
                }
                copy = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : null, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : sizeF, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : null, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                resourceModel = copy;
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        return arrayList;
    }

    @NotNull
    public static final List<MediaClip> I(@NotNull List<? extends MediaClip> list, @NotNull List<? extends MediaClip> originClips) {
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        Object obj;
        ResourceModel resourceModel2;
        Object obj2;
        ResourceModel resourceModel3;
        ResourceModel copy;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(originClips, "originClips");
        List<? extends MediaClip> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list2) {
            ResourceModel resourceModel4 = mediaClip.resource;
            if (resourceModel4 != null) {
                List<? extends MediaClip> list3 = originClips;
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        String str3 = mediaClip.resource.id;
                        ResourceModel resourceModel5 = ((MediaClip) obj).resource;
                        if (resourceModel5 != null) {
                            str2 = resourceModel5.id;
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(str3, str2)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MediaClip mediaClip2 = (MediaClip) obj;
                if (mediaClip2 == null || (resourceModel2 = mediaClip2.resource) == null) {
                    resourceModel2 = mediaClip.resource;
                }
                Long valueOf = Long.valueOf(resourceModel2.sourceDuration);
                Iterator<T> it5 = list3.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        Object next = it5.next();
                        String str4 = mediaClip.resource.id;
                        ResourceModel resourceModel6 = ((MediaClip) next).resource;
                        if (resourceModel6 != null) {
                            str = resourceModel6.id;
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str4, str)) {
                            obj2 = next;
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                MediaClip mediaClip3 = (MediaClip) obj2;
                if (mediaClip3 == null || (resourceModel3 = mediaClip3.resource) == null) {
                    resourceModel3 = mediaClip.resource;
                }
                copy = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : valueOf, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : null, (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : Float.valueOf(resourceModel3.deblurScore), (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
                resourceModel = copy;
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        return arrayList;
    }

    @NotNull
    public static final Bitmap a(@NotNull Bitmap bitmap, @NotNull MediaClip mediaClip) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        double d16 = height;
        if (Math.abs((o(mediaClip).height / o(mediaClip).width) - (d16 / width)) < 0.01d) {
            Matrix matrix = new Matrix();
            float f16 = (float) (o(mediaClip).height / d16);
            matrix.postScale(f16, f16);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap,0,0,\u2026idth,bHeight,matrix,true)");
            return createBitmap;
        }
        return bitmap;
    }

    @NotNull
    public static final MediaClip b(@NotNull MediaClip mediaClip, @Nullable String str) {
        ResourceModel resourceModel;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(resourceModel2.extras);
            if (str == null) {
                mutableMap.remove("MEDIA_CLIP_MISSION_ID");
            } else {
                mutableMap.put("MEDIA_CLIP_MISSION_ID", str);
            }
            Unit unit = Unit.INSTANCE;
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : mutableMap, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final MediaClip c(@NotNull MediaClip mediaClip, @Nullable OpeningEndingAigcData openingEndingAigcData) {
        ResourceModel resourceModel;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(resourceModel2.extras);
            if (openingEndingAigcData == null) {
                mutableMap.remove("MEDIA_CLIP_OPENING_ENDING_AIGC_DATA");
            } else {
                String jsonStr = openingEndingAigcData.toJsonStr();
                if (jsonStr == null) {
                    jsonStr = "";
                }
                mutableMap.put("MEDIA_CLIP_OPENING_ENDING_AIGC_DATA", jsonStr);
            }
            Unit unit = Unit.INSTANCE;
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : mutableMap, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final MediaClip d(@NotNull MediaClip mediaClip, @Nullable String str) {
        ResourceModel resourceModel;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(resourceModel2.extras);
            if (str == null) {
                mutableMap.remove("MEDIA_CLIP_TEMPLATE_ID");
            } else {
                mutableMap.put("MEDIA_CLIP_TEMPLATE_ID", str);
            }
            Unit unit = Unit.INSTANCE;
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : mutableMap, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final MediaClip e(@NotNull MediaClip mediaClip, @NotNull MediaClipUseType useType) {
        ResourceModel resourceModel;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        Intrinsics.checkNotNullParameter(useType, "useType");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(resourceModel2.extras);
            mutableMap.put("MEDIA_CLIP_USE_TYPE", useType.getType());
            Unit unit = Unit.INSTANCE;
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : mutableMap, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final MediaClip f(@NotNull MediaClip mediaClip) {
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : UUID.randomUUID().toString(), (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            resourceModel = null;
        }
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final Map<Integer, Float> g(@Nullable List<? extends MediaClip> list) {
        float f16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ResourceModel resourceModel = ((MediaClip) obj).resource;
                if (resourceModel != null) {
                    Integer valueOf = Integer.valueOf(i3);
                    if (resourceModel.type == MediaType.IMAGE) {
                        f16 = 0.0f;
                    } else {
                        f16 = resourceModel.volume;
                    }
                    linkedHashMap.put(valueOf, Float.valueOf(f16));
                }
                i3 = i16;
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<Matrix, android.graphics.RectF> h(@NotNull MediaClip mediaClip) {
        float f16;
        float f17;
        android.graphics.RectF rectF;
        SizeF sizeF;
        SizeF sizeF2;
        RectF rectF2;
        float[] floatArray;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        Matrix matrix = new Matrix();
        if (mediaClip.matrix.size() == 9) {
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(mediaClip.matrix);
            matrix.setValues(floatArray);
        }
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && (rectF2 = resourceModel.picClipRect) != null) {
            rectF = new android.graphics.RectF(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
        } else {
            if (resourceModel != null && (sizeF2 = resourceModel.size) != null) {
                f16 = sizeF2.width;
            } else {
                f16 = 0.0f;
            }
            if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                f17 = sizeF.height;
            } else {
                f17 = 0.0f;
            }
            rectF = new android.graphics.RectF(0.0f, 0.0f, f16, f17);
        }
        return TuplesKt.to(matrix, rectF);
    }

    @NotNull
    public static final String i(@NotNull List<? extends MediaClip> list) {
        Object obj;
        Object obj2;
        long j3;
        SizeF sizeF;
        SizeF sizeF2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder sb5 = new StringBuilder();
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null && (sizeF2 = resourceModel.size) != null) {
                obj = Float.valueOf(sizeF2.width);
            } else {
                obj = 720;
            }
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null && (sizeF = resourceModel2.size) != null) {
                obj2 = Float.valueOf(sizeF.height);
            } else {
                obj2 = 720;
            }
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                j3 = resourceModel3.scaleDuration;
            } else {
                j3 = 0;
            }
            sb5.append(obj);
            sb5.append("*");
            sb5.append(obj2);
            sb5.append(":");
            sb5.append(j3 / 1000000);
            sb5.append(",");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @Nullable
    public static final String j(@NotNull MediaClip mediaClip) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && (map = resourceModel.extras) != null) {
            return map.get("MEDIA_CLIP_MISSION_ID");
        }
        return null;
    }

    @Nullable
    public static final OpeningEndingAigcData k(@NotNull MediaClip mediaClip) {
        String str;
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        OpeningEndingAigcData.Companion companion = OpeningEndingAigcData.INSTANCE;
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && (map = resourceModel.extras) != null) {
            str = map.get("MEDIA_CLIP_OPENING_ENDING_AIGC_DATA");
        } else {
            str = null;
        }
        return companion.a(str);
    }

    @NotNull
    public static final MediaClip l(@NotNull MediaClip mediaClip) {
        ResourceModel resourceModel;
        ResourceModel copy;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel2 = mediaClip.resource;
        if (resourceModel2 != null) {
            long j3 = resourceModel2.sourceDuration;
            copy = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : 0L, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(j3), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
            if (copy != null) {
                resourceModel = com.tencent.mobileqq.wink.editor.clipping.a.a(copy, false);
                return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
            }
        }
        resourceModel = null;
        return MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
    }

    @NotNull
    public static final List<MediaClip> m(@NotNull List<? extends MediaClip> list) {
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        ResourceModel copy;
        int collectionSizeOrDefault2;
        ResourceModel resourceModel2;
        ResourceModel copy2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1 && u(list)) {
            List<? extends MediaClip> list2 = list;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            for (MediaClip mediaClip : list2) {
                ResourceModel resourceModel3 = mediaClip.resource;
                if (resourceModel3 != null) {
                    copy2 = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : 10000000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : 0L, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : 10000000L, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : null, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                    resourceModel2 = copy2;
                } else {
                    resourceModel2 = null;
                }
                arrayList.add(MediaClip.copy$default(mediaClip, resourceModel2, null, null, null, null, null, null, 126, null));
            }
            return arrayList;
        }
        List<? extends MediaClip> list3 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip2 : list3) {
            ResourceModel resourceModel4 = mediaClip2.resource;
            if (resourceModel4 != null) {
                long j3 = resourceModel4.sourceDuration;
                copy = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : Long.valueOf(j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : 0L, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : Long.valueOf(j3), (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
                resourceModel = copy;
            } else {
                resourceModel = null;
            }
            arrayList2.add(MediaClip.copy$default(mediaClip2, resourceModel, null, null, null, null, null, null, 126, null));
        }
        return arrayList2;
    }

    @NotNull
    public static final String n(@NotNull MediaClip mediaClip) {
        String str;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null || (str = resourceModel.id) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final SizeF o(@NotNull MediaClip mediaClip) {
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null || (sizeF = resourceModel.size) == null) {
            return new SizeF(0.0f, 0.0f, null, 7, null);
        }
        return sizeF;
    }

    @Nullable
    public static final String p(@NotNull MediaClip mediaClip) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && (map = resourceModel.extras) != null) {
            return map.get("MEDIA_CLIP_TEMPLATE_ID");
        }
        return null;
    }

    public static final long q(@Nullable List<? extends MediaClip> list) {
        long j3;
        if (list == null) {
            return 0L;
        }
        Iterator<T> it = list.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.sourceDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        return j16;
    }

    @NotNull
    public static final MediaClipUseType r(@NotNull MediaClip mediaClip) {
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            String str = resourceModel.extras.get("MEDIA_CLIP_USE_TYPE");
            MediaClipUseType mediaClipUseType = MediaClipUseType.NORMAL;
            if (!Intrinsics.areEqual(str, mediaClipUseType.getType())) {
                MediaClipUseType mediaClipUseType2 = MediaClipUseType.OPENING;
                if (!Intrinsics.areEqual(str, mediaClipUseType2.getType())) {
                    mediaClipUseType2 = MediaClipUseType.ENDING;
                    if (!Intrinsics.areEqual(str, mediaClipUseType2.getType())) {
                        return mediaClipUseType;
                    }
                }
                return mediaClipUseType2;
            }
            return mediaClipUseType;
        }
        return MediaClipUseType.NORMAL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if ((!r2) != false) goto L25;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<MediaClipForCover> s(float f16, float f17, long j3, @NotNull String path, @NotNull byte[] byteArray, float f18, @Nullable String str) {
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(path)) {
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (str != null) {
            str2 = str;
        } else {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            str2 = uuid;
        }
        arrayList.add(new MediaClipForCover(new ResourceModel(str2, path, j3, 0L, j3, 0L, j3, MediaType.IMAGE, new SizeF(f16, f17, null, 4, null), f18, null, null, null, null, null, 0.0f, null, 130048, null), t.a(), null, null, null, null, null, ByteString.INSTANCE.of(byteArray, 0, byteArray.length), 124, null));
        return arrayList;
    }

    public static /* synthetic */ List t(float f16, float f17, long j3, String str, byte[] bArr, float f18, String str2, int i3, Object obj) {
        String str3;
        byte[] bArr2;
        float f19;
        String str4;
        if ((i3 & 8) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        if ((i3 & 16) != 0) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        if ((i3 & 32) != 0) {
            f19 = 1.0f;
        } else {
            f19 = f18;
        }
        if ((i3 & 64) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        return s(f16, f17, j3, str3, bArr2, f19, str4);
    }

    public static final boolean u(@Nullable List<? extends MediaClip> list) {
        boolean z16;
        List<? extends MediaClip> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        Iterator<? extends MediaClip> it = list.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = it.next().resource;
            if (resourceModel != null && resourceModel.type != MediaType.IMAGE) {
                return false;
            }
        }
        return true;
    }

    public static final boolean v(@NotNull List<? extends MediaClip> list) {
        Long l3;
        Long l16;
        Long l17;
        Intrinsics.checkNotNullParameter(list, "<this>");
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel = mediaClip.resource;
            Long l18 = null;
            if (resourceModel != null) {
                l3 = Long.valueOf(resourceModel.selectDuration);
            } else {
                l3 = null;
            }
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                l16 = Long.valueOf(resourceModel2.sourceDuration);
            } else {
                l16 = null;
            }
            if (Intrinsics.areEqual(l3, l16)) {
                ResourceModel resourceModel3 = mediaClip.resource;
                if (resourceModel3 != null) {
                    l17 = Long.valueOf(resourceModel3.selectStart);
                } else {
                    l17 = null;
                }
                ResourceModel resourceModel4 = mediaClip.resource;
                if (resourceModel4 != null) {
                    l18 = Long.valueOf(resourceModel4.sourceStart);
                }
                if (!Intrinsics.areEqual(l17, l18)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final List<MediaClip> w(@NotNull List<? extends MediaClip> list) {
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (r((MediaClip) obj) == MediaClipUseType.NORMAL) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<MediaClip> x(@NotNull String path, float f16, @Nullable String str) {
        LocalMediaInfo d16;
        String uuid;
        Intrinsics.checkNotNullParameter(path, "path");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(path) && (d16 = WinkExportUtils.d(path)) != null) {
            if (str != null) {
                uuid = str;
            } else {
                uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            }
            long j3 = d16.mDuration;
            long j16 = 1000;
            arrayList.add(new MediaClip(new ResourceModel(uuid, path, j3 * j16, 0L, j3 * j16, 0L, j3 * j16, MediaType.VIDEO, new SizeF(d16.mediaWidth, d16.mediaHeight, null, 4, null), f16, null, null, null, null, null, 0.0f, null, 130048, null), t.a(), null, null, null, null, null, 124, null));
        }
        return arrayList;
    }

    @Nullable
    public static final ClipSource y(@NotNull MediaClip mediaClip, boolean z16, @Nullable Boolean bool) {
        ClipType clipType;
        Rect rect;
        long j3;
        float f16;
        ByteString byteString;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        MediaClipForCover mediaClipForCover = null;
        if (resourceModel == null) {
            return null;
        }
        RectF rectF = resourceModel.picClipRect;
        String str = resourceModel.id;
        String str2 = resourceModel.path;
        if (resourceModel.type == MediaType.IMAGE) {
            clipType = ClipType.PHOTO;
        } else {
            clipType = ClipType.VIDEO;
        }
        ClipType clipType2 = clipType;
        if (rectF != null) {
            rect = new Rect(rectF.bottom, rectF.left, rectF.right, rectF.top);
        } else {
            rect = null;
        }
        if (z16) {
            j3 = resourceModel.sourceDuration;
        } else {
            j3 = resourceModel.selectDuration;
        }
        long j16 = j3;
        long j17 = resourceModel.scaleDuration;
        if (j17 != 0 && !z16) {
            f16 = ((float) resourceModel.selectDuration) / ((float) j17);
        } else {
            f16 = 1.0f;
        }
        float f17 = resourceModel.volume;
        long j18 = resourceModel.selectStart;
        List<Float> list = mediaClip.matrix;
        if (mediaClip instanceof MediaClipForCover) {
            mediaClipForCover = (MediaClipForCover) mediaClip;
        }
        if (mediaClipForCover == null || (byteString = mediaClipForCover.getByteArray()) == null) {
            byteString = ByteString.EMPTY;
        }
        return new ClipSource(str, str2, clipType2, j16, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j18), list, null, null, rect, byteString, bool, 768, null);
    }

    @NotNull
    public static final List<ClipSource> z(@NotNull List<? extends MediaClip> list, boolean z16, @Nullable Boolean bool) {
        int collectionSizeOrDefault;
        boolean z17;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MediaClip) obj).resource != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ClipSource y16 = y((MediaClip) it.next(), z16, bool);
            Intrinsics.checkNotNull(y16);
            arrayList2.add(y16);
        }
        return arrayList2;
    }
}
