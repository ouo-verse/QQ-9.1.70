package com.tencent.mobileqq.search.base.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VADHelper {

    /* renamed from: a, reason: collision with root package name */
    private static String f282802a = "VADHelper";

    /* renamed from: b, reason: collision with root package name */
    private static int f282803b = RecordParams.f307251b;

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f282804c = new ConcurrentHashMap<>(new HashMap(8));

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long[]> f282805d = new ConcurrentHashMap<>(new HashMap());

    /* renamed from: e, reason: collision with root package name */
    public static boolean f282806e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f282807f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f282808g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            VADHelper.f282808g = false;
            dialogInterface.dismiss();
        }
    }

    public static void a() {
        f282804c.clear();
        f282805d.clear();
    }

    public static float b(String str) {
        Long[] lArr;
        if (f282806e && str != null && (lArr = f282805d.get(str)) != null && lArr[0].longValue() > 0) {
            float longValue = ((float) lArr[1].longValue()) / ((float) lArr[0].longValue());
            if (QLog.isColorLevel()) {
                QLog.i(f282802a, 2, str + ", AVG.cost=" + (lArr[1].longValue() / lArr[0].longValue()) + " totalTime:" + lArr[1] + " count:" + lArr[0]);
                return longValue;
            }
            return longValue;
        }
        return 0.0f;
    }

    public static long c(String str) {
        Long[] lArr;
        Long l3;
        if (!f282806e || str == null || (lArr = f282805d.get(str)) == null || lArr[0].longValue() <= 0 || (l3 = lArr[1]) == null) {
            return 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f282802a, 2, str + ", AVG.cost=" + (lArr[1].longValue() / lArr[0].longValue()) + " totalTime:" + lArr[1] + " count:" + lArr[0]);
        }
        return l3.longValue();
    }

    public static void d(Context context) {
        if (f282806e && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u670d\u52a1\u5668\u8bc6\u522b\u8017\u65f6\uff1a" + c("voice_search_server_cost") + " ms \n");
            sb5.append("\u9884\u641c\u7d22\u8017\u65f6\uff1a" + c("voice_search_pre_cost") + " ms \n");
            sb5.append("\u7cbe\u786e\u641c\u7d22\u8017\u65f6\uff1a" + c("voice_search_accurate_cost") + " ms \n");
            sb5.append("\u6a21\u7cca\u641c\u7d22\u8017\u65f6\uff1a" + c("voice_search_approximate_cost") + " ms \n");
            sb5.append("\u672c\u5730\u641c\u7d22\u603b\u8017\u65f6\uff1a" + c("voice_search_als_cost") + " ms \n");
            sb5.append("\u8bed\u97f3\u641c\u7d22\u603b\u8017\u65f6\uff1a" + c("voice_search_all_cost") + " ms \n");
            sb5.append("EditDistance\u603b\u8017\u65f6\uff1a" + c("voice_search_distance_cost") + " ms,\u5e73\u5747 \uff1a" + String.format("%.4f", Float.valueOf(b("voice_search_distance_cost"))) + " ms \n");
            sb5.append("\u58f0\u6bcd\u97f5\u6bcd\u603b\u8017\u65f6\uff1a" + c("voice_search_sy_cost") + " ms,\u5e73\u5747 \uff1a" + String.format("%.4f", Float.valueOf(b("voice_search_sy_cost"))) + " ms");
            QLog.i(f282802a, 2, sb5.toString());
            if (f282807f && !f282808g) {
                DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.uxt), sb5.toString(), "", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new a(), (DialogInterface.OnClickListener) null).show();
                f282808g = true;
            }
            a();
        }
    }

    public static void e(String str) {
        Long remove;
        if (f282806e) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (str != null && (remove = f282804c.remove(str)) != null) {
                Long[] lArr = f282805d.get(str);
                if (lArr == null) {
                    lArr = new Long[]{1L, Long.valueOf(uptimeMillis - remove.longValue())};
                } else {
                    lArr[0] = Long.valueOf(lArr[0].longValue() + 1);
                    lArr[1] = Long.valueOf(lArr[1].longValue() + (uptimeMillis - remove.longValue()));
                }
                f282805d.put(str, lArr);
            }
        }
    }

    public static void f(String str) {
        if (f282806e) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (str != null) {
                f282804c.put(str, Long.valueOf(uptimeMillis));
            }
        }
    }

    public native int calcOneFrameBytes(int i3, int i16);

    public native long create(String str);

    public native int destroy(long j3);

    public native int init(long j3, int i3, int i16);

    public native int process(long j3, byte[] bArr, int i3, float[] fArr);
}
