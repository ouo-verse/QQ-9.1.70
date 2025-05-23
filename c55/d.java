package c55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class d extends MessageNano {

    /* renamed from: a, reason: collision with root package name */
    public String f30390a;

    /* renamed from: b, reason: collision with root package name */
    public String f30391b;

    /* renamed from: c, reason: collision with root package name */
    public String f30392c;

    /* renamed from: d, reason: collision with root package name */
    public long f30393d;

    public d() {
        a();
    }

    public d a() {
        this.f30390a = "";
        this.f30391b = "";
        this.f30392c = "";
        this.f30393d = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 18) {
                    if (readTag != 26) {
                        if (readTag != 34) {
                            if (readTag != 40) {
                                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f30393d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            this.f30392c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f30391b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f30390a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f30390a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f30390a);
        }
        if (!this.f30391b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f30391b);
        }
        if (!this.f30392c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f30392c);
        }
        long j3 = this.f30393d;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f30390a.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f30390a);
        }
        if (!this.f30391b.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f30391b);
        }
        if (!this.f30392c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f30392c);
        }
        long j3 = this.f30393d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
