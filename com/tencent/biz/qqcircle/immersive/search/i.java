package com.tencent.biz.qqcircle.immersive.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.QFSSearchPromptFragment;
import com.tencent.biz.qqcircle.immersive.search.result.QFSSearchResultFragment;
import com.tencent.biz.qqcircle.immersive.search.suggest.QFSSearchSuggestFragment;
import com.tencent.biz.qqcircle.immersive.search.viewmodel.QFSSearchViewModel;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends com.tencent.biz.qqcircle.bizparts.b {
    private QFSSearchViewModel C;

    /* renamed from: d, reason: collision with root package name */
    private QFSSearchPromptFragment f89888d;

    /* renamed from: e, reason: collision with root package name */
    private QFSSearchSuggestFragment f89889e;

    /* renamed from: f, reason: collision with root package name */
    private QFSSearchResultFragment f89890f;

    /* renamed from: h, reason: collision with root package name */
    private QFSBaseFragment f89891h;

    /* renamed from: i, reason: collision with root package name */
    private u60.b f89892i = new u60.b(0);

    /* renamed from: m, reason: collision with root package name */
    private boolean f89893m;

    private void A9(QFSBaseFragment qFSBaseFragment, Bundle bundle) {
        if (bundle != null && !qFSBaseFragment.isStateSaved()) {
            qFSBaseFragment.setArguments(bundle);
        }
        if (qFSBaseFragment == this.f89891h || qFSBaseFragment.isVisible()) {
            return;
        }
        this.C.E.c();
        FragmentTransaction beginTransaction = getHostFragment().getChildFragmentManager().beginTransaction();
        if (qFSBaseFragment.isAdded()) {
            beginTransaction.show(qFSBaseFragment);
            beginTransaction.setMaxLifecycle(qFSBaseFragment, Lifecycle.State.RESUMED);
        } else {
            beginTransaction.add(R.id.f52532a2, qFSBaseFragment);
        }
        QFSBaseFragment qFSBaseFragment2 = this.f89891h;
        if (qFSBaseFragment2 != null) {
            beginTransaction.hide(qFSBaseFragment2);
            beginTransaction.setMaxLifecycle(this.f89891h, Lifecycle.State.STARTED);
        }
        beginTransaction.commitNowAllowingStateLoss();
        this.f89891h = qFSBaseFragment;
    }

    private void B9() {
        z9();
        if (this.f89888d == null) {
            QFSSearchPromptFragment qFSSearchPromptFragment = new QFSSearchPromptFragment();
            this.f89888d = qFSSearchPromptFragment;
            qFSSearchPromptFragment.getPartManager().setPartManagerObservers(getPartManager());
        }
        QFSBaseFragment qFSBaseFragment = this.f89891h;
        QFSSearchPromptFragment qFSSearchPromptFragment2 = this.f89888d;
        if (qFSBaseFragment == qFSSearchPromptFragment2) {
            return;
        }
        A9(qFSSearchPromptFragment2, null);
    }

    private void C9() {
        if (this.f89890f == null) {
            this.f89890f = new QFSSearchResultFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", this.f89892i.f438468b);
        A9(this.f89890f, bundle);
        this.f89890f.update();
    }

    private void D9() {
        if (this.f89889e == null) {
            this.f89889e = new QFSSearchSuggestFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", this.f89892i.f438468b);
        A9(this.f89889e, bundle);
        this.f89889e.update();
    }

    private void x9(@NonNull u60.b bVar) {
        this.f89892i = bVar;
        int i3 = bVar.f438467a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    C9();
                }
            } else {
                D9();
            }
        } else {
            B9();
        }
        this.f89893m = true;
        this.C.D = bVar.f438467a;
    }

    private void z9() {
        if (!this.f89893m) {
            p90.b.a().c(getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPagePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            if (str.equals("getPageState")) {
                return Integer.valueOf(this.f89892i.f438467a);
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("changePageState") && (obj instanceof u60.b)) {
            u60.b bVar = (u60.b) obj;
            x9(bVar);
            QFSSearchResultFragment qFSSearchResultFragment = this.f89890f;
            if (qFSSearchResultFragment != null) {
                qFSSearchResultFragment.rh(bVar);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        return this.f89891h.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void setEnvironment(IPartHost iPartHost, View view, PartManager partManager) {
        super.setEnvironment(iPartHost, view, partManager);
        QFSSearchViewModel qFSSearchViewModel = (QFSSearchViewModel) getViewModel(QFSSearchViewModel.class);
        this.C = qFSSearchViewModel;
        qFSSearchViewModel.O1(getContext());
    }
}
