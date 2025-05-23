package com.tencent.qqnt.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.essencemsg.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msg/g;", "Lcom/tencent/qqnt/aio/msg/c;", "", "Lcom/tencent/qqnt/aio/msg/b;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g implements com.tencent.qqnt.aio.msg.c {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.msg.c
    @NotNull
    public List<com.tencent.qqnt.aio.msg.b> a() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.dataline.nt.f(), new com.tencent.mobileqq.troop.honor.processor.b(), new com.tencent.mobileqq.troop.troopmemberlevel.level.b(), new com.tencent.mobileqq.troop.troopgame.processor.d(), new r(), new com.tencent.mobileqq.troop.troopidentity.processor.c());
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
