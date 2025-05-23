package com.tencent.mobileqq.guild.channel.create.dialog;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSubChannelCreateDialogFragment extends BaseDialogFragment {
    public static QQGuildSubChannelCreateDialogFragment Eh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateDialogFragment qQGuildSubChannelCreateDialogFragment = new QQGuildSubChannelCreateDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildSubChannelCreateDialogFragment.setArguments(bundle);
        return qQGuildSubChannelCreateDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    public int vh() {
        Context context;
        CreateSubChannelInfo createSubChannelInfo = this.H;
        if (createSubChannelInfo != null && createSubChannelInfo.f214824h == 5) {
            int dip2px = ViewUtils.dip2px(56.0f);
            int dip2px2 = ViewUtils.dip2px(926.0f);
            if (getContext() != null) {
                context = getContext();
            } else {
                context = BaseApplication.getContext();
            }
            if (context == null) {
                return dip2px;
            }
            int a16 = (int) (((bv.a(context) * dip2px) * 1.0f) / dip2px2);
            if (QLog.isColorLevel()) {
                QLog.i("Guild.c.create.QQGuildSubChannelCreateDialogFragment", 2, "backgroundHeight: " + a16);
            }
            return a16;
        }
        return super.vh();
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected Fragment wh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateFragment Kh = QQGuildSubChannelCreateFragment.Kh(createSubChannelInfo);
        Kh.ph(this);
        return Kh;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected boolean zh() {
        int i3;
        CreateSubChannelInfo createSubChannelInfo = this.H;
        if (createSubChannelInfo != null && (i3 = createSubChannelInfo.f214824h) != 7 && i3 != 5 && i3 != 2 && i3 != 1) {
            return true;
        }
        return false;
    }
}
