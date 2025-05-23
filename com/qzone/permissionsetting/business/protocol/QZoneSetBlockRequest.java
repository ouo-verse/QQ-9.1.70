package com.qzone.permissionsetting.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_setblack_req;
import NS_MOBILE_MAIN_PAGE.s_black;
import NS_MOBILE_MAIN_PAGE.s_user;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetBlockRequest extends QZoneRequest {
    public static final int ACTION_ADD = 1;
    public static final int ACTION_REMOVE = 0;
    public static final int ACTION_SET = 2;
    private static final String CMD_STRING = "setBlack";

    public QZoneSetBlockRequest(int i3, long j3, long... jArr) {
        super(CMD_STRING);
        s_black s_blackVar = new s_black();
        ArrayList<s_user> generateUserList = generateUserList(jArr);
        s_blackVar.datalist = generateUserList;
        s_blackVar.allnum = generateUserList == null ? 0 : generateUserList.size();
        mobile_sub_setblack_req mobile_sub_setblack_reqVar = new mobile_sub_setblack_req();
        mobile_sub_setblack_reqVar.action = i3;
        mobile_sub_setblack_reqVar.black = s_blackVar;
        this.req = mobile_sub_setblack_reqVar;
    }

    private static ArrayList<s_user> generateUserList(long... jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList<s_user> arrayList = new ArrayList<>();
        for (long j3 : jArr) {
            s_user s_userVar = new s_user();
            s_userVar.uin = j3;
            arrayList.add(s_userVar);
        }
        return arrayList;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    private static ArrayList<s_user> generateUserList(Collection<Long> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList<s_user> arrayList = new ArrayList<>();
        for (Long l3 : collection) {
            if (l3 != null) {
                s_user s_userVar = new s_user();
                s_userVar.uin = l3.longValue();
                arrayList.add(s_userVar);
            }
        }
        return arrayList;
    }

    public QZoneSetBlockRequest(int i3, long j3, Collection<Long> collection) {
        super(CMD_STRING);
        s_black s_blackVar = new s_black();
        ArrayList<s_user> generateUserList = generateUserList(collection);
        s_blackVar.datalist = generateUserList;
        s_blackVar.allnum = generateUserList == null ? 0 : generateUserList.size();
        mobile_sub_setblack_req mobile_sub_setblack_reqVar = new mobile_sub_setblack_req();
        mobile_sub_setblack_reqVar.action = i3;
        mobile_sub_setblack_reqVar.black = s_blackVar;
        this.req = mobile_sub_setblack_reqVar;
    }
}
