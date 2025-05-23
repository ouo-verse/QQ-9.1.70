package com.tencent.timi.game.api.entrance.impl;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.entrance.impl.CheckDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/api/entrance/impl/CheckDialogFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "th", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "onFinish", "needStatusTrans", "needImmersive", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class CheckDialogFragment extends QPublicBaseFragment {
    private final void th() {
        if (getActivity() == null) {
            AegisLogger.INSTANCE.i("Audience|CheckDialogFragment", "showEditProfileDlg activity is null");
            return;
        }
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, activity.getString(R.string.f159811tb), activity.getString(R.string.f159791t_), activity.getString(R.string.f159831td), new DialogInterface.OnClickListener() { // from class: if4.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CheckDialogFragment.uh(FragmentActivity.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: if4.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CheckDialogFragment.vh(FragmentActivity.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setCancelable(false);
            createCustomDialog.setCanceledOnTouchOutside(false);
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(FragmentActivity this_run, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        dialogInterface.dismiss();
        this_run.startActivity(new Intent(this_run, (Class<?>) JumpActivity.class).setData(Uri.parse("mqqapi://profile/more_info_edit")));
        this_run.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(FragmentActivity this_run, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        dialogInterface.dismiss();
        this_run.finish();
    }

    private final void wh() {
        if (getActivity() == null) {
            AegisLogger.INSTANCE.i("Audience|CheckDialogFragment", "showEnableStudyModeDlg activity is null");
            return;
        }
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, activity.getString(R.string.f159821tc), activity.getString(R.string.f159801ta), activity.getString(R.string.f159841te), new DialogInterface.OnClickListener() { // from class: if4.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CheckDialogFragment.xh(FragmentActivity.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: if4.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CheckDialogFragment.yh(FragmentActivity.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setCancelable(false);
            createCustomDialog.setCanceledOnTouchOutside(false);
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(FragmentActivity this_run, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        dialogInterface.dismiss();
        this_run.startActivity(new Intent(this_run, (Class<?>) JumpActivity.class).setData(Uri.parse("mqqapi://vaslive/study_mode")));
        this_run.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(FragmentActivity this_run, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        dialogInterface.dismiss();
        this_run.finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, linearLayout);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("key_dlg_type"));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            th();
            return;
        }
        if (num != null && num.intValue() == 2) {
            wh();
            return;
        }
        AegisLogger.INSTANCE.i(QPublicBaseFragment.TAG, "do not support dlg type:" + num);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
