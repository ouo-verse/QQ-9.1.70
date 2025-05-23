package cp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: o, reason: collision with root package name */
    private static volatile b[] f391572o;

    /* renamed from: a, reason: collision with root package name */
    public String f391573a;

    /* renamed from: b, reason: collision with root package name */
    public String f391574b;

    /* renamed from: c, reason: collision with root package name */
    public String f391575c;

    /* renamed from: d, reason: collision with root package name */
    public int f391576d;

    /* renamed from: e, reason: collision with root package name */
    public long f391577e;

    /* renamed from: f, reason: collision with root package name */
    public long f391578f;

    /* renamed from: g, reason: collision with root package name */
    public long f391579g;

    /* renamed from: h, reason: collision with root package name */
    public d f391580h;

    /* renamed from: i, reason: collision with root package name */
    public k f391581i;

    /* renamed from: j, reason: collision with root package name */
    public long f391582j;

    /* renamed from: k, reason: collision with root package name */
    public a[] f391583k;

    /* renamed from: l, reason: collision with root package name */
    public long f391584l;

    /* renamed from: m, reason: collision with root package name */
    public int f391585m;

    /* renamed from: n, reason: collision with root package name */
    public Map<String, String> f391586n;

    public b() {
        a();
    }

    public static b[] b() {
        if (f391572o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391572o == null) {
                    f391572o = new b[0];
                }
            }
        }
        return f391572o;
    }

    public b a() {
        this.f391573a = "";
        this.f391574b = "";
        this.f391575c = "";
        this.f391576d = 0;
        this.f391577e = 0L;
        this.f391578f = 0L;
        this.f391579g = 0L;
        this.f391580h = null;
        this.f391581i = null;
        this.f391582j = 0L;
        this.f391583k = a.b();
        this.f391584l = 0L;
        this.f391585m = 0;
        this.f391586n = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f391573a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f391574b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f391575c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f391576d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f391577e = codedInputByteBufferNano.readInt64();
                    break;
                case 48:
                    this.f391578f = codedInputByteBufferNano.readInt64();
                    break;
                case 56:
                    this.f391579g = codedInputByteBufferNano.readInt64();
                    break;
                case 66:
                    if (this.f391580h == null) {
                        this.f391580h = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f391580h);
                    break;
                case 74:
                    if (this.f391581i == null) {
                        this.f391581i = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f391581i);
                    break;
                case 80:
                    this.f391582j = codedInputByteBufferNano.readUInt64();
                    break;
                case 802:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 802);
                    a[] aVarArr = this.f391583k;
                    if (aVarArr == null) {
                        length = 0;
                    } else {
                        length = aVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    a[] aVarArr2 = new a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        a aVar = new a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f391583k = aVarArr2;
                    break;
                case 808:
                    this.f391584l = codedInputByteBufferNano.readUInt64();
                    break;
                case 816:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f391585m = readInt32;
                        break;
                    }
                case BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO /* 826 */:
                    this.f391586n = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f391586n, mapFactory, 9, 9, null, 10, 18);
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
        if (!this.f391573a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f391573a);
        }
        if (!this.f391574b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391574b);
        }
        if (!this.f391575c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391575c);
        }
        int i3 = this.f391576d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        long j3 = this.f391577e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        long j16 = this.f391578f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j16);
        }
        long j17 = this.f391579g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j17);
        }
        d dVar = this.f391580h;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, dVar);
        }
        k kVar = this.f391581i;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, kVar);
        }
        long j18 = this.f391582j;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j18);
        }
        a[] aVarArr = this.f391583k;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f391583k;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(100, aVar);
                }
                i16++;
            }
        }
        long j19 = this.f391584l;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(101, j19);
        }
        int i17 = this.f391585m;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(102, i17);
        }
        Map<String, String> map = this.f391586n;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 103, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f391573a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f391573a);
        }
        if (!this.f391574b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391574b);
        }
        if (!this.f391575c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391575c);
        }
        int i3 = this.f391576d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        long j3 = this.f391577e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        long j16 = this.f391578f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j16);
        }
        long j17 = this.f391579g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j17);
        }
        d dVar = this.f391580h;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(8, dVar);
        }
        k kVar = this.f391581i;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(9, kVar);
        }
        long j18 = this.f391582j;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j18);
        }
        a[] aVarArr = this.f391583k;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f391583k;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(100, aVar);
                }
                i16++;
            }
        }
        long j19 = this.f391584l;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(101, j19);
        }
        int i17 = this.f391585m;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(102, i17);
        }
        Map<String, String> map = this.f391586n;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 103, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
