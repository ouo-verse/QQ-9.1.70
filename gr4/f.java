package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f403119a;

    /* renamed from: b, reason: collision with root package name */
    public String f403120b;

    /* renamed from: c, reason: collision with root package name */
    public String f403121c;

    /* renamed from: d, reason: collision with root package name */
    public String f403122d;

    /* renamed from: e, reason: collision with root package name */
    public String f403123e;

    /* renamed from: f, reason: collision with root package name */
    public String f403124f;

    /* renamed from: g, reason: collision with root package name */
    public String f403125g;

    public f() {
        a();
    }

    public f a() {
        this.f403119a = "";
        this.f403120b = "";
        this.f403121c = "";
        this.f403122d = "";
        this.f403123e = "";
        this.f403124f = "";
        this.f403125g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f403125g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f403124f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f403123e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f403122d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403121c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403120b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403119a = codedInputByteBufferNano.readString();
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
        if (!this.f403119a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403119a);
        }
        if (!this.f403120b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403120b);
        }
        if (!this.f403121c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403121c);
        }
        if (!this.f403122d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403122d);
        }
        if (!this.f403123e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403123e);
        }
        if (!this.f403124f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f403124f);
        }
        if (!this.f403125g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f403125g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403119a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403119a);
        }
        if (!this.f403120b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403120b);
        }
        if (!this.f403121c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403121c);
        }
        if (!this.f403122d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403122d);
        }
        if (!this.f403123e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403123e);
        }
        if (!this.f403124f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f403124f);
        }
        if (!this.f403125g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f403125g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
