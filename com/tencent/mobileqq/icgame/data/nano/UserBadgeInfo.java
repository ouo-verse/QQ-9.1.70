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
public final class UserBadgeInfo extends ExtendableMessageNano<UserBadgeInfo> {
    private static volatile UserBadgeInfo[] _emptyArray;
    public int badgeId;
    public int badgeLevel;
    public int badgeScore;
    public String badgeTxt;
    public int scoreToNext;
    public int survivalTime;

    public UserBadgeInfo() {
        clear();
    }

    public static UserBadgeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserBadgeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserBadgeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserBadgeInfo) MessageNano.mergeFrom(new UserBadgeInfo(), bArr);
    }

    public UserBadgeInfo clear() {
        this.badgeId = 0;
        this.badgeLevel = 0;
        this.badgeTxt = "";
        this.scoreToNext = 0;
        this.survivalTime = 0;
        this.badgeScore = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.badgeId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.badgeLevel;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.badgeTxt.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.badgeTxt);
        }
        int i17 = this.scoreToNext;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        int i18 = this.survivalTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.badgeScore;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.badgeId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.badgeLevel;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.badgeTxt.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.badgeTxt);
        }
        int i17 = this.scoreToNext;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        int i18 = this.survivalTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.badgeScore;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserBadgeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserBadgeInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserBadgeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.badgeId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.badgeLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 74) {
                this.badgeTxt = codedInputByteBufferNano.readString();
            } else if (readTag == 80) {
                this.scoreToNext = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 88) {
                this.survivalTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 96) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.badgeScore = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
