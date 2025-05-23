package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UserInfo extends ExtendableMessageNano<UserInfo> {
    private static volatile UserInfo[] _emptyArray;
    public String age;
    public String headImgUrl;
    public LiveStatusInfo liveStatusInfo;
    public int makeFriendMood;
    public String nickName;
    public int sex;
    public int uid;

    public UserInfo() {
        clear();
    }

    public static UserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserInfo) MessageNano.mergeFrom(new UserInfo(), bArr);
    }

    public UserInfo clear() {
        this.uid = 0;
        this.liveStatusInfo = null;
        this.nickName = "";
        this.headImgUrl = "";
        this.age = "";
        this.sex = 0;
        this.makeFriendMood = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.uid;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        LiveStatusInfo liveStatusInfo = this.liveStatusInfo;
        if (liveStatusInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveStatusInfo);
        }
        if (!this.nickName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.nickName);
        }
        if (!this.headImgUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.headImgUrl);
        }
        if (!this.age.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.age);
        }
        int i16 = this.sex;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.makeFriendMood;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.uid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        LiveStatusInfo liveStatusInfo = this.liveStatusInfo;
        if (liveStatusInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, liveStatusInfo);
        }
        if (!this.nickName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.nickName);
        }
        if (!this.headImgUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.headImgUrl);
        }
        if (!this.age.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.age);
        }
        int i16 = this.sex;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.makeFriendMood;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.liveStatusInfo == null) {
                    this.liveStatusInfo = new LiveStatusInfo();
                }
                codedInputByteBufferNano.readMessage(this.liveStatusInfo);
            } else if (readTag == 26) {
                this.nickName = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.headImgUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.age = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.sex = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.makeFriendMood = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
