package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g extends e {
    public String A;
    public String B;
    public int C;

    /* renamed from: c, reason: collision with root package name */
    public String f106790c;

    /* renamed from: d, reason: collision with root package name */
    public String f106791d;

    /* renamed from: e, reason: collision with root package name */
    public int f106792e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f106793f;

    /* renamed from: g, reason: collision with root package name */
    public int f106794g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f106795h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f106796i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f106797j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f106798k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f106799l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f106800m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f106801n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f106802o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f106803p;

    /* renamed from: q, reason: collision with root package name */
    public long f106804q;

    /* renamed from: r, reason: collision with root package name */
    public long f106805r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f106806s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f106807t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f106808u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f106809v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f106810w;

    /* renamed from: x, reason: collision with root package name */
    private HashSet<String> f106811x;

    /* renamed from: y, reason: collision with root package name */
    private List<b> f106812y;

    /* renamed from: z, reason: collision with root package name */
    private HashMap<Integer, String> f106813z;

    public g(String str) {
        super(str);
        this.f106790c = WadlProxyConsts.DEFAULT_MGR_URL;
        this.f106791d = WadlProxyConsts.DEFAULT_MGR_SCHEME;
        this.f106792e = 0;
        this.f106793f = false;
        this.f106794g = 0;
        this.f106795h = false;
        this.f106796i = false;
        this.f106797j = false;
        this.f106798k = false;
        this.f106799l = false;
        this.f106800m = false;
        this.f106801n = false;
        this.f106802o = true;
        this.f106803p = false;
        this.f106804q = 500L;
        this.f106805r = 86400000L;
        this.f106806s = true;
        this.f106807t = true;
        this.f106808u = true;
        this.f106809v = true;
        this.f106810w = true;
        this.f106811x = new HashSet<>();
        this.A = "";
        this.B = "";
        this.C = 10;
        this.f106812y = new ArrayList();
        this.f106813z = new HashMap<>();
    }

    private void e() {
        JSONObject jSONObject;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = true;
        try {
            jSONObject = new JSONObject(this.f106789b.optString(GameCenterUtil.CONF_KEY_AUTO_DOWNLOAD_INFO, ""));
        } catch (Exception e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseHardCodeInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (jSONObject.optInt("isDelayDownload", 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f106806s = z16;
            if (jSONObject.optInt("isAppointDownload", 1) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f106807t = z17;
            if (jSONObject.optInt("isUpdateDownload", 1) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.f106808u = z18;
            if (jSONObject.optInt("isResApkDownload", 1) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.f106809v = z19;
            if (jSONObject.optInt("isResDefDownload", 1) != 1) {
                z26 = false;
            }
            this.f106810w = z26;
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optAutoDownloadInfo autoDownloadInfo is empty");
    }

    private void f() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.f106789b.optString(GameCenterUtil.CONF_KEY_MATCH_INFO, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optOtherInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.f106804q = jSONObject.optLong(GameCenterUtil.CONF_KEY_MATCH_SLEEP_TIME, 500L);
            this.f106805r = jSONObject.optLong(GameCenterUtil.CONF_KEY_MATCH_CONFIG_INVALID_TIME, 86400000L);
            QLog.d("Wadl_WadlCommConfig", 1, "optOtherInfo matchSleepTime=" + this.f106804q + ",interruptCofInvalidTime=" + this.f106805r);
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optOtherInfo matchInfo is empty");
    }

    private void g() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.f106789b.optString(GameCenterUtil.CONF_KEY_FLOAT_WINDOW_INFO, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseFloatWindowInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.A = jSONObject.optString("title");
            this.B = jSONObject.optString("content");
            QLog.d("Wadl_WadlCommConfig", 1, "optParseFloatWindowInfo floatWindowTitle=" + this.A + ",floatWindowContent=" + this.B);
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseFloatWindowInfo floatWindowInfo is empty");
    }

    private void h() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.f106789b.optString(GameCenterUtil.CONF_KEY_HARDCODE_INFO, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseHardCodeInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            boolean z16 = false;
            if (jSONObject.optInt("hardCodeSwitch", 0) == 1) {
                z16 = true;
            }
            int optInt = jSONObject.optInt("maxTaskNum", 1);
            int optInt2 = jSONObject.optInt("threadNum", 3);
            GameCenterSpUtils.writeToSpBool(WadlProxyConsts.KEY_HARD_CODE_SWITCH, z16);
            GameCenterSpUtils.writeToSpInt(WadlProxyConsts.KEY_TASK_NUM, optInt);
            GameCenterSpUtils.writeToSpInt(WadlProxyConsts.KEY_THREAD_NUM, optInt2);
            QLog.d("Wadl_WadlCommConfig", 1, "optParseHardCodeInfo hardCodeSwitchOn=" + z16 + ",maxTaskNum=" + optInt + ",maxThreadNum=" + optInt2);
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseHardCodeInfo hardCodeInfo is empty");
    }

    private void i() {
        JSONObject jSONObject;
        int i3;
        try {
            jSONObject = new JSONObject(this.f106789b.optString("url_match_rule", ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseMatchInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("reg_list");
            if (optJSONArray != null) {
                i3 = optJSONArray.length();
            } else {
                i3 = 0;
            }
            try {
                if (i3 > 0) {
                    for (int i16 = 0; i16 < i3; i16++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                        b bVar = new b();
                        bVar.f106752a = jSONObject2.getString("pattern");
                        bVar.f106754c = jSONObject2.getInt("path_node_num");
                        bVar.f106755d = jSONObject2.getInt("appid_index");
                        bVar.f106756e = jSONObject2.optInt("app_name_index", -1);
                        bVar.f106753b = jSONObject2.getString("split_name_char");
                        bVar.f106757f = jSONObject2.getInt("name_node_num");
                        bVar.f106758g = jSONObject2.optInt("channel_index", -1);
                        int i17 = jSONObject2.getInt("pkg_name_index");
                        bVar.f106759h = i17;
                        int i18 = bVar.f106755d;
                        int i19 = bVar.f106754c;
                        if (i18 < i19 && bVar.f106756e < i19) {
                            int i26 = bVar.f106758g;
                            int i27 = bVar.f106757f;
                            if (i26 < i27 && i17 < i27) {
                                this.f106812y.add(bVar);
                            }
                        }
                    }
                    QLog.d("Wadl_WadlCommConfig", 1, "optParseMatchInfo regList size=" + this.f106812y.size());
                    return;
                }
                QLog.d("Wadl_WadlCommConfig", 1, "optParseMatchInfo regArray is empty");
                return;
            } catch (JSONException e17) {
                QLog.e("Wadl_WadlCommConfig", 1, "optParseMatchInfo exception", e17);
                return;
            }
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseMatchInfo matchRuleObject is empty");
    }

    private void j() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.f106789b.optString(GameCenterUtil.CONF_KEY_SCHEDULE_INFO, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseScheduleInfo exception", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            QLog.d("Wadl_WadlCommConfig", 1, "optParseScheduleInfo scheduleStr=" + jSONObject2);
            GameCenterSpUtils.setStringOutAccount(WadlProxyConsts.KEY_SCHEDULE_INFO, jSONObject2);
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseScheduleInfo scheduleInfo is empty");
    }

    private void k() {
        JSONArray jSONArray;
        int length;
        try {
            jSONArray = new JSONArray(this.f106789b.optString(GameCenterUtil.CONF_KEY_WEB_SSO_CMDS, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseSsoCmdInfo exception", e16);
            jSONArray = null;
        }
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            synchronized (this.f106811x) {
                this.f106811x.clear();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = jSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        this.f106811x.add(optString);
                    }
                }
            }
            QLog.d("Wadl_WadlCommConfig", 1, "optParseSsoCmdInfo webSsoCmds size=" + this.f106811x.size());
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseSsoCmdInfo cmdArray is empty");
    }

    private void l() {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(this.f106789b.optString(GameCenterUtil.CONF_KEY_TIPS_PRE_INFO, ""));
        } catch (JSONException e16) {
            QLog.e("Wadl_WadlCommConfig", 1, "optParseTipsInfo exception", e16);
            jSONArray = null;
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("type", -1);
                    String optString = optJSONObject.optString("content");
                    QLog.d("Wadl_WadlCommConfig", 1, "optParseTipsInfo type=" + optInt + ",tipsStr=" + optString);
                    if (optInt > -1 && !TextUtils.isEmpty(optString)) {
                        this.f106813z.put(Integer.valueOf(optInt), optString);
                    }
                }
            }
            return;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "optParseTipsInfo tipsPreInfoArray is empty");
    }

    private ApkInfo m(String str, String str2, b bVar) {
        int lastIndexOf;
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2) || bVar == null || (lastIndexOf = str2.lastIndexOf("/") + 1) < 2) {
            return null;
        }
        String substring = str2.substring(lastIndexOf);
        String[] split = str2.substring(0, lastIndexOf).split("/");
        String[] split2 = substring.split(bVar.f106753b);
        if (split.length >= bVar.f106754c && split2.length >= bVar.f106757f) {
            String str5 = split[bVar.f106755d];
            int i3 = bVar.f106756e;
            if (i3 <= -1) {
                str3 = "";
            } else {
                str3 = split[i3];
            }
            int i16 = bVar.f106758g;
            if (i16 <= -1) {
                str4 = "";
            } else {
                str4 = split2[i16];
            }
            ApkInfo apkInfo = new ApkInfo(str5, str3, str4, split2[bVar.f106759h], str);
            apkInfo.from = 0;
            apkInfo.jumpType = 0;
            return apkInfo;
        }
        QLog.d("Wadl_WadlCommConfig", 1, "interrupt url fail, pathInfo.length=" + split.length + ",fileInfo.length=" + split2.length);
        return null;
    }

    private void n() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        this.f106790c = this.f106789b.optString(GameCenterUtil.CONF_KEY_DOWNLOAD_MGR_URL, WadlProxyConsts.DEFAULT_MGR_URL);
        this.f106791d = this.f106789b.optString(GameCenterUtil.CONF_KEY_INTERRUPT_SCHEME, WadlProxyConsts.DEFAULT_MGR_SCHEME);
        boolean z37 = false;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_CLEAR_FILE_SWITCH, 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f106793f = z16;
        this.f106792e = this.f106789b.optInt(GameCenterUtil.CONF_KEY_AUTH_DIALOG, 0);
        int optInt = this.f106789b.optInt(GameCenterUtil.CONF_KEY_AUTO_DOWNLOAD_PULL, 1);
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_INTERRUPT_URL_SWITCH, 0) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f106795h = z17;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_INTERRUPT_REGEX_SWITCH, 1) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f106796i = z18;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_INTERRUPT_MAPPING_SWITCH, 1) == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f106797j = z19;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_INTERRUPT_JOINT_REGEX_SWITCH, 0) == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        this.f106798k = z26;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_INTERRUPT_JOINT_SWITCH, 1) == 1) {
            z27 = true;
        } else {
            z27 = false;
        }
        this.f106799l = z27;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_SPEED_LIMIT, 0) == 1) {
            z28 = true;
        } else {
            z28 = false;
        }
        this.f106800m = z28;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_TGPA_PROVIDER_SWITCH, 0) == 1) {
            z29 = true;
        } else {
            z29 = false;
        }
        this.f106801n = z29;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_MINI_PROVIDER_SWITCH, 1) == 1) {
            z36 = true;
        } else {
            z36 = false;
        }
        this.f106802o = z36;
        if (this.f106789b.optInt(GameCenterUtil.CONF_KEY_REPORT_PERMISSION_SWITCH, 1) == 1) {
            z37 = true;
        }
        this.f106803p = z37;
        this.C = this.f106789b.optInt(GameCenterUtil.CONF_KEY_REPORT_RATE, 10);
        QLog.d("Wadl_WadlCommConfig", 1, "parseSwitch downloadMgrUrl=" + this.f106790c + ",interruptScheme=" + this.f106791d + ",clearFileSwitchOn=" + this.f106793f + ",authDialog=" + this.f106792e + ",pullAutoDownloadSwitch=" + optInt + ",interruptSwitchOn=" + this.f106795h + ",interruptRegexSwitchOn=" + this.f106796i + ",interruptMappingSwitchOn=" + this.f106797j + ",interruptJointRegexSwitchOn=" + this.f106798k + ",interruptJointSwitchOn=" + this.f106799l + ",speedLimitSwitchOn=" + this.f106800m + ",tgpaProviderSwitchOn=" + this.f106801n + ",miniProviderSwitchOn=" + this.f106802o + ",reportPermissionSwitchOn=" + this.f106803p + ",reportSampleRate=" + this.C);
        GameCenterSpUtils.writeToSpInt(WadlProxyConsts.KEY_PULL_AUTODOWNLOAD_SWITCH, optInt);
    }

    @Override // com.tencent.gamecenter.wadl.biz.entity.e
    public void a(JSONObject jSONObject, String str) {
        super.a(jSONObject, str);
        if (this.f106789b == null) {
            return;
        }
        try {
            i();
            n();
            h();
            j();
            l();
            k();
            g();
            e();
            f();
        } catch (Throwable th5) {
            QLog.e("Wadl_WadlCommConfig", 1, "parse exception", th5);
        }
    }

    public String b(int i3) {
        return this.f106813z.get(Integer.valueOf(i3));
    }

    public HashSet<String> c() {
        return this.f106811x;
    }

    public ApkInfo d(String str) {
        ApkInfo apkInfo = null;
        try {
            for (b bVar : this.f106812y) {
                Matcher matcher = Pattern.compile(bVar.f106752a).matcher(str);
                if (matcher.find()) {
                    apkInfo = m(str, matcher.group(), bVar);
                }
                if (apkInfo != null) {
                    break;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return apkInfo;
    }
}
