package cq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f391676c;

    /* renamed from: a, reason: collision with root package name */
    public e f391677a;

    /* renamed from: b, reason: collision with root package name */
    public long f391678b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f391676c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391676c == null) {
                    f391676c = new d[0];
                }
            }
        }
        return f391676c;
    }

    public d a() {
        this.f391677a = null;
        this.f391678b = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f391678b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    if (this.f391677a == null) {
                        this.f391677a = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f391677a);
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
        e eVar = this.f391677a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        long j3 = this.f391678b;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f391677a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        long j3 = this.f391678b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
