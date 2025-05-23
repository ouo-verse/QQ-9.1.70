package com.tencent.mobileqq.icgame.data.login.nano;

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
public final class BusinessRequestExtData extends ExtendableMessageNano<BusinessRequestExtData> {
    private static volatile BusinessRequestExtData[] _emptyArray;
    public String adid;
    public String[] adids;
    public String androidId;
    public int cancelRecover;
    public String channelId;
    public String city;
    public ClientInfo[] clientInfos;
    public RequestCommonConfigInfo commonConfig;
    public float latitude;
    public int loginMode;
    public int loginType;
    public float longitude;
    public String macAddr;
    public String oaid;
    public String oaidTicket;
    public String[] qadids;
    public RequestSplashScreenConfig splashConfig;

    public BusinessRequestExtData() {
        clear();
    }

    public static BusinessRequestExtData[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BusinessRequestExtData[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BusinessRequestExtData parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BusinessRequestExtData) MessageNano.mergeFrom(new BusinessRequestExtData(), bArr);
    }

    public BusinessRequestExtData clear() {
        this.loginType = 0;
        this.loginMode = 0;
        this.longitude = 0.0f;
        this.latitude = 0.0f;
        this.city = "";
        this.cancelRecover = 0;
        this.channelId = "";
        this.adid = "";
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.adids = strArr;
        this.qadids = strArr;
        this.oaid = "";
        this.androidId = "";
        this.macAddr = "";
        this.splashConfig = null;
        this.commonConfig = null;
        this.oaidTicket = "";
        this.clientInfos = ClientInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.loginType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.loginMode;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.longitude);
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.latitude);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.city);
        }
        int i17 = this.cancelRecover;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        if (!this.channelId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.channelId);
        }
        if (!this.adid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.adid);
        }
        String[] strArr = this.adids;
        int i18 = 0;
        if (strArr != null && strArr.length > 0) {
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr2 = this.adids;
                if (i19 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i19];
                if (str != null) {
                    i27++;
                    i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (i27 * 1);
        }
        String[] strArr3 = this.qadids;
        if (strArr3 != null && strArr3.length > 0) {
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            while (true) {
                String[] strArr4 = this.qadids;
                if (i28 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i28];
                if (str2 != null) {
                    i36++;
                    i29 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i28++;
            }
            computeSerializedSize = computeSerializedSize + i29 + (i36 * 1);
        }
        if (!this.oaid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.oaid);
        }
        if (!this.androidId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.androidId);
        }
        if (!this.macAddr.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.macAddr);
        }
        RequestSplashScreenConfig requestSplashScreenConfig = this.splashConfig;
        if (requestSplashScreenConfig != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, requestSplashScreenConfig);
        }
        RequestCommonConfigInfo requestCommonConfigInfo = this.commonConfig;
        if (requestCommonConfigInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, requestCommonConfigInfo);
        }
        if (!this.oaidTicket.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.oaidTicket);
        }
        ClientInfo[] clientInfoArr = this.clientInfos;
        if (clientInfoArr != null && clientInfoArr.length > 0) {
            while (true) {
                ClientInfo[] clientInfoArr2 = this.clientInfos;
                if (i18 >= clientInfoArr2.length) {
                    break;
                }
                ClientInfo clientInfo = clientInfoArr2[i18];
                if (clientInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, clientInfo);
                }
                i18++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.loginType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.loginMode;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.longitude);
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.latitude);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.city);
        }
        int i17 = this.cancelRecover;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        if (!this.channelId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.channelId);
        }
        if (!this.adid.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.adid);
        }
        String[] strArr = this.adids;
        int i18 = 0;
        if (strArr != null && strArr.length > 0) {
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.adids;
                if (i19 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i19];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(9, str);
                }
                i19++;
            }
        }
        String[] strArr3 = this.qadids;
        if (strArr3 != null && strArr3.length > 0) {
            int i26 = 0;
            while (true) {
                String[] strArr4 = this.qadids;
                if (i26 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i26];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(10, str2);
                }
                i26++;
            }
        }
        if (!this.oaid.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.oaid);
        }
        if (!this.androidId.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.androidId);
        }
        if (!this.macAddr.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.macAddr);
        }
        RequestSplashScreenConfig requestSplashScreenConfig = this.splashConfig;
        if (requestSplashScreenConfig != null) {
            codedOutputByteBufferNano.writeMessage(14, requestSplashScreenConfig);
        }
        RequestCommonConfigInfo requestCommonConfigInfo = this.commonConfig;
        if (requestCommonConfigInfo != null) {
            codedOutputByteBufferNano.writeMessage(15, requestCommonConfigInfo);
        }
        if (!this.oaidTicket.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.oaidTicket);
        }
        ClientInfo[] clientInfoArr = this.clientInfos;
        if (clientInfoArr != null && clientInfoArr.length > 0) {
            while (true) {
                ClientInfo[] clientInfoArr2 = this.clientInfos;
                if (i18 >= clientInfoArr2.length) {
                    break;
                }
                ClientInfo clientInfo = clientInfoArr2[i18];
                if (clientInfo != null) {
                    codedOutputByteBufferNano.writeMessage(17, clientInfo);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BusinessRequestExtData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BusinessRequestExtData().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BusinessRequestExtData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.loginType = readInt32;
                        break;
                    }
                case 16:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.loginMode = readInt322;
                        break;
                    }
                case 29:
                    this.longitude = codedInputByteBufferNano.readFloat();
                    break;
                case 37:
                    this.latitude = codedInputByteBufferNano.readFloat();
                    break;
                case 42:
                    this.city = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.cancelRecover = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.channelId = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.adid = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    String[] strArr = this.adids;
                    int length = strArr == null ? 0 : strArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i3];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.adids = strArr2;
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    String[] strArr3 = this.qadids;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i16];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.qadids = strArr4;
                    break;
                case 90:
                    this.oaid = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.androidId = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.macAddr = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    if (this.splashConfig == null) {
                        this.splashConfig = new RequestSplashScreenConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.splashConfig);
                    break;
                case 122:
                    if (this.commonConfig == null) {
                        this.commonConfig = new RequestCommonConfigInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.commonConfig);
                    break;
                case 130:
                    this.oaidTicket = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    ClientInfo[] clientInfoArr = this.clientInfos;
                    int length3 = clientInfoArr == null ? 0 : clientInfoArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    ClientInfo[] clientInfoArr2 = new ClientInfo[i17];
                    if (length3 != 0) {
                        System.arraycopy(clientInfoArr, 0, clientInfoArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        ClientInfo clientInfo = new ClientInfo();
                        clientInfoArr2[length3] = clientInfo;
                        codedInputByteBufferNano.readMessage(clientInfo);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    ClientInfo clientInfo2 = new ClientInfo();
                    clientInfoArr2[length3] = clientInfo2;
                    codedInputByteBufferNano.readMessage(clientInfo2);
                    this.clientInfos = clientInfoArr2;
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
