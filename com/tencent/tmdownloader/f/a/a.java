package com.tencent.tmdownloader.f.a;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistant.common.jce.ConfigItem;
import com.tencent.tmassistant.common.jce.GetConfigRequest;
import com.tencent.tmassistant.common.jce.GetConfigResponse;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.info.InfoAnalyzer;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.c;
import com.tencent.tmdownloader.f.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends PostHttpRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<Integer> f380633f;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<Integer> f380634g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f380635h;

    /* renamed from: a, reason: collision with root package name */
    private long f380636a;

    /* renamed from: b, reason: collision with root package name */
    private long f380637b;

    /* renamed from: c, reason: collision with root package name */
    private long f380638c;

    /* renamed from: d, reason: collision with root package name */
    private long f380639d;

    /* renamed from: e, reason: collision with root package name */
    private long f380640e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.f.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class RunnableC10001a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f380641a;

        RunnableC10001a(byte[] bArr) {
            this.f380641a = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) bArr);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.sendRequest(this.f380641a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_SUBTITLE_SWITCH_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f380633f = new ArrayList<>();
        f380634g = new ArrayList<>();
        f380633f.add(4);
        f380633f.add(6);
        f380633f.add(8);
        f380633f.add(9);
        f380633f.add(11);
        f380633f.add(12);
        f380634g.add(8);
        f380635h = null;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380636a = 0L;
        this.f380637b = 0L;
        this.f380638c = 0L;
        this.f380639d = 0L;
        this.f380640e = 0L;
    }

    private ArrayList<Integer> b() {
        String currentDay = GlobalUtil.getCurrentDay();
        String string = Settings.getInstance().getString("KEY_CRG_DATE");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(f380633f);
        if (TextUtils.isEmpty(string) || !string.equals(currentDay)) {
            arrayList.add(10);
        }
        return arrayList;
    }

    private boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f380638c <= 2000) {
            return false;
        }
        this.f380638c = currentTimeMillis;
        if (currentTimeMillis - this.f380636a < 1800000) {
            return false;
        }
        return true;
    }

    private boolean d() {
        String currentDay = GlobalUtil.getCurrentDay();
        String dayAndHour = GlobalUtil.getDayAndHour(System.currentTimeMillis());
        String string = Settings.getInstance().getString("KEY_GET_CFG_REQUEST_DAY");
        if (TextUtils.equals(dayAndHour, Settings.getInstance().getString("KEY_GET_CFG_REQUEST_HOUR"))) {
            return false;
        }
        int i3 = Settings.getInstance().getInt("KEY_GET_CFG_SUCC_COUNT");
        if (!TextUtils.equals(currentDay, string)) {
            Settings.getInstance().setInt("KEY_GET_CFG_SUCC_COUNT", 0);
            i3 = 0;
        }
        if (i3 >= 10) {
            return false;
        }
        return true;
    }

    public synchronized void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!l.e()) {
            c.a().e();
        } else {
            if (!c()) {
                return;
            }
            if (!d()) {
            } else {
                a(b());
            }
        }
    }

    public synchronized void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!l.e()) {
            c.a().c();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f380640e <= 2000) {
                return;
            }
            this.f380640e = currentTimeMillis;
            ArrayList<Integer> arrayList = new ArrayList<>(1);
            arrayList.add(11);
            a(arrayList);
        }
    }

    public synchronized void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!l.e()) {
            c.a().d();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f380639d <= 2000) {
                return;
            }
            this.f380639d = currentTimeMillis;
            if (currentTimeMillis - this.f380637b >= 1800000) {
                a(f380634g);
            }
        }
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected synchronized void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, bArr2, Integer.valueOf(i3));
            return;
        }
        if (bArr2 != null && i3 == 0) {
            Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
            if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
                JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bArr3, (Class<? extends JceStruct>) GetConfigResponse.class);
                if (unpageageJceResponse != null && (unpageageJceResponse instanceof GetConfigResponse)) {
                    GetConfigResponse getConfigResponse = (GetConfigResponse) unpageageJceResponse;
                    if (getConfigResponse.ret == 0) {
                        a(getConfigResponse, true);
                    } else {
                        a(getConfigResponse, false);
                    }
                } else {
                    a((GetConfigResponse) null, false);
                }
            } else {
                a((GetConfigResponse) null, false);
            }
            return;
        }
        a((GetConfigResponse) null, false);
    }

    public static a a() {
        if (f380635h == null) {
            synchronized (a.class) {
                if (f380635h == null) {
                    f380635h = new a();
                }
            }
        }
        return f380635h;
    }

    private synchronized void a(ArrayList<Integer> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                GetConfigRequest getConfigRequest = new GetConfigRequest();
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                getConfigRequest.typeList = arrayList2;
                arrayList2.addAll(arrayList);
                byte[] buildPostData = ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(getConfigRequest));
                if (!sendRequest(buildPostData)) {
                    e.a().postDelayed(new RunnableC10001a(buildPostData), 2000L);
                }
            }
        }
    }

    private synchronized void a(GetConfigResponse getConfigResponse, boolean z16) {
        ArrayList<String> arrayList;
        if (z16 && getConfigResponse != null) {
            ArrayList<ConfigItem> arrayList2 = getConfigResponse.settingList;
            if (arrayList2 != null && arrayList2.size() != 0) {
                ArrayList<ConfigItem> arrayList3 = getConfigResponse.settingList;
                int size = arrayList3.size();
                getConfigResponse.settingList.size();
                l.a();
                Iterator<ConfigItem> it = arrayList3.iterator();
                while (it.hasNext()) {
                    ConfigItem next = it.next();
                    if (next != null && next.configuration != null) {
                        switch (next.type) {
                            case 6:
                                if (((BatchReportConfig) ProtocolPackage.bytes2JceObj(next.configuration, BatchReportConfig.class)) == null) {
                                    break;
                                } else {
                                    b.a().c(next.configuration);
                                    break;
                                }
                            case 8:
                                b.a().a(next.configuration);
                                break;
                            case 9:
                                BypassInterceptConfig bypassInterceptConfig = (BypassInterceptConfig) ProtocolPackage.bytes2JceObj(next.configuration, BypassInterceptConfig.class);
                                if (bypassInterceptConfig != null) {
                                    Objects.toString(bypassInterceptConfig.pkgList);
                                }
                                b.a().a("key_bypass_config", next.configuration, BypassInterceptConfig.class);
                                break;
                            case 10:
                                BoutiqueGameConfig boutiqueGameConfig = (BoutiqueGameConfig) ProtocolPackage.bytes2JceObj(next.configuration, BoutiqueGameConfig.class);
                                if (boutiqueGameConfig != null && (arrayList = boutiqueGameConfig.pkgList) != null && arrayList.size() != 0) {
                                    boutiqueGameConfig.pkgList.size();
                                    Objects.toString(boutiqueGameConfig.pkgList);
                                    b.a().a("key_recommend_games_config", next.configuration, BoutiqueGameConfig.class);
                                    Settings.getInstance().setString("KEY_CRG_DATE", GlobalUtil.getCurrentDay());
                                    break;
                                } else {
                                    r.a("nemo_bgg", "<onRequestFinished> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
                                    break;
                                }
                            case 11:
                                NewQqCenterConfig newQqCenterConfig = (NewQqCenterConfig) ProtocolPackage.bytes2JceObj(next.configuration, NewQqCenterConfig.class);
                                if (newQqCenterConfig != null) {
                                    Objects.toString(newQqCenterConfig.enterOldViaList);
                                    a(newQqCenterConfig.appNewsUrlMap);
                                    b.a().b(next.configuration);
                                    break;
                                } else {
                                    r.a("GetConfigEngine", "CONFIG_NEW_APP_CENTER Bad content!");
                                    break;
                                }
                            case 12:
                                AppDataReportConfig appDataReportConfig = (AppDataReportConfig) ProtocolPackage.bytes2JceObj(next.configuration, AppDataReportConfig.class);
                                r.a("GetConfigEngine", "config 12=" + appDataReportConfig);
                                if (appDataReportConfig == null) {
                                    break;
                                } else {
                                    InfoAnalyzer.b().b(appDataReportConfig);
                                    break;
                                }
                        }
                    }
                }
                if (size == f380634g.size()) {
                    this.f380637b = System.currentTimeMillis();
                } else {
                    this.f380636a = System.currentTimeMillis();
                    String currentDay = GlobalUtil.getCurrentDay();
                    String dayAndHour = GlobalUtil.getDayAndHour(System.currentTimeMillis());
                    String string = Settings.getInstance().getString("KEY_GET_CFG_REQUEST_DAY");
                    int i3 = Settings.getInstance().getInt("KEY_GET_CFG_SUCC_COUNT");
                    if (!TextUtils.equals(string, currentDay)) {
                        i3 = 0;
                    }
                    Settings.getInstance().setString("KEY_GET_CFG_REQUEST_DAY", currentDay);
                    Settings.getInstance().setString("KEY_GET_CFG_REQUEST_HOUR", dayAndHour);
                    Settings.getInstance().setInt("KEY_GET_CFG_SUCC_COUNT", i3 + 1);
                }
            }
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        if (map == null || map.size() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        sb5.append("[");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb5.append("key:" + entry.getKey());
            sb5.append(",value:" + entry.getValue());
            sb5.append("||");
        }
        sb5.append("]");
        return sb5.toString();
    }
}
