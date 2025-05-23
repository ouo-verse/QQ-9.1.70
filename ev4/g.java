package ev4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile g[] f397237d;

    /* renamed from: a, reason: collision with root package name */
    public String f397238a;

    /* renamed from: b, reason: collision with root package name */
    public String f397239b;

    /* renamed from: c, reason: collision with root package name */
    public String f397240c;

    public g() {
        a();
    }

    public static g[] b() {
        if (f397237d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397237d == null) {
                    f397237d = new g[0];
                }
            }
        }
        return f397237d;
    }

    public g a() {
        this.f397238a = "";
        this.f397239b = "";
        this.f397240c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f397238a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f397239b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397240c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f397238a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f397238a);
        }
        if (!this.f397239b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397239b);
        }
        return !this.f397240c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f397240c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f397238a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f397238a);
        }
        if (!this.f397239b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397239b);
        }
        if (!this.f397240c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397240c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
