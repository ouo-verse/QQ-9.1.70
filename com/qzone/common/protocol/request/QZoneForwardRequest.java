package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_forward_req;
import NS_MOBILE_OPERATION.operation_forward_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneForwardRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "forward";
    private String content;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f46119a;
    }

    public QZoneForwardRequest(operation_forward_req operation_forward_reqVar) {
        super(CMD_STRING);
        this.req = operation_forward_reqVar;
        this.content = operation_forward_reqVar.reason;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "QzoneNewService.forward";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof operation_forward_rsp)) {
            return null;
        }
        new a().f46119a = ((operation_forward_rsp) jceStruct).ret;
        return null;
    }

    public QZoneForwardRequest(int i3, int i16, long j3, String str, ArrayList<String> arrayList, String str2, String str3, String str4, ArrayList<String> arrayList2, int i17, int i18, int i19, String str5, int i26, String str6, int i27, Map<Integer, String> map, String str7, Map<String, ArrayList<String>> map2) {
        super(CMD_STRING);
        this.contentCacheUnikey = str7;
        operation_forward_req operation_forward_reqVar = new operation_forward_req();
        operation_forward_reqVar.appid = i3;
        operation_forward_reqVar.subid = i16;
        operation_forward_reqVar.uin = LoginData.getInstance().getUin();
        operation_forward_reqVar.ownUin = j3;
        operation_forward_reqVar.srcId = str;
        operation_forward_reqVar.srcSubid = arrayList;
        operation_forward_reqVar.reason = str2;
        operation_forward_reqVar.srcTitle = str3;
        operation_forward_reqVar.srcAbstract = str4;
        operation_forward_reqVar.srcImages = arrayList2;
        operation_forward_reqVar.srcPicNum = i17;
        operation_forward_reqVar.source = i18;
        operation_forward_reqVar.isverified = i19;
        operation_forward_reqVar.category = str5;
        operation_forward_reqVar.operatemask = i26;
        operation_forward_reqVar.dstAlbumId = str6;
        operation_forward_reqVar.dstAlbumType = i27;
        operation_forward_reqVar.busi_param = map;
        operation_forward_reqVar.photoids = map2;
        this.req = operation_forward_reqVar;
        this.content = str2;
    }

    public QZoneForwardRequest(String str, String str2, int i3, long j3, String str3, String str4, String str5, ArrayList<String> arrayList, long j16, String str6, int i16) {
        super(CMD_STRING);
        operation_forward_req operation_forward_reqVar = new operation_forward_req();
        if (j16 != 0) {
            operation_forward_reqVar.subid = (int) j16;
        }
        String str7 = str == null ? "" : str;
        if (str2 != null) {
            operation_forward_reqVar.srcId = str2;
        }
        if (i3 > 0) {
            operation_forward_reqVar.appid = i3;
        }
        operation_forward_reqVar.uin = LoginData.getInstance().getUin();
        if (j3 > 0) {
            operation_forward_reqVar.ownUin = j3;
        }
        if (str3 != null) {
            if (str3.length() > 200) {
                operation_forward_reqVar.srcTitle = str3.substring(0, 200);
            } else {
                operation_forward_reqVar.srcTitle = str3;
            }
        }
        if (str4 != null) {
            if (str4.length() > 600) {
                operation_forward_reqVar.srcAbstract = str4.substring(0, 600);
            } else {
                operation_forward_reqVar.srcAbstract = str4;
            }
        }
        if (str5 != null) {
            if (str5.length() > 1500) {
                operation_forward_reqVar.reason = str5.substring(0, 1500);
            } else {
                operation_forward_reqVar.reason = str5;
            }
        }
        if (arrayList != null && arrayList.size() > 9) {
            if (operation_forward_reqVar.srcImages == null) {
                operation_forward_reqVar.srcImages = new ArrayList<>();
            }
            for (int i17 = 0; i17 < 9; i17++) {
                operation_forward_reqVar.srcImages.add(arrayList.get(i17));
            }
        } else {
            operation_forward_reqVar.srcImages = arrayList;
        }
        operation_forward_reqVar.operatemask = 4;
        if (operation_forward_reqVar.busi_param == null) {
            operation_forward_reqVar.busi_param = new HashMap();
        }
        operation_forward_reqVar.busi_param.put(43, str7);
        if (!TextUtils.isEmpty(str6)) {
            operation_forward_reqVar.busi_param.put(79, str6);
        }
        operation_forward_reqVar.iUrlInfoFrm = i16;
        this.req = operation_forward_reqVar;
    }
}
