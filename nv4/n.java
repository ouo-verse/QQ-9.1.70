package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile n[] f421436d;

    /* renamed from: a, reason: collision with root package name */
    public String f421437a;

    /* renamed from: b, reason: collision with root package name */
    public int f421438b;

    /* renamed from: c, reason: collision with root package name */
    public mv4.j f421439c;

    public n() {
        a();
    }

    public static n[] b() {
        if (f421436d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421436d == null) {
                    f421436d = new n[0];
                }
            }
        }
        return f421436d;
    }

    public n a() {
        this.f421437a = "";
        this.f421438b = 0;
        this.f421439c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f421437a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f421438b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f421439c == null) {
                    this.f421439c = new mv4.j();
                }
                codedInputByteBufferNano.readMessage(this.f421439c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f421437a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421437a);
        }
        int i3 = this.f421438b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        mv4.j jVar = this.f421439c;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421437a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421437a);
        }
        int i3 = this.f421438b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        mv4.j jVar = this.f421439c;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(3, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
