package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile k[] f403136h;

    /* renamed from: a, reason: collision with root package name */
    public long f403137a;

    /* renamed from: b, reason: collision with root package name */
    public String f403138b;

    /* renamed from: c, reason: collision with root package name */
    public String f403139c;

    /* renamed from: d, reason: collision with root package name */
    public int f403140d;

    /* renamed from: e, reason: collision with root package name */
    public int f403141e;

    /* renamed from: f, reason: collision with root package name */
    public int f403142f;

    /* renamed from: g, reason: collision with root package name */
    public int f403143g;

    public k() {
        a();
    }

    public static k[] b() {
        if (f403136h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403136h == null) {
                    f403136h = new k[0];
                }
            }
        }
        return f403136h;
    }

    public static k d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (k) MessageNano.mergeFrom(new k(), bArr);
    }

    public k a() {
        this.f403137a = 0L;
        this.f403138b = "";
        this.f403139c = "";
        this.f403140d = 0;
        this.f403141e = 0;
        this.f403142f = 0;
        this.f403143g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f403143g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f403142f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f403141e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f403140d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f403139c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403138b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403137a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403137a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f403138b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403138b);
        }
        if (!this.f403139c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403139c);
        }
        int i3 = this.f403140d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f403141e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f403142f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f403143g;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403137a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f403138b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403138b);
        }
        if (!this.f403139c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403139c);
        }
        int i3 = this.f403140d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f403141e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f403142f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f403143g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
