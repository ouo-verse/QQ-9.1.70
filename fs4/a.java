package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f400495a;

    /* renamed from: b, reason: collision with root package name */
    public int f400496b;

    /* renamed from: c, reason: collision with root package name */
    public int f400497c;

    /* renamed from: d, reason: collision with root package name */
    public int f400498d;

    /* renamed from: e, reason: collision with root package name */
    public String f400499e;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400495a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f400496b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f400497c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f400498d = codedInputByteBufferNano.readInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400499e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f400495a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f400496b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f400497c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f400498d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        return !this.f400499e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f400499e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400495a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f400496b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f400497c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f400498d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        if (!this.f400499e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400499e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f400495a = 0;
        this.f400496b = 0;
        this.f400497c = 0;
        this.f400498d = 0;
        this.f400499e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
