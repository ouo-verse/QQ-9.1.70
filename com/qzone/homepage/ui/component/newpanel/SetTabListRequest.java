package com.qzone.homepage.ui.component.newpanel;

import NS_MOBILE_MAIN_PAGE.mobile_tablist_set_req;
import NS_MOBILE_MAIN_PAGE.s_tab_list;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SetTabListRequest extends QZoneRequest {
    private static final String CMD = "setTableList";
    private static final String UNI_KEY = "setTableList";

    public SetTabListRequest(long j3, s_tab_list s_tab_listVar) {
        super("setTableList");
        this.req = new mobile_tablist_set_req(j3, s_tab_listVar, true);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "setTableList";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "setTableList";
    }
}
