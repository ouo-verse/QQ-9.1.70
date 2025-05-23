package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c[] f391727b;

    /* renamed from: a, reason: collision with root package name */
    public String f391728a;

    public c() {
        a();
    }

    public static c[] b() {
        if (f391727b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391727b == null) {
                    f391727b = new c[0];
                }
            }
        }
        return f391727b;
    }

    public c a() {
        this.f391728a = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.f391728a = codedInputByteBufferNano.readString();
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
        if (!this.f391728a.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.f391728a);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f391728a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f391728a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
