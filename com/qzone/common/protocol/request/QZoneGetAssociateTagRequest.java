package com.qzone.common.protocol.request;

import NS_MOBILE_TAGS.GetSugTagsReq;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetAssociateTagRequest extends QZoneRequest {
    private static final String CMD_STRING = "tag.GetSugWords";
    private static final String CMD_SUFFIX_STRING = "GetSugWords";
    public boolean mIsLoadMore;
    public String mQueryText;

    public QZoneGetAssociateTagRequest(String str, boolean z16) {
        super(CMD_STRING);
        this.mIsLoadMore = z16;
        this.mQueryText = str;
        GetSugTagsReq getSugTagsReq = new GetSugTagsReq();
        getSugTagsReq.inputTag = str;
        this.req = getSugTagsReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_SUFFIX_STRING;
    }
}
