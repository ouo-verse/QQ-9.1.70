package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import tencent.im.confess.common.RedpointInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f202175a;

    /* renamed from: b, reason: collision with root package name */
    private String f202176b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f202177c;

    /* renamed from: d, reason: collision with root package name */
    public int f202178d;

    /* renamed from: e, reason: collision with root package name */
    public long f202179e;

    /* renamed from: f, reason: collision with root package name */
    public int f202180f;

    /* renamed from: g, reason: collision with root package name */
    public String f202181g;

    /* renamed from: h, reason: collision with root package name */
    public String f202182h;

    /* renamed from: i, reason: collision with root package name */
    public String f202183i;

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f202175a = null;
        this.f202177c = false;
        this.f202178d = 0;
        this.f202179e = 0L;
        this.f202180f = 0;
        this.f202181g = "";
        this.f202182h = "";
        this.f202183i = "";
        this.f202176b = str;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f202177c) {
            return;
        }
        this.f202177c = true;
        String string = ea.E(this.f202176b, AppConstants.Preferences.CONFESS_CONFIG_SP).getString("key_frd_rec_confess_info", "");
        this.f202175a = string;
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f202175a);
                if (jSONObject.has("nUnReadCnt")) {
                    this.f202178d = jSONObject.getInt("nUnReadCnt");
                }
                if (jSONObject.has("lLastMsgTime")) {
                    this.f202179e = jSONObject.getLong("lLastMsgTime");
                }
                if (jSONObject.has("nTopicId")) {
                    this.f202180f = jSONObject.getInt("nTopicId");
                }
                if (jSONObject.has("strTopicDesc")) {
                    this.f202183i = jSONObject.getString("strTopicDesc");
                }
                if (jSONObject.has("strFrdUin")) {
                    this.f202181g = jSONObject.getString("strFrdUin");
                }
                if (jSONObject.has("strFrdNick")) {
                    this.f202182h = jSONObject.getString("strFrdNick");
                }
            } catch (Exception unused) {
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("FrdConfessInfo", 4, String.format(Locale.getDefault(), "init strJsonStr: %s", this.f202175a));
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f202181g) && !TextUtils.isEmpty(this.f202183i)) {
            return true;
        }
        return false;
    }

    public void c(RedTouchItem redTouchItem) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) redTouchItem);
            return;
        }
        if (redTouchItem == null) {
            return;
        }
        if (redTouchItem.unReadFlag) {
            i3 = redTouchItem.count;
        } else {
            i3 = 0;
        }
        this.f202178d = i3;
        this.f202179e = redTouchItem.lastRecvTime;
        List<RedTouchItemExtMsg> list = redTouchItem.extMsgs;
        if (list != null && list.size() > 0) {
            RedTouchItemExtMsg redTouchItemExtMsg = null;
            int i16 = 0;
            for (RedTouchItemExtMsg redTouchItemExtMsg2 : redTouchItem.extMsgs) {
                int i17 = redTouchItemExtMsg2.time;
                if (i17 > i16) {
                    redTouchItemExtMsg = redTouchItemExtMsg2;
                    i16 = i17;
                }
            }
            try {
                RedpointInfo redpointInfo = new RedpointInfo();
                redpointInfo.mergeFrom(redTouchItemExtMsg.bytesData);
                if (redpointInfo.data.has()) {
                    JSONObject jSONObject = new JSONObject(redpointInfo.data.get());
                    if (jSONObject.has("topicId")) {
                        this.f202180f = jSONObject.getInt("topicId");
                    }
                    if (jSONObject.has("topicDesc")) {
                        this.f202183i = jSONObject.getString("topicDesc");
                    }
                    if (jSONObject.has("frdUin")) {
                        this.f202181g = String.valueOf(jSONObject.getLong("frdUin"));
                    }
                    if (jSONObject.has("frdNick")) {
                        this.f202182h = jSONObject.getString("frdNick");
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FrdConfessInfo", 2, e16, new Object[0]);
                }
            }
        }
        d();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nUnReadCnt", this.f202178d);
            jSONObject.put("lLastMsgTime", this.f202179e);
            jSONObject.put("nTopicId", this.f202180f);
            jSONObject.put("strTopicDesc", this.f202183i);
            jSONObject.put("strFrdUin", this.f202181g);
            jSONObject.put("strFrdNick", this.f202182h);
            this.f202175a = jSONObject.toString();
            ea.E(this.f202176b, AppConstants.Preferences.CONFESS_CONFIG_SP).edit().putString("key_frd_rec_confess_info", this.f202175a).apply();
        } catch (Exception unused) {
        }
        if (QLog.isColorLevel()) {
            QLog.e("FrdConfessInfo", 2, String.format(Locale.getDefault(), "updateJsonStr str: %s", this.f202175a));
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("{isInit = ");
        sb5.append(this.f202177c);
        sb5.append(", nUnReadCnt = ");
        sb5.append(this.f202178d);
        sb5.append(", lLastMsgTime = ");
        sb5.append(this.f202179e);
        sb5.append(", nTopicId = ");
        sb5.append(this.f202180f);
        sb5.append(", strTopicDesc = ");
        sb5.append(this.f202183i);
        sb5.append(", strFrdUin = ");
        sb5.append(this.f202181g);
        sb5.append(", strFrdNick = ");
        sb5.append(this.f202182h);
        sb5.append("}");
        return sb5.toString();
    }
}
