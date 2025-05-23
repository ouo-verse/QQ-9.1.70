package com.qzone.publish.business.protocol;

import NS_MOBILE_COMM.UgcRightInfo;
import NS_MOBILE_OPERATION.AudioInfo;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.ShootInfo;
import NS_MOBILE_OPERATION.Source;
import NS_MOBILE_OPERATION.operation_publishmood_req;
import NS_MOBILE_OPERATION.operation_publishmood_rsp;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.feed.utils.h;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZonePublishMoodRequest extends QZoneRequest {
    private static final String CMD_STRING = "publishmood";
    public static final String EXT_INFO_KEY_DELETE_TIME = "self_delete_time";
    public static final String EXT_INFO_KEY_EVENT_TAG = "event_tags";
    public static final String EXT_INFO_KEY_EVENT_TAG_ID = "event_tags_id";
    public static final String EXT_INFO_KEY_ISKUOLIE = "kuolie_info";
    public static final String EXT_INFO_KEY_IS_FORMAT_F20 = "iIsFormatF20";
    public static final String EXT_INFO_KEY_IS_ORIGIN_VIDEO = "iIsOriginalVideo";
    public static final String EXT_INFO_KEY_IS_SEND_FEED = "isSendFeed";
    public static final String EXT_INFO_KEY_IS_SYNC_TO_QQSTORY = "sync_qqstory";
    public static final String EXT_INFO_KEY_KUOLIE_CAMPUS = "kuolie_campus";
    public static final String EXT_INFO_KEY_SYNC_TO_FRIEND = "qqim_share_info";
    public static final String EXT_INFO_KEY_SYNC_TO_RENZHENHAO = "certified_puin";
    public static final String EXT_INFO_KEY_SYNC_TO_WEZONE = "circle_info";
    public static final String EXT_INFO_KEY_TEMPLATE_SHUOSHUO = "mv_template_shuoshuo";
    public static final String EXT_INFO_KEY_TOPIC_ID = "tid";
    public static final String EXT_INFO_KEY_TOPIC_SYNC = "sync";
    public static final String EXT_INFO_KEY_TOPOC = "weishi_info";
    public static final String EXT_INFO_KEY_VIDEO_SIZE = "videoSize";
    public static final String IS_INTEGRATION_VIDEO = "is_integration_video";
    public static final String KEY_APPID_FOR_CLIENT_FAKE_FEED = "fakeFeedAppIdForClient";
    public static final String KEY_EDIT_MEHOD = "edit_method";
    public static final String KEY_INFO_HOLIDAY_PUBLISH = "holiday_publish";
    public static final String KEY_UPLOAD_PHOTO_CLIENT_KEY = "uploadPhotoClientKey";

    public QZonePublishMoodRequest() {
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public operation_publishmood_rsp getResp() {
        return (operation_publishmood_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZonePublishMoodRequest(String str, boolean z16, boolean z17, String str2, int i3, MediaInfo mediaInfo, LbsInfo lbsInfo, Source source, String str3, int i16, long j3, int i17, ArrayList<String> arrayList, Map<String, String> map, Map<String, byte[]> map2, String str4, Map<String, String> map3) {
        this(str, z16, z17, str2, i3, mediaInfo, lbsInfo, source, str3, i16, j3, i17, arrayList, map, map2, str4, null, null, map3);
    }

    public QZonePublishMoodRequest(String str, int i3, int i16, ArrayList<String> arrayList) {
        this("", true, false, null, 0, null, null, null, "", 0, 0L, i16, arrayList, null, null, null, null, null, null, str, i3);
    }

    public QZonePublishMoodRequest(String str, boolean z16, boolean z17, String str2, int i3, MediaInfo mediaInfo, LbsInfo lbsInfo, Source source, String str3, int i16, long j3, int i17, ArrayList<String> arrayList, Map<String, String> map, Map<String, byte[]> map2, String str4, String str5, LbsInfo lbsInfo2, Map<String, String> map3) {
        this(str, z16, z17, str2, i3, mediaInfo, lbsInfo, source, str3, i16, j3, i17, arrayList, map, map2, str4, str5, lbsInfo2, map3, "", 0);
    }

    public QZonePublishMoodRequest(String str, boolean z16, boolean z17, String str2, int i3, MediaInfo mediaInfo, LbsInfo lbsInfo, Source source, String str3, int i16, long j3, int i17, ArrayList<String> arrayList, Map<String, String> map, Map<String, byte[]> map2, String str4, String str5, LbsInfo lbsInfo2, Map<String, String> map3, String str6, int i18) {
        super(CMD_STRING);
        String str7;
        operation_publishmood_req operation_publishmood_reqVar = new operation_publishmood_req();
        operation_publishmood_reqVar.uin = LoginData.getInstance().getUin();
        operation_publishmood_reqVar.content = str;
        operation_publishmood_reqVar.isverified = z16;
        operation_publishmood_reqVar.issynctoweibo = z17;
        operation_publishmood_reqVar.weibourl = str2;
        operation_publishmood_reqVar.mediatype = i3;
        operation_publishmood_reqVar.mediainfo = mediaInfo;
        operation_publishmood_reqVar.lbsinfo = lbsInfo;
        operation_publishmood_reqVar.source = source;
        operation_publishmood_reqVar.clientkey = str3;
        operation_publishmood_reqVar.publishTime = j3;
        operation_publishmood_reqVar.extend_info = map;
        operation_publishmood_reqVar.stored_extend_info = map3;
        operation_publishmood_reqVar.hidden_poi = lbsInfo2;
        operation_publishmood_reqVar.proto_extend_info = map2;
        operation_publishmood_reqVar.srcid = str6;
        operation_publishmood_reqVar.modifyflag = i18;
        if (QZLog.isColorLevel()) {
            String str8 = this.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = "source subtype:";
            objArr[1] = Integer.valueOf(source != null ? source.subtype : -1);
            QZLog.d(str8, 2, objArr);
        }
        Map<String, String> map4 = operation_publishmood_reqVar.extend_info;
        if (map4 != null && !map4.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = operation_publishmood_reqVar.extend_info.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next.getValue() == null) {
                    QZLog.e(this.TAG, "shoot params are invalid, value(key=" + next.getKey() + ") is null, may cause wup crash.");
                    it.remove();
                }
            }
            this.contentCacheUnikey = operation_publishmood_reqVar.extend_info.get("content_cache_key");
        }
        if (operation_publishmood_reqVar.busi_param == null) {
            operation_publishmood_reqVar.busi_param = new HashMap();
        }
        operation_publishmood_reqVar.busi_param.put(25, LoginData.getInstance().getNickName(l.a(R.string.s6g)));
        Map<Integer, String> map5 = operation_publishmood_reqVar.busi_param;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("quickpic_use=");
        sb5.append(i16);
        if (str4 == null) {
            str7 = "";
        } else {
            str7 = ContainerUtils.FIELD_DELIMITER + str4;
        }
        sb5.append(str7);
        map5.put(41, sb5.toString());
        operation_publishmood_reqVar.busi_param.put(32, Integer.toString(LoginData.getInstance().getVipLevel()));
        operation_publishmood_reqVar.busi_param.put(33, Integer.toString(LoginData.getInstance().getUserType()));
        if (!TextUtils.isEmpty(str5)) {
            operation_publishmood_reqVar.busi_param.put(62, str5);
        }
        MediaInfo mediaInfo2 = operation_publishmood_reqVar.mediainfo;
        if (mediaInfo2 != null) {
            ArrayList<PicInfo> arrayList2 = mediaInfo2.picinfolist;
            if (arrayList2 != null && arrayList2.size() > 0) {
                operation_publishmood_reqVar.mediabittype |= 2;
            }
            MediaInfo mediaInfo3 = operation_publishmood_reqVar.mediainfo;
            if (mediaInfo3.vedioinfo != null) {
                operation_publishmood_reqVar.mediabittype |= 8;
            }
            ArrayList<AudioInfo> arrayList3 = mediaInfo3.audioinfo;
            if (arrayList3 != null && arrayList3.size() > 0) {
                operation_publishmood_reqVar.mediabittype |= 16;
            }
        }
        UgcRightInfo ugcRightInfo = new UgcRightInfo();
        operation_publishmood_reqVar.right_info = ugcRightInfo;
        ugcRightInfo.ugc_right = i17;
        if (h.h(i17) && arrayList != null) {
            operation_publishmood_reqVar.right_info.allow_uins = new ArrayList<>();
            try {
                Iterator<String> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    if (TextUtils.isDigitsOnly(next2)) {
                        operation_publishmood_reqVar.right_info.allow_uins.add(Long.valueOf(next2));
                    }
                }
            } catch (Throwable th5) {
                QZLog.w(this.TAG, "publish_mood:", th5);
            }
        }
        ShootInfo shootInfo = new ShootInfo();
        operation_publishmood_reqVar.shootInfo = shootInfo;
        shootInfo.shootLbs = getShootLbs(map);
        operation_publishmood_reqVar.shootInfo.shootTime = getShootTime(map);
        this.req = operation_publishmood_reqVar;
    }

    private LbsInfo getShootLbs(Map<String, String> map) {
        int i3;
        if (map == null) {
            return null;
        }
        LbsInfo lbsInfo = new LbsInfo();
        lbsInfo.lbs_x = map.get("geo_x");
        lbsInfo.lbs_y = map.get("geo_y");
        try {
            i3 = Integer.valueOf(map.get("geo_id")).intValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        lbsInfo.lbs_id = i3;
        lbsInfo.lbs_idnm = map.get("geo_idname");
        lbsInfo.lbs_nm = map.get("geo_name");
        return lbsInfo;
    }

    private long getShootTime(Map<String, String> map) {
        long j3 = 0;
        if (map == null) {
            return 0L;
        }
        try {
            j3 = Long.valueOf(map.get("capturetime")).longValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        return j3 / 1000;
    }
}
