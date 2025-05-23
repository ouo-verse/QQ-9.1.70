package com.tencent.mobileqq.guild.live.fragment.base.module.topbar;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.qphone.base.util.QLog;
import nq1.f;
import nq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class QQGuildLiveBaseTopBarFragment extends QQGuildLiveModuleBaseFragment implements f {
    protected View C;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        super.initView(view);
        this.C = view;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (QLog.isColorLevel()) {
            QLog.i("QQGuildLiveBaseTopBarFragment", 1, "onAttach.");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.h(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.C;
        if (view != null) {
            view.clearAnimation();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (QLog.isColorLevel()) {
            QLog.i("QQGuildLiveBaseTopBarFragment", 1, "onDetach.");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.h(null);
        }
    }
}
