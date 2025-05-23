package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f403144a;

    /* renamed from: b, reason: collision with root package name */
    public long f403145b;

    /* renamed from: c, reason: collision with root package name */
    public long f403146c;

    /* renamed from: d, reason: collision with root package name */
    public String f403147d;

    /* renamed from: e, reason: collision with root package name */
    public String f403148e;

    public l() {
        a();
    }

    public l a() {
        this.f403144a = WireFormatNano.EMPTY_BYTES;
        this.f403145b = 0L;
        this.f403146c = 0L;
        this.f403147d = "";
        this.f403148e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f403148e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f403147d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403146c = codedInputByteBufferNano.readInt64();
                        }
                    } else {
                        this.f403145b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f403144a = codedInputByteBufferNano.readBytes();
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
        if (!Arrays.equals(this.f403144a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f403144a);
        }
        long j3 = this.f403145b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        long j16 = this.f403146c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        if (!this.f403147d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403147d);
        }
        if (!this.f403148e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f403148e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f403144a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f403144a);
        }
        long j3 = this.f403145b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        long j16 = this.f403146c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        if (!this.f403147d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403147d);
        }
        if (!this.f403148e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403148e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
