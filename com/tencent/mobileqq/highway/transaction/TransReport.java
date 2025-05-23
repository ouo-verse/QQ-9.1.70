package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TransReport {
    static IPatchRedirector $redirector_ = null;
    public static final String rep_BDH_Cache_Diff = "param_BDH_Cache_Diff";
    public static final String rep_BDH_LongVideo_First_Range = "param_BDH_LongVideo_First_Range";
    public static final String rep_BDH_LongVideo_Has_ReUpload = "param_BDH_LongVideo_HasReUpload";
    public static final String rep_BDH_Reason = "param_BDH_Reason";
    public static final String rep_Ip_ConnCost = "param_Ip_ConnCost";
    public static final String rep_Ip_Index = "param_ip_index";
    public static final String rep_Net_Detect = "NetDetect";
    public static final String rep_bdhTrans = "rep_bdhTrans";
    public static final String rep_confMaxConn = "param_conf_connNum";
    public static final String rep_confSegNum = "param_conf_segNum";
    public static final String rep_confSegSize = "param_conf_segSize";
    public static final String rep_connNUm = "connNum:";
    public static final String rep_dwFlow_Xg = "dwFlow_Xg";
    public static final String rep_dwFlow_wifi = "dwFlow_WiFi";
    public static final String rep_finLost = "param_fin_lost";
    public static final String rep_has_ipv6_list = "param_hasV6List";
    public static final String rep_has_net = "hasNet";
    public static final String rep_heart_resp = "param_heart_resp";
    public static final String rep_ip = "ip";
    public static final String rep_ip_type = "param_ipType";
    public static final String rep_ipv6_first = "param_ipv6First";
    public static final String rep_isPreConnExist = "PreConn:";
    public static final String rep_is_ipv6 = "param_is_ipv6";
    public static final String rep_net_type = "net:";
    public static final String rep_port = "port";
    public static final String rep_progress = "progress";
    public static final String rep_proto = "proto";
    public static final String rep_retry_code = "param_retry_code";
    public static final String rep_retry_max = "param_max_retry_times";
    public static final String rep_retry_seg_count = "param_retry_seg_count";
    public static final String rep_retry_total = "param_total_retry_times";
    public static final String rep_segsPerConn = "segspercnt";
    public static final String rep_slice_num = "sn:";
    public static final String rep_time_cache = "tc_p:";
    public static final String rep_time_ht = "tc_h:";
    public static final String rep_time_send = "tc_s:";
    public static final String rep_upFlow_Xg = "upFlow_Xg";
    public static final String rep_upFlow_wifi = "upFlow_WiFi";
    public boolean bCacheDiff;
    public boolean bFINLost;
    public boolean bHasNet;
    public long confConnNum;
    public long confSegNum;
    public long confSegSize;
    public int connErrCode;
    public int connNum;
    public long[] dataFlow;
    public String detectResult;
    public String failReason;
    public int firstRange;
    public boolean hasReUpload;
    public String ipAddr;
    public long ipConnCost;
    public int ipIndex;
    public boolean isConnected;
    public boolean isIpv6;
    public HashMap<Integer, AtomicInteger> mDataFlowOfChannel;
    public boolean mHasIpv6List;
    public boolean mIPv6Fast;
    public boolean mIsPreConnExist;
    public int mRetryCode;
    public int mRetryTimes_SegsMax;
    public int mRetryTimes_SegsNum;
    public int mRetryTimes_SegsTotal;
    public int mTransferedSize;
    public int netType;
    public String port;
    public String protoType;
    public int sliceNum;
    public int timeCost_Cache;
    public int timeCost_Ht;
    public int timeCost_Send;

    public TransReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDataFlowOfChannel = new HashMap<>();
        this.mIsPreConnExist = false;
        this.timeCost_Ht = 0;
        this.timeCost_Send = 0;
        this.timeCost_Cache = 0;
        this.sliceNum = 0;
        this.ipIndex = -1;
        this.ipAddr = "";
        this.port = "";
        this.ipConnCost = 0L;
        this.firstRange = 0;
        this.hasReUpload = false;
        this.bFINLost = false;
        this.bHasNet = false;
        this.isConnected = false;
        this.mRetryTimes_SegsNum = 0;
        this.mRetryTimes_SegsTotal = 0;
        this.mRetryTimes_SegsMax = 0;
        this.mTransferedSize = -1;
        this.bCacheDiff = false;
    }

    public HashMap<String, String> getReportInfo() {
        String str;
        String str2;
        String str3;
        long j3;
        long j16;
        long j17;
        long j18;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        int i3 = this.netType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            str = "UnKnow";
                        } else {
                            str = "CABLE";
                        }
                    } else {
                        str = "4G";
                    }
                } else {
                    str = "3G";
                }
            } else {
                str = "2G";
            }
        } else {
            str = "WiFi";
        }
        StringBuilder sb5 = new StringBuilder("");
        int i16 = 0;
        for (AtomicInteger atomicInteger : this.mDataFlowOfChannel.values()) {
            if (i16 >= 5) {
                break;
            }
            if (i16 > 0) {
                sb5.append("_");
            }
            sb5.append(atomicInteger.get());
            i16++;
        }
        StringBuilder sb6 = new StringBuilder("");
        sb6.append(rep_slice_num);
        sb6.append(this.sliceNum);
        sb6.append(";");
        sb6.append(rep_time_send);
        sb6.append(this.timeCost_Send);
        sb6.append(";");
        sb6.append(rep_time_ht);
        sb6.append(this.timeCost_Ht);
        sb6.append(";");
        sb6.append(rep_time_cache);
        sb6.append(this.timeCost_Cache);
        sb6.append(";");
        sb6.append(rep_net_type);
        sb6.append(str);
        sb6.append(";");
        sb6.append("ip");
        sb6.append(":");
        sb6.append(this.ipAddr);
        sb6.append(";");
        sb6.append("port");
        sb6.append(":");
        sb6.append(this.port);
        sb6.append(";");
        sb6.append(rep_connNUm);
        sb6.append(this.connNum);
        sb6.append(";");
        sb6.append(rep_isPreConnExist);
        if (this.mIsPreConnExist) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        sb6.append(str2);
        sb6.append(";");
        sb6.append(rep_confSegSize);
        sb6.append(":");
        sb6.append(this.confSegSize);
        sb6.append(";");
        sb6.append(rep_confSegNum);
        sb6.append(":");
        sb6.append(this.confSegNum);
        sb6.append(";");
        sb6.append(rep_confMaxConn);
        sb6.append(":");
        sb6.append(this.confConnNum);
        sb6.append(";");
        sb6.append("proto");
        sb6.append(":");
        sb6.append(this.protoType);
        sb6.append(";");
        sb6.append(rep_has_net);
        sb6.append(":");
        if (this.bHasNet) {
            str3 = "true";
        } else {
            str3 = "false";
        }
        sb6.append(str3);
        sb6.append(";");
        sb6.append("progress");
        sb6.append(":");
        sb6.append(this.mTransferedSize);
        sb6.append(";");
        sb6.append(rep_BDH_Reason);
        sb6.append(this.failReason);
        sb6.append(";");
        long[] jArr = this.dataFlow;
        if (jArr != null && jArr.length >= 4) {
            j3 = jArr[0];
            j16 = jArr[1];
            j17 = jArr[2];
            j18 = jArr[3];
        } else {
            j3 = 0;
            j16 = 0;
            j17 = 0;
            j18 = 0;
        }
        hashMap.put(rep_upFlow_wifi, String.valueOf(j3));
        hashMap.put(rep_dwFlow_wifi, String.valueOf(j16));
        hashMap.put(rep_upFlow_Xg, String.valueOf(j17));
        hashMap.put(rep_dwFlow_Xg, String.valueOf(j18));
        hashMap.put(rep_time_cache, String.valueOf(this.timeCost_Cache));
        hashMap.put(rep_bdhTrans, sb6.toString());
        hashMap.put(rep_confSegSize, String.valueOf(this.confSegSize));
        hashMap.put(rep_confSegNum, String.valueOf(this.confSegNum));
        hashMap.put(rep_confMaxConn, String.valueOf(this.confConnNum));
        hashMap.put(rep_segsPerConn, sb5.toString());
        if (this.bFINLost) {
            valueOf = String.valueOf(true);
        } else {
            valueOf = String.valueOf(false);
        }
        hashMap.put(rep_finLost, valueOf);
        hashMap.put(rep_retry_seg_count, String.valueOf(this.mRetryTimes_SegsNum));
        hashMap.put(rep_retry_total, String.valueOf(this.mRetryTimes_SegsTotal));
        hashMap.put(rep_retry_max, String.valueOf(this.mRetryTimes_SegsMax));
        hashMap.put(rep_retry_code, String.valueOf(this.mRetryCode));
        hashMap.put(rep_Ip_Index, String.valueOf(this.ipIndex));
        hashMap.put(rep_Ip_ConnCost, String.valueOf(this.ipConnCost));
        hashMap.put("ip", String.valueOf(this.ipAddr));
        hashMap.put("port", this.port);
        hashMap.put(rep_BDH_Cache_Diff, String.valueOf(this.bCacheDiff));
        hashMap.put(rep_is_ipv6, String.valueOf(this.isIpv6 ? 1 : 0));
        hashMap.put(rep_ipv6_first, String.valueOf(this.mIPv6Fast ? 1 : 0));
        hashMap.put(rep_has_ipv6_list, String.valueOf(this.mHasIpv6List ? 1 : 0));
        return hashMap;
    }

    public void setFailReason(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        this.failReason = "BDH_E_" + i3 + "_N_" + this.connErrCode + "_D_" + str;
    }

    public void updateRetryInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            if (i3 == 0) {
                return;
            }
            if (i3 > this.mRetryTimes_SegsMax) {
                this.mRetryTimes_SegsMax = i3;
            }
            this.mRetryTimes_SegsNum++;
            this.mRetryTimes_SegsTotal += i3;
        }
    }
}
