package ew4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f397307a;

    /* renamed from: b, reason: collision with root package name */
    public String f397308b;

    /* renamed from: c, reason: collision with root package name */
    public String f397309c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f397310d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f397311e;

    public a() {
        a();
    }

    public a a() {
        this.f397307a = "";
        this.f397308b = "";
        this.f397309c = "";
        this.f397310d = false;
        this.f397311e = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f397307a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f397308b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f397309c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f397310d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397311e = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f397307a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f397307a);
        }
        if (!this.f397308b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397308b);
        }
        if (!this.f397309c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f397309c);
        }
        boolean z16 = this.f397310d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        boolean z17 = this.f397311e;
        return z17 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f397307a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f397307a);
        }
        if (!this.f397308b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397308b);
        }
        if (!this.f397309c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397309c);
        }
        boolean z16 = this.f397310d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        boolean z17 = this.f397311e;
        if (z17) {
            codedOutputByteBufferNano.writeBool(5, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
