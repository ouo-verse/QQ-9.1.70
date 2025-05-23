package as4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f26878h;

    /* renamed from: a, reason: collision with root package name */
    public int f26879a;

    /* renamed from: b, reason: collision with root package name */
    public String f26880b;

    /* renamed from: c, reason: collision with root package name */
    public String f26881c;

    /* renamed from: d, reason: collision with root package name */
    public String f26882d;

    /* renamed from: e, reason: collision with root package name */
    public String f26883e;

    /* renamed from: f, reason: collision with root package name */
    public String f26884f;

    /* renamed from: g, reason: collision with root package name */
    public int f26885g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f26878h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f26878h == null) {
                    f26878h = new c[0];
                }
            }
        }
        return f26878h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.f26879a = readInt32;
            } else if (readTag == 18) {
                this.f26880b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f26881c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f26882d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f26883e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f26884f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f26885g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f26879a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f26880b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f26880b);
        }
        if (!this.f26881c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f26881c);
        }
        if (!this.f26882d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f26882d);
        }
        if (!this.f26883e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f26883e);
        }
        if (!this.f26884f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f26884f);
        }
        int i16 = this.f26885g;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f26879a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f26880b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f26880b);
        }
        if (!this.f26881c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f26881c);
        }
        if (!this.f26882d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f26882d);
        }
        if (!this.f26883e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f26883e);
        }
        if (!this.f26884f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f26884f);
        }
        int i16 = this.f26885g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f26879a = 0;
        this.f26880b = "";
        this.f26881c = "";
        this.f26882d = "";
        this.f26883e = "";
        this.f26884f = "";
        this.f26885g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
