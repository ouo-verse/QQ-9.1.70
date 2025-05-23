package com.tencent.mobileqq.guild.live.fragment.base.module.chatbar;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import nq1.a;
import nq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class QQGuildLiveBaseChatBarFragment extends QQGuildLiveModuleBaseFragment implements a {
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.c(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.c(null);
        }
    }
}
