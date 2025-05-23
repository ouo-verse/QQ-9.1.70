package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TroopFansEntryConfig {
    static IPatchRedirector $redirector_ = null;
    protected static final int SWITCH_OFF = 0;
    protected static final int SWITCH_ON = 1;
    public static final String TAG = "TroopFansEntryConfig";
    public int mGroupEntranceSwitch;
    public int mGuideSwitch;
    public int mProfileCardEntranceSwitch;

    public TroopFansEntryConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mProfileCardEntranceSwitch = 0;
        this.mGroupEntranceSwitch = 0;
        this.mGuideSwitch = 0;
    }

    public static TroopFansEntryConfig parse(ai[] aiVarArr) {
        TroopFansEntryConfig troopFansEntryConfig = new TroopFansEntryConfig();
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "jsonObj:" + jSONObject.toString());
                    }
                    troopFansEntryConfig.mProfileCardEntranceSwitch = jSONObject.optInt("profileCardEntranceSwitch", 0);
                    troopFansEntryConfig.mGroupEntranceSwitch = jSONObject.optInt("groupEntranceSwitch", 0);
                    troopFansEntryConfig.mGuideSwitch = jSONObject.optInt("guideSwitch", 0);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "config:" + troopFansEntryConfig.toString());
        }
        return troopFansEntryConfig;
    }

    public boolean isGroupEntranceSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isGuideSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isProfileCardEntranceSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "mProfileCardEntranceSwitch:" + this.mProfileCardEntranceSwitch + "\r\nmGroupEntranceSwitch:" + this.mGroupEntranceSwitch + "\r\nmGuideSwitch:" + this.mGuideSwitch + "\r\n";
    }
}
