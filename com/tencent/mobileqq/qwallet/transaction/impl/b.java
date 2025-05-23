package com.tencent.mobileqq.qwallet.transaction.impl;

import android.database.Cursor;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f279235a;

    /* renamed from: b, reason: collision with root package name */
    public long f279236b;

    /* renamed from: c, reason: collision with root package name */
    public int f279237c;

    /* renamed from: d, reason: collision with root package name */
    public String f279238d;

    /* renamed from: e, reason: collision with root package name */
    public long f279239e;

    /* renamed from: f, reason: collision with root package name */
    public JSONObject f279240f;

    /* renamed from: g, reason: collision with root package name */
    protected String f279241g;

    public b(int i3, long j3, int i16, String str, long j16, String str2) {
        this.f279235a = i3;
        this.f279236b = j3;
        this.f279237c = i16;
        this.f279238d = str;
        this.f279239e = j16;
        this.f279241g = str2;
    }

    public static b a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("no");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("uin");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("btype");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("bid");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(AlbumCacheData.CREATE_TIME);
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("ext");
        int i3 = cursor.getInt(columnIndexOrThrow);
        long j3 = cursor.getLong(columnIndexOrThrow2);
        int i16 = cursor.getInt(columnIndexOrThrow3);
        String string = cursor.getString(columnIndexOrThrow4);
        long j16 = cursor.getLong(columnIndexOrThrow5);
        String string2 = cursor.getString(columnIndexOrThrow6);
        if (QLog.isColorLevel()) {
            QLog.i("NotifyMsgRecord", 2, "fromCursorOrThrow bId:" + string + " extJson:" + string2);
        }
        return new b(i3, j3, i16, string, j16, string2);
    }

    public int b(String str, int i3) {
        c(false);
        JSONObject jSONObject = this.f279240f;
        if (jSONObject == null) {
            return i3;
        }
        return jSONObject.optInt(str, i3);
    }

    public void c(boolean z16) {
        if (this.f279240f != null) {
            return;
        }
        String str = this.f279241g;
        if (str != null && str.length() > 0) {
            try {
                this.f279240f = new JSONObject(this.f279241g);
                return;
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NotifyMsgRecord", 1, "error msg in qqpay-impl module: ", e16);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("NotifyMsgRecord", 1, "error msg in qqpay-impl module: ", th5);
                return;
            }
        }
        if (z16 && this.f279240f == null) {
            this.f279240f = new JSONObject();
        }
    }

    public void d(String str, int i3) {
        c(true);
        try {
            this.f279240f.put(str, i3);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("NotifyMsgRecord", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
    }

    public void e(String str, String str2) {
        c(true);
        try {
            this.f279240f.put(str, str2);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("NotifyMsgRecord", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
    }
}
