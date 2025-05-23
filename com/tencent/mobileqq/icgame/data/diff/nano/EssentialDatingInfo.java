package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.icgame.data.nano.VipUser;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EssentialDatingInfo extends ExtendableMessageNano<EssentialDatingInfo> {
    private static volatile EssentialDatingInfo[] _emptyArray;
    public int cas;
    public int datingStage;
    public int essentialDatingInfoSeq;
    public int gameMode;
    public LoveInfo[] loveInfos;
    public ContributionInfo[] manInfos;
    public int memberlistSeq;
    public long startSeq;
    public VipUser[] vipUsers;
    public ContributionInfo[] womanInfos;

    public EssentialDatingInfo() {
        clear();
    }

    public static EssentialDatingInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EssentialDatingInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EssentialDatingInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EssentialDatingInfo) MessageNano.mergeFrom(new EssentialDatingInfo(), bArr);
    }

    public EssentialDatingInfo clear() {
        this.essentialDatingInfoSeq = 0;
        this.datingStage = 0;
        this.vipUsers = VipUser.emptyArray();
        this.cas = 0;
        this.memberlistSeq = 0;
        this.manInfos = ContributionInfo.emptyArray();
        this.womanInfos = ContributionInfo.emptyArray();
        this.gameMode = 0;
        this.startSeq = 0L;
        this.loveInfos = LoveInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.essentialDatingInfoSeq);
        int i3 = this.datingStage;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        VipUser[] vipUserArr = this.vipUsers;
        int i16 = 0;
        if (vipUserArr != null && vipUserArr.length > 0) {
            int i17 = 0;
            while (true) {
                VipUser[] vipUserArr2 = this.vipUsers;
                if (i17 >= vipUserArr2.length) {
                    break;
                }
                VipUser vipUser = vipUserArr2[i17];
                if (vipUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vipUser);
                }
                i17++;
            }
        }
        int i18 = this.cas;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.memberlistSeq;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        ContributionInfo[] contributionInfoArr = this.manInfos;
        if (contributionInfoArr != null && contributionInfoArr.length > 0) {
            int i26 = 0;
            while (true) {
                ContributionInfo[] contributionInfoArr2 = this.manInfos;
                if (i26 >= contributionInfoArr2.length) {
                    break;
                }
                ContributionInfo contributionInfo = contributionInfoArr2[i26];
                if (contributionInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, contributionInfo);
                }
                i26++;
            }
        }
        ContributionInfo[] contributionInfoArr3 = this.womanInfos;
        if (contributionInfoArr3 != null && contributionInfoArr3.length > 0) {
            int i27 = 0;
            while (true) {
                ContributionInfo[] contributionInfoArr4 = this.womanInfos;
                if (i27 >= contributionInfoArr4.length) {
                    break;
                }
                ContributionInfo contributionInfo2 = contributionInfoArr4[i27];
                if (contributionInfo2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, contributionInfo2);
                }
                i27++;
            }
        }
        int i28 = this.gameMode;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i28);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        LoveInfo[] loveInfoArr = this.loveInfos;
        if (loveInfoArr != null && loveInfoArr.length > 0) {
            while (true) {
                LoveInfo[] loveInfoArr2 = this.loveInfos;
                if (i16 >= loveInfoArr2.length) {
                    break;
                }
                LoveInfo loveInfo = loveInfoArr2[i16];
                if (loveInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, loveInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.essentialDatingInfoSeq);
        int i3 = this.datingStage;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        VipUser[] vipUserArr = this.vipUsers;
        int i16 = 0;
        if (vipUserArr != null && vipUserArr.length > 0) {
            int i17 = 0;
            while (true) {
                VipUser[] vipUserArr2 = this.vipUsers;
                if (i17 >= vipUserArr2.length) {
                    break;
                }
                VipUser vipUser = vipUserArr2[i17];
                if (vipUser != null) {
                    codedOutputByteBufferNano.writeMessage(3, vipUser);
                }
                i17++;
            }
        }
        int i18 = this.cas;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.memberlistSeq;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        ContributionInfo[] contributionInfoArr = this.manInfos;
        if (contributionInfoArr != null && contributionInfoArr.length > 0) {
            int i26 = 0;
            while (true) {
                ContributionInfo[] contributionInfoArr2 = this.manInfos;
                if (i26 >= contributionInfoArr2.length) {
                    break;
                }
                ContributionInfo contributionInfo = contributionInfoArr2[i26];
                if (contributionInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, contributionInfo);
                }
                i26++;
            }
        }
        ContributionInfo[] contributionInfoArr3 = this.womanInfos;
        if (contributionInfoArr3 != null && contributionInfoArr3.length > 0) {
            int i27 = 0;
            while (true) {
                ContributionInfo[] contributionInfoArr4 = this.womanInfos;
                if (i27 >= contributionInfoArr4.length) {
                    break;
                }
                ContributionInfo contributionInfo2 = contributionInfoArr4[i27];
                if (contributionInfo2 != null) {
                    codedOutputByteBufferNano.writeMessage(7, contributionInfo2);
                }
                i27++;
            }
        }
        int i28 = this.gameMode;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i28);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        LoveInfo[] loveInfoArr = this.loveInfos;
        if (loveInfoArr != null && loveInfoArr.length > 0) {
            while (true) {
                LoveInfo[] loveInfoArr2 = this.loveInfos;
                if (i16 >= loveInfoArr2.length) {
                    break;
                }
                LoveInfo loveInfo = loveInfoArr2[i16];
                if (loveInfo != null) {
                    codedOutputByteBufferNano.writeMessage(10, loveInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EssentialDatingInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EssentialDatingInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EssentialDatingInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.essentialDatingInfoSeq = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.datingStage = readInt32;
                        break;
                    }
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    VipUser[] vipUserArr = this.vipUsers;
                    int length = vipUserArr == null ? 0 : vipUserArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    VipUser[] vipUserArr2 = new VipUser[i3];
                    if (length != 0) {
                        System.arraycopy(vipUserArr, 0, vipUserArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        VipUser vipUser = new VipUser();
                        vipUserArr2[length] = vipUser;
                        codedInputByteBufferNano.readMessage(vipUser);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    VipUser vipUser2 = new VipUser();
                    vipUserArr2[length] = vipUser2;
                    codedInputByteBufferNano.readMessage(vipUser2);
                    this.vipUsers = vipUserArr2;
                    break;
                case 32:
                    this.cas = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.memberlistSeq = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    ContributionInfo[] contributionInfoArr = this.manInfos;
                    int length2 = contributionInfoArr == null ? 0 : contributionInfoArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    ContributionInfo[] contributionInfoArr2 = new ContributionInfo[i16];
                    if (length2 != 0) {
                        System.arraycopy(contributionInfoArr, 0, contributionInfoArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        ContributionInfo contributionInfo = new ContributionInfo();
                        contributionInfoArr2[length2] = contributionInfo;
                        codedInputByteBufferNano.readMessage(contributionInfo);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    ContributionInfo contributionInfo2 = new ContributionInfo();
                    contributionInfoArr2[length2] = contributionInfo2;
                    codedInputByteBufferNano.readMessage(contributionInfo2);
                    this.manInfos = contributionInfoArr2;
                    break;
                case 58:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    ContributionInfo[] contributionInfoArr3 = this.womanInfos;
                    int length3 = contributionInfoArr3 == null ? 0 : contributionInfoArr3.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    ContributionInfo[] contributionInfoArr4 = new ContributionInfo[i17];
                    if (length3 != 0) {
                        System.arraycopy(contributionInfoArr3, 0, contributionInfoArr4, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        ContributionInfo contributionInfo3 = new ContributionInfo();
                        contributionInfoArr4[length3] = contributionInfo3;
                        codedInputByteBufferNano.readMessage(contributionInfo3);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    ContributionInfo contributionInfo4 = new ContributionInfo();
                    contributionInfoArr4[length3] = contributionInfo4;
                    codedInputByteBufferNano.readMessage(contributionInfo4);
                    this.womanInfos = contributionInfoArr4;
                    break;
                case 64:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1) {
                        break;
                    } else {
                        this.gameMode = readInt322;
                        break;
                    }
                case 72:
                    this.startSeq = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    LoveInfo[] loveInfoArr = this.loveInfos;
                    int length4 = loveInfoArr == null ? 0 : loveInfoArr.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    LoveInfo[] loveInfoArr2 = new LoveInfo[i18];
                    if (length4 != 0) {
                        System.arraycopy(loveInfoArr, 0, loveInfoArr2, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        LoveInfo loveInfo = new LoveInfo();
                        loveInfoArr2[length4] = loveInfo;
                        codedInputByteBufferNano.readMessage(loveInfo);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    LoveInfo loveInfo2 = new LoveInfo();
                    loveInfoArr2[length4] = loveInfo2;
                    codedInputByteBufferNano.readMessage(loveInfo2);
                    this.loveInfos = loveInfoArr2;
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
