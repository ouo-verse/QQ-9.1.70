package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;

@ProxyService(proxy = KingCardProxy.class)
/* loaded from: classes23.dex */
public class KingCardProxyDefault implements KingCardProxy {
    public static final String KINGCARD_GUIDE_TEXT = WnsConfig.getConfig("qqminiapp", "kingcardGuideText", "");
    public static final String KINGCARD_GUIDE_ICON = WnsConfig.getConfig("qqminiapp", "kingcardGuideIcon", "");
    public static final String KINGCARD_GUIDE_DARK_LOTTIE = WnsConfig.getConfig("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
    public static final String KINGCARD_GUIDE_LOTTIE = WnsConfig.getConfig("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy
    public ImageView getCapsuleButtonMoreView(Context context) {
        return null;
    }

    protected String getKingCardText(Context context) {
        String str = KINGCARD_GUIDE_TEXT;
        if (TextUtils.isEmpty(str)) {
            return context.getResources().getString(R.string.mini_sdk_kingcard_tip);
        }
        return str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy
    public boolean showKingCardTips(IMiniAppContext iMiniAppContext, ImageView imageView) {
        return false;
    }
}
