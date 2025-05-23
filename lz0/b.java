package lz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b[] f415805c;

    /* renamed from: a, reason: collision with root package name */
    public f f415806a;

    /* renamed from: b, reason: collision with root package name */
    public g f415807b;

    public b() {
        a();
    }

    public static b[] b() {
        if (f415805c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f415805c == null) {
                    f415805c = new b[0];
                }
            }
        }
        return f415805c;
    }

    public b a() {
        this.f415806a = null;
        this.f415807b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f415807b == null) {
                            this.f415807b = new g();
                        }
                        codedInputByteBufferNano.readMessage(this.f415807b);
                    }
                } else {
                    if (this.f415806a == null) {
                        this.f415806a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f415806a);
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
        f fVar = this.f415806a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        g gVar = this.f415807b;
        if (gVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f415806a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        g gVar = this.f415807b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
