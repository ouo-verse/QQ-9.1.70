package com.tencent.mobileqq.guild.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QQGuildTitleBarFragment extends QQGuildCustomTitleBarFragment {
    protected void Ch() {
        TextView textView = (TextView) this.N.findViewById(R.id.ivTitleBtnLeftButton);
        this.D = textView;
        textView.setPadding(0, 0, 0, 0);
        this.D.setGravity(19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
    }

    public AppInterface getAppInterface() {
        if (getQBaseActivity() != null && (getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
            return (AppInterface) getQBaseActivity().getAppRuntime();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void init(Bundle bundle) {
        super.init(bundle);
        Ch();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void setRightButtonEnable(boolean z16) {
        super.setRightButtonEnable(z16);
        setRightViewTextDisable(z16 ? 1 : 0);
    }
}
