package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicAvatarDownloadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static File f199947f;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<WeakReference<b>> f199948a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, NetReq> f199949b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f199950c;

    /* renamed from: d, reason: collision with root package name */
    public long f199951d;

    /* renamed from: e, reason: collision with root package name */
    public int f199952e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements INetEngineListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarDownloadManager.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onResp reqUrl: resp is null: ");
                if (netResp == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                sb5.append(z18);
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
            }
            if (netResp == null) {
                return;
            }
            String str = ((HttpNetReq) netResp.mReq).mReqUrl;
            int i3 = netResp.mResult;
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onResp reqUrl: " + str + " mResult: " + i3 + ",httpCode:" + netResp.mHttpCode + ",errDesc:" + netResp.mErrDesc);
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.avatar.api.a.a(z16, i3, "3");
            synchronized (DynamicAvatarDownloadManager.this.f199948a) {
                if (!DynamicAvatarDownloadManager.this.f199948a.isEmpty()) {
                    Iterator it = DynamicAvatarDownloadManager.this.f199948a.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null && weakReference.get() != 0) {
                            b bVar = (b) weakReference.get();
                            if (i3 == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            bVar.b(str, z17, false);
                        }
                    }
                }
            }
            DynamicAvatarDownloadManager.this.f199949b.remove(str);
            if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()) && !NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                DynamicAvatarDownloadManager.this.r();
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (!DynamicAvatarDownloadManager.this.f199948a.isEmpty() && (netReq instanceof HttpNetReq)) {
                if (j16 > 0) {
                    i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
                }
                String str = ((HttpNetReq) netReq).mReqUrl;
                synchronized (DynamicAvatarDownloadManager.this.f199948a) {
                    if (!DynamicAvatarDownloadManager.this.f199948a.isEmpty()) {
                        Iterator it = DynamicAvatarDownloadManager.this.f199948a.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference != null && weakReference.get() != 0) {
                                ((b) weakReference.get()).a(str, i3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(String str, int i3);

        void b(String str, boolean z16, boolean z17);
    }

    static {
        File cacheDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
        } else {
            cacheDir = BaseApplicationImpl.getApplication().getCacheDir();
        }
        f199947f = new File(cacheDir, "_dynamic");
    }

    public DynamicAvatarDownloadManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f199948a = new ArrayList<>();
        this.f199949b = new ConcurrentHashMap<>();
        this.f199950c = appInterface;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarDownloadManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DynamicAvatarDownloadManager.this.k();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 64, null, true);
    }

    public static File h(String str) {
        return new File(f199947f, i(str));
    }

    public static String i(String str) {
        return "cache_" + Utils.Crc64String(str) + ".mp4";
    }

    public static String j(String str) {
        return h(str).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String[] split;
        String string = BaseApplicationImpl.getApplication().getSharedPreferences(QCircleScheme.AttrQQPublish.OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM, 4).getString("dynamic_load_count_one_day", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("#")) != null && split.length == 2) {
            try {
                this.f199951d = Long.valueOf(split[0]).longValue();
                this.f199952e = Integer.valueOf(split[1]).intValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private boolean l(String str) {
        File h16 = h(str);
        if (h16 != null && h16.exists() && h16.isFile()) {
            synchronized (this.f199948a) {
                if (!this.f199948a.isEmpty()) {
                    Iterator<WeakReference<b>> it = this.f199948a.iterator();
                    while (it.hasNext()) {
                        WeakReference<b> next = it.next();
                        if (next != null && next.get() != null) {
                            next.get().b(str, true, true);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean m(String str) {
        if (!TextUtils.isEmpty(str)) {
            File h16 = h(str);
            if (h16.exists() && h16.isFile()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean n() {
        AppInterface appInterface;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f199951d;
        if (currentTimeMillis - j3 <= 86400000 && currentTimeMillis - j3 >= 0 && (appInterface = this.f199950c) != null) {
            if (this.f199952e + 1 > ((DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).m().f200060k) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isLoadCountSatisfy not satisfy.");
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private boolean o(String str) {
        if (NetworkUtil.isWifiConnected(BaseApplication.getContext()) || n()) {
            return false;
        }
        synchronized (this.f199948a) {
            if (!this.f199948a.isEmpty()) {
                Iterator<WeakReference<b>> it = this.f199948a.iterator();
                while (it.hasNext()) {
                    WeakReference<b> next = it.next();
                    if (next != null && next.get() != null) {
                        next.get().b(str, false, false);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f199952e++;
        long currentTimeMillis = System.currentTimeMillis();
        if (System.currentTimeMillis() - this.f199951d >= 86400000) {
            this.f199951d = System.currentTimeMillis();
            this.f199952e = 0;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable(currentTimeMillis) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f199953d;

            {
                this.f199953d = currentTimeMillis;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DynamicAvatarDownloadManager.this, Long.valueOf(currentTimeMillis));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                BaseApplicationImpl.getApplication().getSharedPreferences(QCircleScheme.AttrQQPublish.OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM, 4).edit().putString("dynamic_load_count_one_day", this.f199953d + "#0").commit();
            }
        });
    }

    public void e(b bVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        synchronized (this.f199948a) {
            Iterator<WeakReference<b>> it = this.f199948a.iterator();
            while (true) {
                if (it.hasNext()) {
                    WeakReference<b> next = it.next();
                    if (next != null && next.get() != null && next.get() == bVar) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.f199948a.add(new WeakReference<>(bVar));
            }
        }
    }

    public final void f() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Collection<NetReq> values = this.f199949b.values();
        if (values != null && !values.isEmpty()) {
            for (NetReq netReq : values) {
                if (netReq != null && (appInterface = this.f199950c) != null) {
                    ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(netReq);
                }
            }
            this.f199949b.clear();
        }
    }

    public final void g(ArrayList<String> arrayList) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.f199949b.containsKey(next)) {
                    NetReq netReq = this.f199949b.get(next);
                    if (netReq != null && (appInterface = this.f199950c) != null) {
                        ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(netReq);
                    }
                    this.f199949b.remove(next);
                }
            }
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f();
        this.f199948a.clear();
        this.f199950c = null;
    }

    public boolean q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (l(str)) {
            return true;
        }
        if (o(str)) {
            return false;
        }
        if (this.f199949b.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "url:" + str + " has contains");
            }
            return false;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = h(str).getPath();
        httpNetReq.mContinuErrorLimit = 1;
        AppInterface appInterface = this.f199950c;
        if (appInterface != null) {
            ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
            this.f199949b.put(str, httpNetReq);
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "startDownloadDynamicAvatar, url: " + str + ", uin:" + this.f199950c.getCurrentAccountUin());
        }
        return false;
    }
}
