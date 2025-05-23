package mt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f417568a;

    /* renamed from: b, reason: collision with root package name */
    public long f417569b;

    /* renamed from: c, reason: collision with root package name */
    public long f417570c;

    /* renamed from: d, reason: collision with root package name */
    public long f417571d;

    /* renamed from: e, reason: collision with root package name */
    public String f417572e;

    /* renamed from: f, reason: collision with root package name */
    public String f417573f;

    public f() {
        a();
    }

    public f a() {
        this.f417568a = 0L;
        this.f417569b = 0L;
        this.f417570c = 0L;
        this.f417571d = 0L;
        this.f417572e = "";
        this.f417573f = "";
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
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f417573f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f417572e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f417571d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f417570c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f417569b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f417568a = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f417568a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f417569b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f417570c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f417571d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        if (!this.f417572e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f417572e);
        }
        if (!this.f417573f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f417573f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f417568a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f417569b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f417570c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f417571d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        if (!this.f417572e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f417572e);
        }
        if (!this.f417573f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f417573f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
