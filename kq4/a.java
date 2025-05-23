package kq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a[] f412866g;

    /* renamed from: a, reason: collision with root package name */
    public String f412867a;

    /* renamed from: b, reason: collision with root package name */
    public String f412868b;

    /* renamed from: c, reason: collision with root package name */
    public String f412869c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f412870d;

    /* renamed from: e, reason: collision with root package name */
    public d[] f412871e;

    /* renamed from: f, reason: collision with root package name */
    public a[] f412872f;

    public a() {
        a();
    }

    public static a[] b() {
        if (f412866g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412866g == null) {
                    f412866g = new a[0];
                }
            }
        }
        return f412866g;
    }

    public a a() {
        this.f412867a = "";
        this.f412868b = "";
        this.f412869c = "";
        this.f412870d = null;
        this.f412871e = d.b();
        this.f412872f = b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                        a[] aVarArr = this.f412872f;
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
                                        this.f412872f = aVarArr2;
                                    }
                                } else {
                                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    d[] dVarArr = this.f412871e;
                                    if (dVarArr == null) {
                                        length2 = 0;
                                    } else {
                                        length2 = dVarArr.length;
                                    }
                                    int i16 = repeatedFieldArrayLength2 + length2;
                                    d[] dVarArr2 = new d[i16];
                                    if (length2 != 0) {
                                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length2);
                                    }
                                    while (length2 < i16 - 1) {
                                        d dVar = new d();
                                        dVarArr2[length2] = dVar;
                                        codedInputByteBufferNano.readMessage(dVar);
                                        codedInputByteBufferNano.readTag();
                                        length2++;
                                    }
                                    d dVar2 = new d();
                                    dVarArr2[length2] = dVar2;
                                    codedInputByteBufferNano.readMessage(dVar2);
                                    this.f412871e = dVarArr2;
                                }
                            } else {
                                this.f412870d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f412870d, mapFactory, 9, 9, null, 10, 18);
                            }
                        } else {
                            this.f412869c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f412868b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f412867a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f412867a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f412867a);
        }
        if (!this.f412868b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f412868b);
        }
        if (!this.f412869c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f412869c);
        }
        Map<String, String> map = this.f412870d;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        d[] dVarArr = this.f412871e;
        int i3 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                d[] dVarArr2 = this.f412871e;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i16];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, dVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f412872f;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f412872f;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, aVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f412867a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f412867a);
        }
        if (!this.f412868b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f412868b);
        }
        if (!this.f412869c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f412869c);
        }
        Map<String, String> map = this.f412870d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        d[] dVarArr = this.f412871e;
        int i3 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                d[] dVarArr2 = this.f412871e;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i16];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, dVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f412872f;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f412872f;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, aVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
