package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ApplyMaterialTask.a f322859a;

        a(ApplyMaterialTask.a aVar) {
            this.f322859a = aVar;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            if (z16) {
                this.f322859a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
            } else {
                this.f322859a.a(ApplyMaterialTask.Status.FAILED, -1);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            this.f322859a.a(ApplyMaterialTask.Status.ONGOING, i3);
        }
    }

    public static boolean a(@Nullable MetaMaterial metaMaterial) {
        return com.tencent.mobileqq.wink.editor.c.X0(metaMaterial);
    }

    public static boolean b(@NonNull MetaMaterial metaMaterial) {
        return WinkEditorResourceManager.a1().q(metaMaterial);
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
            WinkEditorResourceManager.a1().f(metaMaterial, new a(aVar));
        }
    }

    public static void e(@NonNull ApplyMaterialTask.a aVar) {
        aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }

    public static void f(@NonNull ApplyMaterialTask.a aVar) {
        aVar.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
}
