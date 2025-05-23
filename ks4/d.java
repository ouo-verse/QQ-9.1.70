package ks4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d[] f412961e;

    /* renamed from: a, reason: collision with root package name */
    public int f412962a;

    /* renamed from: b, reason: collision with root package name */
    public int f412963b;

    /* renamed from: c, reason: collision with root package name */
    public c f412964c;

    /* renamed from: d, reason: collision with root package name */
    public String f412965d;

    public d() {
        a();
    }

    public static d[] b() {
        if (f412961e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412961e == null) {
                    f412961e = new d[0];
                }
            }
        }
        return f412961e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 99) {
                    this.f412962a = readInt32;
                }
            } else if (readTag == 16) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 99) {
                    this.f412963b = readInt322;
                }
            } else if (readTag == 26) {
                if (this.f412964c == null) {
                    this.f412964c = new c();
                }
                codedInputByteBufferNano.readMessage(this.f412964c);
            } else if (readTag != 794) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f412965d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f412962a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f412963b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        c cVar = this.f412964c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        return !this.f412965d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(99, this.f412965d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f412962a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f412963b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        c cVar = this.f412964c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        if (!this.f412965d.equals("")) {
            codedOutputByteBufferNano.writeString(99, this.f412965d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f412962a = 0;
        this.f412963b = 0;
        this.f412964c = null;
        this.f412965d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
