package com.tencent.tavcut.model;

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
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.tavcut.model.LightAssetModel;
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

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bBK\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJL\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$Builder;", "fontAssets", "", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "musicIds", "", "materialConfig", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "boundsTrackerPlaceHolders", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/util/List;Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "FontAsset", "MaterialConfig", "MediaType", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightAssetModel extends AndroidMessage<LightAssetModel, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<LightAssetModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LightAssetModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    @JvmField
    @NotNull
    public final List<String> boundsTrackerPlaceHolders;

    @WireField(adapter = "com.tencent.tavcut.model.LightAssetModel$FontAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @JvmField
    @NotNull
    public final List<FontAsset> fontAssets;

    @WireField(adapter = "com.tencent.tavcut.model.LightAssetModel$MaterialConfig#ADAPTER", tag = 4)
    @JvmField
    @Nullable
    public final MaterialConfig materialConfig;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    @JvmField
    @NotNull
    public final List<String> musicIds;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel;", "()V", "boundsTrackerPlaceHolders", "", "", "fontAssets", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "materialConfig", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "musicIds", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<LightAssetModel, Builder> {

        @JvmField
        @NotNull
        public List<String> boundsTrackerPlaceHolders;

        @JvmField
        @NotNull
        public List<FontAsset> fontAssets;

        @JvmField
        @Nullable
        public MaterialConfig materialConfig;

        @JvmField
        @NotNull
        public List<String> musicIds;

        public Builder() {
            List<FontAsset> emptyList;
            List<String> emptyList2;
            List<String> emptyList3;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.fontAssets = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.musicIds = emptyList2;
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            this.boundsTrackerPlaceHolders = emptyList3;
        }

        @NotNull
        public final Builder boundsTrackerPlaceHolders(@NotNull List<String> boundsTrackerPlaceHolders) {
            Intrinsics.checkParameterIsNotNull(boundsTrackerPlaceHolders, "boundsTrackerPlaceHolders");
            Internal.checkElementsNotNull(boundsTrackerPlaceHolders);
            this.boundsTrackerPlaceHolders = boundsTrackerPlaceHolders;
            return this;
        }

        @NotNull
        public final Builder fontAssets(@NotNull List<FontAsset> fontAssets) {
            Intrinsics.checkParameterIsNotNull(fontAssets, "fontAssets");
            Internal.checkElementsNotNull(fontAssets);
            this.fontAssets = fontAssets;
            return this;
        }

        @NotNull
        public final Builder materialConfig(@Nullable MaterialConfig materialConfig) {
            this.materialConfig = materialConfig;
            return this;
        }

        @NotNull
        public final Builder musicIds(@NotNull List<String> musicIds) {
            Intrinsics.checkParameterIsNotNull(musicIds, "musicIds");
            Internal.checkElementsNotNull(musicIds);
            this.musicIds = musicIds;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public LightAssetModel build() {
            return new LightAssetModel(this.fontAssets, this.musicIds, this.materialConfig, this.boundsTrackerPlaceHolders, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset$Builder;", "fontFamily", "", "fontStyle", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class FontAsset extends AndroidMessage<FontAsset, Builder> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<FontAsset> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<FontAsset> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        @JvmField
        @Nullable
        public final String fontFamily;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @Nullable
        public final String fontStyle;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$FontAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel$FontAsset;", "()V", "fontFamily", "", "fontStyle", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Builder extends Message.Builder<FontAsset, Builder> {

            @JvmField
            @Nullable
            public String fontFamily;

            @JvmField
            @Nullable
            public String fontStyle;

            @NotNull
            public final Builder fontFamily(@Nullable String fontFamily) {
                this.fontFamily = fontFamily;
                return this;
            }

            @NotNull
            public final Builder fontStyle(@Nullable String fontStyle) {
                this.fontStyle = fontStyle;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public FontAsset build() {
                return new FontAsset(this.fontFamily, this.fontStyle, buildUnknownFields());
            }
        }

        static {
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FontAsset.class);
            final String str = "type.googleapis.com/publisher.LightAssetModel.FontAsset";
            ProtoAdapter<FontAsset> protoAdapter = new ProtoAdapter<FontAsset>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.LightAssetModel$FontAsset$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public LightAssetModel.FontAsset decode(@NotNull ProtoReader reader) {
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    String str2 = null;
                    String str3 = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new LightAssetModel.FontAsset(str2, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag != 2) {
                            reader.readUnknownField(nextTag);
                        } else {
                            str3 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull LightAssetModel.FontAsset value) {
                    Intrinsics.checkParameterIsNotNull(writer, "writer");
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    protoAdapter2.encodeWithTag(writer, 1, value.fontFamily);
                    protoAdapter2.encodeWithTag(writer, 2, value.fontStyle);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull LightAssetModel.FontAsset value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    return protoAdapter2.encodedSizeWithTag(1, value.fontFamily) + protoAdapter2.encodedSizeWithTag(2, value.fontStyle) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public LightAssetModel.FontAsset redact(@NotNull LightAssetModel.FontAsset value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    return LightAssetModel.FontAsset.copy$default(value, null, null, ByteString.EMPTY, 3, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public FontAsset() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ FontAsset copy$default(FontAsset fontAsset, String str, String str2, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = fontAsset.fontFamily;
            }
            if ((i3 & 2) != 0) {
                str2 = fontAsset.fontStyle;
            }
            if ((i3 & 4) != 0) {
                byteString = fontAsset.unknownFields();
            }
            return fontAsset.copy(str, str2, byteString);
        }

        @NotNull
        public final FontAsset copy(@Nullable String fontFamily, @Nullable String fontStyle, @NotNull ByteString unknownFields) {
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            return new FontAsset(fontFamily, fontStyle, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof FontAsset)) {
                return false;
            }
            FontAsset fontAsset = (FontAsset) other;
            if (Intrinsics.areEqual(unknownFields(), fontAsset.unknownFields()) && Intrinsics.areEqual(this.fontFamily, fontAsset.fontFamily) && Intrinsics.areEqual(this.fontStyle, fontAsset.fontStyle)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = this.hashCode;
            if (i16 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.fontFamily;
                int i17 = 0;
                if (str != null) {
                    i3 = str.hashCode();
                } else {
                    i3 = 0;
                }
                int i18 = (hashCode + i3) * 37;
                String str2 = this.fontStyle;
                if (str2 != null) {
                    i17 = str2.hashCode();
                }
                int i19 = i18 + i17;
                this.hashCode = i19;
                return i19;
            }
            return i16;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            ArrayList arrayList = new ArrayList();
            if (this.fontFamily != null) {
                arrayList.add("fontFamily=" + Internal.sanitize(this.fontFamily));
            }
            if (this.fontStyle != null) {
                arrayList.add("fontStyle=" + Internal.sanitize(this.fontStyle));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "FontAsset{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ FontAsset(String str, String str2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.fontFamily = this.fontFamily;
            builder.fontStyle = this.fontStyle;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FontAsset(@Nullable String str, @Nullable String str2, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            this.fontFamily = str;
            this.fontStyle = str2;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aBK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig$Builder;", "type", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "minAssetCount", "", "maxAssetCount", "minVideoDuration", "minImageDuration", "maxImageDuration", "preferredCoverTime", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/tavcut/model/LightAssetModel$MediaType;IIIIIJLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class MaterialConfig extends AndroidMessage<MaterialConfig, Builder> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<MaterialConfig> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<MaterialConfig> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
        @JvmField
        public final int maxAssetCount;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 6)
        @JvmField
        public final int maxImageDuration;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 2)
        @JvmField
        public final int minAssetCount;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 5)
        @JvmField
        public final int minImageDuration;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
        @JvmField
        public final int minVideoDuration;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 7)
        @JvmField
        public final long preferredCoverTime;

        @WireField(adapter = "com.tencent.tavcut.model.LightAssetModel$MediaType#ADAPTER", tag = 1)
        @JvmField
        @Nullable
        public final MediaType type;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "()V", "maxAssetCount", "", "Ljava/lang/Integer;", "maxImageDuration", "minAssetCount", "minImageDuration", "minVideoDuration", "preferredCoverTime", "", "Ljava/lang/Long;", "type", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Builder extends Message.Builder<MaterialConfig, Builder> {

            @JvmField
            @Nullable
            public Integer maxAssetCount;

            @JvmField
            @Nullable
            public Integer maxImageDuration;

            @JvmField
            @Nullable
            public Integer minAssetCount;

            @JvmField
            @Nullable
            public Integer minImageDuration;

            @JvmField
            @Nullable
            public Integer minVideoDuration;

            @JvmField
            @Nullable
            public Long preferredCoverTime;

            @JvmField
            @Nullable
            public MediaType type;

            @NotNull
            public final Builder maxAssetCount(int maxAssetCount) {
                this.maxAssetCount = Integer.valueOf(maxAssetCount);
                return this;
            }

            @NotNull
            public final Builder maxImageDuration(int maxImageDuration) {
                this.maxImageDuration = Integer.valueOf(maxImageDuration);
                return this;
            }

            @NotNull
            public final Builder minAssetCount(int minAssetCount) {
                this.minAssetCount = Integer.valueOf(minAssetCount);
                return this;
            }

            @NotNull
            public final Builder minImageDuration(int minImageDuration) {
                this.minImageDuration = Integer.valueOf(minImageDuration);
                return this;
            }

            @NotNull
            public final Builder minVideoDuration(int minVideoDuration) {
                this.minVideoDuration = Integer.valueOf(minVideoDuration);
                return this;
            }

            @NotNull
            public final Builder preferredCoverTime(long preferredCoverTime) {
                this.preferredCoverTime = Long.valueOf(preferredCoverTime);
                return this;
            }

            @NotNull
            public final Builder type(@Nullable MediaType type) {
                this.type = type;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public MaterialConfig build() {
                MediaType mediaType = this.type;
                Integer num = this.minAssetCount;
                if (num != null) {
                    int intValue = num.intValue();
                    Integer num2 = this.maxAssetCount;
                    if (num2 != null) {
                        int intValue2 = num2.intValue();
                        Integer num3 = this.minVideoDuration;
                        if (num3 != null) {
                            int intValue3 = num3.intValue();
                            Integer num4 = this.minImageDuration;
                            if (num4 != null) {
                                int intValue4 = num4.intValue();
                                Integer num5 = this.maxImageDuration;
                                if (num5 != null) {
                                    int intValue5 = num5.intValue();
                                    Long l3 = this.preferredCoverTime;
                                    if (l3 != null) {
                                        return new MaterialConfig(mediaType, intValue, intValue2, intValue3, intValue4, intValue5, l3.longValue(), buildUnknownFields());
                                    }
                                    throw Internal.missingRequiredFields(l3, "preferredCoverTime");
                                }
                                throw Internal.missingRequiredFields(num5, "maxImageDuration");
                            }
                            throw Internal.missingRequiredFields(num4, "minImageDuration");
                        }
                        throw Internal.missingRequiredFields(num3, "minVideoDuration");
                    }
                    throw Internal.missingRequiredFields(num2, "maxAssetCount");
                }
                throw Internal.missingRequiredFields(num, "minAssetCount");
            }
        }

        static {
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MaterialConfig.class);
            final String str = "type.googleapis.com/publisher.LightAssetModel.MaterialConfig";
            ProtoAdapter<MaterialConfig> protoAdapter = new ProtoAdapter<MaterialConfig>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.LightAssetModel$MaterialConfig$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public LightAssetModel.MaterialConfig decode(@NotNull ProtoReader reader) {
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    Integer num = null;
                    LightAssetModel.MediaType mediaType = null;
                    Integer num2 = null;
                    Integer num3 = null;
                    Integer num4 = null;
                    Integer num5 = null;
                    Long l3 = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                            if (num != null) {
                                int intValue = num.intValue();
                                if (num2 != null) {
                                    int intValue2 = num2.intValue();
                                    if (num3 != null) {
                                        int intValue3 = num3.intValue();
                                        if (num4 != null) {
                                            int intValue4 = num4.intValue();
                                            if (num5 != null) {
                                                int intValue5 = num5.intValue();
                                                if (l3 != null) {
                                                    return new LightAssetModel.MaterialConfig(mediaType, intValue, intValue2, intValue3, intValue4, intValue5, l3.longValue(), endMessageAndGetUnknownFields);
                                                }
                                                throw Internal.missingRequiredFields(l3, "preferredCoverTime");
                                            }
                                            throw Internal.missingRequiredFields(num5, "maxImageDuration");
                                        }
                                        throw Internal.missingRequiredFields(num4, "minImageDuration");
                                    }
                                    throw Internal.missingRequiredFields(num3, "minVideoDuration");
                                }
                                throw Internal.missingRequiredFields(num2, "maxAssetCount");
                            }
                            throw Internal.missingRequiredFields(num, "minAssetCount");
                        }
                        switch (nextTag) {
                            case 1:
                                try {
                                    mediaType = LightAssetModel.MediaType.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                            case 2:
                                num = ProtoAdapter.INT32.decode(reader);
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
                                num5 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 7:
                                l3 = ProtoAdapter.INT64.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull LightAssetModel.MaterialConfig value) {
                    Intrinsics.checkParameterIsNotNull(writer, "writer");
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    LightAssetModel.MediaType.ADAPTER.encodeWithTag(writer, 1, value.type);
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    protoAdapter2.encodeWithTag(writer, 2, Integer.valueOf(value.minAssetCount));
                    protoAdapter2.encodeWithTag(writer, 3, Integer.valueOf(value.maxAssetCount));
                    protoAdapter2.encodeWithTag(writer, 4, Integer.valueOf(value.minVideoDuration));
                    protoAdapter2.encodeWithTag(writer, 5, Integer.valueOf(value.minImageDuration));
                    protoAdapter2.encodeWithTag(writer, 6, Integer.valueOf(value.maxImageDuration));
                    ProtoAdapter.INT64.encodeWithTag(writer, 7, Long.valueOf(value.preferredCoverTime));
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull LightAssetModel.MaterialConfig value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    int encodedSizeWithTag = LightAssetModel.MediaType.ADAPTER.encodedSizeWithTag(1, value.type);
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.minAssetCount)) + protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.maxAssetCount)) + protoAdapter2.encodedSizeWithTag(4, Integer.valueOf(value.minVideoDuration)) + protoAdapter2.encodedSizeWithTag(5, Integer.valueOf(value.minImageDuration)) + protoAdapter2.encodedSizeWithTag(6, Integer.valueOf(value.maxImageDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(7, Long.valueOf(value.preferredCoverTime)) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public LightAssetModel.MaterialConfig redact(@NotNull LightAssetModel.MaterialConfig value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    return LightAssetModel.MaterialConfig.copy$default(value, null, 0, 0, 0, 0, 0, 0L, ByteString.EMPTY, 127, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public /* synthetic */ MaterialConfig(MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, ByteString byteString, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this((i26 & 1) != 0 ? null : mediaType, i3, i16, i17, i18, i19, j3, (i26 & 128) != 0 ? ByteString.EMPTY : byteString);
        }

        public static /* synthetic */ MaterialConfig copy$default(MaterialConfig materialConfig, MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, ByteString byteString, int i26, Object obj) {
            MediaType mediaType2;
            int i27;
            int i28;
            int i29;
            int i36;
            int i37;
            long j16;
            ByteString byteString2;
            if ((i26 & 1) != 0) {
                mediaType2 = materialConfig.type;
            } else {
                mediaType2 = mediaType;
            }
            if ((i26 & 2) != 0) {
                i27 = materialConfig.minAssetCount;
            } else {
                i27 = i3;
            }
            if ((i26 & 4) != 0) {
                i28 = materialConfig.maxAssetCount;
            } else {
                i28 = i16;
            }
            if ((i26 & 8) != 0) {
                i29 = materialConfig.minVideoDuration;
            } else {
                i29 = i17;
            }
            if ((i26 & 16) != 0) {
                i36 = materialConfig.minImageDuration;
            } else {
                i36 = i18;
            }
            if ((i26 & 32) != 0) {
                i37 = materialConfig.maxImageDuration;
            } else {
                i37 = i19;
            }
            if ((i26 & 64) != 0) {
                j16 = materialConfig.preferredCoverTime;
            } else {
                j16 = j3;
            }
            if ((i26 & 128) != 0) {
                byteString2 = materialConfig.unknownFields();
            } else {
                byteString2 = byteString;
            }
            return materialConfig.copy(mediaType2, i27, i28, i29, i36, i37, j16, byteString2);
        }

        @NotNull
        public final MaterialConfig copy(@Nullable MediaType type, int minAssetCount, int maxAssetCount, int minVideoDuration, int minImageDuration, int maxImageDuration, long preferredCoverTime, @NotNull ByteString unknownFields) {
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            return new MaterialConfig(type, minAssetCount, maxAssetCount, minVideoDuration, minImageDuration, maxImageDuration, preferredCoverTime, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof MaterialConfig)) {
                return false;
            }
            MaterialConfig materialConfig = (MaterialConfig) other;
            if (Intrinsics.areEqual(unknownFields(), materialConfig.unknownFields()) && this.type == materialConfig.type && this.minAssetCount == materialConfig.minAssetCount && this.maxAssetCount == materialConfig.maxAssetCount && this.minVideoDuration == materialConfig.minVideoDuration && this.minImageDuration == materialConfig.minImageDuration && this.maxImageDuration == materialConfig.maxImageDuration && this.preferredCoverTime == materialConfig.preferredCoverTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = this.hashCode;
            if (i16 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                MediaType mediaType = this.type;
                if (mediaType != null) {
                    i3 = mediaType.hashCode();
                } else {
                    i3 = 0;
                }
                int a16 = ((((((((((((hashCode + i3) * 37) + this.minAssetCount) * 37) + this.maxAssetCount) * 37) + this.minVideoDuration) * 37) + this.minImageDuration) * 37) + this.maxImageDuration) * 37) + a.a(this.preferredCoverTime);
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
            if (this.type != null) {
                arrayList.add("type=" + this.type);
            }
            arrayList.add("minAssetCount=" + this.minAssetCount);
            arrayList.add("maxAssetCount=" + this.maxAssetCount);
            arrayList.add("minVideoDuration=" + this.minVideoDuration);
            arrayList.add("minImageDuration=" + this.minImageDuration);
            arrayList.add("maxImageDuration=" + this.maxImageDuration);
            arrayList.add("preferredCoverTime=" + this.preferredCoverTime);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "MaterialConfig{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MaterialConfig(@Nullable MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            this.type = mediaType;
            this.minAssetCount = i3;
            this.maxAssetCount = i16;
            this.minVideoDuration = i17;
            this.minImageDuration = i18;
            this.maxImageDuration = i19;
            this.preferredCoverTime = j3;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.type = this.type;
            builder.minAssetCount = Integer.valueOf(this.minAssetCount);
            builder.maxAssetCount = Integer.valueOf(this.maxAssetCount);
            builder.minVideoDuration = Integer.valueOf(this.minVideoDuration);
            builder.minImageDuration = Integer.valueOf(this.minImageDuration);
            builder.maxImageDuration = Integer.valueOf(this.maxImageDuration);
            builder.preferredCoverTime = Long.valueOf(this.preferredCoverTime);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "VIDEO_ONLY", "PHOTO_ONLY", "MULTI_MEDIA", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum MediaType implements WireEnum {
        VIDEO_ONLY(0),
        PHOTO_ONLY(1),
        MULTI_MEDIA(2);


        @JvmField
        @NotNull
        public static final ProtoAdapter<MediaType> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/model/LightAssetModel$MediaType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LightAssetModel$MediaType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Companion {
            Companion() {
            }

            @JvmStatic
            @Nullable
            public final MediaType fromValue(int value) {
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            return null;
                        }
                        return MediaType.MULTI_MEDIA;
                    }
                    return MediaType.PHOTO_ONLY;
                }
                return MediaType.VIDEO_ONLY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MediaType.class);
            ADAPTER = new EnumAdapter<MediaType>(orCreateKotlinClass) { // from class: com.tencent.tavcut.model.LightAssetModel$MediaType$Companion$ADAPTER$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public LightAssetModel.MediaType fromValue(int value) {
                    return LightAssetModel.MediaType.INSTANCE.fromValue(value);
                }
            };
        }

        MediaType(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final MediaType fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LightAssetModel.class);
        final String str = "type.googleapis.com/publisher.LightAssetModel";
        ProtoAdapter<LightAssetModel> protoAdapter = new ProtoAdapter<LightAssetModel>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.LightAssetModel$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LightAssetModel decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                long beginMessage = reader.beginMessage();
                LightAssetModel.MaterialConfig materialConfig = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new LightAssetModel(arrayList, arrayList2, materialConfig, arrayList3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        arrayList.add(LightAssetModel.FontAsset.ADAPTER.decode(reader));
                    } else if (nextTag == 2) {
                        arrayList2.add(ProtoAdapter.STRING.decode(reader));
                    } else if (nextTag == 4) {
                        materialConfig = LightAssetModel.MaterialConfig.ADAPTER.decode(reader);
                    } else if (nextTag != 5) {
                        reader.readUnknownField(nextTag);
                    } else {
                        arrayList3.add(ProtoAdapter.STRING.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull LightAssetModel value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                LightAssetModel.FontAsset.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.fontAssets);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.musicIds);
                LightAssetModel.MaterialConfig.ADAPTER.encodeWithTag(writer, 4, value.materialConfig);
                protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.boundsTrackerPlaceHolders);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull LightAssetModel value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                int encodedSizeWithTag = LightAssetModel.FontAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, value.fontAssets);
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.musicIds) + LightAssetModel.MaterialConfig.ADAPTER.encodedSizeWithTag(4, value.materialConfig) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.boundsTrackerPlaceHolders) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public LightAssetModel redact(@NotNull LightAssetModel value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                List m87redactElements = Internal.m87redactElements(value.fontAssets, LightAssetModel.FontAsset.ADAPTER);
                LightAssetModel.MaterialConfig materialConfig = value.materialConfig;
                return LightAssetModel.copy$default(value, m87redactElements, null, materialConfig != null ? LightAssetModel.MaterialConfig.ADAPTER.redact(materialConfig) : null, null, ByteString.EMPTY, 10, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public LightAssetModel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ LightAssetModel copy$default(LightAssetModel lightAssetModel, List list, List list2, MaterialConfig materialConfig, List list3, ByteString byteString, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = lightAssetModel.fontAssets;
        }
        if ((i3 & 2) != 0) {
            list2 = lightAssetModel.musicIds;
        }
        List list4 = list2;
        if ((i3 & 4) != 0) {
            materialConfig = lightAssetModel.materialConfig;
        }
        MaterialConfig materialConfig2 = materialConfig;
        if ((i3 & 8) != 0) {
            list3 = lightAssetModel.boundsTrackerPlaceHolders;
        }
        List list5 = list3;
        if ((i3 & 16) != 0) {
            byteString = lightAssetModel.unknownFields();
        }
        return lightAssetModel.copy(list, list4, materialConfig2, list5, byteString);
    }

    @NotNull
    public final LightAssetModel copy(@NotNull List<FontAsset> fontAssets, @NotNull List<String> musicIds, @Nullable MaterialConfig materialConfig, @NotNull List<String> boundsTrackerPlaceHolders, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(fontAssets, "fontAssets");
        Intrinsics.checkParameterIsNotNull(musicIds, "musicIds");
        Intrinsics.checkParameterIsNotNull(boundsTrackerPlaceHolders, "boundsTrackerPlaceHolders");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new LightAssetModel(fontAssets, musicIds, materialConfig, boundsTrackerPlaceHolders, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LightAssetModel)) {
            return false;
        }
        LightAssetModel lightAssetModel = (LightAssetModel) other;
        if (Intrinsics.areEqual(unknownFields(), lightAssetModel.unknownFields()) && Intrinsics.areEqual(this.fontAssets, lightAssetModel.fontAssets) && Intrinsics.areEqual(this.musicIds, lightAssetModel.musicIds) && Intrinsics.areEqual(this.materialConfig, lightAssetModel.materialConfig) && Intrinsics.areEqual(this.boundsTrackerPlaceHolders, lightAssetModel.boundsTrackerPlaceHolders)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.fontAssets.hashCode()) * 37) + this.musicIds.hashCode()) * 37;
            MaterialConfig materialConfig = this.materialConfig;
            if (materialConfig != null) {
                i3 = materialConfig.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.boundsTrackerPlaceHolders.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (!this.fontAssets.isEmpty()) {
            arrayList.add("fontAssets=" + this.fontAssets);
        }
        if (!this.musicIds.isEmpty()) {
            arrayList.add("musicIds=" + Internal.sanitize(this.musicIds));
        }
        if (this.materialConfig != null) {
            arrayList.add("materialConfig=" + this.materialConfig);
        }
        if (!this.boundsTrackerPlaceHolders.isEmpty()) {
            arrayList.add("boundsTrackerPlaceHolders=" + Internal.sanitize(this.boundsTrackerPlaceHolders));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LightAssetModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ LightAssetModel(List list, List list2, MaterialConfig materialConfig, List list3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? null : materialConfig, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i3 & 16) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.fontAssets = this.fontAssets;
        builder.musicIds = this.musicIds;
        builder.materialConfig = this.materialConfig;
        builder.boundsTrackerPlaceHolders = this.boundsTrackerPlaceHolders;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightAssetModel(@NotNull List<FontAsset> fontAssets, @NotNull List<String> musicIds, @Nullable MaterialConfig materialConfig, @NotNull List<String> boundsTrackerPlaceHolders, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(fontAssets, "fontAssets");
        Intrinsics.checkParameterIsNotNull(musicIds, "musicIds");
        Intrinsics.checkParameterIsNotNull(boundsTrackerPlaceHolders, "boundsTrackerPlaceHolders");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.fontAssets = fontAssets;
        this.musicIds = musicIds;
        this.materialConfig = materialConfig;
        this.boundsTrackerPlaceHolders = boundsTrackerPlaceHolders;
    }
}
