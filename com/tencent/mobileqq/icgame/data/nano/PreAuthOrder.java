package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PreAuthOrder extends ExtendableMessageNano<PreAuthOrder> {
    private static volatile PreAuthOrder[] _emptyArray;
    public long expire;
    public String ext;
    public String order;
    public int price;
    public int type;

    public PreAuthOrder() {
        clear();
    }

    public static PreAuthOrder[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PreAuthOrder[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PreAuthOrder parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PreAuthOrder) MessageNano.mergeFrom(new PreAuthOrder(), bArr);
    }

    public PreAuthOrder clear() {
        this.type = 1;
        this.order = "";
        this.price = 0;
        this.expire = 0L;
        this.ext = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.type) + CodedOutputByteBufferNano.computeStringSize(2, this.order) + CodedOutputByteBufferNano.computeUInt32Size(3, this.price) + CodedOutputByteBufferNano.computeUInt64Size(4, this.expire);
        if (!this.ext.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.ext);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(1, this.type);
        codedOutputByteBufferNano.writeString(2, this.order);
        codedOutputByteBufferNano.writeUInt32(3, this.price);
        codedOutputByteBufferNano.writeUInt64(4, this.expire);
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.ext);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PreAuthOrder parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PreAuthOrder().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PreAuthOrder mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1) {
                    this.type = readInt32;
                }
            } else if (readTag == 18) {
                this.order = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.price = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.expire = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.ext = codedInputByteBufferNano.readString();
            }
        }
    }
}
