package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile j[] f423370e;

    /* renamed from: a, reason: collision with root package name */
    public String f423371a;

    /* renamed from: b, reason: collision with root package name */
    public String f423372b;

    /* renamed from: c, reason: collision with root package name */
    public String f423373c;

    /* renamed from: d, reason: collision with root package name */
    public String f423374d;

    public j() {
        a();
    }

    public static j[] b() {
        if (f423370e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423370e == null) {
                    f423370e = new j[0];
                }
            }
        }
        return f423370e;
    }

    public j a() {
        this.f423371a = "";
        this.f423372b = "";
        this.f423373c = "";
        this.f423374d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f423374d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f423373c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f423372b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f423371a = codedInputByteBufferNano.readString();
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
        if (!this.f423371a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423371a);
        }
        if (!this.f423372b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f423372b);
        }
        if (!this.f423373c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f423373c);
        }
        if (!this.f423374d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f423374d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423371a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423371a);
        }
        if (!this.f423372b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f423372b);
        }
        if (!this.f423373c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f423373c);
        }
        if (!this.f423374d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f423374d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
