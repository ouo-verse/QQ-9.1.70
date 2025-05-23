package nr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f421227a;

    /* renamed from: b, reason: collision with root package name */
    public String f421228b;

    /* renamed from: c, reason: collision with root package name */
    public long f421229c;

    /* renamed from: d, reason: collision with root package name */
    public String f421230d;

    /* renamed from: e, reason: collision with root package name */
    public long f421231e;

    /* renamed from: f, reason: collision with root package name */
    public String f421232f;

    /* renamed from: g, reason: collision with root package name */
    public String f421233g;

    /* renamed from: h, reason: collision with root package name */
    public int f421234h;

    /* renamed from: i, reason: collision with root package name */
    public String f421235i;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f421227a = 0L;
        this.f421228b = "";
        this.f421229c = 0L;
        this.f421230d = "";
        this.f421231e = 0L;
        this.f421232f = "";
        this.f421233g = "";
        this.f421234h = 0;
        this.f421235i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                                    this.f421235i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f421234h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f421233g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f421232f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f421231e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f421230d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f421229c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f421228b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f421227a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f421227a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f421228b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421228b);
        }
        long j16 = this.f421229c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f421230d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f421230d);
        }
        long j17 = this.f421231e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        if (!this.f421232f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f421232f);
        }
        if (!this.f421233g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f421233g);
        }
        int i3 = this.f421234h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        if (!this.f421235i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f421235i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f421227a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f421228b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421228b);
        }
        long j16 = this.f421229c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f421230d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f421230d);
        }
        long j17 = this.f421231e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        if (!this.f421232f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f421232f);
        }
        if (!this.f421233g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f421233g);
        }
        int i3 = this.f421234h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        if (!this.f421235i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f421235i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
