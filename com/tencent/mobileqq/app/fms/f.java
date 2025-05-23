package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f195628a;

    /* renamed from: b, reason: collision with root package name */
    public static int f195629b;

    /* renamed from: c, reason: collision with root package name */
    public static int f195630c;

    /* renamed from: d, reason: collision with root package name */
    public static long f195631d;

    /* renamed from: e, reason: collision with root package name */
    public static Integer[] f195632e;

    /* renamed from: f, reason: collision with root package name */
    public static GroupMsgMask[] f195633f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f195628a = 9999;
        f195629b = Integer.MAX_VALUE;
        f195630c = 3000;
        f195631d = 863913600L;
        f195632e = new Integer[]{0, 1, 3000};
        f195633f = new GroupMsgMask[]{GroupMsgMask.NOTIFY, GroupMsgMask.RECEIVE, GroupMsgMask.ASSISTANT, GroupMsgMask.SHIELD};
    }

    public static boolean a(QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (NetConnInfoCenter.getServerTime() - recentUser.lastmsgtime >= f195631d || !c(recentUser.getType())) {
            return false;
        }
        if (recentUser.getType() == 1 && !b(qQAppInterface.getTroopMask(recentUser.uin))) {
            return false;
        }
        return true;
    }

    public static boolean b(GroupMsgMask groupMsgMask) {
        for (GroupMsgMask groupMsgMask2 : f195633f) {
            if (groupMsgMask2 == groupMsgMask) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(int i3) {
        for (Integer num : f195632e) {
            if (num.intValue() == i3) {
                return true;
            }
        }
        return false;
    }
}
