package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEARCakeMaterialManager {

    /* renamed from: c, reason: collision with root package name */
    private String f62809c;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.data.a f62811e;

    /* renamed from: f, reason: collision with root package name */
    AEARCakeMaterialAdapter f62812f;

    /* renamed from: h, reason: collision with root package name */
    AEARCakePanel.g f62814h;

    /* renamed from: i, reason: collision with root package name */
    private b f62815i;

    /* renamed from: j, reason: collision with root package name */
    private AEARCakeMaterial f62816j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f62817k;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.aelight.camera.ae.data.a> f62807a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f62808b = false;

    /* renamed from: d, reason: collision with root package name */
    private int f62810d = -1;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<c> f62818l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.aelight.camera.download.a f62819m = new com.tencent.aelight.camera.download.a() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3
        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(final AEMaterialMetaData aEMaterialMetaData, final boolean z16, final int i3) {
            ms.a.a("AEARCakeMaterialManager", "arcake : onDownloadFinish " + z16);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 != 200) {
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f169902y80), 1).show();
                        return;
                    }
                    AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
                    if (aEMaterialMetaData2 != null && z16) {
                        AEARCakePanel.g gVar = AEARCakeMaterialManager.this.f62814h;
                        if (gVar != null) {
                            gVar.a(aEMaterialMetaData2);
                        }
                        AEARCakeMaterialAdapter aEARCakeMaterialAdapter = AEARCakeMaterialManager.this.f62812f;
                        if (aEARCakeMaterialAdapter != null) {
                            aEARCakeMaterialAdapter.notifyItemChanged(0, 1);
                        }
                        if (AEARCakeMaterialManager.this.f62815i != null) {
                            AEARCakeMaterialManager.this.f62815i.b(aEMaterialMetaData);
                            AEARCakeMaterialManager.this.f62817k = true;
                            AEARCakeMaterialManager.this.f62816j = null;
                            return;
                        }
                        return;
                    }
                    ms.a.a("AEARCakeMaterialManager", "arcake : can not set material ");
                }
            });
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(final AEMaterialMetaData aEMaterialMetaData, final int i3) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AEARCakeMaterialAdapter aEARCakeMaterialAdapter = AEARCakeMaterialManager.this.f62812f;
                    if (aEARCakeMaterialAdapter != null) {
                        aEARCakeMaterialAdapter.notifyItemChanged(0, 1);
                    }
                    if (AEARCakeMaterialManager.this.f62815i != null) {
                        AEARCakeMaterialManager.this.f62815i.a(aEMaterialMetaData, i3);
                    }
                }
            });
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private AEMaterialManager f62813g = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final AEARCakeMaterialManager f62828a = new AEARCakeMaterialManager();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(AEMaterialMetaData aEMaterialMetaData, int i3);

        void b(AEMaterialMetaData aEMaterialMetaData);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a();
    }

    AEARCakeMaterialManager() {
    }

    private void d(AEARCakeMaterial aEARCakeMaterial) {
        ms.a.a("AEARCakeMaterialManager", "arcake : doRealDownload");
        this.f62816j = aEARCakeMaterial;
        AEMaterialManager aEMaterialManager = this.f62813g;
        aEMaterialManager.E0(aEMaterialManager.getApp(), aEARCakeMaterial, this.f62819m);
    }

    public static AEARCakeMaterialManager i() {
        return a.f62828a;
    }

    public void e() {
        ms.a.a("AEARCakeMaterialManager", "arcake : downloadFirstSelectMaterial ");
        CopyOnWriteArrayList<com.tencent.aelight.camera.ae.data.a> copyOnWriteArrayList = this.f62807a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            com.tencent.aelight.camera.ae.data.a aVar = this.f62807a.get(0);
            if (aVar == null) {
                ms.a.c("AEARCakeMaterialManager", "can not set select first material,giftMaterial is null ");
                return;
            }
            ms.a.a("AEARCakeMaterialManager", "arcake : can find " + aVar.c());
            f(aVar);
            return;
        }
        ms.a.c("AEARCakeMaterialManager", "can not set select first material");
    }

    public void f(com.tencent.aelight.camera.ae.data.a aVar) {
        AEARCakeMaterial b16 = aVar.b();
        if (b16 == null) {
            ms.a.c("AEARCakeMaterialManager", "can not set select first material,arcakematerial is null ");
            return;
        }
        this.f62810d = 0;
        ms.a.a("AEARCakeMaterialManager", "arcake : setSelectMaterial" + b16.name + ProgressTracer.SEPARATOR + b16.usable + ": mSelectedPosition" + this.f62810d);
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()) && !b16.usable) {
            ms.a.c("AEARCakeMaterialManager", "net work not available");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f169902y80), 1).show();
                }
            });
            return;
        }
        z(aVar, this.f62810d);
        if (b16.usable) {
            if (!AEResUtil.R()) {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.qdv), 0).show();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
                        if (com.tencent.aelight.camera.ae.d.j()) {
                            com.tencent.aelight.camera.ae.d.u();
                        }
                    }
                }, 64, null, true);
                return;
            }
            ms.a.a("AEARCakeMaterialManager", "arcake : mMaterialPanelListener" + this.f62814h);
            AEARCakePanel.g gVar = this.f62814h;
            if (gVar != null) {
                gVar.a(b16);
                return;
            }
            return;
        }
        g(b16);
    }

    public AEARCakeMaterial h() {
        return this.f62816j;
    }

    public b j() {
        return this.f62815i;
    }

    public synchronized List<com.tencent.aelight.camera.ae.data.a> k() {
        ms.a.f("AEARCakeMaterialManager", "arcake : getMaterialsSync---mHasLoaded=" + this.f62808b);
        if (this.f62808b) {
            return new ArrayList(this.f62807a);
        }
        List<com.tencent.aelight.camera.ae.data.a> b16 = AEGiftMaterialConfigParser.b();
        r(b16);
        this.f62807a.clear();
        this.f62807a.addAll(b16);
        this.f62808b = true;
        return new ArrayList(this.f62807a);
    }

    public String l() {
        String m3 = m();
        if (m3 == null || m3.length() <= 4) {
            return m3;
        }
        return m3.substring(0, 4) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public String m() {
        IFriendDataService iFriendDataService;
        PeakAppInterface peakAppInterface = (PeakAppInterface) com.tencent.aelight.camera.aebase.a.a();
        String str = "you";
        this.f62809c = "you";
        if (peakAppInterface == null) {
            ms.a.c("AEARCakeMaterialManager", "app interface is null");
            return this.f62809c;
        }
        String j3 = AECameraPrefsUtil.f().j(IAECameraPrefsUtil.KEY_ARCAKE_PREVIEW, "", 4);
        if (!TextUtils.isEmpty(j3) && "1".equals(j3)) {
            this.f62809c = "you";
            ms.a.a("AEARCakeMaterialManager", "arcake preview status info : " + this.f62809c);
            return this.f62809c;
        }
        String j16 = AECameraPrefsUtil.f().j(IAECameraPrefsUtil.KEY_ARCAKE_TOUIN, "", 4);
        if (!TextUtils.isEmpty(j16) && (iFriendDataService = (IFriendDataService) peakAppInterface.getRuntimeService(IFriendDataService.class, "all")) != null) {
            Friends friend = iFriendDataService.getFriend(j16, true, true, true);
            if (friend != null) {
                str = friend.getFriendNick();
            }
            this.f62809c = str;
            ms.a.a("AEARCakeMaterialManager", "arcake current user is giver info : " + this.f62809c);
            return this.f62809c;
        }
        this.f62809c = peakAppInterface.getCurrentNickname();
        ms.a.a("AEARCakeMaterialManager", "arcake mSelectedARShowInfo current user: " + this.f62809c);
        return this.f62809c;
    }

    public com.tencent.aelight.camera.ae.data.a n() {
        return this.f62811e;
    }

    public int o() {
        return this.f62810d;
    }

    public boolean p() {
        return this.f62817k;
    }

    public synchronized void q() {
        ms.a.f("AEARCakeMaterialManager", "arcake : onConfigUpdated---");
        this.f62808b = false;
        Iterator<c> it = this.f62818l.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void s(c cVar) {
        if (cVar == null) {
            ms.a.c("AEARCakeMaterialManager", "registerListener---the listener param is null");
            return;
        }
        ms.a.a("AEARCakeMaterialManager", "arcake :registerListener");
        if (this.f62818l.contains(cVar)) {
            return;
        }
        ms.a.a("AEARCakeMaterialManager", "add listener");
        this.f62818l.add(cVar);
    }

    public void t(c cVar) {
        this.f62818l.remove(cVar);
    }

    public void u(AEARCakeMaterialAdapter aEARCakeMaterialAdapter) {
        this.f62812f = aEARCakeMaterialAdapter;
    }

    public void v(b bVar) {
        this.f62815i = bVar;
    }

    public void w(AEARCakeMaterial aEARCakeMaterial) {
        this.f62816j = aEARCakeMaterial;
    }

    public void x(boolean z16) {
        this.f62808b = z16;
    }

    public void y(AEARCakePanel.g gVar) {
        this.f62814h = gVar;
    }

    public void z(com.tencent.aelight.camera.ae.data.a aVar, int i3) {
        if (aVar == null) {
            ms.a.c("AEARCakeMaterialManager", "arcake gift is null ,can not set anything");
            return;
        }
        this.f62810d = i3;
        this.f62811e = aVar;
        if (aVar.b() == null) {
            ms.a.c("AEARCakeMaterialManager", "arcake material is null, can not set anything");
        }
    }

    private void g(AEARCakeMaterial aEARCakeMaterial) {
        if (aEARCakeMaterial == null || aEARCakeMaterial.downloading || TextUtils.isEmpty(aEARCakeMaterial.f69050id) || this.f62813g == null) {
            return;
        }
        d(aEARCakeMaterial);
    }

    private void r(List<com.tencent.aelight.camera.ae.data.a> list) {
        AEARCakeMaterial b16;
        if (list == null) {
            return;
        }
        for (com.tencent.aelight.camera.ae.data.a aVar : list) {
            if (aVar != null && (b16 = aVar.b()) != null) {
                b16.usable = AEMaterialManager.W(b16);
            }
        }
    }
}
