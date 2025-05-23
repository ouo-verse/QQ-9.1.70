package com.qzone.personalize;

import NS_MOBILE_CUSTOM.custom_list_switch_set_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCustomListSwitchSetRequest extends QZoneRequest {
    public static final String CMD_STRING = "setCustomListSwitch";

    public QZoneCustomListSwitchSetRequest(int i3, int i16, int i17, int i18, int i19, int i26, String str, int i27, int i28, int i29) {
        super(CMD_STRING);
        custom_list_switch_set_req custom_list_switch_set_reqVar = new custom_list_switch_set_req();
        custom_list_switch_set_reqVar.iSetItemBits = i3;
        custom_list_switch_set_reqVar.iFeedSkin = i16;
        custom_list_switch_set_reqVar.iFacade = i17;
        custom_list_switch_set_reqVar.iAvatar = i18;
        custom_list_switch_set_reqVar.iFloat = i19;
        custom_list_switch_set_reqVar.iCover = i26;
        custom_list_switch_set_reqVar.strTraceInfo = str;
        custom_list_switch_set_reqVar.iVisitorSkin = i27;
        custom_list_switch_set_reqVar.iCustomVip = i28;
        custom_list_switch_set_reqVar.iCustomNavi = i29;
        this.req = custom_list_switch_set_reqVar;
    }

    public static String getCmd() {
        return CMD_STRING;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.Custom.setCustomListSwitch";
    }

    public custom_list_switch_set_req getJceRequest() {
        return (custom_list_switch_set_req) this.req;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneCustomListSwitchSetRequest() {
    }
}
