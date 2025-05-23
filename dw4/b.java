package dw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import qu4.h;
import uv4.am;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: m, reason: collision with root package name */
    private static volatile b[] f395113m;

    /* renamed from: a, reason: collision with root package name */
    public boolean f395114a;

    /* renamed from: b, reason: collision with root package name */
    public h f395115b;

    /* renamed from: c, reason: collision with root package name */
    public int f395116c;

    /* renamed from: d, reason: collision with root package name */
    public qu4.a f395117d;

    /* renamed from: e, reason: collision with root package name */
    public qu4.a f395118e;

    /* renamed from: f, reason: collision with root package name */
    public qu4.a f395119f;

    /* renamed from: g, reason: collision with root package name */
    public qu4.a f395120g;

    /* renamed from: h, reason: collision with root package name */
    public h f395121h;

    /* renamed from: i, reason: collision with root package name */
    public h f395122i;

    /* renamed from: j, reason: collision with root package name */
    public long f395123j;

    /* renamed from: k, reason: collision with root package name */
    public am f395124k;

    /* renamed from: l, reason: collision with root package name */
    public String f395125l;

    public b() {
        a();
    }

    public static b[] b() {
        if (f395113m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395113m == null) {
                    f395113m = new b[0];
                }
            }
        }
        return f395113m;
    }

    public static b d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f395114a = codedInputByteBufferNano.readBool();
                    break;
                case 18:
                    if (this.f395115b == null) {
                        this.f395115b = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f395115b);
                    break;
                case 24:
                    this.f395116c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    if (this.f395117d == null) {
                        this.f395117d = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f395117d);
                    break;
                case 42:
                    if (this.f395118e == null) {
                        this.f395118e = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f395118e);
                    break;
                case 50:
                    if (this.f395119f == null) {
                        this.f395119f = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f395119f);
                    break;
                case 58:
                    if (this.f395120g == null) {
                        this.f395120g = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f395120g);
                    break;
                case 66:
                    if (this.f395121h == null) {
                        this.f395121h = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f395121h);
                    break;
                case 74:
                    if (this.f395122i == null) {
                        this.f395122i = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f395122i);
                    break;
                case 80:
                    this.f395123j = codedInputByteBufferNano.readUInt64();
                    break;
                case 90:
                    if (this.f395124k == null) {
                        this.f395124k = new am();
                    }
                    codedInputByteBufferNano.readMessage(this.f395124k);
                    break;
                case 98:
                    this.f395125l = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f395114a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        h hVar = this.f395115b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        int i3 = this.f395116c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        qu4.a aVar = this.f395117d;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        qu4.a aVar2 = this.f395118e;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar2);
        }
        qu4.a aVar3 = this.f395119f;
        if (aVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, aVar3);
        }
        qu4.a aVar4 = this.f395120g;
        if (aVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, aVar4);
        }
        h hVar2 = this.f395121h;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, hVar2);
        }
        h hVar3 = this.f395122i;
        if (hVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, hVar3);
        }
        long j3 = this.f395123j;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j3);
        }
        am amVar = this.f395124k;
        if (amVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, amVar);
        }
        return !this.f395125l.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f395125l) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f395114a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        h hVar = this.f395115b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        int i3 = this.f395116c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        qu4.a aVar = this.f395117d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        qu4.a aVar2 = this.f395118e;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar2);
        }
        qu4.a aVar3 = this.f395119f;
        if (aVar3 != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar3);
        }
        qu4.a aVar4 = this.f395120g;
        if (aVar4 != null) {
            codedOutputByteBufferNano.writeMessage(7, aVar4);
        }
        h hVar2 = this.f395121h;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(8, hVar2);
        }
        h hVar3 = this.f395122i;
        if (hVar3 != null) {
            codedOutputByteBufferNano.writeMessage(9, hVar3);
        }
        long j3 = this.f395123j;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        am amVar = this.f395124k;
        if (amVar != null) {
            codedOutputByteBufferNano.writeMessage(11, amVar);
        }
        if (!this.f395125l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f395125l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f395114a = false;
        this.f395115b = null;
        this.f395116c = 0;
        this.f395117d = null;
        this.f395118e = null;
        this.f395119f = null;
        this.f395120g = null;
        this.f395121h = null;
        this.f395122i = null;
        this.f395123j = 0L;
        this.f395124k = null;
        this.f395125l = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
