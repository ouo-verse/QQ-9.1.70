package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.bw;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bt extends bw.e {
    private String E;

    public bt(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.E = str2;
    }

    public static bt m(Context context, String str, gj gjVar) {
        byte[] e16 = fv.e(gjVar);
        if (e16 != null && e16.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 0);
            contentValues.put("messageId", "");
            contentValues.put("messageItemId", gjVar.d());
            contentValues.put("messageItem", e16);
            contentValues.put("appId", bn.b(context).l());
            contentValues.put("packageName", bn.b(context).d());
            contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("uploadTimestamp", (Integer) 0);
            return new bt(str, contentValues, "a job build to insert message to db");
        }
        return null;
    }
}
