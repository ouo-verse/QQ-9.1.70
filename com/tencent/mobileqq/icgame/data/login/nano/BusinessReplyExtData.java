package com.tencent.mobileqq.icgame.data.login.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class BusinessReplyExtData extends ExtendableMessageNano<BusinessReplyExtData> {
    private static volatile BusinessReplyExtData[] _emptyArray;
    public ReplyCommonConfigInfo commonConfig;
    public String oaid;
    public int retCode;
    public String retMsg;
    public ReplySplashScreenConfig splashConfig;
    public long svrUtcTime;
    public UpgradeInfo upgradeInfo;
    public UserInfo userInfo;

    public BusinessReplyExtData() {
        clear();
    }

    public static BusinessReplyExtData[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BusinessReplyExtData[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BusinessReplyExtData parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BusinessReplyExtData) MessageNano.mergeFrom(new BusinessReplyExtData(), bArr);
    }

    public BusinessReplyExtData clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.svrUtcTime = 0L;
        this.userInfo = null;
        this.upgradeInfo = null;
        this.splashConfig = null;
        this.commonConfig = null;
        this.oaid = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        long j3 = this.svrUtcTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
        }
        UpgradeInfo upgradeInfo = this.upgradeInfo;
        if (upgradeInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, upgradeInfo);
        }
        ReplySplashScreenConfig replySplashScreenConfig = this.splashConfig;
        if (replySplashScreenConfig != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, replySplashScreenConfig);
        }
        ReplyCommonConfigInfo replyCommonConfigInfo = this.commonConfig;
        if (replyCommonConfigInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, replyCommonConfigInfo);
        }
        if (!this.oaid.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.oaid);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        long j3 = this.svrUtcTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo);
        }
        UpgradeInfo upgradeInfo = this.upgradeInfo;
        if (upgradeInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, upgradeInfo);
        }
        ReplySplashScreenConfig replySplashScreenConfig = this.splashConfig;
        if (replySplashScreenConfig != null) {
            codedOutputByteBufferNano.writeMessage(6, replySplashScreenConfig);
        }
        ReplyCommonConfigInfo replyCommonConfigInfo = this.commonConfig;
        if (replyCommonConfigInfo != null) {
            codedOutputByteBufferNano.writeMessage(7, replyCommonConfigInfo);
        }
        if (!this.oaid.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.oaid);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BusinessReplyExtData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BusinessReplyExtData().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BusinessReplyExtData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.svrUtcTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (readTag == 42) {
                if (this.upgradeInfo == null) {
                    this.upgradeInfo = new UpgradeInfo();
                }
                codedInputByteBufferNano.readMessage(this.upgradeInfo);
            } else if (readTag == 50) {
                if (this.splashConfig == null) {
                    this.splashConfig = new ReplySplashScreenConfig();
                }
                codedInputByteBufferNano.readMessage(this.splashConfig);
            } else if (readTag == 58) {
                if (this.commonConfig == null) {
                    this.commonConfig = new ReplyCommonConfigInfo();
                }
                codedInputByteBufferNano.readMessage(this.commonConfig);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.oaid = codedInputByteBufferNano.readString();
            }
        }
    }
}
