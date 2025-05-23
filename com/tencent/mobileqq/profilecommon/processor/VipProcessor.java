package com.tencent.mobileqq.profilecommon.processor;

import QQService.EVIPSPEC;
import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emosm.o;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.r;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import hx3.c;
import java.nio.ByteBuffer;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jf.dexlib2.analysis.RegisterType;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class VipProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f260940b;

    /* renamed from: a, reason: collision with root package name */
    private long f260941a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f260940b = new int[]{23105, 23106, 23107, 42324, 42241, 42240};
        }
    }

    public VipProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f260941a = 0L;
        }
    }

    private void a(ByteStringMicro byteStringMicro, FriendsManager friendsManager, String str) {
        short s16;
        byte[] byteArray = byteStringMicro.toByteArray();
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 1, "push the big club type change=" + ((int) s16));
        }
        Card r16 = friendsManager.r(str + "");
        if (r16 != null) {
            r16.iBigClubVipType = s16;
            friendsManager.p0(r16);
            ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.bigClubInfo = ((s16 & 255) << 24) | (vasSimpleInfoWithUid.bigClubInfo & 16777215);
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
        h();
    }

    private void b(ByteStringMicro byteStringMicro, String str) {
        short s16;
        byte[] byteArray = byteStringMicro.toByteArray();
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 1, "push the big club iVipType change = " + ((int) s16));
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.bigClubInfo = ((s16 & 255) << 16) | (vasSimpleInfoWithUid.bigClubInfo & (-16711681));
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
        h();
    }

    private void c(ByteStringMicro byteStringMicro, String str) {
        if (byteStringMicro.size() >= 2) {
            ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).saveLiangNumId(str, (byteStringMicro.byteAt(1) & 255) | ((byteStringMicro.byteAt(0) & 255) << 8));
        }
    }

    private void d(ByteStringMicro byteStringMicro, String str) {
        int i3;
        boolean equals = this.appRuntime.getCurrentAccountUin().equals(str);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        if ((byteStringMicro.byteAt(5) & 32) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        nTVasSimpleInfo.superVipInfo = (i3 << 24) | (vasSimpleInfoWithUid.superVipInfo & 16777215);
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
        if (equals) {
            l();
            j();
        }
    }

    private void e(ByteStringMicro byteStringMicro, String str) {
        boolean equals = this.appRuntime.getCurrentAccountUin().equals(str);
        n(byteStringMicro, str);
        if (equals) {
            l();
        }
    }

    private void f(ByteStringMicro byteStringMicro, String str) {
        boolean equals = this.appRuntime.getCurrentAccountUin().equals(str);
        o(byteStringMicro, str);
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 2, "threadName:" + Thread.currentThread().getName());
        }
        if (equals) {
            l();
            i();
            j();
            k();
        }
    }

    private void g(ByteStringMicro byteStringMicro, String str) {
        boolean z16;
        if (byteStringMicro.size() == 2) {
            try {
                byte[] byteArray = byteStringMicro.toByteArray();
                ByteBuffer.wrap(byteArray);
                short s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
                boolean z17 = false;
                if (s16 != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                StudyModeManager.W(80, z16);
                if (s16 != 0) {
                    z17 = true;
                }
                StudyModeManager.W(96, z17);
            } catch (Exception e16) {
                QLog.d("VipProcessor", 2, "urlfilter_ 45077:" + e16.toString());
            }
        }
    }

    private void h() {
        VasLogNtReporter.getVipIcon().reportDebug("0x27 requestBigClubUpdate and request vipinfo data");
        ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(this.f260941a));
        TicketManager ticketManager = (TicketManager) this.appRuntime.getManager(2);
        ((VipInfoHandler) ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey(ticketManager, String.valueOf(this.f260941a)), this.f260941a + "");
    }

    private void i() {
        Intent intent = new Intent("tencent.video.q2v.SVIP.PAY");
        intent.putExtra("SVIPpaySuccess", true);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        this.appRuntime.getApp().sendBroadcast(intent);
    }

    private void j() {
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 2, "[EmoticonUpdateAuth] updateEmoticonAuth");
        }
        o oVar = (o) ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        oVar.g(0, 0);
        oVar.c(0, 0, 1, 0);
    }

    private void k() {
        VasLogNtReporter.getVipIcon().reportDebug("0x27 requestUpdateQQSettingMe and request vipinfo data");
        QVipConfigManager.setLong(this.appRuntime, QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, 0L);
        ((VipInfoHandler) ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey((TicketManager) this.appRuntime.getManager(2), this.appRuntime.getCurrentAccountUin()), Long.toString(this.f260941a));
    }

    private void l() {
        ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
    }

    private void m(ByteStringMicro byteStringMicro, FriendsManager friendsManager, String str) {
        short s16;
        byte[] byteArray = byteStringMicro.toByteArray();
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 1, "push the big club level change=" + ((int) s16));
        }
        Card r16 = friendsManager.r(str + "");
        if (r16 != null) {
            r16.iBigClubVipLevel = s16;
            friendsManager.p0(r16);
            ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.bigClubInfo = (s16 & 65535) | (vasSimpleInfoWithUid.bigClubInfo & SupportMenu.CATEGORY_MASK);
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
        h();
    }

    @VisibleForTesting
    @NotNull
    private void n(ByteStringMicro byteStringMicro, String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        boolean c16 = r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP);
        boolean c17 = r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_QQVIP);
        boolean c18 = r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERQQ);
        r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_BIGCLUB);
        byte byteAt = byteStringMicro.byteAt(4);
        byte byteAt2 = byteStringMicro.byteAt(5);
        int i3 = 0;
        if ((byteAt2 & 240) != 0) {
            byte b16 = RegisterType.UNINIT_REF;
            int i16 = 0;
            while (true) {
                if (i16 >= 4) {
                    break;
                }
                if ((byteAt2 & b16) != 0) {
                    i3 = 13 - i16;
                    break;
                } else {
                    i16++;
                    b16 = (byte) (b16 << 1);
                }
            }
        } else {
            byte b17 = 1;
            if (byteAt != 0) {
                int i17 = 0;
                while (true) {
                    if (i17 >= 8) {
                        break;
                    }
                    if ((byteAt & b17) != 0) {
                        i3 = 9 - i17;
                        break;
                    } else {
                        i17++;
                        b17 = (byte) (b17 << 1);
                    }
                }
            } else {
                i3 = 1;
            }
        }
        if (c16) {
            nTVasSimpleInfo.superVipInfo = (65535 & i3) | (vasSimpleInfoWithUid.superVipInfo & SupportMenu.CATEGORY_MASK);
        } else if (c17) {
            nTVasSimpleInfo.qqVipInfo = (65535 & i3) | (vasSimpleInfoWithUid.qqVipInfo & SupportMenu.CATEGORY_MASK);
        } else if (c18) {
            nTVasSimpleInfo.superQqInfo = (65535 & i3) | (vasSimpleInfoWithUid.superQqInfo & SupportMenu.CATEGORY_MASK);
        }
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
    }

    @VisibleForTesting
    @NotNull
    private void o(ByteStringMicro byteStringMicro, String str) {
        int i3;
        int i16;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VipProcessor");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, str);
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        int i17 = vasSimpleInfoWithUid.qqVipInfo & 16777215;
        int i18 = 0;
        boolean z16 = true;
        if ((byteStringMicro.byteAt(0) & 128) == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        nTVasSimpleInfo.qqVipInfo = i17 | (i3 << 24);
        int i19 = vasSimpleInfoWithUid.superQqInfo & 16777215;
        if ((byteStringMicro.byteAt(0) & 8) == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        nTVasSimpleInfo.superQqInfo = i19 | (i16 << 24);
        if ((byteStringMicro.byteAt(0) & MaskType.MASK_TYPE_EXTERNAL) == 0) {
            z16 = false;
        }
        if (z16) {
            i18 = 65536;
        }
        if (r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP)) {
            nTVasSimpleInfo.superVipInfo = (vasSimpleInfoWithUid.superVipInfo & (-16711681)) | i18;
        } else if (r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_QQVIP)) {
            nTVasSimpleInfo.qqVipInfo = (vasSimpleInfoWithUid.qqVipInfo & (-16711681)) | i18;
        } else if (r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERQQ)) {
            nTVasSimpleInfo.superQqInfo = (vasSimpleInfoWithUid.superQqInfo & (-16711681)) | i18;
        }
        if (r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_BIGCLUB)) {
            nTVasSimpleInfo.bigClubInfo = (vasSimpleInfoWithUid.bigClubInfo & (-16711681)) | i18;
        }
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VipProcessor", (c<NTVasSimpleInfo>) null);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "VipProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        for (int i16 : f260940b) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipProcessor", 2, "onProcessProfileModifyPush uin = " + this.f260941a + " type = " + i3 + " value = " + Arrays.toString(byteStringMicro.toByteArray()));
        }
        if (this.f260941a <= 0) {
            return;
        }
        VasLogNtReporter.getVipIcon().reportDebug("0x27 " + i3);
        FriendsManager friendsManager = (FriendsManager) this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        switch (i3) {
            case 23105:
                f(byteStringMicro, String.valueOf(this.f260941a));
                return;
            case 23106:
                e(byteStringMicro, String.valueOf(this.f260941a));
                return;
            case 23107:
                d(byteStringMicro, String.valueOf(this.f260941a));
                return;
            case 42240:
                m(byteStringMicro, friendsManager, String.valueOf(this.f260941a));
                return;
            case 42241:
                a(byteStringMicro, friendsManager, String.valueOf(this.f260941a));
                return;
            case 42324:
                b(byteStringMicro, String.valueOf(this.f260941a));
                return;
            case ProfileContants.FIELD_HAOMA_NAMEPLATE /* 47218 */:
                c(byteStringMicro, String.valueOf(this.f260941a));
                return;
            case ProfileContants.FILED_KID_MODE_URL_FILTER_SWITCH /* 47222 */:
                g(byteStringMicro, String.valueOf(this.f260941a));
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushBegin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.f260941a = j3;
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f260941a = 0L;
        }
    }
}
