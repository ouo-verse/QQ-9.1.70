package iv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile k[] f408830d;

    /* renamed from: a, reason: collision with root package name */
    public kv4.a f408831a;

    /* renamed from: b, reason: collision with root package name */
    public j f408832b;

    /* renamed from: c, reason: collision with root package name */
    public m f408833c;

    public k() {
        a();
    }

    public static k[] b() {
        if (f408830d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408830d == null) {
                    f408830d = new k[0];
                }
            }
        }
        return f408830d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f408831a == null) {
                    this.f408831a = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f408831a);
            } else if (readTag == 18) {
                if (this.f408832b == null) {
                    this.f408832b = new j();
                }
                codedInputByteBufferNano.readMessage(this.f408832b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f408833c == null) {
                    this.f408833c = new m();
                }
                codedInputByteBufferNano.readMessage(this.f408833c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        kv4.a aVar = this.f408831a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        j jVar = this.f408832b;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, jVar);
        }
        m mVar = this.f408833c;
        return mVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, mVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        kv4.a aVar = this.f408831a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        j jVar = this.f408832b;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(2, jVar);
        }
        m mVar = this.f408833c;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(3, mVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f408831a = null;
        this.f408832b = null;
        this.f408833c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
