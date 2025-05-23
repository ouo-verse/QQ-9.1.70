package cv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;
import uu4.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile e[] f391927e;

    /* renamed from: a, reason: collision with root package name */
    public String f391928a;

    /* renamed from: b, reason: collision with root package name */
    public int f391929b;

    /* renamed from: c, reason: collision with root package name */
    public g f391930c;

    /* renamed from: d, reason: collision with root package name */
    public int f391931d;

    public e() {
        a();
    }

    public static e[] b() {
        if (f391927e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391927e == null) {
                    f391927e = new e[0];
                }
            }
        }
        return f391927e;
    }

    public e a() {
        this.f391928a = "";
        this.f391929b = 0;
        this.f391930c = null;
        this.f391931d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f391928a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f391929b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                if (this.f391930c == null) {
                    this.f391930c = new g();
                }
                codedInputByteBufferNano.readMessage(this.f391930c);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f391931d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f391928a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f391928a);
        }
        int i3 = this.f391929b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        g gVar = this.f391930c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        int i16 = this.f391931d;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f391928a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f391928a);
        }
        int i3 = this.f391929b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        g gVar = this.f391930c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        int i16 = this.f391931d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
