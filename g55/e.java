package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public e55.c f401358a;

    /* renamed from: b, reason: collision with root package name */
    public long f401359b;

    /* renamed from: c, reason: collision with root package name */
    public int f401360c;

    /* renamed from: d, reason: collision with root package name */
    public String f401361d;

    /* renamed from: e, reason: collision with root package name */
    public String f401362e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f401363f;

    public e() {
        a();
    }

    public e a() {
        this.f401358a = null;
        this.f401359b = 0L;
        this.f401360c = 0;
        this.f401361d = "";
        this.f401362e = "";
        this.f401363f = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f401363f = codedInputByteBufferNano.readBool();
                                    }
                                } else {
                                    this.f401362e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f401361d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f401360c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f401359b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    if (this.f401358a == null) {
                        this.f401358a = new e55.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f401358a);
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
        e55.c cVar = this.f401358a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        long j3 = this.f401359b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f401360c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f401361d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f401361d);
        }
        if (!this.f401362e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f401362e);
        }
        boolean z16 = this.f401363f;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e55.c cVar = this.f401358a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        long j3 = this.f401359b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f401360c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f401361d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f401361d);
        }
        if (!this.f401362e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f401362e);
        }
        boolean z16 = this.f401363f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
