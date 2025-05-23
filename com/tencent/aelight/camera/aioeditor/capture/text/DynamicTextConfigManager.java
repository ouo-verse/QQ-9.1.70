package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DynamicTextConfigManager extends fr.e {
    public static File G = new File(QIMFileUtils.a(), "dynamic_text");
    private static String H;
    private String C;

    /* renamed from: h, reason: collision with root package name */
    private String f66874h;

    /* renamed from: i, reason: collision with root package name */
    private String f66875i;

    /* renamed from: m, reason: collision with root package name */
    private String f66876m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DynamicTextConfigBean> f66871d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f66872e = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f66873f = false;
    private boolean D = false;
    public int F = 120;
    private a E = new a(this);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class DynamicTextConfigBean {
        public ArrayList<a> fontInfos = new ArrayList<>();
        public int iconDrawableId;
        public int predownload;
        public int text_id;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public String f66879a;

            /* renamed from: b, reason: collision with root package name */
            public String f66880b;

            /* renamed from: c, reason: collision with root package name */
            public String f66881c;

            /* renamed from: d, reason: collision with root package name */
            public int f66882d;

            /* renamed from: e, reason: collision with root package name */
            public int f66883e;

            public static a a(JSONObject jSONObject) {
                a aVar = new a();
                aVar.f66879a = jSONObject.optString("resurl");
                aVar.f66880b = jSONObject.optString("md5");
                aVar.f66881c = jSONObject.optString("name");
                aVar.f66882d = jSONObject.optInt("text_id");
                aVar.f66883e = jSONObject.optInt("progress");
                return aVar;
            }

            public String b() {
                return this.f66881c + "_" + this.f66880b;
            }
        }

        public static DynamicTextConfigBean convertFrom(JSONObject jSONObject) {
            DynamicTextConfigBean dynamicTextConfigBean = null;
            try {
                DynamicTextConfigBean dynamicTextConfigBean2 = new DynamicTextConfigBean();
                try {
                    if (jSONObject.has("text_id")) {
                        dynamicTextConfigBean2.text_id = jSONObject.getInt("text_id");
                    }
                    if (jSONObject.has("predownload")) {
                        dynamicTextConfigBean2.predownload = jSONObject.getInt("predownload");
                    }
                    if (!jSONObject.has("fonts")) {
                        return dynamicTextConfigBean2;
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray("fonts");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        a a16 = a.a((JSONObject) jSONArray.get(i3));
                        a16.f66882d = dynamicTextConfigBean2.text_id;
                        dynamicTextConfigBean2.fontInfos.add(a16);
                    }
                    return dynamicTextConfigBean2;
                } catch (JSONException e16) {
                    e = e16;
                    dynamicTextConfigBean = dynamicTextConfigBean2;
                    if (QLog.isColorLevel()) {
                        QLog.i("DText", 2, e.toString());
                    }
                    return dynamicTextConfigBean;
                }
            } catch (JSONException e17) {
                e = e17;
            }
        }

        public int getProgress() {
            ArrayList<a> arrayList = this.fontInfos;
            if (arrayList == null) {
                return 100;
            }
            int size = arrayList.size();
            Iterator<a> it = this.fontInfos.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += (it.next().f66883e * 1) / size;
            }
            return i3;
        }

        public boolean isContainsResUrl(String str) {
            if (this.fontInfos != null && !TextUtils.isEmpty(str)) {
                Iterator<a> it = this.fontInfos.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && str.equals(next.f66879a)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(float f16, String str, int i3);

        void v(boolean z16, String str);
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(G.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("usable");
        sb5.append(str);
        H = sb5.toString();
    }

    private ArrayList<DynamicTextConfigBean> h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ArrayList<DynamicTextConfigBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("texts");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                DynamicTextConfigBean convertFrom = DynamicTextConfigBean.convertFrom(jSONArray.getJSONObject(i3));
                if (convertFrom != null) {
                    convertFrom.iconDrawableId = DynamicTextBuilder.f(convertFrom.text_id);
                    arrayList.add(convertFrom);
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String j(DynamicTextConfigBean.a aVar) {
        return new File(G, aVar.b()).getPath();
    }

    public static boolean n() {
        boolean exists = new File(G + File.separator + "dynamic_text_config.cfg").exists();
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "DynamicTextConfigManager isStickerConfigFileExist" + exists);
        }
        return exists;
    }

    private void r(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("text_guide");
            if (jSONObject != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("DText", 2, jSONObject.toString());
                }
                this.f66874h = jSONObject.optString("default");
                this.f66875i = jSONObject.optString("local_slides");
                this.f66876m = jSONObject.optString("local_singlePhoto");
                this.C = jSONObject.optString("local_singleVideo");
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("dynamic_text_pre", 4);
                if (sharedPreferences == null) {
                    return;
                }
                this.D = jSONObject.optInt("is_text_guide_on") == 1;
                sharedPreferences.edit().putBoolean("dynamic_text_key_is_hint_on", this.D).apply();
                sharedPreferences.edit().putString("key_dynamic_text_hint_default", this.f66874h).apply();
                sharedPreferences.edit().putString("key_dynamic_text_hint_local_slides", this.f66875i).apply();
                sharedPreferences.edit().putString("key_dtext_hint_single_photo", this.f66876m).apply();
                sharedPreferences.edit().putString("key_dtext_hint_single_video", this.C).apply();
            }
        } catch (Exception e16) {
            QLog.d("DText", 1, e16, new Object[0]);
        }
    }

    public DynamicTextConfigBean g(String str) {
        int i3;
        try {
            i3 = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            i3 = 0;
        }
        synchronized (this.f66871d) {
            Iterator<DynamicTextConfigBean> it = this.f66871d.iterator();
            while (it.hasNext()) {
                DynamicTextConfigBean next = it.next();
                if (next != null && next.text_id == i3) {
                    return next;
                }
            }
            return null;
        }
    }

    public ArrayList<DynamicTextConfigBean> i() {
        return this.f66871d;
    }

    public void l(String str) {
        ArrayList<DynamicTextConfigBean> h16;
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "handleDynamicTextConfig config is: " + str);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim()) || (h16 = h(str)) == null || h16.isEmpty()) {
            return;
        }
        synchronized (this.f66871d) {
            this.f66871d.clear();
            this.f66871d.addAll(h16);
            r(str);
            this.f66872e = true;
            c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, false, null);
        }
        Iterator<DynamicTextConfigBean> it = h16.iterator();
        while (it.hasNext()) {
            DynamicTextConfigBean next = it.next();
            if (next.predownload == 1 && !q(next) && NetConnInfoCenter.isWifiConn()) {
                s(next, null);
            }
        }
        QIMFileUtils.d(G, "dynamic_text_config.cfg", str);
    }

    public void m() {
        String c16;
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "initConfigListByFile start");
        }
        if (!this.f66873f && !this.f66872e) {
            if (n()) {
                c16 = QIMFileUtils.b(G, "dynamic_text_config.cfg");
                if (QLog.isColorLevel()) {
                    QLog.i("DText", 2, "initConfigListByFile dir=" + G + " file=dynamic_text_config.cfg");
                }
            } else {
                c16 = QIMFileUtils.c("dynamic_text_config.cfg");
                if (QLog.isColorLevel()) {
                    QLog.i("DText", 2, "initConfigListByFile read from asset");
                }
            }
            synchronized (this.f66871d) {
                if (!this.f66872e && !this.f66873f) {
                    this.f66871d.clear();
                    ArrayList<DynamicTextConfigBean> h16 = h(c16);
                    if (h16 != null && !h16.isEmpty()) {
                        this.f66871d.addAll(h16);
                    }
                    r(c16);
                    this.f66873f = true;
                    if (h16 == null || h16.isEmpty()) {
                        return;
                    }
                    Iterator<DynamicTextConfigBean> it = h16.iterator();
                    while (it.hasNext()) {
                        DynamicTextConfigBean next = it.next();
                        if (next.predownload == 1 && !q(next) && NetConnInfoCenter.isWifiConn()) {
                            s(next, null);
                        }
                    }
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "initConfigListByFile return by mIsInitByCache");
        }
    }

    public boolean o() {
        return this.f66872e || this.f66873f;
    }

    public boolean t(DynamicTextConfigBean.a aVar) {
        try {
            ZipUtils.unZipFile(new File(G, aVar.b()), H);
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            e16.printStackTrace();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ConcurrentHashMap<String, ArrayList<WeakReference<b>>> f66884a = new ConcurrentHashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private DynamicTextConfigManager f66885b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0579a implements INetEngineListener {
            C0579a() {
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(NetResp netResp) {
                DynamicTextConfigBean.a aVar = (DynamicTextConfigBean.a) netResp.mReq.getUserData();
                if (QLog.isColorLevel()) {
                    QLog.i("DText", 2, "onResp, url is: " + aVar.f66879a + " http status: " + netResp.mHttpCode);
                }
                a.this.d(aVar);
                boolean z16 = a.this.f66885b.t(aVar) && a.this.f66885b.p(aVar);
                synchronized (a.this.f66884a) {
                    ArrayList arrayList = (ArrayList) a.this.f66884a.remove(aVar.f66879a);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) arrayList.get(size);
                        if (weakReference.get() != 0) {
                            ((b) weakReference.get()).v(z16, aVar.f66879a);
                        }
                    }
                }
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                DynamicTextConfigBean.a aVar = (DynamicTextConfigBean.a) netReq.getUserData();
                synchronized (a.this.f66884a) {
                    Iterator it = ((ArrayList) a.this.f66884a.get(aVar.f66879a)).iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference.get() != 0) {
                            ((b) weakReference.get()).a((float) ((100 * j3) / j16), aVar.f66879a, aVar.f66882d);
                        }
                    }
                }
                float f16 = (((float) j3) * 100.0f) / ((float) j16);
                aVar.f66883e = (int) f16;
                if (QLog.isColorLevel()) {
                    QLog.i("DText", 2, "onResDownloadProgressUpdate url: " + aVar.f66879a + " progress: " + f16 + " curOffset: " + j3 + " totalLen: " + j16);
                }
            }
        }

        public a(DynamicTextConfigManager dynamicTextConfigManager) {
            this.f66885b = dynamicTextConfigManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(DynamicTextConfigBean.a aVar) {
            File[] listFiles;
            if (aVar == null || TextUtils.isEmpty(aVar.f66881c) || (listFiles = DynamicTextConfigManager.G.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            for (File file : listFiles) {
                if (file != null) {
                    String name = file.getName();
                    if (TextUtils.isEmpty(name)) {
                        file.delete();
                    }
                    if (name.contains("_")) {
                        if (aVar.f66881c.equalsIgnoreCase(name.substring(0, name.lastIndexOf("_"))) && !name.equalsIgnoreCase(aVar.b())) {
                            file.delete();
                        }
                    }
                }
            }
        }

        public void e(DynamicTextConfigBean.a aVar, b bVar) {
            if (aVar != null && !TextUtils.isEmpty(aVar.f66879a)) {
                String str = aVar.f66879a;
                if (QLog.isColorLevel()) {
                    QLog.i("DText", 2, "startDownloadDynamicText res url: " + str);
                }
                synchronized (this.f66884a) {
                    boolean z16 = false;
                    if (this.f66884a.containsKey(str)) {
                        ArrayList<WeakReference<b>> arrayList = this.f66884a.get(str);
                        Iterator<WeakReference<b>> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (it.next().get() == bVar) {
                                z16 = true;
                                break;
                            }
                        }
                        if (!z16) {
                            arrayList.add(new WeakReference<>(bVar));
                        }
                        return;
                    }
                    ArrayList<WeakReference<b>> arrayList2 = new ArrayList<>();
                    arrayList2.add(new WeakReference<>(bVar));
                    this.f66884a.put(str, arrayList2);
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new C0579a();
                    httpNetReq.mReqUrl = str;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = DynamicTextConfigManager.j(aVar);
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    httpNetReq.setUserData(aVar);
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
            }
        }
    }

    public void s(final DynamicTextConfigBean dynamicTextConfigBean, final b bVar) {
        if (dynamicTextConfigBean == null || dynamicTextConfigBean.fontInfos == null) {
            return;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DynamicTextConfigBean.a> it = dynamicTextConfigBean.fontInfos.iterator();
                while (it.hasNext()) {
                    DynamicTextConfigManager.this.E.e(it.next(), bVar);
                }
            }
        }, null, true);
    }

    public boolean p(DynamicTextConfigBean.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f66881c)) {
            if (TextUtils.isEmpty(aVar.f66879a)) {
                return true;
            }
            if (!new File(G, aVar.b()).exists()) {
                return false;
            }
            if (new File(H + aVar.f66881c).exists()) {
                return true;
            }
        }
        return false;
    }

    public String k(DynamicTextConfigBean.a aVar) {
        if (aVar == null) {
            return null;
        }
        return H + aVar.f66881c + File.separator;
    }

    public boolean q(DynamicTextConfigBean dynamicTextConfigBean) {
        if (dynamicTextConfigBean == null) {
            return false;
        }
        ArrayList<DynamicTextConfigBean.a> arrayList = dynamicTextConfigBean.fontInfos;
        if (arrayList == null) {
            return true;
        }
        Iterator<DynamicTextConfigBean.a> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!p(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // fr.e
    public void d() {
    }

    @Override // fr.e
    public void e() {
    }
}
