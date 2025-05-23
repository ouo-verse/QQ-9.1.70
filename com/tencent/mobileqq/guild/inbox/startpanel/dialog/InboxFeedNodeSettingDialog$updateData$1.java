package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class InboxFeedNodeSettingDialog$updateData$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ InboxFeedNodeSettingDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InboxFeedNodeSettingDialog$updateData$1(InboxFeedNodeSettingDialog inboxFeedNodeSettingDialog) {
        super(1);
        this.this$0 = inboxFeedNodeSettingDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InboxFeedNodeSettingDialog this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this$0.Kh(z16);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final InboxFeedNodeSettingDialog inboxFeedNodeSettingDialog = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.g
            @Override // java.lang.Runnable
            public final void run() {
                InboxFeedNodeSettingDialog$updateData$1.b(InboxFeedNodeSettingDialog.this, i3);
            }
        });
    }
}
