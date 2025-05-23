package com.tencent.mobileqq.troop.avatar.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.epicgames.ue4.GameActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.b;
import com.tencent.mobileqq.troop.avatar.c;
import com.tencent.mobileqq.troop.avatar.g;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    protected static final List<String> f294558i;

    /* renamed from: c, reason: collision with root package name */
    private final String f294559c;

    /* renamed from: d, reason: collision with root package name */
    protected final String f294560d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f294561e;

    /* renamed from: f, reason: collision with root package name */
    protected final String f294562f;

    /* renamed from: g, reason: collision with root package name */
    protected final String f294563g;

    /* renamed from: h, reason: collision with root package name */
    protected final String f294564h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f294558i = arrayList;
        arrayList.add("2408:8756:3af0:10::107");
        arrayList.add("240e:ff:f101:10::104");
        arrayList.add("2402:4e00:8010::132");
        arrayList.add("2402:4e00:8010::22");
        arrayList.add("2408:80f1:31:50::21");
        arrayList.add("240e:e1:a900:50::3d");
        arrayList.add("2402:4e00:8020:2::86");
        arrayList.add("2409:8c1e:8fd0:50::1c");
        arrayList.add("2408:8711:10:10::13");
        arrayList.add("240e:928:1400:10::23");
        arrayList.add("2402:4e00:8030:1::a0");
        arrayList.add("2409:8702:4860:10::41");
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f294559c = "TroopAvatarManger_NormalTroopUrlAction";
        this.f294560d = "0x6ff0072";
        this.f294561e = "5520";
        this.f294562f = "3";
        this.f294563g = "5";
        this.f294564h = "cgi-bin/httpconn";
    }

    private String f(boolean z16) {
        String i3 = i("htdata3.qq.com", "cgi-bin/httpconn", !z16);
        if (TextUtils.isEmpty(i3)) {
            i3 = i("htdata4.qq.com", "cgi-bin/httpconn", !z16);
        }
        if (TextUtils.isEmpty(i3)) {
            return j("cgi-bin/httpconn", z16);
        }
        return i3;
    }

    private String h(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new URL("http", str2, i3, "cgi-bin/httpconn").toString();
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.b
    public int b(HttpURLConnection httpURLConnection, TroopUploadingThread.b bVar, g gVar) {
        int i3;
        List<String> list;
        List<String> list2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, httpURLConnection, bVar, gVar)).intValue();
        }
        int i16 = -1;
        Integer num = -1;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        try {
            i3 = httpURLConnection.getResponseCode();
        } catch (IOException e16) {
            QLog.d("TroopAvatarManger_NormalTroopUrlAction", 1, "getResult IOException", e16);
            i3 = -1;
        }
        String str2 = null;
        if (headerFields != null) {
            for (String str3 : headerFields.keySet()) {
                if (str3 != null && (list = headerFields.get(str3)) != null && (list instanceof List)) {
                    if (str3.equals(GameActivity.DOWNLOAD_RETURN_NAME)) {
                        List<String> list3 = list;
                        String str4 = list3.get(0);
                        if (str4 != null && (str4 instanceof String)) {
                            num = Integer.valueOf(Integer.parseInt(list3.get(0)));
                        }
                    } else if (str3.equals("NewSeq")) {
                        List<String> list4 = list;
                        String str5 = list4.get(0);
                        if (str5 != null && (str5 instanceof String)) {
                            bVar.f294522c = Integer.parseInt(list4.get(0));
                        }
                    } else if (str3.equals("FileName")) {
                        List<String> list5 = list;
                        String str6 = list5.get(0);
                        if (str6 != null && (str6 instanceof String)) {
                            str2 = list5.get(0);
                        }
                    } else if (str3.equals("X-ErrMsg")) {
                        List<String> list6 = list;
                        String str7 = list6.get(0);
                        if (str7 != null && (str7 instanceof String)) {
                            bVar.f294526g = new String(((ITroopCardApi) QRoute.api(ITroopCardApi.class)).base64Decode(list6.get(0)));
                        }
                    } else if (str3.equals("X-ErrNo") && (str = (list2 = list).get(0)) != null && (str instanceof String)) {
                        int parseInt = Integer.parseInt(list2.get(0));
                        bVar.f294525f = parseInt;
                        num = Integer.valueOf(parseInt);
                    }
                }
            }
        }
        int intValue = num.intValue();
        if (i3 != 200) {
            intValue = 102;
        }
        QLog.d("TroopAvatarManger_NormalTroopUrlAction", 1, "result:" + intValue + "resCode:" + i3);
        if (str2 != null && str2.contains("_")) {
            String[] split = str2.split("_");
            if (split.length == 2) {
                try {
                    bVar.f294521b = Integer.parseInt(split[1]);
                    i16 = intValue;
                } catch (NumberFormatException e17) {
                    e17.printStackTrace();
                }
            }
        }
        if (gVar.f294552c) {
            return 104;
        }
        httpURLConnection.disconnect();
        return i16;
    }

    @Override // com.tencent.mobileqq.troop.avatar.b
    public List<String> c(AppInterface appInterface) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
        Bundle bundle = this.f294539a;
        if (bundle != null) {
            String str = "0";
            if (bundle.getString("userData") == null) {
                string = "0";
            } else {
                string = this.f294539a.getString("userData");
            }
            if (this.f294539a.getString(DownloaderConstant.KEY_RANGE) != null) {
                str = this.f294539a.getString(DownloaderConstant.KEY_RANGE);
            }
            return g(appInterface, string, str, this.f294539a.getString(IProfileProtocolConst.PARAM_TROOP_CODE), this.f294539a.getString("uin"), this.f294539a.getString("ukey"));
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.troop.avatar.b
    public void e(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
            return;
        }
        c cVar = new c();
        cVar.d("sslv6.htdata.qq.com");
        this.f294540b = cVar;
    }

    protected List<String> g(AppInterface appInterface, String str, String str2, String str3, String str4, String str5) {
        boolean z16;
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, appInterface, str, str2, str3, str4, str5);
        }
        ArrayList arrayList = new ArrayList();
        boolean isPreferIpv6 = HeadDpcCfg.get().isPreferIpv6();
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        com.tencent.mobileqq.troop.soso.b c16 = com.tencent.mobileqq.troop.soso.b.c();
        c16.g();
        if (activeNetIpFamily == 3) {
            String e16 = c16.e(appInterface, 0, isPreferIpv6, true);
            if (!TextUtils.isEmpty(e16)) {
                arrayList.add(e16 + "cgi-bin/httpconn");
            }
            String e17 = c16.e(appInterface, 0, !isPreferIpv6, true);
            if (!TextUtils.isEmpty(e17)) {
                arrayList.add(e17 + "cgi-bin/httpconn");
            }
            if (arrayList.size() < 2) {
                String f16 = f(false);
                if (!TextUtils.isEmpty(f16)) {
                    arrayList.add(f16);
                }
            }
            String h16 = h("cgi-bin/httpconn", "htdata3.qq.com", 80);
            if (!TextUtils.isEmpty(h16)) {
                arrayList.add(h16);
            }
        } else {
            if (activeNetIpFamily == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            String e18 = c16.e(appInterface, 0, z16, true);
            if (!TextUtils.isEmpty(e18)) {
                arrayList.add(e18 + "cgi-bin/httpconn");
            }
            if (activeNetIpFamily == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            String f17 = f(z17);
            if (!TextUtils.isEmpty(f17)) {
                arrayList.add(f17);
            }
            String h17 = h("cgi-bin/httpconn", "htdata3.qq.com", 80);
            if (!TextUtils.isEmpty(h17)) {
                arrayList.add(h17);
            }
        }
        if (QLog.isColorLevel()) {
            i3 = 0;
            QLog.i("TroopAvatarManger_NormalTroopUrlAction", 2, String.format("getSrvAddr type=%d prefV6=%b getUrl=%s", Integer.valueOf(activeNetIpFamily), Boolean.valueOf(isPreferIpv6), Arrays.toString(arrayList.toArray())));
        } else {
            i3 = 0;
        }
        for (int i16 = i3; i16 < arrayList.size(); i16++) {
            arrayList.set(i16, ((String) arrayList.get(i16)) + "?htcmd=0x6ff0072&ver=5520&ukey=" + str5 + "&range=" + str2 + "&uin=" + str4 + "&seq=23&groupuin=" + str3 + "&filetype=3&imagetype=5&userdata=" + str);
        }
        return arrayList;
    }

    public String i(String str, String str2, boolean z16) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, str, str2, Boolean.valueOf(z16));
        }
        String str4 = null;
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null) {
                for (InetAddress inetAddress : allByName) {
                    if ((inetAddress instanceof Inet4Address) && z16) {
                        str3 = inetAddress.getHostAddress();
                        break;
                    }
                    if ((inetAddress instanceof Inet6Address) && !z16) {
                        str3 = inetAddress.getHostAddress();
                        break;
                    }
                }
            }
            str3 = null;
            if (!TextUtils.isEmpty(str3)) {
                str4 = h(str2, str3, 80);
            }
            QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, String.format("tryGetIpByHost host[%s] %s", str, str3));
        } catch (UnknownHostException e16) {
            QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, "UnknownHostException", e16);
        }
        return str4;
    }

    public String j(String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
        }
        int nextInt = new Random().nextInt(100);
        if (z16) {
            List<String> list = f294558i;
            str2 = list.get(Math.abs(nextInt) % list.size());
        } else if (Math.abs(nextInt) % 2 == 0) {
            str2 = "14.17.18.20";
        } else {
            str2 = "112.90.139.96";
        }
        String h16 = h(str, str2, 80);
        QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", str2, Boolean.valueOf(z16)));
        return h16;
    }
}
