package com.qzone.permissionsetting.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_setspaceright_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetSpaceRightRequest extends QZoneRequest {
    private static final String CMD_STRING = "setspaceright";

    public QZoneSetSpaceRightRequest(long j3, int i3) {
        super(CMD_STRING);
        mobile_sub_setspaceright_req mobile_sub_setspaceright_reqVar = new mobile_sub_setspaceright_req();
        mobile_sub_setspaceright_reqVar.uin = j3;
        mobile_sub_setspaceright_reqVar.rightval = i3;
        this.req = mobile_sub_setspaceright_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneSetSpaceRightRequest(long j3, int i3, List<Integer> list, long j16) {
        super(CMD_STRING);
        mobile_sub_setspaceright_req mobile_sub_setspaceright_reqVar = new mobile_sub_setspaceright_req();
        mobile_sub_setspaceright_reqVar.uin = j3;
        mobile_sub_setspaceright_reqVar.rightval = i3;
        mobile_sub_setspaceright_reqVar.cur_seq = j16;
        if (list != null) {
            byte[] bArr = new byte[list.size()];
            for (int i16 = 0; i16 < list.size(); i16++) {
                bArr[i16] = (byte) list.get(i16).intValue();
            }
            mobile_sub_setspaceright_reqVar.allowGroupsId = bArr;
        }
        this.req = mobile_sub_setspaceright_reqVar;
    }
}
