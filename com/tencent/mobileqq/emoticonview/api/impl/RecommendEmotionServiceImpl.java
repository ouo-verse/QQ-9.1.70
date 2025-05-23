package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.helper.ac;
import com.tencent.mobileqq.activity.aio.w;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.EmojiHomeUiPluginConstant;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RecommendEmotionServiceImpl implements IRecommendEmotionService<PromotionEmoticonPkg> {
    static IPatchRedirector $redirector_;

    public RecommendEmotionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
    public void clearSpecWordType(a61.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            ((ac) bVar.b(41)).a();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
    public String getSpecKeyWord(a61.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
        return ((ac) bVar.b(41)).b();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
    public void onEmotionKeywordDimiss(a61.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            w.a("RecommendEmotionServiceImpl.onEmotionKeywordDimiss");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
    public void openEmoticonDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, PromotionEmoticonPkg promotionEmoticonPkg, int i3) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iEmoticonMainPanelApp, promotionEmoticonPkg, Integer.valueOf(i3));
            return;
        }
        if (promotionEmoticonPkg.type == 4) {
            intent = new Intent();
            intent.putExtra(EmojiHomeUiPluginConstant.EXTRA_KEY_IS_SMALL_EMOTICON, true);
        } else {
            intent = null;
        }
        if (i3 == 1) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(EmojiHomeUiPluginConstant.EXTRA_KEY_IS_KANDIAN_EMOTICON, true);
        }
        Intent intent2 = intent;
        if (context instanceof Activity) {
            EmojiHomeUiPlugin.openEmojiDetailPage(context, iEmoticonMainPanelApp, iEmoticonMainPanelApp.getAccount(), 8, promotionEmoticonPkg.f203111id, false, intent2, promotionEmoticonPkg.type == 4);
        } else {
            QLog.e("RecommendEmotionServiceImpl", 1, "openEmoticonDetailPage error : context not activity");
        }
    }
}
