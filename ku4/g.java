package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public n[] f413106a;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f413106a = n.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                n[] nVarArr = this.f413106a;
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
                this.f413106a = nVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        n[] nVarArr = this.f413106a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f413106a;
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
        n[] nVarArr = this.f413106a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f413106a;
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
