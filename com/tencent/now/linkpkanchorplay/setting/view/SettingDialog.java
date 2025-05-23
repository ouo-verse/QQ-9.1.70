package com.tencent.now.linkpkanchorplay.setting.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.setting.view.SettingView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SettingDialog extends BottomDialog {
    private SettingView H;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements SettingView.c {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.setting.view.SettingView.c
        public void onBack() {
            if (SettingDialog.this.getDialog() != null) {
                SettingDialog.this.getDialog().cancel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        SettingView settingView = new SettingView(getContext());
        this.H = settingView;
        settingView.setCallback(new a());
        com.tencent.report.a.f364907a.f(this.H, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, zm3.a.f452778a.b());
        rh(true);
        SettingView settingView2 = this.H;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, settingView2);
        return settingView2;
    }
}
