package com.tencent.av.business.manager.filter;

import com.tencent.av.business.manager.pendant.c;
import com.tencent.smtt.sdk.TbsListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FilterItem extends c {
    private String desc;
    private String displayName;
    private String filterid;
    private int filtertype;
    private String iconmd5;
    private String iconurl;
    private String md5;
    private String name = "";
    private String newIcon;
    private int predownload;
    private String resurl;
    private boolean usable;

    @Override // com.tencent.av.business.manager.pendant.c
    public String getDesc() {
        return this.desc;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getFilterId() {
        return this.filterid;
    }

    public int getFiltertype() {
        return this.filtertype;
    }

    public String getIconMd5() {
        return this.iconmd5;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getIconUrl() {
        return this.iconurl;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getId() {
        return this.name;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getMd5() {
        return this.md5;
    }

    public String getNewIcon() {
        return this.newIcon;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public int getPlatform() {
        return TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION;
    }

    public int getPredownload() {
        return this.predownload;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getResUrl() {
        return this.resurl;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getVersion() {
        return "";
    }

    public boolean isEmptyFilter() {
        try {
            int intValue = Integer.valueOf(getFilterId()).intValue();
            if (intValue != -1 && intValue != 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public boolean isUsable() {
        return this.usable;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public void setUsable(boolean z16) {
        this.usable = z16;
    }

    public String toString() {
        return "filterid[" + this.filterid + "], desc[" + this.desc + "], name[" + this.name + "], isDownloading[" + this.isDownloading + "], filtertype[" + this.filtertype + "]";
    }
}
