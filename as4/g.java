package as4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f26898a;

    /* renamed from: b, reason: collision with root package name */
    public String f26899b;

    /* renamed from: c, reason: collision with root package name */
    public String f26900c;

    /* renamed from: d, reason: collision with root package name */
    public String f26901d;

    /* renamed from: e, reason: collision with root package name */
    public String f26902e;

    /* renamed from: f, reason: collision with root package name */
    public String f26903f;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f26898a = readInt32;
            } else if (readTag == 18) {
                this.f26899b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f26900c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f26901d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f26902e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f26903f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f26898a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f26899b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f26899b);
        }
        if (!this.f26900c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f26900c);
        }
        if (!this.f26901d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f26901d);
        }
        if (!this.f26902e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f26902e);
        }
        return !this.f26903f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f26903f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f26898a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f26899b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f26899b);
        }
        if (!this.f26900c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f26900c);
        }
        if (!this.f26901d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f26901d);
        }
        if (!this.f26902e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f26902e);
        }
        if (!this.f26903f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f26903f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f26898a = 0;
        this.f26899b = "";
        this.f26900c = "";
        this.f26901d = "";
        this.f26902e = "";
        this.f26903f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
