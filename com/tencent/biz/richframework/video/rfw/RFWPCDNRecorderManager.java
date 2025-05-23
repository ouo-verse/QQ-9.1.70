package com.tencent.biz.richframework.video.rfw;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWPCDNRecorderManager {
    private static volatile RFWPCDNRecorderManager S_INSTANCE;
    private final HashSet<String> mERRORRecSet = new HashSet<>();
    private final HashSet<Integer> mTargetErrorSet;

    RFWPCDNRecorderManager() {
        HashSet<Integer> hashSet = new HashSet<>();
        this.mTargetErrorSet = hashSet;
        hashSet.add(1610001);
        hashSet.add(1612001);
        hashSet.add(1612002);
        hashSet.add(1612003);
        hashSet.add(1612004);
        hashSet.add(1612005);
    }

    public static RFWPCDNRecorderManager g() {
        if (S_INSTANCE == null) {
            synchronized (RFWPCDNRecorderManager.class) {
                if (S_INSTANCE == null) {
                    S_INSTANCE = new RFWPCDNRecorderManager();
                }
            }
        }
        return S_INSTANCE;
    }

    public void decodeAdnRecPCDNFailedInfo(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str2);
            int i3 = jSONObject.getInt("stopReason");
            if (TextUtils.isEmpty(str)) {
                str = jSONObject.getString("fileId");
            }
            if (this.mTargetErrorSet.contains(Integer.valueOf(i3)) && !this.mERRORRecSet.contains(str)) {
                RFWLog.d("RFWPCDNRecorderManager", RFWLog.USR, "pcdn filed not enable next:" + str + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + str3);
                this.mERRORRecSet.add(str);
            }
        } catch (Exception e16) {
            RFWLog.d("RFWPCDNRecorderManager", RFWLog.USR, e16);
        }
    }

    public boolean enablePCDN(String str) {
        if (!RFWVideoFluencyExp9095.hitExpB() || !this.mERRORRecSet.contains(str)) {
            return true;
        }
        return com.tencent.mobileqq.qcircle.api.utils.c.h();
    }
}
