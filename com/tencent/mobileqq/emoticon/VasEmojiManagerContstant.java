package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VasEmojiManagerContstant {
    static IPatchRedirector $redirector_ = null;
    public static final String PARAMS_DOWNLOAD_START = "vas_download_start";
    public static HashMap<String, MagicTip> sMagicTips;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sMagicTips = new HashMap<>();
        }
    }

    public VasEmojiManagerContstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void delete(String str) {
        VasUpdateUtil.safeDeleteFile(new File(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", getEpId(str))));
    }

    public static String getEpId(String str) {
        return str.substring(23, str.indexOf(46, 23));
    }

    public static String getSavePath(String str) {
        return MarketFaceConstants.H5MagicZipPath.replace("[epId]", getEpId(str));
    }

    public static void setMagicTips(JSONArray jSONArray) {
        HashMap<String, MagicTip> hashMap = new HashMap<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int length = jSONArray.length(); length >= 0; length--) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(length);
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.getString("id");
                        MagicTip magicTip = new MagicTip();
                        magicTip.leftText = jSONObject.getString("leftText");
                        magicTip.linkText = jSONObject.getString("linkText");
                        magicTip.type = jSONObject.getString("type");
                        hashMap.put(string, magicTip);
                    } catch (JSONException e16) {
                        QLog.e(IVasEmojiManager.TAG, 1, "setMagicTips: ", e16);
                    }
                }
            }
        }
        sMagicTips = hashMap;
    }
}
