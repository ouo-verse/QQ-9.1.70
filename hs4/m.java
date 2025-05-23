package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile m[] f406168d;

    /* renamed from: a, reason: collision with root package name */
    public String f406169a;

    /* renamed from: b, reason: collision with root package name */
    public String f406170b;

    /* renamed from: c, reason: collision with root package name */
    public int f406171c;

    public m() {
        a();
    }

    public static m[] b() {
        if (f406168d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406168d == null) {
                    f406168d = new m[0];
                }
            }
        }
        return f406168d;
    }

    public m a() {
        this.f406169a = "";
        this.f406170b = "";
        this.f406171c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406169a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f406170b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f406171c = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406169a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406169a);
        }
        if (!this.f406170b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406170b);
        }
        int i3 = this.f406171c;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406169a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406169a);
        }
        if (!this.f406170b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406170b);
        }
        int i3 = this.f406171c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
