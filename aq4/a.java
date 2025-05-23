package aq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import np4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public c f26753a;

    /* renamed from: b, reason: collision with root package name */
    public String f26754b;

    /* renamed from: c, reason: collision with root package name */
    public String f26755c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f26756d;

    public a() {
        a();
    }

    public a a() {
        this.f26753a = null;
        this.f26754b = "";
        this.f26755c = "";
        this.f26756d = WireFormatNano.EMPTY_BYTES;
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
                                this.f26756d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f26755c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f26754b = codedInputByteBufferNano.readString();
                    }
                } else {
                    if (this.f26753a == null) {
                        this.f26753a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f26753a);
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
        c cVar = this.f26753a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        if (!this.f26754b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f26754b);
        }
        if (!this.f26755c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f26755c);
        }
        if (!Arrays.equals(this.f26756d, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.f26756d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f26753a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        if (!this.f26754b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f26754b);
        }
        if (!this.f26755c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f26755c);
        }
        if (!Arrays.equals(this.f26756d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f26756d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
