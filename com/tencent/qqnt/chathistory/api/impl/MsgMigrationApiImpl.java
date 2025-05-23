package com.tencent.qqnt.chathistory.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J@\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/MsgMigrationApiImpl;", "Lcom/tencent/qqnt/chathistory/api/IMsgMigrationApi;", "()V", "jumpToChatHistorySettingFragment", "", "context", "Landroid/content/Context;", "reportBigT", "bigT", "", "entry", "", "result", "r1", "r2", "r3", "r4", "triggerToMigration", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class MsgMigrationApiImpl implements IMsgMigrationApi {
    static IPatchRedirector $redirector_;

    public MsgMigrationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IMsgMigrationApi
    public void jumpToChatHistorySettingFragment(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            PublicFragmentActivity.start(context, new Intent(), ChatHistorySettingFragment.class);
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IMsgMigrationApi
    public void reportBigT(@NotNull String bigT, int entry, int result, @NotNull String r16, @NotNull String r26, @NotNull String r36, @NotNull String r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bigT, Integer.valueOf(entry), Integer.valueOf(result), r16, r26, r36, r46);
            return;
        }
        Intrinsics.checkNotNullParameter(bigT, "bigT");
        Intrinsics.checkNotNullParameter(r16, "r1");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", bigT, bigT, entry, result, r16, r26, r36, r46);
    }

    @Override // com.tencent.qqnt.chathistory.api.IMsgMigrationApi
    public void triggerToMigration(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            NTMsgMigrationManager.INSTANCE.a().A1();
        }
    }
}
