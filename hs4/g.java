package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile g[] f406140e;

    /* renamed from: a, reason: collision with root package name */
    public int f406141a;

    /* renamed from: b, reason: collision with root package name */
    public long f406142b;

    /* renamed from: c, reason: collision with root package name */
    public String f406143c;

    /* renamed from: d, reason: collision with root package name */
    public String f406144d;

    public g() {
        a();
    }

    public static g[] b() {
        if (f406140e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406140e == null) {
                    f406140e = new g[0];
                }
            }
        }
        return f406140e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.f406141a = readInt32;
                        break;
                }
            } else if (readTag == 16) {
                this.f406142b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f406143c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406144d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406141a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f406142b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f406143c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406143c);
        }
        return !this.f406144d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f406144d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406141a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f406142b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f406143c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406143c);
        }
        if (!this.f406144d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406144d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f406141a = 0;
        this.f406142b = 0L;
        this.f406143c = "";
        this.f406144d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
