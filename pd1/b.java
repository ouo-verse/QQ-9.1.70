package pd1;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f425912a;

    /* renamed from: b, reason: collision with root package name */
    public String f425913b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<C11004b> f425914c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public int f425915d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f425916a;

        /* renamed from: b, reason: collision with root package name */
        public String f425917b;
    }

    /* compiled from: P */
    /* renamed from: pd1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C11004b {

        /* renamed from: a, reason: collision with root package name */
        public int f425918a;

        /* renamed from: b, reason: collision with root package name */
        public int f425919b;

        /* renamed from: c, reason: collision with root package name */
        public String f425920c;

        /* renamed from: d, reason: collision with root package name */
        public a[] f425921d;

        /* renamed from: e, reason: collision with root package name */
        public String f425922e;

        /* renamed from: f, reason: collision with root package name */
        public String f425923f;

        /* renamed from: h, reason: collision with root package name */
        public String f425925h;

        /* renamed from: j, reason: collision with root package name */
        public String f425927j;

        /* renamed from: k, reason: collision with root package name */
        public String f425928k;

        /* renamed from: g, reason: collision with root package name */
        public volatile int f425924g = 0;

        /* renamed from: i, reason: collision with root package name */
        private final List<pd1.a> f425926i = new ArrayList();

        public synchronized void a(pd1.a aVar) {
            this.f425926i.add(aVar);
        }

        public synchronized void b(String str, String str2) {
            Iterator<pd1.a> it = this.f425926i.iterator();
            while (it.hasNext()) {
                it.next().a(this.f425918a, str, str2);
            }
            this.f425926i.clear();
        }

        public String c(String str) {
            a[] aVarArr;
            String str2 = this.f425923f;
            if (!TextUtils.isEmpty(str) && (aVarArr = this.f425921d) != null && aVarArr.length > 0) {
                Uri parse = Uri.parse(str);
                int i3 = 0;
                while (true) {
                    a[] aVarArr2 = this.f425921d;
                    if (i3 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i3];
                    String str3 = "\\\"" + aVar.f425917b + "\\\"";
                    String str4 = aVar.f425917b;
                    if (str4.startsWith("${") && aVar.f425917b.endsWith("}")) {
                        str4 = aVar.f425917b.substring(2, r5.length() - 1);
                    }
                    if ("platform".equals(str4)) {
                        str2 = str2.replace(str3, "1").replace(aVar.f425917b, "1");
                    } else if ("uin".equals(str4)) {
                        str2 = str2.replace(str3, "\\\"" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "\\\"");
                    } else if ("timestamp".equals(str4)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        str2 = str2.replace(str3, "" + currentTimeMillis).replace(aVar.f425917b, "" + currentTimeMillis);
                    } else {
                        String queryParameter = parse.getQueryParameter(str4);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (Entry.DATA_TYPE_STRING.equals(aVar.f425916a)) {
                                str2 = str2.replace(str3, "\\\"" + queryParameter + "\\\"");
                            } else {
                                str2 = str2.replace(str3, queryParameter).replace(aVar.f425917b, queryParameter);
                            }
                        }
                    }
                    i3++;
                }
            }
            return str2;
        }

        public String toString() {
            String obj;
            StringBuffer stringBuffer = new StringBuffer("PreloadItem{");
            stringBuffer.append("preloadType=");
            stringBuffer.append(this.f425918a);
            stringBuffer.append(", preloadTime='");
            stringBuffer.append(this.f425919b);
            stringBuffer.append('\'');
            stringBuffer.append(", uniqueId='");
            stringBuffer.append(this.f425920c);
            stringBuffer.append('\'');
            stringBuffer.append(", dynamicParams=");
            a[] aVarArr = this.f425921d;
            if (aVarArr == null) {
                obj = "null";
            } else {
                obj = Arrays.asList(aVarArr).toString();
            }
            stringBuffer.append(obj);
            stringBuffer.append(", ssoCmd='");
            stringBuffer.append(this.f425922e);
            stringBuffer.append('\'');
            stringBuffer.append(", ssoOriginBodyJson='");
            stringBuffer.append(this.f425923f);
            stringBuffer.append('\'');
            stringBuffer.append(", ssoRequestState=");
            stringBuffer.append(this.f425924g);
            stringBuffer.append(", ssoResponseJson='");
            stringBuffer.append(this.f425925h);
            stringBuffer.append('\'');
            stringBuffer.append(", metaSSORequestListeners=");
            stringBuffer.append(this.f425926i);
            stringBuffer.append(", downloadUrl='");
            stringBuffer.append(this.f425927j);
            stringBuffer.append('\'');
            stringBuffer.append(", vid='");
            stringBuffer.append(this.f425928k);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    b() {
    }

    public static b a(String str) {
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str);
        if (moduleVersion > 0) {
            File file = new File(((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(str, moduleVersion), "config.json");
            if (file.exists()) {
                return b(str, moduleVersion, file);
            }
            return null;
        }
        return null;
    }

    private static b b(String str, int i3, File file) {
        JSONObject optJSONObject;
        b bVar = new b();
        bVar.f425913b = str;
        bVar.f425915d = i3;
        try {
            optJSONObject = new JSONObject(FileUtils.readFileContent(file)).optJSONObject("preload");
        } catch (JSONException e16) {
            QLog.e("PreloadDataConfig", 1, e16, new Object[0]);
        }
        if (optJSONObject == null) {
            return null;
        }
        bVar.f425912a = optJSONObject.optBoolean("enablePreload");
        JSONArray optJSONArray = optJSONObject.optJSONArray("preloadList");
        if (optJSONArray != null) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
                C11004b c11004b = new C11004b();
                bVar.f425914c.add(c11004b);
                c11004b.f425918a = optJSONObject2.optInt(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE);
                c11004b.f425919b = optJSONObject2.optInt("preloadTime");
                c11004b.f425920c = optJSONObject2.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("requestParams");
                if (optJSONObject3 != null) {
                    c11004b.f425922e = optJSONObject3.optString("cmd");
                    c11004b.f425927j = optJSONObject3.optString("url");
                    c11004b.f425928k = optJSONObject3.optString("vid");
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("ssoDataBody");
                    if (optJSONObject4 != null) {
                        c11004b.f425923f = optJSONObject4.toString();
                    }
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("dynamicParams");
                    if (optJSONArray2 != null) {
                        c11004b.f425921d = new a[optJSONArray2.length()];
                        for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i17);
                            a aVar = new a();
                            aVar.f425916a = optJSONObject5.optString("type");
                            aVar.f425917b = optJSONObject5.optString("template");
                            c11004b.f425921d[i17] = aVar;
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadDataConfig", 2, "parseDataConfig dataConfig:", bVar);
        }
        return bVar;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MetaDreamDataConfig{");
        stringBuffer.append("enablePreload=");
        stringBuffer.append(this.f425912a);
        stringBuffer.append(", bundleName='");
        stringBuffer.append(this.f425913b);
        stringBuffer.append('\'');
        stringBuffer.append(", preloadItems=");
        stringBuffer.append(this.f425914c);
        stringBuffer.append(", bundleVersion=");
        stringBuffer.append(this.f425915d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
