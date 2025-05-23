package com.tencent.qqmini.miniapp.util.logmonitor;

import androidx.annotation.Nullable;
import com.tencent.qqmini.miniapp.util.logmonitor.LogLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LogBeanUtil {
    private static boolean detected = false;
    private static LogBean oldLogBean;

    @Nullable
    public static LogBean createBeanFromLine(String str) {
        LogBean logBean = new LogBean();
        int indexOf = str.indexOf("/");
        int indexOf2 = str.indexOf("):");
        if (indexOf2 != -1 && indexOf != -1) {
            logBean.tag = str.substring(indexOf + 1, indexOf2 + 1);
            logBean.f346323msg = str.substring(indexOf2 + 2);
            logBean.lev = str.substring(indexOf - 1, indexOf);
            logBean.time = str.substring(6, indexOf - 2);
            return logBean;
        }
        return null;
    }

    public static void loadLogBeanList(String str, String str2, final String str3, final ILoadLogListener iLoadLogListener) {
        final ArrayList arrayList = new ArrayList();
        LogLoader.load(LogCatCmd.getInstance().options(LogCmdOptions.DUMP).withTime().recentLines(1000).filter(str, str2).commit(), new LogLoader.LoadHandler() { // from class: com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil.1
            @Override // com.tencent.qqmini.miniapp.util.logmonitor.LogLoader.LoadHandler
            public void handLine(String str4) {
                LogBean createBeanFromLine = LogBeanUtil.createBeanFromLine(str4);
                if (createBeanFromLine != null) {
                    String str5 = createBeanFromLine.f346323msg;
                    String str6 = str3;
                    if (str6 == null) {
                        LogBeanUtil.recordLogLine(createBeanFromLine, str5, arrayList);
                    } else if (str5.contains(str6)) {
                        LogBeanUtil.recordLogLine(createBeanFromLine, str5, arrayList);
                    }
                }
            }

            @Override // com.tencent.qqmini.miniapp.util.logmonitor.LogLoader.LoadHandler
            public void onComplete() {
                LogBean unused = LogBeanUtil.oldLogBean = null;
                iLoadLogListener.onLoaded(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordLogLine(LogBean logBean, String str, ArrayList<LogBean> arrayList) {
        if (!str.contains("FATAL EXCEPTION") && !str.startsWith(" \t... ") && !str.startsWith(" Process: ")) {
            if (oldLogBean != null && str.startsWith(" \tat ")) {
                StringBuilder sb5 = new StringBuilder();
                LogBean logBean2 = oldLogBean;
                sb5.append(logBean2.f346323msg);
                sb5.append("\n\t\t");
                sb5.append(str);
                logBean2.f346323msg = sb5.toString();
                return;
            }
            oldLogBean = logBean;
            arrayList.add(logBean);
        }
    }
}
