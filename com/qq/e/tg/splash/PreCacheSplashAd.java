package com.qq.e.tg.splash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.util.ArrayUtilStub;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class PreCacheSplashAd {

    /* renamed from: a, reason: collision with root package name */
    private String f40695a;

    /* renamed from: b, reason: collision with root package name */
    private String f40696b;

    /* renamed from: c, reason: collision with root package name */
    private String f40697c;

    /* renamed from: d, reason: collision with root package name */
    private String f40698d;

    /* renamed from: e, reason: collision with root package name */
    private volatile String f40699e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f40700f;

    /* renamed from: g, reason: collision with root package name */
    private int f40701g;

    /* renamed from: h, reason: collision with root package name */
    private String f40702h;

    /* renamed from: i, reason: collision with root package name */
    private String f40703i;

    /* renamed from: j, reason: collision with root package name */
    private String f40704j;

    /* renamed from: k, reason: collision with root package name */
    private String f40705k;

    /* renamed from: l, reason: collision with root package name */
    private String f40706l;

    /* renamed from: m, reason: collision with root package name */
    private String f40707m;

    /* renamed from: n, reason: collision with root package name */
    private Pair<Long, Long> f40708n;

    /* renamed from: o, reason: collision with root package name */
    private long f40709o;

    /* renamed from: p, reason: collision with root package name */
    private List<Pair<Integer, Integer>> f40710p;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f40711a;

        /* renamed from: b, reason: collision with root package name */
        private int f40712b;

        /* renamed from: c, reason: collision with root package name */
        private String f40713c;

        /* renamed from: d, reason: collision with root package name */
        private String f40714d;

        /* renamed from: e, reason: collision with root package name */
        private String f40715e;

        /* renamed from: f, reason: collision with root package name */
        private String f40716f;

        /* renamed from: g, reason: collision with root package name */
        private String f40717g;

        /* renamed from: h, reason: collision with root package name */
        private String f40718h;

        /* renamed from: i, reason: collision with root package name */
        private String f40719i;

        /* renamed from: j, reason: collision with root package name */
        private String f40720j;

        /* renamed from: k, reason: collision with root package name */
        private String f40721k;

        /* renamed from: l, reason: collision with root package name */
        private String f40722l;

        /* renamed from: m, reason: collision with root package name */
        private Pair<Long, Long> f40723m;

        /* renamed from: n, reason: collision with root package name */
        private long f40724n;

        /* renamed from: o, reason: collision with root package name */
        private List<Pair<Integer, Integer>> f40725o;

        public PreCacheSplashAd build() {
            return new PreCacheSplashAd(this.f40711a, this.f40712b, this.f40713c, this.f40716f, this.f40717g, this.f40718h, this.f40719i, this.f40720j, this.f40721k, this.f40722l, this.f40723m, this.f40724n, this.f40725o, this.f40714d, this.f40715e);
        }

        public Builder setAid(String str) {
            this.f40722l = str;
            return this;
        }

        public Builder setApUrl(String str) {
            this.f40718h = str;
            return this;
        }

        public Builder setCollisionAnimationUrl(String str) {
            this.f40715e = str;
            return this;
        }

        public Builder setDate(String str) {
            this.f40721k = str;
            return this;
        }

        public Builder setEffectTimes(List<Pair<Integer, Integer>> list) {
            this.f40725o = list;
            return this;
        }

        public Builder setGotDataTimeMillis(long j3) {
            this.f40724n = j3;
            return this;
        }

        public Builder setIconZipUrl(String str) {
            this.f40714d = str;
            return this;
        }

        public Builder setImg(String str) {
            this.f40713c = str;
            return this;
        }

        public Builder setMaxExposureDate(String str) {
            this.f40719i = str;
            return this;
        }

        public Builder setPosId(String str) {
            this.f40720j = str;
            return this;
        }

        public Builder setTimeLife(int i3) {
            this.f40712b = i3;
            return this;
        }

        public Builder setUoid(String str) {
            this.f40711a = str;
            return this;
        }

        public Builder setValidTimeDuration(Pair<Long, Long> pair) {
            this.f40723m = pair;
            return this;
        }

        public Builder setVideo(String str) {
            this.f40716f = str;
            return this;
        }

        public Builder setVideoFirstFrameUrl(String str) {
            this.f40717g = str;
            return this;
        }
    }

    public PreCacheSplashAd(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Pair<Long, Long> pair, long j3, List<Pair<Integer, Integer>> list, String str10, String str11) {
        this.f40695a = null;
        this.f40696b = null;
        this.f40697c = null;
        this.f40698d = null;
        this.f40700f = str;
        this.f40701g = i3;
        this.f40702h = str2;
        this.f40703i = str10;
        this.f40704j = str11;
        this.f40705k = str3;
        this.f40697c = str4;
        this.f40706l = str5;
        this.f40707m = str6;
        this.f40695a = str7;
        this.f40696b = str8;
        this.f40698d = str9;
        this.f40708n = pair;
        this.f40709o = j3;
        this.f40710p = list;
    }

    public static PreCacheSplashAd fromJSONObject(String str, JSONObject jSONObject) {
        if (!JSONUtilStub.notNull(jSONObject)) {
            return null;
        }
        String optString = JSONUtilStub.optString(jSONObject.names(), 0);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        JSONObject optJSONObject = JSONUtilStub.optJSONObject(jSONObject, optString);
        int optInt = JSONUtilStub.optInt(optJSONObject, "timeLife");
        String optString2 = JSONUtilStub.optString(optJSONObject, "img", null);
        String optString3 = JSONUtilStub.optString(optJSONObject, "icon_zip_url", null);
        String optString4 = JSONUtilStub.optString(optJSONObject, "collision_animation_url", null);
        String optString5 = JSONUtilStub.optString(optJSONObject, "video", null);
        return new Builder().setPosId(str).setUoid(optString).setAid(JSONUtilStub.optString(optJSONObject, "aid", null)).setImg(optString2).setIconZipUrl(optString3).setCollisionAnimationUrl(optString4).setVideo(optString5).setVideoFirstFrameUrl(JSONUtilStub.optString(optJSONObject, "videoFirstFrameUrl", null)).setTimeLife(optInt).setGotDataTimeMillis(JSONUtilStub.optInt(optJSONObject, "dataFetchTimeMillis")).build();
    }

    public final JSONObject formatOrderInfo() {
        String str;
        JSONObject newJSONObject = JSONUtilStub.newJSONObject();
        JSONObject newJSONObject2 = JSONUtilStub.newJSONObject();
        if (isEmpty()) {
            JSONUtilStub.put(newJSONObject2, this.f40707m, this.f40706l);
            str = this.f40695a;
        } else {
            JSONUtilStub.put(newJSONObject2, "aid", this.f40698d);
            JSONUtilStub.put(newJSONObject2, "timeLife", Integer.valueOf(this.f40701g));
            JSONUtilStub.put(newJSONObject2, "img", this.f40702h);
            JSONUtilStub.put(newJSONObject2, "icon_zip_url", this.f40703i);
            JSONUtilStub.put(newJSONObject2, "collision_animation_url", this.f40704j);
            JSONUtilStub.put(newJSONObject2, "video", this.f40705k);
            JSONUtilStub.put(newJSONObject2, "videoFirstFrameUrl", this.f40697c);
            JSONUtilStub.put(newJSONObject2, "dataFetchTimeMillis", Long.valueOf(this.f40709o));
            str = this.f40700f;
        }
        JSONUtilStub.put(newJSONObject, str, newJSONObject2);
        return newJSONObject;
    }

    public final String getAid() {
        return this.f40698d;
    }

    public final String getApUrl() {
        return this.f40706l;
    }

    public final String getCollisionAnimationUrl() {
        return this.f40704j;
    }

    public final String getDate() {
        return this.f40696b;
    }

    public final List<Pair<Integer, Integer>> getEffectTimes() {
        return this.f40710p;
    }

    public final long getGotDataTimeMillis() {
        return this.f40709o;
    }

    public final String getIconZipUrl() {
        return this.f40703i;
    }

    public final String getImg() {
        return this.f40702h;
    }

    public final String getMaxExposureDate() {
        return this.f40707m;
    }

    public final String getPosId() {
        return this.f40695a;
    }

    public final String getPreloadData() {
        return this.f40699e;
    }

    public final int getTimeLife() {
        return this.f40701g;
    }

    public final String getUoid() {
        return this.f40700f;
    }

    public final Pair<Long, Long> getValidTimeDuration() {
        return this.f40708n;
    }

    public final String getVideo() {
        return this.f40705k;
    }

    public final String getVideoFirstFrameUrl() {
        return this.f40697c;
    }

    public final boolean isEmpty() {
        if (!TextUtils.isEmpty(this.f40706l)) {
            return true;
        }
        return false;
    }

    public final boolean isInEnableTime() {
        long j3 = 0;
        if (getGotDataTimeMillis() != 0) {
            long currentTimeMillis = System.currentTimeMillis() - getGotDataTimeMillis();
            GDTLogger.i("[isInEnableTime] timeGap :" + currentTimeMillis + " ValidTimeDuration :" + getValidTimeDuration());
            if (getValidTimeDuration() != null) {
                j3 = ((Long) getValidTimeDuration().second).longValue();
            }
            if (currentTimeMillis > j3 * 60000) {
                return false;
            }
            return true;
        }
        if (!ArrayUtilStub.isNotNullAndEmpty(this.f40710p)) {
            return true;
        }
        int currentTimeInMinute = TGSplashPreCacheUtil.getCurrentTimeInMinute();
        GDTLogger.i("[isInEnableTime] effectTimes :" + Arrays.toString(this.f40710p.toArray()));
        GDTLogger.i("[isInEnableTime] currentTimeInMinute :" + currentTimeInMinute);
        for (int i3 = 0; i3 < this.f40710p.size(); i3++) {
            if (this.f40710p.get(i3) != null) {
                int intValue = ((Integer) this.f40710p.get(i3).first).intValue();
                int intValue2 = ((Integer) this.f40710p.get(i3).second).intValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                if (intValue2 > 1440) {
                    intValue2 = 1440;
                }
                if (intValue < intValue2 && currentTimeInMinute <= intValue2 && currentTimeInMinute >= intValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSrcReady(Context context) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        if (context != null && !TextUtils.isEmpty(this.f40695a)) {
            if (isEmpty()) {
                if (!TextUtils.isEmpty(this.f40706l) && !TextUtils.isEmpty(this.f40707m)) {
                    return true;
                }
                str = "PreCacheSplashAd [isValid] isEmpty params error";
            } else if (TextUtils.isEmpty(this.f40700f)) {
                str = "PreCacheSplashAd [isValid] no uoid error";
            } else {
                File videoFile = TGSplashFileUtil.getVideoFile(context, this.f40705k);
                File imgFile = TGSplashFileUtil.getImgFile(context, this.f40702h);
                File imgFile2 = TGSplashFileUtil.getImgFile(context, this.f40697c);
                if (videoFile != null && videoFile.exists()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (imgFile != null && imgFile.exists()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (imgFile2 != null && imgFile2.exists()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                GDTLogger.i("PreCacheSplashAd [isValid] videoReady :" + z16 + " url:" + this.f40705k);
                GDTLogger.i("PreCacheSplashAd [isValid] imgReady :" + z17 + " url:" + this.f40702h);
                GDTLogger.i("PreCacheSplashAd [isValid] videoFirstFrameReady :" + z18 + " url:" + this.f40697c);
                if (TextUtils.isEmpty(this.f40705k) && TextUtils.isEmpty(this.f40697c) && !TextUtils.isEmpty(this.f40702h)) {
                    return z17;
                }
                if (TextUtils.isEmpty(this.f40705k) || TextUtils.isEmpty(this.f40697c) || TextUtils.isEmpty(this.f40702h) || ((!z16 || !z18) && (z16 || !z17))) {
                    return false;
                }
                return true;
            }
        } else {
            str = "PreCacheSplashAd [isValid] params error";
        }
        GDTLogger.e(str);
        return false;
    }

    public final boolean isValid(Context context) {
        if (isInEnableTime() && isSrcReady(context)) {
            return true;
        }
        return false;
    }

    public final void updatePreloadData(String str) {
        this.f40699e = str;
    }
}
