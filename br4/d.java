package br4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f29027c;

    /* renamed from: a, reason: collision with root package name */
    public long f29028a;

    /* renamed from: b, reason: collision with root package name */
    public c f29029b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f29027c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29027c == null) {
                    f29027c = new d[0];
                }
            }
        }
        return f29027c;
    }

    public d a() {
        this.f29028a = 0L;
        this.f29029b = null;
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
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f29029b == null) {
                            this.f29029b = new c();
                        }
                        codedInputByteBufferNano.readMessage(this.f29029b);
                    }
                } else {
                    this.f29028a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f29028a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        c cVar = this.f29029b;
        if (cVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, cVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29028a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        c cVar = this.f29029b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
