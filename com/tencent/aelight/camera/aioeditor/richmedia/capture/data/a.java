package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.activity.richmedia.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f67458i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f67459j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f67460k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f67461l;

    /* renamed from: m, reason: collision with root package name */
    private static final String f67462m;

    /* renamed from: n, reason: collision with root package name */
    private static int f67463n;

    /* renamed from: o, reason: collision with root package name */
    public static Object f67464o;

    /* renamed from: p, reason: collision with root package name */
    public static String f67465p;

    /* renamed from: q, reason: collision with root package name */
    public static String f67466q;

    /* renamed from: r, reason: collision with root package name */
    public static int f67467r;

    /* renamed from: s, reason: collision with root package name */
    private static int f67468s;

    /* renamed from: t, reason: collision with root package name */
    private static int f67469t;

    /* renamed from: u, reason: collision with root package name */
    private static int f67470u;

    /* renamed from: v, reason: collision with root package name */
    private static int f67471v;

    /* renamed from: b, reason: collision with root package name */
    private Handler f67473b;

    /* renamed from: c, reason: collision with root package name */
    public CaptureRedDotConfig f67474c;

    /* renamed from: e, reason: collision with root package name */
    public FilterCategoryItem f67476e;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f67472a = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public boolean f67475d = false;

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, FilterDesc> f67477f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<FilterCategory> f67478g = new CopyOnWriteArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private final CopyOnWriteArrayList<FilterCategoryItem> f67479h = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    private static class C0585a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f67480a = new a();
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = g.f185856d;
        sb5.append(str);
        sb5.append("pddata/prd/dov_capture_qsvf");
        String str2 = File.separator;
        sb5.append(str2);
        String sb6 = sb5.toString();
        f67458i = sb6;
        f67459j = sb6 + "capture_res" + str2;
        f67460k = false;
        String str3 = str + "qav" + str2 + "beauty" + str2;
        f67461l = str3;
        f67462m = str3 + "SKINCOLOR" + str2;
        f67463n = 0;
        f67464o = new Object();
        f67465p = sb6 + "lowlight";
        f67466q = f67465p + str2 + "LowLight.png";
        f67467r = 0;
        f67468s = 2;
        f67469t = 1;
        f67470u = -1;
        f67471v = 0;
    }

    a() {
        QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + (ah.C() + " " + ah.s()));
        this.f67473b = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    static void b(Context context, String str, String str2) {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = null;
        if (str == null || str.equals("")) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            k(str, arrayList);
        }
        if (str2 != null && !str2.equals("")) {
            arrayList2 = new ArrayList();
            k(str2, arrayList2);
        } else {
            String str3 = f67459j;
            if (new File(str3).exists()) {
                FileUtils.deleteDirectory(str3);
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            AVCoreLog.printColorLog("CaptureVideoFilterManager", "compareContent newList.size=0");
            FileUtils.deleteDirectory(f67459j);
        } else if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                FilterDesc filterDesc = (FilterDesc) it.next();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    FilterDesc filterDesc2 = (FilterDesc) it5.next();
                    String str4 = filterDesc2.name;
                    if (str4 != null && str4.equals(filterDesc.name)) {
                        AVCoreLog.d("CaptureVideoFilterManager", "compareContent res:" + filterDesc2.name + "|" + filterDesc2.resMD5 + "|" + filterDesc.resMD5);
                        String str5 = filterDesc2.resMD5;
                        if (str5 != null && !str5.equals(filterDesc.resMD5)) {
                            FileUtils.deleteDirectory(filterDesc.getResFold(f67459j));
                        }
                        AVCoreLog.d("CaptureVideoFilterManager", "compareContent iconMD5:" + filterDesc2.name + "|" + filterDesc2.iconMD5 + "|" + filterDesc.iconMD5);
                        String str6 = filterDesc2.iconMD5;
                        if (str6 != null && !str6.equals(filterDesc.iconMD5)) {
                            FileUtils.deleteFile(filterDesc.getIconFile(f67459j));
                        }
                    }
                }
            }
        }
        AVCoreLog.d("CaptureVideoFilterManager", "compareContent :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        File file = new File(f67466q);
        if (file.exists()) {
            file.delete();
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        Bitmap lowLightImage = LowLightTools.getLowLightImage(3.0f, 0.88f, 0.96f, 1.22f, false);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            lowLightImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            QLog.w("CaptureVideoFilterManager", 2, "LowLightTools saveBitmap:" + e16);
        }
        if (!file.exists()) {
            f67467r = f67470u;
        } else {
            f67467r = f67468s;
        }
    }

    public static final a e() {
        return C0585a.f67480a;
    }

    public static String f(Context context) {
        String str = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            String str2 = f67458i;
            sb5.append(str2);
            sb5.append("filter_config.xml");
            File file = new File(sb5.toString());
            AVCoreLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfig:" + str2 + "filter_config.xml|" + file.exists());
            if (file.exists()) {
                str = FileUtils.readFileToString(file);
            } else {
                m(context, 0);
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return str;
    }

    public static int g(Context context) {
        int i3 = 0;
        int i16 = PreferenceManager.getDefaultSharedPreferences(context).getInt("capture_qq_video_filter_config_version", 0);
        if (i16 > 0) {
            if (!new File(f67458i + "filter_config.xml").exists()) {
                AVCoreLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
                AVCoreLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion:" + i3);
                return i3;
            }
        }
        i3 = i16;
        AVCoreLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion:" + i3);
        return i3;
    }

    static void k(String str, List<FilterDesc> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            list.clear();
            try {
                list.addAll(FilterDesc.parse(new JSONObject(str).getJSONArray("filters")));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        AVCoreLog.printColorLog("CaptureVideoFilterManager", "parseConfig|content is empty.");
    }

    public static void m(Context context, int i3) {
        AVCoreLog.printColorLog("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + i3);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("capture_qq_video_filter_config_version", i3);
        edit.commit();
    }

    public FilterDesc d(String str) {
        return this.f67477f.get(str);
    }

    public FilterCategoryItem h() {
        return this.f67476e;
    }

    public void i() {
        CaptureRedDotConfig redDotConfigFromFile = CaptureRedDotConfig.getRedDotConfigFromFile(f67458i, "_Filter");
        if (redDotConfigFromFile != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, "CaptureVideoFilterManger init UpdateByServer= " + this.f67475d);
            }
            synchronized (f67464o) {
                if (!this.f67475d) {
                    this.f67474c = redDotConfigFromFile;
                }
            }
        }
    }

    public boolean j(int i3, int i16, String str) {
        synchronized (f67464o) {
            CaptureRedDotConfig captureRedDotConfig = this.f67474c;
            if (captureRedDotConfig == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
                }
                return false;
            }
            boolean needShowRedDot = captureRedDotConfig.needShowRedDot(i3, i16, str);
            if (needShowRedDot && QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ShowRedDot==> type=");
                sb5.append(i3);
                if (i3 == 2) {
                    sb5.append(",categoryId=");
                    sb5.append(i16);
                } else if (i3 == 3) {
                    sb5.append(",id=");
                    sb5.append(str);
                } else if (i3 == 4) {
                    sb5.append(",defaultId=");
                    sb5.append(this.f67474c.defaultUseId);
                } else if (i3 == 5) {
                    sb5.append(",defaultCategoryId=");
                    sb5.append(this.f67474c.defaultCategoryId);
                }
                QLog.d("QIMRedDotConfig_Filter", 2, sb5.toString());
            }
            return needShowRedDot;
        }
    }

    public void l(boolean z16) {
        if (z16) {
            CaptureRedDotConfig captureRedDotConfig = this.f67474c;
            if (captureRedDotConfig == null || !captureRedDotConfig.update) {
                return;
            }
            captureRedDotConfig.update = false;
            CaptureRedDotConfig.saveRedDotConfig(captureRedDotConfig, f67458i, "_Filter");
            return;
        }
        CaptureRedDotConfig.saveRedDotConfig(this.f67474c, f67458i, "_Filter");
    }

    public void n(Context context, String str, int i3) {
        if (str == null) {
            AVCoreLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
            return;
        }
        b(context, str, f(context));
        FileUtils.writeFile(f67458i, "filter_config.xml", str);
        m(context, i3);
        i();
        o(str);
        AVCoreLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
    }

    public boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (f67464o) {
            if (this.f67474c == null) {
                this.f67474c = new CaptureRedDotConfig(1);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray(IVideoFilterTools.CATEGORYS);
                int optInt = jSONObject.optInt("iconRedDotVersion");
                boolean optBoolean = jSONObject.optBoolean("needRedDot");
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.f67474c.iconVersion + ",ver=" + optInt + ",showRed " + optBoolean);
                }
                int optInt2 = jSONObject.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
                CaptureRedDotConfig captureRedDotConfig = this.f67474c;
                captureRedDotConfig.showTime = optInt2;
                if (captureRedDotConfig.iconVersion != optInt) {
                    captureRedDotConfig.iconVersion = optInt;
                    captureRedDotConfig.showRedDot = optBoolean;
                    captureRedDotConfig.hasShow = false;
                    captureRedDotConfig.firstShowTime = 0L;
                }
                int optInt3 = jSONObject.optInt("defaultCategoryVersion");
                int optInt4 = jSONObject.optInt("defaultCategoryId", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.f67474c.defaultCategoryVer + ",ver=" + optInt3 + ",defaultCategoryId " + optInt4);
                }
                CaptureRedDotConfig captureRedDotConfig2 = this.f67474c;
                if (captureRedDotConfig2.defaultCategoryVer != optInt3) {
                    captureRedDotConfig2.defaultCategoryVer = optInt3;
                    captureRedDotConfig2.defaultCategoryId = optInt4;
                    captureRedDotConfig2.hasChoose = false;
                }
                int optInt5 = jSONObject.optInt("defaultUseVersion");
                String optString = jSONObject.optString("defaultUseId");
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.f67474c.defaultUseVer + ",ver=" + optInt5 + ",defaultUseId " + optString);
                }
                CaptureRedDotConfig captureRedDotConfig3 = this.f67474c;
                if (captureRedDotConfig3.defaultUseVer != optInt5) {
                    captureRedDotConfig3.defaultUseVer = optInt5;
                    captureRedDotConfig3.defaultUseId = optString;
                    captureRedDotConfig3.hasUse = false;
                }
                int optInt6 = jSONObject.optInt("itemRedDotVersion");
                CaptureRedDotConfig captureRedDotConfig4 = this.f67474c;
                if (captureRedDotConfig4.redDotVersion != optInt6) {
                    captureRedDotConfig4.redDotVersion = optInt6;
                    captureRedDotConfig4.redDotItems.clear();
                    if (jSONObject.has("itemNeedRedDot")) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("itemNeedRedDot");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("updateFromServer redDotList: ");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            String optString2 = jSONArray2.optString(i3);
                            if (!TextUtils.isEmpty(optString2)) {
                                CaptureRedDotConfig.RedDotItemConfig redDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                                redDotItemConfig.filterId = optString2;
                                sb5.append(optString2);
                                sb5.append(",");
                                this.f67474c.redDotItems.put(optString2, redDotItemConfig);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMRedDotConfig_Filter", 2, sb5.toString());
                        }
                    }
                }
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    arrayList.add(new FilterCategory(jSONArray.getJSONObject(i16), this.f67474c));
                }
                this.f67475d = true;
                l(false);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QIMRedDotConfig", 2, QLog.getStackTraceString(e16));
                }
                return false;
            }
        }
        return true;
    }
}
