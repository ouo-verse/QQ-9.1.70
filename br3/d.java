package br3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f29014a;

    /* renamed from: b, reason: collision with root package name */
    public long f29015b;

    /* renamed from: c, reason: collision with root package name */
    public long f29016c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f29017d;

    public d() {
        a();
    }

    public d a() {
        this.f29014a = WireFormatNano.EMPTY_BYTES;
        this.f29015b = 0L;
        this.f29016c = 0L;
        this.f29017d = a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
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
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                a[] aVarArr = this.f29017d;
                                if (aVarArr == null) {
                                    length = 0;
                                } else {
                                    length = aVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                a[] aVarArr2 = new a[i3];
                                if (length != 0) {
                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    a aVar = new a();
                                    aVarArr2[length] = aVar;
                                    codedInputByteBufferNano.readMessage(aVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                a aVar2 = new a();
                                aVarArr2[length] = aVar2;
                                codedInputByteBufferNano.readMessage(aVar2);
                                this.f29017d = aVarArr2;
                            }
                        } else {
                            this.f29016c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f29015b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f29014a = codedInputByteBufferNano.readBytes();
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
        if (!Arrays.equals(this.f29014a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f29014a);
        }
        long j3 = this.f29015b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f29016c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        a[] aVarArr = this.f29017d;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f29017d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f29014a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f29014a);
        }
        long j3 = this.f29015b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f29016c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        a[] aVarArr = this.f29017d;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f29017d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
