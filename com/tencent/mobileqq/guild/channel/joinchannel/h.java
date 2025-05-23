package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import vh2.bv;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {
    public static void a(Context context, JumpGuildParam jumpGuildParam, JoinGuildLogic.JumpParam jumpParam, String str, @Nullable bv bvVar) {
        new JoinGuildLogic(context, str).e(jumpGuildParam, jumpParam, bvVar);
    }

    public static void b(Context context, JumpGuildParam jumpGuildParam, JoinGuildLogic.JumpParam jumpParam, String str) {
        new JoinGuildLogic(context, str).g(jumpGuildParam, jumpParam);
    }

    public static void c(Context context, int i3, String str, @Nullable IGProSecurityResult iGProSecurityResult) {
        if (g.f214997a.a(i3)) {
            return;
        }
        if (context == null) {
            context = QBaseActivity.sTopActivity;
        }
        if (context == null) {
            QLog.e("Guild.join.QQJoinGuildHelper", 1, "handleJoinGuildError context is null, code:", Integer.valueOf(i3), " tips:", str);
            return;
        }
        if (i3 == 1002) {
            QQToast.makeText(context, QQGuildUIUtil.r(R.string.f1511016s), 1).show();
            return;
        }
        if (i3 == 22037) {
            QLog.e("Guild.join.QQJoinGuildHelper", 1, "handleJoinGuildError security silent bear code:", Integer.valueOf(i3), " tips:", str);
            return;
        }
        if ((i3 == 3 || i3 == 22006 || i3 == 22008) && !TextUtils.isEmpty(str)) {
            QQToast.makeText(context, str, 1).show();
        } else if (i3 == 22036) {
            QLog.i("Guild.join.QQJoinGuildHelper", 1, "handleJoinGuildError ASYNC_QUEUE_DEAL");
        } else {
            SecurityTipHelperKt.B(context, i3, str, iGProSecurityResult, QQGuildUIUtil.r(R.string.f138610_1));
        }
    }

    public static boolean d(int i3, IGProSecurityResult iGProSecurityResult) {
        if (ch.p(iGProSecurityResult) && (i3 == 0 || i3 == 22004)) {
            return true;
        }
        return false;
    }
}
