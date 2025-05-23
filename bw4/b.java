package bw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f29338d;

    /* renamed from: a, reason: collision with root package name */
    public String f29339a;

    /* renamed from: b, reason: collision with root package name */
    public long f29340b;

    /* renamed from: c, reason: collision with root package name */
    public String f29341c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f29338d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29338d == null) {
                    f29338d = new b[0];
                }
            }
        }
        return f29338d;
    }

    public b a() {
        this.f29339a = "";
        this.f29340b = 0L;
        this.f29341c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29339a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f29340b = codedInputByteBufferNano.readInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29341c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29339a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29339a);
        }
        long j3 = this.f29340b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        return !this.f29341c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f29341c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29339a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29339a);
        }
        long j3 = this.f29340b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f29341c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f29341c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
