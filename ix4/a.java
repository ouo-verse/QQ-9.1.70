package ix4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f408922a;

    /* renamed from: b, reason: collision with root package name */
    public String f408923b;

    /* renamed from: c, reason: collision with root package name */
    public String f408924c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f408925d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f408926e;

    public a() {
        a();
    }

    public a a() {
        this.f408922a = "";
        this.f408923b = "";
        this.f408924c = "";
        this.f408925d = false;
        this.f408926e = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f408926e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f408925d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f408924c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f408923b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408922a = codedInputByteBufferNano.readString();
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
        if (!this.f408922a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408922a);
        }
        if (!this.f408923b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408923b);
        }
        if (!this.f408924c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f408924c);
        }
        boolean z16 = this.f408925d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        boolean z17 = this.f408926e;
        if (z17) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408922a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408922a);
        }
        if (!this.f408923b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408923b);
        }
        if (!this.f408924c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f408924c);
        }
        boolean z16 = this.f408925d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        boolean z17 = this.f408926e;
        if (z17) {
            codedOutputByteBufferNano.writeBool(5, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
