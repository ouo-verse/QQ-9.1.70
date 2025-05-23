package com.tencent.mobileqq.reminder.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface QQConstants {
    public static final IPatchRedirector $redirector_ = null;
    public static final int ACSMSG_TYPE_NOTIFY_MULTIPLE = 1;
    public static final int ACSMSG_TYPE_NOTIFY_ONCE = 0;
    public static final int ACSMSG_TYPE_NOTIFY_TIME_MULTIPLE = 2;
    public static final long ACTIVATE_FRIENDS_LONG_VALUE = 9973;
    public static final String ACTIVATE_FRIENDS_UIN;
    public static final int CMD_ID_ACK_MSGS = 2004;
    public static final int CMD_ID_BATCH_SUB = 2007;
    public static final int CMD_ID_DEL_REMINDER_MSG = 2001;
    public static final int CMD_ID_GET_MSGS = 2005;
    public static final int CMD_ID_GET_REMINDER_LIST = 2000;
    public static final int CMD_ID_SUBSCRIBE_REMINDER_MSG = 2002;
    public static final int DAY_OF_TIME = 86400000;
    public static final int DELETE_SOURCE_FROM_ALL_LIST = 2;
    public static final int DELETE_SOURCE_FROM_TAB = 1;
    public static final int JUMP_TYPE_DONWLOAD_APP = 1;
    public static final int JUMP_TYPE_H5 = 0;
    public static final int JUMP_TYPE_MINI_APP = 4;
    public static final String MEMORIAL_MSG_ID = "97f2e3f9e7a46a25a4e986296e5ab4b1";
    public static final String MEMORIAL_MSG_ID_FORMAL = "4d570810d990d6bc0b723f61f2531e9c";
    public static final String PREF_ACTIVATE_FRIENDS = "pref_act_frd";
    public static final String QQ_CLCK = "qq_clck";
    public static final String QQ_IMP = "qq_imp";
    public static final int REMINDER_POS_ID = 974;
    public static final int UIN_TYPE_ACTIVATE_FRIENDS = 9002;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface IntervalFrom {
        public static final int LOCAL = 0;
        public static final int UPDATE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface ReminderGetFrom {
        public static final int FOREGROUND_STATUS = 1;
        public static final int LOGIN = 0;
        public static final int NETWORK_RESUME = 2;
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(35297), (Class<?>) QQConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            ACTIVATE_FRIENDS_UIN = String.valueOf(9973L);
        }
    }
}
