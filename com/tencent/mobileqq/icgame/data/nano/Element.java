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
public final class Element extends ExtendableMessageNano<Element> {
    private static volatile Element[] _emptyArray;
    public PicElement elPic;
    public TextElement elText;
    public int type;

    public Element() {
        clear();
    }

    public static Element[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Element[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Element parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Element) MessageNano.mergeFrom(new Element(), bArr);
    }

    public Element clear() {
        this.type = 0;
        this.elText = null;
        this.elPic = null;
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
        TextElement textElement = this.elText;
        if (textElement != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, textElement);
        }
        PicElement picElement = this.elPic;
        if (picElement != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, picElement);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        TextElement textElement = this.elText;
        if (textElement != null) {
            codedOutputByteBufferNano.writeMessage(2, textElement);
        }
        PicElement picElement = this.elPic;
        if (picElement != null) {
            codedOutputByteBufferNano.writeMessage(3, picElement);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Element parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Element().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Element mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.elText == null) {
                    this.elText = new TextElement();
                }
                codedInputByteBufferNano.readMessage(this.elText);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.elPic == null) {
                    this.elPic = new PicElement();
                }
                codedInputByteBufferNano.readMessage(this.elPic);
            }
        }
    }
}
