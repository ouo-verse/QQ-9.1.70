package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile g[] f29061g;

    /* renamed from: a, reason: collision with root package name */
    public long f29062a;

    /* renamed from: b, reason: collision with root package name */
    public e f29063b;

    /* renamed from: c, reason: collision with root package name */
    public long f29064c;

    /* renamed from: d, reason: collision with root package name */
    public long f29065d;

    /* renamed from: e, reason: collision with root package name */
    public c f29066e;

    /* renamed from: f, reason: collision with root package name */
    public a f29067f;

    public g() {
        a();
    }

    public static g[] b() {
        if (f29061g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29061g == null) {
                    f29061g = new g[0];
                }
            }
        }
        return f29061g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29062a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                if (this.f29063b == null) {
                    this.f29063b = new e();
                }
                codedInputByteBufferNano.readMessage(this.f29063b);
            } else if (readTag == 24) {
                this.f29064c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f29065d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                if (this.f29066e == null) {
                    this.f29066e = new c();
                }
                codedInputByteBufferNano.readMessage(this.f29066e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f29067f == null) {
                    this.f29067f = new a();
                }
                codedInputByteBufferNano.readMessage(this.f29067f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29062a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        e eVar = this.f29063b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        long j16 = this.f29064c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        long j17 = this.f29065d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        c cVar = this.f29066e;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar);
        }
        a aVar = this.f29067f;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29062a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        e eVar = this.f29063b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        long j16 = this.f29064c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        long j17 = this.f29065d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        c cVar = this.f29066e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        a aVar = this.f29067f;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f29062a = 0L;
        this.f29063b = null;
        this.f29064c = 0L;
        this.f29065d = 0L;
        this.f29066e = null;
        this.f29067f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
