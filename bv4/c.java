package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f29265a;

    /* renamed from: b, reason: collision with root package name */
    public long f29266b;

    /* renamed from: c, reason: collision with root package name */
    public long f29267c;

    /* renamed from: d, reason: collision with root package name */
    public long f29268d;

    /* renamed from: e, reason: collision with root package name */
    public int f29269e;

    /* renamed from: f, reason: collision with root package name */
    public String f29270f;

    public c() {
        a();
    }

    public c a() {
        this.f29265a = "";
        this.f29266b = 0L;
        this.f29267c = 0L;
        this.f29268d = 0L;
        this.f29269e = 0;
        this.f29270f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29265a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f29266b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f29267c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f29268d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 109 || readInt32 == 110) {
                    this.f29269e = readInt32;
                }
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29270f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29265a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29265a);
        }
        long j3 = this.f29266b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f29267c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f29268d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        int i3 = this.f29269e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return !this.f29270f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f29270f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29265a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29265a);
        }
        long j3 = this.f29266b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f29267c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f29268d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        int i3 = this.f29269e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        if (!this.f29270f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f29270f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
