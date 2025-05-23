package lt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f415552a;

    /* renamed from: b, reason: collision with root package name */
    public c f415553b;

    /* renamed from: c, reason: collision with root package name */
    public long f415554c;

    /* renamed from: d, reason: collision with root package name */
    public String f415555d;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415552a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f415553b == null) {
                    this.f415553b = new c();
                }
                codedInputByteBufferNano.readMessage(this.f415553b);
            } else if (readTag == 24) {
                this.f415554c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415555d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f415552a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        c cVar = this.f415553b;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
        }
        long j3 = this.f415554c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return !this.f415555d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f415555d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415552a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        c cVar = this.f415553b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar);
        }
        long j3 = this.f415554c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.f415555d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f415555d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f415552a = 0;
        this.f415553b = null;
        this.f415554c = 0L;
        this.f415555d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
