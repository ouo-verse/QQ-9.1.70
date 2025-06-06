package com.tencent.mobileqq.profilecard.bussiness.anonymous.constant;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String EMPTY_BACKGROUND_URL = "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png";
    public static final String EMPTY_BACKGROUND_URL_TWO_LINE_TEXT = "https://sola.gtimg.cn/aoi/sola/20200804163900_erRdzraqzD.png";
    public static final int[] HEAD_BG_COLOR;
    public static final String KEY_ASK_ANONYMOUSLY = "key_ask_anonymously";
    public static final String KEY_A_STR = "key_answer_str";
    public static final String KEY_A_TIME = "key_answer_time";
    public static final String KEY_BEEN_PRAISE = "key_been_praise";
    public static final String KEY_COMMENT_NUM = "key_comment_num";
    public static final String KEY_PRAISE_KEY = "key_praise_key";
    public static final String KEY_PRAISE_NUM = "key_praise_num";
    public static final String KEY_Q_ID = "key_question_id";
    public static final String KEY_Q_STR = "key_question_str";
    public static final String KEY_Q_TIME = "key_question_time";
    public static final String KEY_Q_UIN = "key_question_uin";
    public static final String KEY_SHOW_TIMES = "key_show_times";
    public static final int LIKE_IV_COLOR;
    public static final int LIKE_IV_DRAWABLE;
    public static final int LIST_MAX_SHOW_ITEM = 10;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface AnonymousUiState {
        public static final int HOST_EMPTY_ANSWER = 2;
        public static final int HOST_EMPTY_QUESTION = 1;
        public static final int HOST_SHOW_TOTAL = 3;
        public static final int SHOW_NORMAL_DATA = 0;
        public static final int VISITOR_EMPTY = 4;
        public static final int VISITOR_SHOW_ASK_QUESTION = 5;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LIKE_IV_DRAWABLE = R.drawable.nfx;
        LIKE_IV_COLOR = Color.parseColor("#FF4D94FF");
        HEAD_BG_COLOR = new int[]{Color.parseColor("#FFFFDB00"), Color.parseColor("#FF32C5FF"), Color.parseColor("#FFFF7979"), Color.parseColor("#FF64F0BD"), Color.parseColor("#FF9266FF"), Color.parseColor("#FF8FF56F"), Color.parseColor("#FFFFC1A4"), Color.parseColor("#FFFF8C5D"), Color.parseColor("#FF49B3FF"), Color.parseColor("#FFC362FF"), Color.parseColor("#FF629BFF"), Color.parseColor("#FFFE89E1"), Color.parseColor("#FFFFD957"), Color.parseColor("#FF6776FF"), Color.parseColor("#FFEB5FFF"), Color.parseColor("#FFFF63B4"), Color.parseColor("#FF76E4FF"), Color.parseColor("#FFB4E019"), Color.parseColor("#FFFFA967"), Color.parseColor("#FFFF6767")};
    }

    public AnonymousConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
