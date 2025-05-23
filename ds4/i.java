package ds4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile i[] f394783g;

    /* renamed from: a, reason: collision with root package name */
    public long f394784a;

    /* renamed from: b, reason: collision with root package name */
    public long f394785b;

    /* renamed from: c, reason: collision with root package name */
    public long f394786c;

    /* renamed from: d, reason: collision with root package name */
    public int f394787d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f394788e;

    /* renamed from: f, reason: collision with root package name */
    public j f394789f;

    public i() {
        a();
    }

    public static i[] b() {
        if (f394783g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f394783g == null) {
                    f394783g = new i[0];
                }
            }
        }
        return f394783g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f394784a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f394785b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f394786c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f394787d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 42) {
                this.f394788e = codedInputByteBufferNano.readBytes();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f394789f == null) {
                    this.f394789f = new j();
                }
                codedInputByteBufferNano.readMessage(this.f394789f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f394784a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f394785b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f394786c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        int i3 = this.f394787d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!Arrays.equals(this.f394788e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f394788e);
        }
        j jVar = this.f394789f;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394784a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f394785b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f394786c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        int i3 = this.f394787d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!Arrays.equals(this.f394788e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f394788e);
        }
        j jVar = this.f394789f;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(6, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f394784a = 0L;
        this.f394785b = 0L;
        this.f394786c = 0L;
        this.f394787d = 0;
        this.f394788e = WireFormatNano.EMPTY_BYTES;
        this.f394789f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
