package cooperation.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfTokenInfo;
import QMF_PROTOCAL.QmfUpstream;
import QMF_PROTOCAL.RetryInfo;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WNSStream {
    private static final String BUSICOMPCONTROL = "busiCompCtl";
    private static final String ENCODE_CODE = "UTF-8";
    private int SUPPORT_COMPRESS;
    private byte[] mA2;
    private int mAppId;
    private String mDeviceInfo;
    private String mQUA;
    private RetryInfo mRetryInfo;
    private long mUin;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class TokenType {
        public static final int A2 = 64;
        public static final int SID = 128;
    }

    public WNSStream() {
        this.mQUA = null;
        this.mAppId = 0;
        this.mUin = 0L;
        this.mA2 = null;
        this.SUPPORT_COMPRESS = 1;
        this.mDeviceInfo = null;
        this.mRetryInfo = null;
    }

    private QmfBusiControl createBusiControl(boolean z16, int i3, int i16) {
        QmfBusiControl qmfBusiControl = new QmfBusiControl();
        qmfBusiControl.compFlag = z16 ? 1 : 0;
        qmfBusiControl.lenBeforeComp = i3;
        qmfBusiControl.rspCompFlag = i16;
        return qmfBusiControl;
    }

    public static <T extends JceStruct> T decodeWup(Class<T> cls, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                newInstance.readFrom(new JceInputStream(bArr));
                return newInstance;
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return null;
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:95), block:B:43:0x005e */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static byte[] decompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e16;
        Object obj;
        ?? e17 = 0;
        e17 = 0;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        try {
            try {
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                        try {
                            byte[] bArr3 = new byte[1024];
                            while (!inflater.finished()) {
                                byteArrayOutputStream.write(bArr3, 0, inflater.inflate(bArr3));
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            e17 = bArr3;
                        } catch (Exception e18) {
                            e16 = e18;
                            e16.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                                e17 = e16;
                            }
                            inflater.end();
                            return bArr;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            e17 = byteArrayOutputStream;
                            e.printStackTrace();
                            if (e17 != 0) {
                                try {
                                    e17.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            bArr = bArr2;
                            inflater.end();
                            return bArr;
                        }
                    } catch (Exception e27) {
                        byteArrayOutputStream = null;
                        e16 = e27;
                    } catch (OutOfMemoryError e28) {
                        e = e28;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    e17 = obj;
                    if (e17 != 0) {
                        try {
                            e17.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e36) {
                e17 = e36;
                e17.printStackTrace();
            }
            inflater.end();
            return bArr;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static byte[] encodeWup(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("UTF-8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public byte[] compress(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            try {
                try {
                    byte[] bArr3 = new byte[1024];
                    while (!deflater.finished()) {
                        byteArrayOutputStream.write(bArr3, 0, deflater.deflate(bArr3));
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    byteArrayOutputStream.close();
                } catch (OutOfMemoryError e17) {
                    e17.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    bArr = bArr2;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            deflater.end();
            return bArr;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            throw th5;
        }
    }

    QmfUpstream createQmfUpstream(int i3, String str, int i16, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, String str2, String str3, RetryInfo retryInfo) {
        if (bArr2 != null && bArr3 != null && bArr != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(1, new byte[]{0});
            return new QmfUpstream(i3, i16, j3, str2, str, str3, new QmfTokenInfo(64, bArr, hashMap), new QmfClientIpInfo((byte) 0, (short) 0, 0, new byte[]{0, 0, 0, 0, 0, 0}), bArr2, bArr3, 0L, 0L, retryInfo);
        }
        return null;
    }

    public byte[] pack(int i3, String str, byte[] bArr, boolean z16) {
        if (bArr == null) {
            return null;
        }
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.put(BUSICOMPCONTROL, createBusiControl(z16, bArr.length, this.SUPPORT_COMPRESS));
        if (z16) {
            byte[] compress = compress(bArr);
            if (compress == null) {
                return null;
            }
            return encodeWup(createQmfUpstream(i3, str, this.mAppId, this.mUin, this.mA2, compress, uniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
        }
        return encodeWup(createQmfUpstream(i3, str, this.mAppId, this.mUin, this.mA2, bArr, uniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
    }

    public byte[] packForUndeal(int i3, String str, byte[] bArr, boolean z16, JceStruct jceStruct) {
        if (bArr == null) {
            return null;
        }
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.put(BUSICOMPCONTROL, createBusiControl(z16, bArr.length, this.SUPPORT_COMPRESS));
        if (jceStruct != null) {
            uniAttribute.put("conf_info_req", jceStruct);
            uniAttribute.put("wns_sdk_version", new Integer(1));
        }
        if (z16) {
            byte[] compress = compress(bArr);
            if (compress == null) {
                return null;
            }
            return encodeWup(createQmfUpstream(i3, str, this.mAppId, this.mUin, this.mA2, compress, uniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
        }
        return encodeWup(createQmfUpstream(i3, str, this.mAppId, this.mUin, this.mA2, bArr, uniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
    }

    public QmfDownstream unpack(byte[] bArr) throws IOException {
        if (bArr != null) {
            return (QmfDownstream) decodeWup(QmfDownstream.class, bArr);
        }
        return null;
    }

    public WNSStream(int i3, String str, long j3, byte[] bArr, String str2) {
        this.SUPPORT_COMPRESS = 1;
        this.mRetryInfo = null;
        this.mAppId = i3;
        this.mQUA = str;
        this.mUin = j3;
        this.mA2 = bArr;
        this.mDeviceInfo = str2;
    }

    public WNSStream(int i3, String str, long j3, byte[] bArr, String str2, RetryInfo retryInfo) {
        this(i3, str, j3, bArr, str2);
        this.mRetryInfo = retryInfo;
    }
}
