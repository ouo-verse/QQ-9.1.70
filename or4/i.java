package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public n[] f423497a;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    public i a() {
        this.f423497a = n.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    n[] nVarArr = this.f423497a;
                    if (nVarArr == null) {
                        length = 0;
                    } else {
                        length = nVarArr.length;
                    }
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
                    this.f423497a = nVarArr2;
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
        n[] nVarArr = this.f423497a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f423497a;
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
        n[] nVarArr = this.f423497a;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f423497a;
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
