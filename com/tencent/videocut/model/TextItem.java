package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u00e9\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u00f9\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010\u0017\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0014\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/videocut/model/TextItem;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TextItem$Builder;", "text", "", "textColor", "fontPath", "strokeColor", "strokeWidth", "", NodeProps.SHADOW_COLOR, NodeProps.SHADOW_OPACITY, "opacity", "index", "", "fauxBold", "", "fauxItalic", "fontFamily", "applyStroke", "leading", "tracking", "backgroundColor", "backgroundAlpha", "layerSize", "Lcom/tencent/videocut/model/Size;", "fontStyle", "justification", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;ILcom/tencent/videocut/model/Size;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "Ljava/lang/Float;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/videocut/model/Size;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/TextItem;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TextItem extends AndroidMessage<TextItem, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<TextItem> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TextItem> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    @JvmField
    @Nullable
    public final Integer justification;

    @WireField(adapter = "com.tencent.videocut.model.Size#ADAPTER", tag = 18)
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
    public String text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String textColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 15)
    @JvmField
    @Nullable
    public final Float tracking;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010!J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\"\u001a\u00020\u0002H\u0016J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010 J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010 J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010!J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010#R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/tencent/videocut/model/TextItem$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TextItem;", "()V", "applyStroke", "", "Ljava/lang/Boolean;", "backgroundAlpha", "", "backgroundColor", "", "fauxBold", "fauxItalic", "fontFamily", "fontPath", "fontStyle", "index", "justification", "Ljava/lang/Integer;", "layerSize", "Lcom/tencent/videocut/model/Size;", "leading", "", "Ljava/lang/Float;", "opacity", NodeProps.SHADOW_COLOR, NodeProps.SHADOW_OPACITY, "strokeColor", "strokeWidth", "text", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/TextItem$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/TextItem$Builder;", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/TextItem$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<TextItem, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public Boolean applyStroke;

        @JvmField
        public int backgroundAlpha;

        @JvmField
        @NotNull
        public String backgroundColor;

        @JvmField
        @Nullable
        public Boolean fauxBold;

        @JvmField
        @Nullable
        public Boolean fauxItalic;

        @JvmField
        @NotNull
        public String fontFamily;

        @JvmField
        @NotNull
        public String fontPath;

        @JvmField
        @NotNull
        public String fontStyle;

        @JvmField
        public int index;

        @JvmField
        @Nullable
        public Integer justification;

        @JvmField
        @Nullable
        public Size layerSize;

        @JvmField
        @Nullable
        public Float leading;

        @JvmField
        @Nullable
        public Float opacity;

        @JvmField
        @NotNull
        public String shadowColor;

        @JvmField
        @Nullable
        public Float shadowOpacity;

        @JvmField
        @NotNull
        public String strokeColor;

        @JvmField
        public float strokeWidth;

        @JvmField
        @NotNull
        public String text;

        @JvmField
        @NotNull
        public String textColor;

        @JvmField
        @Nullable
        public Float tracking;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.text = "";
            this.textColor = "";
            this.fontPath = "";
            this.strokeColor = "";
            this.shadowColor = "";
            this.fontFamily = "";
            this.backgroundColor = "";
            this.fontStyle = "";
        }

        @NotNull
        public final Builder applyStroke(@Nullable Boolean applyStroke) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) applyStroke);
            }
            this.applyStroke = applyStroke;
            return this;
        }

        @NotNull
        public final Builder backgroundAlpha(@Nullable Integer backgroundAlpha) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) backgroundAlpha);
            }
            if (backgroundAlpha != null) {
                i3 = backgroundAlpha.intValue();
            } else {
                i3 = 0;
            }
            this.backgroundAlpha = i3;
            return this;
        }

        @NotNull
        public final Builder backgroundColor(@Nullable String backgroundColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) backgroundColor);
            }
            if (backgroundColor == null) {
                backgroundColor = "";
            }
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder fauxBold(@Nullable Boolean fauxBold) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) fauxBold);
            }
            this.fauxBold = fauxBold;
            return this;
        }

        @NotNull
        public final Builder fauxItalic(@Nullable Boolean fauxItalic) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) fauxItalic);
            }
            this.fauxItalic = fauxItalic;
            return this;
        }

        @NotNull
        public final Builder fontFamily(@Nullable String fontFamily) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) fontFamily);
            }
            if (fontFamily == null) {
                fontFamily = "";
            }
            this.fontFamily = fontFamily;
            return this;
        }

        @NotNull
        public final Builder fontPath(@Nullable String fontPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fontPath);
            }
            if (fontPath == null) {
                fontPath = "";
            }
            this.fontPath = fontPath;
            return this;
        }

        @NotNull
        public final Builder fontStyle(@Nullable String fontStyle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) fontStyle);
            }
            if (fontStyle == null) {
                fontStyle = "";
            }
            this.fontStyle = fontStyle;
            return this;
        }

        @NotNull
        public final Builder index(@Nullable Integer index) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) index);
            }
            if (index != null) {
                i3 = index.intValue();
            } else {
                i3 = 0;
            }
            this.index = i3;
            return this;
        }

        @NotNull
        public final Builder justification(@Nullable Integer justification) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) justification);
            }
            this.justification = justification;
            return this;
        }

        @NotNull
        public final Builder layerSize(@Nullable Size layerSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) layerSize);
            }
            this.layerSize = layerSize;
            return this;
        }

        @NotNull
        public final Builder leading(@Nullable Float leading) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) leading);
            }
            this.leading = leading;
            return this;
        }

        @NotNull
        public final Builder opacity(@Nullable Float opacity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) opacity);
            }
            this.opacity = opacity;
            return this;
        }

        @NotNull
        public final Builder shadowColor(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            if (str == null) {
                str = "";
            }
            this.shadowColor = str;
            return this;
        }

        @NotNull
        public final Builder shadowOpacity(@Nullable Float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) f16);
            }
            this.shadowOpacity = f16;
            return this;
        }

        @NotNull
        public final Builder strokeColor(@Nullable String strokeColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) strokeColor);
            }
            if (strokeColor == null) {
                strokeColor = "";
            }
            this.strokeColor = strokeColor;
            return this;
        }

        @NotNull
        public final Builder strokeWidth(@Nullable Float strokeWidth) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) strokeWidth);
            }
            if (strokeWidth != null) {
                f16 = strokeWidth.floatValue();
            } else {
                f16 = 0.0f;
            }
            this.strokeWidth = f16;
            return this;
        }

        @NotNull
        public final Builder text(@Nullable String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) text);
            }
            if (text == null) {
                text = "";
            }
            this.text = text;
            return this;
        }

        @NotNull
        public final Builder textColor(@Nullable String textColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) textColor);
            }
            if (textColor == null) {
                textColor = "";
            }
            this.textColor = textColor;
            return this;
        }

        @NotNull
        public final Builder tracking(@Nullable Float tracking) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) tracking);
            }
            this.tracking = tracking;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TextItem build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? new TextItem(this.text, this.textColor, this.fontPath, this.strokeColor, this.strokeWidth, this.shadowColor, this.shadowOpacity, this.opacity, this.index, this.fauxBold, this.fauxItalic, this.fontFamily, this.applyStroke, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, this.layerSize, this.fontStyle, this.justification, buildUnknownFields()) : (TextItem) iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TextItem$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TextItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ProtoAdapter<TextItem> protoAdapter = new ProtoAdapter<TextItem>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextItem.class)) { // from class: com.tencent.videocut.model.TextItem$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(r4, r5, "type.googleapis.com/publisher.TextItem");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextItem decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (TextItem) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                Integer num = 1;
                long beginMessage = reader.beginMessage();
                String str = "";
                int i3 = 0;
                int i16 = 0;
                Float f16 = null;
                Float f17 = null;
                Boolean bool = null;
                Boolean bool2 = null;
                Boolean bool3 = null;
                Float f18 = null;
                Float f19 = null;
                Size size = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                float f26 = 0.0f;
                String str8 = str7;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str8 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 4:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 5:
                                f26 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 6:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 7:
                                f16 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 8:
                                f17 = ProtoAdapter.FLOAT.decode(reader);
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
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 13:
                                bool3 = ProtoAdapter.BOOL.decode(reader);
                                break;
                            case 14:
                                f18 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 15:
                                f19 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 16:
                                str6 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 17:
                                i16 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 18:
                                size = Size.ADAPTER.decode(reader);
                                break;
                            case 19:
                                str7 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 20:
                                num = ProtoAdapter.INT32.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new TextItem(str, str8, str2, str3, f26, str4, f16, f17, i3, bool, bool2, str5, bool3, f18, f19, str6, i16, size, str7, num, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TextItem value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.text);
                protoAdapter2.encodeWithTag(writer, 2, value.textColor);
                protoAdapter2.encodeWithTag(writer, 3, value.fontPath);
                protoAdapter2.encodeWithTag(writer, 4, value.strokeColor);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                protoAdapter3.encodeWithTag(writer, 5, Float.valueOf(value.strokeWidth));
                protoAdapter2.encodeWithTag(writer, 6, value.shadowColor);
                protoAdapter3.encodeWithTag(writer, 7, value.shadowOpacity);
                protoAdapter3.encodeWithTag(writer, 8, value.opacity);
                ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
                protoAdapter4.encodeWithTag(writer, 9, Integer.valueOf(value.index));
                ProtoAdapter<Boolean> protoAdapter5 = ProtoAdapter.BOOL;
                protoAdapter5.encodeWithTag(writer, 10, value.fauxBold);
                protoAdapter5.encodeWithTag(writer, 11, value.fauxItalic);
                protoAdapter2.encodeWithTag(writer, 12, value.fontFamily);
                protoAdapter5.encodeWithTag(writer, 13, value.applyStroke);
                protoAdapter3.encodeWithTag(writer, 14, value.leading);
                protoAdapter3.encodeWithTag(writer, 15, value.tracking);
                protoAdapter2.encodeWithTag(writer, 16, value.backgroundColor);
                protoAdapter4.encodeWithTag(writer, 17, Integer.valueOf(value.backgroundAlpha));
                Size.ADAPTER.encodeWithTag(writer, 18, value.layerSize);
                protoAdapter2.encodeWithTag(writer, 19, value.fontStyle);
                protoAdapter4.encodeWithTag(writer, 20, value.justification);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TextItem value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.text) + protoAdapter2.encodedSizeWithTag(2, value.textColor) + protoAdapter2.encodedSizeWithTag(3, value.fontPath) + protoAdapter2.encodedSizeWithTag(4, value.strokeColor);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(5, Float.valueOf(value.strokeWidth)) + protoAdapter2.encodedSizeWithTag(6, value.shadowColor) + protoAdapter3.encodedSizeWithTag(7, value.shadowOpacity) + protoAdapter3.encodedSizeWithTag(8, value.opacity);
                ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(9, Integer.valueOf(value.index));
                ProtoAdapter<Boolean> protoAdapter5 = ProtoAdapter.BOOL;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(10, value.fauxBold) + protoAdapter5.encodedSizeWithTag(11, value.fauxItalic) + protoAdapter2.encodedSizeWithTag(12, value.fontFamily) + protoAdapter5.encodedSizeWithTag(13, value.applyStroke) + protoAdapter3.encodedSizeWithTag(14, value.leading) + protoAdapter3.encodedSizeWithTag(15, value.tracking) + protoAdapter2.encodedSizeWithTag(16, value.backgroundColor) + protoAdapter4.encodedSizeWithTag(17, Integer.valueOf(value.backgroundAlpha)) + Size.ADAPTER.encodedSizeWithTag(18, value.layerSize) + protoAdapter2.encodedSizeWithTag(19, value.fontStyle) + protoAdapter4.encodedSizeWithTag(20, value.justification) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextItem redact(@NotNull TextItem value) {
                TextItem copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (TextItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                Size size = value.layerSize;
                copy = value.copy((r38 & 1) != 0 ? value.text : null, (r38 & 2) != 0 ? value.textColor : null, (r38 & 4) != 0 ? value.fontPath : null, (r38 & 8) != 0 ? value.strokeColor : null, (r38 & 16) != 0 ? Float.valueOf(value.strokeWidth) : null, (r38 & 32) != 0 ? value.shadowColor : null, (r38 & 64) != 0 ? value.shadowOpacity : null, (r38 & 128) != 0 ? value.opacity : null, (r38 & 256) != 0 ? Integer.valueOf(value.index) : null, (r38 & 512) != 0 ? value.fauxBold : null, (r38 & 1024) != 0 ? value.fauxItalic : null, (r38 & 2048) != 0 ? value.fontFamily : null, (r38 & 4096) != 0 ? value.applyStroke : null, (r38 & 8192) != 0 ? value.leading : null, (r38 & 16384) != 0 ? value.tracking : null, (r38 & 32768) != 0 ? value.backgroundColor : null, (r38 & 65536) != 0 ? Integer.valueOf(value.backgroundAlpha) : null, (r38 & 131072) != 0 ? value.layerSize : size != null ? Size.ADAPTER.redact(size) : null, (r38 & 262144) != 0 ? value.fontStyle : null, (r38 & 524288) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TextItem() {
        this(null, null, null, null, 0.0f, null, null, null, 0, null, null, null, null, null, null, null, 0, null, null, null, null, 2097151, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final TextItem copy(@Nullable String text, @Nullable String textColor, @Nullable String fontPath, @Nullable String strokeColor, @Nullable Float strokeWidth, @Nullable String r302, @Nullable Float r312, @Nullable Float opacity, @Nullable Integer index, @Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable String fontFamily, @Nullable Boolean applyStroke, @Nullable Float leading, @Nullable Float tracking, @Nullable String backgroundColor, @Nullable Integer backgroundAlpha, @Nullable Size layerSize, @Nullable String fontStyle, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextItem) iPatchRedirector.redirect((short) 7, this, text, textColor, fontPath, strokeColor, strokeWidth, r302, r312, opacity, index, fauxBold, fauxItalic, fontFamily, applyStroke, leading, tracking, backgroundColor, backgroundAlpha, layerSize, fontStyle, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new TextItem(text == null ? "" : text, textColor == null ? "" : textColor, fontPath == null ? "" : fontPath, strokeColor == null ? "" : strokeColor, strokeWidth != null ? strokeWidth.floatValue() : 0.0f, r302 == null ? "" : r302, r312, opacity, index != null ? index.intValue() : 0, fauxBold, fauxItalic, fontFamily == null ? "" : fontFamily, applyStroke, leading, tracking, backgroundColor == null ? "" : backgroundColor, backgroundAlpha != null ? backgroundAlpha.intValue() : 0, layerSize, fontStyle == null ? "" : fontStyle, this.justification, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
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
            if (z16 && Intrinsics.areEqual(this.shadowColor, textItem.shadowColor) && Intrinsics.areEqual(this.shadowOpacity, textItem.shadowOpacity) && Intrinsics.areEqual(this.opacity, textItem.opacity) && this.index == textItem.index && Intrinsics.areEqual(this.fauxBold, textItem.fauxBold) && Intrinsics.areEqual(this.fauxItalic, textItem.fauxItalic) && Intrinsics.areEqual(this.fontFamily, textItem.fontFamily) && Intrinsics.areEqual(this.applyStroke, textItem.applyStroke) && Intrinsics.areEqual(this.leading, textItem.leading) && Intrinsics.areEqual(this.tracking, textItem.tracking) && Intrinsics.areEqual(this.backgroundColor, textItem.backgroundColor) && this.backgroundAlpha == textItem.backgroundAlpha && Intrinsics.areEqual(this.layerSize, textItem.layerSize) && Intrinsics.areEqual(this.fontStyle, textItem.fontStyle) && Intrinsics.areEqual(this.justification, textItem.justification)) {
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
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i29 = this.hashCode;
        if (i29 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + this.text.hashCode()) * 37) + this.textColor.hashCode()) * 37) + this.fontPath.hashCode()) * 37) + this.strokeColor.hashCode()) * 37) + Float.floatToIntBits(this.strokeWidth)) * 37) + this.shadowColor.hashCode()) * 37;
            Float f16 = this.shadowOpacity;
            int i36 = 0;
            if (f16 != null) {
                i3 = f16.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            Float f17 = this.opacity;
            if (f17 != null) {
                i16 = f17.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (((i37 + i16) * 37) + this.index) * 37;
            Boolean bool = this.fauxBold;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i39 = (i38 + i17) * 37;
            Boolean bool2 = this.fauxItalic;
            if (bool2 != null) {
                i18 = bool2.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i39 + i18) * 37) + this.fontFamily.hashCode()) * 37;
            Boolean bool3 = this.applyStroke;
            if (bool3 != null) {
                i19 = bool3.hashCode();
            } else {
                i19 = 0;
            }
            int i46 = (hashCode2 + i19) * 37;
            Float f18 = this.leading;
            if (f18 != null) {
                i26 = f18.hashCode();
            } else {
                i26 = 0;
            }
            int i47 = (i46 + i26) * 37;
            Float f19 = this.tracking;
            if (f19 != null) {
                i27 = f19.hashCode();
            } else {
                i27 = 0;
            }
            int hashCode3 = (((((i47 + i27) * 37) + this.backgroundColor.hashCode()) * 37) + this.backgroundAlpha) * 37;
            Size size = this.layerSize;
            if (size != null) {
                i28 = size.hashCode();
            } else {
                i28 = 0;
            }
            int hashCode4 = (((hashCode3 + i28) * 37) + this.fontStyle.hashCode()) * 37;
            Integer num = this.justification;
            if (num != null) {
                i36 = num.hashCode();
            }
            int i48 = hashCode4 + i36;
            this.hashCode = i48;
            return i48;
        }
        return i29;
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

    public /* synthetic */ TextItem(String str, String str2, String str3, String str4, float f16, String str5, Float f17, Float f18, int i3, Boolean bool, Boolean bool2, String str6, Boolean bool3, Float f19, Float f26, String str7, int i16, Size size, String str8, Integer num, ByteString byteString, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) != 0 ? 0.0f : f16, (i17 & 32) != 0 ? "" : str5, (i17 & 64) != 0 ? null : f17, (i17 & 128) != 0 ? null : f18, (i17 & 256) != 0 ? 0 : i3, (i17 & 512) != 0 ? null : bool, (i17 & 1024) != 0 ? null : bool2, (i17 & 2048) != 0 ? "" : str6, (i17 & 4096) != 0 ? null : bool3, (i17 & 8192) != 0 ? null : f19, (i17 & 16384) != 0 ? null : f26, (32768 & i17) != 0 ? "" : str7, (65536 & i17) != 0 ? 0 : i16, (131072 & i17) != 0 ? null : size, (262144 & i17) != 0 ? "" : str8, (524288 & i17) != 0 ? 1 : num, (1048576 & i17) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Float.valueOf(f16), str5, f17, f18, Integer.valueOf(i3), bool, bool2, str6, bool3, f19, f26, str7, Integer.valueOf(i16), size, str8, num, byteString, Integer.valueOf(i17), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.text = this.text;
        builder.textColor = this.textColor;
        builder.fontPath = this.fontPath;
        builder.strokeColor = this.strokeColor;
        builder.strokeWidth = this.strokeWidth;
        builder.shadowColor = this.shadowColor;
        builder.shadowOpacity = this.shadowOpacity;
        builder.opacity = this.opacity;
        builder.index = this.index;
        builder.fauxBold = this.fauxBold;
        builder.fauxItalic = this.fauxItalic;
        builder.fontFamily = this.fontFamily;
        builder.applyStroke = this.applyStroke;
        builder.leading = this.leading;
        builder.tracking = this.tracking;
        builder.backgroundColor = this.backgroundColor;
        builder.backgroundAlpha = this.backgroundAlpha;
        builder.layerSize = this.layerSize;
        builder.fontStyle = this.fontStyle;
        builder.justification = this.justification;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextItem(@NotNull String text, @NotNull String textColor, @NotNull String fontPath, @NotNull String strokeColor, float f16, @NotNull String shadowColor, @Nullable Float f17, @Nullable Float f18, int i3, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull String fontFamily, @Nullable Boolean bool3, @Nullable Float f19, @Nullable Float f26, @NotNull String backgroundColor, int i16, @Nullable Size size, @NotNull String fontStyle, @Nullable Integer num, @NotNull ByteString unknownFields) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, text, textColor, fontPath, strokeColor, Float.valueOf(f16), shadowColor, f17, f18, Integer.valueOf(i3), bool, bool2, fontFamily, bool3, f19, f26, backgroundColor, Integer.valueOf(i16), size, fontStyle, num, unknownFields);
            return;
        }
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
        this.justification = num;
    }
}
