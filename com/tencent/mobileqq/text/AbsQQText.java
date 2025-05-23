package com.tencent.mobileqq.text;

import android.text.Spannable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AbsQQText implements CharSequence, Spannable {
    static IPatchRedirector $redirector_ = null;
    public static final int AIO_NICK_EMO_SIZE = 13;
    public static final int DEFAULT_BIG_EMO_SIZE = 32;
    public static final int DEFAULT_EMO_SIZE = 32;
    public static final String EMOJI_SYMBOL;
    public static final int EMOJI_TYPE_EMOJI = 0;
    public static final int EMOJI_TYPE_SMALL = 2;
    public static final int EMOJI_TYPE_SYSTEM = 1;
    public static final String EMOTICON_CONTENT_DESCRIPTION_SYMBOL;
    public static final char ENTER = '\r';
    public static final char ENTER_REPLACE = '\u00fe';
    public static final int GRAB_ANIM_EMOTCATION = 5;
    public static final int GRAB_COLOR_NICK = 16;
    public static final int GRAB_EMOJI = 1;
    public static final int GRAB_EMOTCATION = 3;
    public static final int GRAB_EMOTCATION_MASK = 7;
    public static final int GRAB_FOR_AIO = 45;
    public static final int GRAB_GUILD_NUMBER = 64;
    public static final int GRAB_HASHTAG_LINKS = 32;
    public static final int GRAB_LINKS = 8;
    public static final int GRAB_SYS_ANIM_EMOTCATION = 4;
    public static final int GRAB_SYS_EMOTCATION = 2;
    public static final int GRAB_SYS_EMOTCATION_MASK = 6;
    public static final char HEAD_INDEX = 20;
    public static final char HEAD_INDEX_REPLACE = '\u00fd';
    public static final char LF = '\n';
    public static final int NO_ACTION = 0;
    public static final int PLAIN_TYPE_FILTER_SYS_AND_EMOJI = 1;
    public static final int PLAIN_TYPE_REPLACE_EMOJI = 2;
    public static final int PLAIN_TYPE_REPLACE_EMOJI_WITH_CONTENT_DESCRIPTION = 4;
    public static final int PLAIN_TYPE_RETAIN_EMOJI = 3;
    public static final char RF = '\u00fa';
    public static String SMALL_EMOJI_SYMBOL = null;
    public static final int SMALL_EMO_SIZE = 16;
    public static final int SUB_SEQUENCE_FLAG_PASS_FLAGS = 1;
    public static final int TROOP_NICK_EDIT_EMO_SIZE = 16;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EMOTICON_CONTENT_DESCRIPTION_SYMBOL = HardCodeUtil.qqStr(R.string.f208805dp);
        EMOJI_SYMBOL = HardCodeUtil.qqStr(R.string.f208795do);
        SMALL_EMOJI_SYMBOL = HardCodeUtil.qqStr(R.string.f208815dq);
    }

    public AbsQQText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract AbsQQText append(String str, boolean z16, int... iArr);
}
