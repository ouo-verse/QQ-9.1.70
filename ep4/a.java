package ep4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a[] f396935g;

    /* renamed from: a, reason: collision with root package name */
    public String f396936a;

    /* renamed from: b, reason: collision with root package name */
    public String f396937b;

    /* renamed from: c, reason: collision with root package name */
    public String f396938c;

    /* renamed from: d, reason: collision with root package name */
    public float f396939d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f396940e;

    /* renamed from: f, reason: collision with root package name */
    public int f396941f;

    public a() {
        a();
    }

    public static a[] b() {
        if (f396935g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f396935g == null) {
                    f396935g = new a[0];
                }
            }
        }
        return f396935g;
    }

    public a a() {
        this.f396936a = "";
        this.f396937b = "";
        this.f396938c = "";
        this.f396939d = 0.0f;
        this.f396940e = false;
        this.f396941f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 37) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f396941f = codedInputByteBufferNano.readInt32();
                                    }
                                } else {
                                    this.f396940e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f396939d = codedInputByteBufferNano.readFloat();
                            }
                        } else {
                            this.f396938c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f396937b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f396936a = codedInputByteBufferNano.readString();
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
        if (!this.f396936a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f396936a);
        }
        if (!this.f396937b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f396937b);
        }
        if (!this.f396938c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f396938c);
        }
        if (Float.floatToIntBits(this.f396939d) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.f396939d);
        }
        boolean z16 = this.f396940e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        int i3 = this.f396941f;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f396936a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f396936a);
        }
        if (!this.f396937b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f396937b);
        }
        if (!this.f396938c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f396938c);
        }
        if (Float.floatToIntBits(this.f396939d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f396939d);
        }
        boolean z16 = this.f396940e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        int i3 = this.f396941f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
