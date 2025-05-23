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
public final class CarInfo extends ExtendableMessageNano<CarInfo> {
    private static volatile CarInfo[] _emptyArray;
    public String androidUrl;
    public int carId;
    public String carName;
    public String flashUrl;
    public int platformType;
    public int xsize;
    public int ysize;

    public CarInfo() {
        clear();
    }

    public static CarInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CarInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CarInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CarInfo) MessageNano.mergeFrom(new CarInfo(), bArr);
    }

    public CarInfo clear() {
        this.carId = 0;
        this.carName = "";
        this.platformType = 9;
        this.xsize = 0;
        this.ysize = 0;
        this.flashUrl = "";
        this.androidUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.carId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.carName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.carName);
        }
        int i16 = this.platformType;
        if (i16 != 9) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.xsize;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.ysize;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        if (!this.flashUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.flashUrl);
        }
        if (!this.androidUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.androidUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.carId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.carName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.carName);
        }
        int i16 = this.platformType;
        if (i16 != 9) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.xsize;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.ysize;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        if (!this.flashUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.flashUrl);
        }
        if (!this.androidUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.androidUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CarInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CarInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CarInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.carId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.carName = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.platformType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.xsize = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.ysize = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                this.flashUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.androidUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
