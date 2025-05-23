package hu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f406377a;

    public h() {
        a();
    }

    public h a() {
        this.f406377a = g.b();
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
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                g[] gVarArr = this.f406377a;
                int length = gVarArr == null ? 0 : gVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                g[] gVarArr2 = new g[i3];
                if (length != 0) {
                    System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    g gVar = new g();
                    gVarArr2[length] = gVar;
                    codedInputByteBufferNano.readMessage(gVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                g gVar2 = new g();
                gVarArr2[length] = gVar2;
                codedInputByteBufferNano.readMessage(gVar2);
                this.f406377a = gVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        g[] gVarArr = this.f406377a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f406377a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g[] gVarArr = this.f406377a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f406377a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
