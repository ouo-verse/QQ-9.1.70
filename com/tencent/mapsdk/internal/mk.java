package com.tencent.mapsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class mk implements RequestProcessor {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f149310a = true;

    /* renamed from: b, reason: collision with root package name */
    private final String f149311b;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.mk$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f149312a;

        static {
            int[] iArr = new int[NetMethod.values().length];
            f149312a = iArr;
            try {
                iArr[NetMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f149312a[NetMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    mk(String str) {
        this.f149311b = str;
    }

    public static mk a(String str) {
        return new mk(str);
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        byte[] bArr;
        String str = this.f149311b;
        if (netRequest != null && !TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(netRequest.url);
            HashMap hashMap = new HashMap();
            int i3 = AnonymousClass1.f149312a[netRequest.mNetMethod.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && ((bArr = netRequest.postData) == null || bArr.length > 0)) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr));
                        JSONArray names = jSONObject.names();
                        for (int i16 = 0; i16 < names.length(); i16++) {
                            String optString = names.optString(i16);
                            hashMap.put(optString, jSONObject.opt(optString));
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                String query = parse.getQuery();
                if (!TextUtils.isEmpty(query)) {
                    if (!f149310a && query == null) {
                        throw new AssertionError();
                    }
                    for (String str2 : query.split(ContainerUtils.FIELD_DELIMITER)) {
                        String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        String substring = str2.substring(split[0].length() + 1);
                        split[1] = substring;
                        hashMap.put(split[0], substring);
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(parse.getPath());
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (!hashMap.isEmpty()) {
                ArrayList arrayList = new ArrayList(hashMap.keySet());
                Collections.sort(arrayList);
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    String str3 = (String) arrayList.get(i17);
                    Object obj = hashMap.get(str3);
                    if (obj != null) {
                        if (i17 == arrayList.size() - 1) {
                            sb5.append(str3);
                            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb5.append(obj.toString());
                        } else {
                            sb5.append(str3);
                            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb5.append(obj.toString());
                            sb5.append(ContainerUtils.FIELD_DELIMITER);
                        }
                    }
                }
            }
            sb5.append(str);
            netRequest.url = parse.buildUpon().appendQueryParameter(PreloadTRTCPlayerParams.KEY_SIG, Util.getMD5String(sb5.toString())).build().toString();
        }
    }

    private static void a(NetRequest netRequest, String str) {
        byte[] bArr;
        if (netRequest == null || TextUtils.isEmpty(str)) {
            return;
        }
        Uri parse = Uri.parse(netRequest.url);
        HashMap hashMap = new HashMap();
        int i3 = AnonymousClass1.f149312a[netRequest.mNetMethod.ordinal()];
        if (i3 == 1) {
            String query = parse.getQuery();
            if (!TextUtils.isEmpty(query)) {
                if (!f149310a && query == null) {
                    throw new AssertionError();
                }
                for (String str2 : query.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    String substring = str2.substring(split[0].length() + 1);
                    split[1] = substring;
                    hashMap.put(split[0], substring);
                }
            }
        } else if (i3 == 2 && ((bArr = netRequest.postData) == null || bArr.length > 0)) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                JSONArray names = jSONObject.names();
                for (int i16 = 0; i16 < names.length(); i16++) {
                    String optString = names.optString(i16);
                    hashMap.put(optString, jSONObject.opt(optString));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(parse.getPath());
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (!hashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList);
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                String str3 = (String) arrayList.get(i17);
                Object obj = hashMap.get(str3);
                if (obj != null) {
                    if (i17 == arrayList.size() - 1) {
                        sb5.append(str3);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(obj.toString());
                    } else {
                        sb5.append(str3);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(obj.toString());
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
            }
        }
        sb5.append(str);
        netRequest.url = parse.buildUpon().appendQueryParameter(PreloadTRTCPlayerParams.KEY_SIG, Util.getMD5String(sb5.toString())).build().toString();
    }
}
