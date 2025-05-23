package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public String f406184a;

    /* renamed from: b, reason: collision with root package name */
    public int f406185b;

    /* renamed from: c, reason: collision with root package name */
    public r f406186c;

    /* renamed from: d, reason: collision with root package name */
    public String f406187d;

    /* renamed from: e, reason: collision with root package name */
    public String f406188e;

    /* renamed from: f, reason: collision with root package name */
    public String f406189f;

    public q() {
        a();
    }

    public q a() {
        this.f406184a = "";
        this.f406185b = 0;
        this.f406186c = null;
        this.f406187d = "";
        this.f406188e = "";
        this.f406189f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406184a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f406185b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.f406186c == null) {
                    this.f406186c = new r();
                }
                codedInputByteBufferNano.readMessage(this.f406186c);
            } else if (readTag == 34) {
                this.f406187d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f406188e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406189f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406184a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406184a);
        }
        int i3 = this.f406185b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        r rVar = this.f406186c;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, rVar);
        }
        if (!this.f406187d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406187d);
        }
        if (!this.f406188e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406188e);
        }
        return !this.f406189f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f406189f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406184a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406184a);
        }
        int i3 = this.f406185b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        r rVar = this.f406186c;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(3, rVar);
        }
        if (!this.f406187d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406187d);
        }
        if (!this.f406188e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406188e);
        }
        if (!this.f406189f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406189f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
