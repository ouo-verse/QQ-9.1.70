package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f29282a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f29283b;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29282a = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29283b = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f29282a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f29283b;
        return z17 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f29282a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f29283b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f29282a = false;
        this.f29283b = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
