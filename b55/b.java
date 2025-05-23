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
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public g f27961a;

    /* renamed from: b, reason: collision with root package name */
    public y45.b[] f27962b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f27963c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27964d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f27961a = null;
        this.f27962b = y45.b.b();
        this.f27963c = null;
        this.f27964d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f27964d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f27963c = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f27963c, mapFactory, 9, 9, null, 10, 18);
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        y45.b[] bVarArr = this.f27962b;
                        if (bVarArr == null) {
                            length = 0;
                        } else {
                            length = bVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        y45.b[] bVarArr2 = new y45.b[i3];
                        if (length != 0) {
                            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            y45.b bVar = new y45.b();
                            bVarArr2[length] = bVar;
                            codedInputByteBufferNano.readMessage(bVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        y45.b bVar2 = new y45.b();
                        bVarArr2[length] = bVar2;
                        codedInputByteBufferNano.readMessage(bVar2);
                        this.f27962b = bVarArr2;
                    }
                } else {
                    if (this.f27961a == null) {
                        this.f27961a = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f27961a);
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
        g gVar = this.f27961a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        y45.b[] bVarArr = this.f27962b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f27962b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i3++;
            }
        }
        Map<String, String> map = this.f27963c;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 3, 9, 9);
        }
        boolean z16 = this.f27964d;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g gVar = this.f27961a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        y45.b[] bVarArr = this.f27962b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f27962b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i3++;
            }
        }
        Map<String, String> map = this.f27963c;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 9, 9);
        }
        boolean z16 = this.f27964d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
