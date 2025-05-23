package f55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public h[] f397867a;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f397867a = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    h[] hVarArr = this.f397867a;
                    if (hVarArr == null) {
                        length = 0;
                    } else {
                        length = hVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    h[] hVarArr2 = new h[i3];
                    if (length != 0) {
                        System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        h hVar = new h();
                        hVarArr2[length] = hVar;
                        codedInputByteBufferNano.readMessage(hVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    h hVar2 = new h();
                    hVarArr2[length] = hVar2;
                    codedInputByteBufferNano.readMessage(hVar2);
                    this.f397867a = hVarArr2;
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
        h[] hVarArr = this.f397867a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f397867a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        h[] hVarArr = this.f397867a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f397867a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
