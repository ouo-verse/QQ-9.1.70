package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public e55.a[] f401404a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f401405b;

    /* renamed from: c, reason: collision with root package name */
    public String f401406c;

    public z() {
        a();
    }

    public static z c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (z) MessageNano.mergeFrom(new z(), bArr);
    }

    public z a() {
        this.f401404a = e55.a.b();
        this.f401405b = false;
        this.f401406c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f401406c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f401405b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    e55.a[] aVarArr = this.f401404a;
                    if (aVarArr == null) {
                        length = 0;
                    } else {
                        length = aVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    e55.a[] aVarArr2 = new e55.a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e55.a aVar = new e55.a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e55.a aVar2 = new e55.a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f401404a = aVarArr2;
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
        e55.a[] aVarArr = this.f401404a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e55.a[] aVarArr2 = this.f401404a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                e55.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401405b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        if (!this.f401406c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f401406c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e55.a[] aVarArr = this.f401404a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e55.a[] aVarArr2 = this.f401404a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                e55.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401405b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!this.f401406c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f401406c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
