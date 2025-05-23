package com.tencent.mobileqq.activity.troop.config;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends com.tencent.mobileqq.troop.api.config.o {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void i(@NonNull AppInterface appInterface, String str) {
        if (appInterface instanceof QQAppInterface) {
            ((QQAppInterface) appInterface).getMessageFacade().q(str, 1);
        }
    }

    private void j(AppInterface appInterface, String str, int i3, String str2) {
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (!str2.isEmpty()) {
                ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, new LocalGrayTip.LocalGrayTipBuilder(str, 2, 2603L, 1, true, true, null).g(str2, 1).m(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.activity.troop.config.h
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                    public final void onResult(int i16, long j3) {
                        i.k(i16, j3);
                    }
                });
            }
            aw.e(str, qQAppInterface);
            try {
                if (qQAppInterface.getAVNotifyCenter().S(Long.parseLong(str))) {
                    BaseApplication.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(int i3, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopBizTroopMngProcessor", 2, "handleExitTroopHoldMsg, addLocalGrayTip result:" + i3);
        }
    }

    private void l(int i3) {
        QQToast.makeText(BaseApplication.context, 2, i3, 0).show();
    }

    @Override // com.tencent.mobileqq.troop.api.config.o
    public void b(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface, (Object) str);
        } else {
            l(R.string.ud5);
            i(appInterface, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.api.config.o
    public void c(@androidx.annotation.NonNull @NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
        } else {
            l(R.string.ud5);
            j(appInterface, str, 2, "\u4f60\u5df2\u89e3\u6563\u8be5\u7fa4\u804a\u3002");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.o
    public void d(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) str);
        } else {
            l(R.string.ud7);
            i(appInterface, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.api.config.o
    public void e(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        } else {
            l(R.string.ud7);
            j(appInterface, str, 3, "\u4f60\u5df2\u9000\u51fa\u8be5\u7fa4\u804a\u3002");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.o
    public void f(String str, int i3, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), parcelable);
            return;
        }
        if (!TextUtils.isEmpty(str) && parcelable != null) {
            int i16 = !(parcelable instanceof JoinTroopParam) ? 1 : 0;
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
            intent.setAction("com.tencent.security.VERIFY_WEB");
            intent.putExtra("url", str);
            intent.putExtra(QWSoterConstans.CGI_KEY_BUSI_TYPE, i16);
            intent.putExtra("verify_type", i3);
            intent.putExtra("extra_data", parcelable);
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }
}
