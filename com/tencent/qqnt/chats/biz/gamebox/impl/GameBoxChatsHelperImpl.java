package com.tencent.qqnt.chats.biz.gamebox.impl;

import com.tencent.mobileqq.activity.recent.gamemsgbox.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.gamebox.IGameBoxChatsHelper;
import com.tencent.qqnt.chats.main.vm.datasource.filter.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/biz/gamebox/impl/GameBoxChatsHelperImpl;", "Lcom/tencent/qqnt/chats/biz/gamebox/IGameBoxChatsHelper;", "", "gameBoxScene", "", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "getLocalChatsFilter", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GameBoxChatsHelperImpl implements IGameBoxChatsHelper {
    static IPatchRedirector $redirector_;

    public GameBoxChatsHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.gamebox.IGameBoxChatsHelper
    @NotNull
    public List<a> getLocalChatsFilter(int gameBoxScene) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new k(gameBoxScene));
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this, gameBoxScene);
    }
}
