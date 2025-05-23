package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes.dex */
public class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Location f29518a;

    static {
        new Bundle();
        f29518a = new Location("Empty");
    }

    public static String a(int i3, int i16, int i17) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        boolean b16 = q.b().b("https");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("http");
        if (b16) {
            str = ReportConstant.COSTREPORT_PREFIX;
        } else {
            str = "";
        }
        sb6.append(str);
        sb6.append("://lbs.map.qq.com/loc");
        sb5.append(sb6.toString());
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("c=");
        sb5.append(i3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("mars=");
        sb5.append(i16);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("obs=");
        sb5.append(i17);
        return sb5.toString();
    }
}
