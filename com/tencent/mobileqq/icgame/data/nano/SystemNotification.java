package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SystemNotification extends ExtendableMessageNano<SystemNotification> {
    private static volatile SystemNotification[] _emptyArray;
    public Element[] elments;

    /* renamed from: id, reason: collision with root package name */
    public int f237293id;
    public String jumpurl;
    public int showSec;

    public SystemNotification() {
        clear();
    }

    public static SystemNotification[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SystemNotification[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SystemNotification parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SystemNotification) MessageNano.mergeFrom(new SystemNotification(), bArr);
    }

    public SystemNotification clear() {
        this.f237293id = 0;
        this.elments = Element.emptyArray();
        this.jumpurl = "";
        this.showSec = 3;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f237293id;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        Element[] elementArr = this.elments;
        if (elementArr != null && elementArr.length > 0) {
            int i16 = 0;
            while (true) {
                Element[] elementArr2 = this.elments;
                if (i16 >= elementArr2.length) {
                    break;
                }
                Element element = elementArr2[i16];
                if (element != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, element);
                }
                i16++;
            }
        }
        if (!this.jumpurl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpurl);
        }
        int i17 = this.showSec;
        if (i17 != 3) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f237293id;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        Element[] elementArr = this.elments;
        if (elementArr != null && elementArr.length > 0) {
            int i16 = 0;
            while (true) {
                Element[] elementArr2 = this.elments;
                if (i16 >= elementArr2.length) {
                    break;
                }
                Element element = elementArr2[i16];
                if (element != null) {
                    codedOutputByteBufferNano.writeMessage(2, element);
                }
                i16++;
            }
        }
        if (!this.jumpurl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.jumpurl);
        }
        int i17 = this.showSec;
        if (i17 != 3) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SystemNotification parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SystemNotification().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SystemNotification mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237293id = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Element[] elementArr = this.elments;
                int length = elementArr == null ? 0 : elementArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Element[] elementArr2 = new Element[i3];
                if (length != 0) {
                    System.arraycopy(elementArr, 0, elementArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Element element = new Element();
                    elementArr2[length] = element;
                    codedInputByteBufferNano.readMessage(element);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Element element2 = new Element();
                elementArr2[length] = element2;
                codedInputByteBufferNano.readMessage(element2);
                this.elments = elementArr2;
            } else if (readTag == 26) {
                this.jumpurl = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.showSec = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
