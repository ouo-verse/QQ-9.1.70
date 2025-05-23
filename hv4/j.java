package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j[] f406436d;

    /* renamed from: a, reason: collision with root package name */
    public String f406437a;

    /* renamed from: b, reason: collision with root package name */
    public String f406438b;

    /* renamed from: c, reason: collision with root package name */
    public String f406439c;

    public j() {
        a();
    }

    public static j[] b() {
        if (f406436d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406436d == null) {
                    f406436d = new j[0];
                }
            }
        }
        return f406436d;
    }

    public j a() {
        this.f406437a = "";
        this.f406438b = "";
        this.f406439c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406437a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406438b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406439c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406437a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406437a);
        }
        if (!this.f406438b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406438b);
        }
        return !this.f406439c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f406439c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406437a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406437a);
        }
        if (!this.f406438b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406438b);
        }
        if (!this.f406439c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406439c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
