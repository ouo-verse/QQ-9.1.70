package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aa extends ExtendableMessageNano<aa> {

    /* renamed from: a, reason: collision with root package name */
    public e55.c f401281a;

    /* renamed from: b, reason: collision with root package name */
    public String f401282b;

    /* renamed from: c, reason: collision with root package name */
    public String f401283c;

    /* renamed from: d, reason: collision with root package name */
    public long f401284d;

    /* renamed from: e, reason: collision with root package name */
    public long f401285e;

    /* renamed from: f, reason: collision with root package name */
    public String f401286f;

    /* renamed from: g, reason: collision with root package name */
    public int f401287g;

    /* renamed from: h, reason: collision with root package name */
    public int f401288h;

    public aa() {
        a();
    }

    public aa a() {
        this.f401281a = null;
        this.f401282b = "";
        this.f401283c = "";
        this.f401284d = 0L;
        this.f401285e = 0L;
        this.f401286f = "";
        this.f401287g = 0;
        this.f401288h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f401288h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f401287g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f401286f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f401285e = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                this.f401284d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            this.f401283c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f401282b = codedInputByteBufferNano.readString();
                    }
                } else {
                    if (this.f401281a == null) {
                        this.f401281a = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401281a);
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
        e55.c cVar = this.f401281a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        if (!this.f401282b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f401282b);
        }
        if (!this.f401283c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f401283c);
        }
        long j3 = this.f401284d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j3);
        }
        long j16 = this.f401285e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        if (!this.f401286f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f401286f);
        }
        int i3 = this.f401287g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i16 = this.f401288h;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e55.c cVar = this.f401281a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        if (!this.f401282b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f401282b);
        }
        if (!this.f401283c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f401283c);
        }
        long j3 = this.f401284d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        long j16 = this.f401285e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        if (!this.f401286f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f401286f);
        }
        int i3 = this.f401287g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i16 = this.f401288h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
