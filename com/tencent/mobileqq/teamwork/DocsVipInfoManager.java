package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.widget.k;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DocsVipInfoManager {

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f291470b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile DocsVipInfoManager f291471c;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.widget.k f291472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.DocsVipInfoManager$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass3 implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f291475a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f291476b;

        AnonymousClass3(Activity activity, String str) {
            this.f291475a = activity;
            this.f291476b = str;
        }

        @Override // com.tencent.mobileqq.teamwork.DocsVipInfoManager.b
        public void a(final Map<String, Object> map) {
            this.f291475a.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.DocsVipInfoManager.3.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.teamwork.DocsVipInfoManager$3$1$a */
                /* loaded from: classes18.dex */
                class a implements k.d {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.widget.k.d
                    public void a(String str) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        DocsVipInfoManager.this.e(anonymousClass3.f291475a, str);
                        DocsVipInfoManager.this.f291472a.dismiss();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DocsVipInfoManager.this.f291472a == null) {
                        DocsVipInfoManager docsVipInfoManager = DocsVipInfoManager.this;
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        docsVipInfoManager.f291472a = new com.tencent.mobileqq.widget.k(anonymousClass3.f291475a, map, anonymousClass3.f291476b);
                        DocsVipInfoManager.this.f291472a.setCancelable(false);
                    }
                    DocsVipInfoManager.this.f291472a.S(new a());
                    if (!DocsVipInfoManager.this.f291472a.isShowing()) {
                        DocsVipInfoManager.this.f291472a.show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f291481a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f291482b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f291483c;

        a(String str, Map map, b bVar) {
            this.f291481a = str;
            this.f291482b = map;
            this.f291483c = bVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    int i3 = jSONObject.getInt("code");
                    QLog.i("DocsVipInfoManager", 1, "requestWuJiConfig, code = " + i3 + "version" + jSONObject.getInt("version"));
                    if (i3 == 200) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                            if (Objects.equals(this.f291481a, jSONObject2.getString("vipType"))) {
                                this.f291482b.putAll(DocsVipInfoManager.j(new JSONObject(jSONObject2.getString("value"))));
                            }
                        }
                    }
                    b bVar = this.f291483c;
                    if (bVar != null) {
                        bVar.a(this.f291482b);
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("DocsVipInfoManager", 2, "requestWuJiConfig  error " + th5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(Map<String, Object> map);
    }

    static {
        HashMap hashMap = new HashMap();
        f291470b = hashMap;
        hashMap.put(1, "noVip");
        hashMap.put(2, "vip");
        hashMap.put(3, "svip");
        hashMap.put(4, "svip_plus");
    }

    public static DocsVipInfoManager c() {
        if (f291471c == null) {
            synchronized (DocsVipInfoManager.class) {
                if (f291471c == null) {
                    f291471c = new DocsVipInfoManager();
                }
            }
        }
        return f291471c;
    }

    public static String d(int i3) {
        return f291470b.get(Integer.valueOf(i3));
    }

    public static synchronized void f(final b bVar) {
        synchronized (DocsVipInfoManager.class) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.DocsVipInfoManager.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.teamwork.DocsVipInfoManager$1$a */
                /* loaded from: classes18.dex */
                class a implements IGetExternalInterface.d {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public void a(Object obj) {
                        try {
                            if (obj instanceof String) {
                                JSONObject jSONObject = new JSONObject((String) obj);
                                int i3 = jSONObject.getInt("retcode");
                                QLog.d("DocsVipInfoManager", 1, "requestDocsVipInfo, code = " + i3 + "msg" + jSONObject.getString("msg"));
                                HashMap hashMap = new HashMap();
                                if (i3 == 0) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                    hashMap.put("uid", jSONObject2.getString("uid"));
                                    hashMap.put("vipLevel", Integer.valueOf(jSONObject2.getJSONObject("all").getJSONObject("info").getInt("vip_level")));
                                    if (QLog.isColorLevel()) {
                                        QLog.i("DocsVipInfoManager", 2, "requestDocsVipInfo  infoMap" + hashMap);
                                    }
                                    DocsVipInfoManager.g(b.this, hashMap);
                                }
                            }
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.e("DocsVipInfoManager", 2, "requestDocsVipInfo  error " + th5);
                            }
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("", com.tencent.mobileqq.filemanager.util.ah.W().getCurrentAccountUin(), "https://qqandroid.docs.qq.com/api/vipcenter/info/all?xsrf=tencentdocs", ITeamWorkHandler.DOCS_DOMAIN, "TOK=tencentdocs", null, true, new a());
                }
            }, 128, null, false);
        }
    }

    public static synchronized void g(b bVar, Map<String, Object> map) {
        String str;
        synchronized (DocsVipInfoManager.class) {
            try {
                Integer num = (Integer) map.get("vipLevel");
                if (num != null) {
                    str = d(num.intValue());
                } else {
                    str = "novip";
                }
                ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("", com.tencent.mobileqq.filemanager.util.ah.W().getCurrentAccountUin(), "https://cache.wuji.qq.com/x/api/wuji_cache/object?appid=AID_MULTI_D_CONIG&schemaid=PROMOTION_STORAGE_MODAL_PROD&schemakey=75087bc0790147d99b57316b0c71ad2d", "cache.wuji.qq.com", "", null, true, new a(str, map, bVar));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("DocsVipInfoManager", 2, "requestWuJiConfig  error " + th5);
                }
            }
        }
    }

    public static List<Object> i(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object obj = jSONArray.get(i3);
            if (obj instanceof JSONObject) {
                obj = j((JSONObject) obj);
            } else if (obj instanceof JSONArray) {
                obj = i((JSONArray) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> j(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                Object obj = jSONObject.get(str);
                if (obj instanceof JSONObject) {
                    obj = j((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = i((JSONArray) obj);
                }
                hashMap.put(str, obj);
            } catch (JSONException e16) {
                throw new RuntimeException(e16);
            }
        }
        return hashMap;
    }

    public void e(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("isShowAd", false);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public void h(Activity activity, String str) {
        if (activity.isFinishing()) {
            return;
        }
        c();
        f(new AnonymousClass3(activity, str));
    }
}
