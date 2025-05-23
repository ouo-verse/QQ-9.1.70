package com.qzone.publish.business.protocol;

import NS_MOBILE_COMM.UgcRightInfo;
import NS_MOBILE_OPERATION.operation_publishmood_req;
import android.text.TextUtils;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.feed.utils.h;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZonePublishStickMoodRequest extends QZoneRequest {
    private static final String CMD_STRING = "FreelyStickOperation.publishStickMood";
    private static final String TAG = "QZonePublishStickMoodRequest";
    private static final String UNI_KEY_STRING = "publishStickMood";

    public QZonePublishStickMoodRequest() {
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
        return UNI_KEY_STRING;
    }

    public QZonePublishStickMoodRequest(String str, int i3, long j3, long j16, int i16, String str2, int i17, ArrayList<String> arrayList, Map<String, String> map) {
        super(CMD_STRING);
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, String.format("QZonePublishStickMoodRequest, context=%s mediaType=%s hostUin=%s publishUin=%s priv=%s priv_uin_list=%s stored_extend_info=%s", str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), arrayList, map));
        }
        operation_publishmood_req operation_publishmood_reqVar = new operation_publishmood_req();
        operation_publishmood_reqVar.uin = j3;
        operation_publishmood_reqVar.content = str;
        operation_publishmood_reqVar.mediatype = i3;
        operation_publishmood_reqVar.stored_extend_info = map;
        operation_publishmood_reqVar.srcid = str2;
        if (operation_publishmood_reqVar.busi_param == null) {
            HashMap hashMap = new HashMap();
            operation_publishmood_reqVar.busi_param = hashMap;
            hashMap.put(197, String.valueOf(j16));
        }
        UgcRightInfo ugcRightInfo = new UgcRightInfo();
        operation_publishmood_reqVar.right_info = ugcRightInfo;
        ugcRightInfo.ugc_right = i16;
        if (h.h(i16) && arrayList != null) {
            operation_publishmood_reqVar.right_info.allow_uins = new ArrayList<>();
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isDigitsOnly(next)) {
                        operation_publishmood_reqVar.right_info.allow_uins.add(Long.valueOf(next));
                    }
                }
            } catch (Throwable th5) {
                QZLog.w(TAG, "QZonePublishStickMoodRequest process right info warn!", th5);
            }
        }
        operation_publishmood_reqVar.modifyflag = i17;
        this.req = operation_publishmood_reqVar;
    }
}
