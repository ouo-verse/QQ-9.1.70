package ar4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f26810a;

    /* renamed from: b, reason: collision with root package name */
    public String f26811b;

    /* renamed from: c, reason: collision with root package name */
    public String f26812c;

    /* renamed from: d, reason: collision with root package name */
    public String f26813d;

    /* renamed from: e, reason: collision with root package name */
    public C0066a f26814e;

    /* renamed from: f, reason: collision with root package name */
    public long f26815f;

    /* renamed from: g, reason: collision with root package name */
    public long f26816g;

    /* renamed from: h, reason: collision with root package name */
    public long f26817h;

    /* renamed from: i, reason: collision with root package name */
    public int f26818i;

    /* compiled from: P */
    /* renamed from: ar4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C0066a extends ExtendableMessageNano<C0066a> {

        /* renamed from: a, reason: collision with root package name */
        public String f26819a;

        /* renamed from: b, reason: collision with root package name */
        public String f26820b;

        public C0066a() {
            a();
        }

        public C0066a a() {
            this.f26819a = "";
            this.f26820b = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0066a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag != 0) {
                    if (readTag != 10) {
                        if (readTag != 18) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f26820b = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f26819a = codedInputByteBufferNano.readString();
                    }
                } else {
                    return this;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (!this.f26819a.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f26819a);
            }
            if (!this.f26820b.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f26820b);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f26819a.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f26819a);
            }
            if (!this.f26820b.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.f26820b);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f26810a = "";
        this.f26811b = "";
        this.f26812c = "";
        this.f26813d = "";
        this.f26814e = null;
        this.f26815f = 0L;
        this.f26816g = 0L;
        this.f26817h = 0L;
        this.f26818i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (readTag != 72) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                                        this.f26818i = readInt32;
                                                    }
                                                }
                                            } else {
                                                this.f26817h = codedInputByteBufferNano.readUInt64();
                                            }
                                        } else {
                                            this.f26816g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f26815f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    if (this.f26814e == null) {
                                        this.f26814e = new C0066a();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f26814e);
                                }
                            } else {
                                this.f26813d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f26812c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f26811b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f26810a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f26810a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f26810a);
        }
        if (!this.f26811b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f26811b);
        }
        if (!this.f26812c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f26812c);
        }
        if (!this.f26813d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f26813d);
        }
        C0066a c0066a = this.f26814e;
        if (c0066a != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0066a);
        }
        long j3 = this.f26815f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        long j16 = this.f26816g;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j16);
        }
        long j17 = this.f26817h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        int i3 = this.f26818i;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(9, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f26810a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f26810a);
        }
        if (!this.f26811b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f26811b);
        }
        if (!this.f26812c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f26812c);
        }
        if (!this.f26813d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f26813d);
        }
        C0066a c0066a = this.f26814e;
        if (c0066a != null) {
            codedOutputByteBufferNano.writeMessage(5, c0066a);
        }
        long j3 = this.f26815f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        long j16 = this.f26816g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        long j17 = this.f26817h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        int i3 = this.f26818i;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
