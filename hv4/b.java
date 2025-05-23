package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f406408a;

    /* renamed from: b, reason: collision with root package name */
    public String f406409b;

    /* renamed from: c, reason: collision with root package name */
    public j[] f406410c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f406408a = "";
        this.f406409b = "";
        this.f406410c = j.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406408a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406409b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                j[] jVarArr = this.f406410c;
                int length = jVarArr == null ? 0 : jVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                j[] jVarArr2 = new j[i3];
                if (length != 0) {
                    System.arraycopy(jVarArr, 0, jVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    j jVar = new j();
                    jVarArr2[length] = jVar;
                    codedInputByteBufferNano.readMessage(jVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                j jVar2 = new j();
                jVarArr2[length] = jVar2;
                codedInputByteBufferNano.readMessage(jVar2);
                this.f406410c = jVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406408a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406408a);
        }
        if (!this.f406409b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406409b);
        }
        j[] jVarArr = this.f406410c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                j[] jVarArr2 = this.f406410c;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i3];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406408a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406408a);
        }
        if (!this.f406409b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406409b);
        }
        j[] jVarArr = this.f406410c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                j[] jVarArr2 = this.f406410c;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i3];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, jVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
