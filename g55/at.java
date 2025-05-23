package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class at extends ExtendableMessageNano<at> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile at[] f401324l;

    /* renamed from: a, reason: collision with root package name */
    public long f401325a;

    /* renamed from: b, reason: collision with root package name */
    public int f401326b;

    /* renamed from: c, reason: collision with root package name */
    public e f401327c;

    /* renamed from: d, reason: collision with root package name */
    public e f401328d;

    /* renamed from: e, reason: collision with root package name */
    public long f401329e;

    /* renamed from: f, reason: collision with root package name */
    public long f401330f;

    /* renamed from: g, reason: collision with root package name */
    public e f401331g;

    /* renamed from: h, reason: collision with root package name */
    public int f401332h;

    /* renamed from: i, reason: collision with root package name */
    public e f401333i;

    /* renamed from: j, reason: collision with root package name */
    public av f401334j;

    /* renamed from: k, reason: collision with root package name */
    public long f401335k;

    public at() {
        a();
    }

    public static at[] b() {
        if (f401324l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f401324l == null) {
                    f401324l = new at[0];
                }
            }
        }
        return f401324l;
    }

    public at a() {
        this.f401325a = 0L;
        this.f401326b = 0;
        this.f401327c = null;
        this.f401328d = null;
        this.f401329e = 0L;
        this.f401330f = 0L;
        this.f401331g = null;
        this.f401332h = 0;
        this.f401333i = null;
        this.f401334j = null;
        this.f401335k = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public at mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f401325a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f401326b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    if (this.f401327c == null) {
                        this.f401327c = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f401327c);
                    break;
                case 34:
                    if (this.f401328d == null) {
                        this.f401328d = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f401328d);
                    break;
                case 40:
                    this.f401329e = codedInputByteBufferNano.readInt64();
                    break;
                case 48:
                    this.f401330f = codedInputByteBufferNano.readInt64();
                    break;
                case 58:
                    if (this.f401331g == null) {
                        this.f401331g = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f401331g);
                    break;
                case 64:
                    this.f401332h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.f401333i == null) {
                        this.f401333i = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f401333i);
                    break;
                case 82:
                    if (this.f401334j == null) {
                        this.f401334j = new av();
                    }
                    codedInputByteBufferNano.readMessage(this.f401334j);
                    break;
                case 88:
                    this.f401335k = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f401325a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f401326b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        e eVar = this.f401327c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        e eVar2 = this.f401328d;
        if (eVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar2);
        }
        long j16 = this.f401329e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        long j17 = this.f401330f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j17);
        }
        e eVar3 = this.f401331g;
        if (eVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, eVar3);
        }
        int i16 = this.f401332h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        e eVar4 = this.f401333i;
        if (eVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, eVar4);
        }
        av avVar = this.f401334j;
        if (avVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, avVar);
        }
        long j18 = this.f401335k;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(11, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f401325a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f401326b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        e eVar = this.f401327c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        e eVar2 = this.f401328d;
        if (eVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar2);
        }
        long j16 = this.f401329e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        long j17 = this.f401330f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j17);
        }
        e eVar3 = this.f401331g;
        if (eVar3 != null) {
            codedOutputByteBufferNano.writeMessage(7, eVar3);
        }
        int i16 = this.f401332h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        e eVar4 = this.f401333i;
        if (eVar4 != null) {
            codedOutputByteBufferNano.writeMessage(9, eVar4);
        }
        av avVar = this.f401334j;
        if (avVar != null) {
            codedOutputByteBufferNano.writeMessage(10, avVar);
        }
        long j18 = this.f401335k;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(11, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
