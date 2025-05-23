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

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u0097\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\u0002\u0010\u001fJ\u009d\u0002\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\tH\u0016R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Stretch;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Stretch$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "type", "", "version", "vFace", "", "thinFace", "cheekboneThin", "foreHead", "enlargeEye", "eyeDistance", "eyeAngle", "noseHeight", "noseSize", "noseWing", "mouthSize", "mouthHeight", "mouthWidth", "mouthPosition", "chin", "shortFace", "basicFace", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)V", "Ljava/lang/Float;", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Stretch;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Stretch extends AndroidMessage<Stretch, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Stretch> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Stretch> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 22)
    @JvmField
    @Nullable
    public final Float basicFace;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    @Nullable
    public final Float cheekboneThin;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 20)
    @JvmField
    @Nullable
    public final Float chin;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 10)
    @JvmField
    @Nullable
    public final Float enlargeEye;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 12)
    @JvmField
    @Nullable
    public final Float eyeAngle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    @Nullable
    public final Float eyeDistance;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    @JvmField
    @Nullable
    public final Float foreHead;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 17)
    @JvmField
    @Nullable
    public final Float mouthHeight;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 19)
    @JvmField
    @Nullable
    public final Float mouthPosition;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 16)
    @JvmField
    @Nullable
    public final Float mouthSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 18)
    @JvmField
    @Nullable
    public final Float mouthWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 13)
    @JvmField
    @Nullable
    public final Float noseHeight;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    @JvmField
    @Nullable
    public final Float noseSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 15)
    @JvmField
    @Nullable
    public final Float noseWing;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 21)
    @JvmField
    @Nullable
    public final Float shortFace;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    @Nullable
    public final Float thinFace;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float vFace;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010#J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010$J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010#J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010!J\u0015\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010#R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006%"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Stretch$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Stretch;", "()V", "basicFace", "", "Ljava/lang/Float;", "cheekboneThin", "chin", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", "enlargeEye", TemplateParser.KEY_ENTITY_ID, "eyeAngle", "eyeDistance", "foreHead", "mouthHeight", "mouthPosition", "mouthSize", "mouthWidth", "noseHeight", "noseSize", "noseWing", "shortFace", "thinFace", "type", "", "vFace", "version", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/Stretch$Builder;", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Stretch$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/Stretch$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Stretch, Builder> {

        @JvmField
        @Nullable
        public Float basicFace;

        @JvmField
        @Nullable
        public Float cheekboneThin;

        @JvmField
        @Nullable
        public Float chin;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Float enlargeEye;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Float eyeAngle;

        @JvmField
        @Nullable
        public Float eyeDistance;

        @JvmField
        @Nullable
        public Float foreHead;

        @JvmField
        @Nullable
        public Float mouthHeight;

        @JvmField
        @Nullable
        public Float mouthPosition;

        @JvmField
        @Nullable
        public Float mouthSize;

        @JvmField
        @Nullable
        public Float mouthWidth;

        @JvmField
        @Nullable
        public Float noseHeight;

        @JvmField
        @Nullable
        public Float noseSize;

        @JvmField
        @Nullable
        public Float noseWing;

        @JvmField
        @Nullable
        public Float shortFace;

        @JvmField
        @Nullable
        public Float thinFace;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Float vFace;

        @JvmField
        @Nullable
        public Integer version;

        @NotNull
        public final Builder basicFace(@Nullable Float basicFace) {
            this.basicFace = basicFace;
            return this;
        }

        @NotNull
        public final Builder cheekboneThin(@Nullable Float cheekboneThin) {
            this.cheekboneThin = cheekboneThin;
            return this;
        }

        @NotNull
        public final Builder chin(@Nullable Float chin) {
            this.chin = chin;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder enabled(@Nullable Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @NotNull
        public final Builder enlargeEye(@Nullable Float enlargeEye) {
            this.enlargeEye = enlargeEye;
            return this;
        }

        @NotNull
        public final Builder entityId(@Nullable Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        @NotNull
        public final Builder eyeAngle(@Nullable Float eyeAngle) {
            this.eyeAngle = eyeAngle;
            return this;
        }

        @NotNull
        public final Builder eyeDistance(@Nullable Float eyeDistance) {
            this.eyeDistance = eyeDistance;
            return this;
        }

        @NotNull
        public final Builder foreHead(@Nullable Float foreHead) {
            this.foreHead = foreHead;
            return this;
        }

        @NotNull
        public final Builder mouthHeight(@Nullable Float mouthHeight) {
            this.mouthHeight = mouthHeight;
            return this;
        }

        @NotNull
        public final Builder mouthPosition(@Nullable Float mouthPosition) {
            this.mouthPosition = mouthPosition;
            return this;
        }

        @NotNull
        public final Builder mouthSize(@Nullable Float mouthSize) {
            this.mouthSize = mouthSize;
            return this;
        }

        @NotNull
        public final Builder mouthWidth(@Nullable Float mouthWidth) {
            this.mouthWidth = mouthWidth;
            return this;
        }

        @NotNull
        public final Builder noseHeight(@Nullable Float noseHeight) {
            this.noseHeight = noseHeight;
            return this;
        }

        @NotNull
        public final Builder noseSize(@Nullable Float noseSize) {
            this.noseSize = noseSize;
            return this;
        }

        @NotNull
        public final Builder noseWing(@Nullable Float noseWing) {
            this.noseWing = noseWing;
            return this;
        }

        @NotNull
        public final Builder shortFace(@Nullable Float shortFace) {
            this.shortFace = shortFace;
            return this;
        }

        @NotNull
        public final Builder thinFace(@Nullable Float thinFace) {
            this.thinFace = thinFace;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder vFace(@Nullable Float vFace) {
            this.vFace = vFace;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable Integer version) {
            this.version = version;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Stretch build() {
            return new Stretch(this.componentID, this.enabled, this.entityId, this.type, this.version, this.vFace, this.thinFace, this.cheekboneThin, this.foreHead, this.enlargeEye, this.eyeDistance, this.eyeAngle, this.noseHeight, this.noseSize, this.noseWing, this.mouthSize, this.mouthHeight, this.mouthWidth, this.mouthPosition, this.chin, this.shortFace, this.basicFace, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Stretch.class);
        final String str = "type.googleapis.com/publisher.Stretch";
        ProtoAdapter<Stretch> protoAdapter = new ProtoAdapter<Stretch>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Stretch$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Stretch decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                String str2 = null;
                Integer num3 = null;
                Float f16 = null;
                Float f17 = null;
                Float f18 = null;
                Float f19 = null;
                Float f26 = null;
                Float f27 = null;
                Float f28 = null;
                Float f29 = null;
                Float f36 = null;
                Float f37 = null;
                Float f38 = null;
                Float f39 = null;
                Float f46 = null;
                Float f47 = null;
                Float f48 = null;
                Float f49 = null;
                Float f56 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Stretch(num, bool, num2, str2, num3, f16, f17, f18, f19, f26, f27, f28, f29, f36, f37, f38, f39, f46, f47, f48, f49, f56, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 7:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 8:
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 9:
                            f19 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 10:
                            f26 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 11:
                            f27 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 12:
                            f28 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 13:
                            f29 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 14:
                            f36 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 15:
                            f37 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 16:
                            f38 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 17:
                            f39 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 18:
                            f46 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 19:
                            f47 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 20:
                            f48 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 21:
                            f49 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 22:
                            f56 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Stretch value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                ProtoAdapter.STRING.encodeWithTag(writer, 4, value.type);
                protoAdapter2.encodeWithTag(writer, 5, value.version);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                protoAdapter3.encodeWithTag(writer, 6, value.vFace);
                protoAdapter3.encodeWithTag(writer, 7, value.thinFace);
                protoAdapter3.encodeWithTag(writer, 8, value.cheekboneThin);
                protoAdapter3.encodeWithTag(writer, 9, value.foreHead);
                protoAdapter3.encodeWithTag(writer, 10, value.enlargeEye);
                protoAdapter3.encodeWithTag(writer, 11, value.eyeDistance);
                protoAdapter3.encodeWithTag(writer, 12, value.eyeAngle);
                protoAdapter3.encodeWithTag(writer, 13, value.noseHeight);
                protoAdapter3.encodeWithTag(writer, 14, value.noseSize);
                protoAdapter3.encodeWithTag(writer, 15, value.noseWing);
                protoAdapter3.encodeWithTag(writer, 16, value.mouthSize);
                protoAdapter3.encodeWithTag(writer, 17, value.mouthHeight);
                protoAdapter3.encodeWithTag(writer, 18, value.mouthWidth);
                protoAdapter3.encodeWithTag(writer, 19, value.mouthPosition);
                protoAdapter3.encodeWithTag(writer, 20, value.chin);
                protoAdapter3.encodeWithTag(writer, 21, value.shortFace);
                protoAdapter3.encodeWithTag(writer, 22, value.basicFace);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Stretch value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.type) + protoAdapter2.encodedSizeWithTag(5, value.version);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(6, value.vFace) + protoAdapter3.encodedSizeWithTag(7, value.thinFace) + protoAdapter3.encodedSizeWithTag(8, value.cheekboneThin) + protoAdapter3.encodedSizeWithTag(9, value.foreHead) + protoAdapter3.encodedSizeWithTag(10, value.enlargeEye) + protoAdapter3.encodedSizeWithTag(11, value.eyeDistance) + protoAdapter3.encodedSizeWithTag(12, value.eyeAngle) + protoAdapter3.encodedSizeWithTag(13, value.noseHeight) + protoAdapter3.encodedSizeWithTag(14, value.noseSize) + protoAdapter3.encodedSizeWithTag(15, value.noseWing) + protoAdapter3.encodedSizeWithTag(16, value.mouthSize) + protoAdapter3.encodedSizeWithTag(17, value.mouthHeight) + protoAdapter3.encodedSizeWithTag(18, value.mouthWidth) + protoAdapter3.encodedSizeWithTag(19, value.mouthPosition) + protoAdapter3.encodedSizeWithTag(20, value.chin) + protoAdapter3.encodedSizeWithTag(21, value.shortFace) + protoAdapter3.encodedSizeWithTag(22, value.basicFace) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Stretch redact(@NotNull Stretch value) {
                Stretch copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r41 & 1) != 0 ? value.componentID : null, (r41 & 2) != 0 ? value.enabled : null, (r41 & 4) != 0 ? value.entityId : null, (r41 & 8) != 0 ? value.type : null, (r41 & 16) != 0 ? value.version : null, (r41 & 32) != 0 ? value.vFace : null, (r41 & 64) != 0 ? value.thinFace : null, (r41 & 128) != 0 ? value.cheekboneThin : null, (r41 & 256) != 0 ? value.foreHead : null, (r41 & 512) != 0 ? value.enlargeEye : null, (r41 & 1024) != 0 ? value.eyeDistance : null, (r41 & 2048) != 0 ? value.eyeAngle : null, (r41 & 4096) != 0 ? value.noseHeight : null, (r41 & 8192) != 0 ? value.noseSize : null, (r41 & 16384) != 0 ? value.noseWing : null, (r41 & 32768) != 0 ? value.mouthSize : null, (r41 & 65536) != 0 ? value.mouthHeight : null, (r41 & 131072) != 0 ? value.mouthWidth : null, (r41 & 262144) != 0 ? value.mouthPosition : null, (r41 & 524288) != 0 ? value.chin : null, (r41 & 1048576) != 0 ? value.shortFace : null, (r41 & 2097152) != 0 ? value.basicFace : null, (r41 & 4194304) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Stretch() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    @NotNull
    public final Stretch copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @Nullable String type, @Nullable Integer version, @Nullable Float vFace, @Nullable Float thinFace, @Nullable Float cheekboneThin, @Nullable Float foreHead, @Nullable Float enlargeEye, @Nullable Float eyeDistance, @Nullable Float eyeAngle, @Nullable Float noseHeight, @Nullable Float noseSize, @Nullable Float noseWing, @Nullable Float mouthSize, @Nullable Float mouthHeight, @Nullable Float mouthWidth, @Nullable Float mouthPosition, @Nullable Float chin, @Nullable Float shortFace, @Nullable Float basicFace, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Stretch(componentID, enabled, entityId, type, version, vFace, thinFace, cheekboneThin, foreHead, enlargeEye, eyeDistance, eyeAngle, noseHeight, noseSize, noseWing, mouthSize, mouthHeight, mouthWidth, mouthPosition, chin, shortFace, basicFace, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Stretch)) {
            return false;
        }
        Stretch stretch = (Stretch) other;
        if (Intrinsics.areEqual(unknownFields(), stretch.unknownFields()) && Intrinsics.areEqual(this.componentID, stretch.componentID) && Intrinsics.areEqual(this.enabled, stretch.enabled) && Intrinsics.areEqual(this.entityId, stretch.entityId) && Intrinsics.areEqual(this.type, stretch.type) && Intrinsics.areEqual(this.version, stretch.version) && Intrinsics.areEqual(this.vFace, stretch.vFace) && Intrinsics.areEqual(this.thinFace, stretch.thinFace) && Intrinsics.areEqual(this.cheekboneThin, stretch.cheekboneThin) && Intrinsics.areEqual(this.foreHead, stretch.foreHead) && Intrinsics.areEqual(this.enlargeEye, stretch.enlargeEye) && Intrinsics.areEqual(this.eyeDistance, stretch.eyeDistance) && Intrinsics.areEqual(this.eyeAngle, stretch.eyeAngle) && Intrinsics.areEqual(this.noseHeight, stretch.noseHeight) && Intrinsics.areEqual(this.noseSize, stretch.noseSize) && Intrinsics.areEqual(this.noseWing, stretch.noseWing) && Intrinsics.areEqual(this.mouthSize, stretch.mouthSize) && Intrinsics.areEqual(this.mouthHeight, stretch.mouthHeight) && Intrinsics.areEqual(this.mouthWidth, stretch.mouthWidth) && Intrinsics.areEqual(this.mouthPosition, stretch.mouthPosition) && Intrinsics.areEqual(this.chin, stretch.chin) && Intrinsics.areEqual(this.shortFace, stretch.shortFace) && Intrinsics.areEqual(this.basicFace, stretch.basicFace)) {
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
        int i65 = this.hashCode;
        if (i65 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.componentID;
            int i66 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i67 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i68 = (i67 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i69 = (i68 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i75 = (i69 + i18) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i19 = num3.hashCode();
            } else {
                i19 = 0;
            }
            int i76 = (i75 + i19) * 37;
            Float f16 = this.vFace;
            if (f16 != null) {
                i26 = f16.hashCode();
            } else {
                i26 = 0;
            }
            int i77 = (i76 + i26) * 37;
            Float f17 = this.thinFace;
            if (f17 != null) {
                i27 = f17.hashCode();
            } else {
                i27 = 0;
            }
            int i78 = (i77 + i27) * 37;
            Float f18 = this.cheekboneThin;
            if (f18 != null) {
                i28 = f18.hashCode();
            } else {
                i28 = 0;
            }
            int i79 = (i78 + i28) * 37;
            Float f19 = this.foreHead;
            if (f19 != null) {
                i29 = f19.hashCode();
            } else {
                i29 = 0;
            }
            int i85 = (i79 + i29) * 37;
            Float f26 = this.enlargeEye;
            if (f26 != null) {
                i36 = f26.hashCode();
            } else {
                i36 = 0;
            }
            int i86 = (i85 + i36) * 37;
            Float f27 = this.eyeDistance;
            if (f27 != null) {
                i37 = f27.hashCode();
            } else {
                i37 = 0;
            }
            int i87 = (i86 + i37) * 37;
            Float f28 = this.eyeAngle;
            if (f28 != null) {
                i38 = f28.hashCode();
            } else {
                i38 = 0;
            }
            int i88 = (i87 + i38) * 37;
            Float f29 = this.noseHeight;
            if (f29 != null) {
                i39 = f29.hashCode();
            } else {
                i39 = 0;
            }
            int i89 = (i88 + i39) * 37;
            Float f36 = this.noseSize;
            if (f36 != null) {
                i46 = f36.hashCode();
            } else {
                i46 = 0;
            }
            int i95 = (i89 + i46) * 37;
            Float f37 = this.noseWing;
            if (f37 != null) {
                i47 = f37.hashCode();
            } else {
                i47 = 0;
            }
            int i96 = (i95 + i47) * 37;
            Float f38 = this.mouthSize;
            if (f38 != null) {
                i48 = f38.hashCode();
            } else {
                i48 = 0;
            }
            int i97 = (i96 + i48) * 37;
            Float f39 = this.mouthHeight;
            if (f39 != null) {
                i49 = f39.hashCode();
            } else {
                i49 = 0;
            }
            int i98 = (i97 + i49) * 37;
            Float f46 = this.mouthWidth;
            if (f46 != null) {
                i56 = f46.hashCode();
            } else {
                i56 = 0;
            }
            int i99 = (i98 + i56) * 37;
            Float f47 = this.mouthPosition;
            if (f47 != null) {
                i57 = f47.hashCode();
            } else {
                i57 = 0;
            }
            int i100 = (i99 + i57) * 37;
            Float f48 = this.chin;
            if (f48 != null) {
                i58 = f48.hashCode();
            } else {
                i58 = 0;
            }
            int i101 = (i100 + i58) * 37;
            Float f49 = this.shortFace;
            if (f49 != null) {
                i59 = f49.hashCode();
            } else {
                i59 = 0;
            }
            int i102 = (i101 + i59) * 37;
            Float f56 = this.basicFace;
            if (f56 != null) {
                i66 = f56.hashCode();
            }
            int i103 = i102 + i66;
            this.hashCode = i103;
            return i103;
        }
        return i65;
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
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.vFace != null) {
            arrayList.add("vFace=" + this.vFace);
        }
        if (this.thinFace != null) {
            arrayList.add("thinFace=" + this.thinFace);
        }
        if (this.cheekboneThin != null) {
            arrayList.add("cheekboneThin=" + this.cheekboneThin);
        }
        if (this.foreHead != null) {
            arrayList.add("foreHead=" + this.foreHead);
        }
        if (this.enlargeEye != null) {
            arrayList.add("enlargeEye=" + this.enlargeEye);
        }
        if (this.eyeDistance != null) {
            arrayList.add("eyeDistance=" + this.eyeDistance);
        }
        if (this.eyeAngle != null) {
            arrayList.add("eyeAngle=" + this.eyeAngle);
        }
        if (this.noseHeight != null) {
            arrayList.add("noseHeight=" + this.noseHeight);
        }
        if (this.noseSize != null) {
            arrayList.add("noseSize=" + this.noseSize);
        }
        if (this.noseWing != null) {
            arrayList.add("noseWing=" + this.noseWing);
        }
        if (this.mouthSize != null) {
            arrayList.add("mouthSize=" + this.mouthSize);
        }
        if (this.mouthHeight != null) {
            arrayList.add("mouthHeight=" + this.mouthHeight);
        }
        if (this.mouthWidth != null) {
            arrayList.add("mouthWidth=" + this.mouthWidth);
        }
        if (this.mouthPosition != null) {
            arrayList.add("mouthPosition=" + this.mouthPosition);
        }
        if (this.chin != null) {
            arrayList.add("chin=" + this.chin);
        }
        if (this.shortFace != null) {
            arrayList.add("shortFace=" + this.shortFace);
        }
        if (this.basicFace != null) {
            arrayList.add("basicFace=" + this.basicFace);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Stretch{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Stretch(Integer num, Boolean bool, Integer num2, String str, Integer num3, Float f16, Float f17, Float f18, Float f19, Float f26, Float f27, Float f28, Float f29, Float f36, Float f37, Float f38, Float f39, Float f46, Float f47, Float f48, Float f49, Float f56, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : f16, (i3 & 64) != 0 ? null : f17, (i3 & 128) != 0 ? null : f18, (i3 & 256) != 0 ? null : f19, (i3 & 512) != 0 ? null : f26, (i3 & 1024) != 0 ? null : f27, (i3 & 2048) != 0 ? null : f28, (i3 & 4096) != 0 ? null : f29, (i3 & 8192) != 0 ? null : f36, (i3 & 16384) != 0 ? null : f37, (i3 & 32768) != 0 ? null : f38, (i3 & 65536) != 0 ? null : f39, (i3 & 131072) != 0 ? null : f46, (i3 & 262144) != 0 ? null : f47, (i3 & 524288) != 0 ? null : f48, (i3 & 1048576) != 0 ? null : f49, (i3 & 2097152) != 0 ? null : f56, (i3 & 4194304) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.type = this.type;
        builder.version = this.version;
        builder.vFace = this.vFace;
        builder.thinFace = this.thinFace;
        builder.cheekboneThin = this.cheekboneThin;
        builder.foreHead = this.foreHead;
        builder.enlargeEye = this.enlargeEye;
        builder.eyeDistance = this.eyeDistance;
        builder.eyeAngle = this.eyeAngle;
        builder.noseHeight = this.noseHeight;
        builder.noseSize = this.noseSize;
        builder.noseWing = this.noseWing;
        builder.mouthSize = this.mouthSize;
        builder.mouthHeight = this.mouthHeight;
        builder.mouthWidth = this.mouthWidth;
        builder.mouthPosition = this.mouthPosition;
        builder.chin = this.chin;
        builder.shortFace = this.shortFace;
        builder.basicFace = this.basicFace;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Stretch(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable Float f16, @Nullable Float f17, @Nullable Float f18, @Nullable Float f19, @Nullable Float f26, @Nullable Float f27, @Nullable Float f28, @Nullable Float f29, @Nullable Float f36, @Nullable Float f37, @Nullable Float f38, @Nullable Float f39, @Nullable Float f46, @Nullable Float f47, @Nullable Float f48, @Nullable Float f49, @Nullable Float f56, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.type = str;
        this.version = num3;
        this.vFace = f16;
        this.thinFace = f17;
        this.cheekboneThin = f18;
        this.foreHead = f19;
        this.enlargeEye = f26;
        this.eyeDistance = f27;
        this.eyeAngle = f28;
        this.noseHeight = f29;
        this.noseSize = f36;
        this.noseWing = f37;
        this.mouthSize = f38;
        this.mouthHeight = f39;
        this.mouthWidth = f46;
        this.mouthPosition = f47;
        this.chin = f48;
        this.shortFace = f49;
        this.basicFace = f56;
    }
}
