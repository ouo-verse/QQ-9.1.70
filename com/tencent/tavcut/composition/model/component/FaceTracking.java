package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0087\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ\u008d\u0002\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\rH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/FaceTracking;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/FaceTracking$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "alignPoints", "", "eTrackingOptions", "faceIndex", "genderBinding", "", "isAllFrameFaceDetect", "isRefine", "isWaitFirstFrameDetect", "type", "xAxisRotateTrack", "xAxisScale", "xAxisTrack", "yAxisRotateTrack", "yAxisScale", "yAxisTrack", "zAxisRotateTrack", "scalePivotPoint1", "scalePivotPoint2", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/FaceTracking;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class FaceTracking extends AndroidMessage<FaceTracking, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<FaceTracking> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<FaceTracking> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 4)
    @JvmField
    @NotNull
    public final List<Integer> alignPoints;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    @JvmField
    @Nullable
    public final Boolean eTrackingOptions;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
    @JvmField
    @NotNull
    public final List<Integer> faceIndex;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String genderBinding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    @JvmField
    @Nullable
    public final Boolean isAllFrameFaceDetect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    @JvmField
    @Nullable
    public final Boolean isRefine;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    @JvmField
    @Nullable
    public final Boolean isWaitFirstFrameDetect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 19)
    @JvmField
    @Nullable
    public final Integer scalePivotPoint1;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    @JvmField
    @Nullable
    public final Integer scalePivotPoint2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    @JvmField
    @Nullable
    public final Boolean xAxisRotateTrack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    @JvmField
    @Nullable
    public final Boolean xAxisScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    @JvmField
    @Nullable
    public final Boolean xAxisTrack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    @JvmField
    @Nullable
    public final Boolean yAxisRotateTrack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    @JvmField
    @Nullable
    public final Boolean yAxisScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    @JvmField
    @Nullable
    public final Boolean yAxisTrack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    @JvmField
    @Nullable
    public final Boolean zAxisRotateTrack;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u001fJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 J\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010 R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/FaceTracking$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/FaceTracking;", "()V", "alignPoints", "", "", TemplateParser.KEY_COMPONENT_ID, "Ljava/lang/Integer;", "eTrackingOptions", "", "Ljava/lang/Boolean;", NodeProps.ENABLED, TemplateParser.KEY_ENTITY_ID, "faceIndex", "genderBinding", "", "isAllFrameFaceDetect", "isRefine", "isWaitFirstFrameDetect", "scalePivotPoint1", "scalePivotPoint2", "type", "xAxisRotateTrack", "xAxisScale", "xAxisTrack", "yAxisRotateTrack", "yAxisScale", "yAxisTrack", "zAxisRotateTrack", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/FaceTracking$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/FaceTracking$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<FaceTracking, Builder> {

        @JvmField
        @NotNull
        public List<Integer> alignPoints;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Boolean eTrackingOptions;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @NotNull
        public List<Integer> faceIndex;

        @JvmField
        @Nullable
        public String genderBinding;

        @JvmField
        @Nullable
        public Boolean isAllFrameFaceDetect;

        @JvmField
        @Nullable
        public Boolean isRefine;

        @JvmField
        @Nullable
        public Boolean isWaitFirstFrameDetect;

        @JvmField
        @Nullable
        public Integer scalePivotPoint1;

        @JvmField
        @Nullable
        public Integer scalePivotPoint2;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Boolean xAxisRotateTrack;

        @JvmField
        @Nullable
        public Boolean xAxisScale;

        @JvmField
        @Nullable
        public Boolean xAxisTrack;

        @JvmField
        @Nullable
        public Boolean yAxisRotateTrack;

        @JvmField
        @Nullable
        public Boolean yAxisScale;

        @JvmField
        @Nullable
        public Boolean yAxisTrack;

        @JvmField
        @Nullable
        public Boolean zAxisRotateTrack;

        public Builder() {
            List<Integer> emptyList;
            List<Integer> emptyList2;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.alignPoints = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.faceIndex = emptyList2;
        }

        @NotNull
        public final Builder alignPoints(@NotNull List<Integer> alignPoints) {
            Intrinsics.checkParameterIsNotNull(alignPoints, "alignPoints");
            Internal.checkElementsNotNull(alignPoints);
            this.alignPoints = alignPoints;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder eTrackingOptions(@Nullable Boolean eTrackingOptions) {
            this.eTrackingOptions = eTrackingOptions;
            return this;
        }

        @NotNull
        public final Builder enabled(@Nullable Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @NotNull
        public final Builder entityId(@Nullable Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        @NotNull
        public final Builder faceIndex(@NotNull List<Integer> faceIndex) {
            Intrinsics.checkParameterIsNotNull(faceIndex, "faceIndex");
            Internal.checkElementsNotNull(faceIndex);
            this.faceIndex = faceIndex;
            return this;
        }

        @NotNull
        public final Builder genderBinding(@Nullable String genderBinding) {
            this.genderBinding = genderBinding;
            return this;
        }

        @NotNull
        public final Builder isAllFrameFaceDetect(@Nullable Boolean isAllFrameFaceDetect) {
            this.isAllFrameFaceDetect = isAllFrameFaceDetect;
            return this;
        }

        @NotNull
        public final Builder isRefine(@Nullable Boolean isRefine) {
            this.isRefine = isRefine;
            return this;
        }

        @NotNull
        public final Builder isWaitFirstFrameDetect(@Nullable Boolean isWaitFirstFrameDetect) {
            this.isWaitFirstFrameDetect = isWaitFirstFrameDetect;
            return this;
        }

        @NotNull
        public final Builder scalePivotPoint1(@Nullable Integer scalePivotPoint1) {
            this.scalePivotPoint1 = scalePivotPoint1;
            return this;
        }

        @NotNull
        public final Builder scalePivotPoint2(@Nullable Integer scalePivotPoint2) {
            this.scalePivotPoint2 = scalePivotPoint2;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder xAxisRotateTrack(@Nullable Boolean xAxisRotateTrack) {
            this.xAxisRotateTrack = xAxisRotateTrack;
            return this;
        }

        @NotNull
        public final Builder xAxisScale(@Nullable Boolean xAxisScale) {
            this.xAxisScale = xAxisScale;
            return this;
        }

        @NotNull
        public final Builder xAxisTrack(@Nullable Boolean xAxisTrack) {
            this.xAxisTrack = xAxisTrack;
            return this;
        }

        @NotNull
        public final Builder yAxisRotateTrack(@Nullable Boolean yAxisRotateTrack) {
            this.yAxisRotateTrack = yAxisRotateTrack;
            return this;
        }

        @NotNull
        public final Builder yAxisScale(@Nullable Boolean yAxisScale) {
            this.yAxisScale = yAxisScale;
            return this;
        }

        @NotNull
        public final Builder yAxisTrack(@Nullable Boolean yAxisTrack) {
            this.yAxisTrack = yAxisTrack;
            return this;
        }

        @NotNull
        public final Builder zAxisRotateTrack(@Nullable Boolean zAxisRotateTrack) {
            this.zAxisRotateTrack = zAxisRotateTrack;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public FaceTracking build() {
            return new FaceTracking(this.componentID, this.enabled, this.entityId, this.alignPoints, this.eTrackingOptions, this.faceIndex, this.genderBinding, this.isAllFrameFaceDetect, this.isRefine, this.isWaitFirstFrameDetect, this.type, this.xAxisRotateTrack, this.xAxisScale, this.xAxisTrack, this.yAxisRotateTrack, this.yAxisScale, this.yAxisTrack, this.zAxisRotateTrack, this.scalePivotPoint1, this.scalePivotPoint2, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FaceTracking.class);
        final String str = "type.googleapis.com/publisher.FaceTracking";
        ProtoAdapter<FaceTracking> protoAdapter = new ProtoAdapter<FaceTracking>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.FaceTracking$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public FaceTracking decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                Boolean bool2 = null;
                String str2 = null;
                Boolean bool3 = null;
                Boolean bool4 = null;
                Boolean bool5 = null;
                String str3 = null;
                Boolean bool6 = null;
                Boolean bool7 = null;
                Boolean bool8 = null;
                Boolean bool9 = null;
                Boolean bool10 = null;
                Boolean bool11 = null;
                Integer num3 = null;
                Integer num4 = null;
                Boolean bool12 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    Boolean bool13 = bool6;
                    if (nextTag == -1) {
                        return new FaceTracking(num, bool, num2, arrayList, bool2, arrayList2, str2, bool3, bool4, bool5, str3, bool13, bool12, bool7, bool8, bool9, bool10, bool11, num3, num4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 3:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            arrayList.add(ProtoAdapter.INT32.decode(reader));
                            break;
                        case 5:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 6:
                            arrayList2.add(ProtoAdapter.INT32.decode(reader));
                            break;
                        case 7:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 9:
                            bool4 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 10:
                            bool5 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 11:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            bool6 = ProtoAdapter.BOOL.decode(reader);
                            continue;
                        case 13:
                            bool12 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 14:
                            bool7 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 15:
                            bool8 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 16:
                            bool9 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 17:
                            bool10 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 18:
                            bool11 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 19:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 20:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                    bool6 = bool13;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull FaceTracking value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                protoAdapter3.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.alignPoints);
                protoAdapter3.encodeWithTag(writer, 5, value.eTrackingOptions);
                protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.faceIndex);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                protoAdapter4.encodeWithTag(writer, 7, value.genderBinding);
                protoAdapter3.encodeWithTag(writer, 8, value.isAllFrameFaceDetect);
                protoAdapter3.encodeWithTag(writer, 9, value.isRefine);
                protoAdapter3.encodeWithTag(writer, 10, value.isWaitFirstFrameDetect);
                protoAdapter4.encodeWithTag(writer, 11, value.type);
                protoAdapter3.encodeWithTag(writer, 12, value.xAxisRotateTrack);
                protoAdapter3.encodeWithTag(writer, 13, value.xAxisScale);
                protoAdapter3.encodeWithTag(writer, 14, value.xAxisTrack);
                protoAdapter3.encodeWithTag(writer, 15, value.yAxisRotateTrack);
                protoAdapter3.encodeWithTag(writer, 16, value.yAxisScale);
                protoAdapter3.encodeWithTag(writer, 17, value.yAxisTrack);
                protoAdapter3.encodeWithTag(writer, 18, value.zAxisRotateTrack);
                protoAdapter2.encodeWithTag(writer, 19, value.scalePivotPoint1);
                protoAdapter2.encodeWithTag(writer, 20, value.scalePivotPoint2);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull FaceTracking value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.alignPoints) + protoAdapter3.encodedSizeWithTag(5, value.eTrackingOptions) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.faceIndex);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(7, value.genderBinding) + protoAdapter3.encodedSizeWithTag(8, value.isAllFrameFaceDetect) + protoAdapter3.encodedSizeWithTag(9, value.isRefine) + protoAdapter3.encodedSizeWithTag(10, value.isWaitFirstFrameDetect) + protoAdapter4.encodedSizeWithTag(11, value.type) + protoAdapter3.encodedSizeWithTag(12, value.xAxisRotateTrack) + protoAdapter3.encodedSizeWithTag(13, value.xAxisScale) + protoAdapter3.encodedSizeWithTag(14, value.xAxisTrack) + protoAdapter3.encodedSizeWithTag(15, value.yAxisRotateTrack) + protoAdapter3.encodedSizeWithTag(16, value.yAxisScale) + protoAdapter3.encodedSizeWithTag(17, value.yAxisTrack) + protoAdapter3.encodedSizeWithTag(18, value.zAxisRotateTrack) + protoAdapter2.encodedSizeWithTag(19, value.scalePivotPoint1) + protoAdapter2.encodedSizeWithTag(20, value.scalePivotPoint2) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public FaceTracking redact(@NotNull FaceTracking value) {
                FaceTracking copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r39 & 1) != 0 ? value.componentID : null, (r39 & 2) != 0 ? value.enabled : null, (r39 & 4) != 0 ? value.entityId : null, (r39 & 8) != 0 ? value.alignPoints : null, (r39 & 16) != 0 ? value.eTrackingOptions : null, (r39 & 32) != 0 ? value.faceIndex : null, (r39 & 64) != 0 ? value.genderBinding : null, (r39 & 128) != 0 ? value.isAllFrameFaceDetect : null, (r39 & 256) != 0 ? value.isRefine : null, (r39 & 512) != 0 ? value.isWaitFirstFrameDetect : null, (r39 & 1024) != 0 ? value.type : null, (r39 & 2048) != 0 ? value.xAxisRotateTrack : null, (r39 & 4096) != 0 ? value.xAxisScale : null, (r39 & 8192) != 0 ? value.xAxisTrack : null, (r39 & 16384) != 0 ? value.yAxisRotateTrack : null, (r39 & 32768) != 0 ? value.yAxisScale : null, (r39 & 65536) != 0 ? value.yAxisTrack : null, (r39 & 131072) != 0 ? value.zAxisRotateTrack : null, (r39 & 262144) != 0 ? value.scalePivotPoint1 : null, (r39 & 524288) != 0 ? value.scalePivotPoint2 : null, (r39 & 1048576) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public FaceTracking() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    @NotNull
    public final FaceTracking copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @NotNull List<Integer> alignPoints, @Nullable Boolean eTrackingOptions, @NotNull List<Integer> faceIndex, @Nullable String genderBinding, @Nullable Boolean isAllFrameFaceDetect, @Nullable Boolean isRefine, @Nullable Boolean isWaitFirstFrameDetect, @Nullable String type, @Nullable Boolean xAxisRotateTrack, @Nullable Boolean xAxisScale, @Nullable Boolean xAxisTrack, @Nullable Boolean yAxisRotateTrack, @Nullable Boolean yAxisScale, @Nullable Boolean yAxisTrack, @Nullable Boolean zAxisRotateTrack, @Nullable Integer scalePivotPoint1, @Nullable Integer scalePivotPoint2, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(alignPoints, "alignPoints");
        Intrinsics.checkParameterIsNotNull(faceIndex, "faceIndex");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new FaceTracking(componentID, enabled, entityId, alignPoints, eTrackingOptions, faceIndex, genderBinding, isAllFrameFaceDetect, isRefine, isWaitFirstFrameDetect, type, xAxisRotateTrack, xAxisScale, xAxisTrack, yAxisRotateTrack, yAxisScale, yAxisTrack, zAxisRotateTrack, scalePivotPoint1, scalePivotPoint2, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FaceTracking)) {
            return false;
        }
        FaceTracking faceTracking = (FaceTracking) other;
        if (Intrinsics.areEqual(unknownFields(), faceTracking.unknownFields()) && Intrinsics.areEqual(this.componentID, faceTracking.componentID) && Intrinsics.areEqual(this.enabled, faceTracking.enabled) && Intrinsics.areEqual(this.entityId, faceTracking.entityId) && Intrinsics.areEqual(this.alignPoints, faceTracking.alignPoints) && Intrinsics.areEqual(this.eTrackingOptions, faceTracking.eTrackingOptions) && Intrinsics.areEqual(this.faceIndex, faceTracking.faceIndex) && Intrinsics.areEqual(this.genderBinding, faceTracking.genderBinding) && Intrinsics.areEqual(this.isAllFrameFaceDetect, faceTracking.isAllFrameFaceDetect) && Intrinsics.areEqual(this.isRefine, faceTracking.isRefine) && Intrinsics.areEqual(this.isWaitFirstFrameDetect, faceTracking.isWaitFirstFrameDetect) && Intrinsics.areEqual(this.type, faceTracking.type) && Intrinsics.areEqual(this.xAxisRotateTrack, faceTracking.xAxisRotateTrack) && Intrinsics.areEqual(this.xAxisScale, faceTracking.xAxisScale) && Intrinsics.areEqual(this.xAxisTrack, faceTracking.xAxisTrack) && Intrinsics.areEqual(this.yAxisRotateTrack, faceTracking.yAxisRotateTrack) && Intrinsics.areEqual(this.yAxisScale, faceTracking.yAxisScale) && Intrinsics.areEqual(this.yAxisTrack, faceTracking.yAxisTrack) && Intrinsics.areEqual(this.zAxisRotateTrack, faceTracking.zAxisRotateTrack) && Intrinsics.areEqual(this.scalePivotPoint1, faceTracking.scalePivotPoint1) && Intrinsics.areEqual(this.scalePivotPoint2, faceTracking.scalePivotPoint2)) {
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
        int i56 = this.hashCode;
        if (i56 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.componentID;
            int i57 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i58 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i59 = (i58 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i59 + i17) * 37) + this.alignPoints.hashCode()) * 37;
            Boolean bool2 = this.eTrackingOptions;
            if (bool2 != null) {
                i18 = bool2.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode3 = (((hashCode2 + i18) * 37) + this.faceIndex.hashCode()) * 37;
            String str = this.genderBinding;
            if (str != null) {
                i19 = str.hashCode();
            } else {
                i19 = 0;
            }
            int i65 = (hashCode3 + i19) * 37;
            Boolean bool3 = this.isAllFrameFaceDetect;
            if (bool3 != null) {
                i26 = bool3.hashCode();
            } else {
                i26 = 0;
            }
            int i66 = (i65 + i26) * 37;
            Boolean bool4 = this.isRefine;
            if (bool4 != null) {
                i27 = bool4.hashCode();
            } else {
                i27 = 0;
            }
            int i67 = (i66 + i27) * 37;
            Boolean bool5 = this.isWaitFirstFrameDetect;
            if (bool5 != null) {
                i28 = bool5.hashCode();
            } else {
                i28 = 0;
            }
            int i68 = (i67 + i28) * 37;
            String str2 = this.type;
            if (str2 != null) {
                i29 = str2.hashCode();
            } else {
                i29 = 0;
            }
            int i69 = (i68 + i29) * 37;
            Boolean bool6 = this.xAxisRotateTrack;
            if (bool6 != null) {
                i36 = bool6.hashCode();
            } else {
                i36 = 0;
            }
            int i75 = (i69 + i36) * 37;
            Boolean bool7 = this.xAxisScale;
            if (bool7 != null) {
                i37 = bool7.hashCode();
            } else {
                i37 = 0;
            }
            int i76 = (i75 + i37) * 37;
            Boolean bool8 = this.xAxisTrack;
            if (bool8 != null) {
                i38 = bool8.hashCode();
            } else {
                i38 = 0;
            }
            int i77 = (i76 + i38) * 37;
            Boolean bool9 = this.yAxisRotateTrack;
            if (bool9 != null) {
                i39 = bool9.hashCode();
            } else {
                i39 = 0;
            }
            int i78 = (i77 + i39) * 37;
            Boolean bool10 = this.yAxisScale;
            if (bool10 != null) {
                i46 = bool10.hashCode();
            } else {
                i46 = 0;
            }
            int i79 = (i78 + i46) * 37;
            Boolean bool11 = this.yAxisTrack;
            if (bool11 != null) {
                i47 = bool11.hashCode();
            } else {
                i47 = 0;
            }
            int i85 = (i79 + i47) * 37;
            Boolean bool12 = this.zAxisRotateTrack;
            if (bool12 != null) {
                i48 = bool12.hashCode();
            } else {
                i48 = 0;
            }
            int i86 = (i85 + i48) * 37;
            Integer num3 = this.scalePivotPoint1;
            if (num3 != null) {
                i49 = num3.hashCode();
            } else {
                i49 = 0;
            }
            int i87 = (i86 + i49) * 37;
            Integer num4 = this.scalePivotPoint2;
            if (num4 != null) {
                i57 = num4.hashCode();
            }
            int i88 = i87 + i57;
            this.hashCode = i88;
            return i88;
        }
        return i56;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (!this.alignPoints.isEmpty()) {
            arrayList.add("alignPoints=" + this.alignPoints);
        }
        if (this.eTrackingOptions != null) {
            arrayList.add("eTrackingOptions=" + this.eTrackingOptions);
        }
        if (!this.faceIndex.isEmpty()) {
            arrayList.add("faceIndex=" + this.faceIndex);
        }
        if (this.genderBinding != null) {
            arrayList.add("genderBinding=" + Internal.sanitize(this.genderBinding));
        }
        if (this.isAllFrameFaceDetect != null) {
            arrayList.add("isAllFrameFaceDetect=" + this.isAllFrameFaceDetect);
        }
        if (this.isRefine != null) {
            arrayList.add("isRefine=" + this.isRefine);
        }
        if (this.isWaitFirstFrameDetect != null) {
            arrayList.add("isWaitFirstFrameDetect=" + this.isWaitFirstFrameDetect);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.xAxisRotateTrack != null) {
            arrayList.add("xAxisRotateTrack=" + this.xAxisRotateTrack);
        }
        if (this.xAxisScale != null) {
            arrayList.add("xAxisScale=" + this.xAxisScale);
        }
        if (this.xAxisTrack != null) {
            arrayList.add("xAxisTrack=" + this.xAxisTrack);
        }
        if (this.yAxisRotateTrack != null) {
            arrayList.add("yAxisRotateTrack=" + this.yAxisRotateTrack);
        }
        if (this.yAxisScale != null) {
            arrayList.add("yAxisScale=" + this.yAxisScale);
        }
        if (this.yAxisTrack != null) {
            arrayList.add("yAxisTrack=" + this.yAxisTrack);
        }
        if (this.zAxisRotateTrack != null) {
            arrayList.add("zAxisRotateTrack=" + this.zAxisRotateTrack);
        }
        if (this.scalePivotPoint1 != null) {
            arrayList.add("scalePivotPoint1=" + this.scalePivotPoint1);
        }
        if (this.scalePivotPoint2 != null) {
            arrayList.add("scalePivotPoint2=" + this.scalePivotPoint2);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "FaceTracking{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ FaceTracking(Integer num, Boolean bool, Integer num2, List list, Boolean bool2, List list2, String str, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Integer num3, Integer num4, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? null : bool2, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 64) != 0 ? null : str, (i3 & 128) != 0 ? null : bool3, (i3 & 256) != 0 ? null : bool4, (i3 & 512) != 0 ? null : bool5, (i3 & 1024) != 0 ? null : str2, (i3 & 2048) != 0 ? null : bool6, (i3 & 4096) != 0 ? null : bool7, (i3 & 8192) != 0 ? null : bool8, (i3 & 16384) != 0 ? null : bool9, (i3 & 32768) != 0 ? null : bool10, (i3 & 65536) != 0 ? null : bool11, (i3 & 131072) != 0 ? null : bool12, (i3 & 262144) != 0 ? null : num3, (i3 & 524288) != 0 ? null : num4, (i3 & 1048576) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.alignPoints = this.alignPoints;
        builder.eTrackingOptions = this.eTrackingOptions;
        builder.faceIndex = this.faceIndex;
        builder.genderBinding = this.genderBinding;
        builder.isAllFrameFaceDetect = this.isAllFrameFaceDetect;
        builder.isRefine = this.isRefine;
        builder.isWaitFirstFrameDetect = this.isWaitFirstFrameDetect;
        builder.type = this.type;
        builder.xAxisRotateTrack = this.xAxisRotateTrack;
        builder.xAxisScale = this.xAxisScale;
        builder.xAxisTrack = this.xAxisTrack;
        builder.yAxisRotateTrack = this.yAxisRotateTrack;
        builder.yAxisScale = this.yAxisScale;
        builder.yAxisTrack = this.yAxisTrack;
        builder.zAxisRotateTrack = this.zAxisRotateTrack;
        builder.scalePivotPoint1 = this.scalePivotPoint1;
        builder.scalePivotPoint2 = this.scalePivotPoint2;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceTracking(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @NotNull List<Integer> alignPoints, @Nullable Boolean bool2, @NotNull List<Integer> faceIndex, @Nullable String str, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable String str2, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable Integer num3, @Nullable Integer num4, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(alignPoints, "alignPoints");
        Intrinsics.checkParameterIsNotNull(faceIndex, "faceIndex");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.alignPoints = alignPoints;
        this.eTrackingOptions = bool2;
        this.faceIndex = faceIndex;
        this.genderBinding = str;
        this.isAllFrameFaceDetect = bool3;
        this.isRefine = bool4;
        this.isWaitFirstFrameDetect = bool5;
        this.type = str2;
        this.xAxisRotateTrack = bool6;
        this.xAxisScale = bool7;
        this.xAxisTrack = bool8;
        this.yAxisRotateTrack = bool9;
        this.yAxisScale = bool10;
        this.yAxisTrack = bool11;
        this.zAxisRotateTrack = bool12;
        this.scalePivotPoint1 = num3;
        this.scalePivotPoint2 = num4;
    }
}
