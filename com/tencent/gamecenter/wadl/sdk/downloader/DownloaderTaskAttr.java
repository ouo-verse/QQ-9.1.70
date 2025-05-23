package com.tencent.gamecenter.wadl.sdk.downloader;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DownloaderTaskAttr {
    public static DownloaderTaskAttr DEFAULT_TASK_ATTR = new DownloaderTaskAttr();
    public DownloaderTaskCategory taskCategory = DownloaderTaskCategory.CATE_CUSTOM_MASS_1;
    public DownloaderTaskPriority priority = DownloaderTaskPriority.NORMAL;
    public boolean scheduleSwitch = false;
    public boolean multiSection = true;
    public boolean useDynamicSection = false;
    public short sectionDefPercent = 100;
    public short sectionMobilePercent = 0;
    public short sectionP2PPercent = 0;
    public long knownSize = -1;

    public boolean validSectionPercent() {
        short s16;
        short s17;
        short s18 = this.sectionDefPercent;
        if (s18 < 0 || (s16 = this.sectionMobilePercent) < 0 || (s17 = this.sectionP2PPercent) < 0 || s18 + s16 + s17 != 100) {
            return false;
        }
        return true;
    }
}
