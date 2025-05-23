package com.tencent.mobileqq.confess;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_CONFESSOR_FRIEND_SEX = "key_confessor_friend_sex";
    public static final String KEY_CONFESSOR_NICK = "key_confessor_nick";
    public static final String KEY_CONFESSOR_NUM = "key_confessor_num";
    public static final String KEY_CONFESSOR_SEX = "key_confessor_sex";
    public static final String KEY_CONFESSOR_UIN = "key_confessor_uin";
    public static final String KEY_CONFESS_BG_TYPE = "key_confess_bg_type";
    public static final String KEY_CONFESS_DESC = "key_confess_desc";
    public static final String KEY_CONFESS_REC_NICK_NAME = "key_confess_rec_nick_name";
    public static final String KEY_CONFESS_REC_NICK_TYPE = "key_confess_rec_nick_type";
    public static final String KEY_CONFESS_REC_UIN = "key_confess_rec_uin";
    public static final String KEY_CONFESS_SYSMSG = "key_confess_sysmsg";
    public static final String KEY_CONFESS_TIME = "key_confess_time";
    public static final String KEY_CONFESS_TOPICID = "key_confess_topicid";
    private static final long serialVersionUID = 0;
    public long confessTime;
    public String confessorNick;
    public int confessorSex;
    public long confessorUin;
    public String confessorUinStr;
    public int isSysMsg;
    public String topic;
    public int topicId;

    public ConfessInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null || !(obj instanceof ConfessInfo)) {
            return false;
        }
        ConfessInfo confessInfo = (ConfessInfo) obj;
        if (this.topicId != confessInfo.topicId || this.confessorSex != confessInfo.confessorSex || this.confessorUin != confessInfo.confessorUin || !Utils.p(this.confessorNick, confessInfo.confessorNick) || !Utils.p(this.topic, confessInfo.topic)) {
            return false;
        }
        return true;
    }

    public void parseFromJsonStr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        reset();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(KEY_CONFESS_TOPICID)) {
                this.topicId = jSONObject.getInt(KEY_CONFESS_TOPICID);
            }
            if (jSONObject.has(KEY_CONFESSOR_SEX)) {
                this.confessorSex = jSONObject.getInt(KEY_CONFESSOR_SEX);
            }
            if (jSONObject.has(KEY_CONFESS_SYSMSG)) {
                this.isSysMsg = jSONObject.getInt(KEY_CONFESS_SYSMSG);
            }
            if (jSONObject.has(KEY_CONFESSOR_UIN)) {
                this.confessorUin = jSONObject.getLong(KEY_CONFESSOR_UIN);
            }
            if (jSONObject.has(KEY_CONFESSOR_NICK)) {
                this.confessorNick = jSONObject.getString(KEY_CONFESSOR_NICK);
            }
            if (jSONObject.has(KEY_CONFESS_DESC)) {
                this.topic = jSONObject.getString(KEY_CONFESS_DESC);
            }
            if (jSONObject.has(KEY_CONFESS_TIME)) {
                this.confessTime = jSONObject.getLong(KEY_CONFESS_TIME);
            }
            this.confessorUinStr = String.valueOf(this.confessorUin);
        } catch (Exception unused) {
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.topicId = 0;
        this.confessorSex = 0;
        this.isSysMsg = 0;
        this.confessorUin = 0L;
        this.confessorNick = "";
        this.confessorUinStr = "";
        this.topic = "";
        this.confessTime = 0L;
    }

    public String toJsonStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? toJsonStr(this.topicId, this.confessorUin, this.confessorSex, this.confessorNick, this.isSysMsg, this.topic, this.confessTime) : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "[topicId" + ContainerUtils.KEY_VALUE_DELIMITER + this.topicId + " topic" + ContainerUtils.KEY_VALUE_DELIMITER + this.topic + " confessorUin" + ContainerUtils.KEY_VALUE_DELIMITER + this.confessorUin + " confessorNick" + ContainerUtils.KEY_VALUE_DELIMITER + this.confessorNick + " confessorSex" + ContainerUtils.KEY_VALUE_DELIMITER + this.confessorSex + " confessTime" + ContainerUtils.KEY_VALUE_DELIMITER + this.confessTime + " isSysMsg" + ContainerUtils.KEY_VALUE_DELIMITER + this.isSysMsg + "]";
    }

    public static String toJsonStr(int i3, long j3, int i16, String str, int i17, String str2, long j16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_CONFESS_TOPICID, i3);
            jSONObject.put(KEY_CONFESSOR_UIN, j3);
            jSONObject.put(KEY_CONFESSOR_NICK, str);
            jSONObject.put(KEY_CONFESSOR_SEX, i16);
            jSONObject.put(KEY_CONFESS_SYSMSG, i17);
            jSONObject.put(KEY_CONFESS_DESC, str2);
            jSONObject.put(KEY_CONFESS_TIME, j16);
            return jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
