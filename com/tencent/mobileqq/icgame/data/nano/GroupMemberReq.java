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
public final class GroupMemberReq extends ExtendableMessageNano<GroupMemberReq> {
    private static volatile GroupMemberReq[] _emptyArray;
    public long groupCode;
    public int roomId;
    public long[] rptUidList;

    public GroupMemberReq() {
        clear();
    }

    public static GroupMemberReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GroupMemberReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GroupMemberReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GroupMemberReq) MessageNano.mergeFrom(new GroupMemberReq(), bArr);
    }

    public GroupMemberReq clear() {
        this.roomId = 0;
        this.groupCode = 0L;
        this.rptUidList = WireFormatNano.EMPTY_LONG_ARRAY;
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
        long j3 = this.groupCode;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long[] jArr = this.rptUidList;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.rptUidList;
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
        long j3 = this.groupCode;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long[] jArr = this.rptUidList;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.rptUidList;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GroupMemberReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GroupMemberReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GroupMemberReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.groupCode = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.rptUidList;
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
                this.rptUidList = jArr2;
            } else if (readTag != 26) {
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
                long[] jArr3 = this.rptUidList;
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
                this.rptUidList = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
