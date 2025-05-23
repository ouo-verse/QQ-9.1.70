package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile s[] f406200i;

    /* renamed from: a, reason: collision with root package name */
    public int f406201a;

    /* renamed from: b, reason: collision with root package name */
    public e f406202b;

    /* renamed from: c, reason: collision with root package name */
    public l f406203c;

    /* renamed from: d, reason: collision with root package name */
    public a f406204d;

    /* renamed from: e, reason: collision with root package name */
    public int f406205e;

    /* renamed from: f, reason: collision with root package name */
    public o f406206f;

    /* renamed from: g, reason: collision with root package name */
    public u f406207g;

    /* renamed from: h, reason: collision with root package name */
    public c f406208h;

    public s() {
        a();
    }

    public static s[] b() {
        if (f406200i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406200i == null) {
                    f406200i = new s[0];
                }
            }
        }
        return f406200i;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406201a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f406202b == null) {
                    this.f406202b = new e();
                }
                codedInputByteBufferNano.readMessage(this.f406202b);
            } else if (readTag == 26) {
                if (this.f406203c == null) {
                    this.f406203c = new l();
                }
                codedInputByteBufferNano.readMessage(this.f406203c);
            } else if (readTag == 34) {
                if (this.f406204d == null) {
                    this.f406204d = new a();
                }
                codedInputByteBufferNano.readMessage(this.f406204d);
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f406205e = readInt32;
                }
            } else if (readTag == 50) {
                if (this.f406206f == null) {
                    this.f406206f = new o();
                }
                codedInputByteBufferNano.readMessage(this.f406206f);
            } else if (readTag == 58) {
                if (this.f406207g == null) {
                    this.f406207g = new u();
                }
                codedInputByteBufferNano.readMessage(this.f406207g);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f406208h == null) {
                    this.f406208h = new c();
                }
                codedInputByteBufferNano.readMessage(this.f406208h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406201a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        e eVar = this.f406202b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        l lVar = this.f406203c;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, lVar);
        }
        a aVar = this.f406204d;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        int i16 = this.f406205e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        o oVar = this.f406206f;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, oVar);
        }
        u uVar = this.f406207g;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, uVar);
        }
        c cVar = this.f406208h;
        return cVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, cVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406201a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        e eVar = this.f406202b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        l lVar = this.f406203c;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(3, lVar);
        }
        a aVar = this.f406204d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        int i16 = this.f406205e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        o oVar = this.f406206f;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(6, oVar);
        }
        u uVar = this.f406207g;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(7, uVar);
        }
        c cVar = this.f406208h;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public s a() {
        this.f406201a = 0;
        this.f406202b = null;
        this.f406203c = null;
        this.f406204d = null;
        this.f406205e = 0;
        this.f406206f = null;
        this.f406207g = null;
        this.f406208h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
