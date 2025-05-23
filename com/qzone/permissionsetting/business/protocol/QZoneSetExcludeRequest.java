package com.qzone.permissionsetting.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_setuncare_req;
import NS_MOBILE_MAIN_PAGE.s_uncare;
import NS_MOBILE_MAIN_PAGE.s_user;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetExcludeRequest extends QZoneRequest {
    public static final int ACTION_ADD = 1;
    public static final int ACTION_REMOVE = 0;
    public static final int ACTION_SET = 2;
    private static final String CMD_STRING = "setUncare";

    public QZoneSetExcludeRequest(int i3, long j3, long... jArr) {
        super(CMD_STRING);
        ArrayList<s_user> generateUserList = generateUserList(jArr);
        s_uncare s_uncareVar = new s_uncare();
        s_uncareVar.datalist = generateUserList;
        s_uncareVar.allnum = generateUserList == null ? 0 : generateUserList.size();
        mobile_sub_setuncare_req mobile_sub_setuncare_reqVar = new mobile_sub_setuncare_req();
        mobile_sub_setuncare_reqVar.action = i3;
        mobile_sub_setuncare_reqVar.uncare = s_uncareVar;
        this.req = mobile_sub_setuncare_reqVar;
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

    public QZoneSetExcludeRequest(int i3, long j3, Collection<Long> collection) {
        super(CMD_STRING);
        ArrayList<s_user> generateUserList = generateUserList(collection);
        s_uncare s_uncareVar = new s_uncare();
        s_uncareVar.datalist = generateUserList;
        s_uncareVar.allnum = generateUserList == null ? 0 : generateUserList.size();
        mobile_sub_setuncare_req mobile_sub_setuncare_reqVar = new mobile_sub_setuncare_req();
        mobile_sub_setuncare_reqVar.action = i3;
        mobile_sub_setuncare_reqVar.uncare = s_uncareVar;
        this.req = mobile_sub_setuncare_reqVar;
    }
}
