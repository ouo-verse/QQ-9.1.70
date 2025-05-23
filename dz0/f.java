package dz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f395260a;

    /* renamed from: b, reason: collision with root package name */
    public int f395261b;

    /* renamed from: c, reason: collision with root package name */
    public String f395262c;

    /* renamed from: d, reason: collision with root package name */
    public String f395263d;

    public f() {
        a();
    }

    public f a() {
        this.f395260a = "";
        this.f395261b = 0;
        this.f395262c = "";
        this.f395263d = "";
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
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f395263d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f395262c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f395261b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f395260a = codedInputByteBufferNano.readString();
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
        if (!this.f395260a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f395260a);
        }
        int i3 = this.f395261b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f395262c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395262c);
        }
        if (!this.f395263d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f395263d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395260a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395260a);
        }
        int i3 = this.f395261b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f395262c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395262c);
        }
        if (!this.f395263d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f395263d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
