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
public final class MeleeBasicInfo extends ExtendableMessageNano<MeleeBasicInfo> {
    private static volatile MeleeBasicInfo[] _emptyArray;
    public int cas;
    public int meleeBasicinfoSeq;
    public String punishTopic;
    public int stage;
    public long startSeq;
    public int startTime;
    public int timeLimit;
    public MeleeVipUser[] vipUsers;

    public MeleeBasicInfo() {
        clear();
    }

    public static MeleeBasicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeBasicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeBasicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeBasicInfo) MessageNano.mergeFrom(new MeleeBasicInfo(), bArr);
    }

    public MeleeBasicInfo clear() {
        this.meleeBasicinfoSeq = 0;
        this.stage = 0;
        this.vipUsers = MeleeVipUser.emptyArray();
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
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.meleeBasicinfoSeq);
        int i3 = this.stage;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        MeleeVipUser[] meleeVipUserArr = this.vipUsers;
        if (meleeVipUserArr != null && meleeVipUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                MeleeVipUser[] meleeVipUserArr2 = this.vipUsers;
                if (i16 >= meleeVipUserArr2.length) {
                    break;
                }
                MeleeVipUser meleeVipUser = meleeVipUserArr2[i16];
                if (meleeVipUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, meleeVipUser);
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
        codedOutputByteBufferNano.writeUInt32(1, this.meleeBasicinfoSeq);
        int i3 = this.stage;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        MeleeVipUser[] meleeVipUserArr = this.vipUsers;
        if (meleeVipUserArr != null && meleeVipUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                MeleeVipUser[] meleeVipUserArr2 = this.vipUsers;
                if (i16 >= meleeVipUserArr2.length) {
                    break;
                }
                MeleeVipUser meleeVipUser = meleeVipUserArr2[i16];
                if (meleeVipUser != null) {
                    codedOutputByteBufferNano.writeMessage(3, meleeVipUser);
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

    public static MeleeBasicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeBasicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeBasicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.meleeBasicinfoSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.stage = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                MeleeVipUser[] meleeVipUserArr = this.vipUsers;
                int length = meleeVipUserArr == null ? 0 : meleeVipUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                MeleeVipUser[] meleeVipUserArr2 = new MeleeVipUser[i3];
                if (length != 0) {
                    System.arraycopy(meleeVipUserArr, 0, meleeVipUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    MeleeVipUser meleeVipUser = new MeleeVipUser();
                    meleeVipUserArr2[length] = meleeVipUser;
                    codedInputByteBufferNano.readMessage(meleeVipUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                MeleeVipUser meleeVipUser2 = new MeleeVipUser();
                meleeVipUserArr2[length] = meleeVipUser2;
                codedInputByteBufferNano.readMessage(meleeVipUser2);
                this.vipUsers = meleeVipUserArr2;
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
