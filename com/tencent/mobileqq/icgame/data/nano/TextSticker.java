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
public final class TextSticker extends ExtendableMessageNano<TextSticker> {
    private static volatile TextSticker[] _emptyArray;
    public boolean isEdit;
    public boolean isSelect;
    public long latestTs;
    public String location;
    public String materialMd5;
    public String materialUrl;
    public String stickerName;
    public TextContext textDefault;
    public TextContext textModified;
    public int textType;

    public TextSticker() {
        clear();
    }

    public static TextSticker[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TextSticker[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TextSticker parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TextSticker) MessageNano.mergeFrom(new TextSticker(), bArr);
    }

    public TextSticker clear() {
        this.stickerName = "";
        this.materialUrl = "";
        this.textType = 0;
        this.textDefault = null;
        this.materialMd5 = "";
        this.isSelect = false;
        this.isEdit = false;
        this.textModified = null;
        this.location = "";
        this.latestTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.stickerName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.stickerName);
        }
        if (!this.materialUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.materialUrl);
        }
        int i3 = this.textType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        TextContext textContext = this.textDefault;
        if (textContext != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, textContext);
        }
        if (!this.materialMd5.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.materialMd5);
        }
        boolean z16 = this.isSelect;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        boolean z17 = this.isEdit;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z17);
        }
        TextContext textContext2 = this.textModified;
        if (textContext2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, textContext2);
        }
        if (!this.location.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.location);
        }
        long j3 = this.latestTs;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(14, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.stickerName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.stickerName);
        }
        if (!this.materialUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.materialUrl);
        }
        int i3 = this.textType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        TextContext textContext = this.textDefault;
        if (textContext != null) {
            codedOutputByteBufferNano.writeMessage(4, textContext);
        }
        if (!this.materialMd5.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.materialMd5);
        }
        boolean z16 = this.isSelect;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        boolean z17 = this.isEdit;
        if (z17) {
            codedOutputByteBufferNano.writeBool(11, z17);
        }
        TextContext textContext2 = this.textModified;
        if (textContext2 != null) {
            codedOutputByteBufferNano.writeMessage(12, textContext2);
        }
        if (!this.location.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.location);
        }
        long j3 = this.latestTs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(14, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TextSticker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TextSticker().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TextSticker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.stickerName = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.materialUrl = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.textType = readInt32;
                        break;
                    }
                case 34:
                    if (this.textDefault == null) {
                        this.textDefault = new TextContext();
                    }
                    codedInputByteBufferNano.readMessage(this.textDefault);
                    break;
                case 42:
                    this.materialMd5 = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.isSelect = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.isEdit = codedInputByteBufferNano.readBool();
                    break;
                case 98:
                    if (this.textModified == null) {
                        this.textModified = new TextContext();
                    }
                    codedInputByteBufferNano.readMessage(this.textModified);
                    break;
                case 106:
                    this.location = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.latestTs = codedInputByteBufferNano.readInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
