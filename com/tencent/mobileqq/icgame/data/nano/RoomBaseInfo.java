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
public final class RoomBaseInfo extends ExtendableMessageNano<RoomBaseInfo> {
    private static volatile RoomBaseInfo[] _emptyArray;
    public String avRoomId;
    public String chatRoomId;
    public int ctime;
    public long groupCode;
    public String logo;
    public int mtime;
    public long ownerUin;
    public String pic;
    public int roomId;
    public String roomName;
    public int roomNo;
    public int roomRawNo;
    public int roomType;

    public RoomBaseInfo() {
        clear();
    }

    public static RoomBaseInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomBaseInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomBaseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomBaseInfo) MessageNano.mergeFrom(new RoomBaseInfo(), bArr);
    }

    public RoomBaseInfo clear() {
        this.roomId = 0;
        this.roomName = "";
        this.chatRoomId = "";
        this.logo = "";
        this.pic = "";
        this.ownerUin = 0L;
        this.roomNo = 0;
        this.roomRawNo = 0;
        this.groupCode = 0L;
        this.roomType = 0;
        this.ctime = 0;
        this.mtime = 0;
        this.avRoomId = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        if (!this.roomName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomName);
        }
        if (!this.chatRoomId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.chatRoomId);
        }
        if (!this.logo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.logo);
        }
        if (!this.pic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.pic);
        }
        long j3 = this.ownerUin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        int i3 = this.roomNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i16 = this.roomRawNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        long j16 = this.groupCode;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j16);
        }
        int i17 = this.roomType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        int i18 = this.ctime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.mtime;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        if (!this.avRoomId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.avRoomId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        if (!this.roomName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomName);
        }
        if (!this.chatRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.chatRoomId);
        }
        if (!this.logo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.logo);
        }
        if (!this.pic.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.pic);
        }
        long j3 = this.ownerUin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        int i3 = this.roomNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i16 = this.roomRawNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        long j16 = this.groupCode;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j16);
        }
        int i17 = this.roomType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        int i18 = this.ctime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.mtime;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        if (!this.avRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.avRoomId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomBaseInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomBaseInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomBaseInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.roomName = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.chatRoomId = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.logo = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.pic = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.ownerUin = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.roomNo = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.roomRawNo = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.groupCode = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.roomType = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.ctime = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.mtime = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.avRoomId = codedInputByteBufferNano.readString();
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
