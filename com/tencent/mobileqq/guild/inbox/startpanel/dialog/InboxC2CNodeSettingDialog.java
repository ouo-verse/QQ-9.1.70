package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxC2CNodeSettingDialog;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog;", "", "eventId", "", "isChecked", "", "Th", "Ih", "Hh", "", "xh", "Qh", "onResume", "Jh", "Landroid/view/View;", "view", "Dh", "Lh", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;)V", "T", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InboxC2CNodeSettingDialog extends InboxNodeSettingBaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InboxC2CNodeSettingDialog(@NotNull d callback) {
        super(callback);
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(InboxC2CNodeSettingDialog this$0, boolean z16, int i3, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "setDirectMsgNotifyType error result=" + i16 + ", errMsg=" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.InboxC2CNodeSettingDialog", 1, (String) it.next(), null);
            }
            this$0.Kh(!z16);
            SecurityTipHelperKt.F(this$0.getContext(), i16, str, iGProSecurityResult, "", null, 32, null);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.C2C.InboxC2CNodeSettingDialog", 2, "setDirectMsgNotifyType success result=" + i16 + ", errMsg=" + str);
        }
        DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
        String str3 = this$0.getNodeUIData().f226297f;
        Intrinsics.checkNotNullExpressionValue(str3, "nodeUIData.channelId");
        directMessageNodeRepository.O(str3, i3);
    }

    private final void Th(String eventId, boolean isChecked) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isChecked) {
            str = "1";
        } else {
            str = "2";
        }
        linkedHashMap.put("sgrp_private_switch", str);
        VideoReport.reportEvent(eventId, Ah(), linkedHashMap);
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Dh(@NotNull View view, final boolean isChecked) {
        final int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        if (isChecked) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setDirectMsgNotifyType(getNodeUIData().f226298h, i3, new cd() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.e
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                InboxC2CNodeSettingDialog.Sh(InboxC2CNodeSettingDialog.this, isChecked, i3, i16, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    /* renamed from: Hh */
    public boolean getIsShowDeleteButton() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public boolean Ih() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Jh(boolean isChecked) {
        Th("clck", isChecked);
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Lh() {
        VideoReport.setPageId(getRootView(), "pg_sgrp_mvp_private_list");
        DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
        String str = getNodeUIData().f226296e;
        Intrinsics.checkNotNullExpressionValue(str, "nodeUIData.inboxKey");
        String str2 = getNodeUIData().f226298h;
        Intrinsics.checkNotNullExpressionValue(str2, "nodeUIData.tinyId");
        Map<String, Object> H = directMessageNodeRepository.H(str, str2);
        Switch Ah = Ah();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(Ah, "em_sgrp_private_details_disturb_switch", clickPolicy, exposurePolicy);
        ch.Y0(yh(), "em_sgrp_private_delete", clickPolicy, exposurePolicy);
        VideoReport.setElementParams(Ah(), H);
        VideoReport.setElementParams(yh(), H);
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Qh() {
        String str = getNodeUIData().f226297f;
        Intrinsics.checkNotNullExpressionValue(str, "nodeUIData.channelId");
        DirectMessageNode C = DirectMessageNodeRepository.C(str);
        boolean z16 = false;
        if (C != null && C.getNotifyType() == 3) {
            z16 = true;
        }
        Nh(z16);
        Kh(getMIsCheck());
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Th("imp", getMIsCheck());
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public int xh() {
        return R.string.f143080l4;
    }
}
