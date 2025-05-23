package ip4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f408148a;

    /* renamed from: b, reason: collision with root package name */
    public c[] f408149b;

    public b() {
        a();
    }

    public b a() {
        this.f408148a = "";
        this.f408149b = c.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        c[] cVarArr = this.f408149b;
                        if (cVarArr == null) {
                            length = 0;
                        } else {
                            length = cVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        c[] cVarArr2 = new c[i3];
                        if (length != 0) {
                            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            c cVar = new c();
                            cVarArr2[length] = cVar;
                            codedInputByteBufferNano.readMessage(cVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        c cVar2 = new c();
                        cVarArr2[length] = cVar2;
                        codedInputByteBufferNano.readMessage(cVar2);
                        this.f408149b = cVarArr2;
                    }
                } else {
                    this.f408148a = codedInputByteBufferNano.readString();
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
        if (!this.f408148a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408148a);
        }
        c[] cVarArr = this.f408149b;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f408149b;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408148a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408148a);
        }
        c[] cVarArr = this.f408149b;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f408149b;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, cVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
