package com.qq.e.comm.plugin.base.ad.e;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.ag;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.xweb.FileReaderHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private static final Pattern f38769a = Pattern.compile("^https\\://v\\.gdt\\.qq\\.com/gdt_stats\\.fcg\\?viewid=([^&]*).*");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f38770b = Pattern.compile(".*[?&]viewid=([^&]*).*");

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i3);
    }

    public static void a(String str, int i3, String str2, com.qq.e.comm.plugin.base.ad.model.a aVar, a aVar2) {
        Matcher matcher = f38769a.matcher(str2);
        GDTLogger.d(matcher.matches() + "");
        if (matcher.matches() && matcher.groupCount() == 1) {
            GDTLogger.d("count" + matcher.groupCount());
            String group = matcher.group(1);
            au.a(aVar, 0L, 4003, Integer.MIN_VALUE);
            a(str2, Arrays.asList(group), aVar, aVar2);
            return;
        }
        a(com.qq.e.comm.plugin.k.b.c(str2), aVar, aVar2);
    }

    public static void a(String str, List<String> list, final com.qq.e.comm.plugin.base.ad.model.a aVar, final a aVar2) {
        String str2 = aVar.f38905a;
        new l(aVar.f38906b, aVar.f38907c, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
        final long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        if (list.size() > 0) {
            sb5.append("count=");
            sb5.append(list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append("viewid");
                sb5.append(i3);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(a(list.get(i3)));
            }
            GDTLogger.d("(ccr) exporsure string buffer = " + sb5.toString());
            if (TextUtils.isEmpty(str)) {
                str = "https://v.gdt.qq.com/gdt_stats.fcg";
            }
            String c16 = com.qq.e.comm.plugin.k.b.c(com.qq.e.comm.plugin.k.b.b(str));
            NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.plugin.base.ad.e.b.1
                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onException(Exception exc) {
                    a aVar3 = a.this;
                    if (aVar3 != null) {
                        aVar3.a(5000);
                    }
                    au.a(aVar, System.currentTimeMillis() - currentTimeMillis, 4001, Integer.MIN_VALUE);
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onResponse(Request request, Response response) {
                    if (response.getStatusCode() != 200 && response.getStatusCode() != 204) {
                        a aVar3 = a.this;
                        if (aVar3 != null) {
                            aVar3.a(response.getStatusCode());
                        }
                        au.a(aVar, System.currentTimeMillis() - currentTimeMillis, 4001, response.getStatusCode());
                    } else {
                        a aVar4 = a.this;
                        if (aVar4 != null) {
                            aVar4.a();
                        }
                        au.a(aVar, System.currentTimeMillis() - currentTimeMillis, 4000, Integer.MIN_VALUE);
                    }
                    response.getStatusCode();
                }
            };
            PlainRequest plainRequest = new PlainRequest(c16, 2, sb5.toString().getBytes(ag.f39619a));
            plainRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
            NetworkClientImpl.getInstance().submit(plainRequest, 1, networkCallBack);
        }
    }

    public static void a(int i3, int i16, int i17, int i18, int i19, int i26, int i27, String str, com.qq.e.comm.plugin.base.ad.model.a aVar, final a aVar2) {
        Matcher matcher = f38770b.matcher(str);
        String group = (matcher.matches() && matcher.groupCount() == 1) ? matcher.group(1) : "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (i27 == i26) {
                i17 = 13;
                i27 = 0;
            }
            jSONObject.put("bt", String.valueOf(i27));
            jSONObject.put(FileReaderHelper.ET_EXT, String.valueOf(i19));
            jSONObject.put("bf", i27 > 0 ? String.valueOf(0) : String.valueOf(1));
            jSONObject.put("ef", String.valueOf(i19 == i26 ? 1 : 0));
            jSONObject.put("pp", String.valueOf(i16));
            jSONObject.put("pa", String.valueOf(i17));
            jSONObject.put("ft", String.valueOf(i3));
            if (i18 == 2 || i18 == 3) {
                jSONObject.put(Constants.KEYS.PLACEMENTS, String.valueOf(i18));
            }
            GDTLogger.d("VideoPlayReport =" + jSONObject.toString());
            Arrays.asList(group);
            String str2 = aVar.f38905a;
            new l(aVar.f38906b, aVar.f38907c, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
            System.currentTimeMillis();
            NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.plugin.base.ad.e.b.2
                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onException(Exception exc) {
                    a aVar3 = a.this;
                    if (aVar3 != null) {
                        aVar3.a(5000);
                    }
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onResponse(Request request, Response response) {
                    if (response.getStatusCode() != 200 && response.getStatusCode() != 204) {
                        a aVar3 = a.this;
                        if (aVar3 != null) {
                            aVar3.a(response.getStatusCode());
                        }
                    } else {
                        a aVar4 = a.this;
                        if (aVar4 != null) {
                            aVar4.a();
                        }
                    }
                    response.getStatusCode();
                }
            };
            PlainRequest plainRequest = new PlainRequest(com.qq.e.comm.plugin.k.b.b(str), 1, (byte[]) null);
            plainRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
            plainRequest.addQuery("video", a(jSONObject.toString()));
            NetworkClientImpl.getInstance().submit(plainRequest, 1, networkCallBack);
        } catch (JSONException e16) {
            GDTLogger.e("ReportVideoInfo JSONException: " + e16.toString());
        }
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            GDTLogger.w("encode param failed:" + e16.getMessage());
            return "";
        }
    }

    private static void a(String str, com.qq.e.comm.plugin.base.ad.model.a aVar, final a aVar2) {
        au.a(aVar, 0L, 4004, Integer.MIN_VALUE);
        af.a(com.qq.e.comm.plugin.k.b.b(str), true, new af.a() { // from class: com.qq.e.comm.plugin.base.ad.e.b.3
            @Override // com.qq.e.comm.plugin.k.af.a
            public void a() {
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }

            @Override // com.qq.e.comm.plugin.k.af.a
            public void a(int i3) {
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(i3);
                }
            }
        });
    }

    public static void a(String str, JSONObject jSONObject) {
        GDTLogger.d("originalExposure with ad info: " + str);
        af.a(com.qq.e.comm.plugin.k.b.a(str, jSONObject, (String) null), true, null);
    }

    public static void a(String str, String str2) {
        GDTLogger.d("originalExposure with status : " + str);
        af.a(com.qq.e.comm.plugin.k.b.a(str, (JSONObject) null, str2), true, null);
    }
}
