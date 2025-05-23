package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f427130a;

    /* renamed from: b, reason: collision with root package name */
    public long f427131b;

    /* renamed from: c, reason: collision with root package name */
    public g f427132c;

    /* renamed from: d, reason: collision with root package name */
    public int f427133d;

    /* renamed from: e, reason: collision with root package name */
    public int f427134e;

    /* renamed from: f, reason: collision with root package name */
    public int f427135f;

    public d() {
        a();
    }

    public d a() {
        this.f427130a = "";
        this.f427131b = 0L;
        this.f427132c = null;
        this.f427133d = 0;
        this.f427134e = 0;
        this.f427135f = 0;
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
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f427135f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f427134e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f427133d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            if (this.f427132c == null) {
                                this.f427132c = new g();
                            }
                            codedInputByteBufferNano.readMessage(this.f427132c);
                        }
                    } else {
                        this.f427131b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f427130a = codedInputByteBufferNano.readString();
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
        if (!this.f427130a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427130a);
        }
        long j3 = this.f427131b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        g gVar = this.f427132c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        int i3 = this.f427133d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f427134e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f427135f;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427130a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427130a);
        }
        long j3 = this.f427131b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        g gVar = this.f427132c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        int i3 = this.f427133d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f427134e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f427135f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
