package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile t[] f400580k;

    /* renamed from: a, reason: collision with root package name */
    public long f400581a;

    /* renamed from: b, reason: collision with root package name */
    public u f400582b;

    /* renamed from: c, reason: collision with root package name */
    public String f400583c;

    /* renamed from: d, reason: collision with root package name */
    public int f400584d;

    /* renamed from: e, reason: collision with root package name */
    public d f400585e;

    /* renamed from: f, reason: collision with root package name */
    public h f400586f;

    /* renamed from: g, reason: collision with root package name */
    public int f400587g;

    /* renamed from: h, reason: collision with root package name */
    public o f400588h;

    /* renamed from: i, reason: collision with root package name */
    public o f400589i;

    /* renamed from: j, reason: collision with root package name */
    public o f400590j;

    public t() {
        a();
    }

    public static t[] b() {
        if (f400580k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400580k == null) {
                    f400580k = new t[0];
                }
            }
        }
        return f400580k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f400581a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    if (this.f400582b == null) {
                        this.f400582b = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f400582b);
                    break;
                case 26:
                    this.f400583c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f400584d = readInt32;
                        break;
                    }
                case 42:
                    if (this.f400585e == null) {
                        this.f400585e = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f400585e);
                    break;
                case 50:
                    if (this.f400586f == null) {
                        this.f400586f = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f400586f);
                    break;
                case 56:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f400587g = readInt322;
                        break;
                    }
                case 186:
                    if (this.f400588h == null) {
                        this.f400588h = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f400588h);
                    break;
                case 194:
                    if (this.f400589i == null) {
                        this.f400589i = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f400589i);
                    break;
                case 202:
                    if (this.f400590j == null) {
                        this.f400590j = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f400590j);
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
        long j3 = this.f400581a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        u uVar = this.f400582b;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar);
        }
        if (!this.f400583c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400583c);
        }
        int i3 = this.f400584d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        d dVar = this.f400585e;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, dVar);
        }
        h hVar = this.f400586f;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, hVar);
        }
        int i16 = this.f400587g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        o oVar = this.f400588h;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, oVar);
        }
        o oVar2 = this.f400589i;
        if (oVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, oVar2);
        }
        o oVar3 = this.f400590j;
        return oVar3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(25, oVar3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400581a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        u uVar = this.f400582b;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar);
        }
        if (!this.f400583c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400583c);
        }
        int i3 = this.f400584d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        d dVar = this.f400585e;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(5, dVar);
        }
        h hVar = this.f400586f;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(6, hVar);
        }
        int i16 = this.f400587g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        o oVar = this.f400588h;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(23, oVar);
        }
        o oVar2 = this.f400589i;
        if (oVar2 != null) {
            codedOutputByteBufferNano.writeMessage(24, oVar2);
        }
        o oVar3 = this.f400590j;
        if (oVar3 != null) {
            codedOutputByteBufferNano.writeMessage(25, oVar3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f400581a = 0L;
        this.f400582b = null;
        this.f400583c = "";
        this.f400584d = 0;
        this.f400585e = null;
        this.f400586f = null;
        this.f400587g = 0;
        this.f400588h = null;
        this.f400589i = null;
        this.f400590j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
