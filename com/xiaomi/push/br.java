package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.bw;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class br extends bw.b<Long> {
    private long L;
    private String M;

    public br(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i3, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i3);
        this.L = 0L;
        this.M = str6;
    }

    public static br o(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new br(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    @Override // com.xiaomi.push.bw.a
    public Object f() {
        return Long.valueOf(this.L);
    }

    @Override // com.xiaomi.push.bw.b
    public void n(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.L = list.get(0).longValue();
        }
    }

    @Override // com.xiaomi.push.bw.b
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long m(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }
}
