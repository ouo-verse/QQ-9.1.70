package com.tencent.mobileqq;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class DrawerPushItem extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO = 2;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GAME_PANEL = 9;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GAME_RED = 3;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_GUIDE_3D = 10;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_HOT_CHAT_GAME = 5;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_PUSH = 7;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_REDDOT = 4;
    public static final int BUBBLE_PUSH_MSG_TYPE_AIO_PANEL_SHOP = 6;
    public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER = 1;
    public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER_0 = 0;
    public static final int BUBBLE_PUSH_MSG_TYPE_DRAWER_GAME_BOX = 8;
    public static final int BUBBLE_ROLE_TYPE_2D = 2;
    public static final int BUBBLE_ROLE_TYPE_3D = 3;
    public static final int BUBBLE_ROLE_TYPE_DEFAULT = 0;
    public String act_id;
    public int action_id;
    public int bubble_res_id;
    public int color;
    public String content;
    public int end_ts;
    public String ext_url;
    public boolean fromTianshu;
    public String icon_url;
    public int is_reddot;
    public int life_Time;

    @unique
    public String msg_id;
    public int msg_type;
    public int priority;
    public int reddotGameId;
    public String reddotPath;

    @notColumn
    public int reddotRedId;
    public String scheme;
    public int send_time;
    public int show_counts;
    public int show_sum;
    public int start_ts;
    public int sub_priority;
    public int target_model;
    public int tianshuAdId;
    public String tianshuTraceInfo;
    public String tips_str;

    public DrawerPushItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.start_ts < currentTimeMillis && this.end_ts > currentTimeMillis && this.show_sum < this.show_counts) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("DrawerPushItem{");
        stringBuffer.append("msg_id='");
        stringBuffer.append(this.msg_id);
        stringBuffer.append('\'');
        stringBuffer.append(", priority=");
        stringBuffer.append(this.priority);
        stringBuffer.append(", sub_priority=");
        stringBuffer.append(this.sub_priority);
        stringBuffer.append(", start_ts=");
        stringBuffer.append(this.start_ts);
        stringBuffer.append(", end_ts=");
        stringBuffer.append(this.end_ts);
        stringBuffer.append(", send_time=");
        stringBuffer.append(this.send_time);
        stringBuffer.append(", action_id=");
        stringBuffer.append(this.action_id);
        stringBuffer.append(", content='");
        stringBuffer.append(this.content);
        stringBuffer.append('\'');
        stringBuffer.append(", scheme='");
        stringBuffer.append(this.scheme);
        stringBuffer.append('\'');
        stringBuffer.append(", ext_url='");
        stringBuffer.append(this.ext_url);
        stringBuffer.append('\'');
        stringBuffer.append(", color=");
        stringBuffer.append(this.color);
        stringBuffer.append(", show_counts=");
        stringBuffer.append(this.show_counts);
        stringBuffer.append(", show_sum=");
        stringBuffer.append(this.show_sum);
        stringBuffer.append(", life_Time=");
        stringBuffer.append(this.life_Time);
        stringBuffer.append(", is_reddot=");
        stringBuffer.append(this.is_reddot);
        stringBuffer.append(", bubble_res_id=");
        stringBuffer.append(this.bubble_res_id);
        stringBuffer.append(", icon_url='");
        stringBuffer.append(this.icon_url);
        stringBuffer.append('\'');
        stringBuffer.append(", msg_type=");
        stringBuffer.append(this.msg_type);
        stringBuffer.append(", act_id='");
        stringBuffer.append(this.act_id);
        stringBuffer.append('\'');
        stringBuffer.append(", tips_str='");
        stringBuffer.append(this.tips_str);
        stringBuffer.append('\'');
        stringBuffer.append(", target_model=");
        stringBuffer.append(this.target_model);
        stringBuffer.append(", fromTianshu=");
        stringBuffer.append(this.fromTianshu);
        stringBuffer.append(", tianshuAdId=");
        stringBuffer.append(this.tianshuAdId);
        stringBuffer.append(", tianshuTraceInfo='");
        stringBuffer.append(this.tianshuTraceInfo);
        stringBuffer.append('\'');
        stringBuffer.append(", reddotPath='");
        stringBuffer.append(this.reddotPath);
        stringBuffer.append('\'');
        stringBuffer.append(", reddotGameId=");
        stringBuffer.append(this.reddotGameId);
        stringBuffer.append(", reddotRedId=");
        stringBuffer.append(this.reddotRedId);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
