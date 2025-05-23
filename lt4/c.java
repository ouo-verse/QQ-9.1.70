package lt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f415556a;

    /* renamed from: b, reason: collision with root package name */
    public String f415557b;

    /* renamed from: c, reason: collision with root package name */
    public String f415558c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.a f415559d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.a f415560e;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415556a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f415557b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f415558c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f415559d == null) {
                    this.f415559d = new hs4.a();
                }
                codedInputByteBufferNano.readMessage(this.f415559d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f415560e == null) {
                    this.f415560e = new hs4.a();
                }
                codedInputByteBufferNano.readMessage(this.f415560e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f415556a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f415557b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415557b);
        }
        if (!this.f415558c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f415558c);
        }
        hs4.a aVar = this.f415559d;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        hs4.a aVar2 = this.f415560e;
        return aVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, aVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415556a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f415557b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415557b);
        }
        if (!this.f415558c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f415558c);
        }
        hs4.a aVar = this.f415559d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        hs4.a aVar2 = this.f415560e;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f415556a = 0;
        this.f415557b = "";
        this.f415558c = "";
        this.f415559d = null;
        this.f415560e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
