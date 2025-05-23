package com.tencent.luggage.wxa.ve;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143407a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143408b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f143409c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ve.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6844a implements ActivityCompat.OnRequestPermissionsResultCallback {
            public C6844a() {
            }

            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
                if (i3 != 48) {
                    return;
                }
                if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                    a aVar = a.this;
                    e.this.a(aVar.f143407a, aVar.f143408b, aVar.f143409c, true);
                } else {
                    a aVar2 = a.this;
                    aVar2.f143407a.a(aVar2.f143409c, e.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d));
                }
            }
        }

        public a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f143407a = dVar;
            this.f143408b = jSONObject;
            this.f143409c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.a(this.f143407a.getAppId(), new C6844a());
            Context context = this.f143407a.getContext();
            if (context != null && (context instanceof Activity)) {
                if (k.a((Activity) context, this.f143407a, QQPermissionConstants.Permission.READ_CONTACTS, 48, "", "")) {
                    q.a(this.f143407a.getAppId());
                    return;
                }
                return;
            }
            this.f143407a.a(this.f143409c, e.this.makeReturnJson("fail:internal error invalid android context"));
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            return replaceAll.substring(2);
        }
        return replaceAll;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a(dVar, jSONObject, i3, false);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, boolean z16) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiSearchContacts", "data is null, err");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        w.d("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        w.a("MicroMsg.JsApiSearchContacts", "data:%s", jSONObject);
        if (!z16 && !a(dVar, jSONObject, i3)) {
            w.d("MicroMsg.JsApiSearchContacts", "check permission");
            return;
        }
        String optString = jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
        if (optString.length() < 8) {
            w.b("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
            HashMap hashMap = new HashMap();
            hashMap.put("result", "");
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            return;
        }
        List<String[]> a16 = a(z.c());
        if (a16 == null) {
            w.b("MicroMsg.JsApiSearchContacts", "addressList is null, err");
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        if (!a16.isEmpty()) {
            for (String[] strArr : a16) {
                String b16 = b(strArr[2]);
                String b17 = w0.b(strArr[1], "");
                if (!w0.c(b16) && a(optString, b16)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, b16);
                        jSONObject2.put("name", b17);
                        jSONArray.mo162put(jSONObject2);
                    } catch (JSONException e16) {
                        w.a("MicroMsg.JsApiSearchContacts", e16, "", new Object[0]);
                    }
                }
            }
        }
        w.a("MicroMsg.JsApiSearchContacts", "resultArray:%s", jSONArray.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", jSONArray);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap2));
    }

    public final boolean a(String str, String str2) {
        if (!w0.c(str) && !w0.c(str2)) {
            int length = str.length();
            int length2 = str2.length();
            if (length < 8) {
                w.a("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", Integer.valueOf(str.length()));
                return false;
            }
            if (length > length2) {
                w.a("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", Integer.valueOf(length), Integer.valueOf(length2));
                return false;
            }
            int i3 = 0;
            for (int i16 = 0; i16 < length && (str.charAt(i16) == str2.charAt(i16) || (i3 = i3 + 1) <= 3); i16++) {
            }
            return i3 <= 3;
        }
        w.b("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r11.moveToFirst() != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        r2.add(new java.lang.String[]{r11.getString(r11.getColumnIndex("contact_id")), r11.getString(r11.getColumnIndex("display_name")), r11.getString(r11.getColumnIndex(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1)), r11.getString(r11.getColumnIndex("raw_contact_id"))});
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0093, code lost:
    
        if (r11.moveToNext() != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List a(Context context) {
        Cursor query;
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            query = ContactsMonitor.query(contentResolver, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
        } catch (Exception e16) {
            w.a("MicroMsg.JsApiSearchContacts", e16, "", new Object[0]);
            w.b("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", e16.getMessage());
            query = ContactsMonitor.query(contentResolver, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        }
        if (query == null) {
            w.b("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
            return linkedList;
        }
        try {
            if (query.getCount() > 0) {
            }
        } catch (Exception e17) {
            w.a("MicroMsg.JsApiSearchContacts", e17, "", new Object[0]);
            w.b("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", e17.getMessage());
        } finally {
            query.close();
        }
        return linkedList;
    }

    public final boolean a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (ContextCompat.checkSelfPermission(z.c(), QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
            return true;
        }
        dVar.a(new a(dVar, jSONObject, i3));
        return false;
    }
}
