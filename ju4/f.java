package ju4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f410983a;

    /* renamed from: b, reason: collision with root package name */
    public String f410984b;

    /* renamed from: c, reason: collision with root package name */
    public long f410985c;

    /* renamed from: d, reason: collision with root package name */
    public long f410986d;

    /* renamed from: e, reason: collision with root package name */
    public long f410987e;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f410983a = "";
        this.f410984b = "";
        this.f410985c = 0L;
        this.f410986d = 0L;
        this.f410987e = 0L;
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
                this.f410983a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f410984b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f410985c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f410986d = codedInputByteBufferNano.readInt64();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f410987e = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f410983a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f410983a);
        }
        if (!this.f410984b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f410984b);
        }
        long j3 = this.f410985c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        long j16 = this.f410986d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        long j17 = this.f410987e;
        return j17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f410983a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f410983a);
        }
        if (!this.f410984b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f410984b);
        }
        long j3 = this.f410985c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        long j16 = this.f410986d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        long j17 = this.f410987e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
