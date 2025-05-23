package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicLocationInfo extends ExtendableMessageNano<LinkMicLocationInfo> {
    private static volatile LinkMicLocationInfo[] _emptyArray;
    public double borderHeight;
    public double borderWidth;
    public Map<Long, Location> locations;

    public LinkMicLocationInfo() {
        clear();
    }

    public static LinkMicLocationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicLocationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicLocationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicLocationInfo) MessageNano.mergeFrom(new LinkMicLocationInfo(), bArr);
    }

    public LinkMicLocationInfo clear() {
        this.locations = null;
        this.borderWidth = 0.0d;
        this.borderHeight = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Map<Long, Location> map = this.locations;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 4, 11);
        }
        if (Double.doubleToLongBits(this.borderWidth) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.borderWidth);
        }
        if (Double.doubleToLongBits(this.borderHeight) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(3, this.borderHeight);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Long, Location> map = this.locations;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 4, 11);
        }
        if (Double.doubleToLongBits(this.borderWidth) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.borderWidth);
        }
        if (Double.doubleToLongBits(this.borderHeight) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.borderHeight);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicLocationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicLocationInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicLocationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.locations = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.locations, mapFactory, 4, 11, new Location(), 8, 18);
            } else if (readTag == 17) {
                this.borderWidth = codedInputByteBufferNano.readDouble();
            } else if (readTag != 25) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.borderHeight = codedInputByteBufferNano.readDouble();
            }
        }
    }
}
