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
public final class TeaseHerHistoryRsp extends ExtendableMessageNano<TeaseHerHistoryRsp> {
    private static volatile TeaseHerHistoryRsp[] _emptyArray;
    public int count;
    public String errmsg;
    public boolean isEnd;
    public AnchorInfo[] records;
    public int retcode;
    public int start;
    public long[] times;

    public TeaseHerHistoryRsp() {
        clear();
    }

    public static TeaseHerHistoryRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeaseHerHistoryRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TeaseHerHistoryRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TeaseHerHistoryRsp) MessageNano.mergeFrom(new TeaseHerHistoryRsp(), bArr);
    }

    public TeaseHerHistoryRsp clear() {
        this.retcode = 0;
        this.errmsg = "";
        this.start = 0;
        this.count = 0;
        this.isEnd = false;
        this.times = WireFormatNano.EMPTY_LONG_ARRAY;
        this.records = AnchorInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        int i16 = this.start;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.count;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        boolean z16 = this.isEnd;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long[] jArr2 = this.times;
        int i18 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                jArr = this.times;
                if (i19 >= jArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr[i19]);
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (jArr.length * 1);
        }
        AnchorInfo[] anchorInfoArr = this.records;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.records;
                if (i18 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i18];
                if (anchorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, anchorInfo);
                }
                i18++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.errmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errmsg);
        }
        int i16 = this.start;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.count;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        boolean z16 = this.isEnd;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long[] jArr = this.times;
        int i18 = 0;
        if (jArr != null && jArr.length > 0) {
            int i19 = 0;
            while (true) {
                long[] jArr2 = this.times;
                if (i19 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt64(6, jArr2[i19]);
                i19++;
            }
        }
        AnchorInfo[] anchorInfoArr = this.records;
        if (anchorInfoArr != null && anchorInfoArr.length > 0) {
            while (true) {
                AnchorInfo[] anchorInfoArr2 = this.records;
                if (i18 >= anchorInfoArr2.length) {
                    break;
                }
                AnchorInfo anchorInfo = anchorInfoArr2[i18];
                if (anchorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(7, anchorInfo);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TeaseHerHistoryRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TeaseHerHistoryRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TeaseHerHistoryRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retcode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.errmsg = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.start = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.count = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.isEnd = codedInputByteBufferNano.readBool();
            } else if (readTag == 48) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                long[] jArr = this.times;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readInt64();
                this.times = jArr2;
            } else if (readTag == 50) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.times;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readInt64();
                    length2++;
                }
                this.times = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                AnchorInfo[] anchorInfoArr = this.records;
                int length3 = anchorInfoArr == null ? 0 : anchorInfoArr.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                AnchorInfo[] anchorInfoArr2 = new AnchorInfo[i18];
                if (length3 != 0) {
                    System.arraycopy(anchorInfoArr, 0, anchorInfoArr2, 0, length3);
                }
                while (length3 < i18 - 1) {
                    AnchorInfo anchorInfo = new AnchorInfo();
                    anchorInfoArr2[length3] = anchorInfo;
                    codedInputByteBufferNano.readMessage(anchorInfo);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                AnchorInfo anchorInfo2 = new AnchorInfo();
                anchorInfoArr2[length3] = anchorInfo2;
                codedInputByteBufferNano.readMessage(anchorInfo2);
                this.records = anchorInfoArr2;
            }
        }
    }
}
