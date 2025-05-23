package com.tencent.mobileqq.guild.channel.create.dialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppPreviewFragment;

/* loaded from: classes12.dex */
public class QQGuildAppPreviewDialogFragment extends BaseDialogFragment {
    public static QQGuildAppPreviewDialogFragment Eh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildAppPreviewDialogFragment qQGuildAppPreviewDialogFragment = new QQGuildAppPreviewDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildAppPreviewDialogFragment.setArguments(bundle);
        return qQGuildAppPreviewDialogFragment;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected Fragment wh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildAppPreviewFragment zh5 = QQGuildAppPreviewFragment.zh(createSubChannelInfo);
        zh5.ph(this);
        return zh5;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected boolean zh() {
        return true;
    }
}
