package lp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f415353a;

    /* renamed from: b, reason: collision with root package name */
    public String f415354b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f415355c;

    /* renamed from: d, reason: collision with root package name */
    public String f415356d;

    public a() {
        a();
    }

    public a a() {
        this.f415353a = "";
        this.f415354b = "";
        this.f415355c = WireFormatNano.EMPTY_BYTES;
        this.f415356d = "";
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
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f415356d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f415355c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f415354b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f415353a = codedInputByteBufferNano.readString();
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
        if (!this.f415353a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415353a);
        }
        if (!this.f415354b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415354b);
        }
        if (!Arrays.equals(this.f415355c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f415355c);
        }
        if (!this.f415356d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f415356d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415353a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415353a);
        }
        if (!this.f415354b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415354b);
        }
        if (!Arrays.equals(this.f415355c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f415355c);
        }
        if (!this.f415356d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f415356d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
