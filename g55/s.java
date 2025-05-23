package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public String f401386a;

    /* renamed from: b, reason: collision with root package name */
    public g f401387b;

    /* renamed from: c, reason: collision with root package name */
    public g f401388c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f401389d;

    /* renamed from: e, reason: collision with root package name */
    public String f401390e;

    public s() {
        a();
    }

    public static s c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (s) MessageNano.mergeFrom(new s(), bArr);
    }

    public s a() {
        this.f401386a = "";
        this.f401387b = null;
        this.f401388c = null;
        this.f401389d = false;
        this.f401390e = "";
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
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f401390e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f401389d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            if (this.f401388c == null) {
                                this.f401388c = new g();
                            }
                            codedInputByteBufferNano.readMessage(this.f401388c);
                        }
                    } else {
                        if (this.f401387b == null) {
                            this.f401387b = new g();
                        }
                        codedInputByteBufferNano.readMessage(this.f401387b);
                    }
                } else {
                    this.f401386a = codedInputByteBufferNano.readString();
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
        if (!this.f401386a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401386a);
        }
        g gVar = this.f401387b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        g gVar2 = this.f401388c;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar2);
        }
        boolean z16 = this.f401389d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        if (!this.f401390e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f401390e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401386a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401386a);
        }
        g gVar = this.f401387b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        g gVar2 = this.f401388c;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar2);
        }
        boolean z16 = this.f401389d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        if (!this.f401390e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f401390e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
