package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import hs4.r;
import hs4.s;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f29039a;

    /* renamed from: b, reason: collision with root package name */
    public long f29040b;

    /* renamed from: c, reason: collision with root package name */
    public h f29041c;

    /* renamed from: d, reason: collision with root package name */
    public h f29042d;

    /* renamed from: e, reason: collision with root package name */
    public r f29043e;

    /* renamed from: f, reason: collision with root package name */
    public d f29044f;

    /* renamed from: g, reason: collision with root package name */
    public long f29045g;

    /* renamed from: h, reason: collision with root package name */
    public long f29046h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f29047i;

    /* renamed from: j, reason: collision with root package name */
    public s f29048j;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f29039a = codedInputByteBufferNano.readInt64();
                    break;
                case 16:
                    this.f29040b = codedInputByteBufferNano.readInt64();
                    break;
                case 26:
                    if (this.f29041c == null) {
                        this.f29041c = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f29041c);
                    break;
                case 34:
                    if (this.f29042d == null) {
                        this.f29042d = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f29042d);
                    break;
                case 42:
                    if (this.f29043e == null) {
                        this.f29043e = new r();
                    }
                    codedInputByteBufferNano.readMessage(this.f29043e);
                    break;
                case 50:
                    if (this.f29044f == null) {
                        this.f29044f = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f29044f);
                    break;
                case 56:
                    this.f29045g = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.f29046h = codedInputByteBufferNano.readInt64();
                    break;
                case 72:
                    this.f29047i = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    if (this.f29048j == null) {
                        this.f29048j = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f29048j);
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29039a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f29040b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        h hVar = this.f29041c;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
        }
        h hVar2 = this.f29042d;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar2);
        }
        r rVar = this.f29043e;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, rVar);
        }
        d dVar = this.f29044f;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, dVar);
        }
        long j17 = this.f29045g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j17);
        }
        long j18 = this.f29046h;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j18);
        }
        boolean z16 = this.f29047i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        s sVar = this.f29048j;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29039a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f29040b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        h hVar = this.f29041c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        h hVar2 = this.f29042d;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, hVar2);
        }
        r rVar = this.f29043e;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(5, rVar);
        }
        d dVar = this.f29044f;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(6, dVar);
        }
        long j17 = this.f29045g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j17);
        }
        long j18 = this.f29046h;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j18);
        }
        boolean z16 = this.f29047i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        s sVar = this.f29048j;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(10, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f29039a = 0L;
        this.f29040b = 0L;
        this.f29041c = null;
        this.f29042d = null;
        this.f29043e = null;
        this.f29044f = null;
        this.f29045g = 0L;
        this.f29046h = 0L;
        this.f29047i = false;
        this.f29048j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
