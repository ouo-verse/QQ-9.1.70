package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f185503c;

    /* renamed from: a, reason: collision with root package name */
    public RecentUser f185504a;

    @SerializedName("game_appid")
    public String appid;

    /* renamed from: b, reason: collision with root package name */
    public MessageRecord f185505b;

    @SerializedName("is_red")
    public boolean redDot;

    @SerializedName("text")
    public String summary;

    @SerializedName("time")
    public long time;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f185503c = null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185504a = null;
            this.f185505b = null;
        }
    }

    public static a a() {
        return f185503c;
    }

    public static void b(JSONObject jSONObject) {
        f185503c = (a) new Gson().fromJson(jSONObject.toString(), a.class);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f185504a = null;
        this.f185505b = null;
        f185503c = null;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "GameBoxAuthMsgData: summary = " + this.summary + ", redDot = " + this.redDot + ", time = " + this.time + ", appid = " + this.appid;
    }
}
