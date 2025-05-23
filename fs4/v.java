package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public int f400594a;

    /* renamed from: b, reason: collision with root package name */
    public int f400595b;

    /* renamed from: c, reason: collision with root package name */
    public int f400596c;

    /* renamed from: d, reason: collision with root package name */
    public int f400597d;

    /* renamed from: e, reason: collision with root package name */
    public String f400598e;

    public v() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400594a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f400595b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f400596c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f400597d = codedInputByteBufferNano.readInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400598e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f400594a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f400595b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f400596c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f400597d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        return !this.f400598e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f400598e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400594a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f400595b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f400596c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f400597d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        if (!this.f400598e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400598e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public v a() {
        this.f400594a = 0;
        this.f400595b = 0;
        this.f400596c = 0;
        this.f400597d = 0;
        this.f400598e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
