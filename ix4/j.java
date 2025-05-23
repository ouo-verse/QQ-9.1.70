package ix4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public k[] f408949a;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f408949a = k.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    k[] kVarArr = this.f408949a;
                    if (kVarArr == null) {
                        length = 0;
                    } else {
                        length = kVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    k[] kVarArr2 = new k[i3];
                    if (length != 0) {
                        System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        k kVar = new k();
                        kVarArr2[length] = kVar;
                        codedInputByteBufferNano.readMessage(kVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    k kVar2 = new k();
                    kVarArr2[length] = kVar2;
                    codedInputByteBufferNano.readMessage(kVar2);
                    this.f408949a = kVarArr2;
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
        k[] kVarArr = this.f408949a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f408949a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        k[] kVarArr = this.f408949a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f408949a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, kVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
