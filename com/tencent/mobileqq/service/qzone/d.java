package com.tencent.mobileqq.service.qzone;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.profilecard.bussiness.photowall.constant.PhotoWallConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneDelPhotoWallRequest;
import cooperation.qzone.QZoneGetPhotoWallRequest;
import cooperation.qzone.QZoneRequestEncoder;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static String[] f286405d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f286405d = new String[]{"QzoneService", "SQQzoneSvc"};
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(UniPacket uniPacket) {
        uniPacket.setEncodeName("utf8");
        uniPacket.put("version", 1091030);
        uniPacket.put("Q-UA", AppSetting.k());
        uniPacket.put("rupt", Boolean.FALSE);
    }

    private UniPacket b(String str) {
        UniPacket uniPacket = new UniPacket();
        uniPacket.setEncodeName("utf8");
        a(uniPacket);
        uniPacket.put("uin", Long.valueOf(Long.parseLong(str)));
        return uniPacket;
    }

    private Object c(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        JceStruct decodeDelResponse = QZoneDelPhotoWallRequest.decodeDelResponse(fromServiceMsg.getWupBuffer());
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_PHOTO_WALL, 2, "decodeDelQZonePhotoWall|jceObj = " + decodeDelResponse);
        }
        return decodeDelResponse;
    }

    private Object d(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        JceStruct decodeCoverResponse = QZoneRequestEncoder.decodeCoverResponse(fromServiceMsg.getWupBuffer());
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_COVER, 2, "decodeGetQZoneCover|jceObj = " + decodeCoverResponse);
        }
        return decodeCoverResponse;
    }

    private Object e(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        JceStruct decodePhotoWallResponse = QZoneGetPhotoWallRequest.decodePhotoWallResponse(fromServiceMsg.getWupBuffer());
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_PHOTO_WALL, 2, "decodeGetQZonePhotoWall|jceObj = " + decodePhotoWallResponse);
        }
        return decodePhotoWallResponse;
    }

    private byte[] f(ToServiceMsg toServiceMsg) {
        long j3;
        long j16;
        String str = (String) toServiceMsg.getAttribute("uin");
        String str2 = (String) toServiceMsg.getAttribute("photo_id");
        Long l3 = (Long) toServiceMsg.getAttribute("photo_time");
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_PHOTO_WALL, 2, "handleDetQZonePhotoWall|uin = " + str);
        }
        try {
            j3 = Long.parseLong(str);
            try {
                j16 = Long.parseLong(toServiceMsg.getUin());
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.QZONE_PHOTO_WALL, 2, e.toString());
                }
                j16 = 0;
                return new QZoneDelPhotoWallRequest(j3, j16, str2, l3).encode();
            }
        } catch (Exception e17) {
            e = e17;
            j3 = 0;
        }
        return new QZoneDelPhotoWallRequest(j3, j16, str2, l3).encode();
    }

    private byte[] g(ToServiceMsg toServiceMsg) {
        long j3;
        String str = (String) toServiceMsg.getAttribute("uin");
        Integer num = (Integer) toServiceMsg.getAttribute("flag", 1);
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_COVER, 2, "handleGetQZoneCover|uin = " + str + ",flag=" + num.intValue());
        }
        long j16 = 0;
        try {
            j3 = Long.parseLong(str);
            try {
                j16 = Long.parseLong(toServiceMsg.getUin());
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.QZONE_COVER, 2, e.toString());
                }
                return new QZoneRequestEncoder(j3, j16, num.intValue()).encode();
            }
        } catch (Exception e17) {
            e = e17;
            j3 = 0;
        }
        return new QZoneRequestEncoder(j3, j16, num.intValue()).encode();
    }

    private byte[] h(ToServiceMsg toServiceMsg) {
        long j3;
        long j16;
        String str = (String) toServiceMsg.getAttribute("uin");
        String str2 = (String) toServiceMsg.getAttribute("attachInfo");
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QZONE_PHOTO_WALL, 2, "handleGetQZonePhotoWall|uin = " + str);
        }
        try {
            j3 = Long.parseLong(str);
            try {
                j16 = Long.parseLong(toServiceMsg.getUin());
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.QZONE_PHOTO_WALL, 2, e.toString());
                }
                j16 = 0;
                return new QZoneGetPhotoWallRequest(j3, j16, str2).encode();
            }
        } catch (Exception e17) {
            e = e17;
            j3 = 0;
        }
        return new QZoneGetPhotoWallRequest(j3, j16, str2).encode();
    }

    private byte[] i(ToServiceMsg toServiceMsg) {
        UniPacket b16 = b(toServiceMsg.getUin());
        b16.put("uin", Long.valueOf(Long.parseLong(toServiceMsg.getUin())));
        a(b16);
        b16.setServantName("QzoneServer");
        b16.setFuncName("GetNewAndUnread");
        return fh.b(b16.encode());
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f286405d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("SQQzoneSvc.getCover".equals(serviceCmd)) {
            return d(fromServiceMsg, toServiceMsg);
        }
        if (PhotoWallConstant.CMD_GET_PHOTO_WALL.equals(serviceCmd)) {
            return e(fromServiceMsg, toServiceMsg);
        }
        if (PhotoWallConstant.CMD_DEL_PHOTO_WALL.equals(serviceCmd)) {
            return c(fromServiceMsg, toServiceMsg);
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void decodeRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean enableBinaryProtocol() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public byte[] encodeReqMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if ("QzoneService.GetNewAndUnread".equals(serviceCmd)) {
            return i(toServiceMsg);
        }
        if ("SQQzoneSvc.getCover".equals(serviceCmd)) {
            return g(toServiceMsg);
        }
        if (PhotoWallConstant.CMD_GET_PHOTO_WALL.equals(serviceCmd)) {
            return h(toServiceMsg);
        }
        if (PhotoWallConstant.CMD_DEL_PHOTO_WALL.equals(serviceCmd)) {
            return f(toServiceMsg);
        }
        return null;
    }
}
