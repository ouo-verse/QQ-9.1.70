package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile v[] f427243c;

    /* renamed from: a, reason: collision with root package name */
    public long f427244a;

    /* renamed from: b, reason: collision with root package name */
    public String f427245b;

    public v() {
        a();
    }

    public static v[] b() {
        if (f427243c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427243c == null) {
                    f427243c = new v[0];
                }
            }
        }
        return f427243c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427244a = codedInputByteBufferNano.readInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427245b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427244a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        return !this.f427245b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f427245b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427244a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        if (!this.f427245b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427245b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public v a() {
        this.f427244a = 0L;
        this.f427245b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
