package com.tencent.mobileqq.guild.message.chatpie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.chatpie.GuildResendDialogFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/message/chatpie/GuildResendDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroid/view/View$OnClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnClickListener;", "getMResendClickListener", "()Landroid/view/View$OnClickListener;", "th", "(Landroid/view/View$OnClickListener;)V", "mResendClickListener", "", "D", "Ljava/lang/String;", "getMResendText", "()Ljava/lang/String;", "uh", "(Ljava/lang/String;)V", "mResendText", "Lvn0/l;", "E", "Lvn0/l;", "binding", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildResendDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener mResendClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mResendText = "";

    /* renamed from: E, reason: from kotlin metadata */
    private l binding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GuildResendDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildResendDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.mResendClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        l g16 = l.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewParent viewParent;
        super.onResume();
        View view = getView();
        View view2 = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view2 = (View) viewParent;
        }
        if (view2 != null) {
            view2.setBackgroundColor(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        l lVar = this.binding;
        l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            lVar = null;
        }
        lVar.f441973c.setOnClickListener(new View.OnClickListener() { // from class: wt1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildResendDialogFragment.rh(GuildResendDialogFragment.this, view2);
            }
        });
        l lVar3 = this.binding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            lVar3 = null;
        }
        TextView textView = lVar3.f441974d;
        textView.setText(this.mResendText);
        textView.setOnClickListener(new View.OnClickListener() { // from class: wt1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildResendDialogFragment.sh(GuildResendDialogFragment.this, view2);
            }
        });
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            l lVar4 = this.binding;
            if (lVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                lVar2 = lVar4;
            }
            lVar2.f441975e.setBackgroundResource(R.color.black);
        }
    }

    public final void th(@Nullable View.OnClickListener onClickListener) {
        this.mResendClickListener = onClickListener;
    }

    public final void uh(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mResendText = str;
    }
}
