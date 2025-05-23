package com.tencent.icgame.game.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {
    public static boolean b(Context context) {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context);
    }

    public static boolean d(Context context) {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(context);
    }

    public static void e(Context context, DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f210605ik), context.getString(R.string.f210595ij), context.getString(R.string.f210585ii), context.getString(R.string.f210615il), onClickListener, onClickListener2);
        createCustomDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.icgame.game.utils.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                onClickListener2.onClick(dialogInterface, 0);
            }
        });
        createCustomDialog.show();
    }
}
