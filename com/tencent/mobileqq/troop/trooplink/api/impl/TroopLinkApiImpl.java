package com.tencent.mobileqq.troop.trooplink.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLinkApiImpl implements ITroopLinkApi {
    static IPatchRedirector $redirector_ = null;
    public static final String CONFIG_FILE_NAME = "troop_link_config.json";
    public static final String TAG = ".troop.trooplink";
    public static final HashMap<String, String> urlMaps;
    protected boolean isUpdateServer;
    protected Object mLock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65035);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        urlMaps = hashMap;
        hashMap.put("troop_create", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
        hashMap.put("troop_create_for_school", "https://admin.qun.qq.com/mcreatev4/classinfo?");
        hashMap.put("troop_create_for_game", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
        hashMap.put("troop_rank", "https://qun.qq.com/qqweb/m/qun/rank/rank.html?gc=<$GC>&uin=<$UIN>&from=<$FROM>&_wv=1031&_bid=2468");
        hashMap.put("troop_level", "https://qinfo.clt.qq.com/qlevel/level.html?gc=<$GC>&type=<$TYPE>");
        hashMap.put("troop_unique_title", "https://qun.qq.com/qqweb/m/qun/medal/index.html?_wv=16777223&_bid=2504&gc=<$GC>&uin=<$UIN>&from=<$FROM>");
        hashMap.put("troop_create_notice", "https://web.qun.qq.com/mannounce/edit.html?_bid=148&_wv=1031&gc=<$GC>&title=<$TITLE>&content=<$CONTENT>&from=<$FROM>&school=1");
        hashMap.put("troop_create_homework", "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>");
        hashMap.put("troop_list_homework", "https://qun.qq.com/homework/features/v2/index.html?_wv=1027&_bid=3089&gc=<$GC>&from=<$FROM>");
        hashMap.put("troop_homework_create_notice", "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>");
        hashMap.put("troop_bind_game", "https://static.gamecenter.qq.com/social-web/group-bind-game/index.html?_wvx=10&_wvxBclr=0xffffff&_wv=1027");
        hashMap.put("troop_honor_page", "https://qun.qq.com/interactive/qunhonor?gc=<$GC>&_wv=3&&_wwv=128");
        hashMap.put("troop_member_honor_page", "https://qun.qq.com/interactive/userhonor?uin=<$UIN>&gc=<$GC>&_wv=3&&_wwv=128");
        hashMap.put("troop_honor_setting", "https://qinfo.clt.qq.com/qlevel/setting.html?_wv=4&_bid=125#gc=<$GC>&type=102&grayscale=<$GRAY>");
        hashMap.put("guild_create", "https://qun.qq.com/guild/h5/guild-create/index.html?_wv=54183&_wwv=128&cateid=50000&from=plus");
    }

    public TroopLinkApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLock = new Object();
        this.isUpdateServer = false;
        ThreadManagerV2.post(new Runnable(MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + File.separator + CONFIG_FILE_NAME) { // from class: com.tencent.mobileqq.troop.trooplink.api.impl.TroopLinkApiImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f300501d;

            {
                this.f300501d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLinkApiImpl.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    synchronized (TroopLinkApiImpl.this.mLock) {
                        if (TroopLinkApiImpl.this.isUpdateServer) {
                            return;
                        }
                        File file = new File(this.f300501d);
                        if (file.exists()) {
                            JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
                            Iterator keys = jSONObject.keys();
                            synchronized (TroopLinkApiImpl.this.mLock) {
                                while (keys.hasNext()) {
                                    String str = (String) keys.next();
                                    TroopLinkApiImpl.urlMaps.put(str, jSONObject.getString(str));
                                }
                            }
                            return;
                        }
                        QLog.e(TroopLinkApiImpl.TAG, 1, "config not find!");
                    }
                } catch (Exception e16) {
                    QLog.e(TroopLinkApiImpl.TAG, 1, "readConfig failed!", e16);
                }
            }
        }, 5, null, false);
    }

    private String replace(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            str = str.replace(str2, (String) bundle.get(str2));
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getSmartManagerUrl(String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str.replace("$GCODE$", str2).replace("$ROBOTUIN$", String.valueOf(j3)).replace("$RPID$", String.valueOf(i3));
        }
        QLog.d("TroopManage", 1, "getSmartManagerUrl, url: " + str + ", troopUin: " + str2 + ", robotUin: " + j3 + ", id: " + i3);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getTroopHonorSettingUrl(String str, boolean z16) {
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
        }
        ITroopLinkApi.a c16 = ITroopLinkApi.a.a().c(str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        String url = getUrl("troop_honor_setting", c16.d(str2));
        if (SimpleUIUtil.getSimpleUISwitch()) {
            int simpleUiBgColor = SimpleUIUtil.getSimpleUiBgColor();
            if (simpleUiBgColor != 0) {
                str3 = "&mode_color=" + String.format("%08x", Integer.valueOf(simpleUiBgColor)).substring(2);
            } else {
                str3 = "&mode_color=000000";
            }
            return url + str3;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getTroopHonorUrl(String str, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        }
        String url = getUrl("troop_honor_page", ITroopLinkApi.a.a().c(str));
        if (SimpleUIUtil.getSimpleUISwitch()) {
            int simpleUiBgColor = SimpleUIUtil.getSimpleUiBgColor();
            if (simpleUiBgColor != 0) {
                str2 = "&mode_color=" + String.format("%08x", Integer.valueOf(simpleUiBgColor)).substring(2);
            } else {
                str2 = "&mode_color=000000";
            }
            url = url + str2;
        }
        return url + "&dragon_gray=" + i3;
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getTroopMemberHonorUrl(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        return getUrl("troop_member_honor_page", ITroopLinkApi.a.a().g(str2).c(str));
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getTroopMemberLevelUrl(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, str, str2, str3, str4, str5);
        }
        String url = getUrl("troop_unique_title", ITroopLinkApi.a.a().c(str).g(str2).e(str3).f("3").b("aio"));
        if (TextUtils.isEmpty(url)) {
            return "https://web.qun.qq.com/cgi-bin/misc/dynamic_url?gc=" + str + ContainerUtils.FIELD_DELIMITER + "uin=" + str2 + ContainerUtils.FIELD_DELIMITER + "type=3" + ContainerUtils.FIELD_DELIMITER + "from=aio" + ContainerUtils.FIELD_DELIMITER + "_wv=16777223&_wwv=1";
        }
        return url;
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getUrl(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? replace(getUrl(str), bundle) : (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bundle);
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String replaceParams(String str, ITroopLinkApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar);
        }
        String str2 = aVar.f300493c;
        if (str2 != null) {
            str = str.replace("<$FROM>", str2);
        }
        String str3 = aVar.f300491a;
        if (str3 != null) {
            str = str.replace("<$GC>", str3);
        }
        String str4 = aVar.f300495e;
        if (str4 != null) {
            str = str.replace("<$NICK>", str4);
        }
        String str5 = aVar.f300494d;
        if (str5 != null) {
            str = str.replace("<$TYPE>", str5);
        }
        String str6 = aVar.f300492b;
        if (str6 != null) {
            str = str.replace("<$UIN>", str6);
        }
        String str7 = aVar.f300496f;
        if (str7 != null) {
            str = str.replace("<$CATEID>", str7);
        }
        String str8 = aVar.f300497g;
        if (str8 != null) {
            str = str.replace("<$SUBID>", str8);
        }
        String str9 = aVar.f300500j;
        if (str9 != null) {
            str = str.replace("<$GRAY>", str9);
        }
        String str10 = aVar.f300498h;
        if (str10 != null) {
            try {
                str = str.replace("<$TITLE>", URLEncoder.encode(str10, "UTF-8").replaceAll("\\+", "%20"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        String str11 = aVar.f300499i;
        if (str11 != null) {
            try {
                return str.replace("<$CONTENT>", URLEncoder.encode(str11, "UTF-8").replaceAll("\\+", "%20"));
            } catch (UnsupportedEncodingException e17) {
                e17.printStackTrace();
                return str;
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public boolean saveConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "config update:" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            synchronized (this.mLock) {
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    urlMaps.put(str2, jSONObject.getString(str2));
                }
                this.isUpdateServer = true;
            }
            String str3 = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + File.separator + CONFIG_FILE_NAME;
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
            ThreadManagerV2.post(new Runnable(str3, str) { // from class: com.tencent.mobileqq.troop.trooplink.api.impl.TroopLinkApiImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f300502d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f300503e;

                {
                    this.f300502d = str3;
                    this.f300503e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopLinkApiImpl.this, str3, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!FileUtils.writeFile(this.f300502d, this.f300503e)) {
                        MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences().edit().putInt("troop_link_config_version", 0).commit();
                    }
                }
            }, 5, null, false);
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseConfig failed!", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
    public String getUrl(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        synchronized (this.mLock) {
            str2 = urlMaps.get(str);
        }
        return str2;
    }

    private String getUrl(String str, ITroopLinkApi.a aVar) {
        String url = getUrl(str);
        return (TextUtils.isEmpty(url) || aVar == null) ? url : replaceParams(url, aVar);
    }
}
