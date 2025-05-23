package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.download.unite.DownloadDialogFragment;
import com.tencent.mobileqq.download.unite.util.a;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Long, InterfaceC7486b> f203598a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f203599b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterfaceC7486b interfaceC7486b;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == 1) {
                long longValue = ((Long) message.obj).longValue();
                if (QLog.isColorLevel()) {
                    QLog.d("[UniteDownload] UniteDownloadUtil", 2, "dialogCallbackHandler is Contain: ", Boolean.valueOf(b.f203598a.containsKey(Long.valueOf(longValue))));
                }
                if (b.f203598a.containsKey(Long.valueOf(longValue)) && (interfaceC7486b = (InterfaceC7486b) b.f203598a.get(Long.valueOf(longValue))) != null) {
                    interfaceC7486b.a(message.arg1);
                    b.f203598a.remove(Long.valueOf(longValue));
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.download.unite.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7486b {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203598a = new ConcurrentHashMap<>();
            f203599b = new Handler(ThreadManagerV2.getSubThreadLooper(), new a());
        }
    }

    public static Handler b() {
        return f203599b;
    }

    public static void c(String str) {
        bv.d("0X800B539", 0, "", str);
    }

    public static void d(String str) {
        bv.d("0X800B538", 0, "", str);
    }

    public static void e(DownloadInfo downloadInfo, InterfaceC7486b interfaceC7486b) {
        if (MobileQQ.sProcessId == 1) {
            Random random = new Random();
            Long valueOf = Long.valueOf(random.nextLong());
            while (f203598a.containsKey(valueOf)) {
                valueOf = Long.valueOf(random.nextLong());
            }
            f203598a.put(valueOf, interfaceC7486b);
            DownloadDialogFragment.th(downloadInfo, valueOf.longValue());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadInfoKey", downloadInfo);
        QIPCClientHelper.getInstance().callServer("UniteDownloadIPCModule", "showDialogAction", bundle, new a.b(interfaceC7486b));
    }
}
