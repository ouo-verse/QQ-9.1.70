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
public final class Location extends ExtendableMessageNano<Location> {
    private static volatile Location[] _emptyArray;
    public double height;
    public double width;

    /* renamed from: x, reason: collision with root package name */
    public double f237285x;

    /* renamed from: y, reason: collision with root package name */
    public double f237286y;

    public Location() {
        clear();
    }

    public static Location[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Location[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Location) MessageNano.mergeFrom(new Location(), bArr);
    }

    public Location clear() {
        this.width = 0.0d;
        this.height = 0.0d;
        this.f237285x = 0.0d;
        this.f237286y = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.width);
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.height);
        }
        if (Double.doubleToLongBits(this.f237285x) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.f237285x);
        }
        if (Double.doubleToLongBits(this.f237286y) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(4, this.f237286y);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(1, this.width);
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.height);
        }
        if (Double.doubleToLongBits(this.f237285x) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.f237285x);
        }
        if (Double.doubleToLongBits(this.f237286y) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(4, this.f237286y);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Location parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Location().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Location mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 9) {
                this.width = codedInputByteBufferNano.readDouble();
            } else if (readTag == 17) {
                this.height = codedInputByteBufferNano.readDouble();
            } else if (readTag == 25) {
                this.f237285x = codedInputByteBufferNano.readDouble();
            } else if (readTag != 33) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f237286y = codedInputByteBufferNano.readDouble();
            }
        }
    }
}
