package lt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f415537c;

    /* renamed from: a, reason: collision with root package name */
    public String f415538a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f415539b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f415537c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f415537c == null) {
                    f415537c = new a[0];
                }
            }
        }
        return f415537c;
    }

    public a a() {
        this.f415538a = "";
        this.f415539b = WireFormatNano.EMPTY_BYTES;
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
                        this.f415539b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f415538a = codedInputByteBufferNano.readString();
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
        if (!this.f415538a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415538a);
        }
        if (!Arrays.equals(this.f415539b, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.f415539b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415538a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415538a);
        }
        if (!Arrays.equals(this.f415539b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f415539b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
