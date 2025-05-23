package com.tencent.mobileqq.data;

import com.tencent.avcore.util.ArrayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ap;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ConversationInfoErrorReporter {

    @notColumn
    static boolean REPORT_UINTYPE_ERROR = false;
    static HashMap<String, Boolean> mReportUnreadError = null;

    @notColumn
    public static boolean publicaccountTypeErrorReported = false;

    static {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        mReportUnreadError = hashMap;
        Boolean bool = Boolean.FALSE;
        hashMap.put(ConversationInfo.UNREAD_ERROR, bool);
        mReportUnreadError.put(ConversationInfo.SUB_ACCOUNT_TROOP_UNREAD_ERROR, bool);
        mReportUnreadError.put(ConversationInfo.UNREAD_GIFT_COUNT_ERROR, bool);
        mReportUnreadError.put(ConversationInfo.UNREAD_MARK_ERROR, bool);
        mReportUnreadError.put(ConversationInfo.UNREAD_RED_PACK_ERROR, bool);
    }

    public static boolean reportPublicaccoutTypeError(String str, int i3) {
        BaseApplicationImpl application;
        if (i3 == 1008 && !publicaccountTypeErrorReported && (application = BaseApplicationImpl.getApplication()) != null && application.getRuntime() != null && com.tencent.qqnt.contact.friends.b.f355778a.c(str, "ConversationInfoErrorReporter")) {
            publicaccountTypeErrorReported = true;
            return true;
        }
        return false;
    }

    public static void reportTypeError(int i3, String str) {
        int[] b16 = ap.b();
        if (i3 == 6 || !ArrayUtils.contains(b16, i3)) {
            String str2 = " UIN_TYPE ERROR " + str;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            if (!REPORT_UINTYPE_ERROR) {
                com.tencent.qqperf.monitor.crash.catchedexception.a.c(illegalStateException, str2);
                REPORT_UINTYPE_ERROR = true;
            }
            QLog.e("ConversationInfo_UinType", 1, str, illegalStateException);
        }
    }
}
