package dr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f394722c;

    /* renamed from: a, reason: collision with root package name */
    public String f394723a;

    /* renamed from: b, reason: collision with root package name */
    public String f394724b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f394722c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f394722c == null) {
                    f394722c = new d[0];
                }
            }
        }
        return f394722c;
    }

    public d a() {
        this.f394723a = "";
        this.f394724b = "";
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
                        this.f394724b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394723a = codedInputByteBufferNano.readString();
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
        if (!this.f394723a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394723a);
        }
        if (!this.f394724b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f394724b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394723a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394723a);
        }
        if (!this.f394724b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394724b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
