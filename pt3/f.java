package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile f[] f427141c;

    /* renamed from: a, reason: collision with root package name */
    public String f427142a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f427143b;

    public f() {
        a();
    }

    public static f[] b() {
        if (f427141c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427141c == null) {
                    f427141c = new f[0];
                }
            }
        }
        return f427141c;
    }

    public f a() {
        this.f427142a = "";
        this.f427143b = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f427143b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f427142a = codedInputByteBufferNano.readString();
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
        if (!this.f427142a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427142a);
        }
        if (!Arrays.equals(this.f427143b, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.f427143b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427142a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427142a);
        }
        if (!Arrays.equals(this.f427143b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f427143b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
