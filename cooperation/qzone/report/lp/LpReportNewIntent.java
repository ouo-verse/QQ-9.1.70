package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportNewIntent extends NewIntent {
    public Map<String, String> extra_info;
    public ArrayList<Map<String, String>> info;
    public ArrayList<REPORT_INFO> multi_info;
    public long type;

    public LpReportNewIntent(Context context, Class<? extends Servlet> cls) {
        super(context, cls);
    }
}
