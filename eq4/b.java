package eq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public cq4.b[] f397039a;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f397039a = cq4.b.b();
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
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    cq4.b[] bVarArr = this.f397039a;
                    if (bVarArr == null) {
                        length = 0;
                    } else {
                        length = bVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    cq4.b[] bVarArr2 = new cq4.b[i3];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        cq4.b bVar = new cq4.b();
                        bVarArr2[length] = bVar;
                        codedInputByteBufferNano.readMessage(bVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    cq4.b bVar2 = new cq4.b();
                    bVarArr2[length] = bVar2;
                    codedInputByteBufferNano.readMessage(bVar2);
                    this.f397039a = bVarArr2;
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
        cq4.b[] bVarArr = this.f397039a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                cq4.b[] bVarArr2 = this.f397039a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                cq4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        cq4.b[] bVarArr = this.f397039a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                cq4.b[] bVarArr2 = this.f397039a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                cq4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
