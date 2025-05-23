package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class RichTopPush extends ExtendableMessageNano<RichTopPush> {
    private static volatile RichTopPush[] _emptyArray;
    public String avatar;
    public int level;
    public int levelToNext;
    public String name;
    public long uid;
    public int wealth;

    public RichTopPush() {
        clear();
    }

    public static RichTopPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RichTopPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RichTopPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RichTopPush) MessageNano.mergeFrom(new RichTopPush(), bArr);
    }

    public RichTopPush clear() {
        this.uid = 0L;
        this.name = "";
        this.avatar = "";
        this.wealth = 0;
        this.level = 0;
        this.levelToNext = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.avatar);
        }
        int i3 = this.wealth;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.level;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.levelToNext;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.avatar);
        }
        int i3 = this.wealth;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.level;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.levelToNext;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RichTopPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RichTopPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RichTopPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.wealth = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.level = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.levelToNext = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
