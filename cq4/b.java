package cq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b[] f391667f;

    /* renamed from: a, reason: collision with root package name */
    public int f391668a;

    /* renamed from: b, reason: collision with root package name */
    public long f391669b;

    /* renamed from: c, reason: collision with root package name */
    public d[] f391670c;

    /* renamed from: d, reason: collision with root package name */
    public c[] f391671d;

    /* renamed from: e, reason: collision with root package name */
    public int f391672e;

    public b() {
        a();
    }

    public static b[] b() {
        if (f391667f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391667f == null) {
                    f391667f = new b[0];
                }
            }
        }
        return f391667f;
    }

    public b a() {
        this.f391668a = 0;
        this.f391669b = 0L;
        this.f391670c = d.b();
        this.f391671d = c.b();
        this.f391672e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f391672e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                c[] cVarArr = this.f391671d;
                                if (cVarArr == null) {
                                    length = 0;
                                } else {
                                    length = cVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                c[] cVarArr2 = new c[i3];
                                if (length != 0) {
                                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    c cVar = new c();
                                    cVarArr2[length] = cVar;
                                    codedInputByteBufferNano.readMessage(cVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                c cVar2 = new c();
                                cVarArr2[length] = cVar2;
                                codedInputByteBufferNano.readMessage(cVar2);
                                this.f391671d = cVarArr2;
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            d[] dVarArr = this.f391670c;
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
                            this.f391670c = dVarArr2;
                        }
                    } else {
                        this.f391669b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f391668a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f391668a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f391669b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        d[] dVarArr = this.f391670c;
        int i16 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                d[] dVarArr2 = this.f391670c;
                if (i17 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i17];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
                }
                i17++;
            }
        }
        c[] cVarArr = this.f391671d;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f391671d;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
                }
                i16++;
            }
        }
        int i18 = this.f391672e;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f391668a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f391669b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        d[] dVarArr = this.f391670c;
        int i16 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                d[] dVarArr2 = this.f391670c;
                if (i17 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i17];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, dVar);
                }
                i17++;
            }
        }
        c[] cVarArr = this.f391671d;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f391671d;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, cVar);
                }
                i16++;
            }
        }
        int i18 = this.f391672e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
