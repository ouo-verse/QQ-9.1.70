package com.tencent.mobileqq.icgame.data.meet.nano;

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
public final class UserVideoStatus extends ExtendableMessageNano<UserVideoStatus> {
    private static volatile UserVideoStatus[] _emptyArray;
    public long roomHbcnt;
    public long roomLastestHbTime;
    public long seeBeginTime;
    public long seeRoomid;
    public int status;
    public long unlockTimestamp;
    public int viewCnt;
    public long[] viewedUid;

    public UserVideoStatus() {
        clear();
    }

    public static UserVideoStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserVideoStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserVideoStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserVideoStatus) MessageNano.mergeFrom(new UserVideoStatus(), bArr);
    }

    public UserVideoStatus clear() {
        this.status = 0;
        this.unlockTimestamp = 0L;
        this.viewCnt = 0;
        this.viewedUid = WireFormatNano.EMPTY_LONG_ARRAY;
        this.seeRoomid = 0L;
        this.seeBeginTime = 0L;
        this.roomLastestHbTime = 0L;
        this.roomHbcnt = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.status;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.unlockTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        int i16 = this.viewCnt;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long[] jArr2 = this.viewedUid;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.viewedUid;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        long j16 = this.seeRoomid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.seeBeginTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j17);
        }
        long j18 = this.roomLastestHbTime;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j18);
        }
        long j19 = this.roomHbcnt;
        if (j19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(8, j19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.status;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.unlockTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        int i16 = this.viewCnt;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long[] jArr = this.viewedUid;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.viewedUid;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(4, jArr2[i17]);
                i17++;
            }
        }
        long j16 = this.seeRoomid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.seeBeginTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j17);
        }
        long j18 = this.roomLastestHbTime;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j18);
        }
        long j19 = this.roomHbcnt;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserVideoStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserVideoStatus().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserVideoStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.unlockTimestamp = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.viewCnt = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                long[] jArr = this.viewedUid;
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
                this.viewedUid = jArr2;
            } else if (readTag == 34) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.viewedUid;
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
                this.viewedUid = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 40) {
                this.seeRoomid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.seeBeginTime = codedInputByteBufferNano.readInt64();
            } else if (readTag == 56) {
                this.roomLastestHbTime = codedInputByteBufferNano.readInt64();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomHbcnt = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
