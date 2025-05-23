package com.tencent.sqshow.zootopia.samestyle;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.state.report.SquareReportConst;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f372918d;

        a(Dialog dialog) {
            this.f372918d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f372918d.dismiss();
        }
    }

    public static void a(NavBarCommon navBarCommon) {
        navBarCommon.setTitle(BaseApplication.context.getResources().getString(R.string.xsz));
    }

    public static boolean b(Bundle bundle) {
        ZootopiaSource zootopiaSource = (ZootopiaSource) bundle.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE);
        return zootopiaSource != null && zootopiaSource.getMainSource() == Source.Emoticon;
    }

    public static void c(Context context) {
        String str;
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = "";
        }
        if (((Boolean) cl.c(context, str, "zp_tmp_create_tip", Boolean.TRUE)).booleanValue()) {
            Dialog dialog = new Dialog(context, R.style.qZoneInputDialog);
            dialog.setContentView(R.layout.f167422d81);
            dialog.setCanceledOnTouchOutside(true);
            ((TextView) dialog.findViewById(R.id.plp)).setOnClickListener(new a(dialog));
            dialog.show();
        }
        cl.l(context, str, true, "zp_tmp_create_tip", Boolean.FALSE);
    }
}
