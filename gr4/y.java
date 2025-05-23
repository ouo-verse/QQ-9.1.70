package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class y extends ExtendableMessageNano<y> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile y[] f403242d;

    /* renamed from: a, reason: collision with root package name */
    public int f403243a;

    /* renamed from: b, reason: collision with root package name */
    public long f403244b;

    /* renamed from: c, reason: collision with root package name */
    public String f403245c;

    public y() {
        a();
    }

    public static y[] b() {
        if (f403242d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403242d == null) {
                    f403242d = new y[0];
                }
            }
        }
        return f403242d;
    }

    public y a() {
        this.f403243a = 0;
        this.f403244b = 0L;
        this.f403245c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f403245c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403244b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f403243a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403243a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f403244b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f403245c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f403245c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403243a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f403244b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f403245c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403245c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
