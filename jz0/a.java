package jz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f411232a;

    /* renamed from: b, reason: collision with root package name */
    public String f411233b;

    /* renamed from: c, reason: collision with root package name */
    public long f411234c;

    /* renamed from: d, reason: collision with root package name */
    public String f411235d;

    /* renamed from: e, reason: collision with root package name */
    public long f411236e;

    /* renamed from: f, reason: collision with root package name */
    public String f411237f;

    /* renamed from: g, reason: collision with root package name */
    public String f411238g;

    /* renamed from: h, reason: collision with root package name */
    public int f411239h;

    /* renamed from: i, reason: collision with root package name */
    public String f411240i;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f411232a = 0L;
        this.f411233b = "";
        this.f411234c = 0L;
        this.f411235d = "";
        this.f411236e = 0L;
        this.f411237f = "";
        this.f411238g = "";
        this.f411239h = 0;
        this.f411240i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 64) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f411240i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f411239h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f411238g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f411237f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f411236e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f411235d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f411234c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f411233b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f411232a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f411232a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f411233b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f411233b);
        }
        long j16 = this.f411234c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f411235d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f411235d);
        }
        long j17 = this.f411236e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        if (!this.f411237f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f411237f);
        }
        if (!this.f411238g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f411238g);
        }
        int i3 = this.f411239h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        if (!this.f411240i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f411240i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f411232a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f411233b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f411233b);
        }
        long j16 = this.f411234c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f411235d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f411235d);
        }
        long j17 = this.f411236e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        if (!this.f411237f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f411237f);
        }
        if (!this.f411238g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f411238g);
        }
        int i3 = this.f411239h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        if (!this.f411240i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f411240i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
