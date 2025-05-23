package com.tencent.mobileqq.icgame.data.link.nano;

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
public final class LinkMicMultiApplyReq extends ExtendableMessageNano<LinkMicMultiApplyReq> {
    private static volatile LinkMicMultiApplyReq[] _emptyArray;
    public String linkMicId;
    public UserPlaceOper[] operInfos;

    public LinkMicMultiApplyReq() {
        clear();
    }

    public static LinkMicMultiApplyReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicMultiApplyReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicMultiApplyReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicMultiApplyReq) MessageNano.mergeFrom(new LinkMicMultiApplyReq(), bArr);
    }

    public LinkMicMultiApplyReq clear() {
        this.linkMicId = "";
        this.operInfos = UserPlaceOper.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.linkMicId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.linkMicId);
        }
        UserPlaceOper[] userPlaceOperArr = this.operInfos;
        if (userPlaceOperArr != null && userPlaceOperArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserPlaceOper[] userPlaceOperArr2 = this.operInfos;
                if (i3 >= userPlaceOperArr2.length) {
                    break;
                }
                UserPlaceOper userPlaceOper = userPlaceOperArr2[i3];
                if (userPlaceOper != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userPlaceOper);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.linkMicId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.linkMicId);
        }
        UserPlaceOper[] userPlaceOperArr = this.operInfos;
        if (userPlaceOperArr != null && userPlaceOperArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserPlaceOper[] userPlaceOperArr2 = this.operInfos;
                if (i3 >= userPlaceOperArr2.length) {
                    break;
                }
                UserPlaceOper userPlaceOper = userPlaceOperArr2[i3];
                if (userPlaceOper != null) {
                    codedOutputByteBufferNano.writeMessage(2, userPlaceOper);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicMultiApplyReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicMultiApplyReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicMultiApplyReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.linkMicId = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserPlaceOper[] userPlaceOperArr = this.operInfos;
                int length = userPlaceOperArr == null ? 0 : userPlaceOperArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserPlaceOper[] userPlaceOperArr2 = new UserPlaceOper[i3];
                if (length != 0) {
                    System.arraycopy(userPlaceOperArr, 0, userPlaceOperArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserPlaceOper userPlaceOper = new UserPlaceOper();
                    userPlaceOperArr2[length] = userPlaceOper;
                    codedInputByteBufferNano.readMessage(userPlaceOper);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserPlaceOper userPlaceOper2 = new UserPlaceOper();
                userPlaceOperArr2[length] = userPlaceOper2;
                codedInputByteBufferNano.readMessage(userPlaceOper2);
                this.operInfos = userPlaceOperArr2;
            }
        }
    }
}
