package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f403771a;

    /* renamed from: b, reason: collision with root package name */
    public h[] f403772b;

    public g() {
        a();
    }

    public g a() {
        this.f403771a = 0;
        this.f403772b = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        h[] hVarArr = this.f403772b;
                        if (hVarArr == null) {
                            length = 0;
                        } else {
                            length = hVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        h[] hVarArr2 = new h[i3];
                        if (length != 0) {
                            System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            h hVar = new h();
                            hVarArr2[length] = hVar;
                            codedInputByteBufferNano.readMessage(hVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        h hVar2 = new h();
                        hVarArr2[length] = hVar2;
                        codedInputByteBufferNano.readMessage(hVar2);
                        this.f403772b = hVarArr2;
                    }
                } else {
                    this.f403771a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403771a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        h[] hVarArr = this.f403772b;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f403772b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403771a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        h[] hVarArr = this.f403772b;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f403772b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, hVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
