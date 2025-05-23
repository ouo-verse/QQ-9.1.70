package e55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f395728d;

    /* renamed from: a, reason: collision with root package name */
    public c f395729a;

    /* renamed from: b, reason: collision with root package name */
    public b f395730b;

    /* renamed from: c, reason: collision with root package name */
    public d[] f395731c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f395728d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f395728d == null) {
                    f395728d = new a[0];
                }
            }
        }
        return f395728d;
    }

    public a a() {
        this.f395729a = null;
        this.f395730b = null;
        this.f395731c = d.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            d[] dVarArr = this.f395731c;
                            if (dVarArr == null) {
                                length = 0;
                            } else {
                                length = dVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            d[] dVarArr2 = new d[i3];
                            if (length != 0) {
                                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                d dVar = new d();
                                dVarArr2[length] = dVar;
                                codedInputByteBufferNano.readMessage(dVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            d dVar2 = new d();
                            dVarArr2[length] = dVar2;
                            codedInputByteBufferNano.readMessage(dVar2);
                            this.f395731c = dVarArr2;
                        }
                    } else {
                        if (this.f395730b == null) {
                            this.f395730b = new b();
                        }
                        codedInputByteBufferNano.readMessage(this.f395730b);
                    }
                } else {
                    if (this.f395729a == null) {
                        this.f395729a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f395729a);
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
        c cVar = this.f395729a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        b bVar = this.f395730b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        d[] dVarArr = this.f395731c;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f395731c;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f395729a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        b bVar = this.f395730b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        d[] dVarArr = this.f395731c;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f395731c;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, dVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
