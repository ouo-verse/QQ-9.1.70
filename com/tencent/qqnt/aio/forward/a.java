package com.tencent.qqnt.aio.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/forward/a;", "Lcom/tencent/qqnt/aio/forward/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/aio/data/AIOContact;", "contact", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.forward.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull AIOContact contact, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, contact, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgItem.getMsgRecord());
        if (parseArkMsgModelFromMsgRecord == null) {
            return false;
        }
        String d16 = parseArkMsgModelFromMsgRecord.d();
        String e16 = parseArkMsgModelFromMsgRecord.e();
        String a16 = parseArkMsgModelFromMsgRecord.a();
        String f16 = parseArkMsgModelFromMsgRecord.f();
        String c16 = parseArkMsgModelFromMsgRecord.c();
        String m3 = parseArkMsgModelFromMsgRecord.m();
        String g16 = parseArkMsgModelFromMsgRecord.g();
        float f17 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
        String n3 = parseArkMsgModelFromMsgRecord.n();
        Bundle a17 = QQCustomArkDialog.b.a(d16, e16, f16, c16, m3, f17, null, null);
        a17.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
        a17.putString("forward_ark_app_name", d16);
        a17.putString("forward_ark_app_view", e16);
        a17.putString("forward_ark_biz_src", f16);
        a17.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, a16);
        a17.putString("forward_ark_app_ver", c16);
        a17.putString("forward_ark_app_meta", m3);
        a17.putString("forward_ark_app_prompt", n3);
        a17.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, g16);
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtras(a17);
        return true;
    }
}
