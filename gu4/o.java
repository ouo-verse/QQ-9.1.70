package gu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f403408a;

    /* renamed from: b, reason: collision with root package name */
    public String f403409b;

    /* renamed from: c, reason: collision with root package name */
    public e f403410c;

    public o() {
        a();
    }

    public static o c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (o) MessageNano.mergeFrom(new o(), bArr);
    }

    public o a() {
        this.f403408a = 0;
        this.f403409b = "";
        this.f403410c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            if (this.f403410c == null) {
                                this.f403410c = new e();
                            }
                            codedInputByteBufferNano.readMessage(this.f403410c);
                        }
                    } else {
                        this.f403409b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403408a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403408a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f403409b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403409b);
        }
        e eVar = this.f403410c;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403408a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f403409b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403409b);
        }
        e eVar = this.f403410c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
