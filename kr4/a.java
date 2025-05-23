package kr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f412912a;

    /* renamed from: b, reason: collision with root package name */
    public b[] f412913b;

    /* renamed from: c, reason: collision with root package name */
    public long f412914c;

    public a() {
        a();
    }

    public a a() {
        this.f412912a = 0L;
        this.f412913b = b.b();
        this.f412914c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 40) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f412914c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        b[] bVarArr = this.f412913b;
                        if (bVarArr == null) {
                            length = 0;
                        } else {
                            length = bVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        b[] bVarArr2 = new b[i3];
                        if (length != 0) {
                            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            b bVar = new b();
                            bVarArr2[length] = bVar;
                            codedInputByteBufferNano.readMessage(bVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        b bVar2 = new b();
                        bVarArr2[length] = bVar2;
                        codedInputByteBufferNano.readMessage(bVar2);
                        this.f412913b = bVarArr2;
                    }
                } else {
                    this.f412912a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f412912a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        b[] bVarArr = this.f412913b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                b[] bVarArr2 = this.f412913b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i3++;
            }
        }
        long j16 = this.f412914c;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f412912a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        b[] bVarArr = this.f412913b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                b[] bVarArr2 = this.f412913b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i3++;
            }
        }
        long j16 = this.f412914c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
