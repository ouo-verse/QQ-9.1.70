package e55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d[] f395739b;

    /* renamed from: a, reason: collision with root package name */
    public String f395740a;

    public d() {
        a();
    }

    public static d[] b() {
        if (f395739b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395739b == null) {
                    f395739b = new d[0];
                }
            }
        }
        return f395739b;
    }

    public d a() {
        this.f395740a = "";
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
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.f395740a = codedInputByteBufferNano.readString();
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
        if (!this.f395740a.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.f395740a);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395740a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395740a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
