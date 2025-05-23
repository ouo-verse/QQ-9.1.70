package com.tencent.component.network.module.report;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.network.Global;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.SDCardUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReportObj {
    public static final int APP_ID_HEAD = 6;
    public static final int APP_ID_PHOTO = 0;
    public static final int APP_ID_QQ_QUN_PHOTO = 10;
    public static final int APP_ID_SOUND = 4;
    public static final int APP_ID_UPP = 8;
    public static final int APP_ID_VIDEO = 2;
    private static final String APP_TYPE_HEAD = "qzone_head";
    private static final String APP_TYPE_PHOTO = "photo";
    private static final String APP_TYPE_QQ_QUN_PHOTO = "groupphoto";
    private static final String APP_TYPE_SOUND = "qzone_sound";
    private static final String APP_TYPE_UPP = "upp";
    private static final String APP_TYPE_VIDEO = "qzone_video";
    public static boolean IS_CONNECT_USB = false;
    public static final int OP_DOWN = 1;
    public static final int OP_UP = 0;
    public static final String REPORT_REFER_QQ_QUN = "mqun";
    private static final String REPORT_URL = "https://expeva.store.qq.com/";
    public String domain;
    public long downloadTime;
    public long elapse;
    public long endTime;
    public StringBuilder errMsg;
    public ExtendData extend;
    public long fileSize;
    public int flow;
    public boolean isFromQzoneAlbum;
    public boolean isHttp2;
    public boolean isSucceed;
    public int networkType;
    public String refer;
    public int retCode;
    public String serverIp;
    public long startTime;
    public int strategyId;
    public String terminal;
    public String version;

    public ReportObj() {
        this.terminal = "Android";
        this.version = "0.0.1";
        this.refer = "unknown";
        this.networkType = 0;
        this.retCode = 0;
        this.serverIp = "";
        this.fileSize = 0L;
        this.elapse = 0L;
        this.errMsg = new StringBuilder();
        this.extend = null;
        this.isSucceed = false;
    }

    public static String getReportUrl(int i3, int i16) {
        String str;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 != 8) {
                            if (i3 != 10) {
                                return "";
                            }
                            str = REPORT_URL + APP_TYPE_QQ_QUN_PHOTO;
                        } else {
                            str = REPORT_URL + "upp";
                        }
                    } else {
                        str = REPORT_URL + APP_TYPE_HEAD;
                    }
                } else {
                    str = REPORT_URL + APP_TYPE_SOUND;
                }
            } else {
                str = REPORT_URL + APP_TYPE_VIDEO;
            }
        } else {
            str = REPORT_URL + "photo";
        }
        String str2 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (i16 == 0) {
            return str2 + "op=upload";
        }
        if (i16 != 1) {
            return "";
        }
        return str2 + "op=down";
    }

    private static String putAddress(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3 & 255);
        stringBuffer.append('.');
        int i16 = i3 >>> 8;
        stringBuffer.append(i16 & 255);
        stringBuffer.append('.');
        int i17 = i16 >>> 8;
        stringBuffer.append(i17 & 255);
        stringBuffer.append('.');
        stringBuffer.append((i17 >>> 8) & 255);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRefer() {
        return this.refer;
    }

    public void init() {
        this.terminal = Config.getTerminal();
        this.version = Config.getVersion();
        this.refer = Config.getRefer();
    }

    public JSONObject toJSON() throws JSONException {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", this.fileSize);
            jSONObject.put("delay", this.elapse);
            jSONObject.put("network", this.networkType);
            jSONObject.put("terminal", this.terminal);
            jSONObject.put("terminalver", this.version);
            jSONObject.put("refer", getRefer());
            jSONObject.put("errcode", this.retCode);
            jSONObject.put("uin", Config.getCurrentUin());
            jSONObject.put("time", this.endTime / 1000);
            jSONObject.put("flow", this.flow);
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.serverIp);
            StringBuilder sb5 = this.errMsg;
            if (sb5 != null && sb5.length() > 0) {
                jSONObject.put("msg", this.errMsg.toString());
                if (this.extend == null) {
                    this.extend = new ExtendData();
                }
                DhcpInfo dhcpInfo = NetworkMonitor.getDhcpInfo((WifiManager) Global.getContext().getSystemService("wifi"));
                String str = "none";
                if (dhcpInfo != null) {
                    str = putAddress(dhcpInfo.dns1) + "," + putAddress(dhcpInfo.dns2);
                }
                int i16 = 0;
                this.extend.put(0, DeviceInfoMonitor.getModel());
                this.extend.put(1, Build.VERSION.RELEASE);
                ExtendData extendData = this.extend;
                if (SDCardUtil.isSDCardMounted()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                extendData.put(2, String.valueOf(i3));
                this.extend.put(3, SDCardUtil.getSDCardCapabilityForDisplay());
                this.extend.put(4, SDCardUtil.getSDCardRemainForDisplay());
                this.extend.put(6, str);
                ExtendData extendData2 = this.extend;
                if (IS_CONNECT_USB) {
                    i16 = 1;
                }
                extendData2.put(7, String.valueOf(i16));
                jSONObject.put(QFSEdgeItem.KEY_EXTEND, this.extend.getExtendString());
            }
        } catch (Throwable th5) {
            QDLog.e("BusinessReport", "to json error!", th5);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("networkType = ");
        int i3 = this.networkType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    sb5.append("\u672a\u77e5");
                } else {
                    sb5.append("2G");
                }
            } else {
                sb5.append("3G");
            }
        } else {
            sb5.append(com.tencent.ams.adcore.mma.api.Global.TRACKING_WIFI);
        }
        sb5.append(" retCode = ");
        sb5.append(this.retCode);
        sb5.append(" fileSize = ");
        sb5.append(this.fileSize);
        sb5.append(" elapse = ");
        sb5.append(this.elapse);
        sb5.append(" errMsg = ");
        sb5.append(this.errMsg.toString());
        return sb5.toString();
    }

    public ReportObj(int i3, int i16, String str, long j3, long j16, long j17, int i17, String str2, ExtendData extendData) {
        this.terminal = "Android";
        this.version = "0.0.1";
        this.refer = "unknown";
        this.networkType = 0;
        this.retCode = 0;
        this.serverIp = "";
        this.fileSize = 0L;
        this.elapse = 0L;
        StringBuilder sb5 = new StringBuilder();
        this.errMsg = sb5;
        this.extend = null;
        this.isSucceed = false;
        this.networkType = i3;
        this.retCode = i16;
        this.serverIp = str;
        this.fileSize = j3;
        this.startTime = j16;
        this.endTime = j17;
        this.elapse = j17 - j16;
        this.flow = i17;
        sb5.append(str2 != null ? str2 : "");
        this.extend = extendData;
    }
}
