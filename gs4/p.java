package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public int f403324a;

    /* renamed from: b, reason: collision with root package name */
    public long f403325b;

    /* renamed from: c, reason: collision with root package name */
    public int f403326c;

    /* renamed from: d, reason: collision with root package name */
    public long f403327d;

    /* renamed from: e, reason: collision with root package name */
    public String f403328e;

    /* renamed from: f, reason: collision with root package name */
    public String f403329f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f403330g;

    public p() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403324a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f403325b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f403326c = readInt32;
                }
            } else if (readTag == 32) {
                this.f403327d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                this.f403328e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f403329f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f403330g = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f403324a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f403325b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        int i16 = this.f403326c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        long j16 = this.f403327d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        if (!this.f403328e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403328e);
        }
        if (!this.f403329f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f403329f);
        }
        boolean z16 = this.f403330g;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403324a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f403325b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        int i16 = this.f403326c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        long j16 = this.f403327d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        if (!this.f403328e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403328e);
        }
        if (!this.f403329f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f403329f);
        }
        boolean z16 = this.f403330g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f403324a = 0;
        this.f403325b = 0L;
        this.f403326c = 0;
        this.f403327d = 0L;
        this.f403328e = "";
        this.f403329f = "";
        this.f403330g = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
