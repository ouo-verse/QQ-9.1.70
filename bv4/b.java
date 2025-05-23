package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f29259a;

    /* renamed from: b, reason: collision with root package name */
    public String f29260b;

    /* renamed from: c, reason: collision with root package name */
    public qu4.a f29261c;

    /* renamed from: d, reason: collision with root package name */
    public String f29262d;

    /* renamed from: e, reason: collision with root package name */
    public String f29263e;

    /* renamed from: f, reason: collision with root package name */
    public f f29264f;

    public b() {
        a();
    }

    public b a() {
        this.f29259a = "";
        this.f29260b = "";
        this.f29261c = null;
        this.f29262d = "";
        this.f29263e = "";
        this.f29264f = null;
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
                this.f29259a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f29260b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.f29261c == null) {
                    this.f29261c = new qu4.a();
                }
                codedInputByteBufferNano.readMessage(this.f29261c);
            } else if (readTag == 34) {
                this.f29262d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f29263e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f29264f == null) {
                    this.f29264f = new f();
                }
                codedInputByteBufferNano.readMessage(this.f29264f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29259a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29259a);
        }
        if (!this.f29260b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29260b);
        }
        qu4.a aVar = this.f29261c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        if (!this.f29262d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f29262d);
        }
        if (!this.f29263e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f29263e);
        }
        f fVar = this.f29264f;
        return fVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, fVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29259a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29259a);
        }
        if (!this.f29260b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29260b);
        }
        qu4.a aVar = this.f29261c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        if (!this.f29262d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f29262d);
        }
        if (!this.f29263e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f29263e);
        }
        f fVar = this.f29264f;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(6, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
