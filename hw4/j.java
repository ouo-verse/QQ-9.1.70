package hw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j[] f406524d;

    /* renamed from: a, reason: collision with root package name */
    public long f406525a;

    /* renamed from: b, reason: collision with root package name */
    public String f406526b;

    /* renamed from: c, reason: collision with root package name */
    public String f406527c;

    public j() {
        a();
    }

    public static j[] b() {
        if (f406524d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406524d == null) {
                    f406524d = new j[0];
                }
            }
        }
        return f406524d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406525a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f406526b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406527c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f406525a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f406526b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406526b);
        }
        return !this.f406527c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f406527c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406525a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f406526b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406526b);
        }
        if (!this.f406527c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406527c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f406525a = 0L;
        this.f406526b = "";
        this.f406527c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
