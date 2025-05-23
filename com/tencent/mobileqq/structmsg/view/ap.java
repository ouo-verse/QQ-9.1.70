package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ap extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    public int f290597g1;

    /* renamed from: h1, reason: collision with root package name */
    public boolean f290598h1;

    /* renamed from: i1, reason: collision with root package name */
    public int f290599i1;

    public ap() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void M(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f290598h1 = z16;
            this.f290597g1 = i3;
        }
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f290599i1 = i3;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        int g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view instanceof TextView) {
            if (TextUtils.isEmpty(this.R0)) {
                g16 = m();
            } else {
                g16 = com.tencent.mobileqq.structmsg.k.g(this.R0);
            }
            ((TextView) view).setTextColor(g16);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        TroopInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, context, view, bundle);
        }
        if (bundle != null && bundle.containsKey("extend-data-json") && bundle.getInt("serviceID", 0) == 128) {
            String string = bundle.getString("extend-data-json");
            if (!TextUtils.isEmpty(string)) {
                try {
                    if (context instanceof BaseActivity) {
                        JSONObject jSONObject = new JSONObject(string);
                        QQAppInterface qQAppInterface = ((BaseActivity) context).app;
                        StringBuilder sb5 = new StringBuilder();
                        if (jSONObject.has("senderuin")) {
                            String optString = jSONObject.optString("senderuin");
                            if (TextUtils.equals(optString, qQAppInterface.getCurrentUin())) {
                                String Q = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, jSONObject.optString("invitedUin"), 0);
                                sb5.append("\u4f60\u9080\u8bf7");
                                sb5.append(com.tencent.mobileqq.utils.ac.x(Q, 12.0f));
                            } else {
                                sb5.append(com.tencent.mobileqq.utils.ac.x(com.tencent.mobileqq.utils.ac.Q(qQAppInterface, optString, 0), 12.0f));
                                sb5.append("\u9080\u8bf7\u4f60");
                            }
                        } else {
                            sb5.append("\u9080\u8bf7");
                        }
                        String optString2 = jSONObject.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME);
                        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                        if (troopManager != null && (k3 = troopManager.k(jSONObject.optString("groupcode"))) != null) {
                            String troopDisplayName = k3.getTroopDisplayName();
                            if (!TextUtils.isEmpty(troopDisplayName)) {
                                optString2 = troopDisplayName;
                            }
                        }
                        sb5.append("\u52a0\u5165\u7fa4\u804a\u201c");
                        sb5.append(com.tencent.mobileqq.utils.ac.x(optString2, 12.0f));
                        sb5.append("\u201d\uff0c\u8fdb\u5165\u53ef\u67e5\u770b\u8be6\u60c5\u3002");
                        this.X0 = sb5.toString();
                    }
                } catch (Throwable th5) {
                    QLog.d("StructMsgItemSummary", 1, "createView error:" + th5.getMessage());
                }
            }
        }
        return super.c(context, view, bundle);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "Summary";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void j(AbsShareMsg absShareMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absShareMsg);
        } else {
            absShareMsg.mContentSummary = this.X0;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.f290598h1 && this.f290597g1 != 0) {
            return -1;
        }
        return -8355712;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 28;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        AbsStructMsg absStructMsg = this.P0;
        if (absStructMsg != null && absStructMsg.mMsgServiceID == 35) {
            return super.r();
        }
        try {
            if (!TextUtils.isEmpty(this.f290387b1)) {
                return Integer.parseInt(this.f290387b1);
            }
        } catch (NumberFormatException e16) {
            QLog.i("StructMsgItemSummary", 1, "text=" + this.X0 + ", url=" + this.f290327h + ", exc=" + e16.toString());
        }
        return this.f290599i1;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.tv_summary;
    }

    public ap(String str) {
        super(str, "summary");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f290597g1 = 0;
        this.f290598h1 = false;
        this.f290599i1 = 3;
    }
}
