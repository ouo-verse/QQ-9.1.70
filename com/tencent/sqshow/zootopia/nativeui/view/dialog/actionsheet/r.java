package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"", "c", "d", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class r {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String c() {
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(currentDate)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        try {
            String nick = ((IFriendNameService) peekAppRuntime.getRuntimeService(IFriendNameService.class, "all")).getFriendNick(peekAppRuntime.getCurrentUin());
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            if (nick.codePointCount(0, nick.length()) > 6) {
                Intrinsics.checkNotNullExpressionValue(nick, "nick");
                int offsetByCodePoints = nick.offsetByCodePoints(0, 6);
                Intrinsics.checkNotNullExpressionValue(nick, "nick");
                String substring = nick.substring(0, offsetByCodePoints);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                nick = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            return nick;
        } catch (Throwable unused) {
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            return currentUin;
        }
    }
}
