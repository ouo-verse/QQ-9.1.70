package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile n[] f406473e;

    /* renamed from: a, reason: collision with root package name */
    public String f406474a;

    /* renamed from: b, reason: collision with root package name */
    public String f406475b;

    /* renamed from: c, reason: collision with root package name */
    public long f406476c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f406477d;

    public n() {
        a();
    }

    public static n[] b() {
        if (f406473e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406473e == null) {
                    f406473e = new n[0];
                }
            }
        }
        return f406473e;
    }

    public n a() {
        this.f406474a = "";
        this.f406475b = "";
        this.f406476c = 0L;
        this.f406477d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406474a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406475b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f406476c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406477d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406474a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406474a);
        }
        if (!this.f406475b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406475b);
        }
        long j3 = this.f406476c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        boolean z16 = this.f406477d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406474a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406474a);
        }
        if (!this.f406475b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406475b);
        }
        long j3 = this.f406476c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        boolean z16 = this.f406477d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
