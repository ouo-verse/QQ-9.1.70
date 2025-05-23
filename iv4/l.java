package iv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public k[] f408834a;

    /* renamed from: b, reason: collision with root package name */
    public int f408835b;

    public l() {
        a();
    }

    public l a() {
        this.f408834a = k.b();
        this.f408835b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                k[] kVarArr = this.f408834a;
                int length = kVarArr == null ? 0 : kVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                k[] kVarArr2 = new k[i3];
                if (length != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    k kVar = new k();
                    kVarArr2[length] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                k kVar2 = new k();
                kVarArr2[length] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.f408834a = kVarArr2;
            } else if (readTag != 800) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408835b = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        k[] kVarArr = this.f408834a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f408834a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
                }
                i3++;
            }
        }
        int i16 = this.f408835b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(100, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        k[] kVarArr = this.f408834a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f408834a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, kVar);
                }
                i3++;
            }
        }
        int i16 = this.f408835b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(100, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
