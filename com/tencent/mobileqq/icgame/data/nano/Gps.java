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
public final class Gps extends ExtendableMessageNano<Gps> {
    private static volatile Gps[] _emptyArray;
    public int accuracy;
    public int lat;
    public int lon;

    public Gps() {
        clear();
    }

    public static Gps[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Gps[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Gps parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Gps) MessageNano.mergeFrom(new Gps(), bArr);
    }

    public Gps clear() {
        this.lat = 0;
        this.lon = 0;
        this.accuracy = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.lat;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.lon;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.accuracy;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.lat;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.lon;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.accuracy;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Gps parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Gps().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Gps mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.lat = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.lon = codedInputByteBufferNano.readInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.accuracy = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
