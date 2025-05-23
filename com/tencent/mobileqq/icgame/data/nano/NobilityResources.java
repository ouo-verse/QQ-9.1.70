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
public final class NobilityResources extends ExtendableMessageNano<NobilityResources> {
    private static volatile NobilityResources[] _emptyArray;
    public IconInfo iconBackground;
    public IconInfo iconHead;
    public IconInfo iconPc;
    public int textColor;

    public NobilityResources() {
        clear();
    }

    public static NobilityResources[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new NobilityResources[0];
                }
            }
        }
        return _emptyArray;
    }

    public static NobilityResources parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NobilityResources) MessageNano.mergeFrom(new NobilityResources(), bArr);
    }

    public NobilityResources clear() {
        this.iconHead = null;
        this.iconBackground = null;
        this.textColor = 0;
        this.iconPc = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        IconInfo iconInfo = this.iconHead;
        if (iconInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iconInfo);
        }
        IconInfo iconInfo2 = this.iconBackground;
        if (iconInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, iconInfo2);
        }
        int i3 = this.textColor;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        IconInfo iconInfo3 = this.iconPc;
        if (iconInfo3 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, iconInfo3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        IconInfo iconInfo = this.iconHead;
        if (iconInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, iconInfo);
        }
        IconInfo iconInfo2 = this.iconBackground;
        if (iconInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, iconInfo2);
        }
        int i3 = this.textColor;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        IconInfo iconInfo3 = this.iconPc;
        if (iconInfo3 != null) {
            codedOutputByteBufferNano.writeMessage(4, iconInfo3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static NobilityResources parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new NobilityResources().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public NobilityResources mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.iconHead == null) {
                    this.iconHead = new IconInfo();
                }
                codedInputByteBufferNano.readMessage(this.iconHead);
            } else if (readTag == 18) {
                if (this.iconBackground == null) {
                    this.iconBackground = new IconInfo();
                }
                codedInputByteBufferNano.readMessage(this.iconBackground);
            } else if (readTag == 24) {
                this.textColor = codedInputByteBufferNano.readInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.iconPc == null) {
                    this.iconPc = new IconInfo();
                }
                codedInputByteBufferNano.readMessage(this.iconPc);
            }
        }
    }
}
