package dq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f394662a;

    /* renamed from: b, reason: collision with root package name */
    public int f394663b;

    /* renamed from: c, reason: collision with root package name */
    public bq4.b[] f394664c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f394662a = 0L;
        this.f394663b = 0;
        this.f394664c = bq4.b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            bq4.b[] bVarArr = this.f394664c;
                            if (bVarArr == null) {
                                length = 0;
                            } else {
                                length = bVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            bq4.b[] bVarArr2 = new bq4.b[i3];
                            if (length != 0) {
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                bq4.b bVar = new bq4.b();
                                bVarArr2[length] = bVar;
                                codedInputByteBufferNano.readMessage(bVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            bq4.b bVar2 = new bq4.b();
                            bVarArr2[length] = bVar2;
                            codedInputByteBufferNano.readMessage(bVar2);
                            this.f394664c = bVarArr2;
                        }
                    } else {
                        this.f394663b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f394662a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f394662a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f394663b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        bq4.b[] bVarArr = this.f394664c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bq4.b[] bVarArr2 = this.f394664c;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                bq4.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394662a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f394663b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        bq4.b[] bVarArr = this.f394664c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bq4.b[] bVarArr2 = this.f394664c;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                bq4.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, bVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
