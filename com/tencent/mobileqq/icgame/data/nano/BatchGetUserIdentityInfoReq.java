package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class BatchGetUserIdentityInfoReq extends ExtendableMessageNano<BatchGetUserIdentityInfoReq> {
    private static volatile BatchGetUserIdentityInfoReq[] _emptyArray;
    public int roomId;
    public long[] userIdList;

    public BatchGetUserIdentityInfoReq() {
        clear();
    }

    public static BatchGetUserIdentityInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetUserIdentityInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetUserIdentityInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetUserIdentityInfoReq) MessageNano.mergeFrom(new BatchGetUserIdentityInfoReq(), bArr);
    }

    public BatchGetUserIdentityInfoReq clear() {
        this.roomId = 0;
        this.userIdList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long[] jArr = this.userIdList;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.userIdList;
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
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long[] jArr = this.userIdList;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.userIdList;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetUserIdentityInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetUserIdentityInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetUserIdentityInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.userIdList;
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
                this.userIdList = jArr2;
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
                long[] jArr3 = this.userIdList;
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
                this.userIdList = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
