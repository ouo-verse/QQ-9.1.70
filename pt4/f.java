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
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public o[] f427167a;

    /* renamed from: b, reason: collision with root package name */
    public String f427168b;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f427167a = o.b();
        this.f427168b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                o[] oVarArr = this.f427167a;
                int length = oVarArr == null ? 0 : oVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                o[] oVarArr2 = new o[i3];
                if (length != 0) {
                    System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    o oVar = new o();
                    oVarArr2[length] = oVar;
                    codedInputByteBufferNano.readMessage(oVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                o oVar2 = new o();
                oVarArr2[length] = oVar2;
                codedInputByteBufferNano.readMessage(oVar2);
                this.f427167a = oVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427168b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        o[] oVarArr = this.f427167a;
        if (oVarArr != null && oVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                o[] oVarArr2 = this.f427167a;
                if (i3 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i3];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, oVar);
                }
                i3++;
            }
        }
        return !this.f427168b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f427168b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        o[] oVarArr = this.f427167a;
        if (oVarArr != null && oVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                o[] oVarArr2 = this.f427167a;
                if (i3 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i3];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, oVar);
                }
                i3++;
            }
        }
        if (!this.f427168b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427168b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
