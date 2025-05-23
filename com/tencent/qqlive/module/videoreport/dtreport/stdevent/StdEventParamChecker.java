package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class StdEventParamChecker {
    private static final Map<StdEventCode, Class<?>> CODE_BUILDER_MAP;
    private static final String TAG = "StdEventParamChecker";

    static {
        HashMap hashMap = new HashMap();
        CODE_BUILDER_MAP = hashMap;
        hashMap.put(StdEventCode.VIDEO_START, VideoStartEventParamsBuilder.class);
        hashMap.put(StdEventCode.VIDEO_END, VideoEndEventParamsBuilder.class);
    }

    public static boolean checkParamBuilder(StdEventCode stdEventCode, IEventParamsBuilder iEventParamsBuilder) {
        String str;
        Class<?> cls = CODE_BUILDER_MAP.get(stdEventCode);
        if (cls == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6821\u9a8c\u9519\u8bef, \u4e8b\u4ef6 [");
            if (stdEventCode == null) {
                str = null;
            } else {
                str = stdEventCode.codeName;
            }
            sb5.append(str);
            sb5.append("] \u4e0d\u652f\u6301!");
            handleError(sb5.toString());
            return false;
        }
        if (!cls.isInstance(iEventParamsBuilder)) {
            handleError("\u6821\u9a8c\u9519\u8bef, \u4e8b\u4ef6 [" + stdEventCode.codeName + "] \u9700\u8981\u4f7f\u7528 " + cls.getSimpleName());
            return false;
        }
        if (iEventParamsBuilder instanceof BaseEventParamsBuilder) {
            BaseEventParamsBuilder.CheckResult checkValidity = ((BaseEventParamsBuilder) iEventParamsBuilder).checkValidity();
            if (!checkValidity.success) {
                handleError("\u6821\u9a8c\u9519\u8bef, \u4e8b\u4ef6 [" + stdEventCode.codeName + "] \u53c2\u6570\u6709\u8bef\uff1a\n" + checkValidity.errMsg);
                return false;
            }
            return true;
        }
        return true;
    }

    private static void handleError(String str) {
        Log.e(TAG, str);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Toast.makeText(ReportUtils.getContext(), str, 1).show();
        }
    }
}
