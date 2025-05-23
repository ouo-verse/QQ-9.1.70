package com.tencent.mobileqq.app;

import IPwdPxyMQQ.RespondQueryIPwdStat;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.msg.nt_register_proxy$OnlineInfo;
import tencent.im.msg.nt_register_proxy$PCStatInfo;
import tencent.im.msg.nt_register_proxy$PushParams;
import tencent.im.s2c.msgtype0x210.submsgtype0x15d.SubMsgType0x15d$OnlineDevInfo;
import tencent.im.statsvc.getonline.StatSvcGetOnline$Instance;
import tencent.im.statsvc.getonline.StatSvcGetOnline$ReqBody;
import tencent.im.statsvc.getonline.StatSvcGetOnline$RspBody;
import tencent.im.statsvc.stat.mute.StatSetMute$ReqBody;
import tencent.im.statsvc.stat.mute.StatSetMute$RspBody;

/* loaded from: classes11.dex */
public class RegisterProxySvcPackHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private long G;
    private long H;
    private long I;
    private int J;
    private final CopyOnWriteArrayList<Integer> K;
    protected Handler L;
    private final QQAppInterface M;

    /* renamed from: d, reason: collision with root package name */
    private int f194995d;

    /* renamed from: e, reason: collision with root package name */
    private int f194996e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f194997f;

    /* renamed from: h, reason: collision with root package name */
    private int f194998h;

    /* renamed from: i, reason: collision with root package name */
    private int f194999i;

    /* renamed from: m, reason: collision with root package name */
    private int f195000m;

    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterProxySvcPackHandler.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 101) {
                if (i3 == 102) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RegisterProxySvcPack", 2, "real notify padStatus:", Integer.valueOf(RegisterProxySvcPackHandler.this.f194996e), " ,isPad:", Boolean.valueOf(RegisterProxySvcPackHandler.this.f194997f), " ,devStatus:", Integer.valueOf(RegisterProxySvcPackHandler.this.J), " ,clientType:", Long.valueOf(RegisterProxySvcPackHandler.this.H), " ,appid:", Long.valueOf(RegisterProxySvcPackHandler.this.I));
                    }
                    RegisterProxySvcPackHandler registerProxySvcPackHandler = RegisterProxySvcPackHandler.this;
                    registerProxySvcPackHandler.notifyUI(2, true, new Object[]{Integer.valueOf(registerProxySvcPackHandler.J)});
                    if (RegisterProxySvcPackHandler.this.J == 0) {
                        if (!RegisterProxySvcPackHandler.this.V2() && !RegisterProxySvcPackHandler.this.L.hasMessages(101)) {
                            RegisterProxySvcPackHandler.this.L.sendEmptyMessageDelayed(101, 3000L);
                        }
                        com.tencent.mobileqq.util.az.d(false);
                        return;
                    }
                    return;
                }
                return;
            }
            RegisterProxySvcPackHandler.this.M2();
        }
    }

    RegisterProxySvcPackHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194995d = 0;
        this.f194996e = 0;
        this.f194997f = false;
        this.f194998h = 0;
        this.f194999i = 0;
        this.f195000m = 1;
        this.C = 1;
        this.D = 0;
        this.E = 1;
        this.F = false;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0;
        this.K = new CopyOnWriteArrayList<>();
        this.L = new a(Looper.getMainLooper());
        this.M = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V2() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102836", false);
        QLog.d("RegisterProxySvcPack", 1, "needCloseDeviceInfoRequest switch is: " + isSwitchOn);
        return isSwitchOn;
    }

    public void J2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else {
            this.K.add(Integer.valueOf(i3));
        }
    }

    public boolean K2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, i3)).booleanValue();
        }
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = this.K;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            return this.K.contains(Integer.valueOf(i3));
        }
        return false;
    }

    public synchronized boolean L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.F;
    }

    public void M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        StatSvcGetOnline$ReqBody statSvcGetOnline$ReqBody = new StatSvcGetOnline$ReqBody();
        statSvcGetOnline$ReqBody.uint64_uin.set(this.M.getLongAccountUin());
        statSvcGetOnline$ReqBody.uint32_appid.set(0);
        ToServiceMsg createToServiceMsg = createToServiceMsg("StatSvc.GetOnlineStatus");
        createToServiceMsg.putWupBuffer(statSvcGetOnline$ReqBody.toByteArray());
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        send(createToServiceMsg);
    }

    public synchronized int N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f194996e;
    }

    public synchronized int O2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f194998h;
    }

    public synchronized int P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f194995d;
    }

    public synchronized int Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f195000m;
    }

    public synchronized int R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.D;
    }

    public synchronized int S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.E;
    }

    public synchronized long T2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.G;
    }

    public synchronized boolean U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f194997f;
    }

    public void W2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RegisterProxySvcPack", 2, "iState:" + this.f194995d + ", clientType:" + this.H + ", appId:" + this.I);
        }
        if (!this.L.hasMessages(102)) {
            this.L.sendEmptyMessageDelayed(102, 1000L);
        }
    }

    public void X2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            notifyUI(3, true, new Object[]{Integer.valueOf(i3)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    public void Y2(nt_register_proxy$PushParams nt_register_proxy_pushparams) {
        boolean z16;
        int i3;
        ?? r56;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) nt_register_proxy_pushparams);
            return;
        }
        if (nt_register_proxy_pushparams == null) {
            QLog.e("RegisterProxySvcPack", 1, "onReceiveNtPack is null");
            return;
        }
        nt_register_proxy$PCStatInfo nt_register_proxy_pcstatinfo = nt_register_proxy_pushparams.pc_stat_info;
        k3(nt_register_proxy_pcstatinfo.support_dataline.get());
        l3(nt_register_proxy_pcstatinfo.support_print.get());
        m3(nt_register_proxy_pcstatinfo.support_view_pc_file.get());
        n3(nt_register_proxy_pcstatinfo.pc_version.get());
        ArrayList arrayList = (ArrayList) nt_register_proxy_pushparams.online_infos.get();
        boolean p16 = AppSetting.p(BaseApplication.getContext());
        nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo = null;
        nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo2 = null;
        nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo3 = null;
        nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo4 = null;
        if (arrayList != null) {
            i3 = 0;
            boolean z17 = false;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo5 = (nt_register_proxy$OnlineInfo) arrayList.get(i16);
                if (nt_register_proxy_onlineinfo5.client_type.get() != 9 && nt_register_proxy_onlineinfo5.client_type.get() != 13) {
                    if (nt_register_proxy_onlineinfo5.client_type.get() == 15) {
                        nt_register_proxy_onlineinfo = nt_register_proxy_onlineinfo5;
                    } else if (p16 && nt_register_proxy_onlineinfo5.client_type.get() == 7) {
                        nt_register_proxy_onlineinfo3 = nt_register_proxy_onlineinfo5;
                    } else if (nt_register_proxy_onlineinfo5.client_type_new.get() == 81154) {
                        nt_register_proxy_onlineinfo2 = nt_register_proxy_onlineinfo5;
                    } else if (nt_register_proxy_onlineinfo5.client_type_new.get() == 65793 || nt_register_proxy_onlineinfo5.client_type_new.get() == 77313 || nt_register_proxy_onlineinfo5.client_type_new.get() == 83714) {
                        nt_register_proxy_onlineinfo4 = nt_register_proxy_onlineinfo5;
                    }
                } else if (!AppSetting.p(BaseApplication.getContext())) {
                    if (nt_register_proxy_onlineinfo5.client_type.get() == 9) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    i3 = nt_register_proxy_onlineinfo5.online_stat.get();
                }
                QLog.d("RegisterProxySvcPack", 2, "NT onReceive client_type: " + nt_register_proxy_onlineinfo5.client_type.get() + " client_type_new : " + nt_register_proxy_onlineinfo5.client_type_new.get() + " online_stat: " + nt_register_proxy_onlineinfo5.online_stat.get());
            }
            z16 = z17;
        } else {
            z16 = false;
            i3 = 0;
        }
        h3(i3, z16);
        if (nt_register_proxy_onlineinfo != null) {
            r56 = 1;
            r56 = 1;
            if (nt_register_proxy_onlineinfo.online_stat.get() == 1) {
                j3(1);
                c3(66831L);
                b3(nt_register_proxy_onlineinfo.instance_id.get());
                notifyUI(1, true, new Object[]{1, Integer.valueOf(nt_register_proxy_pcstatinfo.support_dataline.get())});
            }
        } else {
            r56 = 1;
        }
        if (nt_register_proxy_onlineinfo2 != null && nt_register_proxy_onlineinfo2.online_stat.get() == r56) {
            j3(r56);
            c3(81154L);
            b3(nt_register_proxy_onlineinfo2.instance_id.get());
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf((int) r56);
            objArr[r56] = Integer.valueOf(nt_register_proxy_pcstatinfo.support_dataline.get());
            notifyUI(r56, r56, objArr);
        }
        if (nt_register_proxy_onlineinfo3 != null && nt_register_proxy_onlineinfo3.online_stat.get() == r56) {
            i3(nt_register_proxy_onlineinfo3.online_stat.get());
            c3(65799L);
            b3(nt_register_proxy_onlineinfo3.instance_id.get());
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf((int) r56);
            objArr2[r56] = Integer.valueOf(nt_register_proxy_pcstatinfo.support_dataline.get());
            notifyUI(r56, r56, objArr2);
        }
        if (nt_register_proxy_onlineinfo4 != null && nt_register_proxy_onlineinfo4.online_stat.get() == r56) {
            int i17 = nt_register_proxy_onlineinfo4.online_stat.get();
            if (nt_register_proxy_onlineinfo4.client_type_new.get() != 83714 && nt_register_proxy_pcstatinfo.support_dataline.get() == 2) {
                i17 = 0;
            }
            j3(i17);
            if (i17 == 1) {
                c3(nt_register_proxy_onlineinfo4.client_type.get());
                b3(1L);
            }
            notifyUI(1, true, new Object[]{Integer.valueOf(i17), Integer.valueOf(nt_register_proxy_pcstatinfo.support_dataline.get())});
        }
        this.J = ((rd0.g) this.M.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).r(nt_register_proxy_pushparams) ? 1 : 0;
        W2();
        QLog.d("RegisterProxySvcPack", 2, "NT online status of pc supportdataline: " + nt_register_proxy_pcstatinfo.support_dataline.get() + "support_print: " + nt_register_proxy_pcstatinfo.support_print.get() + "support_view_pc_file : " + nt_register_proxy_pcstatinfo.support_view_pc_file.get() + " PcVersion: " + nt_register_proxy_pcstatinfo.pc_version.get() + "- uRoamFlag: " + nt_register_proxy_pushparams.udc_flag.c2c_roam_msg_flag.get());
        ArrayList arrayList2 = (ArrayList) nt_register_proxy_pushparams.game_box_appids.get();
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("gameBoxAppid", 0);
        sharedPreferences.edit().putInt("size", arrayList2.size()).apply();
        for (int i18 = 0; i18 < arrayList2.size(); i18++) {
            sharedPreferences.edit().putLong(String.valueOf(i18), ((Long) arrayList2.get(i18)).longValue()).apply();
        }
        QLog.d("RegisterProxySvcPack", 2, "NT onReceiveNtPack : iIsSupportC2CRoamMsg: " + nt_register_proxy_pushparams.udc_flag.c2c_roam_msg_flag.get() + " iIsSupportDataLine : " + nt_register_proxy_pcstatinfo.support_dataline.get() + " iIsSupportPrintable: " + nt_register_proxy_pcstatinfo.support_print.get() + " iIsSupportViewPCFile" + nt_register_proxy_pcstatinfo.support_view_pc_file.get() + " iPcVersion :" + nt_register_proxy_pcstatinfo.pc_version.get() + " iGuildUdcFlag" + nt_register_proxy_pushparams.udc_flag.guild_flag.get() + " iGuildSwitchFlag : " + nt_register_proxy_pushparams.udc_flag.guild_switch_flag.get() + " gameboxAppids" + arrayList2);
    }

    public void Z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            send(createToServiceMsg("RegPrxySvc.infoAndroid"));
        }
    }

    public void a3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        StatSetMute$ReqBody statSetMute$ReqBody = new StatSetMute$ReqBody();
        statSetMute$ReqBody.set_mute.set(z16 ? 1 : 0);
        ToServiceMsg createToServiceMsg = createToServiceMsg("StatSvc.SetMute");
        createToServiceMsg.putWupBuffer(statSetMute$ReqBody.toByteArray());
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        createToServiceMsg.extraData.putBoolean("param_is_mute", z16);
        send(createToServiceMsg);
    }

    public synchronized void b3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
        } else {
            this.I = j3;
        }
    }

    public synchronized void c3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, j3);
        } else {
            this.H = j3;
        }
    }

    public synchronized void d3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public synchronized void e3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.f194999i = i3;
        }
    }

    public synchronized void f3(long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RegisterProxySvcPack", 2, "uIsSetPwd = " + j3);
        }
        if (j3 == 1) {
            i3 = 1;
        } else if (j3 == 2) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        QQAppInterface qQAppInterface = this.M;
        if (qQAppInterface != null && i3 != -1) {
            qQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_is_set_password" + this.M.getCurrentAccountUin(), i3).commit();
        } else if (QLog.isColorLevel()) {
            QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or isSetPassword is error ,isSetPassword = " + i3);
        }
    }

    public synchronized void g3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public synchronized boolean h3(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        this.f194996e = i3;
        if (this.f194997f == z16) {
            return false;
        }
        this.f194997f = z16;
        return true;
    }

    public synchronized void i3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f194998h = i3;
        }
    }

    public synchronized void j3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f194995d = i3;
        }
    }

    public synchronized void k3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f195000m = i3;
        }
    }

    public synchronized void l3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public synchronized void m3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public synchronized void n3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
            return;
        }
        QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + j3);
        this.G = j3;
    }

    public void o3(ArrayList<SubMsgType0x15d$OnlineDevInfo> arrayList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) arrayList);
            return;
        }
        this.K.clear();
        if (arrayList == null) {
            return;
        }
        Iterator<SubMsgType0x15d$OnlineDevInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            switch (it.next().client_type.get()) {
                case 65793:
                case 66818:
                case 66831:
                case 77313:
                case 81154:
                case 83714:
                    i3 = 0;
                    break;
                case 65799:
                case 67586:
                    i3 = 2;
                    break;
                case Friends.TERM_TYPE_MOBILE_HD /* 65805 */:
                case Friends.TERM_TYPE_ANDROID_PAD /* 68104 */:
                case Friends.TERM_TYPE_MOBILE_IPAD /* 68361 */:
                case Friends.TERM_TYPE_MOBILE_IPAD_NEW /* 72194 */:
                case 88322:
                    i3 = 1;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            if (i3 != -1) {
                this.K.add(Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return cq.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
            QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat")) {
            if (obj != null) {
                RespondQueryIPwdStat respondQueryIPwdStat = (RespondQueryIPwdStat) obj;
                f3(respondQueryIPwdStat.uIsSetPwd);
                if (QLog.isColorLevel()) {
                    QLog.d("RegisterProxySvcPack", 2, "QueryIPwdStat:" + respondQueryIPwdStat.uIsSetPwd);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
                return;
            }
            return;
        }
        boolean z18 = false;
        if (fromServiceMsg.getServiceCmd().equals("StatSvc.GetOnlineStatus")) {
            if (fromServiceMsg.isSuccess() && obj != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive :" + z17);
            }
            if (z17) {
                try {
                    StatSvcGetOnline$RspBody statSvcGetOnline$RspBody = new StatSvcGetOnline$RspBody();
                    statSvcGetOnline$RspBody.mergeFrom((byte[]) obj);
                    int i3 = statSvcGetOnline$RspBody.error_code.get();
                    if (i3 == 0) {
                        z18 = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("RegisterProxySvcPack", 2, "errorCode: " + i3);
                    }
                    if (z18) {
                        if (statSvcGetOnline$RspBody.uint64_uin.has() && this.M.getLongAccountUin() == statSvcGetOnline$RspBody.uint64_uin.get() && statSvcGetOnline$RspBody.msg_instances.has()) {
                            for (StatSvcGetOnline$Instance statSvcGetOnline$Instance : statSvcGetOnline$RspBody.msg_instances.get()) {
                                if (statSvcGetOnline$Instance != null) {
                                    int i16 = statSvcGetOnline$Instance.uint32_client_type.get();
                                    if (QLog.isColorLevel()) {
                                        QLog.e("RegisterProxySvcPack", 2, "uint32_client_type: " + i16);
                                    }
                                    if (i16 == 65793 || i16 == 77313 || i16 == 66831 || i16 == 81154) {
                                        j3(1);
                                        c3(i16);
                                        b3(statSvcGetOnline$Instance.uint32_instance_id.get());
                                        W2();
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (statSvcGetOnline$RspBody.error_msg.has() && QLog.isColorLevel()) {
                        QLog.e("RegisterProxySvcPack", 2, "err msg: " + statSvcGetOnline$RspBody.error_msg.get());
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive fail: ", e16);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("StatSvc.SetMute")) {
            if (QLog.isColorLevel()) {
                QLog.d("RegisterProxySvcPack", 2, "CMD_REQ_SET_MUTE onReceive :" + fromServiceMsg.isSuccess());
            }
            if (obj != null) {
                try {
                    StatSetMute$RspBody statSetMute$RspBody = new StatSetMute$RspBody();
                    statSetMute$RspBody.mergeFrom((byte[]) obj);
                    int i17 = statSetMute$RspBody.error_code.get();
                    if (i17 == 0) {
                        if (statSetMute$RspBody.set_mute_resp.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        SettingCloneUtil.writeValue(this.M.getApp().getApplicationContext(), this.M.getCurrentUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, z16);
                        com.tencent.mobileqq.util.az.d(z16);
                        if (QLog.isColorLevel()) {
                            QLog.d("RegisterProxySvcPack", 2, "setmute success ismute:", Boolean.valueOf(z16));
                        }
                        notifyUI(4, true, new Object[]{Boolean.valueOf(z16)});
                        return;
                    }
                    QLog.d("RegisterProxySvcPack", 1, "setmute err:", Integer.valueOf(i17), " ,msg:", statSetMute$RspBody.error_msg.get());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }
}
