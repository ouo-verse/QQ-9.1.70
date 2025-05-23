package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RichTitleElement extends ExtendableMessageNano<RichTitleElement> {
    private static volatile RichTitleElement[] _emptyArray;
    public String text;
    public int type;
    public String url;

    public RichTitleElement() {
        clear();
    }

    public static RichTitleElement[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RichTitleElement[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RichTitleElement parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RichTitleElement) MessageNano.mergeFrom(new RichTitleElement(), bArr);
    }

    public RichTitleElement clear() {
        this.type = 0;
        this.text = "";
        this.url = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.text.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
        }
        if (!this.url.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.url);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.text);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.url);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RichTitleElement parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RichTitleElement().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RichTitleElement mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.text = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.url = codedInputByteBufferNano.readString();
            }
        }
    }
}
