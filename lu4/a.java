package lu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f415575d;

    /* renamed from: a, reason: collision with root package name */
    public String f415576a;

    /* renamed from: b, reason: collision with root package name */
    public int f415577b;

    /* renamed from: c, reason: collision with root package name */
    public int f415578c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f415575d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f415575d == null) {
                    f415575d = new a[0];
                }
            }
        }
        return f415575d;
    }

    public a a() {
        this.f415576a = "";
        this.f415577b = 0;
        this.f415578c = 0;
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
                this.f415576a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f415577b = readInt32;
                }
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f415578c = readInt322;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f415576a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415576a);
        }
        int i3 = this.f415577b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f415578c;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415576a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415576a);
        }
        int i3 = this.f415577b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f415578c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
