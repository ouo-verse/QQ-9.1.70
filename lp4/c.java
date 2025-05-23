package lp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f415359a;

    /* renamed from: b, reason: collision with root package name */
    public e f415360b;

    /* renamed from: c, reason: collision with root package name */
    public i f415361c;

    public c() {
        a();
    }

    public c a() {
        this.f415359a = 0;
        this.f415360b = null;
        this.f415361c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f415361c == null) {
                                this.f415361c = new i();
                            }
                            codedInputByteBufferNano.readMessage(this.f415361c);
                        }
                    } else {
                        if (this.f415360b == null) {
                            this.f415360b = new e();
                        }
                        codedInputByteBufferNano.readMessage(this.f415360b);
                    }
                } else {
                    this.f415359a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f415359a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        e eVar = this.f415360b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        i iVar = this.f415361c;
        if (iVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415359a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        e eVar = this.f415360b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        i iVar = this.f415361c;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
