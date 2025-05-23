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
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public c f26757a;

    /* renamed from: b, reason: collision with root package name */
    public int f26758b;

    /* renamed from: c, reason: collision with root package name */
    public String f26759c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f26760d;

    public b() {
        a();
    }

    public b a() {
        this.f26757a = null;
        this.f26758b = 0;
        this.f26759c = "";
        this.f26760d = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f26760d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f26759c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f26758b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    if (this.f26757a == null) {
                        this.f26757a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f26757a);
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
        c cVar = this.f26757a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        int i3 = this.f26758b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f26759c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f26759c);
        }
        if (!Arrays.equals(this.f26760d, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.f26760d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f26757a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        int i3 = this.f26758b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f26759c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f26759c);
        }
        if (!Arrays.equals(this.f26760d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f26760d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
