package j5;

import cooperation.qzone.LbsDataV2;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f409269a;

    /* renamed from: b, reason: collision with root package name */
    public String f409270b;

    /* renamed from: c, reason: collision with root package name */
    public LbsDataV2.PoiList f409271c;

    public static String a(long j3) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        return simpleDateFormat.format(date);
    }
}
