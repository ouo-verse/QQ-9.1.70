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
public final class AdDeviceInfo extends Message<AdDeviceInfo, a> {
    public static final ProtoAdapter<AdDeviceInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String idValue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int mergeIdType;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdDeviceInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383543a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f383544b = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdDeviceInfo build() {
            return new AdDeviceInfo(this.f383543a, this.f383544b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383543a = str;
            return this;
        }

        public a c(int i3) {
            this.f383544b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdDeviceInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdDeviceInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdDeviceInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdDeviceInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdDeviceInfo adDeviceInfo) throws IOException {
            if (!Objects.equals(adDeviceInfo.idValue, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adDeviceInfo.idValue);
            }
            if (!Objects.equals(Integer.valueOf(adDeviceInfo.mergeIdType), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adDeviceInfo.mergeIdType));
            }
            protoWriter.writeBytes(adDeviceInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdDeviceInfo adDeviceInfo) {
            int i3;
            if (!Objects.equals(adDeviceInfo.idValue, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, adDeviceInfo.idValue) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(adDeviceInfo.mergeIdType), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adDeviceInfo.mergeIdType));
            }
            return i3 + adDeviceInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdDeviceInfo redact(AdDeviceInfo adDeviceInfo) {
            a newBuilder = adDeviceInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdDeviceInfo(String str, int i3) {
        this(str, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdDeviceInfo)) {
            return false;
        }
        AdDeviceInfo adDeviceInfo = (AdDeviceInfo) obj;
        if (unknownFields().equals(adDeviceInfo.unknownFields()) && Internal.equals(this.idValue, adDeviceInfo.idValue) && Internal.equals(Integer.valueOf(this.mergeIdType), Integer.valueOf(adDeviceInfo.mergeIdType))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.idValue;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.mergeIdType;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.idValue != null) {
            sb5.append(", idValue=");
            sb5.append(Internal.sanitize(this.idValue));
        }
        sb5.append(", mergeIdType=");
        sb5.append(this.mergeIdType);
        StringBuilder replace = sb5.replace(0, 2, "AdDeviceInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdDeviceInfo(String str, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.idValue = str;
            this.mergeIdType = i3;
            return;
        }
        throw new IllegalArgumentException("idValue == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383543a = this.idValue;
        aVar.f383544b = this.mergeIdType;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
