package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes37.dex */
public final class PanelConfig {
    public final List<ShareItem> bottomItems;
    public final List<ShareItem> topItems;

    public PanelConfig(List<ShareItem> list, List<ShareItem> list2) {
        this.topItems = list;
        this.bottomItems = list2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PanelConfig() {
        this(r0, r1);
        List mutableListOf;
        List mutableListOf2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(SharePanelViewKt.ShareItemSendToQQ, SharePanelViewKt.ShareItemSendToQZone, SharePanelViewKt.ShareItemSendToWechatFriend, SharePanelViewKt.ShareItemSendToWechatCircle, SharePanelViewKt.ShareItemSendToXHS);
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(SharePanelViewKt.getShareItemSaveToMobile());
    }
}
