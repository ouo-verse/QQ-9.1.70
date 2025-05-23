package dm3;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import ft3.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, String> f394278a = new HashMap<>();

    public a a(String str, int i3) {
        this.f394278a.put(str, String.valueOf(i3));
        return this;
    }

    public a b(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        this.f394278a.put(str, str2.replace(ContainerUtils.FIELD_DELIMITER, "_"));
        return this;
    }

    public void c() {
        c newReportTask = ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask();
        Set<Map.Entry<String, String>> entrySet = this.f394278a.entrySet();
        newReportTask.a(this.f394278a.get("module"));
        for (Map.Entry<String, String> entry : entrySet) {
            if (!TextUtils.equals(entry.getKey(), "module")) {
                newReportTask.addKeyValue(entry.getKey(), entry.getValue());
            }
        }
        newReportTask.send();
    }

    public a d(String str) {
        this.f394278a.put("action", str);
        return this;
    }

    public a e(String str) {
        this.f394278a.put("module", str);
        return this;
    }

    public String toString() {
        return "ReportTask{map=" + this.f394278a + '}';
    }
}
