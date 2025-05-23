package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.af;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes11.dex */
public class PokeBigResHandler extends BusinessHandler implements af {
    static IPatchRedirector $redirector_;
    public static boolean C;
    private static final String[] D;
    private static final String[] E;
    private static final int[] F;
    private static final int[] G;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f196609f;

    /* renamed from: h, reason: collision with root package name */
    private static String f196610h;

    /* renamed from: i, reason: collision with root package name */
    private static String f196611i;

    /* renamed from: m, reason: collision with root package name */
    private static final String f196612m;

    /* renamed from: d, reason: collision with root package name */
    private NetEngine f196613d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f196614e;

    /* loaded from: classes11.dex */
    public class BigResRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ PokeBigResHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class NetEngine implements INetEngineListener {
        static IPatchRedirector $redirector_;

        public NetEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
            } else if (netResp.mResult == 0) {
                ThreadManagerV2.excute(new Runnable(netResp.mReq.mOutPath) { // from class: com.tencent.mobileqq.app.utils.PokeBigResHandler.NetEngine.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f196615d;

                    {
                        this.f196615d = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetEngine.this, (Object) r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            PokeBigResHandler.C = PokeBigResHandler.N2(this.f196615d);
                            PokeBigResHandler.f196609f = false;
                        }
                    }
                }, 64, null, true);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            Log.e("Ron", "req:[" + netReq.toString() + "\n curOffset" + j3 + "\n totalLen" + j16 + "]");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f196609f = false;
        f196610h = "";
        f196611i = "";
        f196612m = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "bigPoke");
        C = false;
        D = new String[]{"/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion"};
        E = new String[]{"/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan"};
        F = new int[]{57, 57, 67, 6, 0, 50, 20};
        G = new int[]{2, 10, 37, 55};
    }

    public PokeBigResHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f196613d = new NetEngine();
            this.f196614e = qQAppInterface;
        }
    }

    public static boolean L2() {
        File file = new File(af.H3);
        if (file.exists() && file.list() != null) {
            for (int i3 = 0; i3 < 4; i3++) {
                if (!M2(i3, af.I3)) {
                    C = false;
                    return false;
                }
            }
            for (int i16 = 0; i16 < 7; i16++) {
                if (!O2(i16, af.J3)) {
                    C = false;
                    return false;
                }
            }
            C = true;
            return true;
        }
        C = false;
        return false;
    }

    public static boolean M2(int i3, String str) {
        String[] list;
        File file = new File(str + E[i3]);
        int i16 = G[i3];
        try {
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            if (list.length != i16) {
                return false;
            }
            return true;
        } catch (NullPointerException e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("PokeBigResHandler", 2, e16, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N2(String str) {
        String str2 = f196610h;
        File file = new File(str);
        if (file.exists()) {
            String str3 = null;
            try {
                str3 = HexUtil.bytes2HexStr(MD5.getFileMd5(file.getAbsolutePath()));
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigResDown", 2, "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", e16.getMessage());
                    e16.printStackTrace();
                }
                try {
                    str3 = com.tencent.qqprotect.singleupdate.a.d(file);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + file.getAbsolutePath());
                    }
                }
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigResDown", 2, "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", e17.getMessage());
                    e17.printStackTrace();
                }
                try {
                    str3 = com.tencent.qqprotect.singleupdate.a.d(file);
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + file.getAbsolutePath());
                    }
                }
            }
            if (str3 != null && str2 != null && str3.toLowerCase().equals(str2.toLowerCase())) {
                R2(file.getAbsolutePath());
                return L2();
            }
            file.delete();
        }
        return false;
    }

    public static boolean O2(int i3, String str) {
        File[] listFiles;
        String[] list;
        String str2 = str + D[i3];
        int i16 = F[i3];
        File file = new File(str2);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        if (i3 == 4) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (!file2.getName().contains("dazhao_move")) {
                        if (file2.getName().contains("daozhao_motion")) {
                            String[] list2 = file2.list();
                            if (list2 == null) {
                                return false;
                            }
                            if (list2.length == 29) {
                                continue;
                            }
                        }
                        if (file2.getName().contains("dazhao2_motion") && (list = file2.list()) != null && list.length == 23) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        if (listFiles.length != i16) {
            return false;
        }
        return true;
    }

    private static boolean P2() {
        String str = af.H3;
        File file = new File(str);
        if (file.exists() && file.list() != null) {
            com.tencent.mobileqq.activity.photo.album.j.a(str);
            return true;
        }
        return false;
    }

    private static void R2(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("BigResDown", 2, "start compress");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!new File(str).exists()) {
            return;
        }
        try {
            String str2 = f196612m;
            if (!TextUtils.isEmpty(VFSAssistantUtils.getSDKPrivatePath(str2))) {
                String str3 = af.H3;
                FileUtils.delete(VFSAssistantUtils.getSDKPrivatePath(str3), false);
                com.tencent.mobileqq.activity.photo.album.j.a(str2);
                FileUtils.uncompressZip(str, VFSAssistantUtils.getSDKPrivatePath(str3), false);
                com.tencent.mobileqq.activity.photo.album.j.a(str3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        FileUtils.delete(str, false);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("BigResDown", 2, "end compress ,cost " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public synchronized void Q2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (!z16 && P2()) {
            return;
        }
        if (f196609f) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.utils.PokeBigResHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PokeBigResHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PokeBigResHandler.f196609f = true;
                    HttpNetReq httpNetReq = new HttpNetReq();
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(PokeBigResHandler.this.f196614e.getApp());
                    String account = PokeBigResHandler.this.f196614e.getAccount();
                    PokeBigResHandler.f196611i = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_NEW_RES_URL, "");
                    PokeBigResHandler.f196610h = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.POKE_NEW_RES_MD5, "");
                    if (TextUtils.isEmpty(PokeBigResHandler.f196611i)) {
                        PokeBigResHandler.f196609f = false;
                        return;
                    }
                    httpNetReq.mCallback = PokeBigResHandler.this.f196613d;
                    httpNetReq.mReqUrl = PokeBigResHandler.f196611i;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = PokeBigResHandler.f196612m + "poke.zip";
                    ((IHttpEngineService) PokeBigResHandler.this.f196614e.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(runnable, 10, null, false);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
