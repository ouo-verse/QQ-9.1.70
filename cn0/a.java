package cn0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f31131c;

    /* renamed from: a, reason: collision with root package name */
    public String f31132a;

    /* renamed from: b, reason: collision with root package name */
    public String f31133b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f31131c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f31131c == null) {
                    f31131c = new a[0];
                }
            }
        }
        return f31131c;
    }

    public a a() {
        this.f31132a = "";
        this.f31133b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f31133b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f31132a = codedInputByteBufferNano.readString();
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
        if (!this.f31132a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f31132a);
        }
        if (!this.f31133b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f31133b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f31132a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f31132a);
        }
        if (!this.f31133b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f31133b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
