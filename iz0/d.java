package iz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f409025c;

    /* renamed from: a, reason: collision with root package name */
    public String f409026a;

    /* renamed from: b, reason: collision with root package name */
    public String f409027b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f409025c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f409025c == null) {
                    f409025c = new d[0];
                }
            }
        }
        return f409025c;
    }

    public d a() {
        this.f409026a = "";
        this.f409027b = "";
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
                        this.f409027b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f409026a = codedInputByteBufferNano.readString();
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
        if (!this.f409026a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f409026a);
        }
        if (!this.f409027b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f409027b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f409026a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f409026a);
        }
        if (!this.f409027b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f409027b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
