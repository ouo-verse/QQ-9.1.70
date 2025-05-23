package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile n[] f423523c;

    /* renamed from: a, reason: collision with root package name */
    public long f423524a;

    /* renamed from: b, reason: collision with root package name */
    public o f423525b;

    public n() {
        a();
    }

    public static n[] b() {
        if (f423523c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423523c == null) {
                    f423523c = new n[0];
                }
            }
        }
        return f423523c;
    }

    public n a() {
        this.f423524a = 0L;
        this.f423525b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f423525b == null) {
                            this.f423525b = new o();
                        }
                        codedInputByteBufferNano.readMessage(this.f423525b);
                    }
                } else {
                    this.f423524a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f423524a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        o oVar = this.f423525b;
        if (oVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, oVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f423524a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        o oVar = this.f423525b;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(2, oVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
