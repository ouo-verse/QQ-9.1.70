package iv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public e f408821a;

    /* renamed from: b, reason: collision with root package name */
    public g f408822b;

    /* renamed from: c, reason: collision with root package name */
    public d f408823c;

    /* renamed from: d, reason: collision with root package name */
    public int f408824d;

    public f() {
        a();
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
                if (this.f408821a == null) {
                    this.f408821a = new e();
                }
                codedInputByteBufferNano.readMessage(this.f408821a);
            } else if (readTag == 18) {
                if (this.f408822b == null) {
                    this.f408822b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f408822b);
            } else if (readTag == 26) {
                if (this.f408823c == null) {
                    this.f408823c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f408823c);
            } else if (readTag != 800) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408824d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        e eVar = this.f408821a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        g gVar = this.f408822b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        d dVar = this.f408823c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        int i3 = this.f408824d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(100, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f408821a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        g gVar = this.f408822b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        d dVar = this.f408823c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        int i3 = this.f408824d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(100, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f408821a = null;
        this.f408822b = null;
        this.f408823c = null;
        this.f408824d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
