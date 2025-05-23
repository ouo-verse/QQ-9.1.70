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
public final class GroupRoomInfo extends ExtendableMessageNano<GroupRoomInfo> {
    private static volatile GroupRoomInfo[] _emptyArray;
    public int gameId;
    public long roomId;
    public String roomName;
    public String roomPic;

    public GroupRoomInfo() {
        clear();
    }

    public static GroupRoomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GroupRoomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GroupRoomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GroupRoomInfo) MessageNano.mergeFrom(new GroupRoomInfo(), bArr);
    }

    public GroupRoomInfo clear() {
        this.roomId = 0L;
        this.roomName = "";
        this.roomPic = "";
        this.gameId = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.roomName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomName);
        }
        if (!this.roomPic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.roomPic);
        }
        int i3 = this.gameId;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.roomName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomName);
        }
        if (!this.roomPic.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.roomPic);
        }
        int i3 = this.gameId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GroupRoomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GroupRoomInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GroupRoomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.roomName = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.roomPic = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.gameId = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
