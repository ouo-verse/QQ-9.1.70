package com.tencent.mobileqq.dt.tip;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f203885a;

    /* renamed from: b, reason: collision with root package name */
    public String f203886b;

    /* renamed from: c, reason: collision with root package name */
    public String f203887c;

    public b() {
        a();
    }

    public b a() {
        this.f203885a = "";
        this.f203886b = "";
        this.f203887c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f203887c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f203886b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f203885a = codedInputByteBufferNano.readString();
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
        if (!this.f203885a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f203885a);
        }
        if (!this.f203886b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f203886b);
        }
        if (!this.f203887c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f203887c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f203885a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f203885a);
        }
        if (!this.f203886b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f203886b);
        }
        if (!this.f203887c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f203887c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
