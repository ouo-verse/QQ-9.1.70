package com.tencent.mobileqq.icgame.data.punish.nano;

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
public final class ForbidReq extends ExtendableMessageNano<ForbidReq> {
    private static volatile ForbidReq[] _emptyArray;
    public byte[] reason;
    public int roomId;
    public int time;
    public int type;
    public long uid;
    public byte[] windowTips;

    public ForbidReq() {
        clear();
    }

    public static ForbidReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ForbidReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ForbidReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ForbidReq) MessageNano.mergeFrom(new ForbidReq(), bArr);
    }

    public ForbidReq clear() {
        this.type = 0;
        this.uid = 0L;
        this.roomId = 0;
        this.time = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.reason = bArr;
        this.windowTips = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.type) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid);
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.time;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        byte[] bArr = this.reason;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.reason);
        }
        if (!Arrays.equals(this.windowTips, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(6, this.windowTips);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.type);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.time;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        byte[] bArr = this.reason;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.reason);
        }
        if (!Arrays.equals(this.windowTips, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.windowTips);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ForbidReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ForbidReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ForbidReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.time = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.reason = codedInputByteBufferNano.readBytes();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.windowTips = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
