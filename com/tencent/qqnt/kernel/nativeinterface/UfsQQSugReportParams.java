package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UfsQQSugReportParams {
    public int actionid;
    public int h5version;
    public int iscache;
    public long reqbusinesstype;
    public int scene;
    public int scenetype;
    public long timestampms;
    public String sessionid = "";
    public String searchid = "";
    public String suggestionid = "";
    public String requestid = "";
    public String iteminfo = "";
    public String docinfo = "";
    public String extinfo = "";
    public String query = "";
    public UfsUserAttr userAttr = new UfsUserAttr();

    public int getActionid() {
        return this.actionid;
    }

    public String getDocinfo() {
        return this.docinfo;
    }

    public String getExtinfo() {
        return this.extinfo;
    }

    public int getH5version() {
        return this.h5version;
    }

    public int getIscache() {
        return this.iscache;
    }

    public String getIteminfo() {
        return this.iteminfo;
    }

    public String getQuery() {
        return this.query;
    }

    public long getReqbusinesstype() {
        return this.reqbusinesstype;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public int getScene() {
        return this.scene;
    }

    public int getScenetype() {
        return this.scenetype;
    }

    public String getSearchid() {
        return this.searchid;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public String getSuggestionid() {
        return this.suggestionid;
    }

    public long getTimestampms() {
        return this.timestampms;
    }

    public UfsUserAttr getUserAttr() {
        return this.userAttr;
    }

    public String toString() {
        return "UfsQQSugReportParams{sessionid=" + this.sessionid + ",searchid=" + this.searchid + ",suggestionid=" + this.suggestionid + ",requestid=" + this.requestid + ",timestampms=" + this.timestampms + ",actionid=" + this.actionid + ",iteminfo=" + this.iteminfo + ",docinfo=" + this.docinfo + ",h5version=" + this.h5version + ",scene=" + this.scene + ",reqbusinesstype=" + this.reqbusinesstype + ",scenetype=" + this.scenetype + ",extinfo=" + this.extinfo + ",iscache=" + this.iscache + ",query=" + this.query + ",userAttr=" + this.userAttr + ",}";
    }
}
