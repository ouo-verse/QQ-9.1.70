package cooperation.qzone.util;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;

/* loaded from: classes28.dex */
public class ProtocolUtils {
    private static final String TAG = "ProtocolUtils";

    public static JceStruct decode(byte[] bArr, String str) {
        return decode(bArr, str, null);
    }

    private static void getServerMsg(UniAttribute uniAttribute, String[] strArr) {
        if (uniAttribute != null && strArr != null && strArr.length >= 1) {
            try {
                String str = (String) uniAttribute.get("msg", "");
                strArr[0] = str;
                if (str == null) {
                    strArr[0] = " unknown msg";
                }
            } catch (Throwable unused) {
                if (strArr[0] == null) {
                    strArr[0] = " unknown msg";
                }
            }
        }
    }

    public static JceStruct decode(byte[] bArr, String str, int[] iArr) {
        return decode(bArr, str, iArr, null);
    }

    public static JceStruct decode(byte[] bArr, String str, int[] iArr, String[] strArr) {
        int i3;
        if (iArr != null && iArr.length > 0) {
            iArr[0] = -1000000;
        }
        try {
            QmfDownstream unpack = new WNSStream().unpack(fh.a(bArr));
            if (unpack != null && unpack.WnsCode == 0) {
                UniAttribute uniAttribute = new UniAttribute();
                uniAttribute.setEncodeName("utf-8");
                uniAttribute.decode(unpack.Extra);
                QmfBusiControl qmfBusiControl = (QmfBusiControl) uniAttribute.get("busiCompCtl");
                if (qmfBusiControl != null && 1 == qmfBusiControl.compFlag) {
                    byte[] decompress = WNSStream.decompress(unpack.BusiBuff);
                    if (decompress != null) {
                        unpack.BusiBuff = decompress;
                    } else {
                        if (iArr != null && iArr.length > 0) {
                            iArr[0] = 1000002;
                        }
                        getServerMsg(uniAttribute, strArr);
                        return null;
                    }
                }
                UniAttribute uniAttribute2 = new UniAttribute();
                uniAttribute2.setEncodeName("utf-8");
                uniAttribute2.decode(unpack.BusiBuff);
                short s16 = unpack.BizCode;
                Object obj = uniAttribute2.get("ret", Short.valueOf(s16));
                if (obj instanceof Short) {
                    i3 = ((Short) obj).intValue();
                } else {
                    i3 = s16;
                    if (obj instanceof Integer) {
                        i3 = ((Integer) obj).intValue();
                    }
                }
                if (iArr != null && iArr.length > 0) {
                    iArr[0] = i3;
                }
                getServerMsg(uniAttribute2, strArr);
                return (JceStruct) uniAttribute2.get(str);
            }
            if (unpack != null && unpack.WnsCode != 0) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "decode " + str + " error:" + WnsError.getErrorMessage(unpack.WnsCode));
                }
                if (iArr != null && iArr.length > 0) {
                    iArr[0] = unpack.WnsCode;
                }
                if (strArr != null && strArr.length > 0) {
                    strArr[0] = WnsError.getErrorMessage(unpack.WnsCode);
                }
                return null;
            }
            if (unpack == null && iArr != null && iArr.length > 0) {
                iArr[0] = 1000003;
            }
            return null;
        } catch (Throwable unused) {
            if (iArr != null && iArr.length > 0) {
                iArr[0] = 1000001;
            }
            return null;
        }
    }
}
