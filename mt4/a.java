package mt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import fs4.o;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f417577e;

    /* renamed from: a, reason: collision with root package name */
    public String f417578a;

    /* renamed from: b, reason: collision with root package name */
    public o f417579b;

    /* renamed from: c, reason: collision with root package name */
    public int f417580c;

    /* renamed from: d, reason: collision with root package name */
    public String f417581d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f417577e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417577e == null) {
                    f417577e = new a[0];
                }
            }
        }
        return f417577e;
    }

    public a a() {
        this.f417578a = "";
        this.f417579b = null;
        this.f417580c = 0;
        this.f417581d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f417578a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f417579b == null) {
                    this.f417579b = new o();
                }
                codedInputByteBufferNano.readMessage(this.f417579b);
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f417580c = readInt32;
                }
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f417581d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f417578a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f417578a);
        }
        o oVar = this.f417579b;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, oVar);
        }
        int i3 = this.f417580c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return !this.f417581d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f417581d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f417578a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f417578a);
        }
        o oVar = this.f417579b;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(2, oVar);
        }
        int i3 = this.f417580c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f417581d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f417581d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
