package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public f f400519a;

    /* renamed from: b, reason: collision with root package name */
    public u f400520b;

    /* renamed from: c, reason: collision with root package name */
    public long f400521c;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f400519a == null) {
                    this.f400519a = new f();
                }
                codedInputByteBufferNano.readMessage(this.f400519a);
            } else if (readTag == 18) {
                if (this.f400520b == null) {
                    this.f400520b = new u();
                }
                codedInputByteBufferNano.readMessage(this.f400520b);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400521c = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        f fVar = this.f400519a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        u uVar = this.f400520b;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar);
        }
        long j3 = this.f400521c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f400519a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        u uVar = this.f400520b;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar);
        }
        long j3 = this.f400521c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f400519a = null;
        this.f400520b = null;
        this.f400521c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
