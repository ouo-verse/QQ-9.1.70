package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import android.graphics.RectF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.model.PointF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.t;
import com.tencent.mobileqq.qqvideoedit.utils.i;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.model.TextPlaceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0016\u0018\u00002\u00020\u0001B\u0089\u0003\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020\n\u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u0010/\u001a\u00020-\u0012\b\b\u0002\u00100\u001a\u00020-\u0012\b\b\u0002\u00101\u001a\u00020-\u0012\b\b\u0002\u00102\u001a\u00020-\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\bZ\u0010[J\u0088\u0003\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-2\b\b\u0002\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020-2\n\b\u0002\u00104\u001a\u0004\u0018\u000103J.\u00109\u001a\u0002082\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010<\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nJ\u001e\u0010?\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010>\u001a\u00020=J\u000e\u0010A\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0005R\u0017\u0010+\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b+\u0010B\u001a\u0004\bC\u0010DR\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010B\u001a\u0004\bE\u0010D\"\u0004\bF\u0010GR\u0017\u0010.\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010/\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b/\u0010H\u001a\u0004\bK\u0010JR\u0017\u00100\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b0\u0010H\u001a\u0004\bL\u0010JR\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b1\u0010H\u001a\u0004\bM\u0010JR\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b2\u0010H\u001a\u0004\bN\u0010JR\u0019\u00104\u001a\u0004\u0018\u0001038\u0006\u00a2\u0006\f\n\u0004\b4\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010BR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010BR\"\u0010T\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010B\u001a\u0004\bU\u0010D\"\u0004\bV\u0010GR\"\u0010W\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010B\u001a\u0004\bX\u0010D\"\u0004\bY\u0010G\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "", "id", "filePath", "", "startTime", "duration", "", "layerIndex", "", "scale", CanvasView.ACTION_ROTATE, "centerX", "centerY", "", "editable", "width", "height", "minScale", "maxScale", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "textItems", "thumbUrl", "timelineTrackIndex", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "type", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "captionInfo", "localThumbId", "editingLayerIndex", "playEndDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "actionType", "bgConfig", "bgPath", "configType", "Lokio/ByteString;", "unknownFields", "initStickerScale", "downScaleRecord", "Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "originPointInView", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "copyAndUpdate", "viewWidth", "viewHeight", "", "updatePositionInView", "eventX", "eventY", "isClickInside", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "videoCut", "isClickInsideV2", "curPlayTimeUs", "isVisibleAtCurrentPlayTime", UserInfo.SEX_FEMALE, "getInitStickerScale", "()F", "getDownScaleRecord", "setDownScaleRecord", "(F)V", "Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "getOriginPointInView", "()Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "getSizeInView", "getCenterInView", "getLeftTopInView", "getRightBottomInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "stickTextTouchPaddingHor", "stickTextTouchPaddingVer", "lastDownScale", "getLastDownScale", "setLastDownScale", "lastDownRotate", "getLastDownRotate", "setLastDownRotate", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;FFLcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class VideoStickerModel extends StickerModel {

    @NotNull
    private final PointF centerInView;
    private float downScaleRecord;
    private final float initStickerScale;
    private float lastDownRotate;
    private float lastDownScale;

    @NotNull
    private final PointF leftTopInView;

    @Nullable
    private final MetaMaterial material;

    @NotNull
    private final PointF originPointInView;

    @NotNull
    private final PointF rightBottomInView;

    @NotNull
    private final PointF sizeInView;
    private float stickTextTouchPaddingHor;
    private float stickTextTouchPaddingVer;

    public VideoStickerModel() {
        this(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -1, 31, null);
    }

    public static /* synthetic */ VideoStickerModel copyAndUpdate$default(VideoStickerModel videoStickerModel, String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, List list, String str3, int i18, AnimationMode animationMode, StickerModel.Type type, String str4, StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, StickerModel.ActionType actionType, List list2, String str5, String str6, ByteString byteString, float f28, float f29, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, int i27, int i28, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyAndUpdate");
        }
        String str7 = (i27 & 1) != 0 ? videoStickerModel.id : str;
        String str8 = (i27 & 2) != 0 ? videoStickerModel.filePath : str2;
        long j18 = (i27 & 4) != 0 ? videoStickerModel.startTime : j3;
        long j19 = (i27 & 8) != 0 ? videoStickerModel.duration : j16;
        int i29 = (i27 & 16) != 0 ? videoStickerModel.layerIndex : i3;
        float f36 = (i27 & 32) != 0 ? videoStickerModel.scale : f16;
        float f37 = (i27 & 64) != 0 ? videoStickerModel.rotate : f17;
        float f38 = (i27 & 128) != 0 ? videoStickerModel.centerX : f18;
        float f39 = (i27 & 256) != 0 ? videoStickerModel.centerY : f19;
        boolean z17 = (i27 & 512) != 0 ? videoStickerModel.editable : z16;
        int i36 = (i27 & 1024) != 0 ? videoStickerModel.width : i16;
        return videoStickerModel.copyAndUpdate(str7, str8, j18, j19, i29, f36, f37, f38, f39, z17, i36, (i27 & 2048) != 0 ? videoStickerModel.height : i17, (i27 & 4096) != 0 ? videoStickerModel.minScale : f26, (i27 & 8192) != 0 ? videoStickerModel.maxScale : f27, (i27 & 16384) != 0 ? videoStickerModel.textItems : list, (i27 & 32768) != 0 ? videoStickerModel.thumbUrl : str3, (i27 & 65536) != 0 ? videoStickerModel.timelineTrackIndex : i18, (i27 & 131072) != 0 ? videoStickerModel.animationMode : animationMode, (i27 & 262144) != 0 ? videoStickerModel.type : type, (i27 & 524288) != 0 ? videoStickerModel.materialId : str4, (i27 & 1048576) != 0 ? videoStickerModel.captionInfo : captionInfo, (i27 & 2097152) != 0 ? videoStickerModel.localThumbId : i19, (i27 & 4194304) != 0 ? videoStickerModel.editingLayerIndex : i26, (i27 & 8388608) != 0 ? videoStickerModel.playEndDuration : j17, (i27 & 16777216) != 0 ? videoStickerModel.actionType : actionType, (33554432 & i27) != 0 ? videoStickerModel.bgConfig : list2, (i27 & 67108864) != 0 ? videoStickerModel.bgPath : str5, (i27 & 134217728) != 0 ? videoStickerModel.configType : str6, (i27 & 268435456) != 0 ? videoStickerModel.unknownFields() : byteString, (i27 & 536870912) != 0 ? videoStickerModel.initStickerScale : f28, (i27 & 1073741824) != 0 ? videoStickerModel.downScaleRecord : f29, (i27 & Integer.MIN_VALUE) != 0 ? videoStickerModel.originPointInView : pointF, (i28 & 1) != 0 ? videoStickerModel.sizeInView : pointF2, (i28 & 2) != 0 ? videoStickerModel.centerInView : pointF3, (i28 & 4) != 0 ? videoStickerModel.leftTopInView : pointF4, (i28 & 8) != 0 ? videoStickerModel.rightBottomInView : pointF5, (i28 & 16) != 0 ? videoStickerModel.material : metaMaterial);
    }

    @NotNull
    public final VideoStickerModel copyAndUpdate(@NotNull String id5, @NotNull String filePath, long startTime, long duration, int layerIndex, float scale, float rotate, float centerX, float centerY, boolean editable, int width, int height, float minScale, float maxScale, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int timelineTrackIndex, @NotNull AnimationMode animationMode, @NotNull StickerModel.Type type, @NotNull String materialId, @Nullable StickerModel.CaptionInfo captionInfo, int localThumbId, int editingLayerIndex, long playEndDuration, @NotNull StickerModel.ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, @NotNull ByteString unknownFields, float initStickerScale, float downScaleRecord, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial material) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(textItems, "textItems");
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(animationMode, "animationMode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(bgConfig, "bgConfig");
        Intrinsics.checkNotNullParameter(bgPath, "bgPath");
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        return new VideoStickerModel(id5, filePath, startTime, duration, layerIndex, scale, rotate, centerX, centerY, editable, width, height, minScale, maxScale, textItems, thumbUrl, timelineTrackIndex, animationMode, type, materialId, captionInfo, localThumbId, editingLayerIndex, playEndDuration, actionType, bgConfig, bgPath, configType, unknownFields, initStickerScale, downScaleRecord, originPointInView, sizeInView, centerInView, leftTopInView, rightBottomInView, material);
    }

    @NotNull
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    public float getLastDownRotate() {
        return this.lastDownRotate;
    }

    public float getLastDownScale() {
        return this.lastDownScale;
    }

    @NotNull
    public final PointF getLeftTopInView() {
        return this.leftTopInView;
    }

    @Nullable
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    @NotNull
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    @NotNull
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @NotNull
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    public final boolean isClickInside(float eventX, float eventY) {
        i iVar = i.f276251a;
        PointF pointF = this.leftTopInView;
        float f16 = pointF.f275793x;
        float f17 = pointF.f275794y;
        PointF pointF2 = this.rightBottomInView;
        return iVar.j(eventX, eventY, new RectF(f16, f17, pointF2.f275793x, pointF2.f275794y), -this.rotate);
    }

    public final boolean isClickInsideV2(float eventX, float eventY, @NotNull aw videoCut) {
        t a16;
        int i3;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(videoCut, "videoCut");
        com.tencent.tavcut.session.a l3 = videoCut.l();
        if (l3 == null) {
            return isClickInside(eventX, eventY);
        }
        ComposeRenderLayer c06 = videoCut.c0();
        if (c06 != null && (a16 = c06.a()) != null) {
            Integer i16 = a16.i(this.id);
            if (i16 != null) {
                i3 = i16.intValue();
            } else {
                i3 = 0;
            }
            List<TextPlaceInfo> editableTextByEntityId = l3.getEditableTextByEntityId(i3);
            if (editableTextByEntityId != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editableTextByEntityId);
                TextPlaceInfo textPlaceInfo = (TextPlaceInfo) firstOrNull;
                if (textPlaceInfo != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TextMetaMaterial", 2, "isClickInsideV2 selfPlaceInfo:" + textPlaceInfo + ", scale:" + this.scale + ", density:" + ViewUtils.getDensity());
                    }
                    float f16 = 2;
                    float density = (ViewUtils.getDensity() * textPlaceInfo.layerWidth * this.scale) + (this.stickTextTouchPaddingHor * f16);
                    float density2 = (ViewUtils.getDensity() * textPlaceInfo.layerHeight * this.scale) + (this.stickTextTouchPaddingVer * f16);
                    if (QLog.isColorLevel()) {
                        QLog.i("TextMetaMaterial", 2, "isClickInsideV2 showWidth:" + density + ", showHeight:" + density2);
                    }
                    RectF rectF = new RectF();
                    PointF pointF = this.leftTopInView;
                    float f17 = pointF.f275793x;
                    PointF pointF2 = this.sizeInView;
                    float f18 = pointF2.f275793x;
                    rectF.left = f17 + ((f18 - density) / f16);
                    float f19 = pointF.f275794y;
                    float f26 = pointF2.f275794y;
                    rectF.top = f19 + ((f26 - density2) / f16);
                    PointF pointF3 = this.rightBottomInView;
                    rectF.right = pointF3.f275793x - ((f18 - density) / f16);
                    rectF.bottom = pointF3.f275794y - ((f26 - density2) / f16);
                    if (QLog.isColorLevel()) {
                        QLog.i("TextMetaMaterial", 2, "isClickInsideV2 leftTopInView:" + this.leftTopInView + ", rightBottomInView:" + this.rightBottomInView + "showRect:" + rectF + ", eventX:" + eventX + ", eventY:" + eventY + ", rotate:" + this.rotate);
                    }
                    return i.f276251a.j(eventX, eventY, rectF, -this.rotate);
                }
            }
            return isClickInside(eventX, eventY);
        }
        return isClickInside(eventX, eventY);
    }

    public final boolean isVisibleAtCurrentPlayTime(long curPlayTimeUs) {
        long j3 = this.startTime;
        if (curPlayTimeUs >= j3 && curPlayTimeUs <= j3 + this.duration) {
            return true;
        }
        return false;
    }

    public final void setDownScaleRecord(float f16) {
        this.downScaleRecord = f16;
    }

    public void setLastDownRotate(float f16) {
        this.lastDownRotate = f16;
    }

    public void setLastDownScale(float f16) {
        this.lastDownScale = f16;
    }

    public final void updatePositionInView(int viewWidth, int viewHeight, float scale, float centerX, float centerY) {
        float f16 = viewHeight;
        float f17 = 1280;
        float f18 = ((this.width * scale) * f16) / f17;
        float f19 = ((this.height * scale) * f16) / f17;
        PointF pointF = this.sizeInView;
        pointF.f275793x = f18;
        pointF.f275794y = f19;
        PointF pointF2 = this.centerInView;
        float f26 = 1;
        float f27 = 2;
        PointF pointF3 = this.originPointInView;
        float f28 = (((centerX + f26) / f27) * viewWidth) + pointF3.f275793x;
        pointF2.f275793x = f28;
        float f29 = ((((-centerY) + f26) / f27) * f16) + pointF3.f275794y;
        pointF2.f275794y = f29;
        PointF pointF4 = this.leftTopInView;
        float f36 = f28 - (f18 / f27);
        pointF4.f275793x = f36;
        float f37 = f29 - (f19 / f27);
        pointF4.f275794y = f37;
        PointF pointF5 = this.rightBottomInView;
        pointF5.f275793x = f36 + f18;
        pointF5.f275794y = f37 + f19;
        if (ms.a.g()) {
            int i3 = this.width;
            int i16 = this.height;
            PointF pointF6 = this.originPointInView;
            float f38 = pointF6.f275793x;
            float f39 = pointF6.f275794y;
            PointF pointF7 = this.centerInView;
            ms.a.c("TextMetaMaterial", "PAG width:" + i3 + " height:" + i16 + " centerX:" + centerX + " centerY:" + centerY + " scale:" + scale + " originPointInView.x:" + f38 + " originPointInView.y" + f39 + " widthInView" + f18 + " heightInView:" + f19 + " centerInView.x:" + pointF7.f275793x + " centerInView.y" + pointF7.f275794y + " viewWidth:" + viewWidth + " viewHeight:" + viewHeight);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ VideoStickerModel(String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, List list, String str3, int i18, AnimationMode animationMode, StickerModel.Type type, String str4, StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, StickerModel.ActionType actionType, List list2, String str5, String str6, ByteString byteString, float f28, float f29, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r7, r9, r4, r12, (i27 & 64) != 0 ? 0.0f : f17, (i27 & 128) != 0 ? 0.0f : f18, (i27 & 256) != 0 ? 0.0f : f19, (i27 & 512) != 0 ? false : z16, (i27 & 1024) != 0 ? 0 : i16, (i27 & 2048) != 0 ? 0 : i17, (i27 & 4096) != 0 ? 0.0f : f26, (i27 & 8192) != 0 ? 0.0f : f27, (i27 & 16384) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i27 & 32768) != 0 ? "" : str3, (i27 & 65536) != 0 ? 0 : i18, (i27 & 131072) != 0 ? AnimationMode.LOOP : animationMode, (i27 & 262144) != 0 ? StickerModel.Type.DEFAULT : type, (i27 & 524288) != 0 ? "" : str4, (i27 & 1048576) != 0 ? null : captionInfo, (i27 & 2097152) != 0 ? 0 : i19, (i27 & 4194304) != 0 ? 0 : i26, (i27 & 8388608) != 0 ? 0L : j17, (i27 & 16777216) != 0 ? StickerModel.ActionType.NONE : actionType, (i27 & 33554432) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i27 & 67108864) != 0 ? "" : str5, (i27 & 134217728) != 0 ? "" : str6, (i27 & 268435456) != 0 ? ByteString.EMPTY : byteString, (i27 & 536870912) != 0 ? r12 : f28, (i27 & 1073741824) != 0 ? 0.0f : f29, (i27 & Integer.MIN_VALUE) != 0 ? new PointF() : pointF, (i28 & 1) != 0 ? new PointF() : pointF2, (i28 & 2) != 0 ? new PointF() : pointF3, (i28 & 4) != 0 ? new PointF() : pointF4, (i28 & 8) != 0 ? new PointF() : pointF5, (i28 & 16) == 0 ? metaMaterial : null);
        String str7 = (i27 & 1) != 0 ? "" : str;
        String str8 = (i27 & 2) != 0 ? "" : str2;
        long j18 = (i27 & 4) != 0 ? 0L : j3;
        long j19 = (i27 & 8) != 0 ? 0L : j16;
        int i29 = (i27 & 16) != 0 ? 0 : i3;
        float f36 = (i27 & 32) != 0 ? 0.0f : f16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStickerModel(@NotNull String id5, @NotNull String filePath, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int i18, @NotNull AnimationMode animationMode, @NotNull StickerModel.Type type, @NotNull String materialId, @Nullable StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, @NotNull StickerModel.ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, @NotNull ByteString unknownFields, float f28, float f29, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial metaMaterial) {
        super(id5, filePath, j3, j16, i3, f16, f17, f18, f19, z16, i16, i17, f26, f27, textItems, thumbUrl, i18, animationMode, type, materialId, captionInfo, i19, i26, j17, actionType, bgConfig, bgPath, configType, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(textItems, "textItems");
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(animationMode, "animationMode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(bgConfig, "bgConfig");
        Intrinsics.checkNotNullParameter(bgPath, "bgPath");
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        this.initStickerScale = f28;
        this.downScaleRecord = f29;
        this.originPointInView = originPointInView;
        this.sizeInView = sizeInView;
        this.centerInView = centerInView;
        this.leftTopInView = leftTopInView;
        this.rightBottomInView = rightBottomInView;
        this.material = metaMaterial;
        float f36 = 12;
        this.stickTextTouchPaddingHor = ViewUtils.getDensity() * f36;
        this.stickTextTouchPaddingVer = ViewUtils.getDensity() * f36;
    }
}
