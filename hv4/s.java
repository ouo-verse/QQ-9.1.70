package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile s[] f406492e;

    /* renamed from: a, reason: collision with root package name */
    public String f406493a;

    /* renamed from: b, reason: collision with root package name */
    public String f406494b;

    /* renamed from: c, reason: collision with root package name */
    public String f406495c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f406496d;

    public s() {
        a();
    }

    public static s[] b() {
        if (f406492e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406492e == null) {
                    f406492e = new s[0];
                }
            }
        }
        return f406492e;
    }

    public s a() {
        this.f406493a = "";
        this.f406494b = "";
        this.f406495c = "";
        this.f406496d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406493a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406494b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f406495c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406496d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406493a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406493a);
        }
        if (!this.f406494b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406494b);
        }
        if (!this.f406495c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406495c);
        }
        boolean z16 = this.f406496d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406493a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406493a);
        }
        if (!this.f406494b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406494b);
        }
        if (!this.f406495c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406495c);
        }
        boolean z16 = this.f406496d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
