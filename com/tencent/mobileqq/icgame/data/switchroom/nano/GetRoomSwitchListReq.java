package com.tencent.mobileqq.icgame.data.switchroom.nano;

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
public final class GetRoomSwitchListReq extends ExtendableMessageNano<GetRoomSwitchListReq> {
    private static volatile GetRoomSwitchListReq[] _emptyArray;
    public AttributeInfo attr;
    public RoomBasic basic;
    public ExtInfo[] exts;
    public SourceInfo source;

    public GetRoomSwitchListReq() {
        clear();
    }

    public static GetRoomSwitchListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomSwitchListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomSwitchListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomSwitchListReq) MessageNano.mergeFrom(new GetRoomSwitchListReq(), bArr);
    }

    public GetRoomSwitchListReq clear() {
        this.basic = null;
        this.attr = null;
        this.source = null;
        this.exts = ExtInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomBasic roomBasic = this.basic;
        if (roomBasic != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, roomBasic);
        }
        AttributeInfo attributeInfo = this.attr;
        if (attributeInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, attributeInfo);
        }
        SourceInfo sourceInfo = this.source;
        if (sourceInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sourceInfo);
        }
        ExtInfo[] extInfoArr = this.exts;
        if (extInfoArr != null && extInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ExtInfo[] extInfoArr2 = this.exts;
                if (i3 >= extInfoArr2.length) {
                    break;
                }
                ExtInfo extInfo = extInfoArr2[i3];
                if (extInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, extInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomBasic roomBasic = this.basic;
        if (roomBasic != null) {
            codedOutputByteBufferNano.writeMessage(1, roomBasic);
        }
        AttributeInfo attributeInfo = this.attr;
        if (attributeInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, attributeInfo);
        }
        SourceInfo sourceInfo = this.source;
        if (sourceInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, sourceInfo);
        }
        ExtInfo[] extInfoArr = this.exts;
        if (extInfoArr != null && extInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ExtInfo[] extInfoArr2 = this.exts;
                if (i3 >= extInfoArr2.length) {
                    break;
                }
                ExtInfo extInfo = extInfoArr2[i3];
                if (extInfo != null) {
                    codedOutputByteBufferNano.writeMessage(9, extInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomSwitchListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomSwitchListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomSwitchListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.basic == null) {
                    this.basic = new RoomBasic();
                }
                codedInputByteBufferNano.readMessage(this.basic);
            } else if (readTag == 18) {
                if (this.attr == null) {
                    this.attr = new AttributeInfo();
                }
                codedInputByteBufferNano.readMessage(this.attr);
            } else if (readTag == 26) {
                if (this.source == null) {
                    this.source = new SourceInfo();
                }
                codedInputByteBufferNano.readMessage(this.source);
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                ExtInfo[] extInfoArr = this.exts;
                int length = extInfoArr == null ? 0 : extInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ExtInfo[] extInfoArr2 = new ExtInfo[i3];
                if (length != 0) {
                    System.arraycopy(extInfoArr, 0, extInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ExtInfo extInfo = new ExtInfo();
                    extInfoArr2[length] = extInfo;
                    codedInputByteBufferNano.readMessage(extInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ExtInfo extInfo2 = new ExtInfo();
                extInfoArr2[length] = extInfo2;
                codedInputByteBufferNano.readMessage(extInfo2);
                this.exts = extInfoArr2;
            }
        }
    }
}
