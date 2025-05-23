package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f394929a;

    /* renamed from: b, reason: collision with root package name */
    public String f394930b;

    /* renamed from: c, reason: collision with root package name */
    public String f394931c;

    /* renamed from: d, reason: collision with root package name */
    public String f394932d;

    public b() {
        a();
    }

    public b a() {
        this.f394929a = "";
        this.f394930b = "";
        this.f394931c = "";
        this.f394932d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                this.f394932d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f394931c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f394930b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394929a = codedInputByteBufferNano.readString();
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
        if (!this.f394929a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394929a);
        }
        if (!this.f394930b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394930b);
        }
        if (!this.f394931c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f394931c);
        }
        if (!this.f394932d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f394932d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394929a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394929a);
        }
        if (!this.f394930b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394930b);
        }
        if (!this.f394931c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f394931c);
        }
        if (!this.f394932d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f394932d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
