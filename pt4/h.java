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
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public q[] f427172a;

    /* renamed from: b, reason: collision with root package name */
    public int f427173b;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f427172a = q.b();
        this.f427173b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                q[] qVarArr = this.f427172a;
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
                this.f427172a = qVarArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f427173b = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        q[] qVarArr = this.f427172a;
        if (qVarArr != null && qVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                q[] qVarArr2 = this.f427172a;
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
        int i16 = this.f427173b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        q[] qVarArr = this.f427172a;
        if (qVarArr != null && qVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                q[] qVarArr2 = this.f427172a;
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
        int i16 = this.f427173b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
