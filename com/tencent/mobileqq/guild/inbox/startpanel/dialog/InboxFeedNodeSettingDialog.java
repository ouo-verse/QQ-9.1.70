package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxFeedNodeSettingDialog;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog;", "", "Ih", "Hh", "", "xh", "", "Qh", "Landroid/view/View;", "view", "isChecked", "Dh", "Lh", "", "T", "Ljava/lang/String;", "getDtPage", "()Ljava/lang/String;", "setDtPage", "(Ljava/lang/String;)V", "dtPage", "U", "Z", "isShowDeleteButton", "()Z", "setShowDeleteButton", "(Z)V", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InboxFeedNodeSettingDialog extends InboxNodeSettingBaseDialog {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String dtPage;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isShowDeleteButton;

    public /* synthetic */ InboxFeedNodeSettingDialog(d dVar, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, str, (i3 & 4) != 0 ? true : z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(InboxFeedNodeSettingDialog this$0, boolean z16, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            this$0.Kh(!z16);
            SecurityTipHelperKt.F(this$0.getContext(), i3, str, null, null, null, 56, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Dh(@NotNull View view, final boolean isChecked) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setFeedCommentsNotifySwitch(i3, new vh2.k() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.f
            @Override // vh2.k
            public final void onResult(int i16, String str, int i17) {
                InboxFeedNodeSettingDialog.Sh(InboxFeedNodeSettingDialog.this, isChecked, i16, str, i17);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    /* renamed from: Hh, reason: from getter */
    public boolean getIsShowDeleteButton() {
        return this.isShowDeleteButton;
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public boolean Ih() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Lh() {
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        VideoReport.setPageId(rootView, this.dtPage);
        Switch Ah = Ah();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(Ah, "em_sgrp_private_push_switch", clickPolicy, exposurePolicy);
        View Bh = Bh();
        if (Bh == null) {
            return;
        }
        ch.Y0(Bh, "em_sgrp_private_push_switch", clickPolicy, exposurePolicy);
        VideoReport.reportEvent("imp", Bh, null);
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Qh() {
        com.tencent.mobileqq.guild.message.directmessage.model.repositories.i.b(new InboxFeedNodeSettingDialog$updateData$1(this));
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public int xh() {
        return R.string.f143090l5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InboxFeedNodeSettingDialog(@Nullable d dVar, @NotNull String dtPage, boolean z16) {
        super(dVar);
        Intrinsics.checkNotNullParameter(dtPage, "dtPage");
        this.dtPage = dtPage;
        this.isShowDeleteButton = z16;
    }
}
