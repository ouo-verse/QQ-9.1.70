package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.superplayer.tools.utils.e;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f345598a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(TVKPlayerVideoInfo.PLAYER_CFG_KEY_PREVID, "previd");
        hashMap.put("vinfo_key_toushe", TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE);
        hashMap.put("vinfo_key_from_platform", TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM);
        hashMap.put("vinfo_key_sptest", TVKCommonParamEnum.REQ_PARAM_KEY_SPTEST);
        hashMap.put("vinfo_key_drm", TVKCommonParamEnum.REQ_PARAM_KEY_DRM);
        hashMap.put("vinfo_key_spvideo", TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO);
        hashMap.put("vinfo_key_spaudio", "spaudio");
        f345598a = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, boolean z16) {
        e.a(tVKPlayerVideoInfo, str, !z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        Map<String, String> configMap = tVKPlayerVideoInfo.getConfigMap();
        Map<String, String> extraRequestParamsMap = tVKPlayerVideoInfo.getExtraRequestParamsMap();
        if (configMap != null && !configMap.isEmpty()) {
            if (extraRequestParamsMap == null) {
                extraRequestParamsMap = new HashMap<>();
            }
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(f345598a.keySet());
            hashSet.retainAll(configMap.keySet());
            for (String str : hashSet) {
                extraRequestParamsMap.put(f345598a.get(str), configMap.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        String d16 = tt3.a.d();
        if (!TextUtils.isEmpty(d16)) {
            String[] split = d16.split("[.]");
            if (split.length > 0) {
                tVKPlayerVideoInfo.addExtraRequestParamsMap(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_VERSION_TAG, split[split.length - 1]);
            }
        }
    }

    private static void d(String str, Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append("(");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb5.append("[");
                sb5.append(entry.getKey());
                sb5.append("]");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append("[");
                sb5.append(entry.getValue());
                sb5.append("]&");
            }
        } else {
            sb5.append("null");
        }
        sb5.append(")");
        int length = sb5.length();
        for (int i3 = 0; i3 < (length / 1024) + 1; i3++) {
            int i16 = i3 * 1024;
            int i17 = length - i16;
            if (i17 >= 1024) {
                i17 = 1024;
            }
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", sb5.substring(i16, i17 + i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        d("### ConfigMap:", tVKPlayerVideoInfo.getConfigMap());
        d("### ExtraRequestParamsMap:", tVKPlayerVideoInfo.getExtraRequestParamsMap());
        d("### ReportInfoMap:", tVKPlayerVideoInfo.getReportInfoMap());
        d("### AdReportInfo:", tVKPlayerVideoInfo.getAdReportInfoMap());
        d("### ProxyExtra:", tVKPlayerVideoInfo.getProxyExtraMap());
        d("### AdRequestParamMap:", tVKPlayerVideoInfo.getAdRequestParamMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(c cVar, b bVar) {
        boolean z16;
        if (cVar == null || bVar == null || cVar.k() == null) {
            return;
        }
        String a16 = vt3.d.D0.a();
        if (a16 == null) {
            a16 = "";
        }
        String d16 = bVar.b().d();
        if (!TextUtils.isEmpty(a16) && g.b(d16, a16) > 0) {
            bVar.b().e(a16);
            cVar.d(a16);
            return;
        }
        if (TextUtils.isEmpty(d16)) {
            cVar.d(d16);
            return;
        }
        boolean z17 = false;
        if (cVar.k().getPlayType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || cVar.k().getPlayType() == 3) {
            z17 = true;
        }
        if (z17 && d16.equalsIgnoreCase("hd") && bVar.b().l() == 1) {
            bVar.b().e("mp4");
            cVar.d("mp4");
        }
    }
}
