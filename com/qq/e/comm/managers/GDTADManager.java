package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.b;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.c;
import com.qq.e.comm.util.BuglyUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.comm.util.PreHotNetwork;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import com.qq.e.comm.util.TimeRecorder;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GDTADManager {

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f38162h;

    /* renamed from: j, reason: collision with root package name */
    private static volatile GDTADManager f38163j;

    /* renamed from: a, reason: collision with root package name */
    private volatile Boolean f38164a = Boolean.FALSE;

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f38165b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SM f38166c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PM f38167d;

    /* renamed from: e, reason: collision with root package name */
    private volatile APPStatus f38168e;

    /* renamed from: f, reason: collision with root package name */
    private volatile DeviceStatus f38169f;

    /* renamed from: g, reason: collision with root package name */
    private volatile String f38170g;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<PM.a.InterfaceC0276a> f38171i;

    GDTADManager() {
    }

    private static Pair<Integer, JSONArray> a(String str, int i3, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("exp_id");
            if (!JSONUtilStub.isJSONArrayEmpty(optJSONArray)) {
                if (JSONUtilStub.isJSONArrayEmpty(jSONArray)) {
                    jSONArray = optJSONArray;
                } else {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        jSONArray.mo162put(optJSONArray.get(i16));
                    }
                }
            }
        } catch (JSONException e16) {
            GDTLogger.e(e16.getMessage());
        }
        return new Pair<>(Integer.valueOf(i3), jSONArray);
    }

    public static GDTADManager getInstance() {
        if (f38163j == null) {
            synchronized (GDTADManager.class) {
                if (f38163j == null) {
                    f38163j = new GDTADManager();
                }
            }
        }
        return f38163j;
    }

    public static String getIpcServerProcessName() {
        return f38162h;
    }

    public static void setIpcServerProcessName(String str) {
        f38162h = str;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (isInitialized()) {
            JSONObject a16 = c.a(this.f38166c);
            a16.put("app", c.a(this.f38168e));
            a16.put("c", c.b(this.f38169f));
            a16.put("sdk", c.a(this.f38167d));
            return a16;
        }
        return null;
    }

    public JSONObject generateExpInfo(String str, int i3, String[] strArr) {
        String str2;
        String str3;
        SM sm5 = getSM();
        if (sm5 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        String string = sm5.getString("ex_exp_info");
        String str4 = "";
        int i16 = -1;
        if (!TextUtils.isEmpty(string)) {
            Pair<Integer, JSONArray> a16 = a(string, -1, jSONArray);
            i16 = ((Integer) a16.first).intValue();
            jSONArray = (JSONArray) a16.second;
            StringBuilder sb5 = new StringBuilder("stub app exp info = ");
            if (JSONUtilStub.isJSONArrayEmpty(jSONArray)) {
                str3 = "";
            } else {
                str3 = jSONArray.toString();
            }
            sb5.append(str3);
            GDTLogger.d(sb5.toString());
        }
        Object obj = sm5.get(str, "ex_exp_info");
        if (obj != null) {
            str2 = obj.toString();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && !str2.equals(string)) {
            Pair<Integer, JSONArray> a17 = a(str2, i16, jSONArray);
            i16 = ((Integer) a17.first).intValue();
            jSONArray = (JSONArray) a17.second;
            StringBuilder sb6 = new StringBuilder("stub pos exp info = ");
            if (!JSONUtilStub.isJSONArrayEmpty(jSONArray)) {
                str4 = jSONArray.toString();
            }
            sb6.append(str4);
            GDTLogger.d(sb6.toString());
        }
        if (strArr != null && strArr.length > 0) {
            for (String str5 : strArr) {
                jSONArray.mo162put(str5);
            }
        } else {
            i3 = i16;
        }
        if (jSONArray.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", i3);
                jSONObject.put("exp_id", jSONArray);
                GDTLogger.d("stub final exp info = " + jSONObject.toString());
                return jSONObject;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f38165b;
    }

    public APPStatus getAppStatus() {
        return this.f38168e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f38169f;
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f38167d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f38170g;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f38166c;
    }

    public String getTransPortraitADActivityClassName() {
        return CustomPkgConstants.getTransPortraitADActivityClassName();
    }

    public synchronized void initPlugin() {
        PM.a.InterfaceC0276a interfaceC0276a;
        Context context = this.f38165b;
        WeakReference<PM.a.InterfaceC0276a> weakReference = this.f38171i;
        if (weakReference != null) {
            interfaceC0276a = weakReference.get();
        } else {
            interfaceC0276a = null;
        }
        this.f38167d = new PM(context, interfaceC0276a);
        GDTLogger.i("successLoadOnlinePlugin, start to check splash material");
    }

    public synchronized boolean initWith(final Context context, String str) {
        PM.a.InterfaceC0276a interfaceC0276a;
        if (this.f38164a.booleanValue()) {
            return true;
        }
        if (context != null && !StringUtil.isEmpty(str)) {
            try {
                TimeRecorder.getInstance().start();
                final long nanoTime = System.nanoTime();
                this.f38170g = SystemUtil.getProcessName(context);
                this.f38165b = context.getApplicationContext();
                this.f38168e = new APPStatus(str, this.f38165b);
                this.f38169f = new DeviceStatus(this.f38165b);
                this.f38166c = new SM(this.f38165b);
                this.f38166c.doLoadConfig();
                GDTLogger.d("doInit prepare: " + TimeRecorder.getInstance().costFromStart());
                a(1);
                Context context2 = this.f38165b;
                WeakReference<PM.a.InterfaceC0276a> weakReference = this.f38171i;
                if (weakReference != null) {
                    interfaceC0276a = weakReference.get();
                } else {
                    interfaceC0276a = null;
                }
                this.f38167d = new PM(context2, interfaceC0276a);
                GDTLogger.d("doInit PM init: " + TimeRecorder.getInstance().costFromStart());
                a(2);
                PreHotNetwork.getInstance().preRequest(1);
                PreHotNetwork.getInstance().preRequest(2);
                try {
                    this.f38167d.getPOFactory();
                } catch (a e16) {
                    e16.printStackTrace();
                }
                GDTLogger.d("doInit POFactory init: " + TimeRecorder.getInstance().costFromStart());
                a(3);
                BuglyUtil.getInstance().setUp();
                GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.managers.GDTADManager.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            GDTADManager.a(GDTADManager.this, nanoTime);
                            b.a(context);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                });
                GDTLogger.d("doInit SDKInitTotalTime: " + TimeRecorder.getInstance().costFromStart());
                a(4);
                this.f38164a = Boolean.TRUE;
                return true;
            } catch (Throwable th5) {
                GDTLogger.report("ADManager init error", th5);
                return false;
            }
        }
        GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
        return false;
    }

    public boolean isInitialized() {
        if (this.f38164a == null) {
            return false;
        }
        return this.f38164a.booleanValue();
    }

    @Deprecated
    public void preRequestDNS() {
        if (this.f38166c == null) {
            return;
        }
        if (this.f38166c.getInteger(Constants.KEYS.PRE_DNS_REQUEST, 0) == 1) {
            String string = this.f38166c.getString(Constants.KEYS.PRE_DNS_REQUEST_LIST);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] split = string.split(",");
            if (split.length > 0) {
                for (final String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.managers.GDTADManager.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    InetAddress.getAllByName(str);
                                    GDTLogger.d("DNS pre success : " + str);
                                } catch (UnknownHostException e16) {
                                    e16.printStackTrace();
                                    GDTLogger.d("DNS pre failed : " + str);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void setPluginLoadListener(PM.a.InterfaceC0276a interfaceC0276a) {
        this.f38171i = new WeakReference<>(interfaceC0276a);
    }

    private void a(int i3) {
        com.qq.e.comm.a.a(i3, this.f38167d != null ? this.f38167d.getPluginVersion() : -1, TimeRecorder.getInstance().costFromStart(), 2);
    }

    static /* synthetic */ void a(GDTADManager gDTADManager, long j3) {
        com.qq.e.comm.a.a.a().a(gDTADManager.f38165b, gDTADManager.f38166c, gDTADManager.f38167d, gDTADManager.f38169f, gDTADManager.f38168e, j3);
    }
}
