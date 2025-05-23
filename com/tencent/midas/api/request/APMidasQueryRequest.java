package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APMidasQueryRequest extends APMidasBaseRequest {
    public static String NET_REQ_TRANSACTION = "transaction";
    public String beginTime;
    public String cmdCode;
    public String crossApp;
    public String endTime;
    public String isRetTotalCnt;
    public String orderBy;
    public String pageNum;
    public String pageSize;
    public String searchType;
    public String subCmdCode;
    public String type;

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getCmdCode() {
        return this.cmdCode;
    }

    public String getCrossApp() {
        return this.crossApp;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getIsRetTotalCnt() {
        return this.isRetTotalCnt;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public String getSearchType() {
        return this.searchType;
    }

    public String getSubCmdCode() {
        return this.subCmdCode;
    }

    public String getType() {
        return this.type;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setCmdCode(String str) {
        this.cmdCode = str;
    }

    public void setCrossApp(String str) {
        this.crossApp = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setIsRetTotalCnt(String str) {
        this.isRetTotalCnt = str;
    }

    public void setOrderBy(String str) {
        this.orderBy = str;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public void setSearchType(String str) {
        this.searchType = str;
    }

    public void setSubCmdCode(String str) {
        this.subCmdCode = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
