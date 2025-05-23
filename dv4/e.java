package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public j f395026a;

    /* renamed from: b, reason: collision with root package name */
    public int f395027b;

    /* renamed from: c, reason: collision with root package name */
    public String f395028c;

    /* renamed from: d, reason: collision with root package name */
    public String f395029d;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f395026a == null) {
                    this.f395026a = new j();
                }
                codedInputByteBufferNano.readMessage(this.f395026a);
            } else if (readTag == 16) {
                this.f395027b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f395028c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395029d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        j jVar = this.f395026a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        int i3 = this.f395027b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f395028c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395028c);
        }
        return !this.f395029d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f395029d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f395026a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        int i3 = this.f395027b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f395028c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395028c);
        }
        if (!this.f395029d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f395029d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f395026a = null;
        this.f395027b = 0;
        this.f395028c = "";
        this.f395029d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
