package com.tencent.mobileqq.activity.recent.msgbox.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TempGameMsgSettingReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f185705a;

    public TempGameMsgSettingReceiver(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f185705a = qQAppInterface;
        }
    }

    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "0X800BB93";
            }
            return "0X800BB92";
        }
        return "0X800BB91";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (QLog.isColorLevel()) {
            QLog.d("TempGameMsgSettingReceiver", 2, "[onReceiver] action:" + action);
        }
        if (action != null && action.equals("action_qgame_toggle_change")) {
            int intExtra = intent.getIntExtra("key_msg_change_type_id", 1);
            String stringExtra = intent.getStringExtra("key_msg_change_game_id");
            if (QLog.isColorLevel()) {
                QLog.d("TempGameMsgSettingReceiver", 2, "type = [" + intExtra + "], gameId = [" + stringExtra + "]");
            }
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            new e().b(this.f185705a);
            ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(this.f185705a, true);
            String a16 = a(intExtra);
            if (!TextUtils.isEmpty(a16)) {
                ReportController.o(this.f185705a, "dc00898", "", "", a16, a16, 0, 0, "", "", "", stringExtra);
            }
        }
    }
}
