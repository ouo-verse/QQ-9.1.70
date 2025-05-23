package com.tencent.mobileqq.guild.media.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRaiseHandInvitationDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initView", "rh", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "logicParent", "sh", "onStart", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mRootView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "mOpenMicIv", "E", "Landroid/view/View;", "mAcceptView", UserInfo.SEX_FEMALE, "mRejectView", "G", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaRaiseHandInvitationDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mOpenMicIv;

    /* renamed from: E, reason: from kotlin metadata */
    private View mAcceptView;

    /* renamed from: F, reason: from kotlin metadata */
    private View mRejectView;

    /* renamed from: G, reason: from kotlin metadata */
    private View logicParent;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (r0.equals("MANAGER_AGREE_OPEN_MIC") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c8, code lost:
    
        r5 = getString(com.tencent.mobileqq.R.string.f14972132);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
    
        if (r0.equals("MANAGER_INVITE_OPEN_MIC_FREE_MODE") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
    
        if (r0.equals("INVITE") != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        final String str;
        String string;
        String string2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        String string3;
        ViewGroup viewGroup4 = this.mRootView;
        ViewGroup viewGroup5 = null;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup4 = null;
        }
        View findViewById = viewGroup4.findViewById(R.id.f166464zz0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.open_mic_icon)");
        ImageView imageView = (ImageView) findViewById;
        this.mOpenMicIv = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenMicIv");
            imageView = null;
        }
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/avChannel/guild_pic_invite.png", imageView, true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("OPEN_TYPE", "MANAGER_AGREE_OPEN_MIC");
        } else {
            str = null;
        }
        ViewGroup viewGroup6 = this.mRootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup6 = null;
        }
        View findViewById2 = viewGroup6.findViewById(R.id.f163839w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.accept)");
        this.mAcceptView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAcceptView");
            findViewById2 = null;
        }
        jt1.b.b(findViewById2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.guild.performance.report.aa.f230980i.B(true);
                if (!Intrinsics.areEqual(str, "MANAGER_AGREE_OPEN_MIC") && !Intrinsics.areEqual(str, "INVITE")) {
                    MediaChannelCore.INSTANCE.a().f().f(new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment$initView$1.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, Boolean bool) {
                            invoke(num.intValue(), str2, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3, @NotNull String retMsg, boolean z16) {
                            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                            if (i3 == 0 || !z16) {
                                return;
                            }
                            MediaChannelUtils.Q(MediaChannelUtils.f228046a, retMsg, null, 2, null);
                        }
                    });
                } else {
                    com.tencent.mobileqq.guild.media.core.j.a().T().p1(true ^ Intrinsics.areEqual(str, "MANAGER_AGREE_OPEN_MIC"), new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment$initView$1.2
                        public final void invoke(int i3, @NotNull String retMsg) {
                            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                            invoke(num.intValue(), str2);
                            return Unit.INSTANCE;
                        }
                    });
                }
                this.dismissAllowingStateLoss();
            }
        });
        ViewGroup viewGroup7 = this.mRootView;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup7 = null;
        }
        View findViewById3 = viewGroup7.findViewById(R.id.i6k);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.reject)");
        this.mRejectView = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRejectView");
            findViewById3 = null;
        }
        jt1.b.b(findViewById3, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.guild.performance.report.aa.f230980i.B(false);
                com.tencent.mobileqq.guild.media.core.j.a().T().q1(!Intrinsics.areEqual(str, "MANAGER_AGREE_OPEN_MIC"), new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment$initView$2.1
                    public final void invoke(int i3, @NotNull String retMsg) {
                        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                        invoke(num.intValue(), str2);
                        return Unit.INSTANCE;
                    }
                });
                this.dismissAllowingStateLoss();
            }
        });
        if (str != null) {
            switch (str.hashCode()) {
                case -2130369783:
                    break;
                case -306114464:
                    if (str.equals("MANAGER_INVITE_JOIN_QUEUE")) {
                        string = getString(R.string.f1495612m);
                        break;
                    }
                    break;
                case 14401805:
                    break;
                case 1443741175:
                    break;
            }
            Intrinsics.checkNotNullExpressionValue(string, "when (openType) {\n      \u2026media_open_mic)\n        }");
            if (!Intrinsics.areEqual(str, "MANAGER_INVITE_JOIN_QUEUE")) {
                string2 = getString(R.string.f1494912f);
            } else {
                string2 = getString(R.string.f1495112h);
            }
            Intrinsics.checkNotNullExpressionValue(string2, "when (openType) {\n      \u2026)\n            }\n        }");
            viewGroup = this.mRootView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            ((TextView) viewGroup.findViewById(R.id.xro)).setText(string2);
            viewGroup2 = this.mRootView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup2 = null;
            }
            ((TextView) viewGroup2.findViewById(R.id.s6s)).setText(string);
            viewGroup3 = this.mRootView;
            if (viewGroup3 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup5 = viewGroup3;
            }
            TextView textView = (TextView) viewGroup5.findViewById(R.id.f72583r9);
            if (Intrinsics.areEqual(str, "MANAGER_AGREE_OPEN_MIC")) {
                string3 = getString(R.string.f1495312j);
            } else {
                string3 = getString(R.string.f1495412k);
            }
            textView.setText(string3);
            rh();
        }
        string = getString(R.string.f14972132);
        Intrinsics.checkNotNullExpressionValue(string, "when (openType) {\n      \u2026media_open_mic)\n        }");
        if (!Intrinsics.areEqual(str, "MANAGER_INVITE_JOIN_QUEUE")) {
        }
        Intrinsics.checkNotNullExpressionValue(string2, "when (openType) {\n      \u2026)\n            }\n        }");
        viewGroup = this.mRootView;
        if (viewGroup == null) {
        }
        ((TextView) viewGroup.findViewById(R.id.xro)).setText(string2);
        viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
        }
        ((TextView) viewGroup2.findViewById(R.id.s6s)).setText(string);
        viewGroup3 = this.mRootView;
        if (viewGroup3 != null) {
        }
        TextView textView2 = (TextView) viewGroup5.findViewById(R.id.f72583r9);
        if (Intrinsics.areEqual(str, "MANAGER_AGREE_OPEN_MIC")) {
        }
        textView2.setText(string3);
        rh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(GuildMediaRaiseHandInvitationDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void rh() {
        View view = null;
        if (this.logicParent != null) {
            View view2 = this.mAcceptView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAcceptView");
                view2 = null;
            }
            View view3 = this.logicParent;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicParent");
                view3 = null;
            }
            VideoReport.setLogicParent(view2, view3);
            View view4 = this.mRejectView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRejectView");
                view4 = null;
            }
            View view5 = this.logicParent;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicParent");
                view5 = null;
            }
            VideoReport.setLogicParent(view4, view5);
        }
        View view6 = this.mAcceptView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAcceptView");
            view6 = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("btn_type", "accept");
        Unit unit = Unit.INSTANCE;
        ch.W0(view6, "em_sgrp_invite_popup_btn", hashMap);
        View view7 = this.mRejectView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRejectView");
        } else {
            view = view7;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("btn_type", "refuse");
        ch.W0(view, "em_sgrp_invite_popup_btn", hashMap2);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168128ez0, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        initView();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        u.b(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        u.b(true);
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        ((ViewGroup) viewGroup.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaRaiseHandInvitationDialogFragment.qh(GuildMediaRaiseHandInvitationDialogFragment.this, view);
            }
        });
    }

    public final void sh(@NotNull View logicParent) {
        Intrinsics.checkNotNullParameter(logicParent, "logicParent");
        this.logicParent = logicParent;
    }
}
