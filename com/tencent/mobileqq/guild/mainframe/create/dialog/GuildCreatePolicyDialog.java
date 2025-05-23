package com.tencent.mobileqq.guild.mainframe.create.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.bottomsheet.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.create.dialog.GuildCreatePolicyDialog;
import com.tencent.mobileqq.guild.mainframe.create.j;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tr1.c;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/dialog/GuildCreatePolicyDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "Ltr1/c;", "callback", "rh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mContentView", "E", "mButton", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mCloseBtn", "G", "Ltr1/c;", "mCallback", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCreatePolicyDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mContentView;

    /* renamed from: E, reason: from kotlin metadata */
    private View mButton;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mCloseBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private c mCallback;

    private final void initView() {
        TextView textView;
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.bjz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.dialog_content)");
        this.mContentView = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.uhk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.dialog_button)");
        this.mButton = findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.uhl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.dialog_close)");
        this.mCloseBtn = (ImageView) findViewById3;
        View view4 = this.mButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButton");
            view4 = null;
        }
        view4.setOnClickListener(new View.OnClickListener() { // from class: tr1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildCreatePolicyDialog.sh(GuildCreatePolicyDialog.this, view5);
            }
        });
        ImageView imageView = this.mCloseBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tr1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildCreatePolicyDialog.th(GuildCreatePolicyDialog.this, view5);
            }
        });
        TextView textView2 = this.mContentView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            textView = null;
        } else {
            textView = textView2;
        }
        j.g(textView, R.string.f142930kp, R.string.f142930kp, "https://qun.qq.com/guild/h5/static-pages/index.html?pageId=guildLicense", null, null, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildCreatePolicyDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            c cVar = this$0.mCallback;
            if (cVar != null) {
                cVar.a();
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(GuildCreatePolicyDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            c cVar = this$0.mCallback;
            if (cVar != null) {
                cVar.b();
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ek7, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026policy_dialog, container)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initView();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        a aVar = (a) dialog;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
    }

    public final void rh(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }
}
