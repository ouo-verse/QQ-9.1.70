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
public final class LocationInfo extends ExtendableMessageNano<LocationInfo> {
    private static volatile LocationInfo[] _emptyArray;
    public float latitude;
    public float longitude;

    public LocationInfo() {
        clear();
    }

    public static LocationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LocationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LocationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LocationInfo) MessageNano.mergeFrom(new LocationInfo(), bArr);
    }

    public LocationInfo clear() {
        this.longitude = 0.0f;
        this.latitude = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.longitude);
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, this.latitude);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(1, this.longitude);
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(2, this.latitude);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LocationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LocationInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LocationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 13) {
                this.longitude = codedInputByteBufferNano.readFloat();
            } else if (readTag != 21) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.latitude = codedInputByteBufferNano.readFloat();
            }
        }
    }
}
