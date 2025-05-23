package com.tencent.hippy.qq.api.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyCrashHandler;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyCrashHandlerImpl implements IHippyCrashHandler {
    private static HashMap<String, String> getReportCrashData() {
        HashMap<String, String> hippyStatus = HippyQQEngine.getHippyStatus();
        String str = hippyStatus.get(HippyQQEngine.HIPPY_VISIBLE_LIST_INFO);
        String str2 = hippyStatus.get(HippyQQEngine.HIPPY_PREDRAW_LIST_INFO);
        String str3 = hippyStatus.get(HippyQQEngine.HIPPY_PRELOAD_LIST_INFO);
        String str4 = hippyStatus.get(HippyQQEngine.HIPPY_OTHER_LIST_INFO);
        String str5 = hippyStatus.get(HippyQQEngine.HIPPY_TOP_SHOWING_NAME);
        String str6 = hippyStatus.get(HippyQQEngine.HIPPY_TOP_SHOWING_VERSION);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", str5);
        hashMap.put("page_ver", str6);
        hashMap.put("visibleList", str);
        hashMap.put("predrawList", str2);
        hashMap.put("preloadList", str3);
        hashMap.put("otherList", str4);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportCrash$0(HashMap hashMap) {
        HippyReporter.getInstance();
        HippyReporter.reportToDengTa(HippyReporter.EventCode.HIPPY_CRASH, hashMap, true);
    }

    @Override // com.tencent.hippy.qq.api.IHippyCrashHandler
    public String getHippyStatus() {
        HashMap<String, String> hippyStatus = HippyQQEngine.getHippyStatus();
        String str = hippyStatus.get(HippyQQEngine.HIPPY_VISIBLE_LIST_INFO);
        String str2 = hippyStatus.get(HippyQQEngine.HIPPY_PREDRAW_LIST_INFO);
        String str3 = hippyStatus.get(HippyQQEngine.HIPPY_PRELOAD_LIST_INFO);
        String str4 = hippyStatus.get(HippyQQEngine.HIPPY_OTHER_LIST_INFO);
        String str5 = hippyStatus.get(HippyQQEngine.HIPPY_TOP_SHOWING_NAME);
        String str6 = hippyStatus.get(HippyQQEngine.HIPPY_TOP_SHOWING_VERSION);
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str5)) {
            sb5.append("topShow:");
            sb5.append(str5);
            sb5.append(':');
            sb5.append(str6);
            sb5.append(',');
        }
        if (str != null) {
            sb5.append("visible:");
            sb5.append(str);
            sb5.append(',');
        }
        if (str2 != null) {
            sb5.append("predraw:");
            sb5.append(str2);
            sb5.append(',');
        }
        if (str3 != null) {
            sb5.append("preload:");
            sb5.append(str3);
            sb5.append(',');
        }
        if (str4 != null) {
            sb5.append("other:");
            sb5.append(str4);
        }
        if (sb5.length() > 0 && sb5.lastIndexOf(",") == sb5.length() - 1) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    @Override // com.tencent.hippy.qq.api.IHippyCrashHandler
    public boolean isSaveHippyStatus() {
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1 || i3 == 7) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippyCrashHandler
    public void reportCrash(String str, String str2) {
        final HashMap<String, String> reportCrashData = getReportCrashData();
        reportCrashData.put("crashType", str);
        reportCrashData.put("crashStack", str2);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                HippyCrashHandlerImpl.lambda$reportCrash$0(reportCrashData);
            }
        }, 16, null, true);
    }
}
