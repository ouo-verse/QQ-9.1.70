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
public final class EditAuctionReq extends ExtendableMessageNano<EditAuctionReq> {
    private static volatile EditAuctionReq[] _emptyArray;
    public String auctionTheme;
    public int rateOfInctrease;
    public int roomId;
    public int startingPrice;
    public int waitingTime;

    public EditAuctionReq() {
        clear();
    }

    public static EditAuctionReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditAuctionReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditAuctionReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditAuctionReq) MessageNano.mergeFrom(new EditAuctionReq(), bArr);
    }

    public EditAuctionReq clear() {
        this.roomId = 0;
        this.waitingTime = 0;
        this.startingPrice = 0;
        this.rateOfInctrease = 0;
        this.auctionTheme = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        int i3 = this.waitingTime;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.startingPrice;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.rateOfInctrease;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!this.auctionTheme.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.auctionTheme);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        int i3 = this.waitingTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.startingPrice;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.rateOfInctrease;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!this.auctionTheme.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.auctionTheme);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditAuctionReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditAuctionReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditAuctionReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.waitingTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.startingPrice = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.rateOfInctrease = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.auctionTheme = codedInputByteBufferNano.readString();
            }
        }
    }
}
