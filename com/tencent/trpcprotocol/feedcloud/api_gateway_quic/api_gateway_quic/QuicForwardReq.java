package com.tencent.trpcprotocol.feedcloud.api_gateway_quic.api_gateway_quic;

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
/* loaded from: classes10.dex */
public final class QuicForwardReq extends Message<QuicForwardReq, a> {
    public static final ProtoAdapter<QuicForwardReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final ByteString body;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 100)
    public final Map<String, String> exts;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "serializationType", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int serialization_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String service;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<QuicForwardReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f381285a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f381286b = "";

        /* renamed from: c, reason: collision with root package name */
        public ByteString f381287c = ByteString.EMPTY;

        /* renamed from: d, reason: collision with root package name */
        public int f381288d = 0;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f381289e = Internal.newMutableMap();

        public a a(ByteString byteString) {
            this.f381287c = byteString;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QuicForwardReq build() {
            return new QuicForwardReq(this.f381285a, this.f381286b, this.f381287c, this.f381288d, this.f381289e, super.buildUnknownFields());
        }

        public a c(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f381289e = map;
            return this;
        }

        public a d(String str) {
            this.f381286b = str;
            return this;
        }

        public a e(int i3) {
            this.f381288d = i3;
            return this;
        }

        public a f(String str) {
            this.f381285a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<QuicForwardReq> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f381290a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) QuicForwardReq.class, "type.googleapis.com/trpc.feedcloud.api_gateway_quic.QuicForwardReq", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f381290a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f381290a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QuicForwardReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 100) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.f381289e.putAll(d().decode(protoReader));
                                    }
                                } else {
                                    aVar.e(ProtoAdapter.UINT32.decode(protoReader).intValue());
                                }
                            } else {
                                aVar.a(ProtoAdapter.BYTES.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.f(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, QuicForwardReq quicForwardReq) throws IOException {
            if (!Objects.equals(quicForwardReq.service, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, quicForwardReq.service);
            }
            if (!Objects.equals(quicForwardReq.method, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, quicForwardReq.method);
            }
            if (!Objects.equals(quicForwardReq.body, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 3, quicForwardReq.body);
            }
            if (!Objects.equals(Integer.valueOf(quicForwardReq.serialization_type), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, Integer.valueOf(quicForwardReq.serialization_type));
            }
            d().encodeWithTag(protoWriter, 100, quicForwardReq.exts);
            protoWriter.writeBytes(quicForwardReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(QuicForwardReq quicForwardReq) {
            int i3;
            if (!Objects.equals(quicForwardReq.service, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, quicForwardReq.service) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(quicForwardReq.method, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, quicForwardReq.method);
            }
            if (!Objects.equals(quicForwardReq.body, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(3, quicForwardReq.body);
            }
            if (!Objects.equals(Integer.valueOf(quicForwardReq.serialization_type), 0)) {
                i3 += ProtoAdapter.UINT32.encodedSizeWithTag(4, Integer.valueOf(quicForwardReq.serialization_type));
            }
            return i3 + d().encodedSizeWithTag(100, quicForwardReq.exts) + quicForwardReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QuicForwardReq redact(QuicForwardReq quicForwardReq) {
            a newBuilder = quicForwardReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public QuicForwardReq(String str, String str2, ByteString byteString, int i3, Map<String, String> map) {
        this(str, str2, byteString, i3, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuicForwardReq)) {
            return false;
        }
        QuicForwardReq quicForwardReq = (QuicForwardReq) obj;
        if (unknownFields().equals(quicForwardReq.unknownFields()) && Internal.equals(this.service, quicForwardReq.service) && Internal.equals(this.method, quicForwardReq.method) && Internal.equals(this.body, quicForwardReq.body) && Internal.equals(Integer.valueOf(this.serialization_type), Integer.valueOf(quicForwardReq.serialization_type)) && this.exts.equals(quicForwardReq.exts)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.service;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.method;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            ByteString byteString = this.body;
            if (byteString != null) {
                i18 = byteString.hashCode();
            }
            int hashCode2 = ((((i26 + i18) * 37) + this.serialization_type) * 37) + this.exts.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.service != null) {
            sb5.append(", service=");
            sb5.append(Internal.sanitize(this.service));
        }
        if (this.method != null) {
            sb5.append(", method=");
            sb5.append(Internal.sanitize(this.method));
        }
        if (this.body != null) {
            sb5.append(", body=");
            sb5.append(this.body);
        }
        sb5.append(", serialization_type=");
        sb5.append(this.serialization_type);
        if (!this.exts.isEmpty()) {
            sb5.append(", exts=");
            sb5.append(this.exts);
        }
        StringBuilder replace = sb5.replace(0, 2, "QuicForwardReq{");
        replace.append('}');
        return replace.toString();
    }

    public QuicForwardReq(String str, String str2, ByteString byteString, int i3, Map<String, String> map, ByteString byteString2) {
        super(ADAPTER, byteString2);
        if (str != null) {
            this.service = str;
            if (str2 != null) {
                this.method = str2;
                if (byteString != null) {
                    this.body = byteString;
                    this.serialization_type = i3;
                    this.exts = Internal.immutableCopyOf("exts", map);
                    return;
                }
                throw new IllegalArgumentException("body == null");
            }
            throw new IllegalArgumentException("method == null");
        }
        throw new IllegalArgumentException("service == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f381285a = this.service;
        aVar.f381286b = this.method;
        aVar.f381287c = this.body;
        aVar.f381288d = this.serialization_type;
        aVar.f381289e = Internal.copyOf(this.exts);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
