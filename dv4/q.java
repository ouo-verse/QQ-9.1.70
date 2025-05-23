package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile q[] f395049c;

    /* renamed from: a, reason: collision with root package name */
    public j f395050a;

    /* renamed from: b, reason: collision with root package name */
    public r f395051b;

    public q() {
        a();
    }

    public static q[] b() {
        if (f395049c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395049c == null) {
                    f395049c = new q[0];
                }
            }
        }
        return f395049c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f395050a == null) {
                    this.f395050a = new j();
                }
                codedInputByteBufferNano.readMessage(this.f395050a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f395051b == null) {
                    this.f395051b = new r();
                }
                codedInputByteBufferNano.readMessage(this.f395051b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        j jVar = this.f395050a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        r rVar = this.f395051b;
        return rVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, rVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f395050a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        r rVar = this.f395051b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f395050a = null;
        this.f395051b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
