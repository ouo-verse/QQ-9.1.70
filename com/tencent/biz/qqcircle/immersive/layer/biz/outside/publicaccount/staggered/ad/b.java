package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, a> f86751a = new ConcurrentHashMap<>();

    private String g(a aVar) {
        int i3;
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "parsePlayState error: playState is null");
            return "";
        }
        long endTime = aVar.getEndTime();
        int i16 = 0;
        if (endTime < 100) {
            QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "parsePlayState return: endTime is:", Long.valueOf(endTime));
            return "";
        }
        if (endTime < 200) {
            QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "parsePlayState endTime is threshold, origin:", Long.valueOf(endTime));
            endTime = 200;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bt", String.valueOf(aVar.getStartTime()));
            jSONObject.put(FileReaderHelper.ET_EXT, String.valueOf(endTime));
            if (aVar.getStartTime() == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("bf", String.valueOf(i3));
            if (aVar.getComplete()) {
                i16 = 1;
            }
            jSONObject.put("ef", String.valueOf(i16));
            jSONObject.put("pp", "0");
            jSONObject.put("pa", String.valueOf(aVar.getActionType()));
            jSONObject.put("ft", "3");
            jSONObject.put(Constants.KEYS.PLACEMENTS, "0");
            jSONObject.put("pt", "0");
        } catch (JSONException e16) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "parsePlayState error:" + e16);
        }
        return jSONObject.toString();
    }

    private void i(a aVar) {
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "reportVideoPlay playState is null");
            return;
        }
        String videoReportUrl = aVar.getVideoReportUrl();
        String g16 = g(aVar);
        if (TextUtils.isEmpty(g16)) {
            QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "reportVideoPlay playParam is null");
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 4, "reportVideoPlay reportUrl:" + videoReportUrl);
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 1, "reportVideoPlay reportParams:" + g16);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.d(String.format(Locale.CHINA, "%s&video=%s", videoReportUrl, URLEncoder.encode(g16)));
    }

    public void a(int i3, String str) {
        a aVar = new a();
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onInitReportParams");
        aVar.l(str);
        this.f86751a.put(Integer.valueOf(i3), aVar);
    }

    public void b(int i3, long j3) {
        a aVar = this.f86751a.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "onVideoComplete error: playState is null:" + i3);
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoComplete");
        aVar.h(true);
        aVar.i(j3);
        i(aVar);
        aVar.h(false);
    }

    public void c(int i3) {
        a aVar = this.f86751a.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "onVideoStart error: playState is null:" + i3);
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoLoopStart");
        aVar.g(14);
        e(i3, 0L);
    }

    public void d(int i3, long j3) {
        a aVar = this.f86751a.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "onVideoPause error: playState is null:" + i3);
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoPause");
        aVar.i(j3);
        aVar.j(true);
        i(aVar);
    }

    public void e(int i3, long j3) {
        a aVar = this.f86751a.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "onVideoStart error: playState is null:" + i3);
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoStart");
        aVar.k(j3);
        aVar.j(false);
    }

    public void f(int i3, long j3) {
        a aVar = this.f86751a.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.e("QFSPublicAccountAdCoverVideoReportHelper", 1, "onVideoStop error: playState is null:" + i3);
            return;
        }
        if (aVar.getPause()) {
            QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoStop return: playState is pause");
            return;
        }
        QLog.d("QFSPublicAccountAdCoverVideoReportHelper", 2, "onVideoStop");
        aVar.i(j3);
        i(aVar);
    }

    public void h(int i3) {
        this.f86751a.remove(Integer.valueOf(i3));
    }
}
