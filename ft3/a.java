package ft3;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements b {
    @Override // ft3.b
    public void a(String str, Map<String, String> map, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            QQBeaconReport.reportWithAppKey("0DOU0MNDZE4ME6PH", "", str, true, map, z16);
        }
    }
}
