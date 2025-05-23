package com.tencent.mobileqq.persistence.bridge;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBTableVerifyFailHandler implements OnDBTableVerifyFailListener {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f258312a = false;

    private void b(final String str) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler$1$a */
            /* loaded from: classes16.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler$1$b */
            /* loaded from: classes16.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ExceptionTracker.trackException("DBVerifyFailToastHandler", "table " + str + " Entity file changed without updating DBVersion");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                QLog.d("DBVerifyFailToastHandler", 1, "handleErrorReport top activity: " + qBaseActivity);
                if (qBaseActivity != null) {
                    DBTableVerifyFailHandler.f258312a = true;
                    BaseApplication context = BaseApplication.getContext();
                    String str2 = str;
                    DialogUtil.createNoTitleDialog(qBaseActivity, context.getString(R.string.f237487h7, str2, str2), R.string.f170901b10, R.string.zoj, new a(), new b()).show();
                }
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener
    public void onDBTableVerifyFailed(String str) {
        if (f258312a) {
            return;
        }
        b(str);
    }
}
