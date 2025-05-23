package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public s[] f406497a;

    public t() {
        a();
    }

    public t a() {
        this.f406497a = s.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                s[] sVarArr = this.f406497a;
                int length = sVarArr == null ? 0 : sVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                s[] sVarArr2 = new s[i3];
                if (length != 0) {
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    s sVar = new s();
                    sVarArr2[length] = sVar;
                    codedInputByteBufferNano.readMessage(sVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                s sVar2 = new s();
                sVarArr2[length] = sVar2;
                codedInputByteBufferNano.readMessage(sVar2);
                this.f406497a = sVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        s[] sVarArr = this.f406497a;
        if (sVarArr != null && sVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                s[] sVarArr2 = this.f406497a;
                if (i3 >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i3];
                if (sVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        s[] sVarArr = this.f406497a;
        if (sVarArr != null && sVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                s[] sVarArr2 = this.f406497a;
                if (i3 >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i3];
                if (sVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, sVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
