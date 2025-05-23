package dr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f394715a;

    /* renamed from: b, reason: collision with root package name */
    public String f394716b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f394717c;

    /* renamed from: d, reason: collision with root package name */
    public int f394718d;

    /* renamed from: e, reason: collision with root package name */
    public int f394719e;

    /* renamed from: f, reason: collision with root package name */
    public int f394720f;

    /* renamed from: g, reason: collision with root package name */
    public String f394721g;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f394715a = 0;
        this.f394716b = "";
        this.f394717c = WireFormatNano.EMPTY_BYTES;
        this.f394718d = 0;
        this.f394719e = 0;
        this.f394720f = 0;
        this.f394721g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f394721g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f394720f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f394719e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f394718d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f394717c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f394716b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394715a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f394715a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f394716b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394716b);
        }
        if (!Arrays.equals(this.f394717c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f394717c);
        }
        int i16 = this.f394718d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f394719e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f394720f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!this.f394721g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f394721g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f394715a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f394716b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394716b);
        }
        if (!Arrays.equals(this.f394717c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f394717c);
        }
        int i16 = this.f394718d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f394719e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f394720f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f394721g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f394721g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
