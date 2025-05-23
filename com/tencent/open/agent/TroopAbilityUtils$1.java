package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
class TroopAbilityUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f340077d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f340078e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f340079f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f340080h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f340081i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ String f340082m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!TroopAbilityUtils$1.this.f340077d.isFinishing()) {
                dialogInterface.dismiss();
            }
            if (i3 == 0) {
                try {
                    Intent intent = new Intent();
                    intent.addFlags(335544320);
                    TroopAbilityUtils$1 troopAbilityUtils$1 = TroopAbilityUtils$1.this;
                    if (troopAbilityUtils$1.f340078e) {
                        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(troopAbilityUtils$1.f340079f), TroopAbilityUtils$1.this.f340080h)));
                    } else {
                        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", Long.valueOf(troopAbilityUtils$1.f340079f), TroopAbilityUtils$1.this.f340080h)));
                    }
                    intent.setPackage(TroopAbilityUtils$1.this.f340081i);
                    TroopAbilityUtils$1.this.f340077d.startActivity(intent);
                } catch (Exception e16) {
                    QLog.e("TroopAbility.Utils", 1, "[startSdkCallback] startActivity failed, exception=", e16);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.biz.widgets.e eVar = new com.tencent.biz.widgets.e(this.f340077d);
        a aVar = new a();
        String qqStr = HardCodeUtil.qqStr(R.string.u_d);
        eVar.Q(this.f340082m);
        eVar.O(qqStr, aVar);
        eVar.P(aVar);
        eVar.show();
    }
}
