package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchReqBody {
    public boolean disableCorrectionQuery;
    public boolean firstPage;
    public boolean usePbSerialization;
    public String keyWord = "";
    public String version = "";
    public SearchTabInfo tabs = new SearchTabInfo();
    public byte[] sessionInfo = new byte[0];
    public SearchDeviceInfo deviceInfo = new SearchDeviceInfo();
    public SearchGroupConditonFilter groupConditionFilter = new SearchGroupConditonFilter();
    public String lbs = "";
    public SearchChannelConditonFilter channelConditionFilter = new SearchChannelConditonFilter();
    public byte[] busiSessionInfo = new byte[0];
    public SearchMiniAppConditonFilter miniAppConditionFilter = new SearchMiniAppConditonFilter();
    public byte[] bytesExtension = new byte[0];

    public byte[] getBusiSessionInfo() {
        return this.busiSessionInfo;
    }

    public byte[] getBytesExtension() {
        return this.bytesExtension;
    }

    public SearchChannelConditonFilter getChannelConditionFilter() {
        return this.channelConditionFilter;
    }

    public SearchDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public boolean getDisableCorrectionQuery() {
        return this.disableCorrectionQuery;
    }

    public boolean getFirstPage() {
        return this.firstPage;
    }

    public SearchGroupConditonFilter getGroupConditionFilter() {
        return this.groupConditionFilter;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public String getLbs() {
        return this.lbs;
    }

    public SearchMiniAppConditonFilter getMiniAppConditionFilter() {
        return this.miniAppConditionFilter;
    }

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public SearchTabInfo getTabs() {
        return this.tabs;
    }

    public boolean getUsePbSerialization() {
        return this.usePbSerialization;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "SearchReqBody{keyWord=" + this.keyWord + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",tabs=" + this.tabs + ",sessionInfo=" + this.sessionInfo + ",firstPage=" + this.firstPage + ",deviceInfo=" + this.deviceInfo + ",groupConditionFilter=" + this.groupConditionFilter + ",lbs=" + this.lbs + ",channelConditionFilter=" + this.channelConditionFilter + ",busiSessionInfo=" + this.busiSessionInfo + ",disableCorrectionQuery=" + this.disableCorrectionQuery + ",usePbSerialization=" + this.usePbSerialization + ",miniAppConditionFilter=" + this.miniAppConditionFilter + ",bytesExtension=" + this.bytesExtension + ",}";
    }
}
