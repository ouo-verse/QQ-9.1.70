package com.tencent.qqnt.aio.forward;

import android.content.Intent;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IMsg2TextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/forward/g;", "Lcom/tencent/qqnt/aio/forward/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/aio/data/AIOContact;", "contact", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g implements c {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.forward.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull AIOContact contact, @NotNull Intent intent) {
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, contact, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("forward_type", -3);
        String msgForwardText = ((IMsg2TextUtil) QRoute.api(IMsg2TextUtil.class)).getMsgForwardText(msgItem);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, msgForwardText);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) msgForwardText, "]", 0, false, 6, (Object) null);
        String substring = msgForwardText.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, substring);
        return true;
    }
}
