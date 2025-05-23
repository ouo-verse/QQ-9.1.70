package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public r f395043a;

    /* renamed from: b, reason: collision with root package name */
    public String f395044b;

    /* renamed from: c, reason: collision with root package name */
    public String f395045c;

    /* renamed from: d, reason: collision with root package name */
    public int f395046d;

    public o() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f395043a == null) {
                    this.f395043a = new r();
                }
                codedInputByteBufferNano.readMessage(this.f395043a);
            } else if (readTag == 18) {
                this.f395044b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f395045c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395046d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        r rVar = this.f395043a;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
        }
        if (!this.f395044b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f395044b);
        }
        if (!this.f395045c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395045c);
        }
        int i3 = this.f395046d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r rVar = this.f395043a;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(1, rVar);
        }
        if (!this.f395044b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f395044b);
        }
        if (!this.f395045c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395045c);
        }
        int i3 = this.f395046d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f395043a = null;
        this.f395044b = "";
        this.f395045c = "";
        this.f395046d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
