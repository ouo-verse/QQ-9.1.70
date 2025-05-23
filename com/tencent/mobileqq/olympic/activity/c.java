package com.tencent.mobileqq.olympic.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload;
import com.tencent.mobileqq.ar.ARPromotionMgr.d;
import com.tencent.mobileqq.ar.ARPromotionMgr.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.a;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    static final String f255206j;

    /* renamed from: a, reason: collision with root package name */
    private ScanTorchActivity f255207a;

    /* renamed from: b, reason: collision with root package name */
    private e f255208b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f255209c;

    /* renamed from: d, reason: collision with root package name */
    int[] f255210d;

    /* renamed from: e, reason: collision with root package name */
    private PromotionConfigInfo.a f255211e;

    /* renamed from: f, reason: collision with root package name */
    private PromotionResDownload.b f255212f;

    /* renamed from: g, reason: collision with root package name */
    private a.InterfaceC8592a f255213g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f255214h;

    /* renamed from: i, reason: collision with root package name */
    long f255215i;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements d.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f255216a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppInterface f255217b;

        a(String str, AppInterface appInterface) {
            this.f255216a = str;
            this.f255217b = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, appInterface);
            }
        }

        @Override // com.tencent.mobileqq.ar.ARPromotionMgr.d.b
        public void a(PromotionConfigInfo promotionConfigInfo) {
            PromotionConfigInfo.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) promotionConfigInfo);
                return;
            }
            QLog.w(c.f255206j, 1, "getRes, promotionConfigInfo[" + promotionConfigInfo + "], activityID[" + this.f255216a + "], isDestroyed[" + c.this.o() + "]");
            if (c.this.o()) {
                return;
            }
            if (promotionConfigInfo != null) {
                String str = this.f255216a;
                if (str != null) {
                    aVar = promotionConfigInfo.getItem(str);
                } else {
                    aVar = promotionConfigInfo.getActivityItem();
                }
                String currentAccountUin = c.this.f255209c.getCurrentAccountUin();
                int a16 = z81.e.a(currentAccountUin + "AR_PROMOTION_ENTRY_SHOWONCE");
                int b16 = ty2.a.b(currentAccountUin);
                boolean z16 = false;
                if (b16 != z81.e.a(currentAccountUin + "AR_PROMOTION_ENTRY_SERVER_VERSION") || b16 == 0) {
                    z81.e.b(currentAccountUin + "AR_PROMOTION_ENTRY_SERVER_VERSION", b16);
                    a16 = 0;
                }
                if (!promotionConfigInfo.showOnce || a16 == 0) {
                    z81.e.b(currentAccountUin + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
                }
                if (!promotionConfigInfo.showOnce || a16 == 0) {
                    z16 = true;
                }
                c.this.f255208b.b(z16, promotionConfigInfo.showInTopView);
                if (z16 && promotionConfigInfo.showOnce) {
                    z81.e.b(currentAccountUin + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
                }
            } else {
                aVar = null;
            }
            c.this.v(this.f255217b, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements a.InterfaceC8592a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f255219d;

        b(AppInterface appInterface) {
            this.f255219d = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) appInterface);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.gesture.a.InterfaceC8592a
        public void l8(boolean z16, boolean z17, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            QLog.w(c.f255206j, 1, "onDownloadProgress, index[3], bDownloadSuc[" + z16 + "]");
            c cVar = c.this;
            int[] iArr = cVar.f255210d;
            if (z16) {
                i16 = 100;
            } else {
                i16 = -1;
            }
            iArr[3] = i16;
            if (cVar.n() == 100) {
                c.this.i("onDownloadProgress1", this.f255219d, false);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.gesture.a.InterfaceC8592a
        public void onDownloadProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                c.this.f255210d[3] = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.olympic.activity.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8181c implements PromotionResDownload.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f255221a;

        C8181c(AppInterface appInterface) {
            this.f255221a = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) appInterface);
            }
        }

        @Override // com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.b
        public void b(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            PromotionConfigInfo.a l3 = c.this.l();
            if (l3 != null && TextUtils.equals(str, l3.f196897e)) {
                c cVar = c.this;
                int[] iArr = cVar.f255210d;
                if (i3 < iArr.length) {
                    iArr[i3] = i16;
                }
                if (i16 >= 0 && i16 <= 99) {
                    cVar.C("onDownloadProgress", true);
                    return;
                }
                QLog.w(c.f255206j, 1, "onDownloadProgress, index[" + i3 + "], progress[" + i16 + "]");
                if (i16 == 100 && i3 == 0) {
                    c.this.j("onDownloadProgress", this.f255221a);
                }
                c.this.i("onDownloadProgress2", this.f255221a, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PopupMenu popupMenu = new PopupMenu(c.this.f255207a, view);
                c cVar = c.this;
                cVar.D(cVar.f255207a.app, popupMenu);
                popupMenu.show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        boolean a();

        void b(boolean z16, boolean z17);

        void i(PromotionConfigInfo.a aVar, boolean z16);

        boolean isEngineReady();

        void m(PromotionConfigInfo.a aVar);

        boolean n();

        void o(String str, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f255206j = f.f196950a + "_Res";
    }

    public c(ScanTorchActivity scanTorchActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scanTorchActivity);
            return;
        }
        this.f255210d = new int[]{100, 100, 100, 100, 100};
        this.f255211e = null;
        this.f255212f = null;
        this.f255213g = null;
        this.f255214h = false;
        this.f255215i = 0L;
        this.f255207a = scanTorchActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, boolean z16) {
        if (o()) {
            return;
        }
        long j3 = this.f255215i;
        if (j3 == 0) {
            this.f255215i = System.currentTimeMillis() + 1500;
            QLog.w(f255206j, 1, "showDownloadProgress, \u5ffd\u75651, from[" + str + "], progress[" + z16 + "]");
            return;
        }
        if (j3 > System.currentTimeMillis()) {
            QLog.w(f255206j, 1, "showDownloadProgress, \u5ffd\u75652, from[" + str + "], progress[" + z16 + "]");
            return;
        }
        if (z16 && r()) {
            this.f255208b.o("PromotionRes_" + str, 0);
        }
    }

    private void E(AppInterface appInterface, boolean z16) {
        boolean s16 = s(appInterface);
        if (this.f255210d[0] == 100) {
            j("tryDownload", appInterface);
        }
        if (s16) {
            i("tryDownload", appInterface, false);
        } else {
            this.f255214h = z16;
            C("tryDownload", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, AppInterface appInterface, boolean z16) {
        if (o()) {
            QLog.w(f255206j, 1, "checkAllRes, scanTorchActivity\u4e3a\u7a7a, from[" + str + "], notify[" + z16 + "]");
            return;
        }
        PromotionConfigInfo.a l3 = l();
        if (l3 == null) {
            QLog.w(f255206j, 1, "checkAllRes, promotionItem\u4e3a\u7a7a, from[" + str + "], notify[" + z16 + "]");
            if (z16) {
                this.f255208b.i(l3, false);
                return;
            }
            return;
        }
        C("checkAllRes", true);
        if (q()) {
            QLog.w(f255206j, 1, "checkAllRes, \u8fd8\u5728\u4e0b\u8f7d\u4e2d, from[" + str + "], notify[" + z16 + "]");
            return;
        }
        if (p()) {
            QLog.w(f255206j, 1, "checkAllRes, \u4e0b\u8f7d\u5931\u8d25, from[" + str + "], notify[" + z16 + "]");
            this.f255208b.i(l3, false);
            return;
        }
        if (!this.f255208b.isEngineReady()) {
            QLog.w(f255206j, 1, "checkAllRes, ArEngine\u672a\u51c6\u5907\u597d, from[" + str + "], notify[" + z16 + "]");
            return;
        }
        QLog.w(f255206j, 1, "checkAllRes, all ready, from[" + str + "], notify[" + z16 + "]");
        B();
        this.f255208b.i(l3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, AppInterface appInterface) {
        if (o()) {
            QLog.w(f255206j, 1, "checkEntryRes, scanTorchActivity\u4e3a\u7a7a");
            return;
        }
        PromotionConfigInfo.a l3 = l();
        if (l3 == null) {
            QLog.w(f255206j, 1, "checkEntryRes, promotion\u4e3a\u7a7a");
            return;
        }
        boolean n3 = this.f255208b.n();
        boolean z16 = false;
        if (this.f255210d[0] == 100) {
            z16 = true;
        }
        QLog.w(f255206j, 1, "checkEntryRes, from[" + str + "], isReadyShowEntry[" + n3 + "], isEntryReady[" + z16 + "], promotionItem[" + l3 + "]");
        if (n3 && z16) {
            this.f255208b.m(l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        ScanTorchActivity scanTorchActivity = this.f255207a;
        if (scanTorchActivity != null && !scanTorchActivity.isDestroyed) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(AppInterface appInterface, PromotionConfigInfo.a aVar) {
        if (aVar != null && (!aVar.f196895c || aVar.c() != null)) {
            this.f255211e = aVar;
            x(appInterface);
            f.b(appInterface).m(appInterface, aVar.f196897e);
            E(appInterface, this.f255208b.a());
            return;
        }
        i("onGetTransferDoorConfig", appInterface, true);
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f255214h = z16;
        }
    }

    void B() {
        if (QQAudioHelper.c(5) != 1) {
            return;
        }
        Button button = (Button) this.f255207a.findViewById(R.id.be7);
        button.setVisibility(0);
        if (button.getTag() != null) {
            return;
        }
        button.setTag(new Object());
        button.setOnClickListener(new d());
    }

    public void D(AppInterface appInterface, PopupMenu popupMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface, (Object) popupMenu);
        }
    }

    public void k(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
            return;
        }
        this.f255207a = null;
        if (this.f255212f != null) {
            f.b(appInterface).l(this.f255212f);
            this.f255212f = null;
        }
        if (this.f255213g != null) {
            com.tencent.mobileqq.shortvideo.gesture.a.c().a(false, this.f255213g);
        }
        this.f255211e = null;
    }

    public PromotionConfigInfo.a l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PromotionConfigInfo.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f255211e;
    }

    public void m(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        if (this.f255208b.a()) {
            QLog.d(f255206j, 1, "getRes,  \u9700\u8981\u663e\u793a\u7a7f\u8d8a\u95e8\u8fdb\u5ea6\u6761");
            this.f255214h = true;
        }
        QLog.d(f255206j, 1, "getRes, activityID[" + str + "], TotalProgress[" + n() + "]");
        f.b(appInterface).r(appInterface, new a(str, appInterface));
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int[] iArr = this.f255210d;
            if (i3 < iArr.length) {
                i16 += iArr[i3];
                i3++;
            } else {
                return i16 / iArr.length;
            }
        }
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (q()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f255210d;
            if (i3 >= iArr.length) {
                return false;
            }
            if (iArr[i3] < 0) {
                QLog.w(f255206j, 1, "isDownloadError, index[" + i3 + "], errCode[" + this.f255210d[i3] + "]");
                return true;
            }
            i3++;
        }
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f255210d;
            if (i3 >= iArr.length) {
                return false;
            }
            int i16 = iArr[i3];
            if (i16 >= 0 && i16 <= 99) {
                QLog.w(f255206j, 1, "isDownloading, index[" + i3 + "], Progress[" + this.f255210d[i3] + "]");
                return true;
            }
            i3++;
        }
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f255214h;
    }

    public boolean s(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appInterface)).booleanValue();
        }
        PromotionConfigInfo.a l3 = l();
        if (l3 == null) {
            QLog.w(f255206j, 1, "isResReady no promotion Item so reay");
            return true;
        }
        TreeMap<Integer, PromotionConfigInfo.b> e16 = l3.e();
        int size = e16.size();
        if (size + 1 > this.f255210d.length) {
            String str = "checkRes, zip\u6570\u76ee\u4e0d\u5bf9, itemCount[" + size + "]";
            QLog.w(f255206j, 1, str);
            if (QQAudioHelper.f()) {
                throw new IllegalStateException(str);
            }
        }
        Iterator<Map.Entry<Integer, PromotionConfigInfo.b>> it = e16.entrySet().iterator();
        while (it.hasNext()) {
            PromotionConfigInfo.b value = it.next().getValue();
            if (PromotionResDownload.n(appInterface.getCurrentAccountUin(), value)) {
                this.f255210d[value.f196902a] = 100;
            } else {
                this.f255210d[value.f196902a] = 0;
            }
        }
        if (com.tencent.mobileqq.shortvideo.ptvfilter.gesture.a.a()) {
            this.f255210d[3] = 100;
        } else {
            this.f255210d[3] = 0;
        }
        int n3 = n();
        QLog.w(f255206j, 1, "checkRes, itemCount[" + size + "], Progress0[" + this.f255210d[0] + "], Progress1[" + this.f255210d[1] + "], Progress2[" + this.f255210d[2] + "], Progress3[" + this.f255210d[3] + "], TotalProgress[" + n3 + "]");
        if (n3 == 100) {
            return true;
        }
        return false;
    }

    public void t(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface);
        } else {
            QLog.w(f255206j, 1, "onAREngineReady");
            i("onAREngineReady", appInterface, false);
        }
    }

    public void u(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInterface);
        } else {
            j("onAREngineReady", appInterface);
        }
    }

    public void w(AppInterface appInterface) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface);
            return;
        }
        PromotionConfigInfo.a l3 = l();
        boolean q16 = q();
        if (!q16) {
            z16 = p();
        } else {
            z16 = false;
        }
        QLog.w(f255206j, 1, "reTry, promotionItem[" + l3 + "], isDownloading[" + q16 + "], isDownloadError[" + z16 + "], needShowDownloadProgress[" + this.f255214h + "], TotalProgress[" + n() + "]");
        this.f255214h = true;
        if (l3 == null || q16) {
            return;
        }
        f.b(appInterface).m(appInterface, l3.f196897e);
        E(appInterface, this.f255208b.a());
    }

    void x(AppInterface appInterface) {
        if (this.f255212f != null) {
            return;
        }
        this.f255213g = new b(appInterface);
        com.tencent.mobileqq.shortvideo.gesture.a.c().a(true, this.f255213g);
        this.f255212f = new C8181c(appInterface);
        f.b(appInterface).c(this.f255212f);
    }

    public void y(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
        } else {
            this.f255208b = eVar;
        }
    }

    public void z(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
        } else {
            this.f255209c = appInterface;
        }
    }
}
