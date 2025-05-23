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
public final class DrawNotify extends ExtendableMessageNano<DrawNotify> {
    private static volatile DrawNotify[] _emptyArray;
    public String jumpUrl;
    public int num;
    public String text;

    public DrawNotify() {
        clear();
    }

    public static DrawNotify[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawNotify[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawNotify) MessageNano.mergeFrom(new DrawNotify(), bArr);
    }

    public DrawNotify clear() {
        this.text = "";
        this.num = 0;
        this.jumpUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        int i3 = this.num;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.jumpUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        int i3 = this.num;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.jumpUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawNotify parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawNotify().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawNotify mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.num = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.jumpUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
