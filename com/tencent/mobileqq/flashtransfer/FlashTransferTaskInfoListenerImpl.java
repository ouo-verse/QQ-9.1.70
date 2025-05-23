package com.tencent.mobileqq.flashtransfer;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleStatus;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferTaskStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.Uploader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FlashTransferTaskInfoListenerImpl implements IFlashTransferTaskInfoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static String f209869g;

    /* renamed from: h, reason: collision with root package name */
    private static FlashTransferTaskInfoListenerImpl f209870h;

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, b> f209871a;

    /* renamed from: b, reason: collision with root package name */
    HashMap<String, b> f209872b;

    /* renamed from: c, reason: collision with root package name */
    private a f209873c;

    /* renamed from: d, reason: collision with root package name */
    private String f209874d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f209875e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f209876f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f209878a;

        /* renamed from: b, reason: collision with root package name */
        int f209879b;

        /* renamed from: c, reason: collision with root package name */
        int f209880c;

        /* renamed from: d, reason: collision with root package name */
        String f209881d;

        /* renamed from: e, reason: collision with root package name */
        String f209882e;

        /* renamed from: f, reason: collision with root package name */
        boolean f209883f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f209878a = -1;
            this.f209879b = 0;
            this.f209880c = 0;
            this.f209881d = "";
            this.f209882e = "";
            this.f209883f = false;
        }

        public boolean a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
            }
            if (this.f209878a == aVar.f209878a && this.f209879b == aVar.f209879b && this.f209880c == aVar.f209880c && this.f209881d.equalsIgnoreCase(aVar.f209881d) && this.f209882e.equalsIgnoreCase(aVar.f209882e) && this.f209883f == aVar.f209883f) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        FlashTransferTaskStatusInfo f209884a;

        /* renamed from: b, reason: collision with root package name */
        boolean f209885b;

        /* renamed from: c, reason: collision with root package name */
        boolean f209886c;

        /* renamed from: d, reason: collision with root package name */
        boolean f209887d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f209884a = new FlashTransferTaskStatusInfo();
            this.f209885b = false;
            this.f209886c = false;
            this.f209887d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f209888a;

        /* renamed from: b, reason: collision with root package name */
        boolean f209889b;

        /* renamed from: c, reason: collision with root package name */
        boolean f209890c;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f209888a = false;
            this.f209889b = false;
            this.f209890c = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f209869g = "FlashTransferTaskInfoListenerImpl";
            f209870h = new FlashTransferTaskInfoListenerImpl();
        }
    }

    FlashTransferTaskInfoListenerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209871a = new HashMap<>();
        this.f209872b = new HashMap<>();
        this.f209873c = new a();
        this.f209874d = "";
        this.f209875e = false;
        this.f209876f = false;
    }

    private static <K, V> K b(HashMap<K, V> hashMap) {
        Iterator<K> it = hashMap.keySet().iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static FlashTransferTaskInfoListenerImpl c() {
        return f209870h;
    }

    private static <K, V> K d(HashMap<K, V> hashMap) {
        Iterator<K> it = hashMap.keySet().iterator();
        K k3 = null;
        while (it.hasNext()) {
            k3 = it.next();
        }
        return k3;
    }

    private static HashMap<String, b> e(HashMap<String, b> hashMap) {
        HashMap<String, b> hashMap2 = new HashMap<>();
        for (Map.Entry<String, b> entry : hashMap.entrySet()) {
            if (!entry.getValue().f209885b) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap2;
    }

    private static HashMap<String, b> f(HashMap<String, b> hashMap) {
        HashMap<String, b> hashMap2 = new HashMap<>();
        for (Map.Entry<String, b> entry : hashMap.entrySet()) {
            if (!entry.getValue().f209887d) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap2;
    }

    private static HashMap<String, b> g(HashMap<String, b> hashMap) {
        HashMap<String, b> hashMap2 = new HashMap<>();
        for (Map.Entry<String, b> entry : hashMap.entrySet()) {
            if (!entry.getValue().f209886c) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap2;
    }

    private static boolean h(HashMap<String, b> hashMap) {
        Iterator<Map.Entry<String, b>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().f209885b) {
                return false;
            }
        }
        return true;
    }

    private static boolean i(ArrayList<Uploader> arrayList) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (currentAccountUin.equalsIgnoreCase(arrayList.get(i3).uin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean j(FileSetSimpleStatus fileSetSimpleStatus) {
        if (fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADING && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADING && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADPAUSED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADPAUSED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADFINISHED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADFINISHED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADFAILED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADFAILED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADCANCELED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADCANCELED && fileSetSimpleStatus != FileSetSimpleStatus.KDELETED && fileSetSimpleStatus != FileSetSimpleStatus.KEXPIRED && fileSetSimpleStatus != FileSetSimpleStatus.KHIT) {
            return false;
        }
        return true;
    }

    private static boolean k(FileSetSimpleStatus fileSetSimpleStatus) {
        if (fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADING && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADPAUSED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADFINISHED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADFAILED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADCANCELED) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ArrayList<FlashTransferTaskStatusInfo> arrayList) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(f209869g, 1, "onTransferTaskInfoUpdate: appRuntime empty!");
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        if (arrayList == null) {
            String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
            if (!this.f209874d.equalsIgnoreCase(currentAccountUin)) {
                this.f209874d = currentAccountUin;
                q(baseQQAppInterface);
                return;
            }
            return;
        }
        c t16 = t(arrayList);
        if (!t16.f209888a) {
            return;
        }
        HashMap<String, b> f16 = f(this.f209871a);
        if (f16.size() == 1) {
            o(baseQQAppInterface, f16.get((String) b(f16)));
        } else {
            HashMap<String, b> g16 = g(f16);
            if (g16.size() == 0) {
                baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(2, true, null);
                this.f209875e = false;
                r(f16);
            } else if (g16.size() == 1) {
                o(baseQQAppInterface, g16.get((String) b(g16)));
            } else {
                HashMap<String, b> e16 = e(g16);
                if (e16.size() == 0) {
                    b bVar = g16.get((String) b(g16));
                    a aVar = new a();
                    aVar.f209879b = 1;
                    aVar.f209878a = !k(bVar.f209884a.status) ? 1 : 0;
                    FlashTransferTaskStatusInfo flashTransferTaskStatusInfo = bVar.f209884a;
                    aVar.f209881d = flashTransferTaskStatusInfo.fileSetId;
                    aVar.f209882e = flashTransferTaskStatusInfo.name;
                    baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(1, true, new Object[]{Integer.valueOf(aVar.f209878a), aVar.f209881d, aVar.f209882e});
                    this.f209875e = true;
                    this.f209873c = aVar;
                } else if (e16.size() == 1) {
                    o(baseQQAppInterface, e16.get((String) b(e16)));
                } else {
                    n(baseQQAppInterface, e16);
                }
            }
        }
        if (h(this.f209871a)) {
            m(baseQQAppInterface);
        }
        p(this.f209871a);
        if (t16.f209889b) {
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(2, true, null);
            this.f209875e = false;
        }
        if (t16.f209890c) {
            baseQQAppInterface.getBusinessHandler(FlashTransferErrHandler.class.getName()).notifyUI(1, true, null);
            this.f209876f = false;
        }
    }

    private void m(BaseQQAppInterface baseQQAppInterface) {
        int i3;
        HashMap<String, b> f16 = f(this.f209872b);
        if (f16.size() > 0) {
            if (f16.size() == 1) {
                b bVar = f16.get((String) b(f16));
                if (bVar != null) {
                    FlashTransferTaskStatusInfo flashTransferTaskStatusInfo = bVar.f209884a;
                    if (flashTransferTaskStatusInfo.status == FileSetSimpleStatus.KUPLOADFAILED) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    baseQQAppInterface.getBusinessHandler(FlashTransferErrHandler.class.getName()).notifyUI(0, true, new Object[]{Integer.valueOf(i3), Integer.valueOf((int) flashTransferTaskStatusInfo.failedFileCount), flashTransferTaskStatusInfo.fileSetId});
                    this.f209876f = true;
                }
            } else {
                String str = "";
                int i16 = 0;
                for (Map.Entry<String, b> entry : f16.entrySet()) {
                    i16 += (int) entry.getValue().f209884a.failedFileCount;
                    str = entry.getValue().f209884a.fileSetId;
                }
                baseQQAppInterface.getBusinessHandler(FlashTransferErrHandler.class.getName()).notifyUI(0, true, new Object[]{2, Integer.valueOf(i16), str});
                this.f209876f = true;
            }
        }
        this.f209872b.clear();
    }

    private void n(BaseQQAppInterface baseQQAppInterface, HashMap<String, b> hashMap) {
        boolean z16;
        Iterator<Map.Entry<String, b>> it = hashMap.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                if (next.getValue().f209884a.status != FileSetSimpleStatus.KUPLOADPAUSED && next.getValue().f209884a.status != FileSetSimpleStatus.KDOWNLOADPAUSED) {
                    z16 = false;
                    break;
                }
            } else {
                z16 = true;
                break;
            }
        }
        b bVar = hashMap.get((String) d(hashMap));
        a aVar = new a();
        aVar.f209878a = 2;
        aVar.f209879b = hashMap.size();
        FlashTransferTaskStatusInfo flashTransferTaskStatusInfo = bVar.f209884a;
        aVar.f209881d = flashTransferTaskStatusInfo.fileSetId;
        aVar.f209882e = flashTransferTaskStatusInfo.name;
        aVar.f209883f = z16;
        if (!aVar.a(this.f209873c)) {
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(0, true, new Object[]{Integer.valueOf(aVar.f209878a), Integer.valueOf(aVar.f209879b), Integer.valueOf(aVar.f209880c), aVar.f209881d, aVar.f209882e, Boolean.valueOf(aVar.f209883f)});
            this.f209875e = true;
            this.f209873c = aVar;
        }
    }

    private void o(BaseQQAppInterface baseQQAppInterface, b bVar) {
        int i3;
        boolean z16;
        a aVar = new a();
        aVar.f209879b = 1;
        aVar.f209878a = !k(bVar.f209884a.status) ? 1 : 0;
        FlashTransferTaskStatusInfo flashTransferTaskStatusInfo = bVar.f209884a;
        aVar.f209881d = flashTransferTaskStatusInfo.fileSetId;
        aVar.f209882e = flashTransferTaskStatusInfo.name;
        if (bVar.f209886c) {
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(2, true, null);
            this.f209875e = false;
            bVar.f209887d = true;
            this.f209873c = aVar;
            return;
        }
        if (bVar.f209885b) {
            aVar.f209883f = false;
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(1, true, new Object[]{Integer.valueOf(aVar.f209878a), aVar.f209881d, aVar.f209882e});
            this.f209875e = true;
            this.f209873c = aVar;
            return;
        }
        long j3 = flashTransferTaskStatusInfo.totalFileSize;
        if (j3 > 0) {
            i3 = (int) ((flashTransferTaskStatusInfo.completedFileSize * 100) / j3);
        } else {
            i3 = 0;
        }
        aVar.f209880c = i3;
        FileSetSimpleStatus fileSetSimpleStatus = flashTransferTaskStatusInfo.status;
        if (fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADPAUSED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADPAUSED) {
            z16 = false;
        } else {
            z16 = true;
        }
        aVar.f209883f = z16;
        if (!aVar.a(this.f209873c)) {
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(0, true, new Object[]{Integer.valueOf(aVar.f209878a), Integer.valueOf(aVar.f209879b), Integer.valueOf(aVar.f209880c), aVar.f209881d, aVar.f209882e, Boolean.valueOf(aVar.f209883f)});
            this.f209875e = true;
            this.f209873c = aVar;
        }
    }

    private static void p(HashMap<String, b> hashMap) {
        Iterator<Map.Entry<String, b>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().f209885b) {
                it.remove();
            }
        }
    }

    private void q(BaseQQAppInterface baseQQAppInterface) {
        QLog.i(f209869g, 1, "reset. mTransferingTaskInfoMap.size: " + this.f209871a.size() + ", mTransferErrTaskInfoMap.size: " + this.f209872b.size() + ", mOldProgressInfo.taskType: " + this.f209873c.f209878a + ", isProgressBannerShowed: " + this.f209875e + ", isErrBannerShowed: " + this.f209876f);
        this.f209871a.clear();
        this.f209872b.clear();
        this.f209873c = new a();
        if (this.f209875e) {
            baseQQAppInterface.getBusinessHandler(FlashTransferProgressHandler.class.getName()).notifyUI(2, true, null);
            this.f209875e = false;
        }
        if (this.f209876f) {
            baseQQAppInterface.getBusinessHandler(FlashTransferErrHandler.class.getName()).notifyUI(1, true, null);
            this.f209876f = false;
        }
    }

    private static void r(HashMap<String, b> hashMap) {
        new HashMap();
        Iterator<Map.Entry<String, b>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().f209887d = true;
        }
    }

    private c t(ArrayList<FlashTransferTaskStatusInfo> arrayList) {
        int i3;
        boolean z16;
        FileSetSimpleStatus fileSetSimpleStatus;
        boolean z17;
        c cVar = new c();
        Iterator<FlashTransferTaskStatusInfo> it = arrayList.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            FlashTransferTaskStatusInfo next = it.next();
            if (next != null && j(next.status) && (!k(next.status) || i(next.uploaders))) {
                boolean z18 = true;
                cVar.f209888a = true;
                long j3 = next.totalFileSize;
                if (j3 > 0) {
                    i3 = (int) ((next.completedFileSize * 100) / j3);
                } else {
                    i3 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f209869g, 2, "onTransferTaskInfoUpdate. idx: " + i16 + ", fileSetId: " + next.fileSetId + ", filename: " + next.name + ", status: " + next.status + ", progress: " + i3 + ", failedFileCount: " + next.failedFileCount + ", completedFileSize: " + next.completedFileSize + ", totalFileSize: " + next.totalFileSize + ", completedFileCount: " + next.completedFileCount + ", totalFilecount: " + next.totalFileCount + ".");
                }
                i16++;
                FileSetSimpleStatus fileSetSimpleStatus2 = next.status;
                if (fileSetSimpleStatus2 != FileSetSimpleStatus.KUPLOADING && fileSetSimpleStatus2 != FileSetSimpleStatus.KDOWNLOADING && fileSetSimpleStatus2 != FileSetSimpleStatus.KUPLOADPAUSED && fileSetSimpleStatus2 != FileSetSimpleStatus.KDOWNLOADPAUSED && fileSetSimpleStatus2 != FileSetSimpleStatus.KUPLOADFINISHED && fileSetSimpleStatus2 != FileSetSimpleStatus.KDOWNLOADFINISHED && fileSetSimpleStatus2 != FileSetSimpleStatus.KUPLOADFAILED && fileSetSimpleStatus2 != FileSetSimpleStatus.KDOWNLOADFAILED) {
                    if (fileSetSimpleStatus2 == FileSetSimpleStatus.KDELETED || fileSetSimpleStatus2 == FileSetSimpleStatus.KEXPIRED || fileSetSimpleStatus2 == FileSetSimpleStatus.KUPLOADCANCELED || fileSetSimpleStatus2 == FileSetSimpleStatus.KDOWNLOADCANCELED || fileSetSimpleStatus2 == FileSetSimpleStatus.KHIT) {
                        this.f209871a.remove(next.fileSetId);
                        this.f209872b.remove(next.fileSetId);
                        if (this.f209871a.size() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        cVar.f209889b = z17;
                        if (this.f209872b.size() != 0) {
                            z18 = false;
                        }
                        cVar.f209890c = z18;
                    }
                } else {
                    if (this.f209871a.containsKey(next.fileSetId)) {
                        this.f209871a.get(next.fileSetId).f209884a = next;
                    } else {
                        b bVar = new b();
                        bVar.f209884a = next;
                        this.f209871a.put(next.fileSetId, bVar);
                    }
                    b bVar2 = this.f209871a.get(next.fileSetId);
                    if (i3 != 100 && (fileSetSimpleStatus = next.status) != FileSetSimpleStatus.KUPLOADFINISHED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADFINISHED && fileSetSimpleStatus != FileSetSimpleStatus.KUPLOADFAILED && fileSetSimpleStatus != FileSetSimpleStatus.KDOWNLOADFAILED) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    bVar2.f209885b = z16;
                    FileSetSimpleStatus fileSetSimpleStatus3 = next.status;
                    if (fileSetSimpleStatus3 == FileSetSimpleStatus.KUPLOADFAILED || fileSetSimpleStatus3 == FileSetSimpleStatus.KDOWNLOADFAILED) {
                        b bVar3 = this.f209871a.get(next.fileSetId);
                        if (next.completedFileCount != 0) {
                            z18 = false;
                        }
                        bVar3.f209886c = z18;
                        if (this.f209872b.containsKey(next.fileSetId)) {
                            this.f209872b.get(next.fileSetId).f209884a = next;
                        } else {
                            b bVar4 = new b();
                            bVar4.f209884a = next;
                            this.f209872b.put(next.fileSetId, bVar4);
                        }
                    }
                }
            }
        }
        return cVar;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener
    public void onTransferTaskInfoUpdate(ArrayList<FlashTransferTaskStatusInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.flashtransfer.FlashTransferTaskInfoListenerImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f209877d;

                {
                    this.f209877d = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferTaskInfoListenerImpl.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FlashTransferTaskInfoListenerImpl.this.l(this.f209877d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void s(boolean z16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
            return;
        }
        QLog.d(f209869g, 2, "updateBannerHideFlag. isProgressBanner: " + z16 + ", isDownloading: " + z17 + ", filesetId: " + str);
        if (z16) {
            this.f209875e = false;
            if (z17) {
                for (Map.Entry<String, b> entry : this.f209871a.entrySet()) {
                    if (TextUtils.isEmpty(str)) {
                        entry.getValue().f209887d = true;
                    } else if (entry.getKey().equalsIgnoreCase(str)) {
                        QLog.d(f209869g, 2, "updateBannerHideFlag. filesetId: " + str + ", filesetName: " + entry.getValue().f209884a.name);
                        entry.getValue().f209887d = true;
                        return;
                    }
                }
                return;
            }
            return;
        }
        this.f209876f = false;
    }
}
