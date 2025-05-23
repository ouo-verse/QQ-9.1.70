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
public final class Sketchpad extends ExtendableMessageNano<Sketchpad> {
    private static volatile Sketchpad[] _emptyArray;
    public String bigUrl;
    public int expireTime;
    public int giftId;
    public int level;
    public String url;

    public Sketchpad() {
        clear();
    }

    public static Sketchpad[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Sketchpad[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Sketchpad parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Sketchpad) MessageNano.mergeFrom(new Sketchpad(), bArr);
    }

    public Sketchpad clear() {
        this.giftId = 0;
        this.expireTime = 0;
        this.url = "";
        this.bigUrl = "";
        this.level = 0;
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
        int i16 = this.expireTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.url);
        }
        if (!this.bigUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bigUrl);
        }
        int i17 = this.level;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.giftId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.expireTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.url);
        }
        if (!this.bigUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.bigUrl);
        }
        int i17 = this.level;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Sketchpad parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Sketchpad().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Sketchpad mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.expireTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.bigUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.level = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
