package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class as extends ExtendableMessageNano<as> {

    /* renamed from: a, reason: collision with root package name */
    public long f401312a;

    /* renamed from: b, reason: collision with root package name */
    public int f401313b;

    /* renamed from: c, reason: collision with root package name */
    public e55.c f401314c;

    /* renamed from: d, reason: collision with root package name */
    public e55.c f401315d;

    /* renamed from: e, reason: collision with root package name */
    public long f401316e;

    /* renamed from: f, reason: collision with root package name */
    public long f401317f;

    /* renamed from: g, reason: collision with root package name */
    public long f401318g;

    /* renamed from: h, reason: collision with root package name */
    public long f401319h;

    /* renamed from: i, reason: collision with root package name */
    public e55.c f401320i;

    /* renamed from: j, reason: collision with root package name */
    public int f401321j;

    /* renamed from: k, reason: collision with root package name */
    public e55.c f401322k;

    /* renamed from: l, reason: collision with root package name */
    public long f401323l;

    public as() {
        a();
    }

    public as a() {
        this.f401312a = 0L;
        this.f401313b = 0;
        this.f401314c = null;
        this.f401315d = null;
        this.f401316e = 0L;
        this.f401317f = 0L;
        this.f401318g = 0L;
        this.f401319h = 0L;
        this.f401320i = null;
        this.f401321j = 0;
        this.f401322k = null;
        this.f401323l = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public as mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f401312a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f401313b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    if (this.f401314c == null) {
                        this.f401314c = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401314c);
                    break;
                case 34:
                    if (this.f401315d == null) {
                        this.f401315d = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401315d);
                    break;
                case 40:
                    this.f401316e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f401317f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f401318g = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.f401319h = codedInputByteBufferNano.readInt64();
                    break;
                case 74:
                    if (this.f401320i == null) {
                        this.f401320i = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401320i);
                    break;
                case 80:
                    this.f401321j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    if (this.f401322k == null) {
                        this.f401322k = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401322k);
                    break;
                case 96:
                    this.f401323l = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f401312a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f401313b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        e55.c cVar = this.f401314c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        e55.c cVar2 = this.f401315d;
        if (cVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar2);
        }
        long j16 = this.f401316e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f401317f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f401318g;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j18);
        }
        long j19 = this.f401319h;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j19);
        }
        e55.c cVar3 = this.f401320i;
        if (cVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, cVar3);
        }
        int i16 = this.f401321j;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        e55.c cVar4 = this.f401322k;
        if (cVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, cVar4);
        }
        long j26 = this.f401323l;
        if (j26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(12, j26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f401312a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f401313b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        e55.c cVar = this.f401314c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        e55.c cVar2 = this.f401315d;
        if (cVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar2);
        }
        long j16 = this.f401316e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f401317f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f401318g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j18);
        }
        long j19 = this.f401319h;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j19);
        }
        e55.c cVar3 = this.f401320i;
        if (cVar3 != null) {
            codedOutputByteBufferNano.writeMessage(9, cVar3);
        }
        int i16 = this.f401321j;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        e55.c cVar4 = this.f401322k;
        if (cVar4 != null) {
            codedOutputByteBufferNano.writeMessage(11, cVar4);
        }
        long j26 = this.f401323l;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
