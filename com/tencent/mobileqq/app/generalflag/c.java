package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(generalflags$ResvAttr generalflags_resvattr, NTVasSimpleInfo nTVasSimpleInfo, String str) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            i3 = Integer.parseInt(str);
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(MessageHandlerUtils.TAG, 2, "getGeneralFlagElemFromMsg: fontId=" + nTVasSimpleInfo.uVipFont + " subFontId=" + i3);
        }
        generalflags_resvattr.uint64_subfont_id.set(i3);
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = nTVasSimpleInfo.diyFontTimestampMap;
        if (concurrentHashMap != null && concurrentHashMap.get(Integer.valueOf((int) nTVasSimpleInfo.uVipFont)) != null) {
            generalflags_resvattr.uint32_diy_font_timestamp.set(nTVasSimpleInfo.diyFontTimestampMap.get(Integer.valueOf((int) nTVasSimpleInfo.uVipFont)).intValue());
        }
    }

    private static void b(generalflags$ResvAttr generalflags_resvattr, NTVasSimpleInfo nTVasSimpleInfo) {
        int i3 = nTVasSimpleInfo.pendantDiyId;
        if (i3 > 0) {
            generalflags_resvattr.uint32_pendant_diy_id.set(i3);
        }
        int i16 = nTVasSimpleInfo.faceId;
        if (i16 > 0) {
            generalflags_resvattr.uint32_face_id.set(i16);
        }
        int i17 = nTVasSimpleInfo.fontEffect;
        if (i17 > 0) {
            generalflags_resvattr.uint32_req_font_effect_id.set(i17);
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(appInterface.getAccount()), "ExtensionInfoGeneralFlagProvider");
        if (vasSimpleInfoWithUid != null) {
            im_msg_body_generalflags.uint64_pendant_id.set(vasSimpleInfoWithUid.pendantId);
            generalflags_resvattr.uint32_mobile_custom_font.set(FontManagerConstants.generateFontValue(vasSimpleInfoWithUid));
            a(generalflags_resvattr, vasSimpleInfoWithUid, messageRecord.getExtInfoFromExtStr("vip_sub_font_id"));
            b(generalflags_resvattr, vasSimpleInfoWithUid);
            z16 = true;
            z17 = true;
        }
        return new boolean[]{z16, z17};
    }
}
