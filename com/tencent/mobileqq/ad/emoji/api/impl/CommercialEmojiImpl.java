package com.tencent.mobileqq.ad.emoji.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ad.emoji.a;
import com.tencent.mobileqq.ad.emoji.api.ICommercialEmoji;
import com.tencent.mobileqq.ad.emoji.b;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CommercialEmojiImpl implements ICommercialEmoji {
    static IPatchRedirector $redirector_ = null;
    private static final String JUMP_TYPE_H5 = "0";
    private static final String JUMP_TYPE_QQ_MINI_APP = "1";
    private static final String KEY_EMOJI_DESC = "emoji_desc";
    private static final String KEY_EMOJI_ICON = "emoji_icon";
    private static final String KEY_EMOJI_JUMP_TYPE = "emoji_jump_type";
    private static final String KEY_EMOJI_JUMP_URL = "emoji_jump_url";
    private static final String KEY_EMOJI_NAME = "emoji_name";
    private static final String TAG = "CommercialEmojiImpl";
    private a mConfigData;

    public CommercialEmojiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Context getContext() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private JSONObject getEmojiItemJson(String str) {
        a aVar = this.mConfigData;
        if (aVar == null) {
            return null;
        }
        return aVar.a().optJSONObject(str);
    }

    @Override // com.tencent.mobileqq.ad.emoji.api.ICommercialEmoji
    public b getEmojiItem(String str) {
        JSONObject emojiItemJson;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (this.mConfigData == null || (emojiItemJson = getEmojiItemJson(str)) == null) {
            return null;
        }
        b bVar = new b();
        bVar.i(emojiItemJson.optString(KEY_EMOJI_ICON));
        bVar.m(emojiItemJson.optString(KEY_EMOJI_NAME));
        bVar.h(emojiItemJson.optString(KEY_EMOJI_DESC));
        bVar.k(emojiItemJson.optString(KEY_EMOJI_JUMP_URL));
        bVar.j(emojiItemJson.optString(KEY_EMOJI_JUMP_TYPE));
        return bVar;
    }

    @Override // com.tencent.mobileqq.ad.emoji.api.ICommercialEmoji
    public void handleClick(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (getContext() != null && !TextUtils.isEmpty(str)) {
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                QLog.d(TAG, 1, "handleClick miniapp");
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), str, 2016, null);
                return;
            }
            QLog.d(TAG, 1, "handleClick h5");
            Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.addFlags(268435456);
            getContext().startActivity(intent);
            return;
        }
        QLog.e(TAG, 1, "handleClick error: null");
    }

    @Override // com.tencent.mobileqq.ad.emoji.api.ICommercialEmoji
    public boolean isEmojiPkgIdValid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101228");
        this.mConfigData = aVar;
        if (aVar == null || getEmojiItemJson(str) == null) {
            return false;
        }
        return true;
    }
}
