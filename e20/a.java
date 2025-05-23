package e20;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public Boolean a(String str, String str2, Boolean bool) {
        return Boolean.valueOf(QzoneConfig.getInstance().getConfig(str, str2, bool.booleanValue()));
    }

    public Float b(String str, String str2, Float f16) {
        return Float.valueOf(QzoneConfig.getInstance().getConfig(str, str2, f16.floatValue()));
    }

    public Integer c(String str, String str2, Integer num) {
        return Integer.valueOf(QzoneConfig.getInstance().getConfig(str, str2, num.intValue()));
    }

    public Integer d(String str, String str2, Integer num, boolean z16) {
        return Integer.valueOf(QzoneConfig.getInstance().getConfig(str, str2, num.intValue(), z16));
    }

    public Long e(String str, String str2, Long l3) {
        return Long.valueOf(QzoneConfig.getInstance().getConfig(str, str2, l3.longValue()));
    }

    public Long f(String str, String str2, Long l3, boolean z16) {
        return Long.valueOf(QzoneConfig.getInstance().getConfig(str, str2, l3.longValue(), z16));
    }

    public String g(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    public void h(String str, String str2, String str3) {
        QzoneConfig.getInstance().updateOneConfig(str, str2, str3);
    }
}
