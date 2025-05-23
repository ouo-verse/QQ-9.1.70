package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.icgame.data.nano.SeqInfo;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes15.dex */
public final class PrefetchEnterRoomInfoRsp extends ExtendableMessageNano<PrefetchEnterRoomInfoRsp> {
    private static volatile PrefetchEnterRoomInfoRsp[] _emptyArray;
    public byte[] avAuthKey;
    public int memberCount;
    public int roomId;
    public SeqInfo stageInfo;

    public PrefetchEnterRoomInfoRsp() {
        clear();
    }

    public static PrefetchEnterRoomInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PrefetchEnterRoomInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PrefetchEnterRoomInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PrefetchEnterRoomInfoRsp) MessageNano.mergeFrom(new PrefetchEnterRoomInfoRsp(), bArr);
    }

    public PrefetchEnterRoomInfoRsp clear() {
        this.roomId = 0;
        this.stageInfo = null;
        this.avAuthKey = WireFormatNano.EMPTY_BYTES;
        this.memberCount = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        SeqInfo seqInfo = this.stageInfo;
        if (seqInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, seqInfo);
        }
        if (!Arrays.equals(this.avAuthKey, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.avAuthKey);
        }
        int i16 = this.memberCount;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        SeqInfo seqInfo = this.stageInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, seqInfo);
        }
        if (!Arrays.equals(this.avAuthKey, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.avAuthKey);
        }
        int i16 = this.memberCount;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PrefetchEnterRoomInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PrefetchEnterRoomInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PrefetchEnterRoomInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.stageInfo == null) {
                    this.stageInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.stageInfo);
            } else if (readTag == 26) {
                this.avAuthKey = codedInputByteBufferNano.readBytes();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.memberCount = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
