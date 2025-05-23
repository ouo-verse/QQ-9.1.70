package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile g[] f406419i;

    /* renamed from: a, reason: collision with root package name */
    public String f406420a;

    /* renamed from: b, reason: collision with root package name */
    public String f406421b;

    /* renamed from: c, reason: collision with root package name */
    public String f406422c;

    /* renamed from: d, reason: collision with root package name */
    public String f406423d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f406424e;

    /* renamed from: f, reason: collision with root package name */
    public String f406425f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f406426g;

    /* renamed from: h, reason: collision with root package name */
    public String f406427h;

    public g() {
        a();
    }

    public static g[] b() {
        if (f406419i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406419i == null) {
                    f406419i = new g[0];
                }
            }
        }
        return f406419i;
    }

    public g a() {
        this.f406420a = "";
        this.f406421b = "";
        this.f406422c = "";
        this.f406423d = "";
        this.f406424e = false;
        this.f406425f = "";
        this.f406426g = false;
        this.f406427h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406420a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406421b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f406422c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f406423d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f406424e = codedInputByteBufferNano.readBool();
            } else if (readTag == 50) {
                this.f406425f = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.f406426g = codedInputByteBufferNano.readBool();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406427h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406420a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406420a);
        }
        if (!this.f406421b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406421b);
        }
        if (!this.f406422c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406422c);
        }
        if (!this.f406423d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406423d);
        }
        boolean z16 = this.f406424e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        if (!this.f406425f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f406425f);
        }
        boolean z17 = this.f406426g;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z17);
        }
        return !this.f406427h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f406427h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406420a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406420a);
        }
        if (!this.f406421b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406421b);
        }
        if (!this.f406422c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406422c);
        }
        if (!this.f406423d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406423d);
        }
        boolean z16 = this.f406424e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        if (!this.f406425f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406425f);
        }
        boolean z17 = this.f406426g;
        if (z17) {
            codedOutputByteBufferNano.writeBool(7, z17);
        }
        if (!this.f406427h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f406427h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
