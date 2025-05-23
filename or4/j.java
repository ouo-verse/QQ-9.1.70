package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f423498a;

    /* renamed from: b, reason: collision with root package name */
    public l f423499b;

    /* renamed from: c, reason: collision with root package name */
    public b f423500c;

    /* renamed from: d, reason: collision with root package name */
    public int f423501d;

    /* renamed from: e, reason: collision with root package name */
    public int f423502e;

    public j() {
        a();
    }

    public j a() {
        this.f423498a = 0;
        this.f423499b = null;
        this.f423500c = null;
        this.f423501d = 0;
        this.f423502e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f423502e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f423501d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f423500c == null) {
                                this.f423500c = new b();
                            }
                            codedInputByteBufferNano.readMessage(this.f423500c);
                        }
                    } else {
                        if (this.f423499b == null) {
                            this.f423499b = new l();
                        }
                        codedInputByteBufferNano.readMessage(this.f423499b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1) {
                        this.f423498a = readInt32;
                    }
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
        int i3 = this.f423498a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        l lVar = this.f423499b;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
        }
        b bVar = this.f423500c;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
        }
        int i16 = this.f423501d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f423502e;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f423498a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        l lVar = this.f423499b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        b bVar = this.f423500c;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(3, bVar);
        }
        int i16 = this.f423501d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f423502e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
