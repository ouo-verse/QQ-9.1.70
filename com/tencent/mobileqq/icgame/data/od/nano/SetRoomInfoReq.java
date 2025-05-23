package com.tencent.mobileqq.icgame.data.od.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetRoomInfoReq extends ExtendableMessageNano<SetRoomInfoReq> {
    private static volatile SetRoomInfoReq[] _emptyArray;
    public byte[] announcement;
    public byte[] coverUrl;
    public int roomId;
    public byte[] roomTag;
    public byte[] topic;

    public SetRoomInfoReq() {
        clear();
    }

    public static SetRoomInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomInfoReq) MessageNano.mergeFrom(new SetRoomInfoReq(), bArr);
    }

    public SetRoomInfoReq clear() {
        this.roomId = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.coverUrl = bArr;
        this.roomTag = bArr;
        this.topic = bArr;
        this.announcement = bArr;
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
        byte[] bArr = this.coverUrl;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.coverUrl);
        }
        if (!Arrays.equals(this.roomTag, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.roomTag);
        }
        if (!Arrays.equals(this.topic, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.topic);
        }
        if (!Arrays.equals(this.announcement, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(5, this.announcement);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        byte[] bArr = this.coverUrl;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.coverUrl);
        }
        if (!Arrays.equals(this.roomTag, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.roomTag);
        }
        if (!Arrays.equals(this.topic, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.topic);
        }
        if (!Arrays.equals(this.announcement, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.announcement);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.coverUrl = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.roomTag = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                this.topic = codedInputByteBufferNano.readBytes();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.announcement = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
