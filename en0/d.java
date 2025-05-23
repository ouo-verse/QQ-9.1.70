package en0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f396867c;

    /* renamed from: a, reason: collision with root package name */
    public String f396868a;

    /* renamed from: b, reason: collision with root package name */
    public String f396869b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f396867c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f396867c == null) {
                    f396867c = new d[0];
                }
            }
        }
        return f396867c;
    }

    public d a() {
        this.f396868a = "";
        this.f396869b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f396869b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f396868a = codedInputByteBufferNano.readString();
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
        if (!this.f396868a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f396868a);
        }
        if (!this.f396869b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f396869b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f396868a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f396868a);
        }
        if (!this.f396869b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f396869b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
