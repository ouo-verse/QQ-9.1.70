package com.tencent.open.virtual;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public OpenVirtualAccountNickEditorDialog.c f341781a;

    /* renamed from: b, reason: collision with root package name */
    public String f341782b;

    @NonNull
    public static OpenVirtualAccountNickEditorDialog d(@NonNull QBaseActivity qBaseActivity, String str, OpenVirtualAccountNickEditorDialog.c cVar) {
        OpenVirtualAccountNickEditorDialog a16 = new h().c(str).b(cVar).a();
        a16.yh(qBaseActivity);
        return a16;
    }

    public OpenVirtualAccountNickEditorDialog a() {
        OpenVirtualAccountNickEditorDialog openVirtualAccountNickEditorDialog = new OpenVirtualAccountNickEditorDialog();
        openVirtualAccountNickEditorDialog.xh(this.f341781a);
        openVirtualAccountNickEditorDialog.wh(this.f341782b);
        return openVirtualAccountNickEditorDialog;
    }

    public h b(OpenVirtualAccountNickEditorDialog.c cVar) {
        this.f341781a = cVar;
        return this;
    }

    public h c(String str) {
        this.f341782b = str;
        return this;
    }
}
