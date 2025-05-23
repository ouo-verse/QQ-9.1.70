package com.tencent.mobileqq.leba.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class LebaPluginInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    static final String EXT_CONF_ALLOW_CHANGE = "allowChange";
    private static final String EXT_CONF_CHANNEL_NAME = "channel_blacklist";
    public static final String EXT_CONF_DA_TONG_ID = "daTongID";
    static final String EXT_CONF_SIMPLE_ICON = "simpleIcon";
    public static final String EXT_CONF_SIMPLE_MODE_NAME = "simpleModeName";
    static final String EXT_CONF_WATERMARK_URL = "waterMarkUrl";
    public static final int STATE_ADD = 3;
    public static final int STATE_DEL = 2;
    public static final int STATE_NONE = 0;
    public static final int STATE_UPDATE = 1;
    public static final String TAG = "Leba.PluginInfo";

    @notColumn
    private Boolean allowChange;
    public int cCanChangeState;
    public byte cDataType;

    @notColumn
    public int cIconResId;

    @notColumn
    public boolean cShow;

    @notColumn
    public int cShowVer;

    @notColumn
    private JSONObject extConfCache;

    @notColumn
    public int groupId;
    public String resConf;

    @notColumn
    public int sPriority;
    public int sResSeq;
    public short sResSubType;

    @Deprecated
    public int showInSimpleMode;

    @notColumn
    public int state;
    public String strGotoUrl;
    public String strGridIconUrl;

    @Deprecated
    public String strPkgName;
    public String strResName;
    public String strResURL;
    public String strSimpleResUrl;

    @unique
    public long uiResId;

    public LebaPluginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.state = 0;
        this.cIconResId = 0;
        this.allowChange = null;
        this.cShow = true;
        this.cShowVer = 0;
    }

    public static LebaPluginInfo find(EntityManager entityManager, long j3) {
        if (entityManager != null && j3 > 0) {
            return (LebaPluginInfo) DBMethodProxy.find(entityManager, LebaPluginInfo.class, "uiResId=?", new String[]{String.valueOf(j3)});
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<LebaPluginInfo> getAll(EntityManager entityManager) {
        List list;
        if (entityManager != null) {
            list = entityManager.query(LebaPluginInfo.class, false, "", null, null, null, null, null);
        } else {
            list = null;
        }
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

    private JSONObject getExtConfCache() {
        JSONObject jSONObject = this.extConfCache;
        if (jSONObject != null) {
            return jSONObject;
        }
        if (TextUtils.isEmpty(this.resConf)) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.resConf);
            this.extConfCache = jSONObject2;
            return jSONObject2;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "failed to parse ext conf, conf=" + this.resConf + ", exception=" + e16.toString());
            return new JSONObject();
        }
    }

    public static void persistOrReplace(EntityManager entityManager, LebaPluginInfo lebaPluginInfo) {
        if (entityManager != null && lebaPluginInfo != null) {
            long j3 = lebaPluginInfo.uiResId;
            if (j3 > 0) {
                LebaPluginInfo lebaPluginInfo2 = (LebaPluginInfo) DBMethodProxy.find(entityManager, LebaPluginInfo.class, "uiResId=?", new String[]{String.valueOf(j3)});
                if (lebaPluginInfo2 != null) {
                    lebaPluginInfo2.sResSeq = lebaPluginInfo.sResSeq;
                    lebaPluginInfo2.strPkgName = lebaPluginInfo.strPkgName;
                    lebaPluginInfo2.strResName = lebaPluginInfo.strResName;
                    lebaPluginInfo2.strResURL = lebaPluginInfo.strResURL;
                    lebaPluginInfo2.sResSubType = lebaPluginInfo.sResSubType;
                    lebaPluginInfo2.strGotoUrl = lebaPluginInfo.strGotoUrl;
                    lebaPluginInfo2.cCanChangeState = lebaPluginInfo.cCanChangeState;
                    lebaPluginInfo2.resConf = lebaPluginInfo.resConf;
                    lebaPluginInfo2.cDataType = lebaPluginInfo.cDataType;
                    lebaPluginInfo2.showInSimpleMode = lebaPluginInfo.showInSimpleMode;
                    lebaPluginInfo2.strGridIconUrl = lebaPluginInfo.strGridIconUrl;
                    entityManager.update(lebaPluginInfo2);
                    return;
                }
                entityManager.persist(lebaPluginInfo);
            }
        }
    }

    public static void remove(EntityManager entityManager, long j3) {
        LebaPluginInfo find;
        if (entityManager != null && (find = find(entityManager, j3)) != null) {
            entityManager.remove(find);
        }
    }

    public boolean getAllowModify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return getExtConfCache().optBoolean(EXT_CONF_ALLOW_CHANGE, true);
    }

    public boolean getChannelName(String str) {
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && (optString = getExtConfCache().optString(EXT_CONF_CHANNEL_NAME, "DefaultChannelName")) != null && !optString.isEmpty()) {
            String[] split = optString.split(",");
            for (int i3 = 0; i3 < split.length; i3++) {
                if (str.equals(split[i3])) {
                    QLog.d(TAG, 1, "get channel name is " + split[i3]);
                    return true;
                }
            }
        }
        return false;
    }

    public String getDaTongID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getExtConfCache().optString(EXT_CONF_DA_TONG_ID, "default");
    }

    public String getPluginName(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        if (z16) {
            String optString = getExtConfCache().optString(EXT_CONF_SIMPLE_MODE_NAME, this.strResName);
            if (optString != null && !optString.trim().isEmpty()) {
                return optString;
            }
            return this.strResName;
        }
        return this.strResName;
    }

    public boolean getShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.cShow;
    }

    public int getShowVer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.cShowVer;
    }

    public String getSimpleIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!TextUtils.isEmpty(this.strSimpleResUrl)) {
            return this.strSimpleResUrl;
        }
        return getExtConfCache().optString(EXT_CONF_SIMPLE_ICON, "");
    }

    public String getWaterMarkUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getExtConfCache().optString(EXT_CONF_WATERMARK_URL, "");
    }

    public boolean isAllowUserChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        Boolean bool = this.allowChange;
        if (bool != null) {
            return bool.booleanValue();
        }
        return getAllowModify();
    }

    public void setAllowChange(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bool);
        } else {
            this.allowChange = bool;
        }
    }

    public void setShow(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.cShow = z16;
            this.cShowVer = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LebaPluginInfo\uff1a" + this.uiResId + "|" + this.state + "|" + this.strPkgName + "|" + this.strResName + "|" + this.sResSeq + "|" + ((int) this.sResSubType) + "|" + this.cCanChangeState + "|" + this.sPriority + "|" + this.showInSimpleMode + "|" + this.strResURL + "|" + this.strGotoUrl + "|" + this.strGridIconUrl + "|" + this.resConf;
    }
}
