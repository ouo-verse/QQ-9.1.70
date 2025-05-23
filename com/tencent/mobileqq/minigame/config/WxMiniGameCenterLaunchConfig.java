package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/WxMiniGameCenterLaunchConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", ZPlanPublishSource.FROM_SCHEME, "", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class WxMiniGameCenterLaunchConfig implements IConfigData {
    public static final String CONFIG_ID = "106187";
    public static final String DEFAULT_SCHEME = "mqqapi://kuikly/open?page_name=mini_game_home&version=1&src_type=web&bundle_name=mini_game&kr_turbo_display=1&kr_fast_json=1&module_type=7&rank_type=2&from=xl_xstj";
    private String scheme = "";

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheme = str;
    }
}
