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
public final class HandInHandItem extends ExtendableMessageNano<HandInHandItem> {
    private static volatile HandInHandItem[] _emptyArray;
    public int handTime;
    public int roomId;
    public long uid1;
    public long uid2;
    public String user1Avatar;
    public int user1Gender;
    public String user1Name;
    public String user2Avatar;
    public int user2Gender;
    public String user2Name;

    public HandInHandItem() {
        clear();
    }

    public static HandInHandItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HandInHandItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HandInHandItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HandInHandItem) MessageNano.mergeFrom(new HandInHandItem(), bArr);
    }

    public HandInHandItem clear() {
        this.uid1 = 0L;
        this.uid2 = 0L;
        this.roomId = 0;
        this.handTime = 0;
        this.user1Name = "";
        this.user2Name = "";
        this.user1Avatar = "";
        this.user2Avatar = "";
        this.user1Gender = 0;
        this.user2Gender = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid1;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.uid2;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.handTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.user1Name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.user1Name);
        }
        if (!this.user2Name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.user2Name);
        }
        if (!this.user1Avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.user1Avatar);
        }
        if (!this.user2Avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.user2Avatar);
        }
        int i17 = this.user1Gender;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i17);
        }
        int i18 = this.user2Gender;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(15, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid1;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.uid2;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.handTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.user1Name.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.user1Name);
        }
        if (!this.user2Name.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.user2Name);
        }
        if (!this.user1Avatar.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.user1Avatar);
        }
        if (!this.user2Avatar.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.user2Avatar);
        }
        int i17 = this.user1Gender;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i17);
        }
        int i18 = this.user2Gender;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HandInHandItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HandInHandItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HandInHandItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid1 = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.uid2 = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.handTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.user1Name = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.user2Name = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.user1Avatar = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.user2Avatar = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.user1Gender = readInt32;
                        break;
                    }
                case 120:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.user2Gender = readInt322;
                        break;
                    }
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
