package ot3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f424010e;

    /* renamed from: a, reason: collision with root package name */
    public int f424011a;

    /* renamed from: b, reason: collision with root package name */
    public a[] f424012b;

    /* renamed from: c, reason: collision with root package name */
    public String f424013c;

    /* renamed from: d, reason: collision with root package name */
    public int f424014d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f424010e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f424010e == null) {
                    f424010e = new b[0];
                }
            }
        }
        return f424010e;
    }

    public b a() {
        this.f424011a = 0;
        this.f424012b = a.b();
        this.f424013c = "";
        this.f424014d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f424014d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f424013c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        a[] aVarArr = this.f424012b;
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
                        this.f424012b = aVarArr2;
                    }
                } else {
                    this.f424011a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f424011a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        a[] aVarArr = this.f424012b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f424012b;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
                }
                i16++;
            }
        }
        if (!this.f424013c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424013c);
        }
        int i17 = this.f424014d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424011a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        a[] aVarArr = this.f424012b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f424012b;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, aVar);
                }
                i16++;
            }
        }
        if (!this.f424013c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424013c);
        }
        int i17 = this.f424014d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
