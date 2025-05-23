package it3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b[] f408723c;

    /* renamed from: a, reason: collision with root package name */
    public long f408724a;

    /* renamed from: b, reason: collision with root package name */
    public String f408725b;

    public b() {
        a();
    }

    public static b[] b() {
        if (f408723c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408723c == null) {
                    f408723c = new b[0];
                }
            }
        }
        return f408723c;
    }

    public b a() {
        this.f408724a = 0L;
        this.f408725b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f408725b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408724a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f408724a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f408725b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f408725b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f408724a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f408725b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408725b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
