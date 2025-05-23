package cooperation.qzone.statistic.access;

import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.statistic.access.concept.Assembler;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class HttpAssembler extends Assembler {
    protected Statistic publicField = null;

    public static String utf8encode(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return URLEncoder.encode(obj.toString(), "utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return obj.toString();
        }
    }

    @Override // cooperation.qzone.statistic.access.concept.Assembler
    public String assemble(List<Statistic> list) {
        int size = list.size();
        String format = format((String) null, this.publicField);
        if (size == 0) {
            return format;
        }
        if (size == 1) {
            return format(format, list.get(0));
        }
        return format(format, list);
    }

    public String format(String str, Statistic statistic) {
        Key[] keys = statistic.getKeys();
        Object[] values = statistic.getValues();
        StringBuilder sb5 = new StringBuilder();
        if (str != null) {
            sb5.append(str);
        }
        for (int i3 = 0; i3 < keys.length; i3++) {
            Object obj = values[i3];
            if (obj != null) {
                if (!obj.equals("")) {
                    sb5.append(sb5.length() != 0 ? ContainerUtils.FIELD_DELIMITER : "");
                    sb5.append(keys[i3]);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(utf8encode(values[i3]));
                }
            }
        }
        return sb5.toString();
    }

    public Statistic getPublicField() {
        return this.publicField;
    }

    public void setPublicField(Statistic statistic) {
        this.publicField = statistic;
    }

    public String format(String str, List<Statistic> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            if (str != null) {
                try {
                    sb5.append(str);
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                } catch (OutOfMemoryError e16) {
                    QZLog.e("HttpAssembler", "", e16);
                }
            }
            Key[] keys = list.get(0).getKeys();
            sb5.append("key=");
            for (int i3 = 0; i3 < keys.length; i3++) {
                String name = keys[i3].getName();
                if (i3 != 0) {
                    sb5.append(",");
                }
                sb5.append(name);
            }
            for (int i16 = 0; i16 < keys.length; i16++) {
                int i17 = 0;
                while (i17 < list.size()) {
                    Statistic statistic = list.get(i17);
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    i17++;
                    sb5.append(i17);
                    sb5.append("_");
                    sb5.append(i16 + 1);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(utf8encode(statistic.getValue(i16)));
                }
            }
            sb5.append("&count=");
            sb5.append(list.size());
            return sb5.toString();
        }
        return null;
    }
}
