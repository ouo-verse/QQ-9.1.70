package com.qzone.common.protocol.request;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.operation_addcomment_req;
import NS_MOBILE_OPERATION.operation_addcomment_rsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.util.u;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAddCommentRequest extends AbsCompatRequest<a> {
    public static final int CMD_DEFAULT = 0;
    private static final String CMD_STRING = "addComment";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f46118a;
    }

    public QZoneAddCommentRequest() {
        super(getCmdString(0), true);
    }

    private static String getCmdString(int i3) {
        return CMD_STRING;
    }

    private void onAddCommentWithBarrageEffect() {
        MobileReportManager.getInstance().reportAction("qzone_pri", "2", "16", 144, 1, System.currentTimeMillis());
    }

    private void onPrivateComment() {
        MobileReportManager.getInstance().reportAction("qzone_pri", "4", "10", 144, 1, System.currentTimeMillis());
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getRequestType() {
        return com.qzone.app.a.b(((operation_addcomment_req) this.req).appid);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneAddCommentRequest(int i3, int i16, long j3, String str, String str2, String str3, int i17, Map<Integer, String> map, String str4, boolean z16, Map<String, String> map2) {
        super(getCmdString(i3), true);
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        this.contentCacheUnikey = str3;
        operation_addcomment_req operation_addcomment_reqVar = new operation_addcomment_req();
        operation_addcomment_reqVar.appid = i16;
        operation_addcomment_reqVar.uin = LoginData.getInstance().getUin();
        operation_addcomment_reqVar.ownuin = j3;
        operation_addcomment_reqVar.srcId = str;
        operation_addcomment_reqVar.content = u.c(str2);
        operation_addcomment_reqVar.isverified = i17;
        operation_addcomment_reqVar.busi_param = map;
        operation_addcomment_reqVar.isPrivateComment = z16 ? 1 : 0;
        operation_addcomment_reqVar.bypass_param = map2;
        if (map2 != null) {
            try {
                Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey() == null || next.getValue() == null) {
                        it.remove();
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (map2 != null && map2.containsKey("private_barrage_data") && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(map2.get("private_barrage_data"))) != null && fromJson.f51896id > 0) {
            if (operation_addcomment_reqVar.bypass_param_binary == null) {
                operation_addcomment_reqVar.bypass_param_binary = new HashMap();
            }
            operation_addcomment_reqVar.bypass_param_binary.put(UNIVERSAL_MALL_QUAL.value, fromJson.toJceReqData());
            onAddCommentWithBarrageEffect();
        }
        if (str4 != null) {
            addParameter("refer", str4);
        }
        if (z16) {
            onPrivateComment();
        }
        this.req = operation_addcomment_reqVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof operation_addcomment_rsp)) {
            return null;
        }
        new a().f46118a = ((operation_addcomment_rsp) jceStruct).ret;
        return null;
    }

    public QZoneAddCommentRequest(int i3, int i16, long j3, String str, String str2, String str3, int i17, Map<Integer, String> map, String str4, boolean z16, MediaInfo mediaInfo, Map<String, String> map2) {
        super(getCmdString(i3), true);
        ArrayList<PicInfo> arrayList;
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        this.contentCacheUnikey = str3;
        operation_addcomment_req operation_addcomment_reqVar = new operation_addcomment_req();
        operation_addcomment_reqVar.appid = i16;
        operation_addcomment_reqVar.uin = LoginData.getInstance().getUin();
        operation_addcomment_reqVar.ownuin = j3;
        operation_addcomment_reqVar.srcId = str;
        operation_addcomment_reqVar.content = u.c(str2);
        operation_addcomment_reqVar.isverified = i17;
        operation_addcomment_reqVar.busi_param = map;
        operation_addcomment_reqVar.isPrivateComment = z16 ? 1 : 0;
        operation_addcomment_reqVar.mediainfo = mediaInfo;
        operation_addcomment_reqVar.bypass_param = map2;
        if (map2 != null) {
            try {
                Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey() == null || next.getValue() == null) {
                        it.remove();
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (map2 != null && map2.containsKey("private_barrage_data") && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(map2.get("private_barrage_data"))) != null && fromJson.f51896id > 0) {
            if (operation_addcomment_reqVar.bypass_param_binary == null) {
                operation_addcomment_reqVar.bypass_param_binary = new HashMap();
            }
            operation_addcomment_reqVar.bypass_param_binary.put(UNIVERSAL_MALL_QUAL.value, fromJson.toJceReqData());
            onAddCommentWithBarrageEffect();
        }
        if (mediaInfo != null && (arrayList = mediaInfo.picinfolist) != null && arrayList.size() > 0) {
            operation_addcomment_reqVar.mediabittype = 2;
        } else {
            operation_addcomment_reqVar.mediabittype = 0;
        }
        if (str4 != null) {
            addParameter("refer", str4);
        }
        if (z16) {
            onPrivateComment();
        }
        this.req = operation_addcomment_reqVar;
    }
}
