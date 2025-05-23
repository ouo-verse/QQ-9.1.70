package com.tenpay;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tenpay.api.QFuncApi;
import java.io.File;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QwLog {
    private static final String CFT_TAG = "CFT-sdk";
    private static final int LV_D = 0;
    private static final int LV_E = 2;
    private static final int LV_I = 1;
    private static final String MARK_RETURN = "CFT-<< ";
    private static final String MARK_START = "CFT->> ";
    private static final int QLOG_LEVEL = 1;
    private static String format = "(%s:%s)";
    private static boolean ischeked = false;
    private static boolean isdevelop = false;

    public static void d(String str) {
        formatLog(str, 0);
    }

    public static void e(String str) {
        formatLog(str, 2);
    }

    private static void formatLog(String str, int i3) {
        if (QFuncApi.isColorLevel() || getIsDevelop()) {
            String finalLog = getFinalLog(str);
            if (i3 != 0) {
                if (i3 != 2) {
                    QFuncApi.QLogi(CFT_TAG, 1, finalLog);
                    return;
                } else {
                    QFuncApi.QLoge(CFT_TAG, 1, finalLog);
                    return;
                }
            }
            QFuncApi.QLogd(CFT_TAG, 1, finalLog);
        }
    }

    private static String getFinalLog(String str) {
        StackTraceElement stackElement = getStackElement();
        if (stackElement == null) {
            return str;
        }
        return String.format("{%d}%s[%s]%s", Long.valueOf(Thread.currentThread().getId()), String.format(format, stackElement.getFileName(), Integer.valueOf(stackElement.getLineNumber())), stackElement.getMethodName(), str);
    }

    public static boolean getIsDevelop() {
        if (ischeked) {
            return isdevelop;
        }
        ischeked = true;
        boolean exists = new File("/sdcard/debug_local").exists();
        isdevelop = exists;
        return exists;
    }

    private static StackTraceElement getStackElement() {
        return Thread.currentThread().getStackTrace()[6];
    }

    public static String getStackInfo(Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            stringBuffer.append(stackTraceElement);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static void i(String str) {
        formatLog(str, 1);
    }

    public static void ia(Object[] objArr) {
        if (getIsDevelop() && objArr == null) {
            StringBuffer stringBuffer = new StringBuffer("\n");
            stringBuffer.append("========================\n");
            for (int i3 = 0; i3 < objArr.length; i3++) {
                stringBuffer.append(i3 + " => " + objArr[i3] + "\n");
            }
            stringBuffer.append("========================");
            i(stringBuffer.toString());
        }
    }

    public static <K> String list2str(List<K> list) {
        if (!QFuncApi.isColorLevel() || list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i3 = 0; i3 < list.size(); i3++) {
            stringBuffer.append(list.get(i3) + APLogFileUtil.SEPARATOR_LOG);
        }
        return stringBuffer.toString();
    }

    public static <K, V> String map2str(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + ProgressTracer.SEPARATOR + entry.getValue() + ", ");
        }
        return stringBuffer.toString();
    }
}
