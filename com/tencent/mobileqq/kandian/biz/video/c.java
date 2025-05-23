package com.tencent.mobileqq.kandian.biz.video;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import r52.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f239565a;

    /* renamed from: b, reason: collision with root package name */
    private static JSONObject f239566b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<b> f239567c;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f239568d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f239569e = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f239570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f239571b;

        a(b bVar, HashMap hashMap) {
            this.f239570a = bVar;
            this.f239571b = hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f239572a;

        /* renamed from: b, reason: collision with root package name */
        public long f239573b;

        /* renamed from: c, reason: collision with root package name */
        public long f239574c;

        /* renamed from: d, reason: collision with root package name */
        public float f239575d;

        /* renamed from: e, reason: collision with root package name */
        public int f239576e;

        /* renamed from: f, reason: collision with root package name */
        public String f239577f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<d> f239578g = new ArrayList<>();

        b() {
        }
    }

    private static boolean a() {
        String str = (String) com.tencent.mobileqq.kandian.base.utils.c.c("kandian_video_extract_frame", "");
        if (QLog.isColorLevel()) {
            QLog.d("VideoExtractFrame", 2, "serverConfig = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f239565a = jSONObject;
            String string = jSONObject.getString("version");
            int i3 = f239565a.getInt("tryCount");
            int i16 = f239565a.getInt("succCount");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            if (NetworkUtil.getSystemNetwork(null) != 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoExtractFrame", 2, "\u5f53\u524d\u7f51\u7edc\u73af\u5883\u975eWIFI\uff0c\u4e0d\u8fdb\u884c\u68c0\u6d4b\u903b\u8f91");
                }
                return false;
            }
            String str2 = (String) com.tencent.mobileqq.kandian.base.utils.c.c("kandian_video_extract_frame_local_result", "");
            if (QLog.isColorLevel()) {
                QLog.d("VideoExtractFrame", 2, "localResult = " + str2);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    f239566b = jSONObject2;
                    String optString = jSONObject2.optString("KEY_LOCAL_RESULT_VERSION", "");
                    int optInt = f239566b.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
                    int optInt2 = f239566b.optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
                    if (string.equals(optString) && (optInt >= i3 || optInt2 >= i16)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoExtractFrame", 2, "\u5df2\u5230\u8fbe\u8fd0\u884c\u4e0a\u9650");
                        }
                        return false;
                    }
                    if (!string.equals(optString)) {
                        f239566b.put("KEY_LOCAL_RESULT_VERSION", string);
                        f239566b.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
                        f239566b.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
                        com.tencent.mobileqq.kandian.base.utils.c.e("kandian_video_extract_frame_local_result", f239566b.toString());
                    }
                } catch (Exception unused) {
                    return false;
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                f239566b = jSONObject3;
                jSONObject3.put("KEY_LOCAL_RESULT_VERSION", string);
                f239566b.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
                f239566b.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
                com.tencent.mobileqq.kandian.base.utils.c.e("kandian_video_extract_frame_local_result", f239566b.toString());
            }
            ArrayList<b> e16 = e();
            f239567c = e16;
            return e16 != null;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void c() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoExtractFrame", 2, "onEnterBackground() mHasRun = " + f239568d.get() + ", mHasDestory = " + f239569e.get());
        }
        if (Looper.getMainLooper() == null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoExtractFrame", 2, "Looper == null, \u76f4\u63a5\u8fd4\u56de");
                return;
            }
            return;
        }
        if (!f239568d.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoExtractFrame", 2, "\u5f53\u524d\u8fdb\u7a0b\u5df2\u6267\u884c\u8fc7\u4e00\u6b21\uff0c\u76f4\u63a5\u8fd4\u56de");
            }
        } else if (!a()) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoExtractFrame", 2, "\u6761\u4ef6\u4e0d\u6ee1\u8db3\uff0c\u4e0d\u8fdb\u884c\u68c0\u6d4b\u903b\u8f91");
            }
        } else {
            if (!b()) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoExtractFrame", 2, "\u5f53\u524d\u8bbe\u5907OPENGL\u7248\u672c\u53f7\u4f4e\u4e8e2.0\uff0c\u76f4\u63a5\u8fd4\u56de");
                    return;
                }
                return;
            }
            f();
        }
    }

    public static void d() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoExtractFrame", 2, "onEnterForeground() mHasRun = " + f239568d.get() + ", mHasDestory = " + f239569e.get());
        }
        if (f239568d.get()) {
            f239569e.compareAndSet(false, true);
        }
    }

    private static ArrayList<b> e() {
        if (f239565a == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = f239565a.getJSONArray("videoList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                b bVar = new b();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                bVar.f239572a = jSONObject.getString("vid");
                bVar.f239573b = jSONObject.getLong("bitrate");
                bVar.f239574c = jSONObject.getLong("timeout_ms");
                bVar.f239575d = Float.valueOf(jSONObject.getString("hevc_level")).floatValue();
                bVar.f239576e = jSONObject.getInt("max_hashdiff");
                bVar.f239577f = jSONObject.optString("tag");
                JSONArray jSONArray2 = jSONObject.getJSONArray("frameInfo");
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    d dVar = new d();
                    JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i16);
                    dVar.f239579a = jSONObject2.getInt("index");
                    dVar.f239580b = jSONObject2.getLong("serverHash");
                    bVar.f239578g.add(dVar);
                }
                arrayList.add(bVar);
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void f() {
        try {
            f239566b.put("KEY_LOCAL_RESULT_TRY_COUNT", f239566b.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0) + 1);
            com.tencent.mobileqq.kandian.base.utils.c.e("kandian_video_extract_frame_local_result", f239566b.toString());
            float j3 = VideoDeviceInfoHelper.j();
            Iterator<b> it = f239567c.iterator();
            while (it.hasNext()) {
                if (it.next().f239575d > j3) {
                    it.remove();
                }
            }
            if (f239567c.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoExtractFrame", 2, "\u5f53\u524d\u8bbe\u5907\u65e0\u652f\u6301\u64ad\u653e\u7684\u89c6\u9891\uff0c\u76f4\u63a5\u8fd4\u56de");
                    return;
                }
                return;
            }
            b bVar = f239567c.get(new Random().nextInt(f239567c.size()));
            HashMap hashMap = new HashMap();
            Iterator<d> it5 = bVar.f239578g.iterator();
            while (it5.hasNext()) {
                d next = it5.next();
                hashMap.put(Integer.valueOf(next.f239579a), next);
            }
            r52.b.a().g(bVar.f239572a, new a(bVar, hashMap));
        } catch (Exception unused) {
        }
    }

    private static boolean b() {
        ConfigurationInfo deviceConfigurationInfo;
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplicationImpl.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
                return false;
            }
            return deviceConfigurationInfo.reqGlEsVersion >= 131072;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
