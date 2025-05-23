package com.tencent.luggage.wxa.b3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.luggage.scanner.scanner.ui.BaseScanPage;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.ja.b;
import com.tencent.luggage.wxa.m9.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f121830a = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6029a implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f121831a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f121832b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121833c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Intent f121834d;

        public C6029a(WeakReference weakReference, WeakReference weakReference2, int i3, Intent intent) {
            this.f121831a = weakReference;
            this.f121832b = weakReference2;
            this.f121833c = i3;
            this.f121834d = intent;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public void a(int i3, Intent intent) {
            String str;
            String str2;
            int i16;
            boolean unused = a.f121830a = false;
            w.d("MicroMsg.JsApiScanCode", "receive scan code result");
            Context context = (Context) this.f121831a.get();
            d dVar = (d) this.f121832b.get();
            if (dVar == null) {
                w.b("MicroMsg.JsApiScanCode", "component is unreachable, unable to start inner scanner");
                return;
            }
            if (i3 != -2) {
                if (i3 != -1) {
                    if (i3 != 0) {
                        w.d("MicroMsg.JsApiScanCode", "RESULT_DEFAULT");
                        dVar.a(this.f121833c, a.this.makeReturnJson("fail"));
                        return;
                    } else {
                        w.d("MicroMsg.JsApiScanCode", "RESULT_CANCELED");
                        dVar.a(this.f121833c, a.this.makeReturnJson("cancel"));
                        return;
                    }
                }
                w.d("MicroMsg.JsApiScanCode", "RESULT_OK");
                String encodeToString = Base64.encodeToString(new byte[0], 2);
                if (intent != null) {
                    str = intent.getStringExtra("key_scan_result");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("key_scan_result_raw");
                    if (byteArrayExtra != null) {
                        encodeToString = Base64.encodeToString(byteArrayExtra, 2);
                    }
                    str2 = intent.getStringExtra("key_scan_result_code_name");
                    i16 = Math.max(0, intent.getIntExtra("key_scan_result_code_version", 0));
                    w.d("MicroMsg.JsApiScanCode", String.format("KEY_SCAN_RESULT_CODE_TYPE %s", str2));
                } else {
                    str = "";
                    str2 = null;
                    i16 = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("charSet", "utf-8");
                hashMap.put("rawData", encodeToString);
                hashMap.put("result", str);
                hashMap.put("scanType", str2);
                hashMap.put("codeVersion", Integer.valueOf(i16));
                w.d("MicroMsg.JsApiScanCode", String.format("result: %s , scanType: %s, rawData: %s", str, str2, encodeToString));
                if (w0.c(encodeToString) && w0.c(str)) {
                    dVar.a(this.f121833c, a.this.makeReturnJson("fail:no result"));
                    return;
                } else {
                    dVar.a(this.f121833c, a.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    return;
                }
            }
            w.d("MicroMsg.JsApiScanCode", "RESULT_CODE_BACK_INNER_SCANNER");
            if (context != null) {
                boolean unused2 = a.f121830a = true;
                a.this.a(context, dVar, this.f121834d, this.f121833c);
            } else {
                w.b("MicroMsg.JsApiScanCode", "activity is unreachable, unable to start inner scanner");
            }
        }
    }

    public final void b(Context context, d dVar, Intent intent, int i3) {
        Intent intent2 = new Intent("com.tencent.wmpf.action.WMPF_SCAN_CODE");
        intent2.putExtra("key_only_from_camera", intent.getBooleanExtra("key_only_from_camera", false));
        intent2.putExtra("key_support_scan_code_type", intent.getStringArrayExtra("key_support_scan_code_type"));
        long currentTimeMillis = System.currentTimeMillis();
        intent2.putExtra("key_time_stamp", currentTimeMillis);
        intent2.putExtra("key_token", c.a(dVar.getAppId() + "_" + currentTimeMillis));
        a(context, intent2, dVar, i3);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (!com.tencent.luggage.wxa.y3.a.f145414a.a()) {
            dVar.a(i3, makeReturnJson("fail: not support"));
            return;
        }
        Context context = dVar.getContext();
        if (!(context instanceof Activity)) {
            dVar.a(i3, makeReturnJson("fail"));
            w.b("MicroMsg.JsApiScanCode", "activity is null, invoke fail!");
            return;
        }
        if (f121830a) {
            dVar.a(i3, makeReturnJson("cancel"));
            return;
        }
        Intent intent = new Intent();
        int i16 = 0;
        intent.putExtra("key_only_from_camera", jSONObject.optBoolean("onlyFromCamera", false));
        JSONArray optJSONArray = jSONObject.optJSONArray("scanType");
        HashSet hashSet = new HashSet();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                String optString = optJSONArray.optString(i17);
                if ("barCode".equals(optString) || CommonConstant.KEY_QR_CODE.equals(optString) || "datamatrix".equals(optString) || "pdf417".equals(optString)) {
                    hashSet.add(optString);
                }
            }
        } else {
            hashSet.add("barCode");
            hashSet.add(CommonConstant.KEY_QR_CODE);
            hashSet.add("datamatrix");
            hashSet.add("pdf417");
        }
        String[] strArr = new String[hashSet.size()];
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            strArr[i16] = (String) it.next();
            i16++;
        }
        intent.putExtra("key_support_scan_code_type", strArr);
        f121830a = true;
        intent.setAction("com.tencent.wmpf.action.WMPF_SCAN_CODE");
        if (a(context, intent)) {
            b(context, dVar, intent, i3);
            w.d("MicroMsg.JsApiScanCode", "scan code with thirdpart scanner");
        } else {
            a(context, dVar, intent, i3);
            w.d("MicroMsg.JsApiScanCode", "scan code with inner scanner");
        }
    }

    public final void a(Context context, d dVar, Intent intent, int i3) {
        Intent intent2 = new Intent(context, (Class<?>) BaseScanPage.class);
        intent2.putExtra("key_is_hide_right_btn", intent.getBooleanExtra("key_only_from_camera", false));
        intent2.putExtra("key_support_scan_code_type", a(intent.getStringArrayExtra("key_support_scan_code_type")));
        intent2.putExtra("key_show_scan_tips", false);
        a(context, intent2, dVar, i3);
    }

    public final void a(Context context, Intent intent, d dVar, int i3) {
        o21.a.a(context).a(context, intent, new C6029a(new WeakReference(context), new WeakReference(dVar), i3, intent));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x001a. Please report as an issue. */
    public final int[] a(String[] strArr) {
        int i3;
        if (strArr == null) {
            return new int[0];
        }
        int[] iArr = new int[strArr.length];
        int i16 = 0;
        for (String str : strArr) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -993060056:
                    if (str.equals("pdf417")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -952485970:
                    if (str.equals(CommonConstant.KEY_QR_CODE)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -334537568:
                    if (str.equals("barCode")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 2003869675:
                    if (str.equals("datamatrix")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    i3 = i16 + 1;
                    iArr[i16] = 4;
                    break;
                case 1:
                    i3 = i16 + 1;
                    iArr[i16] = 2;
                    break;
                case 2:
                    i3 = i16 + 1;
                    iArr[i16] = 1;
                    break;
                case 3:
                    i3 = i16 + 1;
                    iArr[i16] = 5;
                    break;
            }
            i16 = i3;
        }
        return iArr;
    }

    public final boolean a(Context context, Intent intent) {
        List list = (List) com.tencent.luggage.wxa.ia.a.a(context.getPackageManager(), b.a(65536, new com.tencent.luggage.wxa.ja.a()).a(intent).a(), "com/tencent/luggage/jsapi/scanner/JsApiScanCode", "checkThirdpartIntentAvailable", "(Landroid/content/Context;Landroid/content/Intent;)Z", "android/content/pm/PackageManager", "queryIntentActivities", "(Landroid/content/Intent;I)Ljava/util/List;");
        return (list == null || list.isEmpty()) ? false : true;
    }
}
