package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public r[] f427176a;

    /* renamed from: b, reason: collision with root package name */
    public int f427177b;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f427176a = r.b();
        this.f427177b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                r[] rVarArr = this.f427176a;
                int length = rVarArr == null ? 0 : rVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                r[] rVarArr2 = new r[i3];
                if (length != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    r rVar = new r();
                    rVarArr2[length] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                r rVar2 = new r();
                rVarArr2[length] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f427176a = rVarArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f427177b = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        r[] rVarArr = this.f427176a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f427176a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i3++;
            }
        }
        int i16 = this.f427177b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r[] rVarArr = this.f427176a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f427176a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i3++;
            }
        }
        int i16 = this.f427177b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
