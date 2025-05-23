package com.tencent.mobileqq.guild.media.dialog.modedialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.bottomsheet.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.dialog.modedialog.ModeChooseDialog;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eR\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/media/dialog/modedialog/ModeChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "vh", "rh", "th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", DKHippyEvent.EVENT_STOP, "logicParent", "uh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "", "D", "I", "mLastMode", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "E", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "mSwitchBtn", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "clickReportMap", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ModeChooseDialog extends BottomSheetDialogFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final MutableLiveData<Boolean> I = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private GuildSwitchButton mSwitchBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private View logicParent;

    /* renamed from: D, reason: from kotlin metadata */
    private int mLastMode = bw.k();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> clickReportMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/dialog/modedialog/ModeChooseDialog$a;", "", "Landroidx/lifecycle/MutableLiveData;", "", "modeChooseObserver", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.dialog.modedialog.ModeChooseDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MutableLiveData<Boolean> a() {
            return ModeChooseDialog.I;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/dialog/modedialog/ModeChooseDialog$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                ModeChooseDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    private final void rh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> behavior = ((a) dialog).getBehavior();
        behavior.setPeekHeight(0);
        behavior.setState(3);
        behavior.addBottomSheetCallback(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(ModeChooseDialog this$0, GuildSwitchButton guildSwitchButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            QQToast.makeText(this$0.getContext(), HardCodeUtil.qqStr(R.string.f1499013j), 0, 2).show();
            j.a().J().b(1);
            bw.L0(1);
            this$0.clickReportMap.put("sgrp_switch_type", "1");
        } else {
            QQToast.makeText(this$0.getContext(), HardCodeUtil.qqStr(R.string.f1498913i), 0, 2).show();
            j.a().J().b(0);
            bw.L0(0);
            this$0.clickReportMap.put("sgrp_switch_type", "2");
        }
        GuildSwitchButton guildSwitchButton2 = this$0.mSwitchBtn;
        if (guildSwitchButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
            guildSwitchButton2 = null;
        }
        VideoReport.reportEvent("clck", guildSwitchButton2, this$0.clickReportMap);
        I.postValue(Boolean.valueOf(z16));
    }

    private final void th() {
        GuildSwitchButton guildSwitchButton = this.mSwitchBtn;
        GuildSwitchButton guildSwitchButton2 = null;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
            guildSwitchButton = null;
        }
        if (guildSwitchButton.isChecked()) {
            this.clickReportMap.put("sgrp_switch_type", "1");
        } else {
            this.clickReportMap.put("sgrp_switch_type", "2");
        }
        GuildSwitchButton guildSwitchButton3 = this.mSwitchBtn;
        if (guildSwitchButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
        } else {
            guildSwitchButton2 = guildSwitchButton3;
        }
        ch.T0(guildSwitchButton2, "em_sgrp_audio_quality_speech", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, this.clickReportMap);
    }

    private final void vh() {
        GuildSwitchButton guildSwitchButton = null;
        if (this.mLastMode == 1 && MediaChannelCore.INSTANCE.a().y0().q() == 1) {
            GuildSwitchButton guildSwitchButton2 = this.mSwitchBtn;
            if (guildSwitchButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
            } else {
                guildSwitchButton = guildSwitchButton2;
            }
            guildSwitchButton.setCheckedOnly(true);
            return;
        }
        GuildSwitchButton guildSwitchButton3 = this.mSwitchBtn;
        if (guildSwitchButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
        } else {
            guildSwitchButton = guildSwitchButton3;
        }
        guildSwitchButton.setCheckedOnly(false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        a aVar = (a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.egd, container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_dialog, container, true)");
        this.mRootView = inflate;
        rh();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.vzc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_audio_mode_switch)");
        this.mSwitchBtn = (GuildSwitchButton) findViewById;
        vh();
        GuildSwitchButton guildSwitchButton = this.mSwitchBtn;
        View view2 = null;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
            guildSwitchButton = null;
        }
        guildSwitchButton.setOnCheckedChangeListener(new GuildSwitchButton.a() { // from class: xs1.a
            @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
            public final void onCheckedChanged(GuildSwitchButton guildSwitchButton2, boolean z16) {
                ModeChooseDialog.sh(ModeChooseDialog.this, guildSwitchButton2, z16);
            }
        });
        if (this.logicParent != null) {
            GuildSwitchButton guildSwitchButton2 = this.mSwitchBtn;
            if (guildSwitchButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwitchBtn");
                guildSwitchButton2 = null;
            }
            View view3 = this.logicParent;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logicParent");
            } else {
                view2 = view3;
            }
            VideoReport.setLogicParent(guildSwitchButton2, view2);
        } else {
            QLog.w("ModeChooseDialog", 1, "[onViewCreated] setLogicParent failed");
        }
        th();
    }

    public final void uh(@NotNull View logicParent) {
        Intrinsics.checkNotNullParameter(logicParent, "logicParent");
        this.logicParent = logicParent;
    }
}
