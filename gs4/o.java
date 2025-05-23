package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile o[] f403317g;

    /* renamed from: a, reason: collision with root package name */
    public long f403318a;

    /* renamed from: b, reason: collision with root package name */
    public long f403319b;

    /* renamed from: c, reason: collision with root package name */
    public long f403320c;

    /* renamed from: d, reason: collision with root package name */
    public int f403321d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f403322e;

    /* renamed from: f, reason: collision with root package name */
    public p f403323f;

    public o() {
        a();
    }

    public static o[] b() {
        if (f403317g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403317g == null) {
                    f403317g = new o[0];
                }
            }
        }
        return f403317g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403318a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f403319b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f403320c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f403321d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 42) {
                this.f403322e = codedInputByteBufferNano.readBytes();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403323f == null) {
                    this.f403323f = new p();
                }
                codedInputByteBufferNano.readMessage(this.f403323f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f403318a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f403319b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f403320c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        int i3 = this.f403321d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!Arrays.equals(this.f403322e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f403322e);
        }
        p pVar = this.f403323f;
        return pVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, pVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403318a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f403319b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f403320c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        int i3 = this.f403321d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!Arrays.equals(this.f403322e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f403322e);
        }
        p pVar = this.f403323f;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(6, pVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f403318a = 0L;
        this.f403319b = 0L;
        this.f403320c = 0L;
        this.f403321d = 0;
        this.f403322e = WireFormatNano.EMPTY_BYTES;
        this.f403323f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
