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
public final class UserScoreItem extends ExtendableMessageNano<UserScoreItem> {
    private static volatile UserScoreItem[] _emptyArray;
    public String avatar;
    public int beforeNextLevelScore;
    public int datingLevelNew;
    public int gender;
    public int glamour;
    public String name;
    public int seatPosition;
    public long uid;
    public int wealth;

    public UserScoreItem() {
        clear();
    }

    public static UserScoreItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserScoreItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserScoreItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserScoreItem) MessageNano.mergeFrom(new UserScoreItem(), bArr);
    }

    public UserScoreItem clear() {
        this.uid = 0L;
        this.name = "";
        this.avatar = "";
        this.gender = 0;
        this.wealth = 0;
        this.glamour = 0;
        this.datingLevelNew = 0;
        this.beforeNextLevelScore = 0;
        this.seatPosition = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid) + CodedOutputByteBufferNano.computeStringSize(2, this.name) + CodedOutputByteBufferNano.computeStringSize(3, this.avatar) + CodedOutputByteBufferNano.computeInt32Size(4, this.gender);
        int i3 = this.wealth;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.glamour;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.datingLevelNew;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.beforeNextLevelScore;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.seatPosition;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        codedOutputByteBufferNano.writeString(2, this.name);
        codedOutputByteBufferNano.writeString(3, this.avatar);
        codedOutputByteBufferNano.writeInt32(4, this.gender);
        int i3 = this.wealth;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.glamour;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.datingLevelNew;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.beforeNextLevelScore;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.seatPosition;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserScoreItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserScoreItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserScoreItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.gender = readInt32;
                }
            } else if (readTag == 40) {
                this.wealth = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.glamour = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.datingLevelNew = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.beforeNextLevelScore = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.seatPosition = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
