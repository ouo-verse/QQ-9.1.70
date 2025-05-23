package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f403088a;

    /* renamed from: b, reason: collision with root package name */
    public String f403089b;

    /* renamed from: c, reason: collision with root package name */
    public String f403090c;

    /* renamed from: d, reason: collision with root package name */
    public String f403091d;

    public a() {
        a();
    }

    public a a() {
        this.f403088a = "";
        this.f403089b = "";
        this.f403090c = "";
        this.f403091d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                this.f403091d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403090c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403089b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403088a = codedInputByteBufferNano.readString();
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
        if (!this.f403088a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403088a);
        }
        if (!this.f403089b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403089b);
        }
        if (!this.f403090c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403090c);
        }
        if (!this.f403091d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f403091d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403088a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403088a);
        }
        if (!this.f403089b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403089b);
        }
        if (!this.f403090c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403090c);
        }
        if (!this.f403091d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403091d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
