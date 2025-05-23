package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouchConst {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class Action {
        static IPatchRedirector $redirector_ = null;
        public static final String PUSH_ACTION_FOR_AV = "com.tencent.redpoint.broadcast.push.av";

        public Action() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class AppSet {
        static IPatchRedirector $redirector_ = null;
        public static final int PLUS_PANEL_SET = 10;
        public static final int QCIRCLE_TAB_BUBBLE_APP_SET = 16;
        public static final int TAB_APP_SET_AIO = 4;

        @Deprecated
        public static final int TAB_APP_SET_CALL = 6;
        public static final int TAB_APP_SET_CONTACT = 5;
        public static final int TAB_APP_SET_CONVERSATION = 10000;
        public static final int TAB_APP_SET_CONVERSION_CAMERA = 6;
        public static final int TAB_APP_SET_GUILD = 101;
        public static final int TAB_APP_SET_KANDIAN = 7;
        public static final int TAB_APP_SET_LEBA = 0;
        public static final int TAB_APP_SET_META_DREAM = 103;
        public static final int TAB_APP_SET_NONE = 2;
        public static final int TAB_APP_SET_QCIRCLE = 102;
        public static final int TAB_APP_SET_SETTING = 1;
        public static final int TAB_GUILD_APP_SET = 17;
        public static final int TAB_META_DREAM_APP_SET = 17;
        public static final int TROOP_PLUS_PANEL_SET = 11;
        public static final int TROOP_SETTINGS = 13;
        public static final int VIRTUAL_APP_SET = 3;
        public static final int ZPLAN_AIO_EMOTICON = 1;
        public static final int ZPLAN_APP_SET = 15;

        public AppSet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class Cmd {
        static IPatchRedirector $redirector_ = null;
        public static final String CMD_RED_TOUCH_CLIENT_REPORT = "RedTouchSvc.ClientReport";
        public static final String CMD_RED_TOUCH_ENTRANCE_SETTING = "RedTouchSvc.EntranceSetting";

        public Cmd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class Key {
        static IPatchRedirector $redirector_ = null;
        public static final String IS_CACHE_CHANGE = "isCacheChange";
        public static final String LAST_CLICK_PATH = "lastClickPath";
        public static final String PREF_NAME_REDTOUCH = "redTouchPref";
        public static final int PUSH_KEY = 309;
        public static final int RED_POINT_PUSH_KEY = 113;
        public static final String USE_OLD_TIANSHU_PUSH_CHANNEL_KEY = "UseOldTianShuPushChannel";

        public Key() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class PicDownload {
        static IPatchRedirector $redirector_ = null;
        public static final String ISCIRCLE = "isCircle";
        public static final String REDTOUCHPIC_PROTOC = "redtouchpicdownloadprotoc";

        public PicDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class Report {
        static IPatchRedirector $redirector_ = null;
        public static final int RED_POINT_ARRIVE = 32;
        public static final int RED_POINT_CLICK_REPORT = 6;
        public static final int RED_POINT_CLIENT_REPORT = 5;
        public static final int RED_POINT_COMMON_CLICK_REPORT = 31;
        public static final int RED_POINT_COMMON_EXPOSE_REPORT = 30;
        public static final int RED_POINT_CONVERSATION_REMIAN_REPORT = 50;
        public static final int RED_POINT_EXPOSURE_REPORT = 1;
        public static final int RED_POINT_GETAPPINFO_REPORT = 12;
        public static final int RED_POINT_LEBA_SETTING = 4;
        public static final int RED_POINT_PHOTO_REPORT = 14;
        public static final int RED_POINT_PUSH_CLEAR = 19;
        public static final int RED_POINT_RESIDENCE_TIME = 18;
        public static final int RED_POINT_SETAPPINFO_REPORT = 13;

        public Report() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class Source {
        static IPatchRedirector $redirector_ = null;
        public static final int SRC_FROM_LEBA = 1;

        public Source() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchConst.this);
            }
        }
    }

    public RedTouchConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
