package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.RectF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.editor.draft.TrackStickerInfo;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.utils.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.ImageType;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\bT\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00a8\u00012\u00020\u0001:\u0002\u00a9\u0001B\u00d2\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\r\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u000f\u0012\u0015\b\u0002\u0010\u00a3\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u00a5\u0001\u001a\u00030\u00a4\u0001\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00102\u001a\u00020\u000f\u0012\b\b\u0002\u00103\u001a\u00020\u000f\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u000204\u0012\b\b\u0002\u00108\u001a\u000204\u0012\b\b\u0002\u00109\u001a\u000204\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010<\u001a\u000204\u0012\b\b\u0002\u0010=\u001a\u000204\u0012\b\b\u0002\u0010>\u001a\u000204\u0012\b\b\u0002\u0010?\u001a\u000204\u0012\b\b\u0002\u0010@\u001a\u00020\u0015\u0012\u001c\b\u0002\u0010D\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`C\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010F\u001a\u00020\u0015\u0012\b\b\u0002\u0010G\u001a\u00020\u000f\u0012\b\b\u0002\u0010H\u001a\u00020\u000f\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u0015\u00a2\u0006\u0006\b\u00a6\u0001\u0010\u00a7\u0001J\u0006\u0010\u0002\u001a\u00020\u0000J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u00c2\u0004\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020*2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\b\b\u0002\u0010-\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002042\b\b\u0002\u00109\u001a\u0002042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u0002042\b\b\u0002\u0010?\u001a\u0002042\b\b\u0002\u0010@\u001a\u00020\u00152\u001c\b\u0002\u0010D\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`C2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010F\u001a\u00020\u00152\b\b\u0002\u0010G\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\u000f2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010K\u001a\u00020\u0015J6\u0010P\u001a\u00020O2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010R\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u0004Jf\u0010Y\u001a\u00020O2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u000fJ\u001e\u0010]\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u0015J\u000e\u0010_\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\nR\u0017\u00102\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b2\u0010`\u001a\u0004\ba\u0010bR\"\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010`\u001a\u0004\bc\u0010b\"\u0004\bd\u0010eR\u0017\u00105\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u0010f\u001a\u0004\bg\u0010hR\u0017\u00106\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b6\u0010f\u001a\u0004\bi\u0010hR\u0017\u00107\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b7\u0010f\u001a\u0004\bj\u0010hR\u0017\u00108\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b8\u0010f\u001a\u0004\bk\u0010hR\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b9\u0010f\u001a\u0004\bl\u0010hR\u0019\u0010;\u001a\u0004\u0018\u00010:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010m\u001a\u0004\bn\u0010oR\u0017\u0010<\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b<\u0010f\u001a\u0004\bp\u0010hR\u0017\u0010=\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b=\u0010f\u001a\u0004\bq\u0010hR\"\u0010>\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010f\u001a\u0004\br\u0010h\"\u0004\bs\u0010tR\"\u0010?\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010f\u001a\u0004\bu\u0010h\"\u0004\bv\u0010tR\"\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010w\u001a\u0004\b@\u0010x\"\u0004\by\u0010zR6\u0010D\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR)\u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bE\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R#\u0010F\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bF\u0010w\u001a\u0004\bF\u0010x\"\u0005\b\u0085\u0001\u0010zR$\u0010G\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bG\u0010`\u001a\u0005\b\u0086\u0001\u0010b\"\u0005\b\u0087\u0001\u0010eR$\u0010H\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bH\u0010`\u001a\u0005\b\u0088\u0001\u0010b\"\u0005\b\u0089\u0001\u0010eR)\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bJ\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R$\u0010K\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bK\u0010w\u001a\u0005\b\u008f\u0001\u0010x\"\u0005\b\u0090\u0001\u0010zR&\u0010\u0091\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0091\u0001\u0010`\u001a\u0005\b\u0092\u0001\u0010b\"\u0005\b\u0093\u0001\u0010eR&\u0010\u0094\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0094\u0001\u0010`\u001a\u0005\b\u0095\u0001\u0010b\"\u0005\b\u0096\u0001\u0010eR&\u0010\u0097\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0097\u0001\u0010`\u001a\u0005\b\u0098\u0001\u0010b\"\u0005\b\u0099\u0001\u0010eR\u0013\u0010\u009a\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010xR\u0013\u0010\u009b\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010xR\u0013\u0010\u009c\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010xR\u0013\u0010\u009d\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010xR\u0013\u0010\u009e\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010xR\u0013\u0010\u009f\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010xR\u0013\u0010\u00a0\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u00a0\u0001\u0010xR\u0013\u0010\u00a1\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u00a1\u0001\u0010xR\u0013\u0010\u00a2\u0001\u001a\u00020\u00158F\u00a2\u0006\u0007\u001a\u0005\b\u00a2\u0001\u0010x\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lcom/tencent/videocut/model/StickerModel;", "copy", "", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "watermarkDateModel", "copyAndUpdateWatermark", "id", "filePath", "", "startTime", "duration", "", "layerIndex", "", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, CanvasView.ACTION_ROTATE, "centerX", "centerY", "", "editable", "width", "height", "minScale", "maxScale", "", "Lcom/tencent/videocut/model/TextItem;", "textItems", "thumbUrl", "timelineTrackIndex", "Lcom/tencent/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/videocut/model/StickerModel$Type;", "type", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "captionInfo", "localThumbId", "editingLayerIndex", "playEndDuration", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "actionType", "bgConfig", "bgPath", "configType", "frameScale", "Lokio/ByteString;", "unknownFields", "initStickerScale", "downScaleRecord", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "originPointInView", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "normalizedLeftTopInView", "normalizedRightBottomInView", "clickBoundsLeftTopInView", "clickBoundsRightBottomInView", "isTraceSticker", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/TrackStickerInfo;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "entityName", "isTimeRangeChangedByUser", "postCropScale", "postCropTranslateY", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "ttsAudioInfo", "hasChooseTTS", "copyAndUpdate", "renderWidth", "renderHeight", "", "updatePositionInView", "inputText", "updateTextContent", "pagViewWidth", "pagViewCenterY", "textBounds_top", "textBounds_bottom", "textBounds_left", "textBounds_right", "updateTextPositionInView", "eventX", "eventY", "isStickerTimeLineType", "isClickInside", "curPlayTimeUs", "isVisibleAtCurrentPlayTime", UserInfo.SEX_FEMALE, "getInitStickerScale", "()F", "getDownScaleRecord", "setDownScaleRecord", "(F)V", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getOriginPointInView", "()Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getSizeInView", "getCenterInView", "getLeftTopInView", "getRightBottomInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getNormalizedLeftTopInView", "getNormalizedRightBottomInView", "getClickBoundsLeftTopInView", "setClickBoundsLeftTopInView", "(Lcom/tencent/mobileqq/wink/editor/model/PointF;)V", "getClickBoundsRightBottomInView", "setClickBoundsRightBottomInView", "Z", "()Z", "setTraceSticker", "(Z)V", "Ljava/util/ArrayList;", "getStickerTrackerResult", "()Ljava/util/ArrayList;", "setStickerTrackerResult", "(Ljava/util/ArrayList;)V", "Ljava/lang/String;", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "setTimeRangeChangedByUser", "getPostCropScale", "setPostCropScale", "getPostCropTranslateY", "setPostCropTranslateY", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "getTtsAudioInfo", "()Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "setTtsAudioInfo", "(Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;)V", "getHasChooseTTS", "setHasChooseTTS", "lastDownScaleX", "getLastDownScaleX", "setLastDownScaleX", "lastDownScaleY", "getLastDownScaleY", "setLastDownScaleY", "lastDownRotate", "getLastDownRotate", "setLastDownRotate", "isTextSticker", "isSubtitleSticker", "isLyricSticker", "isTemplateTextSticker", "isBackgroundTextSticker", "isAISticker", "isPlainText", "isTemplateImageSticker", "isMosaicDoodleSticker", "watermarkModel", "Lcom/tencent/videocut/model/ImageType;", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;FLjava/util/Map;Lcom/tencent/videocut/model/ImageType;Lokio/ByteString;FFLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;ZLjava/util/ArrayList;Ljava/lang/String;ZFFLcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;Z)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkStickerModel extends StickerModel {
    private static final long serialVersionUID = 7721197785356712551L;

    @NotNull
    private final PointF centerInView;

    @NotNull
    private PointF clickBoundsLeftTopInView;

    @NotNull
    private PointF clickBoundsRightBottomInView;
    private float downScaleRecord;

    @Nullable
    private String entityName;
    private boolean hasChooseTTS;
    private final float initStickerScale;
    private boolean isTimeRangeChangedByUser;
    private boolean isTraceSticker;
    private float lastDownRotate;
    private float lastDownScaleX;
    private float lastDownScaleY;

    @NotNull
    private final PointF leftTopInView;

    @Nullable
    private final MetaMaterial material;

    @NotNull
    private final PointF normalizedLeftTopInView;

    @NotNull
    private final PointF normalizedRightBottomInView;

    @NotNull
    private final PointF originPointInView;
    private float postCropScale;
    private float postCropTranslateY;

    @NotNull
    private final PointF rightBottomInView;

    @NotNull
    private final PointF sizeInView;

    @Nullable
    private ArrayList<TrackStickerInfo> stickerTrackerResult;

    @Nullable
    private TTSAudioInfo ttsAudioInfo;

    public WinkStickerModel() {
        this(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1, 2097151, null);
    }

    public static /* synthetic */ WinkStickerModel copyAndUpdate$default(WinkStickerModel winkStickerModel, String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, List list, String str3, int i18, AnimationMode animationMode, StickerModel.Type type, String str4, StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, StickerModel.ActionType actionType, List list2, String str5, String str6, float f29, Map map, ByteString byteString, float f36, float f37, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, boolean z17, ArrayList arrayList, String str7, boolean z18, float f38, float f39, TTSAudioInfo tTSAudioInfo, boolean z19, int i27, int i28, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyAndUpdate");
        }
        return winkStickerModel.copyAndUpdate((i27 & 1) != 0 ? winkStickerModel.id : str, (i27 & 2) != 0 ? winkStickerModel.filePath : str2, (i27 & 4) != 0 ? winkStickerModel.startTime : j3, (i27 & 8) != 0 ? winkStickerModel.duration : j16, (i27 & 16) != 0 ? winkStickerModel.layerIndex : i3, (i27 & 32) != 0 ? winkStickerModel.scaleX : f16, (i27 & 64) != 0 ? winkStickerModel.scaleY : f17, (i27 & 128) != 0 ? winkStickerModel.rotate : f18, (i27 & 256) != 0 ? winkStickerModel.centerX : f19, (i27 & 512) != 0 ? winkStickerModel.centerY : f26, (i27 & 1024) != 0 ? winkStickerModel.editable : z16, (i27 & 2048) != 0 ? winkStickerModel.width : i16, (i27 & 4096) != 0 ? winkStickerModel.height : i17, (i27 & 8192) != 0 ? winkStickerModel.minScale : f27, (i27 & 16384) != 0 ? winkStickerModel.maxScale : f28, (i27 & 32768) != 0 ? winkStickerModel.textItems : list, (i27 & 65536) != 0 ? winkStickerModel.thumbUrl : str3, (i27 & 131072) != 0 ? winkStickerModel.timelineTrackIndex : i18, (i27 & 262144) != 0 ? winkStickerModel.animationMode : animationMode, (i27 & 524288) != 0 ? winkStickerModel.type : type, (i27 & 1048576) != 0 ? winkStickerModel.materialId : str4, (i27 & 2097152) != 0 ? winkStickerModel.captionInfo : captionInfo, (i27 & 4194304) != 0 ? winkStickerModel.localThumbId : i19, (i27 & 8388608) != 0 ? winkStickerModel.editingLayerIndex : i26, (i27 & 16777216) != 0 ? winkStickerModel.playEndDuration : j17, (i27 & 33554432) != 0 ? winkStickerModel.actionType : actionType, (67108864 & i27) != 0 ? winkStickerModel.bgConfig : list2, (i27 & 134217728) != 0 ? winkStickerModel.bgPath : str5, (i27 & 268435456) != 0 ? winkStickerModel.configType : str6, (i27 & 536870912) != 0 ? winkStickerModel.frameScale : f29, (i27 & 1073741824) != 0 ? winkStickerModel.watermarkModel : map, (i27 & Integer.MIN_VALUE) != 0 ? winkStickerModel.unknownFields() : byteString, (i28 & 1) != 0 ? winkStickerModel.initStickerScale : f36, (i28 & 2) != 0 ? winkStickerModel.downScaleRecord : f37, (i28 & 4) != 0 ? winkStickerModel.originPointInView : pointF, (i28 & 8) != 0 ? winkStickerModel.sizeInView : pointF2, (i28 & 16) != 0 ? winkStickerModel.centerInView : pointF3, (i28 & 32) != 0 ? winkStickerModel.leftTopInView : pointF4, (i28 & 64) != 0 ? winkStickerModel.rightBottomInView : pointF5, (i28 & 128) != 0 ? winkStickerModel.material : metaMaterial, (i28 & 256) != 0 ? winkStickerModel.normalizedLeftTopInView : pointF6, (i28 & 512) != 0 ? winkStickerModel.normalizedRightBottomInView : pointF7, (i28 & 1024) != 0 ? winkStickerModel.clickBoundsLeftTopInView : pointF8, (i28 & 2048) != 0 ? winkStickerModel.clickBoundsRightBottomInView : pointF9, (i28 & 4096) != 0 ? winkStickerModel.isTraceSticker : z17, (i28 & 8192) != 0 ? winkStickerModel.stickerTrackerResult : arrayList, (i28 & 16384) != 0 ? winkStickerModel.entityName : str7, (i28 & 32768) != 0 ? winkStickerModel.isTimeRangeChangedByUser : z18, (i28 & 65536) != 0 ? winkStickerModel.postCropScale : f38, (i28 & 131072) != 0 ? winkStickerModel.postCropTranslateY : f39, (i28 & 262144) != 0 ? winkStickerModel.ttsAudioInfo : tTSAudioInfo, (i28 & 524288) != 0 ? winkStickerModel.hasChooseTTS : z19);
    }

    @NotNull
    public final WinkStickerModel copy() {
        MetaMaterial metaMaterial;
        MetaMaterial metaMaterial2 = this.material;
        if (metaMaterial2 != null) {
            metaMaterial = metaMaterial2.copy();
        } else {
            metaMaterial = null;
        }
        return copyAndUpdate$default(this, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, metaMaterial, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1, 1048447, null);
    }

    @NotNull
    public final WinkStickerModel copyAndUpdate(@NotNull String id5, @NotNull String filePath, long startTime, long duration, int layerIndex, float scaleX, float scaleY, float rotate, float centerX, float centerY, boolean editable, int width, int height, float minScale, float maxScale, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int timelineTrackIndex, @NotNull AnimationMode animationMode, @NotNull StickerModel.Type type, @NotNull String materialId, @Nullable StickerModel.CaptionInfo captionInfo, int localThumbId, int editingLayerIndex, long playEndDuration, @NotNull StickerModel.ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, float frameScale, @NotNull Map<String, WatermarkDataSourceModel> watermarkDateModel, @NotNull ByteString unknownFields, float initStickerScale, float downScaleRecord, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial material, @NotNull PointF normalizedLeftTopInView, @NotNull PointF normalizedRightBottomInView, @NotNull PointF clickBoundsLeftTopInView, @NotNull PointF clickBoundsRightBottomInView, boolean isTraceSticker, @Nullable ArrayList<TrackStickerInfo> stickerTrackerResult, @Nullable String entityName, boolean isTimeRangeChangedByUser, float postCropScale, float postCropTranslateY, @Nullable TTSAudioInfo ttsAudioInfo, boolean hasChooseTTS) {
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
        Intrinsics.checkNotNullParameter(watermarkDateModel, "watermarkDateModel");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        Intrinsics.checkNotNullParameter(normalizedLeftTopInView, "normalizedLeftTopInView");
        Intrinsics.checkNotNullParameter(normalizedRightBottomInView, "normalizedRightBottomInView");
        Intrinsics.checkNotNullParameter(clickBoundsLeftTopInView, "clickBoundsLeftTopInView");
        Intrinsics.checkNotNullParameter(clickBoundsRightBottomInView, "clickBoundsRightBottomInView");
        return new WinkStickerModel(id5, filePath, startTime, duration, layerIndex, scaleX, scaleY, rotate, centerX, centerY, editable, width, height, minScale, maxScale, textItems, thumbUrl, timelineTrackIndex, animationMode, type, materialId, captionInfo, localThumbId, editingLayerIndex, playEndDuration, actionType, bgConfig, bgPath, configType, frameScale, watermarkDateModel, this.imageType, unknownFields, initStickerScale, downScaleRecord, originPointInView, sizeInView, centerInView, leftTopInView, rightBottomInView, material, normalizedLeftTopInView, normalizedRightBottomInView, clickBoundsLeftTopInView, clickBoundsRightBottomInView, isTraceSticker, stickerTrackerResult, entityName, isTimeRangeChangedByUser, postCropScale, postCropTranslateY, ttsAudioInfo, hasChooseTTS);
    }

    @NotNull
    public final WinkStickerModel copyAndUpdateWatermark(@NotNull Map<String, WatermarkDataSourceModel> watermarkDateModel) {
        Intrinsics.checkNotNullParameter(watermarkDateModel, "watermarkDateModel");
        return copyAndUpdate$default(this, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, watermarkDateModel, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1073741825, 1048575, null);
    }

    @NotNull
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    @NotNull
    public final PointF getClickBoundsLeftTopInView() {
        return this.clickBoundsLeftTopInView;
    }

    @NotNull
    public final PointF getClickBoundsRightBottomInView() {
        return this.clickBoundsRightBottomInView;
    }

    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    @Nullable
    public final String getEntityName() {
        return this.entityName;
    }

    public final boolean getHasChooseTTS() {
        return this.hasChooseTTS;
    }

    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    public float getLastDownRotate() {
        return this.lastDownRotate;
    }

    public float getLastDownScaleX() {
        return this.lastDownScaleX;
    }

    public float getLastDownScaleY() {
        return this.lastDownScaleY;
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
    public final PointF getNormalizedLeftTopInView() {
        return this.normalizedLeftTopInView;
    }

    @NotNull
    public final PointF getNormalizedRightBottomInView() {
        return this.normalizedRightBottomInView;
    }

    @NotNull
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    public final float getPostCropScale() {
        return this.postCropScale;
    }

    public final float getPostCropTranslateY() {
        return this.postCropTranslateY;
    }

    @NotNull
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @NotNull
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    @Nullable
    public final ArrayList<TrackStickerInfo> getStickerTrackerResult() {
        return this.stickerTrackerResult;
    }

    @Nullable
    public final TTSAudioInfo getTtsAudioInfo() {
        return this.ttsAudioInfo;
    }

    public final boolean isAISticker() {
        return j73.a.f409615a.i(e.c(this));
    }

    public final boolean isBackgroundTextSticker() {
        if (this.type == StickerModel.Type.TEXT_BACKGROUND_TEMPLATE) {
            return true;
        }
        return false;
    }

    public final boolean isClickInside(float eventX, float eventY, boolean isStickerTimeLineType) {
        u uVar = u.f326728a;
        PointF pointF = this.clickBoundsLeftTopInView;
        float f16 = pointF.f320587x;
        float f17 = pointF.f320588y;
        PointF pointF2 = this.clickBoundsRightBottomInView;
        return uVar.l(eventX, eventY, new RectF(f16, f17, pointF2.f320587x, pointF2.f320588y), -this.rotate);
    }

    public final boolean isLyricSticker() {
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial != null) {
            return m.S(metaMaterial);
        }
        return false;
    }

    public final boolean isMosaicDoodleSticker() {
        if (this.type == StickerModel.Type.MOSAIC_DOODLE) {
            return true;
        }
        return false;
    }

    public final boolean isPlainText() {
        if (isTextSticker() && !isSubtitleSticker() && !isLyricSticker() && !isTemplateTextSticker() && !isBackgroundTextSticker() && !isAISticker()) {
            return true;
        }
        return false;
    }

    public final boolean isSubtitleSticker() {
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial != null) {
            return m.U(metaMaterial);
        }
        return false;
    }

    public final boolean isTemplateImageSticker() {
        if (this.type == StickerModel.Type.IMAGE_TEMPLATE) {
            return true;
        }
        return false;
    }

    public final boolean isTemplateTextSticker() {
        if (this.type == StickerModel.Type.TEXT_TEMPLATE) {
            return true;
        }
        return false;
    }

    public final boolean isTextSticker() {
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial != null) {
            return m.X(metaMaterial);
        }
        return false;
    }

    /* renamed from: isTimeRangeChangedByUser, reason: from getter */
    public final boolean getIsTimeRangeChangedByUser() {
        return this.isTimeRangeChangedByUser;
    }

    /* renamed from: isTraceSticker, reason: from getter */
    public final boolean getIsTraceSticker() {
        return this.isTraceSticker;
    }

    public final boolean isVisibleAtCurrentPlayTime(long curPlayTimeUs) {
        long j3 = this.startTime;
        if (curPlayTimeUs >= j3 && curPlayTimeUs <= j3 + this.duration) {
            return true;
        }
        return false;
    }

    public final void setClickBoundsLeftTopInView(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.clickBoundsLeftTopInView = pointF;
    }

    public final void setClickBoundsRightBottomInView(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.clickBoundsRightBottomInView = pointF;
    }

    public final void setDownScaleRecord(float f16) {
        this.downScaleRecord = f16;
    }

    public final void setEntityName(@Nullable String str) {
        this.entityName = str;
    }

    public final void setHasChooseTTS(boolean z16) {
        this.hasChooseTTS = z16;
    }

    public void setLastDownRotate(float f16) {
        this.lastDownRotate = f16;
    }

    public void setLastDownScaleX(float f16) {
        this.lastDownScaleX = f16;
    }

    public void setLastDownScaleY(float f16) {
        this.lastDownScaleY = f16;
    }

    public final void setPostCropScale(float f16) {
        this.postCropScale = f16;
    }

    public final void setPostCropTranslateY(float f16) {
        this.postCropTranslateY = f16;
    }

    public final void setStickerTrackerResult(@Nullable ArrayList<TrackStickerInfo> arrayList) {
        this.stickerTrackerResult = arrayList;
    }

    public final void setTimeRangeChangedByUser(boolean z16) {
        this.isTimeRangeChangedByUser = z16;
    }

    public final void setTraceSticker(boolean z16) {
        this.isTraceSticker = z16;
    }

    public final void setTtsAudioInfo(@Nullable TTSAudioInfo tTSAudioInfo) {
        this.ttsAudioInfo = tTSAudioInfo;
    }

    public final void updatePositionInView(int renderWidth, int renderHeight, float scaleX, float scaleY, float centerX, float centerY) {
        float f16;
        float f17;
        float f18;
        float f19;
        Map<String, String> map;
        String str;
        int i3 = this.width;
        float f26 = renderHeight;
        float f27 = 1280;
        float f28 = ((i3 * scaleX) * f26) / f27;
        int i16 = this.height;
        float f29 = ((i16 * scaleY) * f26) / f27;
        float f36 = (renderWidth / 2.0f) * 2.0f;
        float f37 = (f26 / 2.0f) * 2.0f;
        PointF pointF = this.sizeInView;
        pointF.f320587x = ((i3 * scaleX) * f37) / f27;
        pointF.f320588y = ((i16 * scaleY) * f37) / f27;
        PointF pointF2 = this.centerInView;
        float f38 = 1;
        float f39 = 2;
        float f46 = ((centerX + f38) / f39) * f36;
        pointF2.f320587x = f46;
        float f47 = (((-centerY) + f38) / f39) * f37;
        pointF2.f320588y = f47;
        PointF pointF3 = this.leftTopInView;
        float f48 = f46 - (pointF.f320587x / f39);
        pointF3.f320587x = f48;
        float f49 = f47 - (pointF.f320588y / f39);
        pointF3.f320588y = f49;
        PointF pointF4 = this.rightBottomInView;
        pointF4.f320587x = f48 + pointF.f320587x;
        pointF4.f320588y = f49 + pointF.f320588y;
        MetaMaterial metaMaterial = this.material;
        int i17 = 0;
        if (metaMaterial != null && (map = metaMaterial.additionalFields) != null && (str = map.get("pagViewWidth")) != null) {
            try {
                i17 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        int i18 = i17;
        if (i18 > 0) {
            MetaMaterial metaMaterial2 = this.material;
            Intrinsics.checkNotNull(metaMaterial2);
            String str2 = metaMaterial2.additionalFields.get("pagViewCenterY");
            float parseFloat = str2 != null ? Float.parseFloat(str2) : 0.0f;
            String str3 = this.material.additionalFields.get("textBoundsTop");
            float parseFloat2 = str3 != null ? Float.parseFloat(str3) : 0.0f;
            String str4 = this.material.additionalFields.get("textBoundsBottom");
            float parseFloat3 = str4 != null ? Float.parseFloat(str4) : 0.0f;
            String str5 = this.material.additionalFields.get("textBoundsLeft");
            float parseFloat4 = str5 != null ? Float.parseFloat(str5) : 0.0f;
            String str6 = this.material.additionalFields.get("textBoundsRight");
            f16 = f29;
            f18 = centerY;
            f17 = f28;
            f19 = centerX;
            updateTextPositionInView(renderWidth, renderHeight, scaleX, scaleY, centerX, centerY, i18, parseFloat, parseFloat2, parseFloat3, parseFloat4, str6 != null ? Float.parseFloat(str6) : 0.0f);
        } else {
            f16 = f29;
            f17 = f28;
            f18 = centerY;
            f19 = centerX;
            PointF pointF5 = this.clickBoundsLeftTopInView;
            PointF pointF6 = this.leftTopInView;
            pointF5.f320587x = pointF6.f320587x;
            pointF5.f320588y = pointF6.f320588y;
            PointF pointF7 = this.clickBoundsRightBottomInView;
            PointF pointF8 = this.rightBottomInView;
            pointF7.f320587x = pointF8.f320587x;
            pointF7.f320588y = pointF8.f320588y;
        }
        PointF pointF9 = this.normalizedLeftTopInView;
        PointF pointF10 = this.centerInView;
        float f56 = pointF10.f320587x;
        PointF pointF11 = this.sizeInView;
        pointF9.f320587x = (f56 - (pointF11.f320587x / 2.0f)) / f36;
        pointF9.f320588y = (pointF10.f320588y - (pointF11.f320588y / 2.0f)) / f37;
        PointF pointF12 = this.normalizedRightBottomInView;
        pointF12.f320587x = (pointF10.f320587x + (pointF11.f320587x / 2.0f)) / f36;
        pointF12.f320588y = (pointF10.f320588y + (pointF11.f320588y / 2.0f)) / f37;
        if (ms.a.g()) {
            StickerModel.Type type = this.type;
            int i19 = this.width;
            int i26 = this.height;
            PointF pointF13 = this.originPointInView;
            float f57 = pointF13.f320587x;
            float f58 = pointF13.f320588y;
            PointF pointF14 = this.centerInView;
            float f59 = pointF14.f320587x;
            float f65 = pointF14.f320588y;
            PointF pointF15 = this.leftTopInView;
            PointF pointF16 = this.rightBottomInView;
            PointF pointF17 = this.sizeInView;
            float f66 = pointF17.f320587x;
            float f67 = pointF17.f320588y;
            PointF pointF18 = this.clickBoundsLeftTopInView;
            float f68 = pointF18.f320587x;
            float f69 = pointF18.f320588y;
            PointF pointF19 = this.clickBoundsRightBottomInView;
            float f75 = pointF19.f320587x;
            float f76 = pointF19.f320588y;
            PointF pointF20 = this.normalizedLeftTopInView;
            float f77 = pointF20.f320587x;
            float f78 = pointF20.f320588y;
            PointF pointF21 = this.normalizedRightBottomInView;
            ms.a.a("wink_sticker_TextMetaMaterial", "stickerType: " + type + " PAG width: " + i19 + " height: " + i26 + " center: (" + f19 + ", " + f18 + ") scale: (" + scaleX + ", " + scaleY + ") originPointInView: (" + f57 + ", " + f58 + ") sizeInView: (" + f17 + ", " + f16 + ") centerInView: (" + f59 + ", " + f65 + ") viewSize: (" + renderWidth + ", " + renderHeight + ") leftTopInView: " + pointF15 + " rightBottomInView: " + pointF16 + " sizeInView: (" + f66 + ", " + f67 + ") clickBoundsLeftTopInView: (" + f68 + ", " + f69 + ") clickBoundsRightBottomInView: (" + f75 + ", " + f76 + ") normalizedLeftTopInView: (" + f77 + ", " + f78 + ") normalizedRightBottomInView: (" + pointF21.f320587x + ", " + pointF21.f320588y + ")");
        }
    }

    public final void updateTextContent(@NotNull String inputText) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Iterator<TextItem> it = this.textItems.iterator();
        while (it.hasNext()) {
            it.next().text = inputText;
        }
    }

    public final void updateTextPositionInView(int renderWidth, int renderHeight, float scaleX, float scaleY, float centerX, float centerY, int pagViewWidth, float pagViewCenterY, float textBounds_top, float textBounds_bottom, float textBounds_left, float textBounds_right) {
        MetaMaterial metaMaterial = this.material;
        if (metaMaterial != null) {
            m.R0(metaMaterial, true);
        }
        float f16 = renderWidth;
        float f17 = ((f16 / (pagViewWidth + 0.0f)) * this.scaleX) / 0.8f;
        float f18 = (textBounds_right - textBounds_left) * f17;
        if (f18 < f16) {
            float f19 = 2;
            float f26 = f19 * 30.0f;
            if (f18 + f26 >= f16) {
                f18 = (f16 - f26) - f19;
            }
        }
        float f27 = 2;
        float f28 = 30.0f * f27;
        float f29 = f18 + f28;
        float f36 = ((textBounds_bottom - textBounds_top) * f17) + f28;
        float f37 = (((textBounds_bottom + textBounds_top) / 2.0f) - pagViewCenterY) * f17;
        float f38 = 1;
        float f39 = ((centerX + f38) / f27) * (f16 / 2.0f) * 2.0f;
        float f46 = ((((-centerY) + f38) / f27) * (renderHeight / 2.0f) * 2.0f) + f37;
        PointF pointF = this.clickBoundsLeftTopInView;
        float f47 = f39 - (f29 / f27);
        pointF.f320587x = f47;
        float f48 = f46 - (f36 / f27);
        pointF.f320588y = f48;
        PointF pointF2 = this.clickBoundsRightBottomInView;
        pointF2.f320587x = f47 + f29;
        pointF2.f320588y = f48 + f36;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ WinkStickerModel(String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, List list, String str3, int i18, AnimationMode animationMode, StickerModel.Type type, String str4, StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, StickerModel.ActionType actionType, List list2, String str5, String str6, float f29, Map map, ImageType imageType, ByteString byteString, float f36, float f37, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, boolean z17, ArrayList arrayList, String str7, boolean z18, float f38, float f39, TTSAudioInfo tTSAudioInfo, boolean z19, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r4, r8, r10, r5, r13, (i27 & 64) != 0 ? 0.0f : f17, (i27 & 128) != 0 ? 0.0f : f18, (i27 & 256) != 0 ? 0.0f : f19, (i27 & 512) != 0 ? 0.0f : f26, (i27 & 1024) != 0 ? false : z16, (i27 & 2048) != 0 ? 0 : i16, (i27 & 4096) != 0 ? 0 : i17, (i27 & 8192) != 0 ? 0.0f : f27, (i27 & 16384) != 0 ? 0.0f : f28, (i27 & 32768) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i27 & 65536) != 0 ? "" : str3, (i27 & 131072) != 0 ? 0 : i18, (i27 & 262144) != 0 ? AnimationMode.LOOP : animationMode, (i27 & 524288) != 0 ? StickerModel.Type.DEFAULT : type, (i27 & 1048576) != 0 ? "" : str4, (i27 & 2097152) != 0 ? null : captionInfo, (i27 & 4194304) != 0 ? 0 : i19, (i27 & 8388608) != 0 ? 0 : i26, (i27 & 16777216) != 0 ? 0L : j17, (i27 & 33554432) != 0 ? StickerModel.ActionType.NONE : actionType, (i27 & 67108864) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i27 & 134217728) != 0 ? "" : str5, (i27 & 268435456) != 0 ? "" : str6, (i27 & 536870912) != 0 ? 1.0f : f29, (i27 & 1073741824) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i27 & Integer.MIN_VALUE) != 0 ? ImageType.PAG : imageType, (i28 & 1) != 0 ? ByteString.EMPTY : byteString, (i28 & 2) != 0 ? r13 : f36, (i28 & 4) != 0 ? 0.0f : f37, (i28 & 8) != 0 ? new PointF() : pointF, (i28 & 16) != 0 ? new PointF() : pointF2, (i28 & 32) != 0 ? new PointF() : pointF3, (i28 & 64) != 0 ? new PointF() : pointF4, (i28 & 128) != 0 ? new PointF() : pointF5, (i28 & 256) != 0 ? null : metaMaterial, (i28 & 512) != 0 ? new PointF() : pointF6, (i28 & 1024) != 0 ? new PointF() : pointF7, (i28 & 2048) != 0 ? new PointF() : pointF8, (i28 & 4096) != 0 ? new PointF() : pointF9, (i28 & 8192) != 0 ? false : z17, (i28 & 16384) != 0 ? null : arrayList, (i28 & 32768) != 0 ? null : str7, (i28 & 65536) != 0 ? false : z18, (i28 & 131072) != 0 ? 1.0f : f38, (i28 & 262144) != 0 ? 0.0f : f39, (i28 & 524288) == 0 ? tTSAudioInfo : null, (i28 & 1048576) != 0 ? false : z19);
        String str8 = (i27 & 1) != 0 ? "" : str;
        String str9 = (i27 & 2) != 0 ? "" : str2;
        long j18 = (i27 & 4) != 0 ? 0L : j3;
        long j19 = (i27 & 8) != 0 ? 0L : j16;
        int i29 = (i27 & 16) != 0 ? 0 : i3;
        float f46 = (i27 & 32) != 0 ? 0.0f : f16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkStickerModel(@NotNull String id5, @NotNull String filePath, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int i18, @NotNull AnimationMode animationMode, @NotNull StickerModel.Type type, @NotNull String materialId, @Nullable StickerModel.CaptionInfo captionInfo, int i19, int i26, long j17, @NotNull StickerModel.ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, float f29, @NotNull Map<String, WatermarkDataSourceModel> watermarkModel, @NotNull ImageType imageType, @NotNull ByteString unknownFields, float f36, float f37, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial metaMaterial, @NotNull PointF normalizedLeftTopInView, @NotNull PointF normalizedRightBottomInView, @NotNull PointF clickBoundsLeftTopInView, @NotNull PointF clickBoundsRightBottomInView, boolean z17, @Nullable ArrayList<TrackStickerInfo> arrayList, @Nullable String str, boolean z18, float f38, float f39, @Nullable TTSAudioInfo tTSAudioInfo, boolean z19) {
        super(id5, filePath, j3, j16, i3, f16, f17, f18, f19, f26, z16, i16, i17, f27, f28, textItems, thumbUrl, i18, animationMode, type, materialId, captionInfo, i19, i26, j17, actionType, bgConfig, bgPath, configType, f29, watermarkModel, imageType, unknownFields);
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
        Intrinsics.checkNotNullParameter(watermarkModel, "watermarkModel");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        Intrinsics.checkNotNullParameter(normalizedLeftTopInView, "normalizedLeftTopInView");
        Intrinsics.checkNotNullParameter(normalizedRightBottomInView, "normalizedRightBottomInView");
        Intrinsics.checkNotNullParameter(clickBoundsLeftTopInView, "clickBoundsLeftTopInView");
        Intrinsics.checkNotNullParameter(clickBoundsRightBottomInView, "clickBoundsRightBottomInView");
        this.initStickerScale = f36;
        this.downScaleRecord = f37;
        this.originPointInView = originPointInView;
        this.sizeInView = sizeInView;
        this.centerInView = centerInView;
        this.leftTopInView = leftTopInView;
        this.rightBottomInView = rightBottomInView;
        this.material = metaMaterial;
        this.normalizedLeftTopInView = normalizedLeftTopInView;
        this.normalizedRightBottomInView = normalizedRightBottomInView;
        this.clickBoundsLeftTopInView = clickBoundsLeftTopInView;
        this.clickBoundsRightBottomInView = clickBoundsRightBottomInView;
        this.isTraceSticker = z17;
        this.stickerTrackerResult = arrayList;
        this.entityName = str;
        this.isTimeRangeChangedByUser = z18;
        this.postCropScale = f38;
        this.postCropTranslateY = f39;
        this.ttsAudioInfo = tTSAudioInfo;
        this.hasChooseTTS = z19;
    }
}
