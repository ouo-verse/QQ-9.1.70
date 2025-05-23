package lz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f415813c;

    /* renamed from: a, reason: collision with root package name */
    public String f415814a;

    /* renamed from: b, reason: collision with root package name */
    public String f415815b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f415813c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f415813c == null) {
                    f415813c = new e[0];
                }
            }
        }
        return f415813c;
    }

    public e a() {
        this.f415814a = "";
        this.f415815b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f415815b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f415814a = codedInputByteBufferNano.readString();
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
        if (!this.f415814a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415814a);
        }
        if (!this.f415815b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f415815b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415814a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415814a);
        }
        if (!this.f415815b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415815b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
