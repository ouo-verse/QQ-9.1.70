package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f403761a;

    /* renamed from: b, reason: collision with root package name */
    public int f403762b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f403763c;

    /* renamed from: d, reason: collision with root package name */
    public long f403764d;

    public e() {
        a();
    }

    public e a() {
        this.f403761a = 0;
        this.f403762b = 0;
        this.f403763c = f.b();
        this.f403764d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f403764d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            f[] fVarArr = this.f403763c;
                            if (fVarArr == null) {
                                length = 0;
                            } else {
                                length = fVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            f[] fVarArr2 = new f[i3];
                            if (length != 0) {
                                System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                f fVar = new f();
                                fVarArr2[length] = fVar;
                                codedInputByteBufferNano.readMessage(fVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            f fVar2 = new f();
                            fVarArr2[length] = fVar2;
                            codedInputByteBufferNano.readMessage(fVar2);
                            this.f403763c = fVarArr2;
                        }
                    } else {
                        this.f403762b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f403761a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403761a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403762b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        f[] fVarArr = this.f403763c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f403763c;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i17++;
            }
        }
        long j3 = this.f403764d;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403761a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403762b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        f[] fVarArr = this.f403763c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f403763c;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i17++;
            }
        }
        long j3 = this.f403764d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
