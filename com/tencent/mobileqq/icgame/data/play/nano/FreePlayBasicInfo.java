package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayBasicInfo extends ExtendableMessageNano<FreePlayBasicInfo> {
    private static volatile FreePlayBasicInfo[] _emptyArray;
    public int basicinfoSeq;
    public int cas;
    public String punishTopic;
    public int stage;
    public long startSeq;
    public int startTime;
    public int timeLimit;
    public FreePlayVipUser[] vipUsers;

    public FreePlayBasicInfo() {
        clear();
    }

    public static FreePlayBasicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayBasicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayBasicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayBasicInfo) MessageNano.mergeFrom(new FreePlayBasicInfo(), bArr);
    }

    public FreePlayBasicInfo clear() {
        this.basicinfoSeq = 0;
        this.stage = 0;
        this.vipUsers = FreePlayVipUser.emptyArray();
        this.startSeq = 0L;
        this.startTime = 0;
        this.cas = 0;
        this.timeLimit = 0;
        this.punishTopic = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.basicinfoSeq);
        int i3 = this.stage;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        FreePlayVipUser[] freePlayVipUserArr = this.vipUsers;
        if (freePlayVipUserArr != null && freePlayVipUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                FreePlayVipUser[] freePlayVipUserArr2 = this.vipUsers;
                if (i16 >= freePlayVipUserArr2.length) {
                    break;
                }
                FreePlayVipUser freePlayVipUser = freePlayVipUserArr2[i16];
                if (freePlayVipUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, freePlayVipUser);
                }
                i16++;
            }
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        int i17 = this.startTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.cas;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i18);
        }
        int i19 = this.timeLimit;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        if (!this.punishTopic.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.punishTopic);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.basicinfoSeq);
        int i3 = this.stage;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        FreePlayVipUser[] freePlayVipUserArr = this.vipUsers;
        if (freePlayVipUserArr != null && freePlayVipUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                FreePlayVipUser[] freePlayVipUserArr2 = this.vipUsers;
                if (i16 >= freePlayVipUserArr2.length) {
                    break;
                }
                FreePlayVipUser freePlayVipUser = freePlayVipUserArr2[i16];
                if (freePlayVipUser != null) {
                    codedOutputByteBufferNano.writeMessage(3, freePlayVipUser);
                }
                i16++;
            }
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        int i17 = this.startTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.cas;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        int i19 = this.timeLimit;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        if (!this.punishTopic.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.punishTopic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayBasicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayBasicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayBasicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.basicinfoSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.stage = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                FreePlayVipUser[] freePlayVipUserArr = this.vipUsers;
                int length = freePlayVipUserArr == null ? 0 : freePlayVipUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FreePlayVipUser[] freePlayVipUserArr2 = new FreePlayVipUser[i3];
                if (length != 0) {
                    System.arraycopy(freePlayVipUserArr, 0, freePlayVipUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FreePlayVipUser freePlayVipUser = new FreePlayVipUser();
                    freePlayVipUserArr2[length] = freePlayVipUser;
                    codedInputByteBufferNano.readMessage(freePlayVipUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FreePlayVipUser freePlayVipUser2 = new FreePlayVipUser();
                freePlayVipUserArr2[length] = freePlayVipUser2;
                codedInputByteBufferNano.readMessage(freePlayVipUser2);
                this.vipUsers = freePlayVipUserArr2;
            } else if (readTag == 32) {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.startTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.cas = codedInputByteBufferNano.readInt32();
            } else if (readTag == 56) {
                this.timeLimit = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.punishTopic = codedInputByteBufferNano.readString();
            }
        }
    }
}
