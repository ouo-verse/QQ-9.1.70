package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNoticeNodeSettingDialog;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxNodeSettingBaseDialog;", "", "Ih", "Hh", "", "xh", "", "Qh", "Landroid/view/View;", "view", "isChecked", "Dh", "T", "Z", "isShowDeleteButton", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;Z)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InboxNoticeNodeSettingDialog extends InboxNodeSettingBaseDialog {

    /* renamed from: T, reason: from kotlin metadata */
    private final boolean isShowDeleteButton;

    public InboxNoticeNodeSettingDialog(@Nullable d dVar, boolean z16) {
        super(dVar);
        this.isShowDeleteButton = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(InboxNoticeNodeSettingDialog this$0, boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "setDirectMsgNotifyForGuild error result=" + i3 + ", errMsg=" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.InboxNoticeNodeSettingDialog", 1, (String) it.next(), null);
            }
            this$0.Kh(!z16);
            SecurityTipHelperKt.F(this$0.getContext(), i3, str, iGProSecurityResult, "", null, 32, null);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.C2C.InboxNoticeNodeSettingDialog", 2, "setDirectMsgNotifyForGuild success result=" + i3 + ", errMsg=" + str);
        }
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public void Dh(@NotNull View view, final boolean isChecked) {
        Intrinsics.checkNotNullParameter(view, "view");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setDirectMsgNotifyForGuild(az.c(getNodeUIData().f226296e, 0), !isChecked, new cd() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.l
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                InboxNoticeNodeSettingDialog.Sh(InboxNoticeNodeSettingDialog.this, isChecked, i3, str, iGProSecurityResult);
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
    public void Qh() {
        boolean z16 = false;
        if (InboxNoticeNodeRepository.u(az.c(getNodeUIData().f226296e, 0)).e() == 3) {
            z16 = true;
        }
        Nh(z16);
        Kh(getMIsCheck());
    }

    @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog
    public int xh() {
        return R.string.f143090l5;
    }
}
