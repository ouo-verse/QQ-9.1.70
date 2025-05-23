package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraPropertyAIReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraPropertyAIRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetWatermarkDictReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetWatermarkDictRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends a {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f63480f = {"ShadowBackendSvc"};

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCameraConfigReq getCameraConfigReq = new GetCameraConfigReq();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_CAMERA_CONFIG);
        uniPacket.put(AECameraConstants.CMD_CAMERA_CONFIG, getCameraConfigReq);
        return true;
    }

    private boolean i(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        CameraPropertyAIReq cameraPropertyAIReq = new CameraPropertyAIReq();
        cameraPropertyAIReq.BusiID = (String) toServiceMsg.getAttribute(AECameraConstants.REQ_BUSI_ID, "");
        cameraPropertyAIReq.MediaInfos = (ArrayList) toServiceMsg.getAttribute(AECameraConstants.REQ_MEDIA_INFOS);
        cameraPropertyAIReq.Extra = (String) toServiceMsg.getAttribute(AECameraConstants.REQ_EXTRA, "");
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_CAMERA_PROPERTY_AI);
        uniPacket.put(AECameraConstants.CMD_CAMERA_PROPERTY_AI, cameraPropertyAIReq);
        return true;
    }

    private boolean j(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCatMatTreeReq getCatMatTreeReq = new GetCatMatTreeReq();
        getCatMatTreeReq.ServiceId = toServiceMsg.extraData.getString("ServiceId");
        getCatMatTreeReq.ETag = c(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL);
        getCatMatTreeReq.SdkInfos = a();
        getCatMatTreeReq.GroupId = "3";
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY);
        uniPacket.put(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY, getCatMatTreeReq);
        return true;
    }

    private boolean k(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetImgValidStatusReq getImgValidStatusReq = new GetImgValidStatusReq();
        getImgValidStatusReq.Rawdata = toServiceMsg.extraData.getByteArray("Rawdata");
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_FACE_DETECT);
        uniPacket.put(AECameraConstants.CMD_FACE_DETECT, getImgValidStatusReq);
        return true;
    }

    private boolean l(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetRecommandTextByEmotionReq getRecommandTextByEmotionReq = new GetRecommandTextByEmotionReq();
        getRecommandTextByEmotionReq.Rawdata = toServiceMsg.extraData.getByteArray("Rawdata");
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_EMOTION);
        uniPacket.put(AECameraConstants.CMD_EMOTION, getRecommandTextByEmotionReq);
        return true;
    }

    private boolean m(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetFontDataReq getFontDataReq = new GetFontDataReq();
        getFontDataReq.Content = toServiceMsg.extraData.getString(AECameraConstants.REQ_FIELD_FONT_CONTENT);
        getFontDataReq.FontName = toServiceMsg.extraData.getString(AECameraConstants.REQ_FIELD_FONT_NAME);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_GET_FONT_DATA);
        uniPacket.put(AECameraConstants.CMD_GET_FONT_DATA, getFontDataReq);
        return true;
    }

    private boolean n(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetOnlineUserNumReq getOnlineUserNumReq = new GetOnlineUserNumReq();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_QQ_ONLINE_NUMBER);
        uniPacket.put(AECameraConstants.CMD_QQ_ONLINE_NUMBER, getOnlineUserNumReq);
        return true;
    }

    private boolean o(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetBigShowRecommendReq getBigShowRecommendReq = new GetBigShowRecommendReq();
        getBigShowRecommendReq.framePics = (ArrayList) toServiceMsg.extraData.getSerializable(AEEditorConstants.REQ_FIELD_FRAMES);
        getBigShowRecommendReq.SdkVersion = a().get(0).sdkVersion;
        getBigShowRecommendReq.MediaType = toServiceMsg.extraData.getInt("media_type", 0);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND);
        uniPacket.put(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND, getBigShowRecommendReq);
        return true;
    }

    private boolean p(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetBulkImageClassifyReq getBulkImageClassifyReq = new GetBulkImageClassifyReq();
        getBulkImageClassifyReq.MultiPics = (ArrayList) toServiceMsg.extraData.getSerializable(AEEditorConstants.AI_FILTER_REQ_PICS);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_SMART_FILTER);
        uniPacket.put(AECameraConstants.CMD_SMART_FILTER, getBulkImageClassifyReq);
        toServiceMsg.setTimeout(15000L);
        return true;
    }

    private boolean q(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetTextValidStatusReq getTextValidStatusReq = new GetTextValidStatusReq();
        getTextValidStatusReq.EmoText = toServiceMsg.extraData.getString(AECameraConstants.REQ_FIELD_TEXT);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_TEXT_VALID);
        uniPacket.put(AECameraConstants.CMD_TEXT_VALID, getTextValidStatusReq);
        return true;
    }

    private boolean r(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetWatermarkDictReq getWatermarkDictReq = new GetWatermarkDictReq();
        getWatermarkDictReq.Lon = toServiceMsg.extraData.getDouble(AECameraConstants.KEY_LONGTITUDE);
        getWatermarkDictReq.Lat = toServiceMsg.extraData.getDouble(AECameraConstants.KEY_LATITUDE);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_WATERMARK_LOCATION);
        uniPacket.put(AECameraConstants.CMD_WATERMARK_LOCATION, getWatermarkDictReq);
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.config.a, com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return f63480f;
    }

    @Override // com.tencent.aelight.camera.ae.config.a, com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_EMOTION)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_EMOTION, new GetRecommandTextByEmotionRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TEXT_VALID)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_TEXT_VALID, new GetTextValidStatusRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_CAMERA_CONFIG, new GetCameraConfigRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_QQ_ONLINE_NUMBER)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_QQ_ONLINE_NUMBER, new GetOnlineUserNumRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_GET_FONT_DATA)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_GET_FONT_DATA, new GetFontDataRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_FACE_DETECT, new GetImgValidStatusRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_SMART_FILTER)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_SMART_FILTER, new GetBulkImageClassifyRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            return b(fromServiceMsg.getWupBuffer(), AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY, new GetCatMatTreeRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND)) {
            return b(fromServiceMsg.getWupBuffer(), AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND, new GetBigShowRecommendRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_WATERMARK_LOCATION)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_WATERMARK_LOCATION, new GetWatermarkDictRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_PROPERTY_AI)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_CAMERA_PROPERTY_AI, new CameraPropertyAIRsp());
        }
        return super.decode(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.aelight.camera.ae.config.a, com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_EMOTION)) {
            return l(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TEXT_VALID)) {
            return q(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG)) {
            return f(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_QQ_ONLINE_NUMBER)) {
            return n(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_GET_FONT_DATA)) {
            return m(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
            return k(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_SMART_FILTER)) {
            return p(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            return j(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND)) {
            return o(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_WATERMARK_LOCATION)) {
            return r(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_PROPERTY_AI)) {
            return i(toServiceMsg, uniPacket);
        }
        return super.encodeReqMsg(toServiceMsg, uniPacket);
    }
}
