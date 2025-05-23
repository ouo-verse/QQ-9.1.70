package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile o[] f421440d;

    /* renamed from: a, reason: collision with root package name */
    public String f421441a;

    /* renamed from: b, reason: collision with root package name */
    public long f421442b;

    /* renamed from: c, reason: collision with root package name */
    public long f421443c;

    public o() {
        a();
    }

    public static o[] b() {
        if (f421440d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421440d == null) {
                    f421440d = new o[0];
                }
            }
        }
        return f421440d;
    }

    public o a() {
        this.f421441a = "";
        this.f421442b = 0L;
        this.f421443c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f421441a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f421442b = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f421443c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f421441a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421441a);
        }
        long j3 = this.f421442b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f421443c;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421441a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421441a);
        }
        long j3 = this.f421442b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f421443c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
