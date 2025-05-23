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
public final class EditAuctionRsp extends ExtendableMessageNano<EditAuctionRsp> {
    private static volatile EditAuctionRsp[] _emptyArray;
    public AuctionBasicInfo auctionInfo;
    public String detail;
    public int result;

    public EditAuctionRsp() {
        clear();
    }

    public static EditAuctionRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditAuctionRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditAuctionRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditAuctionRsp) MessageNano.mergeFrom(new EditAuctionRsp(), bArr);
    }

    public EditAuctionRsp clear() {
        this.result = 0;
        this.detail = "";
        this.auctionInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.detail.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.detail);
        }
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, auctionBasicInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.detail.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.detail);
        }
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, auctionBasicInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditAuctionRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditAuctionRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditAuctionRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.detail = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
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
