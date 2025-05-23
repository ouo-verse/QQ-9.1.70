package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AuctionInfoPush extends ExtendableMessageNano<AuctionInfoPush> {
    private static volatile AuctionInfoPush[] _emptyArray;
    public AuctionBasicInfo auctionInfo;
    public int roomId;

    public AuctionInfoPush() {
        clear();
    }

    public static AuctionInfoPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuctionInfoPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AuctionInfoPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AuctionInfoPush) MessageNano.mergeFrom(new AuctionInfoPush(), bArr);
    }

    public AuctionInfoPush clear() {
        this.roomId = 0;
        this.auctionInfo = null;
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
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, auctionBasicInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, auctionBasicInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AuctionInfoPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AuctionInfoPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AuctionInfoPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.auctionInfo == null) {
                    this.auctionInfo = new AuctionBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.auctionInfo);
            }
        }
    }
}
