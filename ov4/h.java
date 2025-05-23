package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public p[] f424165a;

    /* renamed from: b, reason: collision with root package name */
    public String f424166b;

    public h() {
        a();
    }

    public h a() {
        this.f424165a = p.b();
        this.f424166b = "";
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
                p[] pVarArr = this.f424165a;
                int length = pVarArr == null ? 0 : pVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                p[] pVarArr2 = new p[i3];
                if (length != 0) {
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    p pVar = new p();
                    pVarArr2[length] = pVar;
                    codedInputByteBufferNano.readMessage(pVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                p pVar2 = new p();
                pVarArr2[length] = pVar2;
                codedInputByteBufferNano.readMessage(pVar2);
                this.f424165a = pVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424166b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        p[] pVarArr = this.f424165a;
        if (pVarArr != null && pVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                p[] pVarArr2 = this.f424165a;
                if (i3 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i3];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, pVar);
                }
                i3++;
            }
        }
        return !this.f424166b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f424166b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        p[] pVarArr = this.f424165a;
        if (pVarArr != null && pVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                p[] pVarArr2 = this.f424165a;
                if (i3 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i3];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, pVar);
                }
                i3++;
            }
        }
        if (!this.f424166b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424166b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
