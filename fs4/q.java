package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile q[] f400561h;

    /* renamed from: a, reason: collision with root package name */
    public long f400562a;

    /* renamed from: b, reason: collision with root package name */
    public k f400563b;

    /* renamed from: c, reason: collision with root package name */
    public long f400564c;

    /* renamed from: d, reason: collision with root package name */
    public long f400565d;

    /* renamed from: e, reason: collision with root package name */
    public e f400566e;

    /* renamed from: f, reason: collision with root package name */
    public c f400567f;

    /* renamed from: g, reason: collision with root package name */
    public int f400568g;

    public q() {
        a();
    }

    public static q[] b() {
        if (f400561h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400561h == null) {
                    f400561h = new q[0];
                }
            }
        }
        return f400561h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400562a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                if (this.f400563b == null) {
                    this.f400563b = new k();
                }
                codedInputByteBufferNano.readMessage(this.f400563b);
            } else if (readTag == 24) {
                this.f400564c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f400565d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                if (this.f400566e == null) {
                    this.f400566e = new e();
                }
                codedInputByteBufferNano.readMessage(this.f400566e);
            } else if (readTag == 50) {
                if (this.f400567f == null) {
                    this.f400567f = new c();
                }
                codedInputByteBufferNano.readMessage(this.f400567f);
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f400568g = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f400562a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        k kVar = this.f400563b;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j16 = this.f400564c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        long j17 = this.f400565d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        e eVar = this.f400566e;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
        }
        c cVar = this.f400567f;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, cVar);
        }
        int i3 = this.f400568g;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400562a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        k kVar = this.f400563b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j16 = this.f400564c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        long j17 = this.f400565d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        e eVar = this.f400566e;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        c cVar = this.f400567f;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(6, cVar);
        }
        int i3 = this.f400568g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f400562a = 0L;
        this.f400563b = null;
        this.f400564c = 0L;
        this.f400565d = 0L;
        this.f400566e = null;
        this.f400567f = null;
        this.f400568g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
