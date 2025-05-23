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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DynamicInfo extends Message<DynamicInfo, a> {
    public static final ProtoAdapter<DynamicInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> extra;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String moduleId;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<DynamicInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383745a = "";

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f383746b = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicInfo build() {
            return new DynamicInfo(this.f383745a, this.f383746b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383745a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<DynamicInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383747a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DynamicInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.DynamicInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383747a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383747a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f383746b.putAll(d().decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, DynamicInfo dynamicInfo) throws IOException {
            if (!Objects.equals(dynamicInfo.moduleId, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, dynamicInfo.moduleId);
            }
            d().encodeWithTag(protoWriter, 2, dynamicInfo.extra);
            protoWriter.writeBytes(dynamicInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(DynamicInfo dynamicInfo) {
            int i3 = 0;
            if (!Objects.equals(dynamicInfo.moduleId, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, dynamicInfo.moduleId);
            }
            return i3 + d().encodedSizeWithTag(2, dynamicInfo.extra) + dynamicInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public DynamicInfo redact(DynamicInfo dynamicInfo) {
            a newBuilder = dynamicInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DynamicInfo(String str, Map<String, String> map) {
        this(str, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicInfo)) {
            return false;
        }
        DynamicInfo dynamicInfo = (DynamicInfo) obj;
        if (unknownFields().equals(dynamicInfo.unknownFields()) && Internal.equals(this.moduleId, dynamicInfo.moduleId) && this.extra.equals(dynamicInfo.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.moduleId;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.extra.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.moduleId != null) {
            sb5.append(", moduleId=");
            sb5.append(Internal.sanitize(this.moduleId));
        }
        if (!this.extra.isEmpty()) {
            sb5.append(", extra=");
            sb5.append(this.extra);
        }
        StringBuilder replace = sb5.replace(0, 2, "DynamicInfo{");
        replace.append('}');
        return replace.toString();
    }

    public DynamicInfo(String str, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.moduleId = str;
            this.extra = Internal.immutableCopyOf("extra", map);
            return;
        }
        throw new IllegalArgumentException("moduleId == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383745a = this.moduleId;
        aVar.f383746b = Internal.copyOf(this.extra);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
