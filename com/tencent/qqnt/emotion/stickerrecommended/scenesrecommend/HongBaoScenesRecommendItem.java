package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class HongBaoScenesRecommendItem extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    int f356627b;

    public HongBaoScenesRecommendItem(c.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f356627b = 100;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c
    public void f(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject != null && jSONObject.has("moneylimit")) {
            try {
                this.f356627b = jSONObject.getInt("moneylimit");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.HongBaoScenesRecommendItem.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HongBaoScenesRecommendItem.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BaseApplication.getContext().getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).edit().putInt("HONGBAO_SCENES_MONEY_LIMIT", HongBaoScenesRecommendItem.this.f356627b).apply();
                }
            }
        }, 16, null, false);
    }
}
