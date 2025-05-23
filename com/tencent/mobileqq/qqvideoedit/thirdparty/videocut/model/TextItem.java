package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u00df\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00fb\u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010%R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010%R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010'R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010)R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)R\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010'R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'R\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010*R\u0014\u0010 \u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "text", "textColor", "fontPath", "strokeColor", "", "strokeWidth", NodeProps.SHADOW_COLOR, NodeProps.SHADOW_OPACITY, "opacity", "index", "fauxBold", "fauxItalic", "fontFamily", "applyStroke", "leading", "tracking", "backgroundColor", "backgroundAlpha", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "layerSize", "fontStyle", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "Ljava/lang/Float;", "I", "Ljava/lang/Boolean;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TextItem extends AndroidMessage<TextItem, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TextItem> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TextItem> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    @JvmField
    @Nullable
    public final Boolean applyStroke;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    @JvmField
    public final int backgroundAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    @JvmField
    @NotNull
    public final String backgroundColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    @JvmField
    @Nullable
    public final Boolean fauxBold;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    @JvmField
    @Nullable
    public final Boolean fauxItalic;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @JvmField
    @NotNull
    public final String fontFamily;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @NotNull
    public final String fontPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    @JvmField
    @NotNull
    public final String fontStyle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    public final int index;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size#ADAPTER", tag = 18)
    @JvmField
    @Nullable
    public final Size layerSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    @JvmField
    @Nullable
    public final Float leading;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    @Nullable
    public final Float opacity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @NotNull
    public final String shadowColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    @Nullable
    public final Float shadowOpacity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @NotNull
    public final String strokeColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    public final float strokeWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String textColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 15)
    @JvmField
    @Nullable
    public final Float tracking;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0005R\u0018\u0010%\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0018\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0014R\u0018\u0010)\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0014R\u0016\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0005R\u0016\u0010-\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0018\u00101\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0005\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "a", "", "Ljava/lang/String;", "text", "b", "textColor", "c", "fontPath", "d", "strokeColor", "", "e", UserInfo.SEX_FEMALE, "strokeWidth", "f", NodeProps.SHADOW_COLOR, "g", "Ljava/lang/Float;", NodeProps.SHADOW_OPACITY, h.F, "opacity", "", "i", "I", "index", "", "j", "Ljava/lang/Boolean;", "fauxBold", "k", "fauxItalic", "l", "fontFamily", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "applyStroke", DomainData.DOMAIN_NAME, "leading", "o", "tracking", "p", "backgroundColor", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "backgroundAlpha", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "r", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "layerSize", ReportConstant.COSTREPORT_PREFIX, "fontStyle", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<TextItem, a> {

        /* renamed from: e */
        @JvmField
        public float strokeWidth;

        /* renamed from: g, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Float com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_OPACITY java.lang.String;

        /* renamed from: h */
        @JvmField
        @Nullable
        public Float opacity;

        /* renamed from: i, reason: from kotlin metadata */
        @JvmField
        public int index;

        /* renamed from: j, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Boolean fauxBold;

        /* renamed from: k, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Boolean fauxItalic;

        /* renamed from: m */
        @JvmField
        @Nullable
        public Boolean applyStroke;

        /* renamed from: n */
        @JvmField
        @Nullable
        public Float leading;

        /* renamed from: o, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Float tracking;

        /* renamed from: q */
        @JvmField
        public int backgroundAlpha;

        /* renamed from: r, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Size layerSize;

        /* renamed from: a, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String text = "";

        /* renamed from: b, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String textColor = "";

        /* renamed from: c, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String fontPath = "";

        /* renamed from: d, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String strokeColor = "";

        /* renamed from: f, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String = "";

        /* renamed from: l, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String fontFamily = "";

        /* renamed from: p, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String backgroundColor = "";

        /* renamed from: s */
        @JvmField
        @NotNull
        public String fontStyle = "";

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a */
        public TextItem build() {
            return new TextItem(this.text, this.textColor, this.fontPath, this.strokeColor, this.strokeWidth, this.com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String, this.com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_OPACITY java.lang.String, this.opacity, this.index, this.fauxBold, this.fauxItalic, this.fontFamily, this.applyStroke, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, this.layerSize, this.fontStyle, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<TextItem> {
        b(FieldEncoding fieldEncoding, KClass<TextItem> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.TextItem");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a */
        public TextItem decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str = "";
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            float f16 = 0.0f;
            Float f17 = null;
            Float f18 = null;
            Boolean bool = null;
            Boolean bool2 = null;
            Boolean bool3 = null;
            Float f19 = null;
            Float f26 = null;
            Size size = null;
            int i3 = 0;
            int i16 = 0;
            String str6 = str5;
            String str7 = str6;
            String str8 = str7;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            break;
                        case 6:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 8:
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 9:
                            i3 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 10:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 11:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 12:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 14:
                            f19 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 15:
                            f26 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 16:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 17:
                            i16 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 18:
                            size = Size.ADAPTER.decode(reader);
                            break;
                        case 19:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    return new TextItem(str, str6, str7, str8, f16, str2, f17, f18, i3, bool, bool2, str3, bool3, f19, f26, str4, i16, size, str5, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(@NotNull ProtoWriter writer, @NotNull TextItem value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.text);
            protoAdapter.encodeWithTag(writer, 2, value.textColor);
            protoAdapter.encodeWithTag(writer, 3, value.fontPath);
            protoAdapter.encodeWithTag(writer, 4, value.strokeColor);
            ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
            protoAdapter2.encodeWithTag(writer, 5, Float.valueOf(value.strokeWidth));
            protoAdapter.encodeWithTag(writer, 6, value.shadowColor);
            protoAdapter2.encodeWithTag(writer, 7, value.shadowOpacity);
            protoAdapter2.encodeWithTag(writer, 8, value.opacity);
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
            protoAdapter3.encodeWithTag(writer, 9, Integer.valueOf(value.index));
            ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
            protoAdapter4.encodeWithTag(writer, 10, value.fauxBold);
            protoAdapter4.encodeWithTag(writer, 11, value.fauxItalic);
            protoAdapter.encodeWithTag(writer, 12, value.fontFamily);
            protoAdapter4.encodeWithTag(writer, 13, value.applyStroke);
            protoAdapter2.encodeWithTag(writer, 14, value.leading);
            protoAdapter2.encodeWithTag(writer, 15, value.tracking);
            protoAdapter.encodeWithTag(writer, 16, value.backgroundColor);
            protoAdapter3.encodeWithTag(writer, 17, Integer.valueOf(value.backgroundAlpha));
            Size.ADAPTER.encodeWithTag(writer, 18, value.layerSize);
            protoAdapter.encodeWithTag(writer, 19, value.fontStyle);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(@NotNull TextItem value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.text) + protoAdapter.encodedSizeWithTag(2, value.textColor) + protoAdapter.encodedSizeWithTag(3, value.fontPath) + protoAdapter.encodedSizeWithTag(4, value.strokeColor);
            ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(5, Float.valueOf(value.strokeWidth)) + protoAdapter.encodedSizeWithTag(6, value.shadowColor) + protoAdapter2.encodedSizeWithTag(7, value.shadowOpacity) + protoAdapter2.encodedSizeWithTag(8, value.opacity);
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter3.encodedSizeWithTag(9, Integer.valueOf(value.index));
            ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
            return encodedSizeWithTag3 + protoAdapter4.encodedSizeWithTag(10, value.fauxBold) + protoAdapter4.encodedSizeWithTag(11, value.fauxItalic) + protoAdapter.encodedSizeWithTag(12, value.fontFamily) + protoAdapter4.encodedSizeWithTag(13, value.applyStroke) + protoAdapter2.encodedSizeWithTag(14, value.leading) + protoAdapter2.encodedSizeWithTag(15, value.tracking) + protoAdapter.encodedSizeWithTag(16, value.backgroundColor) + protoAdapter3.encodedSizeWithTag(17, Integer.valueOf(value.backgroundAlpha)) + Size.ADAPTER.encodedSizeWithTag(18, value.layerSize) + protoAdapter.encodedSizeWithTag(19, value.fontStyle) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d */
        public TextItem redact(@NotNull TextItem value) {
            Size size;
            Intrinsics.checkNotNullParameter(value, "value");
            Size size2 = value.layerSize;
            if (size2 != null) {
                size = Size.ADAPTER.redact(size2);
            } else {
                size = null;
            }
            return TextItem.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, size, null, ByteString.EMPTY, 393215, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextItem.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public TextItem() {
        this(null, null, null, null, 0.0f, null, null, null, 0, null, null, null, null, null, null, null, 0, null, null, null, 1048575, null);
    }

    public static /* synthetic */ TextItem copy$default(TextItem textItem, String str, String str2, String str3, String str4, Float f16, String str5, Float f17, Float f18, Integer num, Boolean bool, Boolean bool2, String str6, Boolean bool3, Float f19, Float f26, String str7, Integer num2, Size size, String str8, ByteString byteString, int i3, Object obj) {
        return textItem.copy((i3 & 1) != 0 ? textItem.text : str, (i3 & 2) != 0 ? textItem.textColor : str2, (i3 & 4) != 0 ? textItem.fontPath : str3, (i3 & 8) != 0 ? textItem.strokeColor : str4, (i3 & 16) != 0 ? Float.valueOf(textItem.strokeWidth) : f16, (i3 & 32) != 0 ? textItem.shadowColor : str5, (i3 & 64) != 0 ? textItem.shadowOpacity : f17, (i3 & 128) != 0 ? textItem.opacity : f18, (i3 & 256) != 0 ? Integer.valueOf(textItem.index) : num, (i3 & 512) != 0 ? textItem.fauxBold : bool, (i3 & 1024) != 0 ? textItem.fauxItalic : bool2, (i3 & 2048) != 0 ? textItem.fontFamily : str6, (i3 & 4096) != 0 ? textItem.applyStroke : bool3, (i3 & 8192) != 0 ? textItem.leading : f19, (i3 & 16384) != 0 ? textItem.tracking : f26, (i3 & 32768) != 0 ? textItem.backgroundColor : str7, (i3 & 65536) != 0 ? Integer.valueOf(textItem.backgroundAlpha) : num2, (i3 & 131072) != 0 ? textItem.layerSize : size, (i3 & 262144) != 0 ? textItem.fontStyle : str8, (i3 & 524288) != 0 ? textItem.unknownFields() : byteString);
    }

    @NotNull
    public final TextItem copy(@Nullable String text, @Nullable String textColor, @Nullable String fontPath, @Nullable String strokeColor, @Nullable Float strokeWidth, @Nullable String r28, @Nullable Float r29, @Nullable Float opacity, @Nullable Integer index, @Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable String fontFamily, @Nullable Boolean applyStroke, @Nullable Float leading, @Nullable Float tracking, @Nullable String backgroundColor, @Nullable Integer backgroundAlpha, @Nullable Size layerSize, @Nullable String fontStyle, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new TextItem(text == null ? "" : text, textColor == null ? "" : textColor, fontPath == null ? "" : fontPath, strokeColor == null ? "" : strokeColor, strokeWidth != null ? strokeWidth.floatValue() : 0.0f, r28 == null ? "" : r28, r29, opacity, index != null ? index.intValue() : 0, fauxBold, fauxItalic, fontFamily == null ? "" : fontFamily, applyStroke, leading, tracking, backgroundColor == null ? "" : backgroundColor, backgroundAlpha != null ? backgroundAlpha.intValue() : 0, layerSize, fontStyle == null ? "" : fontStyle, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (other == this) {
            return true;
        }
        if (!(other instanceof TextItem)) {
            return false;
        }
        TextItem textItem = (TextItem) other;
        if (Intrinsics.areEqual(unknownFields(), textItem.unknownFields()) && Intrinsics.areEqual(this.text, textItem.text) && Intrinsics.areEqual(this.textColor, textItem.textColor) && Intrinsics.areEqual(this.fontPath, textItem.fontPath) && Intrinsics.areEqual(this.strokeColor, textItem.strokeColor)) {
            if (this.strokeWidth == textItem.strokeWidth) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(this.shadowColor, textItem.shadowColor) && Intrinsics.areEqual(this.shadowOpacity, textItem.shadowOpacity) && Intrinsics.areEqual(this.opacity, textItem.opacity) && this.index == textItem.index && Intrinsics.areEqual(this.fauxBold, textItem.fauxBold) && Intrinsics.areEqual(this.fauxItalic, textItem.fauxItalic) && Intrinsics.areEqual(this.fontFamily, textItem.fontFamily) && Intrinsics.areEqual(this.applyStroke, textItem.applyStroke) && Intrinsics.areEqual(this.leading, textItem.leading) && Intrinsics.areEqual(this.tracking, textItem.tracking) && Intrinsics.areEqual(this.backgroundColor, textItem.backgroundColor) && this.backgroundAlpha == textItem.backgroundAlpha && Intrinsics.areEqual(this.layerSize, textItem.layerSize) && Intrinsics.areEqual(this.fontStyle, textItem.fontStyle)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28 = this.hashCode;
        if (i28 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + this.text.hashCode()) * 37) + this.textColor.hashCode()) * 37) + this.fontPath.hashCode()) * 37) + this.strokeColor.hashCode()) * 37) + Float.floatToIntBits(this.strokeWidth)) * 37) + this.shadowColor.hashCode()) * 37;
            Float f16 = this.shadowOpacity;
            int i29 = 0;
            if (f16 != null) {
                i3 = f16.hashCode();
            } else {
                i3 = 0;
            }
            int i36 = (hashCode + i3) * 37;
            Float f17 = this.opacity;
            if (f17 != null) {
                i16 = f17.hashCode();
            } else {
                i16 = 0;
            }
            int i37 = (((i36 + i16) * 37) + this.index) * 37;
            Boolean bool = this.fauxBold;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i38 = (i37 + i17) * 37;
            Boolean bool2 = this.fauxItalic;
            if (bool2 != null) {
                i18 = bool2.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i38 + i18) * 37) + this.fontFamily.hashCode()) * 37;
            Boolean bool3 = this.applyStroke;
            if (bool3 != null) {
                i19 = bool3.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (hashCode2 + i19) * 37;
            Float f18 = this.leading;
            if (f18 != null) {
                i26 = f18.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            Float f19 = this.tracking;
            if (f19 != null) {
                i27 = f19.hashCode();
            } else {
                i27 = 0;
            }
            int hashCode3 = (((((i46 + i27) * 37) + this.backgroundColor.hashCode()) * 37) + this.backgroundAlpha) * 37;
            Size size = this.layerSize;
            if (size != null) {
                i29 = size.hashCode();
            }
            int hashCode4 = ((hashCode3 + i29) * 37) + this.fontStyle.hashCode();
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i28;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = this.text;
        if (str != null) {
            arrayList.add("text=" + Internal.sanitize(str));
        }
        String str2 = this.textColor;
        if (str2 != null) {
            arrayList.add("textColor=" + Internal.sanitize(str2));
        }
        String str3 = this.fontPath;
        if (str3 != null) {
            arrayList.add("fontPath=" + Internal.sanitize(str3));
        }
        String str4 = this.strokeColor;
        if (str4 != null) {
            arrayList.add("strokeColor=" + Internal.sanitize(str4));
        }
        arrayList.add("strokeWidth=" + this.strokeWidth);
        String str5 = this.shadowColor;
        if (str5 != null) {
            arrayList.add("shadowColor=" + Internal.sanitize(str5));
        }
        Float f16 = this.shadowOpacity;
        if (f16 != null) {
            arrayList.add("shadowOpacity=" + f16);
        }
        Float f17 = this.opacity;
        if (f17 != null) {
            arrayList.add("opacity=" + f17);
        }
        arrayList.add("index=" + this.index);
        Boolean bool = this.fauxBold;
        if (bool != null) {
            arrayList.add("fauxBold=" + bool);
        }
        Boolean bool2 = this.fauxItalic;
        if (bool2 != null) {
            arrayList.add("fauxItalic=" + bool2);
        }
        String str6 = this.fontFamily;
        if (str6 != null) {
            arrayList.add("fontFamily=" + Internal.sanitize(str6));
        }
        Boolean bool3 = this.applyStroke;
        if (bool3 != null) {
            arrayList.add("applyStroke=" + bool3);
        }
        Float f18 = this.leading;
        if (f18 != null) {
            arrayList.add("leading=" + f18);
        }
        Float f19 = this.tracking;
        if (f19 != null) {
            arrayList.add("tracking=" + f19);
        }
        String str7 = this.backgroundColor;
        if (str7 != null) {
            arrayList.add("backgroundColor=" + Internal.sanitize(str7));
        }
        arrayList.add("backgroundAlpha=" + this.backgroundAlpha);
        Size size = this.layerSize;
        if (size != null) {
            arrayList.add("layerSize=" + size);
        }
        String str8 = this.fontStyle;
        if (str8 != null) {
            arrayList.add("fontStyle=" + Internal.sanitize(str8));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TextItem{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TextItem(String str, String str2, String str3, String str4, float f16, String str5, Float f17, Float f18, int i3, Boolean bool, Boolean bool2, String str6, Boolean bool3, Float f19, Float f26, String str7, int i16, Size size, String str8, ByteString byteString, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) != 0 ? 0.0f : f16, (i17 & 32) != 0 ? "" : str5, (i17 & 64) != 0 ? null : f17, (i17 & 128) != 0 ? null : f18, (i17 & 256) != 0 ? 0 : i3, (i17 & 512) != 0 ? null : bool, (i17 & 1024) != 0 ? null : bool2, (i17 & 2048) != 0 ? "" : str6, (i17 & 4096) != 0 ? null : bool3, (i17 & 8192) != 0 ? null : f19, (i17 & 16384) != 0 ? null : f26, (i17 & 32768) != 0 ? "" : str7, (i17 & 65536) != 0 ? 0 : i16, (i17 & 131072) != 0 ? null : size, (i17 & 262144) != 0 ? "" : str8, (i17 & 524288) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.text = this.text;
        aVar.textColor = this.textColor;
        aVar.fontPath = this.fontPath;
        aVar.strokeColor = this.strokeColor;
        aVar.strokeWidth = this.strokeWidth;
        aVar.com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String = this.shadowColor;
        aVar.com.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_OPACITY java.lang.String = this.shadowOpacity;
        aVar.opacity = this.opacity;
        aVar.index = this.index;
        aVar.fauxBold = this.fauxBold;
        aVar.fauxItalic = this.fauxItalic;
        aVar.fontFamily = this.fontFamily;
        aVar.applyStroke = this.applyStroke;
        aVar.leading = this.leading;
        aVar.tracking = this.tracking;
        aVar.backgroundColor = this.backgroundColor;
        aVar.backgroundAlpha = this.backgroundAlpha;
        aVar.layerSize = this.layerSize;
        aVar.fontStyle = this.fontStyle;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextItem(@NotNull String text, @NotNull String textColor, @NotNull String fontPath, @NotNull String strokeColor, float f16, @NotNull String shadowColor, @Nullable Float f17, @Nullable Float f18, int i3, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull String fontFamily, @Nullable Boolean bool3, @Nullable Float f19, @Nullable Float f26, @NotNull String backgroundColor, int i16, @Nullable Size size, @NotNull String fontStyle, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(fontPath, "fontPath");
        Intrinsics.checkNotNullParameter(strokeColor, "strokeColor");
        Intrinsics.checkNotNullParameter(shadowColor, "shadowColor");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.text = text;
        this.textColor = textColor;
        this.fontPath = fontPath;
        this.strokeColor = strokeColor;
        this.strokeWidth = f16;
        this.shadowColor = shadowColor;
        this.shadowOpacity = f17;
        this.opacity = f18;
        this.index = i3;
        this.fauxBold = bool;
        this.fauxItalic = bool2;
        this.fontFamily = fontFamily;
        this.applyStroke = bool3;
        this.leading = f19;
        this.tracking = f26;
        this.backgroundColor = backgroundColor;
        this.backgroundAlpha = i16;
        this.layerSize = size;
        this.fontStyle = fontStyle;
    }
}
