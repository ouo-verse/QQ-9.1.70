package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f421385a;

    /* renamed from: b, reason: collision with root package name */
    public String f421386b;

    /* renamed from: c, reason: collision with root package name */
    public String f421387c;

    /* renamed from: d, reason: collision with root package name */
    public pu4.g f421388d;

    public a() {
        a();
    }

    public a a() {
        this.f421385a = "";
        this.f421386b = "";
        this.f421387c = "";
        this.f421388d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f421385a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f421386b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f421387c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f421388d == null) {
                    this.f421388d = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f421388d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f421385a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421385a);
        }
        if (!this.f421386b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421386b);
        }
        if (!this.f421387c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f421387c);
        }
        pu4.g gVar = this.f421388d;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421385a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421385a);
        }
        if (!this.f421386b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421386b);
        }
        if (!this.f421387c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f421387c);
        }
        pu4.g gVar = this.f421388d;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(4, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
