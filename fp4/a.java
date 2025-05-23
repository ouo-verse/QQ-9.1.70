package fp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f400277c;

    /* renamed from: a, reason: collision with root package name */
    public int f400278a;

    /* renamed from: b, reason: collision with root package name */
    public b f400279b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f400277c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400277c == null) {
                    f400277c = new a[0];
                }
            }
        }
        return f400277c;
    }

    public a a() {
        this.f400278a = 0;
        this.f400279b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f400279b == null) {
                            this.f400279b = new b();
                        }
                        codedInputByteBufferNano.readMessage(this.f400279b);
                    }
                } else {
                    this.f400278a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f400278a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        b bVar = this.f400279b;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400278a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        b bVar = this.f400279b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
