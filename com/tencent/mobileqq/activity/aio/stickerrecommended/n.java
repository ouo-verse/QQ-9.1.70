package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {
    static {
        UserAction.registerTunnel(new TunnelInfo("00000BXKOY3QZQ1E"));
    }

    private static boolean a() {
        if (System.currentTimeMillis() % 1000 < 10) {
            return true;
        }
        return false;
    }

    public static void b(HashMap<String, String> hashMap) {
        if (!a()) {
            return;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "click", true, 0L, 0L, hashMap, (String) null);
    }

    public static void c(HashMap<String, String> hashMap) {
        if (!a()) {
            return;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "expo", true, 0L, 0L, hashMap, (String) null);
    }

    public static void d(boolean z16, String str, int i3, String str2, IStickerRecEmoticon iStickerRecEmoticon) {
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("pic_md5", iStickerRecEmoticon.getImgMd5());
        hashMap.put("pic_url", iStickerRecEmoticon.getImgUrl());
        hashMap.put("aio_type", com.tencent.mobileqq.core.util.a.e(i3));
        if (iStickerRecEmoticon instanceof StickerRecData) {
            StickerRecData stickerRecData = (StickerRecData) iStickerRecEmoticon;
            String algoInfo = stickerRecData.getAlgoInfo();
            if (algoInfo != null) {
                hashMap.put("algo_info", algoInfo);
            }
            String recomTransfer = stickerRecData.getRecomTransfer();
            if (recomTransfer != null) {
                hashMap.put("recom_transfer", recomTransfer);
            }
        }
        String reportEventPrefix = iStickerRecEmoticon.getReportEventPrefix();
        if (reportEventPrefix != null && reportEventPrefix.length() > 1 && reportEventPrefix.endsWith("-")) {
            hashMap.put("source", reportEventPrefix.substring(0, 1));
        }
        if (str2 != null) {
            hashMap.put("target_qq", str2);
        }
        hashMap.put(SegmentKeeper.KEY_DURATION, iStickerRecEmoticon.exposedTime() + "");
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (!StringUtil.isValideUin(account)) {
            account = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
        }
        hashMap.put("report_qq", account);
        if (z16) {
            c(hashMap);
        } else {
            b(hashMap);
        }
    }
}
