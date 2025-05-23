package br4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f29021a;

    /* renamed from: b, reason: collision with root package name */
    public String f29022b;

    /* renamed from: c, reason: collision with root package name */
    public String f29023c;

    /* renamed from: d, reason: collision with root package name */
    public String f29024d;

    /* renamed from: e, reason: collision with root package name */
    public String f29025e;

    /* renamed from: f, reason: collision with root package name */
    public String f29026f;

    public c() {
        a();
    }

    public c a() {
        this.f29021a = "";
        this.f29022b = "";
        this.f29023c = "";
        this.f29024d = "";
        this.f29025e = "";
        this.f29026f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f29026f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f29025e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f29024d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f29023c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f29022b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f29021a = codedInputByteBufferNano.readString();
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
        if (!this.f29021a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29021a);
        }
        if (!this.f29022b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29022b);
        }
        if (!this.f29023c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f29023c);
        }
        if (!this.f29024d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f29024d);
        }
        if (!this.f29025e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f29025e);
        }
        if (!this.f29026f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f29026f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29021a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29021a);
        }
        if (!this.f29022b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29022b);
        }
        if (!this.f29023c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f29023c);
        }
        if (!this.f29024d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f29024d);
        }
        if (!this.f29025e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f29025e);
        }
        if (!this.f29026f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f29026f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
