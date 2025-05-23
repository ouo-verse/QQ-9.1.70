package iv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f408810a;

    /* renamed from: b, reason: collision with root package name */
    public int f408811b;

    /* renamed from: c, reason: collision with root package name */
    public kv4.a f408812c;

    /* renamed from: d, reason: collision with root package name */
    public long f408813d;

    /* renamed from: e, reason: collision with root package name */
    public String f408814e;

    /* renamed from: f, reason: collision with root package name */
    public String f408815f;

    /* renamed from: g, reason: collision with root package name */
    public int f408816g;

    public b() {
        a();
    }

    public b a() {
        this.f408810a = "";
        this.f408811b = 0;
        this.f408812c = null;
        this.f408813d = 0L;
        this.f408814e = "";
        this.f408815f = "";
        this.f408816g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f408810a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f408811b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                if (this.f408812c == null) {
                    this.f408812c = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f408812c);
            } else if (readTag == 32) {
                this.f408813d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 42) {
                this.f408814e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f408815f = codedInputByteBufferNano.readString();
            } else if (readTag != 800) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408816g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f408810a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408810a);
        }
        int i3 = this.f408811b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        kv4.a aVar = this.f408812c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        long j3 = this.f408813d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.f408814e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408814e);
        }
        if (!this.f408815f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f408815f);
        }
        int i16 = this.f408816g;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(100, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408810a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408810a);
        }
        int i3 = this.f408811b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        kv4.a aVar = this.f408812c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        long j3 = this.f408813d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.f408814e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408814e);
        }
        if (!this.f408815f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f408815f);
        }
        int i16 = this.f408816g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(100, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
