package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.constant.PhotoWallConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.ilive.photo.NowLiveGallary$ReqBody;

/* loaded from: classes16.dex */
public class PhotoWallHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PhotoWallHandler";
    private AppInterface mApp;

    protected PhotoWallHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.mApp = appInterface;
        }
    }

    private void handleDelPhotoWall(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        String str = (String) toServiceMsg.getAttribute("uin");
        String str2 = (String) toServiceMsg.getAttribute("photo_id");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "handleDelPhotoWall isSuc:" + isSuccess + " photoid:" + str2);
        }
        notifyUI(2, isSuccess, new Object[]{str});
    }

    private void handleGetPhotoWall(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar;
        boolean z16;
        String str = (String) toServiceMsg.getAttribute("uin");
        String str2 = (String) toServiceMsg.getAttribute("attachInfo");
        if (fromServiceMsg.isSuccess() && (obj instanceof mobile_sub_get_photo_wall_rsp)) {
            mobile_sub_get_photo_wall_rspVar = (mobile_sub_get_photo_wall_rsp) obj;
            EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
            QZonePhotoWall qZonePhotoWall = (QZonePhotoWall) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QZonePhotoWall.class, str);
            if (qZonePhotoWall == null) {
                qZonePhotoWall = new QZonePhotoWall();
                qZonePhotoWall.uin = str;
            }
            qZonePhotoWall.updateQzonePhotoWall(str2, mobile_sub_get_photo_wall_rspVar);
            if (qZonePhotoWall.getStatus() == 1000) {
                createEntityManager.persist(qZonePhotoWall);
            } else {
                createEntityManager.update(qZonePhotoWall);
            }
            createEntityManager.close();
            z16 = true;
        } else {
            mobile_sub_get_photo_wall_rspVar = null;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "handleGetPhotoWall isSuc:" + z16);
        }
        notifyUI(1, z16, new Object[]{str2, mobile_sub_get_photo_wall_rspVar, str});
    }

    public void delQzonePhotoWall(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "delQzonePhotoWall");
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(PhotoWallConstant.CMD_DEL_PHOTO_WALL);
        createToServiceMsg.addAttribute("uin", str);
        createToServiceMsg.addAttribute("photo_id", str2);
        createToServiceMsg.addAttribute("photo_time", Long.valueOf(j3));
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(PhotoWallConstant.CMD_DEL_PHOTO_WALL);
            this.allowCmdSet.add(PhotoWallConstant.CMD_GET_PHOTO_WALL);
        }
        return this.allowCmdSet;
    }

    public void getNowOnliveGallary(long j3, NowOnliveGallayCallback nowOnliveGallayCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), nowOnliveGallayCallback);
            return;
        }
        NowLiveGallary$ReqBody nowLiveGallary$ReqBody = new NowLiveGallary$ReqBody();
        nowLiveGallary$ReqBody.req_uin.set(j3);
        ProtoUtils.d(this.mApp, nowOnliveGallayCallback, nowLiveGallary$ReqBody.toByteArray(), PhotoWallConstant.CMD_GET_NOW_LIVE_GALLARY);
    }

    public void getQzonePhotoWall(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "getQzonePhotoWall uin:" + str);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(PhotoWallConstant.CMD_GET_PHOTO_WALL);
        createToServiceMsg.addAttribute("uin", str);
        createToServiceMsg.addAttribute("attachInfo", str2);
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return PhotoWallObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        if (PhotoWallConstant.CMD_GET_PHOTO_WALL.equals(serviceCmd)) {
            handleGetPhotoWall(toServiceMsg, fromServiceMsg, obj);
        } else if (PhotoWallConstant.CMD_DEL_PHOTO_WALL.equals(serviceCmd)) {
            handleDelPhotoWall(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
