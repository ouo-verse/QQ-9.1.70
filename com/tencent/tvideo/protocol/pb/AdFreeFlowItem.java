package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdFreeFlowItem extends Message<AdFreeFlowItem, a> {
    public static final ProtoAdapter<AdFreeFlowItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "flowSubType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int flow_sub_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFreeFlowType#ADAPTER", jsonName = "flowType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdFreeFlowType flow_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "userMob", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String user_mob;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFreeFlowItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdFreeFlowType f383613a = AdFreeFlowType.AD_FREE_FLOW_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public int f383614b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f383615c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFreeFlowItem build() {
            return new AdFreeFlowItem(this.f383613a, this.f383614b, this.f383615c, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f383614b = i3;
            return this;
        }

        public a c(AdFreeFlowType adFreeFlowType) {
            this.f383613a = adFreeFlowType;
            return this;
        }

        public a d(String str) {
            this.f383615c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFreeFlowItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFreeFlowItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFreeFlowItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFreeFlowItem decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        try {
                            aVar.c(AdFreeFlowType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdFreeFlowItem adFreeFlowItem) throws IOException {
            if (!Objects.equals(adFreeFlowItem.flow_type, AdFreeFlowType.AD_FREE_FLOW_TYPE_UNKNOWN)) {
                AdFreeFlowType.ADAPTER.encodeWithTag(protoWriter, 1, adFreeFlowItem.flow_type);
            }
            if (!Objects.equals(Integer.valueOf(adFreeFlowItem.flow_sub_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adFreeFlowItem.flow_sub_type));
            }
            if (!Objects.equals(adFreeFlowItem.user_mob, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adFreeFlowItem.user_mob);
            }
            protoWriter.writeBytes(adFreeFlowItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFreeFlowItem adFreeFlowItem) {
            int i3;
            if (!Objects.equals(adFreeFlowItem.flow_type, AdFreeFlowType.AD_FREE_FLOW_TYPE_UNKNOWN)) {
                i3 = AdFreeFlowType.ADAPTER.encodedSizeWithTag(1, adFreeFlowItem.flow_type) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(adFreeFlowItem.flow_sub_type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adFreeFlowItem.flow_sub_type));
            }
            if (!Objects.equals(adFreeFlowItem.user_mob, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adFreeFlowItem.user_mob);
            }
            return i3 + adFreeFlowItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFreeFlowItem redact(AdFreeFlowItem adFreeFlowItem) {
            a newBuilder = adFreeFlowItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFreeFlowItem(AdFreeFlowType adFreeFlowType, int i3, String str) {
        this(adFreeFlowType, i3, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFreeFlowItem)) {
            return false;
        }
        AdFreeFlowItem adFreeFlowItem = (AdFreeFlowItem) obj;
        if (unknownFields().equals(adFreeFlowItem.unknownFields()) && Internal.equals(this.flow_type, adFreeFlowItem.flow_type) && Internal.equals(Integer.valueOf(this.flow_sub_type), Integer.valueOf(adFreeFlowItem.flow_sub_type)) && Internal.equals(this.user_mob, adFreeFlowItem.user_mob)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdFreeFlowType adFreeFlowType = this.flow_type;
            int i17 = 0;
            if (adFreeFlowType != null) {
                i3 = adFreeFlowType.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (((hashCode + i3) * 37) + this.flow_sub_type) * 37;
            String str = this.user_mob;
            if (str != null) {
                i17 = str.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.flow_type != null) {
            sb5.append(", flow_type=");
            sb5.append(this.flow_type);
        }
        sb5.append(", flow_sub_type=");
        sb5.append(this.flow_sub_type);
        if (this.user_mob != null) {
            sb5.append(", user_mob=");
            sb5.append(Internal.sanitize(this.user_mob));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFreeFlowItem{");
        replace.append('}');
        return replace.toString();
    }

    public AdFreeFlowItem(AdFreeFlowType adFreeFlowType, int i3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adFreeFlowType != null) {
            this.flow_type = adFreeFlowType;
            this.flow_sub_type = i3;
            if (str != null) {
                this.user_mob = str;
                return;
            }
            throw new IllegalArgumentException("user_mob == null");
        }
        throw new IllegalArgumentException("flow_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383613a = this.flow_type;
        aVar.f383614b = this.flow_sub_type;
        aVar.f383615c = this.user_mob;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
