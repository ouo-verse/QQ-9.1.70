package f55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile e[] f397868d;

    /* renamed from: a, reason: collision with root package name */
    public long f397869a;

    /* renamed from: b, reason: collision with root package name */
    public String f397870b;

    /* renamed from: c, reason: collision with root package name */
    public int f397871c;

    public e() {
        a();
    }

    public static e[] b() {
        if (f397868d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397868d == null) {
                    f397868d = new e[0];
                }
            }
        }
        return f397868d;
    }

    public e a() {
        this.f397869a = 0L;
        this.f397870b = "";
        this.f397871c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f397871c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f397870b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f397869a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f397869a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f397870b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397870b);
        }
        int i3 = this.f397871c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f397869a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f397870b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397870b);
        }
        int i3 = this.f397871c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
