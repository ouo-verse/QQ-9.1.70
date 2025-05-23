package ft4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f400612a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f400613b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f400614c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f400612a = bArr;
        this.f400613b = bArr;
        this.f400614c = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400612a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.f400613b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400614c = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f400612a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f400612a);
        }
        if (!Arrays.equals(this.f400613b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f400613b);
        }
        return !Arrays.equals(this.f400614c, bArr2) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.f400614c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f400612a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f400612a);
        }
        if (!Arrays.equals(this.f400613b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.f400613b);
        }
        if (!Arrays.equals(this.f400614c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.f400614c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
