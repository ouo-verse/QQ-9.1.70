package hu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public String f406378a;

    /* renamed from: b, reason: collision with root package name */
    public String f406379b;

    /* renamed from: c, reason: collision with root package name */
    public String f406380c;

    /* renamed from: d, reason: collision with root package name */
    public String f406381d;

    public i() {
        a();
    }

    public i a() {
        this.f406378a = "";
        this.f406379b = "";
        this.f406380c = "";
        this.f406381d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406378a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406379b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f406380c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406381d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406378a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406378a);
        }
        if (!this.f406379b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406379b);
        }
        if (!this.f406380c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406380c);
        }
        return !this.f406381d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f406381d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406378a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406378a);
        }
        if (!this.f406379b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406379b);
        }
        if (!this.f406380c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406380c);
        }
        if (!this.f406381d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406381d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
