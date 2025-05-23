package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.videocut.model.StickerModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0016\u0018\u0000 ?2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006;<=>?@B\u00e9\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-\u0012\b\b\u0002\u0010/\u001a\u000200\u0012\b\b\u0002\u00101\u001a\u000202\u00a2\u0006\u0002\u00103J\u00ea\u0002\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\f2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202J\u0013\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u000107H\u0096\u0002J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016R\u0010\u0010&\u001a\u00020'8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/tencent/videocut/model/StickerModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/StickerModel$Builder;", "id", "", "filePath", "startTime", "", "duration", "layerIndex", "", BasicAnimation.KeyPath.SCALE_X, "", BasicAnimation.KeyPath.SCALE_Y, CanvasView.ACTION_ROTATE, "centerX", "centerY", "editable", "", "width", "height", "minScale", "maxScale", "textItems", "", "Lcom/tencent/videocut/model/TextItem;", "thumbUrl", "timelineTrackIndex", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "type", "Lcom/tencent/videocut/model/StickerModel$Type;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "captionInfo", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "localThumbId", "editingLayerIndex", "playEndDuration", "actionType", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "bgConfig", "bgPath", "configType", "frameScale", "watermarkModel", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "Lcom/tencent/videocut/model/ImageType;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;FLjava/util/Map;Lcom/tencent/videocut/model/ImageType;Lokio/ByteString;)V", "copy", "equals", "other", "", "hashCode", "newBuilder", "toString", "ActionType", "Builder", "CaptionInfo", "CaptionSource", "Companion", "Type", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class StickerModel extends AndroidMessage<StickerModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<StickerModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<StickerModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.StickerModel$ActionType#ADAPTER", tag = 25)
    @JvmField
    @NotNull
    public final ActionType actionType;

    @WireField(adapter = "com.tencent.videocut.model.AnimationMode#ADAPTER", tag = 18)
    @JvmField
    @NotNull
    public final AnimationMode animationMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 26)
    @JvmField
    @NotNull
    public final List<String> bgConfig;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    @JvmField
    @NotNull
    public String bgPath;

    @WireField(adapter = "com.tencent.videocut.model.StickerModel$CaptionInfo#ADAPTER", tag = 21)
    @JvmField
    @Nullable
    public final CaptionInfo captionInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    public final float centerX;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    @JvmField
    public final float centerY;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    @JvmField
    @NotNull
    public final String configType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    @JvmField
    public final boolean editable;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 23)
    @JvmField
    public final int editingLayerIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String filePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 29)
    @JvmField
    public float frameScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    @JvmField
    public int height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.tencent.videocut.model.ImageType#ADAPTER", tag = 41)
    @JvmField
    @NotNull
    public ImageType imageType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    public final int layerIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    @JvmField
    public final int localThumbId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 20)
    @JvmField
    @NotNull
    public final String materialId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    @JvmField
    public final float maxScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 13)
    @JvmField
    public final float minScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 24)
    @JvmField
    public final long playEndDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 31)
    @JvmField
    public final float rotate;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    public final float scaleX;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    public final float scaleY;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @JvmField
    public final long startTime;

    @WireField(adapter = "com.tencent.videocut.model.TextItem#ADAPTER", label = WireField.Label.REPEATED, tag = 15)
    @JvmField
    @NotNull
    public final List<TextItem> textItems;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    @JvmField
    @NotNull
    public final String thumbUrl;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    @JvmField
    public final int timelineTrackIndex;

    @WireField(adapter = "com.tencent.videocut.model.StickerModel$Type#ADAPTER", tag = 19)
    @JvmField
    @NotNull
    public final Type type;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkDataSourceModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 40)
    @JvmField
    @NotNull
    public final Map<String, WatermarkDataSourceModel> watermarkModel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    public int width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$ActionType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "REPLACE_ALL", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class ActionType implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES;
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<ActionType> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final ActionType NONE;
        public static final ActionType REPLACE_ALL;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$ActionType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            @Nullable
            public final ActionType fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ActionType) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
                if (value != 0) {
                    if (value != 1) {
                        return null;
                    }
                    return ActionType.REPLACE_ALL;
                }
                return ActionType.NONE;
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{NONE, REPLACE_ALL};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59123);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NONE = new ActionType("NONE", 0, 0);
            REPLACE_ALL = new ActionType("REPLACE_ALL", 1, 1);
            $VALUES = $values();
            INSTANCE = new Companion(null);
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ActionType.class);
            ADAPTER = new EnumAdapter<ActionType>(orCreateKotlinClass) { // from class: com.tencent.videocut.model.StickerModel$ActionType$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(orCreateKotlinClass);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public StickerModel.ActionType fromValue(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? StickerModel.ActionType.INSTANCE.fromValue(value) : (StickerModel.ActionType) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
            };
        }

        ActionType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        @JvmStatic
        @Nullable
        public static final ActionType fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\b\u00102\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0013J\u0014\u0010(\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\tJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0017J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002000/J\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0017R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002000/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/StickerModel;", "()V", "actionType", "Lcom/tencent/videocut/model/StickerModel$ActionType;", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "bgConfig", "", "", "bgPath", "captionInfo", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "centerX", "", "centerY", "configType", "duration", "", "editable", "", "editingLayerIndex", "", "filePath", "frameScale", "height", "id", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "Lcom/tencent/videocut/model/ImageType;", "layerIndex", "localThumbId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "maxScale", "minScale", "playEndDuration", CanvasView.ACTION_ROTATE, BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "startTime", "textItems", "Lcom/tencent/videocut/model/TextItem;", "thumbUrl", "timelineTrackIndex", "type", "Lcom/tencent/videocut/model/StickerModel$Type;", "watermarkModel", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "width", "build", "scale", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<StickerModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public ActionType actionType;

        @JvmField
        @NotNull
        public AnimationMode animationMode;

        @JvmField
        @NotNull
        public List<String> bgConfig;

        @JvmField
        @NotNull
        public String bgPath;

        @JvmField
        @Nullable
        public CaptionInfo captionInfo;

        @JvmField
        public float centerX;

        @JvmField
        public float centerY;

        @JvmField
        @NotNull
        public String configType;

        @JvmField
        public long duration;

        @JvmField
        public boolean editable;

        @JvmField
        public int editingLayerIndex;

        @JvmField
        @NotNull
        public String filePath;

        @JvmField
        public float frameScale;

        @JvmField
        public int height;

        @JvmField
        @NotNull
        public String id;

        @JvmField
        @NotNull
        public ImageType imageType;

        @JvmField
        public int layerIndex;

        @JvmField
        public int localThumbId;

        @JvmField
        @NotNull
        public String materialId;

        @JvmField
        public float maxScale;

        @JvmField
        public float minScale;

        @JvmField
        public long playEndDuration;

        @JvmField
        public float rotate;

        @JvmField
        public float scaleX;

        @JvmField
        public float scaleY;

        @JvmField
        public long startTime;

        @JvmField
        @NotNull
        public List<TextItem> textItems;

        @JvmField
        @NotNull
        public String thumbUrl;

        @JvmField
        public int timelineTrackIndex;

        @JvmField
        @NotNull
        public Type type;

        @JvmField
        @NotNull
        public Map<String, WatermarkDataSourceModel> watermarkModel;

        @JvmField
        public int width;

        public Builder() {
            List<TextItem> emptyList;
            List<String> emptyList2;
            Map<String, WatermarkDataSourceModel> emptyMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.id = "";
            this.filePath = "";
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.textItems = emptyList;
            this.thumbUrl = "";
            this.animationMode = AnimationMode.LOOP;
            this.type = Type.DEFAULT;
            this.materialId = "";
            this.actionType = ActionType.NONE;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.bgConfig = emptyList2;
            this.bgPath = "";
            this.configType = "";
            this.frameScale = 1.0f;
            this.imageType = ImageType.PAG;
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.watermarkModel = emptyMap;
        }

        @NotNull
        public final Builder actionType(@NotNull ActionType actionType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (Builder) iPatchRedirector.redirect((short) 27, (Object) this, (Object) actionType);
            }
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            this.actionType = actionType;
            return this;
        }

        @NotNull
        public final Builder animationMode(@NotNull AnimationMode animationMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) animationMode);
            }
            Intrinsics.checkNotNullParameter(animationMode, "animationMode");
            this.animationMode = animationMode;
            return this;
        }

        @NotNull
        public final Builder bgConfig(@NotNull List<String> bgConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (Builder) iPatchRedirector.redirect((short) 28, (Object) this, (Object) bgConfig);
            }
            Intrinsics.checkNotNullParameter(bgConfig, "bgConfig");
            Internal.checkElementsNotNull(bgConfig);
            this.bgConfig = bgConfig;
            return this;
        }

        @NotNull
        public final Builder bgPath(@NotNull String bgPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (Builder) iPatchRedirector.redirect((short) 29, (Object) this, (Object) bgPath);
            }
            Intrinsics.checkNotNullParameter(bgPath, "bgPath");
            this.bgPath = bgPath;
            return this;
        }

        @NotNull
        public final Builder captionInfo(@Nullable CaptionInfo captionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, (Object) captionInfo);
            }
            this.captionInfo = captionInfo;
            return this;
        }

        @NotNull
        public final Builder centerX(float centerX) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, this, Float.valueOf(centerX));
            }
            this.centerX = centerX;
            return this;
        }

        @NotNull
        public final Builder centerY(float centerY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, this, Float.valueOf(centerY));
            }
            this.centerY = centerY;
            return this;
        }

        @NotNull
        public final Builder configType(@NotNull String configType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (Builder) iPatchRedirector.redirect((short) 30, (Object) this, (Object) configType);
            }
            Intrinsics.checkNotNullParameter(configType, "configType");
            this.configType = configType;
            return this;
        }

        @NotNull
        public final Builder duration(long duration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, duration);
            }
            this.duration = duration;
            return this;
        }

        @NotNull
        public final Builder editable(boolean editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, editable);
            }
            this.editable = editable;
            return this;
        }

        @NotNull
        public final Builder editingLayerIndex(int editingLayerIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (Builder) iPatchRedirector.redirect((short) 25, (Object) this, editingLayerIndex);
            }
            this.editingLayerIndex = editingLayerIndex;
            return this;
        }

        @NotNull
        public final Builder filePath(@NotNull String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePath);
            }
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            this.filePath = filePath;
            return this;
        }

        @NotNull
        public final Builder frameScale(float frameScale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (Builder) iPatchRedirector.redirect((short) 31, this, Float.valueOf(frameScale));
            }
            this.frameScale = frameScale;
            return this;
        }

        @NotNull
        public final Builder height(int height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, height);
            }
            this.height = height;
            return this;
        }

        @NotNull
        public final Builder id(@NotNull String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            Intrinsics.checkNotNullParameter(id5, "id");
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder imageType(@NotNull ImageType imageType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (Builder) iPatchRedirector.redirect((short) 33, (Object) this, (Object) imageType);
            }
            Intrinsics.checkNotNullParameter(imageType, "imageType");
            this.imageType = imageType;
            return this;
        }

        @NotNull
        public final Builder layerIndex(int layerIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, layerIndex);
            }
            this.layerIndex = layerIndex;
            return this;
        }

        @NotNull
        public final Builder localThumbId(int localThumbId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, (Object) this, localThumbId);
            }
            this.localThumbId = localThumbId;
            return this;
        }

        @NotNull
        public final Builder materialId(@NotNull String materialId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) materialId);
            }
            Intrinsics.checkNotNullParameter(materialId, "materialId");
            this.materialId = materialId;
            return this;
        }

        @NotNull
        public final Builder maxScale(float maxScale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, this, Float.valueOf(maxScale));
            }
            this.maxScale = maxScale;
            return this;
        }

        @NotNull
        public final Builder minScale(float minScale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, this, Float.valueOf(minScale));
            }
            this.minScale = minScale;
            return this;
        }

        @NotNull
        public final Builder playEndDuration(long playEndDuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (Builder) iPatchRedirector.redirect((short) 26, (Object) this, playEndDuration);
            }
            this.playEndDuration = playEndDuration;
            return this;
        }

        @NotNull
        public final Builder rotate(float rotate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, this, Float.valueOf(rotate));
            }
            this.rotate = rotate;
            return this;
        }

        @NotNull
        public final Builder scaleX(float scale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, this, Float.valueOf(scale));
            }
            this.scaleX = scale;
            return this;
        }

        @NotNull
        public final Builder scaleY(float scale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, this, Float.valueOf(scale));
            }
            this.scaleY = scale;
            return this;
        }

        @NotNull
        public final Builder startTime(long startTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, startTime);
            }
            this.startTime = startTime;
            return this;
        }

        @NotNull
        public final Builder textItems(@NotNull List<TextItem> textItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) textItems);
            }
            Intrinsics.checkNotNullParameter(textItems, "textItems");
            Internal.checkElementsNotNull(textItems);
            this.textItems = textItems;
            return this;
        }

        @NotNull
        public final Builder thumbUrl(@NotNull String thumbUrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) thumbUrl);
            }
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            this.thumbUrl = thumbUrl;
            return this;
        }

        @NotNull
        public final Builder timelineTrackIndex(int timelineTrackIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, timelineTrackIndex);
            }
            this.timelineTrackIndex = timelineTrackIndex;
            return this;
        }

        @NotNull
        public final Builder type(@NotNull Type type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) type);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder watermarkModel(@NotNull Map<String, WatermarkDataSourceModel> watermarkModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return (Builder) iPatchRedirector.redirect((short) 32, (Object) this, (Object) watermarkModel);
            }
            Intrinsics.checkNotNullParameter(watermarkModel, "watermarkModel");
            this.watermarkModel = watermarkModel;
            return this;
        }

        @NotNull
        public final Builder width(int width) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, width);
            }
            this.width = width;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public StickerModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) ? new StickerModel(this.id, this.filePath, this.startTime, this.duration, this.layerIndex, this.scaleX, this.scaleY, this.rotate, this.centerX, this.centerY, this.editable, this.width, this.height, this.minScale, this.maxScale, this.textItems, this.thumbUrl, this.timelineTrackIndex, this.animationMode, this.type, this.materialId, this.captionInfo, this.localThumbId, this.editingLayerIndex, this.playEndDuration, this.actionType, this.bgConfig, this.bgPath, this.configType, this.frameScale, this.watermarkModel, this.imageType, buildUnknownFields()) : (StickerModel) iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo$Builder;", "source", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/StickerModel$CaptionSource;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class CaptionInfo extends AndroidMessage<CaptionInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<CaptionInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<CaptionInfo> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @WireField(adapter = "com.tencent.videocut.model.StickerModel$CaptionSource#ADAPTER", tag = 1)
        @JvmField
        @Nullable
        public final CaptionSource source;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$CaptionInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "()V", "source", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<CaptionInfo, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            @Nullable
            public CaptionSource source;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @NotNull
            public final Builder source(@Nullable CaptionSource source) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
                }
                this.source = source;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public CaptionInfo build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new CaptionInfo(this.source, buildUnknownFields()) : (CaptionInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$CaptionInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$CaptionInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59158);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            INSTANCE = new Companion(null);
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CaptionInfo.class);
            ProtoAdapter<CaptionInfo> protoAdapter = new ProtoAdapter<CaptionInfo>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.StickerModel$CaptionInfo$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.StickerModel.CaptionInfo");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public StickerModel.CaptionInfo decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (StickerModel.CaptionInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    StickerModel.CaptionSource captionSource = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new StickerModel.CaptionInfo(captionSource, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            try {
                                captionSource = StickerModel.CaptionSource.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        } else {
                            reader.readUnknownField(nextTag);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull StickerModel.CaptionInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    StickerModel.CaptionSource.ADAPTER.encodeWithTag(writer, 1, value.source);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull StickerModel.CaptionInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return StickerModel.CaptionSource.ADAPTER.encodedSizeWithTag(1, value.source) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public StickerModel.CaptionInfo redact(@NotNull StickerModel.CaptionInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (StickerModel.CaptionInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return StickerModel.CaptionInfo.copy$default(value, null, ByteString.EMPTY, 1, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public CaptionInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
        }

        public static /* synthetic */ CaptionInfo copy$default(CaptionInfo captionInfo, CaptionSource captionSource, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                captionSource = captionInfo.source;
            }
            if ((i3 & 2) != 0) {
                byteString = captionInfo.unknownFields();
            }
            return captionInfo.copy(captionSource, byteString);
        }

        @NotNull
        public final CaptionInfo copy(@Nullable CaptionSource source, @NotNull ByteString unknownFields) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (CaptionInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) source, (Object) unknownFields);
            }
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            return new CaptionInfo(source, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
            if (other == this) {
                return true;
            }
            if (!(other instanceof CaptionInfo)) {
                return false;
            }
            CaptionInfo captionInfo = (CaptionInfo) other;
            if (Intrinsics.areEqual(unknownFields(), captionInfo.unknownFields()) && this.source == captionInfo.source) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            int i16 = this.hashCode;
            if (i16 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                CaptionSource captionSource = this.source;
                if (captionSource != null) {
                    i3 = captionSource.hashCode();
                } else {
                    i3 = 0;
                }
                int i17 = hashCode + i3;
                this.hashCode = i17;
                return i17;
            }
            return i16;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            CaptionSource captionSource = this.source;
            if (captionSource != null) {
                arrayList.add("source=" + captionSource);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "CaptionInfo{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ CaptionInfo(CaptionSource captionSource, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : captionSource, (i3 & 2) != 0 ? ByteString.EMPTY : byteString);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, captionSource, byteString, Integer.valueOf(i3), defaultConstructorMarker);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Builder builder = new Builder();
            builder.source = this.source;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptionInfo(@Nullable CaptionSource captionSource, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.source = captionSource;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) captionSource, (Object) unknownFields);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "VIDEO", "MUSIC", "RECORD", "SEPARATE", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class CaptionSource implements WireEnum {
        private static final /* synthetic */ CaptionSource[] $VALUES;
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<CaptionSource> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final CaptionSource MUSIC;
        public static final CaptionSource RECORD;
        public static final CaptionSource SEPARATE;
        public static final CaptionSource VIDEO;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$CaptionSource$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$CaptionSource;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            @Nullable
            public final CaptionSource fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (CaptionSource) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                return null;
                            }
                            return CaptionSource.SEPARATE;
                        }
                        return CaptionSource.RECORD;
                    }
                    return CaptionSource.MUSIC;
                }
                return CaptionSource.VIDEO;
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ CaptionSource[] $values() {
            return new CaptionSource[]{VIDEO, MUSIC, RECORD, SEPARATE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59178);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            VIDEO = new CaptionSource("VIDEO", 0, 0);
            MUSIC = new CaptionSource("MUSIC", 1, 1);
            RECORD = new CaptionSource("RECORD", 2, 2);
            SEPARATE = new CaptionSource("SEPARATE", 3, 3);
            $VALUES = $values();
            INSTANCE = new Companion(null);
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CaptionSource.class);
            ADAPTER = new EnumAdapter<CaptionSource>(orCreateKotlinClass) { // from class: com.tencent.videocut.model.StickerModel$CaptionSource$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(orCreateKotlinClass);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public StickerModel.CaptionSource fromValue(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? StickerModel.CaptionSource.INSTANCE.fromValue(value) : (StickerModel.CaptionSource) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
            };
        }

        CaptionSource(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        @JvmStatic
        @Nullable
        public static final CaptionSource fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        public static CaptionSource valueOf(String str) {
            return (CaptionSource) Enum.valueOf(CaptionSource.class, str);
        }

        public static CaptionSource[] values() {
            return (CaptionSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "DEFAULT", "TEXT", "TEXT_TEMPLATE", "TOP_FRAME", "BOTTOM_FRAME", "MASK", "CUSTOM", "IMAGE_TEMPLATE", "TEXT_BACKGROUND_TEMPLATE", "MOSAIC_DOODLE", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Type implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<Type> ADAPTER;
        public static final Type BOTTOM_FRAME;
        public static final Type CUSTOM;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final Type DEFAULT;
        public static final Type IMAGE_TEMPLATE;
        public static final Type MASK;
        public static final Type MOSAIC_DOODLE;
        public static final Type TEXT;
        public static final Type TEXT_BACKGROUND_TEMPLATE;
        public static final Type TEXT_TEMPLATE;
        public static final Type TOP_FRAME;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/StickerModel$Type$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel$Type;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            @Nullable
            public final Type fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Type) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
                switch (value) {
                    case 0:
                        return Type.DEFAULT;
                    case 1:
                        return Type.TEXT;
                    case 2:
                        return Type.TEXT_TEMPLATE;
                    case 3:
                        return Type.TOP_FRAME;
                    case 4:
                        return Type.BOTTOM_FRAME;
                    case 5:
                        return Type.MASK;
                    case 6:
                        return Type.CUSTOM;
                    case 7:
                        return Type.IMAGE_TEMPLATE;
                    case 8:
                        return Type.TEXT_BACKGROUND_TEMPLATE;
                    case 9:
                        return Type.MOSAIC_DOODLE;
                    default:
                        return null;
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DEFAULT, TEXT, TEXT_TEMPLATE, TOP_FRAME, BOTTOM_FRAME, MASK, CUSTOM, IMAGE_TEMPLATE, TEXT_BACKGROUND_TEMPLATE, MOSAIC_DOODLE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59206);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            DEFAULT = new Type("DEFAULT", 0, 0);
            TEXT = new Type("TEXT", 1, 1);
            TEXT_TEMPLATE = new Type("TEXT_TEMPLATE", 2, 2);
            TOP_FRAME = new Type("TOP_FRAME", 3, 3);
            BOTTOM_FRAME = new Type("BOTTOM_FRAME", 4, 4);
            MASK = new Type("MASK", 5, 5);
            CUSTOM = new Type("CUSTOM", 6, 6);
            IMAGE_TEMPLATE = new Type("IMAGE_TEMPLATE", 7, 7);
            TEXT_BACKGROUND_TEMPLATE = new Type("TEXT_BACKGROUND_TEMPLATE", 8, 8);
            MOSAIC_DOODLE = new Type("MOSAIC_DOODLE", 9, 9);
            $VALUES = $values();
            INSTANCE = new Companion(null);
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Type.class);
            ADAPTER = new EnumAdapter<Type>(orCreateKotlinClass) { // from class: com.tencent.videocut.model.StickerModel$Type$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(orCreateKotlinClass);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) orCreateKotlinClass);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public StickerModel.Type fromValue(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? StickerModel.Type.INSTANCE.fromValue(value) : (StickerModel.Type) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
            };
        }

        Type(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        @JvmStatic
        @Nullable
        public static final Type fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59211);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(StickerModel.class);
        ProtoAdapter<StickerModel> protoAdapter = new ProtoAdapter<StickerModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.StickerModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            @NotNull
            private final ProtoAdapter<Map<String, WatermarkDataSourceModel>> watermarkAdapter;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.StickerModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                } else {
                    this.watermarkAdapter = ProtoAdapter.INSTANCE.newMapAdapter(ProtoAdapter.STRING, WatermarkDataSourceModel.ADAPTER);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0086. Please report as an issue. */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public StickerModel decode(@NotNull ProtoReader reader) {
                StickerModel.Type type;
                StickerModel.ActionType actionType;
                ImageType imageType;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (StickerModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                AnimationMode animationMode = AnimationMode.LOOP;
                StickerModel.Type type2 = StickerModel.Type.DEFAULT;
                StickerModel.ActionType actionType2 = StickerModel.ActionType.NONE;
                ArrayList arrayList2 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ImageType imageType2 = ImageType.PAG;
                long beginMessage = reader.beginMessage();
                long j3 = 0;
                long j16 = 0;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                float f16 = 0.0f;
                float f17 = 0.0f;
                float f18 = 0.0f;
                float f19 = 0.0f;
                float f26 = 0.0f;
                float f27 = 0.0f;
                float f28 = 0.0f;
                int i3 = 0;
                boolean z16 = false;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i26 = 0;
                StickerModel.CaptionInfo captionInfo = null;
                float f29 = 1.0f;
                StickerModel.Type type3 = type2;
                StickerModel.ActionType actionType3 = actionType2;
                ImageType imageType3 = imageType2;
                long j17 = 0;
                String str5 = str4;
                String str6 = str5;
                AnimationMode animationMode2 = animationMode;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new StickerModel(str5, str6, j16, j17, i3, f16, f17, f18, f19, f26, z16, i16, i17, f27, f28, arrayList, str, i18, animationMode2, type3, str2, captionInfo, i19, i26, j3, actionType3, arrayList2, str3, str4, f29, linkedHashMap, imageType3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 40) {
                        type = type3;
                        actionType = actionType3;
                        imageType = imageType3;
                        linkedHashMap.putAll(this.watermarkAdapter.decode(reader));
                    } else if (nextTag != 41) {
                        switch (nextTag) {
                            case 1:
                                actionType = actionType3;
                                str5 = ProtoAdapter.STRING.decode(reader);
                                actionType3 = actionType;
                                break;
                            case 2:
                                actionType = actionType3;
                                str6 = ProtoAdapter.STRING.decode(reader);
                                actionType3 = actionType;
                                break;
                            case 3:
                                actionType = actionType3;
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                                actionType3 = actionType;
                                break;
                            case 4:
                                actionType = actionType3;
                                j17 = ProtoAdapter.INT64.decode(reader).longValue();
                                actionType3 = actionType;
                                break;
                            case 5:
                                actionType = actionType3;
                                i3 = ProtoAdapter.INT32.decode(reader).intValue();
                                actionType3 = actionType;
                                break;
                            case 6:
                                actionType = actionType3;
                                f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 7:
                                actionType = actionType3;
                                f18 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 8:
                                actionType = actionType3;
                                f19 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 9:
                                actionType = actionType3;
                                f26 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 10:
                                actionType = actionType3;
                                z16 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                                actionType3 = actionType;
                                break;
                            case 11:
                                actionType = actionType3;
                                i16 = ProtoAdapter.INT32.decode(reader).intValue();
                                actionType3 = actionType;
                                break;
                            case 12:
                                actionType = actionType3;
                                i17 = ProtoAdapter.INT32.decode(reader).intValue();
                                actionType3 = actionType;
                                break;
                            case 13:
                                actionType = actionType3;
                                f27 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 14:
                                actionType = actionType3;
                                f28 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                actionType3 = actionType;
                                break;
                            case 15:
                                type = type3;
                                actionType = actionType3;
                                imageType = imageType3;
                                arrayList.add(TextItem.ADAPTER.decode(reader));
                                break;
                            case 16:
                                actionType = actionType3;
                                str = ProtoAdapter.STRING.decode(reader);
                                actionType3 = actionType;
                                break;
                            case 17:
                                actionType = actionType3;
                                i18 = ProtoAdapter.INT32.decode(reader).intValue();
                                actionType3 = actionType;
                                break;
                            case 18:
                                type = type3;
                                actionType = actionType3;
                                imageType = imageType3;
                                try {
                                    animationMode2 = AnimationMode.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                            case 19:
                                type = type3;
                                actionType = actionType3;
                                try {
                                    type3 = StickerModel.Type.ADAPTER.decode(reader);
                                } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                    imageType = imageType3;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                    break;
                                }
                                actionType3 = actionType;
                                break;
                            case 20:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 21:
                                captionInfo = StickerModel.CaptionInfo.ADAPTER.decode(reader);
                                break;
                            case 22:
                                i19 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 23:
                                i26 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 24:
                                j3 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 25:
                                try {
                                    actionType3 = StickerModel.ActionType.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e18) {
                                    type = type3;
                                    actionType = actionType3;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e18.value));
                                    break;
                                }
                            case 26:
                                arrayList2.add(ProtoAdapter.STRING.decode(reader));
                                type = type3;
                                actionType = actionType3;
                                imageType = imageType3;
                                break;
                            case 27:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 28:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 29:
                                f29 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 30:
                                f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                type = type3;
                                actionType = actionType3;
                                imageType = imageType3;
                                break;
                        }
                    } else {
                        imageType3 = ImageType.ADAPTER.decode(reader);
                    }
                    imageType3 = imageType;
                    type3 = type;
                    actionType3 = actionType;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull StickerModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                protoAdapter2.encodeWithTag(writer, 2, value.filePath);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                protoAdapter3.encodeWithTag(writer, 3, Long.valueOf(value.startTime));
                protoAdapter3.encodeWithTag(writer, 4, Long.valueOf(value.duration));
                ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
                protoAdapter4.encodeWithTag(writer, 5, Integer.valueOf(value.layerIndex));
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                protoAdapter5.encodeWithTag(writer, 6, Float.valueOf(value.scaleX));
                protoAdapter5.encodeWithTag(writer, 7, Float.valueOf(value.rotate));
                protoAdapter5.encodeWithTag(writer, 8, Float.valueOf(value.centerX));
                protoAdapter5.encodeWithTag(writer, 9, Float.valueOf(value.centerY));
                ProtoAdapter.BOOL.encodeWithTag(writer, 10, Boolean.valueOf(value.editable));
                protoAdapter4.encodeWithTag(writer, 11, Integer.valueOf(value.width));
                protoAdapter4.encodeWithTag(writer, 12, Integer.valueOf(value.height));
                protoAdapter5.encodeWithTag(writer, 13, Float.valueOf(value.minScale));
                protoAdapter5.encodeWithTag(writer, 14, Float.valueOf(value.maxScale));
                TextItem.ADAPTER.asRepeated().encodeWithTag(writer, 15, value.textItems);
                protoAdapter2.encodeWithTag(writer, 16, value.thumbUrl);
                protoAdapter4.encodeWithTag(writer, 17, Integer.valueOf(value.timelineTrackIndex));
                AnimationMode.ADAPTER.encodeWithTag(writer, 18, value.animationMode);
                StickerModel.Type.ADAPTER.encodeWithTag(writer, 19, value.type);
                protoAdapter2.encodeWithTag(writer, 20, value.materialId);
                StickerModel.CaptionInfo.ADAPTER.encodeWithTag(writer, 21, value.captionInfo);
                protoAdapter4.encodeWithTag(writer, 22, Integer.valueOf(value.localThumbId));
                protoAdapter4.encodeWithTag(writer, 23, Integer.valueOf(value.editingLayerIndex));
                protoAdapter3.encodeWithTag(writer, 24, Long.valueOf(value.playEndDuration));
                StickerModel.ActionType.ADAPTER.encodeWithTag(writer, 25, value.actionType);
                protoAdapter2.asRepeated().encodeWithTag(writer, 26, value.bgConfig);
                protoAdapter2.encodeWithTag(writer, 27, value.bgPath);
                protoAdapter2.encodeWithTag(writer, 28, value.configType);
                protoAdapter5.encodeWithTag(writer, 29, Float.valueOf(value.frameScale));
                protoAdapter5.encodeWithTag(writer, 30, Float.valueOf(value.scaleY));
                this.watermarkAdapter.encodeWithTag(writer, 40, value.watermarkModel);
                ImageType.ADAPTER.encodeWithTag(writer, 41, value.imageType);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull StickerModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.filePath);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, Long.valueOf(value.startTime)) + protoAdapter3.encodedSizeWithTag(4, Long.valueOf(value.duration));
                ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(5, Integer.valueOf(value.layerIndex));
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(6, Float.valueOf(value.scaleX)) + protoAdapter5.encodedSizeWithTag(7, Float.valueOf(value.rotate)) + protoAdapter5.encodedSizeWithTag(8, Float.valueOf(value.centerX)) + protoAdapter5.encodedSizeWithTag(9, Float.valueOf(value.centerY)) + ProtoAdapter.BOOL.encodedSizeWithTag(10, Boolean.valueOf(value.editable)) + protoAdapter4.encodedSizeWithTag(11, Integer.valueOf(value.width)) + protoAdapter4.encodedSizeWithTag(12, Integer.valueOf(value.height)) + protoAdapter5.encodedSizeWithTag(13, Float.valueOf(value.minScale)) + protoAdapter5.encodedSizeWithTag(14, Float.valueOf(value.maxScale)) + TextItem.ADAPTER.asRepeated().encodedSizeWithTag(15, value.textItems) + protoAdapter2.encodedSizeWithTag(16, value.thumbUrl) + protoAdapter4.encodedSizeWithTag(17, Integer.valueOf(value.timelineTrackIndex)) + AnimationMode.ADAPTER.encodedSizeWithTag(18, value.animationMode) + StickerModel.Type.ADAPTER.encodedSizeWithTag(19, value.type) + protoAdapter2.encodedSizeWithTag(20, value.materialId) + StickerModel.CaptionInfo.ADAPTER.encodedSizeWithTag(21, value.captionInfo) + protoAdapter4.encodedSizeWithTag(22, Integer.valueOf(value.localThumbId)) + protoAdapter4.encodedSizeWithTag(23, Integer.valueOf(value.editingLayerIndex)) + protoAdapter3.encodedSizeWithTag(24, Long.valueOf(value.playEndDuration)) + StickerModel.ActionType.ADAPTER.encodedSizeWithTag(25, value.actionType) + protoAdapter2.asRepeated().encodedSizeWithTag(26, value.bgConfig) + protoAdapter2.encodedSizeWithTag(27, value.bgPath) + protoAdapter2.encodedSizeWithTag(28, value.configType) + protoAdapter5.encodedSizeWithTag(29, Float.valueOf(value.frameScale)) + protoAdapter5.encodedSizeWithTag(30, Float.valueOf(value.scaleY)) + this.watermarkAdapter.encodedSizeWithTag(40, value.watermarkModel) + ImageType.ADAPTER.encodedSizeWithTag(41, value.imageType) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public StickerModel redact(@NotNull StickerModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (StickerModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                List m87redactElements = Internal.m87redactElements(value.textItems, TextItem.ADAPTER);
                StickerModel.CaptionInfo captionInfo = value.captionInfo;
                return StickerModel.copy$default(value, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, m87redactElements, null, 0, null, null, null, captionInfo != null ? StickerModel.CaptionInfo.ADAPTER.redact(captionInfo) : null, 0, 0, 0L, null, null, null, null, 0.0f, Internal.m88redactElements(value.watermarkModel, WatermarkDataSourceModel.ADAPTER), null, ByteString.EMPTY, -1075871745, 0, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public StickerModel() {
        this(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, -1, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ StickerModel copy$default(StickerModel stickerModel, String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, List list, String str3, int i18, AnimationMode animationMode, Type type, String str4, CaptionInfo captionInfo, int i19, int i26, long j17, ActionType actionType, List list2, String str5, String str6, float f29, Map map, ImageType imageType, ByteString byteString, int i27, int i28, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        return stickerModel.copy((i27 & 1) != 0 ? stickerModel.id : str, (i27 & 2) != 0 ? stickerModel.filePath : str2, (i27 & 4) != 0 ? stickerModel.startTime : j3, (i27 & 8) != 0 ? stickerModel.duration : j16, (i27 & 16) != 0 ? stickerModel.layerIndex : i3, (i27 & 32) != 0 ? stickerModel.scaleX : f16, (i27 & 64) != 0 ? stickerModel.scaleY : f17, (i27 & 128) != 0 ? stickerModel.rotate : f18, (i27 & 256) != 0 ? stickerModel.centerX : f19, (i27 & 512) != 0 ? stickerModel.centerY : f26, (i27 & 1024) != 0 ? stickerModel.editable : z16, (i27 & 2048) != 0 ? stickerModel.width : i16, (i27 & 4096) != 0 ? stickerModel.height : i17, (i27 & 8192) != 0 ? stickerModel.minScale : f27, (i27 & 16384) != 0 ? stickerModel.maxScale : f28, (i27 & 32768) != 0 ? stickerModel.textItems : list, (i27 & 65536) != 0 ? stickerModel.thumbUrl : str3, (i27 & 131072) != 0 ? stickerModel.timelineTrackIndex : i18, (i27 & 262144) != 0 ? stickerModel.animationMode : animationMode, (i27 & 524288) != 0 ? stickerModel.type : type, (i27 & 1048576) != 0 ? stickerModel.materialId : str4, (i27 & 2097152) != 0 ? stickerModel.captionInfo : captionInfo, (i27 & 4194304) != 0 ? stickerModel.localThumbId : i19, (i27 & 8388608) != 0 ? stickerModel.editingLayerIndex : i26, (i27 & 16777216) != 0 ? stickerModel.playEndDuration : j17, (i27 & 33554432) != 0 ? stickerModel.actionType : actionType, (67108864 & i27) != 0 ? stickerModel.bgConfig : list2, (i27 & 134217728) != 0 ? stickerModel.bgPath : str5, (i27 & 268435456) != 0 ? stickerModel.configType : str6, (i27 & 536870912) != 0 ? stickerModel.frameScale : f29, (i27 & 1073741824) != 0 ? stickerModel.watermarkModel : map, (i27 & Integer.MIN_VALUE) != 0 ? stickerModel.imageType : imageType, (i28 & 1) != 0 ? stickerModel.unknownFields() : byteString);
    }

    @NotNull
    public final StickerModel copy(@NotNull String id5, @NotNull String filePath, long startTime, long duration, int layerIndex, float scaleX, float scaleY, float rotate, float centerX, float centerY, boolean editable, int width, int height, float minScale, float maxScale, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int timelineTrackIndex, @NotNull AnimationMode animationMode, @NotNull Type type, @NotNull String materialId, @Nullable CaptionInfo captionInfo, int localThumbId, int editingLayerIndex, long playEndDuration, @NotNull ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, float frameScale, @NotNull Map<String, WatermarkDataSourceModel> watermarkModel, @NotNull ImageType imageType, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (StickerModel) iPatchRedirector.redirect((short) 7, this, id5, filePath, Long.valueOf(startTime), Long.valueOf(duration), Integer.valueOf(layerIndex), Float.valueOf(scaleX), Float.valueOf(scaleY), Float.valueOf(rotate), Float.valueOf(centerX), Float.valueOf(centerY), Boolean.valueOf(editable), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(minScale), Float.valueOf(maxScale), textItems, thumbUrl, Integer.valueOf(timelineTrackIndex), animationMode, type, materialId, captionInfo, Integer.valueOf(localThumbId), Integer.valueOf(editingLayerIndex), Long.valueOf(playEndDuration), actionType, bgConfig, bgPath, configType, Float.valueOf(frameScale), watermarkModel, imageType, unknownFields);
        }
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
        return new StickerModel(id5, filePath, startTime, duration, layerIndex, scaleX, scaleY, rotate, centerX, centerY, editable, width, height, minScale, maxScale, textItems, thumbUrl, timelineTrackIndex, animationMode, type, materialId, captionInfo, localThumbId, editingLayerIndex, playEndDuration, actionType, bgConfig, bgPath, configType, frameScale, watermarkModel, imageType, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof StickerModel)) {
            return false;
        }
        StickerModel stickerModel = (StickerModel) other;
        if (Intrinsics.areEqual(unknownFields(), stickerModel.unknownFields()) && Intrinsics.areEqual(this.id, stickerModel.id) && Intrinsics.areEqual(this.filePath, stickerModel.filePath) && this.startTime == stickerModel.startTime && this.duration == stickerModel.duration && this.layerIndex == stickerModel.layerIndex) {
            if (this.scaleX == stickerModel.scaleX) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.scaleY == stickerModel.scaleY) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.rotate == stickerModel.rotate) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (this.centerX == stickerModel.centerX) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            if (this.centerY == stickerModel.centerY) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26 && this.editable == stickerModel.editable && this.width == stickerModel.width && this.height == stickerModel.height) {
                                if (this.minScale == stickerModel.minScale) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (z27) {
                                    if (this.maxScale == stickerModel.maxScale) {
                                        z28 = true;
                                    } else {
                                        z28 = false;
                                    }
                                    if (z28 && Intrinsics.areEqual(this.textItems, stickerModel.textItems) && Intrinsics.areEqual(this.thumbUrl, stickerModel.thumbUrl) && this.timelineTrackIndex == stickerModel.timelineTrackIndex && this.animationMode == stickerModel.animationMode && this.type == stickerModel.type && Intrinsics.areEqual(this.materialId, stickerModel.materialId) && Intrinsics.areEqual(this.captionInfo, stickerModel.captionInfo) && this.localThumbId == stickerModel.localThumbId && this.editingLayerIndex == stickerModel.editingLayerIndex && this.playEndDuration == stickerModel.playEndDuration && this.actionType == stickerModel.actionType && Intrinsics.areEqual(this.bgConfig, stickerModel.bgConfig) && Intrinsics.areEqual(this.bgPath, stickerModel.bgPath) && Intrinsics.areEqual(this.configType, stickerModel.configType)) {
                                        if (this.frameScale == stickerModel.frameScale) {
                                            z29 = true;
                                        } else {
                                            z29 = false;
                                        }
                                        if (z29 && Intrinsics.areEqual(this.watermarkModel, stickerModel.watermarkModel) && this.imageType == stickerModel.imageType) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.filePath.hashCode()) * 37) + a.a(this.startTime)) * 37) + a.a(this.duration)) * 37) + this.layerIndex) * 37) + Float.floatToIntBits(this.scaleX)) * 37) + Float.floatToIntBits(this.scaleY)) * 37) + Float.floatToIntBits(this.rotate)) * 37) + Float.floatToIntBits(this.centerX)) * 37) + Float.floatToIntBits(this.centerY)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.editable)) * 37) + this.width) * 37) + this.height) * 37) + Float.floatToIntBits(this.minScale)) * 37) + Float.floatToIntBits(this.maxScale)) * 37) + this.textItems.hashCode()) * 37) + this.thumbUrl.hashCode()) * 37) + this.timelineTrackIndex) * 37) + this.animationMode.hashCode()) * 37) + this.type.hashCode()) * 37) + this.materialId.hashCode()) * 37;
            CaptionInfo captionInfo = this.captionInfo;
            if (captionInfo != null) {
                i3 = captionInfo.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((((((((((((((((((((hashCode + i3) * 37) + this.localThumbId) * 37) + this.editingLayerIndex) * 37) + a.a(this.playEndDuration)) * 37) + this.actionType.hashCode()) * 37) + this.bgConfig.hashCode()) * 37) + this.bgPath.hashCode()) * 37) + this.configType.hashCode()) * 37) + Float.floatToIntBits(this.frameScale)) * 37) + this.watermarkModel.hashCode()) * 37) + this.imageType.hashCode();
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        String str2 = this.filePath;
        if (str2 != null) {
            arrayList.add("filePath=" + Internal.sanitize(str2));
        }
        arrayList.add("startTime=" + this.startTime);
        arrayList.add("duration=" + this.duration);
        arrayList.add("layerIndex=" + this.layerIndex);
        arrayList.add("scale=" + this.scaleX);
        arrayList.add("scale=" + this.scaleY);
        arrayList.add("rotate=" + this.rotate);
        arrayList.add("centerX=" + this.centerX);
        arrayList.add("centerY=" + this.centerY);
        arrayList.add("editable=" + this.editable);
        arrayList.add("width=" + this.width);
        arrayList.add("height=" + this.height);
        arrayList.add("minScale=" + this.minScale);
        arrayList.add("maxScale=" + this.maxScale);
        if (!this.textItems.isEmpty()) {
            arrayList.add("textItems=" + this.textItems);
        }
        String str3 = this.thumbUrl;
        if (str3 != null) {
            arrayList.add("thumbUrl=" + Internal.sanitize(str3));
        }
        arrayList.add("timelineTrackIndex=" + this.timelineTrackIndex);
        AnimationMode animationMode = this.animationMode;
        if (animationMode != null) {
            arrayList.add("animationMode=" + animationMode);
        }
        Type type = this.type;
        if (type != null) {
            arrayList.add("type=" + type);
        }
        String str4 = this.materialId;
        if (str4 != null) {
            arrayList.add("materialId=" + Internal.sanitize(str4));
        }
        CaptionInfo captionInfo = this.captionInfo;
        if (captionInfo != null) {
            arrayList.add("captionInfo=" + captionInfo);
        }
        arrayList.add("localThumbId=" + this.localThumbId);
        arrayList.add("editingLayerIndex=" + this.editingLayerIndex);
        arrayList.add("playEndDuration=" + this.playEndDuration);
        ActionType actionType = this.actionType;
        if (actionType != null) {
            arrayList.add("actionType=" + actionType);
        }
        if (!this.bgConfig.isEmpty()) {
            arrayList.add("bgConfig=" + Internal.sanitize(this.bgConfig));
        }
        String str5 = this.bgPath;
        if (str5 != null) {
            arrayList.add("bgPath=" + Internal.sanitize(str5));
        }
        String str6 = this.configType;
        if (str6 != null) {
            arrayList.add("configType=" + Internal.sanitize(str6));
        }
        arrayList.add("frameScale=" + this.frameScale);
        if (!this.watermarkModel.isEmpty()) {
            arrayList.add("watermarkModel=" + this.watermarkModel);
        }
        ImageType imageType = this.imageType;
        if (imageType != null) {
            arrayList.add("imageType=" + imageType);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "StickerModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StickerModel(String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, List list, String str3, int i18, AnimationMode animationMode, Type type, String str4, CaptionInfo captionInfo, int i19, int i26, long j17, ActionType actionType, List list2, String str5, String str6, float f29, Map map, ImageType imageType, ByteString byteString, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r8, r10, r1, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r36, r2, r37, r38, (Integer.MIN_VALUE & i27) != 0 ? ImageType.PAG : imageType, (i28 & 1) != 0 ? ByteString.EMPTY : byteString);
        List list3;
        List list4;
        Map map2;
        Map emptyMap;
        List emptyList;
        List emptyList2;
        String str7 = (i27 & 1) != 0 ? "" : str;
        String str8 = (i27 & 2) != 0 ? "" : str2;
        long j18 = (i27 & 4) != 0 ? 0L : j3;
        long j19 = (i27 & 8) != 0 ? 0L : j16;
        int i29 = (i27 & 16) != 0 ? 0 : i3;
        float f36 = (i27 & 32) != 0 ? 0.0f : f16;
        float f37 = (i27 & 64) != 0 ? 0.0f : f17;
        float f38 = (i27 & 128) != 0 ? 0.0f : f18;
        float f39 = (i27 & 256) != 0 ? 0.0f : f19;
        float f46 = (i27 & 512) != 0 ? 0.0f : f26;
        boolean z17 = (i27 & 1024) != 0 ? false : z16;
        int i36 = (i27 & 2048) != 0 ? 0 : i16;
        int i37 = (i27 & 4096) != 0 ? 0 : i17;
        float f47 = (i27 & 8192) != 0 ? 0.0f : f27;
        float f48 = (i27 & 16384) != 0 ? 0.0f : f28;
        if ((32768 & i27) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        String str9 = (65536 & i27) != 0 ? "" : str3;
        int i38 = (131072 & i27) != 0 ? 0 : i18;
        AnimationMode animationMode2 = (262144 & i27) != 0 ? AnimationMode.LOOP : animationMode;
        Type type2 = (524288 & i27) != 0 ? Type.DEFAULT : type;
        String str10 = (1048576 & i27) != 0 ? "" : str4;
        CaptionInfo captionInfo2 = (2097152 & i27) != 0 ? null : captionInfo;
        int i39 = (4194304 & i27) != 0 ? 0 : i19;
        int i46 = (8388608 & i27) != 0 ? 0 : i26;
        long j26 = (16777216 & i27) != 0 ? 0L : j17;
        ActionType actionType2 = (33554432 & i27) != 0 ? ActionType.NONE : actionType;
        if ((67108864 & i27) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
        String str11 = (134217728 & i27) != 0 ? "" : str5;
        String str12 = (268435456 & i27) == 0 ? str6 : "";
        float f49 = (536870912 & i27) != 0 ? 1.0f : f29;
        if ((1073741824 & i27) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f27), Float.valueOf(f28), list, str3, Integer.valueOf(i18), animationMode, type, str4, captionInfo, Integer.valueOf(i19), Integer.valueOf(i26), Long.valueOf(j17), actionType, list2, str5, str6, Float.valueOf(f29), map, imageType, byteString, Integer.valueOf(i27), Integer.valueOf(i28), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.id = this.id;
        builder.filePath = this.filePath;
        builder.startTime = this.startTime;
        builder.duration = this.duration;
        builder.layerIndex = this.layerIndex;
        builder.scaleX = this.scaleX;
        builder.scaleY = this.scaleY;
        builder.rotate = this.rotate;
        builder.centerX = this.centerX;
        builder.centerY = this.centerY;
        builder.editable = this.editable;
        builder.width = this.width;
        builder.height = this.height;
        builder.minScale = this.minScale;
        builder.maxScale = this.maxScale;
        builder.textItems = this.textItems;
        builder.thumbUrl = this.thumbUrl;
        builder.timelineTrackIndex = this.timelineTrackIndex;
        builder.animationMode = this.animationMode;
        builder.type = this.type;
        builder.materialId = this.materialId;
        builder.captionInfo = this.captionInfo;
        builder.localThumbId = this.localThumbId;
        builder.editingLayerIndex = this.editingLayerIndex;
        builder.playEndDuration = this.playEndDuration;
        builder.actionType = this.actionType;
        builder.bgConfig = this.bgConfig;
        builder.bgPath = this.bgPath;
        builder.configType = this.configType;
        builder.frameScale = this.frameScale;
        builder.watermarkModel = this.watermarkModel;
        builder.imageType = this.imageType;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerModel(@NotNull String id5, @NotNull String filePath, long j3, long j16, int i3, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, int i17, float f27, float f28, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int i18, @NotNull AnimationMode animationMode, @NotNull Type type, @NotNull String materialId, @Nullable CaptionInfo captionInfo, int i19, int i26, long j17, @NotNull ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, float f29, @NotNull Map<String, WatermarkDataSourceModel> watermarkModel, @NotNull ImageType imageType, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, filePath, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f27), Float.valueOf(f28), textItems, thumbUrl, Integer.valueOf(i18), animationMode, type, materialId, captionInfo, Integer.valueOf(i19), Integer.valueOf(i26), Long.valueOf(j17), actionType, bgConfig, bgPath, configType, Float.valueOf(f29), watermarkModel, imageType, unknownFields);
            return;
        }
        this.id = id5;
        this.filePath = filePath;
        this.startTime = j3;
        this.duration = j16;
        this.layerIndex = i3;
        this.scaleX = f16;
        this.scaleY = f17;
        this.rotate = f18;
        this.centerX = f19;
        this.centerY = f26;
        this.editable = z16;
        this.width = i16;
        this.height = i17;
        this.minScale = f27;
        this.maxScale = f28;
        this.textItems = textItems;
        this.thumbUrl = thumbUrl;
        this.timelineTrackIndex = i18;
        this.animationMode = animationMode;
        this.type = type;
        this.materialId = materialId;
        this.captionInfo = captionInfo;
        this.localThumbId = i19;
        this.editingLayerIndex = i26;
        this.playEndDuration = j17;
        this.actionType = actionType;
        this.bgConfig = bgConfig;
        this.bgPath = bgPath;
        this.configType = configType;
        this.frameScale = f29;
        this.watermarkModel = watermarkModel;
        this.imageType = imageType;
    }
}
