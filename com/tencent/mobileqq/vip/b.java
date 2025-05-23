package com.tencent.mobileqq.vip;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.bugly.network.NetQualityPluginConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.VasEmojiManagerContstant;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.aiotip.api.impl.VasAioTipServiceImpl;
import com.tencent.mobileqq.vas.at;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f312916l;

    /* renamed from: m, reason: collision with root package name */
    private static b f312917m;

    /* renamed from: a, reason: collision with root package name */
    public MessageRecord f312918a;

    /* renamed from: b, reason: collision with root package name */
    public int f312919b;

    /* renamed from: c, reason: collision with root package name */
    public int f312920c;

    /* renamed from: d, reason: collision with root package name */
    public int f312921d;

    /* renamed from: e, reason: collision with root package name */
    public long f312922e;

    /* renamed from: f, reason: collision with root package name */
    public long f312923f;

    /* renamed from: g, reason: collision with root package name */
    public long f312924g;

    /* renamed from: h, reason: collision with root package name */
    public long f312925h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f312926i;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f312927j;

    /* renamed from: k, reason: collision with root package name */
    public Map<String, Boolean> f312928k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f312916l = new String[]{HardCodeUtil.qqStr(R.string.f212955ox), HardCodeUtil.qqStr(R.string.f212915ot), HardCodeUtil.qqStr(R.string.f212935ov), HardCodeUtil.qqStr(R.string.f212965oy), HardCodeUtil.qqStr(R.string.f212945ow), HardCodeUtil.qqStr(R.string.f212925ou), HardCodeUtil.qqStr(R.string.f212905os)};
        EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT = 5000;
        EmojiManagerServiceConstant.EMOTION_TRY_DOWNLOAD = true;
        PendantConstant.BULK_GET_STRANGER_MIN_INTERVAL = 4000;
        com.tencent.mobileqq.model.a.f247239i = "\u901b\u901b";
        com.tencent.mobileqq.model.a.f247240j = "\u6b64\u8868\u60c5\u7684\u5468\u8fb9\u5546\u54c1";
        EmoticonRecDressup.setRecommendClearTime(86400L);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312919b = 1;
        this.f312920c = 1;
        this.f312921d = 1;
        this.f312922e = NetQualityPluginConfig.MAX_CALL_END_DELAY_IN_SEC;
        this.f312923f = 86400L;
        this.f312924g = 86400L;
        this.f312925h = 2000L;
        this.f312926i = new String[]{"\u5c0f\u7070\u6761", "\u8d85\u7ea7\u5c0f\u7070\u6761"};
        this.f312927j = new ArrayList();
        this.f312928k = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String[] strArr, String str, ChatMessage chatMessage, boolean z16, QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        int i3 = 0;
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                String[] strArr2 = this.f312926i;
                if (strArr2 != null && strArr2.length > 0) {
                    while (true) {
                        String[] strArr3 = this.f312926i;
                        if (i3 >= strArr3.length) {
                            break;
                        }
                        String str3 = strArr3[i3];
                        if (!TextUtils.isEmpty(str3) && str.contains(str3)) {
                            QLog.d("AioVipKeywordHelper", 4, "detected Keyword but contain dirty word, keyword=" + str2 + ", dirty word=" + str3);
                            return;
                        }
                        i3++;
                    }
                }
                this.f312918a = chatMessage;
                QLog.d("AioVipKeywordHelper", 4, "detected Keyword, keyword=" + str2);
                ((VIPAioSendHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER)).D2(sessionInfo.f179557e, sessionInfo.f179555d, str2, z16);
                r(qQAppInterface, sessionInfo, str2);
                return;
            }
        }
    }

    public static b c() {
        if (f312917m == null) {
            synchronized (b.class) {
                if (f312917m == null) {
                    f312917m = new b();
                }
            }
        }
        return f312917m;
    }

    private static boolean e(String str) {
        if (str != null && str.length() > 2) {
            return true;
        }
        return false;
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("aioVIPGrayTips");
        if (optJSONObject != null) {
            this.f312919b = optJSONObject.optInt("c2cEnable", 1);
            this.f312920c = optJSONObject.optInt("groupEnable", 1);
            this.f312921d = optJSONObject.optInt("discussGroupEnable", 1);
            this.f312922e = optJSONObject.optLong("c2cFreq", 86400L);
            this.f312923f = optJSONObject.optLong("groupFreq", 86400L);
            this.f312924g = optJSONObject.optLong("discussGroupFreq", 86400L);
            this.f312925h = optJSONObject.optLong("fetchWordingTolerateTime", 2000L);
            String optString = optJSONObject.optString("dirtyWords");
            if (!TextUtils.isEmpty(optString)) {
                ArrayList arrayList = new ArrayList();
                for (String str : optString.split(";")) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str.trim().toLowerCase());
                    }
                }
                this.f312926i = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            String optString2 = optJSONObject.optString("groupGrayTail");
            if (!TextUtils.isEmpty(optString2)) {
                this.f312927j = new ArrayList();
                for (String str2 : optString2.split(";")) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.f312927j.add(str2.trim().toLowerCase());
                    }
                }
            }
        }
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("downloadTimeoutConfig");
        if (optJSONObject != null) {
            EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT = optJSONObject.optInt("emotion", EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT);
            boolean z16 = false;
            if (optJSONObject.optInt("emoTryReadNoLen", 0) == 1) {
                z16 = true;
            }
            EmojiManagerServiceConstant.EMOTION_TRY_DOWNLOAD = z16;
            QLog.d("AioVipKeywordHelper", 1, "downloadTimeoutConfig is " + optJSONObject.toString());
        }
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("getStrangerInterval");
        if (optJSONObject != null) {
            PendantConstant.BULK_GET_STRANGER_MIN_INTERVAL = optJSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 5000);
            QLog.d("AioVipKeywordHelper", 1, "getStrangerInterval is " + PendantConstant.BULK_GET_STRANGER_MIN_INTERVAL);
        }
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ipProductGrayTips");
        if (optJSONObject != null) {
            com.tencent.mobileqq.model.a.f247239i = optJSONObject.optString("leftText", com.tencent.mobileqq.model.a.f247239i);
            com.tencent.mobileqq.model.a.f247240j = optJSONObject.optString("linkText", com.tencent.mobileqq.model.a.f247240j);
            QLog.d("AioVipKeywordHelper", 2, "ipProductGrayTips: " + optJSONObject.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("recommendConfig");
        if (optJSONObject != null) {
            EmoticonRecDressup.setRecommendClearTime(optJSONObject.optLong(WidgetCacheConstellationData.INTERVAL, 86400L));
        }
    }

    private void o(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("shareDomainConfig");
        if (optJSONArray != null) {
            at.a().c(optJSONArray);
        }
    }

    private void p(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("tmsDualCoreConfig");
        if (optJSONObject != null) {
            QLog.d("KC.TMSManager", 1, "tms DPC : " + optJSONObject.toString());
        }
    }

    public String d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    return "";
                }
                return "2";
            }
            return "1";
        }
        return "0";
    }

    public boolean f(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) sessionInfo)).booleanValue();
        }
        return g(qQAppInterface.getCurrentAccountUin(), sessionInfo.f179555d, sessionInfo.f179557e);
    }

    public boolean g(String str, int i3, String str2) {
        int i16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin is empty, need not detect keyword.");
            return false;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return false;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    j3 = 86400;
                    i16 = 0;
                } else {
                    i16 = this.f312921d;
                    j3 = this.f312924g;
                }
            } else {
                i16 = this.f312920c;
                j3 = this.f312923f;
            }
        } else {
            i16 = this.f312919b;
            j3 = this.f312922e;
        }
        if (i16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function is closed.");
            }
            return false;
        }
        if (System.currentTimeMillis() - VasMMKV.getCommon(str).decodeLong(VasAioTipServiceImpl.KEY_LAST_SHOW_GRAY_TIPS_TIME + i3 + "_" + str2, 0L) >= 1000 * j3) {
            return true;
        }
        QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function frequency = " + j3 + "s, so need not detect keyword.");
        return false;
    }

    public void i(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        boolean z16 = true;
        JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_PERSONAL_CONFIG, true, null);
        if (jSONFromLocal == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AioVipKeywordHelper", 2, "parsejson file not exists");
                return;
            }
            return;
        }
        JSONObject optJSONObject = jSONFromLocal.optJSONObject("isChooseStyleClosed");
        if (optJSONObject != null) {
            if (optJSONObject.optInt("isChooseStyleClosed", 0) != 1) {
                z16 = false;
            }
            VipProfileCardPhotoHandlerActivity.f260082e0 = z16;
        }
        h(jSONFromLocal);
        n(jSONFromLocal);
        l(jSONFromLocal);
        k(jSONFromLocal);
        j(jSONFromLocal);
        p(jSONFromLocal);
        o(jSONFromLocal);
        VasEmojiManagerContstant.setMagicTips(jSONFromLocal.optJSONArray("h5MagicTips"));
    }

    public void m(Context context, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir(), "vipKerwordJson");
        if (file.exists()) {
            str2 = FileUtils.readFileContent(file);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        i(BaseApplicationImpl.getApplication().getRuntime());
    }

    public void q(QQAppInterface qQAppInterface, int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qQAppInterface, Integer.valueOf(i3), str, Long.valueOf(j3));
            return;
        }
        VasMMKV.getCommon(qQAppInterface.getCurrentAccountUin()).encodeLong(VasAioTipServiceImpl.KEY_LAST_SHOW_GRAY_TIPS_TIME + i3 + "_" + str, j3);
    }

    public synchronized void r(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQAppInterface, sessionInfo, str);
            return;
        }
        if (this.f312918a != null) {
            String str3 = sessionInfo.f179557e;
            if (e(str3)) {
                q(qQAppInterface, sessionInfo.f179555d, str3, System.currentTimeMillis());
                if (this.f312918a.isSend()) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                VasWebviewUtil.reportVipKeywords(str, str2, "0", d(sessionInfo.f179555d), str3, "", "", "", "", "");
            }
            this.f312918a = null;
        }
    }
}
