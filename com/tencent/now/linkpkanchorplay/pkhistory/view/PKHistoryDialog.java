package com.tencent.now.linkpkanchorplay.pkhistory.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.pkhistory.view.PKHistoryListView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes22.dex */
public class PKHistoryDialog extends BottomDialog {
    private long H;
    private PKHistoryListView I;

    /* loaded from: classes22.dex */
    class a implements PKHistoryListView.d {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.pkhistory.view.PKHistoryListView.d
        public void onBack() {
            if (PKHistoryDialog.this.getDialog() != null) {
                PKHistoryDialog.this.getDialog().cancel();
            }
        }
    }

    public PKHistoryDialog(long j3) {
        this.H = j3;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        PKHistoryListView pKHistoryListView = new PKHistoryListView(getContext(), this.H);
        this.I = pKHistoryListView;
        pKHistoryListView.setCallback(new a());
        com.tencent.report.a.f364907a.f(this.I, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, zm3.a.f452778a.b());
        PKHistoryListView pKHistoryListView2 = this.I;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, pKHistoryListView2);
        return pKHistoryListView2;
    }
}
