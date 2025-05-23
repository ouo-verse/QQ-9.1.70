package com.tencent.mobileqq.icgame.data.meet.nano;

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
    public static final int APP_FRIEND = 1;
    public static final int DEFAULT = 0;
    public static final int QQ_FRIEND = 2;
    private static volatile UserInfo[] _emptyArray;
    public int age;
    public String anchorName;
    public int friendType;
    public String headImgUrl;
    public int isQqUser;
    public long uid;
    public long uin;
    public int userGender;
    public String userLogoUrl;

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
        this.uid = 0L;
        this.headImgUrl = "";
        this.anchorName = "";
        this.friendType = 0;
        this.userLogoUrl = "";
        this.isQqUser = 0;
        this.uin = 0L;
        this.userGender = 0;
        this.age = 0;
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
        if (!this.headImgUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.headImgUrl);
        }
        if (!this.anchorName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.anchorName);
        }
        int i3 = this.friendType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.userLogoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.userLogoUrl);
        }
        int i16 = this.isQqUser;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        long j16 = this.uin;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        int i17 = this.userGender;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i17);
        }
        int i18 = this.age;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.headImgUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.headImgUrl);
        }
        if (!this.anchorName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.anchorName);
        }
        int i3 = this.friendType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.userLogoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.userLogoUrl);
        }
        int i16 = this.isQqUser;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        long j16 = this.uin;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        int i17 = this.userGender;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i17);
        }
        int i18 = this.age;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
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
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.headImgUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.anchorName = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.friendType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                this.userLogoUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.isQqUser = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.uin = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 72) {
                this.userGender = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 80) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.age = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
