package com.tencent.qqnt.emotion.stickerrecommended.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.EmojiHomeUiPluginConstant;
import com.tencent.qqnt.emotion.ipc.b;
import com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService;
import com.tencent.qqnt.emotion.stickerrecommended.PromotionEmoticonPkg;

/* compiled from: P */
/* loaded from: classes24.dex */
public class RecommendEmotionServiceImpl implements IRecommendEmotionService<PromotionEmoticonPkg> {
    static IPatchRedirector $redirector_;

    public RecommendEmotionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService
    public void clearSpecWordType(com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService
    public String getSpecKeyWord(com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService
    public void onEmotionKeywordDimiss(com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService
    public void openEmoticonDetailPage(Context context, b bVar, PromotionEmoticonPkg promotionEmoticonPkg, int i3) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, bVar, promotionEmoticonPkg, Integer.valueOf(i3));
            return;
        }
        if (promotionEmoticonPkg.f356423e == 4) {
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
    }
}
