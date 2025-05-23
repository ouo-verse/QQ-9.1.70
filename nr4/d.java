package nr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f421214a;

    /* renamed from: b, reason: collision with root package name */
    public String f421215b;

    /* renamed from: c, reason: collision with root package name */
    public e f421216c;

    /* renamed from: d, reason: collision with root package name */
    public b f421217d;

    /* renamed from: e, reason: collision with root package name */
    public String f421218e;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f421214a = 0;
        this.f421215b = "";
        this.f421216c = null;
        this.f421217d = null;
        this.f421218e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f421218e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                if (this.f421217d == null) {
                                    this.f421217d = new b();
                                }
                                codedInputByteBufferNano.readMessage(this.f421217d);
                            }
                        } else {
                            if (this.f421216c == null) {
                                this.f421216c = new e();
                            }
                            codedInputByteBufferNano.readMessage(this.f421216c);
                        }
                    } else {
                        this.f421215b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f421214a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f421214a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f421215b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421215b);
        }
        e eVar = this.f421216c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        b bVar = this.f421217d;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
        }
        if (!this.f421218e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f421218e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421214a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f421215b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421215b);
        }
        e eVar = this.f421216c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        b bVar = this.f421217d;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar);
        }
        if (!this.f421218e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f421218e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
