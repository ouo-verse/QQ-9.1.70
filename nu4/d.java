package nu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f421351a;

    /* renamed from: b, reason: collision with root package name */
    public long f421352b;

    /* renamed from: c, reason: collision with root package name */
    public int f421353c;

    /* renamed from: d, reason: collision with root package name */
    public String f421354d;

    public d() {
        a();
    }

    public d a() {
        this.f421351a = "";
        this.f421352b = 0L;
        this.f421353c = 0;
        this.f421354d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f421351a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f421352b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f421353c = codedInputByteBufferNano.readInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f421354d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f421351a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421351a);
        }
        long j3 = this.f421352b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f421353c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return !this.f421354d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f421354d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421351a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421351a);
        }
        long j3 = this.f421352b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f421353c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f421354d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f421354d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
