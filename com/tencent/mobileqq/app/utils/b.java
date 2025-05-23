package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f196635d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, C7393b> f196636e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f196637f;

    /* renamed from: h, reason: collision with root package name */
    private long f196638h;

    /* renamed from: i, reason: collision with root package name */
    private long f196639i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f196640a;

        /* renamed from: b, reason: collision with root package name */
        public long f196641b;

        /* renamed from: c, reason: collision with root package name */
        public long f196642c;

        /* renamed from: d, reason: collision with root package name */
        public long f196643d;

        public a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
                return;
            }
            this.f196641b = -1L;
            this.f196642c = -1L;
            this.f196643d = -1L;
            this.f196640a = Long.toString(j3);
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f196640a = null;
            this.f196641b = -1L;
            this.f196643d = -1L;
            this.f196642c = -1L;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7393b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f196644a;

        /* renamed from: b, reason: collision with root package name */
        public int f196645b;

        /* renamed from: c, reason: collision with root package name */
        public int f196646c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f196647d;

        /* renamed from: e, reason: collision with root package name */
        public long f196648e;

        public C7393b(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f196644a = str;
            this.f196645b = i3;
            this.f196646c = i16;
            this.f196647d = false;
            this.f196648e = System.currentTimeMillis();
        }
    }

    public b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f196638h = -1L;
        this.f196639i = -1L;
        this.f196635d = qQAppInterface;
        this.f196636e = new ConcurrentHashMap<>(0);
        this.f196637f = new ConcurrentHashMap<>(0);
        i();
    }

    private void g(String str) {
        byte b16;
        C7393b c7393b;
        Object obj;
        short s16 = 0;
        Pair<Boolean, Setting> qQHeadSetting = this.f196635d.getQQHeadSetting(4, str, 0);
        if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
            Setting setting = (Setting) obj;
            s16 = setting.systemHeadID;
            b16 = setting.bHeadType;
        } else {
            b16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleUpdateStrangerHeadReal uin=" + str + ",localHeadID=" + ((int) s16) + ",localType=" + ((int) b16));
            StringBuilder sb5 = new StringBuilder(1000);
            for (Map.Entry<String, C7393b> entry : this.f196636e.entrySet()) {
                sb5.append(" QQ 18 handle mHeadIdMap: uin=");
                sb5.append(entry.getKey());
                sb5.append(",headid=");
                sb5.append(entry.getValue().f196645b);
                sb5.append(",type=");
                sb5.append(entry.getValue().f196646c);
                sb5.append(",isRequest=");
                sb5.append(entry.getValue().f196647d);
                sb5.append(",saveTime=");
                sb5.append(entry.getValue().f196648e);
                sb5.append("\n");
                QLog.d("ClassicHeadActivityManager", 2, sb5.toString());
            }
        }
        if (this.f196636e.containsKey(str) && (c7393b = this.f196636e.get(str)) != null) {
            int i3 = c7393b.f196645b;
            int i16 = c7393b.f196646c;
            if (((i16 == 0 && i3 != s16) || i16 != b16) && !c7393b.f196647d) {
                c7393b.f196647d = true;
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder(1000);
                    sb6.append("QQ 18 get and update stranger update head uin = ");
                    sb6.append(str);
                    sb6.append(",receiveSysid = ");
                    sb6.append(i3);
                    sb6.append(",receiveType = ");
                    sb6.append(i16);
                    sb6.append(",localSysid = ");
                    sb6.append((int) s16);
                    sb6.append(",loaclType = ");
                    sb6.append((int) b16);
                    sb6.append("\n");
                    QLog.d("ClassicHeadActivityManager", 2, sb6.toString());
                }
                ((IQQAvatarHandlerService) this.f196635d.getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(str);
                this.f196636e.put(str, c7393b);
            }
            if (i3 == s16 && i16 == b16 && c7393b.f196647d) {
                if (QLog.isColorLevel()) {
                    QLog.d("ClassicHeadActivityManager", 4, " QQ 18 remove update map uin = " + str + ",receiveSysid = " + i3 + ",localSysid = " + ((int) s16));
                }
                this.f196636e.remove(str);
            }
        }
    }

    public Setting a() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Setting) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Pair<Boolean, Setting> qQHeadSetting = this.f196635d.getQQHeadSetting(1, this.f196635d.getCurrentAccountUin(), 0);
        if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
            return (Setting) obj;
        }
        return null;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        long j3 = PreferenceManager.getDefaultSharedPreferences(this.f196635d.getApp()).getLong("classic_head_activity_switch_" + this.f196635d.getCurrentUin(), -1L);
        if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, "getSwitch key=classic_head_activity_switch value= " + j3);
        }
        return j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dd, code lost:
    
        if (r8 != r13) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ef, code lost:
    
        r2.append(" fetch userHead");
        r3.getCustomHead(r18.f196640a);
        r6.notifyUI(3, true, r18.f196640a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        if (r13 == 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(a aVar) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        if (h() && aVar != null) {
            StringBuilder sb5 = new StringBuilder("handleFriendHeadFlagItem");
            sb5.append(" uin=");
            sb5.append(StringUtil.getSimpleUinForPrint(aVar.f196640a));
            sb5.append(" sysId=");
            sb5.append(aVar.f196642c);
            sb5.append(" headType=");
            sb5.append(aVar.f196643d);
            sb5.append(" qq18Switch=");
            sb5.append(aVar.f196641b);
            if (!TextUtils.isEmpty(aVar.f196640a) && aVar.f196640a.equals(this.f196635d.getCurrentAccountUin())) {
                long j3 = aVar.f196641b;
                if (j3 != -1) {
                    k(j3);
                }
            }
            IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) this.f196635d.getRuntimeService(IQQAvatarHandlerService.class, "");
            FriendListHandler friendListHandler = (FriendListHandler) this.f196635d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            Pair<Boolean, Setting> qQHeadSetting = this.f196635d.getQQHeadSetting(1, aVar.f196640a, 0);
            if (qQHeadSetting != null && ((Boolean) qQHeadSetting.first).booleanValue()) {
                iQQAvatarHandlerService.getCustomHead(aVar.f196640a);
                friendListHandler.notifyUI(3, true, aVar.f196640a);
            } else if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
                Setting setting = (Setting) obj;
                long j16 = setting.systemHeadID;
                long j17 = setting.bHeadType;
                sb5.append(" localsysId=");
                sb5.append(j16);
                sb5.append(" localheadType=");
                sb5.append(j17);
                if (aVar.f196641b == 1) {
                    long j18 = aVar.f196643d;
                    if (j18 != -1) {
                    }
                }
                long j19 = aVar.f196642c;
                if (j19 != -1) {
                    if (j19 != j16) {
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ClassicHeadActivityManager", 2, sb5.toString());
            }
        }
    }

    public void d(String str) {
        ConcurrentHashMap<String, C7393b> concurrentHashMap;
        C7393b c7393b;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.f196636e) != null && concurrentHashMap.containsKey(str) && (c7393b = this.f196636e.get(str)) != null && c7393b.f196647d) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleGetHeadError uin=" + str + ",HeadID=" + c7393b.f196645b + ",Type=" + c7393b.f196646c + ",IsRequest=" + c7393b.f196647d);
            this.f196636e.remove(str);
        }
    }

    public void e(long j3, long j16, long j17) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (this.f196635d.getApp() == null && this.f196635d.getCurrentUin() == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("handleInitValue");
        sb5.append(" sysId=");
        sb5.append(j3);
        sb5.append(" headType=");
        sb5.append(j16);
        sb5.append(" qq18Switch=");
        sb5.append(j17);
        String currentAccountUin = this.f196635d.getCurrentAccountUin();
        k(j17);
        if (j17 != 1) {
            return;
        }
        IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) this.f196635d.getRuntimeService(IQQAvatarHandlerService.class, "");
        FriendListHandler friendListHandler = (FriendListHandler) this.f196635d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Pair<Boolean, Setting> qQHeadSetting = this.f196635d.getQQHeadSetting(1, currentAccountUin, 0);
        if (qQHeadSetting != null && ((Boolean) qQHeadSetting.first).booleanValue()) {
            iQQAvatarHandlerService.getCustomHead(currentAccountUin);
            friendListHandler.notifyUI(3, true, currentAccountUin);
        } else if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
            Setting setting = (Setting) obj;
            long j18 = setting.systemHeadID;
            long j19 = setting.bHeadType;
            sb5.append(" localSysId=");
            sb5.append(j18);
            sb5.append(" localheadType=");
            sb5.append(j19);
            if (j16 != j19 || (j16 == 0 && j3 != j18)) {
                sb5.append(" fetch userHead");
                iQQAvatarHandlerService.getCustomHead(currentAccountUin);
                friendListHandler.notifyUI(3, true, currentAccountUin);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, sb5.toString());
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (this.f196635d != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead strangerUin = " + str);
            }
            String currentAccountUin = this.f196635d.getCurrentAccountUin();
            if (currentAccountUin.equals(str)) {
                ConcurrentHashMap<String, C7393b> concurrentHashMap = this.f196636e;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(currentAccountUin)) {
                    this.f196636e.remove(currentAccountUin);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead remove current user ");
                    return;
                }
                return;
            }
            Automator automator = this.f196635d.mAutomator;
            if (automator != null && automator.isInRealActionLoginB()) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.f196637f;
                if (concurrentHashMap2 != null && !concurrentHashMap2.containsKey(str)) {
                    this.f196637f.put(str, "");
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, C7393b> concurrentHashMap3 = this.f196636e;
            if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                g(str);
            }
        }
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0() * 1000;
        long j3 = this.f196638h;
        if (j3 != -1) {
            long j16 = this.f196639i;
            if (j16 != -1 && K0 > j3 && K0 < j16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ClassicHeadActivityManager", 2, "ClassicHeadActivityActivate is activate");
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void i() {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String x16 = ea.x(this.f196635d.getApp(), this.f196635d.getCurrentAccountUin());
        if (!TextUtils.isEmpty(x16) && (split = x16.split("\\|")) != null && split.length == 2) {
            this.f196638h = com.tencent.mobileqq.armap.c.a(split[0]);
            this.f196639i = com.tencent.mobileqq.armap.c.a(split[1]);
            if (QLog.isColorLevel()) {
                QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig success");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig beginTime=" + this.f196638h + " endTime=" + this.f196639i);
        }
    }

    public void j(String str, int i3, int i16) {
        QQAppInterface qQAppInterface;
        byte b16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        short s16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!TextUtils.isEmpty(str) && (qQAppInterface = this.f196635d) != null) {
            Pair<Boolean, Setting> qQHeadSetting = qQAppInterface.getQQHeadSetting(4, str, 0);
            if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
                Setting setting = (Setting) obj;
                s16 = setting.systemHeadID;
                b16 = setting.bHeadType;
            } else {
                b16 = 0;
            }
            if (i3 == s16 && i16 == b16) {
                if (this.f196636e.containsKey(str)) {
                    this.f196636e.remove(str);
                    if (QLog.isColorLevel()) {
                        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId found same, remove uin=" + str + ", syid=" + i3 + ",headType=" + i16);
                        return;
                    }
                    return;
                }
                return;
            }
            C7393b c7393b = new C7393b(str, i3, i16);
            if (!this.f196636e.containsKey(str)) {
                this.f196636e.put(str, c7393b);
                if (QLog.isColorLevel()) {
                    QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + str + ", syid=" + i3 + ",headType=" + i16);
                    return;
                }
                return;
            }
            C7393b c7393b2 = this.f196636e.get(str);
            if (c7393b2 != null) {
                int i17 = c7393b2.f196645b;
                int i18 = c7393b2.f196646c;
                if ((i16 == 0 && i3 != i17) || i18 != i16) {
                    this.f196636e.put(str, c7393b);
                    if (QLog.isColorLevel()) {
                        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + str + ", syid=" + i3 + ",headType=" + i16);
                    }
                }
            }
        }
    }

    public void k(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        String currentAccountUin = this.f196635d.getCurrentAccountUin();
        long b16 = b();
        if (b16 != j3) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f196635d.getApp()).edit();
            edit.putLong("classic_head_activity_switch_" + currentAccountUin, j3);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d("ClassicHeadActivityManager", 2, "save Switch Success");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, "qq18Switch=" + j3 + " localSwitch=" + b16);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f196636e.clear();
        this.f196637f.clear();
        this.f196636e = null;
        this.f196637f = null;
    }
}
