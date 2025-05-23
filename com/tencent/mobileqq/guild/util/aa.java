package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class aa {
    public static void a(@StringRes int i3) {
        b(HardCodeUtil.qqStr(i3));
    }

    public static void b(String str) {
        QQToast.makeText(BaseApplication.getContext(), str, 0).show();
    }

    public static QQCustomDialog c(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Activity b16 = com.tencent.mobileqq.guild.window.o.a().b("qqGuildLiveRoom");
        if (b16 == null) {
            QLog.d("GuildLiveToast", 4, "weakReferenceActivity is null return");
            return null;
        }
        if (!b16.isFinishing() && !b16.isDestroyed()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(b16, 230, (String) null, QQGuildUIUtil.r(R.string.f147670xi), QQGuildUIUtil.r(R.string.f147680xj), QQGuildUIUtil.r(R.string.f147690xk), onClickListener, onClickListener2);
            createCustomDialog.show();
            return createCustomDialog;
        }
        QLog.d("GuildLiveToast", 4, "weakReferenceActivity is isFinishing or isDestroyed");
        return null;
    }

    public static void d(@StringRes int i3) {
        e(HardCodeUtil.qqStr(i3));
    }

    public static void e(String str) {
        QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
    }

    public static void g(String str) {
        QQToast.makeText(BaseApplication.getContext(), str, 1).show();
    }

    public static void h(String str) {
        QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show();
    }

    public static void f(String str) {
    }
}
