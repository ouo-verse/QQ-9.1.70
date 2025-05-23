package hu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f406347c;

    /* renamed from: a, reason: collision with root package name */
    public int f406348a;

    /* renamed from: b, reason: collision with root package name */
    public String f406349b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f406347c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406347c == null) {
                    f406347c = new e[0];
                }
            }
        }
        return f406347c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406348a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406349b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406348a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        return !this.f406349b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406349b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406348a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f406349b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406349b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f406348a = 0;
        this.f406349b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
