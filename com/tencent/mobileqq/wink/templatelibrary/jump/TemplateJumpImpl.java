package com.tencent.mobileqq.wink.templatelibrary.jump;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.mobileqq.wink.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TemplateJumpImpl {

    /* renamed from: a, reason: collision with root package name */
    private HashSet<String> f326453a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private Context f326454b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.wink.templatelibrary.jump.b f326455c;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private class DownloadSoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private MetaMaterial f326456d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.mobileqq.wink.templatelibrary.jump.a f326457e;

        /* renamed from: f, reason: collision with root package name */
        private Bundle f326458f;

        DownloadSoRunnable(@NonNull MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
            this.f326456d = metaMaterial;
            this.f326457e = aVar;
            this.f326458f = bundle;
            if (!WinkEditorResourceManager.a1().p2()) {
                QLog.d("TemplateDownloadManager", 1, "[DownloadSoRunnable] download template data");
                ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).fetchTemplateLibraryResource();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean p26 = WinkEditorResourceManager.a1().p2();
            if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady() && p26) {
                TemplateJumpImpl.this.i(this.f326456d, this.f326457e, this.f326458f);
            } else if (!TemplateJumpImpl.this.g(this.f326456d.f30533id, this.f326457e)) {
                RFWThreadManager.getUIHandler().postDelayed(this, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        private final int f326459a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f326460b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        private final AtomicInteger f326461c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        private int f326462d = 0;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f326463e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326464f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.templatelibrary.jump.a f326465g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Bundle f326466h;

        a(List list, MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
            this.f326463e = list;
            this.f326464f = metaMaterial;
            this.f326465g = aVar;
            this.f326466h = bundle;
            this.f326459a = list.size();
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (QLog.isDebugVersion()) {
                QLog.d("TemplateDownloadManager", 2, "[onDownloadFinish] isSuccess=", Boolean.valueOf(z16));
            }
            if (TemplateJumpImpl.this.g(this.f326464f.f30533id, this.f326465g)) {
                return;
            }
            this.f326461c.incrementAndGet();
            if (z16) {
                this.f326460b.incrementAndGet();
            }
            AtomicInteger atomicInteger = this.f326461c;
            int i3 = this.f326459a;
            if (atomicInteger.compareAndSet(i3, i3)) {
                AtomicInteger atomicInteger2 = this.f326460b;
                int i16 = this.f326459a;
                if (atomicInteger2.compareAndSet(i16, i16)) {
                    TemplateJumpImpl.this.l(this.f326464f, this.f326465g, this.f326466h);
                    return;
                }
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                QQToast.makeText(RFWApplication.getApplication(), 1, "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1).show();
                com.tencent.mobileqq.wink.templatelibrary.jump.a aVar = this.f326465g;
                if (aVar != null) {
                    aVar.b(false, 102);
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            com.tencent.mobileqq.wink.templatelibrary.jump.a aVar = this.f326465g;
            if (aVar != null) {
                int i16 = (int) (this.f326462d + (i3 / this.f326459a));
                this.f326462d = i16;
                aVar.onProgressUpdate(i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        private int f326468a = 0;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326469b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WinkEditorResourceDownloader.d f326470c;

        b(MetaMaterial metaMaterial, WinkEditorResourceDownloader.d dVar) {
            this.f326469b = metaMaterial;
            this.f326470c = dVar;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                String m3 = WinkEditorResourceManager.a1().m(this.f326469b);
                QLog.d("TemplateDownloadManager", 2, "[onDownloadFinish] downloadFolder=", m3);
                com.tencent.mobileqq.wink.editor.c.D1(this.f326469b, m3);
            }
            QLog.i("TemplateDownloadManager", 1, "[onDownloadFinish] download result, id=" + this.f326469b.f30533id + " success: " + z16);
            this.f326470c.onDownloadFinish(z16);
            TemplateJumpImpl.this.j(this.f326469b, z16);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            int i16 = i3 - this.f326468a;
            if (i16 != 0) {
                this.f326468a = i3;
                this.f326470c.onProgressUpdate(i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkEditorResourceDownloader.d f326472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326473b;

        c(WinkEditorResourceDownloader.d dVar, MetaMaterial metaMaterial) {
            this.f326472a = dVar;
            this.f326473b = metaMaterial;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            WinkEditorResourceDownloader.d dVar = this.f326472a;
            if (dVar != null) {
                dVar.onDownloadFinish(z16);
            }
            WinkEditorResourceManager.a1().i0(this.f326473b);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
            WinkEditorResourceDownloader.d dVar = this.f326472a;
            if (dVar != null) {
                dVar.onProgressUpdate(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.templatelibrary.jump.a f326475a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326476b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f326477c;

        d(com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, MetaMaterial metaMaterial, Bundle bundle) {
            this.f326475a = aVar;
            this.f326476b = metaMaterial;
            this.f326477c = bundle;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            com.tencent.mobileqq.wink.templatelibrary.jump.a aVar = this.f326475a;
            if (aVar != null && aVar.a()) {
                return;
            }
            TemplateJumpImpl.this.n(this.f326476b, this.f326477c);
        }
    }

    public TemplateJumpImpl(@NonNull Context context, com.tencent.mobileqq.wink.templatelibrary.jump.b bVar) {
        this.f326454b = context;
        this.f326455c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar) {
        QLog.d("TemplateDownloadManager", 1, "[checkCancelOnKeyStep] material id:", str, ",isCancel:", Boolean.valueOf(!this.f326453a.contains(str)));
        if (this.f326453a.contains(str)) {
            return false;
        }
        if (aVar != null) {
            aVar.c(202);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(@NonNull MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
        Pair<List<MetaMaterial>, List<MetaMaterial>> k3 = k(Collections.singletonList(metaMaterial));
        List list = (List) k3.first;
        List<MetaMaterial> list2 = (List) k3.second;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WinkEditorResourceManager.a1().j0(((MetaMaterial) it.next()).f30533id);
        }
        if (list2.isEmpty()) {
            l(metaMaterial, aVar, bundle);
            return;
        }
        QLog.i("TemplateDownloadManager", 1, "[downloadMaterialAndJump] begin download material, " + metaMaterial.f30533id);
        a aVar2 = new a(list2, metaMaterial, aVar, bundle);
        for (MetaMaterial metaMaterial2 : list2) {
            h(metaMaterial2, new b(metaMaterial2, aVar2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(MetaMaterial metaMaterial, boolean z16) {
        String i26;
        if (metaMaterial != null && z16) {
            if (QQWinkConstants.BUSINESS_ZSHOW_NAME.equals(metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY))) {
                i26 = metaMaterial.additionalFields.get(QQWinkConstants.EDITOR_LOCAL_TEMPLATE_PATH);
            } else {
                i26 = WinkEditorResourceManager.a1().i2(metaMaterial);
            }
            if (TextUtils.isEmpty(i26)) {
                QLog.e("TemplateDownloadManager", 1, "templateFilePath is null ");
                return;
            }
            if (!l.d() && !l.e()) {
                w53.b.c("TemplateDownloadManager", "downloadMaterialNeed loadLib failed");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.jump.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TemplateJumpImpl.o();
                    }
                });
                return;
            }
            ArrayList<String> b16 = ah.f326668a.b(i26);
            QLog.i("TemplateDownloadManager", 1, "material need download size " + b16.size());
            for (String str : b16) {
                QLog.i("TemplateDownloadManager", 1, "material need download" + str);
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(str);
            }
            return;
        }
        QLog.e("TemplateDownloadManager", 1, "material not download ");
    }

    private Pair<List<MetaMaterial>, List<MetaMaterial>> k(List<MetaMaterial> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MetaMaterial metaMaterial : list) {
            if (WinkEditorResourceManager.a1().q(metaMaterial)) {
                arrayList.add(metaMaterial);
            } else {
                arrayList2.add(metaMaterial);
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
        if (aVar != null) {
            aVar.b(true, 100);
        }
        com.tencent.mobileqq.wink.templatelibrary.jump.b bVar = this.f326455c;
        if (bVar == null || bVar.a()) {
            QLog.w("TemplateDownloadManager", 1, "[handleAfterDownloadDone] directJumpToPickAfterDownload: true");
            p(metaMaterial, aVar, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o() {
        QQToast.makeText(RFWApplication.getApplication(), 1, "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
    }

    public void f(String str) {
        this.f326453a.remove(str);
    }

    public void h(MetaMaterial metaMaterial, WinkEditorResourceDownloader.d dVar) {
        if (metaMaterial == null) {
            QLog.w("TemplateDownloadManager", 1, "[downloadMaterial] invalid material");
        } else if (WinkEditorResourceManager.a1().P1(metaMaterial.f30533id) == null) {
            WinkEditorResourceManager.a1().f(metaMaterial, dVar);
        } else {
            WinkEditorResourceManager.a1().f0(metaMaterial, new c(dVar, metaMaterial));
        }
    }

    public void m(@NonNull MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
        if (aVar != null) {
            aVar.onDownloadStart();
        }
        if (aVar != null) {
            aVar.onProgressUpdate(0);
        }
        if (!TextUtils.isEmpty(metaMaterial.f30533id)) {
            this.f326453a.add(metaMaterial.f30533id);
        }
        RFWThreadManager.getUIHandler().post(new DownloadSoRunnable(metaMaterial, aVar, bundle));
    }

    public void n(MetaMaterial metaMaterial, Bundle bundle) {
        HashMap hashMap;
        Intent a16 = QCircleTemplateLibraryMediaPickerFragment.INSTANCE.a(this.f326454b, metaMaterial);
        if (bundle != null) {
            if (!bundle.containsKey(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
                bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            }
            a16.putExtras(bundle);
        } else {
            a16.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        }
        if (a16.getExtras().containsKey("key_attrs") && (hashMap = (HashMap) a16.getExtras().getSerializable("key_attrs")) != null) {
            hashMap.remove("template");
            w53.b.a("TemplateDownloadManager", "remove attr auto template id");
        }
        this.f326454b.startActivity(a16);
    }

    public void p(MetaMaterial metaMaterial, com.tencent.mobileqq.wink.templatelibrary.jump.a aVar, Bundle bundle) {
        QQPermission qQPermission;
        if (this.f326454b == null) {
            QLog.w("TemplateDownloadManager", 1, "[tryToPickPhoto] invalid context");
            return;
        }
        com.tencent.mobileqq.wink.templatelibrary.jump.b bVar = this.f326455c;
        if (bVar != null && bVar.b() != null) {
            qQPermission = this.f326455c.b();
        } else {
            Context context = this.f326454b;
            if (context instanceof Activity) {
                try {
                    qQPermission = QQPermissionFactory.getQQPermission((Activity) context);
                } catch (Exception unused) {
                    QLog.e("TemplateDownloadManager", 1, "[tryToPickPhoto] get qq permission exception");
                }
            }
            qQPermission = null;
        }
        if (qQPermission == null) {
            QLog.d("TemplateDownloadManager", 1, "[tryToPickPhoto] qq permission is null ");
            if (aVar != null) {
                aVar.c(201);
                return;
            }
            return;
        }
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d(aVar, metaMaterial, bundle));
    }
}
