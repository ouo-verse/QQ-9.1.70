package lp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f415371a;

    /* renamed from: b, reason: collision with root package name */
    public int f415372b;

    /* renamed from: c, reason: collision with root package name */
    public int f415373c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f415374d;

    public i() {
        a();
    }

    public i a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f415371a = bArr;
        this.f415372b = 0;
        this.f415373c = 0;
        this.f415374d = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f415374d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f415373c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f415372b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f415371a = codedInputByteBufferNano.readBytes();
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
        byte[] bArr = this.f415371a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f415371a);
        }
        int i3 = this.f415372b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f415373c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!Arrays.equals(this.f415374d, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.f415374d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f415371a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f415371a);
        }
        int i3 = this.f415372b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f415373c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!Arrays.equals(this.f415374d, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.f415374d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
