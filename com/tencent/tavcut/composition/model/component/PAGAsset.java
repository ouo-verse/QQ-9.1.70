package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
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
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001f !\"B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0091\u0001\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "musicID", "src", "usage", "version", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", HippyQQPagViewController.PropertyName.SCALE_MODE, "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "PagScaleMode", "Replacement", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class PAGAsset extends AndroidMessage<PAGAsset, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PAGAsset> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PAGAsset> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String musicID;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.PAGAsset$Replacement#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    @JvmField
    @NotNull
    public final List<Replacement> replacement;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer scaleMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    @Nullable
    public final Integer usage;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    @Nullable
    public final Integer version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0014\u0010\r\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "musicID", "", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", HippyQQPagViewController.PropertyName.SCALE_MODE, "src", "type", "usage", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<PAGAsset, Builder> {

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public String musicID;

        @JvmField
        @NotNull
        public List<Replacement> replacement;

        @JvmField
        @Nullable
        public Integer scaleMode;

        @JvmField
        @Nullable
        public String src;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer usage;

        @JvmField
        @Nullable
        public Integer version;

        public Builder() {
            List<Replacement> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.replacement = emptyList;
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
        public final Builder entityId(@Nullable Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        @NotNull
        public final Builder musicID(@Nullable String musicID) {
            this.musicID = musicID;
            return this;
        }

        @NotNull
        public final Builder replacement(@NotNull List<Replacement> replacement) {
            Intrinsics.checkParameterIsNotNull(replacement, "replacement");
            Internal.checkElementsNotNull(replacement);
            this.replacement = replacement;
            return this;
        }

        @NotNull
        public final Builder scaleMode(@Nullable Integer scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }

        @NotNull
        public final Builder src(@Nullable String src) {
            this.src = src;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder usage(@Nullable Integer usage) {
            this.usage = usage;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable Integer version) {
            this.version = version;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public PAGAsset build() {
            return new PAGAsset(this.entityId, this.componentID, this.enabled, this.type, this.musicID, this.src, this.usage, this.version, this.replacement, this.scaleMode, buildUnknownFields());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "STRETCH", "LETTERBOX", "ZOOM", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum PagScaleMode implements WireEnum {
        NONE(0),
        STRETCH(1),
        LETTERBOX(2),
        ZOOM(3);


        @JvmField
        @NotNull
        public static final ProtoAdapter<PagScaleMode> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", "fromValue", "value", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Companion {
            Companion() {
            }

            @JvmStatic
            @Nullable
            public final PagScaleMode fromValue(int value) {
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                return null;
                            }
                            return PagScaleMode.ZOOM;
                        }
                        return PagScaleMode.LETTERBOX;
                    }
                    return PagScaleMode.STRETCH;
                }
                return PagScaleMode.NONE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PagScaleMode.class);
            ADAPTER = new EnumAdapter<PagScaleMode>(orCreateKotlinClass) { // from class: com.tencent.tavcut.composition.model.component.PAGAsset$PagScaleMode$Companion$ADAPTER$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public PAGAsset.PagScaleMode fromValue(int value) {
                    return PAGAsset.PagScaleMode.INSTANCE.fromValue(value);
                }
            };
        }

        PagScaleMode(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final PagScaleMode fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eBo\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011Ju\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "index", "", "src", "", "replaceType", "sourceIndex", HippyQQPagViewController.PropertyName.SCALE_MODE, "interactive", "", "textReplaceItem", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "textMaxLength", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "ReplaceType", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Replacement extends AndroidMessage<Replacement, Builder> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<Replacement> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<Replacement> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        @JvmField
        @Nullable
        public final Integer index;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
        @JvmField
        @Nullable
        public final Boolean interactive;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
        @JvmField
        @Nullable
        public final Integer replaceType;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
        @JvmField
        @Nullable
        public final Integer scaleMode;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
        @JvmField
        @Nullable
        public final Integer sourceIndex;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @Nullable
        public final String src;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
        @JvmField
        @Nullable
        public final Integer textMaxLength;

        @WireField(adapter = "com.tencent.tavcut.composition.model.component.TextReplaceItem#ADAPTER", tag = 7)
        @JvmField
        @Nullable
        public final TextReplaceItem textReplaceItem;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "()V", "index", "", "Ljava/lang/Integer;", "interactive", "", "Ljava/lang/Boolean;", "replaceType", HippyQQPagViewController.PropertyName.SCALE_MODE, "sourceIndex", "src", "", "textMaxLength", "textReplaceItem", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Builder extends Message.Builder<Replacement, Builder> {

            @JvmField
            @Nullable
            public Integer index;

            @JvmField
            @Nullable
            public Boolean interactive;

            @JvmField
            @Nullable
            public Integer replaceType;

            @JvmField
            @Nullable
            public Integer scaleMode;

            @JvmField
            @Nullable
            public Integer sourceIndex;

            @JvmField
            @Nullable
            public String src;

            @JvmField
            @Nullable
            public Integer textMaxLength;

            @JvmField
            @Nullable
            public TextReplaceItem textReplaceItem;

            @NotNull
            public final Builder index(@Nullable Integer index) {
                this.index = index;
                return this;
            }

            @NotNull
            public final Builder interactive(@Nullable Boolean interactive) {
                this.interactive = interactive;
                return this;
            }

            @NotNull
            public final Builder replaceType(@Nullable Integer replaceType) {
                this.replaceType = replaceType;
                return this;
            }

            @NotNull
            public final Builder scaleMode(@Nullable Integer scaleMode) {
                this.scaleMode = scaleMode;
                return this;
            }

            @NotNull
            public final Builder sourceIndex(@Nullable Integer sourceIndex) {
                this.sourceIndex = sourceIndex;
                return this;
            }

            @NotNull
            public final Builder src(@Nullable String src) {
                this.src = src;
                return this;
            }

            @NotNull
            public final Builder textMaxLength(@Nullable Integer textMaxLength) {
                this.textMaxLength = textMaxLength;
                return this;
            }

            @NotNull
            public final Builder textReplaceItem(@Nullable TextReplaceItem textReplaceItem) {
                this.textReplaceItem = textReplaceItem;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public Replacement build() {
                return new Replacement(this.index, this.src, this.replaceType, this.sourceIndex, this.scaleMode, this.interactive, this.textReplaceItem, this.textMaxLength, buildUnknownFields());
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "TEXT", "IMAGE", "FILTER_REPLACEMENT", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public enum ReplaceType implements WireEnum {
            NONE(0),
            TEXT(1),
            IMAGE(2),
            FILTER_REPLACEMENT(3);


            @JvmField
            @NotNull
            public static final ProtoAdapter<ReplaceType> ADAPTER;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final int value;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
            /* loaded from: classes26.dex */
            public static final class Companion {
                Companion() {
                }

                @JvmStatic
                @Nullable
                public final ReplaceType fromValue(int value) {
                    if (value != 0) {
                        if (value != 1) {
                            if (value != 2) {
                                if (value != 3) {
                                    return null;
                                }
                                return ReplaceType.FILTER_REPLACEMENT;
                            }
                            return ReplaceType.IMAGE;
                        }
                        return ReplaceType.TEXT;
                    }
                    return ReplaceType.NONE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ReplaceType.class);
                ADAPTER = new EnumAdapter<ReplaceType>(orCreateKotlinClass) { // from class: com.tencent.tavcut.composition.model.component.PAGAsset$Replacement$ReplaceType$Companion$ADAPTER$1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.squareup.wire.EnumAdapter
                    @Nullable
                    public PAGAsset.Replacement.ReplaceType fromValue(int value) {
                        return PAGAsset.Replacement.ReplaceType.INSTANCE.fromValue(value);
                    }
                };
            }

            ReplaceType(int i3) {
                this.value = i3;
            }

            @JvmStatic
            @Nullable
            public static final ReplaceType fromValue(int i3) {
                return INSTANCE.fromValue(i3);
            }

            @Override // com.squareup.wire.WireEnum
            public int getValue() {
                return this.value;
            }
        }

        static {
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Replacement.class);
            final String str = "type.googleapis.com/publisher.PAGAsset.Replacement";
            ProtoAdapter<Replacement> protoAdapter = new ProtoAdapter<Replacement>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.PAGAsset$Replacement$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public PAGAsset.Replacement decode(@NotNull ProtoReader reader) {
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    Integer num = null;
                    String str2 = null;
                    Integer num2 = null;
                    Integer num3 = null;
                    Integer num4 = null;
                    Boolean bool = null;
                    TextReplaceItem textReplaceItem = null;
                    Integer num5 = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new PAGAsset.Replacement(num, str2, num2, num3, num4, bool, textReplaceItem, num5, reader.endMessageAndGetUnknownFields(beginMessage));
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
                                num3 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 5:
                                num4 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 6:
                                bool = ProtoAdapter.BOOL.decode(reader);
                                break;
                            case 7:
                                textReplaceItem = TextReplaceItem.ADAPTER.decode(reader);
                                break;
                            case 8:
                                num5 = ProtoAdapter.INT32.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull PAGAsset.Replacement value) {
                    Intrinsics.checkParameterIsNotNull(writer, "writer");
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    protoAdapter2.encodeWithTag(writer, 1, value.index);
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.src);
                    protoAdapter2.encodeWithTag(writer, 3, value.replaceType);
                    protoAdapter2.encodeWithTag(writer, 4, value.sourceIndex);
                    protoAdapter2.encodeWithTag(writer, 5, value.scaleMode);
                    ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.interactive);
                    TextReplaceItem.ADAPTER.encodeWithTag(writer, 7, value.textReplaceItem);
                    protoAdapter2.encodeWithTag(writer, 8, value.textMaxLength);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull PAGAsset.Replacement value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    return protoAdapter2.encodedSizeWithTag(1, value.index) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.src) + protoAdapter2.encodedSizeWithTag(3, value.replaceType) + protoAdapter2.encodedSizeWithTag(4, value.sourceIndex) + protoAdapter2.encodedSizeWithTag(5, value.scaleMode) + ProtoAdapter.BOOL.encodedSizeWithTag(6, value.interactive) + TextReplaceItem.ADAPTER.encodedSizeWithTag(7, value.textReplaceItem) + protoAdapter2.encodedSizeWithTag(8, value.textMaxLength) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public PAGAsset.Replacement redact(@NotNull PAGAsset.Replacement value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    TextReplaceItem textReplaceItem = value.textReplaceItem;
                    return PAGAsset.Replacement.copy$default(value, null, null, null, null, null, null, textReplaceItem != null ? TextReplaceItem.ADAPTER.redact(textReplaceItem) : null, null, ByteString.EMPTY, 191, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public Replacement() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Replacement copy$default(Replacement replacement, Integer num, String str, Integer num2, Integer num3, Integer num4, Boolean bool, TextReplaceItem textReplaceItem, Integer num5, ByteString byteString, int i3, Object obj) {
            Integer num6;
            String str2;
            Integer num7;
            Integer num8;
            Integer num9;
            Boolean bool2;
            TextReplaceItem textReplaceItem2;
            Integer num10;
            ByteString byteString2;
            if ((i3 & 1) != 0) {
                num6 = replacement.index;
            } else {
                num6 = num;
            }
            if ((i3 & 2) != 0) {
                str2 = replacement.src;
            } else {
                str2 = str;
            }
            if ((i3 & 4) != 0) {
                num7 = replacement.replaceType;
            } else {
                num7 = num2;
            }
            if ((i3 & 8) != 0) {
                num8 = replacement.sourceIndex;
            } else {
                num8 = num3;
            }
            if ((i3 & 16) != 0) {
                num9 = replacement.scaleMode;
            } else {
                num9 = num4;
            }
            if ((i3 & 32) != 0) {
                bool2 = replacement.interactive;
            } else {
                bool2 = bool;
            }
            if ((i3 & 64) != 0) {
                textReplaceItem2 = replacement.textReplaceItem;
            } else {
                textReplaceItem2 = textReplaceItem;
            }
            if ((i3 & 128) != 0) {
                num10 = replacement.textMaxLength;
            } else {
                num10 = num5;
            }
            if ((i3 & 256) != 0) {
                byteString2 = replacement.unknownFields();
            } else {
                byteString2 = byteString;
            }
            return replacement.copy(num6, str2, num7, num8, num9, bool2, textReplaceItem2, num10, byteString2);
        }

        @NotNull
        public final Replacement copy(@Nullable Integer index, @Nullable String src, @Nullable Integer replaceType, @Nullable Integer sourceIndex, @Nullable Integer scaleMode, @Nullable Boolean interactive, @Nullable TextReplaceItem textReplaceItem, @Nullable Integer textMaxLength, @NotNull ByteString unknownFields) {
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            return new Replacement(index, src, replaceType, sourceIndex, scaleMode, interactive, textReplaceItem, textMaxLength, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Replacement)) {
                return false;
            }
            Replacement replacement = (Replacement) other;
            if (Intrinsics.areEqual(unknownFields(), replacement.unknownFields()) && Intrinsics.areEqual(this.index, replacement.index) && Intrinsics.areEqual(this.src, replacement.src) && Intrinsics.areEqual(this.replaceType, replacement.replaceType) && Intrinsics.areEqual(this.sourceIndex, replacement.sourceIndex) && Intrinsics.areEqual(this.scaleMode, replacement.scaleMode) && Intrinsics.areEqual(this.interactive, replacement.interactive) && Intrinsics.areEqual(this.textReplaceItem, replacement.textReplaceItem) && Intrinsics.areEqual(this.textMaxLength, replacement.textMaxLength)) {
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
            int i28 = this.hashCode;
            if (i28 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Integer num = this.index;
                int i29 = 0;
                if (num != null) {
                    i3 = num.hashCode();
                } else {
                    i3 = 0;
                }
                int i36 = (hashCode + i3) * 37;
                String str = this.src;
                if (str != null) {
                    i16 = str.hashCode();
                } else {
                    i16 = 0;
                }
                int i37 = (i36 + i16) * 37;
                Integer num2 = this.replaceType;
                if (num2 != null) {
                    i17 = num2.hashCode();
                } else {
                    i17 = 0;
                }
                int i38 = (i37 + i17) * 37;
                Integer num3 = this.sourceIndex;
                if (num3 != null) {
                    i18 = num3.hashCode();
                } else {
                    i18 = 0;
                }
                int i39 = (i38 + i18) * 37;
                Integer num4 = this.scaleMode;
                if (num4 != null) {
                    i19 = num4.hashCode();
                } else {
                    i19 = 0;
                }
                int i46 = (i39 + i19) * 37;
                Boolean bool = this.interactive;
                if (bool != null) {
                    i26 = bool.hashCode();
                } else {
                    i26 = 0;
                }
                int i47 = (i46 + i26) * 37;
                TextReplaceItem textReplaceItem = this.textReplaceItem;
                if (textReplaceItem != null) {
                    i27 = textReplaceItem.hashCode();
                } else {
                    i27 = 0;
                }
                int i48 = (i47 + i27) * 37;
                Integer num5 = this.textMaxLength;
                if (num5 != null) {
                    i29 = num5.hashCode();
                }
                int i49 = i48 + i29;
                this.hashCode = i49;
                return i49;
            }
            return i28;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            ArrayList arrayList = new ArrayList();
            if (this.index != null) {
                arrayList.add("index=" + this.index);
            }
            if (this.src != null) {
                arrayList.add("src=" + Internal.sanitize(this.src));
            }
            if (this.replaceType != null) {
                arrayList.add("replaceType=" + this.replaceType);
            }
            if (this.sourceIndex != null) {
                arrayList.add("sourceIndex=" + this.sourceIndex);
            }
            if (this.scaleMode != null) {
                arrayList.add("scaleMode=" + this.scaleMode);
            }
            if (this.interactive != null) {
                arrayList.add("interactive=" + this.interactive);
            }
            if (this.textReplaceItem != null) {
                arrayList.add("textReplaceItem=" + this.textReplaceItem);
            }
            if (this.textMaxLength != null) {
                arrayList.add("textMaxLength=" + this.textMaxLength);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Replacement{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ Replacement(Integer num, String str, Integer num2, Integer num3, Integer num4, Boolean bool, TextReplaceItem textReplaceItem, Integer num5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : num4, (i3 & 32) != 0 ? null : bool, (i3 & 64) != 0 ? null : textReplaceItem, (i3 & 128) == 0 ? num5 : null, (i3 & 256) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.index = this.index;
            builder.src = this.src;
            builder.replaceType = this.replaceType;
            builder.sourceIndex = this.sourceIndex;
            builder.scaleMode = this.scaleMode;
            builder.interactive = this.interactive;
            builder.textReplaceItem = this.textReplaceItem;
            builder.textMaxLength = this.textMaxLength;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Replacement(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Boolean bool, @Nullable TextReplaceItem textReplaceItem, @Nullable Integer num5, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            this.index = num;
            this.src = str;
            this.replaceType = num2;
            this.sourceIndex = num3;
            this.scaleMode = num4;
            this.interactive = bool;
            this.textReplaceItem = textReplaceItem;
            this.textMaxLength = num5;
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PAGAsset.class);
        final String str = "type.googleapis.com/publisher.PAGAsset";
        ProtoAdapter<PAGAsset> protoAdapter = new ProtoAdapter<PAGAsset>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.PAGAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PAGAsset decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                Integer num3 = null;
                Integer num4 = null;
                Integer num5 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new PAGAsset(num, num2, bool, str2, str3, str4, num3, num4, arrayList, num5, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 8:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 9:
                            arrayList.add(PAGAsset.Replacement.ADAPTER.decode(reader));
                            break;
                        case 10:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull PAGAsset value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.type);
                protoAdapter3.encodeWithTag(writer, 5, value.musicID);
                protoAdapter3.encodeWithTag(writer, 6, value.src);
                protoAdapter2.encodeWithTag(writer, 7, value.usage);
                protoAdapter2.encodeWithTag(writer, 8, value.version);
                PAGAsset.Replacement.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.replacement);
                protoAdapter2.encodeWithTag(writer, 10, value.scaleMode);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull PAGAsset value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.type) + protoAdapter3.encodedSizeWithTag(5, value.musicID) + protoAdapter3.encodedSizeWithTag(6, value.src) + protoAdapter2.encodedSizeWithTag(7, value.usage) + protoAdapter2.encodedSizeWithTag(8, value.version) + PAGAsset.Replacement.ADAPTER.asRepeated().encodedSizeWithTag(9, value.replacement) + protoAdapter2.encodedSizeWithTag(10, value.scaleMode) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PAGAsset redact(@NotNull PAGAsset value) {
                PAGAsset copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r24 & 1) != 0 ? value.entityId : null, (r24 & 2) != 0 ? value.componentID : null, (r24 & 4) != 0 ? value.enabled : null, (r24 & 8) != 0 ? value.type : null, (r24 & 16) != 0 ? value.musicID : null, (r24 & 32) != 0 ? value.src : null, (r24 & 64) != 0 ? value.usage : null, (r24 & 128) != 0 ? value.version : null, (r24 & 256) != 0 ? value.replacement : Internal.m87redactElements(value.replacement, PAGAsset.Replacement.ADAPTER), (r24 & 512) != 0 ? value.scaleMode : null, (r24 & 1024) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public PAGAsset() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @NotNull
    public final PAGAsset copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable String musicID, @Nullable String src, @Nullable Integer usage, @Nullable Integer version, @NotNull List<Replacement> replacement, @Nullable Integer scaleMode, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new PAGAsset(entityId, componentID, enabled, type, musicID, src, usage, version, replacement, scaleMode, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PAGAsset)) {
            return false;
        }
        PAGAsset pAGAsset = (PAGAsset) other;
        if (Intrinsics.areEqual(unknownFields(), pAGAsset.unknownFields()) && Intrinsics.areEqual(this.entityId, pAGAsset.entityId) && Intrinsics.areEqual(this.componentID, pAGAsset.componentID) && Intrinsics.areEqual(this.enabled, pAGAsset.enabled) && Intrinsics.areEqual(this.type, pAGAsset.type) && Intrinsics.areEqual(this.musicID, pAGAsset.musicID) && Intrinsics.areEqual(this.src, pAGAsset.src) && Intrinsics.areEqual(this.usage, pAGAsset.usage) && Intrinsics.areEqual(this.version, pAGAsset.version) && Intrinsics.areEqual(this.replacement, pAGAsset.replacement) && Intrinsics.areEqual(this.scaleMode, pAGAsset.scaleMode)) {
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
        int i29 = this.hashCode;
        if (i29 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i36 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (i37 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i39 = (i38 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i46 = (i39 + i18) * 37;
            String str2 = this.musicID;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i47 = (i46 + i19) * 37;
            String str3 = this.src;
            if (str3 != null) {
                i26 = str3.hashCode();
            } else {
                i26 = 0;
            }
            int i48 = (i47 + i26) * 37;
            Integer num3 = this.usage;
            if (num3 != null) {
                i27 = num3.hashCode();
            } else {
                i27 = 0;
            }
            int i49 = (i48 + i27) * 37;
            Integer num4 = this.version;
            if (num4 != null) {
                i28 = num4.hashCode();
            } else {
                i28 = 0;
            }
            int hashCode2 = (((i49 + i28) * 37) + this.replacement.hashCode()) * 37;
            Integer num5 = this.scaleMode;
            if (num5 != null) {
                i36 = num5.hashCode();
            }
            int i56 = hashCode2 + i36;
            this.hashCode = i56;
            return i56;
        }
        return i29;
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
        if (this.musicID != null) {
            arrayList.add("musicID=" + Internal.sanitize(this.musicID));
        }
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        if (this.usage != null) {
            arrayList.add("usage=" + this.usage);
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (!this.replacement.isEmpty()) {
            arrayList.add("replacement=" + this.replacement);
        }
        if (this.scaleMode != null) {
            arrayList.add("scaleMode=" + this.scaleMode);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PAGAsset{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PAGAsset(Integer num, Integer num2, Boolean bool, String str, String str2, String str3, Integer num3, Integer num4, List list, Integer num5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : num3, (i3 & 128) != 0 ? null : num4, (i3 & 256) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 512) == 0 ? num5 : null, (i3 & 1024) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.musicID = this.musicID;
        builder.src = this.src;
        builder.usage = this.usage;
        builder.version = this.version;
        builder.replacement = this.replacement;
        builder.scaleMode = this.scaleMode;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PAGAsset(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable Integer num4, @NotNull List<Replacement> replacement, @Nullable Integer num5, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.musicID = str2;
        this.src = str3;
        this.usage = num3;
        this.version = num4;
        this.replacement = replacement;
        this.scaleMode = num5;
    }
}
