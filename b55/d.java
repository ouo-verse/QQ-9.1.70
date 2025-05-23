package b55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f27967a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f27968b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f27969c;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f27967a = g.b();
        this.f27968b = null;
        this.f27969c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f27969c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f27968b = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f27968b, mapFactory, 9, 9, null, 10, 18);
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    g[] gVarArr = this.f27967a;
                    if (gVarArr == null) {
                        length = 0;
                    } else {
                        length = gVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    g[] gVarArr2 = new g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        g gVar = new g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f27967a = gVarArr2;
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
        g[] gVarArr = this.f27967a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f27967a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i3++;
            }
        }
        Map<String, String> map = this.f27968b;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 2, 9, 9);
        }
        boolean z16 = this.f27969c;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g[] gVarArr = this.f27967a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f27967a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i3++;
            }
        }
        Map<String, String> map = this.f27968b;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
        }
        boolean z16 = this.f27969c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
