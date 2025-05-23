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
public final class RoomHostInfo extends ExtendableMessageNano<RoomHostInfo> {
    private static volatile RoomHostInfo[] _emptyArray;
    public String hostAvatar;
    public int hostGender;
    public String hostName;
    public long hostUid;
    public int roomId;

    public RoomHostInfo() {
        clear();
    }

    public static RoomHostInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomHostInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomHostInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomHostInfo) MessageNano.mergeFrom(new RoomHostInfo(), bArr);
    }

    public RoomHostInfo clear() {
        this.roomId = 0;
        this.hostUid = 0L;
        this.hostName = "";
        this.hostAvatar = "";
        this.hostGender = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        long j3 = this.hostUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.hostName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.hostName);
        }
        if (!this.hostAvatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.hostAvatar);
        }
        int i3 = this.hostGender;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        long j3 = this.hostUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.hostName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.hostName);
        }
        if (!this.hostAvatar.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.hostAvatar);
        }
        int i3 = this.hostGender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomHostInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomHostInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomHostInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.hostUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.hostName = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.hostAvatar = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.hostGender = readInt32;
                }
            }
        }
    }
}
