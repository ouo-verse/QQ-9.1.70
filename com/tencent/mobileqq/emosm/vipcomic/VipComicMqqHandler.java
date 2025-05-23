package com.tencent.mobileqq.emosm.vipcomic;

import android.text.TextUtils;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.mqqcomic.MqqComicHeadPb$ComicRspHead;
import com.tencent.pb.mqqcomic.MqqComicPb$ComicFavorEmotIcons;
import com.tencent.pb.mqqcomic.MqqComicPb$DelMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb$GetComicGlobalConfigRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb$GetMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb$SetMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb$SetMyComicFavorEmotIconsRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lb1.a;
import lb1.b;
import lb1.d;

/* compiled from: P */
/* loaded from: classes6.dex */
public class VipComicMqqHandler extends BusinessHandler implements a {

    /* renamed from: e, reason: collision with root package name */
    public static final String f204459e = "com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler";

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f204460d;

    public VipComicMqqHandler(AppInterface appInterface) {
        super(appInterface);
        this.f204460d = appInterface;
    }

    private int E2(byte[] bArr, int i3) {
        if (bArr == null) {
            return 0;
        }
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + ((bArr[i3 + 3] & 255) << 0);
    }

    private void G2(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("VipComicMqqHandler", 2, str);
        }
    }

    public boolean F2() {
        int i3 = b.f414287a;
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 100) {
            i3 = 100;
        }
        if (i3 == 0) {
            return false;
        }
        if (i3 != 100 && new Random(System.currentTimeMillis()).nextInt(100) + 1 > i3) {
            return false;
        }
        return true;
    }

    public void H2(byte[] bArr, int i3) {
        if (i3 == 0) {
            MqqComicPb$GetComicGlobalConfigRspBody mqqComicPb$GetComicGlobalConfigRspBody = new MqqComicPb$GetComicGlobalConfigRspBody();
            try {
                mqqComicPb$GetComicGlobalConfigRspBody.mergeFrom(bArr);
            } catch (Exception e16) {
                G2("getComicGlobalConfigRspBody mergeFrom exception : " + e16.getMessage());
                mqqComicPb$GetComicGlobalConfigRspBody = null;
            }
            if (mqqComicPb$GetComicGlobalConfigRspBody != null && mqqComicPb$GetComicGlobalConfigRspBody.maintab.has()) {
                ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).setDefaultComicTab(mqqComicPb$GetComicGlobalConfigRspBody.maintab.get());
            }
        }
        G2("[ComicGlobalConfig] receive from server");
    }

    public void I2(byte[] bArr, int i3) {
        MessageMicro<MqqComicPb$DelMyComicFavorEmotIconsRspBody> messageMicro = new MessageMicro<MqqComicPb$DelMyComicFavorEmotIconsRspBody>() { // from class: com.tencent.pb.mqqcomic.MqqComicPb$DelMyComicFavorEmotIconsRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MqqComicPb$DelMyComicFavorEmotIconsRspBody.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (Exception e16) {
            G2("DelMyComicFavorEmotIconsRspBody mergeFrom exception : " + e16.getMessage());
            messageMicro = null;
        }
        if (i3 == 0) {
            notifyUI(8, true, messageMicro);
        } else {
            notifyUI(9, true, messageMicro);
        }
    }

    public void J2(byte[] bArr, int i3) {
        IVipComicMqqManagerService iVipComicMqqManagerService;
        MqqComicPb$GetMyComicFavorEmotIconsRspBody mqqComicPb$GetMyComicFavorEmotIconsRspBody = new MqqComicPb$GetMyComicFavorEmotIconsRspBody();
        if (i3 == 0) {
            try {
                mqqComicPb$GetMyComicFavorEmotIconsRspBody.mergeFrom(bArr);
            } catch (Exception e16) {
                G2("GetMyComicFavorEmotIconsRspBody mergeFrom exception : " + e16.getMessage());
                mqqComicPb$GetMyComicFavorEmotIconsRspBody = null;
            }
            if (mqqComicPb$GetMyComicFavorEmotIconsRspBody != null) {
                if (mqqComicPb$GetMyComicFavorEmotIconsRspBody.rsps != null && (iVipComicMqqManagerService = (IVipComicMqqManagerService) this.f204460d.getRuntimeService(IVipComicMqqManagerService.class, "")) != null) {
                    for (int i16 = 0; i16 < mqqComicPb$GetMyComicFavorEmotIconsRspBody.rsps.size(); i16++) {
                        VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
                        vipComicFavorEmoStructMsgInfo.picMd5 = mqqComicPb$GetMyComicFavorEmotIconsRspBody.rsps.get(i16).md5.get();
                        vipComicFavorEmoStructMsgInfo.actionData = mqqComicPb$GetMyComicFavorEmotIconsRspBody.rsps.get(i16).info.get();
                        vipComicFavorEmoStructMsgInfo.status = 2;
                        iVipComicMqqManagerService.saveComicStructInfo(vipComicFavorEmoStructMsgInfo);
                    }
                }
                notifyUI(2, true, mqqComicPb$GetMyComicFavorEmotIconsRspBody);
                return;
            }
            notifyUI(3, true, mqqComicPb$GetMyComicFavorEmotIconsRspBody);
            return;
        }
        notifyUI(4, true, mqqComicPb$GetMyComicFavorEmotIconsRspBody);
    }

    public void K2(ToServiceMsg toServiceMsg, byte[] bArr, int i3) {
        MqqComicPb$SetMyComicFavorEmotIconsReqBody mqqComicPb$SetMyComicFavorEmotIconsReqBody = new MqqComicPb$SetMyComicFavorEmotIconsReqBody();
        try {
            byte[] wupBuffer = toServiceMsg.getWupBuffer();
            int E2 = E2(wupBuffer, 4);
            int E22 = E2(wupBuffer, E2 + 4) - 4;
            byte[] bArr2 = new byte[E22];
            PkgTools.copyData(bArr2, 0, wupBuffer, E2 + 8, E22);
            mqqComicPb$SetMyComicFavorEmotIconsReqBody.mergeFrom(bArr2);
            if (mqqComicPb$SetMyComicFavorEmotIconsReqBody.reqs != null) {
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < mqqComicPb$SetMyComicFavorEmotIconsReqBody.reqs.size(); i16++) {
                    arrayList.add(mqqComicPb$SetMyComicFavorEmotIconsReqBody.reqs.get(i16).md5.get());
                }
                ((IVipComicMqqManagerService) this.f204460d.getRuntimeService(IVipComicMqqManagerService.class, "")).updateComicStructInfo(arrayList);
                G2("responseSetMyComicFavorEmotIcons updateComicStructInfo");
            }
        } catch (Exception e16) {
            G2("responseSetMyComicFavorEmotIcons exception:" + e16.getMessage());
        }
        MessageMicro<MqqComicPb$SetMyComicFavorEmotIconsRspBody> messageMicro = new MessageMicro<MqqComicPb$SetMyComicFavorEmotIconsRspBody>() { // from class: com.tencent.pb.mqqcomic.MqqComicPb$SetMyComicFavorEmotIconsRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MqqComicPb$SetMyComicFavorEmotIconsRspBody.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (Exception e17) {
            G2("SetMyComicFavorEmotIconsRspBody mergeFrom exception : " + e17.getMessage());
            messageMicro = null;
        }
        if (i3 == 0) {
            notifyUI(2, true, messageMicro);
        } else {
            notifyUI(4, true, messageMicro);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        byte[] bArr;
        String str;
        String str2;
        String str3;
        String str4;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        long size = toServiceMsg.extraData.size();
        if (obj != null && (obj instanceof byte[])) {
            j3 = ((byte[]) obj).length;
        } else {
            j3 = 0;
        }
        long j16 = j3;
        long j17 = toServiceMsg.extraData.getLong("requestTime");
        String string = toServiceMsg.extraData.getString("subcmd");
        if (TextUtils.isEmpty(serviceCmd) || TextUtils.isEmpty(string) || !"ComicProtoConvSvr.tunnel".equals(serviceCmd)) {
            return;
        }
        if (!fromServiceMsg.isSuccess()) {
            if ("GetMyComicFavorEmotIcons".equals(string)) {
                notifyUI(1, true, null);
                str4 = "[\u4f1a\u5458\u4e2d\u5fc3].\u67e5\u8be2\u6211\u7684\u6f2b\u56fe\u53d1\u9001\u5931\u8d25";
            } else if ("SetMyComicFavorEmotIcons".equals(string)) {
                notifyUI(7, true, null);
                str4 = "[\u4f1a\u5458\u4e2d\u5fc3].\u8bbe\u7f6e\u6211\u7684\u6f2b\u56fe\u53d1\u9001\u5931\u8d25";
            } else if ("DelMyComicFavorEmotIcons".equals(string)) {
                notifyUI(10, true, null);
                str4 = "[\u4f1a\u5458\u4e2d\u5fc3].\u5220\u9664\u6211\u7684\u6f2b\u56fe\u53d1\u9001\u5931\u8d25";
            } else {
                if (!"GetComicGlobalConfig".equals(string)) {
                    str3 = "";
                    if (!F2() && !TextUtils.isEmpty(str3)) {
                        ReportCenter.f().j(string, j17, size, j16, fromServiceMsg.getBusinessFailCode(), Long.valueOf(this.f204460d.getCurrentAccountUin()).longValue(), b.f414288b, str3, false);
                        return;
                    }
                    return;
                }
                str4 = "[QQ\u52a8\u6f2b].\u67e5\u8be2\u52a8\u6f2b\u5168\u5c40\u914d\u7f6e\u5931\u8d25";
            }
            str3 = str4;
            if (!F2()) {
                return;
            } else {
                return;
            }
        }
        byte[] bArr2 = (byte[]) obj;
        int E2 = E2(bArr2, 0);
        int i3 = E2 - 4;
        byte[] bArr3 = new byte[i3];
        PkgTools.copyData(bArr3, 0, bArr2, 4, i3);
        MqqComicHeadPb$ComicRspHead mqqComicHeadPb$ComicRspHead = new MqqComicHeadPb$ComicRspHead();
        try {
            mqqComicHeadPb$ComicRspHead.mergeFrom(bArr3);
        } catch (Exception e16) {
            G2("onReceive comicRspHead mergeFrom exception:" + e16.getMessage());
            mqqComicHeadPb$ComicRspHead = null;
        }
        if (mqqComicHeadPb$ComicRspHead != null && mqqComicHeadPb$ComicRspHead.retCode.has()) {
            int i16 = mqqComicHeadPb$ComicRspHead.retCode.get();
            b.f414287a = mqqComicHeadPb$ComicRspHead.reportRate.get();
            if (i16 == 0) {
                int E22 = E2(bArr2, E2) - 4;
                byte[] bArr4 = new byte[E22];
                PkgTools.copyData(bArr4, 0, bArr2, E2 + 4, E22);
                bArr = bArr4;
            } else {
                bArr = null;
            }
            if ("GetMyComicFavorEmotIcons".equals(string)) {
                J2(bArr, i16);
                str2 = "[\u4f1a\u5458\u4e2d\u5fc3].\u67e5\u8be2\u6211\u7684\u6f2b\u56fe\u6210\u529f";
            } else if ("SetMyComicFavorEmotIcons".equals(string)) {
                K2(toServiceMsg, bArr, i16);
                str2 = "[\u4f1a\u5458\u4e2d\u5fc3].\u8bbe\u7f6e\u6211\u7684\u6f2b\u56fe\u4fe1\u606f\u6210\u529f";
            } else if ("DelMyComicFavorEmotIcons".equals(string)) {
                I2(bArr, i16);
                str2 = "[\u4f1a\u5458\u4e2d\u5fc3].\u5220\u9664\u6211\u7684\u6f2b\u56fe\u4fe1\u606f\u6210\u529f";
            } else {
                if (!"GetComicGlobalConfig".equals(string)) {
                    str = "";
                    if (!F2() && !TextUtils.isEmpty(str)) {
                        ReportCenter.f().j("GetMyComicFavorEmotIcons", j17, size, j16, i16, Long.valueOf(this.f204460d.getCurrentAccountUin()).longValue(), b.f414288b, str, false);
                        return;
                    }
                }
                H2(bArr, i16);
                str2 = "[QQ\u52a8\u6f2b].\u67e5\u8be2\u52a8\u6f2b\u5168\u5c40\u914d\u7f6e\uff0ccode = " + i16;
            }
            str = str2;
            if (!F2()) {
            }
        }
    }

    @Override // lb1.a
    public void M() {
    }

    @Override // lb1.a
    public void O0() {
    }

    public void D2(List<String> list) {
    }

    public void L2(List<MqqComicPb$ComicFavorEmotIcons> list) {
    }
}
