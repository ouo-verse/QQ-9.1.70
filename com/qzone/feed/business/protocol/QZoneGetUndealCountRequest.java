package com.qzone.feed.business.protocol;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZonePlusSignInfoManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.util.QZoneLogTags;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetUndealCountRequest extends QZoneRequest {
    private static final String CMD_STRING = "getUndealCount";
    public static String TAG = QZoneLogTags.LOG_TAG_FEEDALERT + QZoneGetUndealCountRequest.class.getSimpleName();

    public QZoneGetUndealCountRequest(Map<Integer, count_info> map, String str, int i3) {
        super(CMD_STRING);
        mobile_count_req mobile_count_reqVar = new mobile_count_req();
        mobile_count_reqVar.mapLastGetTime = QZoneUnreadServletLogic.v(Long.valueOf(LoginData.getInstance().getUin()));
        mobile_count_reqVar.mapTimeStamp = ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getCTime(Long.valueOf(LoginData.getInstance().getUin()));
        mobile_count_reqVar.iRelationType = 1;
        mobile_count_reqVar.iVisitQZoneType = i3;
        mobile_count_reqVar.stMapCountInfo = map;
        mobile_count_reqVar.extendinfo = QZoneUnreadServletLogic.p(LoginData.getInstance().getUin());
        mobile_count_reqVar.lastUndealCountTime = str;
        mobile_count_reqVar.lastClickPlusButtonTime = QZonePlusSignInfoManager.b();
        if (TianshuRedTouch.INSTANCE.j()) {
            mobile_count_reqVar.reqMask = 1L;
        }
        this.req = mobile_count_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneGetUndealCountRequest(String str, boolean z16) {
        super(str, z16);
    }
}
