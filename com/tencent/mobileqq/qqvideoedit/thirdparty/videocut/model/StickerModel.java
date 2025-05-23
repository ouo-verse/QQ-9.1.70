package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
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
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 ?2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006@ABCDEB\u00b7\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020\b\u0012\b\b\u0002\u0010*\u001a\u00020\u000e\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u001c\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00101\u001a\u000200\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00b6\u0002\u00102\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020+2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\b\b\u0002\u0010.\u001a\u00020\n2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00101\u001a\u000200R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00103R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00104R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00104R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00106R\u0014\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00106R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00106R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00106R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00107R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00105R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00105R\u0014\u0010\u001a\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00106R\u0014\u0010\u001b\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00106R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00108R\u0014\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00103R\u0014\u0010 \u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u00105R\u0014\u0010\"\u001a\u00020!8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00109R\u0014\u0010$\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010:R\u0014\u0010%\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u00103R\u0016\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010;R\u0014\u0010(\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u00105R\u0014\u0010)\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b)\u00105R\u0014\u0010*\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0014\u0010,\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010<R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u00108R\u0014\u0010.\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b.\u00103R\u0014\u0010/\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u00103\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "filePath", "", "startTime", "duration", "layerIndex", "", "scale", CanvasView.ACTION_ROTATE, "centerX", "centerY", "editable", "width", "height", "minScale", "maxScale", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "textItems", "thumbUrl", "timelineTrackIndex", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "type", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "captionInfo", "localThumbId", "editingLayerIndex", "playEndDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "actionType", "bgConfig", "bgPath", "configType", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "J", "I", UserInfo.SEX_FEMALE, "Z", "Ljava/util/List;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJIFFFFZIIFFLjava/util/List;Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;IIJLcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "ActionType", "a", "CaptionInfo", "CaptionSource", "c", "Type", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class StickerModel extends AndroidMessage<StickerModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<StickerModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<StickerModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$ActionType#ADAPTER", tag = 25)
    @JvmField
    @NotNull
    public final ActionType actionType;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode#ADAPTER", tag = 18)
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
    public final String bgPath;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$CaptionInfo#ADAPTER", tag = 21)
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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    @JvmField
    public final int height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    public final float rotate;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    public final float scale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @JvmField
    public final long startTime;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem#ADAPTER", label = WireField.Label.REPEATED, tag = 15)
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

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$Type#ADAPTER", tag = 19)
    @JvmField
    @NotNull
    public final Type type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    public final int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "NONE", "REPLACE_ALL", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public enum ActionType implements WireEnum {
        NONE(0),
        REPLACE_ALL(1);

        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        public static final ProtoAdapter<ActionType> ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionType.class));

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType$a", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "", "value", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends EnumAdapter<ActionType> {
            a(KClass<ActionType> kClass) {
                super(kClass);
            }

            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            /* renamed from: a */
            public ActionType fromValue(int value) {
                return ActionType.INSTANCE.a(value);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$ActionType$b, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final ActionType a(int value) {
                if (value != 0) {
                    if (value != 1) {
                        return null;
                    }
                    return ActionType.REPLACE_ALL;
                }
                return ActionType.NONE;
            }

            Companion() {
            }
        }

        ActionType(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final ActionType fromValue(int i3) {
            return INSTANCE.a(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "source", "Lokio/ByteString;", "unknownFields", "copy", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class CaptionInfo extends AndroidMessage<CaptionInfo, a> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<CaptionInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<CaptionInfo> CREATOR;

        @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$CaptionSource#ADAPTER", tag = 1)
        @JvmField
        @Nullable
        public final CaptionSource source;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "a", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "source", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends Message.Builder<CaptionInfo, a> {

            /* renamed from: a, reason: from kotlin metadata */
            @JvmField
            @Nullable
            public CaptionSource source;

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            /* renamed from: a */
            public CaptionInfo build() {
                return new CaptionInfo(this.source, buildUnknownFields());
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends ProtoAdapter<CaptionInfo> {
            b(FieldEncoding fieldEncoding, KClass<CaptionInfo> kClass) {
                super(fieldEncoding, kClass, "type.googleapis.com/publisher.StickerModel.CaptionInfo");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: a */
            public CaptionInfo decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                CaptionSource captionSource = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag == 1) {
                            try {
                                captionSource = CaptionSource.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        } else {
                            reader.readUnknownField(nextTag);
                        }
                    } else {
                        return new CaptionInfo(captionSource, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b */
            public void encode(@NotNull ProtoWriter writer, @NotNull CaptionInfo value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                CaptionSource.ADAPTER.encodeWithTag(writer, 1, value.source);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c */
            public int encodedSize(@NotNull CaptionInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return CaptionSource.ADAPTER.encodedSizeWithTag(1, value.source) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: d */
            public CaptionInfo redact(@NotNull CaptionInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return CaptionInfo.copy$default(value, null, ByteString.EMPTY, 1, null);
            }
        }

        static {
            b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CaptionInfo.class));
            ADAPTER = bVar;
            CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
        }

        public CaptionInfo() {
            this(null, null, 3, null);
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
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            return new CaptionInfo(source, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
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
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public a newBuilder() {
            a aVar = new a();
            aVar.source = this.source;
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptionInfo(@Nullable CaptionSource captionSource, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            this.source = captionSource;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "VIDEO", "MUSIC", "RECORD", "SEPARATE", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public enum CaptionSource implements WireEnum {
        VIDEO(0),
        MUSIC(1),
        RECORD(2),
        SEPARATE(3);

        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        public static final ProtoAdapter<CaptionSource> ADAPTER = new a(Reflection.getOrCreateKotlinClass(CaptionSource.class));

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource$a", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "", "value", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends EnumAdapter<CaptionSource> {
            a(KClass<CaptionSource> kClass) {
                super(kClass);
            }

            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            /* renamed from: a */
            public CaptionSource fromValue(int value) {
                return CaptionSource.INSTANCE.a(value);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionSource;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$CaptionSource$b, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final CaptionSource a(int value) {
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
            }
        }

        CaptionSource(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final CaptionSource fromValue(int i3) {
            return INSTANCE.a(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "DEFAULT", "TEXT", "TEXT_TEMPLATE", "TOP_FRAME", "BOTTOM_FRAME", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public enum Type implements WireEnum {
        DEFAULT(0),
        TEXT(1),
        TEXT_TEMPLATE(2),
        TOP_FRAME(3),
        BOTTOM_FRAME(4);

        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        public static final ProtoAdapter<Type> ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class));

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type$a", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "", "value", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends EnumAdapter<Type> {
            a(KClass<Type> kClass) {
                super(kClass);
            }

            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            /* renamed from: a */
            public Type fromValue(int value) {
                return Type.INSTANCE.a(value);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel$Type$b, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final Type a(int value) {
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                if (value != 4) {
                                    return null;
                                }
                                return Type.BOTTOM_FRAME;
                            }
                            return Type.TOP_FRAME;
                        }
                        return Type.TEXT_TEMPLATE;
                    }
                    return Type.TEXT;
                }
                return Type.DEFAULT;
            }

            Companion() {
            }
        }

        Type(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final Type fromValue(int i3) {
            return INSTANCE.a(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010 \u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0011R\u0016\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0011R\u0016\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015R\u0016\u0010(\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0015R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0005R\u0016\u00101\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0011R\u0016\u00105\u001a\u0002028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u0005R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u0011R\u0016\u0010C\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u0011R\u0016\u0010E\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u000bR\u0016\u0010I\u001a\u00020F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010,R\u0016\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\u0005R\u0016\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0005\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "a", "", "Ljava/lang/String;", "id", "b", "filePath", "", "c", "J", "startTime", "d", "duration", "", "e", "I", "layerIndex", "", "f", UserInfo.SEX_FEMALE, "scale", "g", CanvasView.ACTION_ROTATE, h.F, "centerX", "i", "centerY", "", "j", "Z", "editable", "k", "width", "l", "height", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "minScale", DomainData.DOMAIN_NAME, "maxScale", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "o", "Ljava/util/List;", "textItems", "p", "thumbUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "timelineTrackIndex", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "r", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "type", "t", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "u", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$CaptionInfo;", "captionInfo", "v", "localThumbId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "editingLayerIndex", "B", "playEndDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$ActionType;", "actionType", "D", "bgConfig", "E", "bgPath", "configType", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<StickerModel, a> {

        /* renamed from: A */
        @JvmField
        public int editingLayerIndex;

        /* renamed from: B, reason: from kotlin metadata */
        @JvmField
        public long playEndDuration;

        /* renamed from: C */
        @JvmField
        @NotNull
        public ActionType actionType;

        /* renamed from: D, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public List<String> bgConfig;

        /* renamed from: E, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String bgPath;

        /* renamed from: F */
        @JvmField
        @NotNull
        public String configType;

        /* renamed from: a, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String id = "";

        /* renamed from: b, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String filePath = "";

        /* renamed from: c, reason: from kotlin metadata */
        @JvmField
        public long startTime;

        /* renamed from: d, reason: from kotlin metadata */
        @JvmField
        public long duration;

        /* renamed from: e, reason: from kotlin metadata */
        @JvmField
        public int layerIndex;

        /* renamed from: f */
        @JvmField
        public float scale;

        /* renamed from: g */
        @JvmField
        public float rotate;

        /* renamed from: h */
        @JvmField
        public float centerX;

        /* renamed from: i */
        @JvmField
        public float centerY;

        /* renamed from: j, reason: from kotlin metadata */
        @JvmField
        public boolean editable;

        /* renamed from: k, reason: from kotlin metadata */
        @JvmField
        public int width;

        /* renamed from: l, reason: from kotlin metadata */
        @JvmField
        public int height;

        /* renamed from: m */
        @JvmField
        public float minScale;

        /* renamed from: n */
        @JvmField
        public float maxScale;

        /* renamed from: o, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public List<TextItem> textItems;

        /* renamed from: p, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String thumbUrl;

        /* renamed from: q */
        @JvmField
        public int timelineTrackIndex;

        /* renamed from: r, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public AnimationMode animationMode;

        /* renamed from: s */
        @JvmField
        @NotNull
        public Type type;

        /* renamed from: t, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String com.tencent.ams.dsdk.core.DKConfiguration.PreloadKeys.KEY_MATERIAL_ID java.lang.String;

        /* renamed from: u, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public CaptionInfo captionInfo;

        /* renamed from: v, reason: from kotlin metadata */
        @JvmField
        public int localThumbId;

        public a() {
            List<TextItem> emptyList;
            List<String> emptyList2;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.textItems = emptyList;
            this.thumbUrl = "";
            this.animationMode = AnimationMode.LOOP;
            this.type = Type.DEFAULT;
            this.com.tencent.ams.dsdk.core.DKConfiguration.PreloadKeys.KEY_MATERIAL_ID java.lang.String = "";
            this.actionType = ActionType.NONE;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.bgConfig = emptyList2;
            this.bgPath = "";
            this.configType = "";
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a */
        public StickerModel build() {
            return new StickerModel(this.id, this.filePath, this.startTime, this.duration, this.layerIndex, this.scale, this.rotate, this.centerX, this.centerY, this.editable, this.width, this.height, this.minScale, this.maxScale, this.textItems, this.thumbUrl, this.timelineTrackIndex, this.animationMode, this.type, this.com.tencent.ams.dsdk.core.DKConfiguration.PreloadKeys.KEY_MATERIAL_ID java.lang.String, this.captionInfo, this.localThumbId, this.editingLayerIndex, this.playEndDuration, this.actionType, this.bgConfig, this.bgPath, this.configType, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<StickerModel> {
        b(FieldEncoding fieldEncoding, KClass<StickerModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.StickerModel");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x005a. Please report as an issue. */
        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a */
        public StickerModel decode(@NotNull ProtoReader reader) {
            long j3;
            Type type;
            ActionType actionType;
            Intrinsics.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            AnimationMode animationMode = AnimationMode.LOOP;
            Type type2 = Type.DEFAULT;
            ActionType actionType2 = ActionType.NONE;
            ArrayList arrayList2 = new ArrayList();
            long beginMessage = reader.beginMessage();
            String str = "";
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            long j16 = 0;
            long j17 = 0;
            int i3 = 0;
            boolean z16 = false;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            float f16 = 0.0f;
            float f17 = 0.0f;
            float f18 = 0.0f;
            float f19 = 0.0f;
            float f26 = 0.0f;
            float f27 = 0.0f;
            CaptionInfo captionInfo = null;
            AnimationMode animationMode2 = animationMode;
            long j18 = 0;
            Type type3 = type2;
            ActionType actionType3 = actionType2;
            String str5 = str4;
            String str6 = str5;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            j3 = j18;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            j18 = j3;
                            break;
                        case 2:
                            j3 = j18;
                            str6 = ProtoAdapter.STRING.decode(reader);
                            j18 = j3;
                            break;
                        case 3:
                            actionType3 = actionType3;
                            j18 = ProtoAdapter.INT64.decode(reader).longValue();
                            type3 = type3;
                            break;
                        case 4:
                            type = type3;
                            j3 = j18;
                            actionType = actionType3;
                            j17 = ProtoAdapter.INT64.decode(reader).longValue();
                            actionType3 = actionType;
                            type3 = type;
                            j18 = j3;
                            break;
                        case 5:
                            j3 = j18;
                            i3 = ProtoAdapter.INT32.decode(reader).intValue();
                            j18 = j3;
                            break;
                        case 6:
                            j3 = j18;
                            f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 7:
                            j3 = j18;
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 8:
                            j3 = j18;
                            f18 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 9:
                            j3 = j18;
                            f19 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 10:
                            j3 = j18;
                            z16 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            j18 = j3;
                            break;
                        case 11:
                            j3 = j18;
                            i16 = ProtoAdapter.INT32.decode(reader).intValue();
                            j18 = j3;
                            break;
                        case 12:
                            j3 = j18;
                            i17 = ProtoAdapter.INT32.decode(reader).intValue();
                            j18 = j3;
                            break;
                        case 13:
                            j3 = j18;
                            f26 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 14:
                            j3 = j18;
                            f27 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            j18 = j3;
                            break;
                        case 15:
                            type = type3;
                            j3 = j18;
                            actionType = actionType3;
                            arrayList.add(TextItem.ADAPTER.decode(reader));
                            actionType3 = actionType;
                            type3 = type;
                            j18 = j3;
                            break;
                        case 16:
                            j3 = j18;
                            str = ProtoAdapter.STRING.decode(reader);
                            j18 = j3;
                            break;
                        case 17:
                            j3 = j18;
                            i18 = ProtoAdapter.INT32.decode(reader).intValue();
                            j18 = j3;
                            break;
                        case 18:
                            type = type3;
                            j3 = j18;
                            actionType = actionType3;
                            try {
                                animationMode2 = AnimationMode.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                            actionType3 = actionType;
                            type3 = type;
                            j18 = j3;
                            break;
                        case 19:
                            j3 = j18;
                            try {
                                type3 = Type.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                type = type3;
                                actionType = actionType3;
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                break;
                            }
                            j18 = j3;
                            break;
                        case 20:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 21:
                            captionInfo = CaptionInfo.ADAPTER.decode(reader);
                            break;
                        case 22:
                            i19 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 23:
                            i26 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 24:
                            j16 = ProtoAdapter.INT64.decode(reader).longValue();
                            break;
                        case 25:
                            try {
                                actionType3 = ActionType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e18) {
                                j3 = j18;
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e18.value));
                                type = type3;
                                break;
                            }
                        case 26:
                            arrayList2.add(ProtoAdapter.STRING.decode(reader));
                            type = type3;
                            j3 = j18;
                            actionType = actionType3;
                            actionType3 = actionType;
                            type3 = type;
                            j18 = j3;
                            break;
                        case 27:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 28:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            type = type3;
                            j3 = j18;
                            actionType = actionType3;
                            reader.readUnknownField(nextTag);
                            actionType3 = actionType;
                            type3 = type;
                            j18 = j3;
                            break;
                    }
                } else {
                    return new StickerModel(str5, str6, j18, j17, i3, f16, f17, f18, f19, z16, i16, i17, f26, f27, arrayList, str, i18, animationMode2, type3, str2, captionInfo, i19, i26, j16, actionType3, arrayList2, str3, str4, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(@NotNull ProtoWriter writer, @NotNull StickerModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.filePath);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            protoAdapter2.encodeWithTag(writer, 3, Long.valueOf(value.startTime));
            protoAdapter2.encodeWithTag(writer, 4, Long.valueOf(value.duration));
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
            protoAdapter3.encodeWithTag(writer, 5, Integer.valueOf(value.layerIndex));
            ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
            protoAdapter4.encodeWithTag(writer, 6, Float.valueOf(value.scale));
            protoAdapter4.encodeWithTag(writer, 7, Float.valueOf(value.rotate));
            protoAdapter4.encodeWithTag(writer, 8, Float.valueOf(value.centerX));
            protoAdapter4.encodeWithTag(writer, 9, Float.valueOf(value.centerY));
            ProtoAdapter.BOOL.encodeWithTag(writer, 10, Boolean.valueOf(value.editable));
            protoAdapter3.encodeWithTag(writer, 11, Integer.valueOf(value.width));
            protoAdapter3.encodeWithTag(writer, 12, Integer.valueOf(value.height));
            protoAdapter4.encodeWithTag(writer, 13, Float.valueOf(value.minScale));
            protoAdapter4.encodeWithTag(writer, 14, Float.valueOf(value.maxScale));
            TextItem.ADAPTER.asRepeated().encodeWithTag(writer, 15, value.textItems);
            protoAdapter.encodeWithTag(writer, 16, value.thumbUrl);
            protoAdapter3.encodeWithTag(writer, 17, Integer.valueOf(value.timelineTrackIndex));
            AnimationMode.ADAPTER.encodeWithTag(writer, 18, value.animationMode);
            Type.ADAPTER.encodeWithTag(writer, 19, value.type);
            protoAdapter.encodeWithTag(writer, 20, value.materialId);
            CaptionInfo.ADAPTER.encodeWithTag(writer, 21, value.captionInfo);
            protoAdapter3.encodeWithTag(writer, 22, Integer.valueOf(value.localThumbId));
            protoAdapter3.encodeWithTag(writer, 23, Integer.valueOf(value.editingLayerIndex));
            protoAdapter2.encodeWithTag(writer, 24, Long.valueOf(value.playEndDuration));
            ActionType.ADAPTER.encodeWithTag(writer, 25, value.actionType);
            protoAdapter.asRepeated().encodeWithTag(writer, 26, value.bgConfig);
            protoAdapter.encodeWithTag(writer, 27, value.bgPath);
            protoAdapter.encodeWithTag(writer, 28, value.configType);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(@NotNull StickerModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.filePath);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, Long.valueOf(value.startTime)) + protoAdapter2.encodedSizeWithTag(4, Long.valueOf(value.duration));
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter3.encodedSizeWithTag(5, Integer.valueOf(value.layerIndex));
            ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
            return encodedSizeWithTag3 + protoAdapter4.encodedSizeWithTag(6, Float.valueOf(value.scale)) + protoAdapter4.encodedSizeWithTag(7, Float.valueOf(value.rotate)) + protoAdapter4.encodedSizeWithTag(8, Float.valueOf(value.centerX)) + protoAdapter4.encodedSizeWithTag(9, Float.valueOf(value.centerY)) + ProtoAdapter.BOOL.encodedSizeWithTag(10, Boolean.valueOf(value.editable)) + protoAdapter3.encodedSizeWithTag(11, Integer.valueOf(value.width)) + protoAdapter3.encodedSizeWithTag(12, Integer.valueOf(value.height)) + protoAdapter4.encodedSizeWithTag(13, Float.valueOf(value.minScale)) + protoAdapter4.encodedSizeWithTag(14, Float.valueOf(value.maxScale)) + TextItem.ADAPTER.asRepeated().encodedSizeWithTag(15, value.textItems) + protoAdapter.encodedSizeWithTag(16, value.thumbUrl) + protoAdapter3.encodedSizeWithTag(17, Integer.valueOf(value.timelineTrackIndex)) + AnimationMode.ADAPTER.encodedSizeWithTag(18, value.animationMode) + Type.ADAPTER.encodedSizeWithTag(19, value.type) + protoAdapter.encodedSizeWithTag(20, value.materialId) + CaptionInfo.ADAPTER.encodedSizeWithTag(21, value.captionInfo) + protoAdapter3.encodedSizeWithTag(22, Integer.valueOf(value.localThumbId)) + protoAdapter3.encodedSizeWithTag(23, Integer.valueOf(value.editingLayerIndex)) + protoAdapter2.encodedSizeWithTag(24, Long.valueOf(value.playEndDuration)) + ActionType.ADAPTER.encodedSizeWithTag(25, value.actionType) + protoAdapter.asRepeated().encodedSizeWithTag(26, value.bgConfig) + protoAdapter.encodedSizeWithTag(27, value.bgPath) + protoAdapter.encodedSizeWithTag(28, value.configType) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d */
        public StickerModel redact(@NotNull StickerModel value) {
            CaptionInfo captionInfo;
            Intrinsics.checkNotNullParameter(value, "value");
            List m87redactElements = Internal.m87redactElements(value.textItems, TextItem.ADAPTER);
            CaptionInfo captionInfo2 = value.captionInfo;
            if (captionInfo2 != null) {
                captionInfo = CaptionInfo.ADAPTER.redact(captionInfo2);
            } else {
                captionInfo = null;
            }
            return StickerModel.copy$default(value, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, m87redactElements, null, 0, null, null, null, captionInfo, 0, 0, 0L, null, null, null, null, ByteString.EMPTY, 267370495, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StickerModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public StickerModel() {
        this(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, null);
    }

    public static /* synthetic */ StickerModel copy$default(StickerModel stickerModel, String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, List list, String str3, int i18, AnimationMode animationMode, Type type, String str4, CaptionInfo captionInfo, int i19, int i26, long j17, ActionType actionType, List list2, String str5, String str6, ByteString byteString, int i27, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        return stickerModel.copy((i27 & 1) != 0 ? stickerModel.id : str, (i27 & 2) != 0 ? stickerModel.filePath : str2, (i27 & 4) != 0 ? stickerModel.startTime : j3, (i27 & 8) != 0 ? stickerModel.duration : j16, (i27 & 16) != 0 ? stickerModel.layerIndex : i3, (i27 & 32) != 0 ? stickerModel.scale : f16, (i27 & 64) != 0 ? stickerModel.rotate : f17, (i27 & 128) != 0 ? stickerModel.centerX : f18, (i27 & 256) != 0 ? stickerModel.centerY : f19, (i27 & 512) != 0 ? stickerModel.editable : z16, (i27 & 1024) != 0 ? stickerModel.width : i16, (i27 & 2048) != 0 ? stickerModel.height : i17, (i27 & 4096) != 0 ? stickerModel.minScale : f26, (i27 & 8192) != 0 ? stickerModel.maxScale : f27, (i27 & 16384) != 0 ? stickerModel.textItems : list, (i27 & 32768) != 0 ? stickerModel.thumbUrl : str3, (i27 & 65536) != 0 ? stickerModel.timelineTrackIndex : i18, (i27 & 131072) != 0 ? stickerModel.animationMode : animationMode, (i27 & 262144) != 0 ? stickerModel.type : type, (i27 & 524288) != 0 ? stickerModel.materialId : str4, (i27 & 1048576) != 0 ? stickerModel.captionInfo : captionInfo, (i27 & 2097152) != 0 ? stickerModel.localThumbId : i19, (i27 & 4194304) != 0 ? stickerModel.editingLayerIndex : i26, (i27 & 8388608) != 0 ? stickerModel.playEndDuration : j17, (i27 & 16777216) != 0 ? stickerModel.actionType : actionType, (33554432 & i27) != 0 ? stickerModel.bgConfig : list2, (i27 & 67108864) != 0 ? stickerModel.bgPath : str5, (i27 & 134217728) != 0 ? stickerModel.configType : str6, (i27 & 268435456) != 0 ? stickerModel.unknownFields() : byteString);
    }

    @NotNull
    public final StickerModel copy(@NotNull String id5, @NotNull String filePath, long startTime, long duration, int layerIndex, float scale, float r442, float centerX, float centerY, boolean editable, int width, int height, float minScale, float maxScale, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int timelineTrackIndex, @NotNull AnimationMode animationMode, @NotNull Type type, @NotNull String r57, @Nullable CaptionInfo captionInfo, int localThumbId, int editingLayerIndex, long playEndDuration, @NotNull ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(textItems, "textItems");
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(animationMode, "animationMode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(r57, "materialId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(bgConfig, "bgConfig");
        Intrinsics.checkNotNullParameter(bgPath, "bgPath");
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new StickerModel(id5, filePath, startTime, duration, layerIndex, scale, r442, centerX, centerY, editable, width, height, minScale, maxScale, textItems, thumbUrl, timelineTrackIndex, animationMode, type, r57, captionInfo, localThumbId, editingLayerIndex, playEndDuration, actionType, bgConfig, bgPath, configType, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (other == this) {
            return true;
        }
        if (!(other instanceof StickerModel)) {
            return false;
        }
        StickerModel stickerModel = (StickerModel) other;
        if (Intrinsics.areEqual(unknownFields(), stickerModel.unknownFields()) && Intrinsics.areEqual(this.id, stickerModel.id) && Intrinsics.areEqual(this.filePath, stickerModel.filePath) && this.startTime == stickerModel.startTime && this.duration == stickerModel.duration && this.layerIndex == stickerModel.layerIndex) {
            if (this.scale == stickerModel.scale) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.rotate == stickerModel.rotate) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.centerX == stickerModel.centerX) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (this.centerY == stickerModel.centerY) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19 && this.editable == stickerModel.editable && this.width == stickerModel.width && this.height == stickerModel.height) {
                            if (this.minScale == stickerModel.minScale) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                if (this.maxScale == stickerModel.maxScale) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (z27 && Intrinsics.areEqual(this.textItems, stickerModel.textItems) && Intrinsics.areEqual(this.thumbUrl, stickerModel.thumbUrl) && this.timelineTrackIndex == stickerModel.timelineTrackIndex && this.animationMode == stickerModel.animationMode && this.type == stickerModel.type && Intrinsics.areEqual(this.materialId, stickerModel.materialId) && Intrinsics.areEqual(this.captionInfo, stickerModel.captionInfo) && this.localThumbId == stickerModel.localThumbId && this.editingLayerIndex == stickerModel.editingLayerIndex && this.playEndDuration == stickerModel.playEndDuration && this.actionType == stickerModel.actionType && Intrinsics.areEqual(this.bgConfig, stickerModel.bgConfig) && Intrinsics.areEqual(this.bgPath, stickerModel.bgPath) && Intrinsics.areEqual(this.configType, stickerModel.configType)) {
                                    return true;
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
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((((((((((((((((((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.filePath.hashCode()) * 37) + androidx.fragment.app.a.a(this.startTime)) * 37) + androidx.fragment.app.a.a(this.duration)) * 37) + this.layerIndex) * 37) + Float.floatToIntBits(this.scale)) * 37) + Float.floatToIntBits(this.rotate)) * 37) + Float.floatToIntBits(this.centerX)) * 37) + Float.floatToIntBits(this.centerY)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.editable)) * 37) + this.width) * 37) + this.height) * 37) + Float.floatToIntBits(this.minScale)) * 37) + Float.floatToIntBits(this.maxScale)) * 37) + this.textItems.hashCode()) * 37) + this.thumbUrl.hashCode()) * 37) + this.timelineTrackIndex) * 37) + this.animationMode.hashCode()) * 37) + this.type.hashCode()) * 37) + this.materialId.hashCode()) * 37;
            CaptionInfo captionInfo = this.captionInfo;
            if (captionInfo != null) {
                i3 = captionInfo.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((((((((((((((hashCode + i3) * 37) + this.localThumbId) * 37) + this.editingLayerIndex) * 37) + androidx.fragment.app.a.a(this.playEndDuration)) * 37) + this.actionType.hashCode()) * 37) + this.bgConfig.hashCode()) * 37) + this.bgPath.hashCode()) * 37) + this.configType.hashCode();
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
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
        arrayList.add("scale=" + this.scale);
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
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "StickerModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ StickerModel(String str, String str2, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, List list, String str3, int i18, AnimationMode animationMode, Type type, String str4, CaptionInfo captionInfo, int i19, int i26, long j17, ActionType actionType, List list2, String str5, String str6, ByteString byteString, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? "" : str, (i27 & 2) != 0 ? "" : str2, (i27 & 4) != 0 ? 0L : j3, (i27 & 8) != 0 ? 0L : j16, (i27 & 16) != 0 ? 0 : i3, (i27 & 32) != 0 ? 0.0f : f16, (i27 & 64) != 0 ? 0.0f : f17, (i27 & 128) != 0 ? 0.0f : f18, (i27 & 256) != 0 ? 0.0f : f19, (i27 & 512) != 0 ? false : z16, (i27 & 1024) != 0 ? 0 : i16, (i27 & 2048) != 0 ? 0 : i17, (i27 & 4096) != 0 ? 0.0f : f26, (i27 & 8192) != 0 ? 0.0f : f27, (i27 & 16384) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i27 & 32768) != 0 ? "" : str3, (i27 & 65536) != 0 ? 0 : i18, (i27 & 131072) != 0 ? AnimationMode.LOOP : animationMode, (i27 & 262144) != 0 ? Type.DEFAULT : type, (i27 & 524288) != 0 ? "" : str4, (i27 & 1048576) != 0 ? null : captionInfo, (i27 & 2097152) != 0 ? 0 : i19, (i27 & 4194304) != 0 ? 0 : i26, (i27 & 8388608) != 0 ? 0L : j17, (i27 & 16777216) != 0 ? ActionType.NONE : actionType, (i27 & 33554432) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i27 & 67108864) != 0 ? "" : str5, (i27 & 134217728) != 0 ? "" : str6, (i27 & 268435456) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.filePath = this.filePath;
        aVar.startTime = this.startTime;
        aVar.duration = this.duration;
        aVar.layerIndex = this.layerIndex;
        aVar.scale = this.scale;
        aVar.rotate = this.rotate;
        aVar.centerX = this.centerX;
        aVar.centerY = this.centerY;
        aVar.editable = this.editable;
        aVar.width = this.width;
        aVar.height = this.height;
        aVar.minScale = this.minScale;
        aVar.maxScale = this.maxScale;
        aVar.textItems = this.textItems;
        aVar.thumbUrl = this.thumbUrl;
        aVar.timelineTrackIndex = this.timelineTrackIndex;
        aVar.animationMode = this.animationMode;
        aVar.type = this.type;
        aVar.com.tencent.ams.dsdk.core.DKConfiguration.PreloadKeys.KEY_MATERIAL_ID java.lang.String = this.materialId;
        aVar.captionInfo = this.captionInfo;
        aVar.localThumbId = this.localThumbId;
        aVar.editingLayerIndex = this.editingLayerIndex;
        aVar.playEndDuration = this.playEndDuration;
        aVar.actionType = this.actionType;
        aVar.bgConfig = this.bgConfig;
        aVar.bgPath = this.bgPath;
        aVar.configType = this.configType;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerModel(@NotNull String id5, @NotNull String filePath, long j3, long j16, int i3, float f16, float f17, float f18, float f19, boolean z16, int i16, int i17, float f26, float f27, @NotNull List<TextItem> textItems, @NotNull String thumbUrl, int i18, @NotNull AnimationMode animationMode, @NotNull Type type, @NotNull String materialId, @Nullable CaptionInfo captionInfo, int i19, int i26, long j17, @NotNull ActionType actionType, @NotNull List<String> bgConfig, @NotNull String bgPath, @NotNull String configType, @NotNull ByteString unknownFields) {
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
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = id5;
        this.filePath = filePath;
        this.startTime = j3;
        this.duration = j16;
        this.layerIndex = i3;
        this.scale = f16;
        this.rotate = f17;
        this.centerX = f18;
        this.centerY = f19;
        this.editable = z16;
        this.width = i16;
        this.height = i17;
        this.minScale = f26;
        this.maxScale = f27;
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
    }
}
