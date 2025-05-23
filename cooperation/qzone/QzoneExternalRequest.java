package cooperation.qzone;

import QMF_PROTOCAL.RetryInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.util.ProtocolUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class QzoneExternalRequest {
    public static final String FIELD_REFER = "refer";
    public static final String FIELD_UIN = "hostuin";
    public static final int QZONE_BUSSINESS_ID = 1000027;
    public static final String TAIL_NAME = "tail_name";
    private String deviceTail;
    protected long hostUin;
    private String refer;
    private RetryInfo retryInfo;
    private String charset = "utf-8";
    protected boolean needCompress = true;
    private long loginUserId = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static JceStruct decode(byte[] bArr, String str) {
        return ProtocolUtils.decode(bArr, str);
    }

    public byte[] encode() {
        WNSStream wNSStream = new WNSStream(1000027, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3(), getLoginUserId(), new byte[0], getDeviceInfo(), (RetryInfo) getRetryInfo());
        byte[] encodedUniParameter = getEncodedUniParameter();
        if (encodedUniParameter != null) {
            return fh.b(wNSStream.pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), encodedUniParameter, this.needCompress));
        }
        return null;
    }

    public String getCharset() {
        return this.charset;
    }

    public abstract String getCmdString();

    public String getDeviceInfo() {
        return ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getDeviceInfor();
    }

    public String getDeviceTail() {
        return this.deviceTail;
    }

    protected byte[] getEncodedUniParameter() {
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("hostuin", Long.valueOf(getHostUin()));
        String uniKey = uniKey();
        if (!TextUtils.isEmpty(uniKey)) {
            uniAttribute.put(uniKey, getReq());
        }
        String refer = getRefer();
        this.refer = refer;
        if (!TextUtils.isEmpty(refer)) {
            uniAttribute.put("refer", this.refer);
        }
        String deviceTail = getDeviceTail();
        if (!TextUtils.isEmpty(deviceTail)) {
            uniAttribute.put(TAIL_NAME, deviceTail);
        }
        return uniAttribute.encode();
    }

    protected long getHostUin() {
        return this.hostUin;
    }

    public long getLoginUserId() {
        return this.loginUserId;
    }

    public byte[] getRawReq() {
        return null;
    }

    public String getRawReqType() {
        return null;
    }

    public String getRefer() {
        return this.refer;
    }

    public abstract JceStruct getReq();

    public Object getRetryInfo() {
        return this.retryInfo;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setDeviceTail(String str) {
        this.deviceTail = str;
    }

    public void setHostUin(long j3) {
        this.hostUin = j3;
    }

    public void setLoginUserId(long j3) {
        this.loginUserId = j3;
    }

    public void setRefer(String str) {
        this.refer = str;
    }

    public abstract String uniKey();

    /* JADX INFO: Access modifiers changed from: protected */
    public static JceStruct decode(byte[] bArr, String str, int[] iArr) {
        return ProtocolUtils.decode(bArr, str, iArr);
    }

    protected static JceStruct decode(byte[] bArr, String str, int[] iArr, String[] strArr) {
        return ProtocolUtils.decode(bArr, str, iArr, strArr);
    }
}
