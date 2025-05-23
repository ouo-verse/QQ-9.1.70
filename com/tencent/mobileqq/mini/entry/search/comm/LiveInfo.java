package com.tencent.mobileqq.mini.entry.search.comm;

import NS_STORE_APP_SEARCH.MiniAppSearch$StHotWatching;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LiveInfo implements ItemInfo {
    public String mHotWords;
    public String mJumpUrl;
    private int position;

    public LiveInfo(MiniAppSearch$StHotWatching miniAppSearch$StHotWatching) {
        this.mHotWords = miniAppSearch$StHotWatching.hotWords.get();
        this.mJumpUrl = miniAppSearch$StHotWatching.url.get();
    }

    public int getPosition() {
        return this.position;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.comm.ItemInfo
    public int getType() {
        return 3;
    }

    public void setPosition(int i3) {
        this.position = i3;
    }
}
