package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile l[] f400534e;

    /* renamed from: a, reason: collision with root package name */
    public long f400535a;

    /* renamed from: b, reason: collision with root package name */
    public long f400536b;

    /* renamed from: c, reason: collision with root package name */
    public v f400537c;

    /* renamed from: d, reason: collision with root package name */
    public a f400538d;

    public l() {
        a();
    }

    public static l[] b() {
        if (f400534e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400534e == null) {
                    f400534e = new l[0];
                }
            }
        }
        return f400534e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400535a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f400536b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                if (this.f400537c == null) {
                    this.f400537c = new v();
                }
                codedInputByteBufferNano.readMessage(this.f400537c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f400538d == null) {
                    this.f400538d = new a();
                }
                codedInputByteBufferNano.readMessage(this.f400538d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f400535a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f400536b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        v vVar = this.f400537c;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vVar);
        }
        a aVar = this.f400538d;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400535a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f400536b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        v vVar = this.f400537c;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(3, vVar);
        }
        a aVar = this.f400538d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f400535a = 0L;
        this.f400536b = 0L;
        this.f400537c = null;
        this.f400538d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
