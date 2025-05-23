package com.tencent.mobileqq.highway.codec;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpException;

/* loaded from: classes9.dex */
public class TcpProtocolDataCodec {
    static IPatchRedirector $redirector_ = null;
    private static final int ETX_C = 41;
    public static final int MAX_PKG_SIZE = 1048576;
    private static final int PROTO_COSNST_LEN = 10;
    private static final int STX_C = 40;
    private static final int VERSION_CODE_1 = 1;
    private static final int VERSION_CODE_2 = 2;
    protected IProtocolCodecListener codecListener;
    protected byte[] revData;
    public String versionCode;

    /* loaded from: classes9.dex */
    public interface DataFlag {
        public static final int FLAG_NORMAL = 4096;
    }

    public TcpProtocolDataCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.versionCode = null;
        }
    }

    private CSDataHighwayHead.DataHighwayHead buildHWHead(HwRequest hwRequest) {
        byte[] bArr;
        CSDataHighwayHead.DataHighwayHead dataHighwayHead = new CSDataHighwayHead.DataHighwayHead();
        if (hwRequest.isOpenUpEnable) {
            dataHighwayHead.uint32_version.set(2);
        } else {
            dataHighwayHead.uint32_version.set(1);
        }
        dataHighwayHead.uint32_appid.set(hwRequest.appid);
        dataHighwayHead.uint32_seq.set(hwRequest.getHwSeq());
        dataHighwayHead.uint32_dataflag.set(hwRequest.dataFlag);
        dataHighwayHead.uint32_retry_times.set(hwRequest.retryCount);
        dataHighwayHead.uint32_command_id.set(hwRequest.mBuCmdId);
        byte[] bArr2 = null;
        try {
            bArr = hwRequest.account.getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            bArr = null;
        }
        try {
            bArr2 = hwRequest.hwCmd.getBytes("utf-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
        }
        dataHighwayHead.bytes_uin.set(ByteStringMicro.copyFrom(bArr));
        dataHighwayHead.bytes_command.set(ByteStringMicro.copyFrom(bArr2));
        if (hwRequest.isOpenUpEnable) {
            try {
                byte[] bytes = getVersionCode().getBytes("utf-8");
                if (bytes != null) {
                    dataHighwayHead.bytes_build_ver.set(ByteStringMicro.copyFrom(bytes));
                }
            } catch (UnsupportedEncodingException e18) {
                e18.printStackTrace();
            }
        }
        int i3 = hwRequest.localeId;
        if (i3 > 0) {
            dataHighwayHead.locale_id.set(i3);
        }
        int customEnvId = ConfigManager.getCustomEnvId();
        if (customEnvId > 0) {
            dataHighwayHead.env_id.set(customEnvId);
        }
        return dataHighwayHead;
    }

    private int decodePackage(byte[] bArr, List<HwResponse> list) {
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        int length = bArr.length;
        boolean z19 = false;
        if (length == 0 || length < 10) {
            return 0;
        }
        if (length > 1048576) {
            BdhLogUtil.LogEvent("N", "Decode Error : BufLen > MAX_PKG_SIZE");
            IProtocolCodecListener iProtocolCodecListener = this.codecListener;
            if (iProtocolCodecListener != null) {
                iProtocolCodecListener.onDecodeInvalidData(1);
            }
            return 0;
        }
        if (bArr[0] != 40) {
            BdhLogUtil.LogEvent("N", "Decode Error : revData[0] != STX_C");
            IProtocolCodecListener iProtocolCodecListener2 = this.codecListener;
            if (iProtocolCodecListener2 != null) {
                iProtocolCodecListener2.onDecodeInvalidData(2);
            }
            return 0;
        }
        int longData = (int) BdhUtils.getLongData(bArr, 1);
        int longData2 = (int) BdhUtils.getLongData(bArr, 5);
        int i3 = longData + 10 + longData2;
        if (bArr.length < i3) {
            return 0;
        }
        byte[] bArr2 = new byte[longData];
        byte[] bArr3 = new byte[longData2];
        BdhUtils.copyData(bArr2, 0, bArr, 9, longData);
        int i16 = 9 + longData;
        BdhUtils.copyData(bArr3, 0, bArr, i16, longData2);
        if (bArr[i16 + longData2] != 41) {
            IProtocolCodecListener iProtocolCodecListener3 = this.codecListener;
            if (iProtocolCodecListener3 != null) {
                iProtocolCodecListener3.onDecodeInvalidData(2);
            }
            return 0;
        }
        CSDataHighwayHead.RspDataHighwayHead rspDataHighwayHead = new CSDataHighwayHead.RspDataHighwayHead();
        try {
            rspDataHighwayHead.mergeFrom(bArr2);
            z16 = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = false;
        }
        if (!z16) {
            IProtocolCodecListener iProtocolCodecListener4 = this.codecListener;
            if (iProtocolCodecListener4 != null) {
                iProtocolCodecListener4.onDecodeInvalidData(2);
            }
            return 0;
        }
        CSDataHighwayHead.DataHighwayHead dataHighwayHead = rspDataHighwayHead.msg_basehead.get();
        HwResponse hwResponse = new HwResponse();
        hwResponse.hwSeq = dataHighwayHead.uint32_seq.get();
        hwResponse.retCode = rspDataHighwayHead.uint32_error_code.get();
        hwResponse.mRespData = bArr3;
        hwResponse.mBuExtendinfo = rspDataHighwayHead.bytes_rsp_extendinfo.get().toByteArray();
        hwResponse.recvTime = SystemClock.uptimeMillis();
        if (rspDataHighwayHead.uint64_range.has()) {
            hwResponse.range = (int) rspDataHighwayHead.uint64_range.get();
        }
        if (rspDataHighwayHead.uint32_is_reset.has()) {
            if (rspDataHighwayHead.uint32_is_reset.get() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            hwResponse.needReUpload = z18;
        }
        try {
            str = new String(dataHighwayHead.bytes_command.get().toByteArray(), "utf-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            str = null;
        }
        hwResponse.cmd = str;
        if (rspDataHighwayHead.uint32_htcost.has()) {
            hwResponse.htCost = rspDataHighwayHead.uint32_htcost.get();
        }
        if (rspDataHighwayHead.uint32_cachecost.has()) {
            hwResponse.cacheCost = rspDataHighwayHead.uint32_cachecost.get();
        }
        if (rspDataHighwayHead.uint32_allow_retry.has()) {
            if (rspDataHighwayHead.uint32_allow_retry.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            hwResponse.shouldRetry = z17;
        }
        if (rspDataHighwayHead.msg_seghead.has()) {
            CSDataHighwayHead.SegHead segHead = rspDataHighwayHead.msg_seghead.get();
            hwResponse.segmentResp = segHead;
            hwResponse.buzRetCode = segHead.uint32_rtcode.get();
            if ((segHead.uint32_flag.get() & 1) == 1) {
                z19 = true;
            }
            hwResponse.isFinish = z19;
        }
        hwResponse.respLength = i3;
        list.add(hwResponse);
        return i3;
    }

    public boolean decodeS2CData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr)).booleanValue();
        }
        if (bArr != null && bArr.length > 0) {
            byte[] bArr2 = this.revData;
            if (bArr2 != null) {
                int length = bArr2.length;
                byte[] bArr3 = new byte[bArr.length + length];
                BdhUtils.copyData(bArr3, 0, bArr2, 0, length);
                BdhUtils.copyData(bArr3, length, bArr, 0, bArr.length);
                this.revData = bArr3;
            } else {
                this.revData = bArr;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                int decodePackage = decodePackage(this.revData, arrayList);
                if (decodePackage <= 0) {
                    break;
                }
                byte[] bArr4 = this.revData;
                byte[] bArr5 = new byte[bArr4.length - decodePackage];
                BdhUtils.copyData(bArr5, 0, bArr4, decodePackage, bArr4.length - decodePackage);
                this.revData = bArr5;
            }
            if (arrayList.size() > 0) {
                IProtocolCodecListener iProtocolCodecListener = this.codecListener;
                if (iProtocolCodecListener != null) {
                    iProtocolCodecListener.onDecodeSucessfully(arrayList);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public byte[] encodeC2SData(EndPoint endPoint, HwRequest hwRequest, byte[] bArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, this, endPoint, hwRequest, bArr);
        }
        CSDataHighwayHead.ReqDataHighwayHead reqDataHighwayHead = new CSDataHighwayHead.ReqDataHighwayHead();
        CSDataHighwayHead.DataHighwayHead buildHWHead = buildHWHead(hwRequest);
        if (buildHWHead != null) {
            reqDataHighwayHead.msg_basehead.set(buildHWHead);
        }
        CSDataHighwayHead.SegHead segmentHead = hwRequest.getSegmentHead();
        if (segmentHead != null) {
            reqDataHighwayHead.msg_seghead.set(segmentHead);
        }
        byte[] extendInfo = hwRequest.getExtendInfo();
        if (extendInfo != null) {
            reqDataHighwayHead.bytes_req_extendinfo.set(ByteStringMicro.copyFrom(extendInfo));
        }
        CSDataHighwayHead.LoginSigHead loginSigHead = hwRequest.getLoginSigHead();
        if (loginSigHead != null) {
            if (hwRequest.isOpenUpEnable) {
                reqDataHighwayHead.msg_login_sig_head.set(loginSigHead);
            } else if (segmentHead != null && segmentHead.uint64_dataoffset.get() == 0) {
                reqDataHighwayHead.msg_login_sig_head.set(loginSigHead);
            }
        }
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        byte[] byteArray = reqDataHighwayHead.toByteArray();
        int length = byteArray.length + 10 + i3;
        byte[] bArr2 = new byte[length];
        hwRequest.bodyLength = i3;
        hwRequest.headLength = byteArray.length + 10;
        bArr2[0] = 40;
        BdhUtils.DWord2Byte(bArr2, 1, byteArray.length);
        BdhUtils.DWord2Byte(bArr2, 5, i3);
        BdhUtils.copyData(bArr2, 9, byteArray, 0, byteArray.length);
        int length2 = 9 + byteArray.length;
        if (i3 != 0) {
            BdhUtils.copyData(bArr2, length2, bArr, 0, i3);
        }
        bArr2[length - 1] = 41;
        return bArr2;
    }

    public String getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.versionCode;
        if (str != null) {
            return str;
        }
        this.versionCode = "unkownVersion";
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 0);
            this.versionCode = packageInfo.versionName + "." + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            this.versionCode = "unkownVersion";
            e16.printStackTrace();
        }
        return this.versionCode;
    }

    public void onRecvData(MsfSocketInputBuffer msfSocketInputBuffer) throws IOException, HttpException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfSocketInputBuffer);
            return;
        }
        int bufferlen = msfSocketInputBuffer.getBufferlen();
        byte[] bArr = new byte[bufferlen];
        System.arraycopy(msfSocketInputBuffer.getBuffer(), 0, bArr, 0, bufferlen);
        decodeS2CData(bArr);
    }

    public void setProtocolCodecListener(IProtocolCodecListener iProtocolCodecListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProtocolCodecListener);
        } else {
            this.codecListener = iProtocolCodecListener;
        }
    }
}
