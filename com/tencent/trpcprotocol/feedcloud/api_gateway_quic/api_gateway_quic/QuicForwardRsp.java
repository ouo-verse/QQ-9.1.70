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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class QuicForwardRsp extends Message<QuicForwardRsp, a> {
    public static final ProtoAdapter<QuicForwardRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final ByteString body;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "compressType", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int compress_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int retcode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String retmsg;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<QuicForwardRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f381291a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f381292b = "";

        /* renamed from: c, reason: collision with root package name */
        public ByteString f381293c = ByteString.EMPTY;

        /* renamed from: d, reason: collision with root package name */
        public int f381294d = 0;

        public a a(ByteString byteString) {
            this.f381293c = byteString;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QuicForwardRsp build() {
            return new QuicForwardRsp(this.f381291a, this.f381292b, this.f381293c, this.f381294d, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f381294d = i3;
            return this;
        }

        public a d(int i3) {
            this.f381291a = i3;
            return this;
        }

        public a e(String str) {
            this.f381292b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<QuicForwardRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) QuicForwardRsp.class, "type.googleapis.com/trpc.feedcloud.api_gateway_quic.QuicForwardRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QuicForwardRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.c(ProtoAdapter.UINT32.decode(protoReader).intValue());
                                }
                            } else {
                                aVar.a(ProtoAdapter.BYTES.decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, QuicForwardRsp quicForwardRsp) throws IOException {
            if (!Objects.equals(Integer.valueOf(quicForwardRsp.retcode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(quicForwardRsp.retcode));
            }
            if (!Objects.equals(quicForwardRsp.retmsg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, quicForwardRsp.retmsg);
            }
            if (!Objects.equals(quicForwardRsp.body, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 3, quicForwardRsp.body);
            }
            if (!Objects.equals(Integer.valueOf(quicForwardRsp.compress_type), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, Integer.valueOf(quicForwardRsp.compress_type));
            }
            protoWriter.writeBytes(quicForwardRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(QuicForwardRsp quicForwardRsp) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(quicForwardRsp.retcode), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(quicForwardRsp.retcode));
            }
            if (!Objects.equals(quicForwardRsp.retmsg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, quicForwardRsp.retmsg);
            }
            if (!Objects.equals(quicForwardRsp.body, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(3, quicForwardRsp.body);
            }
            if (!Objects.equals(Integer.valueOf(quicForwardRsp.compress_type), 0)) {
                i3 += ProtoAdapter.UINT32.encodedSizeWithTag(4, Integer.valueOf(quicForwardRsp.compress_type));
            }
            return i3 + quicForwardRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public QuicForwardRsp redact(QuicForwardRsp quicForwardRsp) {
            a newBuilder = quicForwardRsp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public QuicForwardRsp(int i3, String str, ByteString byteString, int i16) {
        this(i3, str, byteString, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuicForwardRsp)) {
            return false;
        }
        QuicForwardRsp quicForwardRsp = (QuicForwardRsp) obj;
        if (unknownFields().equals(quicForwardRsp.unknownFields()) && Internal.equals(Integer.valueOf(this.retcode), Integer.valueOf(quicForwardRsp.retcode)) && Internal.equals(this.retmsg, quicForwardRsp.retmsg) && Internal.equals(this.body, quicForwardRsp.body) && Internal.equals(Integer.valueOf(this.compress_type), Integer.valueOf(quicForwardRsp.compress_type))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.retcode) * 37;
            String str = this.retmsg;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            ByteString byteString = this.body;
            if (byteString != null) {
                i17 = byteString.hashCode();
            }
            int i19 = ((i18 + i17) * 37) + this.compress_type;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", retcode=");
        sb5.append(this.retcode);
        if (this.retmsg != null) {
            sb5.append(", retmsg=");
            sb5.append(Internal.sanitize(this.retmsg));
        }
        if (this.body != null) {
            sb5.append(", body=");
            sb5.append(this.body);
        }
        sb5.append(", compress_type=");
        sb5.append(this.compress_type);
        StringBuilder replace = sb5.replace(0, 2, "QuicForwardRsp{");
        replace.append('}');
        return replace.toString();
    }

    public QuicForwardRsp(int i3, String str, ByteString byteString, int i16, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.retcode = i3;
        if (str != null) {
            this.retmsg = str;
            if (byteString != null) {
                this.body = byteString;
                this.compress_type = i16;
                return;
            }
            throw new IllegalArgumentException("body == null");
        }
        throw new IllegalArgumentException("retmsg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f381291a = this.retcode;
        aVar.f381292b = this.retmsg;
        aVar.f381293c = this.body;
        aVar.f381294d = this.compress_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
