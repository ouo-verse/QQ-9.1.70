package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class TDocLocalFileConfigParser extends BaseConfigParser<b> {

    /* renamed from: d, reason: collision with root package name */
    private b f291507d = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements ITDocFileBrowserFacade.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f291508a;

        a(Map.Entry entry) {
            this.f291508a = entry;
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade.a
        public void onResult(boolean z16) {
            QLog.i("TDocLocalFileConfigParser", 1, "[updateOfflinePackage] isSuccess:" + z16 + "type:" + ((String) this.f291508a.getKey()));
        }
    }

    /* loaded from: classes18.dex */
    public static class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public boolean f291510d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f291511e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f291512f = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f291513h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f291514i = false;

        /* renamed from: m, reason: collision with root package name */
        public int f291515m = 30000;
        public List<String> C = new ArrayList();
        public List<String> D = new ArrayList();
        public List<String> E = new ArrayList();
        public Map<String, String> F = new HashMap();
        public boolean G = false;

        public String toString() {
            return "TDocLocalFileConfig{enable=" + this.f291510d + ", enableNativeEngine=" + this.f291511e + ", enableWebEngine=" + this.f291512f + ", supportExtensions=" + this.C + ", nativeSupportDocsType=" + this.D + ", offlinePackageDownloadUrl=" + this.F + ", enableBottomMenu=" + this.G + '}';
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.i("TDocLocalFileConfigParser", 1, "defaultConfig");
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b bVar) {
        super.doOnConfigUpdate(bVar);
        QLog.i("TDocLocalFileConfigParser", 1, "onConfigUpdate:" + bVar);
        if (bVar != null && bVar.f291510d && bVar.f291512f) {
            ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(MobileQQ.sMobileQQ);
            for (Map.Entry<String, String> entry : bVar.F.entrySet()) {
                if (!TextUtils.equals(this.f291507d.F.get(entry.getKey()), entry.getValue())) {
                    ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).updateOfflinePackage(entry.getKey(), new a(entry));
                }
            }
            this.f291507d = bVar;
            return;
        }
        QLog.i("TDocLocalFileConfigParser", 1, "enable is false");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        QLog.i("TDocLocalFileConfigParser", 1, "parse");
        b bVar = new b();
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        QLog.i("TDocLocalFileConfigParser", 1, "tDoc_step parse content = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f291510d = jSONObject.optBoolean("enable", false);
            bVar.f291511e = jSONObject.optBoolean("enable_native_engine", false);
            bVar.f291512f = jSONObject.optBoolean("enable_web_engine", false);
            bVar.f291513h = jSONObject.optBoolean("enable_timeout_monitor", false);
            bVar.f291515m = jSONObject.optInt("timeout_monitor_delay_millis", 30000);
            bVar.f291514i = jSONObject.optBoolean("need_check_so_ready", false);
            bVar.G = jSONObject.optBoolean("enable_bottom_menu", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("support_extensions");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    bVar.C.add(optJSONArray.getString(i3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("native_support_docs_type");
            if (optJSONArray2 != null) {
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    bVar.D.add(optJSONArray2.getString(i16));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("web_support_docs_type");
            if (optJSONArray3 != null) {
                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                    bVar.E.add(optJSONArray3.getString(i17));
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("offline_package_download_url");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    bVar.F.put(str2, optJSONObject.optString(str2));
                }
            }
        } catch (Exception e16) {
            QLog.e("TDocLocalFileConfigParser", 1, "parse config error, e:", e16);
        }
        return bVar;
    }
}
