package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile i[] f411034d;

    /* renamed from: a, reason: collision with root package name */
    public long f411035a;

    /* renamed from: b, reason: collision with root package name */
    public int f411036b;

    /* renamed from: c, reason: collision with root package name */
    public o f411037c;

    public i() {
        a();
    }

    public static i[] b() {
        if (f411034d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f411034d == null) {
                    f411034d = new i[0];
                }
            }
        }
        return f411034d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f411035a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f411036b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f411037c == null) {
                    this.f411037c = new o();
                }
                codedInputByteBufferNano.readMessage(this.f411037c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f411035a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f411036b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        o oVar = this.f411037c;
        return oVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, oVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f411035a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f411036b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        o oVar = this.f411037c;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(3, oVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f411035a = 0L;
        this.f411036b = 0;
        this.f411037c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
