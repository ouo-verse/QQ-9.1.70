package gw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile f[] f403469f;

    /* renamed from: a, reason: collision with root package name */
    public int f403470a;

    /* renamed from: b, reason: collision with root package name */
    public int f403471b;

    /* renamed from: c, reason: collision with root package name */
    public String f403472c;

    /* renamed from: d, reason: collision with root package name */
    public int f403473d;

    /* renamed from: e, reason: collision with root package name */
    public h f403474e;

    public f() {
        a();
    }

    public static f[] b() {
        if (f403469f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403469f == null) {
                    f403469f = new f[0];
                }
            }
        }
        return f403469f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403470a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f403471b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f403472c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f403473d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403474e == null) {
                    this.f403474e = new h();
                }
                codedInputByteBufferNano.readMessage(this.f403474e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f403470a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f403471b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f403472c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403472c);
        }
        int i17 = this.f403473d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        h hVar = this.f403474e;
        return hVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, hVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403470a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f403471b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f403472c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403472c);
        }
        int i17 = this.f403473d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        h hVar = this.f403474e;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(5, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f403470a = 0;
        this.f403471b = 0;
        this.f403472c = "";
        this.f403473d = 0;
        this.f403474e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
