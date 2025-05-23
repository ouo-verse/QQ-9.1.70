package com.tencent.mobileqq.avatar.handler;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl;
import com.tencent.avatarinfo.QQHeadUrl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.face.bean.QQHeadDetails;
import com.tencent.mobileqq.app.face.bean.QQHeadStat;
import com.tencent.mobileqq.app.face.i;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.avatar.a;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQClassicAvatarService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.utils.b;
import com.tencent.mobileqq.avatar.utils.c;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jf.dexlib2.analysis.RegisterType;
import tencent.im.oidb.cmd0xedb.oidb_0xedb$ReqBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb$ReqUsrInfo;
import tencent.im.oidb.cmd0xedb.oidb_0xedb$RspBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb$RspHeadInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AvatarHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private QQHeadDownloadHandler C;
    private final Object D;
    private final Hashtable<String, QQHeadStat> E;
    private boolean F;
    private boolean G;
    private final a H;

    /* renamed from: d, reason: collision with root package name */
    public AppInterface f200102d;

    /* renamed from: e, reason: collision with root package name */
    private MqqHandler f200103e;

    /* renamed from: f, reason: collision with root package name */
    private int f200104f;

    /* renamed from: h, reason: collision with root package name */
    private final Hashtable<Integer, RecordArrayList<QQHeadDetails>> f200105h;

    /* renamed from: i, reason: collision with root package name */
    private final Hashtable<String, Long> f200106i;

    /* renamed from: m, reason: collision with root package name */
    private final Object f200107m;

    protected AvatarHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f200104f = 0;
        this.f200105h = new Hashtable<>();
        this.f200106i = new Hashtable<>();
        this.f200107m = new Object();
        this.D = new Object();
        this.E = new Hashtable<>();
        this.F = false;
        this.G = false;
        this.H = new a("qq_avatar_info_batch_request_switch", true);
        this.f200102d = appInterface;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x01b1, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:6:0x0017, B:8:0x001b, B:10:0x0021, B:11:0x003b, B:90:0x0045, B:17:0x0053, B:19:0x0059, B:23:0x0073, B:24:0x0079, B:26:0x007f, B:28:0x009b, B:29:0x00b3, B:31:0x00ba, B:33:0x00c7, B:34:0x00cb, B:36:0x00d1, B:38:0x00f8, B:39:0x0110, B:42:0x0125, B:44:0x012b, B:47:0x0133, B:48:0x0137, B:50:0x013d, B:82:0x014c, B:79:0x0154, B:73:0x015c, B:75:0x0162, B:76:0x017a, B:66:0x0182, B:69:0x018b, B:62:0x01a4, B:88:0x01a8), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[Catch: all -> 0x01b1, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:6:0x0017, B:8:0x001b, B:10:0x0021, B:11:0x003b, B:90:0x0045, B:17:0x0053, B:19:0x0059, B:23:0x0073, B:24:0x0079, B:26:0x007f, B:28:0x009b, B:29:0x00b3, B:31:0x00ba, B:33:0x00c7, B:34:0x00cb, B:36:0x00d1, B:38:0x00f8, B:39:0x0110, B:42:0x0125, B:44:0x012b, B:47:0x0133, B:48:0x0137, B:50:0x013d, B:82:0x014c, B:79:0x0154, B:73:0x015c, B:75:0x0162, B:76:0x017a, B:66:0x0182, B:69:0x018b, B:62:0x01a4, B:88:0x01a8), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void G2() {
        long longValue;
        String str;
        this.f200103e.removeMessages(0);
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "doExecuteGetQQHead start !!! ");
        }
        if (this.f200104f > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.AvatarHandler", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.f200104f);
            }
            String account = this.f200102d.getAccount();
            if (account != null) {
                try {
                    longValue = Long.valueOf(account).longValue();
                } catch (Exception unused) {
                }
                if (longValue != -1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.AvatarHandler", 2, "doExecuteGetQQHead|myUin error: myUin=" + account);
                    }
                    return;
                }
                Enumeration<Integer> keys = this.f200105h.keys();
                while (keys.hasMoreElements()) {
                    int intValue = keys.nextElement().intValue();
                    RecordArrayList<QQHeadDetails> recordArrayList = this.f200105h.get(Integer.valueOf(intValue));
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.AvatarHandler", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + intValue);
                    }
                    List list = null;
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=");
                        sb5.append(intValue);
                        if (recordArrayList != null) {
                            for (QQHeadDetails qQHeadDetails : recordArrayList) {
                                sb5.append(" QQheadDetail uinOrMobile=");
                                sb5.append(StringUtil.getSimpleUinForPrint(qQHeadDetails.uinOrMobile));
                                sb5.append(",Timestamp=");
                                sb5.append(qQHeadDetails.headImgTimestamp);
                                sb5.append("|");
                            }
                            str = "" + recordArrayList.size();
                        } else {
                            str = null;
                        }
                        sb5.append(" QQHeadDetailList length = ");
                        sb5.append(str);
                        QLog.d("Q.qqhead.AvatarHandler", 2, sb5.toString());
                    }
                    if (recordArrayList != null && !recordArrayList.isEmpty()) {
                        list = b.j(recordArrayList, 50);
                    }
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ArrayList<QQHeadDetails> arrayList = new ArrayList<>((List) it.next());
                            if (intValue == 11) {
                                t3(longValue, intValue, arrayList);
                            } else if (intValue == 116) {
                                u3(longValue, intValue, arrayList);
                            } else if (intValue >= 200) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("Q.qqhead.AvatarHandler", 2, "realGetQQHead_Stranger = " + intValue);
                                }
                                x3(intValue, arrayList);
                            } else if (intValue == 16) {
                                w3(intValue, arrayList);
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("Q.qqhead.AvatarHandler", 2, "FaceConstant.HeadType.QQHEAD_TYPE_QCALL = " + intValue);
                                }
                            } else {
                                H2(longValue, intValue, arrayList);
                            }
                        }
                    }
                }
                this.f200104f = 0;
                this.f200105h.clear();
            }
            longValue = -1;
            if (longValue != -1) {
            }
        }
    }

    private void H2(long j3, int i3, ArrayList<QQHeadDetails> arrayList) {
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && i3 == 1) {
            AvatarNewTechHandler.f200124a.b(this, j3, i3, arrayList);
        } else {
            v3(j3, i3, arrayList);
        }
    }

    private void I2(FaceInfo faceInfo) {
        if (AvatarOptimiseConfigUtil.a()) {
            i.a(this, faceInfo);
        } else {
            this.C.addDownloadRequest(faceInfo);
        }
    }

    public static oidb_0xedb$ReqBody J2(ArrayList<QQHeadDetails> arrayList) {
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<QQHeadDetails> it = arrayList.iterator();
            while (it.hasNext()) {
                QQHeadDetails next = it.next();
                long parseLong = Long.parseLong(next.uinOrMobile);
                int i3 = (int) next.headImgTimestamp;
                oidb_0xedb$ReqUsrInfo oidb_0xedb_requsrinfo = new oidb_0xedb$ReqUsrInfo();
                oidb_0xedb_requsrinfo.dstUin.set(parseLong);
                oidb_0xedb_requsrinfo.timestamp.set(i3);
                arrayList2.add(oidb_0xedb_requsrinfo);
            }
            if (!arrayList2.isEmpty()) {
                oidb_0xedb$ReqBody oidb_0xedb_reqbody = new oidb_0xedb$ReqBody();
                oidb_0xedb_reqbody.dstUsrType.set(3);
                oidb_0xedb_reqbody.dstUsrInfos.addAll(arrayList2);
                return oidb_0xedb_reqbody;
            }
        }
        return null;
    }

    private void M2(byte b16, byte b17, QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp, ArrayList<QQHeadDetails> arrayList, List<QQHeadDetails> list, List<QQHeadInfo> list2) {
        byte b18;
        String valueOf;
        String str;
        if (arrayList != null && arrayList.size() > 0) {
            List<QQHeadUrl.RspHeadInfo> list3 = qQHeadUrlRsp.dstHeadInfos.get();
            Iterator<QQHeadDetails> it = arrayList.iterator();
            while (it.hasNext()) {
                QQHeadDetails next = it.next();
                Iterator<QQHeadUrl.RspHeadInfo> it5 = list3.iterator();
                while (true) {
                    b18 = 0;
                    if (!it5.hasNext()) {
                        break;
                    }
                    QQHeadUrl.RspHeadInfo next2 = it5.next();
                    if (b17 == 1) {
                        valueOf = next2.dstUid.get();
                    } else {
                        valueOf = String.valueOf(next2.dstUin.get());
                    }
                    if (next.uinOrMobile.equals(valueOf)) {
                        QQHeadInfo qQHeadInfo = new QQHeadInfo();
                        qQHeadInfo.headLevel = next.level;
                        if (b17 == 1) {
                            qQHeadInfo.phoneNum = next2.dstUid.get();
                        } else {
                            qQHeadInfo.uin = next2.dstUin.get();
                        }
                        qQHeadInfo.dwTimestamp = next2.timestamp.get();
                        qQHeadInfo.cHeadType = (byte) next2.faceType.get();
                        qQHeadInfo.dstUsrType = b16;
                        qQHeadInfo.dwFaceFlgas = (byte) next2.faceFlag.get();
                        qQHeadInfo.downLoadUrl = next2.url.get();
                        qQHeadInfo.systemHeadID = (short) next2.sysid.get();
                        if (next2.headVerify.has()) {
                            str = next2.headVerify.get();
                        } else {
                            str = "";
                        }
                        qQHeadInfo.headVerify = str;
                        if (next2.apngFaceFlag.has()) {
                            b18 = (byte) next2.apngFaceFlag.get();
                        }
                        qQHeadInfo.apngFaceFlag = b18;
                        list2.add(qQHeadInfo);
                        if (b16 == 1) {
                            long j3 = qQHeadInfo.uin;
                            if (j3 > 0) {
                                c.s(String.valueOf(j3), qQHeadInfo.downLoadUrl);
                            }
                        }
                        b18 = 1;
                    }
                }
                if (b18 == 0) {
                    list.add(next);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N2(int i3, List<MultiHeadUrl.RspUsrHeadInfo> list, ArrayList<QQHeadDetails> arrayList, List<QQHeadDetails> list2, List<QQHeadInfo> list3) {
        boolean z16;
        boolean z17;
        Iterator<QQHeadDetails> it = arrayList.iterator();
        while (it.hasNext()) {
            QQHeadDetails next = it.next();
            for (MultiHeadUrl.RspUsrHeadInfo rspUsrHeadInfo : list) {
                String h16 = b.h(rspUsrHeadInfo.dstUin.get());
                if (next.uinOrMobile.equals(h16)) {
                    MultiHeadUrl.RspHeadInfo rspHeadInfo = null;
                    for (MultiHeadUrl.RspHeadInfo rspHeadInfo2 : rspUsrHeadInfo.dstHeadInfos.get()) {
                        rspHeadInfo2.usrType.get();
                        if (rspHeadInfo2.faceType.get() != 0) {
                            rspHeadInfo = rspHeadInfo2;
                        }
                    }
                    if (rspHeadInfo != null) {
                        String str = "";
                        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "");
                        Pair<Boolean, Setting> qQHeadSetting = iQQAvatarDataService.getQQHeadSetting(16, h16, i3);
                        if (!iQQAvatarDataService.isFaceFileExist(16, h16, i3, 0)) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i(LogTag.QQ_HEAD, 2, "handleQQHead_QCALL file not exist.id=" + h16 + ",idType=" + i3);
                            }
                        } else if (qQHeadSetting != null) {
                            Setting setting = (Setting) qQHeadSetting.second;
                            if (QLog.isDevelopLevel()) {
                                QLog.i(LogTag.QQ_HEAD, 2, "handleQQHead_QCALL setting=" + setting + "targetInfo.timestamp=" + rspHeadInfo.timestamp.get());
                            }
                            if (setting == null || setting.headImgTimestamp != rspHeadInfo.timestamp.get()) {
                                z16 = true;
                            } else {
                                list2.add(next);
                                z16 = false;
                            }
                            z17 = z16;
                            if (!z17) {
                                QQHeadInfo qQHeadInfo = new QQHeadInfo();
                                qQHeadInfo.headLevel = next.level;
                                qQHeadInfo.idType = i3;
                                qQHeadInfo.phoneNum = h16;
                                qQHeadInfo.dwTimestamp = rspHeadInfo.timestamp.get();
                                qQHeadInfo.cHeadType = (byte) rspHeadInfo.faceType.get();
                                qQHeadInfo.dstUsrType = RegisterType.UNINIT_REF;
                                qQHeadInfo.dwFaceFlgas = (byte) rspHeadInfo.faceFlag.get();
                                qQHeadInfo.downLoadUrl = rspHeadInfo.url.get();
                                qQHeadInfo.systemHeadID = (short) rspHeadInfo.sysid.get();
                                qQHeadInfo.originUsrType = rspHeadInfo.usrType.get();
                                if (rspHeadInfo.headVerify.has()) {
                                    str = rspHeadInfo.headVerify.get();
                                }
                                qQHeadInfo.headVerify = str;
                                list3.add(qQHeadInfo);
                            }
                        }
                        z17 = true;
                        if (!z17) {
                        }
                    } else if (QLog.isDevelopLevel()) {
                        QLog.d("headqcall", 2, "there is no headinfo uin=" + h16);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O2(int i3, int i16, List<MultiHeadUrl.RspUsrHeadInfo> list, ArrayList<QQHeadDetails> arrayList, List<QQHeadDetails> list2, List<QQHeadInfo> list3) {
        String str;
        Iterator<QQHeadDetails> it = arrayList.iterator();
        while (it.hasNext()) {
            QQHeadDetails next = it.next();
            for (MultiHeadUrl.RspUsrHeadInfo rspUsrHeadInfo : list) {
                boolean z16 = true;
                if (i16 == 0) {
                    str = String.valueOf(rspUsrHeadInfo.dstUin.get());
                } else if (i16 == 1) {
                    str = String.valueOf(rspUsrHeadInfo.dstTid.get());
                } else {
                    str = rspUsrHeadInfo.dstOpenid.get();
                }
                if (next.uinOrMobile.equals(str)) {
                    MultiHeadUrl.RspHeadInfo rspHeadInfo = null;
                    MultiHeadUrl.RspHeadInfo rspHeadInfo2 = null;
                    for (MultiHeadUrl.RspHeadInfo rspHeadInfo3 : rspUsrHeadInfo.dstHeadInfos.get()) {
                        int i17 = rspHeadInfo3.usrType.get();
                        if (i17 == 1) {
                            rspHeadInfo2 = rspHeadInfo3;
                        } else if (i17 == 32 && rspHeadInfo3.faceType.get() != 0) {
                            rspHeadInfo = rspHeadInfo3;
                        }
                    }
                    if (rspHeadInfo == null) {
                        if (rspHeadInfo2 != null) {
                            rspHeadInfo = rspHeadInfo2;
                        } else if (QLog.isDevelopLevel()) {
                            QLog.d("headstranger", 2, "there is no headinfo uin=" + str);
                        }
                    }
                    String str2 = "";
                    IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "");
                    Pair<Boolean, Setting> qQHeadSetting = iQQAvatarDataService.getQQHeadSetting(32, str, i3);
                    if (iQQAvatarDataService.isFaceFileExist(32, str, i3, 0)) {
                        if (qQHeadSetting != null) {
                            Setting setting = (Setting) qQHeadSetting.second;
                            if (setting != null) {
                                if (setting.headImgTimestamp == rspHeadInfo.timestamp.get()) {
                                    list2.add(next);
                                    z16 = false;
                                    if (z16) {
                                        QQHeadInfo qQHeadInfo = new QQHeadInfo();
                                        qQHeadInfo.headLevel = next.level;
                                        qQHeadInfo.idType = i3;
                                        qQHeadInfo.phoneNum = str;
                                        qQHeadInfo.dwTimestamp = rspHeadInfo.timestamp.get();
                                        qQHeadInfo.cHeadType = (byte) rspHeadInfo.faceType.get();
                                        qQHeadInfo.dstUsrType = (byte) 32;
                                        qQHeadInfo.dwFaceFlgas = (byte) rspHeadInfo.faceFlag.get();
                                        qQHeadInfo.downLoadUrl = rspHeadInfo.url.get();
                                        qQHeadInfo.systemHeadID = (short) rspHeadInfo.sysid.get();
                                        qQHeadInfo.originUsrType = rspHeadInfo.usrType.get();
                                        if (rspHeadInfo.headVerify.has()) {
                                            str2 = rspHeadInfo.headVerify.get();
                                        }
                                        qQHeadInfo.headVerify = str2;
                                        list3.add(qQHeadInfo);
                                    } else {
                                        notifyUI(4, true, new Object[]{next.uinOrMobile, Integer.valueOf(i3), Boolean.TRUE});
                                    }
                                }
                            }
                        }
                        z16 = true;
                        if (z16) {
                        }
                    }
                    if (z16) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void X2(int i3, String str, int i16, byte b16, byte b17, int i17, boolean z16) {
        Y2(i3, str, i16, b16, b17, i17, z16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0217 A[Catch: all -> 0x024a, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000d, B:8:0x0016, B:12:0x0020, B:14:0x002a, B:16:0x0030, B:18:0x0043, B:19:0x004a, B:21:0x0055, B:23:0x005b, B:28:0x0076, B:30:0x008b, B:34:0x00be, B:36:0x00d2, B:40:0x00e3, B:41:0x00e6, B:43:0x00f5, B:44:0x011c, B:48:0x0127, B:50:0x0136, B:52:0x0145, B:56:0x01ca, B:59:0x01e4, B:61:0x01f0, B:64:0x0211, B:66:0x0217, B:69:0x0243, B:72:0x0152, B:74:0x0158, B:76:0x0162, B:77:0x016b, B:79:0x0171, B:82:0x0194, B:83:0x018e, B:87:0x01ac, B:89:0x01bf, B:91:0x01c3, B:95:0x013b), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0243 A[Catch: all -> 0x024a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000d, B:8:0x0016, B:12:0x0020, B:14:0x002a, B:16:0x0030, B:18:0x0043, B:19:0x004a, B:21:0x0055, B:23:0x005b, B:28:0x0076, B:30:0x008b, B:34:0x00be, B:36:0x00d2, B:40:0x00e3, B:41:0x00e6, B:43:0x00f5, B:44:0x011c, B:48:0x0127, B:50:0x0136, B:52:0x0145, B:56:0x01ca, B:59:0x01e4, B:61:0x01f0, B:64:0x0211, B:66:0x0217, B:69:0x0243, B:72:0x0152, B:74:0x0158, B:76:0x0162, B:77:0x016b, B:79:0x0171, B:82:0x0194, B:83:0x018e, B:87:0x01ac, B:89:0x01bf, B:91:0x01c3, B:95:0x013b), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0158 A[Catch: all -> 0x024a, TryCatch #0 {, blocks: (B:4:0x000d, B:8:0x0016, B:12:0x0020, B:14:0x002a, B:16:0x0030, B:18:0x0043, B:19:0x004a, B:21:0x0055, B:23:0x005b, B:28:0x0076, B:30:0x008b, B:34:0x00be, B:36:0x00d2, B:40:0x00e3, B:41:0x00e6, B:43:0x00f5, B:44:0x011c, B:48:0x0127, B:50:0x0136, B:52:0x0145, B:56:0x01ca, B:59:0x01e4, B:61:0x01f0, B:64:0x0211, B:66:0x0217, B:69:0x0243, B:72:0x0152, B:74:0x0158, B:76:0x0162, B:77:0x016b, B:79:0x0171, B:82:0x0194, B:83:0x018e, B:87:0x01ac, B:89:0x01bf, B:91:0x01c3, B:95:0x013b), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void Y2(int i3, String str, int i16, byte b16, byte b17, int i17, boolean z16, FaceInfo faceInfo) {
        String str2;
        int i18;
        boolean z17;
        RecordArrayList<QQHeadDetails> recordArrayList;
        long j3;
        long j16;
        long j17;
        Pair<Boolean, Setting> qQHeadSetting;
        Object obj;
        Object valueOf;
        RecordArrayList<QQHeadDetails> recordArrayList2;
        Pair<Boolean, Setting> qQHeadSetting2;
        if (!TextUtils.isEmpty(str) && (i3 != 1 || StringUtil.isValideUin(str))) {
            if (i3 == 1) {
                str2 = str.trim();
            } else {
                str2 = str;
            }
            if (faceInfo != null && !faceInfo.hasUpdateFromSetting() && (qQHeadSetting2 = ((IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(i3, str2, i16)) != null) {
                faceInfo.updateZplanAvatarInfoFromSetting((Setting) qQHeadSetting2.second);
            }
            String i19 = c.i(i3, str2, i16, i17, faceInfo);
            if (!q3(i19)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.AvatarHandler", 2, "markDownloadedQQHead, noNeedDownload= " + i19);
                }
                return;
            }
            r3(i19, false);
            boolean isInRealActionLoginB = ((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isInRealActionLoginB();
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.AvatarHandler", 2, "markDownloadedQQHead end keyStr = " + i19 + ",isImmediatelyGet=" + this.G + ",InActionLoginB=" + isInRealActionLoginB);
            }
            if (i3 == 32) {
                i18 = i16;
            } else {
                i18 = i3;
            }
            this.f200104f++;
            RecordArrayList<QQHeadDetails> recordArrayList3 = this.f200105h.get(Integer.valueOf(i18));
            if (recordArrayList3 == null) {
                recordArrayList3 = new RecordArrayList<>(i18);
                if (this.H.b() && (i18 == 1 || i18 == 4)) {
                    recordArrayList3.setEnableRecord(true);
                }
                this.f200105h.put(Integer.valueOf(i18), recordArrayList3);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.AvatarHandler", 2, "FaceConstant.HeadType.QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i18 + "destQQHeadInfoTable.size = " + this.f200105h.size());
                }
            }
            RecordArrayList<QQHeadDetails> recordArrayList4 = recordArrayList3;
            if (!AvatarOptimiseConfigUtil.a()) {
                if (b17 != 1) {
                    if (b17 != 2) {
                        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "");
                        if (faceInfo != null) {
                            z17 = iQQAvatarDataService.isFaceFileExist(faceInfo);
                        } else {
                            z17 = iQQAvatarDataService.isFaceFileExist(i3, str2, i16, i17);
                        }
                    }
                } else {
                    z17 = true;
                }
                if (!z17 && !AvatarOptimiseConfigUtil.a()) {
                    recordArrayList = recordArrayList4;
                    j17 = 0;
                    QQHeadDetails qQHeadDetails = new QQHeadDetails(i3, str2, j17, b16, i17);
                    qQHeadDetails.faceInfo = faceInfo;
                    recordArrayList2 = recordArrayList;
                    recordArrayList2.add(qQHeadDetails);
                    if (this.G && isInRealActionLoginB && !TextUtils.equals(str2, this.f200102d.getAccount())) {
                        QLog.i("Q.qqhead.AvatarHandler", 1, "getQQHead: " + i19 + " isImmediatelyGet= false InActionLoginB= true");
                        return;
                    }
                    if (!recordArrayList2.isIncreaseQuickly()) {
                        QLog.i("Q.qqhead.AvatarHandler", 2, "getQQHead isIncreaseQuickly. size: " + recordArrayList2.size());
                        this.f200103e.removeMessages(0);
                        this.f200103e.sendEmptyMessageDelayed(0, 30L);
                        return;
                    }
                    G2();
                    return;
                }
                if (!ProAvatarComponentInit.c()) {
                    String j18 = c.j(i3, str2, i16);
                    AvatarInfoEntity a16 = ProAvatarComponentInit.a(j18, true);
                    if (a16 != null) {
                        recordArrayList = recordArrayList4;
                        j16 = a16.headImgTimestamp;
                    } else {
                        recordArrayList = recordArrayList4;
                        j16 = 0;
                    }
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAvatarInfoEntity [");
                        sb5.append(j18);
                        sb5.append("] headImgTimestamp: ");
                        if (a16 == null) {
                            valueOf = "null";
                        } else {
                            valueOf = Long.valueOf(a16.headImgTimestamp);
                        }
                        sb5.append(valueOf);
                        QLog.d("Q.qqhead.AvatarHandler", 4, sb5.toString());
                    }
                    j3 = 0;
                } else {
                    recordArrayList = recordArrayList4;
                    j3 = 0;
                    j16 = 0;
                }
                if (j16 > j3 && (qQHeadSetting = ((IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(i3, str2, i16)) != null && (obj = qQHeadSetting.second) != null) {
                    j17 = ((Setting) obj).headImgTimestamp;
                } else {
                    j17 = j16;
                }
                QQHeadDetails qQHeadDetails2 = new QQHeadDetails(i3, str2, j17, b16, i17);
                qQHeadDetails2.faceInfo = faceInfo;
                recordArrayList2 = recordArrayList;
                recordArrayList2.add(qQHeadDetails2);
                if (this.G) {
                }
                if (!recordArrayList2.isIncreaseQuickly()) {
                }
            }
            z17 = false;
            if (!z17) {
                recordArrayList = recordArrayList4;
                j17 = 0;
                QQHeadDetails qQHeadDetails22 = new QQHeadDetails(i3, str2, j17, b16, i17);
                qQHeadDetails22.faceInfo = faceInfo;
                recordArrayList2 = recordArrayList;
                recordArrayList2.add(qQHeadDetails22);
                if (this.G) {
                }
                if (!recordArrayList2.isIncreaseQuickly()) {
                }
            }
            if (!ProAvatarComponentInit.c()) {
            }
            if (j16 > j3) {
            }
            j17 = j16;
            QQHeadDetails qQHeadDetails222 = new QQHeadDetails(i3, str2, j17, b16, i17);
            qQHeadDetails222.faceInfo = faceInfo;
            recordArrayList2 = recordArrayList;
            recordArrayList2.add(qQHeadDetails222);
            if (this.G) {
            }
            if (!recordArrayList2.isIncreaseQuickly()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Z2(FaceInfo faceInfo) {
        if (faceInfo == null) {
            QLog.e("Q.qqhead.AvatarHandler", 1, "getQQHead faceInfo is null");
        } else {
            Y2(faceInfo.headType, faceInfo.uin, faceInfo.idType, faceInfo.headLevel, faceInfo.faceFileType, faceInfo.sizeType, false, faceInfo);
        }
    }

    private void a3(int i3, String str, int i16, byte b16, byte b17, int i17, boolean z16) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(i3, str, i16, b16, b17, i17, z16) { // from class: com.tencent.mobileqq.avatar.handler.AvatarHandler.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f200117d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f200118e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f200119f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ byte f200120h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ byte f200121i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f200122m;

                {
                    this.f200117d = i3;
                    this.f200118e = str;
                    this.f200119f = i16;
                    this.f200120h = b16;
                    this.f200121i = b17;
                    this.f200122m = i17;
                    this.C = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AvatarHandler.this, Integer.valueOf(i3), str, Integer.valueOf(i16), Byte.valueOf(b16), Byte.valueOf(b17), Integer.valueOf(i17), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AvatarHandler.this.X2(this.f200117d, this.f200118e, this.f200119f, this.f200120h, this.f200121i, this.f200122m, this.C);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, false);
        } else {
            X2(i3, str, i16, b16, b17, i17, z16);
        }
    }

    private void b3(int i3, String str, int i16, byte b16, byte b17, boolean z16) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(i3, str, i16, b16, b17, z16) { // from class: com.tencent.mobileqq.avatar.handler.AvatarHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f200111d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f200112e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f200113f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ byte f200114h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ byte f200115i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ boolean f200116m;

                {
                    this.f200111d = i3;
                    this.f200112e = str;
                    this.f200113f = i16;
                    this.f200114h = b16;
                    this.f200115i = b17;
                    this.f200116m = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AvatarHandler.this, Integer.valueOf(i3), str, Integer.valueOf(i16), Byte.valueOf(b16), Byte.valueOf(b17), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AvatarHandler.this.X2(this.f200111d, this.f200112e, this.f200113f, this.f200114h, this.f200115i, 0, this.f200116m);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, false);
        } else {
            X2(i3, str, i16, b16, b17, 0, z16);
        }
    }

    private void c3(@NonNull FaceInfo faceInfo) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(faceInfo) { // from class: com.tencent.mobileqq.avatar.handler.AvatarHandler.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FaceInfo f200123d;

                {
                    this.f200123d = faceInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarHandler.this, (Object) faceInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AvatarHandler.this.Z2(this.f200123d);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, false);
        } else {
            Z2(faceInfo);
        }
    }

    public static String h3(long j3, String str) {
        if (str == null || str.length() <= 0) {
            return String.valueOf(j3);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[LOOP:3: B:49:0x017c->B:51:0x0182, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        Iterator it;
        Iterator it5;
        byte b16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z18;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("key_request_list");
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && parcelableArrayList != null) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            } catch (Exception e16) {
                QLog.e("Q.qqhead.AvatarHandler", 1, "handleGetApolloHead fail.", e16);
            }
            if (z18) {
                oidb_0xedb$RspBody oidb_0xedb_rspbody = new oidb_0xedb$RspBody();
                oidb_0xedb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                HashMap hashMap = new HashMap();
                if (oidb_0xedb_rspbody.dstHeadInfos.has()) {
                    for (oidb_0xedb$RspHeadInfo oidb_0xedb_rspheadinfo : oidb_0xedb_rspbody.dstHeadInfos.get()) {
                        byte b17 = (byte) oidb_0xedb_rspheadinfo.faceType.get();
                        byte b18 = (byte) oidb_0xedb_rspheadinfo.faceFlag.get();
                        QQHeadInfo qQHeadInfo = new QQHeadInfo();
                        qQHeadInfo.uin = oidb_0xedb_rspheadinfo.dstUin.get();
                        qQHeadInfo.dwTimestamp = oidb_0xedb_rspheadinfo.timestamp.get();
                        qQHeadInfo.cHeadType = b17;
                        qQHeadInfo.dstUsrType = IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE;
                        qQHeadInfo.dwFaceFlgas = b18;
                        qQHeadInfo.downLoadUrl = oidb_0xedb_rspheadinfo.url.get();
                        hashMap.put(String.valueOf(qQHeadInfo.uin), qQHeadInfo);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it6 = parcelableArrayList.iterator();
                while (it6.hasNext()) {
                    QQHeadDetails qQHeadDetails = (QQHeadDetails) it6.next();
                    if (!hashMap.containsKey(qQHeadDetails.uinOrMobile)) {
                        arrayList3.add(qQHeadDetails);
                    } else {
                        QQHeadInfo qQHeadInfo2 = (QQHeadInfo) hashMap.get(qQHeadDetails.uinOrMobile);
                        qQHeadInfo2.headLevel = qQHeadDetails.level;
                        qQHeadInfo2.sizeType = qQHeadDetails.sizeType;
                        qQHeadInfo2.idType = 200;
                        arrayList4.add(qQHeadInfo2);
                    }
                }
                arrayList = arrayList3;
                arrayList2 = arrayList4;
                z16 = true;
                if (!QLog.isDevelopLevel()) {
                    z17 = false;
                    QLog.d("Q.qqhead.AvatarHandler", 2, String.format("handleGetApolloHead success=%s noChangeSize=%s changeSize=%s", Boolean.valueOf(z16), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size())));
                } else {
                    z17 = false;
                }
                if (z16) {
                    z3(arrayList2, z17);
                    l3(116, 200, arrayList);
                }
                it = arrayList.iterator();
                while (it.hasNext()) {
                    QQHeadDetails qQHeadDetails2 = (QQHeadDetails) it.next();
                    String str = qQHeadDetails2.uinOrMobile;
                    Setting setting = (Setting) ((IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(qQHeadDetails2.userType, qQHeadDetails2.uinOrMobile, 200).second;
                    if (setting != null) {
                        b16 = setting.bHeadType;
                    } else {
                        b16 = 0;
                    }
                    notifyUI(7, z16, new Object[]{str, Byte.valueOf(b16)});
                }
                it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    QQHeadInfo qQHeadInfo3 = (QQHeadInfo) it5.next();
                    notifyUI(7, z16, new Object[]{String.valueOf(qQHeadInfo3.uin), Byte.valueOf(qQHeadInfo3.cHeadType)});
                }
            }
        }
        z16 = false;
        if (!QLog.isDevelopLevel()) {
        }
        if (z16) {
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        it5 = arrayList2.iterator();
        while (it5.hasNext()) {
        }
    }

    private void j3(ToServiceMsg toServiceMsg, int i3) {
        int i16;
        ToServiceMsg toServiceMsg2 = toServiceMsg;
        ArrayList parcelableArrayList = toServiceMsg2.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleGetQQHeadError, result=");
        sb5.append(i3);
        sb5.append(", uinListSize=");
        if (parcelableArrayList != null) {
            i16 = parcelableArrayList.size();
        } else {
            i16 = -1;
        }
        sb5.append(i16);
        boolean z16 = true;
        if (parcelableArrayList != null && parcelableArrayList.size() != 0) {
            int i17 = 0;
            int i18 = 0;
            while (i18 < parcelableArrayList.size()) {
                QQHeadDetails qQHeadDetails = (QQHeadDetails) parcelableArrayList.get(i18);
                String i19 = c.i(qQHeadDetails.userType, qQHeadDetails.uinOrMobile, toServiceMsg2.extraData.getInt("idType", i17), i17, qQHeadDetails.faceInfo);
                r3(i19, z16);
                int i26 = i18;
                boolean z17 = z16;
                int i27 = i17;
                B3(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_GET_URL_FAIL, i19, qQHeadDetails.userType, 2, 0, null, i3, 0L);
                sb5.append("; uin=");
                sb5.append(i19);
                sb5.append(", timestamp=");
                sb5.append(qQHeadDetails.headImgTimestamp);
                IQQClassicAvatarService iQQClassicAvatarService = (IQQClassicAvatarService) this.f200102d.getRuntimeService(IQQClassicAvatarService.class, "");
                if (iQQClassicAvatarService != null && iQQClassicAvatarService.isClassicHeadActivityActivate()) {
                    iQQClassicAvatarService.handleGetHeadError(qQHeadDetails.uinOrMobile);
                }
                i18 = i26 + 1;
                z16 = z17;
                i17 = i27;
                toServiceMsg2 = toServiceMsg;
            }
            QLog.i("Q.qqhead.AvatarHandler", z16 ? 1 : 0, sb5.toString());
            return;
        }
        QLog.i("Q.qqhead.AvatarHandler", 1, sb5.toString());
    }

    private void k3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, QQHeadUrlResp qQHeadUrlResp) {
        int i3;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && qQHeadUrlResp != null && qQHeadUrlResp.result == 0 && qQHeadUrlResp.UserHeadInfoList != null) {
            ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                ArrayList<QQHeadInfo> arrayList = new ArrayList<>();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    QQHeadDetails qQHeadDetails = (QQHeadDetails) it.next();
                    Iterator<QQHeadInfo> it5 = qQHeadUrlResp.UserHeadInfoList.iterator();
                    while (it5.hasNext()) {
                        QQHeadInfo next = it5.next();
                        if ((next.dstUsrType != 11 && qQHeadDetails.uinOrMobile.equals(Long.toString(next.uin))) || (next.dstUsrType == 11 && qQHeadDetails.uinOrMobile.equals(next.phoneNum))) {
                            next.headLevel = qQHeadDetails.level;
                            arrayList.add(next);
                            break;
                        }
                    }
                }
                qQHeadUrlResp.UserHeadInfoList = arrayList;
            }
            p3();
            StringBuilder sb5 = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
            for (int i16 = 0; i16 < qQHeadUrlResp.UserHeadInfoList.size(); i16++) {
                QQHeadInfo qQHeadInfo = qQHeadUrlResp.UserHeadInfoList.get(i16);
                A3(0, g3(qQHeadInfo.dstUsrType, qQHeadInfo.uin, qQHeadInfo.phoneNum), qQHeadInfo.dstUsrType, 2);
                sb5.append(" qqHeadUrlResp id=");
                sb5.append(i16);
                sb5.append(" QQHeadInfo.uin=");
                sb5.append(StringUtil.getSimpleUinForPrint(Long.toString(qQHeadInfo.uin)));
                sb5.append(" QQHeadInfo.systemId=");
                sb5.append((int) qQHeadInfo.systemHeadID);
                sb5.append("  QQHeadInfo.headtype=");
                sb5.append((int) qQHeadInfo.cHeadType);
                sb5.append("|");
                FaceInfo faceInfo = new FaceInfo();
                faceInfo.mHeadInfo = qQHeadInfo;
                I2(faceInfo);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.AvatarHandler", 2, sb5.toString());
            }
            com.tencent.mobileqq.proavatar.info.a.o(qQHeadUrlResp.UserHeadInfoList);
            return;
        }
        if (qQHeadUrlResp != null) {
            i3 = qQHeadUrlResp.result;
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        j3(toServiceMsg, i3);
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + i3);
        }
    }

    private void m3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp = null;
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
                    QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp2 = new QQHeadUrl.QQHeadUrlRsp();
                    qQHeadUrlRsp2.mergeFrom((byte[]) obj);
                    qQHeadUrlRsp = qQHeadUrlRsp2;
                }
            } catch (Exception unused) {
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_New qqHeadUrlResp=" + qQHeadUrlRsp + " qqHeadUrlRespData = " + obj);
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && qQHeadUrlRsp != null && qQHeadUrlRsp.result.get() == 0) {
            com.tencent.mobileqq.avatar.api.a.c(true, 0, "1");
            int i16 = qQHeadUrlRsp.dstUsrType.get();
            if (i16 == 8) {
                i16 = 4;
            }
            int i17 = i16;
            byte b16 = (byte) qQHeadUrlRsp.dstEncryptType.get();
            List<QQHeadInfo> arrayList = new ArrayList<>();
            List<QQHeadDetails> arrayList2 = new ArrayList<>();
            M2((byte) i17, b16, qQHeadUrlRsp, toServiceMsg.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST), arrayList2, arrayList);
            z3(arrayList, false);
            l3(i17, 0, arrayList2);
            if (arrayList2.size() > 0 && (i17 == 1 || i17 == 32)) {
                ArrayList arrayList3 = new ArrayList(arrayList2.size());
                Iterator<QQHeadDetails> it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().uinOrMobile);
                }
                notifyUI(6, true, new Object[]{0, arrayList3});
            }
            com.tencent.mobileqq.proavatar.info.a.o(arrayList);
            return;
        }
        if (qQHeadUrlRsp != null) {
            i3 = qQHeadUrlRsp.result.get();
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        j3(toServiceMsg, i3);
        com.tencent.mobileqq.avatar.api.a.c(false, i3, "1");
        int i18 = toServiceMsg.extraData.getInt("dstUsrType", 1);
        if (i18 == 1 || i18 == 32) {
            ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList arrayList4 = new ArrayList();
            if (parcelableArrayList instanceof ArrayList) {
                Iterator it5 = parcelableArrayList.iterator();
                while (it5.hasNext()) {
                    Object next = it5.next();
                    if (next instanceof QQHeadDetails) {
                        arrayList4.add(((QQHeadDetails) next).uinOrMobile);
                    }
                }
            }
            notifyUI(6, false, new Object[]{0, arrayList4});
        }
    }

    private void n3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_QCall ....");
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
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + e16.getMessage());
                }
                e16.printStackTrace();
            }
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && multiBusidUrlRsp != null && multiBusidUrlRsp.result.get() == 0) {
            List<MultiHeadUrl.RspUsrHeadInfo> list = multiBusidUrlRsp.dstUsrHeadInfos.get();
            ArrayList arrayList = new ArrayList();
            ArrayList<QQHeadDetails> parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList arrayList2 = new ArrayList();
            multiBusidUrlRsp.dstUidType.get();
            int i16 = toServiceMsg.extraData.getInt("idType");
            N2(i16, list, parcelableArrayList, arrayList, arrayList2);
            z3(arrayList2, true);
            l3(16, i16, arrayList);
            com.tencent.mobileqq.proavatar.info.a.o(arrayList2);
            return;
        }
        if (multiBusidUrlRsp != null) {
            i3 = multiBusidUrlRsp.result.get();
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        j3(toServiceMsg, i3);
    }

    private void o3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_Stranger ....");
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
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + e16.getMessage());
                }
                e16.printStackTrace();
            }
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && multiBusidUrlRsp != null && multiBusidUrlRsp.result.get() == 0) {
            List<MultiHeadUrl.RspUsrHeadInfo> list = multiBusidUrlRsp.dstUsrHeadInfos.get();
            ArrayList arrayList = new ArrayList();
            ArrayList<QQHeadDetails> parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList arrayList2 = new ArrayList();
            int i16 = multiBusidUrlRsp.dstUidType.get();
            int i17 = toServiceMsg.extraData.getInt("idType");
            O2(i17, i16, list, parcelableArrayList, arrayList, arrayList2);
            z3(arrayList2, true);
            l3(32, i17, arrayList);
            com.tencent.mobileqq.proavatar.info.a.o(arrayList2);
            return;
        }
        if (multiBusidUrlRsp != null) {
            i3 = multiBusidUrlRsp.result.get();
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        j3(toServiceMsg, i3);
    }

    private void p3() {
        if (this.C == null) {
            synchronized (this.D) {
                if (this.C == null) {
                    this.C = new QQHeadDownloadHandler(this.f200102d, this);
                }
            }
        }
    }

    private void t3(long j3, int i3, ArrayList<QQHeadDetails> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ToServiceMsg createToServiceMsg = createToServiceMsg(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD, null);
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                QQHeadDetails qQHeadDetails = arrayList.get(i16);
                arrayList2.add(qQHeadDetails.getDestQQHeadInfo());
                A3(0, qQHeadDetails.uinOrMobile, qQHeadDetails.userType, 1);
            }
            createToServiceMsg.extraData.putParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
            QQHeadUrlReq qQHeadUrlReq = new QQHeadUrlReq(j3, arrayList2, (byte) i3);
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding("UTF-8");
            qQHeadUrlReq.writeTo(jceOutputStream);
            createToServiceMsg.extraData.putByteArray("QQHeadUrlReq", jceOutputStream.toByteArray());
            send(createToServiceMsg);
        }
    }

    private void u3(long j3, int i3, ArrayList<QQHeadDetails> arrayList) {
        if (QLog.isDevelopLevel()) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                Iterator<QQHeadDetails> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().uinOrMobile);
                }
            }
            QLog.d("Q.qqhead.AvatarHandler", 2, String.format("realGetQQHead_Apollo selfUin=%s headType=%s uinList=%s", Long.valueOf(j3), Integer.valueOf(i3), Arrays.toString(arrayList2.toArray())));
        }
        oidb_0xedb$ReqBody J2 = J2(arrayList);
        if (J2 != null) {
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(FaceConstant.AvatarHandlerCmd.CMD_GET_APOLLO_HEAD, 3803, 0, J2.toByteArray());
            makeOIDBPkg.extraData.putParcelableArrayList("key_request_list", arrayList);
            sendPbReq(makeOIDBPkg);
        }
    }

    private void v3(long j3, int i3, ArrayList<QQHeadDetails> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (i3 == 4) {
                i3 = 8;
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW, null);
            QQHeadUrl.QQHeadUrlReq qQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
            qQHeadUrlReq.srcUsrType.set(1);
            qQHeadUrlReq.srcUin.set(Long.parseLong(this.f200102d.getAccount()));
            qQHeadUrlReq.dstUsrType.set(i3);
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                QQHeadDetails qQHeadDetails = arrayList.get(i16);
                QQHeadUrl.ReqUsrInfo reqUsrInfo = new QQHeadUrl.ReqUsrInfo();
                try {
                    reqUsrInfo.dstUin.set(Long.parseLong(qQHeadDetails.uinOrMobile));
                    A3(0, qQHeadDetails.uinOrMobile, qQHeadDetails.userType, 1);
                    reqUsrInfo.timestamp.set((int) qQHeadDetails.headImgTimestamp);
                    qQHeadUrlReq.dstUsrInfos.add(reqUsrInfo);
                } catch (Exception unused) {
                }
            }
            createToServiceMsg.extraData.putParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
            createToServiceMsg.extraData.putInt("dstUsrType", i3);
            createToServiceMsg.putWupBuffer(qQHeadUrlReq.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    private void w3(int i3, ArrayList<QQHeadDetails> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            MultiHeadUrl.MultiBusidUrlReq multiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
            multiBusidUrlReq.srcUidType.set(0);
            multiBusidUrlReq.srcUin.set(Long.parseLong(this.f200102d.getAccount()));
            multiBusidUrlReq.dstUsrType.add(16);
            multiBusidUrlReq.dstUidType.set(0);
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                QQHeadDetails qQHeadDetails = arrayList.get(i16);
                MultiHeadUrl.ReqUsrInfo reqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
                try {
                    reqUsrInfo.dstUin.set(b.e(qQHeadDetails.uinOrMobile));
                    A3(0, qQHeadDetails.uinOrMobile, qQHeadDetails.userType, 1);
                    multiBusidUrlReq.dstUsrInfos.add(reqUsrInfo);
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(RLog.ERROR, 2, e16.getMessage());
                    }
                }
            }
            new HashMap().put("connum", String.valueOf(arrayList.size()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
            createToServiceMsg.extraData.putParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
            createToServiceMsg.extraData.putInt("idType", i3);
            createToServiceMsg.extraData.putInt("qqHeadType", 16);
            createToServiceMsg.putWupBuffer(multiBusidUrlReq.toByteArray());
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.qqhead.AvatarHandler", 2, "realGetQQHead_QCall .  idType = " + i3);
            }
            sendPbReq(createToServiceMsg);
        }
    }

    private void x3(int i3, ArrayList<QQHeadDetails> arrayList) {
        int i16;
        if (arrayList != null && arrayList.size() != 0) {
            if (i3 != 202) {
                if (i3 != 204) {
                    i16 = 0;
                } else {
                    i16 = 2;
                }
            } else {
                i16 = 1;
            }
            MultiHeadUrl.MultiBusidUrlReq multiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
            multiBusidUrlReq.srcUidType.set(0);
            multiBusidUrlReq.srcUin.set(Long.parseLong(this.f200102d.getAccount()));
            multiBusidUrlReq.dstUsrType.add(1);
            multiBusidUrlReq.dstUsrType.add(32);
            multiBusidUrlReq.dstUidType.set(i16);
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                QQHeadDetails qQHeadDetails = arrayList.get(i17);
                MultiHeadUrl.ReqUsrInfo reqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
                if (i16 == 0) {
                    try {
                        reqUsrInfo.dstUin.set(Long.parseLong(qQHeadDetails.uinOrMobile));
                    } catch (Exception e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(RLog.ERROR, 2, e16.getMessage());
                        }
                    }
                } else if (i16 == 1) {
                    reqUsrInfo.dstTid.set(Long.parseLong(qQHeadDetails.uinOrMobile));
                } else if (i16 == 2) {
                    reqUsrInfo.dstOpenid.set(qQHeadDetails.uinOrMobile);
                }
                A3(0, qQHeadDetails.uinOrMobile, qQHeadDetails.userType, 1);
                multiBusidUrlReq.dstUsrInfos.add(reqUsrInfo);
                if (QLog.isDevelopLevel()) {
                    QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + reqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + reqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + reqUsrInfo.dstOpenid);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("connum", String.valueOf(arrayList.size()));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f200102d.getAccount(), "actNearbyHeadConNum", true, 0L, 0L, hashMap, "");
            ToServiceMsg createToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
            createToServiceMsg.extraData.putParcelableArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
            createToServiceMsg.extraData.putInt("idType", i3);
            createToServiceMsg.putWupBuffer(multiBusidUrlReq.toByteArray());
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.qqhead.AvatarHandler", 2, "realGetQQHead_Stranger .  idType = " + i3);
            }
            sendPbReq(createToServiceMsg);
        }
    }

    public void A3(int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            B3(i3, str, i16, i17, 0, null, 0, 0L);
        }
    }

    public void B3(int i3, String str, int i16, int i17, int i18, String str2, int i19, long j3) {
        boolean z16;
        long j16;
        QQHeadStat qQHeadStat;
        long j17;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2, Integer.valueOf(i19), Long.valueOf(j3));
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j3 == 0) {
            j16 = System.currentTimeMillis();
        } else {
            j16 = j3;
        }
        if (i17 == 1) {
            if (this.E.containsKey(str)) {
                this.E.remove(str);
            }
            QQHeadStat qQHeadStat2 = new QQHeadStat();
            qQHeadStat2.beginDownInfoTime = j16;
            qQHeadStat2.headType = i16;
            this.E.put(str, qQHeadStat2);
            qQHeadStat = qQHeadStat2;
        } else if (this.E.containsKey(str)) {
            QQHeadStat qQHeadStat3 = this.E.get(str);
            if (qQHeadStat3 == null) {
                return;
            }
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 == 4) {
                        qQHeadStat3.endDownPicTime = j16;
                        qQHeadStat3.size = i18;
                        qQHeadStat3.downUrl = str2;
                        qQHeadStat3.costTime = j16 - qQHeadStat3.beginDownInfoTime;
                        this.E.remove(str);
                    }
                } else {
                    qQHeadStat3.beginDownPicTime = j16;
                }
            } else {
                qQHeadStat3.endDownInfoTime = j16;
                if (!z16) {
                    this.E.remove(str);
                }
                qQHeadStat3.costTime = qQHeadStat3.endDownInfoTime - qQHeadStat3.beginDownInfoTime;
            }
            qQHeadStat = qQHeadStat3;
        } else {
            qQHeadStat = null;
        }
        if ((!z16 || i17 == 4) && qQHeadStat != null) {
            long j18 = qQHeadStat.endDownInfoTime;
            long j19 = j18 - qQHeadStat.beginDownInfoTime;
            long j26 = qQHeadStat.beginDownPicTime;
            if (j26 > j18 && j18 > 0) {
                j17 = j26 - j18;
            } else {
                j17 = 0;
            }
            long j27 = qQHeadStat.endDownPicTime - j26;
            if (!QLog.isDevelopLevel() && (!z16 || i17 != 4 || qQHeadStat.costTime <= 3000)) {
                z17 = z16;
            } else {
                StringBuffer stringBuffer = new StringBuffer(200);
                stringBuffer.append("===QQHeadStat resultCode=");
                stringBuffer.append(i3);
                stringBuffer.append(", uin=");
                stringBuffer.append(String.format("%11s", str));
                stringBuffer.append(", totalTime=");
                z17 = z16;
                stringBuffer.append(String.format("%-5s", Long.valueOf(qQHeadStat.costTime)));
                stringBuffer.append(", picSize=");
                int i26 = 1;
                stringBuffer.append(String.format("%-6s", Integer.valueOf(qQHeadStat.size)));
                stringBuffer.append(", downInfoTime=");
                stringBuffer.append(j19);
                stringBuffer.append(", intervalTime=");
                stringBuffer.append(j17);
                stringBuffer.append(", downPicTime=");
                stringBuffer.append(j27);
                stringBuffer.append(", reasonCode=");
                stringBuffer.append(i19);
                stringBuffer.append(", downUrl=");
                stringBuffer.append(qQHeadStat.downUrl);
                if (QLog.isDevelopLevel()) {
                    i26 = 2;
                }
                QLog.d("QQHeadCostTime", i26, stringBuffer.toString());
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("qqhead_uin", str);
                hashMap.put("downInfo_time", String.valueOf(j19));
                hashMap.put("interval_time", String.valueOf(j17));
                hashMap.put("downPic_time", String.valueOf(j27));
                hashMap.put("downPic_size", String.valueOf(qQHeadStat.size));
                hashMap.put("download_url", qQHeadStat.downUrl);
                hashMap.put("param_FailCode", Integer.toString(i3));
                hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, Integer.toString(i19));
                hashMap.put("param_threadOpId", String.valueOf(com.tencent.qqperf.opt.threadpriority.a.c().b()));
                String c16 = b.c(i16);
                if (!TextUtils.isEmpty(c16)) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f200102d.getAccount(), c16, z17, qQHeadStat.costTime, qQHeadStat.size, hashMap, "");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f200102d.getAccount(), b.b(i16), z17, qQHeadStat.costTime, qQHeadStat.size, hashMap, "");
            }
        }
    }

    public void K2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.qqhead.AvatarHandler", 2, String.format("getApolloHead(1) uin=%s", str));
        }
        a3(116, str, 200, (byte) 1, (byte) 0, FaceConstant.Apollo.FACE_DEFAULT_SIZE_SPEC, false);
    }

    public void L2(String str, byte b16, byte b17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Byte.valueOf(b16), Byte.valueOf(b17), Integer.valueOf(i3));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.qqhead.AvatarHandler", 2, String.format("getApolloHead(2) uin=%s sizeType=%d", str, Integer.valueOf(i3)));
        }
        a3(116, str, 200, b16, b17, i3, false);
    }

    public String P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        p3();
        return this.C.getChoosedIP();
    }

    public String Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        p3();
        return this.C.getChoosedStrangerGroupIp();
    }

    public void R2(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) faceInfo);
        } else if (faceInfo == null) {
            QLog.e("Q.qqhead.AvatarHandler", 1, "getCustom faceInfo is null");
        } else {
            c3(faceInfo);
        }
    }

    public void S2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (FaceUtil.isUploadingZplanAvatar() && str != null && str.equals(this.f200102d.getCurrentUin())) {
            QLog.i("Q.qqhead.AvatarHandler", 1, "getCustomHead: getUserZplanAvatar isUploading");
        } else {
            b3(1, str, 0, (byte) 0, (byte) 0, false);
        }
    }

    public void T2(String str, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
        } else {
            b3(1, str, 0, b16, b17, false);
        }
    }

    public void U2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            b3(11, str, 0, (byte) 0, (byte) 0, false);
        }
    }

    public void V2(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Byte.valueOf(b16));
        } else {
            b3(11, str, 0, (byte) 0, b16, false);
        }
    }

    public void W2(String str, int i3, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "getQCallHead FaceConstant.HeadType.QQHEAD_TYPE_QCALL uin = " + str + " idType = " + i3 + ", level =  faceFileType = " + ((int) b17));
        }
        b3(16, str, i3, b16, b17, true);
    }

    public void d3(String str, int i3, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Byte.valueOf(b16), Byte.valueOf(b17));
        } else {
            b3(32, str, i3, b16, b17, true);
        }
    }

    public void e3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            b3(4, str, 0, (byte) 0, (byte) 0, false);
        }
    }

    public void f3(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Byte.valueOf(b16));
        } else {
            b3(4, str, 0, (byte) 0, b16, false);
        }
    }

    public String g3(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Long.valueOf(j3), str);
        }
        if (i3 != 11) {
            return Long.toString(j3);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD);
            this.allowCmdSet.add(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW);
            this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
            this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
            this.allowCmdSet.add(FaceConstant.AvatarHandlerCmd.CMD_GET_APOLLO_HEAD);
            this.allowCmdSet.add(FaceConstant.AvatarHandlerCmd.CMD_GET_QQ_HEAD_NT);
        }
        return this.allowCmdSet;
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f200103e = new MqqHandler(this.f200102d.getApplication().getMainLooper()) { // from class: com.tencent.mobileqq.avatar.handler.AvatarHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final boolean f200108d;

                {
                    super(r5);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarHandler.this, (Object) r5);
                        return;
                    }
                    boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("avatar_handler_send_request_sub_thread_switch", true);
                    this.f200108d = isSwitchOn;
                    QLog.i("Q.qqhead.AvatarHandler", 1, "init subThreadSwitch: " + isSwitchOn);
                }

                @Override // mqq.os.MqqHandler
                public void handleMessage(Message message) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    } else if (message.what == 0) {
                        if (!this.f200108d) {
                            AvatarHandler.this.G2();
                        } else {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.avatar.handler.AvatarHandler.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        AvatarHandler.this.G2();
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            }, 240, null, false);
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l3(int i3, int i16, List<QQHeadDetails> list) {
        if (list.size() > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.AvatarHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
            }
            EntityManager createEntityManager = this.f200102d.getEntityManagerFactory().createEntityManager();
            ArrayList arrayList = new ArrayList();
            for (int i17 = 0; i17 < list.size(); i17++) {
                try {
                    QQHeadDetails qQHeadDetails = list.get(i17);
                    Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, c.j(i3, qQHeadDetails.uinOrMobile, i16));
                    if (setting != null) {
                        setting.updateTimestamp = System.currentTimeMillis();
                        ((IQQAvatarDataService) this.f200102d.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(setting);
                        com.tencent.mobileqq.proavatar.info.a.p(i3, i16, list);
                        arrayList.add(new UpdateTransaction(setting));
                    }
                    r3(c.i(i3, qQHeadDetails.uinOrMobile, i16, qQHeadDetails.sizeType, qQHeadDetails.faceInfo), true);
                } catch (Exception unused) {
                }
            }
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
            Iterator<QQHeadDetails> it = list.iterator();
            while (it.hasNext()) {
                ProAvatarComponentInit.h(c.j(i3, it.next().uinOrMobile, i16));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.avatar.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        QQHeadDownloadHandler qQHeadDownloadHandler = this.C;
        if (qQHeadDownloadHandler != null) {
            qQHeadDownloadHandler.close();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.AvatarHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        QLog.i("Q.qqhead.AvatarHandler", 1, "onReceive: " + fromServiceMsg.getServiceCmd());
        if (FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD.equals(fromServiceMsg.getServiceCmd())) {
            k3(toServiceMsg, fromServiceMsg, (QQHeadUrlResp) obj);
            return;
        }
        if (FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW.equals(fromServiceMsg.getServiceCmd())) {
            m3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("MultibusidURLSvr.HeadUrlReq".equals(fromServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getInt("qqHeadType") == 16) {
                n3(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                o3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        if (FaceConstant.AvatarHandlerCmd.CMD_GET_APOLLO_HEAD.equals(fromServiceMsg.getServiceCmd())) {
            i3(toServiceMsg, fromServiceMsg, obj);
        } else if (FaceConstant.AvatarHandlerCmd.CMD_GET_QQ_HEAD_NT.equals(fromServiceMsg.getServiceCmd())) {
            AvatarNewTechHandler.f200124a.d(this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public boolean q3(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.f200107m) {
            if (this.f200106i.containsKey(str)) {
                if (Math.abs(System.currentTimeMillis() - this.f200106i.get(str).longValue()) > 3000) {
                    this.f200106i.remove(str);
                    A3(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT, str, -1, 4);
                } else {
                    z16 = false;
                }
            }
            z16 = true;
        }
        if (z16) {
            boolean e16 = cu.e();
            if ((e16 && cu.b() < 2048) || (!e16 && cu.c() < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE)) {
                if (!QLog.isDevelopLevel()) {
                    return false;
                }
                QLog.d("Q.qqhead.AvatarHandler", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + str + ", isExistSDCard=" + e16);
                return false;
            }
            if (!e16 && !this.F) {
                this.F = true;
                FaceUtil.saveStoreQQHeadToApp(this.f200102d.getApplication(), true);
            }
        }
        return z16;
    }

    public void r3(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.AvatarHandler", 2, "markDownloadedQQHead, uinOrMobile= " + str + ",isRemove=" + z16 + "downloadSize=" + this.f200106i.size());
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            synchronized (this.f200107m) {
                if (z16) {
                    this.f200106i.remove(str);
                } else {
                    if (this.f200106i.size() > 30) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        Enumeration<String> keys = this.f200106i.keys();
                        while (keys.hasMoreElements()) {
                            String nextElement = keys.nextElement();
                            if (Math.abs(currentTimeMillis - this.f200106i.get(nextElement).longValue()) > 3000) {
                                arrayList.add(nextElement);
                            }
                        }
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            String str2 = (String) arrayList.get(i3);
                            this.f200106i.remove(str2);
                            A3(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT, str2, -1, 4);
                        }
                    }
                    this.f200106i.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public void s3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Message obtainMessage = this.f200103e.obtainMessage();
        obtainMessage.what = 0;
        this.f200103e.sendMessage(obtainMessage);
    }

    public void y3(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(FaceConstant.ACTION_QQHEAD_CHANGED);
        intent.putExtra("uin", str);
        intent.putExtra("faceType", i3);
        this.f200102d.getApplication().sendBroadcast(intent);
        QLog.d("Q.qqhead.AvatarHandler", 1, String.format("sendBroadCastHeadChanged faceType=%d uin=%s", Integer.valueOf(i3), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z3(List<QQHeadInfo> list, boolean z16) {
        String valueOf;
        QLog.e("Q.qqhead.AvatarHandler", 1, "startDownloadQQHead start");
        p3();
        QLog.i(LogTag.QQ_HEAD, 1, "startDownloadQQHead count = " + list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            QQHeadInfo qQHeadInfo = list.get(i3);
            A3(0, h3(qQHeadInfo.uin, qQHeadInfo.phoneNum), qQHeadInfo.dstUsrType, 2);
            FaceInfo faceInfo = new FaceInfo();
            if (z16) {
                valueOf = qQHeadInfo.phoneNum;
            } else {
                valueOf = String.valueOf(qQHeadInfo.uin);
            }
            faceInfo.uin = valueOf;
            faceInfo.idType = qQHeadInfo.idType;
            faceInfo.headType = qQHeadInfo.dstUsrType;
            int i16 = qQHeadInfo.sizeType;
            faceInfo.sizeType = i16;
            faceInfo.mHeadInfo = qQHeadInfo;
            faceInfo.shape = b.g(b.a(i16), b.f(faceInfo.sizeType));
            faceInfo.apngFaceFlag = qQHeadInfo.apngFaceFlag;
            faceInfo.staticZplanFaceFlag = qQHeadInfo.staticZplanFaceFlag;
            faceInfo.dynamicZplanFaceFlag = qQHeadInfo.dynamicZplanFaceFlag;
            faceInfo.zplanFaceBgUrl = qQHeadInfo.zplanFaceBgUrl;
            faceInfo.zplanFaceClipPercent = qQHeadInfo.zplanFaceClipPercent;
            faceInfo.setEnableZplanOutbound(qQHeadInfo.enableZplanOutbound);
            QLog.i(LogTag.QQ_HEAD, 1, "startDownloadQQHead faceInfo = " + faceInfo);
            I2(faceInfo);
        }
    }
}
