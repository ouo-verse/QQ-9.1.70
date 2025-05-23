package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetPhotoListReq extends ExtendableMessageNano<GetPhotoListReq> {
    private static volatile GetPhotoListReq[] _emptyArray;

    /* renamed from: id, reason: collision with root package name */
    public long[] f237279id;
    public int idType;

    public GetPhotoListReq() {
        clear();
    }

    public static GetPhotoListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPhotoListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPhotoListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPhotoListReq) MessageNano.mergeFrom(new GetPhotoListReq(), bArr);
    }

    public GetPhotoListReq clear() {
        this.idType = 1;
        this.f237279id = WireFormatNano.EMPTY_LONG_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.idType;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long[] jArr = this.f237279id;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f237279id;
                if (i16 < jArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i16]);
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.idType;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long[] jArr = this.f237279id;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f237279id;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetPhotoListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPhotoListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPhotoListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2) {
                    this.idType = readInt32;
                }
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.f237279id;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.f237279id = jArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f237279id;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.f237279id = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
