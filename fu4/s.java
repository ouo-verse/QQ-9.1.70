package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public long f400803a;

    /* renamed from: b, reason: collision with root package name */
    public String f400804b;

    /* renamed from: c, reason: collision with root package name */
    public String f400805c;

    /* renamed from: d, reason: collision with root package name */
    public String f400806d;

    /* renamed from: e, reason: collision with root package name */
    public t f400807e;

    /* renamed from: f, reason: collision with root package name */
    public int f400808f;

    /* renamed from: g, reason: collision with root package name */
    public int f400809g;

    /* renamed from: h, reason: collision with root package name */
    public int f400810h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f400811i;

    public s() {
        a();
    }

    public s a() {
        this.f400803a = 0L;
        this.f400804b = "";
        this.f400805c = "";
        this.f400806d = "";
        this.f400807e = null;
        this.f400808f = 0;
        this.f400809g = 0;
        this.f400810h = 0;
        this.f400811i = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (readTag != 72) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f400811i = codedInputByteBufferNano.readBool();
                                                }
                                            } else {
                                                this.f400810h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f400809g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f400808f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    if (this.f400807e == null) {
                                        this.f400807e = new t();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f400807e);
                                }
                            } else {
                                this.f400806d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f400805c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f400804b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f400803a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f400803a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f400804b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400804b);
        }
        if (!this.f400805c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400805c);
        }
        if (!this.f400806d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f400806d);
        }
        t tVar = this.f400807e;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, tVar);
        }
        int i3 = this.f400808f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        int i16 = this.f400809g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f400810h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        boolean z16 = this.f400811i;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400803a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f400804b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400804b);
        }
        if (!this.f400805c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400805c);
        }
        if (!this.f400806d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f400806d);
        }
        t tVar = this.f400807e;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(5, tVar);
        }
        int i3 = this.f400808f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        int i16 = this.f400809g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f400810h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        boolean z16 = this.f400811i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
