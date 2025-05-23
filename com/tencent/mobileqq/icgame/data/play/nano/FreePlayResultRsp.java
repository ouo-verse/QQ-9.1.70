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
public final class FreePlayResultRsp extends ExtendableMessageNano<FreePlayResultRsp> {
    private static volatile FreePlayResultRsp[] _emptyArray;
    public long bestPlayer;
    public TeamMember[] loser;
    public int mvpLevel;
    public long mvpUid;
    public int result;
    public TeamMember[] winner;

    /* loaded from: classes15.dex */
    public static final class TeamMember extends ExtendableMessageNano<TeamMember> {
        private static volatile TeamMember[] _emptyArray;
        public int score;
        public long uid;

        public TeamMember() {
            clear();
        }

        public static TeamMember[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TeamMember[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static TeamMember parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (TeamMember) MessageNano.mergeFrom(new TeamMember(), bArr);
        }

        public TeamMember clear() {
            this.uid = 0L;
            this.score = 0;
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
            int i3 = this.score;
            if (i3 != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j3 = this.uid;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j3);
            }
            int i3 = this.score;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static TeamMember parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new TeamMember().mergeFrom(codedInputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public TeamMember mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.uid = codedInputByteBufferNano.readUInt64();
                } else if (readTag != 16) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.score = codedInputByteBufferNano.readUInt32();
                }
            }
        }
    }

    public FreePlayResultRsp() {
        clear();
    }

    public static FreePlayResultRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayResultRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayResultRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayResultRsp) MessageNano.mergeFrom(new FreePlayResultRsp(), bArr);
    }

    public FreePlayResultRsp clear() {
        this.result = 0;
        this.winner = TeamMember.emptyArray();
        this.loser = TeamMember.emptyArray();
        this.mvpUid = 0L;
        this.mvpLevel = 0;
        this.bestPlayer = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        TeamMember[] teamMemberArr = this.winner;
        int i16 = 0;
        if (teamMemberArr != null && teamMemberArr.length > 0) {
            int i17 = 0;
            while (true) {
                TeamMember[] teamMemberArr2 = this.winner;
                if (i17 >= teamMemberArr2.length) {
                    break;
                }
                TeamMember teamMember = teamMemberArr2[i17];
                if (teamMember != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, teamMember);
                }
                i17++;
            }
        }
        TeamMember[] teamMemberArr3 = this.loser;
        if (teamMemberArr3 != null && teamMemberArr3.length > 0) {
            while (true) {
                TeamMember[] teamMemberArr4 = this.loser;
                if (i16 >= teamMemberArr4.length) {
                    break;
                }
                TeamMember teamMember2 = teamMemberArr4[i16];
                if (teamMember2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, teamMember2);
                }
                i16++;
            }
        }
        long j3 = this.mvpUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        int i18 = this.mvpLevel;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        long j16 = this.bestPlayer;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        TeamMember[] teamMemberArr = this.winner;
        int i16 = 0;
        if (teamMemberArr != null && teamMemberArr.length > 0) {
            int i17 = 0;
            while (true) {
                TeamMember[] teamMemberArr2 = this.winner;
                if (i17 >= teamMemberArr2.length) {
                    break;
                }
                TeamMember teamMember = teamMemberArr2[i17];
                if (teamMember != null) {
                    codedOutputByteBufferNano.writeMessage(2, teamMember);
                }
                i17++;
            }
        }
        TeamMember[] teamMemberArr3 = this.loser;
        if (teamMemberArr3 != null && teamMemberArr3.length > 0) {
            while (true) {
                TeamMember[] teamMemberArr4 = this.loser;
                if (i16 >= teamMemberArr4.length) {
                    break;
                }
                TeamMember teamMember2 = teamMemberArr4[i16];
                if (teamMember2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, teamMember2);
                }
                i16++;
            }
        }
        long j3 = this.mvpUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        int i18 = this.mvpLevel;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        long j16 = this.bestPlayer;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayResultRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayResultRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayResultRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                TeamMember[] teamMemberArr = this.winner;
                int length = teamMemberArr == null ? 0 : teamMemberArr.length;
                int i3 = repeatedFieldArrayLength + length;
                TeamMember[] teamMemberArr2 = new TeamMember[i3];
                if (length != 0) {
                    System.arraycopy(teamMemberArr, 0, teamMemberArr2, 0, length);
                }
                while (length < i3 - 1) {
                    TeamMember teamMember = new TeamMember();
                    teamMemberArr2[length] = teamMember;
                    codedInputByteBufferNano.readMessage(teamMember);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                TeamMember teamMember2 = new TeamMember();
                teamMemberArr2[length] = teamMember2;
                codedInputByteBufferNano.readMessage(teamMember2);
                this.winner = teamMemberArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                TeamMember[] teamMemberArr3 = this.loser;
                int length2 = teamMemberArr3 == null ? 0 : teamMemberArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                TeamMember[] teamMemberArr4 = new TeamMember[i16];
                if (length2 != 0) {
                    System.arraycopy(teamMemberArr3, 0, teamMemberArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    TeamMember teamMember3 = new TeamMember();
                    teamMemberArr4[length2] = teamMember3;
                    codedInputByteBufferNano.readMessage(teamMember3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                TeamMember teamMember4 = new TeamMember();
                teamMemberArr4[length2] = teamMember4;
                codedInputByteBufferNano.readMessage(teamMember4);
                this.loser = teamMemberArr4;
            } else if (readTag == 32) {
                this.mvpUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.mvpLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.bestPlayer = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
