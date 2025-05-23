package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MemberInfo extends ExtendableMessageNano<MemberInfo> {
    private static volatile MemberInfo[] _emptyArray;
    public int anchorType;
    public String avatar;
    public int enterTime;
    public int gender;
    public God god;
    public int infoType;
    public int isRobot;
    public ManagerInfo managerInfo;
    public String name;
    public long score;
    public long uid;
    public long uin;
    public NobilityAllInfo userNobility;

    public MemberInfo() {
        clear();
    }

    public static MemberInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MemberInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MemberInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MemberInfo) MessageNano.mergeFrom(new MemberInfo(), bArr);
    }

    public MemberInfo clear() {
        this.uid = 0L;
        this.name = "";
        this.gender = 0;
        this.avatar = "";
        this.managerInfo = null;
        this.anchorType = 0;
        this.god = null;
        this.userNobility = null;
        this.enterTime = 0;
        this.score = 0L;
        this.uin = 0L;
        this.infoType = 0;
        this.isRobot = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.avatar);
        }
        ManagerInfo managerInfo = this.managerInfo;
        if (managerInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, managerInfo);
        }
        int i16 = this.anchorType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        God god = this.god;
        if (god != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, god);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, nobilityAllInfo);
        }
        int i17 = this.enterTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i17);
        }
        long j3 = this.score;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j3);
        }
        long j16 = this.uin;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(18, j16);
        }
        int i18 = this.infoType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(19, i18);
        }
        int i19 = this.isRobot;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(20, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.avatar);
        }
        ManagerInfo managerInfo = this.managerInfo;
        if (managerInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, managerInfo);
        }
        int i16 = this.anchorType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        God god = this.god;
        if (god != null) {
            codedOutputByteBufferNano.writeMessage(8, god);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, nobilityAllInfo);
        }
        int i17 = this.enterTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i17);
        }
        long j3 = this.score;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(17, j3);
        }
        long j16 = this.uin;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j16);
        }
        int i18 = this.infoType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(19, i18);
        }
        int i19 = this.isRobot;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(20, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MemberInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MemberInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MemberInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.gender = readInt32;
                        break;
                    }
                case 34:
                    this.avatar = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    if (this.managerInfo == null) {
                        this.managerInfo = new ManagerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.managerInfo);
                    break;
                case 48:
                    this.anchorType = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    if (this.god == null) {
                        this.god = new God();
                    }
                    codedInputByteBufferNano.readMessage(this.god);
                    break;
                case 74:
                    if (this.userNobility == null) {
                        this.userNobility = new NobilityAllInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userNobility);
                    break;
                case 104:
                    this.enterTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.score = codedInputByteBufferNano.readUInt64();
                    break;
                case 144:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 152:
                    this.infoType = codedInputByteBufferNano.readUInt32();
                    break;
                case 160:
                    this.isRobot = codedInputByteBufferNano.readUInt32();
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
