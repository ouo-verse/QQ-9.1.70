package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile e[] f411018j;

    /* renamed from: a, reason: collision with root package name */
    public long f411019a;

    /* renamed from: b, reason: collision with root package name */
    public int f411020b;

    /* renamed from: c, reason: collision with root package name */
    public int f411021c;

    /* renamed from: d, reason: collision with root package name */
    public k f411022d;

    /* renamed from: e, reason: collision with root package name */
    public l f411023e;

    /* renamed from: f, reason: collision with root package name */
    public h f411024f;

    /* renamed from: g, reason: collision with root package name */
    public a f411025g;

    /* renamed from: h, reason: collision with root package name */
    public c f411026h;

    /* renamed from: i, reason: collision with root package name */
    public m f411027i;

    public e() {
        a();
    }

    public static e[] b() {
        if (f411018j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f411018j == null) {
                    f411018j = new e[0];
                }
            }
        }
        return f411018j;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f411019a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f411020b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f411021c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 802) {
                if (this.f411022d == null) {
                    this.f411022d = new k();
                }
                codedInputByteBufferNano.readMessage(this.f411022d);
            } else if (readTag == 810) {
                if (this.f411023e == null) {
                    this.f411023e = new l();
                }
                codedInputByteBufferNano.readMessage(this.f411023e);
            } else if (readTag == 818) {
                if (this.f411024f == null) {
                    this.f411024f = new h();
                }
                codedInputByteBufferNano.readMessage(this.f411024f);
            } else if (readTag == 826) {
                if (this.f411025g == null) {
                    this.f411025g = new a();
                }
                codedInputByteBufferNano.readMessage(this.f411025g);
            } else if (readTag == 834) {
                if (this.f411026h == null) {
                    this.f411026h = new c();
                }
                codedInputByteBufferNano.readMessage(this.f411026h);
            } else if (readTag != 842) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f411027i == null) {
                    this.f411027i = new m();
                }
                codedInputByteBufferNano.readMessage(this.f411027i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f411019a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f411020b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f411021c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        k kVar = this.f411022d;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(100, kVar);
        }
        l lVar = this.f411023e;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(101, lVar);
        }
        h hVar = this.f411024f;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(102, hVar);
        }
        a aVar = this.f411025g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(103, aVar);
        }
        c cVar = this.f411026h;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(104, cVar);
        }
        m mVar = this.f411027i;
        return mVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(105, mVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f411019a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f411020b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f411021c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        k kVar = this.f411022d;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(100, kVar);
        }
        l lVar = this.f411023e;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(101, lVar);
        }
        h hVar = this.f411024f;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(102, hVar);
        }
        a aVar = this.f411025g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(103, aVar);
        }
        c cVar = this.f411026h;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(104, cVar);
        }
        m mVar = this.f411027i;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(105, mVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f411019a = 0L;
        this.f411020b = 0;
        this.f411021c = 0;
        this.f411022d = null;
        this.f411023e = null;
        this.f411024f = null;
        this.f411025g = null;
        this.f411026h = null;
        this.f411027i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
