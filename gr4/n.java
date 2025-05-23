package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public int f403150a;

    /* renamed from: b, reason: collision with root package name */
    public String f403151b;

    /* renamed from: c, reason: collision with root package name */
    public int f403152c;

    /* renamed from: d, reason: collision with root package name */
    public int f403153d;

    /* renamed from: e, reason: collision with root package name */
    public int f403154e;

    /* renamed from: f, reason: collision with root package name */
    public int f403155f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f403156g;

    public n() {
        a();
    }

    public n a() {
        this.f403150a = 0;
        this.f403151b = "";
        this.f403152c = 0;
        this.f403153d = 0;
        this.f403154e = 0;
        this.f403155f = 0;
        this.f403156g = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f403156g = codedInputByteBufferNano.readBytes();
                                        }
                                    } else {
                                        this.f403155f = codedInputByteBufferNano.readInt32();
                                    }
                                } else {
                                    this.f403151b = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f403154e = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f403153d = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f403152c = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f403150a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403150a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f403152c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f403153d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f403154e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        if (!this.f403151b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403151b);
        }
        int i19 = this.f403155f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i19);
        }
        if (!Arrays.equals(this.f403156g, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(7, this.f403156g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403150a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f403152c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f403153d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f403154e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        if (!this.f403151b.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403151b);
        }
        int i19 = this.f403155f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i19);
        }
        if (!Arrays.equals(this.f403156g, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(7, this.f403156g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
