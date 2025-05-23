package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFieldFilter {
    public GProGuildInfoFilter guildInfoFilter = new GProGuildInfoFilter();
    public GProCmdUinInfoFilter cmdUinInfoFilter = new GProCmdUinInfoFilter();

    public GProCmdUinInfoFilter getCmdUinInfoFilter() {
        return this.cmdUinInfoFilter;
    }

    public GProGuildInfoFilter getGuildInfoFilter() {
        return this.guildInfoFilter;
    }

    public String toString() {
        return "GProFieldFilter{guildInfoFilter=" + this.guildInfoFilter + ",cmdUinInfoFilter=" + this.cmdUinInfoFilter + ",}";
    }
}
