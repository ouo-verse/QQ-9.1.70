package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile p[] f406178f;

    /* renamed from: a, reason: collision with root package name */
    public long f406179a;

    /* renamed from: b, reason: collision with root package name */
    public String f406180b;

    /* renamed from: c, reason: collision with root package name */
    public long f406181c;

    /* renamed from: d, reason: collision with root package name */
    public long f406182d;

    /* renamed from: e, reason: collision with root package name */
    public long f406183e;

    public p() {
        a();
    }

    public static p[] b() {
        if (f406178f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406178f == null) {
                    f406178f = new p[0];
                }
            }
        }
        return f406178f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406179a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f406180b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f406181c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f406182d = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406183e = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f406179a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f406180b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406180b);
        }
        long j16 = this.f406181c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f406182d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        long j18 = this.f406183e;
        return j18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406179a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f406180b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406180b);
        }
        long j16 = this.f406181c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f406182d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        long j18 = this.f406183e;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f406179a = 0L;
        this.f406180b = "";
        this.f406181c = 0L;
        this.f406182d = 0L;
        this.f406183e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
