package ix4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f408941a;

    /* renamed from: b, reason: collision with root package name */
    public String f408942b;

    /* renamed from: c, reason: collision with root package name */
    public int f408943c;

    /* renamed from: d, reason: collision with root package name */
    public String f408944d;

    /* renamed from: e, reason: collision with root package name */
    public String f408945e;

    /* renamed from: f, reason: collision with root package name */
    public String f408946f;

    /* renamed from: g, reason: collision with root package name */
    public int f408947g;

    public h() {
        a();
    }

    public h a() {
        this.f408941a = "";
        this.f408942b = "";
        this.f408943c = 0;
        this.f408944d = "";
        this.f408945e = "";
        this.f408946f = "";
        this.f408947g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f408947g = codedInputByteBufferNano.readInt32();
                                        }
                                    } else {
                                        this.f408946f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f408945e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f408944d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f408943c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f408942b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408941a = codedInputByteBufferNano.readString();
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
        if (!this.f408941a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408941a);
        }
        if (!this.f408942b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408942b);
        }
        int i3 = this.f408943c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f408944d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f408944d);
        }
        if (!this.f408945e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408945e);
        }
        if (!this.f408946f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f408946f);
        }
        int i16 = this.f408947g;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408941a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408941a);
        }
        if (!this.f408942b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408942b);
        }
        int i3 = this.f408943c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f408944d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f408944d);
        }
        if (!this.f408945e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408945e);
        }
        if (!this.f408946f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f408946f);
        }
        int i16 = this.f408947g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
