package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile k[] f393094c;

    /* renamed from: a, reason: collision with root package name */
    public String f393095a;

    /* renamed from: b, reason: collision with root package name */
    public String f393096b;

    public k() {
        a();
    }

    public static k[] b() {
        if (f393094c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f393094c == null) {
                    f393094c = new k[0];
                }
            }
        }
        return f393094c;
    }

    public k a() {
        this.f393095a = "";
        this.f393096b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f393096b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f393095a = codedInputByteBufferNano.readString();
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
        if (!this.f393095a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f393095a);
        }
        if (!this.f393096b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f393096b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f393095a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f393095a);
        }
        if (!this.f393096b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f393096b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
