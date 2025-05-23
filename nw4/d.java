package nw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f421465a;

    /* renamed from: b, reason: collision with root package name */
    public String f421466b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f421467c;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f421465a = "";
        this.f421466b = "";
        this.f421467c = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f421465a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f421466b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                f[] fVarArr = this.f421467c;
                int length = fVarArr == null ? 0 : fVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                f[] fVarArr2 = new f[i3];
                if (length != 0) {
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    f fVar = new f();
                    fVarArr2[length] = fVar;
                    codedInputByteBufferNano.readMessage(fVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                f fVar2 = new f();
                fVarArr2[length] = fVar2;
                codedInputByteBufferNano.readMessage(fVar2);
                this.f421467c = fVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f421465a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421465a);
        }
        if (!this.f421466b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421466b);
        }
        f[] fVarArr = this.f421467c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f421467c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421465a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421465a);
        }
        if (!this.f421466b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421466b);
        }
        f[] fVarArr = this.f421467c;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                f[] fVarArr2 = this.f421467c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
