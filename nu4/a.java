package nu4;

import com.google.gson.annotations.SerializedName;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a[] f421347a;

    /* renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public int f421348id;

    @SerializedName("sortWeight")
    public int sortWeight;

    @SerializedName("url")
    public String url;

    public a() {
        a();
    }

    public static a[] b() {
        if (f421347a == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421347a == null) {
                    f421347a = new a[0];
                }
            }
        }
        return f421347a;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f421348id = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.sortWeight = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f421348id;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
        }
        int i16 = this.sortWeight;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421348id;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.url);
        }
        int i16 = this.sortWeight;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f421348id = 0;
        this.url = "";
        this.sortWeight = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
