package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class aq extends ExtendableMessageNano<aq> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile aq[] f400728c;

    /* renamed from: a, reason: collision with root package name */
    public s f400729a;

    /* renamed from: b, reason: collision with root package name */
    public int f400730b;

    public aq() {
        a();
    }

    public static aq[] b() {
        if (f400728c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400728c == null) {
                    f400728c = new aq[0];
                }
            }
        }
        return f400728c;
    }

    public aq a() {
        this.f400729a = null;
        this.f400730b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 100 || readInt32 == 200) {
                            this.f400730b = readInt32;
                        }
                    }
                } else {
                    if (this.f400729a == null) {
                        this.f400729a = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f400729a);
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
        s sVar = this.f400729a;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sVar);
        }
        int i3 = this.f400730b;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        s sVar = this.f400729a;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(1, sVar);
        }
        int i3 = this.f400730b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
