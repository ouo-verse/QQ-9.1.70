package com.tencent.mobileqq.dating;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ad;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StrangerHdHeadUrlFetcher implements Handler.Callback {
    static IPatchRedirector $redirector_;
    protected MqqHandler C;
    private com.tencent.mobileqq.avatar.observer.a D;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f203387d;

    /* renamed from: e, reason: collision with root package name */
    protected EntityManager f203388e;

    /* renamed from: f, reason: collision with root package name */
    protected Set<String> f203389f;

    /* renamed from: h, reason: collision with root package name */
    protected ConcurrentHashMap<String, String> f203390h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f203391i;

    /* renamed from: m, reason: collision with root package name */
    protected long f203392m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StrangerHdHeadUrlFetcher.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onGetHeadInfo(boolean z16, Setting setting) {
            String str;
            String str2;
            int i3;
            int indexOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), setting);
                return;
            }
            String str3 = null;
            if (z16 && setting != null) {
                str = setting.uin;
            } else {
                str = null;
            }
            if (str != null && str.startsWith("stranger_") && StrangerHdHeadUrlFetcher.this.f203389f.contains(str)) {
                if (!TextUtils.isEmpty(setting.url)) {
                    str2 = StrangerHdHeadUrlFetcher.e(32, setting.url, setting.bHeadType, setting.bFaceFlags);
                } else {
                    f.i("StrangerHdHeadUrlFetcher", "setting.url is null");
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    StrangerHdHeadUrlFetcher.this.f203390h.put(str, str2);
                    try {
                        int indexOf2 = str.indexOf(95) + 1;
                        indexOf = str.indexOf(95, indexOf2);
                        i3 = Integer.parseInt(str.substring(indexOf2, indexOf));
                    } catch (NumberFormatException e16) {
                        e = e16;
                        i3 = 0;
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 0;
                    }
                    try {
                        str3 = str.substring(indexOf + 1);
                    } catch (NumberFormatException e18) {
                        e = e18;
                        f.i("StrangerHdHeadUrlFetcher", e.toString());
                        com.tencent.mobileqq.nearby.ipc.a.c(4106, str3, Integer.valueOf(i3), str2);
                        StrangerHdHeadUrlFetcher.this.g(str);
                    } catch (Exception e19) {
                        e = e19;
                        f.i("StrangerHdHeadUrlFetcher", e.toString());
                        com.tencent.mobileqq.nearby.ipc.a.c(4106, str3, Integer.valueOf(i3), str2);
                        StrangerHdHeadUrlFetcher.this.g(str);
                    }
                    com.tencent.mobileqq.nearby.ipc.a.c(4106, str3, Integer.valueOf(i3), str2);
                }
                StrangerHdHeadUrlFetcher.this.g(str);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17) {
                String d16 = StrangerHdHeadUrlFetcher.d(32, i3, str);
                if (StrangerHdHeadUrlFetcher.this.f203389f.contains(d16)) {
                    String c16 = StrangerHdHeadUrlFetcher.this.c(str, i3, false);
                    if (!TextUtils.isEmpty(c16)) {
                        com.tencent.mobileqq.nearby.ipc.a.c(4106, str, Integer.valueOf(i3), c16);
                    }
                    StrangerHdHeadUrlFetcher.this.g(d16);
                }
            }
        }
    }

    public StrangerHdHeadUrlFetcher(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.D = new a();
        this.f203387d = qQAppInterface;
        this.f203388e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.f203390h = new ConcurrentHashMap<>(20);
        this.f203389f = new HashSet(20);
        this.f203391i = false;
        this.C = new ad(ThreadManagerV2.getSubThreadLooper(), this);
    }

    public static String d(int i3, int i16, String str) {
        StringBuilder sb5 = new StringBuilder(20);
        if (i3 == 4) {
            sb5.append("troop_");
            sb5.append(str);
        } else if (i3 == 32) {
            sb5.append("stranger_");
            sb5.append(i16);
            sb5.append("_");
            sb5.append(str);
        } else if (i3 == 16) {
            sb5.append("qcall_");
            sb5.append(i16);
            sb5.append("_");
            sb5.append(str);
        } else {
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static String e(int i3, String str, byte b16, byte b17) {
        return MsfSdkUtils.insertMtype("QQHeadIcon", str + String.valueOf(640));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        synchronized (this.f203389f) {
            if (str == null) {
                this.f203389f.clear();
            } else {
                this.f203389f.remove(str);
            }
            if (this.f203389f.isEmpty()) {
                this.f203387d.removeObserver(this.D);
                this.f203391i = false;
            }
        }
    }

    public String c(String str, int i3, boolean z16) {
        Setting setting;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (!TextUtils.isEmpty(str) && (i3 == 200 || i3 == 202 || i3 == 204)) {
            String d16 = d(32, i3, str);
            String str2 = this.f203390h.get(d16);
            if (TextUtils.isEmpty(str2) && (setting = (Setting) DBMethodProxy.find(this.f203388e, (Class<? extends Entity>) Setting.class, d16)) != null && !TextUtils.isEmpty(setting.url)) {
                str2 = e(32, setting.url, setting.bHeadType, setting.bFaceFlags);
                this.f203390h.put(d16, str2);
                synchronized (this.f203389f) {
                    this.f203389f.remove(d16);
                }
            }
            ThreadManagerV2.post(new Runnable(str, i3, z16, d16) { // from class: com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f203393d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f203394e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f203395f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f203396h;

                {
                    this.f203393d = str;
                    this.f203394e = i3;
                    this.f203395f = z16;
                    this.f203396h = d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StrangerHdHeadUrlFetcher.this, str, Integer.valueOf(i3), Boolean.valueOf(z16), d16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Pair<Boolean, Setting> qQHeadSetting = StrangerHdHeadUrlFetcher.this.f203387d.getQQHeadSetting(32, this.f203393d, this.f203394e);
                    if (qQHeadSetting != null) {
                        z17 = ((Boolean) qQHeadSetting.first).booleanValue();
                    } else {
                        z17 = false;
                    }
                    if (z17 && this.f203395f) {
                        IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) StrangerHdHeadUrlFetcher.this.f203387d.getRuntimeService(IQQAvatarHandlerService.class, "");
                        if (iQQAvatarHandlerService != null) {
                            StrangerHdHeadUrlFetcher.this.f203392m = System.currentTimeMillis();
                            synchronized (StrangerHdHeadUrlFetcher.this.D) {
                                StrangerHdHeadUrlFetcher strangerHdHeadUrlFetcher = StrangerHdHeadUrlFetcher.this;
                                if (!strangerHdHeadUrlFetcher.f203391i) {
                                    strangerHdHeadUrlFetcher.f203391i = true;
                                    strangerHdHeadUrlFetcher.f203387d.addObserver(strangerHdHeadUrlFetcher.D, true);
                                }
                            }
                            synchronized (StrangerHdHeadUrlFetcher.this.f203389f) {
                                StrangerHdHeadUrlFetcher.this.f203389f.add(this.f203396h);
                            }
                            iQQAvatarHandlerService.getStrangerHead(this.f203393d, this.f203394e, (byte) 1, (byte) 2);
                            if (!StrangerHdHeadUrlFetcher.this.C.hasMessages(1)) {
                                StrangerHdHeadUrlFetcher.this.C.sendEmptyMessageDelayed(1, 60000L);
                                return;
                            }
                            return;
                        }
                        f.j("StrangerHdHeadUrlFetcher", "flh is null");
                    }
                }
            }, 8, null, false);
            return str2;
        }
        f.j("StrangerHdHeadUrlFetcher", "uinOrMobileNum is null or empty");
        return "";
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.f203389f) {
            this.f203387d.removeObserver(this.D);
            this.f203391i = false;
            this.f203389f.clear();
        }
        this.f203390h.clear();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            long abs = Math.abs(System.currentTimeMillis() - this.f203392m);
            if (abs >= 0 && abs <= 60000) {
                if (!this.f203389f.isEmpty()) {
                    this.C.sendEmptyMessageAtTime(1, 60000L);
                    return false;
                }
                return false;
            }
            g(null);
            return false;
        }
        return false;
    }
}
