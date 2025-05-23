package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ6\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper$Builder;", "usedPoiModel", "Lcom/tencent/videocut/model/WatermarkPoiModel;", "usedPoiModelIndex", "", "poiModelList", "", "unknownFields", "Lokio/ByteString;", "(Lcom/tencent/videocut/model/WatermarkPoiModel;ILjava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class WatermarkPoiModelWrapper extends AndroidMessage<WatermarkPoiModelWrapper, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<WatermarkPoiModelWrapper> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WatermarkPoiModelWrapper> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkPoiModel#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    @JvmField
    @NotNull
    public final List<WatermarkPoiModel> poiModelList;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkPoiModel#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    @JvmField
    @Nullable
    public final WatermarkPoiModel usedPoiModel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    @JvmField
    public final int usedPoiModelIndex;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModelWrapper$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", "()V", "poiModelList", "", "Lcom/tencent/videocut/model/WatermarkPoiModel;", "usedPoiModel", "usedPoiModelIndex", "", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<WatermarkPoiModelWrapper, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public List<WatermarkPoiModel> poiModelList;

        @JvmField
        @Nullable
        public WatermarkPoiModel usedPoiModel;

        @JvmField
        public int usedPoiModelIndex;

        public Builder() {
            List<WatermarkPoiModel> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.poiModelList = emptyList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder poiModelList(@NotNull List<WatermarkPoiModel> poiModelList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) poiModelList);
            }
            Intrinsics.checkNotNullParameter(poiModelList, "poiModelList");
            Internal.checkElementsNotNull(poiModelList);
            this.poiModelList = poiModelList;
            return this;
        }

        @NotNull
        public final Builder usedPoiModel(@Nullable WatermarkPoiModel usedPoiModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) usedPoiModel);
            }
            this.usedPoiModel = usedPoiModel;
            return this;
        }

        @NotNull
        public final Builder usedPoiModelIndex(int usedPoiModelIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, usedPoiModelIndex);
            }
            this.usedPoiModelIndex = usedPoiModelIndex;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public WatermarkPoiModelWrapper build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new WatermarkPoiModelWrapper(this.usedPoiModel, this.usedPoiModelIndex, this.poiModelList, buildUnknownFields()) : (WatermarkPoiModelWrapper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModelWrapper$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WatermarkPoiModelWrapper.class);
        final Syntax syntax = Syntax.PROTO_3;
        ProtoAdapter<WatermarkPoiModelWrapper> protoAdapter = new ProtoAdapter<WatermarkPoiModelWrapper>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.tencent.videocut.model.WatermarkPoiModelWrapper$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/model.WatermarkPoiModelWrapper", syntax, (Object) null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, fieldEncoding, orCreateKotlinClass, syntax);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkPoiModelWrapper decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (WatermarkPoiModelWrapper) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                WatermarkPoiModel watermarkPoiModel = null;
                int i3 = 0;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new WatermarkPoiModelWrapper(watermarkPoiModel, i3, arrayList, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1) {
                        watermarkPoiModel = WatermarkPoiModel.ADAPTER.decode(reader);
                    } else if (nextTag == 2) {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (nextTag != 3) {
                        reader.readUnknownField(nextTag);
                    } else {
                        arrayList.add(WatermarkPoiModel.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull WatermarkPoiModelWrapper value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                WatermarkPoiModel watermarkPoiModel = value.usedPoiModel;
                if (watermarkPoiModel != null) {
                    WatermarkPoiModel.ADAPTER.encodeWithTag(writer, 1, watermarkPoiModel);
                }
                int i3 = value.usedPoiModelIndex;
                if (i3 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(i3));
                }
                WatermarkPoiModel.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.poiModelList);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull WatermarkPoiModelWrapper value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int size = value.unknownFields().size();
                WatermarkPoiModel watermarkPoiModel = value.usedPoiModel;
                if (watermarkPoiModel != null) {
                    size += WatermarkPoiModel.ADAPTER.encodedSizeWithTag(1, watermarkPoiModel);
                }
                int i3 = value.usedPoiModelIndex;
                if (i3 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(i3));
                }
                return size + WatermarkPoiModel.ADAPTER.asRepeated().encodedSizeWithTag(3, value.poiModelList);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkPoiModelWrapper redact(@NotNull WatermarkPoiModelWrapper value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (WatermarkPoiModelWrapper) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                WatermarkPoiModel watermarkPoiModel = value.usedPoiModel;
                return WatermarkPoiModelWrapper.copy$default(value, watermarkPoiModel != null ? WatermarkPoiModel.ADAPTER.redact(watermarkPoiModel) : null, 0, Internal.m87redactElements(value.poiModelList, WatermarkPoiModel.ADAPTER), ByteString.EMPTY, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public WatermarkPoiModelWrapper() {
        this(null, 0, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WatermarkPoiModelWrapper copy$default(WatermarkPoiModelWrapper watermarkPoiModelWrapper, WatermarkPoiModel watermarkPoiModel, int i3, List list, ByteString byteString, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            watermarkPoiModel = watermarkPoiModelWrapper.usedPoiModel;
        }
        if ((i16 & 2) != 0) {
            i3 = watermarkPoiModelWrapper.usedPoiModelIndex;
        }
        if ((i16 & 4) != 0) {
            list = watermarkPoiModelWrapper.poiModelList;
        }
        if ((i16 & 8) != 0) {
            byteString = watermarkPoiModelWrapper.unknownFields();
        }
        return watermarkPoiModelWrapper.copy(watermarkPoiModel, i3, list, byteString);
    }

    @NotNull
    public final WatermarkPoiModelWrapper copy(@Nullable WatermarkPoiModel usedPoiModel, int usedPoiModelIndex, @NotNull List<WatermarkPoiModel> poiModelList, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WatermarkPoiModelWrapper) iPatchRedirector.redirect((short) 7, this, usedPoiModel, Integer.valueOf(usedPoiModelIndex), poiModelList, unknownFields);
        }
        Intrinsics.checkNotNullParameter(poiModelList, "poiModelList");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new WatermarkPoiModelWrapper(usedPoiModel, usedPoiModelIndex, poiModelList, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof WatermarkPoiModelWrapper)) {
            return false;
        }
        WatermarkPoiModelWrapper watermarkPoiModelWrapper = (WatermarkPoiModelWrapper) other;
        if (Intrinsics.areEqual(unknownFields(), watermarkPoiModelWrapper.unknownFields()) && Intrinsics.areEqual(this.usedPoiModel, watermarkPoiModelWrapper.usedPoiModel) && this.usedPoiModelIndex == watermarkPoiModelWrapper.usedPoiModelIndex && Intrinsics.areEqual(this.poiModelList, watermarkPoiModelWrapper.poiModelList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            WatermarkPoiModel watermarkPoiModel = this.usedPoiModel;
            if (watermarkPoiModel != null) {
                i3 = watermarkPoiModel.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((((hashCode + i3) * 37) + this.usedPoiModelIndex) * 37) + this.poiModelList.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
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
        WatermarkPoiModel watermarkPoiModel = this.usedPoiModel;
        if (watermarkPoiModel != null) {
            arrayList.add("usedPoiModel=" + watermarkPoiModel);
        }
        arrayList.add("usedPoiModelIndex=" + this.usedPoiModelIndex);
        if (!this.poiModelList.isEmpty()) {
            arrayList.add("poiModelList=" + this.poiModelList);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "WatermarkPoiModelWrapper{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ WatermarkPoiModelWrapper(WatermarkPoiModel watermarkPoiModel, int i3, List list, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : watermarkPoiModel, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 8) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, watermarkPoiModel, Integer.valueOf(i3), list, byteString, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.usedPoiModel = this.usedPoiModel;
        builder.usedPoiModelIndex = this.usedPoiModelIndex;
        builder.poiModelList = this.poiModelList;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkPoiModelWrapper(@Nullable WatermarkPoiModel watermarkPoiModel, int i3, @NotNull List<WatermarkPoiModel> poiModelList, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(poiModelList, "poiModelList");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, watermarkPoiModel, Integer.valueOf(i3), poiModelList, unknownFields);
            return;
        }
        this.usedPoiModel = watermarkPoiModel;
        this.usedPoiModelIndex = i3;
        this.poiModelList = Internal.immutableCopyOf("poiModelList", poiModelList);
    }
}
