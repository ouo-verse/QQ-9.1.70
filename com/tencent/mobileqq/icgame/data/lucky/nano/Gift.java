package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class Gift extends ExtendableMessageNano<Gift> {
    private static volatile Gift[] _emptyArray;
    public int bussId;
    public int giftId;
    public int giftNum;
    public int giftType;
    public String logo;
    public String name;
    public int price;

    public Gift() {
        clear();
    }

    public static Gift[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Gift[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Gift parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Gift) MessageNano.mergeFrom(new Gift(), bArr);
    }

    public Gift clear() {
        this.giftId = 0;
        this.giftNum = 0;
        this.bussId = 0;
        this.giftType = 0;
        this.name = "";
        this.logo = "";
        this.price = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.giftId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.giftNum;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.bussId;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.giftType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.name);
        }
        if (!this.logo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.logo);
        }
        int i19 = this.price;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.giftId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.giftNum;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.bussId;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.giftType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.name);
        }
        if (!this.logo.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.logo);
        }
        int i19 = this.price;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Gift parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Gift().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Gift mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.giftNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.bussId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.giftType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.logo = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.price = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
