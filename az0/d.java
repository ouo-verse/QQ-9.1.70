package az0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends MessageNano {

    /* renamed from: a, reason: collision with root package name */
    public String f27372a;

    /* renamed from: b, reason: collision with root package name */
    public String f27373b;

    /* renamed from: c, reason: collision with root package name */
    public String f27374c;

    /* renamed from: d, reason: collision with root package name */
    public long f27375d;

    public d() {
        a();
    }

    public d a() {
        this.f27372a = "";
        this.f27373b = "";
        this.f27374c = "";
        this.f27375d = 0L;
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
                                this.f27375d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            this.f27374c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f27373b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f27372a = codedInputByteBufferNano.readString();
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
        if (!this.f27372a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f27372a);
        }
        if (!this.f27373b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f27373b);
        }
        if (!this.f27374c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f27374c);
        }
        long j3 = this.f27375d;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f27372a.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f27372a);
        }
        if (!this.f27373b.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f27373b);
        }
        if (!this.f27374c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f27374c);
        }
        long j3 = this.f27375d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
