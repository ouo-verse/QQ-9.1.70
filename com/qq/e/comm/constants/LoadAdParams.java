package com.qq.e.comm.constants;

import com.qq.e.comm.adevent.ADListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LoadAdParams {

    /* renamed from: a, reason: collision with root package name */
    private int f38138a;

    /* renamed from: b, reason: collision with root package name */
    private LoginType f38139b;

    /* renamed from: c, reason: collision with root package name */
    private String f38140c;

    /* renamed from: d, reason: collision with root package name */
    private String f38141d;

    /* renamed from: e, reason: collision with root package name */
    private String f38142e;

    /* renamed from: f, reason: collision with root package name */
    private int f38143f;

    /* renamed from: g, reason: collision with root package name */
    private Map f38144g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38145h;

    /* renamed from: i, reason: collision with root package name */
    private String f38146i;

    /* renamed from: j, reason: collision with root package name */
    private String[] f38147j;

    /* renamed from: k, reason: collision with root package name */
    private int f38148k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f38149l;

    /* renamed from: m, reason: collision with root package name */
    private String[] f38150m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f38151n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f38152o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f38153p;

    /* renamed from: r, reason: collision with root package name */
    private List<String> f38155r;

    /* renamed from: u, reason: collision with root package name */
    private ADListener f38158u;

    /* renamed from: v, reason: collision with root package name */
    private Map f38159v;

    /* renamed from: q, reason: collision with root package name */
    private boolean f38154q = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f38156s = true;

    /* renamed from: t, reason: collision with root package name */
    private boolean f38157t = false;

    public boolean canSetupRequest() {
        return this.f38154q;
    }

    public ADListener getAdListener() {
        return this.f38158u;
    }

    public String[] getApkNames() {
        return this.f38150m;
    }

    public List<String> getBlackAidList() {
        return this.f38155r;
    }

    public int getBlockEffectValue() {
        return this.f38143f;
    }

    public String[] getExperimentId() {
        String[] strArr = this.f38147j;
        if (strArr == null) {
            return null;
        }
        return strArr;
    }

    public String getExperimentStr() {
        String[] strArr = this.f38147j;
        if (strArr != null && strArr.length != 0) {
            return Arrays.toString(strArr);
        }
        return "";
    }

    public int getExperimentType() {
        return this.f38148k;
    }

    public boolean getFilterOneShotFlag() {
        return this.f38149l;
    }

    public int getFlowSourceId() {
        return this.f38138a;
    }

    public String getLoginAppId() {
        return this.f38140c;
    }

    public String getLoginOpenid() {
        return this.f38141d;
    }

    public LoginType getLoginType() {
        return this.f38139b;
    }

    public Map getPassThroughInfo() {
        return this.f38144g;
    }

    public String getPassThroughInfoJsonString() {
        try {
            Map map = this.f38144g;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38144g).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public JSONObject getS2sExtInfo() {
        try {
            Map map = this.f38159v;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38159v);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String getUid() {
        return this.f38146i;
    }

    public String getUin() {
        return this.f38142e;
    }

    public boolean isCanDownloadSrcInRealtimeSelect() {
        return this.f38157t;
    }

    public boolean isGooglePlayVersion() {
        return this.f38152o;
    }

    public boolean isHotLaunchNotShowFirstPlayAd() {
        return this.f38156s;
    }

    public boolean isHotStart() {
        return this.f38145h;
    }

    public boolean isRefreshAdRequest() {
        return this.f38153p;
    }

    public boolean isSupportCarouselAd() {
        return this.f38151n;
    }

    public void setAdListener(ADListener aDListener) {
        this.f38158u = aDListener;
    }

    public void setApkNames(String[] strArr) {
        this.f38150m = strArr;
    }

    public void setBlackAidList(List<String> list) {
        this.f38155r = list;
    }

    public void setBlockEffectValue(int i3) {
        this.f38143f = i3;
    }

    public void setCanDownloadSrcInRealtimeSelect(boolean z16) {
        this.f38157t = z16;
    }

    public void setCanSetupRequest(boolean z16) {
        this.f38154q = z16;
    }

    public void setExperimentId(String[] strArr) {
        this.f38147j = strArr;
    }

    public void setExperimentType(int i3) {
        this.f38148k = i3;
    }

    public void setFilterOneShotInFirstPlay(boolean z16) {
        this.f38149l = z16;
    }

    public void setFlowSourceId(int i3) {
        this.f38138a = i3;
    }

    public void setGooglePlayVersion(boolean z16) {
        this.f38152o = z16;
    }

    public void setHotLaunchNotShowFirstPlayAd(boolean z16) {
        this.f38156s = z16;
    }

    public void setHotStart(boolean z16) {
        this.f38145h = z16;
    }

    public void setLoginAppId(String str) {
        this.f38140c = str;
    }

    public void setLoginOpenid(String str) {
        this.f38141d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38139b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f38144g = map;
    }

    public void setRefreshAdRequest(boolean z16) {
        this.f38153p = z16;
    }

    public void setS2sExtInfo(Map map) {
        this.f38159v = map;
    }

    public void setSupportCarouselAd(boolean z16) {
        this.f38151n = z16;
    }

    public void setUid(String str) {
        this.f38146i = str;
    }

    public void setUin(String str) {
        this.f38142e = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId='" + this.f38138a + "', loginType=" + this.f38139b + ", loginAppId=" + this.f38140c + ", loginOpenid=" + this.f38141d + ", uin=" + this.f38142e + ", blockEffect=" + this.f38143f + ", passThroughInfo='" + this.f38144g + ", experimentId='" + Arrays.toString(this.f38147j) + ", experimentIType='" + this.f38148k + ", appNames='" + Arrays.toString(this.f38150m) + ", isSupportCarouselAd" + this.f38151n + '}';
    }
}
