package com.tencent.mobileqq.icgame.data.switchroom.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RoomInfo extends ExtendableMessageNano<RoomInfo> {
    private static volatile RoomInfo[] _emptyArray;
    public String backgroundPic;
    public long roomId;

    public RoomInfo() {
        clear();
    }

    public static RoomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomInfo) MessageNano.mergeFrom(new RoomInfo(), bArr);
    }

    public RoomInfo clear() {
        this.roomId = 0L;
        this.backgroundPic = "";
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
        if (!this.backgroundPic.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.backgroundPic);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.backgroundPic.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.backgroundPic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.backgroundPic = codedInputByteBufferNano.readString();
            }
        }
    }
}
