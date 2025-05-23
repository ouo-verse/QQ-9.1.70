package com.tencent.qqnt.chats.main.func.littleear;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.chats.core.ui.third.g;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/a;", "Lcom/tencent/qqnt/chats/core/ui/third/g$a;", "", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "existList", "", "update", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements g.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.g.a
    public void update(@NotNull List<com.tencent.qqnt.chats.core.ui.third.f> existList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) existList);
            return;
        }
        Intrinsics.checkNotNullParameter(existList, "existList");
        QRouteApi api = QRoute.api(IMainChatEarManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMainChatEarManager::class.java)");
        IMainChatEarManager iMainChatEarManager = (IMainChatEarManager) api;
        boolean hasLittleEar = iMainChatEarManager.hasLittleEar();
        Iterator<com.tencent.qqnt.chats.core.ui.third.f> it = existList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().d() == ThirdViewEnum.LITTLE_EAR) {
                    if (!hasLittleEar) {
                        it.remove();
                    }
                    z16 = true;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (hasLittleEar && !z16) {
            com.tencent.qqnt.chats.core.ui.third.f buildLittleParam = iMainChatEarManager.buildLittleParam();
            if (existList.isEmpty()) {
                existList.add(buildLittleParam);
            } else {
                existList.add(0, buildLittleParam);
            }
        }
    }
}
