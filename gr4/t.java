package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public r[] f403213a;

    public t() {
        a();
    }

    public t a() {
        this.f403213a = r.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    r[] rVarArr = this.f403213a;
                    if (rVarArr == null) {
                        length = 0;
                    } else {
                        length = rVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    r[] rVarArr2 = new r[i3];
                    if (length != 0) {
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        r rVar = new r();
                        rVarArr2[length] = rVar;
                        codedInputByteBufferNano.readMessage(rVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    r rVar2 = new r();
                    rVarArr2[length] = rVar2;
                    codedInputByteBufferNano.readMessage(rVar2);
                    this.f403213a = rVarArr2;
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
        r[] rVarArr = this.f403213a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f403213a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r[] rVarArr = this.f403213a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f403213a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i3];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
