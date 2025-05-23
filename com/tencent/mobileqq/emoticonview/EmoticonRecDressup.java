package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonRecDressup {
    static IPatchRedirector $redirector_ = null;
    private static final String EMOSM_SP_RECOMMEND = "emosm_sp_is_recommend";
    private static final long RECOMMEND_CLEAR_TIME = 2592000000L;
    public static long RECOMMEND_EXPIRED_TIME = 0;
    private static final String TAG = "EmoticonRecDressup";
    public int authorId;
    public boolean hasRecommendDressup;
    public long lastLookupTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            RECOMMEND_EXPIRED_TIME = 86400000L;
        }
    }

    public EmoticonRecDressup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static EmoticonRecDressup getEmotionRecommend(String str, boolean z16) {
        String string = BaseApplication.getContext().getSharedPreferences(EMOSM_SP_RECOMMEND, 4).getString(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount() + "_" + str, null);
        if (string != null) {
            try {
                return new EmoticonRecDressup().init(new JSONObject(string));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "getEmotionRecommend failed", e16);
            }
        }
        if (!z16) {
            return null;
        }
        EmoticonRecDressup emoticonRecDressup = new EmoticonRecDressup();
        emoticonRecDressup.hasRecommendDressup = true;
        return emoticonRecDressup;
    }

    private EmoticonRecDressup init(JSONObject jSONObject) {
        this.lastLookupTime = jSONObject.optLong("0");
        this.hasRecommendDressup = jSONObject.optBoolean("1");
        this.authorId = jSONObject.optInt("2");
        return this;
    }

    public static void setRecommendClearTime(long j3) {
        RECOMMEND_EXPIRED_TIME = j3 * 1000;
        QLog.i(TAG, 1, "EmotionPanelViewPagerAdapter.RECOMMEND_EXPIRED_TIME update to " + RECOMMEND_EXPIRED_TIME);
    }

    public void saveEmotionRecommend(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(EMOSM_SP_RECOMMEND, 4);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j3 = sharedPreferences.getLong(WadlProxyConsts.CREATE_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j3 > 2592000000L) {
            edit.clear();
            edit.putLong(WadlProxyConsts.CREATE_TIME, currentTimeMillis);
        }
        this.lastLookupTime = currentTimeMillis;
        edit.putString(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount() + "_" + i3, toString());
        edit.commit();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", this.lastLookupTime);
            jSONObject.put("1", this.hasRecommendDressup);
            jSONObject.put("2", this.authorId);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "toString failed", e16);
        }
        return jSONObject.toString();
    }
}
