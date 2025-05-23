package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static ProfileTemplateBase a(Activity activity, @NonNull JSONObject jSONObject, ProfileCardInfo profileCardInfo, String str) throws JSONException {
        Card card;
        ProfileTemplateBase cVar;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            long j3 = card.lCurrentStyleId;
            if (j3 >= 0) {
                long optLong = jSONObject.optLong("id");
                if (optLong == j3) {
                    if (optLong == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE) {
                        cVar = new b(activity, jSONObject, profileCardInfo);
                    } else if (optLong == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE_2) {
                        cVar = new c(activity, jSONObject, profileCardInfo);
                    } else {
                        throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + optLong);
                    }
                    cVar.u(str);
                    return cVar;
                }
                throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + j3 + ") and json id(" + optLong + ") not match");
            }
            throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + j3);
        }
        throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
}
