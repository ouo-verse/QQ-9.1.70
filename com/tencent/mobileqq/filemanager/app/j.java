package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.app.k;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j implements k.a {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f207294b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f207295c;

    /* renamed from: d, reason: collision with root package name */
    private int f207296d = 0;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f207293a = new WeakReference<>((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements TroopFileTransferManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f207303a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f207304b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EIPCModule f207305c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f207306d;

        b(String str, int i3, EIPCModule eIPCModule, int i16) {
            this.f207303a = str;
            this.f207304b = i3;
            this.f207305c = eIPCModule;
            this.f207306d = i16;
        }

        @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager.c
        public void onResult(int i3) {
            Bundle bundle = new Bundle();
            bundle.putString("action_type", this.f207303a);
            bundle.putInt("key_action_in_sheet", this.f207304b);
            this.f207305c.callbackResult(this.f207306d, EIPCResult.createResult(i3, bundle));
        }
    }

    public j(Activity activity, boolean z16) {
        this.f207294b = new WeakReference<>(activity);
        this.f207295c = z16;
    }

    private Activity e() {
        WeakReference<Activity> weakReference = this.f207294b;
        if (weakReference != null && weakReference.get() != null) {
            return this.f207294b.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface f() {
        WeakReference<QQAppInterface> weakReference = this.f207293a;
        if (weakReference != null && weakReference.get() != null) {
            return this.f207293a.get();
        }
        return null;
    }

    private FileManagerEntity g(QQAppInterface qQAppInterface, Bundle bundle) {
        return qQAppInterface.getFileManagerDataCenter().D(bundle.getLong("key_session_id", -1L));
    }

    @Override // com.tencent.mobileqq.filemanager.app.k.a
    public EIPCResult a(EIPCModule eIPCModule, String str, Bundle bundle, int i3) {
        FileManagerEntity g16;
        QQAppInterface f16 = f();
        boolean z16 = bundle.getBoolean("key_from_troop_plugin", true);
        if (f16 == null || this.f207295c != z16 || (g16 = g(f16, bundle)) == null) {
            return null;
        }
        if (!"action_download_file".equals(str) && !"action_print_file".equals(str)) {
            if ("action_share_file".equals(str)) {
                i(eIPCModule, g16, str, bundle.getInt("key_action_in_sheet", 0), i3);
            } else if ("action_get_progress".equals(str)) {
                this.f207296d = i3;
            }
        } else {
            h(eIPCModule, g16, str, z16, i3);
        }
        return null;
    }

    void h(EIPCModule eIPCModule, FileManagerEntity fileManagerEntity, String str, boolean z16, int i3) {
        QQAppInterface f16 = f();
        Activity e16 = e();
        if (f16 != null && e16 != null && fileManagerEntity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.tencent.mobileqq.filemanager.fileviewer.d.i(f16, fileManagerEntity));
            TroopFileModel troopFileModel = new TroopFileModel(f16, e16, arrayList, 0);
            troopFileModel.O0(new a(eIPCModule, troopFileModel, fileManagerEntity, str, z16, i3));
            troopFileModel.l0();
            if (troopFileModel.D() != null) {
                QLog.d("TroopDocsQIPCHandler", 2, "StartDownload. filename: " + fileManagerEntity.fileName);
                troopFileModel.D().a();
            }
        }
    }

    void i(EIPCModule eIPCModule, FileManagerEntity fileManagerEntity, String str, int i3, int i16) {
        Activity e16 = e();
        if (e16 != null && i3 == 27) {
            com.tencent.mobileqq.filemanager.fileviewer.c.y(e16, fileManagerEntity, new b(str, i3, eIPCModule, i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements FileBrowserModelBase.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EIPCModule f207297d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopFileModel f207298e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f207299f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f207300h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f207301i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f207302m;

        a(EIPCModule eIPCModule, TroopFileModel troopFileModel, FileManagerEntity fileManagerEntity, String str, boolean z16, int i3) {
            this.f207297d = eIPCModule;
            this.f207298e = troopFileModel;
            this.f207299f = fileManagerEntity;
            this.f207300h = str;
            this.f207301i = z16;
            this.f207302m = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void a(float f16) {
            if (j.this.f207296d != 0) {
                Bundle bundle = new Bundle();
                bundle.putString("action_type", "action_get_progress");
                bundle.putFloat("key_progress", f16);
                this.f207297d.callbackResult(j.this.f207296d, EIPCResult.createSuccessResult(bundle));
                j.this.f207296d = 0;
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void e() {
            TroopFileModel troopFileModel = this.f207298e;
            if (troopFileModel != null) {
                troopFileModel.m();
            }
            QLog.e("TroopDocsQIPCHandler", 1, "Download failed. filename: " + this.f207299f.fileName);
            j.this.f207296d = 0;
            Bundle bundle = new Bundle();
            bundle.putString("action_type", this.f207300h);
            this.f207297d.callbackResult(this.f207302m, EIPCResult.createResult(-102, bundle));
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void f() {
            TroopFileModel troopFileModel = this.f207298e;
            if (troopFileModel != null) {
                troopFileModel.m();
            }
            QQAppInterface f16 = j.this.f();
            if (f16 == null) {
                return;
            }
            FileManagerEntity queryFileEntity = ((IQQFileDataCenter) f16.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(0L, "", 0, this.f207299f.nSessionId);
            if (queryFileEntity != null) {
                j.this.f207296d = 0;
                Bundle bundle = new Bundle();
                bundle.putString("action_type", this.f207300h);
                if (this.f207301i) {
                    bundle.putString("key_download_path", queryFileEntity.strFilePath);
                }
                this.f207297d.callbackResult(this.f207302m, EIPCResult.createSuccessResult(bundle));
                return;
            }
            QLog.e("TroopDocsQIPCHandler", 1, "Download failed. entityNew == null");
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void j() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void l() {
        }
    }
}
