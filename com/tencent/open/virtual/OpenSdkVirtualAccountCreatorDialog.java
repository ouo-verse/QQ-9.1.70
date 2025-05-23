package com.tencent.open.virtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.open.agent.OpenSdkVirtualAccountCreatorFragment;
import com.tencent.open.agent.OpenVirtualAccountCreatorFragment;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenVirtualAccountCreatorDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkVirtualAccountCreatorDialog extends OpenVirtualAccountCreatorDialog {
    private OpenSdkVirtualAccountCreatorFragment H;
    private long I;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements OpenVirtualAccountCreatorFragment.h {
        a() {
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void a(long j3) {
            t.b("OpenSdkVirtualAccountCreatorDialog", "onCreateSuccess");
            OpenSdkVirtualAccountCreatorDialog.this.dismissDialog();
            OpenVirtualAccountCreatorDialog.b bVar = OpenSdkVirtualAccountCreatorDialog.this.D;
            if (bVar != null) {
                bVar.a(j3);
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void b(int i3) {
            t.b("OpenSdkVirtualAccountCreatorDialog", "onCreateFailed");
            OpenSdkVirtualAccountCreatorDialog.this.dismissDialog();
            OpenVirtualAccountCreatorDialog.b bVar = OpenSdkVirtualAccountCreatorDialog.this.D;
            if (bVar != null) {
                bVar.b(i3);
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void c(boolean z16) {
            t.b("OpenSdkVirtualAccountCreatorDialog", "onEditComplete");
            OpenSdkVirtualAccountCreatorDialog openSdkVirtualAccountCreatorDialog = OpenSdkVirtualAccountCreatorDialog.this;
            openSdkVirtualAccountCreatorDialog.E = z16;
            if (z16) {
                openSdkVirtualAccountCreatorDialog.th();
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void d() {
            t.b("OpenSdkVirtualAccountCreatorDialog", "onEdit");
            OpenSdkVirtualAccountCreatorDialog.this.ph();
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void onCancel() {
            t.b("OpenSdkVirtualAccountCreatorDialog", "onCancel");
            OpenSdkVirtualAccountCreatorDialog.this.dismissDialog();
        }
    }

    @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        OpenSdkVirtualAccountCreatorFragment openSdkVirtualAccountCreatorFragment = this.H;
        if (openSdkVirtualAccountCreatorFragment != null) {
            openSdkVirtualAccountCreatorFragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fqy, viewGroup, false);
        if (this.H == null) {
            OpenSdkVirtualAccountCreatorFragment openSdkVirtualAccountCreatorFragment = new OpenSdkVirtualAccountCreatorFragment();
            this.H = openSdkVirtualAccountCreatorFragment;
            openSdkVirtualAccountCreatorFragment.Th(this.I);
        }
        this.H.Nh(new a());
        vh();
        getChildFragmentManager().beginTransaction().replace(R.id.ckj, this.H).commitAllowingStateLoss();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    public void onNewIntent(Intent intent) {
        t.b("OpenSdkVirtualAccountCreatorDialog", "onNewIntent");
        OpenSdkVirtualAccountCreatorFragment openSdkVirtualAccountCreatorFragment = this.H;
        if (openSdkVirtualAccountCreatorFragment != null) {
            openSdkVirtualAccountCreatorFragment.onNewIntent(intent);
        }
    }

    public void wh(String str) {
        this.I = o.c(str);
    }
}
