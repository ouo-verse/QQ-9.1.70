package mt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import fs4.o;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile j[] f417588g;

    /* renamed from: a, reason: collision with root package name */
    public o f417589a;

    /* renamed from: b, reason: collision with root package name */
    public String f417590b;

    /* renamed from: c, reason: collision with root package name */
    public int f417591c;

    /* renamed from: d, reason: collision with root package name */
    public String f417592d;

    /* renamed from: e, reason: collision with root package name */
    public String f417593e;

    /* renamed from: f, reason: collision with root package name */
    public String f417594f;

    public j() {
        a();
    }

    public static j[] b() {
        if (f417588g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417588g == null) {
                    f417588g = new j[0];
                }
            }
        }
        return f417588g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f417589a == null) {
                    this.f417589a = new o();
                }
                codedInputByteBufferNano.readMessage(this.f417589a);
            } else if (readTag == 18) {
                this.f417590b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f417591c = readInt32;
                }
            } else if (readTag == 34) {
                this.f417592d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f417593e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f417594f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        o oVar = this.f417589a;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, oVar);
        }
        if (!this.f417590b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417590b);
        }
        int i3 = this.f417591c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f417592d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f417592d);
        }
        if (!this.f417593e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f417593e);
        }
        return !this.f417594f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f417594f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        o oVar = this.f417589a;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(1, oVar);
        }
        if (!this.f417590b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417590b);
        }
        int i3 = this.f417591c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f417592d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f417592d);
        }
        if (!this.f417593e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f417593e);
        }
        if (!this.f417594f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f417594f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f417589a = null;
        this.f417590b = "";
        this.f417591c = 0;
        this.f417592d = "";
        this.f417593e = "";
        this.f417594f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
