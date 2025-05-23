package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r[] f406190j;

    /* renamed from: a, reason: collision with root package name */
    public int f406191a;

    /* renamed from: b, reason: collision with root package name */
    public n f406192b;

    /* renamed from: c, reason: collision with root package name */
    public n f406193c;

    /* renamed from: d, reason: collision with root package name */
    public l f406194d;

    /* renamed from: e, reason: collision with root package name */
    public a f406195e;

    /* renamed from: f, reason: collision with root package name */
    public int f406196f;

    /* renamed from: g, reason: collision with root package name */
    public int f406197g;

    /* renamed from: h, reason: collision with root package name */
    public a f406198h;

    /* renamed from: i, reason: collision with root package name */
    public int f406199i;

    public r() {
        a();
    }

    public static r[] b() {
        if (f406190j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406190j == null) {
                    f406190j = new r[0];
                }
            }
        }
        return f406190j;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406191a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f406192b == null) {
                    this.f406192b = new n();
                }
                codedInputByteBufferNano.readMessage(this.f406192b);
            } else if (readTag == 26) {
                if (this.f406193c == null) {
                    this.f406193c = new n();
                }
                codedInputByteBufferNano.readMessage(this.f406193c);
            } else if (readTag == 34) {
                if (this.f406194d == null) {
                    this.f406194d = new l();
                }
                codedInputByteBufferNano.readMessage(this.f406194d);
            } else if (readTag == 42) {
                if (this.f406195e == null) {
                    this.f406195e = new a();
                }
                codedInputByteBufferNano.readMessage(this.f406195e);
            } else if (readTag == 48) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f406196f = readInt32;
                }
            } else if (readTag == 56) {
                this.f406197g = codedInputByteBufferNano.readInt32();
            } else if (readTag == 66) {
                if (this.f406198h == null) {
                    this.f406198h = new a();
                }
                codedInputByteBufferNano.readMessage(this.f406198h);
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f406199i = readInt322;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f406191a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        n nVar = this.f406192b;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, nVar);
        }
        n nVar2 = this.f406193c;
        if (nVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, nVar2);
        }
        l lVar = this.f406194d;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
        }
        a aVar = this.f406195e;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
        }
        int i16 = this.f406196f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f406197g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        a aVar2 = this.f406198h;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, aVar2);
        }
        int i18 = this.f406199i;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(9, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f406191a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        n nVar = this.f406192b;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(2, nVar);
        }
        n nVar2 = this.f406193c;
        if (nVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, nVar2);
        }
        l lVar = this.f406194d;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(4, lVar);
        }
        a aVar = this.f406195e;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar);
        }
        int i16 = this.f406196f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f406197g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        a aVar2 = this.f406198h;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(8, aVar2);
        }
        int i18 = this.f406199i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f406191a = 0;
        this.f406192b = null;
        this.f406193c = null;
        this.f406194d = null;
        this.f406195e = null;
        this.f406196f = 0;
        this.f406197g = 0;
        this.f406198h = null;
        this.f406199i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
