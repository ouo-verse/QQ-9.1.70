package com.tencent.mobileqq.minigame.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.minigame.api.IMiniGameHippyApi;
import com.tencent.mobileqq.minihippy.MiniHippyFragment;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameHippyApiImpl implements IMiniGameHippyApi {
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_BUSINESS_ID = "businessId";
    public static final String KEY_URL = "url";
    public static final String MQQ_API_GUILD_OPEN_FEED_GALLERY = "mqqapi://guild/openFeedGallery";
    public static final String MQQ_GUILD_GUILD_OPEN_FEEDD_ETAIL = "mqqguild://guild/openfeeddetail";
    public static final String MQQ_GUILD_GUILD_OPEN_FEED_EDITOR = "mqqguild://guild/openfeededitor";

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameHippyApi
    public boolean isMiniGameHandled(QBaseFragment qBaseFragment, String str, String str2) {
        if (!(qBaseFragment instanceof MiniHippyFragment)) {
            return false;
        }
        if (!str.startsWith(MQQ_GUILD_GUILD_OPEN_FEED_EDITOR) && !str.startsWith(MQQ_GUILD_GUILD_OPEN_FEEDD_ETAIL) && !str.startsWith(MQQ_API_GUILD_OPEN_FEED_GALLERY)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("appId", ((MiniHippyFragment) qBaseFragment).getAppId());
        intent.putExtra("businessId", str2);
        QPublicFragmentActivity.b.b(qBaseFragment.getActivity(), intent, QPublicTransFragmentActivity.class, HippyJumpGuildFragment.class);
        return true;
    }
}
