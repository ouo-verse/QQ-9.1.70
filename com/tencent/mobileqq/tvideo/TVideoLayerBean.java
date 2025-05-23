package com.tencent.mobileqq.tvideo;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoLayerBean extends QCircleLayerBean {
    private Map<String, String> businessReport;
    private String hippyBundleName;
    private HashMap<String, String> hippyExtraParams;
    private String msgType;
    private String notifyExt;
    private int pageType = 1;
    private String startType = "0";
    private String urlAction;

    public Map<String, String> getBusinessReport() {
        return this.businessReport;
    }

    public Map<String, String> getBusinessReportMap() {
        return this.businessReport;
    }

    public String getHippyBundleName() {
        return this.hippyBundleName;
    }

    public HashMap<String, String> getHippyExtraParams() {
        return this.hippyExtraParams;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getNotifyExt() {
        return this.notifyExt;
    }

    @TVideoLaunchBean$TargetPageType
    public int getPageType() {
        return this.pageType;
    }

    public String getStartType() {
        return this.startType;
    }

    public String getUrlAction() {
        return this.urlAction;
    }

    public boolean isDetailFeedsPage() {
        if (this.pageType == 2) {
            return true;
        }
        return false;
    }

    public boolean isLaunchH5Page() {
        if (!TextUtils.isEmpty(this.urlAction) && "1".equals(this.startType)) {
            return true;
        }
        return false;
    }

    public boolean isLaunchHippyPage() {
        return "2".equals(this.startType);
    }

    public boolean isMultiTabPage() {
        if (this.pageType == 1) {
            return true;
        }
        return false;
    }

    public void setBusinessReport(Map<String, String> map) {
        this.businessReport = map;
    }

    public void setBusinessReportMap(Map<String, String> map) {
        this.businessReport = map;
    }

    public void setHippyBundleName(String str) {
        this.hippyBundleName = str;
    }

    public void setHippyExtraParams(HashMap<String, String> hashMap) {
        this.hippyExtraParams = hashMap;
    }

    public void setIsDetailFeedsPage(boolean z16) {
        if (z16) {
            this.pageType = 2;
        }
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setNotifyExt(String str) {
        this.notifyExt = str;
    }

    public void setPageType(int i3) {
        this.pageType = i3;
    }

    public void setStartType(String str) {
        this.startType = str;
    }

    public void setUrlAction(String str) {
        this.urlAction = str;
    }
}
