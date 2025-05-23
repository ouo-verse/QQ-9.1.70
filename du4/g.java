package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public String f394982a;

    /* renamed from: b, reason: collision with root package name */
    public String f394983b;

    /* renamed from: c, reason: collision with root package name */
    public String f394984c;

    /* renamed from: d, reason: collision with root package name */
    public String f394985d;

    public g() {
        a();
    }

    public g a() {
        this.f394982a = "";
        this.f394983b = "";
        this.f394984c = "";
        this.f394985d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f394985d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f394984c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f394983b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394982a = codedInputByteBufferNano.readString();
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
        if (!this.f394982a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394982a);
        }
        if (!this.f394983b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394983b);
        }
        if (!this.f394984c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f394984c);
        }
        if (!this.f394985d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f394985d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394982a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394982a);
        }
        if (!this.f394983b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394983b);
        }
        if (!this.f394984c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f394984c);
        }
        if (!this.f394985d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f394985d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
