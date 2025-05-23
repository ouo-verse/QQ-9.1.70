package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PlayerInfo extends ExtendableMessageNano<PlayerInfo> {
    private static volatile PlayerInfo[] _emptyArray;
    public int gender;
    public String icon;
    public String nick;
    public int score;
    public long uid;

    public PlayerInfo() {
        clear();
    }

    public static PlayerInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PlayerInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PlayerInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PlayerInfo) MessageNano.mergeFrom(new PlayerInfo(), bArr);
    }

    public PlayerInfo clear() {
        this.uid = 0L;
        this.nick = "";
        this.icon = "";
        this.score = 0;
        this.gender = 0;
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
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.nick);
        }
        if (!this.icon.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.icon);
        }
        int i3 = this.score;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.gender;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.nick);
        }
        if (!this.icon.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.icon);
        }
        int i3 = this.score;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.gender;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PlayerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PlayerInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PlayerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.nick = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.icon = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.score = codedInputByteBufferNano.readInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.gender = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
