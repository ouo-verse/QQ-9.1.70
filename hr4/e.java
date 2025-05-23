package hr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f406102a;

    /* renamed from: b, reason: collision with root package name */
    public String f406103b;

    /* renamed from: c, reason: collision with root package name */
    public String f406104c;

    /* renamed from: d, reason: collision with root package name */
    public String f406105d;

    /* renamed from: e, reason: collision with root package name */
    public String f406106e;

    public e() {
        a();
    }

    public e a() {
        this.f406102a = "";
        this.f406103b = "";
        this.f406104c = "";
        this.f406105d = "";
        this.f406106e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f406106e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f406105d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f406104c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f406103b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f406102a = codedInputByteBufferNano.readString();
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
        if (!this.f406102a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406102a);
        }
        if (!this.f406103b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406103b);
        }
        if (!this.f406104c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406104c);
        }
        if (!this.f406105d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406105d);
        }
        if (!this.f406106e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f406106e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406102a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406102a);
        }
        if (!this.f406103b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406103b);
        }
        if (!this.f406104c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406104c);
        }
        if (!this.f406105d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406105d);
        }
        if (!this.f406106e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406106e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
