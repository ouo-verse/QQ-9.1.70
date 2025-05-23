package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.af;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class PromotionConfigInfo extends ConfigInfo {
    static final String TAG = f.f196950a;
    public static final int zipIndex_0 = 0;
    public static final int zipIndex_1 = 1;
    public static final int zipIndex_2 = 2;
    public static final int zipIndex_3 = 3;
    String version = "-1";
    boolean mainswitch = false;
    String activityid = "-1";
    public long config364Version = 0;
    public boolean showInTopView = false;
    public boolean showOnce = false;
    TreeMap<String, a> operationInfos = new TreeMap<>();
    ArCloudConfigInfo mArCloudConfigInfo = null;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f196893a;

        /* renamed from: b, reason: collision with root package name */
        long f196894b;

        /* renamed from: e, reason: collision with root package name */
        public String f196897e;

        /* renamed from: f, reason: collision with root package name */
        public String f196898f;

        /* renamed from: c, reason: collision with root package name */
        public boolean f196895c = false;

        /* renamed from: d, reason: collision with root package name */
        public long f196896d = 0;

        /* renamed from: g, reason: collision with root package name */
        HashMap<Integer, String> f196899g = new HashMap<>();

        /* renamed from: h, reason: collision with root package name */
        private ArCloudConfigInfo f196900h = null;

        /* renamed from: i, reason: collision with root package name */
        private final TreeMap<Integer, b> f196901i = new TreeMap<>();

        public ArCloudConfigInfo c() {
            return this.f196900h;
        }

        public String d(int i3) {
            return this.f196899g.get(Integer.valueOf(i3));
        }

        public TreeMap<Integer, b> e() {
            return this.f196901i;
        }

        public String toString() {
            String str = "id[" + this.f196897e + "], recoglizeMask[" + this.f196896d + "]";
            if (QLog.isDevelopLevel()) {
                Iterator<b> it = this.f196901i.values().iterator();
                while (it.hasNext()) {
                    str = str + "\n" + it.next();
                }
                return str + ", begin[" + this.f196893a + "], end[" + this.f196894b + "], title[" + this.f196898f + "], tips[" + this.f196899g.size() + "]";
            }
            return str;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f196902a;

        /* renamed from: b, reason: collision with root package name */
        String f196903b;

        /* renamed from: c, reason: collision with root package name */
        String f196904c;

        /* renamed from: f, reason: collision with root package name */
        final String f196907f;

        /* renamed from: d, reason: collision with root package name */
        String f196905d = null;

        /* renamed from: e, reason: collision with root package name */
        String f196906e = null;

        /* renamed from: g, reason: collision with root package name */
        int f196908g = 1;

        /* renamed from: h, reason: collision with root package name */
        boolean f196909h = true;

        /* renamed from: i, reason: collision with root package name */
        i.b f196910i = null;

        /* renamed from: j, reason: collision with root package name */
        Object f196911j = new Object();

        /* renamed from: k, reason: collision with root package name */
        int f196912k = 0;

        /* renamed from: l, reason: collision with root package name */
        long f196913l = 0;

        /* renamed from: m, reason: collision with root package name */
        long f196914m = 0;

        /* renamed from: n, reason: collision with root package name */
        long f196915n = 0;

        /* renamed from: o, reason: collision with root package name */
        int f196916o = -1;

        public b(String str, int i3) {
            this.f196907f = str;
            this.f196902a = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            synchronized (this.f196911j) {
                int i3 = this.f196912k;
                if (i3 == 1) {
                    return;
                }
                if (i3 == -1) {
                    QLog.w(PromotionConfigInfo.TAG, 1, "clearDownladFlag, ZipItem[" + this + "]");
                }
                b(0);
                this.f196913l = 0L;
                this.f196914m = 0L;
                this.f196915n = 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(int i3) {
            synchronized (this.f196911j) {
                this.f196912k = i3;
            }
        }

        public String toString() {
            return this.f196902a + ", id[" + this.f196907f + "], index[" + this.f196902a + "], net_type[" + this.f196908g + "], url[" + this.f196903b + "], md5[" + this.f196904c + "], zipFilePath[" + this.f196905d + "], unzipDirPath[" + this.f196906e + "], callByPreDownload[" + this.f196909h + "], downloadType[" + this.f196912k + "]";
        }
    }

    static boolean set364ZipItem(ArCloudConfigInfo arCloudConfigInfo, a aVar) {
        int i3 = 0;
        if (arCloudConfigInfo != null) {
            aVar.f196900h = arCloudConfigInfo;
            com.tencent.mobileqq.ar.ARPromotion.c cVar = arCloudConfigInfo.M;
            if (cVar != null && !TextUtils.isEmpty(cVar.f196872f) && !TextUtils.isEmpty(arCloudConfigInfo.M.f196874h)) {
                if (arCloudConfigInfo.M.f196868b == 1) {
                    i3 = 1;
                }
                b bVar = new b(aVar.f196897e, 1);
                bVar.f196908g = i3;
                com.tencent.mobileqq.ar.ARPromotion.c cVar2 = arCloudConfigInfo.M;
                bVar.f196903b = cVar2.f196872f;
                bVar.f196904c = cVar2.f196874h;
                bVar.f196905d = com.tencent.mobileqq.ar.ARPromotion.b.b() + bVar.f196904c + ".zip";
                bVar.f196906e = com.tencent.mobileqq.ar.ARPromotion.b.b() + bVar.f196904c + File.separator;
                aVar.f196901i.put(Integer.valueOf(bVar.f196902a), bVar);
            }
            ArModelResource arModelResource = arCloudConfigInfo.F;
            if (arModelResource != null && !TextUtils.isEmpty(arModelResource.f198422f) && !TextUtils.isEmpty(arCloudConfigInfo.F.f198421e)) {
                b bVar2 = new b(aVar.f196897e, 2);
                bVar2.f196908g = i3;
                ArModelResource arModelResource2 = arCloudConfigInfo.F;
                bVar2.f196903b = arModelResource2.f198422f;
                bVar2.f196904c = arModelResource2.f198421e;
                bVar2.f196905d = com.tencent.mobileqq.ar.ARPromotion.b.a() + bVar2.f196904c + com.tencent.mobileqq.ar.ARPromotion.b.f196866a;
                bVar2.f196906e = com.tencent.mobileqq.ar.ARPromotion.b.a() + bVar2.f196904c + File.separator;
                aVar.f196901i.put(Integer.valueOf(bVar2.f196902a), bVar2);
            }
            return true;
        }
        QLog.w(TAG, 1, "setZipItem\uff0c\u6ca1\u6709364\u4fe1\u606f");
        return false;
    }

    public a getActivityItem() {
        a item = getItem(this.activityid);
        if (item != null && f.c(item.f196893a, item.f196894b)) {
            return item;
        }
        return null;
    }

    public a getItem(String str) {
        return this.operationInfos.get(str);
    }

    int loadResConfig() {
        if (this.mArCloudConfigInfo != null) {
            return 0;
        }
        int g16 = ty2.a.g(this.mUin);
        String f16 = ty2.a.f(this.mUin);
        if (f16 == null) {
            if (QQAudioHelper.j()) {
                QLog.w(TAG, 1, "loadResConfig, \u6ca1\u6709json");
            }
            return -1;
        }
        ArCloudConfigInfo a16 = com.tencent.mobileqq.ar.arengine.c.a(f16);
        this.mArCloudConfigInfo = a16;
        if (a16 == null) {
            if (QQAudioHelper.j()) {
                QLog.w(TAG, 1, "loadResConfig, \u6ca1\u6709arCloudConfigInfo");
            }
            return -1;
        }
        if (a16.f197703m == null) {
            a16.f197703m = this.activityid;
        }
        a16.f197699e = SemanticAttributes.HttpFlavorValues.HTTP_2_0;
        a16.f197702i = 8;
        a16.f197701h = 2;
        a16.E = new ArFeatureInfo();
        this.mArCloudConfigInfo.E.f198413i = af.j() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.f197702i + File.separator;
        com.tencent.mobileqq.ar.ARPromotion.c cVar = this.mArCloudConfigInfo.M;
        if (cVar != null) {
            cVar.f196867a = true;
        }
        this.config364Version = g16;
        return g16;
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigInfo
    protected boolean parse(JSONObject jSONObject) {
        ConfigHandler.checkUin(TAG, this.mUin);
        try {
            this.operationInfos.clear();
            this.mainswitch = jSONObject.getBoolean("mainswitch");
            this.activityid = jSONObject.getString("activityid");
            this.version = jSONObject.optString("version");
            if (jSONObject.has("showInTopView")) {
                this.showInTopView = jSONObject.getBoolean("showInTopView");
            }
            if (jSONObject.has("showOnce")) {
                this.showOnce = jSONObject.getBoolean("showOnce");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            JSONArray optJSONArray = jSONObject.optJSONArray("operationInfos");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    a aVar = new a();
                    aVar.f196893a = simpleDateFormat.parse(jSONObject2.optString("begin")).getTime();
                    aVar.f196894b = simpleDateFormat.parse(jSONObject2.optString("end")).getTime();
                    aVar.f196896d = Integer.valueOf(jSONObject2.getString("recoglizeMask")).intValue();
                    aVar.f196897e = jSONObject2.getString("id");
                    aVar.f196898f = jSONObject2.optString("title");
                    aVar.f196895c = jSONObject2.optBoolean("need364");
                    for (int i16 = 1; i16 <= 100; i16++) {
                        String optString = jSONObject2.optString("tips" + i16);
                        if (TextUtils.isEmpty(optString)) {
                            break;
                        }
                        aVar.f196899g.put(Integer.valueOf(i16), optString);
                    }
                    b bVar = new b(aVar.f196897e, 0);
                    bVar.f196903b = jSONObject2.getString("urlEntry");
                    String string = jSONObject2.getString("md5Entry");
                    bVar.f196904c = string;
                    bVar.f196905d = e.h(bVar.f196907f, 0, string);
                    bVar.f196906e = e.f(bVar.f196907f, 0, bVar.f196904c);
                    af.b(bVar.f196906e + ".nomedia");
                    aVar.f196901i.put(Integer.valueOf(bVar.f196902a), bVar);
                    if (aVar.f196895c) {
                        loadResConfig();
                        set364ZipItem(this.mArCloudConfigInfo, aVar);
                    }
                    this.operationInfos.put(aVar.f196897e, aVar);
                }
            }
            return true;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "parseJson, Exception", e16);
            this.operationInfos.clear();
            return false;
        }
    }

    public String toString() {
        Iterator<a> it = this.operationInfos.values().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + "\n" + it.next();
        }
        return "task_id[" + this.taskId + "], _parseRet[" + this.parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
    }
}
