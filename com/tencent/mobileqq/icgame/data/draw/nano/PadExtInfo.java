package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PadExtInfo extends ExtendableMessageNano<PadExtInfo> {
    private static volatile PadExtInfo[] _emptyArray;
    public float height;
    public float offsetx;
    public float offsety;
    public String padUrl;
    public float width;

    public PadExtInfo() {
        clear();
    }

    public static PadExtInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PadExtInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PadExtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PadExtInfo) MessageNano.mergeFrom(new PadExtInfo(), bArr);
    }

    public PadExtInfo clear() {
        this.padUrl = "";
        this.width = 0.0f;
        this.height = 0.0f;
        this.offsetx = 0.0f;
        this.offsety = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.padUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.padUrl);
        }
        if (Float.floatToIntBits(this.width) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.width);
        }
        if (Float.floatToIntBits(this.height) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.height);
        }
        if (Float.floatToIntBits(this.offsetx) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.offsetx);
        }
        if (Float.floatToIntBits(this.offsety) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(5, this.offsety);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.padUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.padUrl);
        }
        if (Float.floatToIntBits(this.width) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(2, this.width);
        }
        if (Float.floatToIntBits(this.height) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.height);
        }
        if (Float.floatToIntBits(this.offsetx) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.offsetx);
        }
        if (Float.floatToIntBits(this.offsety) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(5, this.offsety);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PadExtInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PadExtInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PadExtInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.padUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 21) {
                this.width = codedInputByteBufferNano.readFloat();
            } else if (readTag == 29) {
                this.height = codedInputByteBufferNano.readFloat();
            } else if (readTag == 37) {
                this.offsetx = codedInputByteBufferNano.readFloat();
            } else if (readTag != 45) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.offsety = codedInputByteBufferNano.readFloat();
            }
        }
    }
}
