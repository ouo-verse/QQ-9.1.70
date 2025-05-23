package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f406137a;

    /* renamed from: b, reason: collision with root package name */
    public String f406138b;

    /* renamed from: c, reason: collision with root package name */
    public String f406139c;

    public f() {
        a();
    }

    public f a() {
        this.f406137a = "";
        this.f406138b = "";
        this.f406139c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
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
                this.f406137a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406138b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406139c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406137a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406137a);
        }
        if (!this.f406138b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406138b);
        }
        return !this.f406139c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f406139c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406137a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406137a);
        }
        if (!this.f406138b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406138b);
        }
        if (!this.f406139c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406139c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
