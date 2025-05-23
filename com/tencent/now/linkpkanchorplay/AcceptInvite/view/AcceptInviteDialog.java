package com.tencent.now.linkpkanchorplay.AcceptInvite.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.component.core.log.LogUtil;
import com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteView;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AcceptInviteDialog extends BottomDialog {
    private String H;
    private int I;
    private e55.a J;
    private int K;
    private AcceptInviteView L;
    private Eventor M = new Eventor();
    private c N;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements AcceptInviteView.d {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteView.d
        public void onHide() {
            AcceptInviteDialog.this.dismissAllowingStateLoss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements OnEvent<d.ReceiveInviteEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(d.ReceiveInviteEvent receiveInviteEvent) {
            if (receiveInviteEvent.getInviteMsg().f401299e == 4) {
                AcceptInviteDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        void onDismiss();
    }

    public AcceptInviteDialog(String str, int i3, e55.a aVar, int i16) {
        this.H = str;
        this.J = aVar;
        this.I = i3;
        this.K = i16;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        AcceptInviteView acceptInviteView = new AcceptInviteView(getContext());
        this.L = acceptInviteView;
        acceptInviteView.setCallback(new a());
        if (getActivity() != null) {
            this.L.setViewModelContext(getActivity(), getActivity());
        } else if (getContext() instanceof FragmentActivity) {
            this.L.setViewModelContext((FragmentActivity) getContext(), (FragmentActivity) getContext());
        } else {
            LogUtil.e("AcceptInviteDialog", "onCreateView exception, get activity is null", new Object[0]);
        }
        this.L.r(this.I, this.H, this.J);
        this.L.setRemainRefuseTime(this.K);
        this.M.addOnEvent(new b());
        AcceptInviteView acceptInviteView2 = this.L;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, acceptInviteView2);
        return acceptInviteView2;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.K = this.L.l();
        this.L.w();
        this.M.removeAll();
        c cVar = this.N;
        if (cVar != null) {
            cVar.onDismiss();
        }
        super.onDismiss(dialogInterface);
    }

    public int uh() {
        return this.K;
    }

    public void vh(c cVar) {
        this.N = cVar;
    }
}
