package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddScorePushInfo extends ExtendableMessageNano<AddScorePushInfo> {
    private static volatile AddScorePushInfo[] _emptyArray;
    public String answer;
    public UserInfo audienceInfo;
    public int originalScore;
    public int score;
    public int totalScore;
    public int type;
    public UserInfo vipInfo;

    public AddScorePushInfo() {
        clear();
    }

    public static AddScorePushInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddScorePushInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddScorePushInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddScorePushInfo) MessageNano.mergeFrom(new AddScorePushInfo(), bArr);
    }

    public AddScorePushInfo clear() {
        this.vipInfo = null;
        this.audienceInfo = null;
        this.score = 0;
        this.type = 0;
        this.answer = "";
        this.totalScore = 0;
        this.originalScore = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserInfo userInfo = this.vipInfo;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        UserInfo userInfo2 = this.audienceInfo;
        if (userInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo2);
        }
        int i3 = this.score;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.type;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.answer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.answer);
        }
        int i17 = this.totalScore;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.originalScore;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserInfo userInfo = this.vipInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        UserInfo userInfo2 = this.audienceInfo;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo2);
        }
        int i3 = this.score;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.type;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.answer.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.answer);
        }
        int i17 = this.totalScore;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.originalScore;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddScorePushInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddScorePushInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddScorePushInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.vipInfo == null) {
                    this.vipInfo = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.vipInfo);
            } else if (readTag == 18) {
                if (this.audienceInfo == null) {
                    this.audienceInfo = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.audienceInfo);
            } else if (readTag == 24) {
                this.score = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.answer = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.totalScore = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.originalScore = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
