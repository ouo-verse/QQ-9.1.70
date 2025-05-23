package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f413103a;

    /* renamed from: b, reason: collision with root package name */
    public String f413104b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f413105c;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f413103a = readInt32;
                }
            } else if (readTag == 18) {
                this.f413104b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                int[] iArr = this.f413105c;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f413105c = iArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f413105c;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f413105c = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f413103a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f413104b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f413104b);
        }
        int[] iArr = this.f413105c;
        if (iArr == null || iArr.length <= 0) {
            return computeSerializedSize;
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int[] iArr2 = this.f413105c;
            if (i16 < iArr2.length) {
                i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i16]);
                i16++;
            } else {
                return computeSerializedSize + i17 + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f413103a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f413104b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f413104b);
        }
        int[] iArr = this.f413105c;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f413105c;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f413103a = 0;
        this.f413104b = "";
        this.f413105c = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
