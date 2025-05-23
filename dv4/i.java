package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public q[] f395034a;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    public i a() {
        this.f395034a = q.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                q[] qVarArr = this.f395034a;
                int length = qVarArr == null ? 0 : qVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                q[] qVarArr2 = new q[i3];
                if (length != 0) {
                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    q qVar = new q();
                    qVarArr2[length] = qVar;
                    codedInputByteBufferNano.readMessage(qVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                q qVar2 = new q();
                qVarArr2[length] = qVar2;
                codedInputByteBufferNano.readMessage(qVar2);
                this.f395034a = qVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        q[] qVarArr = this.f395034a;
        if (qVarArr != null && qVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                q[] qVarArr2 = this.f395034a;
                if (i3 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i3];
                if (qVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, qVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        q[] qVarArr = this.f395034a;
        if (qVarArr != null && qVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                q[] qVarArr2 = this.f395034a;
                if (i3 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i3];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, qVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
