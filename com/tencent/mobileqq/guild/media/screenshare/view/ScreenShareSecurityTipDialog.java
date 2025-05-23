package com.tencent.mobileqq.guild.media.screenshare.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.c;
import com.tencent.mobileqq.guild.util.co;
import com.tencent.mobileqq.guild.util.e;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00014B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/media/screenshare/view/ScreenShareSecurityTipDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initView", "vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onStart", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "th", "()Lkotlin/jvm/functions/Function0;", "onStartShare", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "D", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBehavior", "Landroid/os/CountDownTimer;", "E", "Landroid/os/CountDownTimer;", "mCountdownTimer", "Landroid/widget/CheckBox;", UserInfo.SEX_FEMALE, "Landroid/widget/CheckBox;", "mCheckBox", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "mStartShare", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mStartShareTv", "I", "Landroid/view/ViewGroup;", "mRootView", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ScreenShareSecurityTipDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> onStartShare;

    /* renamed from: D, reason: from kotlin metadata */
    private BottomSheetBehavior<FrameLayout> mBehavior;

    /* renamed from: E, reason: from kotlin metadata */
    private CountDownTimer mCountdownTimer;

    /* renamed from: F, reason: from kotlin metadata */
    private CheckBox mCheckBox;

    /* renamed from: G, reason: from kotlin metadata */
    private RelativeLayout mStartShare;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mStartShareTv;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/screenshare/view/ScreenShareSecurityTipDialog$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends CountDownTimer {
        b() {
            super(6000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            bw.L().encodeBool("has_show_guild_screen_share_tip", true);
            RelativeLayout relativeLayout = ScreenShareSecurityTipDialog.this.mStartShare;
            TextView textView = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStartShare");
                relativeLayout = null;
            }
            relativeLayout.setEnabled(true);
            TextView textView2 = ScreenShareSecurityTipDialog.this.mStartShareTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStartShareTv");
                textView2 = null;
            }
            textView2.setAlpha(1.0f);
            TextView textView3 = ScreenShareSecurityTipDialog.this.mStartShareTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStartShareTv");
            } else {
                textView = textView3;
            }
            textView.setText(ScreenShareSecurityTipDialog.this.getString(R.string.f155441hi));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            TextView textView = ScreenShareSecurityTipDialog.this.mStartShareTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStartShareTv");
                textView = null;
            }
            textView.setText(ScreenShareSecurityTipDialog.this.getString(R.string.f155441hi) + "(" + (millisUntilFinished / 1000) + ")");
        }
    }

    public ScreenShareSecurityTipDialog(@NotNull Function0<Unit> onStartShare) {
        Intrinsics.checkNotNullParameter(onStartShare, "onStartShare");
        this.onStartShare = onStartShare;
    }

    private final void initView() {
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.f88014vx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<T\u2026.id.start_screenshare_tv)");
        this.mStartShareTv = (TextView) findViewById;
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        View findViewById2 = viewGroup3.findViewById(R.id.f88004vw);
        RelativeLayout initView$lambda$0 = (RelativeLayout) findViewById2;
        Intrinsics.checkNotNullExpressionValue(initView$lambda$0, "initView$lambda$0");
        jt1.b.b(initView$lambda$0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog$initView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                CheckBox checkBox;
                Intrinsics.checkNotNullParameter(it, "it");
                checkBox = ScreenShareSecurityTipDialog.this.mCheckBox;
                if (checkBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
                    checkBox = null;
                }
                if (checkBox.isChecked()) {
                    bw.L().encodeBool("dont_show_guild_screen_share_tips", true);
                }
                ScreenShareSecurityTipDialog.this.th().invoke();
                ScreenShareSecurityTipDialog.this.dismissAllowingStateLoss();
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById<R\u2026)\n            }\n        }");
        this.mStartShare = initView$lambda$0;
        if (!bw.L().decodeBool("has_show_guild_screen_share_tip", false)) {
            vh();
        }
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup4 = null;
        }
        View findViewById3 = viewGroup4.findViewById(R.id.ytq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById<TextView>(R.id.lock_tv)");
        co.a((TextView) findViewById3, new Function1<e, Unit>() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull e buildSpannableString) {
                Intrinsics.checkNotNullParameter(buildSpannableString, "$this$buildSpannableString");
                e.a.a(buildSpannableString, "\u624b\u673a\u5c4f\u5e55\u5c06\u5b9e\u65f6\u540c\u6b65\u5230\u97f3\u89c6\u9891\u5b50\u9891\u9053\uff0c\u8bf7\u9632\u8303\u7f51\u7edc\u8bc8\u9a97\uff0c\u5207\u52ff\u8f6c\u8d26/\u652f\u4ed8\uff0c\u8c28\u614e\u4fdd\u62a4\u5bc6\u7801\u3001\u9a8c\u8bc1\u7801\u7b49\u91cd\u8981\u4fe1\u606f\u3002", null, 2, null);
                buildSpannableString.a("\u67e5\u770b\u6b3a\u8bc8\u6848\u4f8b", new Function1<c, Unit>() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog$initView$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull c addText) {
                        Intrinsics.checkNotNullParameter(addText, "$this$addText");
                        addText.setColor(R.color.brg);
                        addText.a(false, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog.initView.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                BaseApplication context = BaseApplication.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                                SecurityTipHelperKt.l(context, "https://act.qzone.qq.com/vip/meteor/blockly/p/6951x3def7");
                            }
                        });
                    }
                });
            }
        });
        ViewGroup viewGroup5 = this.mRootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup5 = null;
        }
        View findViewById4 = viewGroup5.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById<TextView>(R.id.cancel)");
        jt1.b.b(findViewById4, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.ScreenShareSecurityTipDialog$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ScreenShareSecurityTipDialog.this.dismissAllowingStateLoss();
            }
        });
        ViewGroup viewGroup6 = this.mRootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup6;
        }
        View findViewById5 = viewGroup2.findViewById(R.id.axa);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById<CheckBox>(R.id.checkbox)");
        this.mCheckBox = (CheckBox) findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(ScreenShareSecurityTipDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void vh() {
        RelativeLayout relativeLayout = this.mStartShare;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStartShare");
            relativeLayout = null;
        }
        relativeLayout.setEnabled(false);
        TextView textView2 = this.mStartShareTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStartShareTv");
        } else {
            textView = textView2;
        }
        textView.setAlpha(0.5f);
        b bVar = new b();
        this.mCountdownTimer = bVar;
        bVar.start();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        this.mBehavior = behavior;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f7q, container, false);
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
        CountDownTimer countDownTimer = this.mCountdownTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCountdownTimer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        ((ViewGroup) viewGroup.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        if (bw.L().decodeBool("has_show_guild_screen_share_tip", false)) {
            ViewGroup viewGroup3 = this.mRootView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup3;
            }
            viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.screenshare.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScreenShareSecurityTipDialog.uh(ScreenShareSecurityTipDialog.this, view);
                }
            });
        }
    }

    @NotNull
    public final Function0<Unit> th() {
        return this.onStartShare;
    }
}
