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
public final class LoginCheckRsp extends ExtendableMessageNano<LoginCheckRsp> {
    private static volatile LoginCheckRsp[] _emptyArray;
    public boolean enableReport;
    public boolean isNeedInit;
    public boolean isNewUser;
    public int result;
    public long serverTime;
    public long uid;
    public long uin;
    public String userName;
    public String userSig;

    public LoginCheckRsp() {
        clear();
    }

    public static LoginCheckRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LoginCheckRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LoginCheckRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LoginCheckRsp) MessageNano.mergeFrom(new LoginCheckRsp(), bArr);
    }

    public LoginCheckRsp clear() {
        this.result = 0;
        this.userName = "";
        this.uin = 0L;
        this.userSig = "";
        this.uid = 0L;
        this.enableReport = false;
        this.isNeedInit = false;
        this.serverTime = 0L;
        this.isNewUser = false;
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
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.userName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.userName);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        if (!this.userSig.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.userSig);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        boolean z16 = this.enableReport;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        boolean z17 = this.isNeedInit;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z17);
        }
        long j17 = this.serverTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        boolean z18 = this.isNewUser;
        if (z18) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(9, z18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.userName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.userName);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        if (!this.userSig.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.userSig);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        boolean z16 = this.enableReport;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        boolean z17 = this.isNeedInit;
        if (z17) {
            codedOutputByteBufferNano.writeBool(7, z17);
        }
        long j17 = this.serverTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        boolean z18 = this.isNewUser;
        if (z18) {
            codedOutputByteBufferNano.writeBool(9, z18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LoginCheckRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LoginCheckRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LoginCheckRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.userName = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.uin = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                this.userSig = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.enableReport = codedInputByteBufferNano.readBool();
            } else if (readTag == 56) {
                this.isNeedInit = codedInputByteBufferNano.readBool();
            } else if (readTag == 64) {
                this.serverTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isNewUser = codedInputByteBufferNano.readBool();
            }
        }
    }
}
