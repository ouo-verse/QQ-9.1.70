package com.vivo.datashare.sport.query;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c implements xy4.b<Object> {

    /* renamed from: a, reason: collision with root package name */
    private Context f387546a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f387548c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f387549d = false;

    /* renamed from: b, reason: collision with root package name */
    private SimpleDateFormat f387547b = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    public c(Context context) {
        this.f387546a = context;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str.trim())) {
            return str.trim();
        }
        if ("null".equals(str.trim())) {
            return null;
        }
        return str;
    }

    private String d(a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aVar.toString());
            String c16 = c(jSONObject.getString("appId"));
            int i3 = jSONObject.getInt("queryType");
            jSONObject.put("appId", c16);
            jSONObject.put("queryType", i3);
            return jSONObject.toString();
        } catch (JSONException e16) {
            Log.e("StepQueryManager", "queryStepBeanToJson JSONException : ".concat(String.valueOf(e16)));
            return null;
        }
    }

    @Override // xy4.b
    public int a() {
        return e(null);
    }

    @Override // xy4.b
    public boolean b() {
        Bundle bundle;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f387548c = true;
            this.f387549d = false;
        }
        if (this.f387548c) {
            return this.f387549d;
        }
        ApplicationInfo applicationInfo = this.f387546a.getPackageManager().getApplicationInfo("com.vivo.assistant", 128);
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            boolean z16 = bundle.getBoolean("vivo.assistant.support.step.data.share");
            this.f387548c = true;
            this.f387549d = z16;
            return z16;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(String str) {
        ContentProviderClient contentProviderClient;
        if (!b()) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f387546a.getPackageName();
        }
        a aVar = new a();
        aVar.f449121b = str;
        aVar.f449120a = 0;
        String d16 = d(aVar);
        if (TextUtils.isEmpty(d16)) {
            return -1;
        }
        ContentProviderClient contentProviderClient2 = aVar;
        if (wy4.a.a()) {
            Log.d("StepQueryManager", "queryTodayStep ,sql:".concat(String.valueOf(d16)));
            contentProviderClient2 = "StepQueryManager";
        }
        Cursor cursor = null;
        try {
            try {
                contentProviderClient = this.f387546a.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.vivo.assistant.step.provider"));
            } catch (DeadObjectException e16) {
                e = e16;
                contentProviderClient = null;
            } catch (Exception e17) {
                e = e17;
                contentProviderClient = null;
            } catch (Throwable th5) {
                th = th5;
                contentProviderClient2 = 0;
                if (0 != 0) {
                }
                if (contentProviderClient2 != 0) {
                }
                throw th;
            }
            try {
                cursor = contentProviderClient.query(Uri.parse("content://com.vivo.assistant.step.provider"), null, d16, null, null);
            } catch (DeadObjectException e18) {
                e = e18;
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClient == null) {
                    return -8;
                }
                try {
                    contentProviderClient.release();
                } catch (Exception unused) {
                    return -8;
                }
            } catch (Exception e19) {
                e = e19;
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClient == null) {
                    return -8;
                }
                contentProviderClient.release();
            }
            if (cursor != null && cursor.getCount() != 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("step_count");
                int i3 = cursor.getInt(cursor.getColumnIndex("ret_code"));
                int i16 = cursor.getInt(columnIndex);
                cursor.close();
                if (i3 != 0) {
                    try {
                        contentProviderClient.release();
                    } catch (Exception unused2) {
                    }
                    return i3;
                }
                try {
                    contentProviderClient.release();
                } catch (Exception unused3) {
                }
                return i16;
            }
            if (cursor != null) {
                cursor.close();
            }
            contentProviderClient.release();
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                cursor.close();
            }
            if (contentProviderClient2 != 0) {
                try {
                    contentProviderClient2.release();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }
}
