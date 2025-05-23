package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile r[] f395052e;

    /* renamed from: a, reason: collision with root package name */
    public String f395053a;

    /* renamed from: b, reason: collision with root package name */
    public String f395054b;

    /* renamed from: c, reason: collision with root package name */
    public int f395055c;

    /* renamed from: d, reason: collision with root package name */
    public a f395056d;

    public r() {
        a();
    }

    public static r[] b() {
        if (f395052e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395052e == null) {
                    f395052e = new r[0];
                }
            }
        }
        return f395052e;
    }

    public r a() {
        this.f395053a = "";
        this.f395054b = "";
        this.f395055c = 0;
        this.f395056d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f395053a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f395054b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f395055c = readInt32;
                }
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f395056d == null) {
                    this.f395056d = new a();
                }
                codedInputByteBufferNano.readMessage(this.f395056d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f395053a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f395053a);
        }
        if (!this.f395054b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f395054b);
        }
        int i3 = this.f395055c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        a aVar = this.f395056d;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f395053a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f395053a);
        }
        if (!this.f395054b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f395054b);
        }
        int i3 = this.f395055c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        a aVar = this.f395056d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
