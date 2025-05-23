package com.tencent.mobileqq.qqvideoedit.flow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements VideoEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f275869a;

        a(ApplyMaterialTask.a aVar) {
            this.f275869a = aVar;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                this.f275869a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f275869a.a(ApplyMaterialTask.Status.FAILED, -1);
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            this.f275869a.a(ApplyMaterialTask.Status.ONGOING, i3);
        }
    }

    public static boolean a(@Nullable MetaMaterial metaMaterial) {
        return com.tencent.mobileqq.qqvideoedit.editor.b.p(metaMaterial);
    }

    public static boolean b(@NonNull MetaMaterial metaMaterial) {
        return VideoEditorResourceManager.L().h(metaMaterial);
    }

    public static void c(String str, MetaMaterial metaMaterial, String str2) {
        String str3;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (metaMaterial == null) {
            str3 = "";
        } else {
            str3 = metaMaterial.f30533id;
        }
        objArr[1] = str3;
        objArr[2] = str2;
        ms.a.f("[ApplyMaterial]", String.format("[%s] %s ==>> %s", objArr));
    }

    public static void d(@NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        if (!NetworkUtil.isNetworkAvailable()) {
            aVar.a(ApplyMaterialTask.Status.FAILED, -1);
        } else {
            VideoEditorResourceManager.L().c(metaMaterial, new a(aVar));
        }
    }

    public static void e(@NonNull ApplyMaterialTask.a aVar) {
        aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }

    public static void f(@NonNull ApplyMaterialTask.a aVar) {
        aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
}
