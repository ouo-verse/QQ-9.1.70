package com.tencent.mobileqq.guild.mainframe.standalone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import dq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildStandaloneDialogAttachFragment extends QPublicBaseFragment implements DialogInterface.OnDismissListener, Handler.Callback {
    private final WeakReferenceHandler C = new WeakReferenceHandler(Looper.getMainLooper(), this);

    private void ph(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static void qh(Context context, JumpGuildParam jumpGuildParam) {
        QLog.i("Guild.MFS.GuildStandaloneDialogAttachFragment", 1, "showInActivity 2nd jumpGuildParam=" + jumpGuildParam);
        rh(context, jumpGuildParam, true);
    }

    public static void rh(Context context, JumpGuildParam jumpGuildParam, boolean z16) {
        new g(jumpGuildParam).jump(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 10000 && getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (QQTheme.isNowThemeIsNight()) {
            ph(activity);
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            ph(activity);
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        showDialog();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.C.sendEmptyMessageDelayed(10000, 300L);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        if (getActivity() != null) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    private void showDialog() {
    }
}
