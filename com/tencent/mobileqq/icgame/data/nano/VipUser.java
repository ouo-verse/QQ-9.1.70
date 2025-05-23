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
public final class VipUser extends ExtendableMessageNano<VipUser> {
    private static volatile VipUser[] _emptyArray;
    public String avAuthKey;
    public int datingLevel;
    public int datingLevelNew;
    public int datingLevelToNext;
    public long loveUid;
    public boolean micStatus;
    public int seatNo;
    public int seatType;
    public int swfId;
    public long uid;
    public boolean videoStatus;

    public VipUser() {
        clear();
    }

    public static VipUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VipUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static VipUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (VipUser) MessageNano.mergeFrom(new VipUser(), bArr);
    }

    public VipUser clear() {
        this.seatType = 0;
        this.seatNo = 0;
        this.uid = 0L;
        this.micStatus = false;
        this.videoStatus = false;
        this.loveUid = 0L;
        this.datingLevel = 0;
        this.swfId = 1;
        this.datingLevelNew = 0;
        this.avAuthKey = "";
        this.datingLevelToNext = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        boolean z16 = this.micStatus;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        boolean z17 = this.videoStatus;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z17);
        }
        long j16 = this.loveUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i17 = this.datingLevel;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.swfId;
        if (i18 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        int i19 = this.datingLevelNew;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        if (!this.avAuthKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.avAuthKey);
        }
        int i26 = this.datingLevelToNext;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        boolean z16 = this.micStatus;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        boolean z17 = this.videoStatus;
        if (z17) {
            codedOutputByteBufferNano.writeBool(5, z17);
        }
        long j16 = this.loveUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i17 = this.datingLevel;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.swfId;
        if (i18 != 1) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        int i19 = this.datingLevelNew;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        if (!this.avAuthKey.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.avAuthKey);
        }
        int i26 = this.datingLevelToNext;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static VipUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new VipUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public VipUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
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
                case 16:
                    this.seatNo = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.micStatus = codedInputByteBufferNano.readBool();
                    break;
                case 40:
                    this.videoStatus = codedInputByteBufferNano.readBool();
                    break;
                case 48:
                    this.loveUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.datingLevel = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.swfId = readInt322;
                        break;
                    }
                case 72:
                    this.datingLevelNew = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.avAuthKey = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.datingLevelToNext = codedInputByteBufferNano.readUInt32();
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
