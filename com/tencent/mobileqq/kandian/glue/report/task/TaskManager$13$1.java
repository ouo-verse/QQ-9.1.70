package com.tencent.mobileqq.kandian.glue.report.task;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
class TaskManager$13$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f239900d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f239901e;

    @Override // java.lang.Runnable
    public void run() {
        DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 232, this.f239900d, this.f239901e, "OK", HardCodeUtil.qqStr(R.string.tzk), new a(), new b()).show();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
