package com.tencent.mobileqq.vipav;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.funcall.VipFunCallAndRing$TGroupInfo;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x1Req;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x1Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x2Req;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x2Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x4Req;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x5Req;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoRsp;
import com.tencent.pb.funcall.VipFunCallAndRing$TUserInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import hx3.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipSetFunCallHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f313082d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private VipFunCallAndRing$TSsoReq f313083a;

        /* renamed from: b, reason: collision with root package name */
        private Bundle f313084b;

        /* renamed from: c, reason: collision with root package name */
        private int f313085c;

        /* renamed from: d, reason: collision with root package name */
        private VipFunCallAndRing$TSsoRsp f313086d;

        /* renamed from: e, reason: collision with root package name */
        private IVipFunCallManager f313087e;

        /* renamed from: f, reason: collision with root package name */
        private int f313088f;

        /* renamed from: g, reason: collision with root package name */
        private String f313089g;

        public a(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq, Bundle bundle, int i3, VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp, IVipFunCallManager iVipFunCallManager, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VipSetFunCallHandler.this, vipFunCallAndRing$TSsoReq, bundle, Integer.valueOf(i3), vipFunCallAndRing$TSsoRsp, iVipFunCallManager, Integer.valueOf(i16), str);
                return;
            }
            this.f313083a = vipFunCallAndRing$TSsoReq;
            this.f313084b = bundle;
            this.f313085c = i3;
            this.f313086d = vipFunCallAndRing$TSsoRsp;
            this.f313087e = iVipFunCallManager;
            this.f313088f = i16;
            this.f313089g = str;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f313088f;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f313089g;
        }

        public a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (this.f313085c == 0) {
                VipFunCallAndRing$TSsoCmd0x2Rsp vipFunCallAndRing$TSsoCmd0x2Rsp = this.f313086d.st_cmd0x2_rsp.get();
                VipFunCallAndRing$TSsoCmd0x2Req vipFunCallAndRing$TSsoCmd0x2Req = this.f313083a.st_cmd0x2_req.get();
                String valueOf = String.valueOf(vipFunCallAndRing$TSsoCmd0x2Req.u64_friend_uin.get());
                int i3 = vipFunCallAndRing$TSsoCmd0x2Rsp.i32_funcall_id.get();
                int resIdByUin = VipFunCallUtil.getResIdByUin(VipSetFunCallHandler.this.f313082d, valueOf, 6, true, null);
                this.f313087e.setFunCallData(VipSetFunCallHandler.this.f313082d, 0, valueOf, i3, vipFunCallAndRing$TSsoCmd0x2Rsp.i32_ring_id.get(), null, 0L);
                com.tencent.mobileqq.vipav.a.c(VipSetFunCallHandler.this.f313082d, vipFunCallAndRing$TSsoCmd0x2Rsp.i32_funcall_id.get(), null, vipFunCallAndRing$TSsoCmd0x2Rsp.st_src_info.get(), true);
                if (VipFunCallUtil.isNetworkAllowDowanload()) {
                    this.f313087e.downloadFCSuit(i3, vipFunCallAndRing$TSsoCmd0x2Rsp.i32_ring_id.get(), false, 0, null);
                }
                VipSetFunCallHandler.this.N2(valueOf, i3, resIdByUin);
                this.f313084b.putString("uin", vipFunCallAndRing$TSsoCmd0x2Req.u64_friend_uin.get() + "");
                this.f313088f = vipFunCallAndRing$TSsoCmd0x2Rsp.i32_ring_id.get();
                this.f313089g = valueOf;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private VipFunCallAndRing$TSsoReq f313091a;

        /* renamed from: b, reason: collision with root package name */
        private int f313092b;

        /* renamed from: c, reason: collision with root package name */
        private Bundle f313093c;

        /* renamed from: d, reason: collision with root package name */
        private int f313094d;

        /* renamed from: e, reason: collision with root package name */
        private VipFunCallAndRing$TSsoRsp f313095e;

        /* renamed from: f, reason: collision with root package name */
        private IVipFunCallManager f313096f;

        /* renamed from: g, reason: collision with root package name */
        private int f313097g;

        /* renamed from: h, reason: collision with root package name */
        private String f313098h;

        public b(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq, int i3, Bundle bundle, int i16, VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp, IVipFunCallManager iVipFunCallManager, int i17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VipSetFunCallHandler.this, vipFunCallAndRing$TSsoReq, Integer.valueOf(i3), bundle, Integer.valueOf(i16), vipFunCallAndRing$TSsoRsp, iVipFunCallManager, Integer.valueOf(i17), str);
                return;
            }
            this.f313091a = vipFunCallAndRing$TSsoReq;
            this.f313092b = i3;
            this.f313093c = bundle;
            this.f313094d = i16;
            this.f313095e = vipFunCallAndRing$TSsoRsp;
            this.f313096f = iVipFunCallManager;
            this.f313097g = i17;
            this.f313098h = str;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f313097g;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f313098h;
        }

        public b c() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            VipFunCallAndRing$TSsoCmd0x3Req vipFunCallAndRing$TSsoCmd0x3Req = this.f313091a.st_cmd0x3_req.get();
            this.f313093c.putInt("callId", vipFunCallAndRing$TSsoCmd0x3Req.i32_funcall_id.get());
            if (this.f313094d == 0) {
                get();
                this.f313096f.setFunCallData(VipSetFunCallHandler.this.f313082d, 0, VipSetFunCallHandler.this.f313082d.getAccount(), vipFunCallAndRing$TSsoCmd0x3Req.i32_funcall_id.get(), vipFunCallAndRing$TSsoCmd0x3Req.i32_ring_id.get(), null, 0L);
                this.f313097g = vipFunCallAndRing$TSsoCmd0x3Req.i32_ring_id.get();
                this.f313098h = VipSetFunCallHandler.this.f313082d.getAccount();
            }
            if (1 == this.f313092b) {
                QQAppInterface qQAppInterface = VipSetFunCallHandler.this.f313082d;
                String valueOf = String.valueOf(vipFunCallAndRing$TSsoCmd0x3Req.i32_funcall_id.get());
                if (this.f313094d == 0) {
                    str = "0";
                } else {
                    str = "1";
                }
                VasWebviewTempUtil.reportVASTo00145(qQAppInterface, valueOf, "preview", "SetComCall", str, new String[0]);
            }
            return this;
        }
    }

    public VipSetFunCallHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f313082d = qQAppInterface;
        }
    }

    private void F2(FromServiceMsg fromServiceMsg, byte[] bArr, int i3, Bundle bundle, int i16) {
        QLog.e("VipSetFunCallHandler", 1, "onReceive~ isSuccess=false ,data=" + PkgTools.toHexStr(bArr) + ", funcType=" + i3);
        ReportCenter.f().r(VipFunCallConstants.CMD_FUN_CALL_SVR, 100, fromServiceMsg.getBusinessFailCode(), this.f313082d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.vgs), true);
        bundle.putInt("result", i16);
        notifyUI(i3, false, bundle);
    }

    @Nullable
    private Bundle G2(int i3, Object obj) {
        Bundle bundle;
        if (obj instanceof Bundle) {
            bundle = (Bundle) obj;
        } else {
            bundle = null;
        }
        if (bundle == null) {
            if (2 != i3 && 3 != i3 && 5 != i3) {
                return new Bundle();
            }
            QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error fcBundle==null funcType=" + i3);
            return null;
        }
        return bundle;
    }

    private int H2(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq) {
        if (vipFunCallAndRing$TSsoReq.i32_cmd.has()) {
            return vipFunCallAndRing$TSsoReq.i32_cmd.get();
        }
        return -1;
    }

    private void I2(boolean z16, VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq) {
        VipFunCallAndRing$TSsoCmd0x1Req vipFunCallAndRing$TSsoCmd0x1Req = new VipFunCallAndRing$TSsoCmd0x1Req();
        long j3 = 0;
        if (!z16) {
            j3 = VipFunCallUtil.getFunCallSP(this.f313082d, 1, null).getLong(VipFunCallConstants.KEY_LOCAL_VERSION, 0L);
        }
        vipFunCallAndRing$TSsoCmd0x1Req.u64_local_ver.set(j3);
        vipFunCallAndRing$TSsoReq.st_cmd0x1_req.set(vipFunCallAndRing$TSsoCmd0x1Req);
    }

    private void J2(int i3, VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp, String str, IVipFunCallManager iVipFunCallManager) {
        if (i3 == 0) {
            VipFunCallAndRing$TSsoCmd0x1Rsp vipFunCallAndRing$TSsoCmd0x1Rsp = vipFunCallAndRing$TSsoRsp.st_cmd0x1_rsp.get();
            long j3 = vipFunCallAndRing$TSsoCmd0x1Rsp.u64_server_ver.get();
            SharedPreferences funCallSP = VipFunCallUtil.getFunCallSP(this.f313082d, 1, null);
            if (funCallSP.getLong(VipFunCallConstants.KEY_LOCAL_VERSION, 0L) == j3) {
                QLog.d("VipSetFunCallHandler", 2, "onReceive localVer == ver.");
                return;
            }
            VipFunCallAndRing$TUserInfo vipFunCallAndRing$TUserInfo = vipFunCallAndRing$TSsoCmd0x1Rsp.st_User_Info.get();
            funCallSP.edit().putLong(VipFunCallConstants.KEY_LOCAL_VERSION, j3).apply();
            if (QLog.isColorLevel()) {
                QLog.d("VipSetFunCallHandler", 2, "onReceive~ localVer=" + str + ", ver=" + j3);
            }
            if (vipFunCallAndRing$TUserInfo != null) {
                QQAppInterface qQAppInterface = this.f313082d;
                iVipFunCallManager.setFunCallData(qQAppInterface, 0, qQAppInterface.getAccount(), vipFunCallAndRing$TUserInfo.i32_common_id.get(), vipFunCallAndRing$TUserInfo.i32_ring_id.get(), null, j3);
                com.tencent.mobileqq.vipav.a.c(this.f313082d, vipFunCallAndRing$TUserInfo.i32_common_id.get(), null, vipFunCallAndRing$TUserInfo.st_src_info.get(), true);
                List<VipFunCallAndRing$TGroupInfo> list = vipFunCallAndRing$TUserInfo.rpt_user_groups.get();
                if (list != null && list.size() > 0) {
                    funCallSP.edit().putString(VipFunCallConstants.KEY_GROUP, "").commit();
                    for (VipFunCallAndRing$TGroupInfo vipFunCallAndRing$TGroupInfo : list) {
                        iVipFunCallManager.setFunCallData(this.f313082d, 1, null, vipFunCallAndRing$TGroupInfo.i32_group_id.get(), vipFunCallAndRing$TGroupInfo.i32_ring_id.get(), vipFunCallAndRing$TGroupInfo.u64_group_uins.get(), 0L);
                        com.tencent.mobileqq.vipav.a.c(this.f313082d, vipFunCallAndRing$TGroupInfo.i32_group_id.get(), null, vipFunCallAndRing$TGroupInfo.st_src_info.get(), true);
                    }
                }
                if (VipFunCallUtil.isNetworkAllowDowanload()) {
                    iVipFunCallManager.downloadFCSuit(vipFunCallAndRing$TUserInfo.i32_common_id.get(), vipFunCallAndRing$TUserInfo.i32_ring_id.get(), false, 0, null);
                }
            }
            funCallSP.edit().putLong("update_time", System.currentTimeMillis()).commit();
        }
    }

    private void K2(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq, int i3, Bundle bundle, int i16, VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp, IVipFunCallManager iVipFunCallManager) {
        String str;
        VipFunCallAndRing$TSsoCmd0x4Req vipFunCallAndRing$TSsoCmd0x4Req = vipFunCallAndRing$TSsoReq.st_cmd0x4_req.get();
        bundle.putInt("callId", vipFunCallAndRing$TSsoCmd0x4Req.i32_funcall_id.get());
        if (i16 == 0) {
            vipFunCallAndRing$TSsoRsp.st_cmd0x4_rsp.get();
            iVipFunCallManager.setFunCallData(this.f313082d, 1, null, vipFunCallAndRing$TSsoCmd0x4Req.i32_funcall_id.get(), vipFunCallAndRing$TSsoCmd0x4Req.i32_ring_id.get(), vipFunCallAndRing$TSsoCmd0x4Req.rpt_uins.get(), 0L);
        }
        if (1 == i3) {
            QQAppInterface qQAppInterface = this.f313082d;
            String valueOf = String.valueOf(vipFunCallAndRing$TSsoCmd0x4Req.i32_funcall_id.get());
            if (i16 == 0) {
                str = "0";
            } else {
                str = "1";
            }
            VasWebviewTempUtil.reportVASTo00145(qQAppInterface, valueOf, "preview", "SetGroupCall", str, new String[0]);
        }
    }

    private void L2(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq, int i3, VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp, IVipFunCallManager iVipFunCallManager) {
        if (i3 == 0) {
            vipFunCallAndRing$TSsoRsp.st_cmd0x5_rsp.get();
            iVipFunCallManager.setFunCallData(this.f313082d, 2, null, vipFunCallAndRing$TSsoReq.st_cmd0x5_req.get().i32_funcall_id.get(), 0, null, 0L);
        }
    }

    private boolean M2(FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess() && obj != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(String str, int i3, int i16) {
        if (i3 != i16) {
            if (i16 == 0) {
                QQAppInterface qQAppInterface = this.f313082d;
                VipFunCallUtil.setNeedToShowTip(qQAppInterface, str, 2, qQAppInterface.getAccount(), i3);
            } else {
                QQAppInterface qQAppInterface2 = this.f313082d;
                VipFunCallUtil.setNeedToShowTip(qQAppInterface2, str, 1, qQAppInterface2.getAccount(), i3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) throws InvalidProtocolBufferMicroException {
        String str;
        int i3;
        String str2;
        String str3;
        int i16;
        int i17;
        boolean z16;
        VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq = new VipFunCallAndRing$TSsoReq();
        vipFunCallAndRing$TSsoReq.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
        int H2 = H2(vipFunCallAndRing$TSsoReq);
        int i18 = toServiceMsg.extraData.getInt("srcType", 0);
        int i19 = toServiceMsg.extraData.getInt("from");
        Bundle bundle = new Bundle();
        bundle.putInt("srcType", i18);
        if (!M2(fromServiceMsg, obj)) {
            F2(fromServiceMsg, (byte[]) obj, H2, bundle, -1);
            return true;
        }
        VipFunCallAndRing$TSsoRsp vipFunCallAndRing$TSsoRsp = new VipFunCallAndRing$TSsoRsp();
        vipFunCallAndRing$TSsoRsp.mergeFrom((byte[]) obj);
        int i26 = vipFunCallAndRing$TSsoRsp.i32_ret.get();
        String str4 = vipFunCallAndRing$TSsoRsp.str_msg.get();
        String str5 = vipFunCallAndRing$TSsoRsp.str_url.get();
        String str6 = vipFunCallAndRing$TSsoRsp.str_act_wording.get();
        bundle.putInt("result", i26);
        IVipFunCallManager funCallManager = VasUtil.getService().getFunCallManager();
        if (QLog.isColorLevel()) {
            QLog.d("VipSetFunCallHandler", 2, "VipSetFunCallHandler onReceive~ ret=" + i26 + ",msg=" + str4 + ", url=" + str5 + ", funcType=" + H2 + ", srcType=" + i18 + ", actStr=" + str6);
        }
        String str7 = null;
        int i27 = 1;
        if (H2 != 1 && H2 != 2) {
            if (ar.b("kenaiyu", "2024-11-13", "vas_feature_rm_funcall_set").isEnable(true)) {
                VasNtCommonReporter.getHistoryFeature("funcall_set").setValue2(H2 + "").reportEveryDay();
                return true;
            }
            i27 = 1;
        }
        if (H2 != i27) {
            if (H2 != 2) {
                if (H2 != 3) {
                    if (H2 != 4) {
                        if (H2 != 5) {
                            QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + H2);
                        } else {
                            L2(vipFunCallAndRing$TSsoReq, i26, vipFunCallAndRing$TSsoRsp, funCallManager);
                        }
                        str = str6;
                    } else {
                        K2(vipFunCallAndRing$TSsoReq, i19, bundle, i26, vipFunCallAndRing$TSsoRsp, funCallManager);
                        str = str6;
                    }
                    i3 = H2;
                    str2 = str4;
                    str3 = str5;
                    i16 = -1;
                } else {
                    str = str6;
                    i3 = H2;
                    str2 = str4;
                    b c16 = new b(vipFunCallAndRing$TSsoReq, i19, bundle, i26, vipFunCallAndRing$TSsoRsp, funCallManager, -1, null).c();
                    i17 = c16.a();
                    str7 = c16.b();
                    str3 = str5;
                }
            } else {
                str = str6;
                i3 = H2;
                str2 = str4;
                str3 = str5;
                a c17 = new a(vipFunCallAndRing$TSsoReq, bundle, i26, vipFunCallAndRing$TSsoRsp, funCallManager, -1, null).c();
                i17 = c17.a();
                str7 = c17.b();
            }
            String str8 = str7;
            bundle.putString("message", str2);
            bundle.putString(VipFunCallConstants.KEY_SV_URL, str3);
            bundle.putString(VipFunCallConstants.KEY_SV_ACTSTR, str);
            int i28 = i3;
            if (i26 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            notifyUI(i28, z16, bundle);
            R2(i17, str8);
            return false;
        }
        str = str6;
        i3 = H2;
        str2 = str4;
        str3 = str5;
        i16 = -1;
        J2(i26, vipFunCallAndRing$TSsoRsp, str2, funCallManager);
        i17 = i16;
        String str82 = str7;
        bundle.putString("message", str2);
        bundle.putString(VipFunCallConstants.KEY_SV_URL, str3);
        bundle.putString(VipFunCallConstants.KEY_SV_ACTSTR, str);
        int i282 = i3;
        if (i26 != 0) {
        }
        notifyUI(i282, z16, bundle);
        R2(i17, str82);
        return false;
    }

    private void R2(int i3, String str) {
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(str));
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, str);
            aVar.m();
            long j3 = i3;
            aVar.o(j3);
            aVar.h0(j3);
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(new ArrayList<>(Collections.singletonList(aVar)), "VipSetFunCallHandler", (c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
        }
    }

    private int S2(VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq, int i3, Bundle bundle) {
        int i16 = bundle.getInt("srcType", i3);
        int i17 = bundle.getInt("callId");
        int i18 = bundle.getInt(VipFunCallConstants.KEY_RING_ID);
        if (i17 == 0) {
            QLog.d("VipSetFunCallHandler", 1, "sendReqToSVR Error 3 callId=" + i17);
        }
        VipFunCallAndRing$TSsoCmd0x3Req vipFunCallAndRing$TSsoCmd0x3Req = new VipFunCallAndRing$TSsoCmd0x3Req();
        vipFunCallAndRing$TSsoCmd0x3Req.i32_funcall_id.set(i17);
        vipFunCallAndRing$TSsoCmd0x3Req.i32_ring_id.set(i18);
        vipFunCallAndRing$TSsoReq.st_cmd0x3_req.set(vipFunCallAndRing$TSsoCmd0x3Req);
        return i16;
    }

    public void P2(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, obj);
        } else {
            Q2(i3, obj, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Q2(int i3, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), obj, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(VipFunCallConstants.CMD_FUN_CALL_SVR);
        VipFunCallAndRing$TSsoReq vipFunCallAndRing$TSsoReq = new VipFunCallAndRing$TSsoReq();
        vipFunCallAndRing$TSsoReq.i32_implat.set(109);
        vipFunCallAndRing$TSsoReq.i32_cmd.set(i3);
        vipFunCallAndRing$TSsoReq.str_qq_ver.set(AppSetting.f99551k);
        Bundle G2 = G2(i3, obj);
        if (G2 == null) {
            return;
        }
        int i17 = G2.getInt("from");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + i3);
                            return;
                        }
                        VipFunCallAndRing$TSsoCmd0x5Req vipFunCallAndRing$TSsoCmd0x5Req = new VipFunCallAndRing$TSsoCmd0x5Req();
                        i16 = G2.getInt("srcType", 0);
                        int i18 = G2.getInt("callId");
                        if (i18 == 0) {
                            QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error 5 callId5=" + i18);
                        }
                        vipFunCallAndRing$TSsoCmd0x5Req.i32_funcall_id.set(i18);
                        vipFunCallAndRing$TSsoReq.st_cmd0x5_req.set(vipFunCallAndRing$TSsoCmd0x5Req);
                    } else {
                        vipFunCallAndRing$TSsoReq.st_cmd0x4_req.set((VipFunCallAndRing$TSsoCmd0x4Req) obj);
                        i17 = 1;
                    }
                } else {
                    i16 = S2(vipFunCallAndRing$TSsoReq, 0, G2);
                }
                vipFunCallAndRing$TSsoReq.setHasFlag(true);
                createToServiceMsg.extraData.putInt("srcType", i16);
                createToServiceMsg.extraData.putInt("from", i17);
                createToServiceMsg.putWupBuffer(vipFunCallAndRing$TSsoReq.toByteArray());
                if (QLog.isColorLevel()) {
                    QLog.d("VipSetFunCallHandler", 2, "sendReqToSVR funcType=" + i3 + ", srcType:" + i16);
                }
                super.sendPbReq(createToServiceMsg);
            }
            VipFunCallAndRing$TSsoCmd0x2Req vipFunCallAndRing$TSsoCmd0x2Req = new VipFunCallAndRing$TSsoCmd0x2Req();
            vipFunCallAndRing$TSsoCmd0x2Req.u64_friend_uin.set(G2.getLong("uin"));
            vipFunCallAndRing$TSsoCmd0x2Req.str_friend_phone.set(G2.getString("phone"));
            vipFunCallAndRing$TSsoReq.st_cmd0x2_req.set(vipFunCallAndRing$TSsoCmd0x2Req);
        } else {
            I2(z16, vipFunCallAndRing$TSsoReq);
        }
        i16 = 0;
        vipFunCallAndRing$TSsoReq.setHasFlag(true);
        createToServiceMsg.extraData.putInt("srcType", i16);
        createToServiceMsg.extraData.putInt("from", i17);
        createToServiceMsg.putWupBuffer(vipFunCallAndRing$TSsoReq.toByteArray());
        if (QLog.isColorLevel()) {
        }
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return VipFunCallObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!VipFunCallConstants.CMD_FUN_CALL_SVR.equals(fromServiceMsg.getServiceCmd())) {
            return;
        }
        try {
            O2(toServiceMsg, fromServiceMsg, obj);
        } catch (Exception e16) {
            QLog.e("VipSetFunCallHandler", 2, "onReceive prb.mergeFrom error: " + e16.getMessage());
        }
    }
}
