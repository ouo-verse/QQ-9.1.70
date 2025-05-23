package com.tencent.mobileqq.wink.editor.model;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReportConstant;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.render.extension.e;
import com.tencent.videocut.render.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u0012\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001a\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0000\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u0000\u001a\n\u0010\u0014\u001a\u00020\u0013*\u00020\u0000\u001a\n\u0010\u0015\u001a\u00020\u0013*\u00020\u0000\u001a\n\u0010\u0016\u001a\u00020\u0013*\u00020\u0000\u001a\n\u0010\u0017\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0018\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0019\u001a\u00020\u0013*\u00020\u0000\u001a\n\u0010\u001a\u001a\u00020\u0013*\u00020\u0000\u001a\u0012\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b\u001a\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u001f*\u00020\u0000\u001a\u0014\u0010#\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001f\u001a2\u0010(\u001a\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0\u0001\u001a$\u0010+\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!\u001a\n\u0010,\u001a\u00020\u0000*\u00020\u0000\u001a*\u0010/\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0002\u001a\u0014\u00101\u001a\u00020\u0000*\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0006\u001a\u0012\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020!\u001a\u0018\u00106\u001a\u00020\u0000*\u00020\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u001f\u001aE\u0010<\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010!2\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0002\u00a2\u0006\u0004\b<\u0010=\u00a8\u0006>"}, d2 = {"Lcom/tencent/videocut/model/MediaModel;", "", "", "Lcom/tencent/videocut/model/TransitionModel;", "transition", "e", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "g", "Lcom/tencent/videocut/model/SizeF;", "renderSize", "bgColor", "l", "", ReportConstant.COSTREPORT_PREFIX, "p", "", "r", "o", "", "v", "u", "w", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lorg/json/JSONObject;", "jsonObject", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "matrix", HippyTKDListViewAdapter.X, "Lcom/tencent/videocut/model/MediaClip;", "clips", "Lcom/tencent/videocut/model/AudioModel;", "audioMap", "b", "width", "height", "d", "i", "duration", "path", "f", "copyBackgroundModel", "j", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "k", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerList", "a", "bgFillScale", "Lcom/tencent/videocut/model/BackgroundFillMode;", "bgFillMode", "color", "pagPath", h.F, "(Lcom/tencent/videocut/model/MediaModel;IILjava/lang/Float;Lcom/tencent/videocut/model/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/videocut/model/MediaModel;", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final MediaModel a(@NotNull MediaModel mediaModel, @NotNull List<? extends WinkStickerModel> stickerList) {
        Map mutableMap;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(stickerList, "stickerList");
        mutableMap = MapsKt__MapsKt.toMutableMap(mediaModel.stickers);
        for (WinkStickerModel winkStickerModel : stickerList) {
            mutableMap.put(winkStickerModel.id, winkStickerModel);
        }
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : mutableMap, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:
    
        if (r1.getValue().sourceDuration > 0) goto L19;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MediaModel b(@NotNull List<? extends MediaClip> clips, @NotNull BackgroundModel backgroundModel, @NotNull Map<String, AudioModel> audioMap) {
        MediaModel copy;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(backgroundModel, "backgroundModel");
        Intrinsics.checkNotNullParameter(audioMap, "audioMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, AudioModel>> it = audioMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, AudioModel> next = it.next();
            boolean z18 = true;
            if (next.getKey().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (next.getValue().id.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                }
            }
            z18 = false;
            if (z18) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        copy = r12.copy((r39 & 1) != 0 ? r12.id : null, (r39 & 2) != 0 ? r12.name : null, (r39 & 4) != 0 ? r12.version : null, (r39 & 8) != 0 ? r12.createTime : null, (r39 & 16) != 0 ? r12.updateTime : null, (r39 & 32) != 0 ? r12.duration : null, (r39 & 64) != 0 ? r12.videos : clips, (r39 & 128) != 0 ? r12.audios : linkedHashMap, (r39 & 256) != 0 ? r12.stickers : null, (r39 & 512) != 0 ? r12.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? r12.filterModels : null, (r39 & 2048) != 0 ? r12.specialEffects : null, (r39 & 4096) != 0 ? r12.transitions : null, (r39 & 8192) != 0 ? r12.templateModel : null, (r39 & 16384) != 0 ? r12.coverInfo : null, (r39 & 32768) != 0 ? r12.exportSetting : null, (r39 & 65536) != 0 ? r12.openHDR : null, (r39 & 131072) != 0 ? r12.hdrModels : null, (r39 & 262144) != 0 ? r12.smoothModels : null, (r39 & 524288) != 0 ? r12.openSuperHDR : null, (r39 & 1048576) != 0 ? new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null).unknownFields() : null);
        return copy;
    }

    public static /* synthetic */ MediaModel c(List list, BackgroundModel backgroundModel, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        return b(list, backgroundModel, map);
    }

    @NotNull
    public static final SizeF d(@NotNull List<? extends MediaClip> clips, float f16, float f17) {
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(clips, "clips");
        SizeF i3 = g.i(clips);
        if (i3 != null) {
            if (Math.abs((f16 / f17) - (i3.width / i3.height)) < 0.01f && Math.abs(f16 - i3.width) < i3.width * 0.01f) {
                return new SizeF(i3.width, i3.height, null, 4, null);
            }
            sizeF = new SizeF(f16, f17, null, 4, null);
        } else {
            sizeF = new SizeF(f16, f17, null, 4, null);
        }
        return sizeF;
    }

    @NotNull
    public static final MediaModel e(@NotNull MediaModel mediaModel, @NotNull Map<String, TransitionModel> transition) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(transition, "transition");
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : transition, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final MediaModel f(@NotNull MediaModel mediaModel, float f16, float f17, long j3, @NotNull String path) {
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return new MediaModel(mediaModel.id, null, null, null, null, null, e.t(f16, f17, j3, path, null, 0.0f, null, 80, null), null, null, mediaModel.backgroundModel, null, null, null, null, null, null, null, null, null, null, null, 2096574, null);
    }

    @NotNull
    public static final MediaModel g(@NotNull MediaModel mediaModel, @NotNull BackgroundModel backgroundModel) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(backgroundModel, "backgroundModel");
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final MediaModel h(@NotNull MediaModel mediaModel, int i3, int i16, @Nullable Float f16, @Nullable BackgroundFillMode backgroundFillMode, @NotNull String color, @NotNull String pagPath) {
        float f17;
        boolean z16;
        String str;
        float f18;
        BackgroundFillMode backgroundFillMode2;
        Map emptyMap;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(pagPath, "pagPath");
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        if (backgroundModel != null) {
            SizeF sizeF = backgroundModel.renderSize;
            float f19 = 0.0f;
            if (sizeF != null) {
                f17 = sizeF.width;
            } else {
                f17 = 0.0f;
            }
            if (sizeF != null) {
                f19 = sizeF.height;
            }
            float f26 = i16;
            float f27 = f26 * f17;
            float f28 = i3;
            float f29 = f28 * f19;
            if (f27 > f29) {
                f17 = f29 / f26;
            } else {
                f19 = f27 / f28;
            }
            float f36 = f19;
            float f37 = f17;
            if (color.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = mediaModel.backgroundModel.bgColor;
            } else {
                str = color;
            }
            List<MediaClip> list = mediaModel.videos;
            BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
            SizeF sizeF2 = new SizeF(f37, f36, null, 4, null);
            if (f16 != null) {
                f18 = f16.floatValue();
            } else {
                f18 = mediaModel.backgroundModel.fillScale;
            }
            float f38 = f18;
            if (backgroundFillMode == null) {
                backgroundFillMode2 = mediaModel.backgroundModel.bgFillMode;
            } else {
                backgroundFillMode2 = backgroundFillMode;
            }
            BackgroundModel copy$default = BackgroundModel.copy$default(backgroundModel2, null, sizeF2, backgroundFillMode2, str, pagPath, null, null, null, f38, 0, null, 1761, null);
            emptyMap = MapsKt__MapsKt.emptyMap();
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : list, (r39 & 128) != 0 ? mediaModel.audios : emptyMap, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : copy$default, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            if (copy != null) {
                return copy;
            }
        }
        return mediaModel;
    }

    @NotNull
    public static final MediaModel i(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        return new MediaModel(mediaModel.id, null, null, null, null, null, mediaModel.videos, null, null, mediaModel.backgroundModel, null, null, mediaModel.transitions, null, null, null, null, null, null, null, null, 2092478, null);
    }

    @NotNull
    public static final MediaModel j(@NotNull MediaModel mediaModel, @Nullable BackgroundModel backgroundModel) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        BackgroundModel backgroundModel2 = null;
        SizeF sizeF = null;
        if (backgroundModel != null) {
            BackgroundModel backgroundModel3 = mediaModel.backgroundModel;
            if (backgroundModel3 != null) {
                sizeF = backgroundModel3.renderSize;
            }
            backgroundModel2 = BackgroundModel.copy$default(backgroundModel, null, sizeF, null, null, null, null, null, null, 0.0f, 0, null, 2045, null);
        }
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel2, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final MediaModel k(@NotNull MediaModel mediaModel, float f16) {
        int collectionSizeOrDefault;
        MediaModel copy;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : Float.valueOf(f16), (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : arrayList, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final BackgroundModel l(@NotNull BackgroundModel backgroundModel, @NotNull SizeF renderSize, @NotNull String bgColor) {
        Intrinsics.checkNotNullParameter(backgroundModel, "<this>");
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return BackgroundModel.copy$default(backgroundModel, null, renderSize, null, bgColor, null, null, null, null, 0.0f, 0, null, 2037, null);
    }

    @NotNull
    public static final String m(@NotNull MediaModel mediaModel) {
        Collection<AudioModel> values;
        Float f16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Map<String, AudioModel> map = mediaModel.audios;
        String str = "";
        if (map != null && (values = map.values()) != null) {
            for (AudioModel audioModel : values) {
                if (audioModel != null) {
                    f16 = Float.valueOf(audioModel.volume);
                } else {
                    f16 = null;
                }
                str = ((Object) str) + f16 + ",";
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0155, code lost:
    
        if (r0 != false) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0127  */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void n(@NotNull MediaModel mediaModel, @NotNull JSONObject jsonObject) {
        Integer num;
        int i3;
        int i16;
        ?? r06;
        ?? r07;
        String str;
        ?? r08;
        ?? r09;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        List<MediaClip> list = mediaModel.videos;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        jsonObject.put("mediaCount", num);
        jsonObject.put(QQWinkConstants.TAB_CROP, v(mediaModel) ? 1 : 0);
        jsonObject.put("Clip", u(mediaModel) ? 1 : 0);
        int i17 = 1;
        if (!mediaModel.stickers.isEmpty()) {
            Map<String, StickerModel> map = mediaModel.stickers;
            if (!map.isEmpty()) {
                Iterator<Map.Entry<String, StickerModel>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (!TextUtils.isEmpty(it.next().getValue().filePath)) {
                        r09 = true;
                        break;
                    }
                }
            }
            r09 = false;
            if (r09 != false) {
                i3 = 1;
                jsonObject.put("sticker", i3);
                if (!mediaModel.filterModels.isEmpty()) {
                    Map<String, FilterModel> map2 = mediaModel.filterModels;
                    if (!map2.isEmpty()) {
                        Iterator<Map.Entry<String, FilterModel>> it5 = map2.entrySet().iterator();
                        while (it5.hasNext()) {
                            LutFilterModel lutFilterModel = it5.next().getValue().lut;
                            if (lutFilterModel == null || (str = lutFilterModel.filePath) == null) {
                                str = "";
                            }
                            if (!TextUtils.isEmpty(str)) {
                                r08 = true;
                                break;
                            }
                        }
                    }
                    r08 = false;
                    if (r08 != false) {
                        i16 = 1;
                        jsonObject.put("filter", i16);
                        jsonObject.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, Intrinsics.areEqual(mediaModel.openHDR, Boolean.TRUE) ? 1 : 0);
                        if (!mediaModel.audios.isEmpty()) {
                            Map<String, AudioModel> map3 = mediaModel.audios;
                            if (!map3.isEmpty()) {
                                Iterator<Map.Entry<String, AudioModel>> it6 = map3.entrySet().iterator();
                                while (it6.hasNext()) {
                                    if (!TextUtils.isEmpty(it6.next().getValue().path)) {
                                        r07 = true;
                                        break;
                                    }
                                }
                            }
                            r07 = false;
                            if (r07 != false) {
                                jsonObject.put("audio", 1);
                                jsonObject.put("audioVolume", m(mediaModel));
                                if (!mediaModel.specialEffects.isEmpty()) {
                                    Map<String, SpecialEffectModel> map4 = mediaModel.specialEffects;
                                    if (!map4.isEmpty()) {
                                        Iterator<Map.Entry<String, SpecialEffectModel>> it7 = map4.entrySet().iterator();
                                        while (it7.hasNext()) {
                                            if (!TextUtils.isEmpty(it7.next().getValue().filePath)) {
                                                r06 = true;
                                                break;
                                            }
                                        }
                                    }
                                    r06 = false;
                                }
                                i17 = 0;
                                jsonObject.put(QQWinkConstants.TAB_EFFECT, i17);
                                jsonObject.put("hasVolumeChanged", w(mediaModel));
                                jsonObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, t(mediaModel));
                            }
                        }
                        jsonObject.put("audio", 0);
                        if (!mediaModel.specialEffects.isEmpty()) {
                        }
                        i17 = 0;
                        jsonObject.put(QQWinkConstants.TAB_EFFECT, i17);
                        jsonObject.put("hasVolumeChanged", w(mediaModel));
                        jsonObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, t(mediaModel));
                    }
                }
                i16 = 0;
                jsonObject.put("filter", i16);
                jsonObject.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, Intrinsics.areEqual(mediaModel.openHDR, Boolean.TRUE) ? 1 : 0);
                if (!mediaModel.audios.isEmpty()) {
                }
                jsonObject.put("audio", 0);
                if (!mediaModel.specialEffects.isEmpty()) {
                }
                i17 = 0;
                jsonObject.put(QQWinkConstants.TAB_EFFECT, i17);
                jsonObject.put("hasVolumeChanged", w(mediaModel));
                jsonObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, t(mediaModel));
            }
        }
        i3 = 0;
        jsonObject.put("sticker", i3);
        if (!mediaModel.filterModels.isEmpty()) {
        }
        i16 = 0;
        jsonObject.put("filter", i16);
        jsonObject.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, Intrinsics.areEqual(mediaModel.openHDR, Boolean.TRUE) ? 1 : 0);
        if (!mediaModel.audios.isEmpty()) {
        }
        jsonObject.put("audio", 0);
        if (!mediaModel.specialEffects.isEmpty()) {
        }
        i17 = 0;
        jsonObject.put(QQWinkConstants.TAB_EFFECT, i17);
        jsonObject.put("hasVolumeChanged", w(mediaModel));
        jsonObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, t(mediaModel));
    }

    @Nullable
    public static final String o(@NotNull MediaModel mediaModel) {
        Object orNull;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        orNull = CollectionsKt___CollectionsKt.getOrNull(mediaModel.videos, 0);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            return resourceModel.path;
        }
        return null;
    }

    public static final int p(@NotNull MediaModel mediaModel) {
        MediaType mediaType;
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ResourceModel resourceModel = ((MediaClip) obj).resource;
            if (resourceModel != null) {
                mediaType = resourceModel.type;
            } else {
                mediaType = null;
            }
            if (mediaType == MediaType.IMAGE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    @NotNull
    public static final List<Long> q(@NotNull MediaModel mediaModel) {
        List<Long> sorted;
        long j3;
        long j16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (StickerModel stickerModel : mediaModel.stickers.values()) {
            linkedHashSet.add(Long.valueOf(stickerModel.startTime));
            linkedHashSet.add(Long.valueOf(stickerModel.startTime + stickerModel.duration));
        }
        for (SpecialEffectModel specialEffectModel : mediaModel.specialEffects.values()) {
            Long l3 = specialEffectModel.startTimeUs;
            long j17 = 0;
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            linkedHashSet.add(Long.valueOf(j3));
            Long l16 = specialEffectModel.startTimeUs;
            if (l16 != null) {
                j16 = l16.longValue();
            } else {
                j16 = 0;
            }
            Long l17 = specialEffectModel.durationUs;
            if (l17 != null) {
                j17 = l17.longValue();
            }
            linkedHashSet.add(Long.valueOf(j16 + j17));
        }
        sorted = CollectionsKt___CollectionsKt.sorted(linkedHashSet);
        return sorted;
    }

    public static final long r(@NotNull MediaModel mediaModel) {
        long j3;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Iterator<T> it = mediaModel.videos.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        return j16;
    }

    public static final int s(@NotNull MediaModel mediaModel) {
        MediaType mediaType;
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ResourceModel resourceModel = ((MediaClip) obj).resource;
            if (resourceModel != null) {
                mediaType = resourceModel.type;
            } else {
                mediaType = null;
            }
            if (mediaType != MediaType.IMAGE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    @NotNull
    public static final String t(@NotNull MediaModel mediaModel) {
        Float f16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Iterator<T> it = mediaModel.videos.iterator();
        String str = "";
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                f16 = Float.valueOf(resourceModel.volume);
            } else {
                f16 = null;
            }
            str = ((Object) str) + f16 + ",";
        }
        return str;
    }

    public static final boolean u(@NotNull MediaModel mediaModel) {
        Long l3;
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel = mediaClip.resource;
            Long l16 = null;
            if (resourceModel != null) {
                l3 = Long.valueOf(resourceModel.scaleDuration);
            } else {
                l3 = null;
            }
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                l16 = Long.valueOf(resourceModel2.sourceDuration);
            }
            if (Intrinsics.areEqual(l3, l16) && (!(!mediaClip.matrix.isEmpty()) || x(mediaClip.matrix))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean v(@NotNull MediaModel mediaModel) {
        RectF rectF;
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                rectF = resourceModel.picClipRect;
            } else {
                rectF = null;
            }
            if (rectF != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean w(@NotNull MediaModel mediaModel) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        List<MediaClip> list = mediaModel.videos;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                if (resourceModel.volume == 1.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z16 = !z17;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean x(@NotNull List<Float> matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        int size = matrix.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 % 4 == 0) {
                if (matrix.get(i3).floatValue() <= 0.99f) {
                    return true;
                }
            } else if (Math.abs(matrix.get(i3).floatValue()) >= 0.01f) {
                return true;
            }
        }
        return false;
    }

    public static final boolean y(@NotNull MediaModel mediaModel) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        if (((!mediaModel.videos.isEmpty()) && mediaModel.videos.size() > 1) || v(mediaModel) || u(mediaModel)) {
            return true;
        }
        if (!mediaModel.stickers.isEmpty()) {
            Map<String, StickerModel> map = mediaModel.stickers;
            if (!map.isEmpty()) {
                Iterator<Map.Entry<String, StickerModel>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (!TextUtils.isEmpty(it.next().getValue().filePath)) {
                        z19 = true;
                        break;
                    }
                }
            }
            z19 = false;
            if (z19) {
                return true;
            }
        }
        if (!mediaModel.filterModels.isEmpty()) {
            Map<String, FilterModel> map2 = mediaModel.filterModels;
            if (!map2.isEmpty()) {
                Iterator<Map.Entry<String, FilterModel>> it5 = map2.entrySet().iterator();
                while (it5.hasNext()) {
                    LutFilterModel lutFilterModel = it5.next().getValue().lut;
                    if (lutFilterModel == null || (str = lutFilterModel.filePath) == null) {
                        str = "";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        z18 = true;
                        break;
                    }
                }
            }
            z18 = false;
            if (z18) {
                return true;
            }
        }
        if (Intrinsics.areEqual(mediaModel.openHDR, Boolean.TRUE)) {
            return true;
        }
        if (!mediaModel.audios.isEmpty()) {
            Map<String, AudioModel> map3 = mediaModel.audios;
            if (!map3.isEmpty()) {
                Iterator<Map.Entry<String, AudioModel>> it6 = map3.entrySet().iterator();
                while (it6.hasNext()) {
                    if (!TextUtils.isEmpty(it6.next().getValue().path)) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                return true;
            }
        }
        if (!mediaModel.specialEffects.isEmpty()) {
            Map<String, SpecialEffectModel> map4 = mediaModel.specialEffects;
            if (!map4.isEmpty()) {
                Iterator<Map.Entry<String, SpecialEffectModel>> it7 = map4.entrySet().iterator();
                while (it7.hasNext()) {
                    if (!TextUtils.isEmpty(it7.next().getValue().filePath)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                return true;
            }
        }
        if (w(mediaModel)) {
            return true;
        }
        return false;
    }

    public static final boolean z(@NotNull MediaModel mediaModel) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        if ((!mediaModel.videos.isEmpty()) && !v(mediaModel) && !u(mediaModel) && mediaModel.stickers.isEmpty() && mediaModel.filterModels.isEmpty() && Intrinsics.areEqual(mediaModel.openHDR, Boolean.FALSE) && (!mediaModel.audios.isEmpty())) {
            Map<String, AudioModel> map = mediaModel.audios;
            if (!map.isEmpty()) {
                Iterator<Map.Entry<String, AudioModel>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().path.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17 && mediaModel.specialEffects.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
