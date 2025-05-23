package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.h;
import com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CreateTroopShareImpl implements ICreateTroopShare {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_UIN = "uin";
    public static final String KEY_UIN_TYPE = "uintype";
    private static final String TAG = "CreateTroopShareImpl";
    private AppRuntime mApp;
    ForwardBaseOption mForwardOption;
    private g share2GuildCallback;

    public CreateTroopShareImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mForwardOption = null;
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare
    public void ShareToQQ(JSONObject jSONObject, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject, (Object) activity);
            return;
        }
        String optString = jSONObject.optString("shareLink");
        String optString2 = jSONObject.optString("shareTitle");
        String optString3 = jSONObject.optString("shareDesc");
        String optString4 = jSONObject.optString("shareIcon");
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(149).d(HardCodeUtil.qqStr(R.string.udg) + optString2).j(optString).a();
        com.tencent.mobileqq.structmsg.a c16 = h.c(2);
        c16.o(optString4, optString2, optString3);
        a16.addItem(c16);
        Intent intent = new Intent();
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 1002);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare
    public void miniAppShareQQDirectly(Intent intent, final Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) activity);
            return;
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            this.mForwardOption = k.d(intent, (QQAppInterface) appRuntime, activity);
            int intExtra = intent.getIntExtra("uintype", 0);
            ForwardBaseOption forwardBaseOption2 = this.mForwardOption;
            if ((forwardBaseOption2 instanceof al) && intExtra == 10027) {
                if (!((al) forwardBaseOption2).b()) {
                    QQToast.makeText(BaseApplication.getContext(), 0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    activity.finish();
                    return;
                }
                this.share2GuildCallback = new g() { // from class: com.tencent.mobileqq.troop.api.troopcreate.impl.a
                    @Override // com.tencent.mobileqq.guild.feed.api.g
                    public final void a(boolean z16) {
                        activity.finish();
                    }
                };
                String stringExtra = intent.getStringExtra("uin");
                if (!TextUtils.isEmpty(stringExtra)) {
                    ((al) this.mForwardOption).a(activity, stringExtra, intent.getIntExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal()), this.share2GuildCallback);
                    return;
                } else {
                    QLog.d(TAG, 1, "guild uin is null, finish it");
                    activity.finish();
                    return;
                }
            }
            forwardBaseOption2.buildForwardDialog(e.N3.intValue(), intent.getExtras());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare
    public void miniAppShareQQDirectlyWithOutDialog(Intent intent, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) activity);
            return;
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            this.mForwardOption = k.d(intent, (QQAppInterface) appRuntime, activity);
            int intExtra = intent.getIntExtra("uintype", 0);
            ForwardBaseOption forwardBaseOption2 = this.mForwardOption;
            if ((forwardBaseOption2 instanceof al) && intExtra == 10027) {
                if (!((al) forwardBaseOption2).b()) {
                    QQToast.makeText(BaseApplication.getContext(), 0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
                activity.finish();
                return;
            }
            forwardBaseOption2.forwardDirectly(null);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        this.mForwardOption = null;
    }
}
