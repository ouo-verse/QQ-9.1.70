package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

/* loaded from: classes37.dex */
public final class LoveWallPlantingGuildViewModel {
    public static final Companion Companion = new Companion();
    public static final List<String> animationUrls;

    /* loaded from: classes37.dex */
    public static final class Companion {
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/social_tree/guild/guild_tree_grow_v4.png");
        animationUrls = listOf;
    }

    public LoveWallPlantingGuildViewModel() {
        Iterator<String> it = animationUrls.iterator();
        while (it.hasNext()) {
            BridgeModule.preDownloadImage$default(QQBridgeApi.INSTANCE.getBridgeModule(), it.next());
        }
    }
}
