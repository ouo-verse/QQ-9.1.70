package com.tencent.mobileqq.guild.util;

import androidx.fragment.app.Fragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q {
    public static void a(Fragment fragment) {
        if (fragment == null) {
            s.e("Guild.comm.GuildFragmentUtil", "hideFragment fragment is null", new NullPointerException());
            return;
        }
        try {
            QLog.i("Guild.comm.GuildFragmentUtil", 1, "hideFragment " + fragment.getClass().getCanonicalName());
            fragment.getParentFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
        } catch (IllegalStateException e16) {
            QLog.w("Guild.comm.GuildFragmentUtil", 1, "hideFragment IllegalStateException", e16);
        }
    }

    public static void b(Fragment fragment) {
        if (fragment == null) {
            s.e("Guild.comm.GuildFragmentUtil", "removeFragment fragment is null", new NullPointerException());
            return;
        }
        try {
            QLog.i("Guild.comm.GuildFragmentUtil", 1, "removeFragment " + fragment.getClass().getCanonicalName());
            fragment.getParentFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
        } catch (IllegalStateException e16) {
            QLog.w("Guild.comm.GuildFragmentUtil", 1, "removeFragment IllegalStateException", e16);
        }
    }
}
