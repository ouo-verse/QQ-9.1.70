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
public final class ExtendUserInfo extends ExtendableMessageNano<ExtendUserInfo> {
    private static volatile ExtendUserInfo[] _emptyArray;
    public long charm;
    public long fansCount;
    public long popularity;
    public int subscribeCount;
    public int subscribeState;
    public long uid;
    public UserExpLev userExpLev;
    public NobilityAllInfo userNobility;
    public UserVoiceCover userVoiceCover;

    public ExtendUserInfo() {
        clear();
    }

    public static ExtendUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExtendUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExtendUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExtendUserInfo) MessageNano.mergeFrom(new ExtendUserInfo(), bArr);
    }

    public ExtendUserInfo clear() {
        this.uid = 0L;
        this.charm = 0L;
        this.popularity = 0L;
        this.fansCount = 0L;
        this.subscribeCount = 0;
        this.subscribeState = 999;
        this.userVoiceCover = null;
        this.userExpLev = null;
        this.userNobility = null;
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
        long j16 = this.charm;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.popularity;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.fansCount;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        int i3 = this.subscribeCount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.subscribeState;
        if (i16 != 999) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, userVoiceCover);
        }
        UserExpLev userExpLev = this.userExpLev;
        if (userExpLev != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, userExpLev);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, nobilityAllInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.charm;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.popularity;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.fansCount;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        int i3 = this.subscribeCount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.subscribeState;
        if (i16 != 999) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            codedOutputByteBufferNano.writeMessage(7, userVoiceCover);
        }
        UserExpLev userExpLev = this.userExpLev;
        if (userExpLev != null) {
            codedOutputByteBufferNano.writeMessage(9, userExpLev);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            codedOutputByteBufferNano.writeMessage(10, nobilityAllInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ExtendUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExtendUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExtendUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.charm = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.popularity = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.fansCount = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.subscribeCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.subscribeState = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                if (this.userVoiceCover == null) {
                    this.userVoiceCover = new UserVoiceCover();
                }
                codedInputByteBufferNano.readMessage(this.userVoiceCover);
            } else if (readTag == 74) {
                if (this.userExpLev == null) {
                    this.userExpLev = new UserExpLev();
                }
                codedInputByteBufferNano.readMessage(this.userExpLev);
            } else if (readTag != 82) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.userNobility == null) {
                    this.userNobility = new NobilityAllInfo();
                }
                codedInputByteBufferNano.readMessage(this.userNobility);
            }
        }
    }
}
