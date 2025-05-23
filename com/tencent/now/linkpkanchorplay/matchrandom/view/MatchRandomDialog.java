package com.tencent.now.linkpkanchorplay.matchrandom.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.component.core.log.LogUtil;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.matchrandom.view.MatchRandomView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MatchRandomDialog extends BottomDialog {
    private long H;
    private UIEvent.PKType I;
    private MatchRandomView J;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements MatchRandomView.e {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.view.MatchRandomView.e
        public void onHide(boolean z16) {
            MatchRandomDialog.this.dismissAllowingStateLoss();
            if (z16) {
                MatchRandomDialog.this.qh().t1(new UIEvent.c());
            }
        }
    }

    public MatchRandomDialog(long j3, UIEvent.PKType pKType) {
        this.H = j3;
        this.I = pKType;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        MatchRandomView matchRandomView = new MatchRandomView(getContext());
        this.J = matchRandomView;
        matchRandomView.setListener(new a());
        this.J.setPKInfo(this.H, this.I);
        if (getActivity() != null) {
            this.J.setViewModelStoreOwner(getActivity());
        } else if (getContext() instanceof FragmentActivity) {
            this.J.setViewModelStoreOwner((FragmentActivity) getContext());
        } else {
            LogUtil.e("AcceptInviteDialog", "onCreateView exception, get activity is null", new Object[0]);
        }
        rh(false);
        MatchRandomView matchRandomView2 = this.J;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, matchRandomView2);
        return matchRandomView2;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.J.m();
        super.onDismiss(dialogInterface);
    }

    public void uh() {
        MatchRandomView matchRandomView = this.J;
        if (matchRandomView != null) {
            matchRandomView.g();
        }
    }
}
