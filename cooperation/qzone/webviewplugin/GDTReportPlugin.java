package cooperation.qzone.webviewplugin;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* loaded from: classes38.dex */
public class GDTReportPlugin extends WebViewPlugin {
    static final int BEFORE_LOADING = 0;
    static final int BEFORE_LOAD_CLICK_CGI = 0;
    static final int FINISH_LOAD_CLICK_CGI = 2;
    public static final String GDT_CLICK_CGI_HOST = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com";
    static final int LOADING = 1;
    static final int LOADING_CLICK_CGI = 1;
    static final int LOAD_FAIL = 3;
    static final int LOAD_SUCCESS = 2;
    public static final String PLUGIN_NAMESPACE = "gdtReportPlugin";
    static final int REPORT_FINISH = 4;
    private Map<Integer, String> feedDataCookie;
    private long loadFinishTime;
    private long loadStartTime;
    private int state = 0;
    private int loadClickCgiState = 0;

    /* loaded from: classes38.dex */
    private static class FailType {
        static final int FAIL_LOADING_BACK = 94;
        static final int FAIL_LOADING_PAUSE = 95;
        static final int FAIL_LOAD_ERROR = 1;

        FailType() {
        }
    }

    private long getLoadTime() {
        return SystemClock.elapsedRealtime() - this.loadStartTime;
    }

    private long getStayTime() {
        return SystemClock.elapsedRealtime() - this.loadFinishTime;
    }

    public static boolean isClickCgiUrlForTool(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            for (String str2 : GDT_CLICK_CGI_HOST.split("#")) {
                if (host.equals(str2)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void reportCgi302Fail(int i3, Map<String, Object> map) {
        Log.i("gdtReportPlugin", "173\t" + getLoadTime());
        RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 1, getLoadTime(), (map != null && map.containsKey("errorCode") && (map.get("errorCode") instanceof Integer)) ? Math.abs(((Integer) map.get("errorCode")).intValue()) : 0);
    }

    private void reportCgi302Success() {
        Log.i("gdtReportPlugin", "172\t" + getLoadTime());
        RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2014, 0, getLoadTime(), 0L);
    }

    private void reportLoadFailTime(int i3, Map<String, Object> map) {
        this.loadFinishTime = SystemClock.elapsedRealtime();
        RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, i3, getLoadTime(), (map != null && map.containsKey("errorCode") && (map.get("errorCode") instanceof Integer)) ? Math.abs(((Integer) map.get("errorCode")).intValue()) : 0);
        Log.i("gdtReportPlugin", (i3 + 120) + "\t" + getLoadTime());
    }

    private void reportLoadSuccessTime() {
        this.loadFinishTime = SystemClock.elapsedRealtime();
        RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2000, 0, getLoadTime(), 0L);
        Log.i("gdtReportPlugin", "120\t" + getLoadTime());
    }

    private void reportStayTime() {
        Log.i("gdtReportPlugin", "129\t" + getLoadTime());
        RemoteHandleManager.getInstance().getSender().gdtAdvReportFromWebViewPlug(this.feedDataCookie, 2005, 0, getStayTime(), 0L);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "gdtReportPlugin";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        if ("gdtReportPlugin".equals(str)) {
            return 2L;
        }
        return super.getWebViewEventByNameSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (this.mRuntime.a().getIntent().getBooleanExtra("needGdtLandingPageReport", false)) {
            int i3 = this.state;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            if (j3 == 8589934593L) {
                                this.state = 4;
                                reportStayTime();
                                this.loadStartTime = SystemClock.elapsedRealtime();
                            } else if (j3 == 8589934597L) {
                                this.state = 4;
                                reportStayTime();
                            }
                        }
                    } else if (j3 == 8589934597L) {
                        reportStayTime();
                        this.state = 4;
                    }
                } else if (j3 == 8589934594L) {
                    this.state = 2;
                    reportLoadSuccessTime();
                } else if (j3 == 8589934595L) {
                    this.state = 3;
                    reportLoadFailTime(1, map);
                } else if (j3 == 8589934601L) {
                    this.state = 4;
                    reportLoadFailTime(94, map);
                    reportStayTime();
                } else if (j3 == 8589934597L) {
                    this.state = 4;
                    reportLoadFailTime(95, map);
                    reportStayTime();
                }
            } else if (j3 == 8589934593L) {
                if (isClickCgiUrlForTool(str) && this.loadClickCgiState == 0) {
                    this.loadClickCgiState = 1;
                }
                List list = (List) this.mRuntime.a().getIntent().getSerializableExtra("FeedDataCookie");
                if (list != null && list.size() == 1) {
                    this.feedDataCookie = (Map) list.get(0);
                }
                this.loadStartTime = SystemClock.elapsedRealtime();
                this.state = 1;
            }
            if (this.loadClickCgiState == 1) {
                if (j3 == 8589934593L && this.state == 1 && !isClickCgiUrlForTool(str)) {
                    reportCgi302Success();
                    this.loadClickCgiState = 2;
                } else if (isClickCgiUrlForTool(str) && (j3 == 8589934598L || j3 == 8589934595L)) {
                    this.loadClickCgiState = 2;
                    reportCgi302Fail(1, map);
                }
            }
            QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
            reportInfo.actionType = String.valueOf(478);
            if (j3 == 8589934599L) {
                reportInfo.subactionType = String.valueOf(2);
                QZoneClickReport.report(this.mRuntime.b().getAccount(), reportInfo, true);
            }
        }
        return false;
    }
}
