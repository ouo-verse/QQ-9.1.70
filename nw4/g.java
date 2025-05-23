package nw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile g[] f421478c;

    /* renamed from: a, reason: collision with root package name */
    public int f421479a;

    /* renamed from: b, reason: collision with root package name */
    public String f421480b;

    public g() {
        a();
    }

    public static g[] b() {
        if (f421478c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421478c == null) {
                    f421478c = new g[0];
                }
            }
        }
        return f421478c;
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
                this.f421479a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f421480b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f421479a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f421480b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f421480b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421479a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f421480b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421480b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f421479a = 0;
        this.f421480b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
