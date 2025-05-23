package com.tencent.open.virtual;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.virtual.OpenVirtualAccountCreatorDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public OpenVirtualAccountCreatorDialog.b f341780a;

    @NonNull
    public static OpenVirtualAccountCreatorDialog c(@NonNull QBaseActivity qBaseActivity, OpenVirtualAccountCreatorDialog.b bVar) {
        OpenVirtualAccountCreatorDialog a16 = new g().b(bVar).a();
        a16.sh(qBaseActivity);
        return a16;
    }

    public OpenVirtualAccountCreatorDialog a() {
        OpenVirtualAccountCreatorDialog openVirtualAccountCreatorDialog = new OpenVirtualAccountCreatorDialog();
        openVirtualAccountCreatorDialog.rh(this.f341780a);
        return openVirtualAccountCreatorDialog;
    }

    public g b(OpenVirtualAccountCreatorDialog.b bVar) {
        this.f341780a = bVar;
        return this;
    }
}
