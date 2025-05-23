package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public n[] f413068a;

    public a() {
        a();
    }

    public a a() {
        this.f413068a = n.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                n[] nVarArr = this.f413068a;
                int length = nVarArr == null ? 0 : nVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                n[] nVarArr2 = new n[i3];
                if (length != 0) {
                    System.arraycopy(nVarArr, 0, nVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    n nVar = new n();
                    nVarArr2[length] = nVar;
                    codedInputByteBufferNano.readMessage(nVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                n nVar2 = new n();
                nVarArr2[length] = nVar2;
                codedInputByteBufferNano.readMessage(nVar2);
                this.f413068a = nVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        n[] nVarArr = this.f413068a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f413068a;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, nVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        n[] nVarArr = this.f413068a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f413068a;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, nVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
