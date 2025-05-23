package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile r[] f406488d;

    /* renamed from: a, reason: collision with root package name */
    public long f406489a;

    /* renamed from: b, reason: collision with root package name */
    public String f406490b;

    /* renamed from: c, reason: collision with root package name */
    public String f406491c;

    public r() {
        a();
    }

    public static r[] b() {
        if (f406488d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406488d == null) {
                    f406488d = new r[0];
                }
            }
        }
        return f406488d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406489a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                this.f406490b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406491c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f406489a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        if (!this.f406490b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406490b);
        }
        return !this.f406491c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f406491c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406489a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        if (!this.f406490b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406490b);
        }
        if (!this.f406491c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406491c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f406489a = 0L;
        this.f406490b = "";
        this.f406491c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
