package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AchieveTaskPushInfo extends ExtendableMessageNano<AchieveTaskPushInfo> {
    private static volatile AchieveTaskPushInfo[] _emptyArray;
    public String animType;
    public String animUrl;
    public String jumpUrl;
    public long roomId;
    public int starLevel;

    public AchieveTaskPushInfo() {
        clear();
    }

    public static AchieveTaskPushInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AchieveTaskPushInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AchieveTaskPushInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AchieveTaskPushInfo) MessageNano.mergeFrom(new AchieveTaskPushInfo(), bArr);
    }

    public AchieveTaskPushInfo clear() {
        this.starLevel = 0;
        this.animUrl = "";
        this.animType = "";
        this.jumpUrl = "";
        this.roomId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.starLevel;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.animUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.animUrl);
        }
        if (!this.animType.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.animType);
        }
        if (!this.jumpUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jumpUrl);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.starLevel;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.animUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.animUrl);
        }
        if (!this.animType.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.animType);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.jumpUrl);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AchieveTaskPushInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AchieveTaskPushInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AchieveTaskPushInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.starLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.animUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.animType = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.jumpUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
