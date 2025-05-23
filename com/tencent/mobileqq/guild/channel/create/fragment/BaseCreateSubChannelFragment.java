package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseCreateSubChannelFragment extends QPublicBaseFragment {
    protected ViewGroup C;
    protected CreateSubChannelInfo D;
    public BaseDialogFragment E;

    public AppInterface getAppInterface() {
        if (getQBaseActivity().getAppRuntime() instanceof AppInterface) {
            return (AppInterface) getQBaseActivity().getAppRuntime();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public abstract int getContentLayoutId();

    protected abstract void init();

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        CreateSubChannelInfo createSubChannelInfo;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.e("Guild.c.create.BaseCreateSubChannelFragment", 2, "onCreate error: bundle is null");
            return;
        }
        this.D = (CreateSubChannelInfo) arguments.getParcelable("extra_key_subchannel_info");
        if (QLog.isColorLevel() && (createSubChannelInfo = this.D) != null) {
            QLog.i("Guild.c.create.BaseCreateSubChannelFragment", 2, String.format("onCreate, guildId=%s, from=%s, categoryId=%s, channelType=%s", createSubChannelInfo.f214821d, createSubChannelInfo.f214823f, Long.valueOf(createSubChannelInfo.f214822e), Integer.valueOf(this.D.f214824h)));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = (ViewGroup) layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.create.BaseCreateSubChannelFragment", 2, "onCreateView");
        }
        if (this.D == null) {
            QLog.w("Guild.c.create.BaseCreateSubChannelFragment", 2, "createSubChannelInfo is null");
            BaseDialogFragment baseDialogFragment = this.E;
            if (baseDialogFragment != null) {
                baseDialogFragment.rh();
            }
        } else {
            init();
        }
        ViewGroup viewGroup2 = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    public void ph(BaseDialogFragment baseDialogFragment) {
        this.E = baseDialogFragment;
    }
}
