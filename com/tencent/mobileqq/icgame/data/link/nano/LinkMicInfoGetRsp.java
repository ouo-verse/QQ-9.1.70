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
public final class LinkMicInfoGetRsp extends ExtendableMessageNano<LinkMicInfoGetRsp> {
    private static volatile LinkMicInfoGetRsp[] _emptyArray;
    public long anchorUid;
    public LinkConfig linkConfig;
    public String linkMicId;
    public LiveStatusInfo liveStatusIfo;
    public LinkMicLocationInfo locationInfo;
    public int micState;
    public MuteList muteList;
    public UserPlaceInfo[] placeInfos;

    public LinkMicInfoGetRsp() {
        clear();
    }

    public static LinkMicInfoGetRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInfoGetRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInfoGetRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInfoGetRsp) MessageNano.mergeFrom(new LinkMicInfoGetRsp(), bArr);
    }

    public LinkMicInfoGetRsp clear() {
        this.anchorUid = 0L;
        this.micState = 0;
        this.linkConfig = null;
        this.linkMicId = "";
        this.placeInfos = UserPlaceInfo.emptyArray();
        this.locationInfo = null;
        this.muteList = null;
        this.liveStatusIfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.micState;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        LinkConfig linkConfig = this.linkConfig;
        if (linkConfig != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, linkConfig);
        }
        if (!this.linkMicId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.linkMicId);
        }
        UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
        if (userPlaceInfoArr != null && userPlaceInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserPlaceInfo[] userPlaceInfoArr2 = this.placeInfos;
                if (i16 >= userPlaceInfoArr2.length) {
                    break;
                }
                UserPlaceInfo userPlaceInfo = userPlaceInfoArr2[i16];
                if (userPlaceInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userPlaceInfo);
                }
                i16++;
            }
        }
        LinkMicLocationInfo linkMicLocationInfo = this.locationInfo;
        if (linkMicLocationInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, linkMicLocationInfo);
        }
        MuteList muteList = this.muteList;
        if (muteList != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, muteList);
        }
        LiveStatusInfo liveStatusInfo = this.liveStatusIfo;
        if (liveStatusInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, liveStatusInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.micState;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        LinkConfig linkConfig = this.linkConfig;
        if (linkConfig != null) {
            codedOutputByteBufferNano.writeMessage(3, linkConfig);
        }
        if (!this.linkMicId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.linkMicId);
        }
        UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
        if (userPlaceInfoArr != null && userPlaceInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                UserPlaceInfo[] userPlaceInfoArr2 = this.placeInfos;
                if (i16 >= userPlaceInfoArr2.length) {
                    break;
                }
                UserPlaceInfo userPlaceInfo = userPlaceInfoArr2[i16];
                if (userPlaceInfo != null) {
                    codedOutputByteBufferNano.writeMessage(5, userPlaceInfo);
                }
                i16++;
            }
        }
        LinkMicLocationInfo linkMicLocationInfo = this.locationInfo;
        if (linkMicLocationInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, linkMicLocationInfo);
        }
        MuteList muteList = this.muteList;
        if (muteList != null) {
            codedOutputByteBufferNano.writeMessage(7, muteList);
        }
        LiveStatusInfo liveStatusInfo = this.liveStatusIfo;
        if (liveStatusInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, liveStatusInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInfoGetRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInfoGetRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInfoGetRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.micState = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.linkConfig == null) {
                    this.linkConfig = new LinkConfig();
                }
                codedInputByteBufferNano.readMessage(this.linkConfig);
            } else if (readTag == 34) {
                this.linkMicId = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserPlaceInfo[] userPlaceInfoArr = this.placeInfos;
                int length = userPlaceInfoArr == null ? 0 : userPlaceInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserPlaceInfo[] userPlaceInfoArr2 = new UserPlaceInfo[i3];
                if (length != 0) {
                    System.arraycopy(userPlaceInfoArr, 0, userPlaceInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserPlaceInfo userPlaceInfo = new UserPlaceInfo();
                    userPlaceInfoArr2[length] = userPlaceInfo;
                    codedInputByteBufferNano.readMessage(userPlaceInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserPlaceInfo userPlaceInfo2 = new UserPlaceInfo();
                userPlaceInfoArr2[length] = userPlaceInfo2;
                codedInputByteBufferNano.readMessage(userPlaceInfo2);
                this.placeInfos = userPlaceInfoArr2;
            } else if (readTag == 50) {
                if (this.locationInfo == null) {
                    this.locationInfo = new LinkMicLocationInfo();
                }
                codedInputByteBufferNano.readMessage(this.locationInfo);
            } else if (readTag == 58) {
                if (this.muteList == null) {
                    this.muteList = new MuteList();
                }
                codedInputByteBufferNano.readMessage(this.muteList);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.liveStatusIfo == null) {
                    this.liveStatusIfo = new LiveStatusInfo();
                }
                codedInputByteBufferNano.readMessage(this.liveStatusIfo);
            }
        }
    }
}
