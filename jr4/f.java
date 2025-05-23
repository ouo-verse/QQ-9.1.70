package jr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f410899a;

    /* renamed from: b, reason: collision with root package name */
    public long f410900b;

    /* renamed from: c, reason: collision with root package name */
    public e f410901c;

    /* renamed from: d, reason: collision with root package name */
    public String f410902d;

    /* renamed from: e, reason: collision with root package name */
    public String f410903e;

    public f() {
        a();
    }

    public f a() {
        this.f410899a = "";
        this.f410900b = 0L;
        this.f410901c = null;
        this.f410902d = "";
        this.f410903e = "";
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
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f410903e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f410902d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f410901c == null) {
                                this.f410901c = new e();
                            }
                            codedInputByteBufferNano.readMessage(this.f410901c);
                        }
                    } else {
                        this.f410900b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f410899a = codedInputByteBufferNano.readString();
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
        if (!this.f410899a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f410899a);
        }
        long j3 = this.f410900b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        e eVar = this.f410901c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        if (!this.f410902d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f410902d);
        }
        if (!this.f410903e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f410903e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f410899a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f410899a);
        }
        long j3 = this.f410900b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        e eVar = this.f410901c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        if (!this.f410902d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f410902d);
        }
        if (!this.f410903e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f410903e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
