package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ca extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ca(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #1 {Exception -> 0x0079, blocks: (B:10:0x001b, B:12:0x0024, B:16:0x0050, B:20:0x002b, B:23:0x0033), top: B:9:0x001b, inners: #0 }] */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (TextUtils.isEmpty(this.f307440e)) {
                QLog.e("QQFavAction", 1, "doAction error: action_name is empty");
            } else {
                try {
                    parseInt = Integer.parseInt(this.f307440e);
                } catch (NumberFormatException e16) {
                    QLog.e("QQFavAction", 1, "doAction error NumberFormatException: " + e16.getMessage());
                }
                if (parseInt == 2) {
                    return true;
                }
                Intent intent = new Intent();
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, BaseApplicationImpl.getApplication().getApplicationContext().getString(R.string.button_back));
                return QfavHelper.i((Activity) this.f307437b, this.f307436a.getAccount(), intent, -1, false);
            }
            parseInt = -1;
            if (parseInt == 2) {
            }
        } catch (Exception e17) {
            QLog.e("QQFavAction", 1, "doAction error: " + e17.getMessage());
            i("QQFavAction");
            return false;
        }
    }
}
