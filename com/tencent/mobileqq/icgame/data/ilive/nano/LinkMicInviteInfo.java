package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicInviteInfo extends ExtendableMessageNano<LinkMicInviteInfo> {
    private static volatile LinkMicInviteInfo[] _emptyArray;
    public int linkMicInviteSwitch;
    public InviteEntity[] receiveList;
    public InviteEntity[] sendList;

    public LinkMicInviteInfo() {
        clear();
    }

    public static LinkMicInviteInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInviteInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInviteInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInviteInfo) MessageNano.mergeFrom(new LinkMicInviteInfo(), bArr);
    }

    public LinkMicInviteInfo clear() {
        this.sendList = InviteEntity.emptyArray();
        this.receiveList = InviteEntity.emptyArray();
        this.linkMicInviteSwitch = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        InviteEntity[] inviteEntityArr = this.sendList;
        int i3 = 0;
        if (inviteEntityArr != null && inviteEntityArr.length > 0) {
            int i16 = 0;
            while (true) {
                InviteEntity[] inviteEntityArr2 = this.sendList;
                if (i16 >= inviteEntityArr2.length) {
                    break;
                }
                InviteEntity inviteEntity = inviteEntityArr2[i16];
                if (inviteEntity != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, inviteEntity);
                }
                i16++;
            }
        }
        InviteEntity[] inviteEntityArr3 = this.receiveList;
        if (inviteEntityArr3 != null && inviteEntityArr3.length > 0) {
            while (true) {
                InviteEntity[] inviteEntityArr4 = this.receiveList;
                if (i3 >= inviteEntityArr4.length) {
                    break;
                }
                InviteEntity inviteEntity2 = inviteEntityArr4[i3];
                if (inviteEntity2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, inviteEntity2);
                }
                i3++;
            }
        }
        int i17 = this.linkMicInviteSwitch;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        InviteEntity[] inviteEntityArr = this.sendList;
        int i3 = 0;
        if (inviteEntityArr != null && inviteEntityArr.length > 0) {
            int i16 = 0;
            while (true) {
                InviteEntity[] inviteEntityArr2 = this.sendList;
                if (i16 >= inviteEntityArr2.length) {
                    break;
                }
                InviteEntity inviteEntity = inviteEntityArr2[i16];
                if (inviteEntity != null) {
                    codedOutputByteBufferNano.writeMessage(1, inviteEntity);
                }
                i16++;
            }
        }
        InviteEntity[] inviteEntityArr3 = this.receiveList;
        if (inviteEntityArr3 != null && inviteEntityArr3.length > 0) {
            while (true) {
                InviteEntity[] inviteEntityArr4 = this.receiveList;
                if (i3 >= inviteEntityArr4.length) {
                    break;
                }
                InviteEntity inviteEntity2 = inviteEntityArr4[i3];
                if (inviteEntity2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, inviteEntity2);
                }
                i3++;
            }
        }
        int i17 = this.linkMicInviteSwitch;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInviteInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInviteInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInviteInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                InviteEntity[] inviteEntityArr = this.sendList;
                int length = inviteEntityArr == null ? 0 : inviteEntityArr.length;
                int i3 = repeatedFieldArrayLength + length;
                InviteEntity[] inviteEntityArr2 = new InviteEntity[i3];
                if (length != 0) {
                    System.arraycopy(inviteEntityArr, 0, inviteEntityArr2, 0, length);
                }
                while (length < i3 - 1) {
                    InviteEntity inviteEntity = new InviteEntity();
                    inviteEntityArr2[length] = inviteEntity;
                    codedInputByteBufferNano.readMessage(inviteEntity);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                InviteEntity inviteEntity2 = new InviteEntity();
                inviteEntityArr2[length] = inviteEntity2;
                codedInputByteBufferNano.readMessage(inviteEntity2);
                this.sendList = inviteEntityArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                InviteEntity[] inviteEntityArr3 = this.receiveList;
                int length2 = inviteEntityArr3 == null ? 0 : inviteEntityArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                InviteEntity[] inviteEntityArr4 = new InviteEntity[i16];
                if (length2 != 0) {
                    System.arraycopy(inviteEntityArr3, 0, inviteEntityArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    InviteEntity inviteEntity3 = new InviteEntity();
                    inviteEntityArr4[length2] = inviteEntity3;
                    codedInputByteBufferNano.readMessage(inviteEntity3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                InviteEntity inviteEntity4 = new InviteEntity();
                inviteEntityArr4[length2] = inviteEntity4;
                codedInputByteBufferNano.readMessage(inviteEntity4);
                this.receiveList = inviteEntityArr4;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicInviteSwitch = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
