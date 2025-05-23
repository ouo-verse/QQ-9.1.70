package gh;

import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.StringUtil;
import x8.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static String a(User user, boolean z16) {
        return b(user, z16, false);
    }

    public static String c(User user, d.a aVar) {
        return d(user, aVar, false);
    }

    public static String b(User user, boolean z16, boolean z17) {
        if (user == null) {
            return "";
        }
        String e16 = e(user.nickName, z16, z17);
        if (user.actiontype == 2) {
            return DetailUtil.buildActionUrlString(user.actionurl, e16);
        }
        return DetailUtil.buildNicknameString(user.uin, e16);
    }

    public static String d(User user, d.a aVar, boolean z16) {
        if (user == null) {
            return "";
        }
        String e16 = e(user.nickName, false, z16);
        if (user.actiontype == 2) {
            return DetailUtil.buildActionUrlString(user.actionurl, e16);
        }
        return DetailUtil.buildVipNicknameString(user.uin, e16, aVar);
    }

    public static String e(String str, boolean z16, boolean z17) {
        String str2;
        if (z17) {
            str = "        " + StringUtil.getElipseStringWide(str, 30) + " ";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (z16) {
            str2 = MsgSummary.STR_COLON;
        } else {
            str2 = "";
        }
        sb5.append(str2);
        return sb5.toString();
    }
}
