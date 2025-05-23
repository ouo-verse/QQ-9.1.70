package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes31.dex */
public final class NBPSharePanelViewAttr extends k {
    public final List<ShareItemData> bottomItems;
    public boolean showCopyLink = true;
    public boolean showShareNBPFeed;
    public final List<ShareItemData> topItems;

    public NBPSharePanelViewAttr() {
        List<ShareItemData> mutableListOf;
        List<ShareItemData> mutableListOf2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NBPSharePanelViewKt.ShareItemQQ, NBPSharePanelViewKt.ShareItemQQZone, NBPSharePanelViewKt.ShareItemWechat, NBPSharePanelViewKt.ShareItemWechatMoment, NBPSharePanelViewKt.ShareItemXhs);
        this.topItems = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(NBPSharePanelViewKt.ShareItemNBPFeed, NBPSharePanelViewKt.ShareItemSaveFile, NBPSharePanelViewKt.ShareItemCopyLink);
        this.bottomItems = mutableListOf2;
    }
}
