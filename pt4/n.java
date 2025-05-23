package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f427190a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f427191b;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427190a = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427191b = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f427190a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f427191b;
        return z17 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f427190a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f427191b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f427190a = false;
        this.f427191b = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
