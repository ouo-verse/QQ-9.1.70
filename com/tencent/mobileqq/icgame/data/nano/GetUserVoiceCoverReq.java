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
public final class GetUserVoiceCoverReq extends ExtendableMessageNano<GetUserVoiceCoverReq> {
    private static volatile GetUserVoiceCoverReq[] _emptyArray;
    public long[] uidList;

    public GetUserVoiceCoverReq() {
        clear();
    }

    public static GetUserVoiceCoverReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUserVoiceCoverReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUserVoiceCoverReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUserVoiceCoverReq) MessageNano.mergeFrom(new GetUserVoiceCoverReq(), bArr);
    }

    public GetUserVoiceCoverReq clear() {
        this.uidList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long[] jArr = this.uidList;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.uidList;
                if (i3 < jArr2.length) {
                    i16 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.uidList;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.uidList;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(1, jArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUserVoiceCoverReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUserVoiceCoverReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUserVoiceCoverReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                long[] jArr = this.uidList;
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
                this.uidList = jArr2;
            } else if (readTag != 10) {
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
                long[] jArr3 = this.uidList;
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
                this.uidList = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
