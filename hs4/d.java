package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f406132c;

    /* renamed from: a, reason: collision with root package name */
    public String f406133a;

    /* renamed from: b, reason: collision with root package name */
    public String f406134b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f406132c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406132c == null) {
                    f406132c = new d[0];
                }
            }
        }
        return f406132c;
    }

    public d a() {
        this.f406133a = "";
        this.f406134b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406133a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406134b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406133a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406133a);
        }
        return !this.f406134b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406134b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406133a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406133a);
        }
        if (!this.f406134b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406134b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
