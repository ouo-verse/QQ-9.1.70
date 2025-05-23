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
public final class MeetVideoQueryRsp extends ExtendableMessageNano<MeetVideoQueryRsp> {
    private static volatile MeetVideoQueryRsp[] _emptyArray;
    public String errmsg;
    public boolean isEnd;
    public int leftCount;
    public int lockStatus;
    public long nowTimestamp;
    public int retcode;
    public long unlockTimestamp;
    public MeetVideoInfo[] videoList;

    public MeetVideoQueryRsp() {
        clear();
    }

    public static MeetVideoQueryRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeetVideoQueryRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeetVideoQueryRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeetVideoQueryRsp) MessageNano.mergeFrom(new MeetVideoQueryRsp(), bArr);
    }

    public MeetVideoQueryRsp clear() {
        this.retcode = 0;
        this.errmsg = "";
        this.leftCount = 0;
        this.lockStatus = 0;
        this.unlockTimestamp = 0L;
        this.nowTimestamp = 0L;
        this.isEnd = false;
        this.videoList = MeetVideoInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        int i16 = this.leftCount;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.lockStatus;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        long j3 = this.unlockTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        long j16 = this.nowTimestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j16);
        }
        boolean z16 = this.isEnd;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        MeetVideoInfo[] meetVideoInfoArr = this.videoList;
        if (meetVideoInfoArr != null && meetVideoInfoArr.length > 0) {
            int i18 = 0;
            while (true) {
                MeetVideoInfo[] meetVideoInfoArr2 = this.videoList;
                if (i18 >= meetVideoInfoArr2.length) {
                    break;
                }
                MeetVideoInfo meetVideoInfo = meetVideoInfoArr2[i18];
                if (meetVideoInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, meetVideoInfo);
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
        int i16 = this.leftCount;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.lockStatus;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        long j3 = this.unlockTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        long j16 = this.nowTimestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j16);
        }
        boolean z16 = this.isEnd;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        MeetVideoInfo[] meetVideoInfoArr = this.videoList;
        if (meetVideoInfoArr != null && meetVideoInfoArr.length > 0) {
            int i18 = 0;
            while (true) {
                MeetVideoInfo[] meetVideoInfoArr2 = this.videoList;
                if (i18 >= meetVideoInfoArr2.length) {
                    break;
                }
                MeetVideoInfo meetVideoInfo = meetVideoInfoArr2[i18];
                if (meetVideoInfo != null) {
                    codedOutputByteBufferNano.writeMessage(8, meetVideoInfo);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeetVideoQueryRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeetVideoQueryRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeetVideoQueryRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.leftCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.lockStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.unlockTimestamp = codedInputByteBufferNano.readInt64();
            } else if (readTag == 48) {
                this.nowTimestamp = codedInputByteBufferNano.readInt64();
            } else if (readTag == 56) {
                this.isEnd = codedInputByteBufferNano.readBool();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                MeetVideoInfo[] meetVideoInfoArr = this.videoList;
                int length = meetVideoInfoArr == null ? 0 : meetVideoInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                MeetVideoInfo[] meetVideoInfoArr2 = new MeetVideoInfo[i3];
                if (length != 0) {
                    System.arraycopy(meetVideoInfoArr, 0, meetVideoInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    MeetVideoInfo meetVideoInfo = new MeetVideoInfo();
                    meetVideoInfoArr2[length] = meetVideoInfo;
                    codedInputByteBufferNano.readMessage(meetVideoInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                MeetVideoInfo meetVideoInfo2 = new MeetVideoInfo();
                meetVideoInfoArr2[length] = meetVideoInfo2;
                codedInputByteBufferNano.readMessage(meetVideoInfo2);
                this.videoList = meetVideoInfoArr2;
            }
        }
    }
}
