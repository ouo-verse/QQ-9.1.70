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
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u00db\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ\u00e1\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "offset", "pivot", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "ePinToEdge", "eFixSize", "eEditingMode", "eKeepRatio", "position", "Lcom/tencent/tavcut/composition/model/component/Vec3;", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/tavcut/composition/model/component/Quat;", "scale", "euler", "objectEnabled", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Vec2;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Quat;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Vec3;Ljava/lang/Boolean;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/Vec2;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Quat;Lcom/tencent/tavcut/composition/model/component/Vec3;Lcom/tencent/tavcut/composition/model/component/Vec3;Ljava/lang/Boolean;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ScreenTransform extends AndroidMessage<ScreenTransform, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<ScreenTransform> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ScreenTransform> CREATOR;
    public static final int DEFAULT_COMPONENTID = 0;
    public static final int DEFAULT_ENTITYID = 0;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag = 5)
    @JvmField
    @Nullable
    public final Rect anchor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer eEditingMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer eFixSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    @JvmField
    @Nullable
    public final Boolean eKeepRatio;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    @Nullable
    public final Integer ePinToEdge;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag = 15)
    @JvmField
    @Nullable
    public final Vec3 euler;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    @JvmField
    @Nullable
    public final Boolean objectEnabled;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag = 6)
    @JvmField
    @Nullable
    public final Rect offset;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Vec2#ADAPTER", tag = 7)
    @JvmField
    @Nullable
    public final Vec2 pivot;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag = 12)
    @JvmField
    @Nullable
    public final Vec3 position;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Quat#ADAPTER", tag = 13)
    @JvmField
    @Nullable
    public final Quat rotation;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Vec3#ADAPTER", tag = 14)
    @JvmField
    @Nullable
    public final Vec3 scale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010 J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010 J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010 J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001fR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006!"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "()V", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", "eEditingMode", "eFixSize", "eKeepRatio", "", "Ljava/lang/Boolean;", "ePinToEdge", NodeProps.ENABLED, TemplateParser.KEY_ENTITY_ID, "euler", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "objectEnabled", "offset", "pivot", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "position", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/tavcut/composition/model/component/Quat;", "scale", "type", "", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<ScreenTransform, Builder> {

        @JvmField
        @Nullable
        public Rect anchor;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Integer eEditingMode;

        @JvmField
        @Nullable
        public Integer eFixSize;

        @JvmField
        @Nullable
        public Boolean eKeepRatio;

        @JvmField
        @Nullable
        public Integer ePinToEdge;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Vec3 euler;

        @JvmField
        @Nullable
        public Boolean objectEnabled;

        @JvmField
        @Nullable
        public Rect offset;

        @JvmField
        @Nullable
        public Vec2 pivot;

        @JvmField
        @Nullable
        public Vec3 position;

        @JvmField
        @Nullable
        public Quat rotation;

        @JvmField
        @Nullable
        public Vec3 scale;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        @NotNull
        public final Builder anchor(@Nullable Rect anchor) {
            this.anchor = anchor;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder eEditingMode(@Nullable Integer eEditingMode) {
            this.eEditingMode = eEditingMode;
            return this;
        }

        @NotNull
        public final Builder eFixSize(@Nullable Integer eFixSize) {
            this.eFixSize = eFixSize;
            return this;
        }

        @NotNull
        public final Builder eKeepRatio(@Nullable Boolean eKeepRatio) {
            this.eKeepRatio = eKeepRatio;
            return this;
        }

        @NotNull
        public final Builder ePinToEdge(@Nullable Integer ePinToEdge) {
            this.ePinToEdge = ePinToEdge;
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
        public final Builder euler(@Nullable Vec3 euler) {
            this.euler = euler;
            return this;
        }

        @NotNull
        public final Builder objectEnabled(@Nullable Boolean objectEnabled) {
            this.objectEnabled = objectEnabled;
            return this;
        }

        @NotNull
        public final Builder offset(@Nullable Rect offset) {
            this.offset = offset;
            return this;
        }

        @NotNull
        public final Builder pivot(@Nullable Vec2 pivot) {
            this.pivot = pivot;
            return this;
        }

        @NotNull
        public final Builder position(@Nullable Vec3 position) {
            this.position = position;
            return this;
        }

        @NotNull
        public final Builder rotation(@Nullable Quat rotation) {
            this.rotation = rotation;
            return this;
        }

        @NotNull
        public final Builder scale(@Nullable Vec3 scale) {
            this.scale = scale;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable Integer version) {
            this.version = version;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ScreenTransform build() {
            return new ScreenTransform(this.entityId, this.componentID, this.enabled, this.type, this.anchor, this.offset, this.pivot, this.ePinToEdge, this.eFixSize, this.eEditingMode, this.eKeepRatio, this.position, this.rotation, this.scale, this.euler, this.objectEnabled, this.version, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ScreenTransform.class);
        final String str = "type.googleapis.com/publisher.ScreenTransform";
        ProtoAdapter<ScreenTransform> protoAdapter = new ProtoAdapter<ScreenTransform>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.ScreenTransform$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ScreenTransform decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Rect rect = null;
                Rect rect2 = null;
                Vec2 vec2 = null;
                Integer num3 = null;
                Integer num4 = null;
                Integer num5 = null;
                Boolean bool2 = null;
                Vec3 vec3 = null;
                Quat quat = null;
                Vec3 vec32 = null;
                Vec3 vec33 = null;
                Boolean bool3 = null;
                Integer num6 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new ScreenTransform(num, num2, bool, str2, rect, rect2, vec2, num3, num4, num5, bool2, vec3, quat, vec32, vec33, bool3, num6, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 3:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            rect = Rect.ADAPTER.decode(reader);
                            break;
                        case 6:
                            rect2 = Rect.ADAPTER.decode(reader);
                            break;
                        case 7:
                            vec2 = Vec2.ADAPTER.decode(reader);
                            break;
                        case 8:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 9:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 10:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 11:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 12:
                            vec3 = Vec3.ADAPTER.decode(reader);
                            break;
                        case 13:
                            quat = Quat.ADAPTER.decode(reader);
                            break;
                        case 14:
                            vec32 = Vec3.ADAPTER.decode(reader);
                            break;
                        case 15:
                            vec33 = Vec3.ADAPTER.decode(reader);
                            break;
                        case 16:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 17:
                            num6 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ScreenTransform value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                protoAdapter3.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter.STRING.encodeWithTag(writer, 4, value.type);
                ProtoAdapter<Rect> protoAdapter4 = Rect.ADAPTER;
                protoAdapter4.encodeWithTag(writer, 5, value.anchor);
                protoAdapter4.encodeWithTag(writer, 6, value.offset);
                Vec2.ADAPTER.encodeWithTag(writer, 7, value.pivot);
                protoAdapter2.encodeWithTag(writer, 8, value.ePinToEdge);
                protoAdapter2.encodeWithTag(writer, 9, value.eFixSize);
                protoAdapter2.encodeWithTag(writer, 10, value.eEditingMode);
                protoAdapter3.encodeWithTag(writer, 11, value.eKeepRatio);
                ProtoAdapter<Vec3> protoAdapter5 = Vec3.ADAPTER;
                protoAdapter5.encodeWithTag(writer, 12, value.position);
                Quat.ADAPTER.encodeWithTag(writer, 13, value.rotation);
                protoAdapter5.encodeWithTag(writer, 14, value.scale);
                protoAdapter5.encodeWithTag(writer, 15, value.euler);
                protoAdapter3.encodeWithTag(writer, 16, value.objectEnabled);
                protoAdapter2.encodeWithTag(writer, 17, value.version);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ScreenTransform value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, value.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.type);
                ProtoAdapter<Rect> protoAdapter4 = Rect.ADAPTER;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(5, value.anchor) + protoAdapter4.encodedSizeWithTag(6, value.offset) + Vec2.ADAPTER.encodedSizeWithTag(7, value.pivot) + protoAdapter2.encodedSizeWithTag(8, value.ePinToEdge) + protoAdapter2.encodedSizeWithTag(9, value.eFixSize) + protoAdapter2.encodedSizeWithTag(10, value.eEditingMode) + protoAdapter3.encodedSizeWithTag(11, value.eKeepRatio);
                ProtoAdapter<Vec3> protoAdapter5 = Vec3.ADAPTER;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(12, value.position) + Quat.ADAPTER.encodedSizeWithTag(13, value.rotation) + protoAdapter5.encodedSizeWithTag(14, value.scale) + protoAdapter5.encodedSizeWithTag(15, value.euler) + protoAdapter3.encodedSizeWithTag(16, value.objectEnabled) + protoAdapter2.encodedSizeWithTag(17, value.version) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ScreenTransform redact(@NotNull ScreenTransform value) {
                ScreenTransform copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                Rect rect = value.anchor;
                Rect redact = rect != null ? Rect.ADAPTER.redact(rect) : null;
                Rect rect2 = value.offset;
                Rect redact2 = rect2 != null ? Rect.ADAPTER.redact(rect2) : null;
                Vec2 vec2 = value.pivot;
                Vec2 redact3 = vec2 != null ? Vec2.ADAPTER.redact(vec2) : null;
                Vec3 vec3 = value.position;
                Vec3 redact4 = vec3 != null ? Vec3.ADAPTER.redact(vec3) : null;
                Quat quat = value.rotation;
                Quat redact5 = quat != null ? Quat.ADAPTER.redact(quat) : null;
                Vec3 vec32 = value.scale;
                Vec3 redact6 = vec32 != null ? Vec3.ADAPTER.redact(vec32) : null;
                Vec3 vec33 = value.euler;
                copy = value.copy((r36 & 1) != 0 ? value.entityId : null, (r36 & 2) != 0 ? value.componentID : null, (r36 & 4) != 0 ? value.enabled : null, (r36 & 8) != 0 ? value.type : null, (r36 & 16) != 0 ? value.anchor : redact, (r36 & 32) != 0 ? value.offset : redact2, (r36 & 64) != 0 ? value.pivot : redact3, (r36 & 128) != 0 ? value.ePinToEdge : null, (r36 & 256) != 0 ? value.eFixSize : null, (r36 & 512) != 0 ? value.eEditingMode : null, (r36 & 1024) != 0 ? value.eKeepRatio : null, (r36 & 2048) != 0 ? value.position : redact4, (r36 & 4096) != 0 ? value.rotation : redact5, (r36 & 8192) != 0 ? value.scale : redact6, (r36 & 16384) != 0 ? value.euler : vec33 != null ? Vec3.ADAPTER.redact(vec33) : null, (r36 & 32768) != 0 ? value.objectEnabled : null, (r36 & 65536) != 0 ? value.version : null, (r36 & 131072) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public ScreenTransform() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    @NotNull
    public final ScreenTransform copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Rect anchor, @Nullable Rect offset, @Nullable Vec2 pivot, @Nullable Integer ePinToEdge, @Nullable Integer eFixSize, @Nullable Integer eEditingMode, @Nullable Boolean eKeepRatio, @Nullable Vec3 position, @Nullable Quat rotation, @Nullable Vec3 scale, @Nullable Vec3 euler, @Nullable Boolean objectEnabled, @Nullable Integer version, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new ScreenTransform(entityId, componentID, enabled, type, anchor, offset, pivot, ePinToEdge, eFixSize, eEditingMode, eKeepRatio, position, rotation, scale, euler, objectEnabled, version, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ScreenTransform)) {
            return false;
        }
        ScreenTransform screenTransform = (ScreenTransform) other;
        if (Intrinsics.areEqual(unknownFields(), screenTransform.unknownFields()) && Intrinsics.areEqual(this.entityId, screenTransform.entityId) && Intrinsics.areEqual(this.componentID, screenTransform.componentID) && Intrinsics.areEqual(this.enabled, screenTransform.enabled) && Intrinsics.areEqual(this.type, screenTransform.type) && Intrinsics.areEqual(this.anchor, screenTransform.anchor) && Intrinsics.areEqual(this.offset, screenTransform.offset) && Intrinsics.areEqual(this.pivot, screenTransform.pivot) && Intrinsics.areEqual(this.ePinToEdge, screenTransform.ePinToEdge) && Intrinsics.areEqual(this.eFixSize, screenTransform.eFixSize) && Intrinsics.areEqual(this.eEditingMode, screenTransform.eEditingMode) && Intrinsics.areEqual(this.eKeepRatio, screenTransform.eKeepRatio) && Intrinsics.areEqual(this.position, screenTransform.position) && Intrinsics.areEqual(this.rotation, screenTransform.rotation) && Intrinsics.areEqual(this.scale, screenTransform.scale) && Intrinsics.areEqual(this.euler, screenTransform.euler) && Intrinsics.areEqual(this.objectEnabled, screenTransform.objectEnabled) && Intrinsics.areEqual(this.version, screenTransform.version)) {
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
        int i49 = this.hashCode;
        if (i49 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i56 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i57 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i58 = (i57 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i59 = (i58 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i65 = (i59 + i18) * 37;
            Rect rect = this.anchor;
            if (rect != null) {
                i19 = rect.hashCode();
            } else {
                i19 = 0;
            }
            int i66 = (i65 + i19) * 37;
            Rect rect2 = this.offset;
            if (rect2 != null) {
                i26 = rect2.hashCode();
            } else {
                i26 = 0;
            }
            int i67 = (i66 + i26) * 37;
            Vec2 vec2 = this.pivot;
            if (vec2 != null) {
                i27 = vec2.hashCode();
            } else {
                i27 = 0;
            }
            int i68 = (i67 + i27) * 37;
            Integer num3 = this.ePinToEdge;
            if (num3 != null) {
                i28 = num3.hashCode();
            } else {
                i28 = 0;
            }
            int i69 = (i68 + i28) * 37;
            Integer num4 = this.eFixSize;
            if (num4 != null) {
                i29 = num4.hashCode();
            } else {
                i29 = 0;
            }
            int i75 = (i69 + i29) * 37;
            Integer num5 = this.eEditingMode;
            if (num5 != null) {
                i36 = num5.hashCode();
            } else {
                i36 = 0;
            }
            int i76 = (i75 + i36) * 37;
            Boolean bool2 = this.eKeepRatio;
            if (bool2 != null) {
                i37 = bool2.hashCode();
            } else {
                i37 = 0;
            }
            int i77 = (i76 + i37) * 37;
            Vec3 vec3 = this.position;
            if (vec3 != null) {
                i38 = vec3.hashCode();
            } else {
                i38 = 0;
            }
            int i78 = (i77 + i38) * 37;
            Quat quat = this.rotation;
            if (quat != null) {
                i39 = quat.hashCode();
            } else {
                i39 = 0;
            }
            int i79 = (i78 + i39) * 37;
            Vec3 vec32 = this.scale;
            if (vec32 != null) {
                i46 = vec32.hashCode();
            } else {
                i46 = 0;
            }
            int i85 = (i79 + i46) * 37;
            Vec3 vec33 = this.euler;
            if (vec33 != null) {
                i47 = vec33.hashCode();
            } else {
                i47 = 0;
            }
            int i86 = (i85 + i47) * 37;
            Boolean bool3 = this.objectEnabled;
            if (bool3 != null) {
                i48 = bool3.hashCode();
            } else {
                i48 = 0;
            }
            int i87 = (i86 + i48) * 37;
            Integer num6 = this.version;
            if (num6 != null) {
                i56 = num6.hashCode();
            }
            int i88 = i87 + i56;
            this.hashCode = i88;
            return i88;
        }
        return i49;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.anchor != null) {
            arrayList.add("anchor=" + this.anchor);
        }
        if (this.offset != null) {
            arrayList.add("offset=" + this.offset);
        }
        if (this.pivot != null) {
            arrayList.add("pivot=" + this.pivot);
        }
        if (this.ePinToEdge != null) {
            arrayList.add("ePinToEdge=" + this.ePinToEdge);
        }
        if (this.eFixSize != null) {
            arrayList.add("eFixSize=" + this.eFixSize);
        }
        if (this.eEditingMode != null) {
            arrayList.add("eEditingMode=" + this.eEditingMode);
        }
        if (this.eKeepRatio != null) {
            arrayList.add("eKeepRatio=" + this.eKeepRatio);
        }
        if (this.position != null) {
            arrayList.add("position=" + this.position);
        }
        if (this.rotation != null) {
            arrayList.add("rotation=" + this.rotation);
        }
        if (this.scale != null) {
            arrayList.add("scale=" + this.scale);
        }
        if (this.euler != null) {
            arrayList.add("euler=" + this.euler);
        }
        if (this.objectEnabled != null) {
            arrayList.add("objectEnabled=" + this.objectEnabled);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ScreenTransform{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ ScreenTransform(Integer num, Integer num2, Boolean bool, String str, Rect rect, Rect rect2, Vec2 vec2, Integer num3, Integer num4, Integer num5, Boolean bool2, Vec3 vec3, Quat quat, Vec3 vec32, Vec3 vec33, Boolean bool3, Integer num6, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : rect, (i3 & 32) != 0 ? null : rect2, (i3 & 64) != 0 ? null : vec2, (i3 & 128) != 0 ? null : num3, (i3 & 256) != 0 ? null : num4, (i3 & 512) != 0 ? null : num5, (i3 & 1024) != 0 ? null : bool2, (i3 & 2048) != 0 ? null : vec3, (i3 & 4096) != 0 ? null : quat, (i3 & 8192) != 0 ? null : vec32, (i3 & 16384) != 0 ? null : vec33, (i3 & 32768) != 0 ? null : bool3, (i3 & 65536) != 0 ? null : num6, (i3 & 131072) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.anchor = this.anchor;
        builder.offset = this.offset;
        builder.pivot = this.pivot;
        builder.ePinToEdge = this.ePinToEdge;
        builder.eFixSize = this.eFixSize;
        builder.eEditingMode = this.eEditingMode;
        builder.eKeepRatio = this.eKeepRatio;
        builder.position = this.position;
        builder.rotation = this.rotation;
        builder.scale = this.scale;
        builder.euler = this.euler;
        builder.objectEnabled = this.objectEnabled;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenTransform(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Vec2 vec2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool2, @Nullable Vec3 vec3, @Nullable Quat quat, @Nullable Vec3 vec32, @Nullable Vec3 vec33, @Nullable Boolean bool3, @Nullable Integer num6, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.anchor = rect;
        this.offset = rect2;
        this.pivot = vec2;
        this.ePinToEdge = num3;
        this.eFixSize = num4;
        this.eEditingMode = num5;
        this.eKeepRatio = bool2;
        this.position = vec3;
        this.rotation = quat;
        this.scale = vec32;
        this.euler = vec33;
        this.objectEnabled = bool3;
        this.version = num6;
    }
}
