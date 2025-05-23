package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ReportInfoManager {
    public static final String ACTION_CANCEL = "cancel";
    public static final String ACTION_DOWNLOAD = "download";
    public static final String ACTION_FINISH = "finish";
    public static final String ACTION_PROFILE = "profile";
    public static final String ACTION_START = "start";
    private static final String REPORT_INFO = "report_info";
    private static final String SHAREDPREFERENCES_NAME = "gamecenter_preferences";
    private static ReportInfoManager instance;
    private ArrayList<b> reportAdInfoList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f106527a;

        a(long j3) {
            this.f106527a = j3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null && message.what == 2) {
                m.b("post report", this.f106527a, (short) 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f106529a;

        /* renamed from: b, reason: collision with root package name */
        public String f106530b;

        /* renamed from: c, reason: collision with root package name */
        public String f106531c;

        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f106532a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f106533b = "-1";

        /* renamed from: c, reason: collision with root package name */
        public String f106534c = "";

        /* renamed from: d, reason: collision with root package name */
        public int f106535d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f106536e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f106537f = 0;

        /* renamed from: g, reason: collision with root package name */
        public String f106538g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f106539h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f106540i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f106541j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f106542k = "";

        /* renamed from: l, reason: collision with root package name */
        public String f106543l = "0";
    }

    public static ReportInfoManager getInstance() {
        if (instance == null) {
            instance = new ReportInfoManager();
        }
        return instance;
    }

    private void saveReportInfo(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHAREDPREFERENCES_NAME, 0).edit();
        edit.putString("report_info", changeList2JSONStr());
        edit.commit();
    }

    public void addReportInfo(Context context, String str, String str2, String str3) {
        b bVar = new b();
        bVar.f106529a = str;
        bVar.f106530b = str2;
        bVar.f106531c = str3;
        this.reportAdInfoList.add(bVar);
        saveReportInfo(context);
    }

    public void changeJSONStr2List(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.reportAdInfoList.clear();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        b bVar = new b();
                        bVar.f106529a = jSONObject.getString("appid");
                        bVar.f106530b = jSONObject.getString("actionname");
                        bVar.f106531c = jSONObject.getString("timestamp");
                        this.reportAdInfoList.add(bVar);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    public String changeList2JSONStr() {
        if (this.reportAdInfoList.size() <= 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = this.reportAdInfoList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", next.f106529a);
                jSONObject2.put("actionname", next.f106530b);
                jSONObject2.put("timestamp", next.f106531c);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("items", jSONArray);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void clearReportInfo(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHAREDPREFERENCES_NAME, 0).edit();
        edit.putString("report_info", "");
        edit.commit();
        this.reportAdInfoList.clear();
    }

    public String convertInfoObjectToJson(c cVar) {
        if (cVar == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uin", cVar.f106532a);
            jSONObject.put("entrance_status", cVar.f106533b);
            jSONObject.put(WadlReportBuilder.TableElem.GAMECENTER_SRC, cVar.f106534c);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, cVar.f106535d);
            jSONObject.put("module_type", cVar.f106536e);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, cVar.f106537f);
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, cVar.f106538g);
            jSONObject.put(WadlReportBuilder.TableElem.GAMECENTER_VER, cVar.f106539h);
            jSONObject.put("device_type", cVar.f106540i);
            jSONObject.put("net_type", cVar.f106541j);
            jSONObject.put("resolution", cVar.f106542k);
            jSONObject.put(WadlReportBuilder.TableElem.RET_ID, cVar.f106543l);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public c genClickReportInfo(String str, String str2, String str3, String str4, String str5) {
        c cVar = new c();
        cVar.f106532a = str;
        cVar.f106533b = str2;
        cVar.f106540i = DeviceInfoMonitor.getModel();
        cVar.f106534c = "1";
        cVar.f106539h = str3;
        cVar.f106536e = 108;
        cVar.f106541j = str4;
        cVar.f106537f = 16001;
        cVar.f106535d = 1;
        cVar.f106542k = str5;
        cVar.f106538g = com.tencent.open.adapter.a.f().n();
        return cVar;
    }

    public void postClickReportInfo(c cVar) {
        if (cVar == null) {
            return;
        }
        new AsyncHttpConnection(new a(r6.getBytes().length)).b(String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", Integer.valueOf(AppSetting.f()), Build.VERSION.RELEASE), convertInfoObjectToJson(cVar));
    }

    public String readReportInfo(Context context) {
        return context.getSharedPreferences(SHAREDPREFERENCES_NAME, 0).getString("report_info", "");
    }
}
