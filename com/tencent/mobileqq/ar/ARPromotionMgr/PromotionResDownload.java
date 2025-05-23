package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.util.LogUtil;

/* loaded from: classes11.dex */
public class PromotionResDownload {

    /* renamed from: a, reason: collision with root package name */
    final String f196917a;

    /* renamed from: b, reason: collision with root package name */
    PromotionConfigInfo f196918b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<b> f196919c = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void a();

        void b(String str, int i3, int i16);
    }

    public PromotionResDownload(long j3) {
        this.f196917a = "ARPromotionResDownload_" + j3;
    }

    static boolean e(PromotionConfigInfo.b bVar) {
        if (bVar.f196902a == 0) {
            String c16 = e.c(bVar);
            if (!new File(c16 + "entry.png").exists()) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("PromotionResDownload", 1, "\u6587\u4ef6\u4e0d\u5b58\u5728, path[" + c16 + "], name[entry.png]");
                }
                return false;
            }
            if (!new File(c16 + "entry.json").exists()) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("PromotionResDownload", 1, "\u6587\u4ef6\u4e0d\u5b58\u5728, path[" + c16 + "], name[entry.json]");
                }
                return false;
            }
            String e16 = e.e(bVar);
            if (!new File(e16 + "guide.json").exists()) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("PromotionResDownload", 1, "\u6587\u4ef6\u4e0d\u5b58\u5728, path[" + e16 + "], name[guide.json]");
                }
                return false;
            }
        }
        return true;
    }

    static PromotionConfigInfo.b h(boolean z16, PromotionConfigInfo promotionConfigInfo, PromotionConfigInfo.a aVar) {
        PromotionConfigInfo.b m3 = m(z16, promotionConfigInfo.mUin, aVar);
        if (m3 == null && z16) {
            return j(z16, promotionConfigInfo);
        }
        return m3;
    }

    private ArrayList<b> i() {
        ArrayList<b> arrayList = new ArrayList<>();
        synchronized (this.f196919c) {
            arrayList.addAll(this.f196919c);
        }
        return arrayList;
    }

    static PromotionConfigInfo.b j(boolean z16, PromotionConfigInfo promotionConfigInfo) {
        Iterator<Map.Entry<String, PromotionConfigInfo.a>> it = promotionConfigInfo.operationInfos.entrySet().iterator();
        PromotionConfigInfo.b bVar = null;
        while (it.hasNext()) {
            PromotionConfigInfo.a value = it.next().getValue();
            if (!f.d(value.f196894b) && (bVar = m(z16, promotionConfigInfo.mUin, value)) != null) {
                break;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z16, AppInterface appInterface, String str2, int i3, PromotionConfigInfo.b bVar) {
        if (k() != null && bVar != null) {
            i.b f16 = f(appInterface, bVar);
            if (f16 == null) {
                return;
            }
            bVar.f196914m = System.currentTimeMillis();
            IPreDownloadController iPreDownloadController = (IPreDownloadController) appInterface.getRuntimeService(IPreDownloadController.class, "");
            iPreDownloadController.cancelPreDownload(bVar.f196903b);
            iPreDownloadController.preDownloadSuccess(bVar.f196903b, 0L);
            String str3 = bVar.f196905d;
            if (n(appInterface.getAccount(), bVar)) {
                synchronized (bVar.f196911j) {
                    if (!z16) {
                        bVar.f196909h = false;
                    }
                }
                QLog.w(this.f196917a, 1, "innerDownloadRes[" + str + "], \u8d44\u6e90\u5df2\u7ecf\u5b58\u5728, callByPreDownload[" + z16 + "], item[" + bVar + "], zipPath[" + str3 + "]");
                bVar.b(2);
                f16.b(bVar.f196903b, bVar.f196904c, 100, str3, bVar);
                return;
            }
            synchronized (bVar.f196911j) {
                if (!z16) {
                    bVar.f196909h = false;
                }
                if (bVar.f196912k == 1) {
                    QLog.w(this.f196917a, 1, "innerDownloadRes[" + str + "], \u5df2\u7ecf\u5728\u4e0b\u8f7d\u4e2d, callByPreDownload[" + z16 + "], item[" + bVar + "], zipPath[" + str3 + "]");
                } else {
                    bVar.b(1);
                    boolean e16 = ((i) appInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD)).e(bVar.f196903b, bVar.f196904c, ".zip", true, 5, bVar, bVar.f196910i);
                    QLog.w(this.f196917a, 1, "innerDownloadRes[" + str + "], \u5f00\u59cb\u4e0b\u8f7d, callByPreDownload[" + z16 + "], ret[" + e16 + "], item[" + bVar + "]");
                    if (!e16) {
                        f16.b(bVar.f196903b, bVar.f196904c, -4, null, bVar);
                    }
                }
            }
            return;
        }
        o(str2, i3, -3);
    }

    public static PromotionConfigInfo.b m(boolean z16, String str, PromotionConfigInfo.a aVar) {
        Iterator<Map.Entry<Integer, PromotionConfigInfo.b>> it = aVar.e().entrySet().iterator();
        while (it.hasNext()) {
            PromotionConfigInfo.b value = it.next().getValue();
            if (value.f196912k == -1) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(f.f196950a, 1, "isPromotionResReady, \u5df2\u7ecf\u4e0b\u8f7d\u5931\u8d25\u4e86, id[" + value.f196907f + "], index[" + value.f196902a + "]");
                }
            } else if (z16 && value.f196908g == 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(f.f196950a, 1, "isPromotionResReady, \u65e0\u9700\u9884\u4e0b\u8f7d, id[" + value.f196907f + "], index[" + value.f196902a + "]");
                }
            } else if (!n(str, value)) {
                return value;
            }
        }
        return null;
    }

    public static boolean n(String str, PromotionConfigInfo.b bVar) {
        if (ty2.a.h(str, bVar.f196907f, bVar.f196902a, bVar.f196904c, bVar.f196906e)) {
            return e(bVar);
        }
        return false;
    }

    public void b(b bVar) {
        synchronized (this.f196919c) {
            this.f196919c.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Iterator<b> it = i().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, int i3, int i16) {
        Iterator<b> it = i().iterator();
        while (it.hasNext()) {
            it.next().b(str, i3, i16);
        }
    }

    synchronized i.b f(AppInterface appInterface, PromotionConfigInfo.b bVar) {
        i.b bVar2 = bVar.f196910i;
        if (bVar2 != null) {
            return bVar2;
        }
        a aVar = new a(appInterface, bVar.f196907f, bVar.f196902a);
        bVar.f196910i = aVar;
        return aVar;
    }

    public void g() {
        this.f196918b = null;
    }

    PromotionConfigInfo k() {
        return this.f196918b;
    }

    void o(String str, int i3, int i16) {
        d(str, i3, i16);
        BusinessCommonConfig.sendDownloadResultNotify(2, str, i3, i16);
    }

    public void p(b bVar) {
        synchronized (this.f196919c) {
            this.f196919c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final AppInterface appInterface, final boolean z16, String str, int i3) {
        PromotionConfigInfo k3 = k();
        if (k3 == null) {
            QLog.w(this.f196917a, 1, "requestPreDownload, ConfigInfo\u4e3a\u7a7a, callByPreDownload[" + z16 + "], activatyid[" + str + "], index[" + i3 + "]");
            return;
        }
        if (!(appInterface instanceof QQAppInterface)) {
            QLog.w(this.f196917a, 1, "requestPreDownload, \u4e0d\u5728\u4e3b\u8fdb\u7a0b");
            return;
        }
        PromotionConfigInfo.a item = k3.getItem(str);
        if (item == null) {
            o(str, i3, -3);
            return;
        }
        final PromotionConfigInfo.b h16 = h(z16, k3, item);
        QLog.w(this.f196917a, 1, "requestPreDownload, expectID[" + str + "], expectIndex[" + i3 + "], callByPreDownload[" + z16 + "], zipItem[" + h16 + "]");
        if (h16 == null) {
            Iterator<Map.Entry<Integer, PromotionConfigInfo.b>> it = item.e().entrySet().iterator();
            while (it.hasNext()) {
                o(str, it.next().getValue().f196902a, 100);
            }
            return;
        }
        String str2 = h16.f196904c;
        if (z16) {
            if (h16.f196908g != 0) {
                boolean requestPreDownload = ((IPreDownloadController) appInterface.getRuntimeService(IPreDownloadController.class, "")).requestPreDownload(10074, PreDownloadConstants.DEPARTMENT_PRD, str2, 0, h16.f196903b, h16.f196905d, h16.f196908g, 0, true, new RunnableTask((QQAppInterface) appInterface, str2, new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PromotionResDownload promotionResDownload = PromotionResDownload.this;
                        String qqStr = HardCodeUtil.qqStr(R.string.pfk);
                        boolean z17 = z16;
                        AppInterface appInterface2 = appInterface;
                        PromotionConfigInfo.b bVar = h16;
                        promotionResDownload.l(qqStr, z17, appInterface2, bVar.f196907f, bVar.f196902a, bVar);
                    }
                }, 0L));
                h16.f196913l = System.currentTimeMillis();
                QLog.w(this.f196917a, 1, "requestPreDownload, \u9884\u4e0b\u8f7d\u7533\u8bf7\u8c03\u5ea6, ret[" + requestPreDownload + "], index[" + h16.f196902a + "]");
                return;
            }
            if (QQAudioHelper.j()) {
                QLog.w(this.f196917a, 1, "requestPreDownload, \u65e0\u9700\u9884\u4e0b\u8f7d\uff0cid[" + h16.f196907f + "], index[" + h16.f196902a + "]");
                return;
            }
            return;
        }
        l(HardCodeUtil.qqStr(R.string.pfm), z16, appInterface, h16.f196907f, h16.f196902a, h16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(PromotionConfigInfo promotionConfigInfo) {
        this.f196918b = promotionConfigInfo;
        if (promotionConfigInfo != null) {
            Iterator<Map.Entry<String, PromotionConfigInfo.a>> it = promotionConfigInfo.operationInfos.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<Map.Entry<Integer, PromotionConfigInfo.b>> it5 = it.next().getValue().e().entrySet().iterator();
                while (it5.hasNext()) {
                    it5.next().getValue().a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements i.b {

        /* renamed from: a, reason: collision with root package name */
        final long f196923a = QQAudioHelper.b();

        /* renamed from: b, reason: collision with root package name */
        long f196924b = System.currentTimeMillis();

        /* renamed from: c, reason: collision with root package name */
        int f196925c = 0;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f196926d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196927e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f196928f;

        a(AppInterface appInterface, String str, int i3) {
            this.f196926d = appInterface;
            this.f196927e = str;
            this.f196928f = i3;
        }

        @Override // com.tencent.mobileqq.armap.i.b
        public void a(String str, String str2, int i3) {
            boolean z16;
            boolean z17 = false;
            if (i3 != 100 && i3 != 0 && Math.abs(i3 - this.f196925c) < 10) {
                z16 = false;
            } else {
                z16 = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f196924b >= 1000) {
                z17 = true;
            }
            if (QLog.isDevelopLevel() && (z17 || z16)) {
                QLog.w(PromotionResDownload.this.f196917a, 1, "onDownloadUpdate, md5[" + str2 + "], activityid[" + this.f196927e + "], index[" + this.f196928f + "], curPercent[" + i3 + "], lastPercent[" + this.f196925c + "], needNotify[" + z16 + "], needNotify2[" + z17 + "]");
            }
            if (z16) {
                this.f196925c = i3;
            }
            if (z17) {
                this.f196924b = currentTimeMillis;
            }
            if (z16 || z17) {
                PromotionResDownload.this.o(this.f196927e, this.f196928f, i3);
            }
        }

        @Override // com.tencent.mobileqq.armap.i.b
        public void b(String str, String str2, int i3, String str3, Object obj) {
            boolean z16;
            if (obj instanceof PromotionConfigInfo.b) {
                PromotionConfigInfo.b bVar = (PromotionConfigInfo.b) obj;
                bVar.f196915n = System.currentTimeMillis();
                String account = this.f196926d.getAccount();
                if (i3 == 0) {
                    z16 = PromotionResDownload.e(bVar);
                } else {
                    z16 = false;
                }
                QLog.w(PromotionResDownload.this.f196917a, 1, "onDownloadFinish, md5[" + str2 + "], errCode[" + i3 + "], check[" + z16 + "], path[" + str3 + "], id[" + bVar.f196907f + "], request[" + bVar.f196913l + "], Begin[" + bVar.f196914m + "], End[" + bVar.f196915n + "], \u8c03\u5ea6\u8017\u65f6[" + (bVar.f196914m - bVar.f196913l) + "], \u4e0b\u8f7d\u8017\u65f6[" + (bVar.f196915n - bVar.f196914m) + "], fromPreCover[" + bVar.f196916o + "], seq[" + this.f196923a + "], Uin[" + LogUtil.getSafePrintUin(account) + "], zipItem[" + bVar + "]");
                if (bVar.f196910i == this) {
                    bVar.f196910i = null;
                }
                if (i3 == 0 && !z16) {
                    i3 = -5;
                }
                if (i3 == 0) {
                    bVar.b(2);
                    ty2.a.i(account, bVar.f196907f, bVar.f196902a, bVar.f196904c);
                    PromotionResDownload.this.o(bVar.f196907f, bVar.f196902a, 100);
                    bVar.f196916o = -1;
                } else if (i3 == 100) {
                    bVar.b(2);
                    PromotionResDownload.this.o(bVar.f196907f, bVar.f196902a, 100);
                } else {
                    bVar.b(-1);
                    PromotionResDownload.this.o(bVar.f196907f, bVar.f196902a, -1);
                }
                PromotionResDownload.this.q(this.f196926d, bVar.f196909h, bVar.f196907f, bVar.f196902a + 1);
            }
        }

        protected void finalize() throws Throwable {
            super.finalize();
            QLog.w(PromotionResDownload.this.f196917a, 1, "ZipItem.finalize, activityid[" + this.f196927e + "], index[" + this.f196928f + "], seq[" + this.f196923a + "]");
        }

        @Override // com.tencent.mobileqq.armap.i.b
        public void onDownloadStart() {
        }
    }
}
