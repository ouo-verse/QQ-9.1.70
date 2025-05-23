package com.tencent.qqnt.aio.menu.processor;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.emotion.api.IRelatedEmotionConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/menu/processor/j;", "Lcom/tencent/qqnt/aio/menu/processor/a;", "", "chatType", "", "b", "c", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/ui/d;", "menuItem", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j implements a {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(int chatType) {
        if (chatType == 1 || chatType == 2 || chatType == 3 || chatType == 100) {
            return true;
        }
        return false;
    }

    private final boolean c() {
        return com.tencent.mobileqq.aio.helper.h.f189065a.c();
    }

    @Override // com.tencent.qqnt.aio.menu.processor.a
    public void a(@NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull com.tencent.qqnt.aio.menu.ui.d menuItem, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, menu, menuItem, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IRelatedEmotionConfigApi) companion.a(IRelatedEmotionConfigApi.class)).isSwitchOpenRelatedEmotion()) {
            boolean z16 = false;
            if (q.f351469a.a(bundle) != null && (!r3.booleanValue())) {
                z16 = true;
            }
            if (z16 && !c()) {
                AIOMsgItem d16 = menuItem.d();
                if (b(d16.getMsgRecord().chatType)) {
                    ((IReportControllerApi) companion.a(IReportControllerApi.class)).reportWith898(MobileQQ.sMobileQQ.peekAppRuntime(), "", String.valueOf(d16.getMsgRecord().peerUin), "0X800B114", "0X800B114", com.tencent.qqnt.emotion.utils.e.c(d16.getMsgRecord().chatType), 0, "", "", "", "");
                    menu.a(menuItem);
                }
            }
        }
    }
}
