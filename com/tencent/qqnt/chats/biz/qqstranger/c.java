package com.tencent.qqnt.chats.biz.qqstranger;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00a2\u0006\u0004\b\t\u0010\nR'\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/qqstranger/c;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "tinyIdList", "<init>", "(Ljava/util/ArrayList;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements com.tencent.qqnt.chats.core.userintent.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> tinyIdList;

    public c(@NotNull ArrayList<String> tinyIdList) {
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tinyIdList);
        } else {
            this.tinyIdList = tinyIdList;
        }
    }

    @NotNull
    public final ArrayList<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tinyIdList;
    }
}
