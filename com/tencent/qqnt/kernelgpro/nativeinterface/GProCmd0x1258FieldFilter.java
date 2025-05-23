package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0x1258FieldFilter {
    public int notCacheFilter;
    public GProFieldFilter guildInfoFilter = new GProFieldFilter();
    public GProCmd0xf5dFieldFilter channelInfoListFilter = new GProCmd0xf5dFieldFilter();
    public GProCmd0xf55Filter channelInfoFilter = new GProCmd0xf55Filter();
    public GProCmd0x1258ExtendFieldFilter extendInfoFilter = new GProCmd0x1258ExtendFieldFilter();

    public GProCmd0xf55Filter getChannelInfoFilter() {
        return this.channelInfoFilter;
    }

    public GProCmd0xf5dFieldFilter getChannelInfoListFilter() {
        return this.channelInfoListFilter;
    }

    public GProCmd0x1258ExtendFieldFilter getExtendInfoFilter() {
        return this.extendInfoFilter;
    }

    public GProFieldFilter getGuildInfoFilter() {
        return this.guildInfoFilter;
    }

    public int getNotCacheFilter() {
        return this.notCacheFilter;
    }

    public String toString() {
        return "GProCmd0x1258FieldFilter{guildInfoFilter=" + this.guildInfoFilter + ",channelInfoListFilter=" + this.channelInfoListFilter + ",channelInfoFilter=" + this.channelInfoFilter + ",extendInfoFilter=" + this.extendInfoFilter + ",notCacheFilter=" + this.notCacheFilter + ",}";
    }
}
