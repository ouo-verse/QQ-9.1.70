package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.biz.map.b;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMapDetailArkOptions extends ForwardArkMsgOption {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements b.InterfaceC0795b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMapDetailArkOptions.this);
            }
        }

        @Override // com.tencent.biz.map.b.InterfaceC0795b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public ForwardMapDetailArkOptions(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    private void o() {
        String str;
        String string;
        QLog.i("ForwardMapDetailArkOption", 2, "sendSingleMapDetailArkMessage");
        int i3 = this.mExtraData.getInt("uintype");
        try {
            if (i3 == 0) {
                string = this.mExtraData.getString("uin");
            } else {
                String string2 = this.mExtraData.getString("troop_uin");
                if ("".equals(string2)) {
                    string = this.mExtraData.getString("uin");
                } else {
                    str = string2;
                    JSONObject jSONObject = new JSONObject(this.mExtraData.getString(QQCustomArkDialogUtil.META_DATA)).getJSONObject("Location.Search");
                    com.tencent.biz.map.b.d(this.app, jSONObject.getString("name"), jSONObject.getString("address"), jSONObject.getString(QCircleSchemeAttr.Polymerize.LAT), jSONObject.getString("lng"), str, i3, new a());
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject(this.mExtraData.getString(QQCustomArkDialogUtil.META_DATA)).getJSONObject("Location.Search");
            com.tencent.biz.map.b.d(this.app, jSONObject2.getString("name"), jSONObject2.getString("address"), jSONObject2.getString(QCircleSchemeAttr.Polymerize.LAT), jSONObject2.getString("lng"), str, i3, new a());
            return;
        } catch (JSONException e16) {
            QLog.e("ForwardMapDetailArkOption", 2, "ArkMessage Error", e16);
            return;
        }
        str = string;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean allowQZoneAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        o();
        this.mActivity.finish();
        return true;
    }
}
