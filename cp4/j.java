package cp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public String f391611a;

    /* renamed from: b, reason: collision with root package name */
    public String f391612b;

    /* renamed from: c, reason: collision with root package name */
    public c f391613c;

    /* renamed from: d, reason: collision with root package name */
    public String f391614d;

    public j() {
        a();
    }

    public j a() {
        this.f391611a = "";
        this.f391612b = "";
        this.f391613c = null;
        this.f391614d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                this.f391614d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f391613c == null) {
                                this.f391613c = new c();
                            }
                            codedInputByteBufferNano.readMessage(this.f391613c);
                        }
                    } else {
                        this.f391612b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f391611a = codedInputByteBufferNano.readString();
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
        if (!this.f391611a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f391611a);
        }
        if (!this.f391612b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391612b);
        }
        c cVar = this.f391613c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        if (!this.f391614d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f391614d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f391611a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f391611a);
        }
        if (!this.f391612b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391612b);
        }
        c cVar = this.f391613c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        if (!this.f391614d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391614d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
