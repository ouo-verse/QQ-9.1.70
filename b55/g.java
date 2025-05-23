package b55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile g[] f27972f;

    /* renamed from: a, reason: collision with root package name */
    public int f27973a;

    /* renamed from: b, reason: collision with root package name */
    public String f27974b;

    /* renamed from: c, reason: collision with root package name */
    public String f27975c;

    /* renamed from: d, reason: collision with root package name */
    public int f27976d;

    /* renamed from: e, reason: collision with root package name */
    public int f27977e;

    public g() {
        a();
    }

    public static g[] b() {
        if (f27972f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f27972f == null) {
                    f27972f = new g[0];
                }
            }
        }
        return f27972f;
    }

    public static g d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f27973a = 0;
        this.f27974b = "";
        this.f27975c = "";
        this.f27976d = 0;
        this.f27977e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f27977e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f27976d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f27975c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f27974b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f27973a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f27973a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f27974b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f27974b);
        }
        if (!this.f27975c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f27975c);
        }
        int i16 = this.f27976d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f27977e;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f27973a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f27974b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f27974b);
        }
        if (!this.f27975c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f27975c);
        }
        int i16 = this.f27976d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f27977e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
