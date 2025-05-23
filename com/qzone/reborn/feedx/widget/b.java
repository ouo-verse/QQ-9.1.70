package com.qzone.reborn.feedx.widget;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {
    public static List<TextCell> a(List<TextCell> list, int i3) {
        for (TextCell textCell : list) {
            if ((textCell instanceof UserNameCell) && e(textCell.getText()) && ((UserNameCell) textCell).getUin().longValue() != LoginData.getInstance().getUin()) {
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    public static List<TextCell> b(List<TextCell> list, int i3, boolean z16) {
        for (TextCell textCell : list) {
            if ((textCell instanceof UserNameCell) && !e(textCell.getText())) {
                ((UserNameCell) textCell).setTextBold(z16);
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    public static List<TextCell> c(List<TextCell> list, int i3) {
        for (TextCell textCell : list) {
            if ((textCell instanceof UserNameCell) && !e(textCell.getText())) {
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    public static List<TextCell> d(List<TextCell> list, int i3, boolean z16) {
        for (TextCell textCell : list) {
            if ((textCell instanceof UrlCell) && "\u8bbe\u7f6e".equals(textCell.getText())) {
                ((UrlCell) textCell).setTextBold(z16);
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("@");
    }
}
