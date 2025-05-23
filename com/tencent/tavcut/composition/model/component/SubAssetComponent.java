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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u00d3\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u0019J\u00d9\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/SubAssetComponent;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/SubAssetComponent$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "index", "version", "resourceId", "eIndexVector", "subAssetApplyType", "indexes", "", "eApplyRange", "level", "renderAfterTransform", "isUsingPropertiesSize", "isEnable3D", "cacheRenderResult", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/SubAssetComponent;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class SubAssetComponent extends AndroidMessage<SubAssetComponent, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<SubAssetComponent> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<SubAssetComponent> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    @JvmField
    @Nullable
    public final Boolean cacheRenderResult;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    @Nullable
    public final Integer eApplyRange;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String eIndexVector;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer index;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 10)
    @JvmField
    @NotNull
    public final List<Integer> indexes;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    @JvmField
    @Nullable
    public final Boolean isEnable3D;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    @JvmField
    @Nullable
    public final Boolean isUsingPropertiesSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    @JvmField
    @Nullable
    public final Integer level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    @JvmField
    @Nullable
    public final Boolean renderAfterTransform;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String resourceId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer subAssetApplyType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/SubAssetComponent$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/SubAssetComponent;", "()V", "cacheRenderResult", "", "Ljava/lang/Boolean;", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", "eApplyRange", "eIndexVector", "", NodeProps.ENABLED, TemplateParser.KEY_ENTITY_ID, "index", "indexes", "", "isEnable3D", "isUsingPropertiesSize", "level", "renderAfterTransform", "resourceId", "subAssetApplyType", "type", "version", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/SubAssetComponent$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/SubAssetComponent$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<SubAssetComponent, Builder> {

        @JvmField
        @Nullable
        public Boolean cacheRenderResult;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Integer eApplyRange;

        @JvmField
        @Nullable
        public String eIndexVector;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Integer index;

        @JvmField
        @NotNull
        public List<Integer> indexes;

        @JvmField
        @Nullable
        public Boolean isEnable3D;

        @JvmField
        @Nullable
        public Boolean isUsingPropertiesSize;

        @JvmField
        @Nullable
        public Integer level;

        @JvmField
        @Nullable
        public Boolean renderAfterTransform;

        @JvmField
        @Nullable
        public String resourceId;

        @JvmField
        @Nullable
        public Integer subAssetApplyType;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        public Builder() {
            List<Integer> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.indexes = emptyList;
        }

        @NotNull
        public final Builder cacheRenderResult(@Nullable Boolean cacheRenderResult) {
            this.cacheRenderResult = cacheRenderResult;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder eApplyRange(@Nullable Integer eApplyRange) {
            this.eApplyRange = eApplyRange;
            return this;
        }

        @NotNull
        public final Builder eIndexVector(@Nullable String eIndexVector) {
            this.eIndexVector = eIndexVector;
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
        public final Builder index(@Nullable Integer index) {
            this.index = index;
            return this;
        }

        @NotNull
        public final Builder indexes(@NotNull List<Integer> indexes) {
            Intrinsics.checkParameterIsNotNull(indexes, "indexes");
            Internal.checkElementsNotNull(indexes);
            this.indexes = indexes;
            return this;
        }

        @NotNull
        public final Builder isEnable3D(@Nullable Boolean isEnable3D) {
            this.isEnable3D = isEnable3D;
            return this;
        }

        @NotNull
        public final Builder isUsingPropertiesSize(@Nullable Boolean isUsingPropertiesSize) {
            this.isUsingPropertiesSize = isUsingPropertiesSize;
            return this;
        }

        @NotNull
        public final Builder level(@Nullable Integer level) {
            this.level = level;
            return this;
        }

        @NotNull
        public final Builder renderAfterTransform(@Nullable Boolean renderAfterTransform) {
            this.renderAfterTransform = renderAfterTransform;
            return this;
        }

        @NotNull
        public final Builder resourceId(@Nullable String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        @NotNull
        public final Builder subAssetApplyType(@Nullable Integer subAssetApplyType) {
            this.subAssetApplyType = subAssetApplyType;
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
        public SubAssetComponent build() {
            return new SubAssetComponent(this.entityId, this.componentID, this.enabled, this.type, this.index, this.version, this.resourceId, this.eIndexVector, this.subAssetApplyType, this.indexes, this.eApplyRange, this.level, this.renderAfterTransform, this.isUsingPropertiesSize, this.isEnable3D, this.cacheRenderResult, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SubAssetComponent.class);
        final String str = "type.googleapis.com/publisher.SubAssetComponent";
        ProtoAdapter<SubAssetComponent> protoAdapter = new ProtoAdapter<SubAssetComponent>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.SubAssetComponent$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SubAssetComponent decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str3 = null;
                String str4 = null;
                Integer num5 = null;
                Integer num6 = null;
                Integer num7 = null;
                Boolean bool2 = null;
                Boolean bool3 = null;
                Boolean bool4 = null;
                Boolean bool5 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    Integer num8 = num7;
                    if (nextTag == -1) {
                        return new SubAssetComponent(num, num2, bool, str2, num3, num4, str3, str4, num5, arrayList, num6, num8, bool5, bool2, bool3, bool4, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 10:
                            arrayList.add(ProtoAdapter.INT32.decode(reader));
                            break;
                        case 11:
                            num6 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 12:
                            num7 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 13:
                            bool5 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 14:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 15:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 16:
                            bool4 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                    num7 = num8;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull SubAssetComponent value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                protoAdapter3.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                protoAdapter4.encodeWithTag(writer, 4, value.type);
                protoAdapter2.encodeWithTag(writer, 5, value.index);
                protoAdapter2.encodeWithTag(writer, 6, value.version);
                protoAdapter4.encodeWithTag(writer, 7, value.resourceId);
                protoAdapter4.encodeWithTag(writer, 8, value.eIndexVector);
                protoAdapter2.encodeWithTag(writer, 9, value.subAssetApplyType);
                protoAdapter2.asRepeated().encodeWithTag(writer, 10, value.indexes);
                protoAdapter2.encodeWithTag(writer, 11, value.eApplyRange);
                protoAdapter2.encodeWithTag(writer, 12, value.level);
                protoAdapter3.encodeWithTag(writer, 13, value.renderAfterTransform);
                protoAdapter3.encodeWithTag(writer, 14, value.isUsingPropertiesSize);
                protoAdapter3.encodeWithTag(writer, 15, value.isEnable3D);
                protoAdapter3.encodeWithTag(writer, 16, value.cacheRenderResult);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull SubAssetComponent value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(4, value.type) + protoAdapter2.encodedSizeWithTag(5, value.index) + protoAdapter2.encodedSizeWithTag(6, value.version) + protoAdapter4.encodedSizeWithTag(7, value.resourceId) + protoAdapter4.encodedSizeWithTag(8, value.eIndexVector) + protoAdapter2.encodedSizeWithTag(9, value.subAssetApplyType) + protoAdapter2.asRepeated().encodedSizeWithTag(10, value.indexes) + protoAdapter2.encodedSizeWithTag(11, value.eApplyRange) + protoAdapter2.encodedSizeWithTag(12, value.level) + protoAdapter3.encodedSizeWithTag(13, value.renderAfterTransform) + protoAdapter3.encodedSizeWithTag(14, value.isUsingPropertiesSize) + protoAdapter3.encodedSizeWithTag(15, value.isEnable3D) + protoAdapter3.encodedSizeWithTag(16, value.cacheRenderResult) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SubAssetComponent redact(@NotNull SubAssetComponent value) {
                SubAssetComponent copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r35 & 1) != 0 ? value.entityId : null, (r35 & 2) != 0 ? value.componentID : null, (r35 & 4) != 0 ? value.enabled : null, (r35 & 8) != 0 ? value.type : null, (r35 & 16) != 0 ? value.index : null, (r35 & 32) != 0 ? value.version : null, (r35 & 64) != 0 ? value.resourceId : null, (r35 & 128) != 0 ? value.eIndexVector : null, (r35 & 256) != 0 ? value.subAssetApplyType : null, (r35 & 512) != 0 ? value.indexes : null, (r35 & 1024) != 0 ? value.eApplyRange : null, (r35 & 2048) != 0 ? value.level : null, (r35 & 4096) != 0 ? value.renderAfterTransform : null, (r35 & 8192) != 0 ? value.isUsingPropertiesSize : null, (r35 & 16384) != 0 ? value.isEnable3D : null, (r35 & 32768) != 0 ? value.cacheRenderResult : null, (r35 & 65536) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public SubAssetComponent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    @NotNull
    public final SubAssetComponent copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Integer index, @Nullable Integer version, @Nullable String resourceId, @Nullable String eIndexVector, @Nullable Integer subAssetApplyType, @NotNull List<Integer> indexes, @Nullable Integer eApplyRange, @Nullable Integer level, @Nullable Boolean renderAfterTransform, @Nullable Boolean isUsingPropertiesSize, @Nullable Boolean isEnable3D, @Nullable Boolean cacheRenderResult, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(indexes, "indexes");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new SubAssetComponent(entityId, componentID, enabled, type, index, version, resourceId, eIndexVector, subAssetApplyType, indexes, eApplyRange, level, renderAfterTransform, isUsingPropertiesSize, isEnable3D, cacheRenderResult, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SubAssetComponent)) {
            return false;
        }
        SubAssetComponent subAssetComponent = (SubAssetComponent) other;
        if (Intrinsics.areEqual(unknownFields(), subAssetComponent.unknownFields()) && Intrinsics.areEqual(this.entityId, subAssetComponent.entityId) && Intrinsics.areEqual(this.componentID, subAssetComponent.componentID) && Intrinsics.areEqual(this.enabled, subAssetComponent.enabled) && Intrinsics.areEqual(this.type, subAssetComponent.type) && Intrinsics.areEqual(this.index, subAssetComponent.index) && Intrinsics.areEqual(this.version, subAssetComponent.version) && Intrinsics.areEqual(this.resourceId, subAssetComponent.resourceId) && Intrinsics.areEqual(this.eIndexVector, subAssetComponent.eIndexVector) && Intrinsics.areEqual(this.subAssetApplyType, subAssetComponent.subAssetApplyType) && Intrinsics.areEqual(this.indexes, subAssetComponent.indexes) && Intrinsics.areEqual(this.eApplyRange, subAssetComponent.eApplyRange) && Intrinsics.areEqual(this.level, subAssetComponent.level) && Intrinsics.areEqual(this.renderAfterTransform, subAssetComponent.renderAfterTransform) && Intrinsics.areEqual(this.isUsingPropertiesSize, subAssetComponent.isUsingPropertiesSize) && Intrinsics.areEqual(this.isEnable3D, subAssetComponent.isEnable3D) && Intrinsics.areEqual(this.cacheRenderResult, subAssetComponent.cacheRenderResult)) {
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
        int i47 = this.hashCode;
        if (i47 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i48 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i49 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i56 = (i49 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i57 = (i56 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i58 = (i57 + i18) * 37;
            Integer num3 = this.index;
            if (num3 != null) {
                i19 = num3.hashCode();
            } else {
                i19 = 0;
            }
            int i59 = (i58 + i19) * 37;
            Integer num4 = this.version;
            if (num4 != null) {
                i26 = num4.hashCode();
            } else {
                i26 = 0;
            }
            int i65 = (i59 + i26) * 37;
            String str2 = this.resourceId;
            if (str2 != null) {
                i27 = str2.hashCode();
            } else {
                i27 = 0;
            }
            int i66 = (i65 + i27) * 37;
            String str3 = this.eIndexVector;
            if (str3 != null) {
                i28 = str3.hashCode();
            } else {
                i28 = 0;
            }
            int i67 = (i66 + i28) * 37;
            Integer num5 = this.subAssetApplyType;
            if (num5 != null) {
                i29 = num5.hashCode();
            } else {
                i29 = 0;
            }
            int hashCode2 = (((i67 + i29) * 37) + this.indexes.hashCode()) * 37;
            Integer num6 = this.eApplyRange;
            if (num6 != null) {
                i36 = num6.hashCode();
            } else {
                i36 = 0;
            }
            int i68 = (hashCode2 + i36) * 37;
            Integer num7 = this.level;
            if (num7 != null) {
                i37 = num7.hashCode();
            } else {
                i37 = 0;
            }
            int i69 = (i68 + i37) * 37;
            Boolean bool2 = this.renderAfterTransform;
            if (bool2 != null) {
                i38 = bool2.hashCode();
            } else {
                i38 = 0;
            }
            int i75 = (i69 + i38) * 37;
            Boolean bool3 = this.isUsingPropertiesSize;
            if (bool3 != null) {
                i39 = bool3.hashCode();
            } else {
                i39 = 0;
            }
            int i76 = (i75 + i39) * 37;
            Boolean bool4 = this.isEnable3D;
            if (bool4 != null) {
                i46 = bool4.hashCode();
            } else {
                i46 = 0;
            }
            int i77 = (i76 + i46) * 37;
            Boolean bool5 = this.cacheRenderResult;
            if (bool5 != null) {
                i48 = bool5.hashCode();
            }
            int i78 = i77 + i48;
            this.hashCode = i78;
            return i78;
        }
        return i47;
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
        if (this.index != null) {
            arrayList.add("index=" + this.index);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.resourceId != null) {
            arrayList.add("resourceId=" + Internal.sanitize(this.resourceId));
        }
        if (this.eIndexVector != null) {
            arrayList.add("eIndexVector=" + Internal.sanitize(this.eIndexVector));
        }
        if (this.subAssetApplyType != null) {
            arrayList.add("subAssetApplyType=" + this.subAssetApplyType);
        }
        if (!this.indexes.isEmpty()) {
            arrayList.add("indexes=" + this.indexes);
        }
        if (this.eApplyRange != null) {
            arrayList.add("eApplyRange=" + this.eApplyRange);
        }
        if (this.level != null) {
            arrayList.add("level=" + this.level);
        }
        if (this.renderAfterTransform != null) {
            arrayList.add("renderAfterTransform=" + this.renderAfterTransform);
        }
        if (this.isUsingPropertiesSize != null) {
            arrayList.add("isUsingPropertiesSize=" + this.isUsingPropertiesSize);
        }
        if (this.isEnable3D != null) {
            arrayList.add("isEnable3D=" + this.isEnable3D);
        }
        if (this.cacheRenderResult != null) {
            arrayList.add("cacheRenderResult=" + this.cacheRenderResult);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "SubAssetComponent{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ SubAssetComponent(Integer num, Integer num2, Boolean bool, String str, Integer num3, Integer num4, String str2, String str3, Integer num5, List list, Integer num6, Integer num7, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : num4, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? null : str3, (i3 & 256) != 0 ? null : num5, (i3 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 1024) != 0 ? null : num6, (i3 & 2048) != 0 ? null : num7, (i3 & 4096) != 0 ? null : bool2, (i3 & 8192) != 0 ? null : bool3, (i3 & 16384) != 0 ? null : bool4, (i3 & 32768) != 0 ? null : bool5, (i3 & 65536) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.index = this.index;
        builder.version = this.version;
        builder.resourceId = this.resourceId;
        builder.eIndexVector = this.eIndexVector;
        builder.subAssetApplyType = this.subAssetApplyType;
        builder.indexes = this.indexes;
        builder.eApplyRange = this.eApplyRange;
        builder.level = this.level;
        builder.renderAfterTransform = this.renderAfterTransform;
        builder.isUsingPropertiesSize = this.isUsingPropertiesSize;
        builder.isEnable3D = this.isEnable3D;
        builder.cacheRenderResult = this.cacheRenderResult;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAssetComponent(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str2, @Nullable String str3, @Nullable Integer num5, @NotNull List<Integer> indexes, @Nullable Integer num6, @Nullable Integer num7, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(indexes, "indexes");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.index = num3;
        this.version = num4;
        this.resourceId = str2;
        this.eIndexVector = str3;
        this.subAssetApplyType = num5;
        this.indexes = indexes;
        this.eApplyRange = num6;
        this.level = num7;
        this.renderAfterTransform = bool2;
        this.isUsingPropertiesSize = bool3;
        this.isEnable3D = bool4;
        this.cacheRenderResult = bool5;
    }
}
