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
public final class UserMeleeRankItem extends ExtendableMessageNano<UserMeleeRankItem> {
    private static volatile UserMeleeRankItem[] _emptyArray;
    public String avatar;
    public int beforeNextLevelScore;
    public int glamour;
    public int isMvp;
    public int isTeamTop;
    public int meleeLevel;
    public int mvpGlamour;
    public String name;
    public long uid;

    public UserMeleeRankItem() {
        clear();
    }

    public static UserMeleeRankItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserMeleeRankItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserMeleeRankItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserMeleeRankItem) MessageNano.mergeFrom(new UserMeleeRankItem(), bArr);
    }

    public UserMeleeRankItem clear() {
        this.uid = 0L;
        this.name = "";
        this.avatar = "";
        this.glamour = 0;
        this.meleeLevel = 0;
        this.beforeNextLevelScore = 0;
        this.isMvp = 0;
        this.isTeamTop = 0;
        this.mvpGlamour = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.avatar);
        }
        int i3 = this.glamour;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.meleeLevel;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.beforeNextLevelScore;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.isMvp;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.isTeamTop;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        int i26 = this.mvpGlamour;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.avatar);
        }
        int i3 = this.glamour;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.meleeLevel;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.beforeNextLevelScore;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.isMvp;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.isTeamTop;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        int i26 = this.mvpGlamour;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserMeleeRankItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserMeleeRankItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserMeleeRankItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.glamour = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.meleeLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.beforeNextLevelScore = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.isMvp = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.isTeamTop = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.mvpGlamour = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
