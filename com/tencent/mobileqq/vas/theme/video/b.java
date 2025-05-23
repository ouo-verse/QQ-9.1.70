package com.tencent.mobileqq.vas.theme.video;

import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public SuperPlayerVideoInfo f310942a;

    /* renamed from: b, reason: collision with root package name */
    private long f310943b;

    /* renamed from: c, reason: collision with root package name */
    private long f310944c;

    /* renamed from: d, reason: collision with root package name */
    public int f310945d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f310946e;

    /* renamed from: f, reason: collision with root package name */
    public int f310947f;

    /* renamed from: g, reason: collision with root package name */
    private String f310948g;

    /* renamed from: h, reason: collision with root package name */
    private String f310949h;

    /* renamed from: i, reason: collision with root package name */
    private String f310950i;

    public b(String str, Drawable drawable) {
        this.f310945d = R.drawable.skin_background;
        this.f310948g = null;
        this.f310949h = null;
        this.f310950i = null;
        this.f310946e = drawable;
        g(str);
    }

    private static void a(String str, long j3) {
        JSONObject jSONObject;
        long uptimeMillis = SystemClock.uptimeMillis();
        String decodeString = VipMMKV.getCommon().decodeString("vas_key_video_duration", "");
        try {
            if (TextUtils.isEmpty(decodeString)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(decodeString);
            }
            Iterator keys = jSONObject.keys();
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                if (optJSONObject != null && currentTimeMillis - optJSONObject.optLong("pre", 0L) > 604800000) {
                    arrayList.add(str2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONObject.remove((String) it.next());
            }
            String str3 = str + "-" + new File(str).lastModified();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pre", currentTimeMillis);
            jSONObject2.put("duration", j3);
            jSONObject.put(str3, jSONObject2);
            VipMMKV.getCommon().encodeString("vas_key_video_duration", jSONObject.toString());
        } catch (JSONException e16) {
            QLog.i("Theme.ThemeVideoInfo", 1, "cacheDurationToMMKV", e16);
            VipMMKV.getCommon().removeKey("vas_key_video_duration");
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeVideoInfo", 1, "cacheDurationToMMKV cost: " + (uptimeMillis2 - uptimeMillis));
        }
    }

    private ITPMediaAsset b(String str, String str2, String str3) {
        ITPMultiMediaAsset createMultiMediaAsset = TPMediaAssetFactory.createMultiMediaAsset();
        if (!h(str)) {
            createMultiMediaAsset.addAsset(TPMediaAssetFactory.createUrlMediaAsset(str), c(str));
        }
        createMultiMediaAsset.addAsset(TPMediaAssetFactory.createUrlMediaAsset(str2), c(str2));
        if (!h(str3)) {
            createMultiMediaAsset.addAsset(TPMediaAssetFactory.createUrlMediaAsset(str3), c(str3));
        }
        return createMultiMediaAsset;
    }

    private long c(String str) {
        Long d16 = d(str);
        if (d16 != null) {
            return d16.longValue();
        }
        int i3 = 0;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            i(str, mediaMetadataRetriever);
            long j3 = i3;
            a(str, j3);
            return j3;
        } catch (Exception e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    @Nullable
    private static Long d(String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        File file = new File(str);
        if (file.exists()) {
            long lastModified = file.lastModified();
            String decodeString = VipMMKV.getCommon().decodeString("vas_key_video_duration", "");
            try {
                if (!TextUtils.isEmpty(decodeString)) {
                    JSONObject optJSONObject = new JSONObject(decodeString).optJSONObject(str + "-" + lastModified);
                    if (optJSONObject == null) {
                        return null;
                    }
                    long optLong = optJSONObject.optLong("duration");
                    if (optLong > 0) {
                        a(str, optLong);
                        return Long.valueOf(optLong);
                    }
                }
            } catch (Exception e16) {
                QLog.e("Theme.ThemeVideoInfo", 1, "getDuration", e16);
                VipMMKV.getCommon().removeKey("vas_key_video_duration");
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeVideoInfo", 1, "getDurationFromMMKV cost: " + (uptimeMillis2 - uptimeMillis));
        }
        return null;
    }

    private void g(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, (String) null);
            this.f310942a = createVideoInfoForUrl;
            createVideoInfoForUrl.setFormat(101);
            this.f310942a.setMediaAssert(b(null, str, null));
        }
    }

    private boolean h(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return false;
        }
        return true;
    }

    private void i(String str, MediaMetadataRetriever mediaMetadataRetriever) {
        VasCommonReporter.getTheme().setNum1(Integer.parseInt(ThemeUtil.getCurrentThemeId())).setNum2(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18))).setNum3(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19))).setValue1(mediaMetadataRetriever.extractMetadata(20)).setValue2(str).setValue3("meta_data").setValue4(mediaMetadataRetriever.extractMetadata(25)).setValue5(mediaMetadataRetriever.extractMetadata(12)).report();
    }

    public long e() {
        long j3 = 0;
        if (this.f310944c <= 0) {
            if (!h(this.f310950i)) {
                j3 = c(this.f310950i);
            }
            this.f310944c = j3;
        }
        return this.f310944c;
    }

    public long f() {
        long j3 = 0;
        if (this.f310943b <= 0) {
            if (!h(this.f310948g)) {
                j3 = c(this.f310948g);
            }
            this.f310943b = j3;
        }
        return this.f310943b;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getName());
        sb5.append('{');
        sb5.append(Integer.toHexString(System.identityHashCode(this)));
        sb5.append(TokenParser.SP);
        sb5.append(",mStaticResId=");
        sb5.append(this.f310945d);
        if (this.f310942a != null) {
            sb5.append(",mVideoInfoAll=");
            sb5.append(this.f310942a);
        }
        sb5.append("}");
        return sb5.toString();
    }

    public b(String str, String str2, String str3, int i3) {
        this(str, str2, str3, i3, null);
    }

    public b(String str, String str2, String str3, int i3, String str4) {
        this.f310945d = R.drawable.skin_background;
        this.f310948g = null;
        this.f310949h = null;
        this.f310950i = null;
        if (TextUtils.isEmpty(str4)) {
            str4 = em.b().a().getString("theme_root", null);
            if (TextUtils.isEmpty(str4)) {
                return;
            }
        }
        String str5 = File.separator;
        if (!str4.endsWith(str5)) {
            str4 = str4 + str5;
        }
        this.f310948g = null;
        this.f310950i = null;
        this.f310949h = null;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f310949h = str4 + "raw/" + str2;
        if (new File(this.f310949h).exists()) {
            QLog.i("Theme.ThemeVideoInfo", 1, "pathLoop:" + this.f310949h);
            if (!TextUtils.isEmpty(str)) {
                this.f310948g = str4 + "raw/" + str;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f310950i = str4 + "raw/" + str3;
            }
            this.f310945d = i3;
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.f310949h, 101, (String) null);
            this.f310942a = createVideoInfoForUrl;
            createVideoInfoForUrl.setFormat(101);
            this.f310942a.setMediaAssert(b(this.f310948g, this.f310949h, this.f310950i));
        }
    }
}
