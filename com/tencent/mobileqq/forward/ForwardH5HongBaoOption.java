package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardH5HongBaoOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f210666d;

    /* renamed from: e, reason: collision with root package name */
    private List<Integer> f210667e;

    /* renamed from: f, reason: collision with root package name */
    private String f210668f;

    /* renamed from: h, reason: collision with root package name */
    private String f210669h;

    /* renamed from: i, reason: collision with root package name */
    private String f210670i;

    /* renamed from: m, reason: collision with root package name */
    private int f210671m;

    public ForwardH5HongBaoOption(Intent intent) {
        super(intent);
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210667e = new ArrayList();
        this.f210669h = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("extra_data"));
            this.f210666d = jSONObject;
            String optString = jSONObject.optString("userId");
            this.f210671m = this.f210666d.optInt("skin_id", -1);
            if (!TextUtils.isEmpty(optString) && (qQAppInterface = this.app) != null && !optString.equals(qQAppInterface.getCurrentAccountUin())) {
                Intent intent2 = new Intent();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret_code", "-1");
                jSONObject2.put("ret_msg", "parameter error!");
                intent2.putExtra("result", jSONObject2.toString());
                this.mActivity.setResult(-1, intent2);
                this.mActivity.finish();
                return;
            }
            String str = "";
            String optString2 = this.f210666d.optString("hb_from_type");
            JSONObject optJSONObject = this.f210666d.optJSONObject("selector");
            if (optString2.equals("100")) {
                if (optJSONObject != null) {
                    str = optJSONObject.optString("friend_type");
                    this.f210669h = optJSONObject.optString("title");
                }
            } else {
                JSONObject optJSONObject2 = this.f210666d.optJSONObject("extra_info");
                if (optJSONObject2 != null) {
                    str = optJSONObject2.optString("friend_type");
                    this.f210669h = optJSONObject2.optString("title");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("\\|")) {
                    try {
                        this.f210667e.add(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mForwardAbilities.addAll(this.f210667e);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null) {
                if (this.f210667e.contains(e.O3) && recentUser.getType() == 0) {
                    arrayList.add(recentUser);
                }
                if (this.f210667e.contains(e.P3) && recentUser.getType() == 1) {
                    arrayList.add(recentUser);
                }
                if (this.f210667e.contains(e.Q3) && recentUser.getType() == 3000) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (TextUtils.isEmpty(this.f210669h)) {
            return super.getTitle();
        }
        return this.f210669h;
    }

    @Override // com.tencent.mobileqq.forward.a
    public boolean isInterceptForwardDialog(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) resultRecord)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isNeedShowToast(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        String stringExtra = intent.getStringExtra("result");
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardH5HongBaoOption", 2, "onActivityResult = " + stringExtra);
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1) != 0) {
                this.mActivity.setResult(-1, intent);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put("chat_type", this.f210668f);
            optJSONObject.put("uin", this.f210670i);
            jSONObject.put("data", optJSONObject);
            intent.putExtra("result", jSONObject.toString());
            this.mActivity.setResult(-1, intent);
            this.mActivity.finish();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.forward.a
    public void onListViewItemClicked(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) resultRecord);
            return;
        }
        try {
            int uinType = resultRecord.getUinType();
            String str = resultRecord.uin;
            if (uinType != 0) {
                if (uinType != 1) {
                    if (uinType == 3000) {
                        this.f210668f = "discuss";
                        this.f210666d.put("group_id", str);
                        this.f210666d.put("recv_type", 2);
                    }
                } else {
                    this.f210668f = VipFunCallConstants.KEY_GROUP;
                    this.f210666d.put("group_id", str);
                    this.f210666d.put("recv_type", 3);
                }
            } else {
                this.f210668f = "c2c";
                this.f210666d.put("recv_type", 1);
            }
            JSONObject jSONObject = this.f210666d;
            this.f210670i = str;
            jSONObject.put("recv_uin", str);
            this.f210666d.put("appid", String.valueOf(AppSetting.f()));
            this.f210666d.put("from_memo", this.app.getCurrentNickname());
            this.f210666d.put("userId", this.app.getCurrentAccountUin());
        } catch (Exception unused) {
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ForwardOption.ForwardH5HongBaoOption", 4, "extra_data = " + this.f210666d);
        }
        Intent intent = new Intent();
        intent.putExtra("come_from", 2);
        intent.putExtra("extra_data", this.f210666d.toString());
        int i3 = this.f210671m;
        if (i3 != -1) {
            intent.putExtra("skin_id", i3);
        }
        RouteUtils.startActivityForResult(this.mActivity, intent, "/qwallet/redpacket/sendhb", 20002);
    }
}
