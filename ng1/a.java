package ng1;

import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    public static String a(IGProClientPresenceInfo iGProClientPresenceInfo) {
        if (iGProClientPresenceInfo == null) {
            return "";
        }
        return e(iGProClientPresenceInfo) + b(iGProClientPresenceInfo) + d(iGProClientPresenceInfo);
    }

    private static String b(IGProClientPresenceInfo iGProClientPresenceInfo) {
        if (!TextUtils.isEmpty(iGProClientPresenceInfo.getDetails())) {
            return APLogFileUtil.SEPARATOR_LOG + iGProClientPresenceInfo.getDetails() + c(iGProClientPresenceInfo);
        }
        return "";
    }

    private static String c(IGProClientPresenceInfo iGProClientPresenceInfo) {
        if (iGProClientPresenceInfo.getPartySize() != 0 && iGProClientPresenceInfo.getPartyMax() != 0) {
            return "(" + iGProClientPresenceInfo.getPartySize() + "/" + iGProClientPresenceInfo.getPartyMax() + ")";
        }
        return "";
    }

    private static String d(IGProClientPresenceInfo iGProClientPresenceInfo) {
        if (!TextUtils.isEmpty(iGProClientPresenceInfo.getRole())) {
            return APLogFileUtil.SEPARATOR_LOG + iGProClientPresenceInfo.getRole();
        }
        return "";
    }

    private static String e(IGProClientPresenceInfo iGProClientPresenceInfo) {
        if (!TextUtils.isEmpty(iGProClientPresenceInfo.getState()) && iGProClientPresenceInfo.getStartTimeStamp() != 0) {
            return iGProClientPresenceInfo.getState() + (((System.currentTimeMillis() / 1000) - iGProClientPresenceInfo.getStartTimeStamp()) / 60) + "\u5206\u949f";
        }
        return iGProClientPresenceInfo.getState();
    }
}
