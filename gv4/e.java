package gv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile e[] f403424g;

    /* renamed from: a, reason: collision with root package name */
    public int f403425a;

    /* renamed from: b, reason: collision with root package name */
    public int f403426b;

    /* renamed from: c, reason: collision with root package name */
    public int f403427c;

    /* renamed from: d, reason: collision with root package name */
    public String f403428d;

    /* renamed from: e, reason: collision with root package name */
    public String f403429e;

    /* renamed from: f, reason: collision with root package name */
    public f f403430f;

    public e() {
        a();
    }

    public static e[] b() {
        if (f403424g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403424g == null) {
                    f403424g = new e[0];
                }
            }
        }
        return f403424g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403425a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f403426b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f403427c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f403428d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f403429e = codedInputByteBufferNano.readString();
            } else if (readTag != 802) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403430f == null) {
                    this.f403430f = new f();
                }
                codedInputByteBufferNano.readMessage(this.f403430f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f403425a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f403426b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f403427c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        if (!this.f403428d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403428d);
        }
        if (!this.f403429e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403429e);
        }
        f fVar = this.f403430f;
        return fVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(100, fVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403425a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f403426b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f403427c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        if (!this.f403428d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403428d);
        }
        if (!this.f403429e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403429e);
        }
        f fVar = this.f403430f;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(100, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f403425a = 0;
        this.f403426b = 0;
        this.f403427c = 0;
        this.f403428d = "";
        this.f403429e = "";
        this.f403430f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
