package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.util.Log;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfos {
    private static final String TAG = "LpReport.LpReportInfos";
    private Map<Integer, REPORT_INFO> infos = new ConcurrentHashMap();

    private void checkParams(int i3, Map<String, String> map, LpReportInfo lpReportInfo) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            if (key == null || value == null) {
                it.remove();
                QZLog.e(TAG, 1, "lpReport error, type=", Integer.valueOf(i3), ", kye:", key, ", value:", value, ", lpReportInfo:", lpReportInfo.getSimpleInfo());
                QZLog.e(TAG, Log.getStackTraceString(new Throwable()));
            }
        }
    }

    public void addInfo(int i3, LpReportInfo lpReportInfo) {
        Map<String, String> map;
        if (lpReportInfo != null && (map = lpReportInfo.toMap()) != null && map.size() != 0) {
            checkParams(i3, map, lpReportInfo);
            if (this.infos.containsKey(Integer.valueOf(i3))) {
                this.infos.get(Integer.valueOf(i3)).info.add(map);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(map);
            this.infos.put(Integer.valueOf(i3), new REPORT_INFO(i3, arrayList));
        }
    }

    public void clear() {
        this.infos.clear();
    }

    public ArrayList<REPORT_INFO> getInfos() {
        return new ArrayList<>(this.infos.values());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        ArrayList<Map<String, String>> arrayList;
        int i3 = 0;
        for (REPORT_INFO report_info : this.infos.values()) {
            if (report_info != null && (arrayList = report_info.info) != null) {
                i3 += arrayList.size();
            }
        }
        return i3;
    }
}
