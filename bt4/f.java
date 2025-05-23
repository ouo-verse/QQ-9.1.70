package bt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import hs4.s;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile f[] f29115g;

    /* renamed from: a, reason: collision with root package name */
    public String f29116a;

    /* renamed from: b, reason: collision with root package name */
    public String f29117b;

    /* renamed from: c, reason: collision with root package name */
    public int f29118c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.l f29119d;

    /* renamed from: e, reason: collision with root package name */
    public int f29120e;

    /* renamed from: f, reason: collision with root package name */
    public s f29121f;

    public f() {
        a();
    }

    public static f[] b() {
        if (f29115g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29115g == null) {
                    f29115g = new f[0];
                }
            }
        }
        return f29115g;
    }

    public f a() {
        this.f29116a = "";
        this.f29117b = "";
        this.f29118c = 0;
        this.f29119d = null;
        this.f29120e = 0;
        this.f29121f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29116a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f29117b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f29118c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                if (this.f29119d == null) {
                    this.f29119d = new hs4.l();
                }
                codedInputByteBufferNano.readMessage(this.f29119d);
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f29120e = readInt32;
                }
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f29121f == null) {
                    this.f29121f = new s();
                }
                codedInputByteBufferNano.readMessage(this.f29121f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29116a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29116a);
        }
        if (!this.f29117b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29117b);
        }
        int i3 = this.f29118c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        hs4.l lVar = this.f29119d;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
        }
        int i16 = this.f29120e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        s sVar = this.f29121f;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29116a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29116a);
        }
        if (!this.f29117b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29117b);
        }
        int i3 = this.f29118c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        hs4.l lVar = this.f29119d;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(4, lVar);
        }
        int i16 = this.f29120e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        s sVar = this.f29121f;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(6, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
