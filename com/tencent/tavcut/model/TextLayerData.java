package com.tencent.tavcut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B\u00b3\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\"\u00a2\u0006\u0002\u0010#J\u00b9\u0002\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020\"\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/tavcut/model/TextLayerData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/TextLayerData$Builder;", "layerIndex", "", "layerName", "", "layerType", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "textColor", "fontFamily", "fontStyle", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "applyFill", "", "applyStroke", "baselineShift", "", "boxText", "firstBaseLine", "fauxBold", "fauxItalic", "fontSize", "strokeColor", "strokeOverFill", "stokeWidth", "justification", "leading", "tracking", "backgroundColor", "backgroundAlpha", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/model/TextLayerData;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TextLayerData extends AndroidMessage<TextLayerData, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TextLayerData> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TextLayerData> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    @JvmField
    @Nullable
    public final Boolean applyFill;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    @JvmField
    @Nullable
    public final Boolean applyStroke;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 24)
    @JvmField
    @Nullable
    public final Integer backgroundAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 23)
    @JvmField
    @Nullable
    public final Integer backgroundColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    @Nullable
    public final Float baselineShift;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    @JvmField
    @Nullable
    public final Boolean boxText;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String defaultText;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    @JvmField
    @Nullable
    public final Boolean fauxBold;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    @JvmField
    @Nullable
    public final Boolean fauxItalic;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 13)
    @JvmField
    @Nullable
    public final Float firstBaseLine;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String fontFamily;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 16)
    @JvmField
    @Nullable
    public final Float fontSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String fontStyle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    @JvmField
    @Nullable
    public final Integer justification;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer layerIndex;

    @WireField(adapter = "com.tencent.tavcut.model.LayerMarkData#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    @JvmField
    @NotNull
    public final List<LayerMarkData> layerMarkList;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String layerName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer layerType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 21)
    @JvmField
    @Nullable
    public final Float leading;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 19)
    @JvmField
    @Nullable
    public final Float stokeWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    @JvmField
    @Nullable
    public final Integer strokeColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    @JvmField
    @Nullable
    public final Boolean strokeOverFill;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer textColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 22)
    @JvmField
    @Nullable
    public final Float tracking;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'J\u0015\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'J\u0015\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010%J\u0015\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010&J\u0015\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010'R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010 \u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010$\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tencent/tavcut/model/TextLayerData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/TextLayerData;", "()V", "applyFill", "", "Ljava/lang/Boolean;", "applyStroke", "backgroundAlpha", "", "Ljava/lang/Integer;", "backgroundColor", "baselineShift", "", "Ljava/lang/Float;", "boxText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "", "fauxBold", "fauxItalic", "firstBaseLine", "fontFamily", "fontSize", "fontStyle", "justification", "layerIndex", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "layerName", "layerType", "leading", "stokeWidth", "strokeColor", "strokeOverFill", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<TextLayerData, Builder> {

        @JvmField
        @Nullable
        public Boolean applyFill;

        @JvmField
        @Nullable
        public Boolean applyStroke;

        @JvmField
        @Nullable
        public Integer backgroundAlpha;

        @JvmField
        @Nullable
        public Integer backgroundColor;

        @JvmField
        @Nullable
        public Float baselineShift;

        @JvmField
        @Nullable
        public Boolean boxText;

        @JvmField
        @Nullable
        public String defaultText;

        @JvmField
        @Nullable
        public Boolean fauxBold;

        @JvmField
        @Nullable
        public Boolean fauxItalic;

        @JvmField
        @Nullable
        public Float firstBaseLine;

        @JvmField
        @Nullable
        public String fontFamily;

        @JvmField
        @Nullable
        public Float fontSize;

        @JvmField
        @Nullable
        public String fontStyle;

        @JvmField
        @Nullable
        public Integer justification;

        @JvmField
        @Nullable
        public Integer layerIndex;

        @JvmField
        @NotNull
        public List<LayerMarkData> layerMarkList;

        @JvmField
        @Nullable
        public String layerName;

        @JvmField
        @Nullable
        public Integer layerType;

        @JvmField
        @Nullable
        public Float leading;

        @JvmField
        @Nullable
        public Float stokeWidth;

        @JvmField
        @Nullable
        public Integer strokeColor;

        @JvmField
        @Nullable
        public Boolean strokeOverFill;

        @JvmField
        @Nullable
        public Integer textColor;

        @JvmField
        @Nullable
        public Float tracking;

        public Builder() {
            List<LayerMarkData> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.layerMarkList = emptyList;
        }

        @NotNull
        public final Builder applyFill(@Nullable Boolean applyFill) {
            this.applyFill = applyFill;
            return this;
        }

        @NotNull
        public final Builder applyStroke(@Nullable Boolean applyStroke) {
            this.applyStroke = applyStroke;
            return this;
        }

        @NotNull
        public final Builder backgroundAlpha(@Nullable Integer backgroundAlpha) {
            this.backgroundAlpha = backgroundAlpha;
            return this;
        }

        @NotNull
        public final Builder backgroundColor(@Nullable Integer backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder baselineShift(@Nullable Float baselineShift) {
            this.baselineShift = baselineShift;
            return this;
        }

        @NotNull
        public final Builder boxText(@Nullable Boolean boxText) {
            this.boxText = boxText;
            return this;
        }

        @NotNull
        public final Builder defaultText(@Nullable String defaultText) {
            this.defaultText = defaultText;
            return this;
        }

        @NotNull
        public final Builder fauxBold(@Nullable Boolean fauxBold) {
            this.fauxBold = fauxBold;
            return this;
        }

        @NotNull
        public final Builder fauxItalic(@Nullable Boolean fauxItalic) {
            this.fauxItalic = fauxItalic;
            return this;
        }

        @NotNull
        public final Builder firstBaseLine(@Nullable Float firstBaseLine) {
            this.firstBaseLine = firstBaseLine;
            return this;
        }

        @NotNull
        public final Builder fontFamily(@Nullable String fontFamily) {
            this.fontFamily = fontFamily;
            return this;
        }

        @NotNull
        public final Builder fontSize(@Nullable Float fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        @NotNull
        public final Builder fontStyle(@Nullable String fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        @NotNull
        public final Builder justification(@Nullable Integer justification) {
            this.justification = justification;
            return this;
        }

        @NotNull
        public final Builder layerIndex(@Nullable Integer layerIndex) {
            this.layerIndex = layerIndex;
            return this;
        }

        @NotNull
        public final Builder layerMarkList(@NotNull List<LayerMarkData> layerMarkList) {
            Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
            Internal.checkElementsNotNull(layerMarkList);
            this.layerMarkList = layerMarkList;
            return this;
        }

        @NotNull
        public final Builder layerName(@Nullable String layerName) {
            this.layerName = layerName;
            return this;
        }

        @NotNull
        public final Builder layerType(@Nullable Integer layerType) {
            this.layerType = layerType;
            return this;
        }

        @NotNull
        public final Builder leading(@Nullable Float leading) {
            this.leading = leading;
            return this;
        }

        @NotNull
        public final Builder stokeWidth(@Nullable Float stokeWidth) {
            this.stokeWidth = stokeWidth;
            return this;
        }

        @NotNull
        public final Builder strokeColor(@Nullable Integer strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        @NotNull
        public final Builder strokeOverFill(@Nullable Boolean strokeOverFill) {
            this.strokeOverFill = strokeOverFill;
            return this;
        }

        @NotNull
        public final Builder textColor(@Nullable Integer textColor) {
            this.textColor = textColor;
            return this;
        }

        @NotNull
        public final Builder tracking(@Nullable Float tracking) {
            this.tracking = tracking;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TextLayerData build() {
            return new TextLayerData(this.layerIndex, this.layerName, this.layerType, this.defaultText, this.textColor, this.fontFamily, this.fontStyle, this.layerMarkList, this.applyFill, this.applyStroke, this.baselineShift, this.boxText, this.firstBaseLine, this.fauxBold, this.fauxItalic, this.fontSize, this.strokeColor, this.strokeOverFill, this.stokeWidth, this.justification, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TextLayerData.class);
        final String str = "type.googleapis.com/publisher.TextLayerData";
        ProtoAdapter<TextLayerData> protoAdapter = new ProtoAdapter<TextLayerData>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.TextLayerData$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextLayerData decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                String str2 = null;
                Integer num2 = null;
                String str3 = null;
                Integer num3 = null;
                String str4 = null;
                String str5 = null;
                Boolean bool = null;
                Boolean bool2 = null;
                Float f16 = null;
                Boolean bool3 = null;
                Boolean bool4 = null;
                Boolean bool5 = null;
                Float f17 = null;
                Integer num4 = null;
                Boolean bool6 = null;
                Float f18 = null;
                Integer num5 = null;
                Float f19 = null;
                Float f26 = null;
                Integer num6 = null;
                Integer num7 = null;
                Float f27 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    Boolean bool7 = bool3;
                    if (nextTag == -1) {
                        return new TextLayerData(num, str2, num2, str3, num3, str4, str5, arrayList, bool, bool2, f16, bool7, f27, bool4, bool5, f17, num4, bool6, f18, num5, f19, f26, num6, num7, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            arrayList.add(LayerMarkData.ADAPTER.decode(reader));
                            break;
                        case 9:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 10:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 11:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 12:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            continue;
                        case 13:
                            f27 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 14:
                            bool4 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 15:
                            bool5 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 16:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 17:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 18:
                            bool6 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 19:
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 20:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 21:
                            f19 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 22:
                            f26 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 23:
                            num6 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 24:
                            num7 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                    bool3 = bool7;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TextLayerData value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.layerIndex);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 2, value.layerName);
                protoAdapter2.encodeWithTag(writer, 3, value.layerType);
                protoAdapter3.encodeWithTag(writer, 4, value.defaultText);
                protoAdapter2.encodeWithTag(writer, 5, value.textColor);
                protoAdapter3.encodeWithTag(writer, 6, value.fontFamily);
                protoAdapter3.encodeWithTag(writer, 7, value.fontStyle);
                LayerMarkData.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.layerMarkList);
                ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
                protoAdapter4.encodeWithTag(writer, 9, value.applyFill);
                protoAdapter4.encodeWithTag(writer, 10, value.applyStroke);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                protoAdapter5.encodeWithTag(writer, 11, value.baselineShift);
                protoAdapter4.encodeWithTag(writer, 12, value.boxText);
                protoAdapter5.encodeWithTag(writer, 13, value.firstBaseLine);
                protoAdapter4.encodeWithTag(writer, 14, value.fauxBold);
                protoAdapter4.encodeWithTag(writer, 15, value.fauxItalic);
                protoAdapter5.encodeWithTag(writer, 16, value.fontSize);
                protoAdapter2.encodeWithTag(writer, 17, value.strokeColor);
                protoAdapter4.encodeWithTag(writer, 18, value.strokeOverFill);
                protoAdapter5.encodeWithTag(writer, 19, value.stokeWidth);
                protoAdapter2.encodeWithTag(writer, 20, value.justification);
                protoAdapter5.encodeWithTag(writer, 21, value.leading);
                protoAdapter5.encodeWithTag(writer, 22, value.tracking);
                protoAdapter2.encodeWithTag(writer, 23, value.backgroundColor);
                protoAdapter2.encodeWithTag(writer, 24, value.backgroundAlpha);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TextLayerData value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.layerIndex);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(2, value.layerName) + protoAdapter2.encodedSizeWithTag(3, value.layerType) + protoAdapter3.encodedSizeWithTag(4, value.defaultText) + protoAdapter2.encodedSizeWithTag(5, value.textColor) + protoAdapter3.encodedSizeWithTag(6, value.fontFamily) + protoAdapter3.encodedSizeWithTag(7, value.fontStyle) + LayerMarkData.ADAPTER.asRepeated().encodedSizeWithTag(8, value.layerMarkList);
                ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(9, value.applyFill) + protoAdapter4.encodedSizeWithTag(10, value.applyStroke);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(11, value.baselineShift) + protoAdapter4.encodedSizeWithTag(12, value.boxText) + protoAdapter5.encodedSizeWithTag(13, value.firstBaseLine) + protoAdapter4.encodedSizeWithTag(14, value.fauxBold) + protoAdapter4.encodedSizeWithTag(15, value.fauxItalic) + protoAdapter5.encodedSizeWithTag(16, value.fontSize) + protoAdapter2.encodedSizeWithTag(17, value.strokeColor) + protoAdapter4.encodedSizeWithTag(18, value.strokeOverFill) + protoAdapter5.encodedSizeWithTag(19, value.stokeWidth) + protoAdapter2.encodedSizeWithTag(20, value.justification) + protoAdapter5.encodedSizeWithTag(21, value.leading) + protoAdapter5.encodedSizeWithTag(22, value.tracking) + protoAdapter2.encodedSizeWithTag(23, value.backgroundColor) + protoAdapter2.encodedSizeWithTag(24, value.backgroundAlpha) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextLayerData redact(@NotNull TextLayerData value) {
                TextLayerData copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r43 & 1) != 0 ? value.layerIndex : null, (r43 & 2) != 0 ? value.layerName : null, (r43 & 4) != 0 ? value.layerType : null, (r43 & 8) != 0 ? value.defaultText : null, (r43 & 16) != 0 ? value.textColor : null, (r43 & 32) != 0 ? value.fontFamily : null, (r43 & 64) != 0 ? value.fontStyle : null, (r43 & 128) != 0 ? value.layerMarkList : Internal.m87redactElements(value.layerMarkList, LayerMarkData.ADAPTER), (r43 & 256) != 0 ? value.applyFill : null, (r43 & 512) != 0 ? value.applyStroke : null, (r43 & 1024) != 0 ? value.baselineShift : null, (r43 & 2048) != 0 ? value.boxText : null, (r43 & 4096) != 0 ? value.firstBaseLine : null, (r43 & 8192) != 0 ? value.fauxBold : null, (r43 & 16384) != 0 ? value.fauxItalic : null, (r43 & 32768) != 0 ? value.fontSize : null, (r43 & 65536) != 0 ? value.strokeColor : null, (r43 & 131072) != 0 ? value.strokeOverFill : null, (r43 & 262144) != 0 ? value.stokeWidth : null, (r43 & 524288) != 0 ? value.justification : null, (r43 & 1048576) != 0 ? value.leading : null, (r43 & 2097152) != 0 ? value.tracking : null, (r43 & 4194304) != 0 ? value.backgroundColor : null, (r43 & 8388608) != 0 ? value.backgroundAlpha : null, (r43 & 16777216) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TextLayerData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    @NotNull
    public final TextLayerData copy(@Nullable Integer layerIndex, @Nullable String layerName, @Nullable Integer layerType, @Nullable String defaultText, @Nullable Integer textColor, @Nullable String fontFamily, @Nullable String fontStyle, @NotNull List<LayerMarkData> layerMarkList, @Nullable Boolean applyFill, @Nullable Boolean applyStroke, @Nullable Float baselineShift, @Nullable Boolean boxText, @Nullable Float firstBaseLine, @Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable Float fontSize, @Nullable Integer strokeColor, @Nullable Boolean strokeOverFill, @Nullable Float stokeWidth, @Nullable Integer justification, @Nullable Float leading, @Nullable Float tracking, @Nullable Integer backgroundColor, @Nullable Integer backgroundAlpha, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new TextLayerData(layerIndex, layerName, layerType, defaultText, textColor, fontFamily, fontStyle, layerMarkList, applyFill, applyStroke, baselineShift, boxText, firstBaseLine, fauxBold, fauxItalic, fontSize, strokeColor, strokeOverFill, stokeWidth, justification, leading, tracking, backgroundColor, backgroundAlpha, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TextLayerData)) {
            return false;
        }
        TextLayerData textLayerData = (TextLayerData) other;
        if (Intrinsics.areEqual(unknownFields(), textLayerData.unknownFields()) && Intrinsics.areEqual(this.layerIndex, textLayerData.layerIndex) && Intrinsics.areEqual(this.layerName, textLayerData.layerName) && Intrinsics.areEqual(this.layerType, textLayerData.layerType) && Intrinsics.areEqual(this.defaultText, textLayerData.defaultText) && Intrinsics.areEqual(this.textColor, textLayerData.textColor) && Intrinsics.areEqual(this.fontFamily, textLayerData.fontFamily) && Intrinsics.areEqual(this.fontStyle, textLayerData.fontStyle) && Intrinsics.areEqual(this.layerMarkList, textLayerData.layerMarkList) && Intrinsics.areEqual(this.applyFill, textLayerData.applyFill) && Intrinsics.areEqual(this.applyStroke, textLayerData.applyStroke) && Intrinsics.areEqual(this.baselineShift, textLayerData.baselineShift) && Intrinsics.areEqual(this.boxText, textLayerData.boxText) && Intrinsics.areEqual(this.firstBaseLine, textLayerData.firstBaseLine) && Intrinsics.areEqual(this.fauxBold, textLayerData.fauxBold) && Intrinsics.areEqual(this.fauxItalic, textLayerData.fauxItalic) && Intrinsics.areEqual(this.fontSize, textLayerData.fontSize) && Intrinsics.areEqual(this.strokeColor, textLayerData.strokeColor) && Intrinsics.areEqual(this.strokeOverFill, textLayerData.strokeOverFill) && Intrinsics.areEqual(this.stokeWidth, textLayerData.stokeWidth) && Intrinsics.areEqual(this.justification, textLayerData.justification) && Intrinsics.areEqual(this.leading, textLayerData.leading) && Intrinsics.areEqual(this.tracking, textLayerData.tracking) && Intrinsics.areEqual(this.backgroundColor, textLayerData.backgroundColor) && Intrinsics.areEqual(this.backgroundAlpha, textLayerData.backgroundAlpha)) {
            return true;
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
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66 = this.hashCode;
        if (i66 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.layerIndex;
            int i67 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i68 = (hashCode + i3) * 37;
            String str = this.layerName;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i69 = (i68 + i16) * 37;
            Integer num2 = this.layerType;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i75 = (i69 + i17) * 37;
            String str2 = this.defaultText;
            if (str2 != null) {
                i18 = str2.hashCode();
            } else {
                i18 = 0;
            }
            int i76 = (i75 + i18) * 37;
            Integer num3 = this.textColor;
            if (num3 != null) {
                i19 = num3.hashCode();
            } else {
                i19 = 0;
            }
            int i77 = (i76 + i19) * 37;
            String str3 = this.fontFamily;
            if (str3 != null) {
                i26 = str3.hashCode();
            } else {
                i26 = 0;
            }
            int i78 = (i77 + i26) * 37;
            String str4 = this.fontStyle;
            if (str4 != null) {
                i27 = str4.hashCode();
            } else {
                i27 = 0;
            }
            int hashCode2 = (((i78 + i27) * 37) + this.layerMarkList.hashCode()) * 37;
            Boolean bool = this.applyFill;
            if (bool != null) {
                i28 = bool.hashCode();
            } else {
                i28 = 0;
            }
            int i79 = (hashCode2 + i28) * 37;
            Boolean bool2 = this.applyStroke;
            if (bool2 != null) {
                i29 = bool2.hashCode();
            } else {
                i29 = 0;
            }
            int i85 = (i79 + i29) * 37;
            Float f16 = this.baselineShift;
            if (f16 != null) {
                i36 = f16.hashCode();
            } else {
                i36 = 0;
            }
            int i86 = (i85 + i36) * 37;
            Boolean bool3 = this.boxText;
            if (bool3 != null) {
                i37 = bool3.hashCode();
            } else {
                i37 = 0;
            }
            int i87 = (i86 + i37) * 37;
            Float f17 = this.firstBaseLine;
            if (f17 != null) {
                i38 = f17.hashCode();
            } else {
                i38 = 0;
            }
            int i88 = (i87 + i38) * 37;
            Boolean bool4 = this.fauxBold;
            if (bool4 != null) {
                i39 = bool4.hashCode();
            } else {
                i39 = 0;
            }
            int i89 = (i88 + i39) * 37;
            Boolean bool5 = this.fauxItalic;
            if (bool5 != null) {
                i46 = bool5.hashCode();
            } else {
                i46 = 0;
            }
            int i95 = (i89 + i46) * 37;
            Float f18 = this.fontSize;
            if (f18 != null) {
                i47 = f18.hashCode();
            } else {
                i47 = 0;
            }
            int i96 = (i95 + i47) * 37;
            Integer num4 = this.strokeColor;
            if (num4 != null) {
                i48 = num4.hashCode();
            } else {
                i48 = 0;
            }
            int i97 = (i96 + i48) * 37;
            Boolean bool6 = this.strokeOverFill;
            if (bool6 != null) {
                i49 = bool6.hashCode();
            } else {
                i49 = 0;
            }
            int i98 = (i97 + i49) * 37;
            Float f19 = this.stokeWidth;
            if (f19 != null) {
                i56 = f19.hashCode();
            } else {
                i56 = 0;
            }
            int i99 = (i98 + i56) * 37;
            Integer num5 = this.justification;
            if (num5 != null) {
                i57 = num5.hashCode();
            } else {
                i57 = 0;
            }
            int i100 = (i99 + i57) * 37;
            Float f26 = this.leading;
            if (f26 != null) {
                i58 = f26.hashCode();
            } else {
                i58 = 0;
            }
            int i101 = (i100 + i58) * 37;
            Float f27 = this.tracking;
            if (f27 != null) {
                i59 = f27.hashCode();
            } else {
                i59 = 0;
            }
            int i102 = (i101 + i59) * 37;
            Integer num6 = this.backgroundColor;
            if (num6 != null) {
                i65 = num6.hashCode();
            } else {
                i65 = 0;
            }
            int i103 = (i102 + i65) * 37;
            Integer num7 = this.backgroundAlpha;
            if (num7 != null) {
                i67 = num7.hashCode();
            }
            int i104 = i103 + i67;
            this.hashCode = i104;
            return i104;
        }
        return i66;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.layerIndex != null) {
            arrayList.add("layerIndex=" + this.layerIndex);
        }
        if (this.layerName != null) {
            arrayList.add("layerName=" + Internal.sanitize(this.layerName));
        }
        if (this.layerType != null) {
            arrayList.add("layerType=" + this.layerType);
        }
        if (this.defaultText != null) {
            arrayList.add("defaultText=" + Internal.sanitize(this.defaultText));
        }
        if (this.textColor != null) {
            arrayList.add("textColor=" + this.textColor);
        }
        if (this.fontFamily != null) {
            arrayList.add("fontFamily=" + Internal.sanitize(this.fontFamily));
        }
        if (this.fontStyle != null) {
            arrayList.add("fontStyle=" + Internal.sanitize(this.fontStyle));
        }
        if (!this.layerMarkList.isEmpty()) {
            arrayList.add("layerMarkList=" + this.layerMarkList);
        }
        if (this.applyFill != null) {
            arrayList.add("applyFill=" + this.applyFill);
        }
        if (this.applyStroke != null) {
            arrayList.add("applyStroke=" + this.applyStroke);
        }
        if (this.baselineShift != null) {
            arrayList.add("baselineShift=" + this.baselineShift);
        }
        if (this.boxText != null) {
            arrayList.add("boxText=" + this.boxText);
        }
        if (this.firstBaseLine != null) {
            arrayList.add("firstBaseLine=" + this.firstBaseLine);
        }
        if (this.fauxBold != null) {
            arrayList.add("fauxBold=" + this.fauxBold);
        }
        if (this.fauxItalic != null) {
            arrayList.add("fauxItalic=" + this.fauxItalic);
        }
        if (this.fontSize != null) {
            arrayList.add("fontSize=" + this.fontSize);
        }
        if (this.strokeColor != null) {
            arrayList.add("strokeColor=" + this.strokeColor);
        }
        if (this.strokeOverFill != null) {
            arrayList.add("strokeOverFill=" + this.strokeOverFill);
        }
        if (this.stokeWidth != null) {
            arrayList.add("stokeWidth=" + this.stokeWidth);
        }
        if (this.justification != null) {
            arrayList.add("justification=" + this.justification);
        }
        if (this.leading != null) {
            arrayList.add("leading=" + this.leading);
        }
        if (this.tracking != null) {
            arrayList.add("tracking=" + this.tracking);
        }
        if (this.backgroundColor != null) {
            arrayList.add("backgroundColor=" + this.backgroundColor);
        }
        if (this.backgroundAlpha != null) {
            arrayList.add("backgroundAlpha=" + this.backgroundAlpha);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TextLayerData{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TextLayerData(Integer num, String str, Integer num2, String str2, Integer num3, String str3, String str4, List list, Boolean bool, Boolean bool2, Float f16, Boolean bool3, Float f17, Boolean bool4, Boolean bool5, Float f18, Integer num4, Boolean bool6, Float f19, Integer num5, Float f26, Float f27, Integer num6, Integer num7, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 256) != 0 ? null : bool, (i3 & 512) != 0 ? null : bool2, (i3 & 1024) != 0 ? null : f16, (i3 & 2048) != 0 ? null : bool3, (i3 & 4096) != 0 ? null : f17, (i3 & 8192) != 0 ? null : bool4, (i3 & 16384) != 0 ? null : bool5, (i3 & 32768) != 0 ? null : f18, (i3 & 65536) != 0 ? null : num4, (i3 & 131072) != 0 ? null : bool6, (i3 & 262144) != 0 ? null : f19, (i3 & 524288) != 0 ? null : num5, (i3 & 1048576) != 0 ? null : f26, (i3 & 2097152) != 0 ? null : f27, (i3 & 4194304) != 0 ? null : num6, (i3 & 8388608) != 0 ? null : num7, (i3 & 16777216) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.layerIndex = this.layerIndex;
        builder.layerName = this.layerName;
        builder.layerType = this.layerType;
        builder.defaultText = this.defaultText;
        builder.textColor = this.textColor;
        builder.fontFamily = this.fontFamily;
        builder.fontStyle = this.fontStyle;
        builder.layerMarkList = this.layerMarkList;
        builder.applyFill = this.applyFill;
        builder.applyStroke = this.applyStroke;
        builder.baselineShift = this.baselineShift;
        builder.boxText = this.boxText;
        builder.firstBaseLine = this.firstBaseLine;
        builder.fauxBold = this.fauxBold;
        builder.fauxItalic = this.fauxItalic;
        builder.fontSize = this.fontSize;
        builder.strokeColor = this.strokeColor;
        builder.strokeOverFill = this.strokeOverFill;
        builder.stokeWidth = this.stokeWidth;
        builder.justification = this.justification;
        builder.leading = this.leading;
        builder.tracking = this.tracking;
        builder.backgroundColor = this.backgroundColor;
        builder.backgroundAlpha = this.backgroundAlpha;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextLayerData(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable Integer num3, @Nullable String str3, @Nullable String str4, @NotNull List<LayerMarkData> layerMarkList, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Float f16, @Nullable Boolean bool3, @Nullable Float f17, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Float f18, @Nullable Integer num4, @Nullable Boolean bool6, @Nullable Float f19, @Nullable Integer num5, @Nullable Float f26, @Nullable Float f27, @Nullable Integer num6, @Nullable Integer num7, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.layerIndex = num;
        this.layerName = str;
        this.layerType = num2;
        this.defaultText = str2;
        this.textColor = num3;
        this.fontFamily = str3;
        this.fontStyle = str4;
        this.layerMarkList = layerMarkList;
        this.applyFill = bool;
        this.applyStroke = bool2;
        this.baselineShift = f16;
        this.boxText = bool3;
        this.firstBaseLine = f17;
        this.fauxBold = bool4;
        this.fauxItalic = bool5;
        this.fontSize = f18;
        this.strokeColor = num4;
        this.strokeOverFill = bool6;
        this.stokeWidth = f19;
        this.justification = num5;
        this.leading = f26;
        this.tracking = f27;
        this.backgroundColor = num6;
        this.backgroundAlpha = num7;
    }
}
