package com.tencent.mobileqq.guild.channel.create.dialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSubChannelCreateMainDialogFragment extends BaseDialogFragment {
    public static QQGuildSubChannelCreateMainDialogFragment Eh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateMainDialogFragment qQGuildSubChannelCreateMainDialogFragment = new QQGuildSubChannelCreateMainDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildSubChannelCreateMainDialogFragment.setArguments(bundle);
        return qQGuildSubChannelCreateMainDialogFragment;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected Fragment wh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateMainFragment wh5 = QQGuildSubChannelCreateMainFragment.wh(createSubChannelInfo);
        wh5.ph(this);
        return wh5;
    }
}
