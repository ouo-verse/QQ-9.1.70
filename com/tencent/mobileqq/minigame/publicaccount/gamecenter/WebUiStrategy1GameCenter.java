package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.app.Activity;
import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WebUiStrategy1GameCenter {
    public void initView(final Activity activity, View view) {
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.rdm);
        uRLImageView.setVisibility(0);
        uRLImageView.setBackgroundURL(GameWnsUtils.getMiniGamePublicAccountGameStoreButtonUrl());
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy1GameCenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL), 4011, null);
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "click", null, null, null);
            }
        });
    }
}
