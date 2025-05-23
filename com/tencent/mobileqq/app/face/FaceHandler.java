package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import com.tencent.avatarinfo.MultiHeadUrl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cu;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    AppInterface f195517d;

    /* renamed from: e, reason: collision with root package name */
    private Hashtable<Integer, ArrayList<FaceInfo>> f195518e;

    /* renamed from: f, reason: collision with root package name */
    private Hashtable<String, Long> f195519f;

    /* renamed from: h, reason: collision with root package name */
    private Object f195520h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f195521i;

    public FaceHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f195518e = new Hashtable<>();
        this.f195519f = new Hashtable<>();
        this.f195520h = new Object();
        this.f195521i = false;
        this.f195517d = appInterface;
    }

    private void D2(MultiHeadUrl.MultiBusidUrlRsp multiBusidUrlRsp) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("start ====================================================================================\n\n");
            sb5.append("QQHead_Stranger response.srcUidType=" + multiBusidUrlRsp.srcUidType.get());
            sb5.append(";srcUin=" + multiBusidUrlRsp.srcUin.get());
            sb5.append("\n\n");
            sb5.append(";srcTid=" + multiBusidUrlRsp.srcTid.get());
            sb5.append(";srcOpenid=" + multiBusidUrlRsp.srcOpenid.get());
            sb5.append("\n\n");
            sb5.append(";dstUidType=" + multiBusidUrlRsp.dstUidType.get());
            sb5.append(";result=" + multiBusidUrlRsp.result.get());
            sb5.append("\n\n");
            List<MultiHeadUrl.RspUsrHeadInfo> list = multiBusidUrlRsp.dstUsrHeadInfos.get();
            if (list != null) {
                for (MultiHeadUrl.RspUsrHeadInfo rspUsrHeadInfo : list) {
                    sb5.append("-------------------------------------------------------------------------------------\n\n");
                    sb5.append("RspUsrHeadInfo.dstUin=" + rspUsrHeadInfo.dstUin.get());
                    sb5.append(";dstTid=" + rspUsrHeadInfo.dstTid.get());
                    sb5.append(";dstOpenid=" + rspUsrHeadInfo.dstOpenid.get());
                    sb5.append("\n\n");
                    for (MultiHeadUrl.RspHeadInfo rspHeadInfo : rspUsrHeadInfo.dstHeadInfos.get()) {
                        sb5.append("RspHeadInfo.usrType=" + rspHeadInfo.usrType.get());
                        sb5.append("\n\n");
                        sb5.append(";faceType=" + rspHeadInfo.faceType.get());
                        sb5.append("\n\n");
                        sb5.append(";timestamp=" + rspHeadInfo.timestamp.get());
                        sb5.append("\n\n");
                        sb5.append(";faceFlag=" + rspHeadInfo.faceFlag.get());
                        sb5.append("\n\n");
                        sb5.append(";url=" + rspHeadInfo.url.get());
                        sb5.append("\n\n");
                        sb5.append(";sysid=" + rspHeadInfo.sysid.get());
                        sb5.append("\n\n");
                    }
                }
            }
            sb5.append("end ====================================================================================\n\n");
            QLog.i("Q.qqhead.FaceHandler", 2, sb5.toString());
        }
    }

    private synchronized void E2() {
        this.f195517d.getCurrentAccountUin();
        Enumeration<Integer> keys = this.f195518e.keys();
        while (keys.hasMoreElements()) {
            int intValue = keys.nextElement().intValue();
            ArrayList<FaceInfo> arrayList = this.f195518e.get(Integer.valueOf(intValue));
            if (intValue != 200 && intValue != 202) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqhead.FaceHandler", 2, "checkWaitingRequests,key =" + intValue);
                }
            }
            M2(intValue, arrayList);
        }
        this.f195518e.clear();
    }

    private void F2(List<MultiHeadUrl.RspUsrHeadInfo> list, List<FaceInfo> list2, ArrayList<FaceInfo> arrayList, List<FaceInfo> list3, int i3, int i16, IQQAvatarManagerService iQQAvatarManagerService) {
        boolean z16;
        String str;
        Iterator<FaceInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FaceInfo next = it.next();
            next.markTime(FaceInfo.TIME_END_DOWNLOADINFO);
            for (MultiHeadUrl.RspUsrHeadInfo rspUsrHeadInfo : list) {
                String H2 = H2(i3, rspUsrHeadInfo);
                if (next.uin.equals(H2)) {
                    Iterator<MultiHeadUrl.RspHeadInfo> it5 = rspUsrHeadInfo.dstHeadInfos.get().iterator();
                    MultiHeadUrl.RspHeadInfo rspHeadInfo = null;
                    MultiHeadUrl.RspHeadInfo rspHeadInfo2 = null;
                    while (true) {
                        z16 = true;
                        if (!it5.hasNext()) {
                            break;
                        }
                        MultiHeadUrl.RspHeadInfo next2 = it5.next();
                        int i17 = next2.usrType.get();
                        if (i17 == 1) {
                            rspHeadInfo2 = next2;
                        } else if (i17 == 32 && next2.faceType.get() != 0) {
                            rspHeadInfo = next2;
                        }
                    }
                    if (rspHeadInfo == null) {
                        if (rspHeadInfo2 != null) {
                            rspHeadInfo = rspHeadInfo2;
                        } else if (QLog.isColorLevel()) {
                            QLog.d("Q.qqhead.FaceHandler", 2, "there is no headinfo uin=" + H2);
                        }
                    }
                    Setting faceSetting = iQQAvatarManagerService.getFaceSetting("stranger_" + String.valueOf(next.idType) + "_" + next.uin);
                    if (iQQAvatarManagerService.isFaceFileExist(next) && faceSetting != null && faceSetting.headImgTimestamp == rspHeadInfo.timestamp.get()) {
                        list2.add(next);
                        z16 = false;
                    }
                    if (z16) {
                        QQHeadInfo qQHeadInfo = new QQHeadInfo();
                        qQHeadInfo.headLevel = next.headLevel;
                        qQHeadInfo.idType = i16;
                        qQHeadInfo.phoneNum = H2;
                        qQHeadInfo.dwTimestamp = rspHeadInfo.timestamp.get();
                        qQHeadInfo.cHeadType = (byte) rspHeadInfo.faceType.get();
                        qQHeadInfo.dstUsrType = (byte) 32;
                        qQHeadInfo.dwFaceFlgas = (byte) rspHeadInfo.faceFlag.get();
                        qQHeadInfo.downLoadUrl = rspHeadInfo.url.get();
                        qQHeadInfo.systemHeadID = (short) rspHeadInfo.sysid.get();
                        qQHeadInfo.originUsrType = rspHeadInfo.usrType.get();
                        if (rspHeadInfo.headVerify.has()) {
                            str = rspHeadInfo.headVerify.get();
                        } else {
                            str = "";
                        }
                        qQHeadInfo.headVerify = str;
                        next.mHeadInfo = qQHeadInfo;
                        list3.add(next);
                    }
                }
            }
        }
    }

    private String H2(int i3, MultiHeadUrl.RspUsrHeadInfo rspUsrHeadInfo) {
        if (i3 == 0) {
            return String.valueOf(rspUsrHeadInfo.dstUin.get());
        }
        if (i3 == 1) {
            return String.valueOf(rspUsrHeadInfo.dstTid.get());
        }
        return rspUsrHeadInfo.dstOpenid.get();
    }

    private void I2(ToServiceMsg toServiceMsg, int i3) {
        int i16;
        ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("list");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleGetQQHeadError, result=");
        sb5.append(i3);
        sb5.append(", listSize=");
        if (parcelableArrayList != null) {
            i16 = parcelableArrayList.size();
        } else {
            i16 = -1;
        }
        sb5.append(i16);
        if (parcelableArrayList != null && parcelableArrayList.size() != 0) {
            for (int i17 = 0; i17 < parcelableArrayList.size(); i17++) {
                FaceInfo faceInfo = (FaceInfo) parcelableArrayList.get(i17);
                L2(faceInfo.getFaceKey(), false);
                sb5.append("info=");
                sb5.append(faceInfo);
            }
            QLog.i("Q.qqhead.FaceHandler", 1, sb5.toString());
            return;
        }
        QLog.i("Q.qqhead.FaceHandler", 1, sb5.toString());
    }

    private void M2(int i3, ArrayList<FaceInfo> arrayList) {
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("realGetStrangerFace");
            sb5.append(", size=");
            if (arrayList != null) {
                i17 = arrayList.size();
            } else {
                i17 = 0;
            }
            sb5.append(i17);
            if (arrayList != null) {
                for (int i18 = 0; i18 < arrayList.size(); i18++) {
                    sb5.append(',');
                    sb5.append(arrayList.get(i18));
                }
            }
            QLog.i("Q.qqhead.FaceHandler", 2, sb5.toString());
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (i3 == 202) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            MultiHeadUrl.MultiBusidUrlReq multiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
            multiBusidUrlReq.srcUidType.set(0);
            multiBusidUrlReq.srcUin.set(Long.parseLong(this.f195517d.getCurrentAccountUin()));
            multiBusidUrlReq.dstUsrType.add(1);
            multiBusidUrlReq.dstUsrType.add(32);
            multiBusidUrlReq.dstUidType.set(i16);
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                FaceInfo faceInfo = arrayList.get(i19);
                MultiHeadUrl.ReqUsrInfo reqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
                if (i16 == 0) {
                    try {
                        reqUsrInfo.dstUin.set(Long.parseLong(faceInfo.uin));
                    } catch (Exception unused) {
                    }
                } else if (i16 == 1) {
                    reqUsrInfo.dstTid.set(Long.parseLong(faceInfo.uin));
                }
                multiBusidUrlReq.dstUsrInfos.add(reqUsrInfo);
                faceInfo.markTime(FaceInfo.TIME_BEGIN_DOWNLOADINFO);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("QQHead_Stranger request.srcUidType=" + multiBusidUrlReq.srcUidType.get());
                sb6.append(";srcUin=" + this.f195517d.getCurrentAccountUin());
                sb6.append("\n\n");
                sb6.append(";dstUsrType=" + multiBusidUrlReq.dstUsrType.get());
                sb6.append(";dstUidType=" + multiBusidUrlReq.dstUidType.get());
                sb6.append("\n\n");
                sb6.append(";uinset={");
                for (int i26 = 0; i26 < arrayList.size(); i26++) {
                    sb6.append(arrayList.get(i26) + ",");
                }
                sb6.append("}");
                QLog.i("Q.qqhead.FaceHandler", 2, sb6.toString());
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
            createToServiceMsg.extraData.putParcelableArrayList("list", arrayList);
            createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
            createToServiceMsg.extraData.putInt("idType", i3);
            createToServiceMsg.putWupBuffer(multiBusidUrlReq.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    public void G2(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) faceInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceHandler", 2, "getStrangerFaceInfo.faceInfo=" + faceInfo);
        }
        String faceKey = faceInfo.getFaceKey();
        if (K2(faceKey)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.FaceHandler", 2, "getStrangerFaceInfo|repeat info=" + faceInfo);
                return;
            }
            return;
        }
        L2(faceKey, true);
        ArrayList<FaceInfo> arrayList = this.f195518e.get(Integer.valueOf(faceInfo.idType));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f195518e.put(Integer.valueOf(faceInfo.idType), arrayList);
        }
        arrayList.add(faceInfo);
        E2();
    }

    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        MultiHeadUrl.MultiBusidUrlRsp multiBusidUrlRsp = null;
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
                    MultiHeadUrl.MultiBusidUrlRsp multiBusidUrlRsp2 = new MultiHeadUrl.MultiBusidUrlRsp();
                    multiBusidUrlRsp2.mergeFrom((byte[]) obj);
                    multiBusidUrlRsp = multiBusidUrlRsp2;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqhead.FaceHandler", 2, "handleStrangerFaceResp multiBusidUrlRsp mergeFrom exception..." + e16.getMessage());
                }
                e16.printStackTrace();
            }
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && multiBusidUrlRsp != null && multiBusidUrlRsp.result.get() == 0) {
            D2(multiBusidUrlRsp);
            List<MultiHeadUrl.RspUsrHeadInfo> list = multiBusidUrlRsp.dstUsrHeadInfos.get();
            List<FaceInfo> arrayList = new ArrayList<>();
            ArrayList<FaceInfo> parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("list");
            List<FaceInfo> arrayList2 = new ArrayList<>();
            int i16 = multiBusidUrlRsp.dstUidType.get();
            int i17 = toServiceMsg.extraData.getInt("idType");
            QQAvatarManagerServiceImpl qQAvatarManagerServiceImpl = (QQAvatarManagerServiceImpl) this.f195517d.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
            F2(list, arrayList, parcelableArrayList, arrayList2, i16, i17, qQAvatarManagerServiceImpl);
            for (int i18 = 0; i18 < arrayList2.size(); i18++) {
                qQAvatarManagerServiceImpl.downloadFace(arrayList2.get(i18));
            }
            if (arrayList.size() > 0) {
                try {
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    for (int i19 = 0; i19 < arrayList.size(); i19++) {
                        FaceInfo faceInfo = arrayList.get(i19);
                        arrayList3.add("stranger_" + String.valueOf(i17) + "_" + faceInfo.uin);
                        L2(faceInfo.getFaceKey(), false);
                    }
                    qQAvatarManagerServiceImpl.updateFaceTimestamp(arrayList3, System.currentTimeMillis());
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (multiBusidUrlRsp != null) {
            i3 = multiBusidUrlRsp.result.get();
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        I2(toServiceMsg, i3);
    }

    public boolean K2(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.f195520h) {
            if (this.f195519f.containsKey(str)) {
                if (Math.abs(System.currentTimeMillis() - this.f195519f.get(str).longValue()) > 60000) {
                    this.f195519f.remove(str);
                } else {
                    z16 = true;
                }
            }
            z16 = false;
        }
        if (!z16) {
            boolean e16 = cu.e();
            if ((e16 && cu.b() < 2048) || (!e16 && cu.c() < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE)) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.d("Q.qqhead.FaceHandler", 2, "getQQHead|fail, storage is not enough. key=" + str + ", isExistSDCard=" + e16);
                return true;
            }
            if (!e16 && !this.f195521i) {
                this.f195521i = true;
                FaceUtil.saveStoreQQHeadToApp(this.f195517d.getApp().getApplicationContext(), true);
            }
        }
        return z16;
    }

    public void L2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f195520h) {
            if (!z16) {
                this.f195519f.remove(str);
            } else {
                if (this.f195519f.size() > 30) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    Enumeration<String> keys = this.f195519f.keys();
                    while (keys.hasMoreElements()) {
                        if (Math.abs(currentTimeMillis - this.f195519f.get(keys.nextElement()).longValue()) > 60000) {
                            arrayList.add(str);
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        this.f195519f.remove(str);
                    }
                }
                this.f195519f.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("MultibusidURLSvr.HeadUrlReq");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return FaceObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.FaceHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        if ("MultibusidURLSvr.HeadUrlReq".equals(fromServiceMsg.getServiceCmd())) {
            J2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
