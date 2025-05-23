package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public i[] f411038a;

    public j() {
        a();
    }

    public j a() {
        this.f411038a = i.b();
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
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                i[] iVarArr = this.f411038a;
                int length = iVarArr == null ? 0 : iVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                i[] iVarArr2 = new i[i3];
                if (length != 0) {
                    System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    i iVar = new i();
                    iVarArr2[length] = iVar;
                    codedInputByteBufferNano.readMessage(iVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                i iVar2 = new i();
                iVarArr2[length] = iVar2;
                codedInputByteBufferNano.readMessage(iVar2);
                this.f411038a = iVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        i[] iVarArr = this.f411038a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f411038a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i[] iVarArr = this.f411038a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f411038a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, iVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
