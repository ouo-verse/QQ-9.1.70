package ev4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f397201a;

    /* renamed from: b, reason: collision with root package name */
    public int f397202b;

    /* renamed from: c, reason: collision with root package name */
    public int f397203c;

    /* renamed from: d, reason: collision with root package name */
    public String f397204d;

    /* renamed from: e, reason: collision with root package name */
    public String f397205e;

    /* renamed from: f, reason: collision with root package name */
    public String f397206f;

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
                this.f397201a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f397202b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f397203c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f397204d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f397205e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397206f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f397201a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f397202b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f397203c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        if (!this.f397204d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f397204d);
        }
        if (!this.f397205e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f397205e);
        }
        return !this.f397206f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f397206f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f397201a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f397202b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f397203c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        if (!this.f397204d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f397204d);
        }
        if (!this.f397205e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f397205e);
        }
        if (!this.f397206f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f397206f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f397201a = 0;
        this.f397202b = 0;
        this.f397203c = 0;
        this.f397204d = "";
        this.f397205e = "";
        this.f397206f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
