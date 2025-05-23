package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bq extends bs {
    public bq(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static bq n(Context context, String str, int i3) {
        jz4.c.w("delete  messages when db size is too bigger");
        String c16 = bw.b(context).c(str);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("rowDataId in (select ");
        sb5.append("rowDataId from " + c16);
        sb5.append(" order by createTimeStamp asc");
        sb5.append(" limit ?)");
        return new bq(str, sb5.toString(), new String[]{String.valueOf(i3)}, "a job build to delete history message");
    }

    private void o(long j3) {
        String[] strArr = this.E;
        if (strArr != null && strArr.length > 0) {
            strArr[0] = String.valueOf(j3);
        }
    }

    @Override // com.xiaomi.push.bw.a
    public void j(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a16 = av.a(g());
            long j3 = aq.f388204b;
            if (a16 > j3) {
                long j16 = (long) ((((a16 - j3) * 1.2d) / j3) * longValue);
                o(j16);
                bn.b(context).i("begin delete " + j16 + "noUpload messages , because db size is " + a16 + "B");
                super.j(context, obj);
                return;
            }
            jz4.c.w("db size is suitable");
        }
    }
}
