package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile m[] f400539c;

    /* renamed from: a, reason: collision with root package name */
    public int f400540a;

    /* renamed from: b, reason: collision with root package name */
    public k f400541b;

    public m() {
        a();
    }

    public static m[] b() {
        if (f400539c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400539c == null) {
                    f400539c = new m[0];
                }
            }
        }
        return f400539c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400540a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f400541b == null) {
                    this.f400541b = new k();
                }
                codedInputByteBufferNano.readMessage(this.f400541b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f400540a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        k kVar = this.f400541b;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400540a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        k kVar = this.f400541b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f400540a = 0;
        this.f400541b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
