package iv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public kv4.a f408817a;

    /* renamed from: b, reason: collision with root package name */
    public int f408818b;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 34) {
                if (this.f408817a == null) {
                    this.f408817a = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f408817a);
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408818b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        kv4.a aVar = this.f408817a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        int i3 = this.f408818b;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        kv4.a aVar = this.f408817a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        int i3 = this.f408818b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f408817a = null;
        this.f408818b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
