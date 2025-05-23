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
public final class BaseUserStatus extends ExtendableMessageNano<BaseUserStatus> {
    private static volatile BaseUserStatus[] _emptyArray;
    public int cas;
    public String city;

    /* renamed from: ip, reason: collision with root package name */
    public String f237273ip;
    public int lastTimestamp;
    public int loginTimestamp;
    public int onStageTimestamp;
    public String province;
    public int roomId;
    public int seatType;
    public String sessionId;
    public long uid;
    public long uin;

    public BaseUserStatus() {
        clear();
    }

    public static BaseUserStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BaseUserStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BaseUserStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BaseUserStatus) MessageNano.mergeFrom(new BaseUserStatus(), bArr);
    }

    public BaseUserStatus clear() {
        this.uid = 0L;
        this.sessionId = "";
        this.roomId = 0;
        this.seatType = 0;
        this.loginTimestamp = 0;
        this.lastTimestamp = 0;
        this.uin = 0L;
        this.cas = 0;
        this.province = "";
        this.city = "";
        this.f237273ip = "";
        this.onStageTimestamp = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        if (!this.sessionId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
        }
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.seatType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        int i17 = this.loginTimestamp;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.lastTimestamp;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        int i19 = this.cas;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i19);
        }
        if (!this.province.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.province);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.city);
        }
        if (!this.f237273ip.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f237273ip);
        }
        int i26 = this.onStageTimestamp;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        if (!this.sessionId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.sessionId);
        }
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.seatType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        int i17 = this.loginTimestamp;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.lastTimestamp;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        int i19 = this.cas;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i19);
        }
        if (!this.province.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.province);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.city);
        }
        if (!this.f237273ip.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f237273ip);
        }
        int i26 = this.onStageTimestamp;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BaseUserStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BaseUserStatus().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BaseUserStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.sessionId = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.seatType = readInt32;
                            break;
                    }
                case 40:
                    this.loginTimestamp = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.lastTimestamp = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.cas = codedInputByteBufferNano.readInt32();
                    break;
                case 74:
                    this.province = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.city = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f237273ip = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.onStageTimestamp = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
